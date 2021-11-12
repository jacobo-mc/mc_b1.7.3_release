package net.minecraft.src;

import java.util.Date;

class GuiWorldSlot extends GuiSlot {
    // $FF: synthetic field
    final GuiSelectWorld parentWorldGui;

    public GuiWorldSlot(GuiSelectWorld var1) {
        super(var1.mc, var1.width, var1.height, 32, var1.height - 64, 36);
        this.parentWorldGui = var1;
    }

    protected int getSize() {
        return GuiSelectWorld.getSize(this.parentWorldGui).size();
    }

    protected void elementClicked(int var1, boolean var2) {
        GuiSelectWorld.onElementSelected(this.parentWorldGui, var1);
        boolean var3 = GuiSelectWorld.getSelectedWorld(this.parentWorldGui) >= 0 && GuiSelectWorld.getSelectedWorld(this.parentWorldGui) < this.getSize();
        GuiSelectWorld.getSelectButton(this.parentWorldGui).enabled = var3;
        GuiSelectWorld.getRenameButton(this.parentWorldGui).enabled = var3;
        GuiSelectWorld.getDeleteButton(this.parentWorldGui).enabled = var3;
        if (var2 && var3) {
            this.parentWorldGui.selectWorld(var1);
        }

    }

    protected boolean isSelected(int var1) {
        return var1 == GuiSelectWorld.getSelectedWorld(this.parentWorldGui);
    }

    protected int getContentHeight() {
        return GuiSelectWorld.getSize(this.parentWorldGui).size() * 36;
    }

    protected void drawBackground() {
        this.parentWorldGui.drawDefaultBackground();
    }

    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5) {
        SaveFormatComparator var6 = (SaveFormatComparator)GuiSelectWorld.getSize(this.parentWorldGui).get(var1);
        String var7 = var6.getDisplayName();
        if (var7 == null || MathHelper.stringNullOrLengthZero(var7)) {
            var7 = GuiSelectWorld.getlocalizedWorldText(this.parentWorldGui) + " " + (var1 + 1);
        }

        String var8 = var6.getFileName();
        var8 = var8 + " (" + GuiSelectWorld.getDateFormatter(this.parentWorldGui).format(new Date(var6.getLastTimePlayed()));
        long var9 = var6.func_22159_c();
        var8 = var8 + ", " + (float)(var9 / 1024L * 100L / 1024L) / 100.0F + " MB)";
        String var11 = "";
        if (var6.func_22161_d()) {
            var11 = GuiSelectWorld.getLocalizedMustConvertText(this.parentWorldGui) + " " + var11;
        }

        this.parentWorldGui.drawString(this.parentWorldGui.fontRenderer, var7, var2 + 2, var3 + 1, 16777215);
        this.parentWorldGui.drawString(this.parentWorldGui.fontRenderer, var8, var2 + 2, var3 + 12, 8421504);
        this.parentWorldGui.drawString(this.parentWorldGui.fontRenderer, var11, var2 + 2, var3 + 12 + 10, 8421504);
    }
}
