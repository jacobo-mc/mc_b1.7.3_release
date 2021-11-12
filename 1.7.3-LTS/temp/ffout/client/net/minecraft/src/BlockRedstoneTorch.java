package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockRedstoneTorch extends BlockTorch {
    private boolean field_451_a = false;
    private static List field_450_b = new ArrayList();

    public int func_232_a(int var1, int var2) {
        return var1 == 1 ? Block.field_394_aw.func_232_a(var1, var2) : super.func_232_a(var1, var2);
    }

    private boolean func_273_a(World var1, int var2, int var3, int var4, boolean var5) {
        if (var5) {
            field_450_b.add(new RedstoneUpdateInfo(var2, var3, var4, var1.func_22139_r()));
        }

        int var6 = 0;

        for(int var7 = 0; var7 < field_450_b.size(); ++var7) {
            RedstoneUpdateInfo var8 = (RedstoneUpdateInfo)field_450_b.get(var7);
            if (var8.field_1009_a == var2 && var8.field_1008_b == var3 && var8.field_1011_c == var4) {
                ++var6;
                if (var6 >= 8) {
                    return true;
                }
            }
        }

        return false;
    }

    protected BlockRedstoneTorch(int var1, int var2, boolean var3) {
        super(var1, var2);
        this.field_451_a = var3;
        this.func_253_b(true);
    }

    public int func_4025_d() {
        return 2;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        if (var1.func_602_e(var2, var3, var4) == 0) {
            super.func_235_e(var1, var2, var3, var4);
        }

        if (this.field_451_a) {
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
            var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
            var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
            var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
            var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
        }

    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        if (this.field_451_a) {
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
            var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
            var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
            var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
            var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
        }

    }

    public boolean func_231_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.field_451_a) {
            return false;
        } else {
            int var6 = var1.func_602_e(var2, var3, var4);
            if (var6 == 5 && var5 == 1) {
                return false;
            } else if (var6 == 3 && var5 == 3) {
                return false;
            } else if (var6 == 4 && var5 == 2) {
                return false;
            } else if (var6 == 1 && var5 == 5) {
                return false;
            } else {
                return var6 != 2 || var5 != 4;
            }
        }
    }

    private boolean func_30002_h(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        if (var5 == 5 && var1.func_706_k(var2, var3 - 1, var4, 0)) {
            return true;
        } else if (var5 == 3 && var1.func_706_k(var2, var3, var4 - 1, 2)) {
            return true;
        } else if (var5 == 4 && var1.func_706_k(var2, var3, var4 + 1, 3)) {
            return true;
        } else if (var5 == 1 && var1.func_706_k(var2 - 1, var3, var4, 4)) {
            return true;
        } else {
            return var5 == 2 && var1.func_706_k(var2 + 1, var3, var4, 5);
        }
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        boolean var6 = this.func_30002_h(var1, var2, var3, var4);

        while(field_450_b.size() > 0 && var1.func_22139_r() - ((RedstoneUpdateInfo)field_450_b.get(0)).field_1010_d > 100L) {
            field_450_b.remove(0);
        }

        if (this.field_451_a) {
            if (var6) {
                var1.func_688_b(var2, var3, var4, Block.field_431_aQ.field_376_bc, var1.func_602_e(var2, var3, var4));
                if (this.func_273_a(var1, var2, var3, var4, true)) {
                    var1.func_684_a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.field_1037_n.nextFloat() - var1.field_1037_n.nextFloat()) * 0.8F);

                    for(int var7 = 0; var7 < 5; ++var7) {
                        double var8 = (double)var2 + var5.nextDouble() * 0.6D + 0.2D;
                        double var10 = (double)var3 + var5.nextDouble() * 0.6D + 0.2D;
                        double var12 = (double)var4 + var5.nextDouble() * 0.6D + 0.2D;
                        var1.func_694_a("smoke", var8, var10, var12, 0.0D, 0.0D, 0.0D);
                    }
                }
            }
        } else if (!var6 && !this.func_273_a(var1, var2, var3, var4, false)) {
            var1.func_688_b(var2, var3, var4, Block.field_430_aR.field_376_bc, var1.func_602_e(var2, var3, var4));
        }

    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        super.func_226_a(var1, var2, var3, var4, var5);
        var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
    }

    public boolean func_228_c(World var1, int var2, int var3, int var4, int var5) {
        return var5 == 0 ? this.func_231_b(var1, var2, var3, var4, var5) : false;
    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_430_aR.field_376_bc;
    }

    public boolean func_209_d() {
        return true;
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_451_a) {
            int var6 = var1.func_602_e(var2, var3, var4);
            double var7 = (double)((float)var2 + 0.5F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var9 = (double)((float)var3 + 0.7F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var11 = (double)((float)var4 + 0.5F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var13 = 0.2199999988079071D;
            double var15 = 0.27000001072883606D;
            if (var6 == 1) {
                var1.func_694_a("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            } else if (var6 == 2) {
                var1.func_694_a("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            } else if (var6 == 3) {
                var1.func_694_a("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
            } else if (var6 == 4) {
                var1.func_694_a("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
            } else {
                var1.func_694_a("reddust", var7, var9, var11, 0.0D, 0.0D, 0.0D);
            }

        }
    }
}
