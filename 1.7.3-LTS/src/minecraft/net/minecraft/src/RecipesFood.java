package net.minecraft.src;

public class RecipesFood {
    public void addRecipes(CraftingManager var1) {
        var1.addRecipe(new ItemStack(Item.bowlSoup), "Y", "X", "#", 'X', Block.mushroomBrown, 'Y', Block.mushroomRed, '#', Item.bowlEmpty);
        var1.addRecipe(new ItemStack(Item.bowlSoup), "Y", "X", "#", 'X', Block.mushroomRed, 'Y', Block.mushroomBrown, '#', Item.bowlEmpty);
        var1.addRecipe(new ItemStack(Item.cookie, 8), "#X#", 'X', new ItemStack(Item.dyePowder, 1, 3), '#', Item.wheat);
    }
}
