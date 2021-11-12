package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet104WindowItems extends Packet {
    public int field_20036_a;
    public ItemStack[] field_20035_b;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20036_a = var1.readByte();
        short var2 = var1.readShort();
        this.field_20035_b = new ItemStack[var2];

        for(int var3 = 0; var3 < var2; ++var3) {
            short var4 = var1.readShort();
            if (var4 >= 0) {
                byte var5 = var1.readByte();
                short var6 = var1.readShort();
                this.field_20035_b[var3] = new ItemStack(var4, var5, var6);
            }
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20036_a);
        var1.writeShort(this.field_20035_b.length);

        for(int var2 = 0; var2 < this.field_20035_b.length; ++var2) {
            if (this.field_20035_b[var2] == null) {
                var1.writeShort(-1);
            } else {
                var1.writeShort((short)this.field_20035_b[var2].field_1617_c);
                var1.writeByte((byte)this.field_20035_b[var2].field_1615_a);
                var1.writeShort((short)this.field_20035_b[var2].func_21181_i());
            }
        }

    }

    public void func_323_a(NetHandler var1) {
        var1.func_20094_a(this);
    }

    public int func_329_a() {
        return 3 + this.field_20035_b.length * 5;
    }
}
