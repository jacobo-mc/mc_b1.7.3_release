# Prism: Apple Silicon window resize/fullscreen crash

A Java fatal-error report with `SIGSEGV` in `libobjc.A.dylib` / `objc_msgSend` is a native crash. The reported configuration was ARM64 Zulu Java 8u504 and Prism's `2.9.4-nightly-20150209` LWJGL Java/native libraries. Resizing or entering fullscreen triggered it. The earlier XML resource-download error is a separate failure.

The maintained [Legacy Fabric LWJGL 2 fork](https://github.com/Legacy-Fabric/lwjgl#fixes) documents fixes for macOS resizing, main-thread dispatch, and HiDPI rendering, with macOS ARM64 support. [LegacyFix's Prism integration](https://github.com/betacraftuk/legacyfix/blob/2b582b1c80dbe0aab2c57098b6033e3a605908c4/common/src/main/java/uk/betacraft/legacyfix/util/launchers/PrismLauncherUtils.java) selects **2.9.4+legacyfabric.18**. This repository's helper configures those same publisher libraries without adding a Java agent or changing this client's auth/skin handling.

## Apply the native-library update

1. Quit Minecraft and **quit Prism completely**, so it cannot overwrite the component while it is being changed.
2. Update this repository to the latest `qol-client` branch.
3. From the repository folder, run:

   ```sh
   python3 tools/fix-prism-macos.py "$HOME/Library/Application Support/PrismLauncher/instances/b1.7.3"
   ```

   Use your actual instance folder if it has a different name. Select the folder containing `mmc-pack.json`, not its `minecraft` subfolder. Python 3 is required; check with `python3 --version`.
4. Reopen Prism and launch. Prism downloads the new LWJGL Java jars and the matching macOS native archive over HTTPS. Keep your current **ARM64 Java 8** installation; switching to Intel Java is unnecessary with this maintained fork.
5. Check the launch log's **Libraries** and **Native libraries** paths. All three LWJGL entries should contain `2.9.4+legacyfabric.18`. The maintained native archive is named `natives-osx.jar` and includes both macOS architectures; the helper maps Prism's `osx-arm64` platform to this archive. The old nightly paths must no longer be selected. Then test dragging the window larger/smaller and fullscreen on/off.

If the helper reports that no local component was found, open Prism → Edit instance → Version → select **LWJGL 2** → **Customize**. Quit Prism and rerun the command. If your Prism data directory is elsewhere, pass `--prism-root "/path/to/PrismLauncher"`.

The helper reads the existing instance override (or Prism's cached LWJGL component) and writes only `patches/org.lwjgl.json`. It preserves JInput, other libraries, and unrelated component settings. An existing override is backed up as `org.lwjgl.json.before-macos-fix-<timestamp>.bak`. Re-running it is a no-op when already configured. It does not modify worlds, options, the Minecraft jar mod, Java selection, shared metadata, or `mmc-pack.json`. It refuses to downgrade newer/custom Legacy Fabric builds. `--dry-run` previews the target without writing.

## Update the client patch as well

The updated client makes fullscreen a single LWJGL mode transition and synchronizes drawable dimensions immediately after window events, before rendering. Rebuild it with Java 8:

```sh
bash tools/build-client.sh
```

Replace the old jar mod in Prism with `build/beta-1.7.3-qol-patch.jar`. **A rebuilt gameplay jar alone does not update LWJGL natives**; apply the helper above as well.

## Undo or investigate a remaining crash

With Prism closed, restore the backed-up `patches/org.lwjgl.json`. If there was no previous override, remove just the new `patches/org.lwjgl.json` to return to Prism's original component. The old native-library problem may then return.

If resizing still crashes after the library paths show the maintained version, inspect the new `hs_err_pid*.log` in the instance's `minecraft` folder. Its native call stack can distinguish LWJGL from another native library; `objc_msgSend` alone does not identify an exact failing call. Include the **Native frames**, Java architecture, and LWJGL library paths when reporting it.

The helper is tested against temporary Prism layouts for preservation, backups, repeatability, and classifier selection. Client fullscreen/resize regressions are exercised under Linux/Xvfb. This cloud environment cannot run macOS or fetch the Legacy Fabric Maven artifacts, so publisher downloads and the M5 native behavior still require verification in Prism on your Mac.

Run the helper's configuration tests from the repository folder with:

```sh
python3 -m unittest discover -s tests -p 'test_prism_macos.py'
```
