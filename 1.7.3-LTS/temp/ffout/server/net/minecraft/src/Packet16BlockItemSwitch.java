package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet16BlockItemSwitch extends Packet {
    public int field_74_b;

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_74_b = var1.readShort();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_74_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_11_a(this);
    }

    public int func_71_a() {
        return 2;
    }
}
