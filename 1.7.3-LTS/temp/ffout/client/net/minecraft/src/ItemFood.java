package net.minecraft.src;

public class ItemFood extends Item {
    private int field_20921_a;
    private boolean field_25013_bi;

    public ItemFood(int var1, int var2, boolean var3) {
        super(var1);
        this.field_20921_a = var2;
        this.field_25013_bi = var3;
        this.field_290_aT = 1;
    }

    public ItemStack func_193_a(ItemStack var1, World var2, EntityPlayer var3) {
        --var1.field_1615_a;
        var3.func_432_b(this.field_20921_a);
        return var1;
    }

    public int func_25011_l() {
        return this.field_20921_a;
    }

    public boolean func_25012_m() {
        return this.field_25013_bi;
    }
}
