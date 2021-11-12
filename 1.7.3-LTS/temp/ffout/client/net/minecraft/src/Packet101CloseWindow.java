package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet101CloseWindow extends Packet {
    public int field_20034_a;

    public Packet101CloseWindow() {
    }

    public Packet101CloseWindow(int var1) {
        this.field_20034_a = var1;
    }

    public void func_323_a(NetHandler var1) {
        var1.func_20092_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20034_a = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20034_a);
    }

    public int func_329_a() {
        return 1;
    }
}
