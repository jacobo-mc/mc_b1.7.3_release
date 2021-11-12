package net.minecraft.src;

public class PlayerHash {
    private transient PlayerHashEntry[] field_949_a = new PlayerHashEntry[16];
    private transient int field_948_b;
    private int field_952_c = 12;
    private final float field_951_d = 0.75F;
    private transient volatile int field_950_e;

    private static int func_671_e(long var0) {
        return func_676_a((int)(var0 ^ var0 >>> 32));
    }

    private static int func_676_a(int var0) {
        var0 ^= var0 >>> 20 ^ var0 >>> 12;
        return var0 ^ var0 >>> 7 ^ var0 >>> 4;
    }

    private static int func_678_a(int var0, int var1) {
        return var0 & var1 - 1;
    }

    public Object func_677_a(long var1) {
        int var3 = func_671_e(var1);

        for(PlayerHashEntry var4 = this.field_949_a[func_678_a(var3, this.field_949_a.length)]; var4 != null; var4 = var4.field_1027_c) {
            if (var4.field_1025_a == var1) {
                return var4.field_1024_b;
            }
        }

        return null;
    }

    public void func_675_a(long var1, Object var3) {
        int var4 = func_671_e(var1);
        int var5 = func_678_a(var4, this.field_949_a.length);

        for(PlayerHashEntry var6 = this.field_949_a[var5]; var6 != null; var6 = var6.field_1027_c) {
            if (var6.field_1025_a == var1) {
                var6.field_1024_b = var3;
            }
        }

        ++this.field_950_e;
        this.func_679_a(var4, var1, var3, var5);
    }

    private void func_680_b(int var1) {
        PlayerHashEntry[] var2 = this.field_949_a;
        int var3 = var2.length;
        if (var3 == 1073741824) {
            this.field_952_c = Integer.MAX_VALUE;
        } else {
            PlayerHashEntry[] var4 = new PlayerHashEntry[var1];
            this.func_673_a(var4);
            this.field_949_a = var4;
            this.field_952_c = (int)((float)var1 * this.field_951_d);
        }
    }

    private void func_673_a(PlayerHashEntry[] var1) {
        PlayerHashEntry[] var2 = this.field_949_a;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            PlayerHashEntry var5 = var2[var4];
            if (var5 != null) {
                var2[var4] = null;

                PlayerHashEntry var6;
                do {
                    var6 = var5.field_1027_c;
                    int var7 = func_678_a(var5.field_1026_d, var3);
                    var5.field_1027_c = var1[var7];
                    var1[var7] = var5;
                    var5 = var6;
                } while(var6 != null);
            }
        }

    }

    public Object func_670_b(long var1) {
        PlayerHashEntry var3 = this.func_672_c(var1);
        return var3 == null ? null : var3.field_1024_b;
    }

    final PlayerHashEntry func_672_c(long var1) {
        int var3 = func_671_e(var1);
        int var4 = func_678_a(var3, this.field_949_a.length);
        PlayerHashEntry var5 = this.field_949_a[var4];

        PlayerHashEntry var6;
        PlayerHashEntry var7;
        for(var6 = var5; var6 != null; var6 = var7) {
            var7 = var6.field_1027_c;
            if (var6.field_1025_a == var1) {
                ++this.field_950_e;
                --this.field_948_b;
                if (var5 == var6) {
                    this.field_949_a[var4] = var7;
                } else {
                    var5.field_1027_c = var7;
                }

                return var6;
            }

            var5 = var6;
        }

        return var6;
    }

    private void func_679_a(int var1, long var2, Object var4, int var5) {
        PlayerHashEntry var6 = this.field_949_a[var5];
        this.field_949_a[var5] = new PlayerHashEntry(var1, var2, var4, var6);
        if (this.field_948_b++ >= this.field_952_c) {
            this.func_680_b(2 * this.field_949_a.length);
        }

    }

    // $FF: synthetic method
    static int func_674_d(long var0) {
        return func_671_e(var0);
    }
}
