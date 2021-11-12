package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CraftingManager {
    private static final CraftingManager field_6541_a = new CraftingManager();
    private List field_1662_b = new ArrayList();

    public static final CraftingManager func_1120_a() {
        return field_6541_a;
    }

    private CraftingManager() {
        (new RecipesTools()).func_1122_a(this);
        (new RecipesWeapons()).func_766_a(this);
        (new RecipesIngots()).func_810_a(this);
        (new RecipesFood()).func_976_a(this);
        (new RecipesCrafting()).func_1051_a(this);
        (new RecipesArmor()).func_1148_a(this);
        (new RecipesDyes()).func_21157_a(this);
        this.func_1121_a(new ItemStack(Item.field_4029_aI, 3), "###", '#', Item.field_302_aH);
        this.func_1121_a(new ItemStack(Item.field_4028_aJ, 1), "#", "#", "#", '#', Item.field_4029_aI);
        this.func_1121_a(new ItemStack(Block.field_4057_ba, 2), "###", "###", '#', Item.field_266_B);
        this.func_1121_a(new ItemStack(Block.field_422_aZ, 1), "###", "#X#", "###", '#', Block.field_334_y, 'X', Item.field_224_l);
        this.func_1121_a(new ItemStack(Block.field_9263_R, 1), "###", "#X#", "###", '#', Block.field_334_y, 'X', Item.field_309_aA);
        this.func_1121_a(new ItemStack(Block.field_407_ao, 1), "###", "XXX", "###", '#', Block.field_334_y, 'X', Item.field_4028_aJ);
        this.func_1121_a(new ItemStack(Block.field_426_aV, 1), "##", "##", '#', Item.field_308_aB);
        this.func_1121_a(new ItemStack(Block.field_424_aX, 1), "##", "##", '#', Item.field_303_aG);
        this.func_1121_a(new ItemStack(Block.field_409_am, 1), "##", "##", '#', Item.field_4030_aF);
        this.func_1121_a(new ItemStack(Block.field_4049_be, 1), "##", "##", '#', Item.field_4022_aR);
        this.func_1121_a(new ItemStack(Block.field_419_ac, 1), "##", "##", '#', Item.field_253_I);
        this.func_1121_a(new ItemStack(Block.field_408_an, 1), "X#X", "#X#", "X#X", 'X', Item.field_250_K, '#', Block.field_393_F);
        this.func_1121_a(new ItemStack(Block.field_410_al, 3, 3), "###", '#', Block.field_335_x);
        this.func_1121_a(new ItemStack(Block.field_410_al, 3, 0), "###", '#', Block.field_338_u);
        this.func_1121_a(new ItemStack(Block.field_410_al, 3, 1), "###", '#', Block.field_9264_Q);
        this.func_1121_a(new ItemStack(Block.field_410_al, 3, 2), "###", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Block.field_441_aG, 2), "# #", "###", "# #", '#', Item.field_266_B);
        this.func_1121_a(new ItemStack(Item.field_265_at, 1), "##", "##", "##", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Block.field_28033_bl, 2), "###", "###", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Item.field_252_az, 1), "##", "##", "##", '#', Item.field_223_m);
        this.func_1121_a(new ItemStack(Item.field_267_as, 1), "###", "###", " X ", '#', Block.field_334_y, 'X', Item.field_266_B);
        this.func_1121_a(new ItemStack(Item.field_21022_aX, 1), "AAA", "BEB", "CCC", 'A', Item.field_305_aE, 'B', Item.field_21019_aW, 'C', Item.field_243_R, 'E', Item.field_296_aN);
        this.func_1121_a(new ItemStack(Item.field_21019_aW, 1), "#", '#', Item.field_302_aH);
        this.func_1121_a(new ItemStack(Block.field_334_y, 4), "#", '#', Block.field_385_K);
        this.func_1121_a(new ItemStack(Item.field_266_B, 4), "#", "#", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Block.field_404_ar, 4), "X", "#", 'X', Item.field_225_k, '#', Item.field_266_B);
        this.func_1121_a(new ItemStack(Block.field_404_ar, 4), "X", "#", 'X', new ItemStack(Item.field_225_k, 1, 1), '#', Item.field_266_B);
        this.func_1121_a(new ItemStack(Item.field_264_C, 4), "# #", " # ", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Block.field_440_aH, 16), "X X", "X#X", "X X", 'X', Item.field_223_m, '#', Item.field_266_B);
        this.func_1121_a(new ItemStack(Block.field_9261_T, 6), "X X", "X#X", "XRX", 'X', Item.field_222_n, 'R', Item.field_309_aA, '#', Item.field_266_B);
        this.func_1121_a(new ItemStack(Block.field_9260_U, 6), "X X", "X#X", "XRX", 'X', Item.field_223_m, 'R', Item.field_309_aA, '#', Block.field_4066_aL);
        this.func_1121_a(new ItemStack(Item.field_256_ax, 1), "# #", "###", '#', Item.field_223_m);
        this.func_1121_a(new ItemStack(Block.field_4045_bg, 1), "A", "B", 'A', Block.field_4055_bb, 'B', Block.field_404_ar);
        this.func_1121_a(new ItemStack(Item.field_4027_aL, 1), "A", "B", 'A', Block.field_396_av, 'B', Item.field_256_ax);
        this.func_1121_a(new ItemStack(Item.field_4026_aM, 1), "A", "B", 'A', Block.field_445_aC, 'B', Item.field_256_ax);
        this.func_1121_a(new ItemStack(Item.field_4031_aC, 1), "# #", "###", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Item.field_262_au, 1), "# #", " # ", '#', Item.field_223_m);
        this.func_1121_a(new ItemStack(Item.field_4014_g, 1), "A ", " B", 'A', Item.field_223_m, 'B', Item.field_273_an);
        this.func_1121_a(new ItemStack(Item.field_242_S, 1), "###", '#', Item.field_243_R);
        this.func_1121_a(new ItemStack(Block.field_4059_au, 4), "#  ", "## ", "###", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Item.field_4024_aP, 1), "  #", " #X", "# X", '#', Item.field_266_B, 'X', Item.field_253_I);
        this.func_1121_a(new ItemStack(Block.field_4069_aI, 4), "#  ", "## ", "###", '#', Block.field_335_x);
        this.func_1121_a(new ItemStack(Item.field_270_aq, 1), "###", "#X#", "###", '#', Item.field_266_B, 'X', Block.field_419_ac);
        this.func_1121_a(new ItemStack(Item.field_269_ar, 1), "###", "#X#", "###", '#', Block.field_413_ai, 'X', Item.field_228_h);
        this.func_1121_a(new ItemStack(Block.field_4067_aK, 1), "X", "#", '#', Block.field_335_x, 'X', Item.field_266_B);
        this.func_1121_a(new ItemStack(Block.field_430_aR, 1), "X", "#", '#', Item.field_266_B, 'X', Item.field_309_aA);
        this.func_1121_a(new ItemStack(Item.field_22018_aZ, 1), "#X#", "III", '#', Block.field_430_aR, 'X', Item.field_309_aA, 'I', Block.field_338_u);
        this.func_1121_a(new ItemStack(Item.field_4023_aQ, 1), " # ", "#X#", " # ", '#', Item.field_222_n, 'X', Item.field_309_aA);
        this.func_1121_a(new ItemStack(Item.field_4025_aO, 1), " # ", "#X#", " # ", '#', Item.field_223_m, 'X', Item.field_309_aA);
        this.func_1121_a(new ItemStack(Item.field_28010_bb, 1), "###", "#X#", "###", '#', Item.field_4029_aI, 'X', Item.field_4025_aO);
        this.func_1121_a(new ItemStack(Block.field_4064_aS, 1), "#", "#", '#', Block.field_338_u);
        this.func_1121_a(new ItemStack(Block.field_4066_aL, 1), "##", '#', Block.field_338_u);
        this.func_1121_a(new ItemStack(Block.field_4065_aN, 1), "##", '#', Block.field_334_y);
        this.func_1121_a(new ItemStack(Block.field_9265_P, 1), "###", "#X#", "#R#", '#', Block.field_335_x, 'X', Item.field_227_i, 'R', Item.field_309_aA);
        this.func_1121_a(new ItemStack(Block.field_9255_Z, 1), "TTT", "#X#", "#R#", '#', Block.field_335_x, 'X', Item.field_223_m, 'R', Item.field_309_aA, 'T', Block.field_334_y);
        this.func_1121_a(new ItemStack(Block.field_9259_V, 1), "S", "P", 'S', Item.field_299_aK, 'P', Block.field_9255_Z);
        this.func_1121_a(new ItemStack(Item.field_22019_aY, 1), "###", "XXX", '#', Block.field_419_ac, 'X', Block.field_334_y);
        Collections.sort(this.field_1662_b, new RecipeSorter(this));
        System.out.println(this.field_1662_b.size() + " recipes");
    }

    void func_1121_a(ItemStack var1, Object... var2) {
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
                var14[var16] = ((ItemStack)var12.get(var10)).func_1102_e();
            } else {
                var14[var16] = null;
            }
        }

        this.field_1662_b.add(new ShapedRecipes(var5, var6, var14, var1));
    }

    void func_21187_b(ItemStack var1, Object... var2) {
        ArrayList var3 = new ArrayList();
        Object[] var4 = var2;
        int var5 = var2.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            if (var7 instanceof ItemStack) {
                var3.add(((ItemStack)var7).func_1102_e());
            } else if (var7 instanceof Item) {
                var3.add(new ItemStack((Item)var7));
            } else {
                if (!(var7 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.field_1662_b.add(new ShapelessRecipes(var1, var3));
    }

    public ItemStack func_21188_a(InventoryCrafting var1) {
        for(int var2 = 0; var2 < this.field_1662_b.size(); ++var2) {
            IRecipe var3 = (IRecipe)this.field_1662_b.get(var2);
            if (var3.func_21135_a(var1)) {
                return var3.func_21136_b(var1);
            }
        }

        return null;
    }

    public List func_25193_b() {
        return this.field_1662_b;
    }
}
