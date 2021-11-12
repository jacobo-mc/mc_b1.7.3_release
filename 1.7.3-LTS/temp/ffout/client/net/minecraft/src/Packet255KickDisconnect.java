package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet255KickDisconnect extends Packet {
    public String field_582_a;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String var1) {
        this.field_582_a = var1;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_582_a = func_27048_a(var1, 100);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        func_27049_a(this.field_582_a, var1);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_844_a(this);
    }

    public int func_329_a() {
        return this.field_582_a.length();
    }
}
