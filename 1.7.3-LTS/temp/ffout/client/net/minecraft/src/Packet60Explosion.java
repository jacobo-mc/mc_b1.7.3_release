package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Packet60Explosion extends Packet {
    public double field_12236_a;
    public double field_12235_b;
    public double field_12239_c;
    public float field_12238_d;
    public Set field_12237_e;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_12236_a = var1.readDouble();
        this.field_12235_b = var1.readDouble();
        this.field_12239_c = var1.readDouble();
        this.field_12238_d = var1.readFloat();
        int var2 = var1.readInt();
        this.field_12237_e = new HashSet();
        int var3 = (int)this.field_12236_a;
        int var4 = (int)this.field_12235_b;
        int var5 = (int)this.field_12239_c;

        for(int var6 = 0; var6 < var2; ++var6) {
            int var7 = var1.readByte() + var3;
            int var8 = var1.readByte() + var4;
            int var9 = var1.readByte() + var5;
            this.field_12237_e.add(new ChunkPosition(var7, var8, var9));
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.field_12236_a);
        var1.writeDouble(this.field_12235_b);
        var1.writeDouble(this.field_12239_c);
        var1.writeFloat(this.field_12238_d);
        var1.writeInt(this.field_12237_e.size());
        int var2 = (int)this.field_12236_a;
        int var3 = (int)this.field_12235_b;
        int var4 = (int)this.field_12239_c;
        Iterator var5 = this.field_12237_e.iterator();

        while(var5.hasNext()) {
            ChunkPosition var6 = (ChunkPosition)var5.next();
            int var7 = var6.field_1111_a - var2;
            int var8 = var6.field_1110_b - var3;
            int var9 = var6.field_1112_c - var4;
            var1.writeByte(var7);
            var1.writeByte(var8);
            var1.writeByte(var9);
        }

    }

    public void func_323_a(NetHandler var1) {
        var1.func_12245_a(this);
    }

    public int func_329_a() {
        return 32 + this.field_12237_e.size() * 3;
    }
}
