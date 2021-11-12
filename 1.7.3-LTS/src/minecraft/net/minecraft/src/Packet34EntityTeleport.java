package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet34EntityTeleport extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;

    public Packet34EntityTeleport() {
    }

    public Packet34EntityTeleport(Entity var1) {
        this.entityId = var1.entityId;
        this.xPosition = MathHelper.floor_double(var1.posX * 32.0D);
        this.yPosition = MathHelper.floor_double(var1.posY * 32.0D);
        this.zPosition = MathHelper.floor_double(var1.posZ * 32.0D);
        this.yaw = (byte)((int)(var1.rotationYaw * 256.0F / 360.0F));
        this.pitch = (byte)((int)(var1.rotationPitch * 256.0F / 360.0F));
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.xPosition = var1.readInt();
        this.yPosition = var1.readInt();
        this.zPosition = var1.readInt();
        this.yaw = (byte)var1.read();
        this.pitch = (byte)var1.read();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        var1.writeInt(this.xPosition);
        var1.writeInt(this.yPosition);
        var1.writeInt(this.zPosition);
        var1.write(this.yaw);
        var1.write(this.pitch);
    }

    public void processPacket(NetHandler var1) {
        var1.handleEntityTeleport(this);
    }

    public int getPacketSize() {
        return 34;
    }
}
