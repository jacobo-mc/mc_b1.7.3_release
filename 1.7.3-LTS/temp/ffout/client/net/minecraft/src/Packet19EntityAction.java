package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet19EntityAction extends Packet {
    public int field_21051_a;
    public int field_21050_b;

    public Packet19EntityAction() {
    }

    public Packet19EntityAction(Entity var1, int var2) {
        this.field_21051_a = var1.field_620_ab;
        this.field_21050_b = var2;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_21051_a = var1.readInt();
        this.field_21050_b = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21051_a);
        var1.writeByte(this.field_21050_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_21147_a(this);
    }

    public int func_329_a() {
        return 5;
    }
}
