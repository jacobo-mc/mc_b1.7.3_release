package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet22Collect extends Packet {
    public int field_581_a;
    public int field_580_b;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_581_a = var1.readInt();
        this.field_580_b = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_581_a);
        var1.writeInt(this.field_580_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_834_a(this);
    }

    public int func_329_a() {
        return 8;
    }
}
