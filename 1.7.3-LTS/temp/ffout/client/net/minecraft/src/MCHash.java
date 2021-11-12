package net.minecraft.src;

public class MCHash {
    private transient MCHashEntry[] field_1590_a = new MCHashEntry[16];
    private transient int field_1589_b;
    private int field_1593_c = 12;
    private final float field_1592_d = 0.75F;
    private transient volatile int field_1591_e;

    private static int func_1055_e(int var0) {
        var0 ^= var0 >>> 20 ^ var0 >>> 12;
        return var0 ^ var0 >>> 7 ^ var0 >>> 4;
    }

    private static int func_1062_a(int var0, int var1) {
        return var0 & var1 - 1;
    }

    public Object func_1057_a(int var1) {
        int var2 = func_1055_e(var1);

        for(MCHashEntry var3 = this.field_1590_a[func_1062_a(var2, this.field_1590_a.length)]; var3 != null; var3 = var3.field_1108_c) {
            if (var3.field_1106_a == var1) {
                return var3.field_1105_b;
            }
        }

        return null;
    }

    public void func_1061_a(int var1, Object var2) {
        int var3 = func_1055_e(var1);
        int var4 = func_1062_a(var3, this.field_1590_a.length);

        for(MCHashEntry var5 = this.field_1590_a[var4]; var5 != null; var5 = var5.field_1108_c) {
            if (var5.field_1106_a == var1) {
                var5.field_1105_b = var2;
            }
        }

        ++this.field_1591_e;
        this.func_1053_a(var3, var1, var2, var4);
    }

    private void func_1060_f(int var1) {
        MCHashEntry[] var2 = this.field_1590_a;
        int var3 = var2.length;
        if (var3 == 1073741824) {
            this.field_1593_c = Integer.MAX_VALUE;
        } else {
            MCHashEntry[] var4 = new MCHashEntry[var1];
            this.func_1059_a(var4);
            this.field_1590_a = var4;
            this.field_1593_c = (int)((float)var1 * this.field_1592_d);
        }
    }

    private void func_1059_a(MCHashEntry[] var1) {
        MCHashEntry[] var2 = this.field_1590_a;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            MCHashEntry var5 = var2[var4];
            if (var5 != null) {
                var2[var4] = null;

                MCHashEntry var6;
                do {
                    var6 = var5.field_1108_c;
                    int var7 = func_1062_a(var5.field_1107_d, var3);
                    var5.field_1108_c = var1[var7];
                    var1[var7] = var5;
                    var5 = var6;
                } while(var6 != null);
            }
        }

    }

    public Object func_1052_b(int var1) {
        MCHashEntry var2 = this.func_1054_c(var1);
        return var2 == null ? null : var2.field_1105_b;
    }

    final MCHashEntry func_1054_c(int var1) {
        int var2 = func_1055_e(var1);
        int var3 = func_1062_a(var2, this.field_1590_a.length);
        MCHashEntry var4 = this.field_1590_a[var3];

        MCHashEntry var5;
        MCHashEntry var6;
        for(var5 = var4; var5 != null; var5 = var6) {
            var6 = var5.field_1108_c;
            if (var5.field_1106_a == var1) {
                ++this.field_1591_e;
                --this.field_1589_b;
                if (var4 == var5) {
                    this.field_1590_a[var3] = var6;
                } else {
                    var4.field_1108_c = var6;
                }

                return var5;
            }

            var4 = var5;
        }

        return var5;
    }

    public void func_1058_a() {
        ++this.field_1591_e;
        MCHashEntry[] var1 = this.field_1590_a;

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = null;
        }

        this.field_1589_b = 0;
    }

    private void func_1053_a(int var1, int var2, Object var3, int var4) {
        MCHashEntry var5 = this.field_1590_a[var4];
        this.field_1590_a[var4] = new MCHashEntry(var1, var2, var3, var5);
        if (this.field_1589_b++ >= this.field_1593_c) {
            this.func_1060_f(2 * this.field_1590_a.length);
        }

    }

    // $FF: synthetic method
    static int func_1056_d(int var0) {
        return func_1055_e(var0);
    }
}
