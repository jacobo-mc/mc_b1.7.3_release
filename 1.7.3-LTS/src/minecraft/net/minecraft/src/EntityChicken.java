package net.minecraft.src;

public class EntityChicken extends EntityAnimal {
    public boolean field_753_a = false;
    public float wingRotation = 0.0F;
    public float destPos = 0.0F;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 1.0F;
    public int timeUntilNextEgg;

    public EntityChicken(World var1) {
        super(var1);
        this.texture = "/mob/chicken.png";
        this.setSize(0.3F, 0.4F);
        this.health = 4;
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
        if (this.destPos < 0.0F) {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F) {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 1.0F;
        }

        this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }

        this.wingRotation += this.wingRotDelta * 2.0F;
        if (!this.worldObj.multiplayerWorld && --this.timeUntilNextEgg <= 0) {
            this.worldObj.playSoundAtEntity(this, "mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Item.egg.shiftedIndex, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }

    }

    protected void fall(float var1) {
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
    }

    protected String getLivingSound() {
        return "mob.chicken";
    }

    protected String getHurtSound() {
        return "mob.chickenhurt";
    }

    protected String getDeathSound() {
        return "mob.chickenhurt";
    }

    protected int getDropItemId() {
        return Item.feather.shiftedIndex;
    }
}
