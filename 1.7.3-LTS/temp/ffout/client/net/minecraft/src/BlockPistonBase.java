package net.minecraft.src;

import java.util.ArrayList;

public class BlockPistonBase extends Block {
    private boolean field_31049_a;
    private boolean field_31048_b;

    public BlockPistonBase(int var1, int var2, boolean var3) {
        super(var1, var2, Material.field_31067_B);
        this.field_31049_a = var3;
        this.func_4024_a(field_9251_h);
        this.func_222_c(0.5F);
    }

    public int func_31040_i() {
        return this.field_31049_a ? 106 : 107;
    }

    public int func_232_a(int var1, int var2) {
        int var3 = func_31044_d(var2);
        if (var3 > 5) {
            return this.field_378_bb;
        } else if (var1 == var3) {
            return !func_31046_e(var2) && this.field_370_bf <= 0.0D && this.field_368_bg <= 0.0D && this.field_366_bh <= 0.0D && this.field_364_bi >= 1.0D && this.field_362_bj >= 1.0D && this.field_360_bk >= 1.0D ? this.field_378_bb : 110;
        } else {
            return var1 == PistonBlockTextures.field_31057_a[var3] ? 109 : 108;
        }
    }

    public int func_210_f() {
        return 16;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return false;
    }

    public void func_4026_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = func_31039_c(var1, var2, var3, var4, (EntityPlayer)var5);
        var1.func_691_b(var2, var3, var4, var6);
        if (!var1.field_1026_y) {
            this.func_31043_h(var1, var2, var3, var4);
        }

    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y && !this.field_31048_b) {
            this.func_31043_h(var1, var2, var3, var4);
        }

    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        if (!var1.field_1026_y && var1.func_603_b(var2, var3, var4) == null) {
            this.func_31043_h(var1, var2, var3, var4);
        }

    }

    private void func_31043_h(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        int var6 = func_31044_d(var5);
        boolean var7 = this.func_31041_f(var1, var2, var3, var4, var6);
        if (var5 != 7) {
            if (var7 && !func_31046_e(var5)) {
                if (func_31045_h(var1, var2, var3, var4, var6)) {
                    var1.func_635_c(var2, var3, var4, var6 | 8);
                    var1.func_21116_c(var2, var3, var4, 0, var6);
                }
            } else if (!var7 && func_31046_e(var5)) {
                var1.func_635_c(var2, var3, var4, var6);
                var1.func_21116_c(var2, var3, var4, 1, var6);
            }

        }
    }

    private boolean func_31041_f(World var1, int var2, int var3, int var4, int var5) {
        if (var5 != 0 && var1.func_706_k(var2, var3 - 1, var4, 0)) {
            return true;
        } else if (var5 != 1 && var1.func_706_k(var2, var3 + 1, var4, 1)) {
            return true;
        } else if (var5 != 2 && var1.func_706_k(var2, var3, var4 - 1, 2)) {
            return true;
        } else if (var5 != 3 && var1.func_706_k(var2, var3, var4 + 1, 3)) {
            return true;
        } else if (var5 != 5 && var1.func_706_k(var2 + 1, var3, var4, 5)) {
            return true;
        } else if (var5 != 4 && var1.func_706_k(var2 - 1, var3, var4, 4)) {
            return true;
        } else if (var1.func_706_k(var2, var3, var4, 0)) {
            return true;
        } else if (var1.func_706_k(var2, var3 + 2, var4, 1)) {
            return true;
        } else if (var1.func_706_k(var2, var3 + 1, var4 - 1, 2)) {
            return true;
        } else if (var1.func_706_k(var2, var3 + 1, var4 + 1, 3)) {
            return true;
        } else if (var1.func_706_k(var2 - 1, var3 + 1, var4, 4)) {
            return true;
        } else {
            return var1.func_706_k(var2 + 1, var3 + 1, var4, 5);
        }
    }

    public void func_21024_a(World var1, int var2, int var3, int var4, int var5, int var6) {
        this.field_31048_b = true;
        if (var5 == 0) {
            if (this.func_31047_i(var1, var2, var3, var4, var6)) {
                var1.func_691_b(var2, var3, var4, var6 | 8);
                var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "tile.piston.out", 0.5F, var1.field_1037_n.nextFloat() * 0.25F + 0.6F);
            }
        } else if (var5 == 1) {
            TileEntity var8 = var1.func_603_b(var2 + PistonBlockTextures.field_31056_b[var6], var3 + PistonBlockTextures.field_31059_c[var6], var4 + PistonBlockTextures.field_31058_d[var6]);
            if (var8 != null && var8 instanceof TileEntityPiston) {
                ((TileEntityPiston)var8).func_31011_l();
            }

            var1.func_643_a(var2, var3, var4, Block.field_9268_ac.field_376_bc, var6);
            var1.func_654_a(var2, var3, var4, BlockPistonMoving.func_31036_a(this.field_376_bc, var6, var6, false, true));
            if (this.field_31049_a) {
                int var9 = var2 + PistonBlockTextures.field_31056_b[var6] * 2;
                int var10 = var3 + PistonBlockTextures.field_31059_c[var6] * 2;
                int var11 = var4 + PistonBlockTextures.field_31058_d[var6] * 2;
                int var12 = var1.func_600_a(var9, var10, var11);
                int var13 = var1.func_602_e(var9, var10, var11);
                boolean var14 = false;
                if (var12 == Block.field_9268_ac.field_376_bc) {
                    TileEntity var15 = var1.func_603_b(var9, var10, var11);
                    if (var15 != null && var15 instanceof TileEntityPiston) {
                        TileEntityPiston var16 = (TileEntityPiston)var15;
                        if (var16.func_31009_d() == var6 && var16.func_31015_b()) {
                            var16.func_31011_l();
                            var12 = var16.func_31016_a();
                            var13 = var16.func_479_f();
                            var14 = true;
                        }
                    }
                }

                if (var14 || var12 <= 0 || !func_31042_a(var12, var1, var9, var10, var11, false) || Block.field_345_n[var12].func_31029_h() != 0 && var12 != Block.field_9255_Z.field_376_bc && var12 != Block.field_9259_V.field_376_bc) {
                    if (!var14) {
                        this.field_31048_b = false;
                        var1.func_690_d(var2 + PistonBlockTextures.field_31056_b[var6], var3 + PistonBlockTextures.field_31059_c[var6], var4 + PistonBlockTextures.field_31058_d[var6], 0);
                        this.field_31048_b = true;
                    }
                } else {
                    this.field_31048_b = false;
                    var1.func_690_d(var9, var10, var11, 0);
                    this.field_31048_b = true;
                    var2 += PistonBlockTextures.field_31056_b[var6];
                    var3 += PistonBlockTextures.field_31059_c[var6];
                    var4 += PistonBlockTextures.field_31058_d[var6];
                    var1.func_643_a(var2, var3, var4, Block.field_9268_ac.field_376_bc, var13);
                    var1.func_654_a(var2, var3, var4, BlockPistonMoving.func_31036_a(var12, var13, var6, false, false));
                }
            } else {
                this.field_31048_b = false;
                var1.func_690_d(var2 + PistonBlockTextures.field_31056_b[var6], var3 + PistonBlockTextures.field_31059_c[var6], var4 + PistonBlockTextures.field_31058_d[var6], 0);
                this.field_31048_b = true;
            }

            var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "tile.piston.in", 0.5F, var1.field_1037_n.nextFloat() * 0.15F + 0.6F);
        }

        this.field_31048_b = false;
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        if (func_31046_e(var5)) {
            switch(func_31044_d(var5)) {
            case 0:
                this.func_213_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 1:
                this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;
            case 2:
                this.func_213_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;
            case 3:
                this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;
            case 4:
                this.func_213_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 5:
                this.func_213_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }
        } else {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

    }

    public void func_237_e() {
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_230_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.func_230_a(var1, var2, var3, var4, var5, var6);
    }

    public boolean func_242_c() {
        return false;
    }

    public static int func_31044_d(int var0) {
        return var0 & 7;
    }

    public static boolean func_31046_e(int var0) {
        return (var0 & 8) != 0;
    }

    private static int func_31039_c(World var0, int var1, int var2, int var3, EntityPlayer var4) {
        if (MathHelper.func_1112_e((float)var4.field_611_ak - (float)var1) < 2.0F && MathHelper.func_1112_e((float)var4.field_609_am - (float)var3) < 2.0F) {
            double var5 = var4.field_610_al + 1.82D - (double)var4.field_9292_aO;
            if (var5 - (double)var2 > 2.0D) {
                return 1;
            }

            if ((double)var2 - var5 > 0.0D) {
                return 0;
            }
        }

        int var7 = MathHelper.func_1108_b((double)(var4.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
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

    private static boolean func_31042_a(int var0, World var1, int var2, int var3, int var4, boolean var5) {
        if (var0 == Block.field_405_aq.field_376_bc) {
            return false;
        } else {
            if (var0 != Block.field_9255_Z.field_376_bc && var0 != Block.field_9259_V.field_376_bc) {
                if (Block.field_345_n[var0].func_31031_m() == -1.0F) {
                    return false;
                }

                if (Block.field_345_n[var0].func_31029_h() == 2) {
                    return false;
                }

                if (!var5 && Block.field_345_n[var0].func_31029_h() == 1) {
                    return false;
                }
            } else if (func_31046_e(var1.func_602_e(var2, var3, var4))) {
                return false;
            }

            TileEntity var6 = var1.func_603_b(var2, var3, var4);
            return var6 == null;
        }
    }

    private static boolean func_31045_h(World var0, int var1, int var2, int var3, int var4) {
        int var5 = var1 + PistonBlockTextures.field_31056_b[var4];
        int var6 = var2 + PistonBlockTextures.field_31059_c[var4];
        int var7 = var3 + PistonBlockTextures.field_31058_d[var4];
        int var8 = 0;

        while(true) {
            if (var8 < 13) {
                if (var6 <= 0 || var6 >= 127) {
                    return false;
                }

                int var9 = var0.func_600_a(var5, var6, var7);
                if (var9 != 0) {
                    if (!func_31042_a(var9, var0, var5, var6, var7, true)) {
                        return false;
                    }

                    if (Block.field_345_n[var9].func_31029_h() != 1) {
                        if (var8 == 12) {
                            return false;
                        }

                        var5 += PistonBlockTextures.field_31056_b[var4];
                        var6 += PistonBlockTextures.field_31059_c[var4];
                        var7 += PistonBlockTextures.field_31058_d[var4];
                        ++var8;
                        continue;
                    }
                }
            }

            return true;
        }
    }

    private boolean func_31047_i(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var2 + PistonBlockTextures.field_31056_b[var5];
        int var7 = var3 + PistonBlockTextures.field_31059_c[var5];
        int var8 = var4 + PistonBlockTextures.field_31058_d[var5];
        int var9 = 0;

        int var10;
        while(var9 < 13) {
            if (var7 > 0 && var7 < 127) {
                var10 = var1.func_600_a(var6, var7, var8);
                if (var10 != 0) {
                    if (!func_31042_a(var10, var1, var6, var7, var8, true)) {
                        return false;
                    }

                    if (Block.field_345_n[var10].func_31029_h() != 1) {
                        if (var9 == 12) {
                            return false;
                        }

                        var6 += PistonBlockTextures.field_31056_b[var5];
                        var7 += PistonBlockTextures.field_31059_c[var5];
                        var8 += PistonBlockTextures.field_31058_d[var5];
                        ++var9;
                        continue;
                    }

                    Block.field_345_n[var10].func_259_b_(var1, var6, var7, var8, var1.func_602_e(var6, var7, var8));
                    var1.func_690_d(var6, var7, var8, 0);
                }
                break;
            }

            return false;
        }

        while(var6 != var2 || var7 != var3 || var8 != var4) {
            var9 = var6 - PistonBlockTextures.field_31056_b[var5];
            var10 = var7 - PistonBlockTextures.field_31059_c[var5];
            int var11 = var8 - PistonBlockTextures.field_31058_d[var5];
            int var12 = var1.func_600_a(var9, var10, var11);
            int var13 = var1.func_602_e(var9, var10, var11);
            if (var12 == this.field_376_bc && var9 == var2 && var10 == var3 && var11 == var4) {
                var1.func_643_a(var6, var7, var8, Block.field_9268_ac.field_376_bc, var5 | (this.field_31049_a ? 8 : 0));
                var1.func_654_a(var6, var7, var8, BlockPistonMoving.func_31036_a(Block.field_9269_aa.field_376_bc, var5 | (this.field_31049_a ? 8 : 0), var5, true, false));
            } else {
                var1.func_643_a(var6, var7, var8, Block.field_9268_ac.field_376_bc, var13);
                var1.func_654_a(var6, var7, var8, BlockPistonMoving.func_31036_a(var12, var13, var5, true, false));
            }

            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return true;
    }
}
