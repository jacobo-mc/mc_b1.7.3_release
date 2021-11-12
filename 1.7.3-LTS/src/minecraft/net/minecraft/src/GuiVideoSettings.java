package net.minecraft.src;

public class GuiVideoSettings extends GuiScreen {
    private GuiScreen parentGuiScreen;
    protected String screenTitle = "Video Settings";
    private GameSettings guiGameSettings;
    private static EnumOptions[] videoOptions;

    public GuiVideoSettings(GuiScreen var1, GameSettings var2) {
        this.parentGuiScreen = var1;
        this.guiGameSettings = var2;
    }

    public void initGui() {
        StringTranslate var1 = StringTranslate.getInstance();
        this.screenTitle = var1.translateKey("options.videoTitle");
        int var2 = 0;
        EnumOptions[] var3 = videoOptions;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            EnumOptions var6 = var3[var5];
            if (!var6.getEnumFloat()) {
                this.controlList.add(new GuiSmallButton(var6.returnEnumOrdinal(), this.width / 2 - 155 + var2 % 2 * 160, this.height / 6 + 24 * (var2 >> 1), var6, this.guiGameSettings.getKeyBinding(var6)));
            } else {
                this.controlList.add(new GuiSlider(var6.returnEnumOrdinal(), this.width / 2 - 155 + var2 % 2 * 160, this.height / 6 + 24 * (var2 >> 1), var6, this.guiGameSettings.getKeyBinding(var6), this.guiGameSettings.getOptionFloatValue(var6)));
            }

            ++var2;
        }

        this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, var1.translateKey("gui.done")));
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id < 100 && var1 instanceof GuiSmallButton) {
                this.guiGameSettings.setOptionValue(((GuiSmallButton)var1).returnEnumOptions(), 1);
                var1.displayString = this.guiGameSettings.getKeyBinding(EnumOptions.getEnumOptions(var1.id));
            }

            if (var1.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGuiScreen);
            }

            ScaledResolution var2 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
            int var3 = var2.getScaledWidth();
            int var4 = var2.getScaledHeight();
            this.setWorldAndResolution(this.mc, var3, var4);
        }
    }

    public void drawScreen(int var1, int var2, float var3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    static {
        videoOptions = new EnumOptions[]{EnumOptions.GRAPHICS, EnumOptions.RENDER_DISTANCE, EnumOptions.AMBIENT_OCCLUSION, EnumOptions.FRAMERATE_LIMIT, EnumOptions.ANAGLYPH, EnumOptions.VIEW_BOBBING, EnumOptions.GUI_SCALE, EnumOptions.ADVANCED_OPENGL};
    }
}
