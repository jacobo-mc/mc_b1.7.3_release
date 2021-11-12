package net.minecraft.src;

import java.awt.image.BufferedImage;

public class IsoImageBuffer {
    public BufferedImage field_1348_a;
    public World field_1347_b;
    public int field_1354_c;
    public int field_1353_d;
    public boolean field_1352_e = false;
    public boolean field_1351_f = false;
    public int field_1350_g = 0;
    public boolean field_1349_h = false;

    public IsoImageBuffer(World var1, int var2, int var3) {
        this.field_1347_b = var1;
        this.func_889_a(var2, var3);
    }

    public void func_889_a(int var1, int var2) {
        this.field_1352_e = false;
        this.field_1354_c = var1;
        this.field_1353_d = var2;
        this.field_1350_g = 0;
        this.field_1349_h = false;
    }

    public void func_888_a(World var1, int var2, int var3) {
        this.field_1347_b = var1;
        this.func_889_a(var2, var3);
    }
}
