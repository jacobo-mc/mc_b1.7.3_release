package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Explosion {
    public boolean field_12031_a = false;
    private Random field_12024_h = new Random();
    private World field_4310_a;
    public double field_12030_b;
    public double field_12029_c;
    public double field_12028_d;
    public Entity field_12027_e;
    public float field_12026_f;
    public Set field_12025_g = new HashSet();

    public Explosion(World var1, Entity var2, double var3, double var5, double var7, float var9) {
        this.field_4310_a = var1;
        this.field_12027_e = var2;
        this.field_12026_f = var9;
        this.field_12030_b = var3;
        this.field_12029_c = var5;
        this.field_12028_d = var7;
    }

    public void func_12023_a() {
        float var1 = this.field_12026_f;
        byte var2 = 16;

        int var3;
        int var4;
        int var5;
        double var15;
        double var17;
        double var19;
        for(var3 = 0; var3 < var2; ++var3) {
            for(var4 = 0; var4 < var2; ++var4) {
                for(var5 = 0; var5 < var2; ++var5) {
                    if (var3 == 0 || var3 == var2 - 1 || var4 == 0 || var4 == var2 - 1 || var5 == 0 || var5 == var2 - 1) {
                        double var6 = (double)((float)var3 / ((float)var2 - 1.0F) * 2.0F - 1.0F);
                        double var8 = (double)((float)var4 / ((float)var2 - 1.0F) * 2.0F - 1.0F);
                        double var10 = (double)((float)var5 / ((float)var2 - 1.0F) * 2.0F - 1.0F);
                        double var12 = Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
                        var6 /= var12;
                        var8 /= var12;
                        var10 /= var12;
                        float var14 = this.field_12026_f * (0.7F + this.field_4310_a.field_803_m.nextFloat() * 0.6F);
                        var15 = this.field_12030_b;
                        var17 = this.field_12029_c;
                        var19 = this.field_12028_d;

                        for(float var21 = 0.3F; var14 > 0.0F; var14 -= var21 * 0.75F) {
                            int var22 = MathHelper.func_584_b(var15);
                            int var23 = MathHelper.func_584_b(var17);
                            int var24 = MathHelper.func_584_b(var19);
                            int var25 = this.field_4310_a.func_444_a(var22, var23, var24);
                            if (var25 > 0) {
                                var14 -= (Block.field_542_n[var25].func_226_a(this.field_12027_e) + 0.3F) * var21;
                            }

                            if (var14 > 0.0F) {
                                this.field_12025_g.add(new ChunkPosition(var22, var23, var24));
                            }

                            var15 += var6 * (double)var21;
                            var17 += var8 * (double)var21;
                            var19 += var10 * (double)var21;
                        }
                    }
                }
            }
        }

        this.field_12026_f *= 2.0F;
        var3 = MathHelper.func_584_b(this.field_12030_b - (double)this.field_12026_f - 1.0D);
        var4 = MathHelper.func_584_b(this.field_12030_b + (double)this.field_12026_f + 1.0D);
        var5 = MathHelper.func_584_b(this.field_12029_c - (double)this.field_12026_f - 1.0D);
        int var29 = MathHelper.func_584_b(this.field_12029_c + (double)this.field_12026_f + 1.0D);
        int var7 = MathHelper.func_584_b(this.field_12028_d - (double)this.field_12026_f - 1.0D);
        int var30 = MathHelper.func_584_b(this.field_12028_d + (double)this.field_12026_f + 1.0D);
        List var9 = this.field_4310_a.func_450_b(this.field_12027_e, AxisAlignedBB.func_693_b((double)var3, (double)var5, (double)var7, (double)var4, (double)var29, (double)var30));
        Vec3D var31 = Vec3D.func_768_b(this.field_12030_b, this.field_12029_c, this.field_12028_d);

        for(int var11 = 0; var11 < var9.size(); ++var11) {
            Entity var33 = (Entity)var9.get(var11);
            double var13 = var33.func_103_e(this.field_12030_b, this.field_12029_c, this.field_12028_d) / (double)this.field_12026_f;
            if (var13 <= 1.0D) {
                var15 = var33.field_322_l - this.field_12030_b;
                var17 = var33.field_321_m - this.field_12029_c;
                var19 = var33.field_320_n - this.field_12028_d;
                double var39 = (double)MathHelper.func_583_a(var15 * var15 + var17 * var17 + var19 * var19);
                var15 /= var39;
                var17 /= var39;
                var19 /= var39;
                double var40 = (double)this.field_4310_a.func_494_a(var31, var33.field_312_v);
                double var41 = (1.0D - var13) * var40;
                var33.func_121_a(this.field_12027_e, (int)((var41 * var41 + var41) / 2.0D * 8.0D * (double)this.field_12026_f + 1.0D));
                var33.field_319_o += var15 * var41;
                var33.field_318_p += var17 * var41;
                var33.field_317_q += var19 * var41;
            }
        }

        this.field_12026_f = var1;
        ArrayList var32 = new ArrayList();
        var32.addAll(this.field_12025_g);
        if (this.field_12031_a) {
            for(int var34 = var32.size() - 1; var34 >= 0; --var34) {
                ChunkPosition var35 = (ChunkPosition)var32.get(var34);
                int var36 = var35.field_846_a;
                int var37 = var35.field_845_b;
                int var16 = var35.field_847_c;
                int var38 = this.field_4310_a.func_444_a(var36, var37, var16);
                int var18 = this.field_4310_a.func_444_a(var36, var37 - 1, var16);
                if (var38 == 0 && Block.field_540_p[var18] && this.field_12024_h.nextInt(3) == 0) {
                    this.field_4310_a.func_508_d(var36, var37, var16, Block.field_599_as.field_573_bc);
                }
            }
        }

    }

    public void func_732_a(boolean var1) {
        this.field_4310_a.func_502_a(this.field_12030_b, this.field_12029_c, this.field_12028_d, "random.explode", 4.0F, (1.0F + (this.field_4310_a.field_803_m.nextFloat() - this.field_4310_a.field_803_m.nextFloat()) * 0.2F) * 0.7F);
        ArrayList var2 = new ArrayList();
        var2.addAll(this.field_12025_g);

        for(int var3 = var2.size() - 1; var3 >= 0; --var3) {
            ChunkPosition var4 = (ChunkPosition)var2.get(var3);
            int var5 = var4.field_846_a;
            int var6 = var4.field_845_b;
            int var7 = var4.field_847_c;
            int var8 = this.field_4310_a.func_444_a(var5, var6, var7);
            if (var1) {
                double var9 = (double)((float)var5 + this.field_4310_a.field_803_m.nextFloat());
                double var11 = (double)((float)var6 + this.field_4310_a.field_803_m.nextFloat());
                double var13 = (double)((float)var7 + this.field_4310_a.field_803_m.nextFloat());
                double var15 = var9 - this.field_12030_b;
                double var17 = var11 - this.field_12029_c;
                double var19 = var13 - this.field_12028_d;
                double var21 = (double)MathHelper.func_583_a(var15 * var15 + var17 * var17 + var19 * var19);
                var15 /= var21;
                var17 /= var21;
                var19 /= var21;
                double var23 = 0.5D / (var21 / (double)this.field_12026_f + 0.1D);
                var23 *= (double)(this.field_4310_a.field_803_m.nextFloat() * this.field_4310_a.field_803_m.nextFloat() + 0.3F);
                var15 *= var23;
                var17 *= var23;
                var19 *= var23;
                this.field_4310_a.func_514_a("explode", (var9 + this.field_12030_b * 1.0D) / 2.0D, (var11 + this.field_12029_c * 1.0D) / 2.0D, (var13 + this.field_12028_d * 1.0D) / 2.0D, var15, var17, var19);
                this.field_4310_a.func_514_a("smoke", var9, var11, var13, var15, var17, var19);
            }

            if (var8 > 0) {
                Block.field_542_n[var8].func_227_a(this.field_4310_a, var5, var6, var7, this.field_4310_a.func_446_b(var5, var6, var7), 0.3F);
                this.field_4310_a.func_508_d(var5, var6, var7, 0);
                Block.field_542_n[var8].func_4029_c(this.field_4310_a, var5, var6, var7);
            }
        }

    }
}
