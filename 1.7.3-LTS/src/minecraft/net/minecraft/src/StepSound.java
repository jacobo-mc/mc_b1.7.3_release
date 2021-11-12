package net.minecraft.src;

public class StepSound {
    public final String field_1678_a;
    public final float field_1677_b;
    public final float field_1679_c;

    public StepSound(String var1, float var2, float var3) {
        this.field_1678_a = var1;
        this.field_1677_b = var2;
        this.field_1679_c = var3;
    }

    public float getVolume() {
        return this.field_1677_b;
    }

    public float getPitch() {
        return this.field_1679_c;
    }

    public String stepSoundDir() {
        return "step." + this.field_1678_a;
    }

    public String stepSoundDir2() {
        return "step." + this.field_1678_a;
    }
}
