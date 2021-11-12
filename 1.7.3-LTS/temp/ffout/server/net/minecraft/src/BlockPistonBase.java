package net.minecraft.src;

import java.util.ArrayList;

public class BlockPistonBase extends Block {
    private boolean field_31044_a;
    private boolean field_31043_b;

    public BlockPistonBase(int var1, int var2, boolean var3) {
        super(var1, var2, Material.field_31062_B);
        this.field_31044_a = var3;
        this.func_4026_a(field_9025_h);
        this.func_237_c(0.5F);
    }

    public int func_22009_a(int var1, int var2) {
        int var3 = func_31042_c(var2);
        if (var3 > 5) {
            return this.field_575_bb;
        } else if (var1 == var3) {
            return !func_31035_d(var2) && this.field_567_bf <= 0.0D && this.field_565_bg <= 0.0D && this.field_563_bh <= 0.0D && this.field_561_bi >= 1.0D && this.field_559_bj >= 1.0D && this.field_557_bk >= 1.0D ? this.field_575_bb : 110;
        } else {
            return var1 == PistonBlockTextures.field_31052_a[var3] ? 109 : 108;
        }
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return false;
    }

    public void func_4027_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = func_31037_c(var1, var2, var3, var4, (EntityPlayer)var5);
        var1.func_511_b(var2, var3, var4, var6);
        if (!var1.field_792_x) {
            this.func_31041_g(var1, var2, var3, var4);
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_792_x && !this.field_31043_b) {
            this.func_31041_g(var1, var2, var3, var4);
        }

    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        if (!var1.field_792_x && var1.func_451_k(var2, var3, var4) == null) {
            this.func_31041_g(var1, var2, var3, var4);
        }

    }

    private void func_31041_g(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        int var6 = func_31042_c(var5);
        boolean var7 = this.func_31039_f(var1, var2, var3, var4, var6);
        if (var5 != 7) {
            if (var7 && !func_31035_d(var5)) {
                if (func_31036_h(var1, var2, var3, var4, var6)) {
                    var1.func_463_c(var2, var3, var4, var6 | 8);
                    var1.func_21117_c(var2, var3, var4, 0, var6);
                }
            } else if (!var7 && func_31035_d(var5)) {
                var1.func_463_c(var2, var3, var4, var6);
                var1.func_21117_c(var2, var3, var4, 1, var6);
            }

        }
    }

    private boolean func_31039_f(World var1, int var2, int var3, int var4, int var5) {
        if (var5 != 0 && var1.func_489_j(var2, var3 - 1, var4, 0)) {
            return true;
        } else if (var5 != 1 && var1.func_489_j(var2, var3 + 1, var4, 1)) {
            return true;
        } else if (var5 != 2 && var1.func_489_j(var2, var3, var4 - 1, 2)) {
            return true;
        } else if (var5 != 3 && var1.func_489_j(var2, var3, var4 + 1, 3)) {
            return true;
        } else if (var5 != 5 && var1.func_489_j(var2 + 1, var3, var4, 5)) {
            return true;
        } else if (var5 != 4 && var1.func_489_j(var2 - 1, var3, var4, 4)) {
            return true;
        } else if (var1.func_489_j(var2, var3, var4, 0)) {
            return true;
        } else if (var1.func_489_j(var2, var3 + 2, var4, 1)) {
            return true;
        } else if (var1.func_489_j(var2, var3 + 1, var4 - 1, 2)) {
            return true;
        } else if (var1.func_489_j(var2, var3 + 1, var4 + 1, 3)) {
            return true;
        } else if (var1.func_489_j(var2 - 1, var3 + 1, var4, 4)) {
            return true;
        } else {
            return var1.func_489_j(var2 + 1, var3 + 1, var4, 5);
        }
    }

    public void func_21024_a(World var1, int var2, int var3, int var4, int var5, int var6) {
        this.field_31043_b = true;
        if (var5 == 0) {
            if (this.func_31038_i(var1, var2, var3, var4, var6)) {
                var1.func_511_b(var2, var3, var4, var6 | 8);
                var1.func_502_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "tile.piston.out", 0.5F, var1.field_803_m.nextFloat() * 0.25F + 0.6F);
            }
        } else if (var5 == 1) {
            TileEntity var8 = var1.func_451_k(var2 + PistonBlockTextures.field_31051_b[var6], var3 + PistonBlockTextures.field_31054_c[var6], var4 + PistonBlockTextures.field_31053_d[var6]);
            if (var8 != null && var8 instanceof TileEntityPiston) {
                ((TileEntityPiston)var8).func_31011_k();
            }

            var1.func_470_a(var2, var3, var4, Block.field_9048_ac.field_573_bc, var6);
            var1.func_473_a(var2, var3, var4, BlockPistonMoving.func_31030_a(this.field_573_bc, var6, var6, false, true));
            if (this.field_31044_a) {
                int var9 = var2 + PistonBlockTextures.field_31051_b[var6] * 2;
                int var10 = var3 + PistonBlockTextures.field_31054_c[var6] * 2;
                int var11 = var4 + PistonBlockTextures.field_31053_d[var6] * 2;
                int var12 = var1.func_444_a(var9, var10, var11);
                int var13 = var1.func_446_b(var9, var10, var11);
                boolean var14 = false;
                if (var12 == Block.field_9048_ac.field_573_bc) {
                    TileEntity var15 = var1.func_451_k(var9, var10, var11);
                    if (var15 != null && var15 instanceof TileEntityPiston) {
                        TileEntityPiston var16 = (TileEntityPiston)var15;
                        if (var16.func_31008_d() == var6 && var16.func_31010_c()) {
                            var16.func_31011_k();
                            var12 = var16.func_31012_a();
                            var13 = var16.func_31005_e();
                            var14 = true;
                        }
                    }
                }

                if (var14 || var12 <= 0 || !func_31040_a(var12, var1, var9, var10, var11, false) || Block.field_542_n[var12].func_31025_e() != 0 && var12 != Block.field_9029_Z.field_573_bc && var12 != Block.field_9033_V.field_573_bc) {
                    if (!var14) {
                        this.field_31043_b = false;
                        var1.func_508_d(var2 + PistonBlockTextures.field_31051_b[var6], var3 + PistonBlockTextures.field_31054_c[var6], var4 + PistonBlockTextures.field_31053_d[var6], 0);
                        this.field_31043_b = true;
                    }
                } else {
                    this.field_31043_b = false;
                    var1.func_508_d(var9, var10, var11, 0);
                    this.field_31043_b = true;
                    var2 += PistonBlockTextures.field_31051_b[var6];
                    var3 += PistonBlockTextures.field_31054_c[var6];
                    var4 += PistonBlockTextures.field_31053_d[var6];
                    var1.func_470_a(var2, var3, var4, Block.field_9048_ac.field_573_bc, var13);
                    var1.func_473_a(var2, var3, var4, BlockPistonMoving.func_31030_a(var12, var13, var6, false, false));
                }
            } else {
                this.field_31043_b = false;
                var1.func_508_d(var2 + PistonBlockTextures.field_31051_b[var6], var3 + PistonBlockTextures.field_31054_c[var6], var4 + PistonBlockTextures.field_31053_d[var6], 0);
                this.field_31043_b = true;
            }

            var1.func_502_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "tile.piston.in", 0.5F, var1.field_803_m.nextFloat() * 0.15F + 0.6F);
        }

        this.field_31043_b = false;
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        if (func_31035_d(var5)) {
            switch(func_31042_c(var5)) {
            case 0:
                this.func_229_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 1:
                this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;
            case 2:
                this.func_229_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;
            case 3:
                this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;
            case 4:
                this.func_229_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 5:
                this.func_229_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }
        } else {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

    }

    public void func_264_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.func_264_a(var1, var2, var3, var4, var5, var6);
    }

    public boolean func_28025_b() {
        return false;
    }

    public static int func_31042_c(int var0) {
        return var0 & 7;
    }

    public static boolean func_31035_d(int var0) {
        return (var0 & 8) != 0;
    }

    private static int func_31037_c(World var0, int var1, int var2, int var3, EntityPlayer var4) {
        if (MathHelper.func_587_e((float)var4.field_322_l - (float)var1) < 2.0F && MathHelper.func_587_e((float)var4.field_320_n - (float)var3) < 2.0F) {
            double var5 = var4.field_321_m + 1.82D - (double)var4.field_9076_H;
            if (var5 - (double)var2 > 2.0D) {
                return 1;
            }

            if ((double)var2 - var5 > 0.0D) {
                return 0;
            }
        }

        int var7 = MathHelper.func_584_b((double)(var4.field_316_r * 4.0F / 360.0F) + 0.5D) & 3;
        if (var7 == 0) {
            return 2;
        } else if (var7 == 1) {
            return 5;
        } else if (var7 == 2) {
            return 3;
        } else {
            return var7 == 3 ? 4 : 0;
        }
    }

    private static boolean func_31040_a(int var0, World var1, int var2, int var3, int var4, boolean var5) {
        if (var0 == Block.field_602_aq.field_573_bc) {
            return false;
        } else {
            if (var0 != Block.field_9029_Z.field_573_bc && var0 != Block.field_9033_V.field_573_bc) {
                if (Block.field_542_n[var0].func_31026_j() == -1.0F) {
                    return false;
                }

                if (Block.field_542_n[var0].func_31025_e() == 2) {
                    return false;
                }

                if (!var5 && Block.field_542_n[var0].func_31025_e() == 1) {
                    return false;
                }
            } else if (func_31035_d(var1.func_446_b(var2, var3, var4))) {
                return false;
            }

            TileEntity var6 = var1.func_451_k(var2, var3, var4);
            return var6 == null;
        }
    }

    private static boolean func_31036_h(World var0, int var1, int var2, int var3, int var4) {
        int var5 = var1 + PistonBlockTextures.field_31051_b[var4];
        int var6 = var2 + PistonBlockTextures.field_31054_c[var4];
        int var7 = var3 + PistonBlockTextures.field_31053_d[var4];
        int var8 = 0;

        while(true) {
            if (var8 < 13) {
                if (var6 <= 0 || var6 >= 127) {
                    return false;
                }

                int var9 = var0.func_444_a(var5, var6, var7);
                if (var9 != 0) {
                    if (!func_31040_a(var9, var0, var5, var6, var7, true)) {
                        return false;
                    }

                    if (Block.field_542_n[var9].func_31025_e() != 1) {
                        if (var8 == 12) {
                            return false;
                        }

                        var5 += PistonBlockTextures.field_31051_b[var4];
                        var6 += PistonBlockTextures.field_31054_c[var4];
                        var7 += PistonBlockTextures.field_31053_d[var4];
                        ++var8;
                        continue;
                    }
                }
            }

            return true;
        }
    }

    private boolean func_31038_i(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var2 + PistonBlockTextures.field_31051_b[var5];
        int var7 = var3 + PistonBlockTextures.field_31054_c[var5];
        int var8 = var4 + PistonBlockTextures.field_31053_d[var5];
        int var9 = 0;

        while(true) {
            int var10;
            if (var9 < 13) {
                if (var7 <= 0 || var7 >= 127) {
                    return false;
                }

                var10 = var1.func_444_a(var6, var7, var8);
                if (var10 != 0) {
                    if (!func_31040_a(var10, var1, var6, var7, var8, true)) {
                        return false;
                    }

                    if (Block.field_542_n[var10].func_31025_e() != 1) {
                        if (var9 == 12) {
                            return false;
                        }

                        var6 += PistonBlockTextures.field_31051_b[var5];
                        var7 += PistonBlockTextures.field_31054_c[var5];
                        var8 += PistonBlockTextures.field_31053_d[var5];
                        ++var9;
                        continue;
                    }

                    Block.field_542_n[var10].func_247_a_(var1, var6, var7, var8, var1.func_446_b(var6, var7, var8));
                    var1.func_508_d(var6, var7, var8, 0);
                }
            }

            while(var6 != var2 || var7 != var3 || var8 != var4) {
                var9 = var6 - PistonBlockTextures.field_31051_b[var5];
                var10 = var7 - PistonBlockTextures.field_31054_c[var5];
                int var11 = var8 - PistonBlockTextures.field_31053_d[var5];
                int var12 = var1.func_444_a(var9, var10, var11);
                int var13 = var1.func_446_b(var9, var10, var11);
                if (var12 == this.field_573_bc && var9 == var2 && var10 == var3 && var11 == var4) {
                    var1.func_470_a(var6, var7, var8, Block.field_9048_ac.field_573_bc, var5 | (this.field_31044_a ? 8 : 0));
                    var1.func_473_a(var6, var7, var8, BlockPistonMoving.func_31030_a(Block.field_9049_aa.field_573_bc, var5 | (this.field_31044_a ? 8 : 0), var5, true, false));
                } else {
                    var1.func_470_a(var6, var7, var8, Block.field_9048_ac.field_573_bc, var13);
                    var1.func_473_a(var6, var7, var8, BlockPistonMoving.func_31030_a(var12, var13, var5, true, false));
                }

                var6 = var9;
                var7 = var10;
                var8 = var11;
            }

            return true;
        }
    }
}
