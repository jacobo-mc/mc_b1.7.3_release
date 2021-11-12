package net.minecraft.src;

public class SlotFurnace extends Slot {
    private EntityPlayer field_27011_d;

    public SlotFurnace(EntityPlayer var1, IInventory var2, int var3, int var4, int var5) {
        super(var2, var3, var4, var5);
        this.field_27011_d = var1;
    }

    public boolean func_4105_a(ItemStack var1) {
        return false;
    }

    public void func_4103_a(ItemStack var1) {
        var1.func_28155_b(this.field_27011_d.field_615_ag, this.field_27011_d);
        if (var1.field_1617_c == Item.field_223_m.field_291_aS) {
            this.field_27011_d.func_25058_a(AchievementList.field_27385_k, 1);
        }

        if (var1.field_1617_c == Item.field_4020_aT.field_291_aS) {
            this.field_27011_d.func_25058_a(AchievementList.field_27380_p, 1);
        }

        super.func_4103_a(var1);
    }
}
