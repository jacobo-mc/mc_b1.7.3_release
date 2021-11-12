package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet24MobSpawn extends Packet {
    public int field_59_a;
    public byte field_58_b;
    public int field_64_c;
    public int field_63_d;
    public int field_62_e;
    public byte field_61_f;
    public byte field_60_g;
    private DataWatcher field_21006_h;
    private List field_21005_i;

    public Packet24MobSpawn() {
    }

    public Packet24MobSpawn(EntityLiving var1) {
        this.field_59_a = var1.field_331_c;
        this.field_58_b = (byte)EntityList.func_565_a(var1);
        this.field_64_c = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_63_d = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_62_e = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        this.field_61_f = (byte)((int)(var1.field_316_r * 256.0F / 360.0F));
        this.field_60_g = (byte)((int)(var1.field_315_s * 256.0F / 360.0F));
        this.field_21006_h = var1.func_21039_p();
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_59_a = var1.readInt();
        this.field_58_b = var1.readByte();
        this.field_64_c = var1.readInt();
        this.field_63_d = var1.readInt();
        this.field_62_e = var1.readInt();
        this.field_61_f = var1.readByte();
        this.field_60_g = var1.readByte();
        this.field_21005_i = DataWatcher.func_21149_a(var1);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_59_a);
        var1.writeByte(this.field_58_b);
        var1.writeInt(this.field_64_c);
        var1.writeInt(this.field_63_d);
        var1.writeInt(this.field_62_e);
        var1.writeByte(this.field_61_f);
        var1.writeByte(this.field_60_g);
        this.field_21006_h.func_21152_a(var1);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4006_a(this);
    }

    public int func_71_a() {
        return 20;
    }
}
