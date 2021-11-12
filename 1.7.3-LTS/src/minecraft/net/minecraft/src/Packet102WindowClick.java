package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet102WindowClick extends Packet {
    public int window_Id;
    public int inventorySlot;
    public int mouseClick;
    public short action;
    public ItemStack itemStack;
    public boolean field_27050_f;

    public Packet102WindowClick() {
    }

    public Packet102WindowClick(int var1, int var2, int var3, boolean var4, ItemStack var5, short var6) {
        this.window_Id = var1;
        this.inventorySlot = var2;
        this.mouseClick = var3;
        this.itemStack = var5;
        this.action = var6;
        this.field_27050_f = var4;
    }

    public void processPacket(NetHandler var1) {
        var1.func_20091_a(this);
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.window_Id = var1.readByte();
        this.inventorySlot = var1.readShort();
        this.mouseClick = var1.readByte();
        this.action = var1.readShort();
        this.field_27050_f = var1.readBoolean();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.itemStack = new ItemStack(var2, var3, var4);
        } else {
            this.itemStack = null;
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeByte(this.window_Id);
        var1.writeShort(this.inventorySlot);
        var1.writeByte(this.mouseClick);
        var1.writeShort(this.action);
        var1.writeBoolean(this.field_27050_f);
        if (this.itemStack == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.itemStack.itemID);
            var1.writeByte(this.itemStack.stackSize);
            var1.writeShort(this.itemStack.getItemDamage());
        }

    }

    public int getPacketSize() {
        return 11;
    }
}
