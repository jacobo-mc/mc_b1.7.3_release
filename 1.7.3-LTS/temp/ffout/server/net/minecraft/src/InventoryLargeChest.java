package net.minecraft.src;

public class InventoryLargeChest implements IInventory {
    private String field_502_a;
    private IInventory field_501_b;
    private IInventory field_503_c;

    public InventoryLargeChest(String var1, IInventory var2, IInventory var3) {
        this.field_502_a = var1;
        this.field_501_b = var2;
        this.field_503_c = var3;
    }

    public int func_83_a() {
        return this.field_501_b.func_83_a() + this.field_503_c.func_83_a();
    }

    public String func_20068_b() {
        return this.field_502_a;
    }

    public ItemStack func_82_a(int var1) {
        return var1 >= this.field_501_b.func_83_a() ? this.field_503_c.func_82_a(var1 - this.field_501_b.func_83_a()) : this.field_501_b.func_82_a(var1);
    }

    public ItemStack func_20069_a(int var1, int var2) {
        return var1 >= this.field_501_b.func_83_a() ? this.field_503_c.func_20069_a(var1 - this.field_501_b.func_83_a(), var2) : this.field_501_b.func_20069_a(var1, var2);
    }

    public void func_206_a(int var1, ItemStack var2) {
        if (var1 >= this.field_501_b.func_83_a()) {
            this.field_503_c.func_206_a(var1 - this.field_501_b.func_83_a(), var2);
        } else {
            this.field_501_b.func_206_a(var1, var2);
        }

    }

    public int func_202_d() {
        return this.field_501_b.func_202_d();
    }

    public void func_183_c() {
        this.field_501_b.func_183_c();
        this.field_503_c.func_183_c();
    }

    public boolean func_20067_a_(EntityPlayer var1) {
        return this.field_501_b.func_20067_a_(var1) && this.field_503_c.func_20067_a_(var1);
    }
}
