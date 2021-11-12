package net.minecraft.src;

public class ItemShears extends Item {
    public ItemShears(int var1) {
        super(var1);
        this.func_21009_c(1);
        this.func_21013_d(238);
    }

    public boolean func_25008_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        if (var2 == Block.field_384_L.field_376_bc || var2 == Block.field_9258_W.field_376_bc) {
            var1.func_25190_a(1, var6);
        }

        return super.func_25008_a(var1, var2, var3, var4, var5, var6);
    }

    public boolean func_4018_a(Block var1) {
        return var1.field_376_bc == Block.field_9258_W.field_376_bc;
    }

    public float func_204_a(ItemStack var1, Block var2) {
        if (var2.field_376_bc != Block.field_9258_W.field_376_bc && var2.field_376_bc != Block.field_384_L.field_376_bc) {
            return var2.field_376_bc == Block.field_419_ac.field_376_bc ? 5.0F : super.func_204_a(var1, var2);
        } else {
            return 15.0F;
        }
    }
}
