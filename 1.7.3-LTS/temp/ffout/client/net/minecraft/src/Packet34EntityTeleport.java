package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet34EntityTeleport extends Packet {
    public int field_509_a;
    public int field_508_b;
    public int field_513_c;
    public int field_512_d;
    public byte field_511_e;
    public byte field_510_f;

    public Packet34EntityTeleport() {
    }

    public Packet34EntityTeleport(Entity var1) {
        this.field_509_a = var1.field_620_ab;
        this.field_508_b = MathHelper.func_1108_b(var1.field_611_ak * 32.0D);
        this.field_513_c = MathHelper.func_1108_b(var1.field_610_al * 32.0D);
        this.field_512_d = MathHelper.func_1108_b(var1.field_609_am * 32.0D);
        this.field_511_e = (byte)((int)(var1.field_605_aq * 256.0F / 360.0F));
        this.field_510_f = (byte)((int)(var1.field_604_ar * 256.0F / 360.0F));
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_509_a = var1.readInt();
        this.field_508_b = var1.readInt();
        this.field_513_c = var1.readInt();
        this.field_512_d = var1.readInt();
        this.field_511_e = (byte)var1.read();
        this.field_510_f = (byte)var1.read();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_509_a);
        var1.writeInt(this.field_508_b);
        var1.writeInt(this.field_513_c);
        var1.writeInt(this.field_512_d);
        var1.write(this.field_511_e);
        var1.write(this.field_510_f);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_829_a(this);
    }

    public int func_329_a() {
        return 34;
    }
}
