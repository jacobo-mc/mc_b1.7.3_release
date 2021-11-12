package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet13PlayerLookMove extends Packet10Flying {
    public Packet13PlayerLookMove() {
        this.field_553_i = true;
        this.field_554_h = true;
    }

    public Packet13PlayerLookMove(double var1, double var3, double var5, double var7, float var9, float var10, boolean var11) {
        this.field_561_a = var1;
        this.field_560_b = var3;
        this.field_558_d = var5;
        this.field_559_c = var7;
        this.field_557_e = var9;
        this.field_556_f = var10;
        this.field_555_g = var11;
        this.field_553_i = true;
        this.field_554_h = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_561_a = var1.readDouble();
        this.field_560_b = var1.readDouble();
        this.field_558_d = var1.readDouble();
        this.field_559_c = var1.readDouble();
        this.field_557_e = var1.readFloat();
        this.field_556_f = var1.readFloat();
        super.func_327_a(var1);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.field_561_a);
        var1.writeDouble(this.field_560_b);
        var1.writeDouble(this.field_558_d);
        var1.writeDouble(this.field_559_c);
        var1.writeFloat(this.field_557_e);
        var1.writeFloat(this.field_556_f);
        super.func_322_a(var1);
    }

    public int func_329_a() {
        return 41;
    }
}
