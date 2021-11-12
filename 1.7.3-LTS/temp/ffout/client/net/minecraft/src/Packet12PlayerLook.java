package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet12PlayerLook extends Packet10Flying {
    public Packet12PlayerLook() {
        this.field_553_i = true;
    }

    public Packet12PlayerLook(float var1, float var2, boolean var3) {
        this.field_557_e = var1;
        this.field_556_f = var2;
        this.field_555_g = var3;
        this.field_553_i = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_557_e = var1.readFloat();
        this.field_556_f = var1.readFloat();
        super.func_327_a(var1);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeFloat(this.field_557_e);
        var1.writeFloat(this.field_556_f);
        super.func_322_a(var1);
    }

    public int func_329_a() {
        return 9;
    }
}
