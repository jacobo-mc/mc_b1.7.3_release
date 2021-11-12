package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiMultiplayer extends GuiScreen {
    private GuiScreen parentScreen;
    private GuiTextField serverTextBox;

    public GuiMultiplayer(GuiScreen var1) {
        this.parentScreen = var1;
    }

    public void updateScreen() {
        this.serverTextBox.updateCursorCounter();
    }

    public void initGui() {
        StringTranslate var1 = StringTranslate.getInstance();
        Keyboard.enableRepeatEvents(true);
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, var1.translateKey("multiplayer.connect")));
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.translateKey("gui.cancel")));
        String var2 = this.mc.gameSettings.lastServer.replaceAll("_", ":");
        ((GuiButton)this.controlList.get(0)).enabled = var2.length() > 0;
        this.serverTextBox = new GuiTextField(this, this.fontRenderer, this.width / 2 - 100, this.height / 4 - 10 + 50 + 18, 200, 20, var2);
        this.serverTextBox.isFocused = true;
        this.serverTextBox.setMaxStringLength(128);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 1) {
                this.mc.displayGuiScreen(this.parentScreen);
            } else if (var1.id == 0) {
                String var2 = this.serverTextBox.getText().trim();
                this.mc.gameSettings.lastServer = var2.replaceAll(":", "_");
                this.mc.gameSettings.saveOptions();
                String[] var3 = var2.split(":");
                if (var2.startsWith("[")) {
                    int var4 = var2.indexOf("]");
                    if (var4 > 0) {
                        String var5 = var2.substring(1, var4);
                        String var6 = var2.substring(var4 + 1).trim();
                        if (var6.startsWith(":") && var6.length() > 0) {
                            var6 = var6.substring(1);
                            var3 = new String[]{var5, var6};
                        } else {
                            var3 = new String[]{var5};
                        }
                    }
                }

                if (var3.length > 2) {
                    var3 = new String[]{var2};
                }

                this.mc.displayGuiScreen(new GuiConnecting(this.mc, var3[0], var3.length > 1 ? this.parseIntWithDefault(var3[1], 25565) : 25565));
            }

        }
    }

    private int parseIntWithDefault(String var1, int var2) {
        try {
            return Integer.parseInt(var1.trim());
        } catch (Exception var4) {
            return var2;
        }
    }

    protected void keyTyped(char var1, int var2) {
        this.serverTextBox.textboxKeyTyped(var1, var2);
        if (var1 == '\r') {
            this.actionPerformed((GuiButton)this.controlList.get(0));
        }

        ((GuiButton)this.controlList.get(0)).enabled = this.serverTextBox.getText().length() > 0;
    }

    protected void mouseClicked(int var1, int var2, int var3) {
        super.mouseClicked(var1, var2, var3);
        this.serverTextBox.mouseClicked(var1, var2, var3);
    }

    public void drawScreen(int var1, int var2, float var3) {
        StringTranslate var4 = StringTranslate.getInstance();
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, var4.translateKey("multiplayer.title"), this.width / 2, this.height / 4 - 60 + 20, 16777215);
        this.drawString(this.fontRenderer, var4.translateKey("multiplayer.info1"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 0, 10526880);
        this.drawString(this.fontRenderer, var4.translateKey("multiplayer.info2"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 9, 10526880);
        this.drawString(this.fontRenderer, var4.translateKey("multiplayer.ipinfo"), this.width / 2 - 140, this.height / 4 - 60 + 60 + 36, 10526880);
        this.serverTextBox.drawTextBox();
        super.drawScreen(var1, var2, var3);
    }
}
