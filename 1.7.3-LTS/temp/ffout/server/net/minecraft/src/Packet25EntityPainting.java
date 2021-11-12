package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet25EntityPainting extends Packet {
    public int field_21013_a;
    public int field_21012_b;
    public int field_21017_c;
    public int field_21016_d;
    public int field_21015_e;
    public String field_21014_f;

    public Packet25EntityPainting() {
    }

    public Packet25EntityPainting(EntityPainting var1) {
        this.field_21013_a = var1.field_331_c;
        this.field_21012_b = var1.field_9188_d;
        this.field_21017_c = var1.field_9187_e;
        this.field_21016_d = var1.field_9186_f;
        this.field_21015_e = var1.field_448_a;
        this.field_21014_f = var1.field_9185_b.field_857_y;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_21013_a = var1.readInt();
        this.field_21014_f = func_27037_a(var1, EnumArt.field_27096_z);
        this.field_21012_b = var1.readInt();
        this.field_21017_c = var1.readInt();
        this.field_21016_d = var1.readInt();
        this.field_21015_e = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21013_a);
        func_27038_a(this.field_21014_f, var1);
        var1.writeInt(this.field_21012_b);
        var1.writeInt(this.field_21017_c);
        var1.writeInt(this.field_21016_d);
        var1.writeInt(this.field_21015_e);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_21003_a(this);
    }

    public int func_71_a() {
        return 24;
    }
}
