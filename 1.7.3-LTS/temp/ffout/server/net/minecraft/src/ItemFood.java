package net.minecraft.src;

public class ItemFood extends Item {
    private int field_20901_a;
    private boolean field_25011_bi;

    public ItemFood(int var1, int var2, boolean var3) {
        super(var1);
        this.field_20901_a = var2;
        this.field_25011_bi = var3;
        this.field_233_aT = 1;
    }

    public ItemStack func_6152_a(ItemStack var1, World var2, EntityPlayer var3) {
        --var1.field_853_a;
        var3.func_137_a(this.field_20901_a);
        return var1;
    }

    public int func_25009_j() {
        return this.field_20901_a;
    }

    public boolean func_25010_k() {
        return this.field_25011_bi;
    }
}
