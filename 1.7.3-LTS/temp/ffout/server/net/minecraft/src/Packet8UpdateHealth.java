package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet8UpdateHealth extends Packet {
    public int field_9017_a;

    public Packet8UpdateHealth() {
    }

    public Packet8UpdateHealth(int var1) {
        this.field_9017_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_9017_a = var1.readShort();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_9017_a);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_9003_a(this);
    }

    public int func_71_a() {
        return 2;
    }
}
