package net.minecraft.src;

public class SlotCrafting extends Slot {
    private final IInventory field_1125_c;
    private EntityPlayer field_25015_e;

    public SlotCrafting(EntityPlayer var1, IInventory var2, IInventory var3, int var4, int var5, int var6) {
        super(var3, var4, var5, var6);
        this.field_25015_e = var1;
        this.field_1125_c = var2;
    }

    public boolean func_4105_a(ItemStack var1) {
        return false;
    }

    public void func_4103_a(ItemStack var1) {
        var1.func_28155_b(this.field_25015_e.field_615_ag, this.field_25015_e);
        if (var1.field_1617_c == Block.field_387_az.field_376_bc) {
            this.field_25015_e.func_25058_a(AchievementList.field_25197_d, 1);
        } else if (var1.field_1617_c == Item.field_218_r.field_291_aS) {
            this.field_25015_e.func_25058_a(AchievementList.field_27387_i, 1);
        } else if (var1.field_1617_c == Block.field_445_aC.field_376_bc) {
            this.field_25015_e.func_25058_a(AchievementList.field_27386_j, 1);
        } else if (var1.field_1617_c == Item.field_249_L.field_291_aS) {
            this.field_25015_e.func_25058_a(AchievementList.field_27384_l, 1);
        } else if (var1.field_1617_c == Item.field_242_S.field_291_aS) {
            this.field_25015_e.func_25058_a(AchievementList.field_27383_m, 1);
        } else if (var1.field_1617_c == Item.field_21022_aX.field_291_aS) {
            this.field_25015_e.func_25058_a(AchievementList.field_27382_n, 1);
        } else if (var1.field_1617_c == Item.field_214_v.field_291_aS) {
            this.field_25015_e.func_25058_a(AchievementList.field_27381_o, 1);
        } else if (var1.field_1617_c == Item.field_220_p.field_291_aS) {
            this.field_25015_e.func_25058_a(AchievementList.field_27378_r, 1);
        }

        for(int var2 = 0; var2 < this.field_1125_c.func_469_c(); ++var2) {
            ItemStack var3 = this.field_1125_c.func_468_c(var2);
            if (var3 != null) {
                this.field_1125_c.func_473_a(var2, 1);
                if (var3.func_1091_a().func_21014_i()) {
                    this.field_1125_c.func_472_a(var2, new ItemStack(var3.func_1091_a().func_21016_h()));
                }
            }
        }

    }
}
