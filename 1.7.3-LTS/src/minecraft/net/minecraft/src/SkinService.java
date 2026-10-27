package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.imageio.ImageIO;

/** Resolves public skins without sending login credentials or using the HTTP auth proxy. */
final class SkinService {
    private static final String PROFILE = "https://api.mojang.com/users/profiles/minecraft/";

    static String profileUrl(String username) {
        return username != null && username.matches("[A-Za-z0-9_]{1,16}") ? PROFILE + username : null;
    }

    static boolean isProfileUrl(String url) {
        return url != null && url.startsWith(PROFILE);
    }

    static BufferedImage download(String profileUrl) throws Exception {
        String profile = readJson(profileUrl);
        if (profile == null) return null;
        String id = new J_JdomParser().parse(profile).getStringValue("id");
        if (!id.matches("[a-fA-F0-9]{32}")) return null;
        String session = readJson("https://sessionserver.mojang.com/session/minecraft/profile/" + id);
        if (session == null) return null;
        String textureUrl = textureUrl(session);
        if (textureUrl == null) return null;
        HttpURLConnection connection = connect(textureUrl);
        try {
            if (connection.getResponseCode() != 200) return null;
            try (InputStream stream = connection.getInputStream()) {
                BufferedImage image = ImageIO.read(stream);
                if (image == null || image.getWidth() != 64 || (image.getHeight() != 32 && image.getHeight() != 64)) return null;
                return image;
            }
        } finally { connection.disconnect(); }
    }

    static String textureUrl(String session) throws Exception {
        for (Object value : new J_JdomParser().parse(session).getArrayNode("properties")) {
            J_JsonNode property = (J_JsonNode)value;
            if (!"textures".equals(property.getStringValue("name"))) continue;
            String decoded = new String(Base64.getDecoder().decode(property.getStringValue("value")), StandardCharsets.UTF_8);
            J_JsonNode textures = (J_JsonNode)new J_JdomParser().parse(decoded).getFields().get(J_JsonNodeFactories.aJsonString("textures"));
            if (textures == null) return null;
            J_JsonNode skin = (J_JsonNode)textures.getFields().get(J_JsonNodeFactories.aJsonString("SKIN"));
            if (skin == null) return null;
            String url = skin.getStringValue("url");
            // Only accept Mojang's texture CDN and always use verified HTTPS.
            if (!url.matches("https?://textures\\.minecraft\\.net/texture/[a-fA-F0-9]+")) return null;
            return url.replaceFirst("^http:", "https:");
        }
        return null;
    }

    private static HttpURLConnection connect(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setInstanceFollowRedirects(false);
        return connection;
    }

    private static String readJson(String url) throws IOException {
        HttpURLConnection connection = connect(url);
        try {
            if (connection.getResponseCode() != 200) return null;
            try (InputStream stream = connection.getInputStream()) {
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int count;
                while ((count = stream.read(buffer)) != -1) {
                    if (bytes.size() + count > 1024 * 1024) throw new IOException("Profile response too large");
                    bytes.write(buffer, 0, count);
                }
                return new String(bytes.toByteArray(), StandardCharsets.UTF_8);
            }
        } finally { connection.disconnect(); }
    }
}
