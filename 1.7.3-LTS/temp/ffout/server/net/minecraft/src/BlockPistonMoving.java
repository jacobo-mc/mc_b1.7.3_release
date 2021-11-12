package net.minecraft.src;

import java.util.Random;

public class BlockPistonMoving extends BlockContainer {
    public BlockPistonMoving(int var1) {
        super(var1, Material.field_31062_B);
        this.func_237_c(-1.0F);
    }

    protected TileEntity func_294_a_() {
        return null;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        TileEntity var5 = var1.func_451_k(var2, var3, var4);
        if (var5 != null && var5 instanceof TileEntityPiston) {
            ((TileEntityPiston)var5).func_31011_k();
        } else {
            super.func_242_b(var1, var2, var3, var4);
        }

    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return false;
    }

    public boolean func_28026_e(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (!var1.field_792_x && var1.func_451_k(var2, var3, var4) == null) {
            var1.func_508_d(var2, var3, var4, 0);
            return true;
        } else {
            return false;
        }
    }

    public int func_252_a(int var1, Random var2) {
        return 0;
    }

    public void func_227_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.field_792_x) {
            TileEntityPiston var7 = this.func_31031_b(var1, var2, var3, var4);
            if (var7 != null) {
                Block.field_542_n[var7.func_31012_a()].func_247_a_(var1, var2, var3, var4, var7.func_31005_e());
            }
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_792_x && var1.func_451_k(var2, var3, var4) == null) {
        }

    }

    public static TileEntity func_31030_a(int var0, int var1, int var2, boolean var3, boolean var4) {
        return new TileEntityPiston(var0, var1, var2, var3, var4);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        TileEntityPiston var5 = this.func_31031_b(var1, var2, var3, var4);
        if (var5 == null) {
            return null;
        } else {
            float var6 = var5.func_31007_a(0.0F);
            if (var5.func_31010_c()) {
                var6 = 1.0F - var6;
            }

            return this.func_31032_a(var1, var2, var3, var4, var5.func_31012_a(), var6, var5.func_31008_d());
        }
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        TileEntityPiston var5 = this.func_31031_b(var1, var2, var3, var4);
        if (var5 != null) {
            Block var6 = Block.field_542_n[var5.func_31012_a()];
            if (var6 == null || var6 == this) {
                return;
            }

            var6.func_233_a(var1, var2, var3, var4);
            float var7 = var5.func_31007_a(0.0F);
            if (var5.func_31010_c()) {
                var7 = 1.0F - var7;
            }

            int var8 = var5.func_31008_d();
            this.field_567_bf = var6.field_567_bf - (double)((float)PistonBlockTextures.field_31051_b[var8] * var7);
            this.field_565_bg = var6.field_565_bg - (double)((float)PistonBlockTextures.field_31054_c[var8] * var7);
            this.field_563_bh = var6.field_563_bh - (double)((float)PistonBlockTextures.field_31053_d[var8] * var7);
            this.field_561_bi = var6.field_561_bi - (double)((float)PistonBlockTextures.field_31051_b[var8] * var7);
            this.field_559_bj = var6.field_559_bj - (double)((float)PistonBlockTextures.field_31054_c[var8] * var7);
            this.field_557_bk = var6.field_557_bk - (double)((float)PistonBlockTextures.field_31053_d[var8] * var7);
        }

    }

    public AxisAlignedBB func_31032_a(World var1, int var2, int var3, int var4, int var5, float var6, int var7) {
        if (var5 != 0 && var5 != this.field_573_bc) {
            AxisAlignedBB var8 = Block.field_542_n[var5].func_248_d(var1, var2, var3, var4);
            if (var8 == null) {
                return null;
            } else {
                var8.field_964_a -= (double)((float)PistonBlockTextures.field_31051_b[var7] * var6);
                var8.field_969_d -= (double)((float)PistonBlockTextures.field_31051_b[var7] * var6);
                var8.field_963_b -= (double)((float)PistonBlockTextures.field_31054_c[var7] * var6);
                var8.field_968_e -= (double)((float)PistonBlockTextures.field_31054_c[var7] * var6);
                var8.field_970_c -= (double)((float)PistonBlockTextures.field_31053_d[var7] * var6);
                var8.field_967_f -= (double)((float)PistonBlockTextures.field_31053_d[var7] * var6);
                return var8;
            }
        } else {
            return null;
        }
    }

    private TileEntityPiston func_31031_b(IBlockAccess var1, int var2, int var3, int var4) {
        TileEntity var5 = var1.func_451_k(var2, var3, var4);
        return var5 != null && var5 instanceof TileEntityPiston ? (TileEntityPiston)var5 : null;
    }
}
