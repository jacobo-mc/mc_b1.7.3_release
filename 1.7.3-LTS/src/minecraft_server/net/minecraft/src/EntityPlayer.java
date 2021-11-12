package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public abstract class EntityPlayer extends EntityLiving {
    public InventoryPlayer inventory = new InventoryPlayer(this);
    public Container personalCraftingInventory;
    public Container currentCraftingInventory;
    public byte field_9152_am = 0;
    public int score = 0;
    public float field_9150_ao;
    public float field_9149_ap;
    public boolean isSwinging = false;
    public int swingProgressInt = 0;
    public String username;
    public int dimension;
    public double field_20047_ay;
    public double field_20046_az;
    public double field_20051_aA;
    public double field_20050_aB;
    public double field_20049_aC;
    public double field_20048_aD;
    protected boolean sleeping;
    public ChunkCoordinates playerLocation;
    private int sleepTimer;
    public float field_22066_z;
    public float field_22067_A;
    private ChunkCoordinates spawnChunk;
    private ChunkCoordinates field_27995_d;
    public int timeUntilPortal = 20;
    protected boolean inPortal = false;
    public float timeInPortal;
    private int damageRemainder = 0;
    public EntityFish fishEntity = null;

    public EntityPlayer(World var1) {
        super(var1);
        this.personalCraftingInventory = new ContainerPlayer(this.inventory, !var1.singleplayerWorld);
        this.currentCraftingInventory = this.personalCraftingInventory;
        this.yOffset = 1.62F;
        ChunkCoordinates var2 = var1.getSpawnPoint();
        this.setLocationAndAngles((double)var2.posX + 0.5D, (double)(var2.posY + 1), (double)var2.posZ + 0.5D, 0.0F, 0.0F);
        this.health = 20;
        this.entityType = "humanoid";
        this.field_9117_aI = 180.0F;
        this.fireResistance = 20;
        this.texture = "/mob/char.png";
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (byte)0);
    }

    public void onUpdate() {
        if (this.func_22057_E()) {
            ++this.sleepTimer;
            if (this.sleepTimer > 100) {
                this.sleepTimer = 100;
            }

            if (!this.worldObj.singleplayerWorld) {
                if (!this.isInBed()) {
                    this.wakeUpPlayer(true, true, false);
                } else if (this.worldObj.isDaytime()) {
                    this.wakeUpPlayer(false, true, true);
                }
            }
        } else if (this.sleepTimer > 0) {
            ++this.sleepTimer;
            if (this.sleepTimer >= 110) {
                this.sleepTimer = 0;
            }
        }

        super.onUpdate();
        if (!this.worldObj.singleplayerWorld && this.currentCraftingInventory != null && !this.currentCraftingInventory.canInteractWith(this)) {
            this.usePersonalCraftingInventory();
            this.currentCraftingInventory = this.personalCraftingInventory;
        }

        this.field_20047_ay = this.field_20050_aB;
        this.field_20046_az = this.field_20049_aC;
        this.field_20051_aA = this.field_20048_aD;
        double var1 = this.posX - this.field_20050_aB;
        double var3 = this.posY - this.field_20049_aC;
        double var5 = this.posZ - this.field_20048_aD;
        double var7 = 10.0D;
        if (var1 > var7) {
            this.field_20047_ay = this.field_20050_aB = this.posX;
        }

        if (var5 > var7) {
            this.field_20051_aA = this.field_20048_aD = this.posZ;
        }

        if (var3 > var7) {
            this.field_20046_az = this.field_20049_aC = this.posY;
        }

        if (var1 < -var7) {
            this.field_20047_ay = this.field_20050_aB = this.posX;
        }

        if (var5 < -var7) {
            this.field_20051_aA = this.field_20048_aD = this.posZ;
        }

        if (var3 < -var7) {
            this.field_20046_az = this.field_20049_aC = this.posY;
        }

        this.field_20050_aB += var1 * 0.25D;
        this.field_20048_aD += var5 * 0.25D;
        this.field_20049_aC += var3 * 0.25D;
        this.addStat(StatList.field_25114_j, 1);
        if (this.ridingEntity == null) {
            this.field_27995_d = null;
        }

    }

    protected boolean isMovementBlocked() {
        return this.health <= 0 || this.func_22057_E();
    }

    protected void usePersonalCraftingInventory() {
        this.currentCraftingInventory = this.personalCraftingInventory;
    }

    public void updateRidden() {
        double var1 = this.posX;
        double var3 = this.posY;
        double var5 = this.posZ;
        super.updateRidden();
        this.field_9150_ao = this.field_9149_ap;
        this.field_9149_ap = 0.0F;
        this.func_27015_h(this.posX - var1, this.posY - var3, this.posZ - var5);
    }

    protected void updatePlayerActionState() {
        if (this.isSwinging) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= 8) {
                this.swingProgressInt = 0;
                this.isSwinging = false;
            }
        } else {
            this.swingProgressInt = 0;
        }

        this.swingProgress = (float)this.swingProgressInt / 8.0F;
    }

    public void onLivingUpdate() {
        if (this.worldObj.difficultySetting == 0 && this.health < 20 && this.ticksExisted % 20 * 12 == 0) {
            this.heal(1);
        }

        this.inventory.decrementAnimations();
        this.field_9150_ao = this.field_9149_ap;
        super.onLivingUpdate();
        float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float var2 = (float)Math.atan(-this.motionY * 0.20000000298023224D) * 15.0F;
        if (var1 > 0.1F) {
            var1 = 0.1F;
        }

        if (!this.onGround || this.health <= 0) {
            var1 = 0.0F;
        }

        if (this.onGround || this.health <= 0) {
            var2 = 0.0F;
        }

        this.field_9149_ap += (var1 - this.field_9149_ap) * 0.4F;
        this.field_9101_aY += (var2 - this.field_9101_aY) * 0.8F;
        if (this.health > 0) {
            List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.0D, 0.0D, 1.0D));
            if (var3 != null) {
                for(int var4 = 0; var4 < var3.size(); ++var4) {
                    Entity var5 = (Entity)var3.get(var4);
                    if (!var5.isDead) {
                        this.func_171_h(var5);
                    }
                }
            }
        }

    }

    private void func_171_h(Entity var1) {
        var1.onCollideWithPlayer(this);
    }

    public void onDeath(Entity var1) {
        super.onDeath(var1);
        this.setSize(0.2F, 0.2F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionY = 0.10000000149011612D;
        if (this.username.equals("Notch")) {
            this.dropPlayerItemWithRandomChoice(new ItemStack(Item.appleRed, 1), true);
        }

        this.inventory.dropAllItems();
        if (var1 != null) {
            this.motionX = (double)(-MathHelper.cos((this.attackedAtYaw + this.rotationYaw) * 3.1415927F / 180.0F) * 0.1F);
            this.motionZ = (double)(-MathHelper.sin((this.attackedAtYaw + this.rotationYaw) * 3.1415927F / 180.0F) * 0.1F);
        } else {
            this.motionX = this.motionZ = 0.0D;
        }

        this.yOffset = 0.1F;
        this.addStat(StatList.field_25098_u, 1);
    }

    public void addToPlayerScore(Entity var1, int var2) {
        this.score += var2;
        if (var1 instanceof EntityPlayer) {
            this.addStat(StatList.field_25096_w, 1);
        } else {
            this.addStat(StatList.field_25097_v, 1);
        }

    }

    public void dropCurrentItem() {
        this.dropPlayerItemWithRandomChoice(this.inventory.decrStackSize(this.inventory.currentItem, 1), false);
    }

    public void dropPlayerItem(ItemStack var1) {
        this.dropPlayerItemWithRandomChoice(var1, false);
    }

    public void dropPlayerItemWithRandomChoice(ItemStack var1, boolean var2) {
        if (var1 != null) {
            EntityItem var3 = new EntityItem(this.worldObj, this.posX, this.posY - 0.30000001192092896D + (double)this.getEyeHeight(), this.posZ, var1);
            var3.delayBeforeCanPickup = 40;
            float var4 = 0.1F;
            float var5;
            if (var2) {
                var5 = this.rand.nextFloat() * 0.5F;
                float var6 = this.rand.nextFloat() * 3.1415927F * 2.0F;
                var3.motionX = (double)(-MathHelper.sin(var6) * var5);
                var3.motionZ = (double)(MathHelper.cos(var6) * var5);
                var3.motionY = 0.20000000298023224D;
            } else {
                var4 = 0.3F;
                var3.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F) * var4);
                var3.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F) * var4);
                var3.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F) * var4 + 0.1F);
                var4 = 0.02F;
                var5 = this.rand.nextFloat() * 3.1415927F * 2.0F;
                var4 *= this.rand.nextFloat();
                var3.motionX += Math.cos((double)var5) * (double)var4;
                var3.motionY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
                var3.motionZ += Math.sin((double)var5) * (double)var4;
            }

            this.joinEntityItemWithWorld(var3);
            this.addStat(StatList.field_25103_r, 1);
        }
    }

    protected void joinEntityItemWithWorld(EntityItem var1) {
        this.worldObj.entityJoinedWorld(var1);
    }

    public float getCurrentPlayerStrVsBlock(Block var1) {
        float var2 = this.inventory.getStrVsBlock(var1);
        if (this.isInsideOfMaterial(Material.water)) {
            var2 /= 5.0F;
        }

        if (!this.onGround) {
            var2 /= 5.0F;
        }

        return var2;
    }

    public boolean canHarvestBlock(Block var1) {
        return this.inventory.canHarvestBlock(var1);
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Inventory");
        this.inventory.readFromNBT(var2);
        this.dimension = var1.getInteger("Dimension");
        this.sleeping = var1.getBoolean("Sleeping");
        this.sleepTimer = var1.getShort("SleepTimer");
        if (this.sleeping) {
            this.playerLocation = new ChunkCoordinates(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.wakeUpPlayer(true, true, false);
        }

        if (var1.hasKey("SpawnX") && var1.hasKey("SpawnY") && var1.hasKey("SpawnZ")) {
            this.spawnChunk = new ChunkCoordinates(var1.getInteger("SpawnX"), var1.getInteger("SpawnY"), var1.getInteger("SpawnZ"));
        }

    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setTag("Inventory", this.inventory.writeToNBT(new NBTTagList()));
        var1.setInteger("Dimension", this.dimension);
        var1.setBoolean("Sleeping", this.sleeping);
        var1.setShort("SleepTimer", (short)this.sleepTimer);
        if (this.spawnChunk != null) {
            var1.setInteger("SpawnX", this.spawnChunk.posX);
            var1.setInteger("SpawnY", this.spawnChunk.posY);
            var1.setInteger("SpawnZ", this.spawnChunk.posZ);
        }

    }

    public void displayGUIChest(IInventory var1) {
    }

    public void displayWorkbenchGUI(int var1, int var2, int var3) {
    }

    public void onItemPickup(Entity var1, int var2) {
    }

    public float getEyeHeight() {
        return 0.12F;
    }

    protected void resetHeight() {
        this.yOffset = 1.62F;
    }

    public boolean attackEntityFrom(Entity var1, int var2) {
        this.age = 0;
        if (this.health <= 0) {
            return false;
        } else {
            if (this.func_22057_E() && !this.worldObj.singleplayerWorld) {
                this.wakeUpPlayer(true, true, false);
            }

            if (var1 instanceof EntityMob || var1 instanceof EntityArrow) {
                if (this.worldObj.difficultySetting == 0) {
                    var2 = 0;
                }

                if (this.worldObj.difficultySetting == 1) {
                    var2 = var2 / 3 + 1;
                }

                if (this.worldObj.difficultySetting == 3) {
                    var2 = var2 * 3 / 2;
                }
            }

            if (var2 == 0) {
                return false;
            } else {
                Object var3 = var1;
                if (var1 instanceof EntityArrow && ((EntityArrow)var1).owner != null) {
                    var3 = ((EntityArrow)var1).owner;
                }

                if (var3 instanceof EntityLiving) {
                    this.func_25047_a((EntityLiving)var3, false);
                }

                this.addStat(StatList.field_25100_t, var2);
                return super.attackEntityFrom(var1, var2);
            }
        }
    }

    protected boolean isPVPEnabled() {
        return false;
    }

    protected void func_25047_a(EntityLiving var1, boolean var2) {
        if (!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
            if (var1 instanceof EntityWolf) {
                EntityWolf var3 = (EntityWolf)var1;
                if (var3.func_25030_y() && this.username.equals(var3.getOwner())) {
                    return;
                }
            }

            if (!(var1 instanceof EntityPlayer) || this.isPVPEnabled()) {
                List var7 = this.worldObj.getEntitiesWithinAABB(EntityWolf.class, AxisAlignedBB.getBoundingBoxFromPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));
                Iterator var4 = var7.iterator();

                while(true) {
                    EntityWolf var6;
                    do {
                        do {
                            do {
                                do {
                                    if (!var4.hasNext()) {
                                        return;
                                    }

                                    Entity var5 = (Entity)var4.next();
                                    var6 = (EntityWolf)var5;
                                } while(!var6.func_25030_y());
                            } while(var6.getEntityToAttack() != null);
                        } while(!this.username.equals(var6.getOwner()));
                    } while(var2 && var6.getIsSitting());

                    var6.setIsSitting(false);
                    var6.setEntityToAttack(var1);
                }
            }
        }
    }

    protected void damageEntity(int var1) {
        int var2 = 25 - this.inventory.getTotalArmorValue();
        int var3 = var1 * var2 + this.damageRemainder;
        this.inventory.damageArmor(var1);
        var1 = var3 / 25;
        this.damageRemainder = var3 % 25;
        super.damageEntity(var1);
    }

    public void displayGUIFurnace(TileEntityFurnace var1) {
    }

    public void displayGUIDispenser(TileEntityDispenser var1) {
    }

    public void displayGUIEditSign(TileEntitySign var1) {
    }

    public void useCurrentItemOnEntity(Entity var1) {
        if (!var1.interact(this)) {
            ItemStack var2 = this.getCurrentEquippedItem();
            if (var2 != null && var1 instanceof EntityLiving) {
                var2.useItemOnEntity((EntityLiving)var1);
                if (var2.stackSize <= 0) {
                    var2.func_577_a(this);
                    this.destroyCurrentEquippedItem();
                }
            }

        }
    }

    public ItemStack getCurrentEquippedItem() {
        return this.inventory.getCurrentItem();
    }

    public void destroyCurrentEquippedItem() {
        this.inventory.setInventorySlotContents(this.inventory.currentItem, (ItemStack)null);
    }

    public double getYOffset() {
        return (double)(this.yOffset - 0.5F);
    }

    public void swingItem() {
        this.swingProgressInt = -1;
        this.isSwinging = true;
    }

    public void attackTargetEntityWithCurrentItem(Entity var1) {
        int var2 = this.inventory.getDamageVsEntity(var1);
        if (var2 > 0) {
            if (this.motionY < 0.0D) {
                ++var2;
            }

            var1.attackEntityFrom(this, var2);
            ItemStack var3 = this.getCurrentEquippedItem();
            if (var3 != null && var1 instanceof EntityLiving) {
                var3.hitEntity((EntityLiving)var1, this);
                if (var3.stackSize <= 0) {
                    var3.func_577_a(this);
                    this.destroyCurrentEquippedItem();
                }
            }

            if (var1 instanceof EntityLiving) {
                if (var1.isEntityAlive()) {
                    this.func_25047_a((EntityLiving)var1, true);
                }

                this.addStat(StatList.field_25102_s, var2);
            }
        }

    }

    public void onItemStackChanged(ItemStack var1) {
    }

    public void setEntityDead() {
        super.setEntityDead();
        this.personalCraftingInventory.onCraftGuiClosed(this);
        if (this.currentCraftingInventory != null) {
            this.currentCraftingInventory.onCraftGuiClosed(this);
        }

    }

    public boolean isEntityInsideOpaqueBlock() {
        return !this.sleeping && super.isEntityInsideOpaqueBlock();
    }

    public EnumStatus goToSleep(int var1, int var2, int var3) {
        if (!this.worldObj.singleplayerWorld) {
            label53: {
                if (!this.func_22057_E() && this.isEntityAlive()) {
                    if (this.worldObj.worldProvider.field_6167_c) {
                        return EnumStatus.NOT_POSSIBLE_HERE;
                    }

                    if (this.worldObj.isDaytime()) {
                        return EnumStatus.NOT_POSSIBLE_NOW;
                    }

                    if (Math.abs(this.posX - (double)var1) <= 3.0D && Math.abs(this.posY - (double)var2) <= 2.0D && Math.abs(this.posZ - (double)var3) <= 3.0D) {
                        break label53;
                    }

                    return EnumStatus.TOO_FAR_AWAY;
                }

                return EnumStatus.OTHER_PROBLEM;
            }
        }

        this.setSize(0.2F, 0.2F);
        this.yOffset = 0.2F;
        if (this.worldObj.blockExists(var1, var2, var3)) {
            int var4 = this.worldObj.getBlockMetadata(var1, var2, var3);
            int var5 = BlockBed.func_22019_c(var4);
            float var6 = 0.5F;
            float var7 = 0.5F;
            switch(var5) {
            case 0:
                var7 = 0.9F;
                break;
            case 1:
                var6 = 0.1F;
                break;
            case 2:
                var7 = 0.1F;
                break;
            case 3:
                var6 = 0.9F;
            }

            this.func_22059_e(var5);
            this.setPosition((double)((float)var1 + var6), (double)((float)var2 + 0.9375F), (double)((float)var3 + var7));
        } else {
            this.setPosition((double)((float)var1 + 0.5F), (double)((float)var2 + 0.9375F), (double)((float)var3 + 0.5F));
        }

        this.sleeping = true;
        this.sleepTimer = 0;
        this.playerLocation = new ChunkCoordinates(var1, var2, var3);
        this.motionX = this.motionZ = this.motionY = 0.0D;
        if (!this.worldObj.singleplayerWorld) {
            this.worldObj.updateAllPlayersSleepingFlag();
        }

        return EnumStatus.OK;
    }

    private void func_22059_e(int var1) {
        this.field_22066_z = 0.0F;
        this.field_22067_A = 0.0F;
        switch(var1) {
        case 0:
            this.field_22067_A = -1.8F;
            break;
        case 1:
            this.field_22066_z = 1.8F;
            break;
        case 2:
            this.field_22067_A = 1.8F;
            break;
        case 3:
            this.field_22066_z = -1.8F;
        }

    }

    public void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
        this.setSize(0.6F, 1.8F);
        this.resetHeight();
        ChunkCoordinates var4 = this.playerLocation;
        ChunkCoordinates var5 = this.playerLocation;
        if (var4 != null && this.worldObj.getBlockId(var4.posX, var4.posY, var4.posZ) == Block.bed.blockID) {
            BlockBed.func_22022_a(this.worldObj, var4.posX, var4.posY, var4.posZ, false);
            var5 = BlockBed.func_22021_g(this.worldObj, var4.posX, var4.posY, var4.posZ, 0);
            if (var5 == null) {
                var5 = new ChunkCoordinates(var4.posX, var4.posY + 1, var4.posZ);
            }

            this.setPosition((double)((float)var5.posX + 0.5F), (double)((float)var5.posY + this.yOffset + 0.1F), (double)((float)var5.posZ + 0.5F));
        }

        this.sleeping = false;
        if (!this.worldObj.singleplayerWorld && var2) {
            this.worldObj.updateAllPlayersSleepingFlag();
        }

        if (var1) {
            this.sleepTimer = 0;
        } else {
            this.sleepTimer = 100;
        }

        if (var3) {
            this.setSpawnChunk(this.playerLocation);
        }

    }

    private boolean isInBed() {
        return this.worldObj.getBlockId(this.playerLocation.posX, this.playerLocation.posY, this.playerLocation.posZ) == Block.bed.blockID;
    }

    public static ChunkCoordinates func_25051_a(World var0, ChunkCoordinates var1) {
        IChunkProvider var2 = var0.getChunkProvider();
        var2.loadChunk(var1.posX - 3 >> 4, var1.posZ - 3 >> 4);
        var2.loadChunk(var1.posX + 3 >> 4, var1.posZ - 3 >> 4);
        var2.loadChunk(var1.posX - 3 >> 4, var1.posZ + 3 >> 4);
        var2.loadChunk(var1.posX + 3 >> 4, var1.posZ + 3 >> 4);
        if (var0.getBlockId(var1.posX, var1.posY, var1.posZ) != Block.bed.blockID) {
            return null;
        } else {
            ChunkCoordinates var3 = BlockBed.func_22021_g(var0, var1.posX, var1.posY, var1.posZ, 0);
            return var3;
        }
    }

    public boolean func_22057_E() {
        return this.sleeping;
    }

    public boolean isPlayerFullyAsleep() {
        return this.sleeping && this.sleepTimer >= 100;
    }

    public void func_22061_a(String var1) {
    }

    public ChunkCoordinates getSpawnChunk() {
        return this.spawnChunk;
    }

    public void setSpawnChunk(ChunkCoordinates var1) {
        if (var1 != null) {
            this.spawnChunk = new ChunkCoordinates(var1);
        } else {
            this.spawnChunk = null;
        }

    }

    public void func_27017_a(StatBase var1) {
        this.addStat(var1, 1);
    }

    public void addStat(StatBase var1, int var2) {
    }

    protected void jump() {
        super.jump();
        this.addStat(StatList.field_25106_q, 1);
    }

    public void moveEntityWithHeading(float var1, float var2) {
        double var3 = this.posX;
        double var5 = this.posY;
        double var7 = this.posZ;
        super.moveEntityWithHeading(var1, var2);
        this.func_25045_g(this.posX - var3, this.posY - var5, this.posZ - var7);
    }

    private void func_25045_g(double var1, double var3, double var5) {
        if (this.ridingEntity == null) {
            int var7;
            if (this.isInsideOfMaterial(Material.water)) {
                var7 = Math.round(MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.addStat(StatList.field_25108_p, var7);
                }
            } else if (this.isInWater()) {
                var7 = Math.round(MathHelper.sqrt_double(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.addStat(StatList.field_25112_l, var7);
                }
            } else if (this.isOnLadder()) {
                if (var3 > 0.0D) {
                    this.addStat(StatList.field_25110_n, (int)Math.round(var3 * 100.0D));
                }
            } else if (this.onGround) {
                var7 = Math.round(MathHelper.sqrt_double(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.addStat(StatList.field_25113_k, var7);
                }
            } else {
                var7 = Math.round(MathHelper.sqrt_double(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 25) {
                    this.addStat(StatList.field_25109_o, var7);
                }
            }

        }
    }

    private void func_27015_h(double var1, double var3, double var5) {
        if (this.ridingEntity != null) {
            int var7 = Math.round(MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
            if (var7 > 0) {
                if (this.ridingEntity instanceof EntityMinecart) {
                    this.addStat(StatList.field_27095_r, var7);
                    if (this.field_27995_d == null) {
                        this.field_27995_d = new ChunkCoordinates(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
                    } else if (this.field_27995_d.getSqDistanceTo(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) >= 1000.0D) {
                        this.addStat(AchievementList.field_27102_q, 1);
                    }
                } else if (this.ridingEntity instanceof EntityBoat) {
                    this.addStat(StatList.field_27094_s, var7);
                } else if (this.ridingEntity instanceof EntityPig) {
                    this.addStat(StatList.field_27093_t, var7);
                }
            }
        }

    }

    protected void fall(float var1) {
        if (var1 >= 2.0F) {
            this.addStat(StatList.field_25111_m, (int)Math.round((double)var1 * 100.0D));
        }

        super.fall(var1);
    }

    public void func_27010_a(EntityLiving var1) {
        if (var1 instanceof EntityMob) {
            this.func_27017_a(AchievementList.field_27100_s);
        }

    }

    public void setInPortal() {
        if (this.timeUntilPortal > 0) {
            this.timeUntilPortal = 10;
        } else {
            this.inPortal = true;
        }
    }
}
