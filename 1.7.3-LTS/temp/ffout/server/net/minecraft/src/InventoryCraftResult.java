package net.minecraft.src;

public class InventoryCraftResult implements IInventory {
    private ItemStack[] field_20071_a = new ItemStack[1];

    public int func_83_a() {
        return 1;
    }

    public ItemStack func_82_a(int var1) {
        return this.field_20071_a[var1];
    }

    public String func_20068_b() {
        return "Result";
    }

    public ItemStack func_20069_a(int var1, int var2) {
        if (this.field_20071_a[var1] != null) {
            ItemStack var3 = this.field_20071_a[var1];
            this.field_20071_a[var1] = null;
            return var3;
        } else {
            return null;
        }
    }

    public void func_206_a(int var1, ItemStack var2) {
        this.field_20071_a[var1] = var2;
    }

    public int func_202_d() {
        return 64;
    }

    public void func_183_c() {
    }

    public boolean func_20067_a_(EntityPlayer var1) {
        return true;
    }
}
