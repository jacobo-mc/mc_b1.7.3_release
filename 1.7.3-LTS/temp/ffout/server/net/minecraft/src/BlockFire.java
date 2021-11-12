package net.minecraft.src;

import java.util.Random;

public class BlockFire extends Block {
    private int[] field_646_a = new int[256];
    private int[] field_645_b = new int[256];

    protected BlockFire(int var1, int var2) {
        super(var1, var2, Material.field_515_l);
        this.func_231_a(true);
    }

    public void func_28028_f() {
        this.func_267_a(Block.field_531_y.field_573_bc, 5, 20);
        this.func_267_a(Block.field_9050_aZ.field_573_bc, 5, 20);
        this.func_267_a(Block.field_9045_at.field_573_bc, 5, 20);
        this.func_267_a(Block.field_582_K.field_573_bc, 5, 5);
        this.func_267_a(Block.field_581_L.field_573_bc, 30, 60);
        this.func_267_a(Block.field_604_ao.field_573_bc, 30, 20);
        this.func_267_a(Block.field_605_an.field_573_bc, 15, 100);
        this.func_267_a(Block.field_9031_X.field_573_bc, 60, 100);
        this.func_267_a(Block.field_616_ac.field_573_bc, 30, 60);
    }

    private void func_267_a(int var1, int var2, int var3) {
        this.field_646_a[var1] = var2;
        this.field_645_b[var1] = var3;
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public int func_4028_b() {
        return 40;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        boolean var6 = var1.func_444_a(var2, var3 - 1, var4) == Block.field_4050_bc.field_573_bc;
        if (!this.func_259_a(var1, var2, var3, var4)) {
            var1.func_508_d(var2, var3, var4, 0);
        }

        if (!var6 && var1.func_27068_v() && (var1.func_27072_q(var2, var3, var4) || var1.func_27072_q(var2 - 1, var3, var4) || var1.func_27072_q(var2 + 1, var3, var4) || var1.func_27072_q(var2, var3, var4 - 1) || var1.func_27072_q(var2, var3, var4 + 1))) {
            var1.func_508_d(var2, var3, var4, 0);
        } else {
            int var7 = var1.func_446_b(var2, var3, var4);
            if (var7 < 15) {
                var1.func_463_c(var2, var3, var4, var7 + var5.nextInt(3) / 2);
            }

            var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
            if (!var6 && !this.func_268_g(var1, var2, var3, var4)) {
                if (!var1.func_445_d(var2, var3 - 1, var4) || var7 > 3) {
                    var1.func_508_d(var2, var3, var4, 0);
                }

            } else if (!var6 && !this.func_269_b(var1, var2, var3 - 1, var4) && var7 == 15 && var5.nextInt(4) == 0) {
                var1.func_508_d(var2, var3, var4, 0);
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

                                int var12 = this.func_270_h(var1, var8, var10, var9);
                                if (var12 > 0) {
                                    int var13 = (var12 + 40) / (var7 + 30);
                                    if (var13 > 0 && var5.nextInt(var11) <= var13 && (!var1.func_27068_v() || !var1.func_27072_q(var8, var10, var9)) && !var1.func_27072_q(var8 - 1, var10, var4) && !var1.func_27072_q(var8 + 1, var10, var9) && !var1.func_27072_q(var8, var10, var9 - 1) && !var1.func_27072_q(var8, var10, var9 + 1)) {
                                        int var14 = var7 + var5.nextInt(5) / 4;
                                        if (var14 > 15) {
                                            var14 = 15;
                                        }

                                        var1.func_507_b(var8, var10, var9, this.field_573_bc, var14);
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
        int var8 = this.field_645_b[var1.func_444_a(var2, var3, var4)];
        if (var6.nextInt(var5) < var8) {
            boolean var9 = var1.func_444_a(var2, var3, var4) == Block.field_605_an.field_573_bc;
            if (var6.nextInt(var7 + 10) < 5 && !var1.func_27072_q(var2, var3, var4)) {
                int var10 = var7 + var6.nextInt(5) / 4;
                if (var10 > 15) {
                    var10 = 15;
                }

                var1.func_507_b(var2, var3, var4, this.field_573_bc, var10);
            } else {
                var1.func_508_d(var2, var3, var4, 0);
            }

            if (var9) {
                Block.field_605_an.func_251_a(var1, var2, var3, var4, 1);
            }
        }

    }

    private boolean func_268_g(World var1, int var2, int var3, int var4) {
        if (this.func_269_b(var1, var2 + 1, var3, var4)) {
            return true;
        } else if (this.func_269_b(var1, var2 - 1, var3, var4)) {
            return true;
        } else if (this.func_269_b(var1, var2, var3 - 1, var4)) {
            return true;
        } else if (this.func_269_b(var1, var2, var3 + 1, var4)) {
            return true;
        } else if (this.func_269_b(var1, var2, var3, var4 - 1)) {
            return true;
        } else {
            return this.func_269_b(var1, var2, var3, var4 + 1);
        }
    }

    private int func_270_h(World var1, int var2, int var3, int var4) {
        byte var5 = 0;
        if (!var1.func_20111_e(var2, var3, var4)) {
            return 0;
        } else {
            int var6 = this.func_265_f(var1, var2 + 1, var3, var4, var5);
            var6 = this.func_265_f(var1, var2 - 1, var3, var4, var6);
            var6 = this.func_265_f(var1, var2, var3 - 1, var4, var6);
            var6 = this.func_265_f(var1, var2, var3 + 1, var4, var6);
            var6 = this.func_265_f(var1, var2, var3, var4 - 1, var6);
            var6 = this.func_265_f(var1, var2, var3, var4 + 1, var6);
            return var6;
        }
    }

    public boolean func_245_e() {
        return false;
    }

    public boolean func_269_b(IBlockAccess var1, int var2, int var3, int var4) {
        return this.field_646_a[var1.func_444_a(var2, var3, var4)] > 0;
    }

    public int func_265_f(World var1, int var2, int var3, int var4, int var5) {
        int var6 = this.field_646_a[var1.func_444_a(var2, var3, var4)];
        return var6 > var5 ? var6 : var5;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return var1.func_445_d(var2, var3 - 1, var4) || this.func_268_g(var1, var2, var3, var4);
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.func_445_d(var2, var3 - 1, var4) && !this.func_268_g(var1, var2, var3, var4)) {
            var1.func_508_d(var2, var3, var4, 0);
        }
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        if (var1.func_444_a(var2, var3 - 1, var4) != Block.field_602_aq.field_573_bc || !Block.field_4044_bf.func_4030_a_(var1, var2, var3, var4)) {
            if (!var1.func_445_d(var2, var3 - 1, var4) && !this.func_268_g(var1, var2, var3, var4)) {
                var1.func_508_d(var2, var3, var4, 0);
            } else {
                var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
            }
        }
    }
}
