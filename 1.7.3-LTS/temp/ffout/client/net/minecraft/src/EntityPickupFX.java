package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class EntityPickupFX extends EntityFX {
    private Entity field_675_a;
    private Entity field_679_o;
    private int field_678_p = 0;
    private int field_677_q = 0;
    private float field_676_r;

    public EntityPickupFX(World var1, Entity var2, Entity var3, float var4) {
        super(var1, var2.field_611_ak, var2.field_610_al, var2.field_609_am, var2.field_608_an, var2.field_607_ao, var2.field_606_ap);
        this.field_675_a = var2;
        this.field_679_o = var3;
        this.field_677_q = 3;
        this.field_676_r = var4;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.field_678_p + var2) / (float)this.field_677_q;
        var8 *= var8;
        double var9 = this.field_675_a.field_611_ak;
        double var11 = this.field_675_a.field_610_al;
        double var13 = this.field_675_a.field_609_am;
        double var15 = this.field_679_o.field_638_aI + (this.field_679_o.field_611_ak - this.field_679_o.field_638_aI) * (double)var2;
        double var17 = this.field_679_o.field_637_aJ + (this.field_679_o.field_610_al - this.field_679_o.field_637_aJ) * (double)var2 + (double)this.field_676_r;
        double var19 = this.field_679_o.field_636_aK + (this.field_679_o.field_609_am - this.field_679_o.field_636_aK) * (double)var2;
        double var21 = var9 + (var15 - var9) * (double)var8;
        double var23 = var11 + (var17 - var11) * (double)var8;
        double var25 = var13 + (var19 - var13) * (double)var8;
        int var27 = MathHelper.func_1108_b(var21);
        int var28 = MathHelper.func_1108_b(var23 + (double)(this.field_9292_aO / 2.0F));
        int var29 = MathHelper.func_1108_b(var25);
        float var30 = this.field_615_ag.func_598_c(var27, var28, var29);
        var21 -= field_660_l;
        var23 -= field_659_m;
        var25 -= field_658_n;
        GL11.glColor4f(var30, var30, var30, 1.0F);
        RenderManager.field_1233_a.func_853_a(this.field_675_a, (double)((float)var21), (double)((float)var23), (double)((float)var25), this.field_675_a.field_605_aq, var2);
    }

    public void func_370_e_() {
        ++this.field_678_p;
        if (this.field_678_p == this.field_677_q) {
            this.func_395_F();
        }

    }

    public int func_404_c() {
        return 3;
    }
}
