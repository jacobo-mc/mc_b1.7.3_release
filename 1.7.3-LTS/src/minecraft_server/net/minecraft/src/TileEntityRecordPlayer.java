package net.minecraft.src;

public class TileEntityRecordPlayer extends TileEntity {
    public int field_28009_a;

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        this.field_28009_a = var1.getInteger("Record");
    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        if (this.field_28009_a > 0) {
            var1.setInteger("Record", this.field_28009_a);
        }

    }
}
