package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet3Chat extends Packet {
    public String field_150_a;

    public Packet3Chat() {
    }

    public Packet3Chat(String var1) {
        if (var1.length() > 119) {
            var1 = var1.substring(0, 119);
        }

        this.field_150_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_150_a = func_27037_a(var1, 119);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        func_27038_a(this.field_150_a, var1);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_23_a(this);
    }

    public int func_71_a() {
        return this.field_150_a.length();
    }
}
