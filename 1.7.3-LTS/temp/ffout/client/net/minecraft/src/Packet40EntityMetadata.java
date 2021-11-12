package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet40EntityMetadata extends Packet {
    public int field_21049_a;
    private List field_21048_b;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_21049_a = var1.readInt();
        this.field_21048_b = DataWatcher.func_21131_a(var1);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_21049_a);
        DataWatcher.func_21125_a(this.field_21048_b, var1);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_21148_a(this);
    }

    public int func_329_a() {
        return 5;
    }

    public List func_21047_b() {
        return this.field_21048_b;
    }
}
