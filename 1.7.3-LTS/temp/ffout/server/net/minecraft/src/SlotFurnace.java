package net.minecraft.src;

public class SlotFurnace extends Slot {
    private EntityPlayer field_27007_d;

    public SlotFurnace(EntityPlayer var1, IInventory var2, int var3, int var4, int var5) {
        super(var2, var3, var4, var5);
        this.field_27007_d = var1;
    }

    public boolean func_20095_a(ItemStack var1) {
        return false;
    }

    public void func_20091_b(ItemStack var1) {
        var1.func_28142_b(this.field_27007_d.field_9093_l, this.field_27007_d);
        if (var1.field_855_c == Item.field_166_m.field_234_aS) {
            this.field_27007_d.func_25046_a(AchievementList.field_27108_k, 1);
        }

        if (var1.field_855_c == Item.field_4192_aT.field_234_aS) {
            this.field_27007_d.func_25046_a(AchievementList.field_27103_p, 1);
        }

        super.func_20091_b(var1);
    }
}
