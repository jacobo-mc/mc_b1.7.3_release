package net.minecraft.src;

class GuiSlotStatsGeneral extends GuiSlot {
    // $FF: synthetic field
    final GuiStats field_27276_a;

    public GuiSlotStatsGeneral(GuiStats var1) {
        super(GuiStats.func_27141_a(var1), var1.field_951_c, var1.field_950_d, 32, var1.field_950_d - 64, 10);
        this.field_27276_a = var1;
        this.func_27258_a(false);
    }

    protected int func_22249_a() {
        return StatList.field_25187_b.size();
    }

    protected void func_22247_a(int var1, boolean var2) {
    }

    protected boolean func_22246_a(int var1) {
        return false;
    }

    protected int func_22245_b() {
        return this.func_22249_a() * 10;
    }

    protected void func_22248_c() {
        this.field_27276_a.func_578_i();
    }

    protected void func_22242_a(int var1, int var2, int var3, int var4, Tessellator var5) {
        StatBase var6 = (StatBase)StatList.field_25187_b.get(var1);
        this.field_27276_a.func_547_b(GuiStats.func_27145_b(this.field_27276_a), var6.field_25070_e, var2 + 2, var3 + 1, var1 % 2 == 0 ? 16777215 : 9474192);
        String var7 = var6.func_27084_a(GuiStats.func_27142_c(this.field_27276_a).func_27184_a(var6));
        this.field_27276_a.func_547_b(GuiStats.func_27140_d(this.field_27276_a), var7, var2 + 2 + 213 - GuiStats.func_27146_e(this.field_27276_a).func_871_a(var7), var3 + 1, var1 % 2 == 0 ? 16777215 : 9474192);
    }
}
