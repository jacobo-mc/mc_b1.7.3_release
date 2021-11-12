package net.minecraft.src;

public class ModelSheep1 extends ModelQuadruped {
    public ModelSheep1() {
        super(12, 0.0F);
        this.head = new ModelRenderer(0, 0);
        this.head.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
        this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.body = new ModelRenderer(28, 8);
        this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        float var1 = 0.5F;
        this.leg1 = new ModelRenderer(0, 16);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
        this.leg2 = new ModelRenderer(0, 16);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
        this.leg3 = new ModelRenderer(0, 16);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
        this.leg4 = new ModelRenderer(0, 16);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
    }
}
