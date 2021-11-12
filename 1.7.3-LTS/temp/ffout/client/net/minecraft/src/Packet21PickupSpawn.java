package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet21PickupSpawn extends Packet {
    public int field_531_a;
    public int field_530_b;
    public int field_529_c;
    public int field_528_d;
    public byte field_527_e;
    public byte field_526_f;
    public byte field_525_g;
    public int field_524_h;
    public int field_523_i;
    public int field_21052_l;

    public Packet21PickupSpawn() {
    }

    public Packet21PickupSpawn(EntityItem var1) {
        this.field_531_a = var1.field_620_ab;
        this.field_524_h = var1.field_801_a.field_1617_c;
        this.field_523_i = var1.field_801_a.field_1615_a;
        this.field_21052_l = var1.field_801_a.func_21181_i();
        this.field_530_b = MathHelper.func_1108_b(var1.field_611_ak * 32.0D);
        this.field_529_c = MathHelper.func_1108_b(var1.field_610_al * 32.0D);
        this.field_528_d = MathHelper.func_1108_b(var1.field_609_am * 32.0D);
        this.field_527_e = (byte)((int)(var1.field_608_an * 128.0D));
        this.field_526_f = (byte)((int)(var1.field_607_ao * 128.0D));
        this.field_525_g = (byte)((int)(var1.field_606_ap * 128.0D));
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_531_a = var1.readInt();
        this.field_524_h = var1.readShort();
        this.field_523_i = var1.readByte();
        this.field_21052_l = var1.readShort();
        this.field_530_b = var1.readInt();
        this.field_529_c = var1.readInt();
        this.field_528_d = var1.readInt();
        this.field_527_e = var1.readByte();
        this.field_526_f = var1.readByte();
        this.field_525_g = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_531_a);
        var1.writeShort(this.field_524_h);
        var1.writeByte(this.field_523_i);
        var1.writeShort(this.field_21052_l);
        var1.writeInt(this.field_530_b);
        var1.writeInt(this.field_529_c);
        var1.writeInt(this.field_528_d);
        var1.writeByte(this.field_527_e);
        var1.writeByte(this.field_526_f);
        var1.writeByte(this.field_525_g);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_832_a(this);
    }

    public int func_329_a() {
        return 24;
    }
}
