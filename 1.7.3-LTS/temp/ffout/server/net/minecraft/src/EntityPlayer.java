package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public abstract class EntityPlayer extends EntityLiving {
    public InventoryPlayer field_416_aj = new InventoryPlayer(this);
    public Container field_20053_ao;
    public Container field_20052_ap;
    public byte field_9152_am = 0;
    public int field_9151_an = 0;
    public float field_9150_ao;
    public float field_9149_ap;
    public boolean field_9148_aq = false;
    public int field_9147_ar = 0;
    public String field_409_aq;
    public int field_4110_as;
    public double field_20047_ay;
    public double field_20046_az;
    public double field_20051_aA;
    public double field_20050_aB;
    public double field_20049_aC;
    public double field_20048_aD;
    protected boolean field_21900_a;
    public ChunkCoordinates field_21901_b;
    private int field_21902_c;
    public float field_22066_z;
    public float field_22067_A;
    private ChunkCoordinates field_24900_d;
    private ChunkCoordinates field_27995_d;
    public int field_28016_C = 20;
    protected boolean field_28015_D = false;
    public float field_28014_E;
    private int field_421_a = 0;
    public EntityFish field_6124_at = null;

    public EntityPlayer(World var1) {
        super(var1);
        this.field_20053_ao = new ContainerPlayer(this.field_416_aj, !var1.field_792_x);
        this.field_20052_ap = this.field_20053_ao;
        this.field_9076_H = 1.62F;
        ChunkCoordinates var2 = var1.func_22078_l();
        this.func_107_c((double)var2.field_22216_a + 0.5D, (double)(var2.field_529_a + 1), (double)var2.field_528_b + 0.5D, 0.0F, 0.0F);
        this.field_9109_aQ = 20;
        this.field_9116_aJ = "humanoid";
        this.field_9117_aI = 180.0F;
        this.field_9062_Y = 20;
        this.field_9119_aG = "/mob/char.png";
    }

    protected void func_21044_a() {
        super.func_21044_a();
        this.field_21045_af.func_21153_a(16, (byte)0);
    }

    public void func_106_b_() {
        if (this.func_22057_E()) {
            ++this.field_21902_c;
            if (this.field_21902_c > 100) {
                this.field_21902_c = 100;
            }

            if (!this.field_9093_l.field_792_x) {
                if (!this.func_22063_l()) {
                    this.func_22062_a(true, true, false);
                } else if (this.field_9093_l.func_453_a()) {
                    this.func_22062_a(false, true, true);
                }
            }
        } else if (this.field_21902_c > 0) {
            ++this.field_21902_c;
            if (this.field_21902_c >= 110) {
                this.field_21902_c = 0;
            }
        }

        super.func_106_b_();
        if (!this.field_9093_l.field_792_x && this.field_20052_ap != null && !this.field_20052_ap.func_20126_b(this)) {
            this.func_20043_I();
            this.field_20052_ap = this.field_20053_ao;
        }

        this.field_20047_ay = this.field_20050_aB;
        this.field_20046_az = this.field_20049_aC;
        this.field_20051_aA = this.field_20048_aD;
        double var1 = this.field_322_l - this.field_20050_aB;
        double var3 = this.field_321_m - this.field_20049_aC;
        double var5 = this.field_320_n - this.field_20048_aD;
        double var7 = 10.0D;
        if (var1 > var7) {
            this.field_20047_ay = this.field_20050_aB = this.field_322_l;
        }

        if (var5 > var7) {
            this.field_20051_aA = this.field_20048_aD = this.field_320_n;
        }

        if (var3 > var7) {
            this.field_20046_az = this.field_20049_aC = this.field_321_m;
        }

        if (var1 < -var7) {
            this.field_20047_ay = this.field_20050_aB = this.field_322_l;
        }

        if (var5 < -var7) {
            this.field_20051_aA = this.field_20048_aD = this.field_320_n;
        }

        if (var3 < -var7) {
            this.field_20046_az = this.field_20049_aC = this.field_321_m;
        }

        this.field_20050_aB += var1 * 0.25D;
        this.field_20048_aD += var5 * 0.25D;
        this.field_20049_aC += var3 * 0.25D;
        this.func_25046_a(StatList.field_25114_j, 1);
        if (this.field_327_g == null) {
            this.field_27995_d = null;
        }

    }

    protected boolean func_22058_w() {
        return this.field_9109_aQ <= 0 || this.func_22057_E();
    }

    protected void func_20043_I() {
        this.field_20052_ap = this.field_20053_ao;
    }

    public void func_115_v() {
        double var1 = this.field_322_l;
        double var3 = this.field_321_m;
        double var5 = this.field_320_n;
        super.func_115_v();
        this.field_9150_ao = this.field_9149_ap;
        this.field_9149_ap = 0.0F;
        this.func_27015_h(this.field_322_l - var1, this.field_321_m - var3, this.field_320_n - var5);
    }

    protected void func_152_d_() {
        if (this.field_9148_aq) {
            ++this.field_9147_ar;
            if (this.field_9147_ar >= 8) {
                this.field_9147_ar = 0;
                this.field_9148_aq = false;
            }
        } else {
            this.field_9147_ar = 0;
        }

        this.field_9110_aP = (float)this.field_9147_ar / 8.0F;
    }

    public void func_153_y() {
        if (this.field_9093_l.field_804_l == 0 && this.field_9109_aQ < 20 && this.field_9063_X % 20 * 12 == 0) {
            this.func_137_a(1);
        }

        this.field_416_aj.func_210_c();
        this.field_9150_ao = this.field_9149_ap;
        super.func_153_y();
        float var1 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
        float var2 = (float)Math.atan(-this.field_318_p * 0.20000000298023224D) * 15.0F;
        if (var1 > 0.1F) {
            var1 = 0.1F;
        }

        if (!this.field_9086_A || this.field_9109_aQ <= 0) {
            var1 = 0.0F;
        }

        if (this.field_9086_A || this.field_9109_aQ <= 0) {
            var2 = 0.0F;
        }

        this.field_9149_ap += (var1 - this.field_9149_ap) * 0.4F;
        this.field_9101_aY += (var2 - this.field_9101_aY) * 0.8F;
        if (this.field_9109_aQ > 0) {
            List var3 = this.field_9093_l.func_450_b(this, this.field_312_v.func_708_b(1.0D, 0.0D, 1.0D));
            if (var3 != null) {
                for(int var4 = 0; var4 < var3.size(); ++var4) {
                    Entity var5 = (Entity)var3.get(var4);
                    if (!var5.field_304_B) {
                        this.func_171_h(var5);
                    }
                }
            }
        }

    }

    private void func_171_h(Entity var1) {
        var1.func_6093_b(this);
    }

    public void func_142_f(Entity var1) {
        super.func_142_f(var1);
        this.func_113_a(0.2F, 0.2F);
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.field_318_p = 0.10000000149011612D;
        if (this.field_409_aq.equals("Notch")) {
            this.func_169_a(new ItemStack(Item.field_171_h, 1), true);
        }

        this.field_416_aj.func_199_f();
        if (var1 != null) {
            this.field_319_o = (double)(-MathHelper.func_582_b((this.field_9105_aU + this.field_316_r) * 3.1415927F / 180.0F) * 0.1F);
            this.field_317_q = (double)(-MathHelper.func_585_a((this.field_9105_aU + this.field_316_r) * 3.1415927F / 180.0F) * 0.1F);
        } else {
            this.field_319_o = this.field_317_q = 0.0D;
        }

        this.field_9076_H = 0.1F;
        this.func_25046_a(StatList.field_25098_u, 1);
    }

    public void func_96_b(Entity var1, int var2) {
        this.field_9151_an += var2;
        if (var1 instanceof EntityPlayer) {
            this.func_25046_a(StatList.field_25096_w, 1);
        } else {
            this.func_25046_a(StatList.field_25097_v, 1);
        }

    }

    public void func_161_a() {
        this.func_169_a(this.field_416_aj.func_20069_a(this.field_416_aj.field_499_d, 1), false);
    }

    public void func_20044_b(ItemStack var1) {
        this.func_169_a(var1, false);
    }

    public void func_169_a(ItemStack var1, boolean var2) {
        if (var1 != null) {
            EntityItem var3 = new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m - 0.30000001192092896D + (double)this.func_104_p(), this.field_320_n, var1);
            var3.field_433_ad = 40;
            float var4 = 0.1F;
            float var5;
            if (var2) {
                var5 = this.field_9064_W.nextFloat() * 0.5F;
                float var6 = this.field_9064_W.nextFloat() * 3.1415927F * 2.0F;
                var3.field_319_o = (double)(-MathHelper.func_585_a(var6) * var5);
                var3.field_317_q = (double)(MathHelper.func_582_b(var6) * var5);
                var3.field_318_p = 0.20000000298023224D;
            } else {
                var4 = 0.3F;
                var3.field_319_o = (double)(-MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F) * var4);
                var3.field_317_q = (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F) * var4);
                var3.field_318_p = (double)(-MathHelper.func_585_a(this.field_315_s / 180.0F * 3.1415927F) * var4 + 0.1F);
                var4 = 0.02F;
                var5 = this.field_9064_W.nextFloat() * 3.1415927F * 2.0F;
                var4 *= this.field_9064_W.nextFloat();
                var3.field_319_o += Math.cos((double)var5) * (double)var4;
                var3.field_318_p += (double)((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.1F);
                var3.field_317_q += Math.sin((double)var5) * (double)var4;
            }

            this.func_162_a(var3);
            this.func_25046_a(StatList.field_25103_r, 1);
        }
    }

    protected void func_162_a(EntityItem var1) {
        this.field_9093_l.func_526_a(var1);
    }

    public float func_165_a(Block var1) {
        float var2 = this.field_416_aj.func_208_a(var1);
        if (this.func_110_a(Material.field_521_f)) {
            var2 /= 5.0F;
        }

        if (!this.field_9086_A) {
            var2 /= 5.0F;
        }

        return var2;
    }

    public boolean func_167_b(Block var1) {
        return this.field_416_aj.func_207_b(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        NBTTagList var2 = var1.func_407_k("Inventory");
        this.field_416_aj.func_203_b(var2);
        this.field_4110_as = var1.func_395_d("Dimension");
        this.field_21900_a = var1.func_402_l("Sleeping");
        this.field_21902_c = var1.func_406_c("SleepTimer");
        if (this.field_21900_a) {
            this.field_21901_b = new ChunkCoordinates(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n));
            this.func_22062_a(true, true, false);
        }

        if (var1.func_410_a("SpawnX") && var1.func_410_a("SpawnY") && var1.func_410_a("SpawnZ")) {
            this.field_24900_d = new ChunkCoordinates(var1.func_395_d("SpawnX"), var1.func_395_d("SpawnY"), var1.func_395_d("SpawnZ"));
        }

    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        var1.func_399_a("Inventory", this.field_416_aj.func_200_a(new NBTTagList()));
        var1.func_405_a("Dimension", this.field_4110_as);
        var1.func_393_a("Sleeping", this.field_21900_a);
        var1.func_394_a("SleepTimer", (short)this.field_21902_c);
        if (this.field_24900_d != null) {
            var1.func_405_a("SpawnX", this.field_24900_d.field_22216_a);
            var1.func_405_a("SpawnY", this.field_24900_d.field_529_a);
            var1.func_405_a("SpawnZ", this.field_24900_d.field_528_b);
        }

    }

    public void func_166_a(IInventory var1) {
    }

    public void func_174_A(int var1, int var2, int var3) {
    }

    public void func_163_c(Entity var1, int var2) {
    }

    public float func_104_p() {
        return 0.12F;
    }

    protected void func_22064_l_() {
        this.field_9076_H = 1.62F;
    }

    public boolean func_121_a(Entity var1, int var2) {
        this.field_9132_bn = 0;
        if (this.field_9109_aQ <= 0) {
            return false;
        } else {
            if (this.func_22057_E() && !this.field_9093_l.field_792_x) {
                this.func_22062_a(true, true, false);
            }

            if (var1 instanceof EntityMob || var1 instanceof EntityArrow) {
                if (this.field_9093_l.field_804_l == 0) {
                    var2 = 0;
                }

                if (this.field_9093_l.field_804_l == 1) {
                    var2 = var2 / 3 + 1;
                }

                if (this.field_9093_l.field_804_l == 3) {
                    var2 = var2 * 3 / 2;
                }
            }

            if (var2 == 0) {
                return false;
            } else {
                Object var3 = var1;
                if (var1 instanceof EntityArrow && ((EntityArrow)var1).field_439_ah != null) {
                    var3 = ((EntityArrow)var1).field_439_ah;
                }

                if (var3 instanceof EntityLiving) {
                    this.func_25047_a((EntityLiving)var3, false);
                }

                this.func_25046_a(StatList.field_25100_t, var2);
                return super.func_121_a(var1, var2);
            }
        }
    }

    protected boolean func_27016_t() {
        return false;
    }

    protected void func_25047_a(EntityLiving var1, boolean var2) {
        if (!(var1 instanceof EntityCreeper) && !(var1 instanceof EntityGhast)) {
            if (var1 instanceof EntityWolf) {
                EntityWolf var3 = (EntityWolf)var1;
                if (var3.func_25030_y() && this.field_409_aq.equals(var3.func_25034_v())) {
                    return;
                }
            }

            if (!(var1 instanceof EntityPlayer) || this.func_27016_t()) {
                List var7 = this.field_9093_l.func_457_a(EntityWolf.class, AxisAlignedBB.func_693_b(this.field_322_l, this.field_321_m, this.field_320_n, this.field_322_l + 1.0D, this.field_321_m + 1.0D, this.field_320_n + 1.0D).func_708_b(16.0D, 4.0D, 16.0D));
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
                                } while(!var6.func_25030_y());
                            } while(var6.func_25024_A() != null);
                        } while(!this.field_409_aq.equals(var6.func_25034_v()));
                    } while(var2 && var6.func_25036_w());

                    var6.func_25031_b(false);
                    var6.func_25025_c(var1);
                }
            }
        }
    }

    protected void func_6099_c(int var1) {
        int var2 = 25 - this.field_416_aj.func_212_e();
        int var3 = var1 * var2 + this.field_421_a;
        this.field_416_aj.func_211_b(var1);
        var1 = var3 / 25;
        this.field_421_a = var3 % 25;
        super.func_6099_c(var1);
    }

    public void func_170_a(TileEntityFurnace var1) {
    }

    public void func_21072_a(TileEntityDispenser var1) {
    }

    public void func_4048_a(TileEntitySign var1) {
    }

    public void func_9145_g(Entity var1) {
        if (!var1.func_6092_a(this)) {
            ItemStack var2 = this.func_172_B();
            if (var2 != null && var1 instanceof EntityLiving) {
                var2.func_21129_b((EntityLiving)var1);
                if (var2.field_853_a <= 0) {
                    var2.func_577_a(this);
                    this.func_164_C();
                }
            }

        }
    }

    public ItemStack func_172_B() {
        return this.field_416_aj.func_213_b();
    }

    public void func_164_C() {
        this.field_416_aj.func_206_a(this.field_416_aj.field_499_d, (ItemStack)null);
    }

    public double func_117_x() {
        return (double)(this.field_9076_H - 0.5F);
    }

    public void func_168_z() {
        this.field_9147_ar = -1;
        this.field_9148_aq = true;
    }

    public void func_9146_h(Entity var1) {
        int var2 = this.field_416_aj.func_9157_a(var1);
        if (var2 > 0) {
            if (this.field_318_p < 0.0D) {
                ++var2;
            }

            var1.func_121_a(this, var2);
            ItemStack var3 = this.func_172_B();
            if (var3 != null && var1 instanceof EntityLiving) {
                var3.func_9217_a((EntityLiving)var1, this);
                if (var3.field_853_a <= 0) {
                    var3.func_577_a(this);
                    this.func_164_C();
                }
            }

            if (var1 instanceof EntityLiving) {
                if (var1.func_120_t()) {
                    this.func_25047_a((EntityLiving)var1, true);
                }

                this.func_25046_a(StatList.field_25102_s, var2);
            }
        }

    }

    public void func_20045_a(ItemStack var1) {
    }

    public void func_118_j() {
        super.func_118_j();
        this.field_20053_ao.func_20130_a(this);
        if (this.field_20052_ap != null) {
            this.field_20052_ap.func_20130_a(this);
        }

    }

    public boolean func_91_u() {
        return !this.field_21900_a && super.func_91_u();
    }

    public EnumStatus func_22060_a(int var1, int var2, int var3) {
        if (!this.field_9093_l.field_792_x) {
            label53: {
                if (!this.func_22057_E() && this.func_120_t()) {
                    if (this.field_9093_l.field_4272_q.field_6167_c) {
                        return EnumStatus.NOT_POSSIBLE_HERE;
                    }

                    if (this.field_9093_l.func_453_a()) {
                        return EnumStatus.NOT_POSSIBLE_NOW;
                    }

                    if (Math.abs(this.field_322_l - (double)var1) <= 3.0D && Math.abs(this.field_321_m - (double)var2) <= 2.0D && Math.abs(this.field_320_n - (double)var3) <= 3.0D) {
                        break label53;
                    }

                    return EnumStatus.TOO_FAR_AWAY;
                }

                return EnumStatus.OTHER_PROBLEM;
            }
        }

        this.func_113_a(0.2F, 0.2F);
        this.field_9076_H = 0.2F;
        if (this.field_9093_l.func_530_e(var1, var2, var3)) {
            int var4 = this.field_9093_l.func_446_b(var1, var2, var3);
            int var5 = BlockBed.func_22019_c(var4);
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

            this.func_22059_e(var5);
            this.func_86_a((double)((float)var1 + var6), (double)((float)var2 + 0.9375F), (double)((float)var3 + var7));
        } else {
            this.func_86_a((double)((float)var1 + 0.5F), (double)((float)var2 + 0.9375F), (double)((float)var3 + 0.5F));
        }

        this.field_21900_a = true;
        this.field_21902_c = 0;
        this.field_21901_b = new ChunkCoordinates(var1, var2, var3);
        this.field_319_o = this.field_317_q = this.field_318_p = 0.0D;
        if (!this.field_9093_l.field_792_x) {
            this.field_9093_l.func_22082_o();
        }

        return EnumStatus.OK;
    }

    private void func_22059_e(int var1) {
        this.field_22066_z = 0.0F;
        this.field_22067_A = 0.0F;
        switch(var1) {
        case 0:
            this.field_22067_A = -1.8F;
            break;
        case 1:
            this.field_22066_z = 1.8F;
            break;
        case 2:
            this.field_22067_A = 1.8F;
            break;
        case 3:
            this.field_22066_z = -1.8F;
        }

    }

    public void func_22062_a(boolean var1, boolean var2, boolean var3) {
        this.func_113_a(0.6F, 1.8F);
        this.func_22064_l_();
        ChunkCoordinates var4 = this.field_21901_b;
        ChunkCoordinates var5 = this.field_21901_b;
        if (var4 != null && this.field_9093_l.func_444_a(var4.field_22216_a, var4.field_529_a, var4.field_528_b) == Block.field_9037_S.field_573_bc) {
            BlockBed.func_22022_a(this.field_9093_l, var4.field_22216_a, var4.field_529_a, var4.field_528_b, false);
            var5 = BlockBed.func_22021_g(this.field_9093_l, var4.field_22216_a, var4.field_529_a, var4.field_528_b, 0);
            if (var5 == null) {
                var5 = new ChunkCoordinates(var4.field_22216_a, var4.field_529_a + 1, var4.field_528_b);
            }

            this.func_86_a((double)((float)var5.field_22216_a + 0.5F), (double)((float)var5.field_529_a + this.field_9076_H + 0.1F), (double)((float)var5.field_528_b + 0.5F));
        }

        this.field_21900_a = false;
        if (!this.field_9093_l.field_792_x && var2) {
            this.field_9093_l.func_22082_o();
        }

        if (var1) {
            this.field_21902_c = 0;
        } else {
            this.field_21902_c = 100;
        }

        if (var3) {
            this.func_25050_a(this.field_21901_b);
        }

    }

    private boolean func_22063_l() {
        return this.field_9093_l.func_444_a(this.field_21901_b.field_22216_a, this.field_21901_b.field_529_a, this.field_21901_b.field_528_b) == Block.field_9037_S.field_573_bc;
    }

    public static ChunkCoordinates func_25051_a(World var0, ChunkCoordinates var1) {
        IChunkProvider var2 = var0.func_25073_n();
        var2.func_376_d(var1.field_22216_a - 3 >> 4, var1.field_528_b - 3 >> 4);
        var2.func_376_d(var1.field_22216_a + 3 >> 4, var1.field_528_b - 3 >> 4);
        var2.func_376_d(var1.field_22216_a - 3 >> 4, var1.field_528_b + 3 >> 4);
        var2.func_376_d(var1.field_22216_a + 3 >> 4, var1.field_528_b + 3 >> 4);
        if (var0.func_444_a(var1.field_22216_a, var1.field_529_a, var1.field_528_b) != Block.field_9037_S.field_573_bc) {
            return null;
        } else {
            ChunkCoordinates var3 = BlockBed.func_22021_g(var0, var1.field_22216_a, var1.field_529_a, var1.field_528_b, 0);
            return var3;
        }
    }

    public boolean func_22057_E() {
        return this.field_21900_a;
    }

    public boolean func_22065_F() {
        return this.field_21900_a && this.field_21902_c >= 100;
    }

    public void func_22061_a(String var1) {
    }

    public ChunkCoordinates func_25049_H() {
        return this.field_24900_d;
    }

    public void func_25050_a(ChunkCoordinates var1) {
        if (var1 != null) {
            this.field_24900_d = new ChunkCoordinates(var1);
        } else {
            this.field_24900_d = null;
        }

    }

    public void func_27017_a(StatBase var1) {
        this.func_25046_a(var1, 1);
    }

    public void func_25046_a(StatBase var1, int var2) {
    }

    protected void func_154_F() {
        super.func_154_F();
        this.func_25046_a(StatList.field_25106_q, 1);
    }

    public void func_148_c(float var1, float var2) {
        double var3 = this.field_322_l;
        double var5 = this.field_321_m;
        double var7 = this.field_320_n;
        super.func_148_c(var1, var2);
        this.func_25045_g(this.field_322_l - var3, this.field_321_m - var5, this.field_320_n - var7);
    }

    private void func_25045_g(double var1, double var3, double var5) {
        if (this.field_327_g == null) {
            int var7;
            if (this.func_110_a(Material.field_521_f)) {
                var7 = Math.round(MathHelper.func_583_a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.func_25046_a(StatList.field_25108_p, var7);
                }
            } else if (this.func_27011_Z()) {
                var7 = Math.round(MathHelper.func_583_a(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.func_25046_a(StatList.field_25112_l, var7);
                }
            } else if (this.func_144_E()) {
                if (var3 > 0.0D) {
                    this.func_25046_a(StatList.field_25110_n, (int)Math.round(var3 * 100.0D));
                }
            } else if (this.field_9086_A) {
                var7 = Math.round(MathHelper.func_583_a(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 0) {
                    this.func_25046_a(StatList.field_25113_k, var7);
                }
            } else {
                var7 = Math.round(MathHelper.func_583_a(var1 * var1 + var5 * var5) * 100.0F);
                if (var7 > 25) {
                    this.func_25046_a(StatList.field_25109_o, var7);
                }
            }

        }
    }

    private void func_27015_h(double var1, double var3, double var5) {
        if (this.field_327_g != null) {
            int var7 = Math.round(MathHelper.func_583_a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
            if (var7 > 0) {
                if (this.field_327_g instanceof EntityMinecart) {
                    this.func_25046_a(StatList.field_27095_r, var7);
                    if (this.field_27995_d == null) {
                        this.field_27995_d = new ChunkCoordinates(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n));
                    } else if (this.field_27995_d.func_27127_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n)) >= 1000.0D) {
                        this.func_25046_a(AchievementList.field_27102_q, 1);
                    }
                } else if (this.field_327_g instanceof EntityBoat) {
                    this.func_25046_a(StatList.field_27094_s, var7);
                } else if (this.field_327_g instanceof EntityPig) {
                    this.func_25046_a(StatList.field_27093_t, var7);
                }
            }
        }

    }

    protected void func_114_a(float var1) {
        if (var1 >= 2.0F) {
            this.func_25046_a(StatList.field_25111_m, (int)Math.round((double)var1 * 100.0D));
        }

        super.func_114_a(var1);
    }

    public void func_27010_a(EntityLiving var1) {
        if (var1 instanceof EntityMob) {
            this.func_27017_a(AchievementList.field_27100_s);
        }

    }

    public void func_4042_C() {
        if (this.field_28016_C > 0) {
            this.field_28016_C = 10;
        } else {
            this.field_28015_D = true;
        }
    }
}
