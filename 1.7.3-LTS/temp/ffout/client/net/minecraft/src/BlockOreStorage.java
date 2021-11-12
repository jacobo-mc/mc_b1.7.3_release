package net.minecraft.src;

public class BlockOreStorage extends Block {
    public BlockOreStorage(int var1, int var2) {
        super(var1, Material.field_1333_e);
        this.field_378_bb = var2;
    }

    public int func_218_a(int var1) {
        return this.field_378_bb;
    }
}
