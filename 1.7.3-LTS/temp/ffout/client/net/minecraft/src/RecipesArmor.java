package net.minecraft.src;

public class RecipesArmor {
    private String[][] field_1681_a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] field_1680_b;

    public RecipesArmor() {
        this.field_1680_b = new Object[][]{{Item.field_306_aD, Block.field_402_as, Item.field_223_m, Item.field_224_l, Item.field_222_n}, {Item.field_241_T, Item.field_237_X, Item.field_285_ab, Item.field_281_af, Item.field_277_aj}, {Item.field_240_U, Item.field_236_Y, Item.field_284_ac, Item.field_280_ag, Item.field_276_ak}, {Item.field_239_V, Item.field_235_Z, Item.field_283_ad, Item.field_279_ah, Item.field_275_al}, {Item.field_238_W, Item.field_286_aa, Item.field_282_ae, Item.field_278_ai, Item.field_274_am}};
    }

    public void func_1148_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_1680_b[0].length; ++var2) {
            Object var3 = this.field_1680_b[0][var2];

            for(int var4 = 0; var4 < this.field_1680_b.length - 1; ++var4) {
                Item var5 = (Item)this.field_1680_b[var4 + 1][var2];
                var1.func_1121_a(new ItemStack(var5), this.field_1681_a[var4], 'X', var3);
            }
        }

    }
}
