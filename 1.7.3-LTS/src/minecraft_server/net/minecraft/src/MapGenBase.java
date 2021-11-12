package net.minecraft.src;

import java.util.Random;

public class MapGenBase {
    protected int field_947_a = 8;
    protected Random rand = new Random();

    public void func_667_a(IChunkProvider var1, World var2, int var3, int var4, byte[] var5) {
        int var6 = this.field_947_a;
        this.rand.setSeed(var2.getRandomSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;

        for(int var11 = var3 - var6; var11 <= var3 + var6; ++var11) {
            for(int var12 = var4 - var6; var12 <= var4 + var6; ++var12) {
                this.rand.setSeed((long)var11 * var7 + (long)var12 * var9 ^ var2.getRandomSeed());
                this.func_666_a(var2, var11, var12, var3, var4, var5);
            }
        }

    }

    protected void func_666_a(World var1, int var2, int var3, int var4, int var5, byte[] var6) {
    }
}
