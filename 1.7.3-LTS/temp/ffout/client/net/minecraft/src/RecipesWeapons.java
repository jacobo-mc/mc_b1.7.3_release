package net.minecraft.src;

public class RecipesWeapons {
    private String[][] field_1100_a = new String[][]{{"X", "X", "#"}};
    private Object[][] field_1099_b;

    public RecipesWeapons() {
        this.field_1099_b = new Object[][]{{Block.field_334_y, Block.field_335_x, Item.field_223_m, Item.field_224_l, Item.field_222_n}, {Item.field_220_p, Item.field_216_t, Item.field_221_o, Item.field_212_x, Item.field_261_E}};
    }

    public void func_766_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_1099_b[0].length; ++var2) {
            Object var3 = this.field_1099_b[0][var2];

            for(int var4 = 0; var4 < this.field_1099_b.length - 1; ++var4) {
                Item var5 = (Item)this.field_1099_b[var4 + 1][var2];
                var1.func_1121_a(new ItemStack(var5), this.field_1100_a[var4], '#', Item.field_266_B, 'X', var3);
            }
        }

        var1.func_1121_a(new ItemStack(Item.field_227_i, 1), " #X", "# X", " #X", 'X', Item.field_253_I, '#', Item.field_266_B);
        var1.func_1121_a(new ItemStack(Item.field_226_j, 4), "X", "#", "Y", 'Y', Item.field_251_J, 'X', Item.field_273_an, '#', Item.field_266_B);
    }
}
