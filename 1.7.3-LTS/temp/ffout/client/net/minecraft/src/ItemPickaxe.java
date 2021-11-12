package net.minecraft.src;

public class ItemPickaxe extends ItemTool {
    private static Block[] field_329_aX;

    protected ItemPickaxe(int var1, EnumToolMaterial var2) {
        super(var1, 2, var2, field_329_aX);
    }

    public boolean func_4018_a(Block var1) {
        if (var1 == Block.field_405_aq) {
            return this.field_20927_a.func_21208_d() == 3;
        } else if (var1 != Block.field_389_ay && var1 != Block.field_391_ax) {
            if (var1 != Block.field_413_ai && var1 != Block.field_390_H) {
                if (var1 != Block.field_412_aj && var1 != Block.field_388_I) {
                    if (var1 != Block.field_9266_O && var1 != Block.field_9267_N) {
                        if (var1 != Block.field_433_aO && var1 != Block.field_432_aP) {
                            if (var1.field_356_bn == Material.field_1334_d) {
                                return true;
                            } else {
                                return var1.field_356_bn == Material.field_1333_e;
                            }
                        } else {
                            return this.field_20927_a.func_21208_d() >= 2;
                        }
                    } else {
                        return this.field_20927_a.func_21208_d() >= 1;
                    }
                } else {
                    return this.field_20927_a.func_21208_d() >= 1;
                }
            } else {
                return this.field_20927_a.func_21208_d() >= 2;
            }
        } else {
            return this.field_20927_a.func_21208_d() >= 2;
        }
    }

    static {
        field_329_aX = new Block[]{Block.field_335_x, Block.field_411_ak, Block.field_410_al, Block.field_338_u, Block.field_9264_Q, Block.field_406_ap, Block.field_388_I, Block.field_412_aj, Block.field_386_J, Block.field_413_ai, Block.field_390_H, Block.field_391_ax, Block.field_389_ay, Block.field_4063_aU, Block.field_4053_bc, Block.field_9267_N, Block.field_9266_O};
    }
}
