package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet255KickDisconnect extends Packet {
    public String reason;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String var1) {
        this.reason = var1;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.reason = readString(var1, 100);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        writeString(this.reason, var1);
    }

    public void processPacket(NetHandler var1) {
        var1.handleKickDisconnect(this);
    }

    public int getPacketSize() {
        return this.reason.length();
    }
}
