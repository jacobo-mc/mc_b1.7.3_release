package net.minecraft.src;

public class MouseFilter {
    private float field_22388_a;
    private float field_22387_b;
    private float field_22389_c;

    public float func_22386_a(float var1, float var2) {
        this.field_22388_a += var1;
        var1 = (this.field_22388_a - this.field_22387_b) * var2;
        this.field_22389_c += (var1 - this.field_22389_c) * 0.5F;
        if (var1 > 0.0F && var1 > this.field_22389_c || var1 < 0.0F && var1 < this.field_22389_c) {
            var1 = this.field_22389_c;
        }

        this.field_22387_b += var1;
        return var1;
    }
}
