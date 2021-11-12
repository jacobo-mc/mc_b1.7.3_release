package net.minecraft.src;

public class NextTickListEntry implements Comparable {
    private static long field_1363_f = 0L;
    public int field_1361_a;
    public int field_1360_b;
    public int field_1366_c;
    public int field_1365_d;
    public long field_1364_e;
    private long field_1362_g;

    public NextTickListEntry(int var1, int var2, int var3, int var4) {
        this.field_1362_g = (long)(field_1363_f++);
        this.field_1361_a = var1;
        this.field_1360_b = var2;
        this.field_1366_c = var3;
        this.field_1365_d = var4;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof NextTickListEntry)) {
            return false;
        } else {
            NextTickListEntry var2 = (NextTickListEntry)var1;
            return this.field_1361_a == var2.field_1361_a && this.field_1360_b == var2.field_1360_b && this.field_1366_c == var2.field_1366_c && this.field_1365_d == var2.field_1365_d;
        }
    }

    public int hashCode() {
        return (this.field_1361_a * 128 * 1024 + this.field_1366_c * 128 + this.field_1360_b) * 256 + this.field_1365_d;
    }

    public NextTickListEntry func_900_a(long var1) {
        this.field_1364_e = var1;
        return this;
    }

    public int func_899_a(NextTickListEntry var1) {
        if (this.field_1364_e < var1.field_1364_e) {
            return -1;
        } else if (this.field_1364_e > var1.field_1364_e) {
            return 1;
        } else if (this.field_1362_g < var1.field_1362_g) {
            return -1;
        } else {
            return this.field_1362_g > var1.field_1362_g ? 1 : 0;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_899_a((NextTickListEntry)var1);
    }
}
