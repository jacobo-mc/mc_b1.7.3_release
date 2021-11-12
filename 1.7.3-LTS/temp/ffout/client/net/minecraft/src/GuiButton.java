package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiButton extends Gui {
    protected int field_935_a;
    protected int field_934_b;
    public int field_941_c;
    public int field_940_d;
    public String field_939_e;
    public int field_938_f;
    public boolean field_937_g;
    public boolean field_936_h;

    public GuiButton(int var1, int var2, int var3, String var4) {
        this(var1, var2, var3, 200, 20, var4);
    }

    public GuiButton(int var1, int var2, int var3, int var4, int var5, String var6) {
        this.field_935_a = 200;
        this.field_934_b = 20;
        this.field_937_g = true;
        this.field_936_h = true;
        this.field_938_f = var1;
        this.field_941_c = var2;
        this.field_940_d = var3;
        this.field_935_a = var4;
        this.field_934_b = var5;
        this.field_939_e = var6;
    }

    protected int func_558_a(boolean var1) {
        byte var2 = 1;
        if (!this.field_937_g) {
            var2 = 0;
        } else if (var1) {
            var2 = 2;
        }

        return var2;
    }

    public void func_561_a(Minecraft var1, int var2, int var3) {
        if (this.field_936_h) {
            FontRenderer var4 = var1.field_6314_o;
            GL11.glBindTexture(3553, var1.field_6315_n.func_1070_a("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean var5 = var2 >= this.field_941_c && var3 >= this.field_940_d && var2 < this.field_941_c + this.field_935_a && var3 < this.field_940_d + this.field_934_b;
            int var6 = this.func_558_a(var5);
            this.func_550_b(this.field_941_c, this.field_940_d, 0, 46 + var6 * 20, this.field_935_a / 2, this.field_934_b);
            this.func_550_b(this.field_941_c + this.field_935_a / 2, this.field_940_d, 200 - this.field_935_a / 2, 46 + var6 * 20, this.field_935_a / 2, this.field_934_b);
            this.func_560_b(var1, var2, var3);
            if (!this.field_937_g) {
                this.func_548_a(var4, this.field_939_e, this.field_941_c + this.field_935_a / 2, this.field_940_d + (this.field_934_b - 8) / 2, -6250336);
            } else if (var5) {
                this.func_548_a(var4, this.field_939_e, this.field_941_c + this.field_935_a / 2, this.field_940_d + (this.field_934_b - 8) / 2, 16777120);
            } else {
                this.func_548_a(var4, this.field_939_e, this.field_941_c + this.field_935_a / 2, this.field_940_d + (this.field_934_b - 8) / 2, 14737632);
            }

        }
    }

    protected void func_560_b(Minecraft var1, int var2, int var3) {
    }

    public void func_559_a(int var1, int var2) {
    }

    public boolean func_562_c(Minecraft var1, int var2, int var3) {
        return this.field_937_g && var2 >= this.field_941_c && var3 >= this.field_940_d && var2 < this.field_941_c + this.field_935_a && var3 < this.field_940_d + this.field_934_b;
    }
}
