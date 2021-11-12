package net.minecraft.src;

public abstract class MapDataBase {
    public final String field_28168_a;
    private boolean field_28167_b;

    public MapDataBase(String var1) {
        this.field_28168_a = var1;
    }

    public abstract void func_28163_a(NBTTagCompound var1);

    public abstract void func_28162_b(NBTTagCompound var1);

    public void func_28164_a() {
        this.func_28165_a(true);
    }

    public void func_28165_a(boolean var1) {
        this.field_28167_b = var1;
    }

    public boolean func_28166_b() {
        return this.field_28167_b;
    }
}
