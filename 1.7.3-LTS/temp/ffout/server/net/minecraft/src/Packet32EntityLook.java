package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet32EntityLook extends Packet30Entity {
    public Packet32EntityLook() {
        this.field_84_g = true;
    }

    public Packet32EntityLook(int var1, byte var2, byte var3) {
        super(var1);
        this.field_86_e = var2;
        this.field_85_f = var3;
        this.field_84_g = true;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        super.func_70_a(var1);
        this.field_86_e = var1.readByte();
        this.field_85_f = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        super.func_68_a(var1);
        var1.writeByte(this.field_86_e);
        var1.writeByte(this.field_85_f);
    }

    public int func_71_a() {
        return 6;
    }
}
