package net.minecraft.src;

import java.io.InputStream;
import java.net.URL;

class MusInputStream extends InputStream {
    private int field_1516_c;
    private InputStream field_1515_d;
    byte[] field_1514_a;
    // $FF: synthetic field
    final CodecMus field_1513_b;

    public MusInputStream(CodecMus var1, URL var2, InputStream var3) {
        this.field_1513_b = var1;
        this.field_1514_a = new byte[1];
        this.field_1515_d = var3;
        String var4 = var2.getPath();
        var4 = var4.substring(var4.lastIndexOf("/") + 1);
        this.field_1516_c = var4.hashCode();
    }

    public int read() {
        int var1 = this.read(this.field_1514_a, 0, 1);
        return var1 < 0 ? var1 : this.field_1514_a[0];
    }

    public int read(byte[] var1, int var2, int var3) {
        var3 = this.field_1515_d.read(var1, var2, var3);

        for(int var4 = 0; var4 < var3; ++var4) {
            byte var5 = var1[var2 + var4] = (byte)(var1[var2 + var4] ^ this.field_1516_c >> 8);
            this.field_1516_c = this.field_1516_c * 498729871 + 85731 * var5;
        }

        return var3;
    }
}
