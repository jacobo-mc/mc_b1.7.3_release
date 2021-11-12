package net.minecraft.src;

public class EntityFallingSand extends Entity {
    public int field_427_a;
    public int field_426_b = 0;

    public EntityFallingSand(World var1) {
        super(var1);
    }

    public EntityFallingSand(World var1, double var2, double var4, double var6, int var8) {
        super(var1);
        this.field_427_a = var8;
        this.field_329_e = true;
        this.func_113_a(0.98F, 0.98F);
        this.field_9076_H = this.field_298_E / 2.0F;
        this.func_86_a(var2, var4, var6);
        this.field_319_o = 0.0D;
        this.field_318_p = 0.0D;
        this.field_317_q = 0.0D;
        this.field_9092_m = var2;
        this.field_9091_n = var4;
        this.field_9090_o = var6;
    }

    protected boolean func_25017_l() {
        return false;
    }

    protected void func_21044_a() {
    }

    public boolean func_129_c_() {
        return !this.field_304_B;
    }

    public void func_106_b_() {
        if (this.field_427_a == 0) {
            this.func_118_j();
        } else {
            this.field_9092_m = this.field_322_l;
            this.field_9091_n = this.field_321_m;
            this.field_9090_o = this.field_320_n;
            ++this.field_426_b;
            this.field_318_p -= 0.03999999910593033D;
            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            this.field_319_o *= 0.9800000190734863D;
            this.field_318_p *= 0.9800000190734863D;
            this.field_317_q *= 0.9800000190734863D;
            int var1 = MathHelper.func_584_b(this.field_322_l);
            int var2 = MathHelper.func_584_b(this.field_321_m);
            int var3 = MathHelper.func_584_b(this.field_320_n);
            if (this.field_9093_l.func_444_a(var1, var2, var3) == this.field_427_a) {
                this.field_9093_l.func_508_d(var1, var2, var3, 0);
            }

            if (this.field_9086_A) {
                this.field_319_o *= 0.699999988079071D;
                this.field_317_q *= 0.699999988079071D;
                this.field_318_p *= -0.5D;
                this.func_118_j();
                if ((!this.field_9093_l.func_516_a(this.field_427_a, var1, var2, var3, true, 1) || BlockSand.func_285_g(this.field_9093_l, var1, var2 - 1, var3) || !this.field_9093_l.func_508_d(var1, var2, var3, this.field_427_a)) && !this.field_9093_l.field_792_x) {
                    this.func_128_a(this.field_427_a, 1);
                }
            } else if (this.field_426_b > 100 && !this.field_9093_l.field_792_x) {
                this.func_128_a(this.field_427_a, 1);
                this.func_118_j();
            }

        }
    }

    protected void func_97_a(NBTTagCompound var1) {
        var1.func_409_a("Tile", (byte)this.field_427_a);
    }

    protected void func_99_b(NBTTagCompound var1) {
        this.field_427_a = var1.func_408_b("Tile") & 255;
    }
}
