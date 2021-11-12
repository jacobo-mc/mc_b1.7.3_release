package net.minecraft.src;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    private static FloatBuffer field_1695_a = GLAllocation.func_1123_d(16);

    public static void func_1159_a() {
        GL11.glDisable(2896);
        GL11.glDisable(16384);
        GL11.glDisable(16385);
        GL11.glDisable(2903);
    }

    public static void func_1158_b() {
        GL11.glEnable(2896);
        GL11.glEnable(16384);
        GL11.glEnable(16385);
        GL11.glEnable(2903);
        GL11.glColorMaterial(1032, 5634);
        float var0 = 0.4F;
        float var1 = 0.6F;
        float var2 = 0.0F;
        Vec3D var3 = Vec3D.func_1248_b(0.20000000298023224D, 1.0D, -0.699999988079071D).func_1252_b();
        GL11.glLight(16384, 4611, func_1157_a(var3.field_1776_a, var3.field_1775_b, var3.field_1779_c, 0.0D));
        GL11.glLight(16384, 4609, func_1156_a(var1, var1, var1, 1.0F));
        GL11.glLight(16384, 4608, func_1156_a(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16384, 4610, func_1156_a(var2, var2, var2, 1.0F));
        var3 = Vec3D.func_1248_b(-0.20000000298023224D, 1.0D, 0.699999988079071D).func_1252_b();
        GL11.glLight(16385, 4611, func_1157_a(var3.field_1776_a, var3.field_1775_b, var3.field_1779_c, 0.0D));
        GL11.glLight(16385, 4609, func_1156_a(var1, var1, var1, 1.0F));
        GL11.glLight(16385, 4608, func_1156_a(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16385, 4610, func_1156_a(var2, var2, var2, 1.0F));
        GL11.glShadeModel(7424);
        GL11.glLightModel(2899, func_1156_a(var0, var0, var0, 1.0F));
    }

    private static FloatBuffer func_1157_a(double var0, double var2, double var4, double var6) {
        return func_1156_a((float)var0, (float)var2, (float)var4, (float)var6);
    }

    private static FloatBuffer func_1156_a(float var0, float var1, float var2, float var3) {
        field_1695_a.clear();
        field_1695_a.put(var0).put(var1).put(var2).put(var3);
        field_1695_a.flip();
        return field_1695_a;
    }
}
