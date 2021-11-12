package net.minecraft.src;

public class BlockOreStorage extends Block {
    public BlockOreStorage(int var1, int var2) {
        super(var1, Material.field_522_e);
        this.field_575_bb = var2;
    }

    public int func_241_a(int var1) {
        return this.field_575_bb;
    }
}
