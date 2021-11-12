package net.minecraft.src;

import java.util.Random;

public class BlockPortal extends BlockBreakable {
    public BlockPortal(int var1, int var2) {
        super(var1, var2, Material.field_4260_x, false);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        float var5;
        float var6;
        if (var1.func_600_a(var2 - 1, var3, var4) != this.field_376_bc && var1.func_600_a(var2 + 1, var3, var4) != this.field_376_bc) {
            var5 = 0.125F;
            var6 = 0.5F;
            this.func_213_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        } else {
            var5 = 0.5F;
            var6 = 0.125F;
            this.func_213_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        }

    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_4032_a_(World var1, int var2, int var3, int var4) {
        byte var5 = 0;
        byte var6 = 0;
        if (var1.func_600_a(var2 - 1, var3, var4) == Block.field_405_aq.field_376_bc || var1.func_600_a(var2 + 1, var3, var4) == Block.field_405_aq.field_376_bc) {
            var5 = 1;
        }

        if (var1.func_600_a(var2, var3, var4 - 1) == Block.field_405_aq.field_376_bc || var1.func_600_a(var2, var3, var4 + 1) == Block.field_405_aq.field_376_bc) {
            var6 = 1;
        }

        if (var5 == var6) {
            return false;
        } else {
            if (var1.func_600_a(var2 - var5, var3, var4 - var6) == 0) {
                var2 -= var5;
                var4 -= var6;
            }

            int var7;
            int var8;
            for(var7 = -1; var7 <= 2; ++var7) {
                for(var8 = -1; var8 <= 3; ++var8) {
                    boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
                    if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                        int var10 = var1.func_600_a(var2 + var5 * var7, var3 + var8, var4 + var6 * var7);
                        if (var9) {
                            if (var10 != Block.field_405_aq.field_376_bc) {
                                return false;
                            }
                        } else if (var10 != 0 && var10 != Block.field_402_as.field_376_bc) {
                            return false;
                        }
                    }
                }
            }

            var1.field_1043_h = true;

            for(var7 = 0; var7 < 2; ++var7) {
                for(var8 = 0; var8 < 3; ++var8) {
                    var1.func_690_d(var2 + var5 * var7, var3 + var8, var4 + var6 * var7, Block.field_4047_bf.field_376_bc);
                }
            }

            var1.field_1043_h = false;
            return true;
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        byte var6 = 0;
        byte var7 = 1;
        if (var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc || var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc) {
            var6 = 1;
            var7 = 0;
        }

        int var8;
        for(var8 = var3; var1.func_600_a(var2, var8 - 1, var4) == this.field_376_bc; --var8) {
        }

        if (var1.func_600_a(var2, var8 - 1, var4) != Block.field_405_aq.field_376_bc) {
            var1.func_690_d(var2, var3, var4, 0);
        } else {
            int var9;
            for(var9 = 1; var9 < 4 && var1.func_600_a(var2, var8 + var9, var4) == this.field_376_bc; ++var9) {
            }

            if (var9 == 3 && var1.func_600_a(var2, var8 + var9, var4) == Block.field_405_aq.field_376_bc) {
                boolean var10 = var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc || var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc;
                boolean var11 = var1.func_600_a(var2, var3, var4 - 1) == this.field_376_bc || var1.func_600_a(var2, var3, var4 + 1) == this.field_376_bc;
                if (var10 && var11) {
                    var1.func_690_d(var2, var3, var4, 0);
                } else if ((var1.func_600_a(var2 + var6, var3, var4 + var7) != Block.field_405_aq.field_376_bc || var1.func_600_a(var2 - var6, var3, var4 - var7) != this.field_376_bc) && (var1.func_600_a(var2 - var6, var3, var4 - var7) != Block.field_405_aq.field_376_bc || var1.func_600_a(var2 + var6, var3, var4 + var7) != this.field_376_bc)) {
                    var1.func_690_d(var2, var3, var4, 0);
                }
            } else {
                var1.func_690_d(var2, var3, var4, 0);
            }
        }
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var1.func_600_a(var2, var3, var4) == this.field_376_bc) {
            return false;
        } else {
            boolean var6 = var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc && var1.func_600_a(var2 - 2, var3, var4) != this.field_376_bc;
            boolean var7 = var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc && var1.func_600_a(var2 + 2, var3, var4) != this.field_376_bc;
            boolean var8 = var1.func_600_a(var2, var3, var4 - 1) == this.field_376_bc && var1.func_600_a(var2, var3, var4 - 2) != this.field_376_bc;
            boolean var9 = var1.func_600_a(var2, var3, var4 + 1) == this.field_376_bc && var1.func_600_a(var2, var3, var4 + 2) != this.field_376_bc;
            boolean var10 = var6 || var7;
            boolean var11 = var8 || var9;
            if (var10 && var5 == 4) {
                return true;
            } else if (var10 && var5 == 5) {
                return true;
            } else if (var11 && var5 == 2) {
                return true;
            } else {
                return var11 && var5 == 3;
            }
        }
    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public int func_234_g() {
        return 1;
    }

    public void func_236_b(World var1, int var2, int var3, int var4, Entity var5) {
        if (var5.field_616_af == null && var5.field_617_ae == null) {
            var5.func_4039_q();
        }

    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(100) == 0) {
            var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "portal.portal", 1.0F, var5.nextFloat() * 0.4F + 0.8F);
        }

        for(int var6 = 0; var6 < 4; ++var6) {
            double var7 = (double)((float)var2 + var5.nextFloat());
            double var9 = (double)((float)var3 + var5.nextFloat());
            double var11 = (double)((float)var4 + var5.nextFloat());
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            int var19 = var5.nextInt(2) * 2 - 1;
            var13 = ((double)var5.nextFloat() - 0.5D) * 0.5D;
            var15 = ((double)var5.nextFloat() - 0.5D) * 0.5D;
            var17 = ((double)var5.nextFloat() - 0.5D) * 0.5D;
            if (var1.func_600_a(var2 - 1, var3, var4) != this.field_376_bc && var1.func_600_a(var2 + 1, var3, var4) != this.field_376_bc) {
                var7 = (double)var2 + 0.5D + 0.25D * (double)var19;
                var13 = (double)(var5.nextFloat() * 2.0F * (float)var19);
            } else {
                var11 = (double)var4 + 0.5D + 0.25D * (double)var19;
                var17 = (double)(var5.nextFloat() * 2.0F * (float)var19);
            }

            var1.func_694_a("portal", var7, var9, var11, var13, var15, var17);
        }

    }
}
