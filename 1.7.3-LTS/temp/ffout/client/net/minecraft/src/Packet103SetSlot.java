package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet103SetSlot extends Packet {
    public int field_20042_a;
    public int field_20041_b;
    public ItemStack field_20043_c;

    public void func_323_a(NetHandler var1) {
        var1.func_20088_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20042_a = var1.readByte();
        this.field_20041_b = var1.readShort();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.field_20043_c = new ItemStack(var2, var3, var4);
        } else {
            this.field_20043_c = null;
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20042_a);
        var1.writeShort(this.field_20041_b);
        if (this.field_20043_c == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.field_20043_c.field_1617_c);
            var1.writeByte(this.field_20043_c.field_1615_a);
            var1.writeShort(this.field_20043_c.func_21181_i());
        }

    }

    public int func_329_a() {
        return 8;
    }
}
