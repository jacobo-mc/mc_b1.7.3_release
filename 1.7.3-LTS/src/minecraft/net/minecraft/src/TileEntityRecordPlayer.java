package net.minecraft.src;

public class TileEntityRecordPlayer extends TileEntity {
    public int record;

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        this.record = var1.getInteger("Record");
    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        if (this.record > 0) {
            var1.setInteger("Record", this.record);
        }

    }
}
