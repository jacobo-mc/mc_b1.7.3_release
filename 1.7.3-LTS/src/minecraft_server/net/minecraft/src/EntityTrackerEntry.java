package net.minecraft.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityTrackerEntry {
    public Entity trackedEntity;
    public int trackingDistanceThreshold;
    public int field_9234_e;
    public int encodedPosX;
    public int encodedPosY;
    public int encodedPosZ;
    public int encodedRotationYaw;
    public int encodedRotationPitch;
    public double lastTrackedEntityMotionX;
    public double lastTrackedEntityMotionY;
    public double lastTrackedEntityMotionZ;
    public int updateCounter = 0;
    private double lastTrackedEntityPosX;
    private double lastTrackedEntityPosY;
    private double lastTrackedEntityPosZ;
    private boolean firstUpdateDone = false;
    private boolean shouldSendMotionUpdates;
    private int field_28165_t = 0;
    public boolean playerEntitiesUpdated = false;
    public Set trackedPlayers = new HashSet();

    public EntityTrackerEntry(Entity var1, int var2, int var3, boolean var4) {
        this.trackedEntity = var1;
        this.trackingDistanceThreshold = var2;
        this.field_9234_e = var3;
        this.shouldSendMotionUpdates = var4;
        this.encodedPosX = MathHelper.floor_double(var1.posX * 32.0D);
        this.encodedPosY = MathHelper.floor_double(var1.posY * 32.0D);
        this.encodedPosZ = MathHelper.floor_double(var1.posZ * 32.0D);
        this.encodedRotationYaw = MathHelper.floor_float(var1.rotationYaw * 256.0F / 360.0F);
        this.encodedRotationPitch = MathHelper.floor_float(var1.rotationPitch * 256.0F / 360.0F);
    }

    public boolean equals(Object var1) {
        if (var1 instanceof EntityTrackerEntry) {
            return ((EntityTrackerEntry)var1).trackedEntity.entityId == this.trackedEntity.entityId;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.trackedEntity.entityId;
    }

    public void updatePlayerList(List var1) {
        this.playerEntitiesUpdated = false;
        if (!this.firstUpdateDone || this.trackedEntity.getDistanceSq(this.lastTrackedEntityPosX, this.lastTrackedEntityPosY, this.lastTrackedEntityPosZ) > 16.0D) {
            this.lastTrackedEntityPosX = this.trackedEntity.posX;
            this.lastTrackedEntityPosY = this.trackedEntity.posY;
            this.lastTrackedEntityPosZ = this.trackedEntity.posZ;
            this.firstUpdateDone = true;
            this.playerEntitiesUpdated = true;
            this.updatePlayerEntities(var1);
        }

        ++this.field_28165_t;
        if (++this.updateCounter % this.field_9234_e == 0) {
            int var2 = MathHelper.floor_double(this.trackedEntity.posX * 32.0D);
            int var3 = MathHelper.floor_double(this.trackedEntity.posY * 32.0D);
            int var4 = MathHelper.floor_double(this.trackedEntity.posZ * 32.0D);
            int var5 = MathHelper.floor_float(this.trackedEntity.rotationYaw * 256.0F / 360.0F);
            int var6 = MathHelper.floor_float(this.trackedEntity.rotationPitch * 256.0F / 360.0F);
            int var7 = var2 - this.encodedPosX;
            int var8 = var3 - this.encodedPosY;
            int var9 = var4 - this.encodedPosZ;
            Object var10 = null;
            boolean var11 = Math.abs(var2) >= 8 || Math.abs(var3) >= 8 || Math.abs(var4) >= 8;
            boolean var12 = Math.abs(var5 - this.encodedRotationYaw) >= 8 || Math.abs(var6 - this.encodedRotationPitch) >= 8;
            if (var7 >= -128 && var7 < 128 && var8 >= -128 && var8 < 128 && var9 >= -128 && var9 < 128 && this.field_28165_t <= 400) {
                if (var11 && var12) {
                    var10 = new Packet33RelEntityMoveLook(this.trackedEntity.entityId, (byte)var7, (byte)var8, (byte)var9, (byte)var5, (byte)var6);
                } else if (var11) {
                    var10 = new Packet31RelEntityMove(this.trackedEntity.entityId, (byte)var7, (byte)var8, (byte)var9);
                } else if (var12) {
                    var10 = new Packet32EntityLook(this.trackedEntity.entityId, (byte)var5, (byte)var6);
                }
            } else {
                this.field_28165_t = 0;
                this.trackedEntity.posX = (double)var2 / 32.0D;
                this.trackedEntity.posY = (double)var3 / 32.0D;
                this.trackedEntity.posZ = (double)var4 / 32.0D;
                var10 = new Packet34EntityTeleport(this.trackedEntity.entityId, var2, var3, var4, (byte)var5, (byte)var6);
            }

            if (this.shouldSendMotionUpdates) {
                double var13 = this.trackedEntity.motionX - this.lastTrackedEntityMotionX;
                double var15 = this.trackedEntity.motionY - this.lastTrackedEntityMotionY;
                double var17 = this.trackedEntity.motionZ - this.lastTrackedEntityMotionZ;
                double var19 = 0.02D;
                double var21 = var13 * var13 + var15 * var15 + var17 * var17;
                if (var21 > var19 * var19 || var21 > 0.0D && this.trackedEntity.motionX == 0.0D && this.trackedEntity.motionY == 0.0D && this.trackedEntity.motionZ == 0.0D) {
                    this.lastTrackedEntityMotionX = this.trackedEntity.motionX;
                    this.lastTrackedEntityMotionY = this.trackedEntity.motionY;
                    this.lastTrackedEntityMotionZ = this.trackedEntity.motionZ;
                    this.sendPacketToTrackedPlayers(new Packet28EntityVelocity(this.trackedEntity.entityId, this.lastTrackedEntityMotionX, this.lastTrackedEntityMotionY, this.lastTrackedEntityMotionZ));
                }
            }

            if (var10 != null) {
                this.sendPacketToTrackedPlayers((Packet)var10);
            }

            DataWatcher var23 = this.trackedEntity.getDataWatcher();
            if (var23.hasObjectChanged()) {
                this.sendPacketToTrackedPlayersAndTrackedEntity(new Packet40EntityMetadata(this.trackedEntity.entityId, var23));
            }

            if (var11) {
                this.encodedPosX = var2;
                this.encodedPosY = var3;
                this.encodedPosZ = var4;
            }

            if (var12) {
                this.encodedRotationYaw = var5;
                this.encodedRotationPitch = var6;
            }
        }

        if (this.trackedEntity.beenAttacked) {
            this.sendPacketToTrackedPlayersAndTrackedEntity(new Packet28EntityVelocity(this.trackedEntity));
            this.trackedEntity.beenAttacked = false;
        }

    }

    public void sendPacketToTrackedPlayers(Packet var1) {
        Iterator var2 = this.trackedPlayers.iterator();

        while(var2.hasNext()) {
            EntityPlayerMP var3 = (EntityPlayerMP)var2.next();
            var3.playerNetServerHandler.sendPacket(var1);
        }

    }

    public void sendPacketToTrackedPlayersAndTrackedEntity(Packet var1) {
        this.sendPacketToTrackedPlayers(var1);
        if (this.trackedEntity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this.trackedEntity).playerNetServerHandler.sendPacket(var1);
        }

    }

    public void sendDestroyEntityPacketToTrackedPlayers() {
        this.sendPacketToTrackedPlayers(new Packet29DestroyEntity(this.trackedEntity.entityId));
    }

    public void removeFromTrackedPlayers(EntityPlayerMP var1) {
        if (this.trackedPlayers.contains(var1)) {
            this.trackedPlayers.remove(var1);
        }

    }

    public void updatePlayerEntity(EntityPlayerMP var1) {
        if (var1 != this.trackedEntity) {
            double var2 = var1.posX - (double)(this.encodedPosX / 32);
            double var4 = var1.posZ - (double)(this.encodedPosZ / 32);
            if (var2 >= (double)(-this.trackingDistanceThreshold) && var2 <= (double)this.trackingDistanceThreshold && var4 >= (double)(-this.trackingDistanceThreshold) && var4 <= (double)this.trackingDistanceThreshold) {
                if (!this.trackedPlayers.contains(var1)) {
                    this.trackedPlayers.add(var1);
                    var1.playerNetServerHandler.sendPacket(this.getSpawnPacket());
                    if (this.shouldSendMotionUpdates) {
                        var1.playerNetServerHandler.sendPacket(new Packet28EntityVelocity(this.trackedEntity.entityId, this.trackedEntity.motionX, this.trackedEntity.motionY, this.trackedEntity.motionZ));
                    }

                    ItemStack[] var6 = this.trackedEntity.getInventory();
                    if (var6 != null) {
                        for(int var7 = 0; var7 < var6.length; ++var7) {
                            var1.playerNetServerHandler.sendPacket(new Packet5PlayerInventory(this.trackedEntity.entityId, var7, var6[var7]));
                        }
                    }

                    if (this.trackedEntity instanceof EntityPlayer) {
                        EntityPlayer var8 = (EntityPlayer)this.trackedEntity;
                        if (var8.func_22057_E()) {
                            var1.playerNetServerHandler.sendPacket(new Packet17Sleep(this.trackedEntity, 0, MathHelper.floor_double(this.trackedEntity.posX), MathHelper.floor_double(this.trackedEntity.posY), MathHelper.floor_double(this.trackedEntity.posZ)));
                        }
                    }
                }
            } else if (this.trackedPlayers.contains(var1)) {
                this.trackedPlayers.remove(var1);
                var1.playerNetServerHandler.sendPacket(new Packet29DestroyEntity(this.trackedEntity.entityId));
            }

        }
    }

    public void updatePlayerEntities(List var1) {
        for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.updatePlayerEntity((EntityPlayerMP)var1.get(var2));
        }

    }

    private Packet getSpawnPacket() {
        if (this.trackedEntity instanceof EntityItem) {
            EntityItem var6 = (EntityItem)this.trackedEntity;
            Packet21PickupSpawn var7 = new Packet21PickupSpawn(var6);
            var6.posX = (double)var7.xPosition / 32.0D;
            var6.posY = (double)var7.yPosition / 32.0D;
            var6.posZ = (double)var7.zPosition / 32.0D;
            return var7;
        } else if (this.trackedEntity instanceof EntityPlayerMP) {
            return new Packet20NamedEntitySpawn((EntityPlayer)this.trackedEntity);
        } else {
            if (this.trackedEntity instanceof EntityMinecart) {
                EntityMinecart var1 = (EntityMinecart)this.trackedEntity;
                if (var1.minecartType == 0) {
                    return new Packet23VehicleSpawn(this.trackedEntity, 10);
                }

                if (var1.minecartType == 1) {
                    return new Packet23VehicleSpawn(this.trackedEntity, 11);
                }

                if (var1.minecartType == 2) {
                    return new Packet23VehicleSpawn(this.trackedEntity, 12);
                }
            }

            if (this.trackedEntity instanceof EntityBoat) {
                return new Packet23VehicleSpawn(this.trackedEntity, 1);
            } else if (this.trackedEntity instanceof IAnimals) {
                return new Packet24MobSpawn((EntityLiving)this.trackedEntity);
            } else if (this.trackedEntity instanceof EntityFish) {
                return new Packet23VehicleSpawn(this.trackedEntity, 90);
            } else if (this.trackedEntity instanceof EntityArrow) {
                EntityLiving var5 = ((EntityArrow)this.trackedEntity).owner;
                return new Packet23VehicleSpawn(this.trackedEntity, 60, var5 != null ? var5.entityId : this.trackedEntity.entityId);
            } else if (this.trackedEntity instanceof EntitySnowball) {
                return new Packet23VehicleSpawn(this.trackedEntity, 61);
            } else if (this.trackedEntity instanceof EntityFireball) {
                EntityFireball var4 = (EntityFireball)this.trackedEntity;
                Packet23VehicleSpawn var2 = new Packet23VehicleSpawn(this.trackedEntity, 63, ((EntityFireball)this.trackedEntity).owner.entityId);
                var2.field_28044_e = (int)(var4.field_9199_b * 8000.0D);
                var2.field_28043_f = (int)(var4.field_9198_c * 8000.0D);
                var2.field_28042_g = (int)(var4.field_9196_d * 8000.0D);
                return var2;
            } else if (this.trackedEntity instanceof EntityEgg) {
                return new Packet23VehicleSpawn(this.trackedEntity, 62);
            } else if (this.trackedEntity instanceof EntityTNTPrimed) {
                return new Packet23VehicleSpawn(this.trackedEntity, 50);
            } else {
                if (this.trackedEntity instanceof EntityFallingSand) {
                    EntityFallingSand var3 = (EntityFallingSand)this.trackedEntity;
                    if (var3.blockID == Block.sand.blockID) {
                        return new Packet23VehicleSpawn(this.trackedEntity, 70);
                    }

                    if (var3.blockID == Block.gravel.blockID) {
                        return new Packet23VehicleSpawn(this.trackedEntity, 71);
                    }
                }

                if (this.trackedEntity instanceof EntityPainting) {
                    return new Packet25EntityPainting((EntityPainting)this.trackedEntity);
                } else {
                    throw new IllegalArgumentException("Don't know how to add " + this.trackedEntity.getClass() + "!");
                }
            }
        }
    }

    public void removeTrackedPlayerSymmetric(EntityPlayerMP var1) {
        if (this.trackedPlayers.contains(var1)) {
            this.trackedPlayers.remove(var1);
            var1.playerNetServerHandler.sendPacket(new Packet29DestroyEntity(this.trackedEntity.entityId));
        }

    }
}
