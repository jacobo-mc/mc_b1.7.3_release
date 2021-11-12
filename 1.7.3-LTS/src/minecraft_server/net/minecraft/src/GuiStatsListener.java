package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiStatsListener implements ActionListener {
    // $FF: synthetic field
    final GuiStatsComponent statsComponent;

    GuiStatsListener(GuiStatsComponent var1) {
        this.statsComponent = var1;
    }

    public void actionPerformed(ActionEvent var1) {
        GuiStatsComponent.update(this.statsComponent);
    }
}
