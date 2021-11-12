package net.minecraft.src;

public class EntityCreature extends EntityLiving {
    private PathEntity pathToEntity;
    protected Entity playerToAttack;
    protected boolean hasAttacked = false;

    public EntityCreature(World var1) {
        super(var1);
    }

    protected boolean func_25026_u() {
        return false;
    }

    protected void updatePlayerActionState() {
        this.hasAttacked = this.func_25026_u();
        float var1 = 16.0F;
        if (this.playerToAttack == null) {
            this.playerToAttack = this.findPlayerToAttack();
            if (this.playerToAttack != null) {
                this.pathToEntity = this.worldObj.getPathToEntity(this, this.playerToAttack, var1);
            }
        } else if (!this.playerToAttack.isEntityAlive()) {
            this.playerToAttack = null;
        } else {
            float var2 = this.playerToAttack.getDistanceToEntity(this);
            if (this.canEntityBeSeen(this.playerToAttack)) {
                this.attackEntity(this.playerToAttack, var2);
            } else {
                this.func_28013_b(this.playerToAttack, var2);
            }
        }

        if (this.hasAttacked || this.playerToAttack == null || this.pathToEntity != null && this.rand.nextInt(20) != 0) {
            if (!this.hasAttacked && (this.pathToEntity == null && this.rand.nextInt(80) == 0 || this.rand.nextInt(80) == 0)) {
                this.func_31021_B();
            }
        } else {
            this.pathToEntity = this.worldObj.getPathToEntity(this, this.playerToAttack, var1);
        }

        int var21 = MathHelper.floor_double(this.boundingBox.minY + 0.5D);
        boolean var3 = this.isInWater();
        boolean var4 = this.handleLavaMovement();
        this.rotationPitch = 0.0F;
        if (this.pathToEntity != null && this.rand.nextInt(100) != 0) {
            Vec3D var5 = this.pathToEntity.getPosition(this);
            double var6 = (double)(this.width * 2.0F);

            while(var5 != null && var5.squareDistanceTo(this.posX, var5.yCoord, this.posZ) < var6 * var6) {
                this.pathToEntity.incrementPathIndex();
                if (this.pathToEntity.isFinished()) {
                    var5 = null;
                    this.pathToEntity = null;
                } else {
                    var5 = this.pathToEntity.getPosition(this);
                }
            }

            this.isJumping = false;
            if (var5 != null) {
                double var8 = var5.xCoord - this.posX;
                double var10 = var5.zCoord - this.posZ;
                double var12 = var5.yCoord - (double)var21;
                float var14 = (float)(Math.atan2(var10, var8) * 180.0D / 3.1415927410125732D) - 90.0F;
                float var15 = var14 - this.rotationYaw;

                for(this.moveForward = this.moveSpeed; var15 < -180.0F; var15 += 360.0F) {
                }

                while(var15 >= 180.0F) {
                    var15 -= 360.0F;
                }

                if (var15 > 30.0F) {
                    var15 = 30.0F;
                }

                if (var15 < -30.0F) {
                    var15 = -30.0F;
                }

                this.rotationYaw += var15;
                if (this.hasAttacked && this.playerToAttack != null) {
                    double var16 = this.playerToAttack.posX - this.posX;
                    double var18 = this.playerToAttack.posZ - this.posZ;
                    float var20 = this.rotationYaw;
                    this.rotationYaw = (float)(Math.atan2(var18, var16) * 180.0D / 3.1415927410125732D) - 90.0F;
                    var15 = (var20 - this.rotationYaw + 90.0F) * 3.1415927F / 180.0F;
                    this.moveStrafing = -MathHelper.sin(var15) * this.moveForward * 1.0F;
                    this.moveForward = MathHelper.cos(var15) * this.moveForward * 1.0F;
                }

                if (var12 > 0.0D) {
                    this.isJumping = true;
                }
            }

            if (this.playerToAttack != null) {
                this.faceEntity(this.playerToAttack, 30.0F, 30.0F);
            }

            if (this.isCollidedHorizontally && !this.getGotPath()) {
                this.isJumping = true;
            }

            if (this.rand.nextFloat() < 0.8F && (var3 || var4)) {
                this.isJumping = true;
            }

        } else {
            super.updatePlayerActionState();
            this.pathToEntity = null;
        }
    }

    protected void func_31021_B() {
        boolean var1 = false;
        int var2 = -1;
        int var3 = -1;
        int var4 = -1;
        float var5 = -99999.0F;

        for(int var6 = 0; var6 < 10; ++var6) {
            int var7 = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(13) - 6.0D);
            int var8 = MathHelper.floor_double(this.posY + (double)this.rand.nextInt(7) - 3.0D);
            int var9 = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(13) - 6.0D);
            float var10 = this.getBlockPathWeight(var7, var8, var9);
            if (var10 > var5) {
                var5 = var10;
                var2 = var7;
                var3 = var8;
                var4 = var9;
                var1 = true;
            }
        }

        if (var1) {
            this.pathToEntity = this.worldObj.getEntityPathToXYZ(this, var2, var3, var4, 10.0F);
        }

    }

    protected void attackEntity(Entity var1, float var2) {
    }

    protected void func_28013_b(Entity var1, float var2) {
    }

    protected float getBlockPathWeight(int var1, int var2, int var3) {
        return 0.0F;
    }

    protected Entity findPlayerToAttack() {
        return null;
    }

    public boolean getCanSpawnHere() {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return super.getCanSpawnHere() && this.getBlockPathWeight(var1, var2, var3) >= 0.0F;
    }

    public boolean getGotPath() {
        return this.pathToEntity != null;
    }

    public void setPathToEntity(PathEntity var1) {
        this.pathToEntity = var1;
    }

    public Entity getEntityToAttack() {
        return this.playerToAttack;
    }

    public void setEntityToAttack(Entity var1) {
        this.playerToAttack = var1;
    }
}
