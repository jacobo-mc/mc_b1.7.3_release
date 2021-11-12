package net.minecraft.src;

import java.util.Random;

public class BlockReed extends Block {
    protected BlockReed(int var1, int var2) {
        super(var1, Material.field_1329_i);
        this.field_378_bb = var2;
        float var3 = 0.375F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
        this.func_253_b(true);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_20084_d(var2, var3 + 1, var4)) {
            int var6;
            for(var6 = 1; var1.func_600_a(var2, var3 - var6, var4) == this.field_376_bc; ++var6) {
            }

            if (var6 < 3) {
                int var7 = var1.func_602_e(var2, var3, var4);
                if (var7 == 15) {
                    var1.func_690_d(var2, var3 + 1, var4, this.field_376_bc);
                    var1.func_691_b(var2, var3, var4, 0);
                } else {
                    var1.func_691_b(var2, var3, var4, var7 + 1);
                }
            }
        }

    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_600_a(var2, var3 - 1, var4);
        if (var5 == this.field_376_bc) {
            return true;
        } else if (var5 != Block.field_337_v.field_376_bc && var5 != Block.field_336_w.field_376_bc) {
            return false;
        } else if (var1.func_599_f(var2 - 1, var3 - 1, var4) == Material.field_1332_f) {
            return true;
        } else if (var1.func_599_f(var2 + 1, var3 - 1, var4) == Material.field_1332_f) {
            return true;
        } else if (var1.func_599_f(var2, var3 - 1, var4 - 1) == Material.field_1332_f) {
            return true;
        } else {
            return var1.func_599_f(var2, var3 - 1, var4 + 1) == Material.field_1332_f;
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        this.func_303_h(var1, var2, var3, var4);
    }

    protected final void func_303_h(World var1, int var2, int var3, int var4) {
        if (!this.func_223_g(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public boolean func_223_g(World var1, int var2, int var3, int var4) {
        return this.func_243_a(var1, var2, var3, var4);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_302_aH.field_291_aS;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 1;
    }
}
