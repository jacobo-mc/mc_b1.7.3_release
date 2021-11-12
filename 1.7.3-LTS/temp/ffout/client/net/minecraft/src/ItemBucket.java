package net.minecraft.src;

public class ItemBucket extends Item {
    private int field_331_a;

    public ItemBucket(int var1, int var2) {
        super(var1);
        this.field_290_aT = 1;
        this.field_331_a = var2;
    }

    public ItemStack func_193_a(ItemStack var1, World var2, EntityPlayer var3) {
        float var4 = 1.0F;
        float var5 = var3.field_602_at + (var3.field_604_ar - var3.field_602_at) * var4;
        float var6 = var3.field_603_as + (var3.field_605_aq - var3.field_603_as) * var4;
        double var7 = var3.field_9285_at + (var3.field_611_ak - var3.field_9285_at) * (double)var4;
        double var9 = var3.field_9284_au + (var3.field_610_al - var3.field_9284_au) * (double)var4 + 1.62D - (double)var3.field_9292_aO;
        double var11 = var3.field_9283_av + (var3.field_609_am - var3.field_9283_av) * (double)var4;
        Vec3D var13 = Vec3D.func_1248_b(var7, var9, var11);
        float var14 = MathHelper.func_1114_b(-var6 * 0.017453292F - 3.1415927F);
        float var15 = MathHelper.func_1106_a(-var6 * 0.017453292F - 3.1415927F);
        float var16 = -MathHelper.func_1114_b(-var5 * 0.017453292F);
        float var17 = MathHelper.func_1106_a(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var20 = var14 * var16;
        double var21 = 5.0D;
        Vec3D var23 = var13.func_1257_c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
        MovingObjectPosition var24 = var2.func_642_a(var13, var23, this.field_331_a == 0);
        if (var24 == null) {
            return var1;
        } else {
            if (var24.field_1167_a == EnumMovingObjectType.TILE) {
                int var25 = var24.field_1166_b;
                int var26 = var24.field_1172_c;
                int var27 = var24.field_1171_d;
                if (!var2.func_6466_a(var3, var25, var26, var27)) {
                    return var1;
                }

                if (this.field_331_a == 0) {
                    if (var2.func_599_f(var25, var26, var27) == Material.field_1332_f && var2.func_602_e(var25, var26, var27) == 0) {
                        var2.func_690_d(var25, var26, var27, 0);
                        return new ItemStack(Item.field_4016_av);
                    }

                    if (var2.func_599_f(var25, var26, var27) == Material.field_1331_g && var2.func_602_e(var25, var26, var27) == 0) {
                        var2.func_690_d(var25, var26, var27, 0);
                        return new ItemStack(Item.field_258_aw);
                    }
                } else {
                    if (this.field_331_a < 0) {
                        return new ItemStack(Item.field_262_au);
                    }

                    if (var24.field_1170_e == 0) {
                        --var26;
                    }

                    if (var24.field_1170_e == 1) {
                        ++var26;
                    }

                    if (var24.field_1170_e == 2) {
                        --var27;
                    }

                    if (var24.field_1170_e == 3) {
                        ++var27;
                    }

                    if (var24.field_1170_e == 4) {
                        --var25;
                    }

                    if (var24.field_1170_e == 5) {
                        ++var25;
                    }

                    if (var2.func_20084_d(var25, var26, var27) || !var2.func_599_f(var25, var26, var27).func_878_a()) {
                        if (var2.field_4209_q.field_6479_d && this.field_331_a == Block.field_401_B.field_376_bc) {
                            var2.func_684_a(var7 + 0.5D, var9 + 0.5D, var11 + 0.5D, "random.fizz", 0.5F, 2.6F + (var2.field_1037_n.nextFloat() - var2.field_1037_n.nextFloat()) * 0.8F);

                            for(int var28 = 0; var28 < 8; ++var28) {
                                var2.func_694_a("largesmoke", (double)var25 + Math.random(), (double)var26 + Math.random(), (double)var27 + Math.random(), 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            var2.func_688_b(var25, var26, var27, this.field_331_a, 0);
                        }

                        return new ItemStack(Item.field_262_au);
                    }
                }
            } else if (this.field_331_a == 0 && var24.field_1168_g instanceof EntityCow) {
                return new ItemStack(Item.field_305_aE);
            }

            return var1;
        }
    }
}
