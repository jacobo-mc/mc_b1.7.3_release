package net.minecraft.src;

public class ContainerChest extends Container {
    private IInventory field_20137_a;
    private int field_27088_b;

    public ContainerChest(IInventory var1, IInventory var2) {
        this.field_20137_a = var2;
        this.field_27088_b = var2.getSizeInventory() / 9;
        int var3 = (this.field_27088_b - 4) * 18;

        int var4;
        int var5;
        for(var4 = 0; var4 < this.field_27088_b; ++var4) {
            for(var5 = 0; var5 < 9; ++var5) {
                this.addSlot(new Slot(var2, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18));
            }
        }

        for(var4 = 0; var4 < 3; ++var4) {
            for(var5 = 0; var5 < 9; ++var5) {
                this.addSlot(new Slot(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
            }
        }

        for(var4 = 0; var4 < 9; ++var4) {
            this.addSlot(new Slot(var1, var4, 8 + var4 * 18, 161 + var3));
        }

    }

    public boolean canInteractWith(EntityPlayer var1) {
        return this.field_20137_a.canInteractWith(var1);
    }

    public ItemStack func_27086_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(var1);
        if (var3 != null && var3.func_27006_b()) {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();
            if (var1 < this.field_27088_b * 9) {
                this.func_28126_a(var4, this.field_27088_b * 9, this.inventorySlots.size(), true);
            } else {
                this.func_28126_a(var4, 0, this.field_27088_b * 9, false);
            }

            if (var4.stackSize == 0) {
                var3.putStack((ItemStack)null);
            } else {
                var3.onSlotChanged();
            }
        }

        return var2;
    }
}
