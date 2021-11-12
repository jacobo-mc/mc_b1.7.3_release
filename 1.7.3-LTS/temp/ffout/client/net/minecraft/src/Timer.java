package net.minecraft.src;

public class Timer {
    public float field_1380_a;
    private double field_1375_f;
    public int field_1379_b;
    public float field_1378_c;
    public float field_1377_d = 1.0F;
    public float field_1376_e = 0.0F;
    private long field_1374_g;
    private long field_1373_h;
    private long field_28132_i;
    private double field_1372_i = 1.0D;

    public Timer(float var1) {
        this.field_1380_a = var1;
        this.field_1374_g = System.currentTimeMillis();
        this.field_1373_h = System.nanoTime() / 1000000L;
    }

    public void func_904_a() {
        long var1 = System.currentTimeMillis();
        long var3 = var1 - this.field_1374_g;
        long var5 = System.nanoTime() / 1000000L;
        double var7 = (double)var5 / 1000.0D;
        if (var3 > 1000L) {
            this.field_1375_f = var7;
        } else if (var3 < 0L) {
            this.field_1375_f = var7;
        } else {
            this.field_28132_i += var3;
            if (this.field_28132_i > 1000L) {
                long var9 = var5 - this.field_1373_h;
                double var11 = (double)this.field_28132_i / (double)var9;
                this.field_1372_i += (var11 - this.field_1372_i) * 0.20000000298023224D;
                this.field_1373_h = var5;
                this.field_28132_i = 0L;
            }

            if (this.field_28132_i < 0L) {
                this.field_1373_h = var5;
            }
        }

        this.field_1374_g = var1;
        double var13 = (var7 - this.field_1375_f) * this.field_1372_i;
        this.field_1375_f = var7;
        if (var13 < 0.0D) {
            var13 = 0.0D;
        }

        if (var13 > 1.0D) {
            var13 = 1.0D;
        }

        this.field_1376_e = (float)((double)this.field_1376_e + var13 * (double)this.field_1377_d * (double)this.field_1380_a);
        this.field_1379_b = (int)this.field_1376_e;
        this.field_1376_e -= (float)this.field_1379_b;
        if (this.field_1379_b > 10) {
            this.field_1379_b = 10;
        }

        this.field_1378_c = this.field_1376_e;
    }
}
