package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet102WindowClick extends Packet {
    public int field_20024_a;
    public int field_20023_b;
    public int field_20027_c;
    public short field_20026_d;
    public ItemStack field_20025_e;
    public boolean field_27050_f;

    public Packet102WindowClick() {
    }

    public Packet102WindowClick(int var1, int var2, int var3, boolean var4, ItemStack var5, short var6) {
        this.field_20024_a = var1;
        this.field_20023_b = var2;
        this.field_20027_c = var3;
        this.field_20025_e = var5;
        this.field_20026_d = var6;
        this.field_27050_f = var4;
    }

    public void func_323_a(NetHandler var1) {
        var1.func_20091_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20024_a = var1.readByte();
        this.field_20023_b = var1.readShort();
        this.field_20027_c = var1.readByte();
        this.field_20026_d = var1.readShort();
        this.field_27050_f = var1.readBoolean();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.field_20025_e = new ItemStack(var2, var3, var4);
        } else {
            this.field_20025_e = null;
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20024_a);
        var1.writeShort(this.field_20023_b);
        var1.writeByte(this.field_20027_c);
        var1.writeShort(this.field_20026_d);
        var1.writeBoolean(this.field_27050_f);
        if (this.field_20025_e == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.field_20025_e.field_1617_c);
            var1.writeByte(this.field_20025_e.field_1615_a);
            var1.writeShort(this.field_20025_e.func_21181_i());
        }

    }

    public int func_329_a() {
        return 11;
    }
}
