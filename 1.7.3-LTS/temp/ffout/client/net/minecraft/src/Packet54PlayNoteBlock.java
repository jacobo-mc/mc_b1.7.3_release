package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet54PlayNoteBlock extends Packet {
    public int field_21037_a;
    public int field_21036_b;
    public int field_21040_c;
    public int field_21039_d;
    public int field_21038_e;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_21037_a = var1.readInt();
        this.field_21036_b = var1.readShort();
        this.field_21040_c = var1.readInt();
        this.field_21039_d = var1.read();
        this.field_21038_e = var1.read();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21037_a);
        var1.writeShort(this.field_21036_b);
        var1.writeInt(this.field_21040_c);
        var1.write(this.field_21039_d);
        var1.write(this.field_21038_e);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_21145_a(this);
    }

    public int func_329_a() {
        return 12;
    }
}
