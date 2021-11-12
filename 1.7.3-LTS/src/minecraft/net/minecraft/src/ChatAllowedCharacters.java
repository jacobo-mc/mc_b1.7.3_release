package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {
    public static final String allowedCharacters = getAllowedCharacters();
    public static final char[] allowedCharactersArray = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '"', ':'};

    private static String getAllowedCharacters() {
        String var0 = "";

        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                if (!var2.startsWith("#")) {
                    var0 = var0 + var2;
                }
            }

            var1.close();
        } catch (Exception var3) {
        }

        return var0;
    }
}
