package net.minecraft.src;

public class ModelCow extends ModelQuadruped {
    ModelRenderer udders;
    ModelRenderer horn1;
    ModelRenderer horn2;

    public ModelCow() {
        super(12, 0.0F);
        this.head = new ModelRenderer(0, 0);
        this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
        this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.horn1 = new ModelRenderer(22, 0);
        this.horn1.addBox(-4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        this.horn1.setRotationPoint(0.0F, 3.0F, -7.0F);
        this.horn2 = new ModelRenderer(22, 0);
        this.horn2.addBox(3.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        this.horn2.setRotationPoint(0.0F, 3.0F, -7.0F);
        this.udders = new ModelRenderer(52, 0);
        this.udders.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 2, 0.0F);
        this.udders.setRotationPoint(0.0F, 14.0F, 6.0F);
        this.udders.rotateAngleX = 1.5707964F;
        this.body = new ModelRenderer(18, 4);
        this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        --this.leg1.rotationPointX;
        ++this.leg2.rotationPointX;
        ModelRenderer var10000 = this.leg1;
        var10000.rotationPointZ += 0.0F;
        var10000 = this.leg2;
        var10000.rotationPointZ += 0.0F;
        --this.leg3.rotationPointX;
        ++this.leg4.rotationPointX;
        --this.leg3.rotationPointZ;
        --this.leg4.rotationPointZ;
    }

    public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.render(var1, var2, var3, var4, var5, var6);
        this.horn1.render(var6);
        this.horn2.render(var6);
        this.udders.render(var6);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6);
        this.horn1.rotateAngleY = this.head.rotateAngleY;
        this.horn1.rotateAngleX = this.head.rotateAngleX;
        this.horn2.rotateAngleY = this.head.rotateAngleY;
        this.horn2.rotateAngleX = this.head.rotateAngleX;
    }
}
