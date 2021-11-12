package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet19EntityAction extends Packet {
    public int field_21021_a;
    public int field_21020_b;

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_21021_a = var1.readInt();
        this.field_21020_b = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21021_a);
        var1.writeByte(this.field_21020_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_21001_a(this);
    }

    public int func_71_a() {
        return 5;
    }
}
