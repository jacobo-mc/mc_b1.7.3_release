package net.minecraft.src;

public enum EnumOptions {
    MUSIC("options.music", true, false),
    SOUND("options.sound", true, false),
    INVERT_MOUSE("options.invertMouse", false, true),
    SENSITIVITY("options.sensitivity", true, false),
    RENDER_DISTANCE("options.renderDistance", false, false),
    VIEW_BOBBING("options.viewBobbing", false, true),
    ANAGLYPH("options.anaglyph", false, true),
    ADVANCED_OPENGL("options.advancedOpengl", false, true),
    FRAMERATE_LIMIT("options.framerateLimit", false, false),
    DIFFICULTY("options.difficulty", false, false),
    GRAPHICS("options.graphics", false, false),
    AMBIENT_OCCLUSION("options.ao", false, true),
    GUI_SCALE("options.guiScale", false, false);

    private final boolean field_20144_k;
    private final boolean field_20143_l;
    private final String field_20142_m;

    public static EnumOptions func_20137_a(int var0) {
        EnumOptions[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            EnumOptions var4 = var1[var3];
            if (var4.func_20135_c() == var0) {
                return var4;
            }
        }

        return null;
    }

    private EnumOptions(String var3, boolean var4, boolean var5) {
        this.field_20142_m = var3;
        this.field_20144_k = var4;
        this.field_20143_l = var5;
    }

    public boolean func_20136_a() {
        return this.field_20144_k;
    }

    public boolean func_20140_b() {
        return this.field_20143_l;
    }

    public int func_20135_c() {
        return this.ordinal();
    }

    public String func_20138_d() {
        return this.field_20142_m;
    }
}
