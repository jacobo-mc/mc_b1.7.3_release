package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet104WindowItems extends Packet {
    public int field_20011_a;
    public ItemStack[] field_20010_b;

    public Packet104WindowItems() {
    }

    public Packet104WindowItems(int var1, List var2) {
        this.field_20011_a = var1;
        this.field_20010_b = new ItemStack[var2.size()];

        for(int var3 = 0; var3 < this.field_20010_b.length; ++var3) {
            ItemStack var4 = (ItemStack)var2.get(var3);
            this.field_20010_b[var3] = var4 == null ? null : var4.func_578_d();
        }

    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_20011_a = var1.readByte();
        short var2 = var1.readShort();
        this.field_20010_b = new ItemStack[var2];

        for(int var3 = 0; var3 < var2; ++var3) {
            short var4 = var1.readShort();
            if (var4 >= 0) {
                byte var5 = var1.readByte();
                short var6 = var1.readShort();
                this.field_20010_b[var3] = new ItemStack(var4, var5, var6);
            }
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20011_a);
        var1.writeShort(this.field_20010_b.length);

        for(int var2 = 0; var2 < this.field_20010_b.length; ++var2) {
            if (this.field_20010_b[var2] == null) {
                var1.writeShort(-1);
            } else {
                var1.writeShort((short)this.field_20010_b[var2].field_855_c);
                var1.writeByte((byte)this.field_20010_b[var2].field_853_a);
                var1.writeShort((short)this.field_20010_b[var2].func_21125_h());
            }
        }

    }

    public void func_72_a(NetHandler var1) {
        var1.func_20001_a(this);
    }

    public int func_71_a() {
        return 3 + this.field_20010_b.length * 5;
    }
}
