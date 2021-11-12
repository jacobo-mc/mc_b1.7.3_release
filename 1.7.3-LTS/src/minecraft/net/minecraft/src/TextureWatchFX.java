package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;

public class TextureWatchFX extends TextureFX {
    private Minecraft mc;
    private int[] watchIconImageData = new int[256];
    private int[] dialImageData = new int[256];
    private double field_4222_j;
    private double field_4221_k;

    public TextureWatchFX(Minecraft var1) {
        super(Item.pocketSundial.getIconFromDamage(0));
        this.mc = var1;
        this.tileImage = 1;

        try {
            BufferedImage var2 = ImageIO.read(Minecraft.class.getResource("/gui/items.png"));
            int var3 = this.iconIndex % 16 * 16;
            int var4 = this.iconIndex / 16 * 16;
            var2.getRGB(var3, var4, 16, 16, this.watchIconImageData, 0, 16);
            var2 = ImageIO.read(Minecraft.class.getResource("/misc/dial.png"));
            var2.getRGB(0, 0, 16, 16, this.dialImageData, 0, 16);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void onTick() {
        double var1 = 0.0D;
        if (this.mc.theWorld != null && this.mc.thePlayer != null) {
            float var3 = this.mc.theWorld.getCelestialAngle(1.0F);
            var1 = (double)(-var3 * 3.1415927F * 2.0F);
            if (this.mc.theWorld.worldProvider.isNether) {
                var1 = Math.random() * 3.1415927410125732D * 2.0D;
            }
        }

        double var22;
        for(var22 = var1 - this.field_4222_j; var22 < -3.141592653589793D; var22 += 6.283185307179586D) {
        }

        while(var22 >= 3.141592653589793D) {
            var22 -= 6.283185307179586D;
        }

        if (var22 < -1.0D) {
            var22 = -1.0D;
        }

        if (var22 > 1.0D) {
            var22 = 1.0D;
        }

        this.field_4221_k += var22 * 0.1D;
        this.field_4221_k *= 0.8D;
        this.field_4222_j += this.field_4221_k;
        double var5 = Math.sin(this.field_4222_j);
        double var7 = Math.cos(this.field_4222_j);

        for(int var9 = 0; var9 < 256; ++var9) {
            int var10 = this.watchIconImageData[var9] >> 24 & 255;
            int var11 = this.watchIconImageData[var9] >> 16 & 255;
            int var12 = this.watchIconImageData[var9] >> 8 & 255;
            int var13 = this.watchIconImageData[var9] >> 0 & 255;
            if (var11 == var13 && var12 == 0 && var13 > 0) {
                double var14 = -((double)(var9 % 16) / 15.0D - 0.5D);
                double var16 = (double)(var9 / 16) / 15.0D - 0.5D;
                int var18 = var11;
                int var19 = (int)((var14 * var7 + var16 * var5 + 0.5D) * 16.0D);
                int var20 = (int)((var16 * var7 - var14 * var5 + 0.5D) * 16.0D);
                int var21 = (var19 & 15) + (var20 & 15) * 16;
                var10 = this.dialImageData[var21] >> 24 & 255;
                var11 = (this.dialImageData[var21] >> 16 & 255) * var11 / 255;
                var12 = (this.dialImageData[var21] >> 8 & 255) * var18 / 255;
                var13 = (this.dialImageData[var21] >> 0 & 255) * var18 / 255;
            }

            if (this.anaglyphEnabled) {
                int var23 = (var11 * 30 + var12 * 59 + var13 * 11) / 100;
                int var15 = (var11 * 30 + var12 * 70) / 100;
                int var24 = (var11 * 30 + var13 * 70) / 100;
                var11 = var23;
                var12 = var15;
                var13 = var24;
            }

            this.imageData[var9 * 4 + 0] = (byte)var11;
            this.imageData[var9 * 4 + 1] = (byte)var12;
            this.imageData[var9 * 4 + 2] = (byte)var13;
            this.imageData[var9 * 4 + 3] = (byte)var10;
        }

    }
}
