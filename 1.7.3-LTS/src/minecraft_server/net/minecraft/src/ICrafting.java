package net.minecraft.src;

import java.util.List;

public interface ICrafting {
    void updateCraftingInventory(Container var1, List var2);

    void updateCraftingInventorySlot(Container var1, int var2, ItemStack var3);

    void updateCraftingInventoryInfo(Container var1, int var2, int var3);
}
