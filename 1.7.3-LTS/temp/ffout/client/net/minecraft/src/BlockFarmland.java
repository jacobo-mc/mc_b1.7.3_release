package net.minecraft.src;

import java.util.Random;

public class BlockFarmland extends Block {
    protected BlockFarmland(int var1) {
        super(var1, Material.field_1336_b);
        this.field_378_bb = 87;
        this.func_253_b(true);
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.func_256_d(255);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_1161_b((double)(var2 + 0), (double)(var3 + 0), (double)(var4 + 0), (double)(var2 + 1), (double)(var3 + 1), (double)(var4 + 1));
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_232_a(int var1, int var2) {
        if (var1 == 1 && var2 > 0) {
            return this.field_378_bb - 1;
        } else {
            return var1 == 1 ? this.field_378_bb : 2;
        }
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(5) == 0) {
            if (!this.func_274_i(var1, var2, var3, var4) && !var1.func_27167_r(var2, var3 + 1, var4)) {
                int var6 = var1.func_602_e(var2, var3, var4);
                if (var6 > 0) {
                    var1.func_691_b(var2, var3, var4, var6 - 1);
                } else if (!this.func_275_h(var1, var2, var3, var4)) {
                    var1.func_690_d(var2, var3, var4, Block.field_336_w.field_376_bc);
                }
            } else {
                var1.func_691_b(var2, var3, var4, 7);
            }
        }

    }

    public void func_254_a(World var1, int var2, int var3, int var4, Entity var5) {
        if (var1.field_1037_n.nextInt(4) == 0) {
            var1.func_690_d(var2, var3, var4, Block.field_336_w.field_376_bc);
        }

    }

    private boolean func_275_h(World var1, int var2, int var3, int var4) {
        byte var5 = 0;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var4 - var5; var7 <= var4 + var5; ++var7) {
                if (var1.func_600_a(var6, var3 + 1, var7) == Block.field_447_aA.field_376_bc) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_274_i(World var1, int var2, int var3, int var4) {
        for(int var5 = var2 - 4; var5 <= var2 + 4; ++var5) {
            for(int var6 = var3; var6 <= var3 + 1; ++var6) {
                for(int var7 = var4 - 4; var7 <= var4 + 4; ++var7) {
                    if (var1.func_599_f(var5, var6, var7) == Material.field_1332_f) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        super.func_226_a(var1, var2, var3, var4, var5);
        Material var6 = var1.func_599_f(var2, var3 + 1, var4);
        if (var6.func_878_a()) {
            var1.func_690_d(var2, var3, var4, Block.field_336_w.field_376_bc);
        }

    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_336_w.func_240_a(0, var2);
    }
}
