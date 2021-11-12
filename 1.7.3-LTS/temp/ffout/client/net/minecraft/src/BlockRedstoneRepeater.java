package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneRepeater extends Block {
    public static final double[] field_22024_a = new double[]{-0.0625D, 0.0625D, 0.1875D, 0.3125D};
    private static final int[] field_22023_b = new int[]{1, 2, 3, 4};
    private final boolean field_22025_c;

    protected BlockRedstoneRepeater(int var1, boolean var2) {
        super(var1, 6, Material.field_1324_n);
        this.field_22025_c = var2;
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return !var1.func_28100_h(var2, var3 - 1, var4) ? false : super.func_243_a(var1, var2, var3, var4);
    }

    public boolean func_223_g(World var1, int var2, int var3, int var4) {
        return !var1.func_28100_h(var2, var3 - 1, var4) ? false : super.func_223_g(var1, var2, var3, var4);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        boolean var7 = this.func_22022_g(var1, var2, var3, var4, var6);
        if (this.field_22025_c && !var7) {
            var1.func_688_b(var2, var3, var4, Block.field_22021_bh.field_376_bc, var6);
        } else if (!this.field_22025_c) {
            var1.func_688_b(var2, var3, var4, Block.field_22020_bi.field_376_bc, var6);
            if (!var7) {
                int var8 = (var6 & 12) >> 2;
                var1.func_22136_c(var2, var3, var4, Block.field_22020_bi.field_376_bc, field_22023_b[var8] * 2);
            }
        }

    }

    public int func_232_a(int var1, int var2) {
        if (var1 == 0) {
            return this.field_22025_c ? 99 : 115;
        } else if (var1 == 1) {
            return this.field_22025_c ? 147 : 131;
        } else {
            return 5;
        }
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var5 != 0 && var5 != 1;
    }

    public int func_210_f() {
        return 15;
    }

    public int func_218_a(int var1) {
        return this.func_232_a(var1, 0);
    }

    public boolean func_228_c(World var1, int var2, int var3, int var4, int var5) {
        return this.func_231_b(var1, var2, var3, var4, var5);
    }

    public boolean func_231_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.field_22025_c) {
            return false;
        } else {
            int var6 = var1.func_602_e(var2, var3, var4) & 3;
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

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!this.func_223_g(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        } else {
            int var6 = var1.func_602_e(var2, var3, var4);
            boolean var7 = this.func_22022_g(var1, var2, var3, var4, var6);
            int var8 = (var6 & 12) >> 2;
            if (this.field_22025_c && !var7) {
                var1.func_22136_c(var2, var3, var4, this.field_376_bc, field_22023_b[var8] * 2);
            } else if (!this.field_22025_c && var7) {
                var1.func_22136_c(var2, var3, var4, this.field_376_bc, field_22023_b[var8] * 2);
            }

        }
    }

    private boolean func_22022_g(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var5 & 3;
        switch(var6) {
        case 0:
            return var1.func_706_k(var2, var3, var4 + 1, 3) || var1.func_600_a(var2, var3, var4 + 1) == Block.field_394_aw.field_376_bc && var1.func_602_e(var2, var3, var4 + 1) > 0;
        case 1:
            return var1.func_706_k(var2 - 1, var3, var4, 4) || var1.func_600_a(var2 - 1, var3, var4) == Block.field_394_aw.field_376_bc && var1.func_602_e(var2 - 1, var3, var4) > 0;
        case 2:
            return var1.func_706_k(var2, var3, var4 - 1, 2) || var1.func_600_a(var2, var3, var4 - 1) == Block.field_394_aw.field_376_bc && var1.func_602_e(var2, var3, var4 - 1) > 0;
        case 3:
            return var1.func_706_k(var2 + 1, var3, var4, 5) || var1.func_600_a(var2 + 1, var3, var4) == Block.field_394_aw.field_376_bc && var1.func_602_e(var2 + 1, var3, var4) > 0;
        default:
            return false;
        }
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        int var7 = (var6 & 12) >> 2;
        var7 = var7 + 1 << 2 & 12;
        var1.func_691_b(var2, var3, var4, var7 | var6 & 3);
        return true;
    }

    public boolean func_209_d() {
        return false;
    }

    public void func_4026_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = ((MathHelper.func_1108_b((double)(var5.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        var1.func_691_b(var2, var3, var4, var6);
        boolean var7 = this.func_22022_g(var1, var2, var3, var4, var6);
        if (var7) {
            var1.func_22136_c(var2, var3, var4, this.field_376_bc, 1);
        }

    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
        var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
        var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
        var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
        var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
        var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
    }

    public boolean func_217_b() {
        return false;
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_22018_aZ.field_291_aS;
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_22025_c) {
            int var6 = var1.func_602_e(var2, var3, var4);
            double var7 = (double)((float)var2 + 0.5F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var9 = (double)((float)var3 + 0.4F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var11 = (double)((float)var4 + 0.5F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var13 = 0.0D;
            double var15 = 0.0D;
            if (var5.nextInt(2) == 0) {
                switch(var6 & 3) {
                case 0:
                    var15 = -0.3125D;
                    break;
                case 1:
                    var13 = 0.3125D;
                    break;
                case 2:
                    var15 = 0.3125D;
                    break;
                case 3:
                    var13 = -0.3125D;
                }
            } else {
                int var17 = (var6 & 12) >> 2;
                switch(var6 & 3) {
                case 0:
                    var15 = field_22024_a[var17];
                    break;
                case 1:
                    var13 = -field_22024_a[var17];
                    break;
                case 2:
                    var15 = -field_22024_a[var17];
                    break;
                case 3:
                    var13 = field_22024_a[var17];
                }
            }

            var1.func_694_a("reddust", var7 + var13, var9, var11 + var15, 0.0D, 0.0D, 0.0D);
        }
    }
}
