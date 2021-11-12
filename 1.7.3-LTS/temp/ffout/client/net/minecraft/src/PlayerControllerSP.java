package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class PlayerControllerSP extends PlayerController {
    private int field_1074_c = -1;
    private int field_1073_d = -1;
    private int field_1072_e = -1;
    private float field_1071_f = 0.0F;
    private float field_1070_g = 0.0F;
    private float field_1069_h = 0.0F;
    private int field_1068_i = 0;

    public PlayerControllerSP(Minecraft var1) {
        super(var1);
    }

    public void func_6476_a(EntityPlayer var1) {
        var1.field_605_aq = -180.0F;
    }

    public boolean func_729_b(int var1, int var2, int var3, int var4) {
        int var5 = this.field_1065_a.field_6324_e.func_600_a(var1, var2, var3);
        int var6 = this.field_1065_a.field_6324_e.func_602_e(var1, var2, var3);
        boolean var7 = super.func_729_b(var1, var2, var3, var4);
        ItemStack var8 = this.field_1065_a.field_6322_g.func_6416_v();
        boolean var9 = this.field_1065_a.field_6322_g.func_454_b(Block.field_345_n[var5]);
        if (var8 != null) {
            var8.func_25191_a(var5, var1, var2, var3, this.field_1065_a.field_6322_g);
            if (var8.field_1615_a == 0) {
                var8.func_1097_a(this.field_1065_a.field_6322_g);
                this.field_1065_a.field_6322_g.func_448_u();
            }
        }

        if (var7 && var9) {
            Block.field_345_n[var5].func_220_a_(this.field_1065_a.field_6324_e, this.field_1065_a.field_6322_g, var1, var2, var3, var6);
        }

        return var7;
    }

    public void func_719_a(int var1, int var2, int var3, int var4) {
        this.field_1065_a.field_6324_e.func_612_i(this.field_1065_a.field_6322_g, var1, var2, var3, var4);
        int var5 = this.field_1065_a.field_6324_e.func_600_a(var1, var2, var3);
        if (var5 > 0 && this.field_1071_f == 0.0F) {
            Block.field_345_n[var5].func_233_b(this.field_1065_a.field_6324_e, var1, var2, var3, this.field_1065_a.field_6322_g);
        }

        if (var5 > 0 && Block.field_345_n[var5].func_225_a(this.field_1065_a.field_6322_g) >= 1.0F) {
            this.func_729_b(var1, var2, var3, var4);
        }

    }

    public void func_6468_a() {
        this.field_1071_f = 0.0F;
        this.field_1068_i = 0;
    }

    public void func_6470_c(int var1, int var2, int var3, int var4) {
        if (this.field_1068_i > 0) {
            --this.field_1068_i;
        } else {
            if (var1 == this.field_1074_c && var2 == this.field_1073_d && var3 == this.field_1072_e) {
                int var5 = this.field_1065_a.field_6324_e.func_600_a(var1, var2, var3);
                if (var5 == 0) {
                    return;
                }

                Block var6 = Block.field_345_n[var5];
                this.field_1071_f += var6.func_225_a(this.field_1065_a.field_6322_g);
                if (this.field_1069_h % 4.0F == 0.0F && var6 != null) {
                    this.field_1065_a.field_6301_A.func_336_b(var6.field_358_bl.func_1145_d(), (float)var1 + 0.5F, (float)var2 + 0.5F, (float)var3 + 0.5F, (var6.field_358_bl.func_1147_b() + 1.0F) / 8.0F, var6.field_358_bl.func_1144_c() * 0.5F);
                }

                ++this.field_1069_h;
                if (this.field_1071_f >= 1.0F) {
                    this.func_729_b(var1, var2, var3, var4);
                    this.field_1071_f = 0.0F;
                    this.field_1070_g = 0.0F;
                    this.field_1069_h = 0.0F;
                    this.field_1068_i = 5;
                }
            } else {
                this.field_1071_f = 0.0F;
                this.field_1070_g = 0.0F;
                this.field_1069_h = 0.0F;
                this.field_1074_c = var1;
                this.field_1073_d = var2;
                this.field_1072_e = var3;
            }

        }
    }

    public void func_6467_a(float var1) {
        if (this.field_1071_f <= 0.0F) {
            this.field_1065_a.field_6308_u.field_6446_b = 0.0F;
            this.field_1065_a.field_6323_f.field_1450_i = 0.0F;
        } else {
            float var2 = this.field_1070_g + (this.field_1071_f - this.field_1070_g) * var1;
            this.field_1065_a.field_6308_u.field_6446_b = var2;
            this.field_1065_a.field_6323_f.field_1450_i = var2;
        }

    }

    public float func_727_b() {
        return 4.0F;
    }

    public void func_717_a(World var1) {
        super.func_717_a(var1);
    }

    public void func_6474_c() {
        this.field_1070_g = this.field_1071_f;
        this.field_1065_a.field_6301_A.func_4033_c();
    }
}
