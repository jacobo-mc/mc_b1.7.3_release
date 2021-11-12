package net.minecraft.src;

import java.util.Random;

public class BlockFurnace extends BlockContainer {
    private Random field_28036_a = new Random();
    private final boolean field_456_a;
    private static boolean field_28037_c = false;

    protected BlockFurnace(int var1, boolean var2) {
        super(var1, Material.field_1334_d);
        this.field_456_a = var2;
        this.field_378_bb = 45;
    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_445_aC.field_376_bc;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        super.func_235_e(var1, var2, var3, var4);
        this.func_284_h(var1, var2, var3, var4);
    }

    private void func_284_h(World var1, int var2, int var3, int var4) {
        if (!var1.field_1026_y) {
            int var5 = var1.func_600_a(var2, var3, var4 - 1);
            int var6 = var1.func_600_a(var2, var3, var4 + 1);
            int var7 = var1.func_600_a(var2 - 1, var3, var4);
            int var8 = var1.func_600_a(var2 + 1, var3, var4);
            byte var9 = 3;
            if (Block.field_343_p[var5] && !Block.field_343_p[var6]) {
                var9 = 3;
            }

            if (Block.field_343_p[var6] && !Block.field_343_p[var5]) {
                var9 = 2;
            }

            if (Block.field_343_p[var7] && !Block.field_343_p[var8]) {
                var9 = 5;
            }

            if (Block.field_343_p[var8] && !Block.field_343_p[var7]) {
                var9 = 4;
            }

            var1.func_691_b(var2, var3, var4, var9);
        }
    }

    public int func_211_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1) {
            return this.field_378_bb + 17;
        } else if (var5 == 0) {
            return this.field_378_bb + 17;
        } else {
            int var6 = var1.func_602_e(var2, var3, var4);
            if (var5 != var6) {
                return this.field_378_bb;
            } else {
                return this.field_456_a ? this.field_378_bb + 16 : this.field_378_bb - 1;
            }
        }
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_456_a) {
            int var6 = var1.func_602_e(var2, var3, var4);
            float var7 = (float)var2 + 0.5F;
            float var8 = (float)var3 + 0.0F + var5.nextFloat() * 6.0F / 16.0F;
            float var9 = (float)var4 + 0.5F;
            float var10 = 0.52F;
            float var11 = var5.nextFloat() * 0.6F - 0.3F;
            if (var6 == 4) {
                var1.func_694_a("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                var1.func_694_a("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            } else if (var6 == 5) {
                var1.func_694_a("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                var1.func_694_a("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            } else if (var6 == 2) {
                var1.func_694_a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
                var1.func_694_a("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
            } else if (var6 == 3) {
                var1.func_694_a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
                var1.func_694_a("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
            }

        }
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb + 17;
        } else if (var1 == 0) {
            return this.field_378_bb + 17;
        } else {
            return var1 == 3 ? this.field_378_bb - 1 : this.field_378_bb;
        }
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_1026_y) {
            return true;
        } else {
            TileEntityFurnace var6 = (TileEntityFurnace)var1.func_603_b(var2, var3, var4);
            var5.func_453_a(var6);
            return true;
        }
    }

    public static void func_285_a(boolean var0, World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        TileEntity var6 = var1.func_603_b(var2, var3, var4);
        field_28037_c = true;
        if (var0) {
            var1.func_690_d(var2, var3, var4, Block.field_444_aD.field_376_bc);
        } else {
            var1.func_690_d(var2, var3, var4, Block.field_445_aC.field_376_bc);
        }

        field_28037_c = false;
        var1.func_691_b(var2, var3, var4, var5);
        var6.func_31004_j();
        var1.func_654_a(var2, var3, var4, var6);
    }

    protected TileEntity func_283_a_() {
        return new TileEntityFurnace();
    }

    public void func_4026_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.func_1108_b((double)(var5.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            var1.func_691_b(var2, var3, var4, 2);
        }

        if (var6 == 1) {
            var1.func_691_b(var2, var3, var4, 5);
        }

        if (var6 == 2) {
            var1.func_691_b(var2, var3, var4, 3);
        }

        if (var6 == 3) {
            var1.func_691_b(var2, var3, var4, 4);
        }

    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        if (!field_28037_c) {
            TileEntityFurnace var5 = (TileEntityFurnace)var1.func_603_b(var2, var3, var4);

            for(int var6 = 0; var6 < var5.func_469_c(); ++var6) {
                ItemStack var7 = var5.func_468_c(var6);
                if (var7 != null) {
                    float var8 = this.field_28036_a.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.field_28036_a.nextFloat() * 0.8F + 0.1F;
                    float var10 = this.field_28036_a.nextFloat() * 0.8F + 0.1F;

                    while(var7.field_1615_a > 0) {
                        int var11 = this.field_28036_a.nextInt(21) + 10;
                        if (var11 > var7.field_1615_a) {
                            var11 = var7.field_1615_a;
                        }

                        var7.field_1615_a -= var11;
                        EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.field_1617_c, var11, var7.func_21181_i()));
                        float var13 = 0.05F;
                        var12.field_608_an = (double)((float)this.field_28036_a.nextGaussian() * var13);
                        var12.field_607_ao = (double)((float)this.field_28036_a.nextGaussian() * var13 + 0.2F);
                        var12.field_606_ap = (double)((float)this.field_28036_a.nextGaussian() * var13);
                        var1.func_674_a(var12);
                    }
                }
            }
        }

        super.func_214_b(var1, var2, var3, var4);
    }
}
