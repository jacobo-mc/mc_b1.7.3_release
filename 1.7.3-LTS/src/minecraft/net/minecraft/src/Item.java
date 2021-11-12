package net.minecraft.src;

import java.util.Random;

public class Item {
    protected static Random itemRand = new Random();
    public static Item[] itemsList = new Item[32000];
    public static Item shovelSteel;
    public static Item pickaxeSteel;
    public static Item axeSteel;
    public static Item flintAndSteel;
    public static Item appleRed;
    public static Item bow;
    public static Item arrow;
    public static Item coal;
    public static Item diamond;
    public static Item ingotIron;
    public static Item ingotGold;
    public static Item swordSteel;
    public static Item swordWood;
    public static Item shovelWood;
    public static Item pickaxeWood;
    public static Item axeWood;
    public static Item swordStone;
    public static Item shovelStone;
    public static Item pickaxeStone;
    public static Item axeStone;
    public static Item swordDiamond;
    public static Item shovelDiamond;
    public static Item pickaxeDiamond;
    public static Item axeDiamond;
    public static Item stick;
    public static Item bowlEmpty;
    public static Item bowlSoup;
    public static Item swordGold;
    public static Item shovelGold;
    public static Item pickaxeGold;
    public static Item axeGold;
    public static Item silk;
    public static Item feather;
    public static Item gunpowder;
    public static Item hoeWood;
    public static Item hoeStone;
    public static Item hoeSteel;
    public static Item hoeDiamond;
    public static Item hoeGold;
    public static Item seeds;
    public static Item wheat;
    public static Item bread;
    public static Item helmetLeather;
    public static Item plateLeather;
    public static Item legsLeather;
    public static Item bootsLeather;
    public static Item helmetChain;
    public static Item plateChain;
    public static Item legsChain;
    public static Item bootsChain;
    public static Item helmetSteel;
    public static Item plateSteel;
    public static Item legsSteel;
    public static Item bootsSteel;
    public static Item helmetDiamond;
    public static Item plateDiamond;
    public static Item legsDiamond;
    public static Item bootsDiamond;
    public static Item helmetGold;
    public static Item plateGold;
    public static Item legsGold;
    public static Item bootsGold;
    public static Item flint;
    public static Item porkRaw;
    public static Item porkCooked;
    public static Item painting;
    public static Item appleGold;
    public static Item sign;
    public static Item doorWood;
    public static Item bucketEmpty;
    public static Item bucketWater;
    public static Item bucketLava;
    public static Item minecartEmpty;
    public static Item saddle;
    public static Item doorSteel;
    public static Item redstone;
    public static Item snowball;
    public static Item boat;
    public static Item leather;
    public static Item bucketMilk;
    public static Item brick;
    public static Item clay;
    public static Item reed;
    public static Item paper;
    public static Item book;
    public static Item slimeBall;
    public static Item minecartCrate;
    public static Item minecartPowered;
    public static Item egg;
    public static Item compass;
    public static Item fishingRod;
    public static Item pocketSundial;
    public static Item lightStoneDust;
    public static Item fishRaw;
    public static Item fishCooked;
    public static Item dyePowder;
    public static Item bone;
    public static Item sugar;
    public static Item cake;
    public static Item bed;
    public static Item redstoneRepeater;
    public static Item cookie;
    public static ItemMap mapItem;
    public static ItemShears shears;
    public static Item record13;
    public static Item recordCat;
    public final int shiftedIndex;
    protected int maxStackSize = 64;
    private int maxDamage = 0;
    protected int iconIndex;
    protected boolean bFull3D = false;
    protected boolean hasSubtypes = false;
    private Item containerItem = null;
    private String itemName;

    protected Item(int var1) {
        this.shiftedIndex = 256 + var1;
        if (itemsList[256 + var1] != null) {
            System.out.println("CONFLICT @ " + var1);
        }

        itemsList[256 + var1] = this;
    }

    public Item setIconIndex(int var1) {
        this.iconIndex = var1;
        return this;
    }

    public Item setMaxStackSize(int var1) {
        this.maxStackSize = var1;
        return this;
    }

    public Item setIconCoord(int var1, int var2) {
        this.iconIndex = var1 + var2 * 16;
        return this;
    }

    public int getIconFromDamage(int var1) {
        return this.iconIndex;
    }

    public final int getIconIndex(ItemStack var1) {
        return this.getIconFromDamage(var1.getItemDamage());
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        return false;
    }

    public float getStrVsBlock(ItemStack var1, Block var2) {
        return 1.0F;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        return var1;
    }

    public int getItemStackLimit() {
        return this.maxStackSize;
    }

    public int getPlacedBlockMetadata(int var1) {
        return 0;
    }

    public boolean getHasSubtypes() {
        return this.hasSubtypes;
    }

    protected Item setHasSubtypes(boolean var1) {
        this.hasSubtypes = var1;
        return this;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    protected Item setMaxDamage(int var1) {
        this.maxDamage = var1;
        return this;
    }

    public boolean isDamagable() {
        return this.maxDamage > 0 && !this.hasSubtypes;
    }

    public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        return false;
    }

    public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        return false;
    }

    public int getDamageVsEntity(Entity var1) {
        return 1;
    }

    public boolean canHarvestBlock(Block var1) {
        return false;
    }

    public void saddleEntity(ItemStack var1, EntityLiving var2) {
    }

    public Item setFull3D() {
        this.bFull3D = true;
        return this;
    }

    public boolean isFull3D() {
        return this.bFull3D;
    }

    public boolean shouldRotateAroundWhenRendering() {
        return false;
    }

    public Item setItemName(String var1) {
        this.itemName = "item." + var1;
        return this;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemNameIS(ItemStack var1) {
        return this.itemName;
    }

    public Item setContainerItem(Item var1) {
        if (this.maxStackSize > 1) {
            throw new IllegalArgumentException("Max stack size must be 1 for items with crafting results");
        } else {
            this.containerItem = var1;
            return this;
        }
    }

    public Item getContainerItem() {
        return this.containerItem;
    }

    public boolean hasContainerItem() {
        return this.containerItem != null;
    }

    public String getStatName() {
        return StatCollector.translateToLocal(this.getItemName() + ".name");
    }

    public int getColorFromDamage(int var1) {
        return 16777215;
    }

    public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
    }

    public void onCreated(ItemStack var1, World var2, EntityPlayer var3) {
    }

    static {
        shovelSteel = (new ItemSpade(0, EnumToolMaterial.IRON)).setIconCoord(2, 5).setItemName("shovelIron");
        pickaxeSteel = (new ItemPickaxe(1, EnumToolMaterial.IRON)).setIconCoord(2, 6).setItemName("pickaxeIron");
        axeSteel = (new ItemAxe(2, EnumToolMaterial.IRON)).setIconCoord(2, 7).setItemName("hatchetIron");
        flintAndSteel = (new ItemFlintAndSteel(3)).setIconCoord(5, 0).setItemName("flintAndSteel");
        appleRed = (new ItemFood(4, 4, false)).setIconCoord(10, 0).setItemName("apple");
        bow = (new ItemBow(5)).setIconCoord(5, 1).setItemName("bow");
        arrow = (new Item(6)).setIconCoord(5, 2).setItemName("arrow");
        coal = (new ItemCoal(7)).setIconCoord(7, 0).setItemName("coal");
        diamond = (new Item(8)).setIconCoord(7, 3).setItemName("emerald");
        ingotIron = (new Item(9)).setIconCoord(7, 1).setItemName("ingotIron");
        ingotGold = (new Item(10)).setIconCoord(7, 2).setItemName("ingotGold");
        swordSteel = (new ItemSword(11, EnumToolMaterial.IRON)).setIconCoord(2, 4).setItemName("swordIron");
        swordWood = (new ItemSword(12, EnumToolMaterial.WOOD)).setIconCoord(0, 4).setItemName("swordWood");
        shovelWood = (new ItemSpade(13, EnumToolMaterial.WOOD)).setIconCoord(0, 5).setItemName("shovelWood");
        pickaxeWood = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).setIconCoord(0, 6).setItemName("pickaxeWood");
        axeWood = (new ItemAxe(15, EnumToolMaterial.WOOD)).setIconCoord(0, 7).setItemName("hatchetWood");
        swordStone = (new ItemSword(16, EnumToolMaterial.STONE)).setIconCoord(1, 4).setItemName("swordStone");
        shovelStone = (new ItemSpade(17, EnumToolMaterial.STONE)).setIconCoord(1, 5).setItemName("shovelStone");
        pickaxeStone = (new ItemPickaxe(18, EnumToolMaterial.STONE)).setIconCoord(1, 6).setItemName("pickaxeStone");
        axeStone = (new ItemAxe(19, EnumToolMaterial.STONE)).setIconCoord(1, 7).setItemName("hatchetStone");
        swordDiamond = (new ItemSword(20, EnumToolMaterial.EMERALD)).setIconCoord(3, 4).setItemName("swordDiamond");
        shovelDiamond = (new ItemSpade(21, EnumToolMaterial.EMERALD)).setIconCoord(3, 5).setItemName("shovelDiamond");
        pickaxeDiamond = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).setIconCoord(3, 6).setItemName("pickaxeDiamond");
        axeDiamond = (new ItemAxe(23, EnumToolMaterial.EMERALD)).setIconCoord(3, 7).setItemName("hatchetDiamond");
        stick = (new Item(24)).setIconCoord(5, 3).setFull3D().setItemName("stick");
        bowlEmpty = (new Item(25)).setIconCoord(7, 4).setItemName("bowl");
        bowlSoup = (new ItemSoup(26, 10)).setIconCoord(8, 4).setItemName("mushroomStew");
        swordGold = (new ItemSword(27, EnumToolMaterial.GOLD)).setIconCoord(4, 4).setItemName("swordGold");
        shovelGold = (new ItemSpade(28, EnumToolMaterial.GOLD)).setIconCoord(4, 5).setItemName("shovelGold");
        pickaxeGold = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).setIconCoord(4, 6).setItemName("pickaxeGold");
        axeGold = (new ItemAxe(30, EnumToolMaterial.GOLD)).setIconCoord(4, 7).setItemName("hatchetGold");
        silk = (new Item(31)).setIconCoord(8, 0).setItemName("string");
        feather = (new Item(32)).setIconCoord(8, 1).setItemName("feather");
        gunpowder = (new Item(33)).setIconCoord(8, 2).setItemName("sulphur");
        hoeWood = (new ItemHoe(34, EnumToolMaterial.WOOD)).setIconCoord(0, 8).setItemName("hoeWood");
        hoeStone = (new ItemHoe(35, EnumToolMaterial.STONE)).setIconCoord(1, 8).setItemName("hoeStone");
        hoeSteel = (new ItemHoe(36, EnumToolMaterial.IRON)).setIconCoord(2, 8).setItemName("hoeIron");
        hoeDiamond = (new ItemHoe(37, EnumToolMaterial.EMERALD)).setIconCoord(3, 8).setItemName("hoeDiamond");
        hoeGold = (new ItemHoe(38, EnumToolMaterial.GOLD)).setIconCoord(4, 8).setItemName("hoeGold");
        seeds = (new ItemSeeds(39, Block.crops.blockID)).setIconCoord(9, 0).setItemName("seeds");
        wheat = (new Item(40)).setIconCoord(9, 1).setItemName("wheat");
        bread = (new ItemFood(41, 5, false)).setIconCoord(9, 2).setItemName("bread");
        helmetLeather = (new ItemArmor(42, 0, 0, 0)).setIconCoord(0, 0).setItemName("helmetCloth");
        plateLeather = (new ItemArmor(43, 0, 0, 1)).setIconCoord(0, 1).setItemName("chestplateCloth");
        legsLeather = (new ItemArmor(44, 0, 0, 2)).setIconCoord(0, 2).setItemName("leggingsCloth");
        bootsLeather = (new ItemArmor(45, 0, 0, 3)).setIconCoord(0, 3).setItemName("bootsCloth");
        helmetChain = (new ItemArmor(46, 1, 1, 0)).setIconCoord(1, 0).setItemName("helmetChain");
        plateChain = (new ItemArmor(47, 1, 1, 1)).setIconCoord(1, 1).setItemName("chestplateChain");
        legsChain = (new ItemArmor(48, 1, 1, 2)).setIconCoord(1, 2).setItemName("leggingsChain");
        bootsChain = (new ItemArmor(49, 1, 1, 3)).setIconCoord(1, 3).setItemName("bootsChain");
        helmetSteel = (new ItemArmor(50, 2, 2, 0)).setIconCoord(2, 0).setItemName("helmetIron");
        plateSteel = (new ItemArmor(51, 2, 2, 1)).setIconCoord(2, 1).setItemName("chestplateIron");
        legsSteel = (new ItemArmor(52, 2, 2, 2)).setIconCoord(2, 2).setItemName("leggingsIron");
        bootsSteel = (new ItemArmor(53, 2, 2, 3)).setIconCoord(2, 3).setItemName("bootsIron");
        helmetDiamond = (new ItemArmor(54, 3, 3, 0)).setIconCoord(3, 0).setItemName("helmetDiamond");
        plateDiamond = (new ItemArmor(55, 3, 3, 1)).setIconCoord(3, 1).setItemName("chestplateDiamond");
        legsDiamond = (new ItemArmor(56, 3, 3, 2)).setIconCoord(3, 2).setItemName("leggingsDiamond");
        bootsDiamond = (new ItemArmor(57, 3, 3, 3)).setIconCoord(3, 3).setItemName("bootsDiamond");
        helmetGold = (new ItemArmor(58, 1, 4, 0)).setIconCoord(4, 0).setItemName("helmetGold");
        plateGold = (new ItemArmor(59, 1, 4, 1)).setIconCoord(4, 1).setItemName("chestplateGold");
        legsGold = (new ItemArmor(60, 1, 4, 2)).setIconCoord(4, 2).setItemName("leggingsGold");
        bootsGold = (new ItemArmor(61, 1, 4, 3)).setIconCoord(4, 3).setItemName("bootsGold");
        flint = (new Item(62)).setIconCoord(6, 0).setItemName("flint");
        porkRaw = (new ItemFood(63, 3, true)).setIconCoord(7, 5).setItemName("porkchopRaw");
        porkCooked = (new ItemFood(64, 8, true)).setIconCoord(8, 5).setItemName("porkchopCooked");
        painting = (new ItemPainting(65)).setIconCoord(10, 1).setItemName("painting");
        appleGold = (new ItemFood(66, 42, false)).setIconCoord(11, 0).setItemName("appleGold");
        sign = (new ItemSign(67)).setIconCoord(10, 2).setItemName("sign");
        doorWood = (new ItemDoor(68, Material.wood)).setIconCoord(11, 2).setItemName("doorWood");
        bucketEmpty = (new ItemBucket(69, 0)).setIconCoord(10, 4).setItemName("bucket");
        bucketWater = (new ItemBucket(70, Block.waterMoving.blockID)).setIconCoord(11, 4).setItemName("bucketWater").setContainerItem(bucketEmpty);
        bucketLava = (new ItemBucket(71, Block.lavaMoving.blockID)).setIconCoord(12, 4).setItemName("bucketLava").setContainerItem(bucketEmpty);
        minecartEmpty = (new ItemMinecart(72, 0)).setIconCoord(7, 8).setItemName("minecart");
        saddle = (new ItemSaddle(73)).setIconCoord(8, 6).setItemName("saddle");
        doorSteel = (new ItemDoor(74, Material.iron)).setIconCoord(12, 2).setItemName("doorIron");
        redstone = (new ItemRedstone(75)).setIconCoord(8, 3).setItemName("redstone");
        snowball = (new ItemSnowball(76)).setIconCoord(14, 0).setItemName("snowball");
        boat = (new ItemBoat(77)).setIconCoord(8, 8).setItemName("boat");
        leather = (new Item(78)).setIconCoord(7, 6).setItemName("leather");
        bucketMilk = (new ItemBucket(79, -1)).setIconCoord(13, 4).setItemName("milk").setContainerItem(bucketEmpty);
        brick = (new Item(80)).setIconCoord(6, 1).setItemName("brick");
        clay = (new Item(81)).setIconCoord(9, 3).setItemName("clay");
        reed = (new ItemReed(82, Block.reed)).setIconCoord(11, 1).setItemName("reeds");
        paper = (new Item(83)).setIconCoord(10, 3).setItemName("paper");
        book = (new Item(84)).setIconCoord(11, 3).setItemName("book");
        slimeBall = (new Item(85)).setIconCoord(14, 1).setItemName("slimeball");
        minecartCrate = (new ItemMinecart(86, 1)).setIconCoord(7, 9).setItemName("minecartChest");
        minecartPowered = (new ItemMinecart(87, 2)).setIconCoord(7, 10).setItemName("minecartFurnace");
        egg = (new ItemEgg(88)).setIconCoord(12, 0).setItemName("egg");
        compass = (new Item(89)).setIconCoord(6, 3).setItemName("compass");
        fishingRod = (new ItemFishingRod(90)).setIconCoord(5, 4).setItemName("fishingRod");
        pocketSundial = (new Item(91)).setIconCoord(6, 4).setItemName("clock");
        lightStoneDust = (new Item(92)).setIconCoord(9, 4).setItemName("yellowDust");
        fishRaw = (new ItemFood(93, 2, false)).setIconCoord(9, 5).setItemName("fishRaw");
        fishCooked = (new ItemFood(94, 5, false)).setIconCoord(10, 5).setItemName("fishCooked");
        dyePowder = (new ItemDye(95)).setIconCoord(14, 4).setItemName("dyePowder");
        bone = (new Item(96)).setIconCoord(12, 1).setItemName("bone").setFull3D();
        sugar = (new Item(97)).setIconCoord(13, 0).setItemName("sugar").setFull3D();
        cake = (new ItemReed(98, Block.cake)).setMaxStackSize(1).setIconCoord(13, 1).setItemName("cake");
        bed = (new ItemBed(99)).setMaxStackSize(1).setIconCoord(13, 2).setItemName("bed");
        redstoneRepeater = (new ItemReed(100, Block.redstoneRepeaterIdle)).setIconCoord(6, 5).setItemName("diode");
        cookie = (new ItemCookie(101, 1, false, 8)).setIconCoord(12, 5).setItemName("cookie");
        mapItem = (ItemMap)(new ItemMap(102)).setIconCoord(12, 3).setItemName("map");
        shears = (ItemShears)(new ItemShears(103)).setIconCoord(13, 5).setItemName("shears");
        record13 = (new ItemRecord(2000, "13")).setIconCoord(0, 15).setItemName("record");
        recordCat = (new ItemRecord(2001, "cat")).setIconCoord(1, 15).setItemName("record");
        StatList.initStats();
    }
}
