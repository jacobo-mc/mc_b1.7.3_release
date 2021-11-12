package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockRedstoneTorch extends BlockTorch {
    private boolean field_649_a = false;
    private static List field_648_b = new ArrayList();

    public int func_22009_a(int var1, int var2) {
        return var1 == 1 ? Block.field_591_aw.func_22009_a(var1, var2) : super.func_22009_a(var1, var2);
    }

    private boolean func_280_a(World var1, int var2, int var3, int var4, boolean var5) {
        if (var5) {
            field_648_b.add(new RedstoneUpdateInfo(var2, var3, var4, var1.func_22080_k()));
        }

        int var6 = 0;

        for(int var7 = 0; var7 < field_648_b.size(); ++var7) {
            RedstoneUpdateInfo var8 = (RedstoneUpdateInfo)field_648_b.get(var7);
            if (var8.field_775_a == var2 && var8.field_774_b == var3 && var8.field_777_c == var4) {
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
        this.field_649_a = var3;
        this.func_231_a(true);
    }

    public int func_4028_b() {
        return 2;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        if (var1.func_446_b(var2, var3, var4) == 0) {
            super.func_250_e(var1, var2, var3, var4);
        }

        if (this.field_649_a) {
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
            var1.func_449_g(var2 - 1, var3, var4, this.field_573_bc);
            var1.func_449_g(var2 + 1, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3, var4 - 1, this.field_573_bc);
            var1.func_449_g(var2, var3, var4 + 1, this.field_573_bc);
        }

    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        if (this.field_649_a) {
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
            var1.func_449_g(var2 - 1, var3, var4, this.field_573_bc);
            var1.func_449_g(var2 + 1, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3, var4 - 1, this.field_573_bc);
            var1.func_449_g(var2, var3, var4 + 1, this.field_573_bc);
        }

    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.field_649_a) {
            return false;
        } else {
            int var6 = var1.func_446_b(var2, var3, var4);
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

    private boolean func_30003_g(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        if (var5 == 5 && var1.func_489_j(var2, var3 - 1, var4, 0)) {
            return true;
        } else if (var5 == 3 && var1.func_489_j(var2, var3, var4 - 1, 2)) {
            return true;
        } else if (var5 == 4 && var1.func_489_j(var2, var3, var4 + 1, 3)) {
            return true;
        } else if (var5 == 1 && var1.func_489_j(var2 - 1, var3, var4, 4)) {
            return true;
        } else {
            return var5 == 2 && var1.func_489_j(var2 + 1, var3, var4, 5);
        }
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        boolean var6 = this.func_30003_g(var1, var2, var3, var4);

        while(field_648_b.size() > 0 && var1.func_22080_k() - ((RedstoneUpdateInfo)field_648_b.get(0)).field_776_d > 100L) {
            field_648_b.remove(0);
        }

        if (this.field_649_a) {
            if (var6) {
                var1.func_507_b(var2, var3, var4, Block.field_628_aQ.field_573_bc, var1.func_446_b(var2, var3, var4));
                if (this.func_280_a(var1, var2, var3, var4, true)) {
                    var1.func_502_a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.field_803_m.nextFloat() - var1.field_803_m.nextFloat()) * 0.8F);

                    for(int var7 = 0; var7 < 5; ++var7) {
                        double var8 = (double)var2 + var5.nextDouble() * 0.6D + 0.2D;
                        double var10 = (double)var3 + var5.nextDouble() * 0.6D + 0.2D;
                        double var12 = (double)var4 + var5.nextDouble() * 0.6D + 0.2D;
                        var1.func_514_a("smoke", var8, var10, var12, 0.0D, 0.0D, 0.0D);
                    }
                }
            }
        } else if (!var6 && !this.func_280_a(var1, var2, var3, var4, false)) {
            var1.func_507_b(var2, var3, var4, Block.field_627_aR.field_573_bc, var1.func_446_b(var2, var3, var4));
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        super.func_234_b(var1, var2, var3, var4, var5);
        var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        return var5 == 0 ? this.func_239_b(var1, var2, var3, var4, var5) : false;
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_627_aR.field_573_bc;
    }

    public boolean func_225_d() {
        return true;
    }
}
