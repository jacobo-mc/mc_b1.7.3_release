package net.minecraft.src;

import java.util.List;

public abstract class EntityLiving extends Entity {
    public int field_9099_av = 20;
    public float field_9098_aw;
    public float field_9096_ay;
    public float renderYawOffset = 0.0F;
    public float prevRenderYawOffset = 0.0F;
    protected float field_9124_aB;
    protected float field_9123_aC;
    protected float field_9122_aD;
    protected float field_9121_aE;
    protected boolean field_9120_aF = true;
    protected String texture = "/mob/char.png";
    protected boolean field_9118_aH = true;
    protected float field_9117_aI = 0.0F;
    protected String entityType = null;
    protected float field_9115_aK = 1.0F;
    protected int scoreValue = 0;
    protected float field_9113_aM = 0.0F;
    public boolean isMultiplayerEntity = false;
    public float prevSwingProgress;
    public float swingProgress;
    public int health = 10;
    public int prevHealth;
    private int livingSoundTime;
    public int hurtTime;
    public int maxHurtTime;
    public float attackedAtYaw = 0.0F;
    public int deathTime = 0;
    public int attackTime = 0;
    public float field_9102_aX;
    public float field_9101_aY;
    protected boolean unused_flag = false;
    public int field_9144_ba = -1;
    public float field_9143_bb = (float)(Math.random() * 0.8999999761581421D + 0.10000000149011612D);
    public float field_9142_bc;
    public float field_9141_bd;
    public float field_386_ba;
    protected int field_9140_bf;
    protected double field_9139_bg;
    protected double field_9138_bh;
    protected double field_9137_bi;
    protected double field_9136_bj;
    protected double field_9135_bk;
    float field_9134_bl = 0.0F;
    protected int field_9133_bm = 0;
    protected int age = 0;
    protected float moveStrafing;
    protected float moveForward;
    protected float randomYawVelocity;
    protected boolean isJumping = false;
    protected float defaultPitch = 0.0F;
    protected float moveSpeed = 0.7F;
    private Entity currentTarget;
    protected int numTicksToChaseTarget = 0;

    public EntityLiving(World var1) {
        super(var1);
        this.preventEntitySpawning = true;
        this.field_9096_ay = (float)(Math.random() + 1.0D) * 0.01F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.field_9098_aw = (float)Math.random() * 12398.0F;
        this.rotationYaw = (float)(Math.random() * 3.1415927410125732D * 2.0D);
        this.stepHeight = 0.5F;
    }

    protected void entityInit() {
    }

    public boolean canEntityBeSeen(Entity var1) {
        return this.worldObj.rayTraceBlocks(Vec3D.createVector(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ), Vec3D.createVector(var1.posX, var1.posY + (double)var1.getEyeHeight(), var1.posZ)) == null;
    }

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    public boolean canBePushed() {
        return !this.isDead;
    }

    public float getEyeHeight() {
        return this.height * 0.85F;
    }

    public int getTalkInterval() {
        return 80;
    }

    public void playLivingSound() {
        String var1 = this.getLivingSound();
        if (var1 != null) {
            this.worldObj.playSoundAtEntity(this, var1, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
        }

    }

    public void onEntityUpdate() {
        this.prevSwingProgress = this.swingProgress;
        super.onEntityUpdate();
        if (this.rand.nextInt(1000) < this.livingSoundTime++) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playLivingSound();
        }

        if (this.isEntityAlive() && this.isEntityInsideOpaqueBlock()) {
            this.attackEntityFrom((Entity)null, 1);
        }

        if (this.isImmuneToFire || this.worldObj.singleplayerWorld) {
            this.fire = 0;
        }

        int var1;
        if (this.isEntityAlive() && this.isInsideOfMaterial(Material.water) && !this.canBreatheUnderwater()) {
            --this.air;
            if (this.air == -20) {
                this.air = 0;

                for(var1 = 0; var1 < 8; ++var1) {
                    float var2 = this.rand.nextFloat() - this.rand.nextFloat();
                    float var3 = this.rand.nextFloat() - this.rand.nextFloat();
                    float var4 = this.rand.nextFloat() - this.rand.nextFloat();
                    this.worldObj.spawnParticle("bubble", this.posX + (double)var2, this.posY + (double)var3, this.posZ + (double)var4, this.motionX, this.motionY, this.motionZ);
                }

                this.attackEntityFrom((Entity)null, 2);
            }

            this.fire = 0;
        } else {
            this.air = this.maxAir;
        }

        this.field_9102_aX = this.field_9101_aY;
        if (this.attackTime > 0) {
            --this.attackTime;
        }

        if (this.hurtTime > 0) {
            --this.hurtTime;
        }

        if (this.field_9083_ac > 0) {
            --this.field_9083_ac;
        }

        if (this.health <= 0) {
            ++this.deathTime;
            if (this.deathTime > 20) {
                this.func_6101_K();
                this.setEntityDead();

                for(var1 = 0; var1 < 20; ++var1) {
                    double var8 = this.rand.nextGaussian() * 0.02D;
                    double var9 = this.rand.nextGaussian() * 0.02D;
                    double var6 = this.rand.nextGaussian() * 0.02D;
                    this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var8, var9, var6);
                }
            }
        }

        this.field_9121_aE = this.field_9122_aD;
        this.prevRenderYawOffset = this.renderYawOffset;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    public void spawnExplosionParticle() {
        for(int var1 = 0; var1 < 20; ++var1) {
            double var2 = this.rand.nextGaussian() * 0.02D;
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = 10.0D;
            this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width - var2 * var8, this.posY + (double)(this.rand.nextFloat() * this.height) - var4 * var8, this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width - var6 * var8, var2, var4, var6);
        }

    }

    public void updateRidden() {
        super.updateRidden();
        this.field_9124_aB = this.field_9123_aC;
        this.field_9123_aC = 0.0F;
    }

    public void onUpdate() {
        super.onUpdate();
        this.onLivingUpdate();
        double var1 = this.posX - this.prevPosX;
        double var3 = this.posZ - this.prevPosZ;
        float var5 = MathHelper.sqrt_double(var1 * var1 + var3 * var3);
        float var6 = this.renderYawOffset;
        float var7 = 0.0F;
        this.field_9124_aB = this.field_9123_aC;
        float var8 = 0.0F;
        if (var5 > 0.05F) {
            var8 = 1.0F;
            var7 = var5 * 3.0F;
            var6 = (float)Math.atan2(var3, var1) * 180.0F / 3.1415927F - 90.0F;
        }

        if (this.swingProgress > 0.0F) {
            var6 = this.rotationYaw;
        }

        if (!this.onGround) {
            var8 = 0.0F;
        }

        this.field_9123_aC += (var8 - this.field_9123_aC) * 0.3F;

        float var9;
        for(var9 = var6 - this.renderYawOffset; var9 < -180.0F; var9 += 360.0F) {
        }

        while(var9 >= 180.0F) {
            var9 -= 360.0F;
        }

        this.renderYawOffset += var9 * 0.3F;

        float var10;
        for(var10 = this.rotationYaw - this.renderYawOffset; var10 < -180.0F; var10 += 360.0F) {
        }

        while(var10 >= 180.0F) {
            var10 -= 360.0F;
        }

        boolean var11 = var10 < -90.0F || var10 >= 90.0F;
        if (var10 < -75.0F) {
            var10 = -75.0F;
        }

        if (var10 >= 75.0F) {
            var10 = 75.0F;
        }

        this.renderYawOffset = this.rotationYaw - var10;
        if (var10 * var10 > 2500.0F) {
            this.renderYawOffset += var10 * 0.2F;
        }

        if (var11) {
            var7 *= -1.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
        }

        while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
        }

        while(this.renderYawOffset - this.prevRenderYawOffset < -180.0F) {
            this.prevRenderYawOffset -= 360.0F;
        }

        while(this.renderYawOffset - this.prevRenderYawOffset >= 180.0F) {
            this.prevRenderYawOffset += 360.0F;
        }

        while(this.rotationPitch - this.prevRotationPitch < -180.0F) {
            this.prevRotationPitch -= 360.0F;
        }

        while(this.rotationPitch - this.prevRotationPitch >= 180.0F) {
            this.prevRotationPitch += 360.0F;
        }

        this.field_9122_aD += var7;
    }

    protected void setSize(float var1, float var2) {
        super.setSize(var1, var2);
    }

    public void heal(int var1) {
        if (this.health > 0) {
            this.health += var1;
            if (this.health > 20) {
                this.health = 20;
            }

            this.field_9083_ac = this.field_9099_av / 2;
        }
    }

    public boolean attackEntityFrom(Entity var1, int var2) {
        if (this.worldObj.singleplayerWorld) {
            return false;
        } else {
            this.age = 0;
            if (this.health <= 0) {
                return false;
            } else {
                this.field_9141_bd = 1.5F;
                boolean var3 = true;
                if ((float)this.field_9083_ac > (float)this.field_9099_av / 2.0F) {
                    if (var2 <= this.field_9133_bm) {
                        return false;
                    }

                    this.damageEntity(var2 - this.field_9133_bm);
                    this.field_9133_bm = var2;
                    var3 = false;
                } else {
                    this.field_9133_bm = var2;
                    this.prevHealth = this.health;
                    this.field_9083_ac = this.field_9099_av;
                    this.damageEntity(var2);
                    this.hurtTime = this.maxHurtTime = 10;
                }

                this.attackedAtYaw = 0.0F;
                if (var3) {
                    this.worldObj.sendTrackedEntityStatusUpdatePacket(this, (byte)2);
                    this.setBeenAttacked();
                    if (var1 != null) {
                        double var4 = var1.posX - this.posX;

                        double var6;
                        for(var6 = var1.posZ - this.posZ; var4 * var4 + var6 * var6 < 1.0E-4D; var6 = (Math.random() - Math.random()) * 0.01D) {
                            var4 = (Math.random() - Math.random()) * 0.01D;
                        }

                        this.attackedAtYaw = (float)(Math.atan2(var6, var4) * 180.0D / 3.1415927410125732D) - this.rotationYaw;
                        this.knockBack(var1, var2, var4, var6);
                    } else {
                        this.attackedAtYaw = (float)((int)(Math.random() * 2.0D) * 180);
                    }
                }

                if (this.health <= 0) {
                    if (var3) {
                        this.worldObj.playSoundAtEntity(this, this.getDeathSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                    }

                    this.onDeath(var1);
                } else if (var3) {
                    this.worldObj.playSoundAtEntity(this, this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                }

                return true;
            }
        }
    }

    protected void damageEntity(int var1) {
        this.health -= var1;
    }

    protected float getSoundVolume() {
        return 1.0F;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "random.hurt";
    }

    protected String getDeathSound() {
        return "random.hurt";
    }

    public void knockBack(Entity var1, int var2, double var3, double var5) {
        float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
        float var8 = 0.4F;
        this.motionX /= 2.0D;
        this.motionY /= 2.0D;
        this.motionZ /= 2.0D;
        this.motionX -= var3 / (double)var7 * (double)var8;
        this.motionY += 0.4000000059604645D;
        this.motionZ -= var5 / (double)var7 * (double)var8;
        if (this.motionY > 0.4000000059604645D) {
            this.motionY = 0.4000000059604645D;
        }

    }

    public void onDeath(Entity var1) {
        if (this.scoreValue >= 0 && var1 != null) {
            var1.addToPlayerScore(this, this.scoreValue);
        }

        if (var1 != null) {
            var1.func_27010_a(this);
        }

        this.unused_flag = true;
        if (!this.worldObj.singleplayerWorld) {
            this.dropFewItems();
        }

        this.worldObj.sendTrackedEntityStatusUpdatePacket(this, (byte)3);
    }

    protected void dropFewItems() {
        int var1 = this.getDropItemId();
        if (var1 > 0) {
            int var2 = this.rand.nextInt(3);

            for(int var3 = 0; var3 < var2; ++var3) {
                this.dropItem(var1, 1);
            }
        }

    }

    protected int getDropItemId() {
        return 0;
    }

    protected void fall(float var1) {
        super.fall(var1);
        int var2 = (int)Math.ceil((double)(var1 - 3.0F));
        if (var2 > 0) {
            this.attackEntityFrom((Entity)null, var2);
            int var3 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset), MathHelper.floor_double(this.posZ));
            if (var3 > 0) {
                StepSound var4 = Block.blocksList[var3].stepSound;
                this.worldObj.playSoundAtEntity(this, var4.func_737_c(), var4.getVolume() * 0.5F, var4.getPitch() * 0.75F);
            }
        }

    }

    public void moveEntityWithHeading(float var1, float var2) {
        double var3;
        if (this.isInWater()) {
            var3 = this.posY;
            this.moveFlying(var1, var2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
            this.motionY -= 0.02D;
            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + var3, this.motionZ)) {
                this.motionY = 0.30000001192092896D;
            }
        } else if (this.handleLavaMovement()) {
            var3 = this.posY;
            this.moveFlying(var1, var2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
            this.motionY -= 0.02D;
            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + var3, this.motionZ)) {
                this.motionY = 0.30000001192092896D;
            }
        } else {
            float var8 = 0.91F;
            if (this.onGround) {
                var8 = 0.54600006F;
                int var4 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (var4 > 0) {
                    var8 = Block.blocksList[var4].slipperiness * 0.91F;
                }
            }

            float var9 = 0.16277136F / (var8 * var8 * var8);
            this.moveFlying(var1, var2, this.onGround ? 0.1F * var9 : 0.02F);
            var8 = 0.91F;
            if (this.onGround) {
                var8 = 0.54600006F;
                int var5 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (var5 > 0) {
                    var8 = Block.blocksList[var5].slipperiness * 0.91F;
                }
            }

            if (this.isOnLadder()) {
                float var10 = 0.15F;
                if (this.motionX < (double)(-var10)) {
                    this.motionX = (double)(-var10);
                }

                if (this.motionX > (double)var10) {
                    this.motionX = (double)var10;
                }

                if (this.motionZ < (double)(-var10)) {
                    this.motionZ = (double)(-var10);
                }

                if (this.motionZ > (double)var10) {
                    this.motionZ = (double)var10;
                }

                this.fallDistance = 0.0F;
                if (this.motionY < -0.15D) {
                    this.motionY = -0.15D;
                }

                if (this.isSneaking() && this.motionY < 0.0D) {
                    this.motionY = 0.0D;
                }
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.isCollidedHorizontally && this.isOnLadder()) {
                this.motionY = 0.2D;
            }

            this.motionY -= 0.08D;
            this.motionY *= 0.9800000190734863D;
            this.motionX *= (double)var8;
            this.motionZ *= (double)var8;
        }

        this.field_9142_bc = this.field_9141_bd;
        var3 = this.posX - this.prevPosX;
        double var11 = this.posZ - this.prevPosZ;
        float var7 = MathHelper.sqrt_double(var3 * var3 + var11 * var11) * 4.0F;
        if (var7 > 1.0F) {
            var7 = 1.0F;
        }

        this.field_9141_bd += (var7 - this.field_9141_bd) * 0.4F;
        this.field_386_ba += this.field_9141_bd;
    }

    public boolean isOnLadder() {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlockId(var1, var2, var3) == Block.ladder.blockID;
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        var1.setShort("Health", (short)this.health);
        var1.setShort("HurtTime", (short)this.hurtTime);
        var1.setShort("DeathTime", (short)this.deathTime);
        var1.setShort("AttackTime", (short)this.attackTime);
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        this.health = var1.getShort("Health");
        if (!var1.hasKey("Health")) {
            this.health = 10;
        }

        this.hurtTime = var1.getShort("HurtTime");
        this.deathTime = var1.getShort("DeathTime");
        this.attackTime = var1.getShort("AttackTime");
    }

    public boolean isEntityAlive() {
        return !this.isDead && this.health > 0;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public void onLivingUpdate() {
        if (this.field_9140_bf > 0) {
            double var1 = this.posX + (this.field_9139_bg - this.posX) / (double)this.field_9140_bf;
            double var3 = this.posY + (this.field_9138_bh - this.posY) / (double)this.field_9140_bf;
            double var5 = this.posZ + (this.field_9137_bi - this.posZ) / (double)this.field_9140_bf;

            double var7;
            for(var7 = this.field_9136_bj - (double)this.rotationYaw; var7 < -180.0D; var7 += 360.0D) {
            }

            while(var7 >= 180.0D) {
                var7 -= 360.0D;
            }

            this.rotationYaw = (float)((double)this.rotationYaw + var7 / (double)this.field_9140_bf);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.field_9135_bk - (double)this.rotationPitch) / (double)this.field_9140_bf);
            --this.field_9140_bf;
            this.setPosition(var1, var3, var5);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            List var9 = this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox.getInsetBoundingBox(0.03125D, 0.0D, 0.03125D));
            if (var9.size() > 0) {
                double var10 = 0.0D;

                for(int var12 = 0; var12 < var9.size(); ++var12) {
                    AxisAlignedBB var13 = (AxisAlignedBB)var9.get(var12);
                    if (var13.maxY > var10) {
                        var10 = var13.maxY;
                    }
                }

                var3 += var10 - this.boundingBox.minY;
                this.setPosition(var1, var3, var5);
            }
        }

        if (this.isMovementBlocked()) {
            this.isJumping = false;
            this.moveStrafing = 0.0F;
            this.moveForward = 0.0F;
            this.randomYawVelocity = 0.0F;
        } else if (!this.isMultiplayerEntity) {
            this.updatePlayerActionState();
        }

        boolean var14 = this.isInWater();
        boolean var2 = this.handleLavaMovement();
        if (this.isJumping) {
            if (var14) {
                this.motionY += 0.03999999910593033D;
            } else if (var2) {
                this.motionY += 0.03999999910593033D;
            } else if (this.onGround) {
                this.jump();
            }
        }

        this.moveStrafing *= 0.98F;
        this.moveForward *= 0.98F;
        this.randomYawVelocity *= 0.9F;
        this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        List var15 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if (var15 != null && var15.size() > 0) {
            for(int var4 = 0; var4 < var15.size(); ++var4) {
                Entity var16 = (Entity)var15.get(var4);
                if (var16.canBePushed()) {
                    var16.applyEntityCollision(this);
                }
            }
        }

    }

    protected boolean isMovementBlocked() {
        return this.health <= 0;
    }

    protected void jump() {
        this.motionY = 0.41999998688697815D;
    }

    protected boolean func_25020_s() {
        return true;
    }

    protected void func_27013_Q() {
        EntityPlayer var1 = this.worldObj.getClosestPlayerToEntity(this, -1.0D);
        if (this.func_25020_s() && var1 != null) {
            double var2 = var1.posX - this.posX;
            double var4 = var1.posY - this.posY;
            double var6 = var1.posZ - this.posZ;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            if (var8 > 16384.0D) {
                this.setEntityDead();
            }

            if (this.age > 600 && this.rand.nextInt(800) == 0) {
                if (var8 < 1024.0D) {
                    this.age = 0;
                } else {
                    this.setEntityDead();
                }
            }
        }

    }

    protected void updatePlayerActionState() {
        ++this.age;
        EntityPlayer var1 = this.worldObj.getClosestPlayerToEntity(this, -1.0D);
        this.func_27013_Q();
        this.moveStrafing = 0.0F;
        this.moveForward = 0.0F;
        float var2 = 8.0F;
        if (this.rand.nextFloat() < 0.02F) {
            var1 = this.worldObj.getClosestPlayerToEntity(this, (double)var2);
            if (var1 != null) {
                this.currentTarget = var1;
                this.numTicksToChaseTarget = 10 + this.rand.nextInt(20);
            } else {
                this.randomYawVelocity = (this.rand.nextFloat() - 0.5F) * 20.0F;
            }
        }

        if (this.currentTarget != null) {
            this.faceEntity(this.currentTarget, 10.0F, (float)this.func_25018_n_());
            if (this.numTicksToChaseTarget-- <= 0 || this.currentTarget.isDead || this.currentTarget.getDistanceSqToEntity(this) > (double)(var2 * var2)) {
                this.currentTarget = null;
            }
        } else {
            if (this.rand.nextFloat() < 0.05F) {
                this.randomYawVelocity = (this.rand.nextFloat() - 0.5F) * 20.0F;
            }

            this.rotationYaw += this.randomYawVelocity;
            this.rotationPitch = this.defaultPitch;
        }

        boolean var3 = this.isInWater();
        boolean var4 = this.handleLavaMovement();
        if (var3 || var4) {
            this.isJumping = this.rand.nextFloat() < 0.8F;
        }

    }

    protected int func_25018_n_() {
        return 40;
    }

    public void faceEntity(Entity var1, float var2, float var3) {
        double var4 = var1.posX - this.posX;
        double var8 = var1.posZ - this.posZ;
        double var6;
        if (var1 instanceof EntityLiving) {
            EntityLiving var10 = (EntityLiving)var1;
            var6 = this.posY + (double)this.getEyeHeight() - (var10.posY + (double)var10.getEyeHeight());
        } else {
            var6 = (var1.boundingBox.minY + var1.boundingBox.maxY) / 2.0D - (this.posY + (double)this.getEyeHeight());
        }

        double var14 = (double)MathHelper.sqrt_double(var4 * var4 + var8 * var8);
        float var12 = (float)(Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
        float var13 = (float)(-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
        this.rotationPitch = -this.updateRotation(this.rotationPitch, var13, var3);
        this.rotationYaw = this.updateRotation(this.rotationYaw, var12, var2);
    }

    public boolean func_25021_O() {
        return this.currentTarget != null;
    }

    public Entity getCurrentTarget() {
        return this.currentTarget;
    }

    private float updateRotation(float var1, float var2, float var3) {
        float var4;
        for(var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
        }

        while(var4 >= 180.0F) {
            var4 -= 360.0F;
        }

        if (var4 > var3) {
            var4 = var3;
        }

        if (var4 < -var3) {
            var4 = -var3;
        }

        return var1 + var4;
    }

    public void func_6101_K() {
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.getIsAnyLiquid(this.boundingBox);
    }

    protected void kill() {
        this.attackEntityFrom((Entity)null, 4);
    }

    public Vec3D getLookVec() {
        return this.getLook(1.0F);
    }

    public Vec3D getLook(float var1) {
        float var2;
        float var3;
        float var4;
        float var5;
        if (var1 == 1.0F) {
            var2 = MathHelper.cos(-this.rotationYaw * 0.017453292F - 3.1415927F);
            var3 = MathHelper.sin(-this.rotationYaw * 0.017453292F - 3.1415927F);
            var4 = -MathHelper.cos(-this.rotationPitch * 0.017453292F);
            var5 = MathHelper.sin(-this.rotationPitch * 0.017453292F);
            return Vec3D.createVector((double)(var3 * var4), (double)var5, (double)(var2 * var4));
        } else {
            var2 = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * var1;
            var3 = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * var1;
            var4 = MathHelper.cos(-var3 * 0.017453292F - 3.1415927F);
            var5 = MathHelper.sin(-var3 * 0.017453292F - 3.1415927F);
            float var6 = -MathHelper.cos(-var2 * 0.017453292F);
            float var7 = MathHelper.sin(-var2 * 0.017453292F);
            return Vec3D.createVector((double)(var5 * var6), (double)var7, (double)(var4 * var6));
        }
    }

    public int getMaxSpawnedInChunk() {
        return 4;
    }

    public boolean func_22057_E() {
        return false;
    }
}
