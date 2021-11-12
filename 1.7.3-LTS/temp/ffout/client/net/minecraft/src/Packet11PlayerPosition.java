package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet11PlayerPosition extends Packet10Flying {
    public Packet11PlayerPosition() {
        this.field_554_h = true;
    }

    public Packet11PlayerPosition(double var1, double var3, double var5, double var7, boolean var9) {
        this.field_561_a = var1;
        this.field_560_b = var3;
        this.field_558_d = var5;
        this.field_559_c = var7;
        this.field_555_g = var9;
        this.field_554_h = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_561_a = var1.readDouble();
        this.field_560_b = var1.readDouble();
        this.field_558_d = var1.readDouble();
        this.field_559_c = var1.readDouble();
        super.func_327_a(var1);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.field_561_a);
        var1.writeDouble(this.field_560_b);
        var1.writeDouble(this.field_558_d);
        var1.writeDouble(this.field_559_c);
        super.func_322_a(var1);
    }

    public int func_329_a() {
        return 33;
    }
}
