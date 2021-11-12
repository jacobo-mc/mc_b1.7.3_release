package net.minecraft.src;

import java.util.Iterator;
import java.util.Random;

public class BlockBed extends Block {
    public static final int[][] field_22033_a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public BlockBed(int var1) {
        super(var1, 134, Material.field_4264_k);
        this.func_22027_j();
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_1026_y) {
            return true;
        } else {
            int var6 = var1.func_602_e(var2, var3, var4);
            if (!func_22032_d(var6)) {
                int var7 = func_22030_c(var6);
                var2 += field_22033_a[var7][0];
                var4 += field_22033_a[var7][1];
                if (var1.func_600_a(var2, var3, var4) != this.field_376_bc) {
                    return true;
                }

                var6 = var1.func_602_e(var2, var3, var4);
            }

            if (!var1.field_4209_q.func_6477_d()) {
                double var16 = (double)var2 + 0.5D;
                double var17 = (double)var3 + 0.5D;
                double var11 = (double)var4 + 0.5D;
                var1.func_690_d(var2, var3, var4, 0);
                int var13 = func_22030_c(var6);
                var2 += field_22033_a[var13][0];
                var4 += field_22033_a[var13][1];
                if (var1.func_600_a(var2, var3, var4) == this.field_376_bc) {
                    var1.func_690_d(var2, var3, var4, 0);
                    var16 = (var16 + (double)var2 + 0.5D) / 2.0D;
                    var17 = (var17 + (double)var3 + 0.5D) / 2.0D;
                    var11 = (var11 + (double)var4 + 0.5D) / 2.0D;
                }

                var1.func_12244_a((Entity)null, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), 5.0F, true);
                return true;
            } else {
                if (func_22029_f(var6)) {
                    EntityPlayer var14 = null;
                    Iterator var8 = var1.field_1040_k.iterator();

                    while(var8.hasNext()) {
                        EntityPlayer var9 = (EntityPlayer)var8.next();
                        if (var9.func_22051_K()) {
                            ChunkCoordinates var10 = var9.field_21908_b;
                            if (var10.field_22395_a == var2 && var10.field_22394_b == var3 && var10.field_22396_c == var4) {
                                var14 = var9;
                            }
                        }
                    }

                    if (var14 != null) {
                        var5.func_22055_b("tile.bed.occupied");
                        return true;
                    }

                    func_22031_a(var1, var2, var3, var4, false);
                }

                EnumStatus var15 = var5.func_22053_b(var2, var3, var4);
                if (var15 == EnumStatus.OK) {
                    func_22031_a(var1, var2, var3, var4, true);
                    return true;
                } else {
                    if (var15 == EnumStatus.NOT_POSSIBLE_NOW) {
                        var5.func_22055_b("tile.bed.noSleep");
                    }

                    return true;
                }
            }
        }
    }

    public int func_232_a(int var1, int var2) {
        if (var1 == 0) {
            return Block.field_334_y.field_378_bb;
        } else {
            int var3 = func_22030_c(var2);
            int var4 = ModelBed.field_22281_c[var3][var1];
            if (func_22032_d(var2)) {
                if (var4 == 2) {
                    return this.field_378_bb + 2 + 16;
                } else {
                    return var4 != 5 && var4 != 4 ? this.field_378_bb + 1 : this.field_378_bb + 1 + 16;
                }
            } else if (var4 == 3) {
                return this.field_378_bb - 1 + 16;
            } else {
                return var4 != 5 && var4 != 4 ? this.field_378_bb : this.field_378_bb + 16;
            }
        }
    }

    public int func_210_f() {
        return 14;
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_217_b() {
        return false;
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        this.func_22027_j();
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        int var7 = func_22030_c(var6);
        if (func_22032_d(var6)) {
            if (var1.func_600_a(var2 - field_22033_a[var7][0], var3, var4 - field_22033_a[var7][1]) != this.field_376_bc) {
                var1.func_690_d(var2, var3, var4, 0);
            }
        } else if (var1.func_600_a(var2 + field_22033_a[var7][0], var3, var4 + field_22033_a[var7][1]) != this.field_376_bc) {
            var1.func_690_d(var2, var3, var4, 0);
            if (!var1.field_1026_y) {
                this.func_259_b_(var1, var2, var3, var4, var6);
            }
        }

    }

    public int func_240_a(int var1, Random var2) {
        return func_22032_d(var1) ? 0 : Item.field_22019_aY.field_291_aS;
    }

    private void func_22027_j() {
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }

    public static int func_22030_c(int var0) {
        return var0 & 3;
    }

    public static boolean func_22032_d(int var0) {
        return (var0 & 8) != 0;
    }

    public static boolean func_22029_f(int var0) {
        return (var0 & 4) != 0;
    }

    public static void func_22031_a(World var0, int var1, int var2, int var3, boolean var4) {
        int var5 = var0.func_602_e(var1, var2, var3);
        if (var4) {
            var5 |= 4;
        } else {
            var5 &= -5;
        }

        var0.func_691_b(var1, var2, var3, var5);
    }

    public static ChunkCoordinates func_22028_g(World var0, int var1, int var2, int var3, int var4) {
        int var5 = var0.func_602_e(var1, var2, var3);
        int var6 = func_22030_c(var5);

        for(int var7 = 0; var7 <= 1; ++var7) {
            int var8 = var1 - field_22033_a[var6][0] * var7 - 1;
            int var9 = var3 - field_22033_a[var6][1] * var7 - 1;
            int var10 = var8 + 2;
            int var11 = var9 + 2;

            for(int var12 = var8; var12 <= var10; ++var12) {
                for(int var13 = var9; var13 <= var11; ++var13) {
                    if (var0.func_28100_h(var12, var2 - 1, var13) && var0.func_20084_d(var12, var2, var13) && var0.func_20084_d(var12, var2 + 1, var13)) {
                        if (var4 <= 0) {
                            return new ChunkCoordinates(var12, var2, var13);
                        }

                        --var4;
                    }
                }
            }
        }

        return null;
    }

    public void func_216_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!func_22032_d(var5)) {
            super.func_216_a(var1, var2, var3, var4, var5, var6);
        }

    }

    public int func_31029_h() {
        return 1;
    }
}
