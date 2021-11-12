package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet29DestroyEntity extends Packet {
    public int field_116_a;

    public Packet29DestroyEntity() {
    }

    public Packet29DestroyEntity(int var1) {
        this.field_116_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_116_a = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_116_a);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_8_a(this);
    }

    public int func_71_a() {
        return 4;
    }
}
