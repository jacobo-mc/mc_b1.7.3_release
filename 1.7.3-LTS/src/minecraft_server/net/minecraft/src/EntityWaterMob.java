package net.minecraft.src;

public class EntityWaterMob extends EntityCreature implements IAnimals {
    public EntityWaterMob(World var1) {
        super(var1);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox);
    }

    public int getTalkInterval() {
        return 120;
    }
}
