package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiAchievement extends Gui {
    private Minecraft field_25082_a;
    private int field_25081_b;
    private int field_25086_c;
    private String field_25085_d;
    private String field_25084_e;
    private Achievement field_27105_f;
    private long field_25083_f;
    private RenderItem field_27104_h;
    private boolean field_27103_i;

    public GuiAchievement(Minecraft var1) {
        this.field_25082_a = var1;
        this.field_27104_h = new RenderItem();
    }

    public void func_27102_a(Achievement var1) {
        this.field_25085_d = StatCollector.func_25200_a("achievement.get");
        this.field_25084_e = var1.field_25070_e;
        this.field_25083_f = System.currentTimeMillis();
        this.field_27105_f = var1;
        this.field_27103_i = false;
    }

    public void func_27101_b(Achievement var1) {
        this.field_25085_d = var1.field_25070_e;
        this.field_25084_e = var1.func_27090_e();
        this.field_25083_f = System.currentTimeMillis() - 2500L;
        this.field_27105_f = var1;
        this.field_27103_i = true;
    }

    private void func_25079_b() {
        GL11.glViewport(0, 0, this.field_25082_a.field_6326_c, this.field_25082_a.field_6325_d);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this.field_25081_b = this.field_25082_a.field_6326_c;
        this.field_25086_c = this.field_25082_a.field_6325_d;
        ScaledResolution var1 = new ScaledResolution(this.field_25082_a.field_6304_y, this.field_25082_a.field_6326_c, this.field_25082_a.field_6325_d);
        this.field_25081_b = var1.func_903_a();
        this.field_25086_c = var1.func_902_b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, (double)this.field_25081_b, (double)this.field_25086_c, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
    }

    public void func_25080_a() {
        if (Minecraft.field_28005_H > 0L) {
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            RenderHelper.func_1159_a();
            this.func_25079_b();
            String var1 = "Minecraft Beta 1.7.3   Unlicensed Copy :(";
            String var2 = "(Or logged in from another location)";
            String var3 = "Purchase at minecraft.net";
            this.field_25082_a.field_6314_o.func_874_a(var1, 2, 2, 16777215);
            this.field_25082_a.field_6314_o.func_874_a(var2, 2, 11, 16777215);
            this.field_25082_a.field_6314_o.func_874_a(var3, 2, 20, 16777215);
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
        }

        if (this.field_27105_f != null && this.field_25083_f != 0L) {
            double var8 = (double)(System.currentTimeMillis() - this.field_25083_f) / 3000.0D;
            if (this.field_27103_i || this.field_27103_i || var8 >= 0.0D && var8 <= 1.0D) {
                this.func_25079_b();
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
                double var9 = var8 * 2.0D;
                if (var9 > 1.0D) {
                    var9 = 2.0D - var9;
                }

                var9 *= 4.0D;
                var9 = 1.0D - var9;
                if (var9 < 0.0D) {
                    var9 = 0.0D;
                }

                var9 *= var9;
                var9 *= var9;
                int var5 = this.field_25081_b - 160;
                int var6 = 0 - (int)(var9 * 36.0D);
                int var7 = this.field_25082_a.field_6315_n.func_1070_a("/achievement/bg.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3553);
                GL11.glBindTexture(3553, var7);
                GL11.glDisable(2896);
                this.func_550_b(var5, var6, 96, 202, 160, 32);
                if (this.field_27103_i) {
                    this.field_25082_a.field_6314_o.func_27278_a(this.field_25084_e, var5 + 30, var6 + 7, 120, -1);
                } else {
                    this.field_25082_a.field_6314_o.func_873_b(this.field_25085_d, var5 + 30, var6 + 7, -256);
                    this.field_25082_a.field_6314_o.func_873_b(this.field_25084_e, var5 + 30, var6 + 18, -1);
                }

                GL11.glPushMatrix();
                GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
                RenderHelper.func_1158_b();
                GL11.glPopMatrix();
                GL11.glDisable(2896);
                GL11.glEnable(32826);
                GL11.glEnable(2903);
                GL11.glEnable(2896);
                this.field_27104_h.func_161_a(this.field_25082_a.field_6314_o, this.field_25082_a.field_6315_n, this.field_27105_f.field_27097_d, var5 + 8, var6 + 8);
                GL11.glDisable(2896);
                GL11.glDepthMask(true);
                GL11.glEnable(2929);
            } else {
                this.field_25083_f = 0L;
            }
        }
    }
}
