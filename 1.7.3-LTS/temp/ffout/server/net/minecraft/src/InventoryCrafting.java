package net.minecraft.src;

public class InventoryCrafting implements IInventory {
    private ItemStack[] field_20076_a;
    private int field_21085_b;
    private Container field_20077_c;

    public InventoryCrafting(Container var1, int var2, int var3) {
        int var4 = var2 * var3;
        this.field_20076_a = new ItemStack[var4];
        this.field_20077_c = var1;
        this.field_21085_b = var2;
    }

    public int func_83_a() {
        return this.field_20076_a.length;
    }

    public ItemStack func_82_a(int var1) {
        return var1 >= this.func_83_a() ? null : this.field_20076_a[var1];
    }

    public ItemStack func_21084_a(int var1, int var2) {
        if (var1 >= 0 && var1 < this.field_21085_b) {
            int var3 = var1 + var2 * this.field_21085_b;
            return this.func_82_a(var3);
        } else {
            return null;
        }
    }

    public String func_20068_b() {
        return "Crafting";
    }

    public ItemStack func_20069_a(int var1, int var2) {
        if (this.field_20076_a[var1] != null) {
            ItemStack var3;
            if (this.field_20076_a[var1].field_853_a <= var2) {
                var3 = this.field_20076_a[var1];
                this.field_20076_a[var1] = null;
                this.field_20077_c.func_20121_a(this);
                return var3;
            } else {
                var3 = this.field_20076_a[var1].func_20118_a(var2);
                if (this.field_20076_a[var1].field_853_a == 0) {
                    this.field_20076_a[var1] = null;
                }

                this.field_20077_c.func_20121_a(this);
                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_206_a(int var1, ItemStack var2) {
        this.field_20076_a[var1] = var2;
        this.field_20077_c.func_20121_a(this);
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
