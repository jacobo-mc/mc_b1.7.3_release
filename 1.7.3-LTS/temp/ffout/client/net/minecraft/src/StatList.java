package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StatList {
    protected static Map field_25169_C = new HashMap();
    public static List field_25188_a = new ArrayList();
    public static List field_25187_b = new ArrayList();
    public static List field_25186_c = new ArrayList();
    public static List field_25185_d = new ArrayList();
    public static StatBase field_25184_e = (new StatBasic(1000, StatCollector.func_25200_a("stat.startGame"))).func_27082_h().func_25068_c();
    public static StatBase field_25183_f = (new StatBasic(1001, StatCollector.func_25200_a("stat.createWorld"))).func_27082_h().func_25068_c();
    public static StatBase field_25182_g = (new StatBasic(1002, StatCollector.func_25200_a("stat.loadWorld"))).func_27082_h().func_25068_c();
    public static StatBase field_25181_h = (new StatBasic(1003, StatCollector.func_25200_a("stat.joinMultiplayer"))).func_27082_h().func_25068_c();
    public static StatBase field_25180_i = (new StatBasic(1004, StatCollector.func_25200_a("stat.leaveGame"))).func_27082_h().func_25068_c();
    public static StatBase field_25179_j;
    public static StatBase field_25178_k;
    public static StatBase field_25177_l;
    public static StatBase field_25176_m;
    public static StatBase field_25175_n;
    public static StatBase field_25174_o;
    public static StatBase field_25173_p;
    public static StatBase field_27364_r;
    public static StatBase field_27363_s;
    public static StatBase field_27362_t;
    public static StatBase field_25171_q;
    public static StatBase field_25168_r;
    public static StatBase field_25167_s;
    public static StatBase field_25165_t;
    public static StatBase field_25163_u;
    public static StatBase field_25162_v;
    public static StatBase field_25161_w;
    public static StatBase field_25160_x;
    public static StatBase[] field_25159_y;
    public static StatBase[] field_25158_z;
    public static StatBase[] field_25172_A;
    public static StatBase[] field_25170_B;
    private static boolean field_25166_D;
    private static boolean field_25164_E;

    public static void func_27360_a() {
    }

    public static void func_25154_a() {
        field_25172_A = func_25155_a(field_25172_A, "stat.useItem", 16908288, 0, Block.field_345_n.length);
        field_25170_B = func_25149_b(field_25170_B, "stat.breakItem", 16973824, 0, Block.field_345_n.length);
        field_25166_D = true;
        func_25157_c();
    }

    public static void func_25151_b() {
        field_25172_A = func_25155_a(field_25172_A, "stat.useItem", 16908288, Block.field_345_n.length, 32000);
        field_25170_B = func_25149_b(field_25170_B, "stat.breakItem", 16973824, Block.field_345_n.length, 32000);
        field_25164_E = true;
        func_25157_c();
    }

    public static void func_25157_c() {
        if (field_25166_D && field_25164_E) {
            HashSet var0 = new HashSet();
            Iterator var1 = CraftingManager.func_1120_a().func_25193_b().iterator();

            while(var1.hasNext()) {
                IRecipe var2 = (IRecipe)var1.next();
                var0.add(var2.func_25117_b().field_1617_c);
            }

            var1 = FurnaceRecipes.func_21200_a().func_25194_b().values().iterator();

            while(var1.hasNext()) {
                ItemStack var4 = (ItemStack)var1.next();
                var0.add(var4.field_1617_c);
            }

            field_25158_z = new StatBase[32000];
            var1 = var0.iterator();

            while(var1.hasNext()) {
                Integer var5 = (Integer)var1.next();
                if (Item.field_233_c[var5] != null) {
                    String var3 = StatCollector.func_25199_a("stat.craftItem", Item.field_233_c[var5].func_25009_k());
                    field_25158_z[var5] = (new StatCrafting(16842752 + var5, var3, var5)).func_25068_c();
                }
            }

            func_25150_a(field_25158_z);
        }
    }

    private static StatBase[] func_25153_a(String var0, int var1) {
        StatBase[] var2 = new StatBase[256];

        for(int var3 = 0; var3 < 256; ++var3) {
            if (Block.field_345_n[var3] != null && Block.field_345_n[var3].func_27033_k()) {
                String var4 = StatCollector.func_25199_a(var0, Block.field_345_n[var3].func_25016_i());
                var2[var3] = (new StatCrafting(var1 + var3, var4, var3)).func_25068_c();
                field_25185_d.add((StatCrafting)var2[var3]);
            }
        }

        func_25150_a(var2);
        return var2;
    }

    private static StatBase[] func_25155_a(StatBase[] var0, String var1, int var2, int var3, int var4) {
        if (var0 == null) {
            var0 = new StatBase[32000];
        }

        for(int var5 = var3; var5 < var4; ++var5) {
            if (Item.field_233_c[var5] != null) {
                String var6 = StatCollector.func_25199_a(var1, Item.field_233_c[var5].func_25009_k());
                var0[var5] = (new StatCrafting(var2 + var5, var6, var5)).func_25068_c();
                if (var5 >= Block.field_345_n.length) {
                    field_25186_c.add((StatCrafting)var0[var5]);
                }
            }
        }

        func_25150_a(var0);
        return var0;
    }

    private static StatBase[] func_25149_b(StatBase[] var0, String var1, int var2, int var3, int var4) {
        if (var0 == null) {
            var0 = new StatBase[32000];
        }

        for(int var5 = var3; var5 < var4; ++var5) {
            if (Item.field_233_c[var5] != null && Item.field_233_c[var5].func_25007_g()) {
                String var6 = StatCollector.func_25199_a(var1, Item.field_233_c[var5].func_25009_k());
                var0[var5] = (new StatCrafting(var2 + var5, var6, var5)).func_25068_c();
            }
        }

        func_25150_a(var0);
        return var0;
    }

    private static void func_25150_a(StatBase[] var0) {
        func_25156_a(var0, Block.field_399_C.field_376_bc, Block.field_401_B.field_376_bc);
        func_25156_a(var0, Block.field_395_E.field_376_bc, Block.field_395_E.field_376_bc);
        func_25156_a(var0, Block.field_4045_bg.field_376_bc, Block.field_4055_bb.field_376_bc);
        func_25156_a(var0, Block.field_444_aD.field_376_bc, Block.field_445_aC.field_376_bc);
        func_25156_a(var0, Block.field_432_aP.field_376_bc, Block.field_433_aO.field_376_bc);
        func_25156_a(var0, Block.field_22020_bi.field_376_bc, Block.field_22021_bh.field_376_bc);
        func_25156_a(var0, Block.field_430_aR.field_376_bc, Block.field_431_aQ.field_376_bc);
        func_25156_a(var0, Block.field_414_ah.field_376_bc, Block.field_415_ag.field_376_bc);
        func_25156_a(var0, Block.field_411_ak.field_376_bc, Block.field_410_al.field_376_bc);
        func_25156_a(var0, Block.field_337_v.field_376_bc, Block.field_336_w.field_376_bc);
        func_25156_a(var0, Block.field_446_aB.field_376_bc, Block.field_336_w.field_376_bc);
    }

    private static void func_25156_a(StatBase[] var0, int var1, int var2) {
        if (var0[var1] != null && var0[var2] == null) {
            var0[var2] = var0[var1];
        } else {
            field_25188_a.remove(var0[var1]);
            field_25185_d.remove(var0[var1]);
            field_25187_b.remove(var0[var1]);
            var0[var1] = var0[var2];
        }
    }

    public static StatBase func_27361_a(int var0) {
        return (StatBase)field_25169_C.get(var0);
    }

    static {
        field_25179_j = (new StatBasic(1100, StatCollector.func_25200_a("stat.playOneMinute"), StatBase.field_27086_j)).func_27082_h().func_25068_c();
        field_25178_k = (new StatBasic(2000, StatCollector.func_25200_a("stat.walkOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_25177_l = (new StatBasic(2001, StatCollector.func_25200_a("stat.swimOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_25176_m = (new StatBasic(2002, StatCollector.func_25200_a("stat.fallOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_25175_n = (new StatBasic(2003, StatCollector.func_25200_a("stat.climbOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_25174_o = (new StatBasic(2004, StatCollector.func_25200_a("stat.flyOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_25173_p = (new StatBasic(2005, StatCollector.func_25200_a("stat.diveOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_27364_r = (new StatBasic(2006, StatCollector.func_25200_a("stat.minecartOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_27363_s = (new StatBasic(2007, StatCollector.func_25200_a("stat.boatOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_27362_t = (new StatBasic(2008, StatCollector.func_25200_a("stat.pigOneCm"), StatBase.field_27085_k)).func_27082_h().func_25068_c();
        field_25171_q = (new StatBasic(2010, StatCollector.func_25200_a("stat.jump"))).func_27082_h().func_25068_c();
        field_25168_r = (new StatBasic(2011, StatCollector.func_25200_a("stat.drop"))).func_27082_h().func_25068_c();
        field_25167_s = (new StatBasic(2020, StatCollector.func_25200_a("stat.damageDealt"))).func_25068_c();
        field_25165_t = (new StatBasic(2021, StatCollector.func_25200_a("stat.damageTaken"))).func_25068_c();
        field_25163_u = (new StatBasic(2022, StatCollector.func_25200_a("stat.deaths"))).func_25068_c();
        field_25162_v = (new StatBasic(2023, StatCollector.func_25200_a("stat.mobKills"))).func_25068_c();
        field_25161_w = (new StatBasic(2024, StatCollector.func_25200_a("stat.playerKills"))).func_25068_c();
        field_25160_x = (new StatBasic(2025, StatCollector.func_25200_a("stat.fishCaught"))).func_25068_c();
        field_25159_y = func_25153_a("stat.mineBlock", 16777216);
        AchievementList.func_27374_a();
        field_25166_D = false;
        field_25164_E = false;
    }
}
