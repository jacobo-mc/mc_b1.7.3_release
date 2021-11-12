package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet28EntityVelocity extends Packet {
    public int entityId;
    public int motionX;
    public int motionY;
    public int motionZ;

    public Packet28EntityVelocity() {
    }

    public Packet28EntityVelocity(Entity var1) {
        this(var1.entityId, var1.motionX, var1.motionY, var1.motionZ);
    }

    public Packet28EntityVelocity(int var1, double var2, double var4, double var6) {
        this.entityId = var1;
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

        this.motionX = (int)(var2 * 8000.0D);
        this.motionY = (int)(var4 * 8000.0D);
        this.motionZ = (int)(var6 * 8000.0D);
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.motionX = var1.readShort();
        this.motionY = var1.readShort();
        this.motionZ = var1.readShort();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        var1.writeShort(this.motionX);
        var1.writeShort(this.motionY);
        var1.writeShort(this.motionZ);
    }

    public void processPacket(NetHandler var1) {
        var1.func_6002_a(this);
    }

    public int getPacketSize() {
        return 10;
    }
}
