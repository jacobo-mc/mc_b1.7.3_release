package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;

class GuiSlotStatsBlock extends GuiSlotStats {
    // $FF: synthetic field
    final GuiStats field_27274_a;

    public GuiSlotStatsBlock(GuiStats var1) {
        super(var1);
        this.field_27274_a = var1;
        this.field_27273_c = new ArrayList();
        Iterator var2 = StatList.field_25185_d.iterator();

        while(var2.hasNext()) {
            StatCrafting var3 = (StatCrafting)var2.next();
            boolean var4 = false;
            int var5 = var3.func_25072_b();
            if (GuiStats.func_27142_c(var1).func_27184_a(var3) > 0) {
                var4 = true;
            } else if (StatList.field_25172_A[var5] != null && GuiStats.func_27142_c(var1).func_27184_a(StatList.field_25172_A[var5]) > 0) {
                var4 = true;
            } else if (StatList.field_25158_z[var5] != null && GuiStats.func_27142_c(var1).func_27184_a(StatList.field_25158_z[var5]) > 0) {
                var4 = true;
            }

            if (var4) {
                this.field_27273_c.add(var3);
            }
        }

        this.field_27272_d = new SorterStatsBlock(this, var1);
    }

    protected void func_27260_a(int var1, int var2, Tessellator var3) {
        super.func_27260_a(var1, var2, var3);
        if (this.field_27268_b == 0) {
            GuiStats.func_27128_a(this.field_27274_a, var1 + 115 - 18 + 1, var2 + 1 + 1, 18, 18);
        } else {
            GuiStats.func_27128_a(this.field_27274_a, var1 + 115 - 18, var2 + 1, 18, 18);
        }

        if (this.field_27268_b == 1) {
            GuiStats.func_27128_a(this.field_27274_a, var1 + 165 - 18 + 1, var2 + 1 + 1, 36, 18);
        } else {
            GuiStats.func_27128_a(this.field_27274_a, var1 + 165 - 18, var2 + 1, 36, 18);
        }

        if (this.field_27268_b == 2) {
            GuiStats.func_27128_a(this.field_27274_a, var1 + 215 - 18 + 1, var2 + 1 + 1, 54, 18);
        } else {
            GuiStats.func_27128_a(this.field_27274_a, var1 + 215 - 18, var2 + 1, 54, 18);
        }

    }

    protected void func_22242_a(int var1, int var2, int var3, int var4, Tessellator var5) {
        StatCrafting var6 = this.func_27264_b(var1);
        int var7 = var6.func_25072_b();
        GuiStats.func_27148_a(this.field_27274_a, var2 + 40, var3, var7);
        this.func_27265_a((StatCrafting)StatList.field_25158_z[var7], var2 + 115, var3, var1 % 2 == 0);
        this.func_27265_a((StatCrafting)StatList.field_25172_A[var7], var2 + 165, var3, var1 % 2 == 0);
        this.func_27265_a(var6, var2 + 215, var3, var1 % 2 == 0);
    }

    protected String func_27263_a(int var1) {
        if (var1 == 0) {
            return "stat.crafted";
        } else {
            return var1 == 1 ? "stat.used" : "stat.mined";
        }
    }
}
