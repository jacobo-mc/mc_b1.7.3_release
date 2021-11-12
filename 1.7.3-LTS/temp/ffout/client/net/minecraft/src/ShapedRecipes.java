package net.minecraft.src;

public class ShapedRecipes implements IRecipe {
    private int field_21138_b;
    private int field_21142_c;
    private ItemStack[] field_21141_d;
    private ItemStack field_21140_e;
    public final int field_21139_a;

    public ShapedRecipes(int var1, int var2, ItemStack[] var3, ItemStack var4) {
        this.field_21139_a = var4.field_1617_c;
        this.field_21138_b = var1;
        this.field_21142_c = var2;
        this.field_21141_d = var3;
        this.field_21140_e = var4;
    }

    public ItemStack func_25117_b() {
        return this.field_21140_e;
    }

    public boolean func_21135_a(InventoryCrafting var1) {
        for(int var2 = 0; var2 <= 3 - this.field_21138_b; ++var2) {
            for(int var3 = 0; var3 <= 3 - this.field_21142_c; ++var3) {
                if (this.func_21137_a(var1, var2, var3, true)) {
                    return true;
                }

                if (this.func_21137_a(var1, var2, var3, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_21137_a(InventoryCrafting var1, int var2, int var3, boolean var4) {
        for(int var5 = 0; var5 < 3; ++var5) {
            for(int var6 = 0; var6 < 3; ++var6) {
                int var7 = var5 - var2;
                int var8 = var6 - var3;
                ItemStack var9 = null;
                if (var7 >= 0 && var8 >= 0 && var7 < this.field_21138_b && var8 < this.field_21142_c) {
                    if (var4) {
                        var9 = this.field_21141_d[this.field_21138_b - var7 - 1 + var8 * this.field_21138_b];
                    } else {
                        var9 = this.field_21141_d[var7 + var8 * this.field_21138_b];
                    }
                }

                ItemStack var10 = var1.func_21103_b(var5, var6);
                if (var10 != null || var9 != null) {
                    if (var10 == null && var9 != null || var10 != null && var9 == null) {
                        return false;
                    }

                    if (var9.field_1617_c != var10.field_1617_c) {
                        return false;
                    }

                    if (var9.func_21181_i() != -1 && var9.func_21181_i() != var10.func_21181_i()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public ItemStack func_21136_b(InventoryCrafting var1) {
        return new ItemStack(this.field_21140_e.field_1617_c, this.field_21140_e.field_1615_a, this.field_21140_e.func_21181_i());
    }

    public int func_1184_a() {
        return this.field_21138_b * this.field_21142_c;
    }
}
