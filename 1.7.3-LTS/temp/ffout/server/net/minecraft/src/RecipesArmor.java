package net.minecraft.src;

public class RecipesArmor {
    private String[][] field_20174_a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] field_20173_b;

    public RecipesArmor() {
        this.field_20173_b = new Object[][]{{Item.field_249_aD, Block.field_599_as, Item.field_166_m, Item.field_167_l, Item.field_4147_n}, {Item.field_4161_T, Item.field_4157_X, Item.field_4188_ab, Item.field_4184_af, Item.field_4180_aj}, {Item.field_4160_U, Item.field_4156_Y, Item.field_4187_ac, Item.field_4183_ag, Item.field_4179_ak}, {Item.field_4159_V, Item.field_4155_Z, Item.field_4186_ad, Item.field_4182_ah, Item.field_4178_al}, {Item.field_4158_W, Item.field_4189_aa, Item.field_4185_ae, Item.field_4181_ai, Item.field_4177_am}};
    }

    public void func_20172_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_20173_b[0].length; ++var2) {
            Object var3 = this.field_20173_b[0][var2];

            for(int var4 = 0; var4 < this.field_20173_b.length - 1; ++var4) {
                Item var5 = (Item)this.field_20173_b[var4 + 1][var2];
                var1.func_20153_a(new ItemStack(var5), this.field_20174_a[var4], 'X', var3);
            }
        }

    }
}
