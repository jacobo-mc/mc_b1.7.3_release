package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet25EntityPainting extends Packet {
    public int field_21042_a;
    public int field_21041_b;
    public int field_21046_c;
    public int field_21045_d;
    public int field_21044_e;
    public String field_21043_f;

    public Packet25EntityPainting() {
    }

    public Packet25EntityPainting(EntityPainting var1) {
        this.field_21042_a = var1.field_620_ab;
        this.field_21041_b = var1.field_9322_d;
        this.field_21046_c = var1.field_9321_e;
        this.field_21045_d = var1.field_9320_f;
        this.field_21044_e = var1.field_691_a;
        this.field_21043_f = var1.field_690_b.field_1624_y;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_21042_a = var1.readInt();
        this.field_21043_f = func_27048_a(var1, EnumArt.field_27365_z);
        this.field_21041_b = var1.readInt();
        this.field_21046_c = var1.readInt();
        this.field_21045_d = var1.readInt();
        this.field_21044_e = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21042_a);
        func_27049_a(this.field_21043_f, var1);
        var1.writeInt(this.field_21041_b);
        var1.writeInt(this.field_21046_c);
        var1.writeInt(this.field_21045_d);
        var1.writeInt(this.field_21044_e);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_21146_a(this);
    }

    public int func_329_a() {
        return 24;
    }
}
