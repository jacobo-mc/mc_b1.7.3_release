package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiGameOver extends GuiScreen {
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 72, "Respawn"));
        this.controlList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 96, "Title menu"));
        if (this.mc.session == null) {
            ((GuiButton)this.controlList.get(1)).enabled = false;
        }

    }

    protected void keyTyped(char var1, int var2) {
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.id == 0) {
        }

        if (var1.id == 1) {
            this.mc.thePlayer.respawnPlayer();
            this.mc.displayGuiScreen((GuiScreen)null);
        }

        if (var1.id == 2) {
            this.mc.changeWorld1((World)null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        }

    }

    public void drawScreen(int var1, int var2, float var3) {
        this.drawGradientRect(0, 0, this.width, this.height, 1615855616, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        this.drawCenteredString(this.fontRenderer, "Game over!", this.width / 2 / 2, 30, 16777215);
        GL11.glPopMatrix();
        this.drawCenteredString(this.fontRenderer, "Score: &e" + this.mc.thePlayer.getScore(), this.width / 2, 100, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    public boolean doesGuiPauseGame() {
        return false;
    }
}
