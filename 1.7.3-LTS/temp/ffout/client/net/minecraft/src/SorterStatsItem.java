package net.minecraft.src;

import java.util.Comparator;

class SorterStatsItem implements Comparator {
    // $FF: synthetic field
    final GuiStats field_27373_a;
    // $FF: synthetic field
    final GuiSlotStatsItem field_27372_b;

    SorterStatsItem(GuiSlotStatsItem var1, GuiStats var2) {
        this.field_27372_b = var1;
        this.field_27373_a = var2;
    }

    public int func_27371_a(StatCrafting var1, StatCrafting var2) {
        int var3 = var1.func_25072_b();
        int var4 = var2.func_25072_b();
        StatBase var5 = null;
        StatBase var6 = null;
        if (this.field_27372_b.field_27271_e == 0) {
            var5 = StatList.field_25170_B[var3];
            var6 = StatList.field_25170_B[var4];
        } else if (this.field_27372_b.field_27271_e == 1) {
            var5 = StatList.field_25158_z[var3];
            var6 = StatList.field_25158_z[var4];
        } else if (this.field_27372_b.field_27271_e == 2) {
            var5 = StatList.field_25172_A[var3];
            var6 = StatList.field_25172_A[var4];
        }

        if (var5 != null || var6 != null) {
            if (var5 == null) {
                return 1;
            }

            if (var6 == null) {
                return -1;
            }

            int var7 = GuiStats.func_27142_c(this.field_27372_b.field_27275_a).func_27184_a(var5);
            int var8 = GuiStats.func_27142_c(this.field_27372_b.field_27275_a).func_27184_a(var6);
            if (var7 != var8) {
                return (var7 - var8) * this.field_27372_b.field_27270_f;
            }
        }

        return var3 - var4;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.func_27371_a((StatCrafting)var1, (StatCrafting)var2);
    }
}
