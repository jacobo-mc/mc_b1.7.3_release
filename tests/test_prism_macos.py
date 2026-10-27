"""Tests configure only temporary Prism instances and never download libraries."""
import copy
import importlib.util
import json
from pathlib import Path
import tempfile
import unittest

SCRIPT = Path(__file__).resolve().parents[1] / "tools" / "fix-prism-macos.py"
spec = importlib.util.spec_from_file_location("prism_macos", SCRIPT)
fix = importlib.util.module_from_spec(spec)
spec.loader.exec_module(fix)


class PrismMacTests(unittest.TestCase):
    def setUp(self):
        self.scratch = tempfile.TemporaryDirectory(prefix="Prism Mac test ")
        self.addCleanup(self.scratch.cleanup)
        self.root = Path(self.scratch.name)
        self.instance = self.root / "instances" / "b1.7.3"
        self.instance.mkdir(parents=True)
        self.pack = self.instance / "mmc-pack.json"
        self.pack.write_text(json.dumps({"formatVersion": 1, "components": [
            {"uid": "net.minecraft", "version": "b1.7.3"},
            {"uid": "org.lwjgl", "version": "2.9.4-nightly-20150209"},
            {"uid": "custom.jarmod.qol", "version": "1"},
        ]}))
        self.patch = self.instance / "patches" / "org.lwjgl.json"
        self.cached = self.root / "meta" / "org.lwjgl" / "2.9.4-nightly-20150209.json"
        self.cached.parent.mkdir(parents=True)
        self.component = {
            "formatVersion": 1, "uid": "org.lwjgl", "name": "LWJGL 2",
            "version": "2.9.4-nightly-20150209", "order": -1,
            "+jvmArgs": ["-Dcustom.example=true"],
            "libraries": [
                {"name": "net.java.jinput:jinput:2.0.5", "url": "https://example.com/", "downloads": {"artifact": {"sha1": "kept"}}},
                {"name": "net.java.jinput:jinput-platform:2.0.5", "natives": {"osx-arm64": "natives-osx-arm64"}},
                {"name": "org.lwjgl.lwjgl:lwjgl:2.9.4-nightly-20150209", "downloads": {"artifact": {"sha1": "old-lwjgl"}}},
                {"name": "org.lwjgl.lwjgl:lwjgl_util:2.9.4-nightly-20150209"},
                {"name": "org.lwjgl.lwjgl:lwjgl-platform:2.9.4-nightly-20150209", "natives": {"osx-arm64": "natives-osx-arm64"}},
            ],
        }
        self.cached.write_text(json.dumps(self.component, indent=2) + "\n")

    def test_replaces_java_and_native_libraries_together(self):
        updated = fix.patched_component(self.component)
        lwjgl = [lib for lib in updated["libraries"] if lib["name"].startswith("org.lwjgl.lwjgl:")]
        self.assertEqual(len(lwjgl), 3)
        self.assertTrue(all(lib["name"].endswith(":2.9.4+legacyfabric.18") for lib in lwjgl))
        self.assertTrue(all(lib["url"] == "https://maven.legacyfabric.net/" for lib in lwjgl))
        native = next(lib for lib in lwjgl if ":lwjgl-platform:" in lib["name"])
        self.assertEqual(native["natives"]["osx-arm64"], "natives-osx")
        self.assertEqual(native["natives"]["osx"], "natives-osx")
        self.assertEqual(native["extract"], {"exclude": ["META-INF/"]})

    def test_preserves_non_lwjgl_libraries_hashes_and_component_settings(self):
        original = copy.deepcopy(self.component)
        updated = fix.patched_component(self.component)
        self.assertEqual(self.component, original)
        self.assertEqual(updated["libraries"][:2], self.component["libraries"][:2])
        self.assertEqual(updated["+jvmArgs"], self.component["+jvmArgs"])
        self.assertEqual(updated["order"], -1)

    def test_uses_cached_component_without_modifying_cache_or_pack(self):
        cache_bytes, pack_bytes = self.cached.read_bytes(), self.pack.read_bytes()
        target = fix.configure(self.instance)
        self.assertEqual(target, self.patch)
        self.assertEqual(json.loads(target.read_text())["version"], fix.VERSION)
        self.assertEqual(self.cached.read_bytes(), cache_bytes)
        self.assertEqual(self.pack.read_bytes(), pack_bytes)

    def test_preserves_existing_customization_and_backs_up_exact_bytes(self):
        self.patch.parent.mkdir()
        custom = copy.deepcopy(self.component)
        custom["libraries"].append({"name": "example:custom:1"})
        self.patch.write_text(json.dumps(custom))
        original = self.patch.read_bytes()
        fix.configure(self.instance)
        backup = list(self.patch.parent.glob("*.bak"))
        self.assertEqual(len(backup), 1)
        self.assertEqual(backup[0].read_bytes(), original)
        self.assertIn({"name": "example:custom:1"}, json.loads(self.patch.read_text())["libraries"])

    def test_repeat_run_is_a_noop(self):
        fix.configure(self.instance)
        content, modified = self.patch.read_bytes(), self.patch.stat().st_mtime_ns
        fix.configure(self.instance)
        self.assertEqual(self.patch.read_bytes(), content)
        self.assertEqual(self.patch.stat().st_mtime_ns, modified)
        self.assertEqual(list(self.patch.parent.glob("*.bak")), [])

    def test_dry_run_does_not_create_patch_directory(self):
        fix.configure(self.instance, dry_run=True)
        self.assertFalse(self.patch.parent.exists())

    def test_wrong_game_is_not_modified(self):
        pack = json.loads(self.pack.read_text()); pack["components"][0]["version"] = "1.21.1"
        self.pack.write_text(json.dumps(pack))
        with self.assertRaisesRegex(ValueError, "Beta b1.7.3"):
            fix.configure(self.instance)
        self.assertFalse(self.patch.parent.exists())

    def test_missing_cache_has_actionable_customize_instruction(self):
        self.cached.unlink()
        with self.assertRaisesRegex(ValueError, "Customize"):
            fix.configure(self.instance)
        self.assertFalse(self.patch.parent.exists())

    def test_unrecognized_lwjgl_artifact_is_not_silently_mixed(self):
        self.component["libraries"].append({"name": "org.lwjgl.lwjgl:unrecognized:1"})
        self.cached.write_text(json.dumps(self.component))
        with self.assertRaisesRegex(ValueError, "Unrecognized LWJGL"):
            fix.configure(self.instance)
        self.assertFalse(self.patch.parent.exists())

    def test_malformed_component_is_not_replaced(self):
        self.patch.parent.mkdir(); self.patch.write_text("{broken")
        with self.assertRaises(ValueError):
            fix.configure(self.instance)
        self.assertEqual(self.patch.read_text(), "{broken")

    def test_newer_library_version_is_not_downgraded(self):
        self.component["version"] = "2.9.4+legacyfabric.19"
        with self.assertRaisesRegex(ValueError, "newer"):
            fix.patched_component(self.component)

    def test_symlink_override_is_preserved(self):
        self.patch.parent.mkdir()
        self.patch.symlink_to(self.cached)
        original = self.cached.read_bytes()
        with self.assertRaisesRegex(ValueError, "symbolic link"):
            fix.configure(self.instance)
        self.assertTrue(self.patch.is_symlink())
        self.assertEqual(self.cached.read_bytes(), original)

    def test_custom_prism_data_directory(self):
        instance = self.root / "somewhere else" / "instance"
        instance.mkdir(parents=True)
        (instance / "mmc-pack.json").write_bytes(self.pack.read_bytes())
        target = fix.configure(instance, prism_root=self.root)
        self.assertTrue(target.is_file())


if __name__ == "__main__":
    unittest.main()
