package net.minecraft.src;

public class SlotCrafting extends Slot {
    private final IInventory field_20103_a;
    private EntityPlayer field_25004_e;

    public SlotCrafting(EntityPlayer var1, IInventory var2, IInventory var3, int var4, int var5, int var6) {
        super(var3, var4, var5, var6);
        this.field_25004_e = var1;
        this.field_20103_a = var2;
    }

    public boolean func_20095_a(ItemStack var1) {
        return false;
    }

    public void func_20091_b(ItemStack var1) {
        var1.func_28142_b(this.field_25004_e.field_9093_l, this.field_25004_e);
        if (var1.field_855_c == Block.field_9044_ay.field_573_bc) {
            this.field_25004_e.func_25046_a(AchievementList.field_25130_d, 1);
        } else if (var1.field_855_c == Item.field_4143_r.field_234_aS) {
            this.field_25004_e.func_25046_a(AchievementList.field_27110_i, 1);
        } else if (var1.field_855_c == Block.field_642_aC.field_573_bc) {
            this.field_25004_e.func_25046_a(AchievementList.field_27109_j, 1);
        } else if (var1.field_855_c == Item.field_4166_L.field_234_aS) {
            this.field_25004_e.func_25046_a(AchievementList.field_27107_l, 1);
        } else if (var1.field_855_c == Item.field_185_S.field_234_aS) {
            this.field_25004_e.func_25046_a(AchievementList.field_27106_m, 1);
        } else if (var1.field_855_c == Item.field_21098_aX.field_234_aS) {
            this.field_25004_e.func_25046_a(AchievementList.field_27105_n, 1);
        } else if (var1.field_855_c == Item.field_4139_v.field_234_aS) {
            this.field_25004_e.func_25046_a(AchievementList.field_27104_o, 1);
        } else if (var1.field_855_c == Item.field_4145_p.field_234_aS) {
            this.field_25004_e.func_25046_a(AchievementList.field_27101_r, 1);
        }

        for(int var2 = 0; var2 < this.field_20103_a.func_83_a(); ++var2) {
            ItemStack var3 = this.field_20103_a.func_82_a(var2);
            if (var3 != null) {
                this.field_20103_a.func_20069_a(var2, 1);
                if (var3.func_569_a().func_21088_g()) {
                    this.field_20103_a.func_206_a(var2, new ItemStack(var3.func_569_a().func_21087_f()));
                }
            }
        }

    }
}
