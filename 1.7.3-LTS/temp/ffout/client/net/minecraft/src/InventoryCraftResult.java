package net.minecraft.src;

public class InventoryCraftResult implements IInventory {
    private ItemStack[] field_818_a = new ItemStack[1];

    public int func_469_c() {
        return 1;
    }

    public ItemStack func_468_c(int var1) {
        return this.field_818_a[var1];
    }

    public String func_471_d() {
        return "Result";
    }

    public ItemStack func_473_a(int var1, int var2) {
        if (this.field_818_a[var1] != null) {
            ItemStack var3 = this.field_818_a[var1];
            this.field_818_a[var1] = null;
            return var3;
        } else {
            return null;
        }
    }

    public void func_472_a(int var1, ItemStack var2) {
        this.field_818_a[var1] = var2;
    }

    public int func_470_e() {
        return 64;
    }

    public void func_474_j_() {
    }

    public boolean func_20070_a_(EntityPlayer var1) {
        return true;
    }
}
