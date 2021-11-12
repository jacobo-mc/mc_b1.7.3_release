package net.minecraft.src;

public class EntityItem extends Entity {
    public ItemStack field_429_a;
    private int field_9170_e;
    public int field_9169_b = 0;
    public int field_433_ad;
    private int field_430_ag = 5;
    public float field_432_ae = (float)(Math.random() * 3.141592653589793D * 2.0D);

    public EntityItem(World var1, double var2, double var4, double var6, ItemStack var8) {
        super(var1);
        this.func_113_a(0.25F, 0.25F);
        this.field_9076_H = this.field_298_E / 2.0F;
        this.func_86_a(var2, var4, var6);
        this.field_429_a = var8;
        this.field_316_r = (float)(Math.random() * 360.0D);
        this.field_319_o = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.field_318_p = 0.20000000298023224D;
        this.field_317_q = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
    }

    protected boolean func_25017_l() {
        return false;
    }

    public EntityItem(World var1) {
        super(var1);
        this.func_113_a(0.25F, 0.25F);
        this.field_9076_H = this.field_298_E / 2.0F;
    }

    protected void func_21044_a() {
    }

    public void func_106_b_() {
        super.func_106_b_();
        if (this.field_433_ad > 0) {
            --this.field_433_ad;
        }

        this.field_9092_m = this.field_322_l;
        this.field_9091_n = this.field_321_m;
        this.field_9090_o = this.field_320_n;
        this.field_318_p -= 0.03999999910593033D;
        if (this.field_9093_l.func_443_c(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n)) == Material.field_520_g) {
            this.field_318_p = 0.20000000298023224D;
            this.field_319_o = (double)((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F);
            this.field_317_q = (double)((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F);
            this.field_9093_l.func_506_a(this, "random.fizz", 0.4F, 2.0F + this.field_9064_W.nextFloat() * 0.4F);
        }

        this.func_28005_g(this.field_322_l, (this.field_312_v.field_963_b + this.field_312_v.field_968_e) / 2.0D, this.field_320_n);
        this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
        float var1 = 0.98F;
        if (this.field_9086_A) {
            var1 = 0.58800006F;
            int var2 = this.field_9093_l.func_444_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_312_v.field_963_b) - 1, MathHelper.func_584_b(this.field_320_n));
            if (var2 > 0) {
                var1 = Block.field_542_n[var2].field_552_bo * 0.98F;
            }
        }

        this.field_319_o *= (double)var1;
        this.field_318_p *= 0.9800000190734863D;
        this.field_317_q *= (double)var1;
        if (this.field_9086_A) {
            this.field_318_p *= -0.5D;
        }

        ++this.field_9170_e;
        ++this.field_9169_b;
        if (this.field_9169_b >= 6000) {
            this.func_118_j();
        }

    }

    public boolean func_119_o() {
        return this.field_9093_l.func_490_a(this.field_312_v, Material.field_521_f, this);
    }

    protected void func_125_b(int var1) {
        this.func_121_a((Entity)null, var1);
    }

    public boolean func_121_a(Entity var1, int var2) {
        this.func_9060_u();
        this.field_430_ag -= var2;
        if (this.field_430_ag <= 0) {
            this.func_118_j();
        }

        return false;
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_394_a("Health", (short)((byte)this.field_430_ag));
        var1.func_394_a("Age", (short)this.field_9169_b);
        var1.func_392_a("Item", this.field_429_a.func_570_a(new NBTTagCompound()));
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_430_ag = var1.func_406_c("Health") & 255;
        this.field_9169_b = var1.func_406_c("Age");
        NBTTagCompound var2 = var1.func_397_j("Item");
        this.field_429_a = new ItemStack(var2);
    }

    public void func_6093_b(EntityPlayer var1) {
        if (!this.field_9093_l.field_792_x) {
            int var2 = this.field_429_a.field_853_a;
            if (this.field_433_ad == 0 && var1.field_416_aj.func_201_a(this.field_429_a)) {
                if (this.field_429_a.field_855_c == Block.field_582_K.field_573_bc) {
                    var1.func_27017_a(AchievementList.field_25131_c);
                }

                if (this.field_429_a.field_855_c == Item.field_249_aD.field_234_aS) {
                    var1.func_27017_a(AchievementList.field_27099_t);
                }

                this.field_9093_l.func_506_a(this, "random.pop", 0.2F, ((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                var1.func_163_c(this, var2);
                if (this.field_429_a.field_853_a <= 0) {
                    this.func_118_j();
                }
            }

        }
    }
}
