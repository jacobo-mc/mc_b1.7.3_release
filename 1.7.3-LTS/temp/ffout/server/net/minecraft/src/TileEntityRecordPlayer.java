package net.minecraft.src;

public class TileEntityRecordPlayer extends TileEntity {
    public int field_28009_a;

    public void func_186_a(NBTTagCompound var1) {
        super.func_186_a(var1);
        this.field_28009_a = var1.func_395_d("Record");
    }

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        if (this.field_28009_a > 0) {
            var1.func_405_a("Record", this.field_28009_a);
        }

    }
}
