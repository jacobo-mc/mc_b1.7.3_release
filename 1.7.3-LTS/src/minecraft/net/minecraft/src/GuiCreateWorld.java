package net.minecraft.src;

import java.util.Random;
import org.lwjgl.input.Keyboard;

public class GuiCreateWorld extends GuiScreen {
    private GuiScreen parentGuiScreen;
    private GuiTextField textboxWorldName;
    private GuiTextField textboxSeed;
    private String folderName;
    private boolean createClicked;

    public GuiCreateWorld(GuiScreen var1) {
        this.parentGuiScreen = var1;
    }

    public void updateScreen() {
        this.textboxWorldName.updateCursorCounter();
        this.textboxSeed.updateCursorCounter();
    }

    public void initGui() {
        StringTranslate var1 = StringTranslate.getInstance();
        Keyboard.enableRepeatEvents(true);
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, var1.translateKey("selectWorld.create")));
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.translateKey("gui.cancel")));
        this.textboxWorldName = new GuiTextField(this, this.fontRenderer, this.width / 2 - 100, 60, 200, 20, var1.translateKey("selectWorld.newWorld"));
        this.textboxWorldName.isFocused = true;
        this.textboxWorldName.setMaxStringLength(32);
        this.textboxSeed = new GuiTextField(this, this.fontRenderer, this.width / 2 - 100, 116, 200, 20, "");
        this.calcSaveDirName();
    }

    private void calcSaveDirName() {
        this.folderName = this.textboxWorldName.getText().trim();
        char[] var1 = ChatAllowedCharacters.allowedCharactersArray;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            char var4 = var1[var3];
            this.folderName = this.folderName.replace(var4, '_');
        }

        if (MathHelper.stringNullOrLengthZero(this.folderName)) {
            this.folderName = "World";
        }

        this.folderName = generateUnusedFolderName(this.mc.getSaveLoader(), this.folderName);
    }

    public static String generateUnusedFolderName(ISaveFormat var0, String var1) {
        while(var0.getWorldInfo(var1) != null) {
            var1 = var1 + "-";
        }

        return var1;
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 1) {
                this.mc.displayGuiScreen(this.parentGuiScreen);
            } else if (var1.id == 0) {
                this.mc.displayGuiScreen((GuiScreen)null);
                if (this.createClicked) {
                    return;
                }

                this.createClicked = true;
                long var2 = (new Random()).nextLong();
                String var4 = this.textboxSeed.getText();
                if (!MathHelper.stringNullOrLengthZero(var4)) {
                    try {
                        long var5 = Long.parseLong(var4);
                        if (var5 != 0L) {
                            var2 = var5;
                        }
                    } catch (NumberFormatException var7) {
                        var2 = (long)var4.hashCode();
                    }
                }

                this.mc.playerController = new PlayerControllerSP(this.mc);
                this.mc.startWorld(this.folderName, this.textboxWorldName.getText(), var2);
                this.mc.displayGuiScreen((GuiScreen)null);
            }

        }
    }

    protected void keyTyped(char var1, int var2) {
        if (this.textboxWorldName.isFocused) {
            this.textboxWorldName.textboxKeyTyped(var1, var2);
        } else {
            this.textboxSeed.textboxKeyTyped(var1, var2);
        }

        if (var1 == '\r') {
            this.actionPerformed((GuiButton)this.controlList.get(0));
        }

        ((GuiButton)this.controlList.get(0)).enabled = this.textboxWorldName.getText().length() > 0;
        this.calcSaveDirName();
    }

    protected void mouseClicked(int var1, int var2, int var3) {
        super.mouseClicked(var1, var2, var3);
        this.textboxWorldName.mouseClicked(var1, var2, var3);
        this.textboxSeed.mouseClicked(var1, var2, var3);
    }

    public void drawScreen(int var1, int var2, float var3) {
        StringTranslate var4 = StringTranslate.getInstance();
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, var4.translateKey("selectWorld.create"), this.width / 2, this.height / 4 - 60 + 20, 16777215);
        this.drawString(this.fontRenderer, var4.translateKey("selectWorld.enterName"), this.width / 2 - 100, 47, 10526880);
        this.drawString(this.fontRenderer, var4.translateKey("selectWorld.resultFolder") + " " + this.folderName, this.width / 2 - 100, 85, 10526880);
        this.drawString(this.fontRenderer, var4.translateKey("selectWorld.enterSeed"), this.width / 2 - 100, 104, 10526880);
        this.drawString(this.fontRenderer, var4.translateKey("selectWorld.seedInfo"), this.width / 2 - 100, 140, 10526880);
        this.textboxWorldName.drawTextBox();
        this.textboxSeed.drawTextBox();
        super.drawScreen(var1, var2, var3);
    }

    public void selectNextField() {
        if (this.textboxWorldName.isFocused) {
            this.textboxWorldName.setFocused(false);
            this.textboxSeed.setFocused(true);
        } else {
            this.textboxWorldName.setFocused(true);
            this.textboxSeed.setFocused(false);
        }

    }
}
