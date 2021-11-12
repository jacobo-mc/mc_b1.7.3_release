package net.minecraft.src;

import java.util.Random;

public class BlockLadder extends Block {
    protected BlockLadder(int var1, int var2) {
        super(var1, var2, Material.field_513_n);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        float var6 = 0.125F;
        if (var5 == 2) {
            this.func_229_a(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 3) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 4) {
            this.func_229_a(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 5) {
            this.func_229_a(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.func_248_d(var1, var2, var3, var4);
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        if (var1.func_445_d(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.func_445_d(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.func_445_d(var2, var3, var4 - 1)) {
            return true;
        } else {
            return var1.func_445_d(var2, var3, var4 + 1);
        }
    }

    public void func_255_c(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        if ((var6 == 0 || var5 == 2) && var1.func_445_d(var2, var3, var4 + 1)) {
            var6 = 2;
        }

        if ((var6 == 0 || var5 == 3) && var1.func_445_d(var2, var3, var4 - 1)) {
            var6 = 3;
        }

        if ((var6 == 0 || var5 == 4) && var1.func_445_d(var2 + 1, var3, var4)) {
            var6 = 4;
        }

        if ((var6 == 0 || var5 == 5) && var1.func_445_d(var2 - 1, var3, var4)) {
            var6 = 5;
        }

        var1.func_511_b(var2, var3, var4, var6);
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        boolean var7 = false;
        if (var6 == 2 && var1.func_445_d(var2, var3, var4 + 1)) {
            var7 = true;
        }

        if (var6 == 3 && var1.func_445_d(var2, var3, var4 - 1)) {
            var7 = true;
        }

        if (var6 == 4 && var1.func_445_d(var2 + 1, var3, var4)) {
            var7 = true;
        }

        if (var6 == 5 && var1.func_445_d(var2 - 1, var3, var4)) {
            var7 = true;
        }

        if (!var7) {
            this.func_247_a_(var1, var2, var3, var4, var6);
            var1.func_508_d(var2, var3, var4, 0);
        }

        super.func_234_b(var1, var2, var3, var4, var5);
    }

    public int func_244_a(Random var1) {
        return 1;
    }
}
