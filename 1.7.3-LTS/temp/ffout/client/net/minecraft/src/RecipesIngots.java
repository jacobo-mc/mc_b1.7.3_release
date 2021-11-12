package net.minecraft.src;

public class RecipesIngots {
    private Object[][] field_1198_a;

    public RecipesIngots() {
        this.field_1198_a = new Object[][]{{Block.field_413_ai, new ItemStack(Item.field_222_n, 9)}, {Block.field_412_aj, new ItemStack(Item.field_223_m, 9)}, {Block.field_389_ay, new ItemStack(Item.field_224_l, 9)}, {Block.field_9266_O, new ItemStack(Item.field_21021_aU, 9, 4)}};
    }

    public void func_810_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_1198_a.length; ++var2) {
            Block var3 = (Block)this.field_1198_a[var2][0];
            ItemStack var4 = (ItemStack)this.field_1198_a[var2][1];
            var1.func_1121_a(new ItemStack(var3), "###", "###", "###", '#', var4);
            var1.func_1121_a(var4, "#", '#', var3);
        }

    }
}
