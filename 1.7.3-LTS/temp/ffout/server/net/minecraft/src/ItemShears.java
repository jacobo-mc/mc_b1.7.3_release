package net.minecraft.src;

public class ItemShears extends Item {
    public ItemShears(int var1) {
        super(var1);
        this.func_21086_c(1);
        this.func_21090_d(238);
    }

    public boolean func_25007_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        if (var2 == Block.field_581_L.field_573_bc || var2 == Block.field_9032_W.field_573_bc) {
            var1.func_25125_a(1, var6);
        }

        return super.func_25007_a(var1, var2, var3, var4, var5, var6);
    }

    public boolean func_80_a(Block var1) {
        return var1.field_573_bc == Block.field_9032_W.field_573_bc;
    }

    public float func_79_a(ItemStack var1, Block var2) {
        if (var2.field_573_bc != Block.field_9032_W.field_573_bc && var2.field_573_bc != Block.field_581_L.field_573_bc) {
            return var2.field_573_bc == Block.field_616_ac.field_573_bc ? 5.0F : super.func_79_a(var1, var2);
        } else {
            return 15.0F;
        }
    }
}
