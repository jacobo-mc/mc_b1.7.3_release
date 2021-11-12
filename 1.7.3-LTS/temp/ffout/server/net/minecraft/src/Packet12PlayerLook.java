package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet12PlayerLook extends Packet10Flying {
    public Packet12PlayerLook() {
        this.field_65_i = true;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_69_e = var1.readFloat();
        this.field_68_f = var1.readFloat();
        super.func_70_a(var1);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeFloat(this.field_69_e);
        var1.writeFloat(this.field_68_f);
        super.func_68_a(var1);
    }

    public int func_71_a() {
        return 9;
    }
}
