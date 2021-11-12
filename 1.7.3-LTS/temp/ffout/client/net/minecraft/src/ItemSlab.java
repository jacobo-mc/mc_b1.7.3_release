package net.minecraft.src;

public class ItemSlab extends ItemBlock {
    public ItemSlab(int var1) {
        super(var1);
        this.func_21013_d(0);
        this.func_21015_a(true);
    }

    public int func_27009_a(int var1) {
        return Block.field_410_al.func_232_a(2, var1);
    }

    public int func_21012_a(int var1) {
        return var1;
    }

    public String func_21011_b(ItemStack var1) {
        return super.func_20009_a() + "." + BlockStep.field_22037_a[var1.func_21181_i()];
    }
}
