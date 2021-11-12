package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet11PlayerPosition extends Packet10Flying {
    public Packet11PlayerPosition() {
        this.field_66_h = true;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_73_a = var1.readDouble();
        this.field_72_b = var1.readDouble();
        this.field_70_d = var1.readDouble();
        this.field_71_c = var1.readDouble();
        super.func_70_a(var1);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.field_73_a);
        var1.writeDouble(this.field_72_b);
        var1.writeDouble(this.field_70_d);
        var1.writeDouble(this.field_71_c);
        super.func_68_a(var1);
    }

    public int func_71_a() {
        return 33;
    }
}
