package net.minecraft.src;

public class ItemSpade extends ItemTool {
    private static Block[] field_4206_bb;

    public ItemSpade(int var1, EnumToolMaterial var2) {
        super(var1, 1, var2, field_4206_bb);
    }

    public boolean func_80_a(Block var1) {
        if (var1 == Block.field_625_aT) {
            return true;
        } else {
            return var1 == Block.field_4076_aV;
        }
    }

    static {
        field_4206_bb = new Block[]{Block.field_534_v, Block.field_533_w, Block.field_590_F, Block.field_4062_G, Block.field_625_aT, Block.field_4076_aV, Block.field_621_aX, Block.field_643_aB};
    }
}
