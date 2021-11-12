package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet5PlayerInventory extends Packet {
    public int field_118_a;
    public int field_117_b;
    public int field_20028_c;
    public int field_21022_d;

    public Packet5PlayerInventory() {
    }

    public Packet5PlayerInventory(int var1, int var2, ItemStack var3) {
        this.field_118_a = var1;
        this.field_117_b = var2;
        if (var3 == null) {
            this.field_20028_c = -1;
            this.field_21022_d = 0;
        } else {
            this.field_20028_c = var3.field_855_c;
            this.field_21022_d = var3.func_21125_h();
        }

    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_118_a = var1.readInt();
        this.field_117_b = var1.readShort();
        this.field_20028_c = var1.readShort();
        this.field_21022_d = var1.readShort();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_118_a);
        var1.writeShort(this.field_117_b);
        var1.writeShort(this.field_20028_c);
        var1.writeShort(this.field_21022_d);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_16_a(this);
    }

    public int func_71_a() {
        return 8;
    }
}
