package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet103SetSlot extends Packet {
    public int field_20017_a;
    public int field_20016_b;
    public ItemStack field_20018_c;

    public Packet103SetSlot() {
    }

    public Packet103SetSlot(int var1, int var2, ItemStack var3) {
        this.field_20017_a = var1;
        this.field_20016_b = var2;
        this.field_20018_c = var3 == null ? var3 : var3.func_578_d();
    }

    public void func_72_a(NetHandler var1) {
        var1.func_20003_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_20017_a = var1.readByte();
        this.field_20016_b = var1.readShort();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.field_20018_c = new ItemStack(var2, var3, var4);
        } else {
            this.field_20018_c = null;
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20017_a);
        var1.writeShort(this.field_20016_b);
        if (this.field_20018_c == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.field_20018_c.field_855_c);
            var1.writeByte(this.field_20018_c.field_853_a);
            var1.writeShort(this.field_20018_c.func_21125_h());
        }

    }

    public int func_71_a() {
        return 8;
    }
}
