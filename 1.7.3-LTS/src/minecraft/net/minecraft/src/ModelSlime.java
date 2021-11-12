package net.minecraft.src;

public class ModelSlime extends ModelBase {
    ModelRenderer slimeBodies;
    ModelRenderer slimeRightEye;
    ModelRenderer slimeLeftEye;
    ModelRenderer slimeMouth;

    public ModelSlime(int var1) {
        this.slimeBodies = new ModelRenderer(0, var1);
        this.slimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);
        if (var1 > 0) {
            this.slimeBodies = new ModelRenderer(0, var1);
            this.slimeBodies.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(32, 0);
            this.slimeRightEye.addBox(-3.25F, 18.0F, -3.5F, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(32, 4);
            this.slimeLeftEye.addBox(1.25F, 18.0F, -3.5F, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(32, 8);
            this.slimeMouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1);
        }

    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
    }

    public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.setRotationAngles(var1, var2, var3, var4, var5, var6);
        this.slimeBodies.render(var6);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.render(var6);
            this.slimeLeftEye.render(var6);
            this.slimeMouth.render(var6);
        }

    }
}
