package net.minecraft.src;

public class RecipesIngots {
    private Object[][] field_20160_a;

    public RecipesIngots() {
        this.field_20160_a = new Object[][]{{Block.field_4068_ai, new ItemStack(Item.field_4147_n, 9)}, {Block.field_4067_aj, new ItemStack(Item.field_166_m, 9)}, {Block.field_4060_ay, new ItemStack(Item.field_167_l, 9)}, {Block.field_9041_O, new ItemStack(Item.field_21097_aU, 9, 4)}};
    }

    public void func_20159_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_20160_a.length; ++var2) {
            Block var3 = (Block)this.field_20160_a[var2][0];
            ItemStack var4 = (ItemStack)this.field_20160_a[var2][1];
            var1.func_20153_a(new ItemStack(var3), "###", "###", "###", '#', var4);
            var1.func_20153_a(var4, "#", '#', var3);
        }

    }
}
