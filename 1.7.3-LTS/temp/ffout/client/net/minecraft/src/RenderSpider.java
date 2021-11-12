package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSpider extends RenderLiving {
    public RenderSpider() {
        super(new ModelSpider(), 1.0F);
        this.func_4013_a(new ModelSpider());
    }

    protected float func_191_a(EntitySpider var1) {
        return 180.0F;
    }

    protected boolean func_190_a(EntitySpider var1, int var2, float var3) {
        if (var2 != 0) {
            return false;
        } else if (var2 != 0) {
            return false;
        } else {
            this.func_151_a("/mob/spider_eyes.png");
            float var4 = (1.0F - var1.func_382_a(1.0F)) * 0.5F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
            return true;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected float func_172_a(EntityLiving var1) {
        return this.func_191_a((EntitySpider)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean func_166_a(EntityLiving var1, int var2, float var3) {
        return this.func_190_a((EntitySpider)var1, var2, var3);
    }
}
