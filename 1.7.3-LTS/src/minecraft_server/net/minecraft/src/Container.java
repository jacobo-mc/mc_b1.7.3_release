package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Container {
    public List inventoryItemStacks = new ArrayList();
    public List inventorySlots = new ArrayList();
    public int windowId = 0;
    private short field_20132_a = 0;
    protected List crafters = new ArrayList();
    private Set field_20131_b = new HashSet();

    protected void addSlot(Slot var1) {
        var1.id = this.inventorySlots.size();
        this.inventorySlots.add(var1);
        this.inventoryItemStacks.add((Object)null);
    }

    public void onCraftGuiOpened(ICrafting var1) {
        if (this.crafters.contains(var1)) {
            throw new IllegalArgumentException("Listener already listening");
        } else {
            this.crafters.add(var1);
            var1.updateCraftingInventory(this, this.func_28127_b());
            this.updateCraftingMatrix();
        }
    }

    public List func_28127_b() {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < this.inventorySlots.size(); ++var2) {
            var1.add(((Slot)this.inventorySlots.get(var2)).getStack());
        }

        return var1;
    }

    public void updateCraftingMatrix() {
        for(int var1 = 0; var1 < this.inventorySlots.size(); ++var1) {
            ItemStack var2 = ((Slot)this.inventorySlots.get(var1)).getStack();
            ItemStack var3 = (ItemStack)this.inventoryItemStacks.get(var1);
            if (!ItemStack.areItemStacksEqual(var3, var2)) {
                var3 = var2 == null ? null : var2.copy();
                this.inventoryItemStacks.set(var1, var3);

                for(int var4 = 0; var4 < this.crafters.size(); ++var4) {
                    ((ICrafting)this.crafters.get(var4)).updateCraftingInventorySlot(this, var1, var3);
                }
            }
        }

    }

    public Slot func_20127_a(IInventory var1, int var2) {
        for(int var3 = 0; var3 < this.inventorySlots.size(); ++var3) {
            Slot var4 = (Slot)this.inventorySlots.get(var3);
            if (var4.isHere(var1, var2)) {
                return var4;
            }
        }

        return null;
    }

    public Slot getSlot(int var1) {
        return (Slot)this.inventorySlots.get(var1);
    }

    public ItemStack func_27086_a(int var1) {
        Slot var2 = (Slot)this.inventorySlots.get(var1);
        return var2 != null ? var2.getStack() : null;
    }

    public ItemStack func_27085_a(int var1, int var2, boolean var3, EntityPlayer var4) {
        ItemStack var5 = null;
        if (var2 == 0 || var2 == 1) {
            InventoryPlayer var6 = var4.inventory;
            if (var1 == -999) {
                if (var6.getItemStack() != null && var1 == -999) {
                    if (var2 == 0) {
                        var4.dropPlayerItem(var6.getItemStack());
                        var6.setItemStack((ItemStack)null);
                    }

                    if (var2 == 1) {
                        var4.dropPlayerItem(var6.getItemStack().splitStack(1));
                        if (var6.getItemStack().stackSize == 0) {
                            var6.setItemStack((ItemStack)null);
                        }
                    }
                }
            } else {
                int var10;
                if (var3) {
                    ItemStack var7 = this.func_27086_a(var1);
                    if (var7 != null) {
                        int var8 = var7.stackSize;
                        var5 = var7.copy();
                        Slot var9 = (Slot)this.inventorySlots.get(var1);
                        if (var9 != null && var9.getStack() != null) {
                            var10 = var9.getStack().stackSize;
                            if (var10 < var8) {
                                this.func_27085_a(var1, var2, var3, var4);
                            }
                        }
                    }
                } else {
                    Slot var12 = (Slot)this.inventorySlots.get(var1);
                    if (var12 != null) {
                        var12.onSlotChanged();
                        ItemStack var13 = var12.getStack();
                        ItemStack var14 = var6.getItemStack();
                        if (var13 != null) {
                            var5 = var13.copy();
                        }

                        if (var13 == null) {
                            if (var14 != null && var12.isItemValid(var14)) {
                                var10 = var2 == 0 ? var14.stackSize : 1;
                                if (var10 > var12.getSlotStackLimit()) {
                                    var10 = var12.getSlotStackLimit();
                                }

                                var12.putStack(var14.splitStack(var10));
                                if (var14.stackSize == 0) {
                                    var6.setItemStack((ItemStack)null);
                                }
                            }
                        } else if (var14 == null) {
                            var10 = var2 == 0 ? var13.stackSize : (var13.stackSize + 1) / 2;
                            ItemStack var11 = var12.decrStackSize(var10);
                            var6.setItemStack(var11);
                            if (var13.stackSize == 0) {
                                var12.putStack((ItemStack)null);
                            }

                            var12.onPickupFromSlot(var6.getItemStack());
                        } else if (var12.isItemValid(var14)) {
                            if (var13.itemID == var14.itemID && (!var13.getHasSubtypes() || var13.getItemDamage() == var14.getItemDamage())) {
                                var10 = var2 == 0 ? var14.stackSize : 1;
                                if (var10 > var12.getSlotStackLimit() - var13.stackSize) {
                                    var10 = var12.getSlotStackLimit() - var13.stackSize;
                                }

                                if (var10 > var14.getMaxStackSize() - var13.stackSize) {
                                    var10 = var14.getMaxStackSize() - var13.stackSize;
                                }

                                var14.splitStack(var10);
                                if (var14.stackSize == 0) {
                                    var6.setItemStack((ItemStack)null);
                                }

                                var13.stackSize += var10;
                            } else if (var14.stackSize <= var12.getSlotStackLimit()) {
                                var12.putStack(var14);
                                var6.setItemStack(var13);
                            }
                        } else if (var13.itemID == var14.itemID && var14.getMaxStackSize() > 1 && (!var13.getHasSubtypes() || var13.getItemDamage() == var14.getItemDamage())) {
                            var10 = var13.stackSize;
                            if (var10 > 0 && var10 + var14.stackSize <= var14.getMaxStackSize()) {
                                var14.stackSize += var10;
                                var13.splitStack(var10);
                                if (var13.stackSize == 0) {
                                    var12.putStack((ItemStack)null);
                                }

                                var12.onPickupFromSlot(var6.getItemStack());
                            }
                        }
                    }
                }
            }
        }

        return var5;
    }

    public void onCraftGuiClosed(EntityPlayer var1) {
        InventoryPlayer var2 = var1.inventory;
        if (var2.getItemStack() != null) {
            var1.dropPlayerItem(var2.getItemStack());
            var2.setItemStack((ItemStack)null);
        }

    }

    public void onCraftMatrixChanged(IInventory var1) {
        this.updateCraftingMatrix();
    }

    public boolean getCanCraft(EntityPlayer var1) {
        return !this.field_20131_b.contains(var1);
    }

    public void setCanCraft(EntityPlayer var1, boolean var2) {
        if (var2) {
            this.field_20131_b.remove(var1);
        } else {
            this.field_20131_b.add(var1);
        }

    }

    public abstract boolean canInteractWith(EntityPlayer var1);

    protected void func_28126_a(ItemStack var1, int var2, int var3, boolean var4) {
        int var5 = var2;
        if (var4) {
            var5 = var3 - 1;
        }

        Slot var6;
        ItemStack var7;
        if (var1.func_21132_c()) {
            while(var1.stackSize > 0 && (!var4 && var5 < var3 || var4 && var5 >= var2)) {
                var6 = (Slot)this.inventorySlots.get(var5);
                var7 = var6.getStack();
                if (var7 != null && var7.itemID == var1.itemID && (!var1.getHasSubtypes() || var1.getItemDamage() == var7.getItemDamage())) {
                    int var8 = var7.stackSize + var1.stackSize;
                    if (var8 <= var1.getMaxStackSize()) {
                        var1.stackSize = 0;
                        var7.stackSize = var8;
                        var6.onSlotChanged();
                    } else if (var7.stackSize < var1.getMaxStackSize()) {
                        var1.stackSize -= var1.getMaxStackSize() - var7.stackSize;
                        var7.stackSize = var1.getMaxStackSize();
                        var6.onSlotChanged();
                    }
                }

                if (var4) {
                    --var5;
                } else {
                    ++var5;
                }
            }
        }

        if (var1.stackSize > 0) {
            if (var4) {
                var5 = var3 - 1;
            } else {
                var5 = var2;
            }

            while(!var4 && var5 < var3 || var4 && var5 >= var2) {
                var6 = (Slot)this.inventorySlots.get(var5);
                var7 = var6.getStack();
                if (var7 == null) {
                    var6.putStack(var1.copy());
                    var6.onSlotChanged();
                    var1.stackSize = 0;
                    break;
                }

                if (var4) {
                    --var5;
                } else {
                    ++var5;
                }
            }
        }

    }
}
