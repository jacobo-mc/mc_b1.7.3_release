package net.minecraft.src;

import java.util.Comparator;

public class RenderSorter implements Comparator {
    private EntityLiving field_4274_a;

    public RenderSorter(EntityLiving var1) {
        this.field_4274_a = var1;
    }

    public int func_993_a(WorldRenderer var1, WorldRenderer var2) {
        boolean var3 = var1.field_1749_o;
        boolean var4 = var2.field_1749_o;
        if (var3 && !var4) {
            return 1;
        } else if (var4 && !var3) {
            return -1;
        } else {
            double var5 = (double)var1.func_1202_a(this.field_4274_a);
            double var7 = (double)var2.func_1202_a(this.field_4274_a);
            if (var5 < var7) {
                return 1;
            } else if (var5 > var7) {
                return -1;
            } else {
                return var1.field_1735_w < var2.field_1735_w ? 1 : -1;
            }
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.func_993_a((WorldRenderer)var1, (WorldRenderer)var2);
    }
}
