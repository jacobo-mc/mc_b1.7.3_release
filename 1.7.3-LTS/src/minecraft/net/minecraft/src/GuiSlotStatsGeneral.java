package net.minecraft.src;

class GuiSlotStatsGeneral extends GuiSlot {
    // $FF: synthetic field
    final GuiStats statsGui;

    public GuiSlotStatsGeneral(GuiStats var1) {
        super(GuiStats.getMinecraft(var1), var1.width, var1.height, 32, var1.height - 64, 10);
        this.statsGui = var1;
        this.setShowSelectionBox(false);
    }

    protected int getSize() {
        return StatList.generalStats.size();
    }

    protected void elementClicked(int var1, boolean var2) {
    }

    protected boolean isSelected(int var1) {
        return false;
    }

    protected int getContentHeight() {
        return this.getSize() * 10;
    }

    protected void drawBackground() {
        this.statsGui.drawDefaultBackground();
    }

    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5) {
        StatBase var6 = (StatBase)StatList.generalStats.get(var1);
        this.statsGui.drawString(GuiStats.getFontRenderer1(this.statsGui), var6.statName, var2 + 2, var3 + 1, var1 % 2 == 0 ? 16777215 : 9474192);
        String var7 = var6.func_27084_a(GuiStats.getStatsFileWriter(this.statsGui).writeStat(var6));
        this.statsGui.drawString(GuiStats.getFontRenderer2(this.statsGui), var7, var2 + 2 + 213 - GuiStats.getFontRenderer3(this.statsGui).getStringWidth(var7), var3 + 1, var1 % 2 == 0 ? 16777215 : 9474192);
    }
}
