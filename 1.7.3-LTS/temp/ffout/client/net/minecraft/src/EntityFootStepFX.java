package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class EntityFootStepFX extends EntityFX {
    private int field_27018_a = 0;
    private int field_27020_o = 0;
    private RenderEngine field_27019_p;

    public EntityFootStepFX(RenderEngine var1, World var2, double var3, double var5, double var7) {
        super(var2, var3, var5, var7, 0.0D, 0.0D, 0.0D);
        this.field_27019_p = var1;
        this.field_608_an = this.field_607_ao = this.field_606_ap = 0.0D;
        this.field_27020_o = 200;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.field_27018_a + var2) / (float)this.field_27020_o;
        var8 *= var8;
        float var9 = 2.0F - var8 * 2.0F;
        if (var9 > 1.0F) {
            var9 = 1.0F;
        }

        var9 *= 0.2F;
        GL11.glDisable(2896);
        float var10 = 0.125F;
        float var11 = (float)(this.field_611_ak - field_660_l);
        float var12 = (float)(this.field_610_al - field_659_m);
        float var13 = (float)(this.field_609_am - field_658_n);
        float var14 = this.field_615_ag.func_598_c(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
        this.field_27019_p.func_1076_b(this.field_27019_p.func_1070_a("/misc/footprint.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        var1.func_977_b();
        var1.func_986_a(var14, var14, var14, var9);
        var1.func_983_a((double)(var11 - var10), (double)var12, (double)(var13 + var10), 0.0D, 1.0D);
        var1.func_983_a((double)(var11 + var10), (double)var12, (double)(var13 + var10), 1.0D, 1.0D);
        var1.func_983_a((double)(var11 + var10), (double)var12, (double)(var13 - var10), 1.0D, 0.0D);
        var1.func_983_a((double)(var11 - var10), (double)var12, (double)(var13 - var10), 0.0D, 0.0D);
        var1.func_982_a();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    public void func_370_e_() {
        ++this.field_27018_a;
        if (this.field_27018_a == this.field_27020_o) {
            this.func_395_F();
        }

    }

    public int func_404_c() {
        return 3;
    }
}
