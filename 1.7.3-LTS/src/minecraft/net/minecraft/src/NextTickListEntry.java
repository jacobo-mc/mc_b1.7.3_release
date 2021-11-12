package net.minecraft.src;

public class NextTickListEntry implements Comparable {
    private static long nextTickEntryID = 0L;
    public int xCoord;
    public int yCoord;
    public int zCoord;
    public int blockID;
    public long scheduledTime;
    private long tickEntryID;

    public NextTickListEntry(int var1, int var2, int var3, int var4) {
        this.tickEntryID = (long)(nextTickEntryID++);
        this.xCoord = var1;
        this.yCoord = var2;
        this.zCoord = var3;
        this.blockID = var4;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof NextTickListEntry)) {
            return false;
        } else {
            NextTickListEntry var2 = (NextTickListEntry)var1;
            return this.xCoord == var2.xCoord && this.yCoord == var2.yCoord && this.zCoord == var2.zCoord && this.blockID == var2.blockID;
        }
    }

    public int hashCode() {
        return (this.xCoord * 128 * 1024 + this.zCoord * 128 + this.yCoord) * 256 + this.blockID;
    }

    public NextTickListEntry setScheduledTime(long var1) {
        this.scheduledTime = var1;
        return this;
    }

    public int comparer(NextTickListEntry var1) {
        if (this.scheduledTime < var1.scheduledTime) {
            return -1;
        } else if (this.scheduledTime > var1.scheduledTime) {
            return 1;
        } else if (this.tickEntryID < var1.tickEntryID) {
            return -1;
        } else {
            return this.tickEntryID > var1.tickEntryID ? 1 : 0;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.comparer((NextTickListEntry)var1);
    }
}
