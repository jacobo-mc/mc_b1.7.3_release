package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {
    protected World field_1729_a;
    private List[] field_1728_b = new List[4];
    private RenderEngine field_1731_c;
    private Random field_1730_d = new Random();

    public EffectRenderer(World var1, RenderEngine var2) {
        if (var1 != null) {
            this.field_1729_a = var1;
        }

        this.field_1731_c = var2;

        for(int var3 = 0; var3 < 4; ++var3) {
            this.field_1728_b[var3] = new ArrayList();
        }

    }

    public void func_1192_a(EntityFX var1) {
        int var2 = var1.func_404_c();
        if (this.field_1728_b[var2].size() >= 4000) {
            this.field_1728_b[var2].remove(0);
        }

        this.field_1728_b[var2].add(var1);
    }

    public void func_1193_a() {
        for(int var1 = 0; var1 < 4; ++var1) {
            for(int var2 = 0; var2 < this.field_1728_b[var1].size(); ++var2) {
                EntityFX var3 = (EntityFX)this.field_1728_b[var1].get(var2);
                var3.func_370_e_();
                if (var3.field_646_aA) {
                    this.field_1728_b[var1].remove(var2--);
                }
            }
        }

    }

    public void func_1189_a(Entity var1, float var2) {
        float var3 = MathHelper.func_1114_b(var1.field_605_aq * 3.1415927F / 180.0F);
        float var4 = MathHelper.func_1106_a(var1.field_605_aq * 3.1415927F / 180.0F);
        float var5 = -var4 * MathHelper.func_1106_a(var1.field_604_ar * 3.1415927F / 180.0F);
        float var6 = var3 * MathHelper.func_1106_a(var1.field_604_ar * 3.1415927F / 180.0F);
        float var7 = MathHelper.func_1114_b(var1.field_604_ar * 3.1415927F / 180.0F);
        EntityFX.field_660_l = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * (double)var2;
        EntityFX.field_659_m = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * (double)var2;
        EntityFX.field_658_n = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * (double)var2;

        for(int var8 = 0; var8 < 3; ++var8) {
            if (this.field_1728_b[var8].size() != 0) {
                int var9 = 0;
                if (var8 == 0) {
                    var9 = this.field_1731_c.func_1070_a("/particles.png");
                }

                if (var8 == 1) {
                    var9 = this.field_1731_c.func_1070_a("/terrain.png");
                }

                if (var8 == 2) {
                    var9 = this.field_1731_c.func_1070_a("/gui/items.png");
                }

                GL11.glBindTexture(3553, var9);
                Tessellator var10 = Tessellator.field_1512_a;
                var10.func_977_b();

                for(int var11 = 0; var11 < this.field_1728_b[var8].size(); ++var11) {
                    EntityFX var12 = (EntityFX)this.field_1728_b[var8].get(var11);
                    var12.func_406_a(var10, var2, var3, var7, var4, var5, var6);
                }

                var10.func_982_a();
            }
        }

    }

    public void func_1187_b(Entity var1, float var2) {
        byte var3 = 3;
        if (this.field_1728_b[var3].size() != 0) {
            Tessellator var4 = Tessellator.field_1512_a;

            for(int var5 = 0; var5 < this.field_1728_b[var3].size(); ++var5) {
                EntityFX var6 = (EntityFX)this.field_1728_b[var3].get(var5);
                var6.func_406_a(var4, var2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
            }

        }
    }

    public void func_1188_a(World var1) {
        this.field_1729_a = var1;

        for(int var2 = 0; var2 < 4; ++var2) {
            this.field_1728_b[var2].clear();
        }

    }

    public void func_1186_a(int var1, int var2, int var3, int var4, int var5) {
        if (var4 != 0) {
            Block var6 = Block.field_345_n[var4];
            byte var7 = 4;

            for(int var8 = 0; var8 < var7; ++var8) {
                for(int var9 = 0; var9 < var7; ++var9) {
                    for(int var10 = 0; var10 < var7; ++var10) {
                        double var11 = (double)var1 + ((double)var8 + 0.5D) / (double)var7;
                        double var13 = (double)var2 + ((double)var9 + 0.5D) / (double)var7;
                        double var15 = (double)var3 + ((double)var10 + 0.5D) / (double)var7;
                        int var17 = this.field_1730_d.nextInt(6);
                        this.func_1192_a((new EntityDiggingFX(this.field_1729_a, var11, var13, var15, var11 - (double)var1 - 0.5D, var13 - (double)var2 - 0.5D, var15 - (double)var3 - 0.5D, var6, var17, var5)).func_4041_a(var1, var2, var3));
                    }
                }
            }

        }
    }

    public void func_1191_a(int var1, int var2, int var3, int var4) {
        int var5 = this.field_1729_a.func_600_a(var1, var2, var3);
        if (var5 != 0) {
            Block var6 = Block.field_345_n[var5];
            float var7 = 0.1F;
            double var8 = (double)var1 + this.field_1730_d.nextDouble() * (var6.field_364_bi - var6.field_370_bf - (double)(var7 * 2.0F)) + (double)var7 + var6.field_370_bf;
            double var10 = (double)var2 + this.field_1730_d.nextDouble() * (var6.field_362_bj - var6.field_368_bg - (double)(var7 * 2.0F)) + (double)var7 + var6.field_368_bg;
            double var12 = (double)var3 + this.field_1730_d.nextDouble() * (var6.field_360_bk - var6.field_366_bh - (double)(var7 * 2.0F)) + (double)var7 + var6.field_366_bh;
            if (var4 == 0) {
                var10 = (double)var2 + var6.field_368_bg - (double)var7;
            }

            if (var4 == 1) {
                var10 = (double)var2 + var6.field_362_bj + (double)var7;
            }

            if (var4 == 2) {
                var12 = (double)var3 + var6.field_366_bh - (double)var7;
            }

            if (var4 == 3) {
                var12 = (double)var3 + var6.field_360_bk + (double)var7;
            }

            if (var4 == 4) {
                var8 = (double)var1 + var6.field_370_bf - (double)var7;
            }

            if (var4 == 5) {
                var8 = (double)var1 + var6.field_364_bi + (double)var7;
            }

            this.func_1192_a((new EntityDiggingFX(this.field_1729_a, var8, var10, var12, 0.0D, 0.0D, 0.0D, var6, var4, this.field_1729_a.func_602_e(var1, var2, var3))).func_4041_a(var1, var2, var3).func_407_b(0.2F).func_405_d(0.6F));
        }
    }

    public String func_1190_b() {
        return "" + (this.field_1728_b[0].size() + this.field_1728_b[1].size() + this.field_1728_b[2].size());
    }
}
