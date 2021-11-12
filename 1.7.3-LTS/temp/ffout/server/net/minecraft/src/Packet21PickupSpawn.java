package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet21PickupSpawn extends Packet {
    public int field_129_a;
    public int field_128_b;
    public int field_127_c;
    public int field_126_d;
    public byte field_125_e;
    public byte field_124_f;
    public byte field_123_g;
    public int field_122_h;
    public int field_121_i;
    public int field_21023_j;

    public Packet21PickupSpawn() {
    }

    public Packet21PickupSpawn(EntityItem var1) {
        this.field_129_a = var1.field_331_c;
        this.field_122_h = var1.field_429_a.field_855_c;
        this.field_121_i = var1.field_429_a.field_853_a;
        this.field_21023_j = var1.field_429_a.func_21125_h();
        this.field_128_b = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_127_c = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_126_d = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        this.field_125_e = (byte)((int)(var1.field_319_o * 128.0D));
        this.field_124_f = (byte)((int)(var1.field_318_p * 128.0D));
        this.field_123_g = (byte)((int)(var1.field_317_q * 128.0D));
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_129_a = var1.readInt();
        this.field_122_h = var1.readShort();
        this.field_121_i = var1.readByte();
        this.field_21023_j = var1.readShort();
        this.field_128_b = var1.readInt();
        this.field_127_c = var1.readInt();
        this.field_126_d = var1.readInt();
        this.field_125_e = var1.readByte();
        this.field_124_f = var1.readByte();
        this.field_123_g = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_129_a);
        var1.writeShort(this.field_122_h);
        var1.writeByte(this.field_121_i);
        var1.writeShort(this.field_21023_j);
        var1.writeInt(this.field_128_b);
        var1.writeInt(this.field_127_c);
        var1.writeInt(this.field_126_d);
        var1.writeByte(this.field_125_e);
        var1.writeByte(this.field_124_f);
        var1.writeByte(this.field_123_g);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4004_a(this);
    }

    public int func_71_a() {
        return 24;
    }
}
