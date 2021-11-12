package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StatList {
    protected static Map field_25104_C = new HashMap();
    public static List field_25123_a = new ArrayList();
    public static List field_25122_b = new ArrayList();
    public static List field_25121_c = new ArrayList();
    public static List field_25120_d = new ArrayList();
    public static StatBase field_25119_e = (new StatBasic(1000, StatCollector.translateToLocal("stat.startGame"))).func_27052_e().func_27053_d();
    public static StatBase field_25118_f = (new StatBasic(1001, StatCollector.translateToLocal("stat.createWorld"))).func_27052_e().func_27053_d();
    public static StatBase field_25117_g = (new StatBasic(1002, StatCollector.translateToLocal("stat.loadWorld"))).func_27052_e().func_27053_d();
    public static StatBase field_25116_h = (new StatBasic(1003, StatCollector.translateToLocal("stat.joinMultiplayer"))).func_27052_e().func_27053_d();
    public static StatBase field_25115_i = (new StatBasic(1004, StatCollector.translateToLocal("stat.leaveGame"))).func_27052_e().func_27053_d();
    public static StatBase field_25114_j;
    public static StatBase field_25113_k;
    public static StatBase field_25112_l;
    public static StatBase field_25111_m;
    public static StatBase field_25110_n;
    public static StatBase field_25109_o;
    public static StatBase field_25108_p;
    public static StatBase field_27095_r;
    public static StatBase field_27094_s;
    public static StatBase field_27093_t;
    public static StatBase field_25106_q;
    public static StatBase field_25103_r;
    public static StatBase field_25102_s;
    public static StatBase field_25100_t;
    public static StatBase field_25098_u;
    public static StatBase field_25097_v;
    public static StatBase field_25096_w;
    public static StatBase fishCaughtStat;
    public static StatBase[] mineBlockStatArray;
    public static StatBase[] field_25093_z;
    public static StatBase[] field_25107_A;
    public static StatBase[] field_25105_B;
    private static boolean field_25101_D;
    private static boolean field_25099_E;

    public static void func_27092_a() {
    }

    public static void update() {
        field_25107_A = func_25090_a(field_25107_A, "stat.useItem", 16908288, 0, Block.blocksList.length);
        field_25105_B = func_25087_b(field_25105_B, "stat.breakItem", 16973824, 0, Block.blocksList.length);
        field_25101_D = true;
        func_25091_c();
    }

    public static void func_25086_b() {
        field_25107_A = func_25090_a(field_25107_A, "stat.useItem", 16908288, Block.blocksList.length, 32000);
        field_25105_B = func_25087_b(field_25105_B, "stat.breakItem", 16973824, Block.blocksList.length, 32000);
        field_25099_E = true;
        func_25091_c();
    }

    public static void func_25091_c() {
        if (field_25101_D && field_25099_E) {
            HashSet var0 = new HashSet();
            Iterator var1 = CraftingManager.getInstance().getRecipeList().iterator();

            while(var1.hasNext()) {
                IRecipe var2 = (IRecipe)var1.next();
                var0.add(var2.func_25077_b().itemID);
            }

            var1 = FurnaceRecipes.smelting().getSmeltingList().values().iterator();

            while(var1.hasNext()) {
                ItemStack var4 = (ItemStack)var1.next();
                var0.add(var4.itemID);
            }

            field_25093_z = new StatBase[32000];
            var1 = var0.iterator();

            while(var1.hasNext()) {
                Integer var5 = (Integer)var1.next();
                if (Item.itemsList[var5] != null) {
                    String var3 = StatCollector.translateToLocalFormatted("stat.craftItem", Item.itemsList[var5].getStatName());
                    field_25093_z[var5] = (new StatCrafting(16842752 + var5, var3, var5)).func_27053_d();
                }
            }

            replaceAllSimilarBlocks(field_25093_z);
        }
    }

    private static StatBase[] func_25089_a(String var0, int var1) {
        StatBase[] var2 = new StatBase[256];

        for(int var3 = 0; var3 < 256; ++var3) {
            if (Block.blocksList[var3] != null && Block.blocksList[var3].getEnableStats()) {
                String var4 = StatCollector.translateToLocalFormatted(var0, Block.blocksList[var3].getNameLocalizedForStats());
                var2[var3] = (new StatCrafting(var1 + var3, var4, var3)).func_27053_d();
                field_25120_d.add((StatCrafting)var2[var3]);
            }
        }

        replaceAllSimilarBlocks(var2);
        return var2;
    }

    private static StatBase[] func_25090_a(StatBase[] var0, String var1, int var2, int var3, int var4) {
        if (var0 == null) {
            var0 = new StatBase[32000];
        }

        for(int var5 = var3; var5 < var4; ++var5) {
            if (Item.itemsList[var5] != null) {
                String var6 = StatCollector.translateToLocalFormatted(var1, Item.itemsList[var5].getStatName());
                var0[var5] = (new StatCrafting(var2 + var5, var6, var5)).func_27053_d();
                if (var5 >= Block.blocksList.length) {
                    field_25121_c.add((StatCrafting)var0[var5]);
                }
            }
        }

        replaceAllSimilarBlocks(var0);
        return var0;
    }

    private static StatBase[] func_25087_b(StatBase[] var0, String var1, int var2, int var3, int var4) {
        if (var0 == null) {
            var0 = new StatBase[32000];
        }

        for(int var5 = var3; var5 < var4; ++var5) {
            if (Item.itemsList[var5] != null && Item.itemsList[var5].isDamagable()) {
                String var6 = StatCollector.translateToLocalFormatted(var1, Item.itemsList[var5].getStatName());
                var0[var5] = (new StatCrafting(var2 + var5, var6, var5)).func_27053_d();
            }
        }

        replaceAllSimilarBlocks(var0);
        return var0;
    }

    private static void replaceAllSimilarBlocks(StatBase[] var0) {
        replaceSimilarBlocks(var0, Block.waterStill.blockID, Block.waterMoving.blockID);
        replaceSimilarBlocks(var0, Block.lavaStill.blockID, Block.lavaStill.blockID);
        replaceSimilarBlocks(var0, Block.pumpkinLantern.blockID, Block.pumpkin.blockID);
        replaceSimilarBlocks(var0, Block.stoneOvenActive.blockID, Block.stoneOvenIdle.blockID);
        replaceSimilarBlocks(var0, Block.oreRedstoneGlowing.blockID, Block.oreRedstone.blockID);
        replaceSimilarBlocks(var0, Block.redstoneRepeaterActive.blockID, Block.redstoneRepeaterIdle.blockID);
        replaceSimilarBlocks(var0, Block.torchRedstoneActive.blockID, Block.torchRedstoneIdle.blockID);
        replaceSimilarBlocks(var0, Block.mushroomRed.blockID, Block.mushroomBrown.blockID);
        replaceSimilarBlocks(var0, Block.stairDouble.blockID, Block.stairSingle.blockID);
        replaceSimilarBlocks(var0, Block.grass.blockID, Block.dirt.blockID);
        replaceSimilarBlocks(var0, Block.tilledField.blockID, Block.dirt.blockID);
    }

    private static void replaceSimilarBlocks(StatBase[] var0, int var1, int var2) {
        if (var0[var1] != null && var0[var2] == null) {
            var0[var2] = var0[var1];
        } else {
            field_25123_a.remove(var0[var1]);
            field_25120_d.remove(var0[var1]);
            field_25122_b.remove(var0[var1]);
            var0[var1] = var0[var2];
        }
    }

    static {
        field_25114_j = (new StatBasic(1100, StatCollector.translateToLocal("stat.playOneMinute"), StatBase.field_27055_j)).func_27052_e().func_27053_d();
        field_25113_k = (new StatBasic(2000, StatCollector.translateToLocal("stat.walkOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_25112_l = (new StatBasic(2001, StatCollector.translateToLocal("stat.swimOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_25111_m = (new StatBasic(2002, StatCollector.translateToLocal("stat.fallOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_25110_n = (new StatBasic(2003, StatCollector.translateToLocal("stat.climbOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_25109_o = (new StatBasic(2004, StatCollector.translateToLocal("stat.flyOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_25108_p = (new StatBasic(2005, StatCollector.translateToLocal("stat.diveOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_27095_r = (new StatBasic(2006, StatCollector.translateToLocal("stat.minecartOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_27094_s = (new StatBasic(2007, StatCollector.translateToLocal("stat.boatOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_27093_t = (new StatBasic(2008, StatCollector.translateToLocal("stat.pigOneCm"), StatBase.field_27054_k)).func_27052_e().func_27053_d();
        field_25106_q = (new StatBasic(2010, StatCollector.translateToLocal("stat.jump"))).func_27052_e().func_27053_d();
        field_25103_r = (new StatBasic(2011, StatCollector.translateToLocal("stat.drop"))).func_27052_e().func_27053_d();
        field_25102_s = (new StatBasic(2020, StatCollector.translateToLocal("stat.damageDealt"))).func_27053_d();
        field_25100_t = (new StatBasic(2021, StatCollector.translateToLocal("stat.damageTaken"))).func_27053_d();
        field_25098_u = (new StatBasic(2022, StatCollector.translateToLocal("stat.deaths"))).func_27053_d();
        field_25097_v = (new StatBasic(2023, StatCollector.translateToLocal("stat.mobKills"))).func_27053_d();
        field_25096_w = (new StatBasic(2024, StatCollector.translateToLocal("stat.playerKills"))).func_27053_d();
        fishCaughtStat = (new StatBasic(2025, StatCollector.translateToLocal("stat.fishCaught"))).func_27053_d();
        mineBlockStatArray = func_25089_a("stat.mineBlock", 16777216);
        AchievementList.func_27097_a();
        field_25101_D = false;
        field_25099_E = false;
    }
}
