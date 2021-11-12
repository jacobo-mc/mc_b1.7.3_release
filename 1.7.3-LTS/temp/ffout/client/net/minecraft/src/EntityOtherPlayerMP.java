package net.minecraft.src;

public class EntityOtherPlayerMP extends EntityPlayer {
    private int field_785_bg;
    private double field_784_bh;
    private double field_783_bi;
    private double field_782_bj;
    private double field_780_bk;
    private double field_786_bl;
    float field_20924_a = 0.0F;

    public EntityOtherPlayerMP(World var1, String var2) {
        super(var1);
        this.field_771_i = var2;
        this.field_9292_aO = 0.0F;
        this.field_9286_aZ = 0.0F;
        if (var2 != null && var2.length() > 0) {
            this.field_20047_bv = "http://s3.amazonaws.com/MinecraftSkins/" + var2 + ".png";
        }

        this.field_9314_ba = true;
        this.field_22062_y = 0.25F;
        this.field_619_ac = 10.0D;
    }

    protected void func_22058_C() {
        this.field_9292_aO = 0.0F;
    }

    public boolean func_396_a(Entity var1, int var2) {
        return true;
    }

    public void func_378_a(double var1, double var3, double var5, float var7, float var8, int var9) {
        this.field_784_bh = var1;
        this.field_783_bi = var3;
        this.field_782_bj = var5;
        this.field_780_bk = (double)var7;
        this.field_786_bl = (double)var8;
        this.field_785_bg = var9;
    }

    public void func_370_e_() {
        this.field_22062_y = 0.0F;
        super.func_370_e_();
        this.field_705_Q = this.field_704_R;
        double var1 = this.field_611_ak - this.field_9285_at;
        double var3 = this.field_609_am - this.field_9283_av;
        float var5 = MathHelper.func_1109_a(var1 * var1 + var3 * var3) * 4.0F;
        if (var5 > 1.0F) {
            var5 = 1.0F;
        }

        this.field_704_R += (var5 - this.field_704_R) * 0.4F;
        this.field_703_S += this.field_704_R;
    }

    public float func_392_h_() {
        return 0.0F;
    }

    public void func_425_j() {
        super.func_418_b_();
        if (this.field_785_bg > 0) {
            double var1 = this.field_611_ak + (this.field_784_bh - this.field_611_ak) / (double)this.field_785_bg;
            double var3 = this.field_610_al + (this.field_783_bi - this.field_610_al) / (double)this.field_785_bg;
            double var5 = this.field_609_am + (this.field_782_bj - this.field_609_am) / (double)this.field_785_bg;

            double var7;
            for(var7 = this.field_780_bk - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
            }

            while(var7 >= 180.0D) {
                var7 -= 360.0D;
            }

            this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_785_bg);
            this.field_604_ar = (float)((double)this.field_604_ar + (this.field_786_bl - (double)this.field_604_ar) / (double)this.field_785_bg);
            --this.field_785_bg;
            this.func_347_a(var1, var3, var5);
            this.func_376_c(this.field_605_aq, this.field_604_ar);
        }

        this.field_775_e = this.field_774_f;
        float var9 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
        float var2 = (float)Math.atan(-this.field_607_ao * 0.20000000298023224D) * 15.0F;
        if (var9 > 0.1F) {
            var9 = 0.1F;
        }

        if (!this.field_9298_aH || this.field_9337_J <= 0) {
            var9 = 0.0F;
        }

        if (this.field_9298_aH || this.field_9337_J <= 0) {
            var2 = 0.0F;
        }

        this.field_774_f += (var9 - this.field_774_f) * 0.4F;
        this.field_9328_R += (var2 - this.field_9328_R) * 0.8F;
    }

    public void func_20045_c(int var1, int var2, int var3) {
        ItemStack var4 = null;
        if (var2 >= 0) {
            var4 = new ItemStack(var2, 1, var3);
        }

        if (var1 == 0) {
            this.field_778_b.field_843_a[this.field_778_b.field_847_d] = var4;
        } else {
            this.field_778_b.field_842_b[var1 - 1] = var4;
        }

    }

    public void func_6420_o() {
    }
}
