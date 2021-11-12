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
    public boolean field_27039_f;

    public void func_72_a(NetHandler var1) {
        var1.func_20007_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_20024_a = var1.readByte();
        this.field_20023_b = var1.readShort();
        this.field_20027_c = var1.readByte();
        this.field_20026_d = var1.readShort();
        this.field_27039_f = var1.readBoolean();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.field_20025_e = new ItemStack(var2, var3, var4);
        } else {
            this.field_20025_e = null;
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20024_a);
        var1.writeShort(this.field_20023_b);
        var1.writeByte(this.field_20027_c);
        var1.writeShort(this.field_20026_d);
        var1.writeBoolean(this.field_27039_f);
        if (this.field_20025_e == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.field_20025_e.field_855_c);
            var1.writeByte(this.field_20025_e.field_853_a);
            var1.writeShort(this.field_20025_e.func_21125_h());
        }

    }

    public int func_71_a() {
        return 11;
    }
}
