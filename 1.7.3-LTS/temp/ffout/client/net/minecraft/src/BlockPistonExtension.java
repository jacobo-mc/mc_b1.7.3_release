package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockPistonExtension extends Block {
    private int field_31053_a = -1;

    public BlockPistonExtension(int var1, int var2) {
        super(var1, var2, Material.field_31067_B);
        this.func_4024_a(field_9251_h);
        this.func_222_c(0.5F);
    }

    public void func_31052_a_(int var1) {
        this.field_31053_a = var1;
    }

    public void func_31051_a() {
        this.field_31053_a = -1;
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        super.func_214_b(var1, var2, var3, var4);
        int var5 = var1.func_602_e(var2, var3, var4);
        int var6 = PistonBlockTextures.field_31057_a[func_31050_c(var5)];
        var2 += PistonBlockTextures.field_31056_b[var6];
        var3 += PistonBlockTextures.field_31059_c[var6];
        var4 += PistonBlockTextures.field_31058_d[var6];
        int var7 = var1.func_600_a(var2, var3, var4);
        if (var7 == Block.field_9255_Z.field_376_bc || var7 == Block.field_9259_V.field_376_bc) {
            var5 = var1.func_602_e(var2, var3, var4);
            if (BlockPistonBase.func_31046_e(var5)) {
                Block.field_345_n[var7].func_259_b_(var1, var2, var3, var4, var5);
                var1.func_690_d(var2, var3, var4, 0);
            }
        }

    }

    public int func_232_a(int var1, int var2) {
        int var3 = func_31050_c(var2);
        if (var1 == var3) {
            if (this.field_31053_a >= 0) {
                return this.field_31053_a;
            } else {
                return (var2 & 8) != 0 ? this.field_378_bb - 1 : this.field_378_bb;
            }
        } else {
            return var1 == PistonBlockTextures.field_31057_a[var3] ? 107 : 108;
        }
    }

    public int func_210_f() {
        return 17;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return false;
    }

    public boolean func_28030_e(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public void func_230_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        int var7 = var1.func_602_e(var2, var3, var4);
        switch(func_31050_c(var7)) {
        case 0:
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            break;
        case 1:
            this.func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            break;
        case 2:
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            break;
        case 3:
            this.func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            break;
        case 4:
            this.func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            break;
        case 5:
            this.func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
        }

        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        switch(func_31050_c(var5)) {
        case 0:
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
        case 1:
            this.func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
        case 2:
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
        case 3:
            this.func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
        case 4:
            this.func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
        case 5:
            this.func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        int var6 = func_31050_c(var1.func_602_e(var2, var3, var4));
        int var7 = var1.func_600_a(var2 - PistonBlockTextures.field_31056_b[var6], var3 - PistonBlockTextures.field_31059_c[var6], var4 - PistonBlockTextures.field_31058_d[var6]);
        if (var7 != Block.field_9255_Z.field_376_bc && var7 != Block.field_9259_V.field_376_bc) {
            var1.func_690_d(var2, var3, var4, 0);
        } else {
            Block.field_345_n[var7].func_226_a(var1, var2 - PistonBlockTextures.field_31056_b[var6], var3 - PistonBlockTextures.field_31059_c[var6], var4 - PistonBlockTextures.field_31058_d[var6], var5);
        }

    }

    public static int func_31050_c(int var0) {
        return var0 & 7;
    }
}
