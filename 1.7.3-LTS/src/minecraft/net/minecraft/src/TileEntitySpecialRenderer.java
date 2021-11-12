package net.minecraft.src;

public abstract class TileEntitySpecialRenderer {
    protected TileEntityRenderer tileEntityRenderer;

    public abstract void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8);

    protected void bindTextureByName(String var1) {
        RenderEngine var2 = this.tileEntityRenderer.renderEngine;
        var2.bindTexture(var2.getTexture(var1));
    }

    public void setTileEntityRenderer(TileEntityRenderer var1) {
        this.tileEntityRenderer = var1;
    }

    public void func_31069_a(World var1) {
    }

    public FontRenderer getFontRenderer() {
        return this.tileEntityRenderer.getFontRenderer();
    }
}
