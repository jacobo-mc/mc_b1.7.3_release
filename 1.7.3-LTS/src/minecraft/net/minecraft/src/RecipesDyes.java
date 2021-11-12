package net.minecraft.src;

public class RecipesDyes {
    public void addRecipes(CraftingManager var1) {
        for(int var2 = 0; var2 < 16; ++var2) {
            var1.addShapelessRecipe(new ItemStack(Block.cloth, 1, BlockCloth.getDyeFromBlock(var2)), new ItemStack(Item.dyePowder, 1, var2), new ItemStack(Item.itemsList[Block.cloth.blockID], 1, 0));
        }

        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 11), Block.plantYellow);
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 1), Block.plantRed);
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 3, 15), Item.bone);
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 9), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 15));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 14), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 11));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 10), new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Item.dyePowder, 1, 15));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 8), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 15));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 7), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Item.dyePowder, 1, 15));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 3, 7), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Item.dyePowder, 1, 15));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 12), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 15));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 6), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 2));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 5), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 1));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 13), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Item.dyePowder, 1, 9));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 3, 13), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 9));
        var1.addShapelessRecipe(new ItemStack(Item.dyePowder, 4, 13), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 15));
    }
}
