package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet28EntityVelocity extends Packet {
    public int field_6367_a;
    public int field_6366_b;
    public int field_6369_c;
    public int field_6368_d;

    public Packet28EntityVelocity() {
    }

    public Packet28EntityVelocity(Entity var1) {
        this(var1.field_620_ab, var1.field_608_an, var1.field_607_ao, var1.field_606_ap);
    }

    public Packet28EntityVelocity(int var1, double var2, double var4, double var6) {
        this.field_6367_a = var1;
        double var8 = 3.9D;
        if (var2 < -var8) {
            var2 = -var8;
        }

        if (var4 < -var8) {
            var4 = -var8;
        }

        if (var6 < -var8) {
            var6 = -var8;
        }

        if (var2 > var8) {
            var2 = var8;
        }

        if (var4 > var8) {
            var4 = var8;
        }

        if (var6 > var8) {
            var6 = var8;
        }

        this.field_6366_b = (int)(var2 * 8000.0D);
        this.field_6369_c = (int)(var4 * 8000.0D);
        this.field_6368_d = (int)(var6 * 8000.0D);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_6367_a = var1.readInt();
        this.field_6366_b = var1.readShort();
        this.field_6369_c = var1.readShort();
        this.field_6368_d = var1.readShort();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_6367_a);
        var1.writeShort(this.field_6366_b);
        var1.writeShort(this.field_6369_c);
        var1.writeShort(this.field_6368_d);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_6498_a(this);
    }

    public int func_329_a() {
        return 10;
    }
}
