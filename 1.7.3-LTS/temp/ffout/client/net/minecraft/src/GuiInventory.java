package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiInventory extends GuiContainer {
    private float field_976_l;
    private float field_975_m;

    public GuiInventory(EntityPlayer var1) {
        super(var1.field_20069_g);
        this.field_948_f = true;
        var1.func_25058_a(AchievementList.field_25195_b, 1);
    }

    public void func_6448_a() {
        this.field_949_e.clear();
    }

    protected void func_587_j() {
        this.field_6451_g.func_873_b("Crafting", 86, 16, 4210752);
    }

    public void func_571_a(int var1, int var2, float var3) {
        super.func_571_a(var1, var2, var3);
        this.field_976_l = (float)var1;
        this.field_975_m = (float)var2;
    }

    protected void func_589_a(float var1) {
        int var2 = this.field_945_b.field_6315_n.func_1070_a("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_945_b.field_6315_n.func_1076_b(var2);
        int var3 = (this.field_951_c - this.field_971_a) / 2;
        int var4 = (this.field_950_d - this.field_974_h) / 2;
        this.func_550_b(var3, var4, 0, 0, this.field_971_a, this.field_974_h);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(var3 + 51), (float)(var4 + 75), 50.0F);
        float var5 = 30.0F;
        GL11.glScalef(-var5, var5, var5);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float var6 = this.field_945_b.field_6322_g.field_735_n;
        float var7 = this.field_945_b.field_6322_g.field_605_aq;
        float var8 = this.field_945_b.field_6322_g.field_604_ar;
        float var9 = (float)(var3 + 51) - this.field_976_l;
        float var10 = (float)(var4 + 75 - 50) - this.field_975_m;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(var10 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        this.field_945_b.field_6322_g.field_735_n = (float)Math.atan((double)(var9 / 40.0F)) * 20.0F;
        this.field_945_b.field_6322_g.field_605_aq = (float)Math.atan((double)(var9 / 40.0F)) * 40.0F;
        this.field_945_b.field_6322_g.field_604_ar = -((float)Math.atan((double)(var10 / 40.0F))) * 20.0F;
        this.field_945_b.field_6322_g.field_31003_bE = 1.0F;
        GL11.glTranslatef(0.0F, this.field_945_b.field_6322_g.field_9292_aO, 0.0F);
        RenderManager.field_1233_a.field_1225_i = 180.0F;
        RenderManager.field_1233_a.func_853_a(this.field_945_b.field_6322_g, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        this.field_945_b.field_6322_g.field_31003_bE = 0.0F;
        this.field_945_b.field_6322_g.field_735_n = var6;
        this.field_945_b.field_6322_g.field_605_aq = var7;
        this.field_945_b.field_6322_g.field_604_ar = var8;
        GL11.glPopMatrix();
        RenderHelper.func_1159_a();
        GL11.glDisable(32826);
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 0) {
            this.field_945_b.func_6272_a(new GuiAchievements(this.field_945_b.field_25001_G));
        }

        if (var1.field_938_f == 1) {
            this.field_945_b.func_6272_a(new GuiStats(this, this.field_945_b.field_25001_G));
        }

    }
}
