package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet16BlockItemSwitch extends Packet {
    public int field_562_b;

    public Packet16BlockItemSwitch() {
    }

    public Packet16BlockItemSwitch(int var1) {
        this.field_562_b = var1;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_562_b = var1.readShort();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_562_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_841_a(this);
    }

    public int func_329_a() {
        return 2;
    }
}
