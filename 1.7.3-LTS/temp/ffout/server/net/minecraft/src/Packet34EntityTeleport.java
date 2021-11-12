package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet34EntityTeleport extends Packet {
    public int field_131_a;
    public int field_130_b;
    public int field_135_c;
    public int field_134_d;
    public byte field_133_e;
    public byte field_132_f;

    public Packet34EntityTeleport() {
    }

    public Packet34EntityTeleport(Entity var1) {
        this.field_131_a = var1.field_331_c;
        this.field_130_b = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_135_c = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_134_d = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        this.field_133_e = (byte)((int)(var1.field_316_r * 256.0F / 360.0F));
        this.field_132_f = (byte)((int)(var1.field_315_s * 256.0F / 360.0F));
    }

    public Packet34EntityTeleport(int var1, int var2, int var3, int var4, byte var5, byte var6) {
        this.field_131_a = var1;
        this.field_130_b = var2;
        this.field_135_c = var3;
        this.field_134_d = var4;
        this.field_133_e = var5;
        this.field_132_f = var6;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_131_a = var1.readInt();
        this.field_130_b = var1.readInt();
        this.field_135_c = var1.readInt();
        this.field_134_d = var1.readInt();
        this.field_133_e = (byte)var1.read();
        this.field_132_f = (byte)var1.read();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_131_a);
        var1.writeInt(this.field_130_b);
        var1.writeInt(this.field_135_c);
        var1.writeInt(this.field_134_d);
        var1.write(this.field_133_e);
        var1.write(this.field_132_f);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4007_a(this);
    }

    public int func_71_a() {
        return 34;
    }
}
