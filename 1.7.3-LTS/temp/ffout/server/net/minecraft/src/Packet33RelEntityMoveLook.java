package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet33RelEntityMoveLook extends Packet30Entity {
    public Packet33RelEntityMoveLook() {
        this.field_84_g = true;
    }

    public Packet33RelEntityMoveLook(int var1, byte var2, byte var3, byte var4, byte var5, byte var6) {
        super(var1);
        this.field_82_b = var2;
        this.field_88_c = var3;
        this.field_87_d = var4;
        this.field_86_e = var5;
        this.field_85_f = var6;
        this.field_84_g = true;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        super.func_70_a(var1);
        this.field_82_b = var1.readByte();
        this.field_88_c = var1.readByte();
        this.field_87_d = var1.readByte();
        this.field_86_e = var1.readByte();
        this.field_85_f = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        super.func_68_a(var1);
        var1.writeByte(this.field_82_b);
        var1.writeByte(this.field_88_c);
        var1.writeByte(this.field_87_d);
        var1.writeByte(this.field_86_e);
        var1.writeByte(this.field_85_f);
    }

    public int func_71_a() {
        return 9;
    }
}
