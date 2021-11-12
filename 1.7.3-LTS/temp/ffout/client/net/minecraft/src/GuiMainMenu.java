package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class GuiMainMenu extends GuiScreen {
    private static final Random field_6463_h = new Random();
    private float field_989_j = 0.0F;
    private String field_6462_l = "missingno";
    private GuiButton field_25096_l;

    public GuiMainMenu() {
        try {
            ArrayList var1 = new ArrayList();
            BufferedReader var2 = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
            String var3 = "";

            while((var3 = var2.readLine()) != null) {
                var3 = var3.trim();
                if (var3.length() > 0) {
                    var1.add(var3);
                }
            }

            this.field_6462_l = (String)var1.get(field_6463_h.nextInt(var1.size()));
        } catch (Exception var4) {
        }

    }

    public void func_570_g() {
        ++this.field_989_j;
    }

    protected void func_580_a(char var1, int var2) {
    }

    public void func_6448_a() {
        Calendar var1 = Calendar.getInstance();
        var1.setTime(new Date());
        if (var1.get(2) + 1 == 11 && var1.get(5) == 9) {
            this.field_6462_l = "Happy birthday, ez!";
        } else if (var1.get(2) + 1 == 6 && var1.get(5) == 1) {
            this.field_6462_l = "Happy birthday, Notch!";
        } else if (var1.get(2) + 1 == 12 && var1.get(5) == 24) {
            this.field_6462_l = "Merry X-mas!";
        } else if (var1.get(2) + 1 == 1 && var1.get(5) == 1) {
            this.field_6462_l = "Happy new year!";
        }

        StringTranslate var2 = StringTranslate.func_20162_a();
        int var4 = this.field_950_d / 4 + 48;
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, var4, var2.func_20163_a("menu.singleplayer")));
        this.field_949_e.add(this.field_25096_l = new GuiButton(2, this.field_951_c / 2 - 100, var4 + 24, var2.func_20163_a("menu.multiplayer")));
        this.field_949_e.add(new GuiButton(3, this.field_951_c / 2 - 100, var4 + 48, var2.func_20163_a("menu.mods")));
        if (this.field_945_b.field_6317_l) {
            this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, var4 + 72, var2.func_20163_a("menu.options")));
        } else {
            this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, var4 + 72 + 12, 98, 20, var2.func_20163_a("menu.options")));
            this.field_949_e.add(new GuiButton(4, this.field_951_c / 2 + 2, var4 + 72 + 12, 98, 20, var2.func_20163_a("menu.quit")));
        }

        if (this.field_945_b.field_6320_i == null) {
            this.field_25096_l.field_937_g = false;
        }

    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 0) {
            this.field_945_b.func_6272_a(new GuiOptions(this, this.field_945_b.field_6304_y));
        }

        if (var1.field_938_f == 1) {
            this.field_945_b.func_6272_a(new GuiSelectWorld(this));
        }

        if (var1.field_938_f == 2) {
            this.field_945_b.func_6272_a(new GuiMultiplayer(this));
        }

        if (var1.field_938_f == 3) {
            this.field_945_b.func_6272_a(new GuiTexturePacks(this));
        }

        if (var1.field_938_f == 4) {
            this.field_945_b.func_6244_d();
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        Tessellator var4 = Tessellator.field_1512_a;
        short var5 = 274;
        int var6 = this.field_951_c / 2 - var5 / 2;
        byte var7 = 30;
        GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("/title/mclogo.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_550_b(var6 + 0, var7 + 0, 0, 0, 155, 44);
        this.func_550_b(var6 + 155, var7 + 0, 0, 45, 155, 44);
        var4.func_990_b(16777215);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.field_951_c / 2 + 90), 70.0F, 0.0F);
        GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
        float var8 = 1.8F - MathHelper.func_1112_e(MathHelper.func_1106_a((float)(System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
        var8 = var8 * 100.0F / (float)(this.field_6451_g.func_871_a(this.field_6462_l) + 32);
        GL11.glScalef(var8, var8, var8);
        this.func_548_a(this.field_6451_g, this.field_6462_l, 0, -8, 16776960);
        GL11.glPopMatrix();
        this.func_547_b(this.field_6451_g, "Minecraft Beta 1.7.3", 2, 2, 5263440);
        String var9 = "Copyright Mojang AB. Do not distribute.";
        this.func_547_b(this.field_6451_g, var9, this.field_951_c - this.field_6451_g.func_871_a(var9) - 2, this.field_950_d - 10, 16777215);
        super.func_571_a(var1, var2, var3);
    }
}
