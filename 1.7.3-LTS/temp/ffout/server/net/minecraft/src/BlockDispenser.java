package net.minecraft.src;

import java.util.Random;

public class BlockDispenser extends BlockContainer {
    private Random field_28032_a = new Random();

    protected BlockDispenser(int var1) {
        super(var1, Material.field_523_d);
        this.field_575_bb = 45;
    }

    public int func_4028_b() {
        return 4;
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_9040_P.field_573_bc;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        super.func_250_e(var1, var2, var3, var4);
        this.func_21035_g(var1, var2, var3, var4);
    }

    private void func_21035_g(World var1, int var2, int var3, int var4) {
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
            return var1 == 3 ? this.field_575_bb + 1 : this.field_575_bb;
        }
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_792_x) {
            return true;
        } else {
            TileEntityDispenser var6 = (TileEntityDispenser)var1.func_451_k(var2, var3, var4);
            var5.func_21072_a(var6);
            return true;
        }
    }

    private void func_21036_b(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        byte var9 = 0;
        byte var10 = 0;
        if (var6 == 3) {
            var10 = 1;
        } else if (var6 == 2) {
            var10 = -1;
        } else if (var6 == 5) {
            var9 = 1;
        } else {
            var9 = -1;
        }

        TileEntityDispenser var11 = (TileEntityDispenser)var1.func_451_k(var2, var3, var4);
        ItemStack var12 = var11.func_21079_e();
        double var13 = (double)var2 + (double)var9 * 0.6D + 0.5D;
        double var15 = (double)var3 + 0.5D;
        double var17 = (double)var4 + (double)var10 * 0.6D + 0.5D;
        if (var12 == null) {
            var1.func_28097_e(1001, var2, var3, var4, 0);
        } else {
            if (var12.field_855_c == Item.field_4148_j.field_234_aS) {
                EntityArrow var19 = new EntityArrow(var1, var13, var15, var17);
                var19.func_177_a((double)var9, 0.10000000149011612D, (double)var10, 1.1F, 6.0F);
                var19.field_28012_a = true;
                var1.func_526_a(var19);
                var1.func_28097_e(1002, var2, var3, var4, 0);
            } else if (var12.field_855_c == Item.field_239_aN.field_234_aS) {
                EntityEgg var22 = new EntityEgg(var1, var13, var15, var17);
                var22.func_20078_a((double)var9, 0.10000000149011612D, (double)var10, 1.1F, 6.0F);
                var1.func_526_a(var22);
                var1.func_28097_e(1002, var2, var3, var4, 0);
            } else if (var12.field_855_c == Item.field_251_aB.field_234_aS) {
                EntitySnowball var23 = new EntitySnowball(var1, var13, var15, var17);
                var23.func_6141_a((double)var9, 0.10000000149011612D, (double)var10, 1.1F, 6.0F);
                var1.func_526_a(var23);
                var1.func_28097_e(1002, var2, var3, var4, 0);
            } else {
                EntityItem var24 = new EntityItem(var1, var13, var15 - 0.3D, var17, var12);
                double var20 = var5.nextDouble() * 0.1D + 0.2D;
                var24.field_319_o = (double)var9 * var20;
                var24.field_318_p = 0.20000000298023224D;
                var24.field_317_q = (double)var10 * var20;
                var24.field_319_o += var5.nextGaussian() * 0.007499999832361937D * 6.0D;
                var24.field_318_p += var5.nextGaussian() * 0.007499999832361937D * 6.0D;
                var24.field_317_q += var5.nextGaussian() * 0.007499999832361937D * 6.0D;
                var1.func_526_a(var24);
                var1.func_28097_e(1000, var2, var3, var4, 0);
            }

            var1.func_28097_e(2000, var2, var3, var4, var9 + 1 + (var10 + 1) * 3);
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (var5 > 0 && Block.field_542_n[var5].func_225_d()) {
            boolean var6 = var1.func_474_n(var2, var3, var4) || var1.func_474_n(var2, var3 + 1, var4);
            if (var6) {
                var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
            }
        }

    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_474_n(var2, var3, var4) || var1.func_474_n(var2, var3 + 1, var4)) {
            this.func_21036_b(var1, var2, var3, var4, var5);
        }

    }

    protected TileEntity func_294_a_() {
        return new TileEntityDispenser();
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
        TileEntityDispenser var5 = (TileEntityDispenser)var1.func_451_k(var2, var3, var4);

        for(int var6 = 0; var6 < var5.func_83_a(); ++var6) {
            ItemStack var7 = var5.func_82_a(var6);
            if (var7 != null) {
                float var8 = this.field_28032_a.nextFloat() * 0.8F + 0.1F;
                float var9 = this.field_28032_a.nextFloat() * 0.8F + 0.1F;
                float var10 = this.field_28032_a.nextFloat() * 0.8F + 0.1F;

                while(var7.field_853_a > 0) {
                    int var11 = this.field_28032_a.nextInt(21) + 10;
                    if (var11 > var7.field_853_a) {
                        var11 = var7.field_853_a;
                    }

                    var7.field_853_a -= var11;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.field_855_c, var11, var7.func_21125_h()));
                    float var13 = 0.05F;
                    var12.field_319_o = (double)((float)this.field_28032_a.nextGaussian() * var13);
                    var12.field_318_p = (double)((float)this.field_28032_a.nextGaussian() * var13 + 0.2F);
                    var12.field_317_q = (double)((float)this.field_28032_a.nextGaussian() * var13);
                    var1.func_526_a(var12);
                }
            }
        }

        super.func_242_b(var1, var2, var3, var4);
    }
}
