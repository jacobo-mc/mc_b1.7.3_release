package net.minecraft.src;

public class MouseFilter {
    private float targetValue;
    private float remainingValue;
    private float lastAmount;

    public float smooth(float var1, float var2) {
        this.targetValue += var1;
        var1 = (this.targetValue - this.remainingValue) * var2;
        this.lastAmount += (var1 - this.lastAmount) * 0.5F;
        if (var1 > 0.0F && var1 > this.lastAmount || var1 < 0.0F && var1 < this.lastAmount) {
            var1 = this.lastAmount;
        }

        this.remainingValue += var1;
        return var1;
    }
}
