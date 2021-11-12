package net.minecraft.src;

public class MCHash {
    private transient MCHashEntry[] field_835_a = new MCHashEntry[16];
    private transient int field_834_b;
    private int field_838_c = 12;
    private final float field_837_d = 0.75F;
    private transient volatile int field_836_e;

    private static int func_545_g(int var0) {
        var0 ^= var0 >>> 20 ^ var0 >>> 12;
        return var0 ^ var0 >>> 7 ^ var0 >>> 4;
    }

    private static int func_555_a(int var0, int var1) {
        return var0 & var1 - 1;
    }

    public Object func_550_a(int var1) {
        int var2 = func_545_g(var1);

        for(MCHashEntry var3 = this.field_835_a[func_555_a(var2, this.field_835_a.length)]; var3 != null; var3 = var3.field_843_c) {
            if (var3.field_841_a == var1) {
                return var3.field_840_b;
            }
        }

        return null;
    }

    public boolean func_556_b(int var1) {
        return this.func_548_c(var1) != null;
    }

    final MCHashEntry func_548_c(int var1) {
        int var2 = func_545_g(var1);

        for(MCHashEntry var3 = this.field_835_a[func_555_a(var2, this.field_835_a.length)]; var3 != null; var3 = var3.field_843_c) {
            if (var3.field_841_a == var1) {
                return var3;
            }
        }

        return null;
    }

    public void func_554_a(int var1, Object var2) {
        int var3 = func_545_g(var1);
        int var4 = func_555_a(var3, this.field_835_a.length);

        for(MCHashEntry var5 = this.field_835_a[var4]; var5 != null; var5 = var5.field_843_c) {
            if (var5.field_841_a == var1) {
                var5.field_840_b = var2;
            }
        }

        ++this.field_836_e;
        this.func_547_a(var3, var1, var2, var4);
    }

    private void func_552_h(int var1) {
        MCHashEntry[] var2 = this.field_835_a;
        int var3 = var2.length;
        if (var3 == 1073741824) {
            this.field_838_c = Integer.MAX_VALUE;
        } else {
            MCHashEntry[] var4 = new MCHashEntry[var1];
            this.func_549_a(var4);
            this.field_835_a = var4;
            this.field_838_c = (int)((float)var1 * this.field_837_d);
        }
    }

    private void func_549_a(MCHashEntry[] var1) {
        MCHashEntry[] var2 = this.field_835_a;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            MCHashEntry var5 = var2[var4];
            if (var5 != null) {
                var2[var4] = null;

                MCHashEntry var6;
                do {
                    var6 = var5.field_843_c;
                    int var7 = func_555_a(var5.field_842_d, var3);
                    var5.field_843_c = var1[var7];
                    var1[var7] = var5;
                    var5 = var6;
                } while(var6 != null);
            }
        }

    }

    public Object func_553_d(int var1) {
        MCHashEntry var2 = this.func_557_e(var1);
        return var2 == null ? null : var2.field_840_b;
    }

    final MCHashEntry func_557_e(int var1) {
        int var2 = func_545_g(var1);
        int var3 = func_555_a(var2, this.field_835_a.length);
        MCHashEntry var4 = this.field_835_a[var3];

        MCHashEntry var5;
        MCHashEntry var6;
        for(var5 = var4; var5 != null; var5 = var6) {
            var6 = var5.field_843_c;
            if (var5.field_841_a == var1) {
                ++this.field_836_e;
                --this.field_834_b;
                if (var4 == var5) {
                    this.field_835_a[var3] = var6;
                } else {
                    var4.field_843_c = var6;
                }

                return var5;
            }

            var4 = var5;
        }

        return var5;
    }

    public void func_551_a() {
        ++this.field_836_e;
        MCHashEntry[] var1 = this.field_835_a;

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = null;
        }

        this.field_834_b = 0;
    }

    private void func_547_a(int var1, int var2, Object var3, int var4) {
        MCHashEntry var5 = this.field_835_a[var4];
        this.field_835_a[var4] = new MCHashEntry(var1, var2, var3, var5);
        if (this.field_834_b++ >= this.field_838_c) {
            this.func_552_h(2 * this.field_835_a.length);
        }

    }

    // $FF: synthetic method
    static int func_546_f(int var0) {
        return func_545_g(var0);
    }
}
