package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet103SetSlot extends Packet {
    public int windowId;
    public int itemSlot;
    public ItemStack myItemStack;

    public Packet103SetSlot() {
    }

    public Packet103SetSlot(int var1, int var2, ItemStack var3) {
        this.windowId = var1;
        this.itemSlot = var2;
        this.myItemStack = var3 == null ? var3 : var3.copy();
    }

    public void processPacket(NetHandler var1) {
        var1.func_20003_a(this);
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.windowId = var1.readByte();
        this.itemSlot = var1.readShort();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.myItemStack = new ItemStack(var2, var3, var4);
        } else {
            this.myItemStack = null;
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeByte(this.windowId);
        var1.writeShort(this.itemSlot);
        if (this.myItemStack == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.myItemStack.itemID);
            var1.writeByte(this.myItemStack.stackSize);
            var1.writeShort(this.myItemStack.getItemDamage());
        }

    }

    public int getPacketSize() {
        return 8;
    }
}
