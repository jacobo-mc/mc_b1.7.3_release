package net.minecraft.src;

public abstract class MapDataBase {
    public final String field_28152_a;
    private boolean field_28151_b;

    public MapDataBase(String var1) {
        this.field_28152_a = var1;
    }

    public abstract void func_28148_a(NBTTagCompound var1);

    public abstract void func_28147_b(NBTTagCompound var1);

    public void func_28146_a() {
        this.func_28149_a(true);
    }

    public void func_28149_a(boolean var1) {
        this.field_28151_b = var1;
    }

    public boolean func_28150_b() {
        return this.field_28151_b;
    }
}
