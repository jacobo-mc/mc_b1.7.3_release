package net.minecraft.src;

public class RecipesCrafting {
    public void addRecipes(CraftingManager var1) {
        var1.addRecipe(new ItemStack(Block.chest), "###", "# #", "###", '#', Block.planks);
        var1.addRecipe(new ItemStack(Block.stoneOvenIdle), "###", "# #", "###", '#', Block.cobblestone);
        var1.addRecipe(new ItemStack(Block.workbench), "##", "##", '#', Block.planks);
        var1.addRecipe(new ItemStack(Block.sandStone), "##", "##", '#', Block.sand);
    }
}
