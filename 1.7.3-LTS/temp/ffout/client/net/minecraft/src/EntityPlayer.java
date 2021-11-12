package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public abstract class EntityPlayer extends EntityLiving {
    public InventoryPlayer field_778_b = new InventoryPlayer(this);
    public Container field_20069_g;
    public Container field_20068_h;
    public byte field_9371_f = 0;
    public int field_9370_g = 0;
    public float field_775_e;
    public float field_774_f;
    public boolean field_9369_j = false;
    public int field_9368_k = 0;
    public String field_771_i;
    public int field_4129_m;
    public String field_20067_q;
    public double field_20066_r;
    public double field_20065_s;
    public double field_20064_t;
    public double field_20063_u;
    public double field_20062_v;
    public double field_20061_w;
    protected boolean field_21901_a;
    public ChunkCoordinates field_21908_b;
    private int field_21907_c;
    public float field_22063_x;
    public float field_22062_y;
    public float field_22061_z;
    private ChunkCoordinates field_24900_bi;
    private ChunkCoordinates field_26907_d;
    public int field_28024_y = 20;
    protected boolean field_28023_z = false;
    public float field_28026_A;
    public float field_28025_B;
    private int field_781_a = 0;
    public EntityFish field_4128_n = null;

    public EntityPlayer(World var1) {
        super(var1);
        this.field_20069_g = new ContainerPlayer(this.field_778_b, !var1.field_1026_y);
        this.field_20068_h = this.field_20069_g;
        this.field_9292_aO = 1.62F;
        ChunkCoordinates var2 = var1.func_22137_s();
        this.func_365_c((double)var2.field_22395_a + 0.5D, (double)(var2.field_22394_b + 1), (double)var2.field_22396_c + 0.5D, 0.0F, 0.0F);
        this.field_9337_J = 20;
        this.field_9351_C = "humanoid";
        this.field_9353_B = 180.0F;
        this.field_9310_bf = 20;
        this.field_9357_z = "/mob/char.png";
    }

    protected void func_21057_b() {
        super.func_21057_b();
        this.field_21064_bx.func_21124_a(16, (byte)0);
    }

    public void func_370_e_() {
        if (this.func_22051_K()) {
            ++this.field_21907_c;
            if (this.field_21907_c > 100) {
                this.field_21907_c = 100;
            }

            if (!this.field_615_ag.field_1026_y) {
                if (!this.func_22057_q()) {
                    this.func_22056_a(true, true, false);
                } else if (this.field_615_ag.func_624_b()) {
                    this.func_22056_a(false, true, true);
                }
            }
        } else if (this.field_21907_c > 0) {
            ++this.field_21907_c;
            if (this.field_21907_c >= 110) {
                this.field_21907_c = 0;
            }
        }

        super.func_370_e_();
        if (!this.field_615_ag.field_1026_y && this.field_20068_h != null && !this.field_20068_h.func_20120_b(this)) {
            this.func_20059_m();
            this.field_20068_h = this.field_20069_g;
        }

        this.field_20066_r = this.field_20063_u;
        this.field_20065_s = this.field_20062_v;
        this.field_20064_t = this.field_20061_w;
        double var1 = this.field_611_ak - this.field_20063_u;
        double var3 = this.field_610_al - this.field_20062_v;
        double var5 = this.field_609_am - this.field_20061_w;
        double var7 = 10.0D;
        if (var1 > var7) {
            this.field_20066_r = this.field_20063_u = this.field_611_ak;
        }

        if (var5 > var7) {
            this.field_20064_t = this.field_20061_w = this.field_609_am;
        }

        if (var3 > var7) {
            this.field_20065_s = this.field_20062_v = this.field_610_al;
        }

        if (var1 < -var7) {
            this.field_20066_r = this.field_20063_u = this.field_611_ak;
        }

        if (var5 < -var7) {
            this.field_20064_t = this.field_20061_w = this.field_609_am;
        }

        if (var3 < -var7) {
            this.field_20065_s = this.field_20062_v = this.field_610_al;
        }

        this.field_20063_u += var1 * 0.25D;
        this.field_20061_w += var5 * 0.25D;
        this.field_20062_v += var3 * 0.25D;
        this.func_25058_a(StatList.field_25179_j, 1);
        if (this.field_616_af == null) {
            this.field_26907_d = null;
        }

    }

    protected boolean func_22049_v() {
        return this.field_9337_J <= 0 || this.func_22051_K();
    }

    protected void func_20059_m() {
        this.field_20068_h = this.field_20069_g;
    }

    public void func_20046_s() {
        this.field_20067_q = "http://s3.amazonaws.com/MinecraftCloaks/" + this.field_771_i + ".png";
        this.field_622_aY = this.field_20067_q;
    }

    public void func_350_p() {
        double var1 = this.field_611_ak;
        double var3 = this.field_610_al;
        double var5 = this.field_609_am;
        super.func_350_p();
        this.field_775_e = this.field_774_f;
        this.field_774_f = 0.0F;
        this.func_27024_i(this.field_611_ak - var1, this.field_610_al - var3, this.field_609_am - var5);
    }

    public void func_374_q() {
        this.field_9292_aO = 1.62F;
        this.func_371_a(0.6F, 1.8F);
        super.func_374_q();
        this.field_9337_J = 20;
        this.field_712_J = 0;
    }

    protected void func_418_b_() {
        if (this.field_9369_j) {
            ++this.field_9368_k;
            if (this.field_9368_k >= 8) {
                this.field_9368_k = 0;
                this.field_9369_j = false;
            }
        } else {
            this.field_9368_k = 0;
        }

        this.field_9339_I = (float)this.field_9368_k / 8.0F;
    }

    public void func_425_j() {
        if (this.field_615_ag.field_1039_l == 0 && this.field_9337_J < 20 && this.field_9311_be % 20 * 12 == 0) {
            this.func_432_b(1);
        }

        this.field_778_b.func_511_b();
        this.field_775_e = this.field_774_f;
        super.func_425_j();
        float var1 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
        float var2 = (float)Math.atan(-this.field_607_ao * 0.20000000298023224D) * 15.0F;
        if (var1 > 0.1F) {
            var1 = 0.1F;
        }

        if (!this.field_9298_aH || this.field_9337_J <= 0) {
            var1 = 0.0F;
        }

        if (this.field_9298_aH || this.field_9337_J <= 0) {
            var2 = 0.0F;
        }

        this.field_774_f += (var1 - this.field_774_f) * 0.4F;
        this.field_9328_R += (var2 - this.field_9328_R) * 0.8F;
        if (this.field_9337_J > 0) {
            List var3 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(1.0D, 0.0D, 1.0D));
            if (var3 != null) {
                for(int var4 = 0; var4 < var3.size(); ++var4) {
                    Entity var5 = (Entity)var3.get(var4);
                    if (!var5.field_646_aA) {
                        this.func_451_h(var5);
                    }
                }
            }
        }

    }

    private void func_451_h(Entity var1) {
        var1.func_6378_b(this);
    }

    public int func_6417_t() {
        return this.field_9370_g;
    }

    public void func_419_b(Entity var1) {
        super.func_419_b(var1);
        this.func_371_a(0.2F, 0.2F);
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
        this.field_607_ao = 0.10000000149011612D;
        if (this.field_771_i.equals("Notch")) {
            this.func_444_a(new ItemStack(Item.field_228_h, 1), true);
        }

        this.field_778_b.func_503_g();
        if (var1 != null) {
            this.field_608_an = (double)(-MathHelper.func_1114_b((this.field_9331_N + this.field_605_aq) * 3.1415927F / 180.0F) * 0.1F);
            this.field_606_ap = (double)(-MathHelper.func_1106_a((this.field_9331_N + this.field_605_aq) * 3.1415927F / 180.0F) * 0.1F);
        } else {
            this.field_608_an = this.field_606_ap = 0.0D;
        }

        this.field_9292_aO = 0.1F;
        this.func_25058_a(StatList.field_25163_u, 1);
    }

    public void func_364_b(Entity var1, int var2) {
        this.field_9370_g += var2;
        if (var1 instanceof EntityPlayer) {
            this.func_25058_a(StatList.field_25161_w, 1);
        } else {
            this.func_25058_a(StatList.field_25162_v, 1);
        }

    }

    public void func_20060_w() {
        this.func_444_a(this.field_778_b.func_473_a(this.field_778_b.field_847_d, 1), false);
    }

    public void func_449_a(ItemStack var1) {
        this.func_444_a(var1, false);
    }

    public void func_444_a(ItemStack var1, boolean var2) {
        if (var1 != null) {
            EntityItem var3 = new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al - 0.30000001192092896D + (double)this.func_373_s(), this.field_609_am, var1);
            var3.field_805_c = 40;
            float var4 = 0.1F;
            float var5;
            if (var2) {
                var5 = this.field_9312_bd.nextFloat() * 0.5F;
                float var6 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
                var3.field_608_an = (double)(-MathHelper.func_1106_a(var6) * var5);
                var3.field_606_ap = (double)(MathHelper.func_1114_b(var6) * var5);
                var3.field_607_ao = 0.20000000298023224D;
            } else {
                var4 = 0.3F;
                var3.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var4);
                var3.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var4);
                var3.field_607_ao = (double)(-MathHelper.func_1106_a(this.field_604_ar / 180.0F * 3.1415927F) * var4 + 0.1F);
                var4 = 0.02F;
                var5 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
                var4 *= this.field_9312_bd.nextFloat();
                var3.field_608_an += Math.cos((double)var5) * (double)var4;
                var3.field_607_ao += (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.1F);
                var3.field_606_ap += Math.sin((double)var5) * (double)var4;
            }

            this.func_446_a(var3);
            this.func_25058_a(StatList.field_25168_r, 1);
        }
    }

    protected void func_446_a(EntityItem var1) {
        this.field_615_ag.func_674_a(var1);
    }

    public float func_450_a(Block var1) {
        float var2 = this.field_778_b.func_508_a(var1);
        if (this.func_393_a(Material.field_1332_f)) {
            var2 /= 5.0F;
        }

        if (!this.field_9298_aH) {
            var2 /= 5.0F;
        }

        return var2;
    }

    public boolean func_454_b(Block var1) {
        return this.field_778_b.func_509_b(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        NBTTagList var2 = var1.func_753_l("Inventory");
        this.field_778_b.func_513_b(var2);
        this.field_4129_m = var1.func_756_e("Dimension");
        this.field_21901_a = var1.func_760_m("Sleeping");
        this.field_21907_c = var1.func_745_d("SleepTimer");
        if (this.field_21901_a) {
            this.field_21908_b = new ChunkCoordinates(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
            this.func_22056_a(true, true, false);
        }

        if (var1.func_751_b("SpawnX") && var1.func_751_b("SpawnY") && var1.func_751_b("SpawnZ")) {
            this.field_24900_bi = new ChunkCoordinates(var1.func_756_e("SpawnX"), var1.func_756_e("SpawnY"), var1.func_756_e("SpawnZ"));
        }

    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_762_a("Inventory", this.field_778_b.func_493_a(new NBTTagList()));
        var1.func_758_a("Dimension", this.field_4129_m);
        var1.func_748_a("Sleeping", this.field_21901_a);
        var1.func_749_a("SleepTimer", (short)this.field_21907_c);
        if (this.field_24900_bi != null) {
            var1.func_758_a("SpawnX", this.field_24900_bi.field_22395_a);
            var1.func_758_a("SpawnY", this.field_24900_bi.field_22394_b);
            var1.func_758_a("SpawnZ", this.field_24900_bi.field_22396_c);
        }

    }

    public void func_452_a(IInventory var1) {
    }

    public void func_445_l(int var1, int var2, int var3) {
    }

    public void func_443_a_(Entity var1, int var2) {
    }

    public float func_373_s() {
        return 0.12F;
    }

    protected void func_22058_C() {
        this.field_9292_aO = 1.62F;
    }

    public boolean func_396_a(Entity var1, int var2) {
        this.field_9344_ag = 0;
        if (this.field_9337_J <= 0) {
            return false;
        } else {
            if (this.func_22051_K() && !this.field_615_ag.field_1026_y) {
                this.func_22056_a(true, true, false);
            }

            if (var1 instanceof EntityMob || var1 instanceof EntityArrow) {
                if (this.field_615_ag.field_1039_l == 0) {
                    var2 = 0;
                }

                if (this.field_615_ag.field_1039_l == 1) {
                    var2 = var2 / 3 + 1;
                }

                if (this.field_615_ag.field_1039_l == 3) {
                    var2 = var2 * 3 / 2;
                }
            }

            if (var2 == 0) {
                return false;
            } else {
                Object var3 = var1;
                if (var1 instanceof EntityArrow && ((EntityArrow)var1).field_682_g != null) {
                    var3 = ((EntityArrow)var1).field_682_g;
                }

                if (var3 instanceof EntityLiving) {
                    this.func_25055_a((EntityLiving)var3, false);
                }

                this.func_25058_a(StatList.field_25165_t, var2);
                return super.func_396_a(var1, var2);
            }
        }
    }

    protected boolean func_27025_G() {
        return false;
    }

    protected void func_25055_a(EntityLiving var1, boolean var2) {
        if (!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
            if (var1 instanceof EntityWolf) {
                EntityWolf var3 = (EntityWolf)var1;
                if (var3.func_25047_D() && this.field_771_i.equals(var3.func_25045_A())) {
                    return;
                }
            }

            if (!(var1 instanceof EntityPlayer) || this.func_27025_G()) {
                List var7 = this.field_615_ag.func_657_a(EntityWolf.class, AxisAlignedBB.func_1161_b(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_611_ak + 1.0D, this.field_610_al + 1.0D, this.field_609_am + 1.0D).func_1177_b(16.0D, 4.0D, 16.0D));
                Iterator var4 = var7.iterator();

                while(true) {
                    EntityWolf var6;
                    do {
                        do {
                            do {
                                do {
                                    if (!var4.hasNext()) {
                                        return;
                                    }

                                    Entity var5 = (Entity)var4.next();
                                    var6 = (EntityWolf)var5;
                                } while(!var6.func_25047_D());
                            } while(var6.func_25030_F() != null);
                        } while(!this.field_771_i.equals(var6.func_25045_A()));
                    } while(var2 && var6.func_25034_B());

                    var6.func_25046_b(false);
                    var6.func_25032_c(var1);
                }
            }
        }
    }

    protected void func_4044_a(int var1) {
        int var2 = 25 - this.field_778_b.func_506_f();
        int var3 = var1 * var2 + this.field_781_a;
        this.field_778_b.func_507_e(var1);
        var1 = var3 / 25;
        this.field_781_a = var3 % 25;
        super.func_4044_a(var1);
    }

    public void func_453_a(TileEntityFurnace var1) {
    }

    public void func_21092_a(TileEntityDispenser var1) {
    }

    public void func_4052_a(TileEntitySign var1) {
    }

    public void func_6415_a_(Entity var1) {
        if (!var1.func_353_a(this)) {
            ItemStack var2 = this.func_6416_v();
            if (var2 != null && var1 instanceof EntityLiving) {
                var2.func_1100_b((EntityLiving)var1);
                if (var2.field_1615_a <= 0) {
                    var2.func_1097_a(this);
                    this.func_448_u();
                }
            }

        }
    }

    public ItemStack func_6416_v() {
        return this.field_778_b.func_494_a();
    }

    public void func_448_u() {
        this.field_778_b.func_472_a(this.field_778_b.field_847_d, (ItemStack)null);
    }

    public double func_388_v() {
        return (double)(this.field_9292_aO - 0.5F);
    }

    public void func_457_w() {
        this.field_9368_k = -1;
        this.field_9369_j = true;
    }

    public void func_463_a(Entity var1) {
        int var2 = this.field_778_b.func_502_a(var1);
        if (var2 > 0) {
            if (this.field_607_ao < 0.0D) {
                ++var2;
            }

            var1.func_396_a(this, var2);
            ItemStack var3 = this.func_6416_v();
            if (var3 != null && var1 instanceof EntityLiving) {
                var3.func_1092_a((EntityLiving)var1, this);
                if (var3.field_1615_a <= 0) {
                    var3.func_1097_a(this);
                    this.func_448_u();
                }
            }

            if (var1 instanceof EntityLiving) {
                if (var1.func_354_B()) {
                    this.func_25055_a((EntityLiving)var1, true);
                }

                this.func_25058_a(StatList.field_25167_s, var2);
            }
        }

    }

    public void func_9367_r() {
    }

    public abstract void func_6420_o();

    public void func_20058_b(ItemStack var1) {
    }

    public void func_395_F() {
        super.func_395_F();
        this.field_20069_g.func_1104_a(this);
        if (this.field_20068_h != null) {
            this.field_20068_h.func_1104_a(this);
        }

    }

    public boolean func_345_I() {
        return !this.field_21901_a && super.func_345_I();
    }

    public EnumStatus func_22053_b(int var1, int var2, int var3) {
        if (!this.field_615_ag.field_1026_y) {
            label53: {
                if (!this.func_22051_K() && this.func_354_B()) {
                    if (this.field_615_ag.field_4209_q.field_4220_c) {
                        return EnumStatus.NOT_POSSIBLE_HERE;
                    }

                    if (this.field_615_ag.func_624_b()) {
                        return EnumStatus.NOT_POSSIBLE_NOW;
                    }

                    if (Math.abs(this.field_611_ak - (double)var1) <= 3.0D && Math.abs(this.field_610_al - (double)var2) <= 2.0D && Math.abs(this.field_609_am - (double)var3) <= 3.0D) {
                        break label53;
                    }

                    return EnumStatus.TOO_FAR_AWAY;
                }

                return EnumStatus.OTHER_PROBLEM;
            }
        }

        this.func_371_a(0.2F, 0.2F);
        this.field_9292_aO = 0.2F;
        if (this.field_615_ag.func_630_d(var1, var2, var3)) {
            int var4 = this.field_615_ag.func_602_e(var1, var2, var3);
            int var5 = BlockBed.func_22030_c(var4);
            float var6 = 0.5F;
            float var7 = 0.5F;
            switch(var5) {
            case 0:
                var7 = 0.9F;
                break;
            case 1:
                var6 = 0.1F;
                break;
            case 2:
                var7 = 0.1F;
                break;
            case 3:
                var6 = 0.9F;
            }

            this.func_22052_e(var5);
            this.func_347_a((double)((float)var1 + var6), (double)((float)var2 + 0.9375F), (double)((float)var3 + var7));
        } else {
            this.func_347_a((double)((float)var1 + 0.5F), (double)((float)var2 + 0.9375F), (double)((float)var3 + 0.5F));
        }

        this.field_21901_a = true;
        this.field_21907_c = 0;
        this.field_21908_b = new ChunkCoordinates(var1, var2, var3);
        this.field_608_an = this.field_606_ap = this.field_607_ao = 0.0D;
        if (!this.field_615_ag.field_1026_y) {
            this.field_615_ag.func_22140_w();
        }

        return EnumStatus.OK;
    }

    private void func_22052_e(int var1) {
        this.field_22063_x = 0.0F;
        this.field_22061_z = 0.0F;
        switch(var1) {
        case 0:
            this.field_22061_z = -1.8F;
            break;
        case 1:
            this.field_22063_x = 1.8F;
            break;
        case 2:
            this.field_22061_z = 1.8F;
            break;
        case 3:
            this.field_22063_x = -1.8F;
        }

    }

    public void func_22056_a(boolean var1, boolean var2, boolean var3) {
        this.func_371_a(0.6F, 1.8F);
        this.func_22058_C();
        ChunkCoordinates var4 = this.field_21908_b;
        ChunkCoordinates var5 = this.field_21908_b;
        if (var4 != null && this.field_615_ag.func_600_a(var4.field_22395_a, var4.field_22394_b, var4.field_22396_c) == Block.field_9262_S.field_376_bc) {
            BlockBed.func_22031_a(this.field_615_ag, var4.field_22395_a, var4.field_22394_b, var4.field_22396_c, false);
            var5 = BlockBed.func_22028_g(this.field_615_ag, var4.field_22395_a, var4.field_22394_b, var4.field_22396_c, 0);
            if (var5 == null) {
                var5 = new ChunkCoordinates(var4.field_22395_a, var4.field_22394_b + 1, var4.field_22396_c);
            }

            this.func_347_a((double)((float)var5.field_22395_a + 0.5F), (double)((float)var5.field_22394_b + this.field_9292_aO + 0.1F), (double)((float)var5.field_22396_c + 0.5F));
        }

        this.field_21901_a = false;
        if (!this.field_615_ag.field_1026_y && var2) {
            this.field_615_ag.func_22140_w();
        }

        if (var1) {
            this.field_21907_c = 0;
        } else {
            this.field_21907_c = 100;
        }

        if (var3) {
            this.func_25061_a(this.field_21908_b);
        }

    }

    private boolean func_22057_q() {
        return this.field_615_ag.func_600_a(this.field_21908_b.field_22395_a, this.field_21908_b.field_22394_b, this.field_21908_b.field_22396_c) == Block.field_9262_S.field_376_bc;
    }

    public static ChunkCoordinates func_25060_a(World var0, ChunkCoordinates var1) {
        IChunkProvider var2 = var0.func_21118_q();
        var2.func_538_d(var1.field_22395_a - 3 >> 4, var1.field_22396_c - 3 >> 4);
        var2.func_538_d(var1.field_22395_a + 3 >> 4, var1.field_22396_c - 3 >> 4);
        var2.func_538_d(var1.field_22395_a - 3 >> 4, var1.field_22396_c + 3 >> 4);
        var2.func_538_d(var1.field_22395_a + 3 >> 4, var1.field_22396_c + 3 >> 4);
        if (var0.func_600_a(var1.field_22395_a, var1.field_22394_b, var1.field_22396_c) != Block.field_9262_S.field_376_bc) {
            return null;
        } else {
            ChunkCoordinates var3 = BlockBed.func_22028_g(var0, var1.field_22395_a, var1.field_22394_b, var1.field_22396_c, 0);
            return var3;
        }
    }

    public float func_22059_J() {
        if (this.field_21908_b != null) {
            int var1 = this.field_615_ag.func_602_e(this.field_21908_b.field_22395_a, this.field_21908_b.field_22394_b, this.field_21908_b.field_22396_c);
            int var2 = BlockBed.func_22030_c(var1);
            switch(var2) {
            case 0:
                return 90.0F;
            case 1:
                return 0.0F;
            case 2:
                return 270.0F;
            case 3:
                return 180.0F;
            }
        }

        return 0.0F;
    }

    public boolean func_22051_K() {
        return this.field_21901_a;
    }

    public boolean func_22054_L() {
        return this.field_21901_a && this.field_21907_c >= 100;
    }

    public int func_22060_M() {
        return this.field_21907_c;
    }

    public void func_22055_b(String var1) {
    }

    public ChunkCoordinates func_25059_P() {
        return this.field_24900_bi;
    }

    public void func_25061_a(ChunkCoordinates var1) {
        if (var1 != null) {
            this.field_24900_bi = new ChunkCoordinates(var1);
        } else {
            this.field_24900_bi = null;
        }

    }

    public void func_27026_a(StatBase var1) {
        this.func_25058_a(var1, 1);
    }

    public void func_25058_a(StatBase var1, int var2) {
    }

    protected void func_424_C() {
        super.func_424_C();
        this.func_25058_a(StatList.field_25171_q, 1);
    }

    public void func_435_b(float var1, float var2) {
        double var3 = this.field_611_ak;
        double var5 = this.field_610_al;
        double var7 = this.field_609_am;
        super.func_435_b(var1, var2);
        this.func_25056_h(this.field_611_ak - var3, this.field_610_al - var5, this.field_609_am - var7);
    }

    private void func_25056_h(double var1, double var3, double var5) {
        if (this.field_616_af == null) {
            int var7;
            if (this.func_393_a(Material.field_1332_f)) {
                var7 = Math.round(MathHelper.func_1109_a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.func_25058_a(StatList.field_25173_p, var7);
                }
            } else if (this.func_27013_ag()) {
                var7 = Math.round(MathHelper.func_1109_a(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.func_25058_a(StatList.field_25177_l, var7);
                }
            } else if (this.func_429_A()) {
                if (var3 > 0.0D) {
                    this.func_25058_a(StatList.field_25175_n, (int)Math.round(var3 * 100.0D));
                }
            } else if (this.field_9298_aH) {
                var7 = Math.round(MathHelper.func_1109_a(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.func_25058_a(StatList.field_25178_k, var7);
                }
            } else {
                var7 = Math.round(MathHelper.func_1109_a(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 25) {
                    this.func_25058_a(StatList.field_25174_o, var7);
                }
            }

        }
    }

    private void func_27024_i(double var1, double var3, double var5) {
        if (this.field_616_af != null) {
            int var7 = Math.round(MathHelper.func_1109_a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
            if (var7 > 0) {
                if (this.field_616_af instanceof EntityMinecart) {
                    this.func_25058_a(StatList.field_27364_r, var7);
                    if (this.field_26907_d == null) {
                        this.field_26907_d = new ChunkCoordinates(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
                    } else if (this.field_26907_d.func_27439_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) >= 1000.0D) {
                        this.func_25058_a(AchievementList.field_27379_q, 1);
                    }
                } else if (this.field_616_af instanceof EntityBoat) {
                    this.func_25058_a(StatList.field_27363_s, var7);
                } else if (this.field_616_af instanceof EntityPig) {
                    this.func_25058_a(StatList.field_27362_t, var7);
                }
            }
        }

    }

    protected void func_400_c(float var1) {
        if (var1 >= 2.0F) {
            this.func_25058_a(StatList.field_25176_m, (int)Math.round((double)var1 * 100.0D));
        }

        super.func_400_c(var1);
    }

    public void func_27015_a(EntityLiving var1) {
        if (var1 instanceof EntityMob) {
            this.func_27026_a(AchievementList.field_27377_s);
        }

    }

    public int func_28021_c(ItemStack var1) {
        int var2 = super.func_28021_c(var1);
        if (var1.field_1617_c == Item.field_4024_aP.field_291_aS && this.field_4128_n != null) {
            var2 = var1.func_1088_b() + 16;
        }

        return var2;
    }

    public void func_4039_q() {
        if (this.field_28024_y > 0) {
            this.field_28024_y = 10;
        } else {
            this.field_28023_z = true;
        }
    }
}
