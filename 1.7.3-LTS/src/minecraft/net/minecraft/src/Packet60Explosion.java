package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Packet60Explosion extends Packet {
    public double explosionX;
    public double explosionY;
    public double explosionZ;
    public float explosionSize;
    public Set destroyedBlockPositions;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.explosionX = var1.readDouble();
        this.explosionY = var1.readDouble();
        this.explosionZ = var1.readDouble();
        this.explosionSize = var1.readFloat();
        int var2 = var1.readInt();
        this.destroyedBlockPositions = new HashSet();
        int var3 = (int)this.explosionX;
        int var4 = (int)this.explosionY;
        int var5 = (int)this.explosionZ;

        for(int var6 = 0; var6 < var2; ++var6) {
            int var7 = var1.readByte() + var3;
            int var8 = var1.readByte() + var4;
            int var9 = var1.readByte() + var5;
            this.destroyedBlockPositions.add(new ChunkPosition(var7, var8, var9));
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.explosionX);
        var1.writeDouble(this.explosionY);
        var1.writeDouble(this.explosionZ);
        var1.writeFloat(this.explosionSize);
        var1.writeInt(this.destroyedBlockPositions.size());
        int var2 = (int)this.explosionX;
        int var3 = (int)this.explosionY;
        int var4 = (int)this.explosionZ;
        Iterator var5 = this.destroyedBlockPositions.iterator();

        while(var5.hasNext()) {
            ChunkPosition var6 = (ChunkPosition)var5.next();
            int var7 = var6.x - var2;
            int var8 = var6.y - var3;
            int var9 = var6.z - var4;
            var1.writeByte(var7);
            var1.writeByte(var8);
            var1.writeByte(var9);
        }

    }

    public void processPacket(NetHandler var1) {
        var1.handleExplosion(this);
    }

    public int getPacketSize() {
        return 32 + this.destroyedBlockPositions.size() * 3;
    }
}
