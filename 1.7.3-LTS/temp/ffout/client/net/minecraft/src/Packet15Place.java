package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet15Place extends Packet {
    public int field_566_a;
    public int field_565_b;
    public int field_569_c;
    public int field_568_d;
    public ItemStack field_567_e;

    public Packet15Place() {
    }

    public Packet15Place(int var1, int var2, int var3, int var4, ItemStack var5) {
        this.field_566_a = var1;
        this.field_565_b = var2;
        this.field_569_c = var3;
        this.field_568_d = var4;
        this.field_567_e = var5;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_566_a = var1.readInt();
        this.field_565_b = var1.read();
        this.field_569_c = var1.readInt();
        this.field_568_d = var1.read();
        short var2 = var1.readShort();
        if (var2 >= 0) {
            byte var3 = var1.readByte();
            short var4 = var1.readShort();
            this.field_567_e = new ItemStack(var2, var3, var4);
        } else {
            this.field_567_e = null;
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_566_a);
        var1.write(this.field_565_b);
        var1.writeInt(this.field_569_c);
        var1.write(this.field_568_d);
        if (this.field_567_e == null) {
            var1.writeShort(-1);
        } else {
            var1.writeShort(this.field_567_e.field_1617_c);
            var1.writeByte(this.field_567_e.field_1615_a);
            var1.writeShort(this.field_567_e.func_21181_i());
        }

    }

    public void func_323_a(NetHandler var1) {
        var1.func_819_a(this);
    }

    public int func_329_a() {
        return 15;
    }
}
