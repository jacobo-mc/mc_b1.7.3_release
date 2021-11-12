package net.minecraft.src;

import java.util.Random;

public class BlockPistonMoving extends BlockContainer {
    public BlockPistonMoving(int var1) {
        super(var1, Material.field_31067_B);
        this.func_222_c(-1.0F);
    }

    protected TileEntity func_283_a_() {
        return null;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        TileEntity var5 = var1.func_603_b(var2, var3, var4);
        if (var5 != null && var5 instanceof TileEntityPiston) {
            ((TileEntityPiston)var5).func_31011_l();
        } else {
            super.func_214_b(var1, var2, var3, var4);
        }

    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return false;
    }

    public boolean func_28030_e(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public int func_210_f() {
        return -1;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (!var1.field_1026_y && var1.func_603_b(var2, var3, var4) == null) {
            var1.func_690_d(var2, var3, var4, 0);
            return true;
        } else {
            return false;
        }
    }

    public int func_240_a(int var1, Random var2) {
        return 0;
    }

    public void func_216_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.field_1026_y) {
            TileEntityPiston var7 = this.func_31034_c(var1, var2, var3, var4);
            if (var7 != null) {
                Block.field_345_n[var7.func_31016_a()].func_259_b_(var1, var2, var3, var4, var7.func_479_f());
            }
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y && var1.func_603_b(var2, var3, var4) == null) {
        }

    }

    public static TileEntity func_31036_a(int var0, int var1, int var2, boolean var3, boolean var4) {
        return new TileEntityPiston(var0, var1, var2, var3, var4);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        TileEntityPiston var5 = this.func_31034_c(var1, var2, var3, var4);
        if (var5 == null) {
            return null;
        } else {
            float var6 = var5.func_31008_a(0.0F);
            if (var5.func_31015_b()) {
                var6 = 1.0F - var6;
            }

            return this.func_31035_a(var1, var2, var3, var4, var5.func_31016_a(), var6, var5.func_31009_d());
        }
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        TileEntityPiston var5 = this.func_31034_c(var1, var2, var3, var4);
        if (var5 != null) {
            Block var6 = Block.field_345_n[var5.func_31016_a()];
            if (var6 == null || var6 == this) {
                return;
            }

            var6.func_238_a(var1, var2, var3, var4);
            float var7 = var5.func_31008_a(0.0F);
            if (var5.func_31015_b()) {
                var7 = 1.0F - var7;
            }

            int var8 = var5.func_31009_d();
            this.field_370_bf = var6.field_370_bf - (double)((float)PistonBlockTextures.field_31056_b[var8] * var7);
            this.field_368_bg = var6.field_368_bg - (double)((float)PistonBlockTextures.field_31059_c[var8] * var7);
            this.field_366_bh = var6.field_366_bh - (double)((float)PistonBlockTextures.field_31058_d[var8] * var7);
            this.field_364_bi = var6.field_364_bi - (double)((float)PistonBlockTextures.field_31056_b[var8] * var7);
            this.field_362_bj = var6.field_362_bj - (double)((float)PistonBlockTextures.field_31059_c[var8] * var7);
            this.field_360_bk = var6.field_360_bk - (double)((float)PistonBlockTextures.field_31058_d[var8] * var7);
        }

    }

    public AxisAlignedBB func_31035_a(World var1, int var2, int var3, int var4, int var5, float var6, int var7) {
        if (var5 != 0 && var5 != this.field_376_bc) {
            AxisAlignedBB var8 = Block.field_345_n[var5].func_221_d(var1, var2, var3, var4);
            if (var8 == null) {
                return null;
            } else {
                var8.field_1698_a -= (double)((float)PistonBlockTextures.field_31056_b[var7] * var6);
                var8.field_1703_d -= (double)((float)PistonBlockTextures.field_31056_b[var7] * var6);
                var8.field_1697_b -= (double)((float)PistonBlockTextures.field_31059_c[var7] * var6);
                var8.field_1702_e -= (double)((float)PistonBlockTextures.field_31059_c[var7] * var6);
                var8.field_1704_c -= (double)((float)PistonBlockTextures.field_31058_d[var7] * var6);
                var8.field_1701_f -= (double)((float)PistonBlockTextures.field_31058_d[var7] * var6);
                return var8;
            }
        } else {
            return null;
        }
    }

    private TileEntityPiston func_31034_c(IBlockAccess var1, int var2, int var3, int var4) {
        TileEntity var5 = var1.func_603_b(var2, var3, var4);
        return var5 != null && var5 instanceof TileEntityPiston ? (TileEntityPiston)var5 : null;
    }
}
