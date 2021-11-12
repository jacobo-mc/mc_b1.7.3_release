package net.minecraft.src;

public class ItemBucket extends Item {
    private int field_274_a;

    public ItemBucket(int var1, int var2) {
        super(var1);
        this.field_233_aT = 1;
        this.field_274_a = var2;
    }

    public ItemStack func_6152_a(ItemStack var1, World var2, EntityPlayer var3) {
        float var4 = 1.0F;
        float var5 = var3.field_9088_y + (var3.field_315_s - var3.field_9088_y) * var4;
        float var6 = var3.field_9089_x + (var3.field_316_r - var3.field_9089_x) * var4;
        double var7 = var3.field_9092_m + (var3.field_322_l - var3.field_9092_m) * (double)var4;
        double var9 = var3.field_9091_n + (var3.field_321_m - var3.field_9091_n) * (double)var4 + 1.62D - (double)var3.field_9076_H;
        double var11 = var3.field_9090_o + (var3.field_320_n - var3.field_9090_o) * (double)var4;
        Vec3D var13 = Vec3D.func_768_b(var7, var9, var11);
        float var14 = MathHelper.func_582_b(-var6 * 0.017453292F - 3.1415927F);
        float var15 = MathHelper.func_585_a(-var6 * 0.017453292F - 3.1415927F);
        float var16 = -MathHelper.func_582_b(-var5 * 0.017453292F);
        float var17 = MathHelper.func_585_a(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var20 = var14 * var16;
        double var21 = 5.0D;
        Vec3D var23 = var13.func_757_c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
        MovingObjectPosition var24 = var2.func_505_a(var13, var23, this.field_274_a == 0);
        if (var24 == null) {
            return var1;
        } else {
            if (var24.field_927_a == EnumMovingObjectType.TILE) {
                int var25 = var24.field_926_b;
                int var26 = var24.field_932_c;
                int var27 = var24.field_931_d;
                if (!var2.func_6157_a(var3, var25, var26, var27)) {
                    return var1;
                }

                if (this.field_274_a == 0) {
                    if (var2.func_443_c(var25, var26, var27) == Material.field_521_f && var2.func_446_b(var25, var26, var27) == 0) {
                        var2.func_508_d(var25, var26, var27, 0);
                        return new ItemStack(Item.field_4170_av);
                    }

                    if (var2.func_443_c(var25, var26, var27) == Material.field_520_g && var2.func_446_b(var25, var26, var27) == 0) {
                        var2.func_508_d(var25, var26, var27, 0);
                        return new ItemStack(Item.field_201_aw);
                    }
                } else {
                    if (this.field_274_a < 0) {
                        return new ItemStack(Item.field_205_au);
                    }

                    if (var24.field_930_e == 0) {
                        --var26;
                    }

                    if (var24.field_930_e == 1) {
                        ++var26;
                    }

                    if (var24.field_930_e == 2) {
                        --var27;
                    }

                    if (var24.field_930_e == 3) {
                        ++var27;
                    }

                    if (var24.field_930_e == 4) {
                        --var25;
                    }

                    if (var24.field_930_e == 5) {
                        ++var25;
                    }

                    if (var2.func_20111_e(var25, var26, var27) || !var2.func_443_c(var25, var26, var27).func_216_a()) {
                        if (var2.field_4272_q.field_6166_d && this.field_274_a == Block.field_598_B.field_573_bc) {
                            var2.func_502_a(var7 + 0.5D, var9 + 0.5D, var11 + 0.5D, "random.fizz", 0.5F, 2.6F + (var2.field_803_m.nextFloat() - var2.field_803_m.nextFloat()) * 0.8F);

                            for(int var28 = 0; var28 < 8; ++var28) {
                                var2.func_514_a("largesmoke", (double)var25 + Math.random(), (double)var26 + Math.random(), (double)var27 + Math.random(), 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            var2.func_507_b(var25, var26, var27, this.field_274_a, 0);
                        }

                        return new ItemStack(Item.field_205_au);
                    }
                }
            } else if (this.field_274_a == 0 && var24.field_928_g instanceof EntityCow) {
                return new ItemStack(Item.field_4204_aE);
            }

            return var1;
        }
    }
}
