package net.minecraft.src;

public class ChunkCache implements IBlockAccess {
    private int field_1060_a;
    private int field_1059_b;
    private Chunk[][] field_1062_c;
    private World field_1061_d;

    public ChunkCache(World var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.field_1061_d = var1;
        this.field_1060_a = var2 >> 4;
        this.field_1059_b = var4 >> 4;
        int var8 = var5 >> 4;
        int var9 = var7 >> 4;
        this.field_1062_c = new Chunk[var8 - this.field_1060_a + 1][var9 - this.field_1059_b + 1];

        for(int var10 = this.field_1060_a; var10 <= var8; ++var10) {
            for(int var11 = this.field_1059_b; var11 <= var9; ++var11) {
                this.field_1062_c[var10 - this.field_1060_a][var11 - this.field_1059_b] = var1.func_704_b(var10, var11);
            }
        }

    }

    public int func_600_a(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else if (var2 >= 128) {
            return 0;
        } else {
            int var4 = (var1 >> 4) - this.field_1060_a;
            int var5 = (var3 >> 4) - this.field_1059_b;
            if (var4 >= 0 && var4 < this.field_1062_c.length && var5 >= 0 && var5 < this.field_1062_c[var4].length) {
                Chunk var6 = this.field_1062_c[var4][var5];
                return var6 == null ? 0 : var6.func_1008_a(var1 & 15, var2, var3 & 15);
            } else {
                return 0;
            }
        }
    }

    public TileEntity func_603_b(int var1, int var2, int var3) {
        int var4 = (var1 >> 4) - this.field_1060_a;
        int var5 = (var3 >> 4) - this.field_1059_b;
        return this.field_1062_c[var4][var5].func_1002_d(var1 & 15, var2, var3 & 15);
    }

    public float func_28099_a(int var1, int var2, int var3, int var4) {
        int var5 = this.func_4086_d(var1, var2, var3);
        if (var5 < var4) {
            var5 = var4;
        }

        return this.field_1061_d.field_4209_q.field_4219_d[var5];
    }

    public float func_598_c(int var1, int var2, int var3) {
        return this.field_1061_d.field_4209_q.field_4219_d[this.func_4086_d(var1, var2, var3)];
    }

    public int func_4086_d(int var1, int var2, int var3) {
        return this.func_716_a(var1, var2, var3, true);
    }

    public int func_716_a(int var1, int var2, int var3, boolean var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            int var5;
            int var6;
            if (var4) {
                var5 = this.func_600_a(var1, var2, var3);
                if (var5 == Block.field_410_al.field_376_bc || var5 == Block.field_446_aB.field_376_bc || var5 == Block.field_4059_au.field_376_bc || var5 == Block.field_4069_aI.field_376_bc) {
                    var6 = this.func_716_a(var1, var2 + 1, var3, false);
                    int var7 = this.func_716_a(var1 + 1, var2, var3, false);
                    int var8 = this.func_716_a(var1 - 1, var2, var3, false);
                    int var9 = this.func_716_a(var1, var2, var3 + 1, false);
                    int var10 = this.func_716_a(var1, var2, var3 - 1, false);
                    if (var7 > var6) {
                        var6 = var7;
                    }

                    if (var8 > var6) {
                        var6 = var8;
                    }

                    if (var9 > var6) {
                        var6 = var9;
                    }

                    if (var10 > var6) {
                        var6 = var10;
                    }

                    return var6;
                }
            }

            if (var2 < 0) {
                return 0;
            } else if (var2 >= 128) {
                var5 = 15 - this.field_1061_d.field_1046_e;
                if (var5 < 0) {
                    var5 = 0;
                }

                return var5;
            } else {
                var5 = (var1 >> 4) - this.field_1060_a;
                var6 = (var3 >> 4) - this.field_1059_b;
                return this.field_1062_c[var5][var6].func_1019_c(var1 & 15, var2, var3 & 15, this.field_1061_d.field_1046_e);
            }
        } else {
            return 15;
        }
    }

    public int func_602_e(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else if (var2 >= 128) {
            return 0;
        } else {
            int var4 = (var1 >> 4) - this.field_1060_a;
            int var5 = (var3 >> 4) - this.field_1059_b;
            return this.field_1062_c[var4][var5].func_1021_b(var1 & 15, var2, var3 & 15);
        }
    }

    public Material func_599_f(int var1, int var2, int var3) {
        int var4 = this.func_600_a(var1, var2, var3);
        return var4 == 0 ? Material.field_1337_a : Block.field_345_n[var4].field_356_bn;
    }

    public WorldChunkManager func_4075_a() {
        return this.field_1061_d.func_4075_a();
    }

    public boolean func_601_g(int var1, int var2, int var3) {
        Block var4 = Block.field_345_n[this.func_600_a(var1, var2, var3)];
        return var4 == null ? false : var4.func_217_b();
    }

    public boolean func_28100_h(int var1, int var2, int var3) {
        Block var4 = Block.field_345_n[this.func_600_a(var1, var2, var3)];
        if (var4 == null) {
            return false;
        } else {
            return var4.field_356_bn.func_880_c() && var4.func_242_c();
        }
    }
}
