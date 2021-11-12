package net.minecraft.src;

public class RecipesWeapons {
    private String[][] field_20114_a = new String[][]{{"X", "X", "#"}};
    private Object[][] field_20113_b;

    public RecipesWeapons() {
        this.field_20113_b = new Object[][]{{Block.field_531_y, Block.field_532_x, Item.field_166_m, Item.field_167_l, Item.field_4147_n}, {Item.field_4145_p, Item.field_4141_t, Item.field_4146_o, Item.field_4137_x, Item.field_4171_E}};
    }

    public void func_20112_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_20113_b[0].length; ++var2) {
            Object var3 = this.field_20113_b[0][var2];

            for(int var4 = 0; var4 < this.field_20113_b.length - 1; ++var4) {
                Item var5 = (Item)this.field_20113_b[var4 + 1][var2];
                var1.func_20153_a(new ItemStack(var5), this.field_20114_a[var4], '#', Item.field_209_B, 'X', var3);
            }
        }

        var1.func_20153_a(new ItemStack(Item.field_4149_i, 1), " #X", "# X", " #X", 'X', Item.field_196_I, '#', Item.field_209_B);
        var1.func_20153_a(new ItemStack(Item.field_4148_j, 4), "X", "#", "Y", 'Y', Item.field_194_J, 'X', Item.field_216_an, '#', Item.field_209_B);
    }
}
