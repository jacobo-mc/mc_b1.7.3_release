package net.minecraft.src;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

public class MinecraftAppletImpl extends Minecraft {
    // $FF: synthetic field
    final MinecraftApplet field_186_a;

    public MinecraftAppletImpl(MinecraftApplet var1, Component var2, Canvas var3, MinecraftApplet var4, int var5, int var6, boolean var7) {
        super(var2, var3, var4, var5, var6, var7);
        this.field_186_a = var1;
    }

    public void func_4007_a(UnexpectedThrowable var1) {
        this.field_186_a.removeAll();
        this.field_186_a.setLayout(new BorderLayout());
        this.field_186_a.add(new PanelCrashReport(var1), "Center");
        this.field_186_a.validate();
    }
}
