package net.minecraft.src;

public class MCHash {
    private transient MCHashEntry[] slots = new MCHashEntry[16];
    private transient int count;
    private int threshold = 12;
    private final float growFactor = 0.75F;
    private transient volatile int versionStamp;

    private static int computeHash(int var0) {
        var0 ^= var0 >>> 20 ^ var0 >>> 12;
        return var0 ^ var0 >>> 7 ^ var0 >>> 4;
    }

    private static int getSlotIndex(int var0, int var1) {
        return var0 & var1 - 1;
    }

    public Object lookup(int var1) {
        int var2 = computeHash(var1);

        for(MCHashEntry var3 = this.slots[getSlotIndex(var2, this.slots.length)]; var3 != null; var3 = var3.nextEntry) {
            if (var3.hashEntry == var1) {
                return var3.valueEntry;
            }
        }

        return null;
    }

    public boolean containsItem(int var1) {
        return this.lookupEntry(var1) != null;
    }

    final MCHashEntry lookupEntry(int var1) {
        int var2 = computeHash(var1);

        for(MCHashEntry var3 = this.slots[getSlotIndex(var2, this.slots.length)]; var3 != null; var3 = var3.nextEntry) {
            if (var3.hashEntry == var1) {
                return var3;
            }
        }

        return null;
    }

    public void addKey(int var1, Object var2) {
        int var3 = computeHash(var1);
        int var4 = getSlotIndex(var3, this.slots.length);

        for(MCHashEntry var5 = this.slots[var4]; var5 != null; var5 = var5.nextEntry) {
            if (var5.hashEntry == var1) {
                var5.valueEntry = var2;
            }
        }

        ++this.versionStamp;
        this.insert(var3, var1, var2, var4);
    }

    private void grow(int var1) {
        MCHashEntry[] var2 = this.slots;
        int var3 = var2.length;
        if (var3 == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
        } else {
            MCHashEntry[] var4 = new MCHashEntry[var1];
            this.copyTo(var4);
            this.slots = var4;
            this.threshold = (int)((float)var1 * this.growFactor);
        }
    }

    private void copyTo(MCHashEntry[] var1) {
        MCHashEntry[] var2 = this.slots;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            MCHashEntry var5 = var2[var4];
            if (var5 != null) {
                var2[var4] = null;

                MCHashEntry var6;
                do {
                    var6 = var5.nextEntry;
                    int var7 = getSlotIndex(var5.slotHash, var3);
                    var5.nextEntry = var1[var7];
                    var1[var7] = var5;
                    var5 = var6;
                } while(var6 != null);
            }
        }

    }

    public Object removeObject(int var1) {
        MCHashEntry var2 = this.removeEntry(var1);
        return var2 == null ? null : var2.valueEntry;
    }

    final MCHashEntry removeEntry(int var1) {
        int var2 = computeHash(var1);
        int var3 = getSlotIndex(var2, this.slots.length);
        MCHashEntry var4 = this.slots[var3];

        MCHashEntry var5;
        MCHashEntry var6;
        for(var5 = var4; var5 != null; var5 = var6) {
            var6 = var5.nextEntry;
            if (var5.hashEntry == var1) {
                ++this.versionStamp;
                --this.count;
                if (var4 == var5) {
                    this.slots[var3] = var6;
                } else {
                    var4.nextEntry = var6;
                }

                return var5;
            }

            var4 = var5;
        }

        return var5;
    }

    public void clearMap() {
        ++this.versionStamp;
        MCHashEntry[] var1 = this.slots;

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = null;
        }

        this.count = 0;
    }

    private void insert(int var1, int var2, Object var3, int var4) {
        MCHashEntry var5 = this.slots[var4];
        this.slots[var4] = new MCHashEntry(var1, var2, var3, var5);
        if (this.count++ >= this.threshold) {
            this.grow(2 * this.slots.length);
        }

    }

    // $FF: synthetic method
    static int getHash(int var0) {
        return computeHash(var0);
    }
}
