package net.minecraft.src;

import java.util.List;

public class EntityFireball extends Entity {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private boolean inGround = false;
    public int shake = 0;
    public EntityLiving owner;
    private int field_9190_an;
    private int ticksInAir = 0;
    public double field_9199_b;
    public double field_9198_c;
    public double field_9196_d;

    public EntityFireball(World var1) {
        super(var1);
        this.setSize(1.0F, 1.0F);
    }

    protected void entityInit() {
    }

    public EntityFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
        super(var1);
        this.owner = var2;
        this.setSize(1.0F, 1.0F);
        this.setLocationAndAngles(var2.posX, var2.posY, var2.posZ, var2.rotationYaw, var2.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = this.motionY = this.motionZ = 0.0D;
        var3 += this.rand.nextGaussian() * 0.4D;
        var5 += this.rand.nextGaussian() * 0.4D;
        var7 += this.rand.nextGaussian() * 0.4D;
        double var9 = (double)MathHelper.sqrt_double(var3 * var3 + var5 * var5 + var7 * var7);
        this.field_9199_b = var3 / var9 * 0.1D;
        this.field_9198_c = var5 / var9 * 0.1D;
        this.field_9196_d = var7 / var9 * 0.1D;
    }

    public void onUpdate() {
        super.onUpdate();
        this.fire = 10;
        if (this.shake > 0) {
            --this.shake;
        }

        if (this.inGround) {
            int var1 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            if (var1 == this.inTile) {
                ++this.field_9190_an;
                if (this.field_9190_an == 1200) {
                    this.setEntityDead();
                }

                return;
            }

            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
            this.field_9190_an = 0;
            this.ticksInAir = 0;
        } else {
            ++this.ticksInAir;
        }

        Vec3D var15 = Vec3D.createVector(this.posX, this.posY, this.posZ);
        Vec3D var2 = Vec3D.createVector(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition var3 = this.worldObj.rayTraceBlocks(var15, var2);
        var15 = Vec3D.createVector(this.posX, this.posY, this.posZ);
        var2 = Vec3D.createVector(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (var3 != null) {
            var2 = Vec3D.createVector(var3.hitVec.xCoord, var3.hitVec.yCoord, var3.hitVec.zCoord);
        }

        Entity var4 = null;
        List var5 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
        double var6 = 0.0D;

        for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if (var9.canBeCollidedWith() && (var9 != this.owner || this.ticksInAir >= 25)) {
                float var10 = 0.3F;
                AxisAlignedBB var11 = var9.boundingBox.expand((double)var10, (double)var10, (double)var10);
                MovingObjectPosition var12 = var11.func_706_a(var15, var2);
                if (var12 != null) {
                    double var13 = var15.distanceTo(var12.hitVec);
                    if (var13 < var6 || var6 == 0.0D) {
                        var4 = var9;
                        var6 = var13;
                    }
                }
            }
        }

        if (var4 != null) {
            var3 = new MovingObjectPosition(var4);
        }

        if (var3 != null) {
            if (!this.worldObj.singleplayerWorld) {
                if (var3.entityHit != null && var3.entityHit.attackEntityFrom(this.owner, 0)) {
                }

                this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.0F, true);
            }

            this.setEntityDead();
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float var16 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

        for(this.rotationPitch = (float)(Math.atan2(this.motionY, (double)var16) * 180.0D / 3.1415927410125732D); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
        }

        while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
            this.prevRotationPitch += 360.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        float var17 = 0.95F;
        if (this.isInWater()) {
            for(int var18 = 0; var18 < 4; ++var18) {
                float var19 = 0.25F;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)var19, this.posY - this.motionY * (double)var19, this.posZ - this.motionZ * (double)var19, this.motionX, this.motionY, this.motionZ);
            }

            var17 = 0.8F;
        }

        this.motionX += this.field_9199_b;
        this.motionY += this.field_9198_c;
        this.motionZ += this.field_9196_d;
        this.motionX *= (double)var17;
        this.motionY *= (double)var17;
        this.motionZ *= (double)var17;
        this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        var1.setShort("xTile", (short)this.xTile);
        var1.setShort("yTile", (short)this.yTile);
        var1.setShort("zTile", (short)this.zTile);
        var1.setByte("inTile", (byte)this.inTile);
        var1.setByte("shake", (byte)this.shake);
        var1.setByte("inGround", (byte)(this.inGround ? 1 : 0));
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        this.xTile = var1.getShort("xTile");
        this.yTile = var1.getShort("yTile");
        this.zTile = var1.getShort("zTile");
        this.inTile = var1.getByte("inTile") & 255;
        this.shake = var1.getByte("shake") & 255;
        this.inGround = var1.getByte("inGround") == 1;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean attackEntityFrom(Entity var1, int var2) {
        this.setBeenAttacked();
        if (var1 != null) {
            Vec3D var3 = var1.getLookVec();
            if (var3 != null) {
                this.motionX = var3.xCoord;
                this.motionY = var3.yCoord;
                this.motionZ = var3.zCoord;
                this.field_9199_b = this.motionX * 0.1D;
                this.field_9198_c = this.motionY * 0.1D;
                this.field_9196_d = this.motionZ * 0.1D;
            }

            return true;
        } else {
            return false;
        }
    }
}
