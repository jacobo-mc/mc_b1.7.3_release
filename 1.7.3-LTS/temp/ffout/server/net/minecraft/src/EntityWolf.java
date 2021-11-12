package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class EntityWolf extends EntityAnimal {
    private boolean field_25039_a = false;
    private float field_25038_b;
    private float field_25044_c;
    private boolean field_25043_f;
    private boolean field_25042_g;
    private float field_25041_h;
    private float field_25040_i;

    public EntityWolf(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/wolf.png";
        this.func_113_a(0.8F, 0.8F);
        this.field_9126_bt = 1.1F;
        this.field_9109_aQ = 8;
    }

    protected void func_21044_a() {
        super.func_21044_a();
        this.field_21045_af.func_21153_a(16, (byte)0);
        this.field_21045_af.func_21153_a(17, "");
        this.field_21045_af.func_21153_a(18, new Integer(this.field_9109_aQ));
    }

    protected boolean func_25017_l() {
        return false;
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        var1.func_393_a("Angry", this.func_25028_x());
        var1.func_393_a("Sitting", this.func_25036_w());
        if (this.func_25034_v() == null) {
            var1.func_403_a("Owner", "");
        } else {
            var1.func_403_a("Owner", this.func_25034_v());
        }

    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        this.func_25037_c(var1.func_402_l("Angry"));
        this.func_25031_b(var1.func_402_l("Sitting"));
        String var2 = var1.func_401_h("Owner");
        if (var2.length() > 0) {
            this.func_25029_a(var2);
            this.func_25032_d(true);
        }

    }

    protected boolean func_25020_s() {
        return !this.func_25030_y();
    }

    protected String func_6097_d() {
        if (this.func_25028_x()) {
            return "mob.wolf.growl";
        } else if (this.field_9064_W.nextInt(3) == 0) {
            return this.func_25030_y() && this.field_21045_af.func_25075_b(18) < 10 ? "mob.wolf.whine" : "mob.wolf.panting";
        } else {
            return "mob.wolf.bark";
        }
    }

    protected String func_6100_e() {
        return "mob.wolf.hurt";
    }

    protected String func_6098_f() {
        return "mob.wolf.death";
    }

    protected float func_6102_h() {
        return 0.4F;
    }

    protected int func_149_g() {
        return -1;
    }

    protected void func_152_d_() {
        super.func_152_d_();
        if (!this.field_387_ah && !this.func_25023_z() && this.func_25030_y() && this.field_327_g == null) {
            EntityPlayer var3 = this.field_9093_l.func_25071_a(this.func_25034_v());
            if (var3 != null) {
                float var2 = var3.func_94_a(this);
                if (var2 > 5.0F) {
                    this.func_25035_b(var3, var2);
                }
            } else if (!this.func_27011_Z()) {
                this.func_25031_b(true);
            }
        } else if (this.field_389_ag == null && !this.func_25023_z() && !this.func_25030_y() && this.field_9093_l.field_803_m.nextInt(100) == 0) {
            List var1 = this.field_9093_l.func_457_a(EntitySheep.class, AxisAlignedBB.func_693_b(this.field_322_l, this.field_321_m, this.field_320_n, this.field_322_l + 1.0D, this.field_321_m + 1.0D, this.field_320_n + 1.0D).func_708_b(16.0D, 4.0D, 16.0D));
            if (!var1.isEmpty()) {
                this.func_25025_c((Entity)var1.get(this.field_9093_l.field_803_m.nextInt(var1.size())));
            }
        }

        if (this.func_27011_Z()) {
            this.func_25031_b(false);
        }

        if (!this.field_9093_l.field_792_x) {
            this.field_21045_af.func_21155_b(18, this.field_9109_aQ);
        }

    }

    public void func_153_y() {
        super.func_153_y();
        this.field_25039_a = false;
        if (this.func_25021_O() && !this.func_25023_z() && !this.func_25028_x()) {
            Entity var1 = this.func_25019_P();
            if (var1 instanceof EntityPlayer) {
                EntityPlayer var2 = (EntityPlayer)var1;
                ItemStack var3 = var2.field_416_aj.func_213_b();
                if (var3 != null) {
                    if (!this.func_25030_y() && var3.field_855_c == Item.field_21096_aV.field_234_aS) {
                        this.field_25039_a = true;
                    } else if (this.func_25030_y() && Item.field_176_c[var3.field_855_c] instanceof ItemFood) {
                        this.field_25039_a = ((ItemFood)Item.field_176_c[var3.field_855_c]).func_25010_k();
                    }
                }
            }
        }

        if (!this.field_9112_aN && this.field_25043_f && !this.field_25042_g && !this.func_25023_z() && this.field_9086_A) {
            this.field_25042_g = true;
            this.field_25041_h = 0.0F;
            this.field_25040_i = 0.0F;
            this.field_9093_l.func_9206_a(this, (byte)8);
        }

    }

    public void func_106_b_() {
        super.func_106_b_();
        this.field_25044_c = this.field_25038_b;
        if (this.field_25039_a) {
            this.field_25038_b += (1.0F - this.field_25038_b) * 0.4F;
        } else {
            this.field_25038_b += (0.0F - this.field_25038_b) * 0.4F;
        }

        if (this.field_25039_a) {
            this.field_4104_c = 10;
        }

        if (this.func_27008_Y()) {
            this.field_25043_f = true;
            this.field_25042_g = false;
            this.field_25041_h = 0.0F;
            this.field_25040_i = 0.0F;
        } else if ((this.field_25043_f || this.field_25042_g) && this.field_25042_g) {
            if (this.field_25041_h == 0.0F) {
                this.field_9093_l.func_506_a(this, "mob.wolf.shake", this.func_6102_h(), (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
            }

            this.field_25040_i = this.field_25041_h;
            this.field_25041_h += 0.05F;
            if (this.field_25040_i >= 2.0F) {
                this.field_25043_f = false;
                this.field_25042_g = false;
                this.field_25040_i = 0.0F;
                this.field_25041_h = 0.0F;
            }

            if (this.field_25041_h > 0.4F) {
                float var1 = (float)this.field_312_v.field_963_b;
                int var2 = (int)(MathHelper.func_585_a((this.field_25041_h - 0.4F) * 3.1415927F) * 7.0F);

                for(int var3 = 0; var3 < var2; ++var3) {
                    float var4 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D * 0.5F;
                    float var5 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D * 0.5F;
                    this.field_9093_l.func_514_a("splash", this.field_322_l + (double)var4, (double)(var1 + 0.8F), this.field_320_n + (double)var5, this.field_319_o, this.field_318_p, this.field_317_q);
                }
            }
        }

    }

    public float func_104_p() {
        return this.field_298_E * 0.8F;
    }

    protected int func_25018_n_() {
        return this.func_25036_w() ? 20 : super.func_25018_n_();
    }

    private void func_25035_b(Entity var1, float var2) {
        PathEntity var3 = this.field_9093_l.func_482_a(this, var1, 16.0F);
        if (var3 == null && var2 > 12.0F) {
            int var4 = MathHelper.func_584_b(var1.field_322_l) - 2;
            int var5 = MathHelper.func_584_b(var1.field_320_n) - 2;
            int var6 = MathHelper.func_584_b(var1.field_312_v.field_963_b);

            for(int var7 = 0; var7 <= 4; ++var7) {
                for(int var8 = 0; var8 <= 4; ++var8) {
                    if ((var7 < 1 || var8 < 1 || var7 > 3 || var8 > 3) && this.field_9093_l.func_445_d(var4 + var7, var6 - 1, var5 + var8) && !this.field_9093_l.func_445_d(var4 + var7, var6, var5 + var8) && !this.field_9093_l.func_445_d(var4 + var7, var6 + 1, var5 + var8)) {
                        this.func_107_c((double)((float)(var4 + var7) + 0.5F), (double)var6, (double)((float)(var5 + var8) + 0.5F), this.field_316_r, this.field_315_s);
                        return;
                    }
                }
            }
        } else {
            this.func_25022_a(var3);
        }

    }

    protected boolean func_25026_u() {
        return this.func_25036_w() || this.field_25042_g;
    }

    public boolean func_121_a(Entity var1, int var2) {
        this.func_25031_b(false);
        if (var1 != null && !(var1 instanceof EntityPlayer) && !(var1 instanceof EntityArrow)) {
            var2 = (var2 + 1) / 2;
        }

        if (!super.func_121_a((Entity)var1, var2)) {
            return false;
        } else {
            if (!this.func_25030_y() && !this.func_25028_x()) {
                if (var1 instanceof EntityPlayer) {
                    this.func_25037_c(true);
                    this.field_389_ag = (Entity)var1;
                }

                if (var1 instanceof EntityArrow && ((EntityArrow)var1).field_439_ah != null) {
                    var1 = ((EntityArrow)var1).field_439_ah;
                }

                if (var1 instanceof EntityLiving) {
                    List var3 = this.field_9093_l.func_457_a(EntityWolf.class, AxisAlignedBB.func_693_b(this.field_322_l, this.field_321_m, this.field_320_n, this.field_322_l + 1.0D, this.field_321_m + 1.0D, this.field_320_n + 1.0D).func_708_b(16.0D, 4.0D, 16.0D));
                    Iterator var4 = var3.iterator();

                    while(var4.hasNext()) {
                        Entity var5 = (Entity)var4.next();
                        EntityWolf var6 = (EntityWolf)var5;
                        if (!var6.func_25030_y() && var6.field_389_ag == null) {
                            var6.field_389_ag = (Entity)var1;
                            if (var1 instanceof EntityPlayer) {
                                var6.func_25037_c(true);
                            }
                        }
                    }
                }
            } else if (var1 != this && var1 != null) {
                if (this.func_25030_y() && var1 instanceof EntityPlayer && ((EntityPlayer)var1).field_409_aq.equalsIgnoreCase(this.func_25034_v())) {
                    return true;
                }

                this.field_389_ag = (Entity)var1;
            }

            return true;
        }
    }

    protected Entity func_158_i() {
        return this.func_25028_x() ? this.field_9093_l.func_472_a(this, 16.0D) : null;
    }

    protected void func_157_a(Entity var1, float var2) {
        if (var2 > 2.0F && var2 < 6.0F && this.field_9064_W.nextInt(10) == 0) {
            if (this.field_9086_A) {
                double var8 = var1.field_322_l - this.field_322_l;
                double var5 = var1.field_320_n - this.field_320_n;
                float var7 = MathHelper.func_583_a(var8 * var8 + var5 * var5);
                this.field_319_o = var8 / (double)var7 * 0.5D * 0.800000011920929D + this.field_319_o * 0.20000000298023224D;
                this.field_317_q = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.field_317_q * 0.20000000298023224D;
                this.field_318_p = 0.4000000059604645D;
            }
        } else if ((double)var2 < 1.5D && var1.field_312_v.field_968_e > this.field_312_v.field_963_b && var1.field_312_v.field_963_b < this.field_312_v.field_968_e) {
            this.field_9103_aW = 20;
            byte var3 = 2;
            if (this.func_25030_y()) {
                var3 = 4;
            }

            var1.func_121_a(this, var3);
        }

    }

    public boolean func_6092_a(EntityPlayer var1) {
        ItemStack var2 = var1.field_416_aj.func_213_b();
        if (!this.func_25030_y()) {
            if (var2 != null && var2.field_855_c == Item.field_21096_aV.field_234_aS && !this.func_25028_x()) {
                --var2.field_853_a;
                if (var2.field_853_a <= 0) {
                    var1.field_416_aj.func_206_a(var1.field_416_aj.field_499_d, (ItemStack)null);
                }

                if (!this.field_9093_l.field_792_x) {
                    if (this.field_9064_W.nextInt(3) == 0) {
                        this.func_25032_d(true);
                        this.func_25022_a((PathEntity)null);
                        this.func_25031_b(true);
                        this.field_9109_aQ = 20;
                        this.func_25029_a(var1.field_409_aq);
                        this.func_25033_a(true);
                        this.field_9093_l.func_9206_a(this, (byte)7);
                    } else {
                        this.func_25033_a(false);
                        this.field_9093_l.func_9206_a(this, (byte)6);
                    }
                }

                return true;
            }
        } else {
            if (var2 != null && Item.field_176_c[var2.field_855_c] instanceof ItemFood) {
                ItemFood var3 = (ItemFood)Item.field_176_c[var2.field_855_c];
                if (var3.func_25010_k() && this.field_21045_af.func_25075_b(18) < 20) {
                    --var2.field_853_a;
                    if (var2.field_853_a <= 0) {
                        var1.field_416_aj.func_206_a(var1.field_416_aj.field_499_d, (ItemStack)null);
                    }

                    this.func_137_a(((ItemFood)Item.field_215_ao).func_25009_j());
                    return true;
                }
            }

            if (var1.field_409_aq.equalsIgnoreCase(this.func_25034_v())) {
                if (!this.field_9093_l.field_792_x) {
                    this.func_25031_b(!this.func_25036_w());
                    this.field_9128_br = false;
                    this.func_25022_a((PathEntity)null);
                }

                return true;
            }
        }

        return false;
    }

    void func_25033_a(boolean var1) {
        String var2 = "heart";
        if (!var1) {
            var2 = "smoke";
        }

        for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.field_9064_W.nextGaussian() * 0.02D;
            double var6 = this.field_9064_W.nextGaussian() * 0.02D;
            double var8 = this.field_9064_W.nextGaussian() * 0.02D;
            this.field_9093_l.func_514_a(var2, this.field_322_l + (double)(this.field_9064_W.nextFloat() * this.field_300_D * 2.0F) - (double)this.field_300_D, this.field_321_m + 0.5D + (double)(this.field_9064_W.nextFloat() * this.field_298_E), this.field_320_n + (double)(this.field_9064_W.nextFloat() * this.field_300_D * 2.0F) - (double)this.field_300_D, var4, var6, var8);
        }

    }

    public int func_4045_i() {
        return 8;
    }

    public String func_25034_v() {
        return this.field_21045_af.func_25076_c(17);
    }

    public void func_25029_a(String var1) {
        this.field_21045_af.func_21155_b(17, var1);
    }

    public boolean func_25036_w() {
        return (this.field_21045_af.func_21156_a(16) & 1) != 0;
    }

    public void func_25031_b(boolean var1) {
        byte var2 = this.field_21045_af.func_21156_a(16);
        if (var1) {
            this.field_21045_af.func_21155_b(16, (byte)(var2 | 1));
        } else {
            this.field_21045_af.func_21155_b(16, (byte)(var2 & -2));
        }

    }

    public boolean func_25028_x() {
        return (this.field_21045_af.func_21156_a(16) & 2) != 0;
    }

    public void func_25037_c(boolean var1) {
        byte var2 = this.field_21045_af.func_21156_a(16);
        if (var1) {
            this.field_21045_af.func_21155_b(16, (byte)(var2 | 2));
        } else {
            this.field_21045_af.func_21155_b(16, (byte)(var2 & -3));
        }

    }

    public boolean func_25030_y() {
        return (this.field_21045_af.func_21156_a(16) & 4) != 0;
    }

    public void func_25032_d(boolean var1) {
        byte var2 = this.field_21045_af.func_21156_a(16);
        if (var1) {
            this.field_21045_af.func_21155_b(16, (byte)(var2 | 4));
        } else {
            this.field_21045_af.func_21155_b(16, (byte)(var2 & -5));
        }

    }
}
