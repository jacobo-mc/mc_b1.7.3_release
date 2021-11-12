package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class TextureFX {
    public byte[] imageData = new byte[1024 /*GL_FRONT_LEFT*/];
    public int iconIndex;
    public boolean anaglyphEnabled = false;
    public int textureId = 0;
    public int tileSize = 1;
    public int tileImage = 0;

    public TextureFX(int var1) {
        this.iconIndex = var1;
    }

    public void onTick() {
    }

    public void bindImage(RenderEngine var1) {
        if (this.tileImage == 0) {
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, var1.getTexture("/terrain.png"));
        } else if (this.tileImage == 1) {
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, var1.getTexture("/gui/items.png"));
        }

    }
}
