package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet4UpdateTime extends Packet {
    public long field_76_a;

    public Packet4UpdateTime() {
    }

    public Packet4UpdateTime(long var1) {
        this.field_76_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_76_a = var1.readLong();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeLong(this.field_76_a);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_25_a(this);
    }

    public int func_71_a() {
        return 8;
    }
}
