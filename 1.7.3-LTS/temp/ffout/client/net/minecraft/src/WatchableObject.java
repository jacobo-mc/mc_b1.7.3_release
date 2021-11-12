package net.minecraft.src;

public class WatchableObject {
    private final int field_21164_a;
    private final int field_21163_b;
    private Object field_21166_c;
    private boolean field_21165_d;

    public WatchableObject(int var1, int var2, Object var3) {
        this.field_21163_b = var2;
        this.field_21166_c = var3;
        this.field_21164_a = var1;
        this.field_21165_d = true;
    }

    public int func_21161_a() {
        return this.field_21163_b;
    }

    public void func_21160_a(Object var1) {
        this.field_21166_c = var1;
    }

    public Object func_21158_b() {
        return this.field_21166_c;
    }

    public int func_21159_c() {
        return this.field_21164_a;
    }

    public void func_21162_a(boolean var1) {
        this.field_21165_d = var1;
    }
}
