package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class EntityClientPlayerMP extends EntityPlayerSP {
    public NetClientHandler field_797_bg;
    private int field_9380_bx = 0;
    private boolean field_21093_bH = false;
    private double field_9379_by;
    private double field_9378_bz;
    private double field_9377_bA;
    private double field_9376_bB;
    private float field_9385_bC;
    private float field_9384_bD;
    private boolean field_9382_bF = false;
    private boolean field_9381_bG = false;
    private int field_12242_bI = 0;

    public EntityClientPlayerMP(Minecraft var1, World var2, Session var3, NetClientHandler var4) {
        super(var1, var2, var3, 0);
        this.field_797_bg = var4;
    }

    public boolean func_396_a(Entity var1, int var2) {
        return false;
    }

    public void func_432_b(int var1) {
    }

    public void func_370_e_() {
        if (this.field_615_ag.func_630_d(MathHelper.func_1108_b(this.field_611_ak), 64, MathHelper.func_1108_b(this.field_609_am))) {
            super.func_370_e_();
            this.func_4056_N();
        }
    }

    public void func_4056_N() {
        if (this.field_9380_bx++ == 20) {
            this.func_9375_Q();
            this.field_9380_bx = 0;
        }

        boolean var1 = this.func_381_o();
        if (var1 != this.field_9381_bG) {
            if (var1) {
                this.field_797_bg.func_847_a(new Packet19EntityAction(this, 1));
            } else {
                this.field_797_bg.func_847_a(new Packet19EntityAction(this, 2));
            }

            this.field_9381_bG = var1;
        }

        double var2 = this.field_611_ak - this.field_9379_by;
        double var4 = this.field_601_au.field_1697_b - this.field_9378_bz;
        double var6 = this.field_610_al - this.field_9377_bA;
        double var8 = this.field_609_am - this.field_9376_bB;
        double var10 = (double)(this.field_605_aq - this.field_9385_bC);
        double var12 = (double)(this.field_604_ar - this.field_9384_bD);
        boolean var14 = var4 != 0.0D || var6 != 0.0D || var2 != 0.0D || var8 != 0.0D;
        boolean var15 = var10 != 0.0D || var12 != 0.0D;
        if (this.field_616_af != null) {
            if (var15) {
                this.field_797_bg.func_847_a(new Packet11PlayerPosition(this.field_608_an, -999.0D, -999.0D, this.field_606_ap, this.field_9298_aH));
            } else {
                this.field_797_bg.func_847_a(new Packet13PlayerLookMove(this.field_608_an, -999.0D, -999.0D, this.field_606_ap, this.field_605_aq, this.field_604_ar, this.field_9298_aH));
            }

            var14 = false;
        } else if (var14 && var15) {
            this.field_797_bg.func_847_a(new Packet13PlayerLookMove(this.field_611_ak, this.field_601_au.field_1697_b, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar, this.field_9298_aH));
            this.field_12242_bI = 0;
        } else if (var14) {
            this.field_797_bg.func_847_a(new Packet11PlayerPosition(this.field_611_ak, this.field_601_au.field_1697_b, this.field_610_al, this.field_609_am, this.field_9298_aH));
            this.field_12242_bI = 0;
        } else if (var15) {
            this.field_797_bg.func_847_a(new Packet12PlayerLook(this.field_605_aq, this.field_604_ar, this.field_9298_aH));
            this.field_12242_bI = 0;
        } else {
            this.field_797_bg.func_847_a(new Packet10Flying(this.field_9298_aH));
            if (this.field_9382_bF == this.field_9298_aH && this.field_12242_bI <= 200) {
                ++this.field_12242_bI;
            } else {
                this.field_12242_bI = 0;
            }
        }

        this.field_9382_bF = this.field_9298_aH;
        if (var14) {
            this.field_9379_by = this.field_611_ak;
            this.field_9378_bz = this.field_601_au.field_1697_b;
            this.field_9377_bA = this.field_610_al;
            this.field_9376_bB = this.field_609_am;
        }

        if (var15) {
            this.field_9385_bC = this.field_605_aq;
            this.field_9384_bD = this.field_604_ar;
        }

    }

    public void func_20060_w() {
        this.field_797_bg.func_847_a(new Packet14BlockDig(4, 0, 0, 0, 0));
    }

    private void func_9375_Q() {
    }

    protected void func_446_a(EntityItem var1) {
    }

    public void func_461_a(String var1) {
        this.field_797_bg.func_847_a(new Packet3Chat(var1));
    }

    public void func_457_w() {
        super.func_457_w();
        this.field_797_bg.func_847_a(new Packet18Animation(this, 1));
    }

    public void func_9367_r() {
        this.func_9375_Q();
        this.field_797_bg.func_847_a(new Packet9Respawn((byte)this.field_4129_m));
    }

    protected void func_4044_a(int var1) {
        this.field_9337_J -= var1;
    }

    public void func_20059_m() {
        this.field_797_bg.func_847_a(new Packet101CloseWindow(this.field_20068_h.field_1618_c));
        this.field_778_b.func_20076_b((ItemStack)null);
        super.func_20059_m();
    }

    public void func_9372_a_(int var1) {
        if (this.field_21093_bH) {
            super.func_9372_a_(var1);
        } else {
            this.field_9337_J = var1;
            this.field_21093_bH = true;
        }

    }

    public void func_25058_a(StatBase var1, int var2) {
        if (var1 != null) {
            if (var1.field_27088_g) {
                super.func_25058_a(var1, var2);
            }

        }
    }

    public void func_27027_b(StatBase var1, int var2) {
        if (var1 != null) {
            if (!var1.field_27088_g) {
                super.func_25058_a(var1, var2);
            }

        }
    }
}
