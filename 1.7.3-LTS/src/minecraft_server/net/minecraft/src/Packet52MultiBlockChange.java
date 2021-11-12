package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet52MultiBlockChange extends Packet {
    public int xPosition;
    public int zPosition;
    public short[] coordinateArray;
    public byte[] typeArray;
    public byte[] metadataArray;
    public int size;

    public Packet52MultiBlockChange() {
        this.isChunkDataPacket = true;
    }

    public Packet52MultiBlockChange(int var1, int var2, short[] var3, int var4, World var5) {
        this.isChunkDataPacket = true;
        this.xPosition = var1;
        this.zPosition = var2;
        this.size = var4;
        this.coordinateArray = new short[var4];
        this.typeArray = new byte[var4];
        this.metadataArray = new byte[var4];
        Chunk var6 = var5.getChunkFromChunkCoords(var1, var2);

        for(int var7 = 0; var7 < var4; ++var7) {
            int var8 = var3[var7] >> 12 & 15;
            int var9 = var3[var7] >> 8 & 15;
            int var10 = var3[var7] & 255;
            this.coordinateArray[var7] = var3[var7];
            this.typeArray[var7] = (byte)var6.getBlockID(var8, var10, var9);
            this.metadataArray[var7] = (byte)var6.getBlockMetadata(var8, var10, var9);
        }

    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xPosition = var1.readInt();
        this.zPosition = var1.readInt();
        this.size = var1.readShort() & '\uffff';
        this.coordinateArray = new short[this.size];
        this.typeArray = new byte[this.size];
        this.metadataArray = new byte[this.size];

        for(int var2 = 0; var2 < this.size; ++var2) {
            this.coordinateArray[var2] = var1.readShort();
        }

        var1.readFully(this.typeArray);
        var1.readFully(this.metadataArray);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.xPosition);
        var1.writeInt(this.zPosition);
        var1.writeShort((short)this.size);

        for(int var2 = 0; var2 < this.size; ++var2) {
            var1.writeShort(this.coordinateArray[var2]);
        }

        var1.write(this.typeArray);
        var1.write(this.metadataArray);
    }

    public void processPacket(NetHandler var1) {
        var1.handleMultiBlockChange(this);
    }

    public int getPacketSize() {
        return 10 + this.size * 4;
    }
}
