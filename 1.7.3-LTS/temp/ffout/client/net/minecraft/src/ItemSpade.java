package net.minecraft.src;

public class ItemSpade extends ItemTool {
    private static Block[] field_326_aX;

    public ItemSpade(int var1, EnumToolMaterial var2) {
        super(var1, 1, var2, field_326_aX);
    }

    public boolean func_4018_a(Block var1) {
        if (var1 == Block.field_428_aT) {
            return true;
        } else {
            return var1 == Block.field_426_aV;
        }
    }

    static {
        field_326_aX = new Block[]{Block.field_337_v, Block.field_336_w, Block.field_393_F, Block.field_392_G, Block.field_428_aT, Block.field_426_aV, Block.field_424_aX, Block.field_446_aB};
    }
}
