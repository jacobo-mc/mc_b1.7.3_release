package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CraftingManager {
    private static final CraftingManager field_20155_a = new CraftingManager();
    private List field_20154_b = new ArrayList();

    public static final CraftingManager func_20151_a() {
        return field_20155_a;
    }

    private CraftingManager() {
        (new RecipesTools()).func_20156_a(this);
        (new RecipesWeapons()).func_20112_a(this);
        (new RecipesIngots()).func_20159_a(this);
        (new RecipesFood()).func_20177_a(this);
        (new RecipesCrafting()).func_20115_a(this);
        (new RecipesArmor()).func_20172_a(this);
        (new RecipesDyes()).func_21165_a(this);
        this.func_20153_a(new ItemStack(Item.field_4201_aI, 3), "###", '#', Item.field_4202_aH);
        this.func_20153_a(new ItemStack(Item.field_4200_aJ, 1), "#", "#", "#", '#', Item.field_4201_aI);
        this.func_20153_a(new ItemStack(Block.field_9050_aZ, 2), "###", "###", '#', Item.field_209_B);
        this.func_20153_a(new ItemStack(Block.field_619_aZ, 1), "###", "#X#", "###", '#', Block.field_531_y, 'X', Item.field_167_l);
        this.func_20153_a(new ItemStack(Block.field_9038_R, 1), "###", "#X#", "###", '#', Block.field_531_y, 'X', Item.field_252_aA);
        this.func_20153_a(new ItemStack(Block.field_604_ao, 1), "###", "XXX", "###", '#', Block.field_531_y, 'X', Item.field_4200_aJ);
        this.func_20153_a(new ItemStack(Block.field_4076_aV, 1), "##", "##", '#', Item.field_251_aB);
        this.func_20153_a(new ItemStack(Block.field_621_aX, 1), "##", "##", '#', Item.field_246_aG);
        this.func_20153_a(new ItemStack(Block.field_9047_al, 1), "##", "##", '#', Item.field_4203_aF);
        this.func_20153_a(new ItemStack(Block.field_6065_bd, 1), "##", "##", '#', Item.field_4194_aR);
        this.func_20153_a(new ItemStack(Block.field_616_ac, 1), "##", "##", '#', Item.field_196_I);
        this.func_20153_a(new ItemStack(Block.field_605_an, 1), "X#X", "#X#", "X#X", 'X', Item.field_193_K, '#', Block.field_590_F);
        this.func_20153_a(new ItemStack(Block.field_607_al, 3, 3), "###", '#', Block.field_532_x);
        this.func_20153_a(new ItemStack(Block.field_607_al, 3, 0), "###", '#', Block.field_535_u);
        this.func_20153_a(new ItemStack(Block.field_607_al, 3, 1), "###", '#', Block.field_9039_Q);
        this.func_20153_a(new ItemStack(Block.field_607_al, 3, 2), "###", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Block.field_638_aG, 2), "# #", "###", "# #", '#', Item.field_209_B);
        this.func_20153_a(new ItemStack(Item.field_208_at, 1), "##", "##", "##", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Block.field_28030_bl, 2), "###", "###", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Item.field_195_az, 1), "##", "##", "##", '#', Item.field_166_m);
        this.func_20153_a(new ItemStack(Item.field_4174_as, 1), "###", "###", " X ", '#', Block.field_531_y, 'X', Item.field_209_B);
        this.func_20153_a(new ItemStack(Item.field_21098_aX, 1), "AAA", "BEB", "CCC", 'A', Item.field_4204_aE, 'B', Item.field_21095_aW, 'C', Item.field_186_R, 'E', Item.field_239_aN);
        this.func_20153_a(new ItemStack(Item.field_21095_aW, 1), "#", '#', Item.field_4202_aH);
        this.func_20153_a(new ItemStack(Block.field_531_y, 4), "#", '#', Block.field_582_K);
        this.func_20153_a(new ItemStack(Item.field_209_B, 4), "#", "#", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Block.field_9046_aq, 4), "X", "#", 'X', Item.field_168_k, '#', Item.field_209_B);
        this.func_20153_a(new ItemStack(Block.field_9046_aq, 4), "X", "#", 'X', new ItemStack(Item.field_168_k, 1, 1), '#', Item.field_209_B);
        this.func_20153_a(new ItemStack(Item.field_4173_C, 4), "# #", " # ", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Block.field_637_aH, 16), "X X", "X#X", "X X", 'X', Item.field_166_m, '#', Item.field_209_B);
        this.func_20153_a(new ItemStack(Block.field_9036_T, 6), "X X", "X#X", "XRX", 'X', Item.field_4147_n, 'R', Item.field_252_aA, '#', Item.field_209_B);
        this.func_20153_a(new ItemStack(Block.field_9034_U, 6), "X X", "X#X", "XRX", 'X', Item.field_166_m, 'R', Item.field_252_aA, '#', Block.field_9053_aK);
        this.func_20153_a(new ItemStack(Item.field_199_ax, 1), "# #", "###", '#', Item.field_166_m);
        this.func_20153_a(new ItemStack(Block.field_9035_bf, 1), "A", "B", 'A', Block.field_4052_bb, 'B', Block.field_9046_aq);
        this.func_20153_a(new ItemStack(Item.field_4199_aL, 1), "A", "B", 'A', Block.field_593_av, 'B', Item.field_199_ax);
        this.func_20153_a(new ItemStack(Item.field_4198_aM, 1), "A", "B", 'A', Block.field_642_aC, 'B', Item.field_199_ax);
        this.func_20153_a(new ItemStack(Item.field_4205_aC, 1), "# #", "###", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Item.field_205_au, 1), "# #", " # ", '#', Item.field_166_m);
        this.func_20153_a(new ItemStack(Item.field_4150_g, 1), "A ", " B", 'A', Item.field_166_m, 'B', Item.field_216_an);
        this.func_20153_a(new ItemStack(Item.field_185_S, 1), "###", '#', Item.field_186_R);
        this.func_20153_a(new ItemStack(Block.field_9045_at, 4), "#  ", "## ", "###", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Item.field_4196_aP, 1), "  #", " #X", "# X", '#', Item.field_209_B, 'X', Item.field_196_I);
        this.func_20153_a(new ItemStack(Block.field_9055_aH, 4), "#  ", "## ", "###", '#', Block.field_532_x);
        this.func_20153_a(new ItemStack(Item.field_213_aq, 1), "###", "#X#", "###", '#', Item.field_209_B, 'X', Block.field_616_ac);
        this.func_20153_a(new ItemStack(Item.field_212_ar, 1), "###", "#X#", "###", '#', Block.field_4068_ai, 'X', Item.field_171_h);
        this.func_20153_a(new ItemStack(Block.field_9054_aJ, 1), "X", "#", '#', Block.field_532_x, 'X', Item.field_209_B);
        this.func_20153_a(new ItemStack(Block.field_627_aR, 1), "X", "#", '#', Item.field_209_B, 'X', Item.field_252_aA);
        this.func_20153_a(new ItemStack(Item.field_22007_aZ, 1), "#X#", "III", '#', Block.field_627_aR, 'X', Item.field_252_aA, 'I', Block.field_535_u);
        this.func_20153_a(new ItemStack(Item.field_4195_aQ, 1), " # ", "#X#", " # ", '#', Item.field_4147_n, 'X', Item.field_252_aA);
        this.func_20153_a(new ItemStack(Item.field_4197_aO, 1), " # ", "#X#", " # ", '#', Item.field_166_m, 'X', Item.field_252_aA);
        this.func_20153_a(new ItemStack(Item.field_28021_bb, 1), "###", "#X#", "###", '#', Item.field_4201_aI, 'X', Item.field_4197_aO);
        this.func_20153_a(new ItemStack(Block.field_9051_aR, 1), "#", "#", '#', Block.field_535_u);
        this.func_20153_a(new ItemStack(Block.field_9053_aK, 1), "##", '#', Block.field_535_u);
        this.func_20153_a(new ItemStack(Block.field_9052_aM, 1), "##", '#', Block.field_531_y);
        this.func_20153_a(new ItemStack(Block.field_9040_P, 1), "###", "#X#", "#R#", '#', Block.field_532_x, 'X', Item.field_4149_i, 'R', Item.field_252_aA);
        this.func_20153_a(new ItemStack(Block.field_9029_Z, 1), "TTT", "#X#", "#R#", '#', Block.field_532_x, 'X', Item.field_166_m, 'R', Item.field_252_aA, 'T', Block.field_531_y);
        this.func_20153_a(new ItemStack(Block.field_9033_V, 1), "S", "P", 'S', Item.field_242_aK, 'P', Block.field_9029_Z);
        this.func_20153_a(new ItemStack(Item.field_22008_aY, 1), "###", "XXX", '#', Block.field_616_ac, 'X', Block.field_531_y);
        Collections.sort(this.field_20154_b, new RecipeSorter(this));
        System.out.println(this.field_20154_b.size() + " recipes");
    }

    void func_20153_a(ItemStack var1, Object... var2) {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        if (var2[var4] instanceof String[]) {
            String[] var11 = (String[])((String[])var2[var4++]);

            for(int var8 = 0; var8 < var11.length; ++var8) {
                String var9 = var11[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        } else {
            while(var2[var4] instanceof String) {
                String var7 = (String)var2[var4++];
                ++var6;
                var5 = var7.length();
                var3 = var3 + var7;
            }
        }

        HashMap var12;
        for(var12 = new HashMap(); var4 < var2.length; var4 += 2) {
            Character var13 = (Character)var2[var4];
            ItemStack var15 = null;
            if (var2[var4 + 1] instanceof Item) {
                var15 = new ItemStack((Item)var2[var4 + 1]);
            } else if (var2[var4 + 1] instanceof Block) {
                var15 = new ItemStack((Block)var2[var4 + 1], 1, -1);
            } else if (var2[var4 + 1] instanceof ItemStack) {
                var15 = (ItemStack)var2[var4 + 1];
            }

            var12.put(var13, var15);
        }

        ItemStack[] var14 = new ItemStack[var5 * var6];

        for(int var16 = 0; var16 < var5 * var6; ++var16) {
            char var10 = var3.charAt(var16);
            if (var12.containsKey(var10)) {
                var14[var16] = ((ItemStack)var12.get(var10)).func_578_d();
            } else {
                var14[var16] = null;
            }
        }

        this.field_20154_b.add(new ShapedRecipes(var5, var6, var14, var1));
    }

    void func_21146_b(ItemStack var1, Object... var2) {
        ArrayList var3 = new ArrayList();
        Object[] var4 = var2;
        int var5 = var2.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            if (var7 instanceof ItemStack) {
                var3.add(((ItemStack)var7).func_578_d());
            } else if (var7 instanceof Item) {
                var3.add(new ItemStack((Item)var7));
            } else {
                if (!(var7 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.field_20154_b.add(new ShapelessRecipes(var1, var3));
    }

    public ItemStack func_21147_a(InventoryCrafting var1) {
        for(int var2 = 0; var2 < this.field_20154_b.size(); ++var2) {
            IRecipe var3 = (IRecipe)this.field_20154_b.get(var2);
            if (var3.func_21134_a(var1)) {
                return var3.func_21136_b(var1);
            }
        }

        return null;
    }

    public List func_25126_b() {
        return this.field_20154_b;
    }
}
