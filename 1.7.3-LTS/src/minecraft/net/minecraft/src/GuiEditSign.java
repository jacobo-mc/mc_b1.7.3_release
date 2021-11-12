package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiEditSign extends GuiScreen {
    protected String screenTitle = "Edit sign message:";
    private TileEntitySign entitySign;
    private int updateCounter;
    private int editLine = 0;
    private static final String allowedCharacters;

    public GuiEditSign(TileEntitySign var1) {
        this.entitySign = var1;
    }

    public void initGui() {
        this.controlList.clear();
        Keyboard.enableRepeatEvents(true);
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Done"));
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        if (this.mc.theWorld.multiplayerWorld) {
            this.mc.getSendQueue().addToSendQueue(new Packet130UpdateSign(this.entitySign.xCoord, this.entitySign.yCoord, this.entitySign.zCoord, this.entitySign.signText));
        }

    }

    public void updateScreen() {
        ++this.updateCounter;
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 0) {
                this.entitySign.onInventoryChanged();
                this.mc.displayGuiScreen((GuiScreen)null);
            }

        }
    }

    protected void keyTyped(char var1, int var2) {
        if (var2 == 200) {
            this.editLine = this.editLine - 1 & 3;
        }

        if (var2 == 208 || var2 == 28) {
            this.editLine = this.editLine + 1 & 3;
        }

        if (var2 == 14 && this.entitySign.signText[this.editLine].length() > 0) {
            this.entitySign.signText[this.editLine] = this.entitySign.signText[this.editLine].substring(0, this.entitySign.signText[this.editLine].length() - 1);
        }

        if (allowedCharacters.indexOf(var1) >= 0 && this.entitySign.signText[this.editLine].length() < 15) {
            StringBuilder var10000 = new StringBuilder();
            String[] var10002 = this.entitySign.signText;
            int var10004 = this.editLine;
            var10002[var10004] = var10000.append(var10002[var10004]).append(var1).toString();
        }

    }

    public void drawScreen(int var1, int var2, float var3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 40, 16777215);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.width / 2), 0.0F, 50.0F);
        float var4 = 93.75F;
        GL11.glScalef(-var4, -var4, -var4);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        Block var5 = this.entitySign.getBlockType();
        if (var5 == Block.signPost) {
            float var6 = (float)(this.entitySign.getBlockMetadata() * 360) / 16.0F;
            GL11.glRotatef(var6, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
        } else {
            int var8 = this.entitySign.getBlockMetadata();
            float var7 = 0.0F;
            if (var8 == 2) {
                var7 = 180.0F;
            }

            if (var8 == 4) {
                var7 = 90.0F;
            }

            if (var8 == 5) {
                var7 = -90.0F;
            }

            GL11.glRotatef(var7, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
        }

        if (this.updateCounter / 6 % 2 == 0) {
            this.entitySign.lineBeingEdited = this.editLine;
        }

        TileEntityRenderer.instance.renderTileEntityAt(this.entitySign, -0.5D, -0.75D, -0.5D, 0.0F);
        this.entitySign.lineBeingEdited = -1;
        GL11.glPopMatrix();
        super.drawScreen(var1, var2, var3);
    }

    static {
        allowedCharacters = ChatAllowedCharacters.allowedCharacters;
    }
}
