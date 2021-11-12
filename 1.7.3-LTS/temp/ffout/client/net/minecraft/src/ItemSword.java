package net.minecraft.src;

public class ItemSword extends Item {
    private int field_319_a;

    public ItemSword(int var1, EnumToolMaterial var2) {
        super(var1);
        this.field_290_aT = 1;
        this.func_21013_d(var2.func_21207_a());
        this.field_319_a = 4 + var2.func_21205_c() * 2;
    }

    public float func_204_a(ItemStack var1, Block var2) {
        return var2.field_376_bc == Block.field_9258_W.field_376_bc ? 15.0F : 1.5F;
    }

    public boolean func_4021_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        var1.func_25190_a(1, var3);
        return true;
    }

    public boolean func_25008_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        var1.func_25190_a(2, var6);
        return true;
    }

    public int func_4020_a(Entity var1) {
        return this.field_319_a;
    }

    public boolean func_4017_a() {
        return true;
    }

    public boolean func_4018_a(Block var1) {
        return var1.field_376_bc == Block.field_9258_W.field_376_bc;
    }
}
