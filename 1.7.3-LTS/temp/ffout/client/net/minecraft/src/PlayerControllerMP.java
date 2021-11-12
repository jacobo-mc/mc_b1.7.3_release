package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class PlayerControllerMP extends PlayerController {
    private int field_9445_c = -1;
    private int field_9444_d = -1;
    private int field_9443_e = -1;
    private float field_9442_f = 0.0F;
    private float field_1080_g = 0.0F;
    private float field_9441_h = 0.0F;
    private int field_9440_i = 0;
    private boolean field_9439_j = false;
    private NetClientHandler field_9438_k;
    private int field_1075_l = 0;

    public PlayerControllerMP(Minecraft var1, NetClientHandler var2) {
        super(var1);
        this.field_9438_k = var2;
    }

    public void func_6476_a(EntityPlayer var1) {
        var1.field_605_aq = -180.0F;
    }

    public boolean func_729_b(int var1, int var2, int var3, int var4) {
        int var5 = this.field_1065_a.field_6324_e.func_600_a(var1, var2, var3);
        boolean var6 = super.func_729_b(var1, var2, var3, var4);
        ItemStack var7 = this.field_1065_a.field_6322_g.func_6416_v();
        if (var7 != null) {
            var7.func_25191_a(var5, var1, var2, var3, this.field_1065_a.field_6322_g);
            if (var7.field_1615_a == 0) {
                var7.func_1097_a(this.field_1065_a.field_6322_g);
                this.field_1065_a.field_6322_g.func_448_u();
            }
        }

        return var6;
    }

    public void func_719_a(int var1, int var2, int var3, int var4) {
        if (!this.field_9439_j || var1 != this.field_9445_c || var2 != this.field_9444_d || var3 != this.field_9443_e) {
            this.field_9438_k.func_847_a(new Packet14BlockDig(0, var1, var2, var3, var4));
            int var5 = this.field_1065_a.field_6324_e.func_600_a(var1, var2, var3);
            if (var5 > 0 && this.field_9442_f == 0.0F) {
                Block.field_345_n[var5].func_233_b(this.field_1065_a.field_6324_e, var1, var2, var3, this.field_1065_a.field_6322_g);
            }

            if (var5 > 0 && Block.field_345_n[var5].func_225_a(this.field_1065_a.field_6322_g) >= 1.0F) {
                this.func_729_b(var1, var2, var3, var4);
            } else {
                this.field_9439_j = true;
                this.field_9445_c = var1;
                this.field_9444_d = var2;
                this.field_9443_e = var3;
                this.field_9442_f = 0.0F;
                this.field_1080_g = 0.0F;
                this.field_9441_h = 0.0F;
            }
        }

    }

    public void func_6468_a() {
        this.field_9442_f = 0.0F;
        this.field_9439_j = false;
    }

    public void func_6470_c(int var1, int var2, int var3, int var4) {
        if (this.field_9439_j) {
            this.func_730_e();
            if (this.field_9440_i > 0) {
                --this.field_9440_i;
            } else {
                if (var1 == this.field_9445_c && var2 == this.field_9444_d && var3 == this.field_9443_e) {
                    int var5 = this.field_1065_a.field_6324_e.func_600_a(var1, var2, var3);
                    if (var5 == 0) {
                        this.field_9439_j = false;
                        return;
                    }

                    Block var6 = Block.field_345_n[var5];
                    this.field_9442_f += var6.func_225_a(this.field_1065_a.field_6322_g);
                    if (this.field_9441_h % 4.0F == 0.0F && var6 != null) {
                        this.field_1065_a.field_6301_A.func_336_b(var6.field_358_bl.func_1145_d(), (float)var1 + 0.5F, (float)var2 + 0.5F, (float)var3 + 0.5F, (var6.field_358_bl.func_1147_b() + 1.0F) / 8.0F, var6.field_358_bl.func_1144_c() * 0.5F);
                    }

                    ++this.field_9441_h;
                    if (this.field_9442_f >= 1.0F) {
                        this.field_9439_j = false;
                        this.field_9438_k.func_847_a(new Packet14BlockDig(2, var1, var2, var3, var4));
                        this.func_729_b(var1, var2, var3, var4);
                        this.field_9442_f = 0.0F;
                        this.field_1080_g = 0.0F;
                        this.field_9441_h = 0.0F;
                        this.field_9440_i = 5;
                    }
                } else {
                    this.func_719_a(var1, var2, var3, var4);
                }

            }
        }
    }

    public void func_6467_a(float var1) {
        if (this.field_9442_f <= 0.0F) {
            this.field_1065_a.field_6308_u.field_6446_b = 0.0F;
            this.field_1065_a.field_6323_f.field_1450_i = 0.0F;
        } else {
            float var2 = this.field_1080_g + (this.field_9442_f - this.field_1080_g) * var1;
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
        this.func_730_e();
        this.field_1080_g = this.field_9442_f;
        this.field_1065_a.field_6301_A.func_4033_c();
    }

    private void func_730_e() {
        int var1 = this.field_1065_a.field_6322_g.field_778_b.field_847_d;
        if (var1 != this.field_1075_l) {
            this.field_1075_l = var1;
            this.field_9438_k.func_847_a(new Packet16BlockItemSwitch(this.field_1075_l));
        }

    }

    public boolean func_722_a(EntityPlayer var1, World var2, ItemStack var3, int var4, int var5, int var6, int var7) {
        this.func_730_e();
        this.field_9438_k.func_847_a(new Packet15Place(var4, var5, var6, var7, var1.field_778_b.func_494_a()));
        boolean var8 = super.func_722_a(var1, var2, var3, var4, var5, var6, var7);
        return var8;
    }

    public boolean func_6471_a(EntityPlayer var1, World var2, ItemStack var3) {
        this.func_730_e();
        this.field_9438_k.func_847_a(new Packet15Place(-1, -1, -1, 255, var1.field_778_b.func_494_a()));
        boolean var4 = super.func_6471_a(var1, var2, var3);
        return var4;
    }

    public EntityPlayer func_4087_b(World var1) {
        return new EntityClientPlayerMP(this.field_1065_a, var1, this.field_1065_a.field_6320_i, this.field_9438_k);
    }

    public void func_6472_b(EntityPlayer var1, Entity var2) {
        this.func_730_e();
        this.field_9438_k.func_847_a(new Packet7UseEntity(var1.field_620_ab, var2.field_620_ab, 1));
        var1.func_463_a(var2);
    }

    public void func_6475_a(EntityPlayer var1, Entity var2) {
        this.func_730_e();
        this.field_9438_k.func_847_a(new Packet7UseEntity(var1.field_620_ab, var2.field_620_ab, 0));
        var1.func_6415_a_(var2);
    }

    public ItemStack func_27174_a(int var1, int var2, int var3, boolean var4, EntityPlayer var5) {
        short var6 = var5.field_20068_h.func_20111_a(var5.field_778_b);
        ItemStack var7 = super.func_27174_a(var1, var2, var3, var4, var5);
        this.field_9438_k.func_847_a(new Packet102WindowClick(var1, var2, var3, var4, var7, var6));
        return var7;
    }

    public void func_20086_a(int var1, EntityPlayer var2) {
        if (var1 != -9999) {
            ;
        }
    }
}
