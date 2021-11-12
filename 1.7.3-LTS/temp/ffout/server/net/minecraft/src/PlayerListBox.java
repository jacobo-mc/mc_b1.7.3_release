package net.minecraft.src;

import java.util.Vector;
import javax.swing.JList;
import net.minecraft.server.MinecraftServer;

public class PlayerListBox extends JList implements IUpdatePlayerListBox {
    private MinecraftServer field_955_a;
    private int field_954_b = 0;

    public PlayerListBox(MinecraftServer var1) {
        this.field_955_a = var1;
        var1.func_6022_a(this);
    }

    public void func_690_a() {
        if (this.field_954_b++ % 20 == 0) {
            Vector var1 = new Vector();

            for(int var2 = 0; var2 < this.field_955_a.field_6033_f.field_924_b.size(); ++var2) {
                var1.add(((EntityPlayerMP)this.field_955_a.field_6033_f.field_924_b.get(var2)).field_409_aq);
            }

            this.setListData(var1);
        }

    }
}
