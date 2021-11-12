package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SpawnPosition extends Packet {
    public int field_139_a;
    public int field_138_b;
    public int field_140_c;

    public Packet6SpawnPosition() {
    }

    public Packet6SpawnPosition(int var1, int var2, int var3) {
        this.field_139_a = var1;
        this.field_138_b = var2;
        this.field_140_c = var3;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_139_a = var1.readInt();
        this.field_138_b = var1.readInt();
        this.field_140_c = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_139_a);
        var1.writeInt(this.field_138_b);
        var1.writeInt(this.field_140_c);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_15_a(this);
    }

    public int func_71_a() {
        return 12;
    }
}
