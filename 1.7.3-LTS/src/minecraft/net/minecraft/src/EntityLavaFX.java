package net.minecraft.src;

public class EntityLavaFX extends EntityFX {
    private float lavaParticleScale;

    public EntityLavaFX(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.800000011920929D;
        this.motionY *= 0.800000011920929D;
        this.motionZ *= 0.800000011920929D;
        this.motionY = (double)(this.rand.nextFloat() * 0.4F + 0.05F);
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleScale *= this.rand.nextFloat() * 2.0F + 0.2F;
        this.lavaParticleScale = this.particleScale;
        this.particleMaxAge = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        this.noClip = false;
        this.particleTextureIndex = 49;
    }

    public float getEntityBrightness(float var1) {
        return 1.0F;
    }

    public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.particleAge + var2) / (float)this.particleMaxAge;
        this.particleScale = this.lavaParticleScale * (1.0F - var8 * var8);
        super.renderParticle(var1, var2, var3, var4, var5, var6, var7);
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setEntityDead();
        }

        float var1 = (float)this.particleAge / (float)this.particleMaxAge;
        if (this.rand.nextFloat() > var1) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
        }

        this.motionY -= 0.03D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9990000128746033D;
        this.motionY *= 0.9990000128746033D;
        this.motionZ *= 0.9990000128746033D;
        if (this.onGround) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }

    }
}
