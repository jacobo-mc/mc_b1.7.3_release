package net.minecraft.src;

public class InventoryLargeChest implements IInventory {
    private String field_837_a;
    private IInventory field_836_b;
    private IInventory field_838_c;

    public InventoryLargeChest(String var1, IInventory var2, IInventory var3) {
        this.field_837_a = var1;
        this.field_836_b = var2;
        this.field_838_c = var3;
    }

    public int func_469_c() {
        return this.field_836_b.func_469_c() + this.field_838_c.func_469_c();
    }

    public String func_471_d() {
        return this.field_837_a;
    }

    public ItemStack func_468_c(int var1) {
        return var1 >= this.field_836_b.func_469_c() ? this.field_838_c.func_468_c(var1 - this.field_836_b.func_469_c()) : this.field_836_b.func_468_c(var1);
    }

    public ItemStack func_473_a(int var1, int var2) {
        return var1 >= this.field_836_b.func_469_c() ? this.field_838_c.func_473_a(var1 - this.field_836_b.func_469_c(), var2) : this.field_836_b.func_473_a(var1, var2);
    }

    public void func_472_a(int var1, ItemStack var2) {
        if (var1 >= this.field_836_b.func_469_c()) {
            this.field_838_c.func_472_a(var1 - this.field_836_b.func_469_c(), var2);
        } else {
            this.field_836_b.func_472_a(var1, var2);
        }

    }

    public int func_470_e() {
        return this.field_836_b.func_470_e();
    }

    public void func_474_j_() {
        this.field_836_b.func_474_j_();
        this.field_838_c.func_474_j_();
    }

    public boolean func_20070_a_(EntityPlayer var1) {
        return this.field_836_b.func_20070_a_(var1) && this.field_838_c.func_20070_a_(var1);
    }
}
