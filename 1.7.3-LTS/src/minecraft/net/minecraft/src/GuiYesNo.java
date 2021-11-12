package net.minecraft.src;

public class GuiYesNo extends GuiScreen {
    private GuiScreen parentScreen;
    private String message1;
    private String message2;
    private String buttonText1;
    private String buttonText2;
    private int worldNumber;

    public GuiYesNo(GuiScreen var1, String var2, String var3, String var4, String var5, int var6) {
        this.parentScreen = var1;
        this.message1 = var2;
        this.message2 = var3;
        this.buttonText1 = var4;
        this.buttonText2 = var5;
        this.worldNumber = var6;
    }

    public void initGui() {
        this.controlList.add(new GuiSmallButton(0, this.width / 2 - 155 + 0, this.height / 6 + 96, this.buttonText1));
        this.controlList.add(new GuiSmallButton(1, this.width / 2 - 155 + 160, this.height / 6 + 96, this.buttonText2));
    }

    protected void actionPerformed(GuiButton var1) {
        this.parentScreen.deleteWorld(var1.id == 0, this.worldNumber);
    }

    public void drawScreen(int var1, int var2, float var3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.message1, this.width / 2, 70, 16777215);
        this.drawCenteredString(this.fontRenderer, this.message2, this.width / 2, 90, 16777215);
        super.drawScreen(var1, var2, var3);
    }
}
