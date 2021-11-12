package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiStatsListener implements ActionListener {
    // $FF: synthetic field
    final GuiStatsComponent field_527_a;

    GuiStatsListener(GuiStatsComponent var1) {
        this.field_527_a = var1;
    }

    public void actionPerformed(ActionEvent var1) {
        GuiStatsComponent.func_435_a(this.field_527_a);
    }
}
