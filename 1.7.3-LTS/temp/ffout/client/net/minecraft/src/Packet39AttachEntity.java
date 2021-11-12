package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet39AttachEntity extends Packet {
    public int field_6365_a;
    public int field_6364_b;

    public int func_329_a() {
        return 8;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_6365_a = var1.readInt();
        this.field_6364_b = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_6365_a);
        var1.writeInt(this.field_6364_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_6497_a(this);
    }
}
