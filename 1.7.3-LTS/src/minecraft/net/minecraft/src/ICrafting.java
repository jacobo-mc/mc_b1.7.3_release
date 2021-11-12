package net.minecraft.src;

public interface ICrafting {
    void sendSlotContents(Container var1, int var2, ItemStack var3);

    void updateCraftingInventoryInfo(Container var1, int var2, int var3);
}
