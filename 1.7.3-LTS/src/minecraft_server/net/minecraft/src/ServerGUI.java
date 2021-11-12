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
    public static Logger logger = Logger.getLogger("Minecraft");
    private MinecraftServer mcServer;

    public static void initGui(MinecraftServer var0) {
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
        this.mcServer = var1;
        this.setPreferredSize(new Dimension(854, 480));
        this.setLayout(new BorderLayout());

        try {
            this.add(this.getLogComponent(), "Center");
            this.add(this.getStatsComponent(), "West");
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private JComponent getStatsComponent() {
        JPanel var1 = new JPanel(new BorderLayout());
        var1.add(new GuiStatsComponent(), "North");
        var1.add(this.getPlayerListComponent(), "Center");
        var1.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return var1;
    }

    private JComponent getPlayerListComponent() {
        PlayerListBox var1 = new PlayerListBox(this.mcServer);
        JScrollPane var2 = new JScrollPane(var1, 22, 30);
        var2.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return var2;
    }

    private JComponent getLogComponent() {
        JPanel var1 = new JPanel(new BorderLayout());
        JTextArea var2 = new JTextArea();
        logger.addHandler(new GuiLogOutputHandler(var2));
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

    public void log(String var1) {
        logger.info(var1);
    }

    public String getUsername() {
        return "CONSOLE";
    }

    // $FF: synthetic method
    static MinecraftServer getMinecraftServer(ServerGUI var0) {
        return var0.mcServer;
    }
}
