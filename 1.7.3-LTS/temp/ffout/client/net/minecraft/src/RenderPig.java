package net.minecraft.src;

public class RenderPig extends RenderLiving {
    public RenderPig(ModelBase var1, ModelBase var2, float var3) {
        super(var1, var3);
        this.func_4013_a(var2);
    }

    protected boolean func_180_a(EntityPig var1, int var2, float var3) {
        this.func_151_a("/mob/saddle.png");
        return var2 == 0 && var1.func_21068_q();
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean func_166_a(EntityLiving var1, int var2, float var3) {
        return this.func_180_a((EntityPig)var1, var2, var3);
    }
}
