package net.minecraft.src;

import java.util.Random;

public class WorldGenClay extends WorldGenerator {
    private int field_867_a;
    private int field_866_b;

    public WorldGenClay(int var1) {
        this.field_867_a = Block.field_424_aX.field_376_bc;
        this.field_866_b = var1;
    }

    public boolean func_516_a(World var1, Random var2, int var3, int var4, int var5) {
        if (var1.func_599_f(var3, var4, var5) != Material.field_1332_f) {
            return false;
        } else {
            float var6 = var2.nextFloat() * 3.1415927F;
            double var7 = (double)((float)(var3 + 8) + MathHelper.func_1106_a(var6) * (float)this.field_866_b / 8.0F);
            double var9 = (double)((float)(var3 + 8) - MathHelper.func_1106_a(var6) * (float)this.field_866_b / 8.0F);
            double var11 = (double)((float)(var5 + 8) + MathHelper.func_1114_b(var6) * (float)this.field_866_b / 8.0F);
            double var13 = (double)((float)(var5 + 8) - MathHelper.func_1114_b(var6) * (float)this.field_866_b / 8.0F);
            double var15 = (double)(var4 + var2.nextInt(3) + 2);
            double var17 = (double)(var4 + var2.nextInt(3) + 2);

            for(int var19 = 0; var19 <= this.field_866_b; ++var19) {
                double var20 = var7 + (var9 - var7) * (double)var19 / (double)this.field_866_b;
                double var22 = var15 + (var17 - var15) * (double)var19 / (double)this.field_866_b;
                double var24 = var11 + (var13 - var11) * (double)var19 / (double)this.field_866_b;
                double var26 = var2.nextDouble() * (double)this.field_866_b / 16.0D;
                double var28 = (double)(MathHelper.func_1106_a((float)var19 * 3.1415927F / (float)this.field_866_b) + 1.0F) * var26 + 1.0D;
                double var30 = (double)(MathHelper.func_1106_a((float)var19 * 3.1415927F / (float)this.field_866_b) + 1.0F) * var26 + 1.0D;
                int var32 = MathHelper.func_1108_b(var20 - var28 / 2.0D);
                int var33 = MathHelper.func_1108_b(var20 + var28 / 2.0D);
                int var34 = MathHelper.func_1108_b(var22 - var30 / 2.0D);
                int var35 = MathHelper.func_1108_b(var22 + var30 / 2.0D);
                int var36 = MathHelper.func_1108_b(var24 - var28 / 2.0D);
                int var37 = MathHelper.func_1108_b(var24 + var28 / 2.0D);

                for(int var38 = var32; var38 <= var33; ++var38) {
                    for(int var39 = var34; var39 <= var35; ++var39) {
                        for(int var40 = var36; var40 <= var37; ++var40) {
                            double var41 = ((double)var38 + 0.5D - var20) / (var28 / 2.0D);
                            double var43 = ((double)var39 + 0.5D - var22) / (var30 / 2.0D);
                            double var45 = ((double)var40 + 0.5D - var24) / (var28 / 2.0D);
                            if (var41 * var41 + var43 * var43 + var45 * var45 < 1.0D) {
                                int var47 = var1.func_600_a(var38, var39, var40);
                                if (var47 == Block.field_393_F.field_376_bc) {
                                    var1.func_634_a(var38, var39, var40, this.field_867_a);
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
