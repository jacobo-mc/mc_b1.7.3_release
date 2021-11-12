package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet71Weather extends Packet {
    public int field_27043_a;
    public int field_27042_b;
    public int field_27046_c;
    public int field_27045_d;
    public int field_27044_e;

    public Packet71Weather() {
    }

    public Packet71Weather(Entity var1) {
        this.field_27043_a = var1.field_331_c;
        this.field_27042_b = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_27046_c = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_27045_d = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        if (var1 instanceof EntityLightningBolt) {
            this.field_27044_e = 1;
        }

    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_27043_a = var1.readInt();
        this.field_27044_e = var1.readByte();
        this.field_27042_b = var1.readInt();
        this.field_27046_c = var1.readInt();
        this.field_27045_d = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_27043_a);
        var1.writeByte(this.field_27044_e);
        var1.writeInt(this.field_27042_b);
        var1.writeInt(this.field_27046_c);
        var1.writeInt(this.field_27045_d);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_27002_a(this);
    }

    public int func_71_a() {
        return 17;
    }
}
