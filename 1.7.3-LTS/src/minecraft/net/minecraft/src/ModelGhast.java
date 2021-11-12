package net.minecraft.src;

import java.util.Random;

public class ModelGhast extends ModelBase {
    ModelRenderer body;
    ModelRenderer[] tentacles = new ModelRenderer[9];

    public ModelGhast() {
        byte var1 = -16;
        this.body = new ModelRenderer(0, 0);
        this.body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
        ModelRenderer var10000 = this.body;
        var10000.rotationPointY += (float)(24 + var1);
        Random var2 = new Random(1660L);

        for(int var3 = 0; var3 < this.tentacles.length; ++var3) {
            this.tentacles[var3] = new ModelRenderer(0, 0);
            float var4 = (((float)(var3 % 3) - (float)(var3 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
            float var5 = ((float)(var3 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
            int var6 = var2.nextInt(7) + 8;
            this.tentacles[var3].addBox(-1.0F, 0.0F, -1.0F, 2, var6, 2);
            this.tentacles[var3].rotationPointX = var4;
            this.tentacles[var3].rotationPointZ = var5;
            this.tentacles[var3].rotationPointY = (float)(31 + var1);
        }

    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
        for(int var7 = 0; var7 < this.tentacles.length; ++var7) {
            this.tentacles[var7].rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + (float)var7) + 0.4F;
        }

    }

    public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.setRotationAngles(var1, var2, var3, var4, var5, var6);
        this.body.render(var6);

        for(int var7 = 0; var7 < this.tentacles.length; ++var7) {
            this.tentacles[var7].render(var6);
        }

    }
}
