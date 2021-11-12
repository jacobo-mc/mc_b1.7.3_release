package net.minecraft.src;

public class ModelSquid extends ModelBase {
    ModelRenderer squidBody;
    ModelRenderer[] squidTentacles = new ModelRenderer[8];

    public ModelSquid() {
        byte var1 = -16;
        this.squidBody = new ModelRenderer(0, 0);
        this.squidBody.addBox(-6.0F, -8.0F, -6.0F, 12, 16, 12);
        ModelRenderer var10000 = this.squidBody;
        var10000.rotationPointY += (float)(24 + var1);

        for(int var2 = 0; var2 < this.squidTentacles.length; ++var2) {
            this.squidTentacles[var2] = new ModelRenderer(48, 0);
            double var3 = (double)var2 * 3.141592653589793D * 2.0D / (double)this.squidTentacles.length;
            float var5 = (float)Math.cos(var3) * 5.0F;
            float var6 = (float)Math.sin(var3) * 5.0F;
            this.squidTentacles[var2].addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2);
            this.squidTentacles[var2].rotationPointX = var5;
            this.squidTentacles[var2].rotationPointZ = var6;
            this.squidTentacles[var2].rotationPointY = (float)(31 + var1);
            var3 = (double)var2 * 3.141592653589793D * -2.0D / (double)this.squidTentacles.length + 1.5707963267948966D;
            this.squidTentacles[var2].rotateAngleY = (float)var3;
        }

    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
        for(int var7 = 0; var7 < this.squidTentacles.length; ++var7) {
            this.squidTentacles[var7].rotateAngleX = var3;
        }

    }

    public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.setRotationAngles(var1, var2, var3, var4, var5, var6);
        this.squidBody.render(var6);

        for(int var7 = 0; var7 < this.squidTentacles.length; ++var7) {
            this.squidTentacles[var7].render(var6);
        }

    }
}
