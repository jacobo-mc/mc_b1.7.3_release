package net.minecraft.src;

public class InventoryCrafting implements IInventory {
    private ItemStack[] field_840_a;
    private int field_21104_b;
    private Container field_841_c;

    public InventoryCrafting(Container var1, int var2, int var3) {
        int var4 = var2 * var3;
        this.field_840_a = new ItemStack[var4];
        this.field_841_c = var1;
        this.field_21104_b = var2;
    }

    public int func_469_c() {
        return this.field_840_a.length;
    }

    public ItemStack func_468_c(int var1) {
        return var1 >= this.func_469_c() ? null : this.field_840_a[var1];
    }

    public ItemStack func_21103_b(int var1, int var2) {
        if (var1 >= 0 && var1 < this.field_21104_b) {
            int var3 = var1 + var2 * this.field_21104_b;
            return this.func_468_c(var3);
        } else {
            return null;
        }
    }

    public String func_471_d() {
        return "Crafting";
    }

    public ItemStack func_473_a(int var1, int var2) {
        if (this.field_840_a[var1] != null) {
            ItemStack var3;
            if (this.field_840_a[var1].field_1615_a <= var2) {
                var3 = this.field_840_a[var1];
                this.field_840_a[var1] = null;
                this.field_841_c.func_1103_a(this);
                return var3;
            } else {
                var3 = this.field_840_a[var1].func_1085_a(var2);
                if (this.field_840_a[var1].field_1615_a == 0) {
                    this.field_840_a[var1] = null;
                }

                this.field_841_c.func_1103_a(this);
                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_472_a(int var1, ItemStack var2) {
        this.field_840_a[var1] = var2;
        this.field_841_c.func_1103_a(this);
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
