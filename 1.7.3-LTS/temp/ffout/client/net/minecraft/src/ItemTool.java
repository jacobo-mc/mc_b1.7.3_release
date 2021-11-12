package net.minecraft.src;

public class ItemTool extends Item {
    private Block[] field_325_aX;
    private float field_324_aY = 4.0F;
    private int field_323_aZ;
    protected EnumToolMaterial field_20927_a;

    protected ItemTool(int var1, int var2, EnumToolMaterial var3, Block[] var4) {
        super(var1);
        this.field_20927_a = var3;
        this.field_325_aX = var4;
        this.field_290_aT = 1;
        this.func_21013_d(var3.func_21207_a());
        this.field_324_aY = var3.func_21206_b();
        this.field_323_aZ = var2 + var3.func_21205_c();
    }

    public float func_204_a(ItemStack var1, Block var2) {
        for(int var3 = 0; var3 < this.field_325_aX.length; ++var3) {
            if (this.field_325_aX[var3] == var2) {
                return this.field_324_aY;
            }
        }

        return 1.0F;
    }

    public boolean func_4021_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        var1.func_25190_a(2, var3);
        return true;
    }

    public boolean func_25008_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        var1.func_25190_a(1, var6);
        return true;
    }

    public int func_4020_a(Entity var1) {
        return this.field_323_aZ;
    }

    public boolean func_4017_a() {
        return true;
    }
}
