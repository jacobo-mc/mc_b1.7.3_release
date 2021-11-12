package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet200Statistic extends Packet {
    public int field_27052_a;
    public int field_27051_b;

    public void func_323_a(NetHandler var1) {
        var1.func_27245_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_27052_a = var1.readInt();
        this.field_27051_b = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_27052_a);
        var1.writeByte(this.field_27051_b);
    }

    public int func_329_a() {
        return 6;
    }
}
