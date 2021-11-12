package net.minecraft.src;

public class BlockLeavesBase extends Block {
    protected boolean field_6088_a;

    protected BlockLeavesBase(int var1, int var2, Material var3, boolean var4) {
        super(var1, var2, var3);
        this.field_6088_a = var4;
    }

    public boolean func_240_b() {
        return false;
    }
}
