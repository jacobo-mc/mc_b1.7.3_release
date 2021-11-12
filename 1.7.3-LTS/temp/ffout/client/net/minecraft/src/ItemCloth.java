package net.minecraft.src;

public class ItemCloth extends ItemBlock {
    public ItemCloth(int var1) {
        super(var1);
        this.func_21013_d(0);
        this.func_21015_a(true);
    }

    public int func_27009_a(int var1) {
        return Block.field_419_ac.func_232_a(2, BlockCloth.func_21034_c(var1));
    }

    public int func_21012_a(int var1) {
        return var1;
    }

    public String func_21011_b(ItemStack var1) {
        return super.func_20009_a() + "." + ItemDye.field_21023_a[BlockCloth.func_21034_c(var1.func_21181_i())];
    }
}
