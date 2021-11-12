package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneOre extends Block {
    private boolean field_468_a;

    public BlockRedstoneOre(int var1, int var2, boolean var3) {
        super(var1, var2, Material.field_1334_d);
        if (var3) {
            this.func_253_b(true);
        }

        this.field_468_a = var3;
    }

    public int func_4025_d() {
        return 30;
    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_320_h(var1, var2, var3, var4);
        super.func_233_b(var1, var2, var3, var4, var5);
    }

    public void func_254_a(World var1, int var2, int var3, int var4, Entity var5) {
        this.func_320_h(var1, var2, var3, var4);
        super.func_254_a(var1, var2, var3, var4, var5);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_320_h(var1, var2, var3, var4);
        return super.func_250_a(var1, var2, var3, var4, var5);
    }

    private void func_320_h(World var1, int var2, int var3, int var4) {
        this.func_319_i(var1, var2, var3, var4);
        if (this.field_376_bc == Block.field_433_aO.field_376_bc) {
            var1.func_690_d(var2, var3, var4, Block.field_432_aP.field_376_bc);
        }

    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_376_bc == Block.field_432_aP.field_376_bc) {
            var1.func_690_d(var2, var3, var4, Block.field_433_aO.field_376_bc);
        }

    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_309_aA.field_291_aS;
    }

    public int func_229_a(Random var1) {
        return 4 + var1.nextInt(2);
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_468_a) {
            this.func_319_i(var1, var2, var3, var4);
        }

    }

    private void func_319_i(World var1, int var2, int var3, int var4) {
        Random var5 = var1.field_1037_n;
        double var6 = 0.0625D;

        for(int var8 = 0; var8 < 6; ++var8) {
            double var9 = (double)((float)var2 + var5.nextFloat());
            double var11 = (double)((float)var3 + var5.nextFloat());
            double var13 = (double)((float)var4 + var5.nextFloat());
            if (var8 == 0 && !var1.func_601_g(var2, var3 + 1, var4)) {
                var11 = (double)(var3 + 1) + var6;
            }

            if (var8 == 1 && !var1.func_601_g(var2, var3 - 1, var4)) {
                var11 = (double)(var3 + 0) - var6;
            }

            if (var8 == 2 && !var1.func_601_g(var2, var3, var4 + 1)) {
                var13 = (double)(var4 + 1) + var6;
            }

            if (var8 == 3 && !var1.func_601_g(var2, var3, var4 - 1)) {
                var13 = (double)(var4 + 0) - var6;
            }

            if (var8 == 4 && !var1.func_601_g(var2 + 1, var3, var4)) {
                var9 = (double)(var2 + 1) + var6;
            }

            if (var8 == 5 && !var1.func_601_g(var2 - 1, var3, var4)) {
                var9 = (double)(var2 + 0) - var6;
            }

            if (var9 < (double)var2 || var9 > (double)(var2 + 1) || var11 < 0.0D || var11 > (double)(var3 + 1) || var13 < (double)var4 || var13 > (double)(var4 + 1)) {
                var1.func_694_a("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
