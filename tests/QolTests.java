package net.minecraft.src;

import com.sun.net.httpserver.HttpServer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/** No external accounts, network services, OpenGL context, or test framework required. */
public final class QolTests {
    private static int checks;
    private static void check(boolean result, String message) {
        checks++;
        if (!result) throw new AssertionError(message);
    }

    public static void main(String[] args) throws Exception {
        settingsAndControls();
        windowDefaults();
        vertexColors();
        skinFormats();
        authentication();
        System.out.println("PASS: " + checks + " checks (settings, controls, colors, skins, auth proxy)");
    }

    private static void windowDefaults() {
        check(ClientWindow.useNativeWindow("Mac OS X", null), "Native window on macOS including Rosetta");
        check(ClientWindow.useNativeWindow("macOS", null), "Case-independent macOS detection");
        check(!ClientWindow.useNativeWindow("Linux", null), "Keep existing Linux window path");
        check(!ClientWindow.useNativeWindow("Windows 11", null), "Keep existing Windows window path");
        check(ClientWindow.useNativeWindow("Linux", "true"), "Force native window for integration testing");
        check(!ClientWindow.useNativeWindow("Mac OS X", "false"), "Allow explicit compatibility override");
    }

    private static void settingsAndControls() throws Exception {
        File directory = Files.createTempDirectory("beta-qol-options").toFile();
        try {
            GameSettings settings = new GameSettings(null, directory);
            check(settings.fov == 70, "Vanilla FOV default");
            settings.setOptionFloatValue(EnumOptions.FOV, 0);
            check(settings.fov == 30, "Minimum FOV");
            settings.setOptionFloatValue(EnumOptions.FOV, 1);
            check(settings.fov == 110, "Maximum FOV");
            settings.setOptionFloatValue(EnumOptions.FOV, Float.NaN);
            check(settings.fov == 70, "Malformed FOV fallback");
            settings.setOptionFloatValue(EnumOptions.FOV, .75F);
            settings.keyBindAttack.keyCode = 19;
            settings.keyBindZoom.keyCode = -97;
            settings.setOptionValue(EnumOptions.FULLBRIGHT, 1);
            check(settings.fullbright, "Fullbright toggle enabled");
            settings.saveOptions();
            GameSettings loaded = new GameSettings(null, directory);
            check(loaded.fov == 90, "FOV persisted");
            check(loaded.fullbright && loaded.keyBindFullbright.keyCode == 48, "Fullbright and default toggle key persisted");
            loaded.setOptionValue(EnumOptions.FULLBRIGHT, 1);
            check(!loaded.fullbright, "Fullbright can be disabled");
            check(loaded.keyBindAttack.keyCode == 19 && loaded.keyBindZoom.keyCode == -97, "Keyboard and mouse bindings persisted");
            check(loaded.keyBindZoom.getDisplayName().equals("Mouse 4"), "Mouse label");
            check(!new KeyBinding("Unbound", 0).matches(0), "Unbound cannot fire");
            loaded.cyclePerspective(); check(loaded.thirdPersonView == 1, "Rear view");
            loaded.cyclePerspective(); check(loaded.thirdPersonView == 2, "Front view");
            loaded.cyclePerspective(); check(loaded.thirdPersonView == 0, "First-person cycle");
            GuiControls gui = new GuiControls(null, loaded);
            gui.width = 427; gui.height = 240;
            gui.initGui();
            Set<Integer> seen = new HashSet<Integer>();
            boolean next;
            do {
                next = false;
                for (Object entry : gui.controlList) {
                    GuiButton button = (GuiButton)entry;
                    if (button.id < loaded.keyBindings.length) {
                        seen.add(button.id);
                        check(button.yPosition + 20 <= gui.height - 54, "Binding does not overlap navigation");
                    }
                    if (button.id == 202 && button.enabled) next = true;
                }
                if (next) gui.actionPerformed(new GuiButton(202, 0, 0, "Next"));
            } while (next);
            check(seen.size() == loaded.keyBindings.length, "Every binding is reachable at small GUI sizes");
            gui.actionPerformed(new GuiButton(0, 0, 0, "Bind"));
            gui.mouseClicked(0, 0, 3);
            check(loaded.keyBindings[0].keyCode == -97, "Mouse rebinding");
            gui.actionPerformed(new GuiButton(0, 0, 0, "Bind"));
            gui.keyTyped('\0', 1);
            check(loaded.keyBindings[0].keyCode == 0, "Escape unbinds");
            gui.actionPerformed(new GuiButton(203, 0, 0, "Reset All"));
            for (KeyBinding key : loaded.keyBindings) check(key.keyCode == key.defaultKeyCode, "Reset " + key.keyDescription);
            Files.write(new File(directory, "options.txt").toPath(), "fov:Infinity\nkey_key.forward:23\n".getBytes(StandardCharsets.UTF_8));
            loaded = new GameSettings(null, directory);
            check(loaded.fov == 110 && loaded.keyBindForward.keyCode == 23, "Clamp FOV and read old key option names");
        } finally {
            new File(directory, "options.txt").delete(); directory.delete();
        }
    }

    private static void vertexColors() {
        int[] vertices = new int[16];
        FloatBuffer output = FloatBuffer.allocate(8);
        for (ByteOrder order : new ByteOrder[]{ByteOrder.LITTLE_ENDIAN, ByteOrder.BIG_ENDIAN}) {
            vertices[5] = order == ByteOrder.LITTLE_ENDIAN ? 0x804020ff : 0xff204080;
            vertices[13] = 0;
            VertexColors.toFloats(vertices, 2, output, order);
            check(output.remaining() == 8, "Two complete RGBA vertices");
            check(output.get() == 1 && output.get() == 32 / 255F && output.get() == 64 / 255F && output.get() == 128 / 255F, "RGBA channels and alpha in " + order);
            check(output.get() == 0 && output.get() == 0 && output.get() == 0 && output.get() == 0, "Transparent black");
        }
    }

    private static String session(String textures) {
        return "{\"properties\":[{\"name\":\"textures\",\"value\":\"" + Base64.getEncoder().encodeToString(textures.getBytes(StandardCharsets.UTF_8)) + "\"}]}";
    }

    private static void skinFormats() throws Exception {
        String json = "{\"textures\":{\"SKIN\":{\"url\":\"http://textures.minecraft.net/texture/abcdef\",\"metadata\":{\"model\":\"slim\"}}}}";
        check("https://textures.minecraft.net/texture/abcdef".equals(SkinService.textureUrl(session(json))), "Modern texture URL resolution and HTTPS upgrade");
        check(SkinService.textureUrl(session("{\"textures\":{}}")) == null, "No skin falls back to Steve");
        check(SkinService.textureUrl(session(json.replace("textures.minecraft.net", "example.com"))) == null, "Reject third-party texture destinations");
        check(SkinService.profileUrl("bad/name") == null, "Reject invalid profile name");
        BufferedImage legacy = new BufferedImage(64, 32, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < 32; y++) for (int x = 0; x < 64; x++) legacy.setRGB(x, y, 0xff123456);
        BufferedImage parsed = new ImageBufferDownload().parseUserSkin(legacy);
        check((parsed.getRGB(40, 4) >>> 24) == 0, "Legacy opaque hat background cleared");
        check(parsed.getRGB(20, 20) == 0xff123456, "Legacy body retained");
        BufferedImage modern = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
        modern.setRGB(40, 4, 0xffabcdef);
        modern.setRGB(8, 4, 0x00123456);
        parsed = new ImageBufferDownload().parseUserSkin(modern);
        check(parsed.getWidth() == 64 && parsed.getHeight() == 32, "Modern skin adapted to Beta UV layout");
        check(parsed.getRGB(40, 4) == 0xffabcdef, "Modern opaque hat retained");
        check((parsed.getRGB(8, 4) >>> 24) == 255, "Base head made opaque");
        check(new ImageBufferDownload().parseUserSkin(null) == null, "Missing image fallback");
    }

    private static void authentication() throws Exception {
        HttpServer proxy = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        final AtomicReference<String> uri = new AtomicReference<String>();
        final AtomicReference<String> response = new AtomicReference<String>("OK\n");
        proxy.createContext("/", exchange -> {
            uri.set(exchange.getRequestURI().toString());
            byte[] body = response.get().getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, body.length);
            exchange.getResponseBody().write(body); exchange.close();
        });
        String host = System.getProperty("http.proxyHost"), port = System.getProperty("http.proxyPort");
        proxy.start();
        try {
            System.setProperty("http.proxyHost", "127.0.0.1");
            System.setProperty("http.proxyPort", "" + proxy.getAddress().getPort());
            check("OK".equals(LegacyAuth.joinServer("Tester", "dummy:+&=", "-abc")), "Authfix-compatible proxy success");
            check(uri.get().startsWith("http://www.minecraft.net/game/joinserver.jsp?"), "Proxy receives absolute legacy URL");
            check(URLDecoder.decode(uri.get(), "UTF-8").contains("sessionId=dummy:+&="), "Session encoded correctly");
            response.set("Bad session: dummy-secret\n");
            String failure = LegacyAuth.joinServer("Tester", "dummy", "abc");
            check(!failure.contains("dummy-secret") && failure.contains("Sign in again"), "Reject session without leaking proxy response");
        } finally {
            proxy.stop(0);
            if (host == null) System.clearProperty("http.proxyHost"); else System.setProperty("http.proxyHost", host);
            if (port == null) System.clearProperty("http.proxyPort"); else System.setProperty("http.proxyPort", port);
        }
    }
}
