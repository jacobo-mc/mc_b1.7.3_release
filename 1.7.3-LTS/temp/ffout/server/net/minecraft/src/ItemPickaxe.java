package net.minecraft.src;

public class ItemPickaxe extends ItemTool {
    private static Block[] field_4209_bb;

    protected ItemPickaxe(int var1, EnumToolMaterial var2) {
        super(var1, 2, var2, field_4209_bb);
    }

    public boolean func_80_a(Block var1) {
        if (var1 == Block.field_602_aq) {
            return this.field_20913_a.func_21181_d() == 3;
        } else if (var1 != Block.field_4060_ay && var1 != Block.field_588_ax) {
            if (var1 != Block.field_4068_ai && var1 != Block.field_4061_H) {
                if (var1 != Block.field_4067_aj && var1 != Block.field_4059_I) {
                    if (var1 != Block.field_9041_O && var1 != Block.field_9042_N) {
                        if (var1 != Block.field_630_aO && var1 != Block.field_629_aP) {
                            if (var1.field_553_bn == Material.field_523_d) {
                                return true;
                            } else {
                                return var1.field_553_bn == Material.field_522_e;
                            }
                        } else {
                            return this.field_20913_a.func_21181_d() >= 2;
                        }
                    } else {
                        return this.field_20913_a.func_21181_d() >= 1;
                    }
                } else {
                    return this.field_20913_a.func_21181_d() >= 1;
                }
            } else {
                return this.field_20913_a.func_21181_d() >= 2;
            }
        } else {
            return this.field_20913_a.func_21181_d() >= 2;
        }
    }

    static {
        field_4209_bb = new Block[]{Block.field_532_x, Block.field_608_ak, Block.field_607_al, Block.field_535_u, Block.field_9039_Q, Block.field_603_ap, Block.field_4059_I, Block.field_4067_aj, Block.field_583_J, Block.field_4068_ai, Block.field_4061_H, Block.field_588_ax, Block.field_4060_ay, Block.field_4077_aU, Block.field_4050_bc, Block.field_9042_N, Block.field_9041_O};
    }
}
