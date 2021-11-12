package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet40EntityMetadata extends Packet {
    public int field_21019_a;
    private List field_21018_b;

    public Packet40EntityMetadata() {
    }

    public Packet40EntityMetadata(int var1, DataWatcher var2) {
        this.field_21019_a = var1;
        this.field_21018_b = var2.func_21148_b();
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_21019_a = var1.readInt();
        this.field_21018_b = DataWatcher.func_21149_a(var1);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21019_a);
        DataWatcher.func_21151_a(this.field_21018_b, var1);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_21002_a(this);
    }

    public int func_71_a() {
        return 5;
    }
}
