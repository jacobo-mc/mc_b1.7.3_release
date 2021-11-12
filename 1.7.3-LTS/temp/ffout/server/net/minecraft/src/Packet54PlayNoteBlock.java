package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet54PlayNoteBlock extends Packet {
    public int field_21008_a;
    public int field_21007_b;
    public int field_21011_c;
    public int field_21010_d;
    public int field_21009_e;

    public Packet54PlayNoteBlock() {
    }

    public Packet54PlayNoteBlock(int var1, int var2, int var3, int var4, int var5) {
        this.field_21008_a = var1;
        this.field_21007_b = var2;
        this.field_21011_c = var3;
        this.field_21010_d = var4;
        this.field_21009_e = var5;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_21008_a = var1.readInt();
        this.field_21007_b = var1.readShort();
        this.field_21011_c = var1.readInt();
        this.field_21010_d = var1.read();
        this.field_21009_e = var1.read();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21008_a);
        var1.writeShort(this.field_21007_b);
        var1.writeInt(this.field_21011_c);
        var1.write(this.field_21010_d);
        var1.write(this.field_21009_e);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_21004_a(this);
    }

    public int func_71_a() {
        return 12;
    }
}
