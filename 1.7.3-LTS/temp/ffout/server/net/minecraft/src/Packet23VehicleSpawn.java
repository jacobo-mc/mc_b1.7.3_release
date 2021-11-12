package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn extends Packet {
    public int field_98_a;
    public int field_97_b;
    public int field_101_c;
    public int field_100_d;
    public int field_28044_e;
    public int field_28043_f;
    public int field_28042_g;
    public int field_99_e;
    public int field_28041_i;

    public Packet23VehicleSpawn() {
    }

    public Packet23VehicleSpawn(Entity var1, int var2) {
        this(var1, var2, 0);
    }

    public Packet23VehicleSpawn(Entity var1, int var2, int var3) {
        this.field_98_a = var1.field_331_c;
        this.field_97_b = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_101_c = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_100_d = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        this.field_99_e = var2;
        this.field_28041_i = var3;
        if (var3 > 0) {
            double var4 = var1.field_319_o;
            double var6 = var1.field_318_p;
            double var8 = var1.field_317_q;
            double var10 = 3.9D;
            if (var4 < -var10) {
                var4 = -var10;
            }

            if (var6 < -var10) {
                var6 = -var10;
            }

            if (var8 < -var10) {
                var8 = -var10;
            }

            if (var4 > var10) {
                var4 = var10;
            }

            if (var6 > var10) {
                var6 = var10;
            }

            if (var8 > var10) {
                var8 = var10;
            }

            this.field_28044_e = (int)(var4 * 8000.0D);
            this.field_28043_f = (int)(var6 * 8000.0D);
            this.field_28042_g = (int)(var8 * 8000.0D);
        }

    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_98_a = var1.readInt();
        this.field_99_e = var1.readByte();
        this.field_97_b = var1.readInt();
        this.field_101_c = var1.readInt();
        this.field_100_d = var1.readInt();
        this.field_28041_i = var1.readInt();
        if (this.field_28041_i > 0) {
            this.field_28044_e = var1.readShort();
            this.field_28043_f = var1.readShort();
            this.field_28042_g = var1.readShort();
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_98_a);
        var1.writeByte(this.field_99_e);
        var1.writeInt(this.field_97_b);
        var1.writeInt(this.field_101_c);
        var1.writeInt(this.field_100_d);
        var1.writeInt(this.field_28041_i);
        if (this.field_28041_i > 0) {
            var1.writeShort(this.field_28044_e);
            var1.writeShort(this.field_28043_f);
            var1.writeShort(this.field_28042_g);
        }

    }

    public void func_72_a(NetHandler var1) {
        var1.func_4003_a(this);
    }

    public int func_71_a() {
        return 21 + this.field_28041_i > 0 ? 6 : 0;
    }
}
