package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet70Bed extends Packet {
    public static final String[] field_25016_a = new String[]{"tile.bed.notValid", null, null};
    public int field_25015_b;

    public Packet70Bed() {
    }

    public Packet70Bed(int var1) {
        this.field_25015_b = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_25015_b = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_25015_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_25001_a(this);
    }

    public int func_71_a() {
        return 1;
    }
}
