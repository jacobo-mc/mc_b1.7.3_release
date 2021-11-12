package net.minecraft.src;

public class EntityItem extends Entity {
    public ItemStack field_801_a;
    private int field_803_e;
    public int field_800_b = 0;
    public int field_805_c;
    private int field_802_f = 5;
    public float field_804_d = (float)(Math.random() * 3.141592653589793D * 2.0D);

    public EntityItem(World var1, double var2, double var4, double var6, ItemStack var8) {
        super(var1);
        this.func_371_a(0.25F, 0.25F);
        this.field_9292_aO = this.field_643_aD / 2.0F;
        this.func_347_a(var2, var4, var6);
        this.field_801_a = var8;
        this.field_605_aq = (float)(Math.random() * 360.0D);
        this.field_608_an = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
        this.field_607_ao = 0.20000000298023224D;
        this.field_606_ap = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
    }

    protected boolean func_25021_m() {
        return false;
    }

    public EntityItem(World var1) {
        super(var1);
        this.func_371_a(0.25F, 0.25F);
        this.field_9292_aO = this.field_643_aD / 2.0F;
    }

    protected void func_21057_b() {
    }

    public void func_370_e_() {
        super.func_370_e_();
        if (this.field_805_c > 0) {
            --this.field_805_c;
        }

        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        this.field_607_ao -= 0.03999999910593033D;
        if (this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) == Material.field_1331_g) {
            this.field_607_ao = 0.20000000298023224D;
            this.field_608_an = (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F);
            this.field_606_ap = (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F);
            this.field_615_ag.func_623_a(this, "random.fizz", 0.4F, 2.0F + this.field_9312_bd.nextFloat() * 0.4F);
        }

        this.func_28014_c(this.field_611_ak, (this.field_601_au.field_1697_b + this.field_601_au.field_1702_e) / 2.0D, this.field_609_am);
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        float var1 = 0.98F;
        if (this.field_9298_aH) {
            var1 = 0.58800006F;
            int var2 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
            if (var2 > 0) {
                var1 = Block.field_345_n[var2].field_355_bo * 0.98F;
            }
        }

        this.field_608_an *= (double)var1;
        this.field_607_ao *= 0.9800000190734863D;
        this.field_606_ap *= (double)var1;
        if (this.field_9298_aH) {
            this.field_607_ao *= -0.5D;
        }

        ++this.field_803_e;
        ++this.field_800_b;
        if (this.field_800_b >= 6000) {
            this.func_395_F();
        }

    }

    public boolean func_397_g_() {
        return this.field_615_ag.func_682_a(this.field_601_au, Material.field_1332_f, this);
    }

    protected void func_355_a(int var1) {
        this.func_396_a((Entity)null, var1);
    }

    public boolean func_396_a(Entity var1, int var2) {
        this.func_9281_M();
        this.field_802_f -= var2;
        if (this.field_802_f <= 0) {
            this.func_395_F();
        }

        return false;
    }

    public void func_352_a(NBTTagCompound var1) {
        var1.func_749_a("Health", (short)((byte)this.field_802_f));
        var1.func_749_a("Age", (short)this.field_800_b);
        var1.func_763_a("Item", this.field_801_a.func_1086_a(new NBTTagCompound()));
    }

    public void func_357_b(NBTTagCompound var1) {
        this.field_802_f = var1.func_745_d("Health") & 255;
        this.field_800_b = var1.func_745_d("Age");
        NBTTagCompound var2 = var1.func_743_k("Item");
        this.field_801_a = new ItemStack(var2);
    }

    public void func_6378_b(EntityPlayer var1) {
        if (!this.field_615_ag.field_1026_y) {
            int var2 = this.field_801_a.field_1615_a;
            if (this.field_805_c == 0 && var1.field_778_b.func_504_a(this.field_801_a)) {
                if (this.field_801_a.field_1617_c == Block.field_385_K.field_376_bc) {
                    var1.func_27026_a(AchievementList.field_25198_c);
                }

                if (this.field_801_a.field_1617_c == Item.field_306_aD.field_291_aS) {
                    var1.func_27026_a(AchievementList.field_27376_t);
                }

                this.field_615_ag.func_623_a(this, "random.pop", 0.2F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                var1.func_443_a_(this, var2);
                if (this.field_801_a.field_1615_a <= 0) {
                    this.func_395_F();
                }
            }

        }
    }
}
