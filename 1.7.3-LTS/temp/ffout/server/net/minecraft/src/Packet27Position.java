package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet27Position extends Packet {
    private float field_22035_a;
    private float field_22034_b;
    private boolean field_22039_c;
    private boolean field_22038_d;
    private float field_22037_e;
    private float field_22036_f;

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_22035_a = var1.readFloat();
        this.field_22034_b = var1.readFloat();
        this.field_22037_e = var1.readFloat();
        this.field_22036_f = var1.readFloat();
        this.field_22039_c = var1.readBoolean();
        this.field_22038_d = var1.readBoolean();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeFloat(this.field_22035_a);
        var1.writeFloat(this.field_22034_b);
        var1.writeFloat(this.field_22037_e);
        var1.writeFloat(this.field_22036_f);
        var1.writeBoolean(this.field_22039_c);
        var1.writeBoolean(this.field_22038_d);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_22001_a(this);
    }

    public int func_71_a() {
        return 18;
    }

    public float func_22031_c() {
        return this.field_22035_a;
    }

    public float func_22029_d() {
        return this.field_22037_e;
    }

    public float func_22028_e() {
        return this.field_22034_b;
    }

    public float func_22033_f() {
        return this.field_22036_f;
    }

    public boolean func_22032_g() {
        return this.field_22039_c;
    }

    public boolean func_22030_h() {
        return this.field_22038_d;
    }
}
