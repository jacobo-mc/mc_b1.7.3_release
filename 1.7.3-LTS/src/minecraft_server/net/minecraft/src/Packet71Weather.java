package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet71Weather extends Packet {
    public int field_27043_a;
    public int field_27042_b;
    public int field_27046_c;
    public int field_27045_d;
    public int field_27044_e;

    public Packet71Weather() {
    }

    public Packet71Weather(Entity var1) {
        this.field_27043_a = var1.entityId;
        this.field_27042_b = MathHelper.floor_double(var1.posX * 32.0D);
        this.field_27046_c = MathHelper.floor_double(var1.posY * 32.0D);
        this.field_27045_d = MathHelper.floor_double(var1.posZ * 32.0D);
        if (var1 instanceof EntityLightningBolt) {
            this.field_27044_e = 1;
        }

    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.field_27043_a = var1.readInt();
        this.field_27044_e = var1.readByte();
        this.field_27042_b = var1.readInt();
        this.field_27046_c = var1.readInt();
        this.field_27045_d = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_27043_a);
        var1.writeByte(this.field_27044_e);
        var1.writeInt(this.field_27042_b);
        var1.writeInt(this.field_27046_c);
        var1.writeInt(this.field_27045_d);
    }

    public void processPacket(NetHandler var1) {
        var1.func_27002_a(this);
    }

    public int getPacketSize() {
        return 17;
    }
}
