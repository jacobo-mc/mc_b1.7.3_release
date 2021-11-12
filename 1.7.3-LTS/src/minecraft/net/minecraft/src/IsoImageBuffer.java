package net.minecraft.src;

import java.awt.image.BufferedImage;

public class IsoImageBuffer {
    public BufferedImage field_1348_a;
    public World worldObj;
    public int chunkX;
    public int chunkZ;
    public boolean field_1352_e = false;
    public boolean field_1351_f = false;
    public int field_1350_g = 0;
    public boolean field_1349_h = false;

    public IsoImageBuffer(World var1, int var2, int var3) {
        this.worldObj = var1;
        this.setChunkPosition(var2, var3);
    }

    public void setChunkPosition(int var1, int var2) {
        this.field_1352_e = false;
        this.chunkX = var1;
        this.chunkZ = var2;
        this.field_1350_g = 0;
        this.field_1349_h = false;
    }

    public void setWorldAndChunkPosition(World var1, int var2, int var3) {
        this.worldObj = var1;
        this.setChunkPosition(var2, var3);
    }
}
