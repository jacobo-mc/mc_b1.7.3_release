package net.minecraft.src;

class MCHashEntry {
    final int field_1106_a;
    Object field_1105_b;
    MCHashEntry field_1108_c;
    final int field_1107_d;

    MCHashEntry(int var1, int var2, Object var3, MCHashEntry var4) {
        this.field_1105_b = var3;
        this.field_1108_c = var4;
        this.field_1106_a = var2;
        this.field_1107_d = var1;
    }

    public final int func_768_a() {
        return this.field_1106_a;
    }

    public final Object func_767_b() {
        return this.field_1105_b;
    }

    public final boolean equals(Object var1) {
        if (!(var1 instanceof MCHashEntry)) {
            return false;
        } else {
            MCHashEntry var2 = (MCHashEntry)var1;
            Integer var3 = this.func_768_a();
            Integer var4 = var2.func_768_a();
            if (var3 == var4 || var3 != null && var3.equals(var4)) {
                Object var5 = this.func_767_b();
                Object var6 = var2.func_767_b();
                if (var5 == var6 || var5 != null && var5.equals(var6)) {
                    return true;
                }
            }

            return false;
        }
    }

    public final int hashCode() {
        return MCHash.func_1056_d(this.field_1106_a);
    }

    public final String toString() {
        return this.func_768_a() + "=" + this.func_767_b();
    }
}
