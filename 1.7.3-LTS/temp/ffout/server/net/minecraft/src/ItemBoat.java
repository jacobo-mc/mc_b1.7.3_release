package net.minecraft.src;

public class ItemBoat extends Item {
    public ItemBoat(int var1) {
        super(var1);
        this.field_233_aT = 1;
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
        MovingObjectPosition var24 = var2.func_505_a(var13, var23, true);
        if (var24 == null) {
            return var1;
        } else {
            if (var24.field_927_a == EnumMovingObjectType.TILE) {
                int var25 = var24.field_926_b;
                int var26 = var24.field_932_c;
                int var27 = var24.field_931_d;
                if (!var2.field_792_x) {
                    if (var2.func_444_a(var25, var26, var27) == Block.field_625_aT.field_573_bc) {
                        --var26;
                    }

                    var2.func_526_a(new EntityBoat(var2, (double)((float)var25 + 0.5F), (double)((float)var26 + 1.0F), (double)((float)var27 + 0.5F)));
                }

                --var1.field_853_a;
            }

            return var1;
        }
    }
}
