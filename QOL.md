# Beta 1.7.3 quality-of-life client

This patch adds:

- **Options → FOV**: 30–110 degrees, default 70; saved in `options.txt`. Water and death effects still apply to the world. The arm and held item use a separate fixed 70-degree projection, so changing FOV or zoom never stretches them.
- **Options → Controls**: paged bindings for movement, attack/use/pick block, inventory, chat, drop, fog, all nine hotbar slots, perspective, zoom, HUD, debug, smooth camera, fullscreen, screenshots, and texture reload. Supports keyboard and mouse buttons, marks duplicate bindings red, and includes Reset All. Select a binding and press Escape to unbind it. Escape remains the pause/back key; mouse-wheel hotbar scrolling remains available.
- **F5**: first person → rear view → front view. Rebindable; camera collision checks remain enabled.
- **Third-person HUD**: the crosshair is hidden in both rear and front view and returns in first person.
- **Inventory hotbar shortcuts**: hover a slot and press its destination hotbar binding (1–9 by default) to exchange the stacks. This also works in chests, furnaces, dispensers, and crafting screens. Rebound keyboard and mouse hotbar bindings are respected; output slots and armour limits are handled without discarding displaced items.
- **Shift-click transfers**: move stacks between main inventory and hotbar, to/from chests and dispensers, and into furnace input/fuel slots. Shift-click armour to equip it, or a crafting result to craft repeatedly while ingredients and space remain. Existing compatible stacks fill before empty slots.
- **Fullbright**: press **B** (rebindable under Controls) or use **Options → Video Settings → Fullbright**. It is off by default and saved in `options.txt`. Fullbright raises rendering brightness for blocks/entities, rebuilds terrain when changed, follows dimension changes, and restores the original brightness table when disabled. Stored sky/block light levels and gameplay lighting remain unchanged.
- **Hold C**: 4× zoom with reduced mouse sensitivity. Releasing it, opening a menu, or losing game focus restores the normal view without changing the saved FOV or sensitivity.
- **macOS swapped-colour fix**: creates a native LWJGL window instead of embedding OpenGL in an AWT Canvas. The AWT window path is the known source of swapped red/blue or blue/purple colours on Apple Silicon (also documented by [LegacyFix's deAWT patch](https://github.com/betacraftuk/legacyfix#windowing)). The launcher host is hidden without stopping its applet; the native window handles closing, resizing, fullscreen, and mouse release. This activates automatically on macOS, including Intel Java under Rosetta. `-Dminecraft.nativeWindow=false` restores the old embedded window for compatibility; `true` enables the native path on other systems for testing. The earlier float vertex-colour workaround remains available via `-Dminecraft.macosFloatColors=true/false`, but does not by itself fix the AWT window colour problem.
- **Multiplayer session validation** through Modern Beta's Authfix-compatible HTTP proxy. The requested `-Dhttp.proxyHost=proxy.modernbeta.org -Dhttp.proxyPort=8080` arguments are supported. These are also the defaults specifically for the legacy join request, so installing the patch doesn't require globally proxying unrelated HTTP traffic. Requests have timeouts and URL-encode session parameters. An authenticated launcher session is still required for online-mode servers.
- **Public player skins**: resolves usernames via Mojang's profile/session APIs and downloads textures over HTTPS. This is independent of the auth proxy and sends no login credentials. Missing profiles or network failures keep the default skin. Modern 64×64 skins are adapted to Beta's 64×32 classic model; independent left limbs, body overlays, and true three-pixel slim arms are not implemented. Use a classic-model skin for accurate arm textures.

Inventory shortcuts send ordinary Beta window-click transactions instead of requiring a server modification or a newer protocol. They leave items already held by the mouse alone: finish placing the held stack before using a shortcut. Beta output slots cannot accept a remainder back, so crafting/furnace output transfers wait until the whole output stack fits. If a displaced hotbar item cannot legally fit in the source or another inventory slot, the swap is left unchanged.

## Build and install

Use a **Java 8 JDK** (not just a JRE):

```sh
export JAVA_HOME=/path/to/jdk8
./tools/build-client.sh
```

The output is `build/beta-1.7.3-qol-patch.jar`, a **jar-mod overlay** for a vanilla Beta 1.7.3 instance. In a launcher with jar-mod support (such as Prism Launcher), create a Beta 1.7.3 instance and add this file using the instance's Version → Add to Minecraft.jar action. It contains rebuilt classes, not game assets or native libraries; it is not a standalone executable jar. Other jar mods that replace the same classes may conflict.

For a MacBook Air with Apple Silicon, use a current **ARM64 Java 8** and the maintained **LWJGL 2.9.4+legacyfabric.18** Java libraries and matching macOS natives. Prism's old `2.9.4-nightly-20150209` natives can crash in Objective-C while resizing/fullscreen even when the gameplay patch is installed. Follow [the Prism macOS repair steps](PRISM-MACOS.md), including the supplied configuration helper. Intel Java/Rosetta is not required with the maintained fork. The repository's bundled Linux `.so` files cannot run on macOS; rebuilding the patch does not replace Prism's native libraries. Use the launcher's authenticated account login for multiplayer; a standalone development launch with the default `-` session is offline only.

If entering the proxy settings in your launcher, place these in **JVM arguments**, before the main class, not game arguments:

```text
-Dhttp.proxyHost=proxy.modernbeta.org -Dhttp.proxyPort=8080
```

Skins need HTTPS access to `api.mojang.com`, `sessionserver.mojang.com`, and `textures.minecraft.net`. Online validation needs access to `proxy.modernbeta.org:8080`. Legacy multiplayer servers must also have working server-side authentication support. The client patch cannot repair a server's dead session-check endpoint.

## Validation

```sh
./tools/test-client.sh
```

This rebuilds the client and runs regression checks for FOV persistence/clamping, old options compatibility, complete Controls pagination, key/mouse bindings and reset, perspective cycling, RGBA byte order, modern/legacy skin parsing, and authentication through a local mock HTTP proxy. The inventory suite exercises real containers for hotbar swaps (including equal-item stacks and differently damaged tools), partial/full destinations, armour limits, chests, dispensers, furnace routing, repeated crafting, and rebound GUI shortcuts. It also checks fullbright state restoration across dimensions. These checks do not need an account or external service.

Optional OpenGL integration checks require a display (or Xvfb) and native libraries matching the host/JVM:

```sh
export LWJGL_NATIVE_DIR=/path/to/lwjgl2/natives
./tools/test-render.sh
```

These draw and read back RGB test quads through both colour paths, render the Controls and Options screens, check zoom/menu/focus behavior, verify front/rear camera transforms at 18 yaw/pitch combinations, compare rendered hand pixel bounds at 30/70/110-degree world FOV with and without zoom, verify crosshair pixels in all three perspectives, and check fullbright pixels before/after toggling. A separate test forces the native window path with a real launcher-style AWT applet host and checks host hiding without shutdown, mouse release, resizing, and fullscreen restoration. A Controls screenshot is written under `build/render-check/screenshots/`.

Validated in Linux with Java 8 and a virtual OpenGL display, including a forced native-window startup from an AWT applet host. The Mac M5 driver and ARM64 runtime still require an on-device check. Live online authentication and skin downloads could not be exercised in the cloud environment because its network policy blocks those destinations; request handling and parsing were tested locally with dummy data. No Microsoft/Mojang session credentials were available for a live login.

Generated classes, jars, and integration-test artifacts stay under ignored `build/`. The tracked MCP `bin/`, `temp/`, source assets, and dependency jars remain untouched by these scripts.
