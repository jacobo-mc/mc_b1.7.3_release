package net.minecraft.src;

public class EntityFlameFX extends EntityFX {
    private float flameScale;

    public EntityFlameFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.motionX = this.motionX * 0.009999999776482582D + var8;
        this.motionY = this.motionY * 0.009999999776482582D + var10;
        this.motionZ = this.motionZ * 0.009999999776482582D + var12;
        double var10000 = var2 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        var10000 = var4 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        var10000 = var6 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.flameScale = this.particleScale;
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        this.noClip = true;
        this.particleTextureIndex = 48;
    }

    public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.particleAge + var2) / (float)this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0F - var8 * var8 * 0.5F);
        super.renderParticle(var1, var2, var3, var4, var5, var6, var7);
    }

    public float getEntityBrightness(float var1) {
        float var2 = ((float)this.particleAge + var1) / (float)this.particleMaxAge;
        if (var2 < 0.0F) {
            var2 = 0.0F;
        }

        if (var2 > 1.0F) {
            var2 = 1.0F;
        }

        float var3 = super.getEntityBrightness(var1);
        return var3 * var2 + (1.0F - var2);
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setEntityDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;
        if (this.onGround) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }

    }
}
