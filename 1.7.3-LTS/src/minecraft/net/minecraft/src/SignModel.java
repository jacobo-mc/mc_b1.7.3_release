package net.minecraft.src;

public class SignModel {
    public ModelRenderer signBoard = new ModelRenderer(0, 0);
    public ModelRenderer signStick;

    public SignModel() {
        this.signBoard.addBox(-12.0F, -14.0F, -1.0F, 24, 12, 2, 0.0F);
        this.signStick = new ModelRenderer(0, 14);
        this.signStick.addBox(-1.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
    }

    public void func_887_a() {
        this.signBoard.render(0.0625F);
        this.signStick.render(0.0625F);
    }
}
