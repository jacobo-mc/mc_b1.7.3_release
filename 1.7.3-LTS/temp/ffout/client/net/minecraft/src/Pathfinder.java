package net.minecraft.src;

public class Pathfinder {
    private IBlockAccess field_1674_a;
    private Path field_1673_b = new Path();
    private MCHash field_1676_c = new MCHash();
    private PathPoint[] field_1675_d = new PathPoint[32];

    public Pathfinder(IBlockAccess var1) {
        this.field_1674_a = var1;
    }

    public PathEntity func_1137_a(Entity var1, Entity var2, float var3) {
        return this.func_1130_a(var1, var2.field_611_ak, var2.field_601_au.field_1697_b, var2.field_609_am, var3);
    }

    public PathEntity func_1131_a(Entity var1, int var2, int var3, int var4, float var5) {
        return this.func_1130_a(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), var5);
    }

    private PathEntity func_1130_a(Entity var1, double var2, double var4, double var6, float var8) {
        this.field_1673_b.func_1038_a();
        this.field_1676_c.func_1058_a();
        PathPoint var9 = this.func_1136_a(MathHelper.func_1108_b(var1.field_601_au.field_1698_a), MathHelper.func_1108_b(var1.field_601_au.field_1697_b), MathHelper.func_1108_b(var1.field_601_au.field_1704_c));
        PathPoint var10 = this.func_1136_a(MathHelper.func_1108_b(var2 - (double)(var1.field_644_aC / 2.0F)), MathHelper.func_1108_b(var4), MathHelper.func_1108_b(var6 - (double)(var1.field_644_aC / 2.0F)));
        PathPoint var11 = new PathPoint(MathHelper.func_1110_d(var1.field_644_aC + 1.0F), MathHelper.func_1110_d(var1.field_643_aD + 1.0F), MathHelper.func_1110_d(var1.field_644_aC + 1.0F));
        PathEntity var12 = this.func_1129_a(var1, var9, var10, var11, var8);
        return var12;
    }

    private PathEntity func_1129_a(Entity var1, PathPoint var2, PathPoint var3, PathPoint var4, float var5) {
        var2.field_1713_f = 0.0F;
        var2.field_1712_g = var2.func_1180_a(var3);
        var2.field_1711_h = var2.field_1712_g;
        this.field_1673_b.func_1038_a();
        this.field_1673_b.func_1034_a(var2);
        PathPoint var6 = var2;

        while(!this.field_1673_b.func_1039_c()) {
            PathPoint var7 = this.field_1673_b.func_1036_b();
            if (var7.equals(var3)) {
                return this.func_1134_a(var2, var3);
            }

            if (var7.func_1180_a(var3) < var6.func_1180_a(var3)) {
                var6 = var7;
            }

            var7.field_1709_j = true;
            int var8 = this.func_1133_b(var1, var7, var4, var3, var5);

            for(int var9 = 0; var9 < var8; ++var9) {
                PathPoint var10 = this.field_1675_d[var9];
                float var11 = var7.field_1713_f + var7.func_1180_a(var10);
                if (!var10.func_1179_a() || var11 < var10.field_1713_f) {
                    var10.field_1710_i = var7;
                    var10.field_1713_f = var11;
                    var10.field_1712_g = var10.func_1180_a(var3);
                    if (var10.func_1179_a()) {
                        this.field_1673_b.func_1035_a(var10, var10.field_1713_f + var10.field_1712_g);
                    } else {
                        var10.field_1711_h = var10.field_1713_f + var10.field_1712_g;
                        this.field_1673_b.func_1034_a(var10);
                    }
                }
            }
        }

        if (var6 == var2) {
            return null;
        } else {
            return this.func_1134_a(var2, var6);
        }
    }

    private int func_1133_b(Entity var1, PathPoint var2, PathPoint var3, PathPoint var4, float var5) {
        int var6 = 0;
        byte var7 = 0;
        if (this.func_1132_a(var1, var2.field_1718_a, var2.field_1717_b + 1, var2.field_1716_c, var3) == 1) {
            var7 = 1;
        }

        PathPoint var8 = this.func_1135_a(var1, var2.field_1718_a, var2.field_1717_b, var2.field_1716_c + 1, var3, var7);
        PathPoint var9 = this.func_1135_a(var1, var2.field_1718_a - 1, var2.field_1717_b, var2.field_1716_c, var3, var7);
        PathPoint var10 = this.func_1135_a(var1, var2.field_1718_a + 1, var2.field_1717_b, var2.field_1716_c, var3, var7);
        PathPoint var11 = this.func_1135_a(var1, var2.field_1718_a, var2.field_1717_b, var2.field_1716_c - 1, var3, var7);
        if (var8 != null && !var8.field_1709_j && var8.func_1180_a(var4) < var5) {
            this.field_1675_d[var6++] = var8;
        }

        if (var9 != null && !var9.field_1709_j && var9.func_1180_a(var4) < var5) {
            this.field_1675_d[var6++] = var9;
        }

        if (var10 != null && !var10.field_1709_j && var10.func_1180_a(var4) < var5) {
            this.field_1675_d[var6++] = var10;
        }

        if (var11 != null && !var11.field_1709_j && var11.func_1180_a(var4) < var5) {
            this.field_1675_d[var6++] = var11;
        }

        return var6;
    }

    private PathPoint func_1135_a(Entity var1, int var2, int var3, int var4, PathPoint var5, int var6) {
        PathPoint var7 = null;
        if (this.func_1132_a(var1, var2, var3, var4, var5) == 1) {
            var7 = this.func_1136_a(var2, var3, var4);
        }

        if (var7 == null && var6 > 0 && this.func_1132_a(var1, var2, var3 + var6, var4, var5) == 1) {
            var7 = this.func_1136_a(var2, var3 + var6, var4);
            var3 += var6;
        }

        if (var7 != null) {
            int var8 = 0;
            int var9 = 0;

            while(var3 > 0 && (var9 = this.func_1132_a(var1, var2, var3 - 1, var4, var5)) == 1) {
                ++var8;
                if (var8 >= 4) {
                    return null;
                }

                --var3;
                if (var3 > 0) {
                    var7 = this.func_1136_a(var2, var3, var4);
                }
            }

            if (var9 == -2) {
                return null;
            }
        }

        return var7;
    }

    private final PathPoint func_1136_a(int var1, int var2, int var3) {
        int var4 = PathPoint.func_22329_a(var1, var2, var3);
        PathPoint var5 = (PathPoint)this.field_1676_c.func_1057_a(var4);
        if (var5 == null) {
            var5 = new PathPoint(var1, var2, var3);
            this.field_1676_c.func_1061_a(var4, var5);
        }

        return var5;
    }

    private int func_1132_a(Entity var1, int var2, int var3, int var4, PathPoint var5) {
        for(int var6 = var2; var6 < var2 + var5.field_1718_a; ++var6) {
            for(int var7 = var3; var7 < var3 + var5.field_1717_b; ++var7) {
                for(int var8 = var4; var8 < var4 + var5.field_1716_c; ++var8) {
                    int var9 = this.field_1674_a.func_600_a(var6, var7, var8);
                    if (var9 > 0) {
                        if (var9 != Block.field_435_aM.field_376_bc && var9 != Block.field_442_aF.field_376_bc) {
                            Material var11 = Block.field_345_n[var9].field_356_bn;
                            if (var11.func_880_c()) {
                                return 0;
                            }

                            if (var11 == Material.field_1332_f) {
                                return -1;
                            }

                            if (var11 == Material.field_1331_g) {
                                return -2;
                            }
                        } else {
                            int var10 = this.field_1674_a.func_602_e(var6, var7, var8);
                            if (!BlockDoor.func_27047_e(var10)) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }

    private PathEntity func_1134_a(PathPoint var1, PathPoint var2) {
        int var3 = 1;

        PathPoint var4;
        for(var4 = var2; var4.field_1710_i != null; var4 = var4.field_1710_i) {
            ++var3;
        }

        PathPoint[] var5 = new PathPoint[var3];
        var4 = var2;
        --var3;

        for(var5[var3] = var2; var4.field_1710_i != null; var5[var3] = var4) {
            var4 = var4.field_1710_i;
            --var3;
        }

        return new PathEntity(var5);
    }
}
