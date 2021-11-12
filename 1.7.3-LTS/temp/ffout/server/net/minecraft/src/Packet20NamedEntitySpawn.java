package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet20NamedEntitySpawn extends Packet {
    public int field_143_a;
    public String field_142_b;
    public int field_149_c;
    public int field_148_d;
    public int field_147_e;
    public byte field_146_f;
    public byte field_145_g;
    public int field_144_h;

    public Packet20NamedEntitySpawn() {
    }

    public Packet20NamedEntitySpawn(EntityPlayer var1) {
        this.field_143_a = var1.field_331_c;
        this.field_142_b = var1.field_409_aq;
        this.field_149_c = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_148_d = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_147_e = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        this.field_146_f = (byte)((int)(var1.field_316_r * 256.0F / 360.0F));
        this.field_145_g = (byte)((int)(var1.field_315_s * 256.0F / 360.0F));
        ItemStack var2 = var1.field_416_aj.func_213_b();
        this.field_144_h = var2 == null ? 0 : var2.field_855_c;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_143_a = var1.readInt();
        this.field_142_b = func_27037_a(var1, 16);
        this.field_149_c = var1.readInt();
        this.field_148_d = var1.readInt();
        this.field_147_e = var1.readInt();
        this.field_146_f = var1.readByte();
        this.field_145_g = var1.readByte();
        this.field_144_h = var1.readShort();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_143_a);
        func_27038_a(this.field_142_b, var1);
        var1.writeInt(this.field_149_c);
        var1.writeInt(this.field_148_d);
        var1.writeInt(this.field_147_e);
        var1.writeByte(this.field_146_f);
        var1.writeByte(this.field_145_g);
        var1.writeShort(this.field_144_h);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4002_a(this);
    }

    public int func_71_a() {
        return 28;
    }
}
