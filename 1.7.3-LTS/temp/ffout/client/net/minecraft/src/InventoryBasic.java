package net.minecraft.src;

import java.util.List;

public class InventoryBasic implements IInventory {
    private String field_20072_a;
    private int field_20071_b;
    private ItemStack[] field_20074_c;
    private List field_20073_d;

    public InventoryBasic(String var1, int var2) {
        this.field_20072_a = var1;
        this.field_20071_b = var2;
        this.field_20074_c = new ItemStack[var2];
    }

    public ItemStack func_468_c(int var1) {
        return this.field_20074_c[var1];
    }

    public ItemStack func_473_a(int var1, int var2) {
        if (this.field_20074_c[var1] != null) {
            ItemStack var3;
            if (this.field_20074_c[var1].field_1615_a <= var2) {
                var3 = this.field_20074_c[var1];
                this.field_20074_c[var1] = null;
                this.func_474_j_();
                return var3;
            } else {
                var3 = this.field_20074_c[var1].func_1085_a(var2);
                if (this.field_20074_c[var1].field_1615_a == 0) {
                    this.field_20074_c[var1] = null;
                }

                this.func_474_j_();
                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_472_a(int var1, ItemStack var2) {
        this.field_20074_c[var1] = var2;
        if (var2 != null && var2.field_1615_a > this.func_470_e()) {
            var2.field_1615_a = this.func_470_e();
        }

        this.func_474_j_();
    }

    public int func_469_c() {
        return this.field_20071_b;
    }

    public String func_471_d() {
        return this.field_20072_a;
    }

    public int func_470_e() {
        return 64;
    }

    public void func_474_j_() {
        if (this.field_20073_d != null) {
            for(int var1 = 0; var1 < this.field_20073_d.size(); ++var1) {
                ((IInvBasic)this.field_20073_d.get(var1)).func_20134_a(this);
            }
        }

    }

    public boolean func_20070_a_(EntityPlayer var1) {
        return true;
    }
}
