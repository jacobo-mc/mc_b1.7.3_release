package net.minecraft.src;

import java.util.List;
import org.lwjgl.opengl.GL11;

class GuiTexturePackSlot extends GuiSlot {
    // $FF: synthetic field
    final GuiTexturePacks parentTexturePackGui;

    public GuiTexturePackSlot(GuiTexturePacks var1) {
        super(GuiTexturePacks.getMinecraft(var1), var1.width, var1.height, 32, var1.height - 55 + 4, 36);
        this.parentTexturePackGui = var1;
    }

    protected int getSize() {
        List var1 = GuiTexturePacks.getMinecraft1(this.parentTexturePackGui).texturePackList.availableTexturePacks();
        return var1.size();
    }

    protected void elementClicked(int var1, boolean var2) {
        List var3 = GuiTexturePacks.getMinecraft2(this.parentTexturePackGui).texturePackList.availableTexturePacks();
        GuiTexturePacks.getMinecraft3(this.parentTexturePackGui).texturePackList.setTexturePack((TexturePackBase)var3.get(var1));
        GuiTexturePacks.getMinecraft4(this.parentTexturePackGui).renderEngine.refreshTextures();
    }

    protected boolean isSelected(int var1) {
        List var2 = GuiTexturePacks.getMinecraft5(this.parentTexturePackGui).texturePackList.availableTexturePacks();
        return GuiTexturePacks.getMinecraft6(this.parentTexturePackGui).texturePackList.selectedTexturePack == var2.get(var1);
    }

    protected int getContentHeight() {
        return this.getSize() * 36;
    }

    protected void drawBackground() {
        this.parentTexturePackGui.drawDefaultBackground();
    }

    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5) {
        TexturePackBase var6 = (TexturePackBase)GuiTexturePacks.getMinecraft7(this.parentTexturePackGui).texturePackList.availableTexturePacks().get(var1);
        var6.bindThumbnailTexture(GuiTexturePacks.getMinecraft8(this.parentTexturePackGui));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        var5.startDrawingQuads();
        var5.setColorOpaque_I(16777215);
        var5.addVertexWithUV((double)var2, (double)(var3 + var4), 0.0D, 0.0D, 1.0D);
        var5.addVertexWithUV((double)(var2 + 32), (double)(var3 + var4), 0.0D, 1.0D, 1.0D);
        var5.addVertexWithUV((double)(var2 + 32), (double)var3, 0.0D, 1.0D, 0.0D);
        var5.addVertexWithUV((double)var2, (double)var3, 0.0D, 0.0D, 0.0D);
        var5.draw();
        this.parentTexturePackGui.drawString(GuiTexturePacks.getFontRenderer(this.parentTexturePackGui), var6.texturePackFileName, var2 + 32 + 2, var3 + 1, 16777215);
        this.parentTexturePackGui.drawString(GuiTexturePacks.getFontRenderer1(this.parentTexturePackGui), var6.firstDescriptionLine, var2 + 32 + 2, var3 + 12, 8421504);
        this.parentTexturePackGui.drawString(GuiTexturePacks.getFontRenderer2(this.parentTexturePackGui), var6.secondDescriptionLine, var2 + 32 + 2, var3 + 12 + 10, 8421504);
    }
}
