package net.minecraft.src;

public class ItemBoat extends Item {
    public ItemBoat(int var1) {
        super(var1);
        this.field_290_aT = 1;
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
        MovingObjectPosition var24 = var2.func_642_a(var13, var23, true);
        if (var24 == null) {
            return var1;
        } else {
            if (var24.field_1167_a == EnumMovingObjectType.TILE) {
                int var25 = var24.field_1166_b;
                int var26 = var24.field_1172_c;
                int var27 = var24.field_1171_d;
                if (!var2.field_1026_y) {
                    if (var2.func_600_a(var25, var26, var27) == Block.field_428_aT.field_376_bc) {
                        --var26;
                    }

                    var2.func_674_a(new EntityBoat(var2, (double)((float)var25 + 0.5F), (double)((float)var26 + 1.0F), (double)((float)var27 + 0.5F)));
                }

                --var1.field_1615_a;
            }

            return var1;
        }
    }
}
