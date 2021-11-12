package net.minecraft.src;

class PlayerHashEntry {
    final long key;
    Object value;
    PlayerHashEntry nextEntry;
    final int field_1026_d;

    PlayerHashEntry(int var1, long var2, Object var4, PlayerHashEntry var5) {
        this.value = var4;
        this.nextEntry = var5;
        this.key = var2;
        this.field_1026_d = var1;
    }

    public final long func_736_a() {
        return this.key;
    }

    public final Object func_735_b() {
        return this.value;
    }

    public final boolean equals(Object var1) {
        if (!(var1 instanceof PlayerHashEntry)) {
            return false;
        } else {
            PlayerHashEntry var2 = (PlayerHashEntry)var1;
            Long var3 = this.func_736_a();
            Long var4 = var2.func_736_a();
            if (var3 == var4 || var3 != null && var3.equals(var4)) {
                Object var5 = this.func_735_b();
                Object var6 = var2.func_735_b();
                if (var5 == var6 || var5 != null && var5.equals(var6)) {
                    return true;
                }
            }

            return false;
        }
    }

    public final int hashCode() {
        return PlayerHash.getHashCode(this.key);
    }

    public final String toString() {
        return this.func_736_a() + "=" + this.func_735_b();
    }
}
