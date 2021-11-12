package net.minecraft.src;

import org.lwjgl.opengl.GLContext;

public class OpenGlCapsChecker {
    private static boolean field_1770_a = true;

    public boolean func_1213_a() {
        return field_1770_a && GLContext.getCapabilities().GL_ARB_occlusion_query;
    }
}
