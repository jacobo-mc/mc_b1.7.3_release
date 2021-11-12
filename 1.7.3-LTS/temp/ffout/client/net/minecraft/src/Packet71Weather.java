package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet71Weather extends Packet {
    public int field_27054_a;
    public int field_27053_b;
    public int field_27057_c;
    public int field_27056_d;
    public int field_27055_e;

    public Packet71Weather() {
    }

    public Packet71Weather(Entity var1) {
        this.field_27054_a = var1.field_620_ab;
        this.field_27053_b = MathHelper.func_1108_b(var1.field_611_ak * 32.0D);
        this.field_27057_c = MathHelper.func_1108_b(var1.field_610_al * 32.0D);
        this.field_27056_d = MathHelper.func_1108_b(var1.field_609_am * 32.0D);
        if (var1 instanceof EntityLightningBolt) {
            this.field_27055_e = 1;
        }

    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_27054_a = var1.readInt();
        this.field_27055_e = var1.readByte();
        this.field_27053_b = var1.readInt();
        this.field_27057_c = var1.readInt();
        this.field_27056_d = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_27054_a);
        var1.writeByte(this.field_27055_e);
        var1.writeInt(this.field_27053_b);
        var1.writeInt(this.field_27057_c);
        var1.writeInt(this.field_27056_d);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_27246_a(this);
    }

    public int func_329_a() {
        return 17;
    }
}
