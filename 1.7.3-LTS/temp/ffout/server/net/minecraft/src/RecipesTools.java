package net.minecraft.src;

public class RecipesTools {
    private String[][] field_20158_a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] field_20157_b;

    public RecipesTools() {
        this.field_20157_b = new Object[][]{{Block.field_531_y, Block.field_532_x, Item.field_166_m, Item.field_167_l, Item.field_4147_n}, {Item.field_4143_r, Item.field_4139_v, Item.field_4152_e, Item.field_4135_z, Item.field_4168_G}, {Item.field_4144_q, Item.field_4140_u, Item.field_4153_d, Item.field_4136_y, Item.field_4169_F}, {Item.field_4142_s, Item.field_4138_w, Item.field_4151_f, Item.field_4175_A, Item.field_4167_H}, {Item.field_4166_L, Item.field_4165_M, Item.field_4164_N, Item.field_4163_O, Item.field_4162_P}};
    }

    public void func_20156_a(CraftingManager var1) {
        for(int var2 = 0; var2 < this.field_20157_b[0].length; ++var2) {
            Object var3 = this.field_20157_b[0][var2];

            for(int var4 = 0; var4 < this.field_20157_b.length - 1; ++var4) {
                Item var5 = (Item)this.field_20157_b[var4 + 1][var2];
                var1.func_20153_a(new ItemStack(var5), this.field_20158_a[var4], '#', Item.field_209_B, 'X', var3);
            }
        }

        var1.func_20153_a(new ItemStack(Item.field_31022_bc), " #", "# ", '#', Item.field_166_m);
    }
}
