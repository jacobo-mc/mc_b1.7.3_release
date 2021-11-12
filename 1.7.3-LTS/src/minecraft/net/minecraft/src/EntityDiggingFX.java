package net.minecraft.src;

public class EntityDiggingFX extends EntityFX {
    private Block blockInstance;
    private int field_32001_o = 0;

    public EntityDiggingFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12, Block var14, int var15, int var16) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.blockInstance = var14;
        this.particleTextureIndex = var14.getBlockTextureFromSideAndMetadata(0, var16);
        this.particleGravity = var14.blockParticleGravity;
        this.particleRed = this.particleGreen = this.particleBlue = 0.6F;
        this.particleScale /= 2.0F;
        this.field_32001_o = var15;
    }

    public EntityDiggingFX applyColourMultiplier(int var1, int var2, int var3) {
        if (this.blockInstance == Block.grass) {
            return this;
        } else {
            int var4 = this.blockInstance.colorMultiplier(this.worldObj, var1, var2, var3);
            this.particleRed *= (float)(var4 >> 16 & 255) / 255.0F;
            this.particleGreen *= (float)(var4 >> 8 & 255) / 255.0F;
            this.particleBlue *= (float)(var4 & 255) / 255.0F;
            return this;
        }
    }

    public int getFXLayer() {
        return 1;
    }

    public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)(this.particleTextureIndex % 16) + this.particleTextureJitterX / 4.0F) / 16.0F;
        float var9 = var8 + 0.015609375F;
        float var10 = ((float)(this.particleTextureIndex / 16) + this.particleTextureJitterY / 4.0F) / 16.0F;
        float var11 = var10 + 0.015609375F;
        float var12 = 0.1F * this.particleScale;
        float var13 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)var2 - interpPosX);
        float var14 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)var2 - interpPosY);
        float var15 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)var2 - interpPosZ);
        float var16 = this.getEntityBrightness(var2);
        var1.setColorOpaque_F(var16 * this.particleRed, var16 * this.particleGreen, var16 * this.particleBlue);
        var1.addVertexWithUV((double)(var13 - var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 - var5 * var12 - var7 * var12), (double)var8, (double)var11);
        var1.addVertexWithUV((double)(var13 - var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 - var5 * var12 + var7 * var12), (double)var8, (double)var10);
        var1.addVertexWithUV((double)(var13 + var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 + var5 * var12 + var7 * var12), (double)var9, (double)var10);
        var1.addVertexWithUV((double)(var13 + var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 + var5 * var12 - var7 * var12), (double)var9, (double)var11);
    }
}
