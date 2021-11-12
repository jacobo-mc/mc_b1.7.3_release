package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class EntityPlayerSP extends EntityPlayer {
    public MovementInput field_787_a;
    protected Minecraft field_788_bg;
    private MouseFilter field_21903_bJ = new MouseFilter();
    private MouseFilter field_21904_bK = new MouseFilter();
    private MouseFilter field_21902_bL = new MouseFilter();

    public EntityPlayerSP(Minecraft var1, World var2, Session var3, int var4) {
        super(var2);
        this.field_788_bg = var1;
        this.field_4129_m = var4;
        if (var3 != null && var3.field_1666_b != null && var3.field_1666_b.length() > 0) {
            this.field_20047_bv = "http://s3.amazonaws.com/MinecraftSkins/" + var3.field_1666_b + ".png";
        }

        this.field_771_i = var3.field_1666_b;
    }

    public void func_349_c(double var1, double var3, double var5) {
        super.func_349_c(var1, var3, var5);
    }

    public void func_418_b_() {
        super.func_418_b_();
        this.field_9342_ah = this.field_787_a.field_1174_a;
        this.field_9340_ai = this.field_787_a.field_1173_b;
        this.field_9336_ak = this.field_787_a.field_1176_d;
    }

    public void func_425_j() {
        if (!this.field_788_bg.field_25001_G.func_27183_a(AchievementList.field_25195_b)) {
            this.field_788_bg.field_25002_t.func_27101_b(AchievementList.field_25195_b);
        }

        this.field_28025_B = this.field_28026_A;
        if (this.field_28023_z) {
            if (!this.field_615_ag.field_1026_y && this.field_616_af != null) {
                this.func_6377_h((Entity)null);
            }

            if (this.field_788_bg.field_6313_p != null) {
                this.field_788_bg.func_6272_a((GuiScreen)null);
            }

            if (this.field_28026_A == 0.0F) {
                this.field_788_bg.field_6301_A.func_337_a("portal.trigger", 1.0F, this.field_9312_bd.nextFloat() * 0.4F + 0.8F);
            }

            this.field_28026_A += 0.0125F;
            if (this.field_28026_A >= 1.0F) {
                this.field_28026_A = 1.0F;
                if (!this.field_615_ag.field_1026_y) {
                    this.field_28024_y = 10;
                    this.field_788_bg.field_6301_A.func_337_a("portal.travel", 1.0F, this.field_9312_bd.nextFloat() * 0.4F + 0.8F);
                    this.field_788_bg.func_6237_k();
                }
            }

            this.field_28023_z = false;
        } else {
            if (this.field_28026_A > 0.0F) {
                this.field_28026_A -= 0.05F;
            }

            if (this.field_28026_A < 0.0F) {
                this.field_28026_A = 0.0F;
            }
        }

        if (this.field_28024_y > 0) {
            --this.field_28024_y;
        }

        this.field_787_a.func_797_a(this);
        if (this.field_787_a.field_1175_e && this.field_9287_aY < 0.2F) {
            this.field_9287_aY = 0.2F;
        }

        this.func_28014_c(this.field_611_ak - (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am + (double)this.field_644_aC * 0.35D);
        this.func_28014_c(this.field_611_ak - (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am - (double)this.field_644_aC * 0.35D);
        this.func_28014_c(this.field_611_ak + (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am - (double)this.field_644_aC * 0.35D);
        this.func_28014_c(this.field_611_ak + (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am + (double)this.field_644_aC * 0.35D);
        super.func_425_j();
    }

    public void func_458_k() {
        this.field_787_a.func_798_a();
    }

    public void func_460_a(int var1, boolean var2) {
        this.field_787_a.func_796_a(var1, var2);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_758_a("Score", this.field_9370_g);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.field_9370_g = var1.func_756_e("Score");
    }

    public void func_20059_m() {
        super.func_20059_m();
        this.field_788_bg.func_6272_a((GuiScreen)null);
    }

    public void func_4052_a(TileEntitySign var1) {
        this.field_788_bg.func_6272_a(new GuiEditSign(var1));
    }

    public void func_452_a(IInventory var1) {
        this.field_788_bg.func_6272_a(new GuiChest(this.field_778_b, var1));
    }

    public void func_445_l(int var1, int var2, int var3) {
        this.field_788_bg.func_6272_a(new GuiCrafting(this.field_778_b, this.field_615_ag, var1, var2, var3));
    }

    public void func_453_a(TileEntityFurnace var1) {
        this.field_788_bg.func_6272_a(new GuiFurnace(this.field_778_b, var1));
    }

    public void func_21092_a(TileEntityDispenser var1) {
        this.field_788_bg.func_6272_a(new GuiDispenser(this.field_778_b, var1));
    }

    public void func_443_a_(Entity var1, int var2) {
        this.field_788_bg.field_6321_h.func_1192_a(new EntityPickupFX(this.field_788_bg.field_6324_e, var1, this, -0.5F));
    }

    public int func_6419_n() {
        return this.field_778_b.func_506_f();
    }

    public void func_461_a(String var1) {
    }

    public boolean func_381_o() {
        return this.field_787_a.field_1175_e && !this.field_21901_a;
    }

    public void func_9372_a_(int var1) {
        int var2 = this.field_9337_J - var1;
        if (var2 <= 0) {
            this.field_9337_J = var1;
            if (var2 < 0) {
                this.field_9306_bj = this.field_9366_o / 2;
            }
        } else {
            this.field_9346_af = var2;
            this.field_9335_K = this.field_9337_J;
            this.field_9306_bj = this.field_9366_o;
            this.func_4044_a(var2);
            this.field_715_G = this.field_9332_M = 10;
        }

    }

    public void func_9367_r() {
        this.field_788_bg.func_6239_p(false, 0);
    }

    public void func_6420_o() {
    }

    public void func_22055_b(String var1) {
        this.field_788_bg.field_6308_u.func_22064_c(var1);
    }

    public void func_25058_a(StatBase var1, int var2) {
        if (var1 != null) {
            if (var1.func_25067_a()) {
                Achievement var3 = (Achievement)var1;
                if (var3.field_25076_c == null || this.field_788_bg.field_25001_G.func_27183_a(var3.field_25076_c)) {
                    if (!this.field_788_bg.field_25001_G.func_27183_a(var3)) {
                        this.field_788_bg.field_25002_t.func_27102_a(var3);
                    }

                    this.field_788_bg.field_25001_G.func_25100_a(var1, var2);
                }
            } else {
                this.field_788_bg.field_25001_G.func_25100_a(var1, var2);
            }

        }
    }

    private boolean func_28027_d(int var1, int var2, int var3) {
        return this.field_615_ag.func_28100_h(var1, var2, var3);
    }

    protected boolean func_28014_c(double var1, double var3, double var5) {
        int var7 = MathHelper.func_1108_b(var1);
        int var8 = MathHelper.func_1108_b(var3);
        int var9 = MathHelper.func_1108_b(var5);
        double var10 = var1 - (double)var7;
        double var12 = var5 - (double)var9;
        if (this.func_28027_d(var7, var8, var9) || this.func_28027_d(var7, var8 + 1, var9)) {
            boolean var14 = !this.func_28027_d(var7 - 1, var8, var9) && !this.func_28027_d(var7 - 1, var8 + 1, var9);
            boolean var15 = !this.func_28027_d(var7 + 1, var8, var9) && !this.func_28027_d(var7 + 1, var8 + 1, var9);
            boolean var16 = !this.func_28027_d(var7, var8, var9 - 1) && !this.func_28027_d(var7, var8 + 1, var9 - 1);
            boolean var17 = !this.func_28027_d(var7, var8, var9 + 1) && !this.func_28027_d(var7, var8 + 1, var9 + 1);
            byte var18 = -1;
            double var19 = 9999.0D;
            if (var14 && var10 < var19) {
                var19 = var10;
                var18 = 0;
            }

            if (var15 && 1.0D - var10 < var19) {
                var19 = 1.0D - var10;
                var18 = 1;
            }

            if (var16 && var12 < var19) {
                var19 = var12;
                var18 = 4;
            }

            if (var17 && 1.0D - var12 < var19) {
                var19 = 1.0D - var12;
                var18 = 5;
            }

            float var21 = 0.1F;
            if (var18 == 0) {
                this.field_608_an = (double)(-var21);
            }

            if (var18 == 1) {
                this.field_608_an = (double)var21;
            }

            if (var18 == 4) {
                this.field_606_ap = (double)(-var21);
            }

            if (var18 == 5) {
                this.field_606_ap = (double)var21;
            }
        }

        return false;
    }
}
