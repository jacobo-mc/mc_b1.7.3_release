package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Packet60Explosion extends Packet {
    public double field_12003_a;
    public double field_12002_b;
    public double field_12006_c;
    public float field_12005_d;
    public Set field_12004_e;

    public Packet60Explosion() {
    }

    public Packet60Explosion(double var1, double var3, double var5, float var7, Set var8) {
        this.field_12003_a = var1;
        this.field_12002_b = var3;
        this.field_12006_c = var5;
        this.field_12005_d = var7;
        this.field_12004_e = new HashSet(var8);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_12003_a = var1.readDouble();
        this.field_12002_b = var1.readDouble();
        this.field_12006_c = var1.readDouble();
        this.field_12005_d = var1.readFloat();
        int var2 = var1.readInt();
        this.field_12004_e = new HashSet();
        int var3 = (int)this.field_12003_a;
        int var4 = (int)this.field_12002_b;
        int var5 = (int)this.field_12006_c;

        for(int var6 = 0; var6 < var2; ++var6) {
            int var7 = var1.readByte() + var3;
            int var8 = var1.readByte() + var4;
            int var9 = var1.readByte() + var5;
            this.field_12004_e.add(new ChunkPosition(var7, var8, var9));
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.field_12003_a);
        var1.writeDouble(this.field_12002_b);
        var1.writeDouble(this.field_12006_c);
        var1.writeFloat(this.field_12005_d);
        var1.writeInt(this.field_12004_e.size());
        int var2 = (int)this.field_12003_a;
        int var3 = (int)this.field_12002_b;
        int var4 = (int)this.field_12006_c;
        Iterator var5 = this.field_12004_e.iterator();

        while(var5.hasNext()) {
            ChunkPosition var6 = (ChunkPosition)var5.next();
            int var7 = var6.field_846_a - var2;
            int var8 = var6.field_845_b - var3;
            int var9 = var6.field_847_c - var4;
            var1.writeByte(var7);
            var1.writeByte(var8);
            var1.writeByte(var9);
        }

    }

    public void func_72_a(NetHandler var1) {
        var1.func_12001_a(this);
    }

    public int func_71_a() {
        return 32 + this.field_12004_e.size() * 3;
    }
}
