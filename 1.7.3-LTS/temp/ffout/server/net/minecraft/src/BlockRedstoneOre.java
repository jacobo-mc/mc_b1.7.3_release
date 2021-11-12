package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneOre extends Block {
    private boolean field_665_a;

    public BlockRedstoneOre(int var1, int var2, boolean var3) {
        super(var1, var2, Material.field_523_d);
        if (var3) {
            this.func_231_a(true);
        }

        this.field_665_a = var3;
    }

    public int func_4028_b() {
        return 30;
    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_321_g(var1, var2, var3, var4);
        super.func_235_b(var1, var2, var3, var4, var5);
    }

    public void func_249_b(World var1, int var2, int var3, int var4, Entity var5) {
        this.func_321_g(var1, var2, var3, var4);
        super.func_249_b(var1, var2, var3, var4, var5);
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_321_g(var1, var2, var3, var4);
        return super.func_246_a(var1, var2, var3, var4, var5);
    }

    private void func_321_g(World var1, int var2, int var3, int var4) {
        this.func_320_h(var1, var2, var3, var4);
        if (this.field_573_bc == Block.field_630_aO.field_573_bc) {
            var1.func_508_d(var2, var3, var4, Block.field_629_aP.field_573_bc);
        }

    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_573_bc == Block.field_629_aP.field_573_bc) {
            var1.func_508_d(var2, var3, var4, Block.field_630_aO.field_573_bc);
        }

    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_252_aA.field_234_aS;
    }

    public int func_244_a(Random var1) {
        return 4 + var1.nextInt(2);
    }

    private void func_320_h(World var1, int var2, int var3, int var4) {
        Random var5 = var1.field_803_m;
        double var6 = 0.0625D;

        for(int var8 = 0; var8 < 6; ++var8) {
            double var9 = (double)((float)var2 + var5.nextFloat());
            double var11 = (double)((float)var3 + var5.nextFloat());
            double var13 = (double)((float)var4 + var5.nextFloat());
            if (var8 == 0 && !var1.func_28095_p(var2, var3 + 1, var4)) {
                var11 = (double)(var3 + 1) + var6;
            }

            if (var8 == 1 && !var1.func_28095_p(var2, var3 - 1, var4)) {
                var11 = (double)(var3 + 0) - var6;
            }

            if (var8 == 2 && !var1.func_28095_p(var2, var3, var4 + 1)) {
                var13 = (double)(var4 + 1) + var6;
            }

            if (var8 == 3 && !var1.func_28095_p(var2, var3, var4 - 1)) {
                var13 = (double)(var4 + 0) - var6;
            }

            if (var8 == 4 && !var1.func_28095_p(var2 + 1, var3, var4)) {
                var9 = (double)(var2 + 1) + var6;
            }

            if (var8 == 5 && !var1.func_28095_p(var2 - 1, var3, var4)) {
                var9 = (double)(var2 + 0) - var6;
            }

            if (var9 < (double)var2 || var9 > (double)(var2 + 1) || var11 < 0.0D || var11 > (double)(var3 + 1) || var13 < (double)var4 || var13 > (double)(var4 + 1)) {
                var1.func_514_a("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
