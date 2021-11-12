package net.minecraft.src;

import java.util.Comparator;

public class EntitySorter implements Comparator {
    private double entityPosX;
    private double entityPosY;
    private double entityPosZ;

    public EntitySorter(Entity var1) {
        this.entityPosX = -var1.posX;
        this.entityPosY = -var1.posY;
        this.entityPosZ = -var1.posZ;
    }

    public int sortByDistanceToEntity(WorldRenderer var1, WorldRenderer var2) {
        double var3 = (double)var1.posXPlus + this.entityPosX;
        double var5 = (double)var1.posYPlus + this.entityPosY;
        double var7 = (double)var1.posZPlus + this.entityPosZ;
        double var9 = (double)var2.posXPlus + this.entityPosX;
        double var11 = (double)var2.posYPlus + this.entityPosY;
        double var13 = (double)var2.posZPlus + this.entityPosZ;
        return (int)((var3 * var3 + var5 * var5 + var7 * var7 - (var9 * var9 + var11 * var11 + var13 * var13)) * 1024.0D);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.sortByDistanceToEntity((WorldRenderer)var1, (WorldRenderer)var2);
    }
}
