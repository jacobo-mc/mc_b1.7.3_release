package net.minecraft.src;

public class Pathfinder {
    private IBlockAccess field_941_a;
    private Path field_940_b = new Path();
    private MCHash field_943_c = new MCHash();
    private PathPoint[] field_942_d = new PathPoint[32];

    public Pathfinder(IBlockAccess var1) {
        this.field_941_a = var1;
    }

    public PathEntity func_657_a(Entity var1, Entity var2, float var3) {
        return this.func_652_a(var1, var2.field_322_l, var2.field_312_v.field_963_b, var2.field_320_n, var3);
    }

    public PathEntity func_651_a(Entity var1, int var2, int var3, int var4, float var5) {
        return this.func_652_a(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), var5);
    }

    private PathEntity func_652_a(Entity var1, double var2, double var4, double var6, float var8) {
        this.field_940_b.func_417_a();
        this.field_943_c.func_551_a();
        PathPoint var9 = this.func_655_a(MathHelper.func_584_b(var1.field_312_v.field_964_a), MathHelper.func_584_b(var1.field_312_v.field_963_b), MathHelper.func_584_b(var1.field_312_v.field_970_c));
        PathPoint var10 = this.func_655_a(MathHelper.func_584_b(var2 - (double)(var1.field_300_D / 2.0F)), MathHelper.func_584_b(var4), MathHelper.func_584_b(var6 - (double)(var1.field_300_D / 2.0F)));
        PathPoint var11 = new PathPoint(MathHelper.func_588_d(var1.field_300_D + 1.0F), MathHelper.func_588_d(var1.field_298_E + 1.0F), MathHelper.func_588_d(var1.field_300_D + 1.0F));
        PathEntity var12 = this.func_656_a(var1, var9, var10, var11, var8);
        return var12;
    }

    private PathEntity func_656_a(Entity var1, PathPoint var2, PathPoint var3, PathPoint var4, float var5) {
        var2.field_1011_f = 0.0F;
        var2.field_1010_g = var2.func_731_a(var3);
        var2.field_1009_h = var2.field_1010_g;
        this.field_940_b.func_417_a();
        this.field_940_b.func_413_a(var2);
        PathPoint var6 = var2;

        while(!this.field_940_b.func_418_c()) {
            PathPoint var7 = this.field_940_b.func_415_b();
            if (var7.equals(var3)) {
                return this.func_653_a(var2, var3);
            }

            if (var7.func_731_a(var3) < var6.func_731_a(var3)) {
                var6 = var7;
            }

            var7.field_1007_j = true;
            int var8 = this.func_654_b(var1, var7, var4, var3, var5);

            for(int var9 = 0; var9 < var8; ++var9) {
                PathPoint var10 = this.field_942_d[var9];
                float var11 = var7.field_1011_f + var7.func_731_a(var10);
                if (!var10.func_730_a() || var11 < var10.field_1011_f) {
                    var10.field_1008_i = var7;
                    var10.field_1011_f = var11;
                    var10.field_1010_g = var10.func_731_a(var3);
                    if (var10.func_730_a()) {
                        this.field_940_b.func_414_a(var10, var10.field_1011_f + var10.field_1010_g);
                    } else {
                        var10.field_1009_h = var10.field_1011_f + var10.field_1010_g;
                        this.field_940_b.func_413_a(var10);
                    }
                }
            }
        }

        if (var6 == var2) {
            return null;
        } else {
            return this.func_653_a(var2, var6);
        }
    }

    private int func_654_b(Entity var1, PathPoint var2, PathPoint var3, PathPoint var4, float var5) {
        int var6 = 0;
        byte var7 = 0;
        if (this.func_649_a(var1, var2.field_1016_a, var2.field_1015_b + 1, var2.field_1014_c, var3) == 1) {
            var7 = 1;
        }

        PathPoint var8 = this.func_650_a(var1, var2.field_1016_a, var2.field_1015_b, var2.field_1014_c + 1, var3, var7);
        PathPoint var9 = this.func_650_a(var1, var2.field_1016_a - 1, var2.field_1015_b, var2.field_1014_c, var3, var7);
        PathPoint var10 = this.func_650_a(var1, var2.field_1016_a + 1, var2.field_1015_b, var2.field_1014_c, var3, var7);
        PathPoint var11 = this.func_650_a(var1, var2.field_1016_a, var2.field_1015_b, var2.field_1014_c - 1, var3, var7);
        if (var8 != null && !var8.field_1007_j && var8.func_731_a(var4) < var5) {
            this.field_942_d[var6++] = var8;
        }

        if (var9 != null && !var9.field_1007_j && var9.func_731_a(var4) < var5) {
            this.field_942_d[var6++] = var9;
        }

        if (var10 != null && !var10.field_1007_j && var10.func_731_a(var4) < var5) {
            this.field_942_d[var6++] = var10;
        }

        if (var11 != null && !var11.field_1007_j && var11.func_731_a(var4) < var5) {
            this.field_942_d[var6++] = var11;
        }

        return var6;
    }

    private PathPoint func_650_a(Entity var1, int var2, int var3, int var4, PathPoint var5, int var6) {
        PathPoint var7 = null;
        if (this.func_649_a(var1, var2, var3, var4, var5) == 1) {
            var7 = this.func_655_a(var2, var3, var4);
        }

        if (var7 == null && var6 > 0 && this.func_649_a(var1, var2, var3 + var6, var4, var5) == 1) {
            var7 = this.func_655_a(var2, var3 + var6, var4);
            var3 += var6;
        }

        if (var7 != null) {
            int var8 = 0;
            int var9 = 0;

            while(var3 > 0 && (var9 = this.func_649_a(var1, var2, var3 - 1, var4, var5)) == 1) {
                ++var8;
                if (var8 >= 4) {
                    return null;
                }

                --var3;
                if (var3 > 0) {
                    var7 = this.func_655_a(var2, var3, var4);
                }
            }

            if (var9 == -2) {
                return null;
            }
        }

        return var7;
    }

    private final PathPoint func_655_a(int var1, int var2, int var3) {
        int var4 = PathPoint.func_22203_a(var1, var2, var3);
        PathPoint var5 = (PathPoint)this.field_943_c.func_550_a(var4);
        if (var5 == null) {
            var5 = new PathPoint(var1, var2, var3);
            this.field_943_c.func_554_a(var4, var5);
        }

        return var5;
    }

    private int func_649_a(Entity var1, int var2, int var3, int var4, PathPoint var5) {
        for(int var6 = var2; var6 < var2 + var5.field_1016_a; ++var6) {
            for(int var7 = var3; var7 < var3 + var5.field_1015_b; ++var7) {
                for(int var8 = var4; var8 < var4 + var5.field_1014_c; ++var8) {
                    int var9 = this.field_941_a.func_444_a(var6, var7, var8);
                    if (var9 > 0) {
                        if (var9 != Block.field_632_aM.field_573_bc && var9 != Block.field_639_aF.field_573_bc) {
                            Material var11 = Block.field_542_n[var9].field_553_bn;
                            if (var11.func_218_c()) {
                                return 0;
                            }

                            if (var11 == Material.field_521_f) {
                                return -1;
                            }

                            if (var11 == Material.field_520_g) {
                                return -2;
                            }
                        } else {
                            int var10 = this.field_941_a.func_446_b(var6, var7, var8);
                            if (!BlockDoor.func_27036_e(var10)) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }

    private PathEntity func_653_a(PathPoint var1, PathPoint var2) {
        int var3 = 1;

        PathPoint var4;
        for(var4 = var2; var4.field_1008_i != null; var4 = var4.field_1008_i) {
            ++var3;
        }

        PathPoint[] var5 = new PathPoint[var3];
        var4 = var2;
        --var3;

        for(var5[var3] = var2; var4.field_1008_i != null; var5[var3] = var4) {
            var4 = var4.field_1008_i;
            --var3;
        }

        return new PathEntity(var5);
    }
}
