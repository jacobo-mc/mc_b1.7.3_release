package net.minecraft.src;

public class ItemCoal extends Item {
    public ItemCoal(int var1) {
        super(var1);
        this.func_21015_a(true);
        this.func_21013_d(0);
    }

    public String func_21011_b(ItemStack var1) {
        return var1.func_21181_i() == 1 ? "item.charcoal" : "item.coal";
    }
}
