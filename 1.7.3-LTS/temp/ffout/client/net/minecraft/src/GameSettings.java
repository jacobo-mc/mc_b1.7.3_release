package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class GameSettings {
    private static final String[] field_20105_z = new String[]{"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
    private static final String[] field_20106_A = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
    private static final String[] field_25147_K = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    private static final String[] field_30006_M = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
    public float field_1584_a = 1.0F;
    public float field_1583_b = 1.0F;
    public float field_1582_c = 0.5F;
    public boolean field_1581_d = false;
    public int field_1580_e = 0;
    public boolean field_1579_f = true;
    public boolean field_1578_g = false;
    public boolean field_27342_h = false;
    public int field_1577_h = 1;
    public boolean field_1576_i = true;
    public boolean field_22278_j = true;
    public String field_6524_j = "Default";
    public KeyBinding field_1575_j = new KeyBinding("key.forward", 17);
    public KeyBinding field_1574_k = new KeyBinding("key.left", 30);
    public KeyBinding field_1573_l = new KeyBinding("key.back", 31);
    public KeyBinding field_1572_m = new KeyBinding("key.right", 32);
    public KeyBinding field_1571_n = new KeyBinding("key.jump", 57);
    public KeyBinding field_1570_o = new KeyBinding("key.inventory", 18);
    public KeyBinding field_6523_q = new KeyBinding("key.drop", 16);
    public KeyBinding field_6521_r = new KeyBinding("key.chat", 20);
    public KeyBinding field_6520_s = new KeyBinding("key.fog", 33);
    public KeyBinding field_1565_s = new KeyBinding("key.sneak", 42);
    public KeyBinding[] field_1564_t;
    protected Minecraft field_1563_u;
    private File field_6522_B;
    public int field_1561_w;
    public boolean field_22277_y;
    public boolean field_1560_x;
    public boolean field_22276_A;
    public String field_12259_z;
    public boolean field_22275_C;
    public boolean field_22274_D;
    public boolean field_22273_E;
    public float field_22272_F;
    public float field_22271_G;
    public int field_25148_H;

    public GameSettings(Minecraft var1, File var2) {
        this.field_1564_t = new KeyBinding[]{this.field_1575_j, this.field_1574_k, this.field_1573_l, this.field_1572_m, this.field_1571_n, this.field_1565_s, this.field_6523_q, this.field_1570_o, this.field_6521_r, this.field_6520_s};
        this.field_1561_w = 2;
        this.field_22277_y = false;
        this.field_1560_x = false;
        this.field_22276_A = false;
        this.field_12259_z = "";
        this.field_22275_C = false;
        this.field_22274_D = false;
        this.field_22273_E = false;
        this.field_22272_F = 1.0F;
        this.field_22271_G = 1.0F;
        this.field_25148_H = 0;
        this.field_1563_u = var1;
        this.field_6522_B = new File(var2, "options.txt");
        this.func_6519_a();
    }

    public GameSettings() {
        this.field_1564_t = new KeyBinding[]{this.field_1575_j, this.field_1574_k, this.field_1573_l, this.field_1572_m, this.field_1571_n, this.field_1565_s, this.field_6523_q, this.field_1570_o, this.field_6521_r, this.field_6520_s};
        this.field_1561_w = 2;
        this.field_22277_y = false;
        this.field_1560_x = false;
        this.field_22276_A = false;
        this.field_12259_z = "";
        this.field_22275_C = false;
        this.field_22274_D = false;
        this.field_22273_E = false;
        this.field_22272_F = 1.0F;
        this.field_22271_G = 1.0F;
        this.field_25148_H = 0;
    }

    public String func_20102_a(int var1) {
        StringTranslate var2 = StringTranslate.func_20162_a();
        return var2.func_20163_a(this.field_1564_t[var1].field_1371_a);
    }

    public String func_1047_d(int var1) {
        return Keyboard.getKeyName(this.field_1564_t[var1].field_1370_b);
    }

    public void func_1042_a(int var1, int var2) {
        this.field_1564_t[var1].field_1370_b = var2;
        this.func_1041_b();
    }

    public void func_1048_a(EnumOptions var1, float var2) {
        if (var1 == EnumOptions.MUSIC) {
            this.field_1584_a = var2;
            this.field_1563_u.field_6301_A.func_335_a();
        }

        if (var1 == EnumOptions.SOUND) {
            this.field_1583_b = var2;
            this.field_1563_u.field_6301_A.func_335_a();
        }

        if (var1 == EnumOptions.SENSITIVITY) {
            this.field_1582_c = var2;
        }

    }

    public void func_1045_b(EnumOptions var1, int var2) {
        if (var1 == EnumOptions.INVERT_MOUSE) {
            this.field_1581_d = !this.field_1581_d;
        }

        if (var1 == EnumOptions.RENDER_DISTANCE) {
            this.field_1580_e = this.field_1580_e + var2 & 3;
        }

        if (var1 == EnumOptions.GUI_SCALE) {
            this.field_25148_H = this.field_25148_H + var2 & 3;
        }

        if (var1 == EnumOptions.VIEW_BOBBING) {
            this.field_1579_f = !this.field_1579_f;
        }

        if (var1 == EnumOptions.ADVANCED_OPENGL) {
            this.field_27342_h = !this.field_27342_h;
            this.field_1563_u.field_6323_f.func_958_a();
        }

        if (var1 == EnumOptions.ANAGLYPH) {
            this.field_1578_g = !this.field_1578_g;
            this.field_1563_u.field_6315_n.func_1065_b();
        }

        if (var1 == EnumOptions.FRAMERATE_LIMIT) {
            this.field_1577_h = (this.field_1577_h + var2 + 3) % 3;
        }

        if (var1 == EnumOptions.DIFFICULTY) {
            this.field_1561_w = this.field_1561_w + var2 & 3;
        }

        if (var1 == EnumOptions.GRAPHICS) {
            this.field_1576_i = !this.field_1576_i;
            this.field_1563_u.field_6323_f.func_958_a();
        }

        if (var1 == EnumOptions.AMBIENT_OCCLUSION) {
            this.field_22278_j = !this.field_22278_j;
            this.field_1563_u.field_6323_f.func_958_a();
        }

        this.func_1041_b();
    }

    public float func_20104_a(EnumOptions var1) {
        if (var1 == EnumOptions.MUSIC) {
            return this.field_1584_a;
        } else if (var1 == EnumOptions.SOUND) {
            return this.field_1583_b;
        } else {
            return var1 == EnumOptions.SENSITIVITY ? this.field_1582_c : 0.0F;
        }
    }

    public boolean func_20103_b(EnumOptions var1) {
        switch(EnumOptionsMappingHelper.field_20155_a[var1.ordinal()]) {
        case 1:
            return this.field_1581_d;
        case 2:
            return this.field_1579_f;
        case 3:
            return this.field_1578_g;
        case 4:
            return this.field_27342_h;
        case 5:
            return this.field_22278_j;
        default:
            return false;
        }
    }

    public String func_1043_a(EnumOptions var1) {
        StringTranslate var2 = StringTranslate.func_20162_a();
        String var3 = var2.func_20163_a(var1.func_20138_d()) + ": ";
        if (var1.func_20136_a()) {
            float var5 = this.func_20104_a(var1);
            if (var1 == EnumOptions.SENSITIVITY) {
                if (var5 == 0.0F) {
                    return var3 + var2.func_20163_a("options.sensitivity.min");
                } else {
                    return var5 == 1.0F ? var3 + var2.func_20163_a("options.sensitivity.max") : var3 + (int)(var5 * 200.0F) + "%";
                }
            } else {
                return var5 == 0.0F ? var3 + var2.func_20163_a("options.off") : var3 + (int)(var5 * 100.0F) + "%";
            }
        } else if (var1.func_20140_b()) {
            boolean var4 = this.func_20103_b(var1);
            return var4 ? var3 + var2.func_20163_a("options.on") : var3 + var2.func_20163_a("options.off");
        } else if (var1 == EnumOptions.RENDER_DISTANCE) {
            return var3 + var2.func_20163_a(field_20105_z[this.field_1580_e]);
        } else if (var1 == EnumOptions.DIFFICULTY) {
            return var3 + var2.func_20163_a(field_20106_A[this.field_1561_w]);
        } else if (var1 == EnumOptions.GUI_SCALE) {
            return var3 + var2.func_20163_a(field_25147_K[this.field_25148_H]);
        } else if (var1 == EnumOptions.FRAMERATE_LIMIT) {
            return var3 + StatCollector.func_25200_a(field_30006_M[this.field_1577_h]);
        } else if (var1 == EnumOptions.GRAPHICS) {
            return this.field_1576_i ? var3 + var2.func_20163_a("options.graphics.fancy") : var3 + var2.func_20163_a("options.graphics.fast");
        } else {
            return var3;
        }
    }

    public void func_6519_a() {
        try {
            if (!this.field_6522_B.exists()) {
                return;
            }

            BufferedReader var1 = new BufferedReader(new FileReader(this.field_6522_B));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                try {
                    String[] var3 = var2.split(":");
                    if (var3[0].equals("music")) {
                        this.field_1584_a = this.func_1050_a(var3[1]);
                    }

                    if (var3[0].equals("sound")) {
                        this.field_1583_b = this.func_1050_a(var3[1]);
                    }

                    if (var3[0].equals("mouseSensitivity")) {
                        this.field_1582_c = this.func_1050_a(var3[1]);
                    }

                    if (var3[0].equals("invertYMouse")) {
                        this.field_1581_d = var3[1].equals("true");
                    }

                    if (var3[0].equals("viewDistance")) {
                        this.field_1580_e = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("guiScale")) {
                        this.field_25148_H = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("bobView")) {
                        this.field_1579_f = var3[1].equals("true");
                    }

                    if (var3[0].equals("anaglyph3d")) {
                        this.field_1578_g = var3[1].equals("true");
                    }

                    if (var3[0].equals("advancedOpengl")) {
                        this.field_27342_h = var3[1].equals("true");
                    }

                    if (var3[0].equals("fpsLimit")) {
                        this.field_1577_h = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("difficulty")) {
                        this.field_1561_w = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("fancyGraphics")) {
                        this.field_1576_i = var3[1].equals("true");
                    }

                    if (var3[0].equals("ao")) {
                        this.field_22278_j = var3[1].equals("true");
                    }

                    if (var3[0].equals("skin")) {
                        this.field_6524_j = var3[1];
                    }

                    if (var3[0].equals("lastServer") && var3.length >= 2) {
                        this.field_12259_z = var3[1];
                    }

                    for(int var4 = 0; var4 < this.field_1564_t.length; ++var4) {
                        if (var3[0].equals("key_" + this.field_1564_t[var4].field_1371_a)) {
                            this.field_1564_t[var4].field_1370_b = Integer.parseInt(var3[1]);
                        }
                    }
                } catch (Exception var5) {
                    System.out.println("Skipping bad option: " + var2);
                }
            }

            var1.close();
        } catch (Exception var6) {
            System.out.println("Failed to load options");
            var6.printStackTrace();
        }

    }

    private float func_1050_a(String var1) {
        if (var1.equals("true")) {
            return 1.0F;
        } else {
            return var1.equals("false") ? 0.0F : Float.parseFloat(var1);
        }
    }

    public void func_1041_b() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.field_6522_B));
            var1.println("music:" + this.field_1584_a);
            var1.println("sound:" + this.field_1583_b);
            var1.println("invertYMouse:" + this.field_1581_d);
            var1.println("mouseSensitivity:" + this.field_1582_c);
            var1.println("viewDistance:" + this.field_1580_e);
            var1.println("guiScale:" + this.field_25148_H);
            var1.println("bobView:" + this.field_1579_f);
            var1.println("anaglyph3d:" + this.field_1578_g);
            var1.println("advancedOpengl:" + this.field_27342_h);
            var1.println("fpsLimit:" + this.field_1577_h);
            var1.println("difficulty:" + this.field_1561_w);
            var1.println("fancyGraphics:" + this.field_1576_i);
            var1.println("ao:" + this.field_22278_j);
            var1.println("skin:" + this.field_6524_j);
            var1.println("lastServer:" + this.field_12259_z);

            for(int var2 = 0; var2 < this.field_1564_t.length; ++var2) {
                var1.println("key_" + this.field_1564_t[var2].field_1371_a + ":" + this.field_1564_t[var2].field_1370_b);
            }

            var1.close();
        } catch (Exception var3) {
            System.out.println("Failed to save options");
            var3.printStackTrace();
        }

    }
}
