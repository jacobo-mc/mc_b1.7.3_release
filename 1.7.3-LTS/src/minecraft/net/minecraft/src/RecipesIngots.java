package net.minecraft.src;

public class RecipesIngots {
    private Object[][] recipeItems;

    public RecipesIngots() {
        this.recipeItems = new Object[][]{{Block.blockGold, new ItemStack(Item.ingotGold, 9)}, {Block.blockSteel, new ItemStack(Item.ingotIron, 9)}, {Block.blockDiamond, new ItemStack(Item.diamond, 9)}, {Block.blockLapis, new ItemStack(Item.dyePowder, 9, 4)}};
    }

    public void addRecipes(CraftingManager var1) {
        for(int var2 = 0; var2 < this.recipeItems.length; ++var2) {
            Block var3 = (Block)this.recipeItems[var2][0];
            ItemStack var4 = (ItemStack)this.recipeItems[var2][1];
            var1.addRecipe(new ItemStack(var3), "###", "###", "###", '#', var4);
            var1.addRecipe(var4, "#", '#', var3);
        }

    }
}
