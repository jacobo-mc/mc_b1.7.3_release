package net.minecraft.src;

public class EntitySplashFX extends EntityRainFX {
    public EntitySplashFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1, var2, var4, var6);
        this.field_664_h = 0.04F;
        ++this.field_670_b;
        if (var10 == 0.0D && (var8 != 0.0D || var12 != 0.0D)) {
            this.field_608_an = var8;
            this.field_607_ao = var10 + 0.1D;
            this.field_606_ap = var12;
        }

    }
}
