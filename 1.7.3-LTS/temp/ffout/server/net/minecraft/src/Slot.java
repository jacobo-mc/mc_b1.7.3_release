package net.minecraft.src;

public class Slot {
    private final int field_20097_a;
    private final IInventory field_20096_b;
    public int field_20100_c;
    public int field_20099_d;
    public int field_20098_e;

    public Slot(IInventory var1, int var2, int var3, int var4) {
        this.field_20096_b = var1;
        this.field_20097_a = var2;
        this.field_20099_d = var3;
        this.field_20098_e = var4;
    }

    public void func_20091_b(ItemStack var1) {
        this.func_20094_d();
    }

    public boolean func_20095_a(ItemStack var1) {
        return true;
    }

    public ItemStack func_20092_c() {
        return this.field_20096_b.func_82_a(this.field_20097_a);
    }

    public boolean func_27006_b() {
        return this.func_20092_c() != null;
    }

    public void func_20089_b(ItemStack var1) {
        this.field_20096_b.func_206_a(this.field_20097_a, var1);
        this.func_20094_d();
    }

    public void func_20094_d() {
        this.field_20096_b.func_183_c();
    }

    public int func_20093_a() {
        return this.field_20096_b.func_202_d();
    }

    public ItemStack func_20088_a(int var1) {
        return this.field_20096_b.func_20069_a(this.field_20097_a, var1);
    }

    public boolean func_20090_a(IInventory var1, int var2) {
        return var1 == this.field_20096_b && var2 == this.field_20097_a;
    }
}
