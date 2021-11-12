package net.minecraft.src;

public class ModelQuadruped extends ModelBase {
    public ModelRenderer head = new ModelRenderer(0, 0);
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;

    public ModelQuadruped(int var1, float var2) {
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, var2);
        this.head.setRotationPoint(0.0F, (float)(18 - var1), -6.0F);
        this.body = new ModelRenderer(28, 8);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, var2);
        this.body.setRotationPoint(0.0F, (float)(17 - var1), 2.0F);
        this.leg1 = new ModelRenderer(0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.leg1.setRotationPoint(-3.0F, (float)(24 - var1), 7.0F);
        this.leg2 = new ModelRenderer(0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.leg2.setRotationPoint(3.0F, (float)(24 - var1), 7.0F);
        this.leg3 = new ModelRenderer(0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.leg3.setRotationPoint(-3.0F, (float)(24 - var1), -5.0F);
        this.leg4 = new ModelRenderer(0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.leg4.setRotationPoint(3.0F, (float)(24 - var1), -5.0F);
    }

    public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.setRotationAngles(var1, var2, var3, var4, var5, var6);
        this.head.render(var6);
        this.body.render(var6);
        this.leg1.render(var6);
        this.leg2.render(var6);
        this.leg3.render(var6);
        this.leg4.render(var6);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.head.rotateAngleX = var5 / 57.295776F;
        this.head.rotateAngleY = var4 / 57.295776F;
        this.body.rotateAngleX = 1.5707964F;
        this.leg1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leg2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.leg3.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.leg4.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    }
}
