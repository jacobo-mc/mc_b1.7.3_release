package net.minecraft.src;

public class ChunkBlockMap {
    private static byte[] convTable = new byte[256];

    public static void removeUnknownBlockIDs(byte[] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
            var0[var1] = convTable[var0[var1] & 255];
        }

    }

    static {
        try {
            for(int var0 = 0; var0 < 256; ++var0) {
                byte var1 = (byte)var0;
                if (var1 != 0 && Block.blocksList[var1 & 255] == null) {
                    var1 = 0;
                }

                convTable[var0] = var1;
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
