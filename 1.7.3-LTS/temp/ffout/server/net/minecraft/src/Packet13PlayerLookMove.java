package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet13PlayerLookMove extends Packet10Flying {
    public Packet13PlayerLookMove() {
        this.field_65_i = true;
        this.field_66_h = true;
    }

    public Packet13PlayerLookMove(double var1, double var3, double var5, double var7, float var9, float var10, boolean var11) {
        this.field_73_a = var1;
        this.field_72_b = var3;
        this.field_70_d = var5;
        this.field_71_c = var7;
        this.field_69_e = var9;
        this.field_68_f = var10;
        this.field_67_g = var11;
        this.field_65_i = true;
        this.field_66_h = true;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_73_a = var1.readDouble();
        this.field_72_b = var1.readDouble();
        this.field_70_d = var1.readDouble();
        this.field_71_c = var1.readDouble();
        this.field_69_e = var1.readFloat();
        this.field_68_f = var1.readFloat();
        super.func_70_a(var1);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.field_73_a);
        var1.writeDouble(this.field_72_b);
        var1.writeDouble(this.field_70_d);
        var1.writeDouble(this.field_71_c);
        var1.writeFloat(this.field_69_e);
        var1.writeFloat(this.field_68_f);
        super.func_68_a(var1);
    }

    public int func_71_a() {
        return 41;
    }
}
