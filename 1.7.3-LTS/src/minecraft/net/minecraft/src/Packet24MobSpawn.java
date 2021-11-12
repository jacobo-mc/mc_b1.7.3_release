package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet24MobSpawn extends Packet {
    public int entityId;
    public byte type;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;
    private DataWatcher metaData;
    private List receivedMetadata;

    public Packet24MobSpawn() {
    }

    public Packet24MobSpawn(EntityLiving var1) {
        this.entityId = var1.entityId;
        this.type = (byte)EntityList.getEntityID(var1);
        this.xPosition = MathHelper.floor_double(var1.posX * 32.0D);
        this.yPosition = MathHelper.floor_double(var1.posY * 32.0D);
        this.zPosition = MathHelper.floor_double(var1.posZ * 32.0D);
        this.yaw = (byte)((int)(var1.rotationYaw * 256.0F / 360.0F));
        this.pitch = (byte)((int)(var1.rotationPitch * 256.0F / 360.0F));
        this.metaData = var1.getDataWatcher();
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.type = var1.readByte();
        this.xPosition = var1.readInt();
        this.yPosition = var1.readInt();
        this.zPosition = var1.readInt();
        this.yaw = var1.readByte();
        this.pitch = var1.readByte();
        this.receivedMetadata = DataWatcher.readWatchableObjects(var1);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        var1.writeByte(this.type);
        var1.writeInt(this.xPosition);
        var1.writeInt(this.yPosition);
        var1.writeInt(this.zPosition);
        var1.writeByte(this.yaw);
        var1.writeByte(this.pitch);
        this.metaData.writeWatchableObjects(var1);
    }

    public void processPacket(NetHandler var1) {
        var1.handleMobSpawn(this);
    }

    public int getPacketSize() {
        return 20;
    }

    public List getMetadata() {
        return this.receivedMetadata;
    }
}
