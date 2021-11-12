package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet18Animation extends Packet {
    public int field_522_a;
    public int field_521_b;

    public Packet18Animation() {
    }

    public Packet18Animation(Entity var1, int var2) {
        this.field_522_a = var1.field_620_ab;
        this.field_521_b = var2;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_522_a = var1.readInt();
        this.field_521_b = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_522_a);
        var1.writeByte(this.field_521_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_825_a(this);
    }

    public int func_329_a() {
        return 5;
    }
}
