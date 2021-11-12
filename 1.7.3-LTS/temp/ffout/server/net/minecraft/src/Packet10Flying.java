package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet10Flying extends Packet {
    public double field_73_a;
    public double field_72_b;
    public double field_71_c;
    public double field_70_d;
    public float field_69_e;
    public float field_68_f;
    public boolean field_67_g;
    public boolean field_66_h;
    public boolean field_65_i;

    public void func_72_a(NetHandler var1) {
        var1.func_18_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_67_g = var1.read() != 0;
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.write(this.field_67_g ? 1 : 0);
    }

    public int func_71_a() {
        return 1;
    }
}
