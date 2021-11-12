package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet29DestroyEntity extends Packet {
    public int field_507_a;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_507_a = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_507_a);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_839_a(this);
    }

    public int func_329_a() {
        return 4;
    }
}
