package net.minecraft.src;

public class TileEntityRecordPlayer extends TileEntity {
    public int field_28017_a;

    public void func_482_a(NBTTagCompound var1) {
        super.func_482_a(var1);
        this.field_28017_a = var1.func_756_e("Record");
    }

    public void func_481_b(NBTTagCompound var1) {
        super.func_481_b(var1);
        if (this.field_28017_a > 0) {
            var1.func_758_a("Record", this.field_28017_a);
        }

    }
}
