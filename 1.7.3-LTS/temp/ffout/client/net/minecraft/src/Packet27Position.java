package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet27Position extends Packet {
    private float field_22039_a;
    private float field_22038_b;
    private boolean field_22043_c;
    private boolean field_22042_d;
    private float field_22041_e;
    private float field_22040_f;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_22039_a = var1.readFloat();
        this.field_22038_b = var1.readFloat();
        this.field_22041_e = var1.readFloat();
        this.field_22040_f = var1.readFloat();
        this.field_22043_c = var1.readBoolean();
        this.field_22042_d = var1.readBoolean();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeFloat(this.field_22039_a);
        var1.writeFloat(this.field_22038_b);
        var1.writeFloat(this.field_22041_e);
        var1.writeFloat(this.field_22040_f);
        var1.writeBoolean(this.field_22043_c);
        var1.writeBoolean(this.field_22042_d);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_22185_a(this);
    }

    public int func_329_a() {
        return 18;
    }
}
