package net.minecraft.src;

import java.util.Random;

public class BlockFurnace extends BlockContainer {
    private Random field_28033_a = new Random();
    private final boolean field_655_a;
    private static boolean field_28034_c = false;

    protected BlockFurnace(int var1, boolean var2) {
        super(var1, Material.field_523_d);
        this.field_655_a = var2;
        this.field_575_bb = 45;
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_642_aC.field_573_bc;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        super.func_250_e(var1, var2, var3, var4);
        this.func_296_g(var1, var2, var3, var4);
    }

    private void func_296_g(World var1, int var2, int var3, int var4) {
        if (!var1.field_792_x) {
            int var5 = var1.func_444_a(var2, var3, var4 - 1);
            int var6 = var1.func_444_a(var2, var3, var4 + 1);
            int var7 = var1.func_444_a(var2 - 1, var3, var4);
            int var8 = var1.func_444_a(var2 + 1, var3, var4);
            byte var9 = 3;
            if (Block.field_540_p[var5] && !Block.field_540_p[var6]) {
                var9 = 3;
            }

            if (Block.field_540_p[var6] && !Block.field_540_p[var5]) {
                var9 = 2;
            }

            if (Block.field_540_p[var7] && !Block.field_540_p[var8]) {
                var9 = 5;
            }

            if (Block.field_540_p[var8] && !Block.field_540_p[var7]) {
                var9 = 4;
            }

            var1.func_511_b(var2, var3, var4, var9);
        }
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb + 17;
        } else if (var1 == 0) {
            return this.field_575_bb + 17;
        } else {
            return var1 == 3 ? this.field_575_bb - 1 : this.field_575_bb;
        }
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_792_x) {
            return true;
        } else {
            TileEntityFurnace var6 = (TileEntityFurnace)var1.func_451_k(var2, var3, var4);
            var5.func_170_a(var6);
            return true;
        }
    }

    public static void func_295_a(boolean var0, World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        TileEntity var6 = var1.func_451_k(var2, var3, var4);
        field_28034_c = true;
        if (var0) {
            var1.func_508_d(var2, var3, var4, Block.field_641_aD.field_573_bc);
        } else {
            var1.func_508_d(var2, var3, var4, Block.field_642_aC.field_573_bc);
        }

        field_28034_c = false;
        var1.func_511_b(var2, var3, var4, var5);
        var6.func_31002_j();
        var1.func_473_a(var2, var3, var4, var6);
    }

    protected TileEntity func_294_a_() {
        return new TileEntityFurnace();
    }

    public void func_4027_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.func_584_b((double)(var5.field_316_r * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            var1.func_511_b(var2, var3, var4, 2);
        }

        if (var6 == 1) {
            var1.func_511_b(var2, var3, var4, 5);
        }

        if (var6 == 2) {
            var1.func_511_b(var2, var3, var4, 3);
        }

        if (var6 == 3) {
            var1.func_511_b(var2, var3, var4, 4);
        }

    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        if (!field_28034_c) {
            TileEntityFurnace var5 = (TileEntityFurnace)var1.func_451_k(var2, var3, var4);

            for(int var6 = 0; var6 < var5.func_83_a(); ++var6) {
                ItemStack var7 = var5.func_82_a(var6);
                if (var7 != null) {
                    float var8 = this.field_28033_a.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.field_28033_a.nextFloat() * 0.8F + 0.1F;
                    float var10 = this.field_28033_a.nextFloat() * 0.8F + 0.1F;

                    while(var7.field_853_a > 0) {
                        int var11 = this.field_28033_a.nextInt(21) + 10;
                        if (var11 > var7.field_853_a) {
                            var11 = var7.field_853_a;
                        }

                        var7.field_853_a -= var11;
                        EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.field_855_c, var11, var7.func_21125_h()));
                        float var13 = 0.05F;
                        var12.field_319_o = (double)((float)this.field_28033_a.nextGaussian() * var13);
                        var12.field_318_p = (double)((float)this.field_28033_a.nextGaussian() * var13 + 0.2F);
                        var12.field_317_q = (double)((float)this.field_28033_a.nextGaussian() * var13);
                        var1.func_526_a(var12);
                    }
                }
            }
        }

        super.func_242_b(var1, var2, var3, var4);
    }
}
