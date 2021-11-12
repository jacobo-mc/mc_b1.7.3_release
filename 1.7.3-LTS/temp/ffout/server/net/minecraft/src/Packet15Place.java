package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet15Place extends Packet {
    public int field_78_a;
    public int field_77_b;
    public int field_81_c;
    public int field_80_d;
    public ItemStack field_79_e;

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_78_a = var1.readInt();
        this.field_77_b = var1.read();
        this.field_81_c = var1.readInt();
        this.field_80_d = var1.read();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.field_79_e = new ItemStack(var2, var3, var4);
        } else {
            this.field_79_e = null;
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_78_a);
        var1.write(this.field_77_b);
        var1.writeInt(this.field_81_c);
        var1.write(this.field_80_d);
        if (this.field_79_e == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.field_79_e.field_855_c);
            var1.writeByte(this.field_79_e.field_853_a);
            var1.writeShort(this.field_79_e.func_21125_h());
        }

    }

    public void func_72_a(NetHandler var1) {
        var1.func_24_a(this);
    }

    public int func_71_a() {
        return 15;
    }
}
