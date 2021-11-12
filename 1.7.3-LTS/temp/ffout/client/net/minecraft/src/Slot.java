package net.minecraft.src;

public class Slot {
    private final int field_1119_a;
    private final IInventory field_1118_b;
    public int field_20007_a;
    public int field_20006_b;
    public int field_20008_c;

    public Slot(IInventory var1, int var2, int var3, int var4) {
        this.field_1118_b = var1;
        this.field_1119_a = var2;
        this.field_20006_b = var3;
        this.field_20008_c = var4;
    }

    public void func_4103_a(ItemStack var1) {
        this.func_779_d();
    }

    public boolean func_4105_a(ItemStack var1) {
        return true;
    }

    public ItemStack func_777_b() {
        return this.field_1118_b.func_468_c(this.field_1119_a);
    }

    public boolean func_20005_c() {
        return this.func_777_b() != null;
    }

    public void func_776_b(ItemStack var1) {
        this.field_1118_b.func_472_a(this.field_1119_a, var1);
        this.func_779_d();
    }

    public void func_779_d() {
        this.field_1118_b.func_474_j_();
    }

    public int func_4104_e() {
        return this.field_1118_b.func_470_e();
    }

    public int func_775_c() {
        return -1;
    }

    public ItemStack func_20004_a(int var1) {
        return this.field_1118_b.func_473_a(this.field_1119_a, var1);
    }
}
