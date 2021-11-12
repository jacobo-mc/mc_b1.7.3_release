package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet2Handshake extends Packet {
    public String field_532_a;

    public Packet2Handshake() {
    }

    public Packet2Handshake(String var1) {
        this.field_532_a = var1;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_532_a = func_27048_a(var1, 32);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        func_27049_a(this.field_532_a, var1);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_838_a(this);
    }

    public int func_329_a() {
        return 4 + this.field_532_a.length() + 4;
    }
}
