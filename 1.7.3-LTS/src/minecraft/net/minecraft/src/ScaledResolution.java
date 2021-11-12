package net.minecraft.src;

public class ScaledResolution {
    private int scaledWidth;
    private int scaledHeight;
    public double scaledWidthD;
    public double scaledHeightD;
    public int scaleFactor;

    public ScaledResolution(GameSettings var1, int var2, int var3) {
        this.scaledWidth = var2;
        this.scaledHeight = var3;
        this.scaleFactor = 1;
        int var4 = var1.guiScale;
        if (var4 == 0) {
            var4 = 1000;
        }

        while(this.scaleFactor < var4 && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240) {
            ++this.scaleFactor;
        }

        this.scaledWidthD = (double)this.scaledWidth / (double)this.scaleFactor;
        this.scaledHeightD = (double)this.scaledHeight / (double)this.scaleFactor;
        this.scaledWidth = (int)Math.ceil(this.scaledWidthD);
        this.scaledHeight = (int)Math.ceil(this.scaledHeightD);
    }

    public int getScaledWidth() {
        return this.scaledWidth;
    }

    public int getScaledHeight() {
        return this.scaledHeight;
    }
}
