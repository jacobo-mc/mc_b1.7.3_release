package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet31RelEntityMove extends Packet30Entity {
    public Packet31RelEntityMove() {
    }

    public Packet31RelEntityMove(int var1, byte var2, byte var3, byte var4) {
        super(var1);
        this.field_82_b = var2;
        this.field_88_c = var3;
        this.field_87_d = var4;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        super.func_70_a(var1);
        this.field_82_b = var1.readByte();
        this.field_88_c = var1.readByte();
        this.field_87_d = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        super.func_68_a(var1);
        var1.writeByte(this.field_82_b);
        var1.writeByte(this.field_88_c);
        var1.writeByte(this.field_87_d);
    }

    public int func_71_a() {
        return 7;
    }
}
