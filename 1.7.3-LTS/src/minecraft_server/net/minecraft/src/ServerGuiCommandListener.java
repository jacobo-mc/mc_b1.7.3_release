package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class ServerGuiCommandListener implements ActionListener {
    // $FF: synthetic field
    final JTextField textField;
    // $FF: synthetic field
    final ServerGUI mcServerGui;

    ServerGuiCommandListener(ServerGUI var1, JTextField var2) {
        this.mcServerGui = var1;
        this.textField = var2;
    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = this.textField.getText().trim();
        if (var2.length() > 0) {
            ServerGUI.getMinecraftServer(this.mcServerGui).addCommand(var2, this.mcServerGui);
        }

        this.textField.setText("");
    }
}
