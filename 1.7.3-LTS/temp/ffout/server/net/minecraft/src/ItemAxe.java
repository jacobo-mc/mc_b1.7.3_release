package net.minecraft.src;

public class ItemAxe extends ItemTool {
    private static Block[] field_4207_bb;

    protected ItemAxe(int var1, EnumToolMaterial var2) {
        super(var1, 3, var2, field_4207_bb);
    }

    static {
        field_4207_bb = new Block[]{Block.field_531_y, Block.field_604_ao, Block.field_582_K, Block.field_593_av};
    }
}
