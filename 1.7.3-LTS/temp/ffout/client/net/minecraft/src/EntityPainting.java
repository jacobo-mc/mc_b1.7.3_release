package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class EntityPainting extends Entity {
    private int field_695_c;
    public int field_691_a;
    public int field_9322_d;
    public int field_9321_e;
    public int field_9320_f;
    public EnumArt field_690_b;

    public EntityPainting(World var1) {
        super(var1);
        this.field_695_c = 0;
        this.field_691_a = 0;
        this.field_9292_aO = 0.0F;
        this.func_371_a(0.5F, 0.5F);
    }

    public EntityPainting(World var1, int var2, int var3, int var4, int var5) {
        this(var1);
        this.field_9322_d = var2;
        this.field_9321_e = var3;
        this.field_9320_f = var4;
        ArrayList var6 = new ArrayList();
        EnumArt[] var7 = EnumArt.values();
        int var8 = var7.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            EnumArt var10 = var7[var9];
            this.field_690_b = var10;
            this.func_412_b(var5);
            if (this.func_410_i()) {
                var6.add(var10);
            }
        }

        if (var6.size() > 0) {
            this.field_690_b = (EnumArt)var6.get(this.field_9312_bd.nextInt(var6.size()));
        }

        this.func_412_b(var5);
    }

    public EntityPainting(World var1, int var2, int var3, int var4, int var5, String var6) {
        this(var1);
        this.field_9322_d = var2;
        this.field_9321_e = var3;
        this.field_9320_f = var4;
        EnumArt[] var7 = EnumArt.values();
        int var8 = var7.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            EnumArt var10 = var7[var9];
            if (var10.field_1624_y.equals(var6)) {
                this.field_690_b = var10;
                break;
            }
        }

        this.func_412_b(var5);
    }

    protected void func_21057_b() {
    }

    public void func_412_b(int var1) {
        this.field_691_a = var1;
        this.field_603_as = this.field_605_aq = (float)(var1 * 90);
        float var2 = (float)this.field_690_b.field_1623_z;
        float var3 = (float)this.field_690_b.field_1636_A;
        float var4 = (float)this.field_690_b.field_1623_z;
        if (var1 != 0 && var1 != 2) {
            var2 = 0.5F;
        } else {
            var4 = 0.5F;
        }

        var2 /= 32.0F;
        var3 /= 32.0F;
        var4 /= 32.0F;
        float var5 = (float)this.field_9322_d + 0.5F;
        float var6 = (float)this.field_9321_e + 0.5F;
        float var7 = (float)this.field_9320_f + 0.5F;
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
            var5 -= this.func_411_c(this.field_690_b.field_1623_z);
        }

        if (var1 == 1) {
            var7 += this.func_411_c(this.field_690_b.field_1623_z);
        }

        if (var1 == 2) {
            var5 += this.func_411_c(this.field_690_b.field_1623_z);
        }

        if (var1 == 3) {
            var7 -= this.func_411_c(this.field_690_b.field_1623_z);
        }

        var6 += this.func_411_c(this.field_690_b.field_1636_A);
        this.func_347_a((double)var5, (double)var6, (double)var7);
        float var9 = -0.00625F;
        this.field_601_au.func_1165_c((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
    }

    private float func_411_c(int var1) {
        if (var1 == 32) {
            return 0.5F;
        } else {
            return var1 == 64 ? 0.5F : 0.0F;
        }
    }

    public void func_370_e_() {
        if (this.field_695_c++ == 100 && !this.field_615_ag.field_1026_y) {
            this.field_695_c = 0;
            if (!this.func_410_i()) {
                this.func_395_F();
                this.field_615_ag.func_674_a(new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, new ItemStack(Item.field_270_aq)));
            }
        }

    }

    public boolean func_410_i() {
        if (this.field_615_ag.func_697_a(this, this.field_601_au).size() > 0) {
            return false;
        } else {
            int var1 = this.field_690_b.field_1623_z / 16;
            int var2 = this.field_690_b.field_1636_A / 16;
            int var3 = this.field_9322_d;
            int var4 = this.field_9321_e;
            int var5 = this.field_9320_f;
            if (this.field_691_a == 0) {
                var3 = MathHelper.func_1108_b(this.field_611_ak - (double)((float)this.field_690_b.field_1623_z / 32.0F));
            }

            if (this.field_691_a == 1) {
                var5 = MathHelper.func_1108_b(this.field_609_am - (double)((float)this.field_690_b.field_1623_z / 32.0F));
            }

            if (this.field_691_a == 2) {
                var3 = MathHelper.func_1108_b(this.field_611_ak - (double)((float)this.field_690_b.field_1623_z / 32.0F));
            }

            if (this.field_691_a == 3) {
                var5 = MathHelper.func_1108_b(this.field_609_am - (double)((float)this.field_690_b.field_1623_z / 32.0F));
            }

            var4 = MathHelper.func_1108_b(this.field_610_al - (double)((float)this.field_690_b.field_1636_A / 32.0F));

            int var7;
            for(int var6 = 0; var6 < var1; ++var6) {
                for(var7 = 0; var7 < var2; ++var7) {
                    Material var8;
                    if (this.field_691_a != 0 && this.field_691_a != 2) {
                        var8 = this.field_615_ag.func_599_f(this.field_9322_d, var4 + var7, var5 + var6);
                    } else {
                        var8 = this.field_615_ag.func_599_f(var3 + var6, var4 + var7, this.field_9320_f);
                    }

                    if (!var8.func_878_a()) {
                        return false;
                    }
                }
            }

            List var9 = this.field_615_ag.func_659_b(this, this.field_601_au);

            for(var7 = 0; var7 < var9.size(); ++var7) {
                if (var9.get(var7) instanceof EntityPainting) {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean func_401_c_() {
        return true;
    }

    public boolean func_396_a(Entity var1, int var2) {
        if (!this.field_646_aA && !this.field_615_ag.field_1026_y) {
            this.func_395_F();
            this.func_9281_M();
            this.field_615_ag.func_674_a(new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, new ItemStack(Item.field_270_aq)));
        }

        return true;
    }

    public void func_352_a(NBTTagCompound var1) {
        var1.func_761_a("Dir", (byte)this.field_691_a);
        var1.func_754_a("Motive", this.field_690_b.field_1624_y);
        var1.func_758_a("TileX", this.field_9322_d);
        var1.func_758_a("TileY", this.field_9321_e);
        var1.func_758_a("TileZ", this.field_9320_f);
    }

    public void func_357_b(NBTTagCompound var1) {
        this.field_691_a = var1.func_746_c("Dir");
        this.field_9322_d = var1.func_756_e("TileX");
        this.field_9321_e = var1.func_756_e("TileY");
        this.field_9320_f = var1.func_756_e("TileZ");
        String var2 = var1.func_755_i("Motive");
        EnumArt[] var3 = EnumArt.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            EnumArt var6 = var3[var5];
            if (var6.field_1624_y.equals(var2)) {
                this.field_690_b = var6;
            }
        }

        if (this.field_690_b == null) {
            this.field_690_b = EnumArt.Kebab;
        }

        this.func_412_b(this.field_691_a);
    }

    public void func_349_c(double var1, double var3, double var5) {
        if (!this.field_615_ag.field_1026_y && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
            this.func_395_F();
            this.field_615_ag.func_674_a(new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, new ItemStack(Item.field_270_aq)));
        }

    }

    public void func_348_f(double var1, double var3, double var5) {
        if (!this.field_615_ag.field_1026_y && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
            this.func_395_F();
            this.field_615_ag.func_674_a(new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, new ItemStack(Item.field_270_aq)));
        }

    }
}
