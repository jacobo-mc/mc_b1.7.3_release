package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class Block {
    public static final StepSound soundPowderFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundWoodFootstep = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound soundGravelFootstep = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundMetalFootstep = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound soundGlassFootstep = new StepSoundStone("stone", 1.0F, 1.0F);
    public static final StepSound soundClothFootstep = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound soundSandFootstep = new StepSoundSand("sand", 1.0F, 1.0F);
    public static final Block[] blocksList = new Block[256];
    public static final boolean[] tickOnLoad = new boolean[256];
    public static final boolean[] opaqueCubeLookup = new boolean[256];
    public static final boolean[] isBlockContainer = new boolean[256];
    public static final int[] lightOpacity = new int[256];
    public static final boolean[] canBlockGrass = new boolean[256];
    public static final int[] lightValue = new int[256];
    public static final boolean[] requiresSelfNotify = new boolean[256];
    public static final Block stone;
    public static final BlockGrass grass;
    public static final Block dirt;
    public static final Block cobblestone;
    public static final Block planks;
    public static final Block sapling;
    public static final Block bedrock;
    public static final Block waterMoving;
    public static final Block waterStill;
    public static final Block lavaMoving;
    public static final Block lavaStill;
    public static final Block sand;
    public static final Block gravel;
    public static final Block oreGold;
    public static final Block oreIron;
    public static final Block oreCoal;
    public static final Block wood;
    public static final BlockLeaves leaves;
    public static final Block sponge;
    public static final Block glass;
    public static final Block oreLapis;
    public static final Block blockLapis;
    public static final Block dispenser;
    public static final Block sandStone;
    public static final Block musicBlock;
    public static final Block bed;
    public static final Block railPowered;
    public static final Block railDetector;
    public static final Block pistonStickyBase;
    public static final Block web;
    public static final BlockTallGrass tallGrass;
    public static final BlockDeadBush deadBush;
    public static final Block pistonBase;
    public static final BlockPistonExtension pistonExtension;
    public static final Block cloth;
    public static final BlockPistonMoving pistonMoving;
    public static final BlockFlower plantYellow;
    public static final BlockFlower plantRed;
    public static final BlockFlower mushroomBrown;
    public static final BlockFlower mushroomRed;
    public static final Block blockGold;
    public static final Block blockSteel;
    public static final Block stairDouble;
    public static final Block stairSingle;
    public static final Block brick;
    public static final Block tnt;
    public static final Block bookShelf;
    public static final Block cobblestoneMossy;
    public static final Block obsidian;
    public static final Block torchWood;
    public static final BlockFire fire;
    public static final Block mobSpawner;
    public static final Block stairCompactPlanks;
    public static final Block chest;
    public static final Block redstoneWire;
    public static final Block oreDiamond;
    public static final Block blockDiamond;
    public static final Block workbench;
    public static final Block crops;
    public static final Block tilledField;
    public static final Block stoneOvenIdle;
    public static final Block stoneOvenActive;
    public static final Block signPost;
    public static final Block doorWood;
    public static final Block ladder;
    public static final Block minecartTrack;
    public static final Block stairCompactCobblestone;
    public static final Block signWall;
    public static final Block lever;
    public static final Block pressurePlateStone;
    public static final Block doorSteel;
    public static final Block pressurePlatePlanks;
    public static final Block oreRedstone;
    public static final Block oreRedstoneGlowing;
    public static final Block torchRedstoneIdle;
    public static final Block torchRedstoneActive;
    public static final Block button;
    public static final Block snow;
    public static final Block ice;
    public static final Block blockSnow;
    public static final Block cactus;
    public static final Block blockClay;
    public static final Block reed;
    public static final Block jukebox;
    public static final Block fence;
    public static final Block pumpkin;
    public static final Block bloodStone;
    public static final Block slowSand;
    public static final Block glowStone;
    public static final BlockPortal portal;
    public static final Block pumpkinLantern;
    public static final Block cake;
    public static final Block redstoneRepeaterIdle;
    public static final Block redstoneRepeaterActive;
    public static final Block lockedChest;
    public static final Block trapdoor;
    public int blockIndexInTexture;
    public final int blockID;
    protected float blockHardness;
    protected float blockResistance;
    protected boolean blockConstructorCalled;
    protected boolean enableStats;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;
    public StepSound stepSound;
    public float blockParticleGravity;
    public final Material blockMaterial;
    public float slipperiness;
    private String blockName;

    protected Block(int var1, Material var2) {
        this.blockConstructorCalled = true;
        this.enableStats = true;
        this.stepSound = soundPowderFootstep;
        this.blockParticleGravity = 1.0F;
        this.slipperiness = 0.6F;
        if (blocksList[var1] != null) {
            throw new IllegalArgumentException("Slot " + var1 + " is already occupied by " + blocksList[var1] + " when adding " + this);
        } else {
            this.blockMaterial = var2;
            blocksList[var1] = this;
            this.blockID = var1;
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            opaqueCubeLookup[var1] = this.isOpaqueCube();
            lightOpacity[var1] = this.isOpaqueCube() ? 255 : 0;
            canBlockGrass[var1] = !var2.getCanBlockGrass();
            isBlockContainer[var1] = false;
        }
    }

    protected Block setRequiresSelfNotify() {
        requiresSelfNotify[this.blockID] = true;
        return this;
    }

    protected void setFireBurnRates() {
    }

    protected Block(int var1, int var2, Material var3) {
        this(var1, var3);
        this.blockIndexInTexture = var2;
    }

    protected Block setStepSound(StepSound var1) {
        this.stepSound = var1;
        return this;
    }

    protected Block setLightOpacity(int var1) {
        lightOpacity[this.blockID] = var1;
        return this;
    }

    protected Block setLightValue(float var1) {
        lightValue[this.blockID] = (int)(15.0F * var1);
        return this;
    }

    protected Block setResistance(float var1) {
        this.blockResistance = var1 * 3.0F;
        return this;
    }

    public boolean isACube() {
        return true;
    }

    protected Block setHardness(float var1) {
        this.blockHardness = var1;
        if (this.blockResistance < var1 * 5.0F) {
            this.blockResistance = var1 * 5.0F;
        }

        return this;
    }

    protected Block setBlockUnbreakable() {
        this.setHardness(-1.0F);
        return this;
    }

    public float getHardness() {
        return this.blockHardness;
    }

    protected Block setTickOnLoad(boolean var1) {
        tickOnLoad[this.blockID] = var1;
        return this;
    }

    public void setBlockBounds(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.minX = (double)var1;
        this.minY = (double)var2;
        this.minZ = (double)var3;
        this.maxX = (double)var4;
        this.maxY = (double)var5;
        this.maxZ = (double)var6;
    }

    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var1.getBlockMaterial(var2, var3, var4).isSolid();
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        return this.getBlockTextureFromSide(var1);
    }

    public int getBlockTextureFromSide(int var1) {
        return this.blockIndexInTexture;
    }

    public void getCollidingBoundingBoxes(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        AxisAlignedBB var7 = this.getCollisionBoundingBoxFromPool(var1, var2, var3, var4);
        if (var7 != null && var5.intersectsWith(var7)) {
            var6.add(var7);
        }

    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.getBoundingBoxFromPool((double)var2 + this.minX, (double)var3 + this.minY, (double)var4 + this.minZ, (double)var2 + this.maxX, (double)var3 + this.maxY, (double)var4 + this.maxZ);
    }

    public boolean isOpaqueCube() {
        return true;
    }

    public boolean canCollideCheck(int var1, boolean var2) {
        return this.isCollidable();
    }

    public boolean isCollidable() {
        return true;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
    }

    public void onBlockDestroyedByPlayer(World var1, int var2, int var3, int var4, int var5) {
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
    }

    public int tickRate() {
        return 10;
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
    }

    public int quantityDropped(Random var1) {
        return 1;
    }

    public int idDropped(int var1, Random var2) {
        return this.blockID;
    }

    public float blockStrength(EntityPlayer var1) {
        if (this.blockHardness < 0.0F) {
            return 0.0F;
        } else {
            return !var1.canHarvestBlock(this) ? 1.0F / this.blockHardness / 100.0F : var1.getCurrentPlayerStrVsBlock(this) / this.blockHardness / 30.0F;
        }
    }

    public final void dropBlockAsItem(World var1, int var2, int var3, int var4, int var5) {
        this.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, 1.0F);
    }

    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.singleplayerWorld) {
            int var7 = this.quantityDropped(var1.rand);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var1.rand.nextFloat() <= var6) {
                    int var9 = this.idDropped(var5, var1.rand);
                    if (var9 > 0) {
                        this.dropBlockAsItem_do(var1, var2, var3, var4, new ItemStack(var9, 1, this.damageDropped(var5)));
                    }
                }
            }

        }
    }

    protected void dropBlockAsItem_do(World var1, int var2, int var3, int var4, ItemStack var5) {
        if (!var1.singleplayerWorld) {
            float var6 = 0.7F;
            double var7 = (double)(var1.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var9 = (double)(var1.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var11 = (double)(var1.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            EntityItem var13 = new EntityItem(var1, (double)var2 + var7, (double)var3 + var9, (double)var4 + var11, var5);
            var13.delayBeforeCanPickup = 10;
            var1.entityJoinedWorld(var13);
        }
    }

    protected int damageDropped(int var1) {
        return 0;
    }

    public float getExplosionResistance(Entity var1) {
        return this.blockResistance / 5.0F;
    }

    public MovingObjectPosition collisionRayTrace(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.setBlockBoundsBasedOnState(var1, var2, var3, var4);
        var5 = var5.addVector((double)(-var2), (double)(-var3), (double)(-var4));
        var6 = var6.addVector((double)(-var2), (double)(-var3), (double)(-var4));
        Vec3D var7 = var5.getIntermediateWithXValue(var6, this.minX);
        Vec3D var8 = var5.getIntermediateWithXValue(var6, this.maxX);
        Vec3D var9 = var5.getIntermediateWithYValue(var6, this.minY);
        Vec3D var10 = var5.getIntermediateWithYValue(var6, this.maxY);
        Vec3D var11 = var5.getIntermediateWithZValue(var6, this.minZ);
        Vec3D var12 = var5.getIntermediateWithZValue(var6, this.maxZ);
        if (!this.isVecInsideYZBounds(var7)) {
            var7 = null;
        }

        if (!this.isVecInsideYZBounds(var8)) {
            var8 = null;
        }

        if (!this.isVecInsideXZBounds(var9)) {
            var9 = null;
        }

        if (!this.isVecInsideXZBounds(var10)) {
            var10 = null;
        }

        if (!this.isVecInsideXYBounds(var11)) {
            var11 = null;
        }

        if (!this.isVecInsideXYBounds(var12)) {
            var12 = null;
        }

        Vec3D var13 = null;
        if (var7 != null && (var13 == null || var5.distanceTo(var7) < var5.distanceTo(var13))) {
            var13 = var7;
        }

        if (var8 != null && (var13 == null || var5.distanceTo(var8) < var5.distanceTo(var13))) {
            var13 = var8;
        }

        if (var9 != null && (var13 == null || var5.distanceTo(var9) < var5.distanceTo(var13))) {
            var13 = var9;
        }

        if (var10 != null && (var13 == null || var5.distanceTo(var10) < var5.distanceTo(var13))) {
            var13 = var10;
        }

        if (var11 != null && (var13 == null || var5.distanceTo(var11) < var5.distanceTo(var13))) {
            var13 = var11;
        }

        if (var12 != null && (var13 == null || var5.distanceTo(var12) < var5.distanceTo(var13))) {
            var13 = var12;
        }

        if (var13 == null) {
            return null;
        } else {
            byte var14 = -1;
            if (var13 == var7) {
                var14 = 4;
            }

            if (var13 == var8) {
                var14 = 5;
            }

            if (var13 == var9) {
                var14 = 0;
            }

            if (var13 == var10) {
                var14 = 1;
            }

            if (var13 == var11) {
                var14 = 2;
            }

            if (var13 == var12) {
                var14 = 3;
            }

            return new MovingObjectPosition(var2, var3, var4, var14, var13.addVector((double)var2, (double)var3, (double)var4));
        }
    }

    private boolean isVecInsideYZBounds(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.yCoord >= this.minY && var1.yCoord <= this.maxY && var1.zCoord >= this.minZ && var1.zCoord <= this.maxZ;
        }
    }

    private boolean isVecInsideXZBounds(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.xCoord >= this.minX && var1.xCoord <= this.maxX && var1.zCoord >= this.minZ && var1.zCoord <= this.maxZ;
        }
    }

    private boolean isVecInsideXYBounds(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.xCoord >= this.minX && var1.xCoord <= this.maxX && var1.yCoord >= this.minY && var1.yCoord <= this.maxY;
        }
    }

    public void onBlockDestroyedByExplosion(World var1, int var2, int var3, int var4) {
    }

    public boolean canPlaceBlockOnSide(World var1, int var2, int var3, int var4, int var5) {
        return this.canPlaceBlockAt(var1, var2, var3, var4);
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockId(var2, var3, var4);
        return var5 == 0 || blocksList[var5].blockMaterial.func_27090_g();
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return false;
    }

    public void onEntityWalking(World var1, int var2, int var3, int var4, Entity var5) {
    }

    public void onBlockPlaced(World var1, int var2, int var3, int var4, int var5) {
    }

    public void onBlockClicked(World var1, int var2, int var3, int var4, EntityPlayer var5) {
    }

    public void velocityToAddToEntity(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
    }

    public boolean isPoweringTo(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public boolean canProvidePower() {
        return false;
    }

    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
    }

    public boolean isIndirectlyPoweringTo(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public void harvestBlock(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        var2.addStat(StatList.mineBlockStatArray[this.blockID], 1);
        this.dropBlockAsItem(var1, var3, var4, var5, var6);
    }

    public boolean canBlockStay(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5) {
    }

    public Block setBlockName(String var1) {
        this.blockName = "tile." + var1;
        return this;
    }

    public String getNameLocalizedForStats() {
        return StatCollector.translateToLocal(this.getBlockName() + ".name");
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void playBlock(World var1, int var2, int var3, int var4, int var5, int var6) {
    }

    public boolean getEnableStats() {
        return this.enableStats;
    }

    protected Block disableStats() {
        this.enableStats = false;
        return this;
    }

    public int getMobilityFlag() {
        return this.blockMaterial.getMaterialMobility();
    }

    static {
        stone = (new BlockStone(1, 1)).setHardness(1.5F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("stone");
        grass = (BlockGrass)(new BlockGrass(2)).setHardness(0.6F).setStepSound(soundGrassFootstep).setBlockName("grass");
        dirt = (new BlockDirt(3, 2)).setHardness(0.5F).setStepSound(soundGravelFootstep).setBlockName("dirt");
        cobblestone = (new Block(4, 16, Material.rock)).setHardness(2.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("stonebrick");
        planks = (new Block(5, 4, Material.wood)).setHardness(2.0F).setResistance(5.0F).setStepSound(soundWoodFootstep).setBlockName("wood").setRequiresSelfNotify();
        sapling = (new BlockSapling(6, 15)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("sapling").setRequiresSelfNotify();
        bedrock = (new Block(7, 17, Material.rock)).setBlockUnbreakable().setResistance(6000000.0F).setStepSound(soundStoneFootstep).setBlockName("bedrock").disableStats();
        waterMoving = (new BlockFlowing(8, Material.water)).setHardness(100.0F).setLightOpacity(3).setBlockName("water").disableStats().setRequiresSelfNotify();
        waterStill = (new BlockStationary(9, Material.water)).setHardness(100.0F).setLightOpacity(3).setBlockName("water").disableStats().setRequiresSelfNotify();
        lavaMoving = (new BlockFlowing(10, Material.lava)).setHardness(0.0F).setLightValue(1.0F).setLightOpacity(255).setBlockName("lava").disableStats().setRequiresSelfNotify();
        lavaStill = (new BlockStationary(11, Material.lava)).setHardness(100.0F).setLightValue(1.0F).setLightOpacity(255).setBlockName("lava").disableStats().setRequiresSelfNotify();
        sand = (new BlockSand(12, 18)).setHardness(0.5F).setStepSound(soundSandFootstep).setBlockName("sand");
        gravel = (new BlockGravel(13, 19)).setHardness(0.6F).setStepSound(soundGravelFootstep).setBlockName("gravel");
        oreGold = (new BlockOre(14, 32)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreGold");
        oreIron = (new BlockOre(15, 33)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreIron");
        oreCoal = (new BlockOre(16, 34)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreCoal");
        wood = (new BlockLog(17)).setHardness(2.0F).setStepSound(soundWoodFootstep).setBlockName("log").setRequiresSelfNotify();
        leaves = (BlockLeaves)(new BlockLeaves(18, 52)).setHardness(0.2F).setLightOpacity(1).setStepSound(soundGrassFootstep).setBlockName("leaves").disableStats().setRequiresSelfNotify();
        sponge = (new BlockSponge(19)).setHardness(0.6F).setStepSound(soundGrassFootstep).setBlockName("sponge");
        glass = (new BlockGlass(20, 49, Material.glass, false)).setHardness(0.3F).setStepSound(soundGlassFootstep).setBlockName("glass");
        oreLapis = (new BlockOre(21, 160)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreLapis");
        blockLapis = (new Block(22, 144, Material.rock)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("blockLapis");
        dispenser = (new BlockDispenser(23)).setHardness(3.5F).setStepSound(soundStoneFootstep).setBlockName("dispenser").setRequiresSelfNotify();
        sandStone = (new BlockSandStone(24)).setStepSound(soundStoneFootstep).setHardness(0.8F).setBlockName("sandStone");
        musicBlock = (new BlockNote(25)).setHardness(0.8F).setBlockName("musicBlock").setRequiresSelfNotify();
        bed = (new BlockBed(26)).setHardness(0.2F).setBlockName("bed").disableStats().setRequiresSelfNotify();
        railPowered = (new BlockRail(27, 179, true)).setHardness(0.7F).setStepSound(soundMetalFootstep).setBlockName("goldenRail").setRequiresSelfNotify();
        railDetector = (new BlockDetectorRail(28, 195)).setHardness(0.7F).setStepSound(soundMetalFootstep).setBlockName("detectorRail").setRequiresSelfNotify();
        pistonStickyBase = (new BlockPistonBase(29, 106, true)).setBlockName("pistonStickyBase").setRequiresSelfNotify();
        web = (new BlockWeb(30, 11)).setLightOpacity(1).setHardness(4.0F).setBlockName("web");
        tallGrass = (BlockTallGrass)(new BlockTallGrass(31, 39)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("tallgrass");
        deadBush = (BlockDeadBush)(new BlockDeadBush(32, 55)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("deadbush");
        pistonBase = (new BlockPistonBase(33, 107, false)).setBlockName("pistonBase").setRequiresSelfNotify();
        pistonExtension = (BlockPistonExtension)(new BlockPistonExtension(34, 107)).setRequiresSelfNotify();
        cloth = (new BlockCloth()).setHardness(0.8F).setStepSound(soundClothFootstep).setBlockName("cloth").setRequiresSelfNotify();
        pistonMoving = new BlockPistonMoving(36);
        plantYellow = (BlockFlower)(new BlockFlower(37, 13)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("flower");
        plantRed = (BlockFlower)(new BlockFlower(38, 12)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("rose");
        mushroomBrown = (BlockFlower)(new BlockMushroom(39, 29)).setHardness(0.0F).setStepSound(soundGrassFootstep).setLightValue(0.125F).setBlockName("mushroom");
        mushroomRed = (BlockFlower)(new BlockMushroom(40, 28)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("mushroom");
        blockGold = (new BlockOreStorage(41, 23)).setHardness(3.0F).setResistance(10.0F).setStepSound(soundMetalFootstep).setBlockName("blockGold");
        blockSteel = (new BlockOreStorage(42, 22)).setHardness(5.0F).setResistance(10.0F).setStepSound(soundMetalFootstep).setBlockName("blockIron");
        stairDouble = (new BlockStep(43, true)).setHardness(2.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("stoneSlab");
        stairSingle = (new BlockStep(44, false)).setHardness(2.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("stoneSlab");
        brick = (new Block(45, 7, Material.rock)).setHardness(2.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("brick");
        tnt = (new BlockTNT(46, 8)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("tnt");
        bookShelf = (new BlockBookshelf(47, 35)).setHardness(1.5F).setStepSound(soundWoodFootstep).setBlockName("bookshelf");
        cobblestoneMossy = (new Block(48, 36, Material.rock)).setHardness(2.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("stoneMoss");
        obsidian = (new BlockObsidian(49, 37)).setHardness(10.0F).setResistance(2000.0F).setStepSound(soundStoneFootstep).setBlockName("obsidian");
        torchWood = (new BlockTorch(50, 80)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(soundWoodFootstep).setBlockName("torch").setRequiresSelfNotify();
        fire = (BlockFire)(new BlockFire(51, 31)).setHardness(0.0F).setLightValue(1.0F).setStepSound(soundWoodFootstep).setBlockName("fire").disableStats().setRequiresSelfNotify();
        mobSpawner = (new BlockMobSpawner(52, 65)).setHardness(5.0F).setStepSound(soundMetalFootstep).setBlockName("mobSpawner").disableStats();
        stairCompactPlanks = (new BlockStairs(53, planks)).setBlockName("stairsWood").setRequiresSelfNotify();
        chest = (new BlockChest(54)).setHardness(2.5F).setStepSound(soundWoodFootstep).setBlockName("chest").setRequiresSelfNotify();
        redstoneWire = (new BlockRedstoneWire(55, 164)).setHardness(0.0F).setStepSound(soundPowderFootstep).setBlockName("redstoneDust").disableStats().setRequiresSelfNotify();
        oreDiamond = (new BlockOre(56, 50)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreDiamond");
        blockDiamond = (new BlockOreStorage(57, 24)).setHardness(5.0F).setResistance(10.0F).setStepSound(soundMetalFootstep).setBlockName("blockDiamond");
        workbench = (new BlockWorkbench(58)).setHardness(2.5F).setStepSound(soundWoodFootstep).setBlockName("workbench");
        crops = (new BlockCrops(59, 88)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("crops").disableStats().setRequiresSelfNotify();
        tilledField = (new BlockFarmland(60)).setHardness(0.6F).setStepSound(soundGravelFootstep).setBlockName("farmland");
        stoneOvenIdle = (new BlockFurnace(61, false)).setHardness(3.5F).setStepSound(soundStoneFootstep).setBlockName("furnace").setRequiresSelfNotify();
        stoneOvenActive = (new BlockFurnace(62, true)).setHardness(3.5F).setStepSound(soundStoneFootstep).setLightValue(0.875F).setBlockName("furnace").setRequiresSelfNotify();
        signPost = (new BlockSign(63, TileEntitySign.class, true)).setHardness(1.0F).setStepSound(soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();
        doorWood = (new BlockDoor(64, Material.wood)).setHardness(3.0F).setStepSound(soundWoodFootstep).setBlockName("doorWood").disableStats().setRequiresSelfNotify();
        ladder = (new BlockLadder(65, 83)).setHardness(0.4F).setStepSound(soundWoodFootstep).setBlockName("ladder").setRequiresSelfNotify();
        minecartTrack = (new BlockRail(66, 128, false)).setHardness(0.7F).setStepSound(soundMetalFootstep).setBlockName("rail").setRequiresSelfNotify();
        stairCompactCobblestone = (new BlockStairs(67, cobblestone)).setBlockName("stairsStone").setRequiresSelfNotify();
        signWall = (new BlockSign(68, TileEntitySign.class, false)).setHardness(1.0F).setStepSound(soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();
        lever = (new BlockLever(69, 96)).setHardness(0.5F).setStepSound(soundWoodFootstep).setBlockName("lever").setRequiresSelfNotify();
        pressurePlateStone = (new BlockPressurePlate(70, stone.blockIndexInTexture, EnumMobType.mobs, Material.rock)).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("pressurePlate").setRequiresSelfNotify();
        doorSteel = (new BlockDoor(71, Material.iron)).setHardness(5.0F).setStepSound(soundMetalFootstep).setBlockName("doorIron").disableStats().setRequiresSelfNotify();
        pressurePlatePlanks = (new BlockPressurePlate(72, planks.blockIndexInTexture, EnumMobType.everything, Material.wood)).setHardness(0.5F).setStepSound(soundWoodFootstep).setBlockName("pressurePlate").setRequiresSelfNotify();
        oreRedstone = (new BlockRedstoneOre(73, 51, false)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreRedstone").setRequiresSelfNotify();
        oreRedstoneGlowing = (new BlockRedstoneOre(74, 51, true)).setLightValue(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep).setBlockName("oreRedstone").setRequiresSelfNotify();
        torchRedstoneIdle = (new BlockRedstoneTorch(75, 115, false)).setHardness(0.0F).setStepSound(soundWoodFootstep).setBlockName("notGate").setRequiresSelfNotify();
        torchRedstoneActive = (new BlockRedstoneTorch(76, 99, true)).setHardness(0.0F).setLightValue(0.5F).setStepSound(soundWoodFootstep).setBlockName("notGate").setRequiresSelfNotify();
        button = (new BlockButton(77, stone.blockIndexInTexture)).setHardness(0.5F).setStepSound(soundStoneFootstep).setBlockName("button").setRequiresSelfNotify();
        snow = (new BlockSnow(78, 66)).setHardness(0.1F).setStepSound(soundClothFootstep).setBlockName("snow");
        ice = (new BlockIce(79, 67)).setHardness(0.5F).setLightOpacity(3).setStepSound(soundGlassFootstep).setBlockName("ice");
        blockSnow = (new BlockSnowBlock(80, 66)).setHardness(0.2F).setStepSound(soundClothFootstep).setBlockName("snow");
        cactus = (new BlockCactus(81, 70)).setHardness(0.4F).setStepSound(soundClothFootstep).setBlockName("cactus");
        blockClay = (new BlockClay(82, 72)).setHardness(0.6F).setStepSound(soundGravelFootstep).setBlockName("clay");
        reed = (new BlockReed(83, 73)).setHardness(0.0F).setStepSound(soundGrassFootstep).setBlockName("reeds").disableStats();
        jukebox = (new BlockJukeBox(84, 74)).setHardness(2.0F).setResistance(10.0F).setStepSound(soundStoneFootstep).setBlockName("jukebox").setRequiresSelfNotify();
        fence = (new BlockFence(85, 4)).setHardness(2.0F).setResistance(5.0F).setStepSound(soundWoodFootstep).setBlockName("fence").setRequiresSelfNotify();
        pumpkin = (new BlockPumpkin(86, 102, false)).setHardness(1.0F).setStepSound(soundWoodFootstep).setBlockName("pumpkin").setRequiresSelfNotify();
        bloodStone = (new BlockNetherrack(87, 103)).setHardness(0.4F).setStepSound(soundStoneFootstep).setBlockName("hellrock");
        slowSand = (new BlockSoulSand(88, 104)).setHardness(0.5F).setStepSound(soundSandFootstep).setBlockName("hellsand");
        glowStone = (new BlockGlowStone(89, 105, Material.rock)).setHardness(0.3F).setStepSound(soundGlassFootstep).setLightValue(1.0F).setBlockName("lightgem");
        portal = (BlockPortal)(new BlockPortal(90, 14)).setHardness(-1.0F).setStepSound(soundGlassFootstep).setLightValue(0.75F).setBlockName("portal");
        pumpkinLantern = (new BlockPumpkin(91, 102, true)).setHardness(1.0F).setStepSound(soundWoodFootstep).setLightValue(1.0F).setBlockName("litpumpkin").setRequiresSelfNotify();
        cake = (new BlockCake(92, 121)).setHardness(0.5F).setStepSound(soundClothFootstep).setBlockName("cake").disableStats().setRequiresSelfNotify();
        redstoneRepeaterIdle = (new BlockRedstoneRepeater(93, false)).setHardness(0.0F).setStepSound(soundWoodFootstep).setBlockName("diode").disableStats().setRequiresSelfNotify();
        redstoneRepeaterActive = (new BlockRedstoneRepeater(94, true)).setHardness(0.0F).setLightValue(0.625F).setStepSound(soundWoodFootstep).setBlockName("diode").disableStats().setRequiresSelfNotify();
        lockedChest = (new BlockLockedChest(95)).setHardness(0.0F).setLightValue(1.0F).setStepSound(soundWoodFootstep).setBlockName("lockedchest").setTickOnLoad(true).setRequiresSelfNotify();
        trapdoor = (new BlockTrapDoor(96, Material.wood)).setHardness(3.0F).setStepSound(soundWoodFootstep).setBlockName("trapdoor").disableStats().setRequiresSelfNotify();
        Item.itemsList[cloth.blockID] = (new ItemCloth(cloth.blockID - 256)).setItemName("cloth");
        Item.itemsList[wood.blockID] = (new ItemLog(wood.blockID - 256)).setItemName("log");
        Item.itemsList[stairSingle.blockID] = (new ItemSlab(stairSingle.blockID - 256)).setItemName("stoneSlab");
        Item.itemsList[sapling.blockID] = (new ItemSapling(sapling.blockID - 256)).setItemName("sapling");
        Item.itemsList[leaves.blockID] = (new ItemLeaves(leaves.blockID - 256)).setItemName("leaves");
        Item.itemsList[pistonBase.blockID] = new ItemPiston(pistonBase.blockID - 256);
        Item.itemsList[pistonStickyBase.blockID] = new ItemPiston(pistonStickyBase.blockID - 256);

        for(int var0 = 0; var0 < 256; ++var0) {
            if (blocksList[var0] != null && Item.itemsList[var0] == null) {
                Item.itemsList[var0] = new ItemBlock(var0 - 256);
                blocksList[var0].setFireBurnRates();
            }
        }

        canBlockGrass[0] = true;
        StatList.update();
    }
}
