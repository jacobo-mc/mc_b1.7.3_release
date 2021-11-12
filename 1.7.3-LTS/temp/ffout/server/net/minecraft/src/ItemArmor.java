package net.minecraft.src;

public class ItemArmor extends Item {
    private static final int[] field_259_ba = new int[]{3, 8, 6, 3};
    private static final int[] field_258_bb = new int[]{11, 16, 15, 13};
    public final int field_254_a;
    public final int field_257_aX;
    public final int field_256_aY;
    public final int field_255_aZ;

    public ItemArmor(int var1, int var2, int var3, int var4) {
        super(var1);
        this.field_254_a = var2;
        this.field_257_aX = var4;
        this.field_255_aZ = var3;
        this.field_256_aY = field_259_ba[var4];
        this.func_21090_d(field_258_bb[var4] * 3 << var2);
        this.field_233_aT = 1;
    }
}
