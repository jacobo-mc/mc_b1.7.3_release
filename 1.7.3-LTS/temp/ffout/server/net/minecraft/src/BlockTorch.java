package net.minecraft.src;

import java.util.Random;

public class BlockTorch extends Block {
    protected BlockTorch(int var1, int var2) {
        super(var1, var2, Material.field_513_n);
        this.func_231_a(true);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    private boolean func_31028_g(World var1, int var2, int var3, int var4) {
        return var1.func_445_d(var2, var3, var4) || var1.func_444_a(var2, var3, var4) == Block.field_9050_aZ.field_573_bc;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        if (var1.func_445_d(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.func_445_d(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.func_445_d(var2, var3, var4 - 1)) {
            return true;
        } else if (var1.func_445_d(var2, var3, var4 + 1)) {
            return true;
        } else {
            return this.func_31028_g(var1, var2, var3 - 1, var4);
        }
    }

    public void func_255_c(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        if (var5 == 1 && this.func_31028_g(var1, var2, var3 - 1, var4)) {
            var6 = 5;
        }

        if (var5 == 2 && var1.func_445_d(var2, var3, var4 + 1)) {
            var6 = 4;
        }

        if (var5 == 3 && var1.func_445_d(var2, var3, var4 - 1)) {
            var6 = 3;
        }

        if (var5 == 4 && var1.func_445_d(var2 + 1, var3, var4)) {
            var6 = 2;
        }

        if (var5 == 5 && var1.func_445_d(var2 - 1, var3, var4)) {
            var6 = 1;
        }

        var1.func_511_b(var2, var3, var4, var6);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        super.func_221_a(var1, var2, var3, var4, var5);
        if (var1.func_446_b(var2, var3, var4) == 0) {
            this.func_250_e(var1, var2, var3, var4);
        }

    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        if (var1.func_445_d(var2 - 1, var3, var4)) {
            var1.func_511_b(var2, var3, var4, 1);
        } else if (var1.func_445_d(var2 + 1, var3, var4)) {
            var1.func_511_b(var2, var3, var4, 2);
        } else if (var1.func_445_d(var2, var3, var4 - 1)) {
            var1.func_511_b(var2, var3, var4, 3);
        } else if (var1.func_445_d(var2, var3, var4 + 1)) {
            var1.func_511_b(var2, var3, var4, 4);
        } else if (this.func_31028_g(var1, var2, var3 - 1, var4)) {
            var1.func_511_b(var2, var3, var4, 5);
        }

        this.func_279_g(var1, var2, var3, var4);
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (this.func_279_g(var1, var2, var3, var4)) {
            int var6 = var1.func_446_b(var2, var3, var4);
            boolean var7 = false;
            if (!var1.func_445_d(var2 - 1, var3, var4) && var6 == 1) {
                var7 = true;
            }

            if (!var1.func_445_d(var2 + 1, var3, var4) && var6 == 2) {
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3, var4 - 1) && var6 == 3) {
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3, var4 + 1) && var6 == 4) {
                var7 = true;
            }

            if (!this.func_31028_g(var1, var2, var3 - 1, var4) && var6 == 5) {
                var7 = true;
            }

            if (var7) {
                this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
                var1.func_508_d(var2, var3, var4, 0);
            }
        }

    }

    private boolean func_279_g(World var1, int var2, int var3, int var4) {
        if (!this.func_259_a(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public MovingObjectPosition func_262_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        int var7 = var1.func_446_b(var2, var3, var4) & 7;
        float var8 = 0.15F;
        if (var7 == 1) {
            this.func_229_a(0.0F, 0.2F, 0.5F - var8, var8 * 2.0F, 0.8F, 0.5F + var8);
        } else if (var7 == 2) {
            this.func_229_a(1.0F - var8 * 2.0F, 0.2F, 0.5F - var8, 1.0F, 0.8F, 0.5F + var8);
        } else if (var7 == 3) {
            this.func_229_a(0.5F - var8, 0.2F, 0.0F, 0.5F + var8, 0.8F, var8 * 2.0F);
        } else if (var7 == 4) {
            this.func_229_a(0.5F - var8, 0.2F, 1.0F - var8 * 2.0F, 0.5F + var8, 0.8F, 1.0F);
        } else {
            var8 = 0.1F;
            this.func_229_a(0.5F - var8, 0.0F, 0.5F - var8, 0.5F + var8, 0.6F, 0.5F + var8);
        }

        return super.func_262_a(var1, var2, var3, var4, var5, var6);
    }
}
