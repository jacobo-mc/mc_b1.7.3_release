package net.minecraft.src;

import java.util.Random;

public class WorldGenLiquids extends WorldGenerator {
    private int field_4157_a;

    public WorldGenLiquids(int var1) {
        this.field_4157_a = var1;
    }

    public boolean func_516_a(World var1, Random var2, int var3, int var4, int var5) {
        if (var1.func_600_a(var3, var4 + 1, var5) != Block.field_338_u.field_376_bc) {
            return false;
        } else if (var1.func_600_a(var3, var4 - 1, var5) != Block.field_338_u.field_376_bc) {
            return false;
        } else if (var1.func_600_a(var3, var4, var5) != 0 && var1.func_600_a(var3, var4, var5) != Block.field_338_u.field_376_bc) {
            return false;
        } else {
            int var6 = 0;
            if (var1.func_600_a(var3 - 1, var4, var5) == Block.field_338_u.field_376_bc) {
                ++var6;
            }

            if (var1.func_600_a(var3 + 1, var4, var5) == Block.field_338_u.field_376_bc) {
                ++var6;
            }

            if (var1.func_600_a(var3, var4, var5 - 1) == Block.field_338_u.field_376_bc) {
                ++var6;
            }

            if (var1.func_600_a(var3, var4, var5 + 1) == Block.field_338_u.field_376_bc) {
                ++var6;
            }

            int var7 = 0;
            if (var1.func_20084_d(var3 - 1, var4, var5)) {
                ++var7;
            }

            if (var1.func_20084_d(var3 + 1, var4, var5)) {
                ++var7;
            }

            if (var1.func_20084_d(var3, var4, var5 - 1)) {
                ++var7;
            }

            if (var1.func_20084_d(var3, var4, var5 + 1)) {
                ++var7;
            }

            if (var6 == 3 && var7 == 1) {
                var1.func_690_d(var3, var4, var5, this.field_4157_a);
                var1.field_4214_a = true;
                Block.field_345_n[this.field_4157_a].func_208_a(var1, var3, var4, var5, var2);
                var1.field_4214_a = false;
            }

            return true;
        }
    }
}
