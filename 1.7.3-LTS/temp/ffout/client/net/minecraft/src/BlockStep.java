package net.minecraft.src;

import java.util.Random;

public class BlockStep extends Block {
    public static final String[] field_22037_a = new String[]{"stone", "sand", "wood", "cobble"};
    private boolean field_20922_a;

    public BlockStep(int var1, boolean var2) {
        super(var1, 6, Material.field_1334_d);
        this.field_20922_a = var2;
        if (!var2) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        this.func_256_d(255);
    }

    public int func_232_a(int var1, int var2) {
        if (var2 == 0) {
            return var1 <= 1 ? 6 : 5;
        } else if (var2 == 1) {
            if (var1 == 0) {
                return 208;
            } else {
                return var1 == 1 ? 176 : 192;
            }
        } else if (var2 == 2) {
            return 4;
        } else {
            return var2 == 3 ? 16 : 6;
        }
    }

    public int func_218_a(int var1) {
        return this.func_232_a(var1, 0);
    }

    public boolean func_217_b() {
        return this.field_20922_a;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        if (this != Block.field_410_al) {
            super.func_235_e(var1, var2, var3, var4);
        }

        int var5 = var1.func_600_a(var2, var3 - 1, var4);
        int var6 = var1.func_602_e(var2, var3, var4);
        int var7 = var1.func_602_e(var2, var3 - 1, var4);
        if (var6 == var7) {
            if (var5 == field_410_al.field_376_bc) {
                var1.func_690_d(var2, var3, var4, 0);
                var1.func_688_b(var2, var3 - 1, var4, Block.field_411_ak.field_376_bc, var6);
            }

        }
    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_410_al.field_376_bc;
    }

    public int func_229_a(Random var1) {
        return this.field_20922_a ? 2 : 1;
    }

    protected int func_21025_b(int var1) {
        return var1;
    }

    public boolean func_242_c() {
        return this.field_20922_a;
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (this != Block.field_410_al) {
            super.func_260_c(var1, var2, var3, var4, var5);
        }

        if (var5 == 1) {
            return true;
        } else if (!super.func_260_c(var1, var2, var3, var4, var5)) {
            return false;
        } else if (var5 == 0) {
            return true;
        } else {
            return var1.func_600_a(var2, var3, var4) != this.field_376_bc;
        }
    }
}
