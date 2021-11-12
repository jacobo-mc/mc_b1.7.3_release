package net.minecraft.src;

public class NextTickListEntry implements Comparable {
    private static long field_1020_f = 0L;
    public int field_1018_a;
    public int field_1017_b;
    public int field_1023_c;
    public int field_1022_d;
    public long field_1021_e;
    private long field_1019_g;

    public NextTickListEntry(int var1, int var2, int var3, int var4) {
        this.field_1019_g = (long)(field_1020_f++);
        this.field_1018_a = var1;
        this.field_1017_b = var2;
        this.field_1023_c = var3;
        this.field_1022_d = var4;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof NextTickListEntry)) {
            return false;
        } else {
            NextTickListEntry var2 = (NextTickListEntry)var1;
            return this.field_1018_a == var2.field_1018_a && this.field_1017_b == var2.field_1017_b && this.field_1023_c == var2.field_1023_c && this.field_1022_d == var2.field_1022_d;
        }
    }

    public int hashCode() {
        return (this.field_1018_a * 128 * 1024 + this.field_1023_c * 128 + this.field_1017_b) * 256 + this.field_1022_d;
    }

    public NextTickListEntry func_733_a(long var1) {
        this.field_1021_e = var1;
        return this;
    }

    public int func_734_a(NextTickListEntry var1) {
        if (this.field_1021_e < var1.field_1021_e) {
            return -1;
        } else if (this.field_1021_e > var1.field_1021_e) {
            return 1;
        } else if (this.field_1019_g < var1.field_1019_g) {
            return -1;
        } else {
            return this.field_1019_g > var1.field_1019_g ? 1 : 0;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_734_a((NextTickListEntry)var1);
    }
}
