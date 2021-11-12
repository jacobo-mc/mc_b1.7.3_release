package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class ServerGuiCommandListener implements ActionListener {
    // $FF: synthetic field
    final JTextField field_993_a;
    // $FF: synthetic field
    final ServerGUI field_992_b;

    ServerGuiCommandListener(ServerGUI var1, JTextField var2) {
        this.field_992_b = var1;
        this.field_993_a = var2;
    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = this.field_993_a.getText().trim();
        if (var2.length() > 0) {
            ServerGUI.func_44_a(this.field_992_b).func_6010_a(var2, this.field_992_b);
        }

        this.field_993_a.setText("");
    }
}
