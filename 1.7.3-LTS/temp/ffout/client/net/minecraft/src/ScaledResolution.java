package net.minecraft.src;

public class ScaledResolution {
    private int field_1367_b;
    private int field_1369_c;
    public double field_25121_a;
    public double field_25120_b;
    public int field_1368_a;

    public ScaledResolution(GameSettings var1, int var2, int var3) {
        this.field_1367_b = var2;
        this.field_1369_c = var3;
        this.field_1368_a = 1;
        int var4 = var1.field_25148_H;
        if (var4 == 0) {
            var4 = 1000;
        }

        while(this.field_1368_a < var4 && this.field_1367_b / (this.field_1368_a + 1) >= 320 && this.field_1369_c / (this.field_1368_a + 1) >= 240) {
            ++this.field_1368_a;
        }

        this.field_25121_a = (double)this.field_1367_b / (double)this.field_1368_a;
        this.field_25120_b = (double)this.field_1369_c / (double)this.field_1368_a;
        this.field_1367_b = (int)Math.ceil(this.field_25121_a);
        this.field_1369_c = (int)Math.ceil(this.field_25120_b);
    }

    public int func_903_a() {
        return this.field_1367_b;
    }

    public int func_902_b() {
        return this.field_1369_c;
    }
}
