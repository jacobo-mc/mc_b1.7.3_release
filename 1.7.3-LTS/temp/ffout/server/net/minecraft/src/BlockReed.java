package net.minecraft.src;

import java.util.Random;

public class BlockReed extends Block {
    protected BlockReed(int var1, int var2) {
        super(var1, Material.field_518_i);
        this.field_575_bb = var2;
        float var3 = 0.375F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
        this.func_231_a(true);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_20111_e(var2, var3 + 1, var4)) {
            int var6;
            for(var6 = 1; var1.func_444_a(var2, var3 - var6, var4) == this.field_573_bc; ++var6) {
            }

            if (var6 < 3) {
                int var7 = var1.func_446_b(var2, var3, var4);
                if (var7 == 15) {
                    var1.func_508_d(var2, var3 + 1, var4, this.field_573_bc);
                    var1.func_511_b(var2, var3, var4, 0);
                } else {
                    var1.func_511_b(var2, var3, var4, var7 + 1);
                }
            }
        }

    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_444_a(var2, var3 - 1, var4);
        if (var5 == this.field_573_bc) {
            return true;
        } else if (var5 != Block.field_534_v.field_573_bc && var5 != Block.field_533_w.field_573_bc) {
            return false;
        } else if (var1.func_443_c(var2 - 1, var3 - 1, var4) == Material.field_521_f) {
            return true;
        } else if (var1.func_443_c(var2 + 1, var3 - 1, var4) == Material.field_521_f) {
            return true;
        } else if (var1.func_443_c(var2, var3 - 1, var4 - 1) == Material.field_521_f) {
            return true;
        } else {
            return var1.func_443_c(var2, var3 - 1, var4 + 1) == Material.field_521_f;
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        this.func_4037_g(var1, var2, var3, var4);
    }

    protected final void func_4037_g(World var1, int var2, int var3, int var4) {
        if (!this.func_220_f(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

    }

    public boolean func_220_f(World var1, int var2, int var3, int var4) {
        return this.func_259_a(var1, var2, var3, var4);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_4202_aH.field_234_aS;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }
}
