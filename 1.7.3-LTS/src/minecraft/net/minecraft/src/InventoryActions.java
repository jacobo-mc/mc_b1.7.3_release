package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Modern shortcuts expressed as normal Beta clicks, including multiplayer transactions. */
public final class InventoryActions {
    private InventoryActions() {}

    public static boolean swapHotbar(PlayerController controller, Container container, int sourceIndex, int hotbar, EntityPlayer player) {
        if (!ready(container, sourceIndex, player) || hotbar < 0 || hotbar > 8) return false;
        Slot source = container.getSlot(sourceIndex);
        Slot target = null;
        for (Object value : container.slots) {
            Slot slot = (Slot)value;
            if (slot.getInventoryIndex(player.inventory) == hotbar) target = slot;
        }
        if (target == null || source == target) return false;
        ItemStack from = source.getStack(), to = target.getStack();
        if (from == null) {
            if (to == null || !source.isItemValid(to)) return false;
            click(controller, container, target, 0, player);
            click(controller, container, source, 0, player);
            if (player.inventory.getItemStack() != null) click(controller, container, target, 0, player);
            return true;
        }
        if (!fits(target, from)) return false;
        if (to == null) {
            click(controller, container, source, 0, player);
            click(controller, container, target, 0, player);
            return true;
        }
        if (!fits(source, to)) {
            // Results/armour cannot accept an arbitrary displaced hotbar item.
            Slot spare = spareSlot(container, source, target, to, player, true);
            if (spare == null) return false;
            click(controller, container, target, 0, player);
            click(controller, container, spare, 0, player);
            click(controller, container, source, 0, player);
            click(controller, container, target, 0, player);
            return true;
        }
        if (clickMerges(from, to)) {
            if (from.isStackable() && from.getItemDamage() == to.getItemDamage()) {
                int difference = from.stackSize - to.stackSize;
                if (difference == 0) return false;
                Slot larger = difference > 0 ? source : target;
                Slot smaller = difference > 0 ? target : source;
                click(controller, container, larger, 0, player);
                for (int i = 0; i < Math.abs(difference); i++) click(controller, container, smaller, 1, player);
                if (player.inventory.getItemStack() != null) click(controller, container, larger, 0, player);
                return true;
            }
            // Beta merges equal item IDs even for differently damaged tools. Use a
            // temporary inventory slot so the shortcut still exchanges the items.
            Slot spare = spareSlot(container, source, target, from, player, false);
            if (spare == null) return false;
            boolean occupied = spare.getHasStack();
            click(controller, container, source, 0, player);
            click(controller, container, spare, 0, player);
            click(controller, container, target, 0, player);
            click(controller, container, source, 0, player);
            click(controller, container, spare, 0, player);
            click(controller, container, target, 0, player);
            if (occupied) click(controller, container, spare, 0, player);
            return true;
        }
        click(controller, container, source, 0, player);
        click(controller, container, target, 0, player);
        click(controller, container, source, 0, player);
        return true;
    }

    private static Slot spareSlot(Container container, Slot source, Slot hotbar, ItemStack incoming, EntityPlayer player, boolean emptyOnly) {
        Slot occupied = null;
        for (Object value : container.slots) {
            Slot slot = (Slot)value;
            int index = slot.getInventoryIndex(player.inventory);
            if (slot == source || slot == hotbar || index < 0 || index >= 36 || !fits(slot, incoming)) continue;
            if (!slot.getHasStack()) return slot;
            if (!emptyOnly && !clickMerges(slot.getStack(), incoming) && !clickMerges(slot.getStack(), hotbar.getStack())
                    && fits(hotbar, slot.getStack())) occupied = slot;
        }
        return occupied;
    }

    public static boolean quickMove(PlayerController controller, Container container, int sourceIndex, EntityPlayer player) {
        if (!ready(container, sourceIndex, player)) return false;
        Slot source = container.getSlot(sourceIndex);
        if (!source.getHasStack()) return false;
        ItemStack original = source.getStack().copy();
        boolean moved = false;
        // A stack in each crafting cell contains at most 64 recipes. Stop when the
        // recipe changes or its entire output no longer fits, leaving it untouched.
        for (int craft = 0; craft < 64; craft++) {
            ItemStack stack = source.getStack();
            if (stack == null || stack.itemID != original.itemID || stack.getItemDamage() != original.getItemDamage()) break;
            List<Slot> targets = targets(container, source, stack, player);
            int capacity = 0;
            for (Slot target : targets) capacity += space(target, stack);
            if (capacity <= 0 || (!source.isItemValid(stack) && capacity < stack.stackSize)) break;
            click(controller, container, source, 0, player);
            for (int pass = 0; pass < 2; pass++) {
                for (Slot target : targets) {
                    ItemStack held = player.inventory.getItemStack();
                    if (held == null) break;
                    if ((pass == 0) != target.getHasStack()) continue;
                    if (space(target, held) > 0) click(controller, container, target, 0, player);
                }
            }
            if (player.inventory.getItemStack() != null) click(controller, container, source, 0, player);
            moved = true;
            if (!(source instanceof SlotCrafting) || player.inventory.getItemStack() != null) break;
        }
        return moved;
    }

    private static List<Slot> targets(Container container, Slot source, ItemStack stack, EntityPlayer player) {
        List<Slot> result = new ArrayList<Slot>();
        int inventoryIndex = source.getInventoryIndex(player.inventory);
        if (container instanceof ContainerPlayer) {
            if (inventoryIndex >= 0 && inventoryIndex < 36) {
                for (Object value : container.slots) {
                    Slot slot = (Slot)value;
                    if (slot instanceof SlotArmor && !slot.getHasStack() && slot.isItemValid(stack)) {
                        result.add(slot);
                        return result;
                    }
                }
                return playerSlots(container, player, inventoryIndex < 9 ? 9 : 0, inventoryIndex < 9 ? 36 : 9, false);
            }
            return playerSlots(container, player, 0, 36, source instanceof SlotCrafting);
        }
        if (inventoryIndex < 0 || inventoryIndex >= 36) return playerSlots(container, player, 0, 36, true);
        if (container instanceof ContainerFurnace) {
            if (FurnaceRecipes.smelting().getSmeltingResult(stack.itemID) != null) result.add(container.getSlot(0));
            else if (TileEntityFurnace.getItemBurnTime(stack) > 0) result.add(container.getSlot(1));
            else return playerSlots(container, player, inventoryIndex < 9 ? 9 : 0, inventoryIndex < 9 ? 36 : 9, false);
            return result;
        }
        if (container instanceof ContainerWorkbench) {
            return playerSlots(container, player, inventoryIndex < 9 ? 9 : 0, inventoryIndex < 9 ? 36 : 9, false);
        }
        for (Object value : container.slots) {
            Slot slot = (Slot)value;
            if (slot != source && slot.getInventoryIndex(player.inventory) < 0 && slot.isItemValid(stack)) result.add(slot);
        }
        return result;
    }

    private static List<Slot> playerSlots(Container container, EntityPlayer player, int start, int end, boolean reverse) {
        List<Slot> result = new ArrayList<Slot>();
        for (Object value : container.slots) {
            Slot slot = (Slot)value;
            int index = slot.getInventoryIndex(player.inventory);
            if (index >= start && index < end) result.add(slot);
        }
        if (reverse) Collections.reverse(result);
        return result;
    }

    private static boolean ready(Container container, int sourceIndex, EntityPlayer player) {
        return container == player.craftingInventory && sourceIndex >= 0 && sourceIndex < container.slots.size()
                && player.inventory.getItemStack() == null;
    }

    private static boolean fits(Slot slot, ItemStack stack) {
        return slot.isItemValid(stack) && stack.stackSize <= Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
    }

    private static boolean clickMerges(ItemStack first, ItemStack second) {
        return first != null && second != null && first.itemID == second.itemID
                && (!first.getHasSubtypes() || first.getItemDamage() == second.getItemDamage());
    }

    private static int space(Slot slot, ItemStack stack) {
        if (!slot.isItemValid(stack)) return 0;
        int limit = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
        ItemStack existing = slot.getStack();
        if (existing == null) return limit;
        return clickMerges(stack, existing) && stack.isStackable() ? Math.max(0, limit - existing.stackSize) : 0;
    }

    private static void click(PlayerController controller, Container container, Slot slot, int button, EntityPlayer player) {
        controller.handleMouseClick(container.windowId, slot.slotNumber, button, false, player);
    }
}
