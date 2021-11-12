package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class World implements IBlockAccess {
    public boolean scheduledUpdatesAreImmediate = false;
    private List field_821_y = new ArrayList();
    public List loadedEntityList = new ArrayList();
    private List unloadedEntityList = new ArrayList();
    private TreeSet scheduledTickTreeSet = new TreeSet();
    private Set scheduledTickSet = new HashSet();
    public List loadedTileEntityList = new ArrayList();
    private List field_20912_E = new ArrayList();
    public List playerEntities = new ArrayList();
    public List lightningEntities = new ArrayList();
    private long field_6159_E = 16777215L;
    public int skylightSubtracted = 0;
    protected int distHashCounter = (new Random()).nextInt();
    protected final int DIST_HASH_MAGIC = 1013904223;
    protected float field_27079_B;
    protected float field_27078_C;
    protected float field_27077_D;
    protected float field_27076_E;
    protected int field_27075_F = 0;
    public int field_27080_i = 0;
    public boolean editingBlocks = false;
    private long lockTimestamp = System.currentTimeMillis();
    protected int autosavePeriod = 40;
    public int difficultySetting;
    public Random rand = new Random();
    public boolean isNewWorld = false;
    public final WorldProvider worldProvider;
    protected List worldAccesses = new ArrayList();
    protected IChunkProvider chunkProvider;
    protected final ISaveHandler worldFile;
    protected WorldInfo worldInfo;
    public boolean worldChunkLoadOverride;
    private boolean allPlayersSleeping;
    public MapStorage field_28105_z;
    private ArrayList field_9207_I = new ArrayList();
    private boolean field_31048_L;
    private int field_4265_J = 0;
    private boolean spawnHostileMobs = true;
    private boolean spawnPeacefulMobs = true;
    static int field_4268_y = 0;
    private Set activeChunkSet = new HashSet();
    private int ambientTickCountdown;
    private List field_778_L;
    public boolean singleplayerWorld;

    public WorldChunkManager getWorldChunkManager() {
        return this.worldProvider.worldChunkMgr;
    }

    public World(ISaveHandler var1, String var2, long var3, WorldProvider var5) {
        this.ambientTickCountdown = this.rand.nextInt(12000);
        this.field_778_L = new ArrayList();
        this.singleplayerWorld = false;
        this.worldFile = var1;
        this.field_28105_z = new MapStorage(var1);
        this.worldInfo = var1.func_22096_c();
        this.isNewWorld = this.worldInfo == null;
        if (var5 != null) {
            this.worldProvider = var5;
        } else if (this.worldInfo != null && this.worldInfo.getDimension() == -1) {
            this.worldProvider = WorldProvider.func_4091_a(-1);
        } else {
            this.worldProvider = WorldProvider.func_4091_a(0);
        }

        boolean var6 = false;
        if (this.worldInfo == null) {
            this.worldInfo = new WorldInfo(var3, var2);
            var6 = true;
        } else {
            this.worldInfo.setLevelName(var2);
        }

        this.worldProvider.registerWorld(this);
        this.chunkProvider = this.createChunkProvider();
        if (var6) {
            this.generateSpawnPoint();
        }

        this.calculateInitialSkylight();
        this.func_27070_x();
    }

    protected IChunkProvider createChunkProvider() {
        IChunkLoader var1 = this.worldFile.func_22092_a(this.worldProvider);
        return new ChunkProvider(this, var1, this.worldProvider.getChunkProvider());
    }

    protected void generateSpawnPoint() {
        this.worldChunkLoadOverride = true;
        int var1 = 0;
        byte var2 = 64;

        int var3;
        for(var3 = 0; !this.worldProvider.canCoordinateBeSpawn(var1, var3); var3 += this.rand.nextInt(64) - this.rand.nextInt(64)) {
            var1 += this.rand.nextInt(64) - this.rand.nextInt(64);
        }

        this.worldInfo.setSpawnPosition(var1, var2, var3);
        this.worldChunkLoadOverride = false;
    }

    public int getFirstUncoveredBlock(int var1, int var2) {
        int var3;
        for(var3 = 63; !this.isAirBlock(var1, var3 + 1, var2); ++var3) {
        }

        return this.getBlockId(var1, var3, var2);
    }

    public void saveWorld(boolean var1, IProgressUpdate var2) {
        if (this.chunkProvider.func_364_b()) {
            if (var2 != null) {
                var2.func_438_a("Saving level");
            }

            this.saveLevel();
            if (var2 != null) {
                var2.displayLoadingString("Saving chunks");
            }

            this.chunkProvider.saveChunks(var1, var2);
        }
    }

    private void saveLevel() {
        this.checkSessionLock();
        this.worldFile.func_22095_a(this.worldInfo, this.playerEntities);
        this.field_28105_z.func_28176_a();
    }

    public int getBlockId(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return 0;
            } else {
                return var2 >= 128 ? 0 : this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4).getBlockID(var1 & 15, var2, var3 & 15);
            }
        } else {
            return 0;
        }
    }

    public boolean isAirBlock(int var1, int var2, int var3) {
        return this.getBlockId(var1, var2, var3) == 0;
    }

    public boolean blockExists(int var1, int var2, int var3) {
        return var2 >= 0 && var2 < 128 ? this.chunkExists(var1 >> 4, var3 >> 4) : false;
    }

    public boolean doChunksNearChunkExist(int var1, int var2, int var3, int var4) {
        return this.checkChunksExist(var1 - var4, var2 - var4, var3 - var4, var1 + var4, var2 + var4, var3 + var4);
    }

    public boolean checkChunksExist(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var5 >= 0 && var2 < 128) {
            var1 >>= 4;
            var2 >>= 4;
            var3 >>= 4;
            var4 >>= 4;
            var5 >>= 4;
            var6 >>= 4;

            for(int var7 = var1; var7 <= var4; ++var7) {
                for(int var8 = var3; var8 <= var6; ++var8) {
                    if (!this.chunkExists(var7, var8)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean chunkExists(int var1, int var2) {
        return this.chunkProvider.chunkExists(var1, var2);
    }

    public Chunk getChunkFromBlockCoords(int var1, int var2) {
        return this.getChunkFromChunkCoords(var1 >> 4, var2 >> 4);
    }

    public Chunk getChunkFromChunkCoords(int var1, int var2) {
        return this.chunkProvider.provideChunk(var1, var2);
    }

    public boolean setBlockAndMetadata(int var1, int var2, int var3, int var4, int var5) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var6 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                return var6.setBlockIDWithMetadata(var1 & 15, var2, var3 & 15, var4, var5);
            }
        } else {
            return false;
        }
    }

    public boolean setBlock(int var1, int var2, int var3, int var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var5 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                return var5.setBlockID(var1 & 15, var2, var3 & 15, var4);
            }
        } else {
            return false;
        }
    }

    public Material getBlockMaterial(int var1, int var2, int var3) {
        int var4 = this.getBlockId(var1, var2, var3);
        return var4 == 0 ? Material.air : Block.blocksList[var4].blockMaterial;
    }

    public int getBlockMetadata(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return 0;
            } else if (var2 >= 128) {
                return 0;
            } else {
                Chunk var4 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var4.getBlockMetadata(var1, var2, var3);
            }
        } else {
            return 0;
        }
    }

    public void setBlockMetadataWithNotify(int var1, int var2, int var3, int var4) {
        if (this.setBlockMetadata(var1, var2, var3, var4)) {
            int var5 = this.getBlockId(var1, var2, var3);
            if (Block.requiresSelfNotify[var5 & 255]) {
                this.notifyBlockChange(var1, var2, var3, var5);
            } else {
                this.notifyBlocksOfNeighborChange(var1, var2, var3, var5);
            }
        }

    }

    public boolean setBlockMetadata(int var1, int var2, int var3, int var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var5 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                var5.setBlockMetadata(var1, var2, var3, var4);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean setBlockWithNotify(int var1, int var2, int var3, int var4) {
        if (this.setBlock(var1, var2, var3, var4)) {
            this.notifyBlockChange(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public boolean setBlockAndMetadataWithNotify(int var1, int var2, int var3, int var4, int var5) {
        if (this.setBlockAndMetadata(var1, var2, var3, var4, var5)) {
            this.notifyBlockChange(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public void markBlockNeedsUpdate(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.worldAccesses.size(); ++var4) {
            ((IWorldAccess)this.worldAccesses.get(var4)).markBlockNeedsUpdate(var1, var2, var3);
        }

    }

    protected void notifyBlockChange(int var1, int var2, int var3, int var4) {
        this.markBlockNeedsUpdate(var1, var2, var3);
        this.notifyBlocksOfNeighborChange(var1, var2, var3, var4);
    }

    public void markBlocksDirtyVertical(int var1, int var2, int var3, int var4) {
        if (var3 > var4) {
            int var5 = var4;
            var4 = var3;
            var3 = var5;
        }

        this.markBlocksDirty(var1, var3, var2, var1, var4, var2);
    }

    public void markBlockAsNeedsUpdate(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.worldAccesses.size(); ++var4) {
            ((IWorldAccess)this.worldAccesses.get(var4)).markBlockRangeNeedsUpdate(var1, var2, var3, var1, var2, var3);
        }

    }

    public void markBlocksDirty(int var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.worldAccesses.size(); ++var7) {
            ((IWorldAccess)this.worldAccesses.get(var7)).markBlockRangeNeedsUpdate(var1, var2, var3, var4, var5, var6);
        }

    }

    public void notifyBlocksOfNeighborChange(int var1, int var2, int var3, int var4) {
        this.notifyBlockOfNeighborChange(var1 - 1, var2, var3, var4);
        this.notifyBlockOfNeighborChange(var1 + 1, var2, var3, var4);
        this.notifyBlockOfNeighborChange(var1, var2 - 1, var3, var4);
        this.notifyBlockOfNeighborChange(var1, var2 + 1, var3, var4);
        this.notifyBlockOfNeighborChange(var1, var2, var3 - 1, var4);
        this.notifyBlockOfNeighborChange(var1, var2, var3 + 1, var4);
    }

    private void notifyBlockOfNeighborChange(int var1, int var2, int var3, int var4) {
        if (!this.editingBlocks && !this.singleplayerWorld) {
            Block var5 = Block.blocksList[this.getBlockId(var1, var2, var3)];
            if (var5 != null) {
                var5.onNeighborBlockChange(this, var1, var2, var3, var4);
            }

        }
    }

    public boolean canBlockSeeTheSky(int var1, int var2, int var3) {
        return this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4).canBlockSeeTheSky(var1 & 15, var2, var3 & 15);
    }

    public int getBlockLightValueNoChecks(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else {
            if (var2 >= 128) {
                var2 = 127;
            }

            return this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4).getBlockLightValue(var1 & 15, var2, var3 & 15, 0);
        }
    }

    public int getBlockLightValue(int var1, int var2, int var3) {
        return this.getBlockLightValue_do(var1, var2, var3, true);
    }

    public int getBlockLightValue_do(int var1, int var2, int var3, boolean var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var4) {
                int var5 = this.getBlockId(var1, var2, var3);
                if (var5 == Block.stairSingle.blockID || var5 == Block.tilledField.blockID || var5 == Block.stairCompactCobblestone.blockID || var5 == Block.stairCompactPlanks.blockID) {
                    int var6 = this.getBlockLightValue_do(var1, var2 + 1, var3, false);
                    int var7 = this.getBlockLightValue_do(var1 + 1, var2, var3, false);
                    int var8 = this.getBlockLightValue_do(var1 - 1, var2, var3, false);
                    int var9 = this.getBlockLightValue_do(var1, var2, var3 + 1, false);
                    int var10 = this.getBlockLightValue_do(var1, var2, var3 - 1, false);
                    if (var7 > var6) {
                        var6 = var7;
                    }

                    if (var8 > var6) {
                        var6 = var8;
                    }

                    if (var9 > var6) {
                        var6 = var9;
                    }

                    if (var10 > var6) {
                        var6 = var10;
                    }

                    return var6;
                }
            }

            if (var2 < 0) {
                return 0;
            } else {
                if (var2 >= 128) {
                    var2 = 127;
                }

                Chunk var11 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var11.getBlockLightValue(var1, var2, var3, this.skylightSubtracted);
            }
        } else {
            return 15;
        }
    }

    public boolean canExistingBlockSeeTheSky(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return true;
            } else if (!this.chunkExists(var1 >> 4, var3 >> 4)) {
                return false;
            } else {
                Chunk var4 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var4.canBlockSeeTheSky(var1, var2, var3);
            }
        } else {
            return false;
        }
    }

    public int getHeightValue(int var1, int var2) {
        if (var1 >= -32000000 && var2 >= -32000000 && var1 < 32000000 && var2 <= 32000000) {
            if (!this.chunkExists(var1 >> 4, var2 >> 4)) {
                return 0;
            } else {
                Chunk var3 = this.getChunkFromChunkCoords(var1 >> 4, var2 >> 4);
                return var3.getHeightValue(var1 & 15, var2 & 15);
            }
        } else {
            return 0;
        }
    }

    public void neighborLightPropagationChanged(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        if (!this.worldProvider.field_4306_c || var1 != EnumSkyBlock.Sky) {
            if (this.blockExists(var2, var3, var4)) {
                if (var1 == EnumSkyBlock.Sky) {
                    if (this.canExistingBlockSeeTheSky(var2, var3, var4)) {
                        var5 = 15;
                    }
                } else if (var1 == EnumSkyBlock.Block) {
                    int var6 = this.getBlockId(var2, var3, var4);
                    if (Block.lightValue[var6] > var5) {
                        var5 = Block.lightValue[var6];
                    }
                }

                if (this.getSavedLightValue(var1, var2, var3, var4) != var5) {
                    this.scheduleLightingUpdate(var1, var2, var3, var4, var2, var3, var4);
                }

            }
        }
    }

    public int getSavedLightValue(EnumSkyBlock var1, int var2, int var3, int var4) {
        if (var3 < 0) {
            var3 = 0;
        }

        if (var3 >= 128) {
            var3 = 127;
        }

        if (var3 >= 0 && var3 < 128 && var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
            int var5 = var2 >> 4;
            int var6 = var4 >> 4;
            if (!this.chunkExists(var5, var6)) {
                return 0;
            } else {
                Chunk var7 = this.getChunkFromChunkCoords(var5, var6);
                return var7.getSavedLightValue(var1, var2 & 15, var3, var4 & 15);
            }
        } else {
            return var1.field_984_c;
        }
    }

    public void setLightValue(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        if (var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
            if (var3 >= 0) {
                if (var3 < 128) {
                    if (this.chunkExists(var2 >> 4, var4 >> 4)) {
                        Chunk var6 = this.getChunkFromChunkCoords(var2 >> 4, var4 >> 4);
                        var6.setLightValue(var1, var2 & 15, var3, var4 & 15, var5);

                        for(int var7 = 0; var7 < this.worldAccesses.size(); ++var7) {
                            ((IWorldAccess)this.worldAccesses.get(var7)).markBlockNeedsUpdate(var2, var3, var4);
                        }

                    }
                }
            }
        }
    }

    public float getLightBrightness(int var1, int var2, int var3) {
        return this.worldProvider.lightBrightnessTable[this.getBlockLightValue(var1, var2, var3)];
    }

    public boolean isDaytime() {
        return this.skylightSubtracted < 4;
    }

    public MovingObjectPosition rayTraceBlocks(Vec3D var1, Vec3D var2) {
        return this.func_28099_a(var1, var2, false, false);
    }

    public MovingObjectPosition rayTraceBlocks_do(Vec3D var1, Vec3D var2, boolean var3) {
        return this.func_28099_a(var1, var2, var3, false);
    }

    public MovingObjectPosition func_28099_a(Vec3D var1, Vec3D var2, boolean var3, boolean var4) {
        if (!Double.isNaN(var1.xCoord) && !Double.isNaN(var1.yCoord) && !Double.isNaN(var1.zCoord)) {
            if (!Double.isNaN(var2.xCoord) && !Double.isNaN(var2.yCoord) && !Double.isNaN(var2.zCoord)) {
                int var5 = MathHelper.floor_double(var2.xCoord);
                int var6 = MathHelper.floor_double(var2.yCoord);
                int var7 = MathHelper.floor_double(var2.zCoord);
                int var8 = MathHelper.floor_double(var1.xCoord);
                int var9 = MathHelper.floor_double(var1.yCoord);
                int var10 = MathHelper.floor_double(var1.zCoord);
                int var11 = this.getBlockId(var8, var9, var10);
                int var12 = this.getBlockMetadata(var8, var9, var10);
                Block var13 = Block.blocksList[var11];
                if ((!var4 || var13 == null || var13.getCollisionBoundingBoxFromPool(this, var8, var9, var10) != null) && var11 > 0 && var13.canCollideCheck(var12, var3)) {
                    MovingObjectPosition var14 = var13.collisionRayTrace(this, var8, var9, var10, var1, var2);
                    if (var14 != null) {
                        return var14;
                    }
                }

                var11 = 200;

                while(var11-- >= 0) {
                    if (Double.isNaN(var1.xCoord) || Double.isNaN(var1.yCoord) || Double.isNaN(var1.zCoord)) {
                        return null;
                    }

                    if (var8 == var5 && var9 == var6 && var10 == var7) {
                        return null;
                    }

                    boolean var39 = true;
                    boolean var40 = true;
                    boolean var41 = true;
                    double var15 = 999.0D;
                    double var17 = 999.0D;
                    double var19 = 999.0D;
                    if (var5 > var8) {
                        var15 = (double)var8 + 1.0D;
                    } else if (var5 < var8) {
                        var15 = (double)var8 + 0.0D;
                    } else {
                        var39 = false;
                    }

                    if (var6 > var9) {
                        var17 = (double)var9 + 1.0D;
                    } else if (var6 < var9) {
                        var17 = (double)var9 + 0.0D;
                    } else {
                        var40 = false;
                    }

                    if (var7 > var10) {
                        var19 = (double)var10 + 1.0D;
                    } else if (var7 < var10) {
                        var19 = (double)var10 + 0.0D;
                    } else {
                        var41 = false;
                    }

                    double var21 = 999.0D;
                    double var23 = 999.0D;
                    double var25 = 999.0D;
                    double var27 = var2.xCoord - var1.xCoord;
                    double var29 = var2.yCoord - var1.yCoord;
                    double var31 = var2.zCoord - var1.zCoord;
                    if (var39) {
                        var21 = (var15 - var1.xCoord) / var27;
                    }

                    if (var40) {
                        var23 = (var17 - var1.yCoord) / var29;
                    }

                    if (var41) {
                        var25 = (var19 - var1.zCoord) / var31;
                    }

                    boolean var33 = false;
                    byte var42;
                    if (var21 < var23 && var21 < var25) {
                        if (var5 > var8) {
                            var42 = 4;
                        } else {
                            var42 = 5;
                        }

                        var1.xCoord = var15;
                        var1.yCoord += var29 * var21;
                        var1.zCoord += var31 * var21;
                    } else if (var23 < var25) {
                        if (var6 > var9) {
                            var42 = 0;
                        } else {
                            var42 = 1;
                        }

                        var1.xCoord += var27 * var23;
                        var1.yCoord = var17;
                        var1.zCoord += var31 * var23;
                    } else {
                        if (var7 > var10) {
                            var42 = 2;
                        } else {
                            var42 = 3;
                        }

                        var1.xCoord += var27 * var25;
                        var1.yCoord += var29 * var25;
                        var1.zCoord = var19;
                    }

                    Vec3D var34 = Vec3D.createVector(var1.xCoord, var1.yCoord, var1.zCoord);
                    var8 = (int)(var34.xCoord = (double)MathHelper.floor_double(var1.xCoord));
                    if (var42 == 5) {
                        --var8;
                        ++var34.xCoord;
                    }

                    var9 = (int)(var34.yCoord = (double)MathHelper.floor_double(var1.yCoord));
                    if (var42 == 1) {
                        --var9;
                        ++var34.yCoord;
                    }

                    var10 = (int)(var34.zCoord = (double)MathHelper.floor_double(var1.zCoord));
                    if (var42 == 3) {
                        --var10;
                        ++var34.zCoord;
                    }

                    int var35 = this.getBlockId(var8, var9, var10);
                    int var36 = this.getBlockMetadata(var8, var9, var10);
                    Block var37 = Block.blocksList[var35];
                    if ((!var4 || var37 == null || var37.getCollisionBoundingBoxFromPool(this, var8, var9, var10) != null) && var35 > 0 && var37.canCollideCheck(var36, var3)) {
                        MovingObjectPosition var38 = var37.collisionRayTrace(this, var8, var9, var10, var1, var2);
                        if (var38 != null) {
                            return var38;
                        }
                    }
                }

                return null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void playSoundAtEntity(Entity var1, String var2, float var3, float var4) {
        for(int var5 = 0; var5 < this.worldAccesses.size(); ++var5) {
            ((IWorldAccess)this.worldAccesses.get(var5)).playSound(var2, var1.posX, var1.posY - (double)var1.yOffset, var1.posZ, var3, var4);
        }

    }

    public void playSoundEffect(double var1, double var3, double var5, String var7, float var8, float var9) {
        for(int var10 = 0; var10 < this.worldAccesses.size(); ++var10) {
            ((IWorldAccess)this.worldAccesses.get(var10)).playSound(var7, var1, var3, var5, var8, var9);
        }

    }

    public void playRecord(String var1, int var2, int var3, int var4) {
        for(int var5 = 0; var5 < this.worldAccesses.size(); ++var5) {
            ((IWorldAccess)this.worldAccesses.get(var5)).playRecord(var1, var2, var3, var4);
        }

    }

    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        for(int var14 = 0; var14 < this.worldAccesses.size(); ++var14) {
            ((IWorldAccess)this.worldAccesses.get(var14)).spawnParticle(var1, var2, var4, var6, var8, var10, var12);
        }

    }

    public boolean addLightningBolt(Entity var1) {
        this.lightningEntities.add(var1);
        return true;
    }

    public boolean entityJoinedWorld(Entity var1) {
        int var2 = MathHelper.floor_double(var1.posX / 16.0D);
        int var3 = MathHelper.floor_double(var1.posZ / 16.0D);
        boolean var4 = false;
        if (var1 instanceof EntityPlayer) {
            var4 = true;
        }

        if (!var4 && !this.chunkExists(var2, var3)) {
            return false;
        } else {
            if (var1 instanceof EntityPlayer) {
                EntityPlayer var5 = (EntityPlayer)var1;
                this.playerEntities.add(var5);
                this.updateAllPlayersSleepingFlag();
            }

            this.getChunkFromChunkCoords(var2, var3).addEntity(var1);
            this.loadedEntityList.add(var1);
            this.obtainEntitySkin(var1);
            return true;
        }
    }

    protected void obtainEntitySkin(Entity var1) {
        for(int var2 = 0; var2 < this.worldAccesses.size(); ++var2) {
            ((IWorldAccess)this.worldAccesses.get(var2)).obtainEntitySkin(var1);
        }

    }

    protected void releaseEntitySkin(Entity var1) {
        for(int var2 = 0; var2 < this.worldAccesses.size(); ++var2) {
            ((IWorldAccess)this.worldAccesses.get(var2)).releaseEntitySkin(var1);
        }

    }

    public void removePlayerForLogoff(Entity var1) {
        if (var1.riddenByEntity != null) {
            var1.riddenByEntity.mountEntity((Entity)null);
        }

        if (var1.ridingEntity != null) {
            var1.mountEntity((Entity)null);
        }

        var1.setEntityDead();
        if (var1 instanceof EntityPlayer) {
            this.playerEntities.remove((EntityPlayer)var1);
            this.updateAllPlayersSleepingFlag();
        }

    }

    public void removePlayer(Entity var1) {
        var1.setEntityDead();
        if (var1 instanceof EntityPlayer) {
            this.playerEntities.remove((EntityPlayer)var1);
            this.updateAllPlayersSleepingFlag();
        }

        int var2 = var1.chunkCoordX;
        int var3 = var1.chunkCoordZ;
        if (var1.addedToChunk && this.chunkExists(var2, var3)) {
            this.getChunkFromChunkCoords(var2, var3).removeEntity(var1);
        }

        this.loadedEntityList.remove(var1);
        this.releaseEntitySkin(var1);
    }

    public void addWorldAccess(IWorldAccess var1) {
        this.worldAccesses.add(var1);
    }

    public List getCollidingBoundingBoxes(Entity var1, AxisAlignedBB var2) {
        this.field_9207_I.clear();
        int var3 = MathHelper.floor_double(var2.minX);
        int var4 = MathHelper.floor_double(var2.maxX + 1.0D);
        int var5 = MathHelper.floor_double(var2.minY);
        int var6 = MathHelper.floor_double(var2.maxY + 1.0D);
        int var7 = MathHelper.floor_double(var2.minZ);
        int var8 = MathHelper.floor_double(var2.maxZ + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var7; var10 < var8; ++var10) {
                if (this.blockExists(var9, 64, var10)) {
                    for(int var11 = var5 - 1; var11 < var6; ++var11) {
                        Block var12 = Block.blocksList[this.getBlockId(var9, var11, var10)];
                        if (var12 != null) {
                            var12.getCollidingBoundingBoxes(this, var9, var11, var10, var2, this.field_9207_I);
                        }
                    }
                }
            }
        }

        double var14 = 0.25D;
        List var15 = this.getEntitiesWithinAABBExcludingEntity(var1, var2.expand(var14, var14, var14));

        for(int var16 = 0; var16 < var15.size(); ++var16) {
            AxisAlignedBB var13 = ((Entity)var15.get(var16)).getBoundingBox();
            if (var13 != null && var13.intersectsWith(var2)) {
                this.field_9207_I.add(var13);
            }

            var13 = var1.func_89_d((Entity)var15.get(var16));
            if (var13 != null && var13.intersectsWith(var2)) {
                this.field_9207_I.add(var13);
            }
        }

        return this.field_9207_I;
    }

    public int calculateSkylightSubtracted(float var1) {
        float var2 = this.getCelestialAngle(var1);
        float var3 = 1.0F - (MathHelper.cos(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        var3 = 1.0F - var3;
        var3 = (float)((double)var3 * (1.0D - (double)(this.func_27074_d(var1) * 5.0F) / 16.0D));
        var3 = (float)((double)var3 * (1.0D - (double)(this.func_27065_c(var1) * 5.0F) / 16.0D));
        var3 = 1.0F - var3;
        return (int)(var3 * 11.0F);
    }

    public float getCelestialAngle(float var1) {
        return this.worldProvider.calculateCelestialAngle(this.worldInfo.getWorldTime(), var1);
    }

    public int getTopSolidOrLiquidBlock(int var1, int var2) {
        Chunk var3 = this.getChunkFromBlockCoords(var1, var2);
        int var4 = 127;
        var1 &= 15;

        for(var2 &= 15; var4 > 0; --var4) {
            int var5 = var3.getBlockID(var1, var4, var2);
            Material var6 = var5 == 0 ? Material.air : Block.blocksList[var5].blockMaterial;
            if (var6.getIsSolid() || var6.getIsLiquid()) {
                return var4 + 1;
            }
        }

        return -1;
    }

    public int findTopSolidBlock(int var1, int var2) {
        Chunk var3 = this.getChunkFromBlockCoords(var1, var2);
        int var4 = 127;
        var1 &= 15;

        for(var2 &= 15; var4 > 0; --var4) {
            int var5 = var3.getBlockID(var1, var4, var2);
            if (var5 != 0 && Block.blocksList[var5].blockMaterial.getIsSolid()) {
                return var4 + 1;
            }
        }

        return -1;
    }

    public void scheduleUpdateTick(int var1, int var2, int var3, int var4, int var5) {
        NextTickListEntry var6 = new NextTickListEntry(var1, var2, var3, var4);
        byte var7 = 8;
        if (this.scheduledUpdatesAreImmediate) {
            if (this.checkChunksExist(var6.xCoord - var7, var6.yCoord - var7, var6.zCoord - var7, var6.xCoord + var7, var6.yCoord + var7, var6.zCoord + var7)) {
                int var8 = this.getBlockId(var6.xCoord, var6.yCoord, var6.zCoord);
                if (var8 == var6.blockID && var8 > 0) {
                    Block.blocksList[var8].updateTick(this, var6.xCoord, var6.yCoord, var6.zCoord, this.rand);
                }
            }

        } else {
            if (this.checkChunksExist(var1 - var7, var2 - var7, var3 - var7, var1 + var7, var2 + var7, var3 + var7)) {
                if (var4 > 0) {
                    var6.setScheduledTime((long)var5 + this.worldInfo.getWorldTime());
                }

                if (!this.scheduledTickSet.contains(var6)) {
                    this.scheduledTickSet.add(var6);
                    this.scheduledTickTreeSet.add(var6);
                }
            }

        }
    }

    public void updateEntities() {
        int var1;
        Entity var2;
        for(var1 = 0; var1 < this.lightningEntities.size(); ++var1) {
            var2 = (Entity)this.lightningEntities.get(var1);
            var2.onUpdate();
            if (var2.isDead) {
                this.lightningEntities.remove(var1--);
            }
        }

        this.loadedEntityList.removeAll(this.unloadedEntityList);

        int var3;
        int var4;
        for(var1 = 0; var1 < this.unloadedEntityList.size(); ++var1) {
            var2 = (Entity)this.unloadedEntityList.get(var1);
            var3 = var2.chunkCoordX;
            var4 = var2.chunkCoordZ;
            if (var2.addedToChunk && this.chunkExists(var3, var4)) {
                this.getChunkFromChunkCoords(var3, var4).removeEntity(var2);
            }
        }

        for(var1 = 0; var1 < this.unloadedEntityList.size(); ++var1) {
            this.releaseEntitySkin((Entity)this.unloadedEntityList.get(var1));
        }

        this.unloadedEntityList.clear();

        for(var1 = 0; var1 < this.loadedEntityList.size(); ++var1) {
            var2 = (Entity)this.loadedEntityList.get(var1);
            if (var2.ridingEntity != null) {
                if (!var2.ridingEntity.isDead && var2.ridingEntity.riddenByEntity == var2) {
                    continue;
                }

                var2.ridingEntity.riddenByEntity = null;
                var2.ridingEntity = null;
            }

            if (!var2.isDead) {
                this.updateEntity(var2);
            }

            if (var2.isDead) {
                var3 = var2.chunkCoordX;
                var4 = var2.chunkCoordZ;
                if (var2.addedToChunk && this.chunkExists(var3, var4)) {
                    this.getChunkFromChunkCoords(var3, var4).removeEntity(var2);
                }

                this.loadedEntityList.remove(var1--);
                this.releaseEntitySkin(var2);
            }
        }

        this.field_31048_L = true;
        Iterator var10 = this.loadedTileEntityList.iterator();

        while(var10.hasNext()) {
            TileEntity var5 = (TileEntity)var10.next();
            if (!var5.isInvalid()) {
                var5.updateEntity();
            }

            if (var5.isInvalid()) {
                var10.remove();
                Chunk var7 = this.getChunkFromChunkCoords(var5.xCoord >> 4, var5.zCoord >> 4);
                if (var7 != null) {
                    var7.removeChunkBlockTileEntity(var5.xCoord & 15, var5.yCoord, var5.zCoord & 15);
                }
            }
        }

        this.field_31048_L = false;
        if (!this.field_20912_E.isEmpty()) {
            Iterator var6 = this.field_20912_E.iterator();

            while(var6.hasNext()) {
                TileEntity var8 = (TileEntity)var6.next();
                if (!var8.isInvalid()) {
                    if (!this.loadedTileEntityList.contains(var8)) {
                        this.loadedTileEntityList.add(var8);
                    }

                    Chunk var9 = this.getChunkFromChunkCoords(var8.xCoord >> 4, var8.zCoord >> 4);
                    if (var9 != null) {
                        var9.setChunkBlockTileEntity(var8.xCoord & 15, var8.yCoord, var8.zCoord & 15, var8);
                    }

                    this.markBlockNeedsUpdate(var8.xCoord, var8.yCoord, var8.zCoord);
                }
            }

            this.field_20912_E.clear();
        }

    }

    public void func_31047_a(Collection var1) {
        if (this.field_31048_L) {
            this.field_20912_E.addAll(var1);
        } else {
            this.loadedTileEntityList.addAll(var1);
        }

    }

    public void updateEntity(Entity var1) {
        this.updateEntityWithOptionalForce(var1, true);
    }

    public void updateEntityWithOptionalForce(Entity var1, boolean var2) {
        int var3 = MathHelper.floor_double(var1.posX);
        int var4 = MathHelper.floor_double(var1.posZ);
        byte var5 = 32;
        if (!var2 || this.checkChunksExist(var3 - var5, 0, var4 - var5, var3 + var5, 128, var4 + var5)) {
            var1.lastTickPosX = var1.posX;
            var1.lastTickPosY = var1.posY;
            var1.lastTickPosZ = var1.posZ;
            var1.prevRotationYaw = var1.rotationYaw;
            var1.prevRotationPitch = var1.rotationPitch;
            if (var2 && var1.addedToChunk) {
                if (var1.ridingEntity != null) {
                    var1.updateRidden();
                } else {
                    var1.onUpdate();
                }
            }

            if (Double.isNaN(var1.posX) || Double.isInfinite(var1.posX)) {
                var1.posX = var1.lastTickPosX;
            }

            if (Double.isNaN(var1.posY) || Double.isInfinite(var1.posY)) {
                var1.posY = var1.lastTickPosY;
            }

            if (Double.isNaN(var1.posZ) || Double.isInfinite(var1.posZ)) {
                var1.posZ = var1.lastTickPosZ;
            }

            if (Double.isNaN((double)var1.rotationPitch) || Double.isInfinite((double)var1.rotationPitch)) {
                var1.rotationPitch = var1.prevRotationPitch;
            }

            if (Double.isNaN((double)var1.rotationYaw) || Double.isInfinite((double)var1.rotationYaw)) {
                var1.rotationYaw = var1.prevRotationYaw;
            }

            int var6 = MathHelper.floor_double(var1.posX / 16.0D);
            int var7 = MathHelper.floor_double(var1.posY / 16.0D);
            int var8 = MathHelper.floor_double(var1.posZ / 16.0D);
            if (!var1.addedToChunk || var1.chunkCoordX != var6 || var1.chunkCoordY != var7 || var1.chunkCoordZ != var8) {
                if (var1.addedToChunk && this.chunkExists(var1.chunkCoordX, var1.chunkCoordZ)) {
                    this.getChunkFromChunkCoords(var1.chunkCoordX, var1.chunkCoordZ).removeEntityAtIndex(var1, var1.chunkCoordY);
                }

                if (this.chunkExists(var6, var8)) {
                    var1.addedToChunk = true;
                    this.getChunkFromChunkCoords(var6, var8).addEntity(var1);
                } else {
                    var1.addedToChunk = false;
                }
            }

            if (var2 && var1.addedToChunk && var1.riddenByEntity != null) {
                if (!var1.riddenByEntity.isDead && var1.riddenByEntity.ridingEntity == var1) {
                    this.updateEntity(var1.riddenByEntity);
                } else {
                    var1.riddenByEntity.ridingEntity = null;
                    var1.riddenByEntity = null;
                }
            }

        }
    }

    public boolean checkIfAABBIsClear(AxisAlignedBB var1) {
        List var2 = this.getEntitiesWithinAABBExcludingEntity((Entity)null, var1);

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            Entity var4 = (Entity)var2.get(var3);
            if (!var4.isDead && var4.preventEntitySpawning) {
                return false;
            }
        }

        return true;
    }

    public boolean func_27069_b(AxisAlignedBB var1) {
        int var2 = MathHelper.floor_double(var1.minX);
        int var3 = MathHelper.floor_double(var1.maxX + 1.0D);
        int var4 = MathHelper.floor_double(var1.minY);
        int var5 = MathHelper.floor_double(var1.maxY + 1.0D);
        int var6 = MathHelper.floor_double(var1.minZ);
        int var7 = MathHelper.floor_double(var1.maxZ + 1.0D);
        if (var1.minX < 0.0D) {
            --var2;
        }

        if (var1.minY < 0.0D) {
            --var4;
        }

        if (var1.minZ < 0.0D) {
            --var6;
        }

        for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
                for(int var10 = var6; var10 < var7; ++var10) {
                    Block var11 = Block.blocksList[this.getBlockId(var8, var9, var10)];
                    if (var11 != null) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean getIsAnyLiquid(AxisAlignedBB var1) {
        int var2 = MathHelper.floor_double(var1.minX);
        int var3 = MathHelper.floor_double(var1.maxX + 1.0D);
        int var4 = MathHelper.floor_double(var1.minY);
        int var5 = MathHelper.floor_double(var1.maxY + 1.0D);
        int var6 = MathHelper.floor_double(var1.minZ);
        int var7 = MathHelper.floor_double(var1.maxZ + 1.0D);
        if (var1.minX < 0.0D) {
            --var2;
        }

        if (var1.minY < 0.0D) {
            --var4;
        }

        if (var1.minZ < 0.0D) {
            --var6;
        }

        for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
                for(int var10 = var6; var10 < var7; ++var10) {
                    Block var11 = Block.blocksList[this.getBlockId(var8, var9, var10)];
                    if (var11 != null && var11.blockMaterial.getIsLiquid()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isBoundingBoxBurning(AxisAlignedBB var1) {
        int var2 = MathHelper.floor_double(var1.minX);
        int var3 = MathHelper.floor_double(var1.maxX + 1.0D);
        int var4 = MathHelper.floor_double(var1.minY);
        int var5 = MathHelper.floor_double(var1.maxY + 1.0D);
        int var6 = MathHelper.floor_double(var1.minZ);
        int var7 = MathHelper.floor_double(var1.maxZ + 1.0D);
        if (this.checkChunksExist(var2, var4, var6, var3, var5, var7)) {
            for(int var8 = var2; var8 < var3; ++var8) {
                for(int var9 = var4; var9 < var5; ++var9) {
                    for(int var10 = var6; var10 < var7; ++var10) {
                        int var11 = this.getBlockId(var8, var9, var10);
                        if (var11 == Block.fire.blockID || var11 == Block.lavaMoving.blockID || var11 == Block.lavaStill.blockID) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean handleMaterialAcceleration(AxisAlignedBB var1, Material var2, Entity var3) {
        int var4 = MathHelper.floor_double(var1.minX);
        int var5 = MathHelper.floor_double(var1.maxX + 1.0D);
        int var6 = MathHelper.floor_double(var1.minY);
        int var7 = MathHelper.floor_double(var1.maxY + 1.0D);
        int var8 = MathHelper.floor_double(var1.minZ);
        int var9 = MathHelper.floor_double(var1.maxZ + 1.0D);
        if (!this.checkChunksExist(var4, var6, var8, var5, var7, var9)) {
            return false;
        } else {
            boolean var10 = false;
            Vec3D var11 = Vec3D.createVector(0.0D, 0.0D, 0.0D);

            for(int var12 = var4; var12 < var5; ++var12) {
                for(int var13 = var6; var13 < var7; ++var13) {
                    for(int var14 = var8; var14 < var9; ++var14) {
                        Block var15 = Block.blocksList[this.getBlockId(var12, var13, var14)];
                        if (var15 != null && var15.blockMaterial == var2) {
                            double var16 = (double)((float)(var13 + 1) - BlockFluid.setFluidHeight(this.getBlockMetadata(var12, var13, var14)));
                            if ((double)var7 >= var16) {
                                var10 = true;
                                var15.velocityToAddToEntity(this, var12, var13, var14, var3, var11);
                            }
                        }
                    }
                }
            }

            if (var11.lengthVector() > 0.0D) {
                var11 = var11.normalize();
                double var18 = 0.014D;
                var3.motionX += var11.xCoord * var18;
                var3.motionY += var11.yCoord * var18;
                var3.motionZ += var11.zCoord * var18;
            }

            return var10;
        }
    }

    public boolean isMaterialInBB(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.floor_double(var1.minX);
        int var4 = MathHelper.floor_double(var1.maxX + 1.0D);
        int var5 = MathHelper.floor_double(var1.minY);
        int var6 = MathHelper.floor_double(var1.maxY + 1.0D);
        int var7 = MathHelper.floor_double(var1.minZ);
        int var8 = MathHelper.floor_double(var1.maxZ + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var5; var10 < var6; ++var10) {
                for(int var11 = var7; var11 < var8; ++var11) {
                    Block var12 = Block.blocksList[this.getBlockId(var9, var10, var11)];
                    if (var12 != null && var12.blockMaterial == var2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isAABBInMaterial(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.floor_double(var1.minX);
        int var4 = MathHelper.floor_double(var1.maxX + 1.0D);
        int var5 = MathHelper.floor_double(var1.minY);
        int var6 = MathHelper.floor_double(var1.maxY + 1.0D);
        int var7 = MathHelper.floor_double(var1.minZ);
        int var8 = MathHelper.floor_double(var1.maxZ + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var5; var10 < var6; ++var10) {
                for(int var11 = var7; var11 < var8; ++var11) {
                    Block var12 = Block.blocksList[this.getBlockId(var9, var10, var11)];
                    if (var12 != null && var12.blockMaterial == var2) {
                        int var13 = this.getBlockMetadata(var9, var10, var11);
                        double var14 = (double)(var10 + 1);
                        if (var13 < 8) {
                            var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
                        }

                        if (var14 >= var1.minY) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public Explosion createExplosion(Entity var1, double var2, double var4, double var6, float var8) {
        return this.newExplosion(var1, var2, var4, var6, var8, false);
    }

    public Explosion newExplosion(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
        Explosion var10 = new Explosion(this, var1, var2, var4, var6, var8);
        var10.isFlaming = var9;
        var10.doExplosion();
        var10.doEffects(true);
        return var10;
    }

    public float func_494_a(Vec3D var1, AxisAlignedBB var2) {
        double var3 = 1.0D / ((var2.maxX - var2.minX) * 2.0D + 1.0D);
        double var5 = 1.0D / ((var2.maxY - var2.minY) * 2.0D + 1.0D);
        double var7 = 1.0D / ((var2.maxZ - var2.minZ) * 2.0D + 1.0D);
        int var9 = 0;
        int var10 = 0;

        for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
            for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
                for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
                    double var14 = var2.minX + (var2.maxX - var2.minX) * (double)var11;
                    double var16 = var2.minY + (var2.maxY - var2.minY) * (double)var12;
                    double var18 = var2.minZ + (var2.maxZ - var2.minZ) * (double)var13;
                    if (this.rayTraceBlocks(Vec3D.createVector(var14, var16, var18), var1) == null) {
                        ++var9;
                    }

                    ++var10;
                }
            }
        }

        return (float)var9 / (float)var10;
    }

    public void func_28096_a(EntityPlayer var1, int var2, int var3, int var4, int var5) {
        if (var5 == 0) {
            --var3;
        }

        if (var5 == 1) {
            ++var3;
        }

        if (var5 == 2) {
            --var4;
        }

        if (var5 == 3) {
            ++var4;
        }

        if (var5 == 4) {
            --var2;
        }

        if (var5 == 5) {
            ++var2;
        }

        if (this.getBlockId(var2, var3, var4) == Block.fire.blockID) {
            this.func_28101_a(var1, 1004, var2, var3, var4, 0);
            this.setBlockWithNotify(var2, var3, var4, 0);
        }

    }

    public TileEntity getBlockTileEntity(int var1, int var2, int var3) {
        Chunk var4 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
        return var4 != null ? var4.getChunkBlockTileEntity(var1 & 15, var2, var3 & 15) : null;
    }

    public void setBlockTileEntity(int var1, int var2, int var3, TileEntity var4) {
        if (!var4.isInvalid()) {
            if (this.field_31048_L) {
                var4.xCoord = var1;
                var4.yCoord = var2;
                var4.zCoord = var3;
                this.field_20912_E.add(var4);
            } else {
                this.loadedTileEntityList.add(var4);
                Chunk var5 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
                if (var5 != null) {
                    var5.setChunkBlockTileEntity(var1 & 15, var2, var3 & 15, var4);
                }
            }
        }

    }

    public void removeBlockTileEntity(int var1, int var2, int var3) {
        TileEntity var4 = this.getBlockTileEntity(var1, var2, var3);
        if (var4 != null && this.field_31048_L) {
            var4.invalidate();
        } else {
            if (var4 != null) {
                this.loadedTileEntityList.remove(var4);
            }

            Chunk var5 = this.getChunkFromChunkCoords(var1 >> 4, var3 >> 4);
            if (var5 != null) {
                var5.removeChunkBlockTileEntity(var1 & 15, var2, var3 & 15);
            }
        }

    }

    public boolean isBlockOpaqueCube(int var1, int var2, int var3) {
        Block var4 = Block.blocksList[this.getBlockId(var1, var2, var3)];
        return var4 == null ? false : var4.isOpaqueCube();
    }

    public boolean isBlockNormalCube(int var1, int var2, int var3) {
        Block var4 = Block.blocksList[this.getBlockId(var1, var2, var3)];
        if (var4 == null) {
            return false;
        } else {
            return var4.blockMaterial.getIsOpaque() && var4.isACube();
        }
    }

    public boolean func_6156_d() {
        if (this.field_4265_J >= 50) {
            return false;
        } else {
            ++this.field_4265_J;

            boolean var2;
            try {
                int var1 = 500;

                while(this.field_821_y.size() > 0) {
                    --var1;
                    if (var1 <= 0) {
                        var2 = true;
                        return var2;
                    }

                    ((MetadataChunkBlock)this.field_821_y.remove(this.field_821_y.size() - 1)).func_4107_a(this);
                }

                var2 = false;
            } finally {
                --this.field_4265_J;
            }

            return var2;
        }
    }

    public void scheduleLightingUpdate(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.func_484_a(var1, var2, var3, var4, var5, var6, var7, true);
    }

    public void func_484_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
        if (!this.worldProvider.field_4306_c || var1 != EnumSkyBlock.Sky) {
            ++field_4268_y;

            try {
                if (field_4268_y != 50) {
                    int var9 = (var5 + var2) / 2;
                    int var10 = (var7 + var4) / 2;
                    if (this.blockExists(var9, 64, var10)) {
                        if (!this.getChunkFromBlockCoords(var9, var10).func_21101_g()) {
                            int var11 = this.field_821_y.size();
                            int var12;
                            if (var8) {
                                var12 = 5;
                                if (var12 > var11) {
                                    var12 = var11;
                                }

                                for(int var13 = 0; var13 < var12; ++var13) {
                                    MetadataChunkBlock var14 = (MetadataChunkBlock)this.field_821_y.get(this.field_821_y.size() - var13 - 1);
                                    if (var14.field_957_a == var1 && var14.func_692_a(var2, var3, var4, var5, var6, var7)) {
                                        return;
                                    }
                                }
                            }

                            this.field_821_y.add(new MetadataChunkBlock(var1, var2, var3, var4, var5, var6, var7));
                            var12 = 1000000;
                            if (this.field_821_y.size() > 1000000) {
                                System.out.println("More than " + var12 + " updates, aborting lighting updates");
                                this.field_821_y.clear();
                            }

                        }
                    }
                }
            } finally {
                --field_4268_y;
            }
        }
    }

    public void calculateInitialSkylight() {
        int var1 = this.calculateSkylightSubtracted(1.0F);
        if (var1 != this.skylightSubtracted) {
            this.skylightSubtracted = var1;
        }

    }

    public void setAllowedSpawnTypes(boolean var1, boolean var2) {
        this.spawnHostileMobs = var1;
        this.spawnPeacefulMobs = var2;
    }

    public void tick() {
        this.updateWeather();
        long var2;
        if (this.isAllPlayersFullyAsleep()) {
            boolean var1 = false;
            if (this.spawnHostileMobs && this.difficultySetting >= 1) {
                var1 = SpawnerAnimals.performSleepSpawning(this, this.playerEntities);
            }

            if (!var1) {
                var2 = this.worldInfo.getWorldTime() + 24000L;
                this.worldInfo.setWorldTime(var2 - var2 % 24000L);
                this.wakeUpAllPlayers();
            }
        }

        SpawnerAnimals.performSpawning(this, this.spawnHostileMobs, this.spawnPeacefulMobs);
        this.chunkProvider.func_361_a();
        int var4 = this.calculateSkylightSubtracted(1.0F);
        if (var4 != this.skylightSubtracted) {
            this.skylightSubtracted = var4;

            for(int var5 = 0; var5 < this.worldAccesses.size(); ++var5) {
                ((IWorldAccess)this.worldAccesses.get(var5)).updateAllRenderers();
            }
        }

        var2 = this.worldInfo.getWorldTime() + 1L;
        if (var2 % (long)this.autosavePeriod == 0L) {
            this.saveWorld(false, (IProgressUpdate)null);
        }

        this.worldInfo.setWorldTime(var2);
        this.TickUpdates(false);
        this.doRandomUpdateTicks();
    }

    private void func_27070_x() {
        if (this.worldInfo.getIsRaining()) {
            this.field_27078_C = 1.0F;
            if (this.worldInfo.getIsThundering()) {
                this.field_27076_E = 1.0F;
            }
        }

    }

    protected void updateWeather() {
        if (!this.worldProvider.field_4306_c) {
            if (this.field_27075_F > 0) {
                --this.field_27075_F;
            }

            int var1 = this.worldInfo.getThunderTime();
            if (var1 <= 0) {
                if (this.worldInfo.getIsThundering()) {
                    this.worldInfo.setThunderTime(this.rand.nextInt(12000) + 3600);
                } else {
                    this.worldInfo.setThunderTime(this.rand.nextInt(168000) + 12000);
                }
            } else {
                --var1;
                this.worldInfo.setThunderTime(var1);
                if (var1 <= 0) {
                    this.worldInfo.setIsThundering(!this.worldInfo.getIsThundering());
                }
            }

            int var2 = this.worldInfo.getRainTime();
            if (var2 <= 0) {
                if (this.worldInfo.getIsRaining()) {
                    this.worldInfo.setRainTime(this.rand.nextInt(12000) + 12000);
                } else {
                    this.worldInfo.setRainTime(this.rand.nextInt(168000) + 12000);
                }
            } else {
                --var2;
                this.worldInfo.setRainTime(var2);
                if (var2 <= 0) {
                    this.worldInfo.setIsRaining(!this.worldInfo.getIsRaining());
                }
            }

            this.field_27079_B = this.field_27078_C;
            if (this.worldInfo.getIsRaining()) {
                this.field_27078_C = (float)((double)this.field_27078_C + 0.01D);
            } else {
                this.field_27078_C = (float)((double)this.field_27078_C - 0.01D);
            }

            if (this.field_27078_C < 0.0F) {
                this.field_27078_C = 0.0F;
            }

            if (this.field_27078_C > 1.0F) {
                this.field_27078_C = 1.0F;
            }

            this.field_27077_D = this.field_27076_E;
            if (this.worldInfo.getIsThundering()) {
                this.field_27076_E = (float)((double)this.field_27076_E + 0.01D);
            } else {
                this.field_27076_E = (float)((double)this.field_27076_E - 0.01D);
            }

            if (this.field_27076_E < 0.0F) {
                this.field_27076_E = 0.0F;
            }

            if (this.field_27076_E > 1.0F) {
                this.field_27076_E = 1.0F;
            }

        }
    }

    private void clearWeather() {
        this.worldInfo.setRainTime(0);
        this.worldInfo.setIsRaining(false);
        this.worldInfo.setThunderTime(0);
        this.worldInfo.setIsThundering(false);
    }

    protected void doRandomUpdateTicks() {
        this.activeChunkSet.clear();

        int var3;
        int var4;
        int var6;
        int var7;
        for(int var1 = 0; var1 < this.playerEntities.size(); ++var1) {
            EntityPlayer var2 = (EntityPlayer)this.playerEntities.get(var1);
            var3 = MathHelper.floor_double(var2.posX / 16.0D);
            var4 = MathHelper.floor_double(var2.posZ / 16.0D);
            byte var5 = 9;

            for(var6 = -var5; var6 <= var5; ++var6) {
                for(var7 = -var5; var7 <= var5; ++var7) {
                    this.activeChunkSet.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
                }
            }
        }

        if (this.ambientTickCountdown > 0) {
            --this.ambientTickCountdown;
        }

        Iterator var12 = this.activeChunkSet.iterator();

        while(var12.hasNext()) {
            ChunkCoordIntPair var13 = (ChunkCoordIntPair)var12.next();
            var3 = var13.chunkXPos * 16;
            var4 = var13.chunkZPos * 16;
            Chunk var14 = this.getChunkFromChunkCoords(var13.chunkXPos, var13.chunkZPos);
            int var8;
            int var9;
            int var10;
            if (this.ambientTickCountdown == 0) {
                this.distHashCounter = this.distHashCounter * 3 + 1013904223;
                var6 = this.distHashCounter >> 2;
                var7 = var6 & 15;
                var8 = var6 >> 8 & 15;
                var9 = var6 >> 16 & 127;
                var10 = var14.getBlockID(var7, var9, var8);
                var7 += var3;
                var8 += var4;
                if (var10 == 0 && this.getBlockLightValueNoChecks(var7, var9, var8) <= this.rand.nextInt(8) && this.getSavedLightValue(EnumSkyBlock.Sky, var7, var9, var8) <= 0) {
                    EntityPlayer var11 = this.getClosestPlayer((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D, 8.0D);
                    if (var11 != null && var11.getDistanceSq((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D) > 4.0D) {
                        this.playSoundEffect((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.rand.nextFloat() * 0.2F);
                        this.ambientTickCountdown = this.rand.nextInt(12000) + 6000;
                    }
                }
            }

            if (this.rand.nextInt(100000) == 0 && this.func_27068_v() && this.func_27067_u()) {
                this.distHashCounter = this.distHashCounter * 3 + 1013904223;
                var6 = this.distHashCounter >> 2;
                var7 = var3 + (var6 & 15);
                var8 = var4 + (var6 >> 8 & 15);
                var9 = this.getTopSolidOrLiquidBlock(var7, var8);
                if (this.canLightningStrikeAt(var7, var9, var8)) {
                    this.addLightningBolt(new EntityLightningBolt(this, (double)var7, (double)var9, (double)var8));
                    this.field_27075_F = 2;
                }
            }

            int var15;
            if (this.rand.nextInt(16) == 0) {
                this.distHashCounter = this.distHashCounter * 3 + 1013904223;
                var6 = this.distHashCounter >> 2;
                var7 = var6 & 15;
                var8 = var6 >> 8 & 15;
                var9 = this.getTopSolidOrLiquidBlock(var7 + var3, var8 + var4);
                if (this.getWorldChunkManager().getBiomeGenAt(var7 + var3, var8 + var4).getEnableSnow() && var9 >= 0 && var9 < 128 && var14.getSavedLightValue(EnumSkyBlock.Block, var7, var9, var8) < 10) {
                    var10 = var14.getBlockID(var7, var9 - 1, var8);
                    var15 = var14.getBlockID(var7, var9, var8);
                    if (this.func_27068_v() && var15 == 0 && Block.snow.canPlaceBlockAt(this, var7 + var3, var9, var8 + var4) && var10 != 0 && var10 != Block.ice.blockID && Block.blocksList[var10].blockMaterial.getIsSolid()) {
                        this.setBlockWithNotify(var7 + var3, var9, var8 + var4, Block.snow.blockID);
                    }

                    if (var10 == Block.waterStill.blockID && var14.getBlockMetadata(var7, var9 - 1, var8) == 0) {
                        this.setBlockWithNotify(var7 + var3, var9 - 1, var8 + var4, Block.ice.blockID);
                    }
                }
            }

            for(var6 = 0; var6 < 80; ++var6) {
                this.distHashCounter = this.distHashCounter * 3 + 1013904223;
                var7 = this.distHashCounter >> 2;
                var8 = var7 & 15;
                var9 = var7 >> 8 & 15;
                var10 = var7 >> 16 & 127;
                var15 = var14.blocks[var8 << 11 | var9 << 7 | var10] & 255;
                if (Block.tickOnLoad[var15]) {
                    Block.blocksList[var15].updateTick(this, var8 + var3, var10, var9 + var4, this.rand);
                }
            }
        }

    }

    public boolean TickUpdates(boolean var1) {
        int var2 = this.scheduledTickTreeSet.size();
        if (var2 != this.scheduledTickSet.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        } else {
            if (var2 > 1000) {
                var2 = 1000;
            }

            for(int var3 = 0; var3 < var2; ++var3) {
                NextTickListEntry var4 = (NextTickListEntry)this.scheduledTickTreeSet.first();
                if (!var1 && var4.scheduledTime > this.worldInfo.getWorldTime()) {
                    break;
                }

                this.scheduledTickTreeSet.remove(var4);
                this.scheduledTickSet.remove(var4);
                byte var5 = 8;
                if (this.checkChunksExist(var4.xCoord - var5, var4.yCoord - var5, var4.zCoord - var5, var4.xCoord + var5, var4.yCoord + var5, var4.zCoord + var5)) {
                    int var6 = this.getBlockId(var4.xCoord, var4.yCoord, var4.zCoord);
                    if (var6 == var4.blockID && var6 > 0) {
                        Block.blocksList[var6].updateTick(this, var4.xCoord, var4.yCoord, var4.zCoord, this.rand);
                    }
                }
            }

            return this.scheduledTickTreeSet.size() != 0;
        }
    }

    public List getEntitiesWithinAABBExcludingEntity(Entity var1, AxisAlignedBB var2) {
        this.field_778_L.clear();
        int var3 = MathHelper.floor_double((var2.minX - 2.0D) / 16.0D);
        int var4 = MathHelper.floor_double((var2.maxX + 2.0D) / 16.0D);
        int var5 = MathHelper.floor_double((var2.minZ - 2.0D) / 16.0D);
        int var6 = MathHelper.floor_double((var2.maxZ + 2.0D) / 16.0D);

        for(int var7 = var3; var7 <= var4; ++var7) {
            for(int var8 = var5; var8 <= var6; ++var8) {
                if (this.chunkExists(var7, var8)) {
                    this.getChunkFromChunkCoords(var7, var8).getEntitiesWithinAABBForEntity(var1, var2, this.field_778_L);
                }
            }
        }

        return this.field_778_L;
    }

    public List getEntitiesWithinAABB(Class var1, AxisAlignedBB var2) {
        int var3 = MathHelper.floor_double((var2.minX - 2.0D) / 16.0D);
        int var4 = MathHelper.floor_double((var2.maxX + 2.0D) / 16.0D);
        int var5 = MathHelper.floor_double((var2.minZ - 2.0D) / 16.0D);
        int var6 = MathHelper.floor_double((var2.maxZ + 2.0D) / 16.0D);
        ArrayList var7 = new ArrayList();

        for(int var8 = var3; var8 <= var4; ++var8) {
            for(int var9 = var5; var9 <= var6; ++var9) {
                if (this.chunkExists(var8, var9)) {
                    this.getChunkFromChunkCoords(var8, var9).getEntitiesOfTypeWithinAAAB(var1, var2, var7);
                }
            }
        }

        return var7;
    }

    public void updateTileEntityChunkAndDoNothing(int var1, int var2, int var3, TileEntity var4) {
        if (this.blockExists(var1, var2, var3)) {
            this.getChunkFromBlockCoords(var1, var3).setChunkModified();
        }

        for(int var5 = 0; var5 < this.worldAccesses.size(); ++var5) {
            ((IWorldAccess)this.worldAccesses.get(var5)).doNothingWithTileEntity(var1, var2, var3, var4);
        }

    }

    public int countEntities(Class var1) {
        int var2 = 0;

        for(int var3 = 0; var3 < this.loadedEntityList.size(); ++var3) {
            Entity var4 = (Entity)this.loadedEntityList.get(var3);
            if (var1.isAssignableFrom(var4.getClass())) {
                ++var2;
            }
        }

        return var2;
    }

    public void addLoadedEntities(List var1) {
        this.loadedEntityList.addAll(var1);

        for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.obtainEntitySkin((Entity)var1.get(var2));
        }

    }

    public void addUnloadedEntities(List var1) {
        this.unloadedEntityList.addAll(var1);
    }

    public boolean canBlockBePlacedAt(int var1, int var2, int var3, int var4, boolean var5, int var6) {
        int var7 = this.getBlockId(var2, var3, var4);
        Block var8 = Block.blocksList[var7];
        Block var9 = Block.blocksList[var1];
        AxisAlignedBB var10 = var9.getCollisionBoundingBoxFromPool(this, var2, var3, var4);
        if (var5) {
            var10 = null;
        }

        if (var10 != null && !this.checkIfAABBIsClear(var10)) {
            return false;
        } else {
            if (var8 == Block.waterMoving || var8 == Block.waterStill || var8 == Block.lavaMoving || var8 == Block.lavaStill || var8 == Block.fire || var8 == Block.snow) {
                var8 = null;
            }

            return var1 > 0 && var8 == null && var9.canPlaceBlockOnSide(this, var2, var3, var4, var6);
        }
    }

    public PathEntity getPathToEntity(Entity var1, Entity var2, float var3) {
        int var4 = MathHelper.floor_double(var1.posX);
        int var5 = MathHelper.floor_double(var1.posY);
        int var6 = MathHelper.floor_double(var1.posZ);
        int var7 = (int)(var3 + 16.0F);
        int var8 = var4 - var7;
        int var9 = var5 - var7;
        int var10 = var6 - var7;
        int var11 = var4 + var7;
        int var12 = var5 + var7;
        int var13 = var6 + var7;
        ChunkCache var14 = new ChunkCache(this, var8, var9, var10, var11, var12, var13);
        return (new Pathfinder(var14)).createEntityPathTo(var1, var2, var3);
    }

    public PathEntity getEntityPathToXYZ(Entity var1, int var2, int var3, int var4, float var5) {
        int var6 = MathHelper.floor_double(var1.posX);
        int var7 = MathHelper.floor_double(var1.posY);
        int var8 = MathHelper.floor_double(var1.posZ);
        int var9 = (int)(var5 + 8.0F);
        int var10 = var6 - var9;
        int var11 = var7 - var9;
        int var12 = var8 - var9;
        int var13 = var6 + var9;
        int var14 = var7 + var9;
        int var15 = var8 + var9;
        ChunkCache var16 = new ChunkCache(this, var10, var11, var12, var13, var14, var15);
        return (new Pathfinder(var16)).createEntityPathTo(var1, var2, var3, var4, var5);
    }

    public boolean isBlockProvidingPowerTo(int var1, int var2, int var3, int var4) {
        int var5 = this.getBlockId(var1, var2, var3);
        return var5 == 0 ? false : Block.blocksList[var5].isIndirectlyPoweringTo(this, var1, var2, var3, var4);
    }

    public boolean isBlockGettingPowered(int var1, int var2, int var3) {
        if (this.isBlockProvidingPowerTo(var1, var2 - 1, var3, 0)) {
            return true;
        } else if (this.isBlockProvidingPowerTo(var1, var2 + 1, var3, 1)) {
            return true;
        } else if (this.isBlockProvidingPowerTo(var1, var2, var3 - 1, 2)) {
            return true;
        } else if (this.isBlockProvidingPowerTo(var1, var2, var3 + 1, 3)) {
            return true;
        } else if (this.isBlockProvidingPowerTo(var1 - 1, var2, var3, 4)) {
            return true;
        } else {
            return this.isBlockProvidingPowerTo(var1 + 1, var2, var3, 5);
        }
    }

    public boolean isBlockIndirectlyProvidingPowerTo(int var1, int var2, int var3, int var4) {
        if (this.isBlockNormalCube(var1, var2, var3)) {
            return this.isBlockGettingPowered(var1, var2, var3);
        } else {
            int var5 = this.getBlockId(var1, var2, var3);
            return var5 == 0 ? false : Block.blocksList[var5].isPoweringTo(this, var1, var2, var3, var4);
        }
    }

    public boolean isBlockIndirectlyGettingPowered(int var1, int var2, int var3) {
        if (this.isBlockIndirectlyProvidingPowerTo(var1, var2 - 1, var3, 0)) {
            return true;
        } else if (this.isBlockIndirectlyProvidingPowerTo(var1, var2 + 1, var3, 1)) {
            return true;
        } else if (this.isBlockIndirectlyProvidingPowerTo(var1, var2, var3 - 1, 2)) {
            return true;
        } else if (this.isBlockIndirectlyProvidingPowerTo(var1, var2, var3 + 1, 3)) {
            return true;
        } else if (this.isBlockIndirectlyProvidingPowerTo(var1 - 1, var2, var3, 4)) {
            return true;
        } else {
            return this.isBlockIndirectlyProvidingPowerTo(var1 + 1, var2, var3, 5);
        }
    }

    public EntityPlayer getClosestPlayerToEntity(Entity var1, double var2) {
        return this.getClosestPlayer(var1.posX, var1.posY, var1.posZ, var2);
    }

    public EntityPlayer getClosestPlayer(double var1, double var3, double var5, double var7) {
        double var9 = -1.0D;
        EntityPlayer var11 = null;

        for(int var12 = 0; var12 < this.playerEntities.size(); ++var12) {
            EntityPlayer var13 = (EntityPlayer)this.playerEntities.get(var12);
            double var14 = var13.getDistanceSq(var1, var3, var5);
            if ((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
                var9 = var14;
                var11 = var13;
            }
        }

        return var11;
    }

    public EntityPlayer getPlayerEntityByName(String var1) {
        for(int var2 = 0; var2 < this.playerEntities.size(); ++var2) {
            if (var1.equals(((EntityPlayer)this.playerEntities.get(var2)).username)) {
                return (EntityPlayer)this.playerEntities.get(var2);
            }
        }

        return null;
    }

    public byte[] getChunkData(int var1, int var2, int var3, int var4, int var5, int var6) {
        byte[] var7 = new byte[var4 * var5 * var6 * 5 / 2];
        int var8 = var1 >> 4;
        int var9 = var3 >> 4;
        int var10 = var1 + var4 - 1 >> 4;
        int var11 = var3 + var6 - 1 >> 4;
        int var12 = 0;
        int var13 = var2;
        int var14 = var2 + var5;
        if (var2 < 0) {
            var13 = 0;
        }

        if (var14 > 128) {
            var14 = 128;
        }

        for(int var15 = var8; var15 <= var10; ++var15) {
            int var16 = var1 - var15 * 16;
            int var17 = var1 + var4 - var15 * 16;
            if (var16 < 0) {
                var16 = 0;
            }

            if (var17 > 16) {
                var17 = 16;
            }

            for(int var18 = var9; var18 <= var11; ++var18) {
                int var19 = var3 - var18 * 16;
                int var20 = var3 + var6 - var18 * 16;
                if (var19 < 0) {
                    var19 = 0;
                }

                if (var20 > 16) {
                    var20 = 16;
                }

                var12 = this.getChunkFromChunkCoords(var15, var18).getChunkData(var7, var16, var13, var19, var17, var14, var20, var12);
            }
        }

        return var7;
    }

    public void checkSessionLock() {
        this.worldFile.func_22091_b();
    }

    public void setWorldTime(long var1) {
        this.worldInfo.setWorldTime(var1);
    }

    public void func_32005_b(long var1) {
        long var3 = var1 - this.worldInfo.getWorldTime();

        NextTickListEntry var6;
        for(Iterator var5 = this.scheduledTickSet.iterator(); var5.hasNext(); var6.scheduledTime += var3) {
            var6 = (NextTickListEntry)var5.next();
        }

        this.setWorldTime(var1);
    }

    public long getRandomSeed() {
        return this.worldInfo.getRandomSeed();
    }

    public long getWorldTime() {
        return this.worldInfo.getWorldTime();
    }

    public ChunkCoordinates getSpawnPoint() {
        return new ChunkCoordinates(this.worldInfo.getSpawnX(), this.worldInfo.getSpawnY(), this.worldInfo.getSpawnZ());
    }

    public boolean canMineBlock(EntityPlayer var1, int var2, int var3, int var4) {
        return true;
    }

    public void sendTrackedEntityStatusUpdatePacket(Entity var1, byte var2) {
    }

    public IChunkProvider getChunkProvider() {
        return this.chunkProvider;
    }

    public void playNoteAt(int var1, int var2, int var3, int var4, int var5) {
        int var6 = this.getBlockId(var1, var2, var3);
        if (var6 > 0) {
            Block.blocksList[var6].playBlock(this, var1, var2, var3, var4, var5);
        }

    }

    public ISaveHandler getWorldFile() {
        return this.worldFile;
    }

    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }

    public void updateAllPlayersSleepingFlag() {
        this.allPlayersSleeping = !this.playerEntities.isEmpty();
        Iterator var1 = this.playerEntities.iterator();

        while(var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (!var2.func_22057_E()) {
                this.allPlayersSleeping = false;
                break;
            }
        }

    }

    protected void wakeUpAllPlayers() {
        this.allPlayersSleeping = false;
        Iterator var1 = this.playerEntities.iterator();

        while(var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (var2.func_22057_E()) {
                var2.wakeUpPlayer(false, false, true);
            }
        }

        this.clearWeather();
    }

    public boolean isAllPlayersFullyAsleep() {
        if (this.allPlayersSleeping && !this.singleplayerWorld) {
            Iterator var1 = this.playerEntities.iterator();

            EntityPlayer var2;
            do {
                if (!var1.hasNext()) {
                    return true;
                }

                var2 = (EntityPlayer)var1.next();
            } while(var2.isPlayerFullyAsleep());

            return false;
        } else {
            return false;
        }
    }

    public float func_27065_c(float var1) {
        return (this.field_27077_D + (this.field_27076_E - this.field_27077_D) * var1) * this.func_27074_d(var1);
    }

    public float func_27074_d(float var1) {
        return this.field_27079_B + (this.field_27078_C - this.field_27079_B) * var1;
    }

    public boolean func_27067_u() {
        return (double)this.func_27065_c(1.0F) > 0.9D;
    }

    public boolean func_27068_v() {
        return (double)this.func_27074_d(1.0F) > 0.2D;
    }

    public boolean canLightningStrikeAt(int var1, int var2, int var3) {
        if (!this.func_27068_v()) {
            return false;
        } else if (!this.canBlockSeeTheSky(var1, var2, var3)) {
            return false;
        } else if (this.getTopSolidOrLiquidBlock(var1, var3) > var2) {
            return false;
        } else {
            BiomeGenBase var4 = this.getWorldChunkManager().getBiomeGenAt(var1, var3);
            return var4.getEnableSnow() ? false : var4.canSpawnLightningBolt();
        }
    }

    public void func_28102_a(String var1, MapDataBase var2) {
        this.field_28105_z.func_28177_a(var1, var2);
    }

    public MapDataBase func_28103_a(Class var1, String var2) {
        return this.field_28105_z.func_28178_a(var1, var2);
    }

    public int func_28104_b(String var1) {
        return this.field_28105_z.func_28173_a(var1);
    }

    public void func_28097_e(int var1, int var2, int var3, int var4, int var5) {
        this.func_28101_a((EntityPlayer)null, var1, var2, var3, var4, var5);
    }

    public void func_28101_a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.worldAccesses.size(); ++var7) {
            ((IWorldAccess)this.worldAccesses.get(var7)).func_28133_a(var1, var2, var3, var4, var5, var6);
        }

    }
}
