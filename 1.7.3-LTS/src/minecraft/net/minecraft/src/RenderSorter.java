package net.minecraft.src;

import java.util.Comparator;

public class RenderSorter implements Comparator {
    private EntityLiving baseEntity;

    public RenderSorter(EntityLiving var1) {
        this.baseEntity = var1;
    }

    public int doCompare(WorldRenderer var1, WorldRenderer var2) {
        boolean var3 = var1.isInFrustum;
        boolean var4 = var2.isInFrustum;
        if (var3 && !var4) {
            return 1;
        } else if (var4 && !var3) {
            return -1;
        } else {
            double var5 = (double)var1.distanceToEntitySquared(this.baseEntity);
            double var7 = (double)var2.distanceToEntitySquared(this.baseEntity);
            if (var5 < var7) {
                return 1;
            } else if (var5 > var7) {
                return -1;
            } else {
                return var1.chunkIndex < var2.chunkIndex ? 1 : -1;
            }
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.doCompare((WorldRenderer)var1, (WorldRenderer)var2);
    }
}
