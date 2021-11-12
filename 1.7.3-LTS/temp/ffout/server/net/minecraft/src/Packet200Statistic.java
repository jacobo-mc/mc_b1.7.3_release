package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet200Statistic extends Packet {
    public int field_27041_a;
    public int field_27040_b;

    public Packet200Statistic() {
    }

    public Packet200Statistic(int var1, int var2) {
        this.field_27041_a = var1;
        this.field_27040_b = var2;
    }

    public void func_72_a(NetHandler var1) {
        var1.func_27001_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_27041_a = var1.readInt();
        this.field_27040_b = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_27041_a);
        var1.writeByte(this.field_27040_b);
    }

    public int func_71_a() {
        return 6;
    }
}
