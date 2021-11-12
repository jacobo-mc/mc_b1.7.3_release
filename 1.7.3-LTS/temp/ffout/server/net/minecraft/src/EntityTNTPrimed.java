package net.minecraft.src;

public class EntityTNTPrimed extends Entity {
    public int field_446_a;

    public EntityTNTPrimed(World var1) {
        super(var1);
        this.field_446_a = 0;
        this.field_329_e = true;
        this.func_113_a(0.98F, 0.98F);
        this.field_9076_H = this.field_298_E / 2.0F;
    }

    public EntityTNTPrimed(World var1, double var2, double var4, double var6) {
        this(var1);
        this.func_86_a(var2, var4, var6);
        float var8 = (float)(Math.random() * 3.1415927410125732D * 2.0D);
        this.field_319_o = (double)(-MathHelper.func_585_a(var8 * 3.1415927F / 180.0F) * 0.02F);
        this.field_318_p = 0.20000000298023224D;
        this.field_317_q = (double)(-MathHelper.func_582_b(var8 * 3.1415927F / 180.0F) * 0.02F);
        this.field_446_a = 80;
        this.field_9092_m = var2;
        this.field_9091_n = var4;
        this.field_9090_o = var6;
    }

    protected void func_21044_a() {
    }

    protected boolean func_25017_l() {
        return false;
    }

    public boolean func_129_c_() {
        return !this.field_304_B;
    }

    public void func_106_b_() {
        this.field_9092_m = this.field_322_l;
        this.field_9091_n = this.field_321_m;
        this.field_9090_o = this.field_320_n;
        this.field_318_p -= 0.03999999910593033D;
        this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
        this.field_319_o *= 0.9800000190734863D;
        this.field_318_p *= 0.9800000190734863D;
        this.field_317_q *= 0.9800000190734863D;
        if (this.field_9086_A) {
            this.field_319_o *= 0.699999988079071D;
            this.field_317_q *= 0.699999988079071D;
            this.field_318_p *= -0.5D;
        }

        if (this.field_446_a-- <= 0) {
            if (!this.field_9093_l.field_792_x) {
                this.func_118_j();
                this.func_178_b();
            } else {
                this.func_118_j();
            }
        } else {
            this.field_9093_l.func_514_a("smoke", this.field_322_l, this.field_321_m + 0.5D, this.field_320_n, 0.0D, 0.0D, 0.0D);
        }

    }

    private void func_178_b() {
        float var1 = 4.0F;
        this.field_9093_l.func_12013_a((Entity)null, this.field_322_l, this.field_321_m, this.field_320_n, var1);
    }

    protected void func_97_a(NBTTagCompound var1) {
        var1.func_409_a("Fuse", (byte)this.field_446_a);
    }

    protected void func_99_b(NBTTagCompound var1) {
        this.field_446_a = var1.func_408_b("Fuse");
    }
}
