package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet71Weather extends Packet {
    public int entityID;
    public int posX;
    public int posY;
    public int posZ;
    public int isLightningBolt;

    public Packet71Weather() {
    }

    public Packet71Weather(Entity var1) {
        this.entityID = var1.entityId;
        this.posX = MathHelper.floor_double(var1.posX * 32.0D);
        this.posY = MathHelper.floor_double(var1.posY * 32.0D);
        this.posZ = MathHelper.floor_double(var1.posZ * 32.0D);
        if (var1 instanceof EntityLightningBolt) {
            this.isLightningBolt = 1;
        }

    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityID = var1.readInt();
        this.isLightningBolt = var1.readByte();
        this.posX = var1.readInt();
        this.posY = var1.readInt();
        this.posZ = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityID);
        var1.writeByte(this.isLightningBolt);
        var1.writeInt(this.posX);
        var1.writeInt(this.posY);
        var1.writeInt(this.posZ);
    }

    public void processPacket(NetHandler var1) {
        var1.handleWeather(this);
    }

    public int getPacketSize() {
        return 17;
    }
}
