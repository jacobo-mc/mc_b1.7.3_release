package net.minecraft.src;

import net.minecraft.client.Minecraft;

/** Exercises real Beta containers; every shortcut must use ordinary window clicks. */
public final class QolInventoryTests {
    private static int checks;
    private static void check(boolean value, String message) {
        checks++;
        if (!value) throw new AssertionError(message);
    }
    private static final class EmptyWorld extends World {
        EmptyWorld() { super(null, "inventory-test", new WorldProviderSurface(), 123L); }
        protected IChunkProvider getChunkProvider() { return null; }
    }
    private static final class Player extends EntityPlayerSP {
        Player(World world) { super(null, world, new Session("InventoryTest", "-"), 0); }
        public void addStat(StatBase stat, int count) {}
    }
    private static final class Clicks extends PlayerController {
        int count;
        Clicks() { super(null); }
        public ItemStack handleMouseClick(int window, int slot, int button, boolean shift, EntityPlayer player) {
            check(!shift && slot >= 0 && (button == 0 || button == 1), "Use vanilla click packets; never drop items");
            check(window == player.craftingInventory.windowId, "Use the currently open window ID");
            count++;
            return super.handleMouseClick(window, slot, button, shift, player);
        }
    }
    private static final class Fixture {
        final Player player = new Player(new EmptyWorld());
        final Clicks controller = new Clicks();
        Container container = player.inventorySlots;
        void open(Container next) { container = next; next.windowId = 7; player.craftingInventory = next; }
        Slot playerSlot(int index) {
            for (Object value : container.slots) {
                Slot slot = (Slot)value;
                if (slot.getInventoryIndex(player.inventory) == index) return slot;
            }
            throw new AssertionError("Missing inventory slot " + index);
        }
        boolean move(Slot slot) {
            boolean moved = InventoryActions.quickMove(controller, container, slot.slotNumber, player);
            check(player.inventory.getItemStack() == null, "Quick move leaves cursor empty");
            return moved;
        }
        boolean swap(Slot slot, int hotbar) {
            boolean moved = InventoryActions.swapHotbar(controller, container, slot.slotNumber, hotbar, player);
            check(player.inventory.getItemStack() == null, "Hotbar swap leaves cursor empty");
            return moved;
        }
    }
    private static ItemStack stone(int size) { return new ItemStack(Block.stone, size); }
    private static void stack(ItemStack stack, int id, int count, String message) {
        check(stack != null && stack.itemID == id && stack.stackSize == count, message);
    }
    private static int total(InventoryPlayer inventory, int id) {
        int total = 0;
        for (ItemStack stack : inventory.mainInventory) if (stack != null && stack.itemID == id) total += stack.stackSize;
        return total;
    }
    public static void main(String[] args) throws Exception {
        StatList.func_27360_a();
        hotbarSwaps();
        playerTransfers();
        storageTransfers();
        furnaceTransfers();
        craftingTransfers();
        guiBindings();
        lighting();
        System.out.println("PASS: " + checks + " inventory/lighting checks (swaps, limits, transfers, recipes, GUI bindings, light restoration)");
    }
    private static void hotbarSwaps() {
        Fixture f = new Fixture();
        f.player.inventory.mainInventory[9] = stone(12);
        f.player.inventory.mainInventory[0] = new ItemStack(Block.dirt, 8);
        check(f.swap(f.playerSlot(9), 0), "Exchange different items");
        stack(f.player.inventory.mainInventory[0], Block.stone.blockID, 12, "Hovered stack to hotbar");
        stack(f.player.inventory.mainInventory[9], Block.dirt.blockID, 8, "Hotbar stack to hovered slot");
        check(f.controller.count == 3, "Three normal clicks for a simple swap");
        check(!f.swap(f.playerSlot(0), 0), "Swapping a hotbar slot with itself is a no-op");
        for (int a : new int[]{1, 8, 64}) for (int b : new int[]{1, 8, 64}) {
            f = new Fixture();
            for (int i = 0; i < 36; i++) f.player.inventory.mainInventory[i] = stone(64);
            f.player.inventory.mainInventory[9] = stone(a); f.player.inventory.mainInventory[0] = stone(b);
            f.swap(f.playerSlot(9), 0);
            stack(f.player.inventory.mainInventory[9], Block.stone.blockID, b, "Equal-item stacks exchange counts with full inventory");
            stack(f.player.inventory.mainInventory[0], Block.stone.blockID, a, "Equal-item hotbar count exchanged");
        }
        f = new Fixture();
        for (int i = 0; i < 36; i++) f.player.inventory.mainInventory[i] = stone(64);
        f.player.inventory.mainInventory[9] = new ItemStack(Item.pickaxeSteel, 1, 7);
        f.player.inventory.mainInventory[0] = new ItemStack(Item.pickaxeSteel, 1, 42);
        check(f.swap(f.playerSlot(9), 0), "Different durability tools swap even with full inventory");
        check(f.player.inventory.mainInventory[9].getItemDamage() == 42 && f.player.inventory.mainInventory[0].getItemDamage() == 7, "Durability preserved");
        stack(f.player.inventory.mainInventory[10], Block.stone.blockID, 64, "Temporary occupied slot restored");
        f = new Fixture();
        f.player.inventory.mainInventory[0] = new ItemStack(Block.pumpkin, 64);
        check(f.swap(f.playerSlot(39), 0), "Equip pumpkin into an empty helmet slot");
        stack(f.player.inventory.armorInventory[3], Block.pumpkin.blockID, 1, "Armour slot limit respected");
        stack(f.player.inventory.mainInventory[0], Block.pumpkin.blockID, 63, "Remaining stack returned to hotbar");
        f = new Fixture();
        f.player.inventory.mainInventory[0] = stone(4);
        check(!f.swap(f.playerSlot(39), 0), "Invalid armour swap rejected");
        f.player.inventory.setItemStack(stone(3));
        check(!InventoryActions.swapHotbar(f.controller, f.container, f.playerSlot(9).slotNumber, 0, f.player), "Occupied cursor is protected");
        stack(f.player.inventory.getItemStack(), Block.stone.blockID, 3, "Cursor item unchanged");
    }
    private static void playerTransfers() {
        Fixture f = new Fixture();
        f.player.inventory.mainInventory[9] = stone(10); f.player.inventory.mainInventory[0] = stone(60);
        check(f.move(f.playerSlot(9)), "Main inventory to hotbar");
        stack(f.player.inventory.mainInventory[0], Block.stone.blockID, 64, "Merge existing stacks first");
        stack(f.player.inventory.mainInventory[1], Block.stone.blockID, 6, "Remainder goes to an empty slot");
        check(total(f.player.inventory, Block.stone.blockID) == 70, "Transfer conserves items");
        check(f.move(f.playerSlot(0)), "Hotbar to main inventory");
        stack(f.player.inventory.mainInventory[9], Block.stone.blockID, 64, "Hotbar transfer destination");
        f = new Fixture();
        f.player.inventory.mainInventory[9] = new ItemStack(Item.helmetDiamond);
        check(f.move(f.playerSlot(9)), "Shift-click auto equips armour");
        check(f.player.inventory.armorInventory[3].itemID == Item.helmetDiamond.shiftedIndex, "Correct armour position");
        check(f.move(f.playerSlot(39)), "Shift-click unequips armour");
        check(f.player.inventory.armorInventory[3] == null, "Armour slot emptied");
        f = new Fixture();
        f.player.inventory.mainInventory[9] = new ItemStack(Block.pumpkin, 64);
        f.move(f.playerSlot(9));
        check(f.player.inventory.armorInventory[3].stackSize == 1 && f.player.inventory.mainInventory[9].stackSize == 63, "Auto equip respects slot limit without losing remainder");
    }
    private static void storageTransfers() {
        for (int size : new int[]{27, 54}) {
            Fixture f = new Fixture(); InventoryBasic chest = new InventoryBasic("Test chest", size);
            f.open(new ContainerChest(f.player.inventory, chest));
            chest.setInventorySlotContents(0, stone(60));
            f.player.inventory.mainInventory[9] = stone(20);
            check(f.move(f.playerSlot(9)), "Player to chest " + size);
            stack(chest.getStackInSlot(0), Block.stone.blockID, 64, "Chest stack merged first");
            stack(chest.getStackInSlot(1), Block.stone.blockID, 16, "Chest remainder stored");
            check(f.move(f.container.getSlot(1)), "Chest to player " + size);
            stack(f.player.inventory.mainInventory[8], Block.stone.blockID, 16, "Chest returns to hotbar");
            for (int i = 0; i < size; i++) chest.setInventorySlotContents(i, stone(64));
            f.player.inventory.mainInventory[9] = new ItemStack(Block.dirt, 10);
            int before = f.controller.count;
            check(!f.move(f.playerSlot(9)) && before == f.controller.count, "Full chest leaves source untouched");
            stack(f.player.inventory.mainInventory[9], Block.dirt.blockID, 10, "Full target source retained");
        }
        Fixture partial = new Fixture(); InventoryBasic limited = new InventoryBasic("Limited", 27);
        partial.open(new ContainerChest(partial.player.inventory, limited));
        for (int i = 0; i < 27; i++) limited.setInventorySlotContents(i, stone(64));
        limited.setInventorySlotContents(0, stone(62)); partial.player.inventory.mainInventory[9] = stone(10);
        check(partial.move(partial.playerSlot(9)), "Partially filled target accepts available capacity");
        stack(limited.getStackInSlot(0), Block.stone.blockID, 64, "Partial transfer fills target");
        stack(partial.player.inventory.mainInventory[9], Block.stone.blockID, 8, "Untransferred remainder returned to original slot");
        partial.player.inventory.setItemStack(new ItemStack(Block.dirt, 3));
        check(!InventoryActions.quickMove(partial.controller, partial.container, 0, partial.player), "Shift shortcut does not disturb an occupied cursor");
        stack(partial.player.inventory.getItemStack(), Block.dirt.blockID, 3, "Held stack remains unchanged");
        Fixture f = new Fixture(); InventoryBasic chest = new InventoryBasic("Subtypes", 27);
        f.open(new ContainerChest(f.player.inventory, chest));
        chest.setInventorySlotContents(0, new ItemStack(Item.dyePowder, 60, 1));
        f.player.inventory.mainInventory[9] = new ItemStack(Item.dyePowder, 4, 0);
        f.move(f.playerSlot(9));
        check(chest.getStackInSlot(0).stackSize == 60 && chest.getStackInSlot(1).getItemDamage() == 0, "Different metadata never merged");
        f = new Fixture(); TileEntityDispenser dispenser = new TileEntityDispenser();
        f.open(new ContainerDispenser(f.player.inventory, dispenser));
        f.player.inventory.mainInventory[9] = stone(40);
        check(f.move(f.playerSlot(9)), "Player to dispenser");
        stack(dispenser.getStackInSlot(0), Block.stone.blockID, 40, "Dispenser received stack");
        check(f.move(f.container.getSlot(0)), "Dispenser to player");
        check(total(f.player.inventory, Block.stone.blockID) == 40 && dispenser.getStackInSlot(0) == null, "Dispenser move conserves items");
    }
    private static void furnaceTransfers() {
        Fixture f = new Fixture(); TileEntityFurnace furnace = new TileEntityFurnace();
        f.open(new ContainerFurnace(f.player.inventory, furnace));
        f.player.inventory.mainInventory[9] = new ItemStack(Block.oreIron, 20);
        check(f.move(f.playerSlot(9)), "Smeltable item routed into furnace input");
        stack(furnace.getStackInSlot(0), Block.oreIron.blockID, 20, "Furnace input filled");
        f.player.inventory.mainInventory[10] = new ItemStack(Item.coal, 8);
        check(f.move(f.playerSlot(10)), "Fuel routed into furnace fuel slot");
        stack(furnace.getStackInSlot(1), Item.coal.shiftedIndex, 8, "Furnace fuel filled");
        f.player.inventory.mainInventory[11] = new ItemStack(Block.dirt, 3);
        check(f.move(f.playerSlot(11)), "Non-furnace item goes between inventory and hotbar");
        stack(f.player.inventory.mainInventory[0], Block.dirt.blockID, 3, "Non-furnace item destination");
        furnace.setInventorySlotContents(2, new ItemStack(Item.ingotIron, 4));
        check(f.move(f.container.getSlot(2)), "Furnace result extracted");
        check(furnace.getStackInSlot(2) == null && total(f.player.inventory, Item.ingotIron.shiftedIndex) == 4, "Furnace output conserved");
        furnace.setInventorySlotContents(2, new ItemStack(Item.ingotIron, 1));
        f.player.inventory.mainInventory[0] = stone(5);
        check(f.swap(f.container.getSlot(2), 0), "Output slot hotbar shortcut relocates displaced item");
        stack(f.player.inventory.mainInventory[0], Item.ingotIron.shiftedIndex, 1, "Output to chosen hotbar");
        check(total(f.player.inventory, Block.stone.blockID) == 5, "Displaced hotbar item retained");
    }
    private static void craftingTransfers() {
        Fixture f = new Fixture(); ContainerPlayer personal = (ContainerPlayer)f.container;
        personal.craftMatrix.setInventorySlotContents(0, new ItemStack(Block.wood, 3));
        check(f.move(personal.getSlot(0)), "Shift crafting repeats available recipe");
        check(personal.craftMatrix.getStackInSlot(0) == null && total(f.player.inventory, Block.planks.blockID) == 12, "Three logs craft exactly twelve planks");
        f = new Fixture(); ContainerWorkbench table = new ContainerWorkbench(f.player.inventory, f.player.worldObj, 0, 0, 0);
        f.open(table); table.craftMatrix.setInventorySlotContents(0, new ItemStack(Block.wood, 2));
        check(f.move(table.getSlot(0)), "Workbench shift crafting");
        check(total(f.player.inventory, Block.planks.blockID) == 8 && table.craftMatrix.getStackInSlot(0) == null, "Workbench consumes ingredients exactly once per recipe");
        table.craftMatrix.setInventorySlotContents(0, new ItemStack(Block.wood, 2));
        f.player.inventory.mainInventory[0] = stone(5);
        check(f.swap(table.getSlot(0), 0), "Number key takes crafting result");
        stack(f.player.inventory.mainInventory[0], Block.planks.blockID, 4, "One recipe to hotbar");
        check(table.craftMatrix.getStackInSlot(0).stackSize == 1 && total(f.player.inventory, Block.stone.blockID) == 5, "Craft result swap preserves displaced item and remaining ingredients");
        f = new Fixture(); personal = (ContainerPlayer)f.container;
        for (int i = 0; i < 36; i++) f.player.inventory.mainInventory[i] = stone(64);
        personal.craftMatrix.setInventorySlotContents(0, new ItemStack(Block.wood, 2));
        check(!f.move(personal.getSlot(0)), "Full inventory does not consume ingredients");
        check(personal.craftMatrix.getStackInSlot(0).stackSize == 2, "Blocked recipe untouched");
    }
    private static void guiBindings() {
        Fixture f = new Fixture();
        Minecraft mc = new Minecraft(null, null, null, 854, 480, false) {
            public void displayUnexpectedThrowable(UnexpectedThrowable crash) { throw new AssertionError("Client crash"); }
        };
        try {
            mc.gameSettings = new GameSettings(); mc.thePlayer = f.player; mc.playerController = f.controller;
            GuiContainer gui = new GuiContainer(f.container) { protected void drawGuiContainerBackgroundLayer(float tick) {} };
            gui.mc = mc; gui.width = 176; gui.height = 166;
            mc.gameSettings.keyBindHotbar[0].keyCode = 51;
            f.player.inventory.mainInventory[9] = stone(6);
            Slot source = f.playerSlot(9);
            check(gui.handleHotbarKey(51, source.xDisplayPosition + 8, source.yDisplayPosition + 8), "GUI honors rebindable hotbar key at hovered slot");
            stack(f.player.inventory.mainInventory[0], Block.stone.blockID, 6, "GUI number key moved hovered item");
            check(!gui.handleHotbarKey(2, source.xDisplayPosition + 8, source.yDisplayPosition + 8), "Old number key no longer bound");
            gui.handleInventoryClick(f.playerSlot(0).slotNumber, 0, true);
            stack(f.player.inventory.mainInventory[9], Block.stone.blockID, 6, "GUI shift click dispatches quick move");
        } finally { mc.running = false; }
    }
    private static void lighting() {
        ClientLighting lighting = new ClientLighting();
        WorldProvider overworld = new EmptyWorld().worldProvider;
        WorldProvider nether = new WorldProviderHell();
        float[] normal = overworld.lightBrightnessTable.clone();
        for (int i = 0; i < 16; i++) nether.lightBrightnessTable[i] = .1F + i / 20F;
        float[] hell = nether.lightBrightnessTable.clone();
        check(lighting.update(overworld, true), "Enable fullbright requests terrain rebuild");
        for (float value : overworld.lightBrightnessTable) check(value == 1F, "All light levels render at full brightness");
        check(!lighting.update(overworld, true), "No redundant rebuild every frame");
        check(lighting.update(nether, true), "Fullbright follows dimension switch");
        check(java.util.Arrays.equals(overworld.lightBrightnessTable, normal), "Old world restored on dimension switch");
        check(lighting.update(nether, false), "Disabling fullbright rebuilds terrain");
        check(java.util.Arrays.equals(nether.lightBrightnessTable, hell), "Exact original Nether lighting restored");
        check(!lighting.update(null, false), "No world is safe");
    }
}
