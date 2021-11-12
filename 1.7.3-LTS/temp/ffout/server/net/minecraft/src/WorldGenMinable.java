package net.minecraft.src;

import java.util.Random;

public class WorldGenMinable extends WorldGenerator {
    private int field_762_a;
    private int field_761_b;

    public WorldGenMinable(int var1, int var2) {
        this.field_762_a = var1;
        this.field_761_b = var2;
    }

    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        float var6 = var2.nextFloat() * 3.1415927F;
        double var7 = (double)((float)(var3 + 8) + MathHelper.func_585_a(var6) * (float)this.field_761_b / 8.0F);
        double var9 = (double)((float)(var3 + 8) - MathHelper.func_585_a(var6) * (float)this.field_761_b / 8.0F);
        double var11 = (double)((float)(var5 + 8) + MathHelper.func_582_b(var6) * (float)this.field_761_b / 8.0F);
        double var13 = (double)((float)(var5 + 8) - MathHelper.func_582_b(var6) * (float)this.field_761_b / 8.0F);
        double var15 = (double)(var4 + var2.nextInt(3) + 2);
        double var17 = (double)(var4 + var2.nextInt(3) + 2);

        for(int var19 = 0; var19 <= this.field_761_b; ++var19) {
            double var20 = var7 + (var9 - var7) * (double)var19 / (double)this.field_761_b;
            double var22 = var15 + (var17 - var15) * (double)var19 / (double)this.field_761_b;
            double var24 = var11 + (var13 - var11) * (double)var19 / (double)this.field_761_b;
            double var26 = var2.nextDouble() * (double)this.field_761_b / 16.0D;
            double var28 = (double)(MathHelper.func_585_a((float)var19 * 3.1415927F / (float)this.field_761_b) + 1.0F) * var26 + 1.0D;
            double var30 = (double)(MathHelper.func_585_a((float)var19 * 3.1415927F / (float)this.field_761_b) + 1.0F) * var26 + 1.0D;
            int var32 = MathHelper.func_584_b(var20 - var28 / 2.0D);
            int var33 = MathHelper.func_584_b(var22 - var30 / 2.0D);
            int var34 = MathHelper.func_584_b(var24 - var28 / 2.0D);
            int var35 = MathHelper.func_584_b(var20 + var28 / 2.0D);
            int var36 = MathHelper.func_584_b(var22 + var30 / 2.0D);
            int var37 = MathHelper.func_584_b(var24 + var28 / 2.0D);

            for(int var38 = var32; var38 <= var35; ++var38) {
                double var39 = ((double)var38 + 0.5D - var20) / (var28 / 2.0D);
                if (var39 * var39 < 1.0D) {
                    for(int var41 = var33; var41 <= var36; ++var41) {
                        double var42 = ((double)var41 + 0.5D - var22) / (var30 / 2.0D);
                        if (var39 * var39 + var42 * var42 < 1.0D) {
                            for(int var44 = var34; var44 <= var37; ++var44) {
                                double var45 = ((double)var44 + 0.5D - var24) / (var28 / 2.0D);
                                if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D && var1.func_444_a(var38, var41, var44) == Block.field_535_u.field_573_bc) {
                                    var1.func_462_a(var38, var41, var44, this.field_762_a);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
