package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet39AttachEntity extends Packet {
    public int field_6044_a;
    public int field_6043_b;

    public Packet39AttachEntity() {
    }

    public Packet39AttachEntity(Entity var1, Entity var2) {
        this.field_6044_a = var1.field_331_c;
        this.field_6043_b = var2 != null ? var2.field_331_c : -1;
    }

    public int func_71_a() {
        return 8;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_6044_a = var1.readInt();
        this.field_6043_b = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_6044_a);
        var1.writeInt(this.field_6043_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_6003_a(this);
    }
}
