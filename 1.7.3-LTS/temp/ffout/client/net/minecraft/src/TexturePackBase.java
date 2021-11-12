package net.minecraft.src;

import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.Minecraft;

public abstract class TexturePackBase {
    public String field_6487_a;
    public String field_6486_b;
    public String field_6489_c;
    public String field_6488_d;

    public void func_6482_a() {
    }

    public void func_6480_b() {
    }

    public void func_6485_a(Minecraft var1) throws IOException {
    }

    public void func_6484_b(Minecraft var1) {
    }

    public void func_6483_c(Minecraft var1) {
    }

    public InputStream func_6481_a(String var1) {
        return TexturePackBase.class.getResourceAsStream(var1);
    }
}
