package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class EntityWolf extends EntityAnimal {
    private boolean field_25039_a = false;
    private float field_25038_b;
    private float field_25044_c;
    private boolean isWet;
    private boolean field_25042_g;
    private float field_25041_h;
    private float field_25040_i;

    public EntityWolf(World var1) {
        super(var1);
        this.texture = "/mob/wolf.png";
        this.setSize(0.8F, 0.8F);
        this.moveSpeed = 1.1F;
        this.health = 8;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (byte)0);
        this.dataWatcher.addObject(17, "");
        this.dataWatcher.addObject(18, new Integer(this.health));
    }

    protected boolean func_25017_l() {
        return false;
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Angry", this.getIsAngry());
        var1.setBoolean("Sitting", this.getIsSitting());
        if (this.getOwner() == null) {
            var1.setString("Owner", "");
        } else {
            var1.setString("Owner", this.getOwner());
        }

    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setIsAngry(var1.getBoolean("Angry"));
        this.setIsSitting(var1.getBoolean("Sitting"));
        String var2 = var1.getString("Owner");
        if (var2.length() > 0) {
            this.setOwner(var2);
            this.setIsTamed(true);
        }

    }

    protected boolean func_25020_s() {
        return !this.func_25030_y();
    }

    protected String getLivingSound() {
        if (this.getIsAngry()) {
            return "mob.wolf.growl";
        } else if (this.rand.nextInt(3) == 0) {
            return this.func_25030_y() && this.dataWatcher.getWatchableObjectInteger(18) < 10 ? "mob.wolf.whine" : "mob.wolf.panting";
        } else {
            return "mob.wolf.bark";
        }
    }

    protected String getHurtSound() {
        return "mob.wolf.hurt";
    }

    protected String getDeathSound() {
        return "mob.wolf.death";
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected int getDropItemId() {
        return -1;
    }

    protected void updatePlayerActionState() {
        super.updatePlayerActionState();
        if (!this.hasAttacked && !this.getGotPath() && this.func_25030_y() && this.ridingEntity == null) {
            EntityPlayer var3 = this.worldObj.getPlayerEntityByName(this.getOwner());
            if (var3 != null) {
                float var2 = var3.getDistanceToEntity(this);
                if (var2 > 5.0F) {
                    this.setPathEntity(var3, var2);
                }
            } else if (!this.isInWater()) {
                this.setIsSitting(true);
            }
        } else if (this.playerToAttack == null && !this.getGotPath() && !this.func_25030_y() && this.worldObj.rand.nextInt(100) == 0) {
            List var1 = this.worldObj.getEntitiesWithinAABB(EntitySheep.class, AxisAlignedBB.getBoundingBoxFromPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));
            if (!var1.isEmpty()) {
                this.setEntityToAttack((Entity)var1.get(this.worldObj.rand.nextInt(var1.size())));
            }
        }

        if (this.isInWater()) {
            this.setIsSitting(false);
        }

        if (!this.worldObj.singleplayerWorld) {
            this.dataWatcher.updateObject(18, this.health);
        }

    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.field_25039_a = false;
        if (this.func_25021_O() && !this.getGotPath() && !this.getIsAngry()) {
            Entity var1 = this.getCurrentTarget();
            if (var1 instanceof EntityPlayer) {
                EntityPlayer var2 = (EntityPlayer)var1;
                ItemStack var3 = var2.inventory.getCurrentItem();
                if (var3 != null) {
                    if (!this.func_25030_y() && var3.itemID == Item.bone.shiftedIndex) {
                        this.field_25039_a = true;
                    } else if (this.func_25030_y() && Item.itemsList[var3.itemID] instanceof ItemFood) {
                        this.field_25039_a = ((ItemFood)Item.itemsList[var3.itemID]).func_25010_k();
                    }
                }
            }
        }

        if (!this.isMultiplayerEntity && this.isWet && !this.field_25042_g && !this.getGotPath() && this.onGround) {
            this.field_25042_g = true;
            this.field_25041_h = 0.0F;
            this.field_25040_i = 0.0F;
            this.worldObj.sendTrackedEntityStatusUpdatePacket(this, (byte)8);
        }

    }

    public void onUpdate() {
        super.onUpdate();
        this.field_25044_c = this.field_25038_b;
        if (this.field_25039_a) {
            this.field_25038_b += (1.0F - this.field_25038_b) * 0.4F;
        } else {
            this.field_25038_b += (0.0F - this.field_25038_b) * 0.4F;
        }

        if (this.field_25039_a) {
            this.numTicksToChaseTarget = 10;
        }

        if (this.func_27008_Y()) {
            this.isWet = true;
            this.field_25042_g = false;
            this.field_25041_h = 0.0F;
            this.field_25040_i = 0.0F;
        } else if ((this.isWet || this.field_25042_g) && this.field_25042_g) {
            if (this.field_25041_h == 0.0F) {
                this.worldObj.playSoundAtEntity(this, "mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.field_25040_i = this.field_25041_h;
            this.field_25041_h += 0.05F;
            if (this.field_25040_i >= 2.0F) {
                this.isWet = false;
                this.field_25042_g = false;
                this.field_25040_i = 0.0F;
                this.field_25041_h = 0.0F;
            }

            if (this.field_25041_h > 0.4F) {
                float var1 = (float)this.boundingBox.minY;
                int var2 = (int)(MathHelper.sin((this.field_25041_h - 0.4F) * 3.1415927F) * 7.0F);

                for(int var3 = 0; var3 < var2; ++var3) {
                    float var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.worldObj.spawnParticle("splash", this.posX + (double)var4, (double)(var1 + 0.8F), this.posZ + (double)var5, this.motionX, this.motionY, this.motionZ);
                }
            }
        }

    }

    public float getEyeHeight() {
        return this.height * 0.8F;
    }

    protected int func_25018_n_() {
        return this.getIsSitting() ? 20 : super.func_25018_n_();
    }

    private void setPathEntity(Entity var1, float var2) {
        PathEntity var3 = this.worldObj.getPathToEntity(this, var1, 16.0F);
        if (var3 == null && var2 > 12.0F) {
            int var4 = MathHelper.floor_double(var1.posX) - 2;
            int var5 = MathHelper.floor_double(var1.posZ) - 2;
            int var6 = MathHelper.floor_double(var1.boundingBox.minY);

            for(int var7 = 0; var7 <= 4; ++var7) {
                for(int var8 = 0; var8 <= 4; ++var8) {
                    if ((var7 < 1 || var8 < 1 || var7 > 3 || var8 > 3) && this.worldObj.isBlockNormalCube(var4 + var7, var6 - 1, var5 + var8) && !this.worldObj.isBlockNormalCube(var4 + var7, var6, var5 + var8) && !this.worldObj.isBlockNormalCube(var4 + var7, var6 + 1, var5 + var8)) {
                        this.setLocationAndAngles((double)((float)(var4 + var7) + 0.5F), (double)var6, (double)((float)(var5 + var8) + 0.5F), this.rotationYaw, this.rotationPitch);
                        return;
                    }
                }
            }
        } else {
            this.setPathToEntity(var3);
        }

    }

    protected boolean func_25026_u() {
        return this.getIsSitting() || this.field_25042_g;
    }

    public boolean attackEntityFrom(Entity var1, int var2) {
        this.setIsSitting(false);
        if (var1 != null && !(var1 instanceof EntityPlayer) && !(var1 instanceof EntityArrow)) {
            var2 = (var2 + 1) / 2;
        }

        if (!super.attackEntityFrom((Entity)var1, var2)) {
            return false;
        } else {
            if (!this.func_25030_y() && !this.getIsAngry()) {
                if (var1 instanceof EntityPlayer) {
                    this.setIsAngry(true);
                    this.playerToAttack = (Entity)var1;
                }

                if (var1 instanceof EntityArrow && ((EntityArrow)var1).owner != null) {
                    var1 = ((EntityArrow)var1).owner;
                }

                if (var1 instanceof EntityLiving) {
                    List var3 = this.worldObj.getEntitiesWithinAABB(EntityWolf.class, AxisAlignedBB.getBoundingBoxFromPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));
                    Iterator var4 = var3.iterator();

                    while(var4.hasNext()) {
                        Entity var5 = (Entity)var4.next();
                        EntityWolf var6 = (EntityWolf)var5;
                        if (!var6.func_25030_y() && var6.playerToAttack == null) {
                            var6.playerToAttack = (Entity)var1;
                            if (var1 instanceof EntityPlayer) {
                                var6.setIsAngry(true);
                            }
                        }
                    }
                }
            } else if (var1 != this && var1 != null) {
                if (this.func_25030_y() && var1 instanceof EntityPlayer && ((EntityPlayer)var1).username.equalsIgnoreCase(this.getOwner())) {
                    return true;
                }

                this.playerToAttack = (Entity)var1;
            }

            return true;
        }
    }

    protected Entity findPlayerToAttack() {
        return this.getIsAngry() ? this.worldObj.getClosestPlayerToEntity(this, 16.0D) : null;
    }

    protected void attackEntity(Entity var1, float var2) {
        if (var2 > 2.0F && var2 < 6.0F && this.rand.nextInt(10) == 0) {
            if (this.onGround) {
                double var8 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var8 * var8 + var5 * var5);
                this.motionX = var8 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.motionY = 0.4000000059604645D;
            }
        } else if ((double)var2 < 1.5D && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            byte var3 = 2;
            if (this.func_25030_y()) {
                var3 = 4;
            }

            var1.attackEntityFrom(this, var3);
        }

    }

    public boolean interact(EntityPlayer var1) {
        ItemStack var2 = var1.inventory.getCurrentItem();
        if (!this.func_25030_y()) {
            if (var2 != null && var2.itemID == Item.bone.shiftedIndex && !this.getIsAngry()) {
                --var2.stackSize;
                if (var2.stackSize <= 0) {
                    var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
                }

                if (!this.worldObj.singleplayerWorld) {
                    if (this.rand.nextInt(3) == 0) {
                        this.setIsTamed(true);
                        this.setPathToEntity((PathEntity)null);
                        this.setIsSitting(true);
                        this.health = 20;
                        this.setOwner(var1.username);
                        this.isNowTamed(true);
                        this.worldObj.sendTrackedEntityStatusUpdatePacket(this, (byte)7);
                    } else {
                        this.isNowTamed(false);
                        this.worldObj.sendTrackedEntityStatusUpdatePacket(this, (byte)6);
                    }
                }

                return true;
            }
        } else {
            if (var2 != null && Item.itemsList[var2.itemID] instanceof ItemFood) {
                ItemFood var3 = (ItemFood)Item.itemsList[var2.itemID];
                if (var3.func_25010_k() && this.dataWatcher.getWatchableObjectInteger(18) < 20) {
                    --var2.stackSize;
                    if (var2.stackSize <= 0) {
                        var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
                    }

                    this.heal(((ItemFood)Item.porkRaw).getHealAmount());
                    return true;
                }
            }

            if (var1.username.equalsIgnoreCase(this.getOwner())) {
                if (!this.worldObj.singleplayerWorld) {
                    this.setIsSitting(!this.getIsSitting());
                    this.isJumping = false;
                    this.setPathToEntity((PathEntity)null);
                }

                return true;
            }
        }

        return false;
    }

    void isNowTamed(boolean var1) {
        String var2 = "heart";
        if (!var1) {
            var2 = "smoke";
        }

        for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(var2, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var4, var6, var8);
        }

    }

    public int getMaxSpawnedInChunk() {
        return 8;
    }

    public String getOwner() {
        return this.dataWatcher.getWatchableObjectString(17);
    }

    public void setOwner(String var1) {
        this.dataWatcher.updateObject(17, var1);
    }

    public boolean getIsSitting() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setIsSitting(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);
        if (var1) {
            this.dataWatcher.updateObject(16, (byte)(var2 | 1));
        } else {
            this.dataWatcher.updateObject(16, (byte)(var2 & -2));
        }

    }

    public boolean getIsAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setIsAngry(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);
        if (var1) {
            this.dataWatcher.updateObject(16, (byte)(var2 | 2));
        } else {
            this.dataWatcher.updateObject(16, (byte)(var2 & -3));
        }

    }

    public boolean func_25030_y() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 4) != 0;
    }

    public void setIsTamed(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);
        if (var1) {
            this.dataWatcher.updateObject(16, (byte)(var2 | 4));
        } else {
            this.dataWatcher.updateObject(16, (byte)(var2 & -5));
        }

    }
}
