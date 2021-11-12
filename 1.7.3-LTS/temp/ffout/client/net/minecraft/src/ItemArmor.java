package net.minecraft.src;

public class ItemArmor extends Item {
    private static final int[] field_315_ba = new int[]{3, 8, 6, 3};
    private static final int[] field_314_bb = new int[]{11, 16, 15, 13};
    public final int field_310_a;
    public final int field_313_aX;
    public final int field_312_aY;
    public final int field_311_aZ;

    public ItemArmor(int var1, int var2, int var3, int var4) {
        super(var1);
        this.field_310_a = var2;
        this.field_313_aX = var4;
        this.field_311_aZ = var3;
        this.field_312_aY = field_315_ba[var4];
        this.func_21013_d(field_314_bb[var4] * 3 << var2);
        this.field_290_aT = 1;
    }
}
