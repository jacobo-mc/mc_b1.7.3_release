package net.minecraft.src;

public class ShapedRecipes implements IRecipe {
    private int field_21140_b;
    private int field_21144_c;
    private ItemStack[] field_21143_d;
    private ItemStack field_21142_e;
    public final int field_21141_a;

    public ShapedRecipes(int var1, int var2, ItemStack[] var3, ItemStack var4) {
        this.field_21141_a = var4.itemID;
        this.field_21140_b = var1;
        this.field_21144_c = var2;
        this.field_21143_d = var3;
        this.field_21142_e = var4;
    }

    public ItemStack func_25077_b() {
        return this.field_21142_e;
    }

    public boolean func_21134_a(InventoryCrafting var1) {
        for(int var2 = 0; var2 <= 3 - this.field_21140_b; ++var2) {
            for(int var3 = 0; var3 <= 3 - this.field_21144_c; ++var3) {
                if (this.func_21139_a(var1, var2, var3, true)) {
                    return true;
                }

                if (this.func_21139_a(var1, var2, var3, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_21139_a(InventoryCrafting var1, int var2, int var3, boolean var4) {
        for(int var5 = 0; var5 < 3; ++var5) {
            for(int var6 = 0; var6 < 3; ++var6) {
                int var7 = var5 - var2;
                int var8 = var6 - var3;
                ItemStack var9 = null;
                if (var7 >= 0 && var8 >= 0 && var7 < this.field_21140_b && var8 < this.field_21144_c) {
                    if (var4) {
                        var9 = this.field_21143_d[this.field_21140_b - var7 - 1 + var8 * this.field_21140_b];
                    } else {
                        var9 = this.field_21143_d[var7 + var8 * this.field_21140_b];
                    }
                }

                ItemStack var10 = var1.func_21084_a(var5, var6);
                if (var10 != null || var9 != null) {
                    if (var10 == null && var9 != null || var10 != null && var9 == null) {
                        return false;
                    }

                    if (var9.itemID != var10.itemID) {
                        return false;
                    }

                    if (var9.getItemDamage() != -1 && var9.getItemDamage() != var10.getItemDamage()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public ItemStack func_21136_b(InventoryCrafting var1) {
        return new ItemStack(this.field_21142_e.itemID, this.field_21142_e.stackSize, this.field_21142_e.getItemDamage());
    }

    public int getRecipeSize() {
        return this.field_21140_b * this.field_21144_c;
    }
}
