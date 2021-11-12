package net.minecraft.src;

public class ItemAxe extends ItemTool {
    private static Block[] field_327_aX;

    protected ItemAxe(int var1, EnumToolMaterial var2) {
        super(var1, 3, var2, field_327_aX);
    }

    static {
        field_327_aX = new Block[]{Block.field_334_y, Block.field_407_ao, Block.field_385_K, Block.field_396_av};
    }
}
