package net.minecraft.src;

public class EntityTNTPrimed extends Entity {
    public int fuse;

    public EntityTNTPrimed(World var1) {
        super(var1);
        this.fuse = 0;
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
    }

    public EntityTNTPrimed(World var1, double var2, double var4, double var6) {
        this(var1);
        this.setPosition(var2, var4, var6);
        float var8 = (float)(Math.random() * 3.1415927410125732D * 2.0D);
        this.motionX = (double)(-MathHelper.sin(var8 * 3.1415927F / 180.0F) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-MathHelper.cos(var8 * 3.1415927F / 180.0F) * 0.02F);
        this.fuse = 80;
        this.prevPosX = var2;
        this.prevPosY = var4;
        this.prevPosZ = var6;
    }

    protected void entityInit() {
    }

    protected boolean func_25017_l() {
        return false;
    }

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;
        if (this.onGround) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fuse-- <= 0) {
            if (!this.worldObj.singleplayerWorld) {
                this.setEntityDead();
                this.explode();
            } else {
                this.setEntityDead();
            }
        } else {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }

    }

    private void explode() {
        float var1 = 4.0F;
        this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, var1);
    }

    protected void writeEntityToNBT(NBTTagCompound var1) {
        var1.setByte("Fuse", (byte)this.fuse);
    }

    protected void readEntityFromNBT(NBTTagCompound var1) {
        this.fuse = var1.getByte("Fuse");
    }
}
