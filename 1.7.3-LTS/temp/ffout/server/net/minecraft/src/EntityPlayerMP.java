package net.minecraft.src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class EntityPlayerMP extends EntityPlayer implements ICrafting {
    public NetServerHandler field_20908_a;
    public MinecraftServer field_419_b;
    public ItemInWorldManager field_425_ad;
    public double field_9155_d;
    public double field_9154_e;
    public List field_422_ag = new LinkedList();
    public Set field_420_ah = new HashSet();
    private int field_9156_bu = -99999999;
    private int field_15004_bw = 60;
    private ItemStack[] field_20066_bG = new ItemStack[]{null, null, null, null, null};
    private int field_20065_bH = 0;
    public boolean field_20064_am;

    public EntityPlayerMP(MinecraftServer var1, World var2, String var3, ItemInWorldManager var4) {
        super(var2);
        var4.field_675_a = this;
        this.field_425_ad = var4;
        ChunkCoordinates var5 = var2.func_22078_l();
        int var6 = var5.field_22216_a;
        int var7 = var5.field_528_b;
        int var8 = var5.field_529_a;
        if (!var2.field_4272_q.field_4306_c) {
            var6 += this.field_9064_W.nextInt(20) - 10;
            var8 = var2.func_4075_e(var6, var7);
            var7 += this.field_9064_W.nextInt(20) - 10;
        }

        this.func_107_c((double)var6 + 0.5D, (double)var8, (double)var7 + 0.5D, 0.0F, 0.0F);
        this.field_419_b = var1;
        this.field_9067_S = 0.0F;
        this.field_409_aq = var3;
        this.field_9076_H = 0.0F;
    }

    public void func_28007_a(World var1) {
        super.func_28007_a(var1);
        this.field_425_ad = new ItemInWorldManager((WorldServer)var1);
        this.field_425_ad.field_675_a = this;
    }

    public void func_20057_k() {
        this.field_20052_ap.func_20128_a(this);
    }

    public ItemStack[] func_20042_E() {
        return this.field_20066_bG;
    }

    protected void func_22064_l_() {
        this.field_9076_H = 0.0F;
    }

    public float func_104_p() {
        return 1.62F;
    }

    public void func_106_b_() {
        this.field_425_ad.func_328_a();
        --this.field_15004_bw;
        this.field_20052_ap.func_20125_a();

        for(int var1 = 0; var1 < 5; ++var1) {
            ItemStack var2 = this.func_21073_a(var1);
            if (var2 != this.field_20066_bG[var1]) {
                this.field_419_b.func_28003_b(this.field_4110_as).func_12021_a(this, new Packet5PlayerInventory(this.field_331_c, var1, var2));
                this.field_20066_bG[var1] = var2;
            }
        }

    }

    public ItemStack func_21073_a(int var1) {
        return var1 == 0 ? this.field_416_aj.func_213_b() : this.field_416_aj.field_495_b[var1 - 1];
    }

    public void func_142_f(Entity var1) {
        this.field_416_aj.func_199_f();
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (this.field_15004_bw > 0) {
            return false;
        } else {
            if (!this.field_419_b.field_9011_n) {
                if (var1 instanceof EntityPlayer) {
                    return false;
                }

                if (var1 instanceof EntityArrow) {
                    EntityArrow var3 = (EntityArrow)var1;
                    if (var3.field_439_ah instanceof EntityPlayer) {
                        return false;
                    }
                }
            }

            return super.func_121_a(var1, var2);
        }
    }

    protected boolean func_27016_t() {
        return this.field_419_b.field_9011_n;
    }

    public void func_137_a(int var1) {
        super.func_137_a(var1);
    }

    public void func_22070_a(boolean var1) {
        super.func_106_b_();

        for(int var2 = 0; var2 < this.field_416_aj.func_83_a(); ++var2) {
            ItemStack var3 = this.field_416_aj.func_82_a(var2);
            if (var3 != null && Item.field_176_c[var3.field_855_c].func_28019_b() && this.field_20908_a.func_38_b() <= 2) {
                Packet var4 = ((ItemMapBase)Item.field_176_c[var3.field_855_c]).func_28022_b(var3, this.field_9093_l, this);
                if (var4 != null) {
                    this.field_20908_a.func_39_b(var4);
                }
            }
        }

        if (var1 && !this.field_422_ag.isEmpty()) {
            ChunkCoordIntPair var7 = (ChunkCoordIntPair)this.field_422_ag.get(0);
            if (var7 != null) {
                boolean var8 = false;
                if (this.field_20908_a.func_38_b() < 4) {
                    var8 = true;
                }

                if (var8) {
                    WorldServer var9 = this.field_419_b.func_28004_a(this.field_4110_as);
                    this.field_422_ag.remove(var7);
                    this.field_20908_a.func_39_b(new Packet51MapChunk(var7.field_152_a * 16, 0, var7.field_151_b * 16, 16, 128, 16, var9));
                    List var5 = var9.func_532_d(var7.field_152_a * 16, 0, var7.field_151_b * 16, var7.field_152_a * 16 + 16, 128, var7.field_151_b * 16 + 16);

                    for(int var6 = 0; var6 < var5.size(); ++var6) {
                        this.func_20063_a((TileEntity)var5.get(var6));
                    }
                }
            }
        }

        if (this.field_28015_D) {
            if (this.field_419_b.field_6035_d.func_724_a("allow-nether", true)) {
                if (this.field_20052_ap != this.field_20053_ao) {
                    this.func_20043_I();
                }

                if (this.field_327_g != null) {
                    this.func_6094_e(this.field_327_g);
                } else {
                    this.field_28014_E += 0.0125F;
                    if (this.field_28014_E >= 1.0F) {
                        this.field_28014_E = 1.0F;
                        this.field_28016_C = 10;
                        this.field_419_b.field_6033_f.func_28168_f(this);
                    }
                }

                this.field_28015_D = false;
            }
        } else {
            if (this.field_28014_E > 0.0F) {
                this.field_28014_E -= 0.05F;
            }

            if (this.field_28014_E < 0.0F) {
                this.field_28014_E = 0.0F;
            }
        }

        if (this.field_28016_C > 0) {
            --this.field_28016_C;
        }

        if (this.field_9109_aQ != this.field_9156_bu) {
            this.field_20908_a.func_39_b(new Packet8UpdateHealth(this.field_9109_aQ));
            this.field_9156_bu = this.field_9109_aQ;
        }

    }

    private void func_20063_a(TileEntity var1) {
        if (var1 != null) {
            Packet var2 = var1.func_20070_f();
            if (var2 != null) {
                this.field_20908_a.func_39_b(var2);
            }
        }

    }

    public void func_153_y() {
        super.func_153_y();
    }

    public void func_163_c(Entity var1, int var2) {
        if (!var1.field_304_B) {
            EntityTracker var3 = this.field_419_b.func_28003_b(this.field_4110_as);
            if (var1 instanceof EntityItem) {
                var3.func_12021_a(var1, new Packet22Collect(var1.field_331_c, this.field_331_c));
            }

            if (var1 instanceof EntityArrow) {
                var3.func_12021_a(var1, new Packet22Collect(var1.field_331_c, this.field_331_c));
            }
        }

        super.func_163_c(var1, var2);
        this.field_20052_ap.func_20125_a();
    }

    public void func_168_z() {
        if (!this.field_9148_aq) {
            this.field_9147_ar = -1;
            this.field_9148_aq = true;
            EntityTracker var1 = this.field_419_b.func_28003_b(this.field_4110_as);
            var1.func_12021_a(this, new Packet18Animation(this, 1));
        }

    }

    public void func_22068_s() {
    }

    public EnumStatus func_22060_a(int var1, int var2, int var3) {
        EnumStatus var4 = super.func_22060_a(var1, var2, var3);
        if (var4 == EnumStatus.OK) {
            EntityTracker var5 = this.field_419_b.func_28003_b(this.field_4110_as);
            Packet17Sleep var6 = new Packet17Sleep(this, 0, var1, var2, var3);
            var5.func_12021_a(this, var6);
            this.field_20908_a.func_41_a(this.field_322_l, this.field_321_m, this.field_320_n, this.field_316_r, this.field_315_s);
            this.field_20908_a.func_39_b(var6);
        }

        return var4;
    }

    public void func_22062_a(boolean var1, boolean var2, boolean var3) {
        if (this.func_22057_E()) {
            EntityTracker var4 = this.field_419_b.func_28003_b(this.field_4110_as);
            var4.func_609_a(this, new Packet18Animation(this, 3));
        }

        super.func_22062_a(var1, var2, var3);
        if (this.field_20908_a != null) {
            this.field_20908_a.func_41_a(this.field_322_l, this.field_321_m, this.field_320_n, this.field_316_r, this.field_315_s);
        }

    }

    public void func_6094_e(Entity var1) {
        super.func_6094_e(var1);
        this.field_20908_a.func_39_b(new Packet39AttachEntity(this, this.field_327_g));
        this.field_20908_a.func_41_a(this.field_322_l, this.field_321_m, this.field_320_n, this.field_316_r, this.field_315_s);
    }

    protected void func_122_m(double var1, boolean var3) {
    }

    public void func_9153_b(double var1, boolean var3) {
        super.func_122_m(var1, var3);
    }

    private void func_20060_R() {
        this.field_20065_bH = this.field_20065_bH % 100 + 1;
    }

    public void func_174_A(int var1, int var2, int var3) {
        this.func_20060_R();
        this.field_20908_a.func_39_b(new Packet100OpenWindow(this.field_20065_bH, 1, "Crafting", 9));
        this.field_20052_ap = new ContainerWorkbench(this.field_416_aj, this.field_9093_l, var1, var2, var3);
        this.field_20052_ap.field_20134_f = this.field_20065_bH;
        this.field_20052_ap.func_20128_a(this);
    }

    public void func_166_a(IInventory var1) {
        this.func_20060_R();
        this.field_20908_a.func_39_b(new Packet100OpenWindow(this.field_20065_bH, 0, var1.func_20068_b(), var1.func_83_a()));
        this.field_20052_ap = new ContainerChest(this.field_416_aj, var1);
        this.field_20052_ap.field_20134_f = this.field_20065_bH;
        this.field_20052_ap.func_20128_a(this);
    }

    public void func_170_a(TileEntityFurnace var1) {
        this.func_20060_R();
        this.field_20908_a.func_39_b(new Packet100OpenWindow(this.field_20065_bH, 2, var1.func_20068_b(), var1.func_83_a()));
        this.field_20052_ap = new ContainerFurnace(this.field_416_aj, var1);
        this.field_20052_ap.field_20134_f = this.field_20065_bH;
        this.field_20052_ap.func_20128_a(this);
    }

    public void func_21072_a(TileEntityDispenser var1) {
        this.func_20060_R();
        this.field_20908_a.func_39_b(new Packet100OpenWindow(this.field_20065_bH, 3, var1.func_20068_b(), var1.func_83_a()));
        this.field_20052_ap = new ContainerDispenser(this.field_416_aj, var1);
        this.field_20052_ap.field_20134_f = this.field_20065_bH;
        this.field_20052_ap.func_20128_a(this);
    }

    public void func_20055_a(Container var1, int var2, ItemStack var3) {
        if (!(var1.func_20120_a(var2) instanceof SlotCrafting)) {
            if (!this.field_20064_am) {
                this.field_20908_a.func_39_b(new Packet103SetSlot(var1.field_20134_f, var2, var3));
            }
        }
    }

    public void func_28017_a(Container var1) {
        this.func_20054_a(var1, var1.func_28127_b());
    }

    public void func_20054_a(Container var1, List var2) {
        this.field_20908_a.func_39_b(new Packet104WindowItems(var1.field_20134_f, var2));
        this.field_20908_a.func_39_b(new Packet103SetSlot(-1, -1, this.field_416_aj.func_20072_i()));
    }

    public void func_20056_a(Container var1, int var2, int var3) {
        this.field_20908_a.func_39_b(new Packet105UpdateProgressbar(var1.field_20134_f, var2, var3));
    }

    public void func_20045_a(ItemStack var1) {
    }

    public void func_20043_I() {
        this.field_20908_a.func_39_b(new Packet101CloseWindow(this.field_20052_ap.field_20134_f));
        this.func_20059_K();
    }

    public void func_20058_J() {
        if (!this.field_20064_am) {
            this.field_20908_a.func_39_b(new Packet103SetSlot(-1, -1, this.field_416_aj.func_20072_i()));
        }
    }

    public void func_20059_K() {
        this.field_20052_ap.func_20130_a(this);
        this.field_20052_ap = this.field_20053_ao;
    }

    public void func_22069_a(float var1, float var2, boolean var3, boolean var4, float var5, float var6) {
        this.field_9131_bo = var1;
        this.field_9130_bp = var2;
        this.field_9128_br = var3;
        this.func_21043_b(var4);
        this.field_315_s = var5;
        this.field_316_r = var6;
    }

    public void func_25046_a(StatBase var1, int var2) {
        if (var1 != null) {
            if (!var1.field_27058_g) {
                while(var2 > 100) {
                    this.field_20908_a.func_39_b(new Packet200Statistic(var1.field_25063_d, 100));
                    var2 -= 100;
                }

                this.field_20908_a.func_39_b(new Packet200Statistic(var1.field_25063_d, var2));
            }

        }
    }

    public void func_30002_A() {
        if (this.field_327_g != null) {
            this.func_6094_e(this.field_327_g);
        }

        if (this.field_328_f != null) {
            this.field_328_f.func_6094_e(this);
        }

        if (this.field_21900_a) {
            this.func_22062_a(true, false, false);
        }

    }

    public void func_30001_B() {
        this.field_9156_bu = -99999999;
    }

    public void func_22061_a(String var1) {
        StringTranslate var2 = StringTranslate.func_25079_a();
        String var3 = var2.func_25080_a(var1);
        this.field_20908_a.func_39_b(new Packet3Chat(var3));
    }
}
