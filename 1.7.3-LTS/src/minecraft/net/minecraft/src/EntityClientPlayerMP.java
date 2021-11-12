package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class EntityClientPlayerMP extends EntityPlayerSP {
    public NetClientHandler sendQueue;
    private int inventoryUpdateTickCounter = 0;
    private boolean hasSetHealth = false;
    private double oldPosX;
    private double oldMinY;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private float oldRotationPitch;
    private boolean wasOnGround = false;
    private boolean wasSneaking = false;
    private int timeSinceMoved = 0;

    public EntityClientPlayerMP(Minecraft var1, World var2, Session var3, NetClientHandler var4) {
        super(var1, var2, var3, 0);
        this.sendQueue = var4;
    }

    public boolean attackEntityFrom(Entity var1, int var2) {
        return false;
    }

    public void heal(int var1) {
    }

    public void onUpdate() {
        if (this.worldObj.blockExists(MathHelper.floor_double(this.posX), 64, MathHelper.floor_double(this.posZ))) {
            super.onUpdate();
            this.sendMotionUpdates();
        }
    }

    public void sendMotionUpdates() {
        if (this.inventoryUpdateTickCounter++ == 20) {
            this.sendInventoryChanged();
            this.inventoryUpdateTickCounter = 0;
        }

        boolean var1 = this.isSneaking();
        if (var1 != this.wasSneaking) {
            if (var1) {
                this.sendQueue.addToSendQueue(new Packet19EntityAction(this, 1));
            } else {
                this.sendQueue.addToSendQueue(new Packet19EntityAction(this, 2));
            }

            this.wasSneaking = var1;
        }

        double var2 = this.posX - this.oldPosX;
        double var4 = this.boundingBox.minY - this.oldMinY;
        double var6 = this.posY - this.oldPosY;
        double var8 = this.posZ - this.oldPosZ;
        double var10 = (double)(this.rotationYaw - this.oldRotationYaw);
        double var12 = (double)(this.rotationPitch - this.oldRotationPitch);
        boolean var14 = var4 != 0.0D || var6 != 0.0D || var2 != 0.0D || var8 != 0.0D;
        boolean var15 = var10 != 0.0D || var12 != 0.0D;
        if (this.ridingEntity != null) {
            if (var15) {
                this.sendQueue.addToSendQueue(new Packet11PlayerPosition(this.motionX, -999.0D, -999.0D, this.motionZ, this.onGround));
            } else {
                this.sendQueue.addToSendQueue(new Packet13PlayerLookMove(this.motionX, -999.0D, -999.0D, this.motionZ, this.rotationYaw, this.rotationPitch, this.onGround));
            }

            var14 = false;
        } else if (var14 && var15) {
            this.sendQueue.addToSendQueue(new Packet13PlayerLookMove(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
            this.timeSinceMoved = 0;
        } else if (var14) {
            this.sendQueue.addToSendQueue(new Packet11PlayerPosition(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.onGround));
            this.timeSinceMoved = 0;
        } else if (var15) {
            this.sendQueue.addToSendQueue(new Packet12PlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
            this.timeSinceMoved = 0;
        } else {
            this.sendQueue.addToSendQueue(new Packet10Flying(this.onGround));
            if (this.wasOnGround == this.onGround && this.timeSinceMoved <= 200) {
                ++this.timeSinceMoved;
            } else {
                this.timeSinceMoved = 0;
            }
        }

        this.wasOnGround = this.onGround;
        if (var14) {
            this.oldPosX = this.posX;
            this.oldMinY = this.boundingBox.minY;
            this.oldPosY = this.posY;
            this.oldPosZ = this.posZ;
        }

        if (var15) {
            this.oldRotationYaw = this.rotationYaw;
            this.oldRotationPitch = this.rotationPitch;
        }

    }

    public void dropCurrentItem() {
        this.sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
    }

    private void sendInventoryChanged() {
    }

    protected void joinEntityItemWithWorld(EntityItem var1) {
    }

    public void sendChatMessage(String var1) {
        this.sendQueue.addToSendQueue(new Packet3Chat(var1));
    }

    public void swingItem() {
        super.swingItem();
        this.sendQueue.addToSendQueue(new Packet18Animation(this, 1));
    }

    public void respawnPlayer() {
        this.sendInventoryChanged();
        this.sendQueue.addToSendQueue(new Packet9Respawn((byte)this.dimension));
    }

    protected void damageEntity(int var1) {
        this.health -= var1;
    }

    public void closeScreen() {
        this.sendQueue.addToSendQueue(new Packet101CloseWindow(this.craftingInventory.windowId));
        this.inventory.setItemStack((ItemStack)null);
        super.closeScreen();
    }

    public void setHealth(int var1) {
        if (this.hasSetHealth) {
            super.setHealth(var1);
        } else {
            this.health = var1;
            this.hasSetHealth = true;
        }

    }

    public void addStat(StatBase var1, int var2) {
        if (var1 != null) {
            if (var1.isIndependent) {
                super.addStat(var1, var2);
            }

        }
    }

    public void incrementStat(StatBase var1, int var2) {
        if (var1 != null) {
            if (!var1.isIndependent) {
                super.addStat(var1, var2);
            }

        }
    }
}
