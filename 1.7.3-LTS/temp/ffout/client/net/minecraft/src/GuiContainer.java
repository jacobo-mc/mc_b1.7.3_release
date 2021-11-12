package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class GuiContainer extends GuiScreen {
    private static RenderItem field_972_j = new RenderItem();
    protected int field_971_a = 176;
    protected int field_974_h = 166;
    public Container field_973_i;

    public GuiContainer(Container var1) {
        this.field_973_i = var1;
    }

    public void func_6448_a() {
        super.func_6448_a();
        this.field_945_b.field_6322_g.field_20068_h = this.field_973_i;
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        int var4 = (this.field_951_c - this.field_971_a) / 2;
        int var5 = (this.field_950_d - this.field_974_h) / 2;
        this.func_589_a(var3);
        GL11.glPushMatrix();
        GL11.glRotatef(120.0F, 1.0F, 0.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var4, (float)var5, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826);
        Slot var6 = null;

        int var9;
        int var10;
        for(int var7 = 0; var7 < this.field_973_i.field_20122_e.size(); ++var7) {
            Slot var8 = (Slot)this.field_973_i.field_20122_e.get(var7);
            this.func_590_a(var8);
            if (this.func_20081_a(var8, var1, var2)) {
                var6 = var8;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                var9 = var8.field_20006_b;
                var10 = var8.field_20008_c;
                this.func_549_a(var9, var10, var9 + 16, var10 + 16, -2130706433, -2130706433);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
        }

        InventoryPlayer var12 = this.field_945_b.field_6322_g.field_778_b;
        if (var12.func_20075_i() != null) {
            GL11.glTranslatef(0.0F, 0.0F, 32.0F);
            field_972_j.func_161_a(this.field_6451_g, this.field_945_b.field_6315_n, var12.func_20075_i(), var1 - var4 - 8, var2 - var5 - 8);
            field_972_j.func_164_b(this.field_6451_g, this.field_945_b.field_6315_n, var12.func_20075_i(), var1 - var4 - 8, var2 - var5 - 8);
        }

        GL11.glDisable(32826);
        RenderHelper.func_1159_a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        this.func_587_j();
        if (var12.func_20075_i() == null && var6 != null && var6.func_20005_c()) {
            String var13 = ("" + StringTranslate.func_20162_a().func_20161_b(var6.func_777_b().func_20109_f())).trim();
            if (var13.length() > 0) {
                var9 = var1 - var4 + 12;
                var10 = var2 - var5 - 12;
                int var11 = this.field_6451_g.func_871_a(var13);
                this.func_549_a(var9 - 3, var10 - 3, var9 + var11 + 3, var10 + 8 + 3, -1073741824, -1073741824);
                this.field_6451_g.func_874_a(var13, var9, var10, -1);
            }
        }

        GL11.glPopMatrix();
        super.func_571_a(var1, var2, var3);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    protected void func_587_j() {
    }

    protected abstract void func_589_a(float var1);

    private void func_590_a(Slot var1) {
        int var2 = var1.field_20006_b;
        int var3 = var1.field_20008_c;
        ItemStack var4 = var1.func_777_b();
        if (var4 == null) {
            int var5 = var1.func_775_c();
            if (var5 >= 0) {
                GL11.glDisable(2896);
                this.field_945_b.field_6315_n.func_1076_b(this.field_945_b.field_6315_n.func_1070_a("/gui/items.png"));
                this.func_550_b(var2, var3, var5 % 16 * 16, var5 / 16 * 16, 16, 16);
                GL11.glEnable(2896);
                return;
            }
        }

        field_972_j.func_161_a(this.field_6451_g, this.field_945_b.field_6315_n, var4, var2, var3);
        field_972_j.func_164_b(this.field_6451_g, this.field_945_b.field_6315_n, var4, var2, var3);
    }

    private Slot func_588_a(int var1, int var2) {
        for(int var3 = 0; var3 < this.field_973_i.field_20122_e.size(); ++var3) {
            Slot var4 = (Slot)this.field_973_i.field_20122_e.get(var3);
            if (this.func_20081_a(var4, var1, var2)) {
                return var4;
            }
        }

        return null;
    }

    private boolean func_20081_a(Slot var1, int var2, int var3) {
        int var4 = (this.field_951_c - this.field_971_a) / 2;
        int var5 = (this.field_950_d - this.field_974_h) / 2;
        var2 -= var4;
        var3 -= var5;
        return var2 >= var1.field_20006_b - 1 && var2 < var1.field_20006_b + 16 + 1 && var3 >= var1.field_20008_c - 1 && var3 < var1.field_20008_c + 16 + 1;
    }

    protected void func_565_a(int var1, int var2, int var3) {
        super.func_565_a(var1, var2, var3);
        if (var3 == 0 || var3 == 1) {
            Slot var4 = this.func_588_a(var1, var2);
            int var5 = (this.field_951_c - this.field_971_a) / 2;
            int var6 = (this.field_950_d - this.field_974_h) / 2;
            boolean var7 = var1 < var5 || var2 < var6 || var1 >= var5 + this.field_971_a || var2 >= var6 + this.field_974_h;
            int var8 = -1;
            if (var4 != null) {
                var8 = var4.field_20007_a;
            }

            if (var7) {
                var8 = -999;
            }

            if (var8 != -1) {
                boolean var9 = var8 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                this.field_945_b.field_6327_b.func_27174_a(this.field_973_i.field_1618_c, var8, var3, var9, this.field_945_b.field_6322_g);
            }
        }

    }

    protected void func_573_b(int var1, int var2, int var3) {
        if (var3 == 0) {
        }

    }

    protected void func_580_a(char var1, int var2) {
        if (var2 == 1 || var2 == this.field_945_b.field_6304_y.field_1570_o.field_1370_b) {
            this.field_945_b.field_6322_g.func_20059_m();
        }

    }

    public void func_6449_h() {
        if (this.field_945_b.field_6322_g != null) {
            this.field_945_b.field_6327_b.func_20086_a(this.field_973_i.field_1618_c, this.field_945_b.field_6322_g);
        }
    }

    public boolean func_6450_b() {
        return false;
    }

    public void func_570_g() {
        super.func_570_g();
        if (!this.field_945_b.field_6322_g.func_354_B() || this.field_945_b.field_6322_g.field_646_aA) {
            this.field_945_b.field_6322_g.func_20059_m();
        }

    }
}
