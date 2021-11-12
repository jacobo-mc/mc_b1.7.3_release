package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class PlayerController {
    protected final Minecraft field_1065_a;
    public boolean field_1064_b = false;

    public PlayerController(Minecraft var1) {
        this.field_1065_a = var1;
    }

    public void func_717_a(World var1) {
    }

    public void func_719_a(int var1, int var2, int var3, int var4) {
        this.field_1065_a.field_6324_e.func_612_i(this.field_1065_a.field_6322_g, var1, var2, var3, var4);
        this.func_729_b(var1, var2, var3, var4);
    }

    public boolean func_729_b(int var1, int var2, int var3, int var4) {
        World var5 = this.field_1065_a.field_6324_e;
        Block var6 = Block.field_345_n[var5.func_600_a(var1, var2, var3)];
        var5.func_28106_e(2001, var1, var2, var3, var6.field_376_bc + var5.func_602_e(var1, var2, var3) * 256);
        int var7 = var5.func_602_e(var1, var2, var3);
        boolean var8 = var5.func_690_d(var1, var2, var3, 0);
        if (var6 != null && var8) {
            var6.func_252_b(var5, var1, var2, var3, var7);
        }

        return var8;
    }

    public void func_6470_c(int var1, int var2, int var3, int var4) {
    }

    public void func_6468_a() {
    }

    public void func_6467_a(float var1) {
    }

    public float func_727_b() {
        return 5.0F;
    }

    public boolean func_6471_a(EntityPlayer var1, World var2, ItemStack var3) {
        int var4 = var3.field_1615_a;
        ItemStack var5 = var3.func_1093_a(var2, var1);
        if (var5 != var3 || var5 != null && var5.field_1615_a != var4) {
            var1.field_778_b.field_843_a[var1.field_778_b.field_847_d] = var5;
            if (var5.field_1615_a == 0) {
                var1.field_778_b.field_843_a[var1.field_778_b.field_847_d] = null;
            }

            return true;
        } else {
            return false;
        }
    }

    public void func_6476_a(EntityPlayer var1) {
    }

    public void func_6474_c() {
    }

    public boolean func_6469_d() {
        return true;
    }

    public void func_6473_b(EntityPlayer var1) {
    }

    public boolean func_722_a(EntityPlayer var1, World var2, ItemStack var3, int var4, int var5, int var6, int var7) {
        int var8 = var2.func_600_a(var4, var5, var6);
        if (var8 > 0 && Block.field_345_n[var8].func_250_a(var2, var4, var5, var6, var1)) {
            return true;
        } else {
            return var3 == null ? false : var3.func_1090_a(var1, var2, var4, var5, var6, var7);
        }
    }

    public EntityPlayer func_4087_b(World var1) {
        return new EntityPlayerSP(this.field_1065_a, var1, this.field_1065_a.field_6320_i, var1.field_4209_q.field_4218_e);
    }

    public void func_6475_a(EntityPlayer var1, Entity var2) {
        var1.func_6415_a_(var2);
    }

    public void func_6472_b(EntityPlayer var1, Entity var2) {
        var1.func_463_a(var2);
    }

    public ItemStack func_27174_a(int var1, int var2, int var3, boolean var4, EntityPlayer var5) {
        return var5.field_20068_h.func_27280_a(var2, var3, var4, var5);
    }

    public void func_20086_a(int var1, EntityPlayer var2) {
        var2.field_20068_h.func_1104_a(var2);
        var2.field_20068_h = var2.field_20069_g;
    }
}
