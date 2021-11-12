package net.minecraft.src;

public abstract class NetHandler {
    public abstract boolean isServerHandler();

    public void handleMapChunk(Packet51MapChunk var1) {
    }

    public void registerPacket(Packet var1) {
    }

    public void handleErrorMessage(String var1, Object[] var2) {
    }

    public void handleKickDisconnect(Packet255KickDisconnect var1) {
        this.registerPacket(var1);
    }

    public void handleLogin(Packet1Login var1) {
        this.registerPacket(var1);
    }

    public void handleFlying(Packet10Flying var1) {
        this.registerPacket(var1);
    }

    public void handleMultiBlockChange(Packet52MultiBlockChange var1) {
        this.registerPacket(var1);
    }

    public void handleBlockDig(Packet14BlockDig var1) {
        this.registerPacket(var1);
    }

    public void handleBlockChange(Packet53BlockChange var1) {
        this.registerPacket(var1);
    }

    public void handlePreChunk(Packet50PreChunk var1) {
        this.registerPacket(var1);
    }

    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn var1) {
        this.registerPacket(var1);
    }

    public void handleEntity(Packet30Entity var1) {
        this.registerPacket(var1);
    }

    public void handleEntityTeleport(Packet34EntityTeleport var1) {
        this.registerPacket(var1);
    }

    public void handlePlace(Packet15Place var1) {
        this.registerPacket(var1);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch var1) {
        this.registerPacket(var1);
    }

    public void handleDestroyEntity(Packet29DestroyEntity var1) {
        this.registerPacket(var1);
    }

    public void handlePickupSpawn(Packet21PickupSpawn var1) {
        this.registerPacket(var1);
    }

    public void handleCollect(Packet22Collect var1) {
        this.registerPacket(var1);
    }

    public void handleChat(Packet3Chat var1) {
        this.registerPacket(var1);
    }

    public void handleVehicleSpawn(Packet23VehicleSpawn var1) {
        this.registerPacket(var1);
    }

    public void handleArmAnimation(Packet18Animation var1) {
        this.registerPacket(var1);
    }

    public void func_21001_a(Packet19EntityAction var1) {
        this.registerPacket(var1);
    }

    public void handleHandshake(Packet2Handshake var1) {
        this.registerPacket(var1);
    }

    public void handleMobSpawn(Packet24MobSpawn var1) {
        this.registerPacket(var1);
    }

    public void handleUpdateTime(Packet4UpdateTime var1) {
        this.registerPacket(var1);
    }

    public void handleSpawnPosition(Packet6SpawnPosition var1) {
        this.registerPacket(var1);
    }

    public void func_6002_a(Packet28EntityVelocity var1) {
        this.registerPacket(var1);
    }

    public void func_21002_a(Packet40EntityMetadata var1) {
        this.registerPacket(var1);
    }

    public void func_6003_a(Packet39AttachEntity var1) {
        this.registerPacket(var1);
    }

    public void func_6006_a(Packet7UseEntity var1) {
        this.registerPacket(var1);
    }

    public void func_9001_a(Packet38EntityStatus var1) {
        this.registerPacket(var1);
    }

    public void handleHealth(Packet8UpdateHealth var1) {
        this.registerPacket(var1);
    }

    public void handleRespawnPacket(Packet9Respawn var1) {
        this.registerPacket(var1);
    }

    public void func_12001_a(Packet60Explosion var1) {
        this.registerPacket(var1);
    }

    public void func_20004_a(Packet100OpenWindow var1) {
        this.registerPacket(var1);
    }

    public void handleCraftingGuiClosedPacked(Packet101CloseWindow var1) {
        this.registerPacket(var1);
    }

    public void func_20007_a(Packet102WindowClick var1) {
        this.registerPacket(var1);
    }

    public void func_20003_a(Packet103SetSlot var1) {
        this.registerPacket(var1);
    }

    public void func_20001_a(Packet104WindowItems var1) {
        this.registerPacket(var1);
    }

    public void handleUpdateSign(Packet130UpdateSign var1) {
        this.registerPacket(var1);
    }

    public void func_20002_a(Packet105UpdateProgressbar var1) {
        this.registerPacket(var1);
    }

    public void handlePlayerInventory(Packet5PlayerInventory var1) {
        this.registerPacket(var1);
    }

    public void func_20008_a(Packet106Transaction var1) {
        this.registerPacket(var1);
    }

    public void func_21003_a(Packet25EntityPainting var1) {
        this.registerPacket(var1);
    }

    public void func_21004_a(Packet54PlayNoteBlock var1) {
        this.registerPacket(var1);
    }

    public void func_27001_a(Packet200Statistic var1) {
        this.registerPacket(var1);
    }

    public void func_22002_a(Packet17Sleep var1) {
        this.registerPacket(var1);
    }

    public void handleMovementTypePacket(Packet27Position var1) {
        this.registerPacket(var1);
    }

    public void func_25001_a(Packet70Bed var1) {
        this.registerPacket(var1);
    }

    public void func_27002_a(Packet71Weather var1) {
        this.registerPacket(var1);
    }

    public void func_28001_a(Packet131MapData var1) {
        this.registerPacket(var1);
    }

    public void func_28002_a(Packet61DoorChange var1) {
        this.registerPacket(var1);
    }
}
