package net.minecraft.src;

import java.util.Random;

public class BlockLadder extends Block {
    protected BlockLadder(int var1, int var2) {
        super(var1, var2, Material.field_1324_n);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        float var6 = 0.125F;
        if (var5 == 2) {
            this.func_213_a(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 3) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 4) {
            this.func_213_a(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 5) {
            this.func_213_a(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.func_221_d(var1, var2, var3, var4);
    }

    public AxisAlignedBB func_246_f(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        float var6 = 0.125F;
        if (var5 == 2) {
            this.func_213_a(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 3) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 4) {
            this.func_213_a(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 5) {
            this.func_213_a(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.func_246_f(var1, var2, var3, var4);
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 8;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        if (var1.func_28100_h(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.func_28100_h(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.func_28100_h(var2, var3, var4 - 1)) {
            return true;
        } else {
            return var1.func_28100_h(var2, var3, var4 + 1);
        }
    }

    public void func_258_d(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        if ((var6 == 0 || var5 == 2) && var1.func_28100_h(var2, var3, var4 + 1)) {
            var6 = 2;
        }

        if ((var6 == 0 || var5 == 3) && var1.func_28100_h(var2, var3, var4 - 1)) {
            var6 = 3;
        }

        if ((var6 == 0 || var5 == 4) && var1.func_28100_h(var2 + 1, var3, var4)) {
            var6 = 4;
        }

        if ((var6 == 0 || var5 == 5) && var1.func_28100_h(var2 - 1, var3, var4)) {
            var6 = 5;
        }

        var1.func_691_b(var2, var3, var4, var6);
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        boolean var7 = false;
        if (var6 == 2 && var1.func_28100_h(var2, var3, var4 + 1)) {
            var7 = true;
        }

        if (var6 == 3 && var1.func_28100_h(var2, var3, var4 - 1)) {
            var7 = true;
        }

        if (var6 == 4 && var1.func_28100_h(var2 + 1, var3, var4)) {
            var7 = true;
        }

        if (var6 == 5 && var1.func_28100_h(var2 - 1, var3, var4)) {
            var7 = true;
        }

        if (!var7) {
            this.func_259_b_(var1, var2, var3, var4, var6);
            var1.func_690_d(var2, var3, var4, 0);
        }

        super.func_226_a(var1, var2, var3, var4, var5);
    }

    public int func_229_a(Random var1) {
        return 1;
    }
}
