package net.minecraft.src;

import java.util.Random;

public class BlockPortal extends BlockBreakable {
    public BlockPortal(int var1, int var2) {
        super(var1, var2, Material.field_4212_x, false);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        float var5;
        float var6;
        if (var1.func_444_a(var2 - 1, var3, var4) != this.field_573_bc && var1.func_444_a(var2 + 1, var3, var4) != this.field_573_bc) {
            var5 = 0.125F;
            var6 = 0.5F;
            this.func_229_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        } else {
            var5 = 0.5F;
            var6 = 0.125F;
            this.func_229_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        }

    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_4030_a_(World var1, int var2, int var3, int var4) {
        byte var5 = 0;
        byte var6 = 0;
        if (var1.func_444_a(var2 - 1, var3, var4) == Block.field_602_aq.field_573_bc || var1.func_444_a(var2 + 1, var3, var4) == Block.field_602_aq.field_573_bc) {
            var5 = 1;
        }

        if (var1.func_444_a(var2, var3, var4 - 1) == Block.field_602_aq.field_573_bc || var1.func_444_a(var2, var3, var4 + 1) == Block.field_602_aq.field_573_bc) {
            var6 = 1;
        }

        if (var5 == var6) {
            return false;
        } else {
            if (var1.func_444_a(var2 - var5, var3, var4 - var6) == 0) {
                var2 -= var5;
                var4 -= var6;
            }

            int var7;
            int var8;
            for(var7 = -1; var7 <= 2; ++var7) {
                for(var8 = -1; var8 <= 3; ++var8) {
                    boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
                    if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                        int var10 = var1.func_444_a(var2 + var5 * var7, var3 + var8, var4 + var6 * var7);
                        if (var9) {
                            if (var10 != Block.field_602_aq.field_573_bc) {
                                return false;
                            }
                        } else if (var10 != 0 && var10 != Block.field_599_as.field_573_bc) {
                            return false;
                        }
                    }
                }
            }

            var1.field_808_h = true;

            for(var7 = 0; var7 < 2; ++var7) {
                for(var8 = 0; var8 < 3; ++var8) {
                    var1.func_508_d(var2 + var5 * var7, var3 + var8, var4 + var6 * var7, Block.field_4044_bf.field_573_bc);
                }
            }

            var1.field_808_h = false;
            return true;
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        byte var6 = 0;
        byte var7 = 1;
        if (var1.func_444_a(var2 - 1, var3, var4) == this.field_573_bc || var1.func_444_a(var2 + 1, var3, var4) == this.field_573_bc) {
            var6 = 1;
            var7 = 0;
        }

        int var8;
        for(var8 = var3; var1.func_444_a(var2, var8 - 1, var4) == this.field_573_bc; --var8) {
        }

        if (var1.func_444_a(var2, var8 - 1, var4) != Block.field_602_aq.field_573_bc) {
            var1.func_508_d(var2, var3, var4, 0);
        } else {
            int var9;
            for(var9 = 1; var9 < 4 && var1.func_444_a(var2, var8 + var9, var4) == this.field_573_bc; ++var9) {
            }

            if (var9 == 3 && var1.func_444_a(var2, var8 + var9, var4) == Block.field_602_aq.field_573_bc) {
                boolean var10 = var1.func_444_a(var2 - 1, var3, var4) == this.field_573_bc || var1.func_444_a(var2 + 1, var3, var4) == this.field_573_bc;
                boolean var11 = var1.func_444_a(var2, var3, var4 - 1) == this.field_573_bc || var1.func_444_a(var2, var3, var4 + 1) == this.field_573_bc;
                if (var10 && var11) {
                    var1.func_508_d(var2, var3, var4, 0);
                } else if ((var1.func_444_a(var2 + var6, var3, var4 + var7) != Block.field_602_aq.field_573_bc || var1.func_444_a(var2 - var6, var3, var4 - var7) != this.field_573_bc) && (var1.func_444_a(var2 - var6, var3, var4 - var7) != Block.field_602_aq.field_573_bc || var1.func_444_a(var2 + var6, var3, var4 + var7) != this.field_573_bc)) {
                    var1.func_508_d(var2, var3, var4, 0);
                }
            } else {
                var1.func_508_d(var2, var3, var4, 0);
            }
        }
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public void func_263_a(World var1, int var2, int var3, int var4, Entity var5) {
        if (var5.field_327_g == null && var5.field_328_f == null) {
            var5.func_4042_C();
        }

    }
}
