package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Packet51MapChunk extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int xSize;
    public int ySize;
    public int zSize;
    public byte[] chunk;
    private int chunkSize;

    public Packet51MapChunk() {
        this.isChunkDataPacket = true;
    }

    public Packet51MapChunk(int var1, int var2, int var3, int var4, int var5, int var6, World var7) {
        this.isChunkDataPacket = true;
        this.xPosition = var1;
        this.yPosition = var2;
        this.zPosition = var3;
        this.xSize = var4;
        this.ySize = var5;
        this.zSize = var6;
        byte[] var8 = var7.getChunkData(var1, var2, var3, var4, var5, var6);
        Deflater var9 = new Deflater(-1);

        try {
            var9.setInput(var8);
            var9.finish();
            this.chunk = new byte[var4 * var5 * var6 * 5 / 2];
            this.chunkSize = var9.deflate(this.chunk);
        } finally {
            var9.end();
        }

    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xPosition = var1.readInt();
        this.yPosition = var1.readShort();
        this.zPosition = var1.readInt();
        this.xSize = var1.read() + 1;
        this.ySize = var1.read() + 1;
        this.zSize = var1.read() + 1;
        this.chunkSize = var1.readInt();
        byte[] var2 = new byte[this.chunkSize];
        var1.readFully(var2);
        this.chunk = new byte[this.xSize * this.ySize * this.zSize * 5 / 2];
        Inflater var3 = new Inflater();
        var3.setInput(var2);

        try {
            var3.inflate(this.chunk);
        } catch (DataFormatException var8) {
            throw new IOException("Bad compressed data format");
        } finally {
            var3.end();
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.xPosition);
        var1.writeShort(this.yPosition);
        var1.writeInt(this.zPosition);
        var1.write(this.xSize - 1);
        var1.write(this.ySize - 1);
        var1.write(this.zSize - 1);
        var1.writeInt(this.chunkSize);
        var1.write(this.chunk, 0, this.chunkSize);
    }

    public void processPacket(NetHandler var1) {
        var1.handleMapChunk(this);
    }

    public int getPacketSize() {
        return 17 + this.chunkSize;
    }
}
