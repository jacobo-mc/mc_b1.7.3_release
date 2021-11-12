package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiSlider extends GuiButton {
    public float field_944_i = 1.0F;
    public boolean field_943_j = false;
    private EnumOptions field_942_l = null;

    public GuiSlider(int var1, int var2, int var3, EnumOptions var4, String var5, float var6) {
        super(var1, var2, var3, 150, 20, var5);
        this.field_942_l = var4;
        this.field_944_i = var6;
    }

    protected int func_558_a(boolean var1) {
        return 0;
    }

    protected void func_560_b(Minecraft var1, int var2, int var3) {
        if (this.field_936_h) {
            if (this.field_943_j) {
                this.field_944_i = (float)(var2 - (this.field_941_c + 4)) / (float)(this.field_935_a - 8);
                if (this.field_944_i < 0.0F) {
                    this.field_944_i = 0.0F;
                }

                if (this.field_944_i > 1.0F) {
                    this.field_944_i = 1.0F;
                }

                var1.field_6304_y.func_1048_a(this.field_942_l, this.field_944_i);
                this.field_939_e = var1.field_6304_y.func_1043_a(this.field_942_l);
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.func_550_b(this.field_941_c + (int)(this.field_944_i * (float)(this.field_935_a - 8)), this.field_940_d, 0, 66, 4, 20);
            this.func_550_b(this.field_941_c + (int)(this.field_944_i * (float)(this.field_935_a - 8)) + 4, this.field_940_d, 196, 66, 4, 20);
        }
    }

    public boolean func_562_c(Minecraft var1, int var2, int var3) {
        if (super.func_562_c(var1, var2, var3)) {
            this.field_944_i = (float)(var2 - (this.field_941_c + 4)) / (float)(this.field_935_a - 8);
            if (this.field_944_i < 0.0F) {
                this.field_944_i = 0.0F;
            }

            if (this.field_944_i > 1.0F) {
                this.field_944_i = 1.0F;
            }

            var1.field_6304_y.func_1048_a(this.field_942_l, this.field_944_i);
            this.field_939_e = var1.field_6304_y.func_1043_a(this.field_942_l);
            this.field_943_j = true;
            return true;
        } else {
            return false;
        }
    }

    public void func_559_a(int var1, int var2) {
        this.field_943_j = false;
    }
}
