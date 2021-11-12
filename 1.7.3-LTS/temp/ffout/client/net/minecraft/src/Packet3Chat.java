package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet3Chat extends Packet {
    public String field_517_a;

    public Packet3Chat() {
    }

    public Packet3Chat(String var1) {
        if (var1.length() > 119) {
            var1 = var1.substring(0, 119);
        }

        this.field_517_a = var1;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_517_a = func_27048_a(var1, 119);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        func_27049_a(this.field_517_a, var1);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_4113_a(this);
    }

    public int func_329_a() {
        return this.field_517_a.length();
    }
}
