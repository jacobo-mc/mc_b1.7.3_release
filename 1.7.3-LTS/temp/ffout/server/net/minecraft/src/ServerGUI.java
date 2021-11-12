package net.minecraft.src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.minecraft.server.MinecraftServer;

public class ServerGUI extends JComponent implements ICommandListener {
    public static Logger field_22_a = Logger.getLogger("Minecraft");
    private MinecraftServer field_21_b;

    public static void func_46_a(MinecraftServer var0) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception var3) {
        }

        ServerGUI var1 = new ServerGUI(var0);
        JFrame var2 = new JFrame("Minecraft server");
        var2.add(var1);
        var2.pack();
        var2.setLocationRelativeTo((Component)null);
        var2.setVisible(true);
        var2.addWindowListener(new ServerWindowAdapter(var0));
    }

    public ServerGUI(MinecraftServer var1) {
        this.field_21_b = var1;
        this.setPreferredSize(new Dimension(854, 480));
        this.setLayout(new BorderLayout());

        try {
            this.add(this.func_47_d(), "Center");
            this.add(this.func_45_a(), "West");
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private JComponent func_45_a() {
        JPanel var1 = new JPanel(new BorderLayout());
        var1.add(new GuiStatsComponent(), "North");
        var1.add(this.func_48_b(), "Center");
        var1.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return var1;
    }

    private JComponent func_48_b() {
        PlayerListBox var1 = new PlayerListBox(this.field_21_b);
        JScrollPane var2 = new JScrollPane(var1, 22, 30);
        var2.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return var2;
    }

    private JComponent func_47_d() {
        JPanel var1 = new JPanel(new BorderLayout());
        JTextArea var2 = new JTextArea();
        field_22_a.addHandler(new GuiLogOutputHandler(var2));
        JScrollPane var3 = new JScrollPane(var2, 22, 30);
        var2.setEditable(false);
        JTextField var4 = new JTextField();
        var4.addActionListener(new ServerGuiCommandListener(this, var4));
        var2.addFocusListener(new ServerGuiFocusAdapter(this));
        var1.add(var3, "Center");
        var1.add(var4, "South");
        var1.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
        return var1;
    }

    public void func_2_b(String var1) {
        field_22_a.info(var1);
    }

    public String func_1_c() {
        return "CONSOLE";
    }

    // $FF: synthetic method
    static MinecraftServer func_44_a(ServerGUI var0) {
        return var0.field_21_b;
    }
}
