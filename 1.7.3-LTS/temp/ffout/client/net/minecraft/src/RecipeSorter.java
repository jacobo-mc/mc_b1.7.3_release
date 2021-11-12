package net.minecraft.src;

import java.util.Comparator;

class RecipeSorter implements Comparator {
    // $FF: synthetic field
    final CraftingManager field_1557_a;

    RecipeSorter(CraftingManager var1) {
        this.field_1557_a = var1;
    }

    public int func_1040_a(IRecipe var1, IRecipe var2) {
        if (var1 instanceof ShapelessRecipes && var2 instanceof ShapedRecipes) {
            return 1;
        } else if (var2 instanceof ShapelessRecipes && var1 instanceof ShapedRecipes) {
            return -1;
        } else if (var2.func_1184_a() < var1.func_1184_a()) {
            return -1;
        } else {
            return var2.func_1184_a() > var1.func_1184_a() ? 1 : 0;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compare(Object var1, Object var2) {
        return this.func_1040_a((IRecipe)var1, (IRecipe)var2);
    }
}
