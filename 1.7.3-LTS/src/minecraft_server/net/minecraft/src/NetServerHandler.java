package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetServerHandler extends NetHandler implements ICommandListener {
    public static Logger logger = Logger.getLogger("Minecraft");
    public NetworkManager netManager;
    public boolean connectionClosed = false;
    private MinecraftServer mcServer;
    private EntityPlayerMP playerEntity;
    private int field_15_f;
    private int field_22004_g;
    private int playerInAirTime;
    private boolean field_22003_h;
    private double lastPosX;
    private double lastPosY;
    private double lastPosZ;
    private boolean hasMoved = true;
    private Map field_10_k = new HashMap();

    public NetServerHandler(MinecraftServer var1, NetworkManager var2, EntityPlayerMP var3) {
        this.mcServer = var1;
        this.netManager = var2;
        var2.setNetHandler(this);
        this.playerEntity = var3;
        var3.playerNetServerHandler = this;
    }

    public void handlePackets() {
        this.field_22003_h = false;
        this.netManager.processReadPackets();
        if (this.field_15_f - this.field_22004_g > 20) {
            this.sendPacket(new Packet0KeepAlive());
        }

    }

    public void kickPlayer(String var1) {
        this.playerEntity.func_30002_A();
        this.sendPacket(new Packet255KickDisconnect(var1));
        this.netManager.serverShutdown();
        this.mcServer.configManager.sendPacketToAllPlayers(new Packet3Chat("\u00a7e" + this.playerEntity.username + " left the game."));
        this.mcServer.configManager.playerLoggedOut(this.playerEntity);
        this.connectionClosed = true;
    }

    public void handleMovementTypePacket(Packet27Position var1) {
        this.playerEntity.setMovementType(var1.func_22031_c(), var1.func_22028_e(), var1.func_22032_g(), var1.func_22030_h(), var1.func_22029_d(), var1.func_22033_f());
    }

    public void handleFlying(Packet10Flying var1) {
        WorldServer var2 = this.mcServer.getWorldManager(this.playerEntity.dimension);
        this.field_22003_h = true;
        double var3;
        if (!this.hasMoved) {
            var3 = var1.yPosition - this.lastPosY;
            if (var1.xPosition == this.lastPosX && var3 * var3 < 0.01D && var1.zPosition == this.lastPosZ) {
                this.hasMoved = true;
            }
        }

        if (this.hasMoved) {
            double var5;
            double var7;
            double var9;
            double var13;
            if (this.playerEntity.ridingEntity != null) {
                float var26 = this.playerEntity.rotationYaw;
                float var4 = this.playerEntity.rotationPitch;
                this.playerEntity.ridingEntity.updateRiderPosition();
                var5 = this.playerEntity.posX;
                var7 = this.playerEntity.posY;
                var9 = this.playerEntity.posZ;
                double var27 = 0.0D;
                var13 = 0.0D;
                if (var1.rotating) {
                    var26 = var1.yaw;
                    var4 = var1.pitch;
                }

                if (var1.moving && var1.yPosition == -999.0D && var1.stance == -999.0D) {
                    var27 = var1.xPosition;
                    var13 = var1.zPosition;
                }

                this.playerEntity.onGround = var1.onGround;
                this.playerEntity.onUpdateEntity(true);
                this.playerEntity.moveEntity(var27, 0.0D, var13);
                this.playerEntity.setPositionAndRotation(var5, var7, var9, var26, var4);
                this.playerEntity.motionX = var27;
                this.playerEntity.motionZ = var13;
                if (this.playerEntity.ridingEntity != null) {
                    var2.func_12017_b(this.playerEntity.ridingEntity, true);
                }

                if (this.playerEntity.ridingEntity != null) {
                    this.playerEntity.ridingEntity.updateRiderPosition();
                }

                this.mcServer.configManager.func_613_b(this.playerEntity);
                this.lastPosX = this.playerEntity.posX;
                this.lastPosY = this.playerEntity.posY;
                this.lastPosZ = this.playerEntity.posZ;
                var2.updateEntity(this.playerEntity);
                return;
            }

            if (this.playerEntity.func_22057_E()) {
                this.playerEntity.onUpdateEntity(true);
                this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                var2.updateEntity(this.playerEntity);
                return;
            }

            var3 = this.playerEntity.posY;
            this.lastPosX = this.playerEntity.posX;
            this.lastPosY = this.playerEntity.posY;
            this.lastPosZ = this.playerEntity.posZ;
            var5 = this.playerEntity.posX;
            var7 = this.playerEntity.posY;
            var9 = this.playerEntity.posZ;
            float var11 = this.playerEntity.rotationYaw;
            float var12 = this.playerEntity.rotationPitch;
            if (var1.moving && var1.yPosition == -999.0D && var1.stance == -999.0D) {
                var1.moving = false;
            }

            if (var1.moving) {
                var5 = var1.xPosition;
                var7 = var1.yPosition;
                var9 = var1.zPosition;
                var13 = var1.stance - var1.yPosition;
                if (!this.playerEntity.func_22057_E() && (var13 > 1.65D || var13 < 0.1D)) {
                    this.kickPlayer("Illegal stance");
                    logger.warning(this.playerEntity.username + " had an illegal stance: " + var13);
                    return;
                }

                if (Math.abs(var1.xPosition) > 3.2E7D || Math.abs(var1.zPosition) > 3.2E7D) {
                    this.kickPlayer("Illegal position");
                    return;
                }
            }

            if (var1.rotating) {
                var11 = var1.yaw;
                var12 = var1.pitch;
            }

            this.playerEntity.onUpdateEntity(true);
            this.playerEntity.ySize = 0.0F;
            this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, var11, var12);
            if (!this.hasMoved) {
                return;
            }

            var13 = var5 - this.playerEntity.posX;
            double var15 = var7 - this.playerEntity.posY;
            double var17 = var9 - this.playerEntity.posZ;
            double var19 = var13 * var13 + var15 * var15 + var17 * var17;
            if (var19 > 100.0D) {
                logger.warning(this.playerEntity.username + " moved too quickly!");
                this.kickPlayer("You moved too quickly :( (Hacking?)");
                return;
            }

            float var21 = 0.0625F;
            boolean var22 = var2.getCollidingBoundingBoxes(this.playerEntity, this.playerEntity.boundingBox.copy().getInsetBoundingBox((double)var21, (double)var21, (double)var21)).size() == 0;
            this.playerEntity.moveEntity(var13, var15, var17);
            var13 = var5 - this.playerEntity.posX;
            var15 = var7 - this.playerEntity.posY;
            if (var15 > -0.5D || var15 < 0.5D) {
                var15 = 0.0D;
            }

            var17 = var9 - this.playerEntity.posZ;
            var19 = var13 * var13 + var15 * var15 + var17 * var17;
            boolean var23 = false;
            if (var19 > 0.0625D && !this.playerEntity.func_22057_E()) {
                var23 = true;
                logger.warning(this.playerEntity.username + " moved wrongly!");
                System.out.println("Got position " + var5 + ", " + var7 + ", " + var9);
                System.out.println("Expected " + this.playerEntity.posX + ", " + this.playerEntity.posY + ", " + this.playerEntity.posZ);
            }

            this.playerEntity.setPositionAndRotation(var5, var7, var9, var11, var12);
            boolean var24 = var2.getCollidingBoundingBoxes(this.playerEntity, this.playerEntity.boundingBox.copy().getInsetBoundingBox((double)var21, (double)var21, (double)var21)).size() == 0;
            if (var22 && (var23 || !var24) && !this.playerEntity.func_22057_E()) {
                this.teleportTo(this.lastPosX, this.lastPosY, this.lastPosZ, var11, var12);
                return;
            }

            AxisAlignedBB var25 = this.playerEntity.boundingBox.copy().expand((double)var21, (double)var21, (double)var21).addCoord(0.0D, -0.55D, 0.0D);
            if (!this.mcServer.allowFlight && !var2.func_27069_b(var25)) {
                if (var15 >= -0.03125D) {
                    ++this.playerInAirTime;
                    if (this.playerInAirTime > 80) {
                        logger.warning(this.playerEntity.username + " was kicked for floating too long!");
                        this.kickPlayer("Flying is not enabled on this server");
                        return;
                    }
                }
            } else {
                this.playerInAirTime = 0;
            }

            this.playerEntity.onGround = var1.onGround;
            this.mcServer.configManager.func_613_b(this.playerEntity);
            this.playerEntity.handleFalling(this.playerEntity.posY - var3, var1.onGround);
        }

    }

    public void teleportTo(double var1, double var3, double var5, float var7, float var8) {
        this.hasMoved = false;
        this.lastPosX = var1;
        this.lastPosY = var3;
        this.lastPosZ = var5;
        this.playerEntity.setPositionAndRotation(var1, var3, var5, var7, var8);
        this.playerEntity.playerNetServerHandler.sendPacket(new Packet13PlayerLookMove(var1, var3 + 1.6200000047683716D, var3, var5, var7, var8, false));
    }

    public void handleBlockDig(Packet14BlockDig var1) {
        WorldServer var2 = this.mcServer.getWorldManager(this.playerEntity.dimension);
        if (var1.status == 4) {
            this.playerEntity.dropCurrentItem();
        } else {
            boolean var3 = var2.field_819_z = var2.worldProvider.worldType != 0 || this.mcServer.configManager.isOp(this.playerEntity.username);
            boolean var4 = false;
            if (var1.status == 0) {
                var4 = true;
            }

            if (var1.status == 2) {
                var4 = true;
            }

            int var5 = var1.xPosition;
            int var6 = var1.yPosition;
            int var7 = var1.zPosition;
            if (var4) {
                double var8 = this.playerEntity.posX - ((double)var5 + 0.5D);
                double var10 = this.playerEntity.posY - ((double)var6 + 0.5D);
                double var12 = this.playerEntity.posZ - ((double)var7 + 0.5D);
                double var14 = var8 * var8 + var10 * var10 + var12 * var12;
                if (var14 > 36.0D) {
                    return;
                }
            }

            ChunkCoordinates var19 = var2.getSpawnPoint();
            int var9 = (int)MathHelper.abs((float)(var5 - var19.posX));
            int var20 = (int)MathHelper.abs((float)(var7 - var19.posZ));
            if (var9 > var20) {
                var20 = var9;
            }

            if (var1.status == 0) {
                if (var20 <= 16 && !var3) {
                    this.playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(var5, var6, var7, var2));
                } else {
                    this.playerEntity.itemInWorldManager.func_324_a(var5, var6, var7, var1.face);
                }
            } else if (var1.status == 2) {
                this.playerEntity.itemInWorldManager.func_22045_b(var5, var6, var7);
                if (var2.getBlockId(var5, var6, var7) != 0) {
                    this.playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(var5, var6, var7, var2));
                }
            } else if (var1.status == 3) {
                double var11 = this.playerEntity.posX - ((double)var5 + 0.5D);
                double var13 = this.playerEntity.posY - ((double)var6 + 0.5D);
                double var15 = this.playerEntity.posZ - ((double)var7 + 0.5D);
                double var17 = var11 * var11 + var13 * var13 + var15 * var15;
                if (var17 < 256.0D) {
                    this.playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(var5, var6, var7, var2));
                }
            }

            var2.field_819_z = false;
        }
    }

    public void handlePlace(Packet15Place var1) {
        WorldServer var2 = this.mcServer.getWorldManager(this.playerEntity.dimension);
        ItemStack var3 = this.playerEntity.inventory.getCurrentItem();
        boolean var4 = var2.field_819_z = var2.worldProvider.worldType != 0 || this.mcServer.configManager.isOp(this.playerEntity.username);
        if (var1.direction == 255) {
            if (var3 == null) {
                return;
            }

            this.playerEntity.itemInWorldManager.func_6154_a(this.playerEntity, var2, var3);
        } else {
            int var5 = var1.xPosition;
            int var6 = var1.yPosition;
            int var7 = var1.zPosition;
            int var8 = var1.direction;
            ChunkCoordinates var9 = var2.getSpawnPoint();
            int var10 = (int)MathHelper.abs((float)(var5 - var9.posX));
            int var11 = (int)MathHelper.abs((float)(var7 - var9.posZ));
            if (var10 > var11) {
                var11 = var10;
            }

            if (this.hasMoved && this.playerEntity.getDistanceSq((double)var5 + 0.5D, (double)var6 + 0.5D, (double)var7 + 0.5D) < 64.0D && (var11 > 16 || var4)) {
                this.playerEntity.itemInWorldManager.activeBlockOrUseItem(this.playerEntity, var2, var3, var5, var6, var7, var8);
            }

            this.playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(var5, var6, var7, var2));
            if (var8 == 0) {
                --var6;
            }

            if (var8 == 1) {
                ++var6;
            }

            if (var8 == 2) {
                --var7;
            }

            if (var8 == 3) {
                ++var7;
            }

            if (var8 == 4) {
                --var5;
            }

            if (var8 == 5) {
                ++var5;
            }

            this.playerEntity.playerNetServerHandler.sendPacket(new Packet53BlockChange(var5, var6, var7, var2));
        }

        var3 = this.playerEntity.inventory.getCurrentItem();
        if (var3 != null && var3.stackSize == 0) {
            this.playerEntity.inventory.mainInventory[this.playerEntity.inventory.currentItem] = null;
        }

        this.playerEntity.isChangingQuantityOnly = true;
        this.playerEntity.inventory.mainInventory[this.playerEntity.inventory.currentItem] = ItemStack.func_20117_a(this.playerEntity.inventory.mainInventory[this.playerEntity.inventory.currentItem]);
        Slot var12 = this.playerEntity.currentCraftingInventory.func_20127_a(this.playerEntity.inventory, this.playerEntity.inventory.currentItem);
        this.playerEntity.currentCraftingInventory.updateCraftingMatrix();
        this.playerEntity.isChangingQuantityOnly = false;
        if (!ItemStack.areItemStacksEqual(this.playerEntity.inventory.getCurrentItem(), var1.itemStack)) {
            this.sendPacket(new Packet103SetSlot(this.playerEntity.currentCraftingInventory.windowId, var12.id, this.playerEntity.inventory.getCurrentItem()));
        }

        var2.field_819_z = false;
    }

    public void handleErrorMessage(String var1, Object[] var2) {
        logger.info(this.playerEntity.username + " lost connection: " + var1);
        this.mcServer.configManager.sendPacketToAllPlayers(new Packet3Chat("\u00a7e" + this.playerEntity.username + " left the game."));
        this.mcServer.configManager.playerLoggedOut(this.playerEntity);
        this.connectionClosed = true;
    }

    public void registerPacket(Packet var1) {
        logger.warning(this.getClass() + " wasn't prepared to deal with a " + var1.getClass());
        this.kickPlayer("Protocol error, unexpected packet");
    }

    public void sendPacket(Packet var1) {
        this.netManager.addToSendQueue(var1);
        this.field_22004_g = this.field_15_f;
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch var1) {
        if (var1.id >= 0 && var1.id <= InventoryPlayer.func_25054_e()) {
            this.playerEntity.inventory.currentItem = var1.id;
        } else {
            logger.warning(this.playerEntity.username + " tried to set an invalid carried item");
        }
    }

    public void handleChat(Packet3Chat var1) {
        String var2 = var1.message;
        if (var2.length() > 100) {
            this.kickPlayer("Chat message too long");
        } else {
            var2 = var2.trim();

            for(int var3 = 0; var3 < var2.length(); ++var3) {
                if (ChatAllowedCharacters.allowedCharacters.indexOf(var2.charAt(var3)) < 0) {
                    this.kickPlayer("Illegal characters in chat");
                    return;
                }
            }

            if (var2.startsWith("/")) {
                this.handleSlashCommand(var2);
            } else {
                var2 = "<" + this.playerEntity.username + "> " + var2;
                logger.info(var2);
                this.mcServer.configManager.sendPacketToAllPlayers(new Packet3Chat(var2));
            }

        }
    }

    private void handleSlashCommand(String var1) {
        if (var1.toLowerCase().startsWith("/me ")) {
            var1 = "* " + this.playerEntity.username + " " + var1.substring(var1.indexOf(" ")).trim();
            logger.info(var1);
            this.mcServer.configManager.sendPacketToAllPlayers(new Packet3Chat(var1));
        } else if (var1.toLowerCase().startsWith("/kill")) {
            this.playerEntity.attackEntityFrom((Entity)null, 1000);
        } else if (var1.toLowerCase().startsWith("/tell ")) {
            String[] var2 = var1.split(" ");
            if (var2.length >= 3) {
                var1 = var1.substring(var1.indexOf(" ")).trim();
                var1 = var1.substring(var1.indexOf(" ")).trim();
                var1 = "\u00a77" + this.playerEntity.username + " whispers " + var1;
                logger.info(var1 + " to " + var2[1]);
                if (!this.mcServer.configManager.sendPacketToPlayer(var2[1], new Packet3Chat(var1))) {
                    this.sendPacket(new Packet3Chat("\u00a7cThere's no player by that name online."));
                }
            }
        } else {
            String var3;
            if (this.mcServer.configManager.isOp(this.playerEntity.username)) {
                var3 = var1.substring(1);
                logger.info(this.playerEntity.username + " issued server command: " + var3);
                this.mcServer.addCommand(var3, this);
            } else {
                var3 = var1.substring(1);
                logger.info(this.playerEntity.username + " tried command: " + var3);
            }
        }

    }

    public void handleArmAnimation(Packet18Animation var1) {
        if (var1.animate == 1) {
            this.playerEntity.swingItem();
        }

    }

    public void func_21001_a(Packet19EntityAction var1) {
        if (var1.state == 1) {
            this.playerEntity.setSneaking(true);
        } else if (var1.state == 2) {
            this.playerEntity.setSneaking(false);
        } else if (var1.state == 3) {
            this.playerEntity.wakeUpPlayer(false, true, true);
            this.hasMoved = false;
        }

    }

    public void handleKickDisconnect(Packet255KickDisconnect var1) {
        this.netManager.networkShutdown("disconnect.quitting");
    }

    public int getNumChunkDataPackets() {
        return this.netManager.getNumChunkDataPackets();
    }

    public void log(String var1) {
        this.sendPacket(new Packet3Chat("\u00a77" + var1));
    }

    public String getUsername() {
        return this.playerEntity.username;
    }

    public void func_6006_a(Packet7UseEntity var1) {
        WorldServer var2 = this.mcServer.getWorldManager(this.playerEntity.dimension);
        Entity var3 = var2.func_6158_a(var1.targetEntity);
        if (var3 != null && this.playerEntity.canEntityBeSeen(var3) && this.playerEntity.getDistanceSqToEntity(var3) < 36.0D) {
            if (var1.isLeftClick == 0) {
                this.playerEntity.useCurrentItemOnEntity(var3);
            } else if (var1.isLeftClick == 1) {
                this.playerEntity.attackTargetEntityWithCurrentItem(var3);
            }
        }

    }

    public void handleRespawnPacket(Packet9Respawn var1) {
        if (this.playerEntity.health <= 0) {
            this.playerEntity = this.mcServer.configManager.recreatePlayerEntity(this.playerEntity, 0);
        }
    }

    public void handleCraftingGuiClosedPacked(Packet101CloseWindow var1) {
        this.playerEntity.closeCraftingGui();
    }

    public void func_20007_a(Packet102WindowClick var1) {
        if (this.playerEntity.currentCraftingInventory.windowId == var1.window_Id && this.playerEntity.currentCraftingInventory.getCanCraft(this.playerEntity)) {
            ItemStack var2 = this.playerEntity.currentCraftingInventory.func_27085_a(var1.inventorySlot, var1.mouseClick, var1.field_27039_f, this.playerEntity);
            if (ItemStack.areItemStacksEqual(var1.itemStack, var2)) {
                this.playerEntity.playerNetServerHandler.sendPacket(new Packet106Transaction(var1.window_Id, var1.action, true));
                this.playerEntity.isChangingQuantityOnly = true;
                this.playerEntity.currentCraftingInventory.updateCraftingMatrix();
                this.playerEntity.updateHeldItem();
                this.playerEntity.isChangingQuantityOnly = false;
            } else {
                this.field_10_k.put(this.playerEntity.currentCraftingInventory.windowId, var1.action);
                this.playerEntity.playerNetServerHandler.sendPacket(new Packet106Transaction(var1.window_Id, var1.action, false));
                this.playerEntity.currentCraftingInventory.setCanCraft(this.playerEntity, false);
                ArrayList var3 = new ArrayList();

                for(int var4 = 0; var4 < this.playerEntity.currentCraftingInventory.inventorySlots.size(); ++var4) {
                    var3.add(((Slot)this.playerEntity.currentCraftingInventory.inventorySlots.get(var4)).getStack());
                }

                this.playerEntity.updateCraftingInventory(this.playerEntity.currentCraftingInventory, var3);
            }
        }

    }

    public void func_20008_a(Packet106Transaction var1) {
        Short var2 = (Short)this.field_10_k.get(this.playerEntity.currentCraftingInventory.windowId);
        if (var2 != null && var1.shortWindowId == var2 && this.playerEntity.currentCraftingInventory.windowId == var1.windowId && !this.playerEntity.currentCraftingInventory.getCanCraft(this.playerEntity)) {
            this.playerEntity.currentCraftingInventory.setCanCraft(this.playerEntity, true);
        }

    }

    public void handleUpdateSign(Packet130UpdateSign var1) {
        WorldServer var2 = this.mcServer.getWorldManager(this.playerEntity.dimension);
        if (var2.blockExists(var1.xPosition, var1.yPosition, var1.zPosition)) {
            TileEntity var3 = var2.getBlockTileEntity(var1.xPosition, var1.yPosition, var1.zPosition);
            if (var3 instanceof TileEntitySign) {
                TileEntitySign var4 = (TileEntitySign)var3;
                if (!var4.getIsEditAble()) {
                    this.mcServer.logWarning("Player " + this.playerEntity.username + " just tried to change non-editable sign");
                    return;
                }
            }

            int var6;
            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
                boolean var5 = true;
                if (var1.signLines[var9].length() > 15) {
                    var5 = false;
                } else {
                    for(var6 = 0; var6 < var1.signLines[var9].length(); ++var6) {
                        if (ChatAllowedCharacters.allowedCharacters.indexOf(var1.signLines[var9].charAt(var6)) < 0) {
                            var5 = false;
                        }
                    }
                }

                if (!var5) {
                    var1.signLines[var9] = "!?";
                }
            }

            if (var3 instanceof TileEntitySign) {
                var9 = var1.xPosition;
                int var10 = var1.yPosition;
                var6 = var1.zPosition;
                TileEntitySign var7 = (TileEntitySign)var3;

                for(int var8 = 0; var8 < 4; ++var8) {
                    var7.signText[var8] = var1.signLines[var8];
                }

                var7.func_32001_a(false);
                var7.onInventoryChanged();
                var2.markBlockNeedsUpdate(var9, var10, var6);
            }
        }

    }

    public boolean isServerHandler() {
        return true;
    }
}
