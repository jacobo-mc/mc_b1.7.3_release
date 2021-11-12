package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet20NamedEntitySpawn extends Packet {
    public int field_534_a;
    public String field_533_b;
    public int field_540_c;
    public int field_539_d;
    public int field_538_e;
    public byte field_537_f;
    public byte field_536_g;
    public int field_535_h;

    public Packet20NamedEntitySpawn() {
    }

    public Packet20NamedEntitySpawn(EntityPlayer var1) {
        this.field_534_a = var1.field_620_ab;
        this.field_533_b = var1.field_771_i;
        this.field_540_c = MathHelper.func_1108_b(var1.field_611_ak * 32.0D);
        this.field_539_d = MathHelper.func_1108_b(var1.field_610_al * 32.0D);
        this.field_538_e = MathHelper.func_1108_b(var1.field_609_am * 32.0D);
        this.field_537_f = (byte)((int)(var1.field_605_aq * 256.0F / 360.0F));
        this.field_536_g = (byte)((int)(var1.field_604_ar * 256.0F / 360.0F));
        ItemStack var2 = var1.field_778_b.func_494_a();
        this.field_535_h = var2 == null ? 0 : var2.field_1617_c;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_534_a = var1.readInt();
        this.field_533_b = func_27048_a(var1, 16);
        this.field_540_c = var1.readInt();
        this.field_539_d = var1.readInt();
        this.field_538_e = var1.readInt();
        this.field_537_f = var1.readByte();
        this.field_536_g = var1.readByte();
        this.field_535_h = var1.readShort();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_534_a);
        func_27049_a(this.field_533_b, var1);
        var1.writeInt(this.field_540_c);
        var1.writeInt(this.field_539_d);
        var1.writeInt(this.field_538_e);
        var1.writeByte(this.field_537_f);
        var1.writeByte(this.field_536_g);
        var1.writeShort(this.field_535_h);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_820_a(this);
    }

    public int func_329_a() {
        return 28;
    }
}
