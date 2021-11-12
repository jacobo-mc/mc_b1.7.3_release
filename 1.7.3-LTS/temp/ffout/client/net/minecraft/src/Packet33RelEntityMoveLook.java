package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet33RelEntityMoveLook extends Packet30Entity {
    public Packet33RelEntityMoveLook() {
        this.field_486_g = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        super.func_327_a(var1);
        this.field_484_b = var1.readByte();
        this.field_490_c = var1.readByte();
        this.field_489_d = var1.readByte();
        this.field_488_e = var1.readByte();
        this.field_487_f = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        super.func_322_a(var1);
        var1.writeByte(this.field_484_b);
        var1.writeByte(this.field_490_c);
        var1.writeByte(this.field_489_d);
        var1.writeByte(this.field_488_e);
        var1.writeByte(this.field_487_f);
    }

    public int func_329_a() {
        return 9;
    }
}
