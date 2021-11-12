package net.minecraft.src;

import java.util.Random;

public class BlockFarmland extends Block {
    protected BlockFarmland(int var1) {
        super(var1, Material.field_525_b);
        this.field_575_bb = 87;
        this.func_231_a(true);
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.func_258_c(255);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_693_b((double)(var2 + 0), (double)(var3 + 0), (double)(var4 + 0), (double)(var2 + 1), (double)(var3 + 1), (double)(var4 + 1));
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public int func_22009_a(int var1, int var2) {
        if (var1 == 1 && var2 > 0) {
            return this.field_575_bb - 1;
        } else {
            return var1 == 1 ? this.field_575_bb : 2;
        }
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(5) == 0) {
            if (!this.func_283_h(var1, var2, var3, var4) && !var1.func_27072_q(var2, var3 + 1, var4)) {
                int var6 = var1.func_446_b(var2, var3, var4);
                if (var6 > 0) {
                    var1.func_511_b(var2, var3, var4, var6 - 1);
                } else if (!this.func_282_g(var1, var2, var3, var4)) {
                    var1.func_508_d(var2, var3, var4, Block.field_533_w.field_573_bc);
                }
            } else {
                var1.func_511_b(var2, var3, var4, 7);
            }
        }

    }

    public void func_249_b(World var1, int var2, int var3, int var4, Entity var5) {
        if (var1.field_803_m.nextInt(4) == 0) {
            var1.func_508_d(var2, var3, var4, Block.field_533_w.field_573_bc);
        }

    }

    private boolean func_282_g(World var1, int var2, int var3, int var4) {
        byte var5 = 0;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var4 - var5; var7 <= var4 + var5; ++var7) {
                if (var1.func_444_a(var6, var3 + 1, var7) == Block.field_644_aA.field_573_bc) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_283_h(World var1, int var2, int var3, int var4) {
        for(int var5 = var2 - 4; var5 <= var2 + 4; ++var5) {
            for(int var6 = var3; var6 <= var3 + 1; ++var6) {
                for(int var7 = var4 - 4; var7 <= var4 + 4; ++var7) {
                    if (var1.func_443_c(var5, var6, var7) == Material.field_521_f) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        super.func_234_b(var1, var2, var3, var4, var5);
        Material var6 = var1.func_443_c(var2, var3 + 1, var4);
        if (var6.func_216_a()) {
            var1.func_508_d(var2, var3, var4, Block.field_533_w.field_573_bc);
        }

    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_533_w.func_252_a(0, var2);
    }
}
