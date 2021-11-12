package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class LoadingScreenRenderer implements IProgressUpdate {
    private String field_1004_a = "";
    private Minecraft field_1003_b;
    private String field_1007_c = "";
    private long field_1006_d = System.currentTimeMillis();
    private boolean field_1005_e = false;

    public LoadingScreenRenderer(Minecraft var1) {
        this.field_1003_b = var1;
    }

    public void func_596_a(String var1) {
        this.field_1005_e = false;
        this.func_597_c(var1);
    }

    public void func_594_b(String var1) {
        this.field_1005_e = true;
        this.func_597_c(this.field_1007_c);
    }

    public void func_597_c(String var1) {
        if (!this.field_1003_b.field_6293_H) {
            if (!this.field_1005_e) {
                throw new MinecraftError();
            }
        } else {
            this.field_1007_c = var1;
            ScaledResolution var2 = new ScaledResolution(this.field_1003_b.field_6304_y, this.field_1003_b.field_6326_c, this.field_1003_b.field_6325_d);
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, var2.field_25121_a, var2.field_25120_b, 0.0D, 100.0D, 300.0D);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        }
    }

    public void func_595_d(String var1) {
        if (!this.field_1003_b.field_6293_H) {
            if (!this.field_1005_e) {
                throw new MinecraftError();
            }
        } else {
            this.field_1006_d = 0L;
            this.field_1004_a = var1;
            this.func_593_a(-1);
            this.field_1006_d = 0L;
        }
    }

    public void func_593_a(int var1) {
        if (!this.field_1003_b.field_6293_H) {
            if (!this.field_1005_e) {
                throw new MinecraftError();
            }
        } else {
            long var2 = System.currentTimeMillis();
            if (var2 - this.field_1006_d >= 20L) {
                this.field_1006_d = var2;
                ScaledResolution var4 = new ScaledResolution(this.field_1003_b.field_6304_y, this.field_1003_b.field_6326_c, this.field_1003_b.field_6325_d);
                int var5 = var4.func_903_a();
                int var6 = var4.func_902_b();
                GL11.glClear(256);
                GL11.glMatrixMode(5889);
                GL11.glLoadIdentity();
                GL11.glOrtho(0.0D, var4.field_25121_a, var4.field_25120_b, 0.0D, 100.0D, 300.0D);
                GL11.glMatrixMode(5888);
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0F, 0.0F, -200.0F);
                GL11.glClear(16640);
                Tessellator var7 = Tessellator.field_1512_a;
                int var8 = this.field_1003_b.field_6315_n.func_1070_a("/gui/background.png");
                GL11.glBindTexture(3553, var8);
                float var9 = 32.0F;
                var7.func_977_b();
                var7.func_990_b(4210752);
                var7.func_983_a(0.0D, (double)var6, 0.0D, 0.0D, (double)((float)var6 / var9));
                var7.func_983_a((double)var5, (double)var6, 0.0D, (double)((float)var5 / var9), (double)((float)var6 / var9));
                var7.func_983_a((double)var5, 0.0D, 0.0D, (double)((float)var5 / var9), 0.0D);
                var7.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
                var7.func_982_a();
                if (var1 >= 0) {
                    byte var10 = 100;
                    byte var11 = 2;
                    int var12 = var5 / 2 - var10 / 2;
                    int var13 = var6 / 2 + 16;
                    GL11.glDisable(3553);
                    var7.func_977_b();
                    var7.func_990_b(8421504);
                    var7.func_991_a((double)var12, (double)var13, 0.0D);
                    var7.func_991_a((double)var12, (double)(var13 + var11), 0.0D);
                    var7.func_991_a((double)(var12 + var10), (double)(var13 + var11), 0.0D);
                    var7.func_991_a((double)(var12 + var10), (double)var13, 0.0D);
                    var7.func_990_b(8454016);
                    var7.func_991_a((double)var12, (double)var13, 0.0D);
                    var7.func_991_a((double)var12, (double)(var13 + var11), 0.0D);
                    var7.func_991_a((double)(var12 + var1), (double)(var13 + var11), 0.0D);
                    var7.func_991_a((double)(var12 + var1), (double)var13, 0.0D);
                    var7.func_982_a();
                    GL11.glEnable(3553);
                }

                this.field_1003_b.field_6314_o.func_874_a(this.field_1007_c, (var5 - this.field_1003_b.field_6314_o.func_871_a(this.field_1007_c)) / 2, var6 / 2 - 4 - 16, 16777215);
                this.field_1003_b.field_6314_o.func_874_a(this.field_1004_a, (var5 - this.field_1003_b.field_6314_o.func_871_a(this.field_1004_a)) / 2, var6 / 2 - 4 + 8, 16777215);
                Display.update();

                try {
                    Thread.yield();
                } catch (Exception var14) {
                }

            }
        }
    }
}
