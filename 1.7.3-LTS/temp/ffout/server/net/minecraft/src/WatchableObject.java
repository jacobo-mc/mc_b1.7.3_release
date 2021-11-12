package net.minecraft.src;

public class WatchableObject {
    private final int field_21175_a;
    private final int field_21174_b;
    private Object field_21177_c;
    private boolean field_21176_d;

    public WatchableObject(int var1, int var2, Object var3) {
        this.field_21174_b = var2;
        this.field_21177_c = var3;
        this.field_21175_a = var1;
        this.field_21176_d = true;
    }

    public int func_21172_a() {
        return this.field_21174_b;
    }

    public void func_21171_a(Object var1) {
        this.field_21177_c = var1;
    }

    public Object func_21168_b() {
        return this.field_21177_c;
    }

    public int func_21169_c() {
        return this.field_21175_a;
    }

    public boolean func_21170_d() {
        return this.field_21176_d;
    }

    public void func_21173_a(boolean var1) {
        this.field_21176_d = var1;
    }
}
