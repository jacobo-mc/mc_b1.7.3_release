package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class RenderLightningBolt extends Render {
    public void func_27002_a(EntityLightningBolt var1, double var2, double var4, double var6, float var8, float var9) {
        Tessellator var10 = Tessellator.instance;
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBlendFunc(770, 1);
        double[] var11 = new double[8];
        double[] var12 = new double[8];
        double var13 = 0.0D;
        double var15 = 0.0D;
        Random var17 = new Random(var1.boltVertex);

        for(int var18 = 7; var18 >= 0; --var18) {
            var11[var18] = var13;
            var12[var18] = var15;
            var13 += (double)(var17.nextInt(11) - 5);
            var15 += (double)(var17.nextInt(11) - 5);
        }

        for(int var45 = 0; var45 < 4; ++var45) {
            Random var46 = new Random(var1.boltVertex);

            for(int var19 = 0; var19 < 3; ++var19) {
                int var20 = 7;
                int var21 = 0;
                if (var19 > 0) {
                    var20 = 7 - var19;
                }

                if (var19 > 0) {
                    var21 = var20 - 2;
                }

                double var22 = var11[var20] - var13;
                double var24 = var12[var20] - var15;

                for(int var26 = var20; var26 >= var21; --var26) {
                    double var27 = var22;
                    double var29 = var24;
                    if (var19 == 0) {
                        var22 += (double)(var46.nextInt(11) - 5);
                        var24 += (double)(var46.nextInt(11) - 5);
                    } else {
                        var22 += (double)(var46.nextInt(31) - 15);
                        var24 += (double)(var46.nextInt(31) - 15);
                    }

                    var10.startDrawing(5);
                    float var31 = 0.5F;
                    var10.setColorRGBA_F(0.9F * var31, 0.9F * var31, 1.0F * var31, 0.3F);
                    double var32 = 0.1D + (double)var45 * 0.2D;
                    if (var19 == 0) {
                        var32 *= (double)var26 * 0.1D + 1.0D;
                    }

                    double var34 = 0.1D + (double)var45 * 0.2D;
                    if (var19 == 0) {
                        var34 *= (double)(var26 - 1) * 0.1D + 1.0D;
                    }

                    for(int var36 = 0; var36 < 5; ++var36) {
                        double var37 = var2 + 0.5D - var32;
                        double var39 = var6 + 0.5D - var32;
                        if (var36 == 1 || var36 == 2) {
                            var37 += var32 * 2.0D;
                        }

                        if (var36 == 2 || var36 == 3) {
                            var39 += var32 * 2.0D;
                        }

                        double var41 = var2 + 0.5D - var34;
                        double var43 = var6 + 0.5D - var34;
                        if (var36 == 1 || var36 == 2) {
                            var41 += var34 * 2.0D;
                        }

                        if (var36 == 2 || var36 == 3) {
                            var43 += var34 * 2.0D;
                        }

                        var10.addVertex(var41 + var22, var4 + (double)(var26 * 16), var43 + var24);
                        var10.addVertex(var37 + var27, var4 + (double)((var26 + 1) * 16), var39 + var29);
                    }

                    var10.draw();
                }
            }
        }

        GL11.glDisable(3042 /*GL_BLEND*/);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_27002_a((EntityLightningBolt)var1, var2, var4, var6, var8, var9);
    }
}
