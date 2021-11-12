package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class AchievementList {
    public static int field_27392_a;
    public static int field_27391_b;
    public static int field_27390_c;
    public static int field_27389_d;
    public static List field_27388_e = new ArrayList();
    public static Achievement field_25195_b;
    public static Achievement field_25198_c;
    public static Achievement field_25197_d;
    public static Achievement field_27387_i;
    public static Achievement field_27386_j;
    public static Achievement field_27385_k;
    public static Achievement field_27384_l;
    public static Achievement field_27383_m;
    public static Achievement field_27382_n;
    public static Achievement field_27381_o;
    public static Achievement field_27380_p;
    public static Achievement field_27379_q;
    public static Achievement field_27378_r;
    public static Achievement field_27377_s;
    public static Achievement field_27376_t;
    public static Achievement field_27375_u;

    public static void func_27374_a() {
    }

    static {
        field_25195_b = (new Achievement(0, "openInventory", 0, 0, Item.field_4028_aJ, (Achievement)null)).func_27089_a().func_27091_c();
        field_25198_c = (new Achievement(1, "mineWood", 2, 1, Block.field_385_K, field_25195_b)).func_27091_c();
        field_25197_d = (new Achievement(2, "buildWorkBench", 4, -1, Block.field_387_az, field_25198_c)).func_27091_c();
        field_27387_i = (new Achievement(3, "buildPickaxe", 4, 2, Item.field_218_r, field_25197_d)).func_27091_c();
        field_27386_j = (new Achievement(4, "buildFurnace", 3, 4, Block.field_444_aD, field_27387_i)).func_27091_c();
        field_27385_k = (new Achievement(5, "acquireIron", 1, 4, Item.field_223_m, field_27386_j)).func_27091_c();
        field_27384_l = (new Achievement(6, "buildHoe", 2, -3, Item.field_249_L, field_25197_d)).func_27091_c();
        field_27383_m = (new Achievement(7, "makeBread", -1, -3, Item.field_242_S, field_27384_l)).func_27091_c();
        field_27382_n = (new Achievement(8, "bakeCake", 0, -5, Item.field_21022_aX, field_27384_l)).func_27091_c();
        field_27381_o = (new Achievement(9, "buildBetterPickaxe", 6, 2, Item.field_214_v, field_27387_i)).func_27091_c();
        field_27380_p = (new Achievement(10, "cookFish", 2, 6, Item.field_4020_aT, field_27386_j)).func_27091_c();
        field_27379_q = (new Achievement(11, "onARail", 2, 3, Block.field_440_aH, field_27385_k)).func_27094_b().func_27091_c();
        field_27378_r = (new Achievement(12, "buildSword", 6, -1, Item.field_220_p, field_25197_d)).func_27091_c();
        field_27377_s = (new Achievement(13, "killEnemy", 8, -1, Item.field_21020_aV, field_27378_r)).func_27091_c();
        field_27376_t = (new Achievement(14, "killCow", 7, -3, Item.field_306_aD, field_27378_r)).func_27091_c();
        field_27375_u = (new Achievement(15, "flyPig", 8, -4, Item.field_254_ay, field_27376_t)).func_27094_b().func_27091_c();
        System.out.println(field_27388_e.size() + " achievements");
    }
}
