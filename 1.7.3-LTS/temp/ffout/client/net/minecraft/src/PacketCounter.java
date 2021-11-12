package net.minecraft.src;

class PacketCounter {
    private int field_22238_a;
    private long field_22237_b;

    private PacketCounter() {
    }

    public void func_22236_a(int var1) {
        ++this.field_22238_a;
        this.field_22237_b += (long)var1;
    }

    // $FF: synthetic method
    PacketCounter(Empty1 var1) {
        this();
    }
}
