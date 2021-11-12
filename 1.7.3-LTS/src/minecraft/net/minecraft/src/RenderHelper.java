package net.minecraft.src;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    private static FloatBuffer field_1695_a = GLAllocation.createDirectFloatBuffer(16);

    public static void disableStandardItemLighting() {
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(16384 /*GL_LIGHT0*/);
        GL11.glDisable(16385 /*GL_LIGHT1*/);
        GL11.glDisable(2903 /*GL_COLOR_MATERIAL*/);
    }

    public static void enableStandardItemLighting() {
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(16384 /*GL_LIGHT0*/);
        GL11.glEnable(16385 /*GL_LIGHT1*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glColorMaterial(1032 /*GL_FRONT_AND_BACK*/, 5634 /*GL_AMBIENT_AND_DIFFUSE*/);
        float var0 = 0.4F;
        float var1 = 0.6F;
        float var2 = 0.0F;
        Vec3D var3 = Vec3D.createVector(0.20000000298023224D, 1.0D, -0.699999988079071D).normalize();
        GL11.glLight(16384 /*GL_LIGHT0*/, 4611 /*GL_POSITION*/, func_1157_a(var3.xCoord, var3.yCoord, var3.zCoord, 0.0D));
        GL11.glLight(16384 /*GL_LIGHT0*/, 4609 /*GL_DIFFUSE*/, func_1156_a(var1, var1, var1, 1.0F));
        GL11.glLight(16384 /*GL_LIGHT0*/, 4608 /*GL_AMBIENT*/, func_1156_a(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16384 /*GL_LIGHT0*/, 4610 /*GL_SPECULAR*/, func_1156_a(var2, var2, var2, 1.0F));
        var3 = Vec3D.createVector(-0.20000000298023224D, 1.0D, 0.699999988079071D).normalize();
        GL11.glLight(16385 /*GL_LIGHT1*/, 4611 /*GL_POSITION*/, func_1157_a(var3.xCoord, var3.yCoord, var3.zCoord, 0.0D));
        GL11.glLight(16385 /*GL_LIGHT1*/, 4609 /*GL_DIFFUSE*/, func_1156_a(var1, var1, var1, 1.0F));
        GL11.glLight(16385 /*GL_LIGHT1*/, 4608 /*GL_AMBIENT*/, func_1156_a(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16385 /*GL_LIGHT1*/, 4610 /*GL_SPECULAR*/, func_1156_a(var2, var2, var2, 1.0F));
        GL11.glShadeModel(7424 /*GL_FLAT*/);
        GL11.glLightModel(2899 /*GL_LIGHT_MODEL_AMBIENT*/, func_1156_a(var0, var0, var0, 1.0F));
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
