package net.minecraft.src;

import java.util.Random;

public class Item {
    protected static Random field_4015_b = new Random();
    public static Item[] field_233_c = new Item[32000];
    public static Item field_232_d;
    public static Item field_231_e;
    public static Item field_230_f;
    public static Item field_4014_g;
    public static Item field_228_h;
    public static Item field_227_i;
    public static Item field_226_j;
    public static Item field_225_k;
    public static Item field_224_l;
    public static Item field_223_m;
    public static Item field_222_n;
    public static Item field_221_o;
    public static Item field_220_p;
    public static Item field_219_q;
    public static Item field_218_r;
    public static Item field_217_s;
    public static Item field_216_t;
    public static Item field_215_u;
    public static Item field_214_v;
    public static Item field_213_w;
    public static Item field_212_x;
    public static Item field_211_y;
    public static Item field_210_z;
    public static Item field_268_A;
    public static Item field_266_B;
    public static Item field_264_C;
    public static Item field_263_D;
    public static Item field_261_E;
    public static Item field_259_F;
    public static Item field_257_G;
    public static Item field_255_H;
    public static Item field_253_I;
    public static Item field_251_J;
    public static Item field_250_K;
    public static Item field_249_L;
    public static Item field_248_M;
    public static Item field_247_N;
    public static Item field_246_O;
    public static Item field_245_P;
    public static Item field_244_Q;
    public static Item field_243_R;
    public static Item field_242_S;
    public static Item field_241_T;
    public static Item field_240_U;
    public static Item field_239_V;
    public static Item field_238_W;
    public static Item field_237_X;
    public static Item field_236_Y;
    public static Item field_235_Z;
    public static Item field_286_aa;
    public static Item field_285_ab;
    public static Item field_284_ac;
    public static Item field_283_ad;
    public static Item field_282_ae;
    public static Item field_281_af;
    public static Item field_280_ag;
    public static Item field_279_ah;
    public static Item field_278_ai;
    public static Item field_277_aj;
    public static Item field_276_ak;
    public static Item field_275_al;
    public static Item field_274_am;
    public static Item field_273_an;
    public static Item field_272_ao;
    public static Item field_4017_ap;
    public static Item field_270_aq;
    public static Item field_269_ar;
    public static Item field_267_as;
    public static Item field_265_at;
    public static Item field_262_au;
    public static Item field_4016_av;
    public static Item field_258_aw;
    public static Item field_256_ax;
    public static Item field_254_ay;
    public static Item field_252_az;
    public static Item field_309_aA;
    public static Item field_308_aB;
    public static Item field_4031_aC;
    public static Item field_306_aD;
    public static Item field_305_aE;
    public static Item field_4030_aF;
    public static Item field_303_aG;
    public static Item field_302_aH;
    public static Item field_4029_aI;
    public static Item field_4028_aJ;
    public static Item field_299_aK;
    public static Item field_4027_aL;
    public static Item field_4026_aM;
    public static Item field_296_aN;
    public static Item field_4025_aO;
    public static Item field_4024_aP;
    public static Item field_4023_aQ;
    public static Item field_4022_aR;
    public static Item field_4021_aS;
    public static Item field_4020_aT;
    public static Item field_21021_aU;
    public static Item field_21020_aV;
    public static Item field_21019_aW;
    public static Item field_21022_aX;
    public static Item field_22019_aY;
    public static Item field_22018_aZ;
    public static Item field_25010_ba;
    public static ItemMap field_28010_bb;
    public static ItemShears field_31001_bc;
    public static Item field_293_aQ;
    public static Item field_4019_aV;
    public final int field_291_aS;
    protected int field_290_aT = 64;
    private int field_289_aU = 0;
    protected int field_4018_aZ;
    protected boolean field_287_aW = false;
    protected boolean field_21018_bf = false;
    private Item field_20926_a = null;
    private String field_332_a;

    protected Item(int var1) {
        this.field_291_aS = 256 + var1;
        if (field_233_c[256 + var1] != null) {
            System.out.println("CONFLICT @ " + var1);
        }

        field_233_c[256 + var1] = this;
    }

    public Item func_4022_a(int var1) {
        this.field_4018_aZ = var1;
        return this;
    }

    public Item func_21009_c(int var1) {
        this.field_290_aT = var1;
        return this;
    }

    public Item func_20010_a(int var1, int var2) {
        this.field_4018_aZ = var1 + var2 * 16;
        return this;
    }

    public int func_27009_a(int var1) {
        return this.field_4018_aZ;
    }

    public final int func_196_a(ItemStack var1) {
        return this.func_27009_a(var1.func_21181_i());
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        return false;
    }

    public float func_204_a(ItemStack var1, Block var2) {
        return 1.0F;
    }

    public ItemStack func_193_a(ItemStack var1, World var2, EntityPlayer var3) {
        return var1;
    }

    public int func_200_b() {
        return this.field_290_aT;
    }

    public int func_21012_a(int var1) {
        return 0;
    }

    public boolean func_21010_e() {
        return this.field_21018_bf;
    }

    protected Item func_21015_a(boolean var1) {
        this.field_21018_bf = var1;
        return this;
    }

    public int func_197_c() {
        return this.field_289_aU;
    }

    protected Item func_21013_d(int var1) {
        this.field_289_aU = var1;
        return this;
    }

    public boolean func_25007_g() {
        return this.field_289_aU > 0 && !this.field_21018_bf;
    }

    public boolean func_4021_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        return false;
    }

    public boolean func_25008_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        return false;
    }

    public int func_4020_a(Entity var1) {
        return 1;
    }

    public boolean func_4018_a(Block var1) {
        return false;
    }

    public void func_4019_b(ItemStack var1, EntityLiving var2) {
    }

    public Item func_4016_e() {
        this.field_287_aW = true;
        return this;
    }

    public boolean func_4017_a() {
        return this.field_287_aW;
    }

    public boolean func_4023_b() {
        return false;
    }

    public Item func_20011_a(String var1) {
        this.field_332_a = "item." + var1;
        return this;
    }

    public String func_20009_a() {
        return this.field_332_a;
    }

    public String func_21011_b(ItemStack var1) {
        return this.field_332_a;
    }

    public Item func_21017_a(Item var1) {
        if (this.field_290_aT > 1) {
            throw new IllegalArgumentException("Max stack size must be 1 for items with crafting results");
        } else {
            this.field_20926_a = var1;
            return this;
        }
    }

    public Item func_21016_h() {
        return this.field_20926_a;
    }

    public boolean func_21014_i() {
        return this.field_20926_a != null;
    }

    public String func_25009_k() {
        return StatCollector.func_25200_a(this.func_20009_a() + ".name");
    }

    public int func_27010_f(int var1) {
        return 16777215;
    }

    public void func_28008_a(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
    }

    public void func_28009_b(ItemStack var1, World var2, EntityPlayer var3) {
    }

    static {
        field_232_d = (new ItemSpade(0, EnumToolMaterial.IRON)).func_20010_a(2, 5).func_20011_a("shovelIron");
        field_231_e = (new ItemPickaxe(1, EnumToolMaterial.IRON)).func_20010_a(2, 6).func_20011_a("pickaxeIron");
        field_230_f = (new ItemAxe(2, EnumToolMaterial.IRON)).func_20010_a(2, 7).func_20011_a("hatchetIron");
        field_4014_g = (new ItemFlintAndSteel(3)).func_20010_a(5, 0).func_20011_a("flintAndSteel");
        field_228_h = (new ItemFood(4, 4, false)).func_20010_a(10, 0).func_20011_a("apple");
        field_227_i = (new ItemBow(5)).func_20010_a(5, 1).func_20011_a("bow");
        field_226_j = (new Item(6)).func_20010_a(5, 2).func_20011_a("arrow");
        field_225_k = (new ItemCoal(7)).func_20010_a(7, 0).func_20011_a("coal");
        field_224_l = (new Item(8)).func_20010_a(7, 3).func_20011_a("emerald");
        field_223_m = (new Item(9)).func_20010_a(7, 1).func_20011_a("ingotIron");
        field_222_n = (new Item(10)).func_20010_a(7, 2).func_20011_a("ingotGold");
        field_221_o = (new ItemSword(11, EnumToolMaterial.IRON)).func_20010_a(2, 4).func_20011_a("swordIron");
        field_220_p = (new ItemSword(12, EnumToolMaterial.WOOD)).func_20010_a(0, 4).func_20011_a("swordWood");
        field_219_q = (new ItemSpade(13, EnumToolMaterial.WOOD)).func_20010_a(0, 5).func_20011_a("shovelWood");
        field_218_r = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).func_20010_a(0, 6).func_20011_a("pickaxeWood");
        field_217_s = (new ItemAxe(15, EnumToolMaterial.WOOD)).func_20010_a(0, 7).func_20011_a("hatchetWood");
        field_216_t = (new ItemSword(16, EnumToolMaterial.STONE)).func_20010_a(1, 4).func_20011_a("swordStone");
        field_215_u = (new ItemSpade(17, EnumToolMaterial.STONE)).func_20010_a(1, 5).func_20011_a("shovelStone");
        field_214_v = (new ItemPickaxe(18, EnumToolMaterial.STONE)).func_20010_a(1, 6).func_20011_a("pickaxeStone");
        field_213_w = (new ItemAxe(19, EnumToolMaterial.STONE)).func_20010_a(1, 7).func_20011_a("hatchetStone");
        field_212_x = (new ItemSword(20, EnumToolMaterial.EMERALD)).func_20010_a(3, 4).func_20011_a("swordDiamond");
        field_211_y = (new ItemSpade(21, EnumToolMaterial.EMERALD)).func_20010_a(3, 5).func_20011_a("shovelDiamond");
        field_210_z = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).func_20010_a(3, 6).func_20011_a("pickaxeDiamond");
        field_268_A = (new ItemAxe(23, EnumToolMaterial.EMERALD)).func_20010_a(3, 7).func_20011_a("hatchetDiamond");
        field_266_B = (new Item(24)).func_20010_a(5, 3).func_4016_e().func_20011_a("stick");
        field_264_C = (new Item(25)).func_20010_a(7, 4).func_20011_a("bowl");
        field_263_D = (new ItemSoup(26, 10)).func_20010_a(8, 4).func_20011_a("mushroomStew");
        field_261_E = (new ItemSword(27, EnumToolMaterial.GOLD)).func_20010_a(4, 4).func_20011_a("swordGold");
        field_259_F = (new ItemSpade(28, EnumToolMaterial.GOLD)).func_20010_a(4, 5).func_20011_a("shovelGold");
        field_257_G = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).func_20010_a(4, 6).func_20011_a("pickaxeGold");
        field_255_H = (new ItemAxe(30, EnumToolMaterial.GOLD)).func_20010_a(4, 7).func_20011_a("hatchetGold");
        field_253_I = (new Item(31)).func_20010_a(8, 0).func_20011_a("string");
        field_251_J = (new Item(32)).func_20010_a(8, 1).func_20011_a("feather");
        field_250_K = (new Item(33)).func_20010_a(8, 2).func_20011_a("sulphur");
        field_249_L = (new ItemHoe(34, EnumToolMaterial.WOOD)).func_20010_a(0, 8).func_20011_a("hoeWood");
        field_248_M = (new ItemHoe(35, EnumToolMaterial.STONE)).func_20010_a(1, 8).func_20011_a("hoeStone");
        field_247_N = (new ItemHoe(36, EnumToolMaterial.IRON)).func_20010_a(2, 8).func_20011_a("hoeIron");
        field_246_O = (new ItemHoe(37, EnumToolMaterial.EMERALD)).func_20010_a(3, 8).func_20011_a("hoeDiamond");
        field_245_P = (new ItemHoe(38, EnumToolMaterial.GOLD)).func_20010_a(4, 8).func_20011_a("hoeGold");
        field_244_Q = (new ItemSeeds(39, Block.field_447_aA.field_376_bc)).func_20010_a(9, 0).func_20011_a("seeds");
        field_243_R = (new Item(40)).func_20010_a(9, 1).func_20011_a("wheat");
        field_242_S = (new ItemFood(41, 5, false)).func_20010_a(9, 2).func_20011_a("bread");
        field_241_T = (new ItemArmor(42, 0, 0, 0)).func_20010_a(0, 0).func_20011_a("helmetCloth");
        field_240_U = (new ItemArmor(43, 0, 0, 1)).func_20010_a(0, 1).func_20011_a("chestplateCloth");
        field_239_V = (new ItemArmor(44, 0, 0, 2)).func_20010_a(0, 2).func_20011_a("leggingsCloth");
        field_238_W = (new ItemArmor(45, 0, 0, 3)).func_20010_a(0, 3).func_20011_a("bootsCloth");
        field_237_X = (new ItemArmor(46, 1, 1, 0)).func_20010_a(1, 0).func_20011_a("helmetChain");
        field_236_Y = (new ItemArmor(47, 1, 1, 1)).func_20010_a(1, 1).func_20011_a("chestplateChain");
        field_235_Z = (new ItemArmor(48, 1, 1, 2)).func_20010_a(1, 2).func_20011_a("leggingsChain");
        field_286_aa = (new ItemArmor(49, 1, 1, 3)).func_20010_a(1, 3).func_20011_a("bootsChain");
        field_285_ab = (new ItemArmor(50, 2, 2, 0)).func_20010_a(2, 0).func_20011_a("helmetIron");
        field_284_ac = (new ItemArmor(51, 2, 2, 1)).func_20010_a(2, 1).func_20011_a("chestplateIron");
        field_283_ad = (new ItemArmor(52, 2, 2, 2)).func_20010_a(2, 2).func_20011_a("leggingsIron");
        field_282_ae = (new ItemArmor(53, 2, 2, 3)).func_20010_a(2, 3).func_20011_a("bootsIron");
        field_281_af = (new ItemArmor(54, 3, 3, 0)).func_20010_a(3, 0).func_20011_a("helmetDiamond");
        field_280_ag = (new ItemArmor(55, 3, 3, 1)).func_20010_a(3, 1).func_20011_a("chestplateDiamond");
        field_279_ah = (new ItemArmor(56, 3, 3, 2)).func_20010_a(3, 2).func_20011_a("leggingsDiamond");
        field_278_ai = (new ItemArmor(57, 3, 3, 3)).func_20010_a(3, 3).func_20011_a("bootsDiamond");
        field_277_aj = (new ItemArmor(58, 1, 4, 0)).func_20010_a(4, 0).func_20011_a("helmetGold");
        field_276_ak = (new ItemArmor(59, 1, 4, 1)).func_20010_a(4, 1).func_20011_a("chestplateGold");
        field_275_al = (new ItemArmor(60, 1, 4, 2)).func_20010_a(4, 2).func_20011_a("leggingsGold");
        field_274_am = (new ItemArmor(61, 1, 4, 3)).func_20010_a(4, 3).func_20011_a("bootsGold");
        field_273_an = (new Item(62)).func_20010_a(6, 0).func_20011_a("flint");
        field_272_ao = (new ItemFood(63, 3, true)).func_20010_a(7, 5).func_20011_a("porkchopRaw");
        field_4017_ap = (new ItemFood(64, 8, true)).func_20010_a(8, 5).func_20011_a("porkchopCooked");
        field_270_aq = (new ItemPainting(65)).func_20010_a(10, 1).func_20011_a("painting");
        field_269_ar = (new ItemFood(66, 42, false)).func_20010_a(11, 0).func_20011_a("appleGold");
        field_267_as = (new ItemSign(67)).func_20010_a(10, 2).func_20011_a("sign");
        field_265_at = (new ItemDoor(68, Material.field_1335_c)).func_20010_a(11, 2).func_20011_a("doorWood");
        field_262_au = (new ItemBucket(69, 0)).func_20010_a(10, 4).func_20011_a("bucket");
        field_4016_av = (new ItemBucket(70, Block.field_401_B.field_376_bc)).func_20010_a(11, 4).func_20011_a("bucketWater").func_21017_a(field_262_au);
        field_258_aw = (new ItemBucket(71, Block.field_397_D.field_376_bc)).func_20010_a(12, 4).func_20011_a("bucketLava").func_21017_a(field_262_au);
        field_256_ax = (new ItemMinecart(72, 0)).func_20010_a(7, 8).func_20011_a("minecart");
        field_254_ay = (new ItemSaddle(73)).func_20010_a(8, 6).func_20011_a("saddle");
        field_252_az = (new ItemDoor(74, Material.field_1333_e)).func_20010_a(12, 2).func_20011_a("doorIron");
        field_309_aA = (new ItemRedstone(75)).func_20010_a(8, 3).func_20011_a("redstone");
        field_308_aB = (new ItemSnowball(76)).func_20010_a(14, 0).func_20011_a("snowball");
        field_4031_aC = (new ItemBoat(77)).func_20010_a(8, 8).func_20011_a("boat");
        field_306_aD = (new Item(78)).func_20010_a(7, 6).func_20011_a("leather");
        field_305_aE = (new ItemBucket(79, -1)).func_20010_a(13, 4).func_20011_a("milk").func_21017_a(field_262_au);
        field_4030_aF = (new Item(80)).func_20010_a(6, 1).func_20011_a("brick");
        field_303_aG = (new Item(81)).func_20010_a(9, 3).func_20011_a("clay");
        field_302_aH = (new ItemReed(82, Block.field_423_aY)).func_20010_a(11, 1).func_20011_a("reeds");
        field_4029_aI = (new Item(83)).func_20010_a(10, 3).func_20011_a("paper");
        field_4028_aJ = (new Item(84)).func_20010_a(11, 3).func_20011_a("book");
        field_299_aK = (new Item(85)).func_20010_a(14, 1).func_20011_a("slimeball");
        field_4027_aL = (new ItemMinecart(86, 1)).func_20010_a(7, 9).func_20011_a("minecartChest");
        field_4026_aM = (new ItemMinecart(87, 2)).func_20010_a(7, 10).func_20011_a("minecartFurnace");
        field_296_aN = (new ItemEgg(88)).func_20010_a(12, 0).func_20011_a("egg");
        field_4025_aO = (new Item(89)).func_20010_a(6, 3).func_20011_a("compass");
        field_4024_aP = (new ItemFishingRod(90)).func_20010_a(5, 4).func_20011_a("fishingRod");
        field_4023_aQ = (new Item(91)).func_20010_a(6, 4).func_20011_a("clock");
        field_4022_aR = (new Item(92)).func_20010_a(9, 4).func_20011_a("yellowDust");
        field_4021_aS = (new ItemFood(93, 2, false)).func_20010_a(9, 5).func_20011_a("fishRaw");
        field_4020_aT = (new ItemFood(94, 5, false)).func_20010_a(10, 5).func_20011_a("fishCooked");
        field_21021_aU = (new ItemDye(95)).func_20010_a(14, 4).func_20011_a("dyePowder");
        field_21020_aV = (new Item(96)).func_20010_a(12, 1).func_20011_a("bone").func_4016_e();
        field_21019_aW = (new Item(97)).func_20010_a(13, 0).func_20011_a("sugar").func_4016_e();
        field_21022_aX = (new ItemReed(98, Block.field_21026_bg)).func_21009_c(1).func_20010_a(13, 1).func_20011_a("cake");
        field_22019_aY = (new ItemBed(99)).func_21009_c(1).func_20010_a(13, 2).func_20011_a("bed");
        field_22018_aZ = (new ItemReed(100, Block.field_22021_bh)).func_20010_a(6, 5).func_20011_a("diode");
        field_25010_ba = (new ItemCookie(101, 1, false, 8)).func_20010_a(12, 5).func_20011_a("cookie");
        field_28010_bb = (ItemMap)(new ItemMap(102)).func_20010_a(12, 3).func_20011_a("map");
        field_31001_bc = (ItemShears)(new ItemShears(103)).func_20010_a(13, 5).func_20011_a("shears");
        field_293_aQ = (new ItemRecord(2000, "13")).func_20010_a(0, 15).func_20011_a("record");
        field_4019_aV = (new ItemRecord(2001, "cat")).func_20010_a(1, 15).func_20011_a("record");
        StatList.func_25151_b();
    }
}
