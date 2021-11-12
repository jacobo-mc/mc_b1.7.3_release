package net.minecraft.src;

public class ShapedRecipes implements IRecipe {
    private int recipeWidth;
    private int recipeHeight;
    private ItemStack[] recipeItems;
    private ItemStack recipeOutput;
    public final int recipeOutputItemID;

    public ShapedRecipes(int var1, int var2, ItemStack[] var3, ItemStack var4) {
        this.recipeOutputItemID = var4.itemID;
        this.recipeWidth = var1;
        this.recipeHeight = var2;
        this.recipeItems = var3;
        this.recipeOutput = var4;
    }

    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    public boolean matches(InventoryCrafting var1) {
        for(int var2 = 0; var2 <= 3 - this.recipeWidth; ++var2) {
            for(int var3 = 0; var3 <= 3 - this.recipeHeight; ++var3) {
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
                if (var7 >= 0 && var8 >= 0 && var7 < this.recipeWidth && var8 < this.recipeHeight) {
                    if (var4) {
                        var9 = this.recipeItems[this.recipeWidth - var7 - 1 + var8 * this.recipeWidth];
                    } else {
                        var9 = this.recipeItems[var7 + var8 * this.recipeWidth];
                    }
                }

                ItemStack var10 = var1.getStackInRowAndColumn(var5, var6);
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

    public ItemStack getCraftingResult(InventoryCrafting var1) {
        return new ItemStack(this.recipeOutput.itemID, this.recipeOutput.stackSize, this.recipeOutput.getItemDamage());
    }

    public int getRecipeSize() {
        return this.recipeWidth * this.recipeHeight;
    }
}
