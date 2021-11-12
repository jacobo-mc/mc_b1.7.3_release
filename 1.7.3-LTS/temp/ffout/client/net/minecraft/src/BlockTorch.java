package net.minecraft.src;

import java.util.Random;

public class BlockTorch extends Block {
    protected BlockTorch(int var1, int var2) {
        super(var1, var2, Material.field_1324_n);
        this.func_253_b(true);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 2;
    }

    private boolean func_31032_h(World var1, int var2, int var3, int var4) {
        return var1.func_28100_h(var2, var3, var4) || var1.func_600_a(var2, var3, var4) == Block.field_4057_ba.field_376_bc;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        if (var1.func_28100_h(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.func_28100_h(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.func_28100_h(var2, var3, var4 - 1)) {
            return true;
        } else if (var1.func_28100_h(var2, var3, var4 + 1)) {
            return true;
        } else {
            return this.func_31032_h(var1, var2, var3 - 1, var4);
        }
    }

    public void func_258_d(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        if (var5 == 1 && this.func_31032_h(var1, var2, var3 - 1, var4)) {
            var6 = 5;
        }

        if (var5 == 2 && var1.func_28100_h(var2, var3, var4 + 1)) {
            var6 = 4;
        }

        if (var5 == 3 && var1.func_28100_h(var2, var3, var4 - 1)) {
            var6 = 3;
        }

        if (var5 == 4 && var1.func_28100_h(var2 + 1, var3, var4)) {
            var6 = 2;
        }

        if (var5 == 5 && var1.func_28100_h(var2 - 1, var3, var4)) {
            var6 = 1;
        }

        var1.func_691_b(var2, var3, var4, var6);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        super.func_208_a(var1, var2, var3, var4, var5);
        if (var1.func_602_e(var2, var3, var4) == 0) {
            this.func_235_e(var1, var2, var3, var4);
        }

    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        if (var1.func_28100_h(var2 - 1, var3, var4)) {
            var1.func_691_b(var2, var3, var4, 1);
        } else if (var1.func_28100_h(var2 + 1, var3, var4)) {
            var1.func_691_b(var2, var3, var4, 2);
        } else if (var1.func_28100_h(var2, var3, var4 - 1)) {
            var1.func_691_b(var2, var3, var4, 3);
        } else if (var1.func_28100_h(var2, var3, var4 + 1)) {
            var1.func_691_b(var2, var3, var4, 4);
        } else if (this.func_31032_h(var1, var2, var3 - 1, var4)) {
            var1.func_691_b(var2, var3, var4, 5);
        }

        this.func_271_h(var1, var2, var3, var4);
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (this.func_271_h(var1, var2, var3, var4)) {
            int var6 = var1.func_602_e(var2, var3, var4);
            boolean var7 = false;
            if (!var1.func_28100_h(var2 - 1, var3, var4) && var6 == 1) {
                var7 = true;
            }

            if (!var1.func_28100_h(var2 + 1, var3, var4) && var6 == 2) {
                var7 = true;
            }

            if (!var1.func_28100_h(var2, var3, var4 - 1) && var6 == 3) {
                var7 = true;
            }

            if (!var1.func_28100_h(var2, var3, var4 + 1) && var6 == 4) {
                var7 = true;
            }

            if (!this.func_31032_h(var1, var2, var3 - 1, var4) && var6 == 5) {
                var7 = true;
            }

            if (var7) {
                this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
                var1.func_690_d(var2, var3, var4, 0);
            }
        }

    }

    private boolean func_271_h(World var1, int var2, int var3, int var4) {
        if (!this.func_243_a(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public MovingObjectPosition func_255_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        int var7 = var1.func_602_e(var2, var3, var4) & 7;
        float var8 = 0.15F;
        if (var7 == 1) {
            this.func_213_a(0.0F, 0.2F, 0.5F - var8, var8 * 2.0F, 0.8F, 0.5F + var8);
        } else if (var7 == 2) {
            this.func_213_a(1.0F - var8 * 2.0F, 0.2F, 0.5F - var8, 1.0F, 0.8F, 0.5F + var8);
        } else if (var7 == 3) {
            this.func_213_a(0.5F - var8, 0.2F, 0.0F, 0.5F + var8, 0.8F, var8 * 2.0F);
        } else if (var7 == 4) {
            this.func_213_a(0.5F - var8, 0.2F, 1.0F - var8 * 2.0F, 0.5F + var8, 0.8F, 1.0F);
        } else {
            var8 = 0.1F;
            this.func_213_a(0.5F - var8, 0.0F, 0.5F - var8, 0.5F + var8, 0.6F, 0.5F + var8);
        }

        return super.func_255_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        double var7 = (double)((float)var2 + 0.5F);
        double var9 = (double)((float)var3 + 0.7F);
        double var11 = (double)((float)var4 + 0.5F);
        double var13 = 0.2199999988079071D;
        double var15 = 0.27000001072883606D;
        if (var6 == 1) {
            var1.func_694_a("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            var1.func_694_a("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 2) {
            var1.func_694_a("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            var1.func_694_a("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 3) {
            var1.func_694_a("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
            var1.func_694_a("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 4) {
            var1.func_694_a("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
            var1.func_694_a("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
        } else {
            var1.func_694_a("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
            var1.func_694_a("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
        }

    }
}
