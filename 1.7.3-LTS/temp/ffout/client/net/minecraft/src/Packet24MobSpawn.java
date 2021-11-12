package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet24MobSpawn extends Packet {
    public int field_547_a;
    public byte field_546_b;
    public int field_552_c;
    public int field_551_d;
    public int field_550_e;
    public byte field_549_f;
    public byte field_548_g;
    private DataWatcher field_21055_h;
    private List field_21054_i;

    public Packet24MobSpawn() {
    }

    public Packet24MobSpawn(EntityLiving var1) {
        this.field_547_a = var1.field_620_ab;
        this.field_546_b = (byte)EntityList.func_1082_a(var1);
        this.field_552_c = MathHelper.func_1108_b(var1.field_611_ak * 32.0D);
        this.field_551_d = MathHelper.func_1108_b(var1.field_610_al * 32.0D);
        this.field_550_e = MathHelper.func_1108_b(var1.field_609_am * 32.0D);
        this.field_549_f = (byte)((int)(var1.field_605_aq * 256.0F / 360.0F));
        this.field_548_g = (byte)((int)(var1.field_604_ar * 256.0F / 360.0F));
        this.field_21055_h = var1.func_21061_O();
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_547_a = var1.readInt();
        this.field_546_b = var1.readByte();
        this.field_552_c = var1.readInt();
        this.field_551_d = var1.readInt();
        this.field_550_e = var1.readInt();
        this.field_549_f = var1.readByte();
        this.field_548_g = var1.readByte();
        this.field_21054_i = DataWatcher.func_21131_a(var1);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_547_a);
        var1.writeByte(this.field_546_b);
        var1.writeInt(this.field_552_c);
        var1.writeInt(this.field_551_d);
        var1.writeInt(this.field_550_e);
        var1.writeByte(this.field_549_f);
        var1.writeByte(this.field_548_g);
        this.field_21055_h.func_21127_a(var1);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_828_a(this);
    }

    public int func_329_a() {
        return 20;
    }

    public List func_21053_b() {
        return this.field_21054_i;
    }
}
