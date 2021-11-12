package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class EntityPainting extends Entity {
    private int field_452_ad;
    public int field_448_a;
    public int field_9188_d;
    public int field_9187_e;
    public int field_9186_f;
    public EnumArt field_9185_b;

    public EntityPainting(World var1) {
        super(var1);
        this.field_452_ad = 0;
        this.field_448_a = 0;
        this.field_9076_H = 0.0F;
        this.func_113_a(0.5F, 0.5F);
    }

    public EntityPainting(World var1, int var2, int var3, int var4, int var5) {
        this(var1);
        this.field_9188_d = var2;
        this.field_9187_e = var3;
        this.field_9186_f = var4;
        ArrayList var6 = new ArrayList();
        EnumArt[] var7 = EnumArt.values();
        int var8 = var7.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            EnumArt var10 = var7[var9];
            this.field_9185_b = var10;
            this.func_179_a(var5);
            if (this.func_181_b()) {
                var6.add(var10);
            }
        }

        if (var6.size() > 0) {
            this.field_9185_b = (EnumArt)var6.get(this.field_9064_W.nextInt(var6.size()));
        }

        this.func_179_a(var5);
    }

    protected void func_21044_a() {
    }

    public void func_179_a(int var1) {
        this.field_448_a = var1;
        this.field_9089_x = this.field_316_r = (float)(var1 * 90);
        float var2 = (float)this.field_9185_b.field_856_z;
        float var3 = (float)this.field_9185_b.field_869_A;
        float var4 = (float)this.field_9185_b.field_856_z;
        if (var1 != 0 && var1 != 2) {
            var2 = 0.5F;
        } else {
            var4 = 0.5F;
        }

        var2 /= 32.0F;
        var3 /= 32.0F;
        var4 /= 32.0F;
        float var5 = (float)this.field_9188_d + 0.5F;
        float var6 = (float)this.field_9187_e + 0.5F;
        float var7 = (float)this.field_9186_f + 0.5F;
        float var8 = 0.5625F;
        if (var1 == 0) {
            var7 -= var8;
        }

        if (var1 == 1) {
            var5 -= var8;
        }

        if (var1 == 2) {
            var7 += var8;
        }

        if (var1 == 3) {
            var5 += var8;
        }

        if (var1 == 0) {
            var5 -= this.func_180_c(this.field_9185_b.field_856_z);
        }

        if (var1 == 1) {
            var7 += this.func_180_c(this.field_9185_b.field_856_z);
        }

        if (var1 == 2) {
            var5 += this.func_180_c(this.field_9185_b.field_856_z);
        }

        if (var1 == 3) {
            var7 -= this.func_180_c(this.field_9185_b.field_856_z);
        }

        var6 += this.func_180_c(this.field_9185_b.field_869_A);
        this.func_86_a((double)var5, (double)var6, (double)var7);
        float var9 = -0.00625F;
        this.field_312_v.func_695_c((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
    }

    private float func_180_c(int var1) {
        if (var1 == 32) {
            return 0.5F;
        } else {
            return var1 == 64 ? 0.5F : 0.0F;
        }
    }

    public void func_106_b_() {
        if (this.field_452_ad++ == 100 && !this.field_9093_l.field_792_x) {
            this.field_452_ad = 0;
            if (!this.func_181_b()) {
                this.func_118_j();
                this.field_9093_l.func_526_a(new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m, this.field_320_n, new ItemStack(Item.field_213_aq)));
            }
        }

    }

    public boolean func_181_b() {
        if (this.field_9093_l.func_481_a(this, this.field_312_v).size() > 0) {
            return false;
        } else {
            int var1 = this.field_9185_b.field_856_z / 16;
            int var2 = this.field_9185_b.field_869_A / 16;
            int var3 = this.field_9188_d;
            int var4 = this.field_9187_e;
            int var5 = this.field_9186_f;
            if (this.field_448_a == 0) {
                var3 = MathHelper.func_584_b(this.field_322_l - (double)((float)this.field_9185_b.field_856_z / 32.0F));
            }

            if (this.field_448_a == 1) {
                var5 = MathHelper.func_584_b(this.field_320_n - (double)((float)this.field_9185_b.field_856_z / 32.0F));
            }

            if (this.field_448_a == 2) {
                var3 = MathHelper.func_584_b(this.field_322_l - (double)((float)this.field_9185_b.field_856_z / 32.0F));
            }

            if (this.field_448_a == 3) {
                var5 = MathHelper.func_584_b(this.field_320_n - (double)((float)this.field_9185_b.field_856_z / 32.0F));
            }

            var4 = MathHelper.func_584_b(this.field_321_m - (double)((float)this.field_9185_b.field_869_A / 32.0F));

            int var7;
            for(int var6 = 0; var6 < var1; ++var6) {
                for(var7 = 0; var7 < var2; ++var7) {
                    Material var8;
                    if (this.field_448_a != 0 && this.field_448_a != 2) {
                        var8 = this.field_9093_l.func_443_c(this.field_9188_d, var4 + var7, var5 + var6);
                    } else {
                        var8 = this.field_9093_l.func_443_c(var3 + var6, var4 + var7, this.field_9186_f);
                    }

                    if (!var8.func_216_a()) {
                        return false;
                    }
                }
            }

            List var9 = this.field_9093_l.func_450_b(this, this.field_312_v);

            for(var7 = 0; var7 < var9.size(); ++var7) {
                if (var9.get(var7) instanceof EntityPainting) {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean func_129_c_() {
        return true;
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (!this.field_304_B && !this.field_9093_l.field_792_x) {
            this.func_118_j();
            this.func_9060_u();
            this.field_9093_l.func_526_a(new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m, this.field_320_n, new ItemStack(Item.field_213_aq)));
        }

        return true;
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_409_a("Dir", (byte)this.field_448_a);
        var1.func_403_a("Motive", this.field_9185_b.field_857_y);
        var1.func_405_a("TileX", this.field_9188_d);
        var1.func_405_a("TileY", this.field_9187_e);
        var1.func_405_a("TileZ", this.field_9186_f);
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_448_a = var1.func_408_b("Dir");
        this.field_9188_d = var1.func_395_d("TileX");
        this.field_9187_e = var1.func_395_d("TileY");
        this.field_9186_f = var1.func_395_d("TileZ");
        String var2 = var1.func_401_h("Motive");
        EnumArt[] var3 = EnumArt.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            EnumArt var6 = var3[var5];
            if (var6.field_857_y.equals(var2)) {
                this.field_9185_b = var6;
            }
        }

        if (this.field_9185_b == null) {
            this.field_9185_b = EnumArt.Kebab;
        }

        this.func_179_a(this.field_448_a);
    }

    public void func_88_c(double var1, double var3, double var5) {
        if (!this.field_9093_l.field_792_x && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
            this.func_118_j();
            this.field_9093_l.func_526_a(new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m, this.field_320_n, new ItemStack(Item.field_213_aq)));
        }

    }

    public void func_87_f(double var1, double var3, double var5) {
        if (!this.field_9093_l.field_792_x && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
            this.func_118_j();
            this.field_9093_l.func_526_a(new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m, this.field_320_n, new ItemStack(Item.field_213_aq)));
        }

    }
}
