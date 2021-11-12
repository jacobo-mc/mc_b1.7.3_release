package net.minecraft.src;

import java.util.Random;

public class BlockFire extends Block {
    private int[] field_449_a = new int[256];
    private int[] field_448_b = new int[256];

    protected BlockFire(int var1, int var2) {
        super(var1, var2, Material.field_1326_l);
        this.func_253_b(true);
    }

    public void func_28028_i() {
        this.func_264_a(Block.field_334_y.field_376_bc, 5, 20);
        this.func_264_a(Block.field_4057_ba.field_376_bc, 5, 20);
        this.func_264_a(Block.field_4059_au.field_376_bc, 5, 20);
        this.func_264_a(Block.field_385_K.field_376_bc, 5, 5);
        this.func_264_a(Block.field_384_L.field_376_bc, 30, 60);
        this.func_264_a(Block.field_407_ao.field_376_bc, 30, 20);
        this.func_264_a(Block.field_408_an.field_376_bc, 15, 100);
        this.func_264_a(Block.field_9257_X.field_376_bc, 60, 100);
        this.func_264_a(Block.field_419_ac.field_376_bc, 30, 60);
    }

    private void func_264_a(int var1, int var2, int var3) {
        this.field_449_a[var1] = var2;
        this.field_448_b[var1] = var3;
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 3;
    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public int func_4025_d() {
        return 40;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        boolean var6 = var1.func_600_a(var2, var3 - 1, var4) == Block.field_4053_bc.field_376_bc;
        if (!this.func_243_a(var1, var2, var3, var4)) {
            var1.func_690_d(var2, var3, var4, 0);
        }

        if (!var6 && var1.func_27161_C() && (var1.func_27167_r(var2, var3, var4) || var1.func_27167_r(var2 - 1, var3, var4) || var1.func_27167_r(var2 + 1, var3, var4) || var1.func_27167_r(var2, var3, var4 - 1) || var1.func_27167_r(var2, var3, var4 + 1))) {
            var1.func_690_d(var2, var3, var4, 0);
        } else {
            int var7 = var1.func_602_e(var2, var3, var4);
            if (var7 < 15) {
                var1.func_635_c(var2, var3, var4, var7 + var5.nextInt(3) / 2);
            }

            var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
            if (!var6 && !this.func_263_h(var1, var2, var3, var4)) {
                if (!var1.func_28100_h(var2, var3 - 1, var4) || var7 > 3) {
                    var1.func_690_d(var2, var3, var4, 0);
                }

            } else if (!var6 && !this.func_261_b(var1, var2, var3 - 1, var4) && var7 == 15 && var5.nextInt(4) == 0) {
                var1.func_690_d(var2, var3, var4, 0);
            } else {
                this.func_266_a(var1, var2 + 1, var3, var4, 300, var5, var7);
                this.func_266_a(var1, var2 - 1, var3, var4, 300, var5, var7);
                this.func_266_a(var1, var2, var3 - 1, var4, 250, var5, var7);
                this.func_266_a(var1, var2, var3 + 1, var4, 250, var5, var7);
                this.func_266_a(var1, var2, var3, var4 - 1, 300, var5, var7);
                this.func_266_a(var1, var2, var3, var4 + 1, 300, var5, var7);

                for(int var8 = var2 - 1; var8 <= var2 + 1; ++var8) {
                    for(int var9 = var4 - 1; var9 <= var4 + 1; ++var9) {
                        for(int var10 = var3 - 1; var10 <= var3 + 4; ++var10) {
                            if (var8 != var2 || var10 != var3 || var9 != var4) {
                                int var11 = 100;
                                if (var10 > var3 + 1) {
                                    var11 += (var10 - (var3 + 1)) * 100;
                                }

                                int var12 = this.func_262_i(var1, var8, var10, var9);
                                if (var12 > 0) {
                                    int var13 = (var12 + 40) / (var7 + 30);
                                    if (var13 > 0 && var5.nextInt(var11) <= var13 && (!var1.func_27161_C() || !var1.func_27167_r(var8, var10, var9)) && !var1.func_27167_r(var8 - 1, var10, var4) && !var1.func_27167_r(var8 + 1, var10, var9) && !var1.func_27167_r(var8, var10, var9 - 1) && !var1.func_27167_r(var8, var10, var9 + 1)) {
                                        int var14 = var7 + var5.nextInt(5) / 4;
                                        if (var14 > 15) {
                                            var14 = 15;
                                        }

                                        var1.func_688_b(var8, var10, var9, this.field_376_bc, var14);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private void func_266_a(World var1, int var2, int var3, int var4, int var5, Random var6, int var7) {
        int var8 = this.field_448_b[var1.func_600_a(var2, var3, var4)];
        if (var6.nextInt(var5) < var8) {
            boolean var9 = var1.func_600_a(var2, var3, var4) == Block.field_408_an.field_376_bc;
            if (var6.nextInt(var7 + 10) < 5 && !var1.func_27167_r(var2, var3, var4)) {
                int var10 = var7 + var6.nextInt(5) / 4;
                if (var10 > 15) {
                    var10 = 15;
                }

                var1.func_688_b(var2, var3, var4, this.field_376_bc, var10);
            } else {
                var1.func_690_d(var2, var3, var4, 0);
            }

            if (var9) {
                Block.field_408_an.func_252_b(var1, var2, var3, var4, 1);
            }
        }

    }

    private boolean func_263_h(World var1, int var2, int var3, int var4) {
        if (this.func_261_b(var1, var2 + 1, var3, var4)) {
            return true;
        } else if (this.func_261_b(var1, var2 - 1, var3, var4)) {
            return true;
        } else if (this.func_261_b(var1, var2, var3 - 1, var4)) {
            return true;
        } else if (this.func_261_b(var1, var2, var3 + 1, var4)) {
            return true;
        } else if (this.func_261_b(var1, var2, var3, var4 - 1)) {
            return true;
        } else {
            return this.func_261_b(var1, var2, var3, var4 + 1);
        }
    }

    private int func_262_i(World var1, int var2, int var3, int var4) {
        byte var5 = 0;
        if (!var1.func_20084_d(var2, var3, var4)) {
            return 0;
        } else {
            int var6 = this.func_265_g(var1, var2 + 1, var3, var4, var5);
            var6 = this.func_265_g(var1, var2 - 1, var3, var4, var6);
            var6 = this.func_265_g(var1, var2, var3 - 1, var4, var6);
            var6 = this.func_265_g(var1, var2, var3 + 1, var4, var6);
            var6 = this.func_265_g(var1, var2, var3, var4 - 1, var6);
            var6 = this.func_265_g(var1, var2, var3, var4 + 1, var6);
            return var6;
        }
    }

    public boolean func_245_h() {
        return false;
    }

    public boolean func_261_b(IBlockAccess var1, int var2, int var3, int var4) {
        return this.field_449_a[var1.func_600_a(var2, var3, var4)] > 0;
    }

    public int func_265_g(World var1, int var2, int var3, int var4, int var5) {
        int var6 = this.field_449_a[var1.func_600_a(var2, var3, var4)];
        return var6 > var5 ? var6 : var5;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return var1.func_28100_h(var2, var3 - 1, var4) || this.func_263_h(var1, var2, var3, var4);
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.func_28100_h(var2, var3 - 1, var4) && !this.func_263_h(var1, var2, var3, var4)) {
            var1.func_690_d(var2, var3, var4, 0);
        }
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        if (var1.func_600_a(var2, var3 - 1, var4) != Block.field_405_aq.field_376_bc || !Block.field_4047_bf.func_4032_a_(var1, var2, var3, var4)) {
            if (!var1.func_28100_h(var2, var3 - 1, var4) && !this.func_263_h(var1, var2, var3, var4)) {
                var1.func_690_d(var2, var3, var4, 0);
            } else {
                var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
            }
        }
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(24) == 0) {
            var1.func_684_a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "fire.fire", 1.0F + var5.nextFloat(), var5.nextFloat() * 0.7F + 0.3F);
        }

        int var6;
        float var7;
        float var8;
        float var9;
        if (!var1.func_28100_h(var2, var3 - 1, var4) && !Block.field_402_as.func_261_b(var1, var2, var3 - 1, var4)) {
            if (Block.field_402_as.func_261_b(var1, var2 - 1, var3, var4)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = (float)var2 + var5.nextFloat() * 0.1F;
                    var8 = (float)var3 + var5.nextFloat();
                    var9 = (float)var4 + var5.nextFloat();
                    var1.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_402_as.func_261_b(var1, var2 + 1, var3, var4)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = (float)(var2 + 1) - var5.nextFloat() * 0.1F;
                    var8 = (float)var3 + var5.nextFloat();
                    var9 = (float)var4 + var5.nextFloat();
                    var1.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_402_as.func_261_b(var1, var2, var3, var4 - 1)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = (float)var2 + var5.nextFloat();
                    var8 = (float)var3 + var5.nextFloat();
                    var9 = (float)var4 + var5.nextFloat() * 0.1F;
                    var1.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_402_as.func_261_b(var1, var2, var3, var4 + 1)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = (float)var2 + var5.nextFloat();
                    var8 = (float)var3 + var5.nextFloat();
                    var9 = (float)(var4 + 1) - var5.nextFloat() * 0.1F;
                    var1.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_402_as.func_261_b(var1, var2, var3 + 1, var4)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = (float)var2 + var5.nextFloat();
                    var8 = (float)(var3 + 1) - var5.nextFloat() * 0.1F;
                    var9 = (float)var4 + var5.nextFloat();
                    var1.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
                }
            }
        } else {
            for(var6 = 0; var6 < 3; ++var6) {
                var7 = (float)var2 + var5.nextFloat();
                var8 = (float)var3 + var5.nextFloat() * 0.5F + 0.5F;
                var9 = (float)var4 + var5.nextFloat();
                var1.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
