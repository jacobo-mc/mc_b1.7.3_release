package net.minecraft.src;

public enum EnumToolMaterial {
    WOOD(0, 59, 2.0F, 0),
    STONE(1, 131, 4.0F, 1),
    IRON(2, 250, 6.0F, 2),
    EMERALD(3, 1561, 8.0F, 3),
    GOLD(0, 32, 12.0F, 0);

    private final int field_21213_f;
    private final int field_21212_g;
    private final float field_21211_h;
    private final int field_21210_i;

    private EnumToolMaterial(int var3, int var4, float var5, int var6) {
        this.field_21213_f = var3;
        this.field_21212_g = var4;
        this.field_21211_h = var5;
        this.field_21210_i = var6;
    }

    public int func_21207_a() {
        return this.field_21212_g;
    }

    public float func_21206_b() {
        return this.field_21211_h;
    }

    public int func_21205_c() {
        return this.field_21210_i;
    }

    public int func_21208_d() {
        return this.field_21213_f;
    }
}
