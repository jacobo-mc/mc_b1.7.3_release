package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;

/** Legacy session validation through Modern Beta's Authfix-compatible proxy. */
final class LegacyAuth {
    static String joinServer(String username, String sessionId, String serverId) throws IOException {
        String host = System.getProperty("http.proxyHost", "proxy.modernbeta.org");
        int port;
        try { port = Integer.parseInt(System.getProperty("http.proxyPort", "8080")); }
        catch (NumberFormatException invalid) { throw new IOException("Invalid auth proxy port"); }
        if (port < 1 || port > 65535) throw new IOException("Invalid auth proxy port");
        URL url = new URL(joinUrl(username, sessionId, serverId));
        HttpURLConnection connection = (HttpURLConnection)url.openConnection(
                new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port)));
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        connection.setInstanceFollowRedirects(false);
        try {
            if (connection.getResponseCode() != 200) throw new IOException("Auth proxy returned HTTP " + connection.getResponseCode());
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
                String response = reader.readLine();
                return "OK".equalsIgnoreCase(response) ? "OK" : "Session rejected. Sign in again using your launcher.";
            }
        } finally { connection.disconnect(); }
    }

    static String joinUrl(String username, String sessionId, String serverId) throws IOException {
        return "http://www.minecraft.net/game/joinserver.jsp?user=" + URLEncoder.encode(username, "UTF-8")
                + "&sessionId=" + URLEncoder.encode(sessionId, "UTF-8") + "&serverId=" + URLEncoder.encode(serverId, "UTF-8");
    }
}
