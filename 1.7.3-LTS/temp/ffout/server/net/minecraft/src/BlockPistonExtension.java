package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockPistonExtension extends Block {
    private int field_31046_a = -1;

    public BlockPistonExtension(int var1, int var2) {
        super(var1, var2, Material.field_31062_B);
        this.func_4026_a(field_9025_h);
        this.func_237_c(0.5F);
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        super.func_242_b(var1, var2, var3, var4);
        int var5 = var1.func_446_b(var2, var3, var4);
        int var6 = PistonBlockTextures.field_31052_a[func_31045_b(var5)];
        var2 += PistonBlockTextures.field_31051_b[var6];
        var3 += PistonBlockTextures.field_31054_c[var6];
        var4 += PistonBlockTextures.field_31053_d[var6];
        int var7 = var1.func_444_a(var2, var3, var4);
        if (var7 == Block.field_9029_Z.field_573_bc || var7 == Block.field_9033_V.field_573_bc) {
            var5 = var1.func_446_b(var2, var3, var4);
            if (BlockPistonBase.func_31035_d(var5)) {
                Block.field_542_n[var7].func_247_a_(var1, var2, var3, var4, var5);
                var1.func_508_d(var2, var3, var4, 0);
            }
        }

    }

    public int func_22009_a(int var1, int var2) {
        int var3 = func_31045_b(var2);
        if (var1 == var3) {
            if (this.field_31046_a >= 0) {
                return this.field_31046_a;
            } else {
                return (var2 & 8) != 0 ? this.field_575_bb - 1 : this.field_575_bb;
            }
        } else {
            return var1 == PistonBlockTextures.field_31052_a[var3] ? 107 : 108;
        }
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return false;
    }

    public boolean func_28026_e(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public void func_264_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        int var7 = var1.func_446_b(var2, var3, var4);
        switch(func_31045_b(var7)) {
        case 0:
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            break;
        case 1:
            this.func_229_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            break;
        case 2:
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            break;
        case 3:
            this.func_229_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            break;
        case 4:
            this.func_229_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            break;
        case 5:
            this.func_229_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
        }

        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        switch(func_31045_b(var5)) {
        case 0:
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
        case 1:
            this.func_229_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
        case 2:
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
        case 3:
            this.func_229_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
        case 4:
            this.func_229_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
        case 5:
            this.func_229_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        int var6 = func_31045_b(var1.func_446_b(var2, var3, var4));
        int var7 = var1.func_444_a(var2 - PistonBlockTextures.field_31051_b[var6], var3 - PistonBlockTextures.field_31054_c[var6], var4 - PistonBlockTextures.field_31053_d[var6]);
        if (var7 != Block.field_9029_Z.field_573_bc && var7 != Block.field_9033_V.field_573_bc) {
            var1.func_508_d(var2, var3, var4, 0);
        } else {
            Block.field_542_n[var7].func_234_b(var1, var2 - PistonBlockTextures.field_31051_b[var6], var3 - PistonBlockTextures.field_31054_c[var6], var4 - PistonBlockTextures.field_31053_d[var6], var5);
        }

    }

    public static int func_31045_b(int var0) {
        return var0 & 7;
    }
}
