package net.minecraft.src;

class PacketCounter {
    private int field_22152_a;
    private long field_22151_b;

    private PacketCounter() {
    }

    public void func_22150_a(int var1) {
        ++this.field_22152_a;
        this.field_22151_b += (long)var1;
    }

    // $FF: synthetic method
    PacketCounter(Empty1 var1) {
        this();
    }
}
