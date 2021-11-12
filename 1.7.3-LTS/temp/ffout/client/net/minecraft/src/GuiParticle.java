package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiParticle extends Gui {
    private List field_25090_a = new ArrayList();
    private Minecraft field_25089_b;

    public GuiParticle(Minecraft var1) {
        this.field_25089_b = var1;
    }

    public void func_25088_a() {
        for(int var1 = 0; var1 < this.field_25090_a.size(); ++var1) {
            Particle var2 = (Particle)this.field_25090_a.get(var1);
            var2.func_25127_a();
            var2.func_25125_a(this);
            if (var2.field_25139_h) {
                this.field_25090_a.remove(var1--);
            }
        }

    }

    public void func_25087_a(float var1) {
        this.field_25089_b.field_6315_n.func_1076_b(this.field_25089_b.field_6315_n.func_1070_a("/gui/particles.png"));

        for(int var2 = 0; var2 < this.field_25090_a.size(); ++var2) {
            Particle var3 = (Particle)this.field_25090_a.get(var2);
            int var4 = (int)(var3.field_25144_c + (var3.field_25146_a - var3.field_25144_c) * (double)var1 - 4.0D);
            int var5 = (int)(var3.field_25143_d + (var3.field_25145_b - var3.field_25143_d) * (double)var1 - 4.0D);
            float var6 = (float)(var3.field_25129_r + (var3.field_25133_n - var3.field_25129_r) * (double)var1);
            float var7 = (float)(var3.field_25132_o + (var3.field_25136_k - var3.field_25132_o) * (double)var1);
            float var8 = (float)(var3.field_25131_p + (var3.field_25135_l - var3.field_25131_p) * (double)var1);
            float var9 = (float)(var3.field_25130_q + (var3.field_25134_m - var3.field_25130_q) * (double)var1);
            GL11.glColor4f(var7, var8, var9, var6);
            this.func_550_b(var4, var5, 40, 0, 8, 8);
        }

    }
}
