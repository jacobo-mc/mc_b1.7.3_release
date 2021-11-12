package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet104WindowItems extends Packet {
    public int windowId;
    public ItemStack[] itemStack;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.windowId = var1.readByte();
        short var2 = var1.readShort();
        this.itemStack = new ItemStack[var2];

        for(int var3 = 0; var3 < var2; ++var3) {
            short var4 = var1.readShort();
            if (var4 >= 0) {
                byte var5 = var1.readByte();
                short var6 = var1.readShort();
                this.itemStack[var3] = new ItemStack(var4, var5, var6);
            }
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeByte(this.windowId);
        var1.writeShort(this.itemStack.length);

        for(int var2 = 0; var2 < this.itemStack.length; ++var2) {
            if (this.itemStack[var2] == null) {
                var1.writeShort(-1);
            } else {
                var1.writeShort((short)this.itemStack[var2].itemID);
                var1.writeByte((byte)this.itemStack[var2].stackSize);
                var1.writeShort((short)this.itemStack[var2].getItemDamage());
            }
        }

    }

    public void processPacket(NetHandler var1) {
        var1.handleWindowItems(this);
    }

    public int getPacketSize() {
        return 3 + this.itemStack.length * 5;
    }
}
