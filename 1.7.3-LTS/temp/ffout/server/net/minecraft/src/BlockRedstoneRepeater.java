package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneRepeater extends Block {
    public static final double[] field_22014_a = new double[]{-0.0625D, 0.0625D, 0.1875D, 0.3125D};
    private static final int[] field_22013_b = new int[]{1, 2, 3, 4};
    private final boolean field_22015_c;

    protected BlockRedstoneRepeater(int var1, boolean var2) {
        super(var1, 6, Material.field_513_n);
        this.field_22015_c = var2;
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return !var1.func_445_d(var2, var3 - 1, var4) ? false : super.func_259_a(var1, var2, var3, var4);
    }

    public boolean func_220_f(World var1, int var2, int var3, int var4) {
        return !var1.func_445_d(var2, var3 - 1, var4) ? false : super.func_220_f(var1, var2, var3, var4);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        boolean var7 = this.func_22012_g(var1, var2, var3, var4, var6);
        if (this.field_22015_c && !var7) {
            var1.func_507_b(var2, var3, var4, Block.field_22011_bh.field_573_bc, var6);
        } else if (!this.field_22015_c) {
            var1.func_507_b(var2, var3, var4, Block.field_22010_bi.field_573_bc, var6);
            if (!var7) {
                int var8 = (var6 & 12) >> 2;
                var1.func_22074_c(var2, var3, var4, Block.field_22010_bi.field_573_bc, field_22013_b[var8] * 2);
            }
        }

    }

    public int func_22009_a(int var1, int var2) {
        if (var1 == 0) {
            return this.field_22015_c ? 99 : 115;
        } else if (var1 == 1) {
            return this.field_22015_c ? 147 : 131;
        } else {
            return 5;
        }
    }

    public int func_241_a(int var1) {
        return this.func_22009_a(var1, 0);
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        return this.func_239_b(var1, var2, var3, var4, var5);
    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.field_22015_c) {
            return false;
        } else {
            int var6 = var1.func_446_b(var2, var3, var4) & 3;
            if (var6 == 0 && var5 == 3) {
                return true;
            } else if (var6 == 1 && var5 == 4) {
                return true;
            } else if (var6 == 2 && var5 == 2) {
                return true;
            } else {
                return var6 == 3 && var5 == 5;
            }
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!this.func_220_f(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        } else {
            int var6 = var1.func_446_b(var2, var3, var4);
            boolean var7 = this.func_22012_g(var1, var2, var3, var4, var6);
            int var8 = (var6 & 12) >> 2;
            if (this.field_22015_c && !var7) {
                var1.func_22074_c(var2, var3, var4, this.field_573_bc, field_22013_b[var8] * 2);
            } else if (!this.field_22015_c && var7) {
                var1.func_22074_c(var2, var3, var4, this.field_573_bc, field_22013_b[var8] * 2);
            }

        }
    }

    private boolean func_22012_g(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var5 & 3;
        switch(var6) {
        case 0:
            return var1.func_489_j(var2, var3, var4 + 1, 3) || var1.func_444_a(var2, var3, var4 + 1) == Block.field_591_aw.field_573_bc && var1.func_446_b(var2, var3, var4 + 1) > 0;
        case 1:
            return var1.func_489_j(var2 - 1, var3, var4, 4) || var1.func_444_a(var2 - 1, var3, var4) == Block.field_591_aw.field_573_bc && var1.func_446_b(var2 - 1, var3, var4) > 0;
        case 2:
            return var1.func_489_j(var2, var3, var4 - 1, 2) || var1.func_444_a(var2, var3, var4 - 1) == Block.field_591_aw.field_573_bc && var1.func_446_b(var2, var3, var4 - 1) > 0;
        case 3:
            return var1.func_489_j(var2 + 1, var3, var4, 5) || var1.func_444_a(var2 + 1, var3, var4) == Block.field_591_aw.field_573_bc && var1.func_446_b(var2 + 1, var3, var4) > 0;
        default:
            return false;
        }
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        int var7 = (var6 & 12) >> 2;
        var7 = var7 + 1 << 2 & 12;
        var1.func_511_b(var2, var3, var4, var7 | var6 & 3);
        return true;
    }

    public boolean func_225_d() {
        return false;
    }

    public void func_4027_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = ((MathHelper.func_584_b((double)(var5.field_316_r * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        var1.func_511_b(var2, var3, var4, var6);
        boolean var7 = this.func_22012_g(var1, var2, var3, var4, var6);
        if (var7) {
            var1.func_22074_c(var2, var3, var4, this.field_573_bc, 1);
        }

    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        var1.func_449_g(var2 + 1, var3, var4, this.field_573_bc);
        var1.func_449_g(var2 - 1, var3, var4, this.field_573_bc);
        var1.func_449_g(var2, var3, var4 + 1, this.field_573_bc);
        var1.func_449_g(var2, var3, var4 - 1, this.field_573_bc);
        var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
        var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
    }

    public boolean func_240_b() {
        return false;
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_22007_aZ.field_234_aS;
    }
}
