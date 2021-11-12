package net.minecraft.src;

public class NibbleArray {
    public final byte[] field_844_a;

    public NibbleArray(int var1) {
        this.field_844_a = new byte[var1 >> 1];
    }

    public NibbleArray(byte[] var1) {
        this.field_844_a = var1;
    }

    public int func_562_a(int var1, int var2, int var3) {
        int var4 = var1 << 11 | var3 << 7 | var2;
        int var5 = var4 >> 1;
        int var6 = var4 & 1;
        return var6 == 0 ? this.field_844_a[var5] & 15 : this.field_844_a[var5] >> 4 & 15;
    }

    public void func_561_a(int var1, int var2, int var3, int var4) {
        int var5 = var1 << 11 | var3 << 7 | var2;
        int var6 = var5 >> 1;
        int var7 = var5 & 1;
        if (var7 == 0) {
            this.field_844_a[var6] = (byte)(this.field_844_a[var6] & 240 | var4 & 15);
        } else {
            this.field_844_a[var6] = (byte)(this.field_844_a[var6] & 15 | (var4 & 15) << 4);
        }

    }

    public boolean func_560_a() {
        return this.field_844_a != null;
    }
}
