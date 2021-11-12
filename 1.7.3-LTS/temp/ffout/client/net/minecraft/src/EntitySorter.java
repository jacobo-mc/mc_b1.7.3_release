package net.minecraft.src;

import java.util.Comparator;

public class EntitySorter implements Comparator {
    private double field_30008_a;
    private double field_30007_b;
    private double field_30009_c;

    public EntitySorter(Entity var1) {
        this.field_30008_a = -var1.field_611_ak;
        this.field_30007_b = -var1.field_610_al;
        this.field_30009_c = -var1.field_609_am;
    }

    public int func_1063_a(WorldRenderer var1, WorldRenderer var2) {
        double var3 = (double)var1.field_1746_q + this.field_30008_a;
        double var5 = (double)var1.field_1743_r + this.field_30007_b;
        double var7 = (double)var1.field_1741_s + this.field_30009_c;
        double var9 = (double)var2.field_1746_q + this.field_30008_a;
        double var11 = (double)var2.field_1743_r + this.field_30007_b;
        double var13 = (double)var2.field_1741_s + this.field_30009_c;
        return (int)((var3 * var3 + var5 * var5 + var7 * var7 - (var9 * var9 + var11 * var11 + var13 * var13)) * 1024.0D);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.func_1063_a((WorldRenderer)var1, (WorldRenderer)var2);
    }
}
