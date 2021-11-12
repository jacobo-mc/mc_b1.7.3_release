package net.minecraft.src;

public class EntityItem extends Entity {
    public ItemStack item;
    private int field_9170_e;
    public int age = 0;
    public int delayBeforeCanPickup;
    private int health = 5;
    public float field_432_ae = (float)(Math.random() * 3.141592653589793D * 2.0D);

    public EntityItem(World var1, double var2, double var4, double var6, ItemStack var8) {
        super(var1);
        this.setSize(0.25F, 0.25F);
        this.yOffset = this.height / 2.0F;
        this.setPosition(var2, var4, var6);
        this.item = var8;
        this.rotationYaw = (float)(Math.random() * 360.0D);
        this.motionX = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
    }

    protected boolean func_25017_l() {
        return false;
    }

    public EntityItem(World var1) {
        super(var1);
        this.setSize(0.25F, 0.25F);
        this.yOffset = this.height / 2.0F;
    }

    protected void entityInit() {
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.delayBeforeCanPickup > 0) {
            --this.delayBeforeCanPickup;
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        if (this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) == Material.lava) {
            this.motionY = 0.20000000298023224D;
            this.motionX = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.motionZ = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.worldObj.playSoundAtEntity(this, "random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
        }

        this.func_28005_g(this.posX, (this.boundingBox.minY + this.boundingBox.maxY) / 2.0D, this.posZ);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        float var1 = 0.98F;
        if (this.onGround) {
            var1 = 0.58800006F;
            int var2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
            if (var2 > 0) {
                var1 = Block.blocksList[var2].slipperiness * 0.98F;
            }
        }

        this.motionX *= (double)var1;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= (double)var1;
        if (this.onGround) {
            this.motionY *= -0.5D;
        }

        ++this.field_9170_e;
        ++this.age;
        if (this.age >= 6000) {
            this.setEntityDead();
        }

    }

    public boolean handleWaterMovement() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
    }

    protected void dealFireDamage(int var1) {
        this.attackEntityFrom((Entity)null, var1);
    }

    public boolean attackEntityFrom(Entity var1, int var2) {
        this.setBeenAttacked();
        this.health -= var2;
        if (this.health <= 0) {
            this.setEntityDead();
        }

        return false;
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        var1.setShort("Health", (short)((byte)this.health));
        var1.setShort("Age", (short)this.age);
        var1.setCompoundTag("Item", this.item.writeToNBT(new NBTTagCompound()));
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        this.health = var1.getShort("Health") & 255;
        this.age = var1.getShort("Age");
        NBTTagCompound var2 = var1.getCompoundTag("Item");
        this.item = new ItemStack(var2);
    }

    public void onCollideWithPlayer(EntityPlayer var1) {
        if (!this.worldObj.singleplayerWorld) {
            int var2 = this.item.stackSize;
            if (this.delayBeforeCanPickup == 0 && var1.inventory.addItemStackToInventory(this.item)) {
                if (this.item.itemID == Block.wood.blockID) {
                    var1.func_27017_a(AchievementList.field_25131_c);
                }

                if (this.item.itemID == Item.leather.shiftedIndex) {
                    var1.func_27017_a(AchievementList.field_27099_t);
                }

                this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                var1.onItemPickup(this, var2);
                if (this.item.stackSize <= 0) {
                    this.setEntityDead();
                }
            }

        }
    }
}
