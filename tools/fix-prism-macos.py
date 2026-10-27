#!/usr/bin/env python3
"""Configure one closed Prism Beta 1.7.3 instance for maintained macOS LWJGL 2.

Does not download binaries, change Java, alter mmc-pack.json, or touch game data.
Prism downloads the publisher's libraries over HTTPS on the next launch.
"""
import argparse
import copy
from datetime import datetime, timezone
import json
import os
from pathlib import Path
import shutil
import tempfile

VERSION = "2.9.4+legacyfabric.18"
REPOSITORY = "https://maven.legacyfabric.net/"
ARTIFACTS = {"lwjgl", "lwjgl_util", "lwjgl-platform"}


def patched_component(original):
    if original.get("uid") != "org.lwjgl" or not isinstance(original.get("libraries"), list):
        raise ValueError("Expected a Prism org.lwjgl component with a libraries list")
    old_version = original.get("version", "")
    prefix = "2.9.4+legacyfabric."
    if isinstance(old_version, str) and old_version.startswith(prefix):
        try:
            newer = int(old_version[len(prefix):]) > 18
        except ValueError:
            newer = True
        if newer:
            raise ValueError("This component already uses a newer or custom Legacy Fabric build; preserving it")
    result = copy.deepcopy(original)
    libraries = []
    for library in result["libraries"]:
        if not isinstance(library, dict) or not isinstance(library.get("name"), str):
            raise ValueError("Invalid library entry; no configuration was changed")
        coordinate = library["name"].split(":")
        if coordinate[0] == "org.lwjgl.lwjgl":
            if len(coordinate) < 3 or coordinate[1] not in ARTIFACTS:
                raise ValueError("Unrecognized LWJGL library; refusing to mix old and new binaries")
            continue
        libraries.append(library)
    for artifact in ("lwjgl", "lwjgl_util", "lwjgl-platform"):
        library = {"name": "org.lwjgl.lwjgl:" + artifact + ":" + VERSION, "url": REPOSITORY}
        if artifact == "lwjgl-platform":
            # The publisher packages both macOS architectures in natives-osx.
            # This is the mapping used by LegacyFix's Prism support.
            library["natives"] = {"osx": "natives-osx", "osx-arm64": "natives-osx"}
            library["extract"] = {"exclude": ["META-INF/"]}
        libraries.append(library)
    result["libraries"] = libraries
    result["version"] = VERSION
    return result


def configure(instance, prism_root=None, dry_run=False):
    instance = Path(instance).expanduser().resolve()
    pack = json.loads((instance / "mmc-pack.json").read_text(encoding="utf-8"))
    components = pack.get("components", [])
    minecraft = [component for component in components if component.get("uid") == "net.minecraft"]
    lwjgl = [component for component in components if component.get("uid") == "org.lwjgl"]
    if len(minecraft) != 1 or minecraft[0].get("version") != "b1.7.3" or len(lwjgl) != 1:
        raise ValueError("Select a Beta b1.7.3 Prism instance containing the LWJGL 2 component")
    version = lwjgl[0].get("version", "")
    if not version or any(character in version for character in ("/", "\\", "\0")) or version in (".", ".."):
        raise ValueError("Invalid LWJGL component version")
    target = instance / "patches" / "org.lwjgl.json"
    root = Path(prism_root).expanduser().resolve() if prism_root else instance.parent.parent
    cached = root / "meta" / "org.lwjgl" / (version + ".json")
    if target.is_symlink() or target.parent.resolve() != instance / "patches":
        raise ValueError("The LWJGL override is a symbolic link; preserve it and customize the instance manually")
    source = target if target.exists() else cached
    if not source.is_file():
        raise ValueError("No local LWJGL component found. In Prism: Edit instance > Version > LWJGL 2 > Customize, then close Prism and retry. For a custom data directory, pass --prism-root.")
    original_bytes = source.read_bytes()
    original = json.loads(original_bytes.decode("utf-8"))
    updated = patched_component(original)
    if target.exists() and original == updated:
        print("Already configured for LWJGL " + VERSION)
        return target
    print("LWJGL component: " + str(source))
    print("Will use publisher libraries: " + VERSION + " from " + REPOSITORY)
    if dry_run:
        print("Dry run: no files changed. Destination: " + str(target))
        return target
    target.parent.mkdir(parents=True, exist_ok=True)
    expected_target = original_bytes if source == target else None
    current_target = target.read_bytes() if target.exists() else None
    if current_target != expected_target:
        raise ValueError("Prism changed the component while configuring it; close Prism and retry")
    if expected_target is not None:
        stamp = datetime.now(timezone.utc).strftime("%Y%m%dT%H%M%S%fZ")
        backup = target.with_name("org.lwjgl.json.before-macos-fix-" + stamp + ".bak")
        shutil.copy2(target, backup)
        print("Original component backup: " + str(backup))
    descriptor, temporary = tempfile.mkstemp(prefix=".org.lwjgl-", suffix=".json", dir=str(target.parent))
    try:
        with os.fdopen(descriptor, "w", encoding="utf-8") as output:
            json.dump(updated, output, indent=2)
            output.write("\n")
        # Preserve existing access permissions when replacing a customized component.
        if source == target:
            os.chmod(temporary, target.stat().st_mode & 0o777)
        os.replace(temporary, target)
    finally:
        if os.path.exists(temporary):
            os.unlink(temporary)
    print("Saved: " + str(target))
    print("Reopen Prism and launch. Verify the library paths contain " + VERSION + "; then test resizing and fullscreen.")
    return target


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("instance", type=Path, help="Instance folder containing mmc-pack.json, not its minecraft subfolder")
    parser.add_argument("--prism-root", type=Path, help="Optional custom Prism data directory containing meta/")
    parser.add_argument("--dry-run", action="store_true")
    args = parser.parse_args()
    try:
        configure(args.instance, args.prism_root, args.dry_run)
    except (OSError, ValueError, TypeError, KeyError) as failure:
        parser.exit(1, "Configuration stopped: " + str(failure) + "\n")


if __name__ == "__main__":
    main()
