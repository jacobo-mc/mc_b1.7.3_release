package net.minecraft.src;

import java.util.Comparator;

class RecipeSorter implements Comparator {
    // $FF: synthetic field
    final CraftingManager craftingManager;

    RecipeSorter(CraftingManager var1) {
        this.craftingManager = var1;
    }

    public int compareRecipes(IRecipe var1, IRecipe var2) {
        if (var1 instanceof ShapelessRecipes && var2 instanceof ShapedRecipes) {
            return 1;
        } else if (var2 instanceof ShapelessRecipes && var1 instanceof ShapedRecipes) {
            return -1;
        } else if (var2.getRecipeSize() < var1.getRecipeSize()) {
            return -1;
        } else {
            return var2.getRecipeSize() > var1.getRecipeSize() ? 1 : 0;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.compareRecipes((IRecipe)var1, (IRecipe)var2);
    }
}
