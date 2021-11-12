package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SpawnPosition extends Packet {
    public int field_515_a;
    public int field_514_b;
    public int field_516_c;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_515_a = var1.readInt();
        this.field_514_b = var1.readInt();
        this.field_516_c = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_515_a);
        var1.writeInt(this.field_514_b);
        var1.writeInt(this.field_516_c);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_845_a(this);
    }

    public int func_329_a() {
        return 12;
    }
}
