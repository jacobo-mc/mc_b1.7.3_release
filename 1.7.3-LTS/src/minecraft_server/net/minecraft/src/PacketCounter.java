package net.minecraft.src;

class PacketCounter {
    private int totalPackets;
    private long totalBytes;

    private PacketCounter() {
    }

    public void addPacket(int var1) {
        ++this.totalPackets;
        this.totalBytes += (long)var1;
    }

    // $FF: synthetic method
    PacketCounter(Empty1 var1) {
        this();
    }
}
