package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class World implements IBlockAccess {
    public boolean field_4214_a;
    private List field_1051_z;
    public List field_1050_a;
    private List field_1024_A;
    private TreeSet field_1058_B;
    private Set field_1056_C;
    public List field_1049_b;
    private List field_30900_E;
    public List field_1040_k;
    public List field_27173_e;
    private long field_1019_F;
    public int field_1046_e;
    protected int field_9437_g;
    protected final int field_9436_h;
    protected float field_26901_B;
    protected float field_27171_C;
    protected float field_27170_D;
    protected float field_27169_E;
    protected int field_27168_F;
    public int field_27172_i;
    public boolean field_1043_h;
    private long field_1054_E;
    protected int field_9435_j;
    public int field_1039_l;
    public Random field_1037_n;
    public boolean field_1033_r;
    public final WorldProvider field_4209_q;
    protected List field_9434_r;
    protected IChunkProvider field_1017_H;
    protected final ISaveHandler field_22147_p;
    protected WorldInfo field_22145_q;
    public boolean field_9430_x;
    private boolean field_22146_A;
    public MapStorage field_28108_z;
    private ArrayList field_9428_I;
    private boolean field_31055_L;
    private int field_4204_J;
    private boolean field_21121_K;
    private boolean field_21120_L;
    static int field_9429_y = 0;
    private Set field_9427_K;
    private int field_9426_L;
    private List field_1012_M;
    public boolean field_1026_y;

    public WorldChunkManager func_4075_a() {
        return this.field_4209_q.field_4215_b;
    }

    public World(ISaveHandler var1, String var2, WorldProvider var3, long var4) {
        this.field_4214_a = false;
        this.field_1051_z = new ArrayList();
        this.field_1050_a = new ArrayList();
        this.field_1024_A = new ArrayList();
        this.field_1058_B = new TreeSet();
        this.field_1056_C = new HashSet();
        this.field_1049_b = new ArrayList();
        this.field_30900_E = new ArrayList();
        this.field_1040_k = new ArrayList();
        this.field_27173_e = new ArrayList();
        this.field_1019_F = 16777215L;
        this.field_1046_e = 0;
        this.field_9437_g = (new Random()).nextInt();
        this.field_9436_h = 1013904223;
        this.field_27168_F = 0;
        this.field_27172_i = 0;
        this.field_1043_h = false;
        this.field_1054_E = System.currentTimeMillis();
        this.field_9435_j = 40;
        this.field_1037_n = new Random();
        this.field_1033_r = false;
        this.field_9434_r = new ArrayList();
        this.field_9428_I = new ArrayList();
        this.field_4204_J = 0;
        this.field_21121_K = true;
        this.field_21120_L = true;
        this.field_9427_K = new HashSet();
        this.field_9426_L = this.field_1037_n.nextInt(12000);
        this.field_1012_M = new ArrayList();
        this.field_1026_y = false;
        this.field_22147_p = var1;
        this.field_22145_q = new WorldInfo(var4, var2);
        this.field_4209_q = var3;
        this.field_28108_z = new MapStorage(var1);
        var3.func_4095_a(this);
        this.field_1017_H = this.func_4081_a();
        this.func_644_f();
        this.func_27163_E();
    }

    public World(World var1, WorldProvider var2) {
        this.field_4214_a = false;
        this.field_1051_z = new ArrayList();
        this.field_1050_a = new ArrayList();
        this.field_1024_A = new ArrayList();
        this.field_1058_B = new TreeSet();
        this.field_1056_C = new HashSet();
        this.field_1049_b = new ArrayList();
        this.field_30900_E = new ArrayList();
        this.field_1040_k = new ArrayList();
        this.field_27173_e = new ArrayList();
        this.field_1019_F = 16777215L;
        this.field_1046_e = 0;
        this.field_9437_g = (new Random()).nextInt();
        this.field_9436_h = 1013904223;
        this.field_27168_F = 0;
        this.field_27172_i = 0;
        this.field_1043_h = false;
        this.field_1054_E = System.currentTimeMillis();
        this.field_9435_j = 40;
        this.field_1037_n = new Random();
        this.field_1033_r = false;
        this.field_9434_r = new ArrayList();
        this.field_9428_I = new ArrayList();
        this.field_4204_J = 0;
        this.field_21121_K = true;
        this.field_21120_L = true;
        this.field_9427_K = new HashSet();
        this.field_9426_L = this.field_1037_n.nextInt(12000);
        this.field_1012_M = new ArrayList();
        this.field_1026_y = false;
        this.field_1054_E = var1.field_1054_E;
        this.field_22147_p = var1.field_22147_p;
        this.field_22145_q = new WorldInfo(var1.field_22145_q);
        this.field_28108_z = new MapStorage(this.field_22147_p);
        this.field_4209_q = var2;
        var2.func_4095_a(this);
        this.field_1017_H = this.func_4081_a();
        this.func_644_f();
        this.func_27163_E();
    }

    public World(ISaveHandler var1, String var2, long var3) {
        this(var1, var2, var3, (WorldProvider)null);
    }

    public World(ISaveHandler var1, String var2, long var3, WorldProvider var5) {
        this.field_4214_a = false;
        this.field_1051_z = new ArrayList();
        this.field_1050_a = new ArrayList();
        this.field_1024_A = new ArrayList();
        this.field_1058_B = new TreeSet();
        this.field_1056_C = new HashSet();
        this.field_1049_b = new ArrayList();
        this.field_30900_E = new ArrayList();
        this.field_1040_k = new ArrayList();
        this.field_27173_e = new ArrayList();
        this.field_1019_F = 16777215L;
        this.field_1046_e = 0;
        this.field_9437_g = (new Random()).nextInt();
        this.field_9436_h = 1013904223;
        this.field_27168_F = 0;
        this.field_27172_i = 0;
        this.field_1043_h = false;
        this.field_1054_E = System.currentTimeMillis();
        this.field_9435_j = 40;
        this.field_1037_n = new Random();
        this.field_1033_r = false;
        this.field_9434_r = new ArrayList();
        this.field_9428_I = new ArrayList();
        this.field_4204_J = 0;
        this.field_21121_K = true;
        this.field_21120_L = true;
        this.field_9427_K = new HashSet();
        this.field_9426_L = this.field_1037_n.nextInt(12000);
        this.field_1012_M = new ArrayList();
        this.field_1026_y = false;
        this.field_22147_p = var1;
        this.field_28108_z = new MapStorage(var1);
        this.field_22145_q = var1.func_22151_c();
        this.field_1033_r = this.field_22145_q == null;
        if (var5 != null) {
            this.field_4209_q = var5;
        } else if (this.field_22145_q != null && this.field_22145_q.func_22290_i() == -1) {
            this.field_4209_q = WorldProvider.func_4101_a(-1);
        } else {
            this.field_4209_q = WorldProvider.func_4101_a(0);
        }

        boolean var6 = false;
        if (this.field_22145_q == null) {
            this.field_22145_q = new WorldInfo(var3, var2);
            var6 = true;
        } else {
            this.field_22145_q.func_22287_a(var2);
        }

        this.field_4209_q.func_4095_a(this);
        this.field_1017_H = this.func_4081_a();
        if (var6) {
            this.func_25098_c();
        }

        this.func_644_f();
        this.func_27163_E();
    }

    protected IChunkProvider func_4081_a() {
        IChunkLoader var1 = this.field_22147_p.func_22149_a(this.field_4209_q);
        return new ChunkProvider(this, var1, this.field_4209_q.func_4094_c());
    }

    protected void func_25098_c() {
        this.field_9430_x = true;
        int var1 = 0;
        byte var2 = 64;

        int var3;
        for(var3 = 0; !this.field_4209_q.func_4102_a(var1, var3); var3 += this.field_1037_n.nextInt(64) - this.field_1037_n.nextInt(64)) {
            var1 += this.field_1037_n.nextInt(64) - this.field_1037_n.nextInt(64);
        }

        this.field_22145_q.func_22292_a(var1, var2, var3);
        this.field_9430_x = false;
    }

    public void func_4076_b() {
        if (this.field_22145_q.func_22295_d() <= 0) {
            this.field_22145_q.func_22308_b(64);
        }

        int var1 = this.field_22145_q.func_22293_c();

        int var2;
        for(var2 = this.field_22145_q.func_22300_e(); this.func_614_g(var1, var2) == 0; var2 += this.field_1037_n.nextInt(8) - this.field_1037_n.nextInt(8)) {
            var1 += this.field_1037_n.nextInt(8) - this.field_1037_n.nextInt(8);
        }

        this.field_22145_q.func_22294_a(var1);
        this.field_22145_q.func_22298_c(var2);
    }

    public int func_614_g(int var1, int var2) {
        int var3;
        for(var3 = 63; !this.func_20084_d(var1, var3 + 1, var2); ++var3) {
        }

        return this.func_600_a(var1, var3, var2);
    }

    public void func_6464_c() {
    }

    public void func_608_a(EntityPlayer var1) {
        try {
            NBTTagCompound var2 = this.field_22145_q.func_22303_h();
            if (var2 != null) {
                var1.func_368_e(var2);
                this.field_22145_q.func_22309_a((NBTTagCompound)null);
            }

            if (this.field_1017_H instanceof ChunkProviderLoadOrGenerate) {
                ChunkProviderLoadOrGenerate var3 = (ChunkProviderLoadOrGenerate)this.field_1017_H;
                int var4 = MathHelper.func_1110_d((float)((int)var1.field_611_ak)) >> 4;
                int var5 = MathHelper.func_1110_d((float)((int)var1.field_609_am)) >> 4;
                var3.func_21110_c(var4, var5);
            }

            this.func_674_a(var1);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public void func_639_a(boolean var1, IProgressUpdate var2) {
        if (this.field_1017_H.func_536_b()) {
            if (var2 != null) {
                var2.func_594_b("Saving level");
            }

            this.func_669_m();
            if (var2 != null) {
                var2.func_595_d("Saving chunks");
            }

            this.field_1017_H.func_535_a(var1, var2);
        }
    }

    private void func_669_m() {
        this.func_663_l();
        this.field_22147_p.func_22148_a(this.field_22145_q, this.field_1040_k);
        this.field_28108_z.func_28188_a();
    }

    public boolean func_650_a(int var1) {
        if (!this.field_1017_H.func_536_b()) {
            return true;
        } else {
            if (var1 == 0) {
                this.func_669_m();
            }

            return this.field_1017_H.func_535_a(false, (IProgressUpdate)null);
        }
    }

    public int func_600_a(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return 0;
            } else {
                return var2 >= 128 ? 0 : this.func_704_b(var1 >> 4, var3 >> 4).func_1008_a(var1 & 15, var2, var3 & 15);
            }
        } else {
            return 0;
        }
    }

    public boolean func_20084_d(int var1, int var2, int var3) {
        return this.func_600_a(var1, var2, var3) == 0;
    }

    public boolean func_630_d(int var1, int var2, int var3) {
        return var2 >= 0 && var2 < 128 ? this.func_620_h(var1 >> 4, var3 >> 4) : false;
    }

    public boolean func_21117_a(int var1, int var2, int var3, int var4) {
        return this.func_640_a(var1 - var4, var2 - var4, var3 - var4, var1 + var4, var2 + var4, var3 + var4);
    }

    public boolean func_640_a(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var5 >= 0 && var2 < 128) {
            var1 >>= 4;
            var2 >>= 4;
            var3 >>= 4;
            var4 >>= 4;
            var5 >>= 4;
            var6 >>= 4;

            for(int var7 = var1; var7 <= var4; ++var7) {
                for(int var8 = var3; var8 <= var6; ++var8) {
                    if (!this.func_620_h(var7, var8)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean func_620_h(int var1, int var2) {
        return this.field_1017_H.func_537_a(var1, var2);
    }

    public Chunk func_673_a(int var1, int var2) {
        return this.func_704_b(var1 >> 4, var2 >> 4);
    }

    public Chunk func_704_b(int var1, int var2) {
        return this.field_1017_H.func_533_b(var1, var2);
    }

    public boolean func_643_a(int var1, int var2, int var3, int var4, int var5) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var6 = this.func_704_b(var1 >> 4, var3 >> 4);
                return var6.func_1010_a(var1 & 15, var2, var3 & 15, var4, var5);
            }
        } else {
            return false;
        }
    }

    public boolean func_634_a(int var1, int var2, int var3, int var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var5 = this.func_704_b(var1 >> 4, var3 >> 4);
                return var5.func_1022_a(var1 & 15, var2, var3 & 15, var4);
            }
        } else {
            return false;
        }
    }

    public Material func_599_f(int var1, int var2, int var3) {
        int var4 = this.func_600_a(var1, var2, var3);
        return var4 == 0 ? Material.field_1337_a : Block.field_345_n[var4].field_356_bn;
    }

    public int func_602_e(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return 0;
            } else if (var2 >= 128) {
                return 0;
            } else {
                Chunk var4 = this.func_704_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var4.func_1021_b(var1, var2, var3);
            }
        } else {
            return 0;
        }
    }

    public void func_691_b(int var1, int var2, int var3, int var4) {
        if (this.func_635_c(var1, var2, var3, var4)) {
            int var5 = this.func_600_a(var1, var2, var3);
            if (Block.field_28032_t[var5 & 255]) {
                this.func_617_e(var1, var2, var3, var5);
            } else {
                this.func_611_g(var1, var2, var3, var5);
            }
        }

    }

    public boolean func_635_c(int var1, int var2, int var3, int var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var5 = this.func_704_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                var5.func_1009_b(var1, var2, var3, var4);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean func_690_d(int var1, int var2, int var3, int var4) {
        if (this.func_634_a(var1, var2, var3, var4)) {
            this.func_617_e(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public boolean func_688_b(int var1, int var2, int var3, int var4, int var5) {
        if (this.func_643_a(var1, var2, var3, var4, var5)) {
            this.func_617_e(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public void func_665_h(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.field_9434_r.size(); ++var4) {
            ((IWorldAccess)this.field_9434_r.get(var4)).func_934_a(var1, var2, var3);
        }

    }

    protected void func_617_e(int var1, int var2, int var3, int var4) {
        this.func_665_h(var1, var2, var3);
        this.func_611_g(var1, var2, var3, var4);
    }

    public void func_680_f(int var1, int var2, int var3, int var4) {
        if (var3 > var4) {
            int var5 = var4;
            var4 = var3;
            var3 = var5;
        }

        this.func_701_b(var1, var3, var2, var1, var4, var2);
    }

    public void func_21115_j(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.field_9434_r.size(); ++var4) {
            ((IWorldAccess)this.field_9434_r.get(var4)).func_937_b(var1, var2, var3, var1, var2, var3);
        }

    }

    public void func_701_b(int var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.field_9434_r.size(); ++var7) {
            ((IWorldAccess)this.field_9434_r.get(var7)).func_937_b(var1, var2, var3, var4, var5, var6);
        }

    }

    public void func_611_g(int var1, int var2, int var3, int var4) {
        this.func_655_l(var1 - 1, var2, var3, var4);
        this.func_655_l(var1 + 1, var2, var3, var4);
        this.func_655_l(var1, var2 - 1, var3, var4);
        this.func_655_l(var1, var2 + 1, var3, var4);
        this.func_655_l(var1, var2, var3 - 1, var4);
        this.func_655_l(var1, var2, var3 + 1, var4);
    }

    private void func_655_l(int var1, int var2, int var3, int var4) {
        if (!this.field_1043_h && !this.field_1026_y) {
            Block var5 = Block.field_345_n[this.func_600_a(var1, var2, var3)];
            if (var5 != null) {
                var5.func_226_a(this, var1, var2, var3, var4);
            }

        }
    }

    public boolean func_647_i(int var1, int var2, int var3) {
        return this.func_704_b(var1 >> 4, var3 >> 4).func_1007_c(var1 & 15, var2, var3 & 15);
    }

    public int func_28104_m(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else {
            if (var2 >= 128) {
                var2 = 127;
            }

            return this.func_704_b(var1 >> 4, var3 >> 4).func_1019_c(var1 & 15, var2, var3 & 15, 0);
        }
    }

    public int func_618_j(int var1, int var2, int var3) {
        return this.func_699_a(var1, var2, var3, true);
    }

    public int func_699_a(int var1, int var2, int var3, boolean var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var4) {
                int var5 = this.func_600_a(var1, var2, var3);
                if (var5 == Block.field_410_al.field_376_bc || var5 == Block.field_446_aB.field_376_bc || var5 == Block.field_4069_aI.field_376_bc || var5 == Block.field_4059_au.field_376_bc) {
                    int var6 = this.func_699_a(var1, var2 + 1, var3, false);
                    int var7 = this.func_699_a(var1 + 1, var2, var3, false);
                    int var8 = this.func_699_a(var1 - 1, var2, var3, false);
                    int var9 = this.func_699_a(var1, var2, var3 + 1, false);
                    int var10 = this.func_699_a(var1, var2, var3 - 1, false);
                    if (var7 > var6) {
                        var6 = var7;
                    }

                    if (var8 > var6) {
                        var6 = var8;
                    }

                    if (var9 > var6) {
                        var6 = var9;
                    }

                    if (var10 > var6) {
                        var6 = var10;
                    }

                    return var6;
                }
            }

            if (var2 < 0) {
                return 0;
            } else {
                if (var2 >= 128) {
                    var2 = 127;
                }

                Chunk var11 = this.func_704_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var11.func_1019_c(var1, var2, var3, this.field_1046_e);
            }
        } else {
            return 15;
        }
    }

    public boolean func_708_k(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return true;
            } else if (!this.func_620_h(var1 >> 4, var3 >> 4)) {
                return false;
            } else {
                Chunk var4 = this.func_704_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var4.func_1007_c(var1, var2, var3);
            }
        } else {
            return false;
        }
    }

    public int func_666_c(int var1, int var2) {
        if (var1 >= -32000000 && var2 >= -32000000 && var1 < 32000000 && var2 <= 32000000) {
            if (!this.func_620_h(var1 >> 4, var2 >> 4)) {
                return 0;
            } else {
                Chunk var3 = this.func_704_b(var1 >> 4, var2 >> 4);
                return var3.func_999_b(var1 & 15, var2 & 15);
            }
        } else {
            return 0;
        }
    }

    public void func_4078_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        if (!this.field_4209_q.field_6478_e || var1 != EnumSkyBlock.Sky) {
            if (this.func_630_d(var2, var3, var4)) {
                if (var1 == EnumSkyBlock.Sky) {
                    if (this.func_708_k(var2, var3, var4)) {
                        var5 = 15;
                    }
                } else if (var1 == EnumSkyBlock.Block) {
                    int var6 = this.func_600_a(var2, var3, var4);
                    if (Block.field_339_t[var6] > var5) {
                        var5 = Block.field_339_t[var6];
                    }
                }

                if (this.func_641_a(var1, var2, var3, var4) != var5) {
                    this.func_616_a(var1, var2, var3, var4, var2, var3, var4);
                }

            }
        }
    }

    public int func_641_a(EnumSkyBlock var1, int var2, int var3, int var4) {
        if (var3 < 0) {
            var3 = 0;
        }

        if (var3 >= 128) {
            var3 = 127;
        }

        if (var3 >= 0 && var3 < 128 && var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
            int var5 = var2 >> 4;
            int var6 = var4 >> 4;
            if (!this.func_620_h(var5, var6)) {
                return 0;
            } else {
                Chunk var7 = this.func_704_b(var5, var6);
                return var7.func_1025_a(var1, var2 & 15, var3, var4 & 15);
            }
        } else {
            return var1.field_1722_c;
        }
    }

    public void func_664_b(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        if (var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
            if (var3 >= 0) {
                if (var3 < 128) {
                    if (this.func_620_h(var2 >> 4, var4 >> 4)) {
                        Chunk var6 = this.func_704_b(var2 >> 4, var4 >> 4);
                        var6.func_1011_a(var1, var2 & 15, var3, var4 & 15, var5);

                        for(int var7 = 0; var7 < this.field_9434_r.size(); ++var7) {
                            ((IWorldAccess)this.field_9434_r.get(var7)).func_934_a(var2, var3, var4);
                        }

                    }
                }
            }
        }
    }

    public float func_28099_a(int var1, int var2, int var3, int var4) {
        int var5 = this.func_618_j(var1, var2, var3);
        if (var5 < var4) {
            var5 = var4;
        }

        return this.field_4209_q.field_4219_d[var5];
    }

    public float func_598_c(int var1, int var2, int var3) {
        return this.field_4209_q.field_4219_d[this.func_618_j(var1, var2, var3)];
    }

    public boolean func_624_b() {
        return this.field_1046_e < 4;
    }

    public MovingObjectPosition func_645_a(Vec3D var1, Vec3D var2) {
        return this.func_28105_a(var1, var2, false, false);
    }

    public MovingObjectPosition func_642_a(Vec3D var1, Vec3D var2, boolean var3) {
        return this.func_28105_a(var1, var2, var3, false);
    }

    public MovingObjectPosition func_28105_a(Vec3D var1, Vec3D var2, boolean var3, boolean var4) {
        if (!Double.isNaN(var1.field_1776_a) && !Double.isNaN(var1.field_1775_b) && !Double.isNaN(var1.field_1779_c)) {
            if (!Double.isNaN(var2.field_1776_a) && !Double.isNaN(var2.field_1775_b) && !Double.isNaN(var2.field_1779_c)) {
                int var5 = MathHelper.func_1108_b(var2.field_1776_a);
                int var6 = MathHelper.func_1108_b(var2.field_1775_b);
                int var7 = MathHelper.func_1108_b(var2.field_1779_c);
                int var8 = MathHelper.func_1108_b(var1.field_1776_a);
                int var9 = MathHelper.func_1108_b(var1.field_1775_b);
                int var10 = MathHelper.func_1108_b(var1.field_1779_c);
                int var11 = this.func_600_a(var8, var9, var10);
                int var12 = this.func_602_e(var8, var9, var10);
                Block var13 = Block.field_345_n[var11];
                if ((!var4 || var13 == null || var13.func_221_d(this, var8, var9, var10) != null) && var11 > 0 && var13.func_224_a(var12, var3)) {
                    MovingObjectPosition var14 = var13.func_255_a(this, var8, var9, var10, var1, var2);
                    if (var14 != null) {
                        return var14;
                    }
                }

                var11 = 200;

                while(var11-- >= 0) {
                    if (Double.isNaN(var1.field_1776_a) || Double.isNaN(var1.field_1775_b) || Double.isNaN(var1.field_1779_c)) {
                        return null;
                    }

                    if (var8 == var5 && var9 == var6 && var10 == var7) {
                        return null;
                    }

                    boolean var39 = true;
                    boolean var40 = true;
                    boolean var41 = true;
                    double var15 = 999.0D;
                    double var17 = 999.0D;
                    double var19 = 999.0D;
                    if (var5 > var8) {
                        var15 = (double)var8 + 1.0D;
                    } else if (var5 < var8) {
                        var15 = (double)var8 + 0.0D;
                    } else {
                        var39 = false;
                    }

                    if (var6 > var9) {
                        var17 = (double)var9 + 1.0D;
                    } else if (var6 < var9) {
                        var17 = (double)var9 + 0.0D;
                    } else {
                        var40 = false;
                    }

                    if (var7 > var10) {
                        var19 = (double)var10 + 1.0D;
                    } else if (var7 < var10) {
                        var19 = (double)var10 + 0.0D;
                    } else {
                        var41 = false;
                    }

                    double var21 = 999.0D;
                    double var23 = 999.0D;
                    double var25 = 999.0D;
                    double var27 = var2.field_1776_a - var1.field_1776_a;
                    double var29 = var2.field_1775_b - var1.field_1775_b;
                    double var31 = var2.field_1779_c - var1.field_1779_c;
                    if (var39) {
                        var21 = (var15 - var1.field_1776_a) / var27;
                    }

                    if (var40) {
                        var23 = (var17 - var1.field_1775_b) / var29;
                    }

                    if (var41) {
                        var25 = (var19 - var1.field_1779_c) / var31;
                    }

                    boolean var33 = false;
                    byte var42;
                    if (var21 < var23 && var21 < var25) {
                        if (var5 > var8) {
                            var42 = 4;
                        } else {
                            var42 = 5;
                        }

                        var1.field_1776_a = var15;
                        var1.field_1775_b += var29 * var21;
                        var1.field_1779_c += var31 * var21;
                    } else if (var23 < var25) {
                        if (var6 > var9) {
                            var42 = 0;
                        } else {
                            var42 = 1;
                        }

                        var1.field_1776_a += var27 * var23;
                        var1.field_1775_b = var17;
                        var1.field_1779_c += var31 * var23;
                    } else {
                        if (var7 > var10) {
                            var42 = 2;
                        } else {
                            var42 = 3;
                        }

                        var1.field_1776_a += var27 * var25;
                        var1.field_1775_b += var29 * var25;
                        var1.field_1779_c = var19;
                    }

                    Vec3D var34 = Vec3D.func_1248_b(var1.field_1776_a, var1.field_1775_b, var1.field_1779_c);
                    var8 = (int)(var34.field_1776_a = (double)MathHelper.func_1108_b(var1.field_1776_a));
                    if (var42 == 5) {
                        --var8;
                        ++var34.field_1776_a;
                    }

                    var9 = (int)(var34.field_1775_b = (double)MathHelper.func_1108_b(var1.field_1775_b));
                    if (var42 == 1) {
                        --var9;
                        ++var34.field_1775_b;
                    }

                    var10 = (int)(var34.field_1779_c = (double)MathHelper.func_1108_b(var1.field_1779_c));
                    if (var42 == 3) {
                        --var10;
                        ++var34.field_1779_c;
                    }

                    int var35 = this.func_600_a(var8, var9, var10);
                    int var36 = this.func_602_e(var8, var9, var10);
                    Block var37 = Block.field_345_n[var35];
                    if ((!var4 || var37 == null || var37.func_221_d(this, var8, var9, var10) != null) && var35 > 0 && var37.func_224_a(var36, var3)) {
                        MovingObjectPosition var38 = var37.func_255_a(this, var8, var9, var10, var1, var2);
                        if (var38 != null) {
                            return var38;
                        }
                    }
                }

                return null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void func_623_a(Entity var1, String var2, float var3, float var4) {
        for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
            ((IWorldAccess)this.field_9434_r.get(var5)).func_940_a(var2, var1.field_611_ak, var1.field_610_al - (double)var1.field_9292_aO, var1.field_609_am, var3, var4);
        }

    }

    public void func_684_a(double var1, double var3, double var5, String var7, float var8, float var9) {
        for(int var10 = 0; var10 < this.field_9434_r.size(); ++var10) {
            ((IWorldAccess)this.field_9434_r.get(var10)).func_940_a(var7, var1, var3, var5, var8, var9);
        }

    }

    public void func_670_a(String var1, int var2, int var3, int var4) {
        for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
            ((IWorldAccess)this.field_9434_r.get(var5)).func_933_a(var1, var2, var3, var4);
        }

    }

    public void func_694_a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        for(int var14 = 0; var14 < this.field_9434_r.size(); ++var14) {
            ((IWorldAccess)this.field_9434_r.get(var14)).func_939_a(var1, var2, var4, var6, var8, var10, var12);
        }

    }

    public boolean func_27159_a(Entity var1) {
        this.field_27173_e.add(var1);
        return true;
    }

    public boolean func_674_a(Entity var1) {
        int var2 = MathHelper.func_1108_b(var1.field_611_ak / 16.0D);
        int var3 = MathHelper.func_1108_b(var1.field_609_am / 16.0D);
        boolean var4 = false;
        if (var1 instanceof EntityPlayer) {
            var4 = true;
        }

        if (!var4 && !this.func_620_h(var2, var3)) {
            return false;
        } else {
            if (var1 instanceof EntityPlayer) {
                EntityPlayer var5 = (EntityPlayer)var1;
                this.field_1040_k.add(var5);
                this.func_22140_w();
            }

            this.func_704_b(var2, var3).func_1000_a(var1);
            this.field_1050_a.add(var1);
            this.func_606_b(var1);
            return true;
        }
    }

    protected void func_606_b(Entity var1) {
        for(int var2 = 0; var2 < this.field_9434_r.size(); ++var2) {
            ((IWorldAccess)this.field_9434_r.get(var2)).func_941_a(var1);
        }

    }

    protected void func_678_c(Entity var1) {
        for(int var2 = 0; var2 < this.field_9434_r.size(); ++var2) {
            ((IWorldAccess)this.field_9434_r.get(var2)).func_938_b(var1);
        }

    }

    public void func_607_d(Entity var1) {
        if (var1.field_617_ae != null) {
            var1.field_617_ae.func_6377_h((Entity)null);
        }

        if (var1.field_616_af != null) {
            var1.func_6377_h((Entity)null);
        }

        var1.func_395_F();
        if (var1 instanceof EntityPlayer) {
            this.field_1040_k.remove((EntityPlayer)var1);
            this.func_22140_w();
        }

    }

    public void func_613_a(IWorldAccess var1) {
        this.field_9434_r.add(var1);
    }

    public void func_672_b(IWorldAccess var1) {
        this.field_9434_r.remove(var1);
    }

    public List func_697_a(Entity var1, AxisAlignedBB var2) {
        this.field_9428_I.clear();
        int var3 = MathHelper.func_1108_b(var2.field_1698_a);
        int var4 = MathHelper.func_1108_b(var2.field_1703_d + 1.0D);
        int var5 = MathHelper.func_1108_b(var2.field_1697_b);
        int var6 = MathHelper.func_1108_b(var2.field_1702_e + 1.0D);
        int var7 = MathHelper.func_1108_b(var2.field_1704_c);
        int var8 = MathHelper.func_1108_b(var2.field_1701_f + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var7; var10 < var8; ++var10) {
                if (this.func_630_d(var9, 64, var10)) {
                    for(int var11 = var5 - 1; var11 < var6; ++var11) {
                        Block var12 = Block.field_345_n[this.func_600_a(var9, var11, var10)];
                        if (var12 != null) {
                            var12.func_230_a(this, var9, var11, var10, var2, this.field_9428_I);
                        }
                    }
                }
            }
        }

        double var14 = 0.25D;
        List var15 = this.func_659_b(var1, var2.func_1177_b(var14, var14, var14));

        for(int var16 = 0; var16 < var15.size(); ++var16) {
            AxisAlignedBB var13 = ((Entity)var15.get(var16)).func_372_f_();
            if (var13 != null && var13.func_1178_a(var2)) {
                this.field_9428_I.add(var13);
            }

            var13 = var1.func_383_b_((Entity)var15.get(var16));
            if (var13 != null && var13.func_1178_a(var2)) {
                this.field_9428_I.add(var13);
            }
        }

        return this.field_9428_I;
    }

    public int func_671_a(float var1) {
        float var2 = this.func_619_c(var1);
        float var3 = 1.0F - (MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        var3 = 1.0F - var3;
        var3 = (float)((double)var3 * (1.0D - (double)(this.func_27162_g(var1) * 5.0F) / 16.0D));
        var3 = (float)((double)var3 * (1.0D - (double)(this.func_27166_f(var1) * 5.0F) / 16.0D));
        var3 = 1.0F - var3;
        return (int)(var3 * 11.0F);
    }

    public Vec3D func_4079_a(Entity var1, float var2) {
        float var3 = this.func_619_c(var2);
        float var4 = MathHelper.func_1114_b(var3 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
        if (var4 < 0.0F) {
            var4 = 0.0F;
        }

        if (var4 > 1.0F) {
            var4 = 1.0F;
        }

        int var5 = MathHelper.func_1108_b(var1.field_611_ak);
        int var6 = MathHelper.func_1108_b(var1.field_609_am);
        float var7 = (float)this.func_4075_a().func_4072_b(var5, var6);
        int var8 = this.func_4075_a().func_4073_a(var5, var6).func_4126_a(var7);
        float var9 = (float)(var8 >> 16 & 255) / 255.0F;
        float var10 = (float)(var8 >> 8 & 255) / 255.0F;
        float var11 = (float)(var8 & 255) / 255.0F;
        var9 *= var4;
        var10 *= var4;
        var11 *= var4;
        float var12 = this.func_27162_g(var2);
        float var13;
        float var14;
        if (var12 > 0.0F) {
            var13 = (var9 * 0.3F + var10 * 0.59F + var11 * 0.11F) * 0.6F;
            var14 = 1.0F - var12 * 0.75F;
            var9 = var9 * var14 + var13 * (1.0F - var14);
            var10 = var10 * var14 + var13 * (1.0F - var14);
            var11 = var11 * var14 + var13 * (1.0F - var14);
        }

        var13 = this.func_27166_f(var2);
        if (var13 > 0.0F) {
            var14 = (var9 * 0.3F + var10 * 0.59F + var11 * 0.11F) * 0.2F;
            float var15 = 1.0F - var13 * 0.75F;
            var9 = var9 * var15 + var14 * (1.0F - var15);
            var10 = var10 * var15 + var14 * (1.0F - var15);
            var11 = var11 * var15 + var14 * (1.0F - var15);
        }

        if (this.field_27172_i > 0) {
            var14 = (float)this.field_27172_i - var2;
            if (var14 > 1.0F) {
                var14 = 1.0F;
            }

            var14 *= 0.45F;
            var9 = var9 * (1.0F - var14) + 0.8F * var14;
            var10 = var10 * (1.0F - var14) + 0.8F * var14;
            var11 = var11 * (1.0F - var14) + 1.0F * var14;
        }

        return Vec3D.func_1248_b((double)var9, (double)var10, (double)var11);
    }

    public float func_619_c(float var1) {
        return this.field_4209_q.func_4100_a(this.field_22145_q.func_22304_f(), var1);
    }

    public Vec3D func_628_d(float var1) {
        float var2 = this.func_619_c(var1);
        float var3 = MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        float var4 = (float)(this.field_1019_F >> 16 & 255L) / 255.0F;
        float var5 = (float)(this.field_1019_F >> 8 & 255L) / 255.0F;
        float var6 = (float)(this.field_1019_F & 255L) / 255.0F;
        float var7 = this.func_27162_g(var1);
        float var8;
        float var9;
        if (var7 > 0.0F) {
            var8 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.6F;
            var9 = 1.0F - var7 * 0.95F;
            var4 = var4 * var9 + var8 * (1.0F - var9);
            var5 = var5 * var9 + var8 * (1.0F - var9);
            var6 = var6 * var9 + var8 * (1.0F - var9);
        }

        var4 *= var3 * 0.9F + 0.1F;
        var5 *= var3 * 0.9F + 0.1F;
        var6 *= var3 * 0.85F + 0.15F;
        var8 = this.func_27166_f(var1);
        if (var8 > 0.0F) {
            var9 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.2F;
            float var10 = 1.0F - var8 * 0.95F;
            var4 = var4 * var10 + var9 * (1.0F - var10);
            var5 = var5 * var10 + var9 * (1.0F - var10);
            var6 = var6 * var10 + var9 * (1.0F - var10);
        }

        return Vec3D.func_1248_b((double)var4, (double)var5, (double)var6);
    }

    public Vec3D func_4082_d(float var1) {
        float var2 = this.func_619_c(var1);
        return this.field_4209_q.func_4096_a(var2, var1);
    }

    public int func_4083_e(int var1, int var2) {
        Chunk var3 = this.func_673_a(var1, var2);
        int var4 = 127;
        var1 &= 15;

        for(var2 &= 15; var4 > 0; --var4) {
            int var5 = var3.func_1008_a(var1, var4, var2);
            Material var6 = var5 == 0 ? Material.field_1337_a : Block.field_345_n[var5].field_356_bn;
            if (var6.func_880_c() || var6.func_879_d()) {
                return var4 + 1;
            }
        }

        return -1;
    }

    public float func_679_f(float var1) {
        float var2 = this.func_619_c(var1);
        float var3 = 1.0F - (MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.75F);
        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        return var3 * var3 * 0.5F;
    }

    public void func_22136_c(int var1, int var2, int var3, int var4, int var5) {
        NextTickListEntry var6 = new NextTickListEntry(var1, var2, var3, var4);
        byte var7 = 8;
        if (this.field_4214_a) {
            if (this.func_640_a(var6.field_1361_a - var7, var6.field_1360_b - var7, var6.field_1366_c - var7, var6.field_1361_a + var7, var6.field_1360_b + var7, var6.field_1366_c + var7)) {
                int var8 = this.func_600_a(var6.field_1361_a, var6.field_1360_b, var6.field_1366_c);
                if (var8 == var6.field_1365_d && var8 > 0) {
                    Block.field_345_n[var8].func_208_a(this, var6.field_1361_a, var6.field_1360_b, var6.field_1366_c, this.field_1037_n);
                }
            }

        } else {
            if (this.func_640_a(var1 - var7, var2 - var7, var3 - var7, var1 + var7, var2 + var7, var3 + var7)) {
                if (var4 > 0) {
                    var6.func_900_a((long)var5 + this.field_22145_q.func_22304_f());
                }

                if (!this.field_1056_C.contains(var6)) {
                    this.field_1056_C.add(var6);
                    this.field_1058_B.add(var6);
                }
            }

        }
    }

    public void func_633_c() {
        int var1;
        Entity var2;
        for(var1 = 0; var1 < this.field_27173_e.size(); ++var1) {
            var2 = (Entity)this.field_27173_e.get(var1);
            var2.func_370_e_();
            if (var2.field_646_aA) {
                this.field_27173_e.remove(var1--);
            }
        }

        this.field_1050_a.removeAll(this.field_1024_A);

        int var3;
        int var4;
        for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
            var2 = (Entity)this.field_1024_A.get(var1);
            var3 = var2.field_657_ba;
            var4 = var2.field_654_bc;
            if (var2.field_621_aZ && this.func_620_h(var3, var4)) {
                this.func_704_b(var3, var4).func_1015_b(var2);
            }
        }

        for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
            this.func_678_c((Entity)this.field_1024_A.get(var1));
        }

        this.field_1024_A.clear();

        for(var1 = 0; var1 < this.field_1050_a.size(); ++var1) {
            var2 = (Entity)this.field_1050_a.get(var1);
            if (var2.field_616_af != null) {
                if (!var2.field_616_af.field_646_aA && var2.field_616_af.field_617_ae == var2) {
                    continue;
                }

                var2.field_616_af.field_617_ae = null;
                var2.field_616_af = null;
            }

            if (!var2.field_646_aA) {
                this.func_667_e(var2);
            }

            if (var2.field_646_aA) {
                var3 = var2.field_657_ba;
                var4 = var2.field_654_bc;
                if (var2.field_621_aZ && this.func_620_h(var3, var4)) {
                    this.func_704_b(var3, var4).func_1015_b(var2);
                }

                this.field_1050_a.remove(var1--);
                this.func_678_c(var2);
            }
        }

        this.field_31055_L = true;
        Iterator var10 = this.field_1049_b.iterator();

        while(var10.hasNext()) {
            TileEntity var5 = (TileEntity)var10.next();
            if (!var5.func_31006_g()) {
                var5.func_475_b();
            }

            if (var5.func_31006_g()) {
                var10.remove();
                Chunk var7 = this.func_704_b(var5.field_823_f >> 4, var5.field_821_h >> 4);
                if (var7 != null) {
                    var7.func_1023_e(var5.field_823_f & 15, var5.field_822_g, var5.field_821_h & 15);
                }
            }
        }

        this.field_31055_L = false;
        if (!this.field_30900_E.isEmpty()) {
            Iterator var6 = this.field_30900_E.iterator();

            while(var6.hasNext()) {
                TileEntity var8 = (TileEntity)var6.next();
                if (!var8.func_31006_g()) {
                    if (!this.field_1049_b.contains(var8)) {
                        this.field_1049_b.add(var8);
                    }

                    Chunk var9 = this.func_704_b(var8.field_823_f >> 4, var8.field_821_h >> 4);
                    if (var9 != null) {
                        var9.func_1005_a(var8.field_823_f & 15, var8.field_822_g, var8.field_821_h & 15, var8);
                    }

                    this.func_665_h(var8.field_823_f, var8.field_822_g, var8.field_821_h);
                }
            }

            this.field_30900_E.clear();
        }

    }

    public void func_31054_a(Collection var1) {
        if (this.field_31055_L) {
            this.field_30900_E.addAll(var1);
        } else {
            this.field_1049_b.addAll(var1);
        }

    }

    public void func_667_e(Entity var1) {
        this.func_4084_a(var1, true);
    }

    public void func_4084_a(Entity var1, boolean var2) {
        int var3 = MathHelper.func_1108_b(var1.field_611_ak);
        int var4 = MathHelper.func_1108_b(var1.field_609_am);
        byte var5 = 32;
        if (!var2 || this.func_640_a(var3 - var5, 0, var4 - var5, var3 + var5, 128, var4 + var5)) {
            var1.field_638_aI = var1.field_611_ak;
            var1.field_637_aJ = var1.field_610_al;
            var1.field_636_aK = var1.field_609_am;
            var1.field_603_as = var1.field_605_aq;
            var1.field_602_at = var1.field_604_ar;
            if (var2 && var1.field_621_aZ) {
                if (var1.field_616_af != null) {
                    var1.func_350_p();
                } else {
                    var1.func_370_e_();
                }
            }

            if (Double.isNaN(var1.field_611_ak) || Double.isInfinite(var1.field_611_ak)) {
                var1.field_611_ak = var1.field_638_aI;
            }

            if (Double.isNaN(var1.field_610_al) || Double.isInfinite(var1.field_610_al)) {
                var1.field_610_al = var1.field_637_aJ;
            }

            if (Double.isNaN(var1.field_609_am) || Double.isInfinite(var1.field_609_am)) {
                var1.field_609_am = var1.field_636_aK;
            }

            if (Double.isNaN((double)var1.field_604_ar) || Double.isInfinite((double)var1.field_604_ar)) {
                var1.field_604_ar = var1.field_602_at;
            }

            if (Double.isNaN((double)var1.field_605_aq) || Double.isInfinite((double)var1.field_605_aq)) {
                var1.field_605_aq = var1.field_603_as;
            }

            int var6 = MathHelper.func_1108_b(var1.field_611_ak / 16.0D);
            int var7 = MathHelper.func_1108_b(var1.field_610_al / 16.0D);
            int var8 = MathHelper.func_1108_b(var1.field_609_am / 16.0D);
            if (!var1.field_621_aZ || var1.field_657_ba != var6 || var1.field_656_bb != var7 || var1.field_654_bc != var8) {
                if (var1.field_621_aZ && this.func_620_h(var1.field_657_ba, var1.field_654_bc)) {
                    this.func_704_b(var1.field_657_ba, var1.field_654_bc).func_1016_a(var1, var1.field_656_bb);
                }

                if (this.func_620_h(var6, var8)) {
                    var1.field_621_aZ = true;
                    this.func_704_b(var6, var8).func_1000_a(var1);
                } else {
                    var1.field_621_aZ = false;
                }
            }

            if (var2 && var1.field_621_aZ && var1.field_617_ae != null) {
                if (!var1.field_617_ae.field_646_aA && var1.field_617_ae.field_616_af == var1) {
                    this.func_667_e(var1.field_617_ae);
                } else {
                    var1.field_617_ae.field_616_af = null;
                    var1.field_617_ae = null;
                }
            }

        }
    }

    public boolean func_604_a(AxisAlignedBB var1) {
        List var2 = this.func_659_b((Entity)null, var1);

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            Entity var4 = (Entity)var2.get(var3);
            if (!var4.field_646_aA && var4.field_618_ad) {
                return false;
            }
        }

        return true;
    }

    public boolean func_662_b(AxisAlignedBB var1) {
        int var2 = MathHelper.func_1108_b(var1.field_1698_a);
        int var3 = MathHelper.func_1108_b(var1.field_1703_d + 1.0D);
        int var4 = MathHelper.func_1108_b(var1.field_1697_b);
        int var5 = MathHelper.func_1108_b(var1.field_1702_e + 1.0D);
        int var6 = MathHelper.func_1108_b(var1.field_1704_c);
        int var7 = MathHelper.func_1108_b(var1.field_1701_f + 1.0D);
        if (var1.field_1698_a < 0.0D) {
            --var2;
        }

        if (var1.field_1697_b < 0.0D) {
            --var4;
        }

        if (var1.field_1704_c < 0.0D) {
            --var6;
        }

        for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
                for(int var10 = var6; var10 < var7; ++var10) {
                    Block var11 = Block.field_345_n[this.func_600_a(var8, var9, var10)];
                    if (var11 != null && var11.field_356_bn.func_879_d()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean func_605_c(AxisAlignedBB var1) {
        int var2 = MathHelper.func_1108_b(var1.field_1698_a);
        int var3 = MathHelper.func_1108_b(var1.field_1703_d + 1.0D);
        int var4 = MathHelper.func_1108_b(var1.field_1697_b);
        int var5 = MathHelper.func_1108_b(var1.field_1702_e + 1.0D);
        int var6 = MathHelper.func_1108_b(var1.field_1704_c);
        int var7 = MathHelper.func_1108_b(var1.field_1701_f + 1.0D);
        if (this.func_640_a(var2, var4, var6, var3, var5, var7)) {
            for(int var8 = var2; var8 < var3; ++var8) {
                for(int var9 = var4; var9 < var5; ++var9) {
                    for(int var10 = var6; var10 < var7; ++var10) {
                        int var11 = this.func_600_a(var8, var9, var10);
                        if (var11 == Block.field_402_as.field_376_bc || var11 == Block.field_397_D.field_376_bc || var11 == Block.field_395_E.field_376_bc) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean func_682_a(AxisAlignedBB var1, Material var2, Entity var3) {
        int var4 = MathHelper.func_1108_b(var1.field_1698_a);
        int var5 = MathHelper.func_1108_b(var1.field_1703_d + 1.0D);
        int var6 = MathHelper.func_1108_b(var1.field_1697_b);
        int var7 = MathHelper.func_1108_b(var1.field_1702_e + 1.0D);
        int var8 = MathHelper.func_1108_b(var1.field_1704_c);
        int var9 = MathHelper.func_1108_b(var1.field_1701_f + 1.0D);
        if (!this.func_640_a(var4, var6, var8, var5, var7, var9)) {
            return false;
        } else {
            boolean var10 = false;
            Vec3D var11 = Vec3D.func_1248_b(0.0D, 0.0D, 0.0D);

            for(int var12 = var4; var12 < var5; ++var12) {
                for(int var13 = var6; var13 < var7; ++var13) {
                    for(int var14 = var8; var14 < var9; ++var14) {
                        Block var15 = Block.field_345_n[this.func_600_a(var12, var13, var14)];
                        if (var15 != null && var15.field_356_bn == var2) {
                            double var16 = (double)((float)(var13 + 1) - BlockFluid.func_288_b(this.func_602_e(var12, var13, var14)));
                            if ((double)var7 >= var16) {
                                var10 = true;
                                var15.func_257_a(this, var12, var13, var14, var3, var11);
                            }
                        }
                    }
                }
            }

            if (var11.func_1253_c() > 0.0D) {
                var11 = var11.func_1252_b();
                double var18 = 0.014D;
                var3.field_608_an += var11.field_1776_a * var18;
                var3.field_607_ao += var11.field_1775_b * var18;
                var3.field_606_ap += var11.field_1779_c * var18;
            }

            return var10;
        }
    }

    public boolean func_689_a(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.func_1108_b(var1.field_1698_a);
        int var4 = MathHelper.func_1108_b(var1.field_1703_d + 1.0D);
        int var5 = MathHelper.func_1108_b(var1.field_1697_b);
        int var6 = MathHelper.func_1108_b(var1.field_1702_e + 1.0D);
        int var7 = MathHelper.func_1108_b(var1.field_1704_c);
        int var8 = MathHelper.func_1108_b(var1.field_1701_f + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var5; var10 < var6; ++var10) {
                for(int var11 = var7; var11 < var8; ++var11) {
                    Block var12 = Block.field_345_n[this.func_600_a(var9, var10, var11)];
                    if (var12 != null && var12.field_356_bn == var2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean func_707_b(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.func_1108_b(var1.field_1698_a);
        int var4 = MathHelper.func_1108_b(var1.field_1703_d + 1.0D);
        int var5 = MathHelper.func_1108_b(var1.field_1697_b);
        int var6 = MathHelper.func_1108_b(var1.field_1702_e + 1.0D);
        int var7 = MathHelper.func_1108_b(var1.field_1704_c);
        int var8 = MathHelper.func_1108_b(var1.field_1701_f + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var5; var10 < var6; ++var10) {
                for(int var11 = var7; var11 < var8; ++var11) {
                    Block var12 = Block.field_345_n[this.func_600_a(var9, var10, var11)];
                    if (var12 != null && var12.field_356_bn == var2) {
                        int var13 = this.func_602_e(var9, var10, var11);
                        double var14 = (double)(var10 + 1);
                        if (var13 < 8) {
                            var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
                        }

                        if (var14 >= var1.field_1697_b) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public Explosion func_12243_a(Entity var1, double var2, double var4, double var6, float var8) {
        return this.func_12244_a(var1, var2, var4, var6, var8, false);
    }

    public Explosion func_12244_a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
        Explosion var10 = new Explosion(this, var1, var2, var4, var6, var8);
        var10.field_12257_a = var9;
        var10.func_12248_a();
        var10.func_12247_b(true);
        return var10;
    }

    public float func_675_a(Vec3D var1, AxisAlignedBB var2) {
        double var3 = 1.0D / ((var2.field_1703_d - var2.field_1698_a) * 2.0D + 1.0D);
        double var5 = 1.0D / ((var2.field_1702_e - var2.field_1697_b) * 2.0D + 1.0D);
        double var7 = 1.0D / ((var2.field_1701_f - var2.field_1704_c) * 2.0D + 1.0D);
        int var9 = 0;
        int var10 = 0;

        for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
            for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
                for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
                    double var14 = var2.field_1698_a + (var2.field_1703_d - var2.field_1698_a) * (double)var11;
                    double var16 = var2.field_1697_b + (var2.field_1702_e - var2.field_1697_b) * (double)var12;
                    double var18 = var2.field_1704_c + (var2.field_1701_f - var2.field_1704_c) * (double)var13;
                    if (this.func_645_a(Vec3D.func_1248_b(var14, var16, var18), var1) == null) {
                        ++var9;
                    }

                    ++var10;
                }
            }
        }

        return (float)var9 / (float)var10;
    }

    public void func_612_i(EntityPlayer var1, int var2, int var3, int var4, int var5) {
        if (var5 == 0) {
            --var3;
        }

        if (var5 == 1) {
            ++var3;
        }

        if (var5 == 2) {
            --var4;
        }

        if (var5 == 3) {
            ++var4;
        }

        if (var5 == 4) {
            --var2;
        }

        if (var5 == 5) {
            ++var2;
        }

        if (this.func_600_a(var2, var3, var4) == Block.field_402_as.field_376_bc) {
            this.func_28107_a(var1, 1004, var2, var3, var4, 0);
            this.func_690_d(var2, var3, var4, 0);
        }

    }

    public Entity func_4085_a(Class var1) {
        return null;
    }

    public String func_687_d() {
        return "All: " + this.field_1050_a.size();
    }

    public String func_21119_g() {
        return this.field_1017_H.func_21109_c();
    }

    public TileEntity func_603_b(int var1, int var2, int var3) {
        Chunk var4 = this.func_704_b(var1 >> 4, var3 >> 4);
        return var4 != null ? var4.func_1002_d(var1 & 15, var2, var3 & 15) : null;
    }

    public void func_654_a(int var1, int var2, int var3, TileEntity var4) {
        if (!var4.func_31006_g()) {
            if (this.field_31055_L) {
                var4.field_823_f = var1;
                var4.field_822_g = var2;
                var4.field_821_h = var3;
                this.field_30900_E.add(var4);
            } else {
                this.field_1049_b.add(var4);
                Chunk var5 = this.func_704_b(var1 >> 4, var3 >> 4);
                if (var5 != null) {
                    var5.func_1005_a(var1 & 15, var2, var3 & 15, var4);
                }
            }
        }

    }

    public void func_692_l(int var1, int var2, int var3) {
        TileEntity var4 = this.func_603_b(var1, var2, var3);
        if (var4 != null && this.field_31055_L) {
            var4.func_31005_i();
        } else {
            if (var4 != null) {
                this.field_1049_b.remove(var4);
            }

            Chunk var5 = this.func_704_b(var1 >> 4, var3 >> 4);
            if (var5 != null) {
                var5.func_1023_e(var1 & 15, var2, var3 & 15);
            }
        }

    }

    public boolean func_601_g(int var1, int var2, int var3) {
        Block var4 = Block.field_345_n[this.func_600_a(var1, var2, var3)];
        return var4 == null ? false : var4.func_217_b();
    }

    public boolean func_28100_h(int var1, int var2, int var3) {
        Block var4 = Block.field_345_n[this.func_600_a(var1, var2, var3)];
        if (var4 == null) {
            return false;
        } else {
            return var4.field_356_bn.func_28126_h() && var4.func_242_c();
        }
    }

    public void func_651_a(IProgressUpdate var1) {
        this.func_639_a(true, var1);
    }

    public boolean func_6465_g() {
        if (this.field_4204_J >= 50) {
            return false;
        } else {
            ++this.field_4204_J;

            boolean var2;
            try {
                int var1 = 500;

                while(this.field_1051_z.size() > 0) {
                    --var1;
                    if (var1 <= 0) {
                        var2 = true;
                        return var2;
                    }

                    ((MetadataChunkBlock)this.field_1051_z.remove(this.field_1051_z.size() - 1)).func_4127_a(this);
                }

                var2 = false;
            } finally {
                --this.field_4204_J;
            }

            return var2;
        }
    }

    public void func_616_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.func_627_a(var1, var2, var3, var4, var5, var6, var7, true);
    }

    public void func_627_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
        if (!this.field_4209_q.field_6478_e || var1 != EnumSkyBlock.Sky) {
            ++field_9429_y;

            try {
                if (field_9429_y != 50) {
                    int var9 = (var5 + var2) / 2;
                    int var10 = (var7 + var4) / 2;
                    if (this.func_630_d(var9, 64, var10)) {
                        if (!this.func_673_a(var9, var10).func_21167_h()) {
                            int var11 = this.field_1051_z.size();
                            int var12;
                            if (var8) {
                                var12 = 5;
                                if (var12 > var11) {
                                    var12 = var11;
                                }

                                for(int var13 = 0; var13 < var12; ++var13) {
                                    MetadataChunkBlock var14 = (MetadataChunkBlock)this.field_1051_z.get(this.field_1051_z.size() - var13 - 1);
                                    if (var14.field_1299_a == var1 && var14.func_866_a(var2, var3, var4, var5, var6, var7)) {
                                        return;
                                    }
                                }
                            }

                            this.field_1051_z.add(new MetadataChunkBlock(var1, var2, var3, var4, var5, var6, var7));
                            var12 = 1000000;
                            if (this.field_1051_z.size() > 1000000) {
                                System.out.println("More than " + var12 + " updates, aborting lighting updates");
                                this.field_1051_z.clear();
                            }

                        }
                    }
                }
            } finally {
                --field_9429_y;
            }
        }
    }

    public void func_644_f() {
        int var1 = this.func_671_a(1.0F);
        if (var1 != this.field_1046_e) {
            this.field_1046_e = var1;
        }

    }

    public void func_21114_a(boolean var1, boolean var2) {
        this.field_21121_K = var1;
        this.field_21120_L = var2;
    }

    public void func_649_g() {
        this.func_27165_m();
        long var2;
        if (this.func_22142_y()) {
            boolean var1 = false;
            if (this.field_21121_K && this.field_1039_l >= 1) {
                var1 = SpawnerAnimals.func_22390_a(this, this.field_1040_k);
            }

            if (!var1) {
                var2 = this.field_22145_q.func_22304_f() + 24000L;
                this.field_22145_q.func_22307_a(var2 - var2 % 24000L);
                this.func_22141_x();
            }
        }

        SpawnerAnimals.func_4154_a(this, this.field_21121_K, this.field_21120_L);
        this.field_1017_H.func_532_a();
        int var4 = this.func_671_a(1.0F);
        if (var4 != this.field_1046_e) {
            this.field_1046_e = var4;

            for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
                ((IWorldAccess)this.field_9434_r.get(var5)).func_936_e();
            }
        }

        var2 = this.field_22145_q.func_22304_f() + 1L;
        if (var2 % (long)this.field_9435_j == 0L) {
            this.func_639_a(false, (IProgressUpdate)null);
        }

        this.field_22145_q.func_22307_a(var2);
        this.func_700_a(false);
        this.func_4080_j();
    }

    private void func_27163_E() {
        if (this.field_22145_q.func_27397_o()) {
            this.field_27171_C = 1.0F;
            if (this.field_22145_q.func_27396_m()) {
                this.field_27169_E = 1.0F;
            }
        }

    }

    protected void func_27165_m() {
        if (!this.field_4209_q.field_6478_e) {
            if (this.field_27168_F > 0) {
                --this.field_27168_F;
            }

            int var1 = this.field_22145_q.func_27400_n();
            if (var1 <= 0) {
                if (this.field_22145_q.func_27396_m()) {
                    this.field_22145_q.func_27399_e(this.field_1037_n.nextInt(12000) + 3600);
                } else {
                    this.field_22145_q.func_27399_e(this.field_1037_n.nextInt(168000) + 12000);
                }
            } else {
                --var1;
                this.field_22145_q.func_27399_e(var1);
                if (var1 <= 0) {
                    this.field_22145_q.func_27398_a(!this.field_22145_q.func_27396_m());
                }
            }

            int var2 = this.field_22145_q.func_27393_p();
            if (var2 <= 0) {
                if (this.field_22145_q.func_27397_o()) {
                    this.field_22145_q.func_27395_f(this.field_1037_n.nextInt(12000) + 12000);
                } else {
                    this.field_22145_q.func_27395_f(this.field_1037_n.nextInt(168000) + 12000);
                }
            } else {
                --var2;
                this.field_22145_q.func_27395_f(var2);
                if (var2 <= 0) {
                    this.field_22145_q.func_27394_b(!this.field_22145_q.func_27397_o());
                }
            }

            this.field_26901_B = this.field_27171_C;
            if (this.field_22145_q.func_27397_o()) {
                this.field_27171_C = (float)((double)this.field_27171_C + 0.01D);
            } else {
                this.field_27171_C = (float)((double)this.field_27171_C - 0.01D);
            }

            if (this.field_27171_C < 0.0F) {
                this.field_27171_C = 0.0F;
            }

            if (this.field_27171_C > 1.0F) {
                this.field_27171_C = 1.0F;
            }

            this.field_27170_D = this.field_27169_E;
            if (this.field_22145_q.func_27396_m()) {
                this.field_27169_E = (float)((double)this.field_27169_E + 0.01D);
            } else {
                this.field_27169_E = (float)((double)this.field_27169_E - 0.01D);
            }

            if (this.field_27169_E < 0.0F) {
                this.field_27169_E = 0.0F;
            }

            if (this.field_27169_E > 1.0F) {
                this.field_27169_E = 1.0F;
            }

        }
    }

    private void func_27164_F() {
        this.field_22145_q.func_27395_f(0);
        this.field_22145_q.func_27394_b(false);
        this.field_22145_q.func_27399_e(0);
        this.field_22145_q.func_27398_a(false);
    }

    protected void func_4080_j() {
        this.field_9427_K.clear();

        int var3;
        int var4;
        int var6;
        int var7;
        for(int var1 = 0; var1 < this.field_1040_k.size(); ++var1) {
            EntityPlayer var2 = (EntityPlayer)this.field_1040_k.get(var1);
            var3 = MathHelper.func_1108_b(var2.field_611_ak / 16.0D);
            var4 = MathHelper.func_1108_b(var2.field_609_am / 16.0D);
            byte var5 = 9;

            for(var6 = -var5; var6 <= var5; ++var6) {
                for(var7 = -var5; var7 <= var5; ++var7) {
                    this.field_9427_K.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
                }
            }
        }

        if (this.field_9426_L > 0) {
            --this.field_9426_L;
        }

        Iterator var12 = this.field_9427_K.iterator();

        while(var12.hasNext()) {
            ChunkCoordIntPair var13 = (ChunkCoordIntPair)var12.next();
            var3 = var13.field_189_a * 16;
            var4 = var13.field_188_b * 16;
            Chunk var14 = this.func_704_b(var13.field_189_a, var13.field_188_b);
            int var8;
            int var9;
            int var10;
            if (this.field_9426_L == 0) {
                this.field_9437_g = this.field_9437_g * 3 + 1013904223;
                var6 = this.field_9437_g >> 2;
                var7 = var6 & 15;
                var8 = var6 >> 8 & 15;
                var9 = var6 >> 16 & 127;
                var10 = var14.func_1008_a(var7, var9, var8);
                var7 += var3;
                var8 += var4;
                if (var10 == 0 && this.func_28104_m(var7, var9, var8) <= this.field_1037_n.nextInt(8) && this.func_641_a(EnumSkyBlock.Sky, var7, var9, var8) <= 0) {
                    EntityPlayer var11 = this.func_683_a((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D, 8.0D);
                    if (var11 != null && var11.func_360_d((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D) > 4.0D) {
                        this.func_684_a((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_1037_n.nextFloat() * 0.2F);
                        this.field_9426_L = this.field_1037_n.nextInt(12000) + 6000;
                    }
                }
            }

            if (this.field_1037_n.nextInt(100000) == 0 && this.func_27161_C() && this.func_27160_B()) {
                this.field_9437_g = this.field_9437_g * 3 + 1013904223;
                var6 = this.field_9437_g >> 2;
                var7 = var3 + (var6 & 15);
                var8 = var4 + (var6 >> 8 & 15);
                var9 = this.func_4083_e(var7, var8);
                if (this.func_27167_r(var7, var9, var8)) {
                    this.func_27159_a(new EntityLightningBolt(this, (double)var7, (double)var9, (double)var8));
                    this.field_27168_F = 2;
                }
            }

            int var15;
            if (this.field_1037_n.nextInt(16) == 0) {
                this.field_9437_g = this.field_9437_g * 3 + 1013904223;
                var6 = this.field_9437_g >> 2;
                var7 = var6 & 15;
                var8 = var6 >> 8 & 15;
                var9 = this.func_4083_e(var7 + var3, var8 + var4);
                if (this.func_4075_a().func_4073_a(var7 + var3, var8 + var4).func_27078_c() && var9 >= 0 && var9 < 128 && var14.func_1025_a(EnumSkyBlock.Block, var7, var9, var8) < 10) {
                    var10 = var14.func_1008_a(var7, var9 - 1, var8);
                    var15 = var14.func_1008_a(var7, var9, var8);
                    if (this.func_27161_C() && var15 == 0 && Block.field_428_aT.func_243_a(this, var7 + var3, var9, var8 + var4) && var10 != 0 && var10 != Block.field_4063_aU.field_376_bc && Block.field_345_n[var10].field_356_bn.func_880_c()) {
                        this.func_690_d(var7 + var3, var9, var8 + var4, Block.field_428_aT.field_376_bc);
                    }

                    if (var10 == Block.field_399_C.field_376_bc && var14.func_1021_b(var7, var9 - 1, var8) == 0) {
                        this.func_690_d(var7 + var3, var9 - 1, var8 + var4, Block.field_4063_aU.field_376_bc);
                    }
                }
            }

            for(var6 = 0; var6 < 80; ++var6) {
                this.field_9437_g = this.field_9437_g * 3 + 1013904223;
                var7 = this.field_9437_g >> 2;
                var8 = var7 & 15;
                var9 = var7 >> 8 & 15;
                var10 = var7 >> 16 & 127;
                var15 = var14.field_1539_b[var8 << 11 | var9 << 7 | var10] & 255;
                if (Block.field_344_o[var15]) {
                    Block.field_345_n[var15].func_208_a(this, var8 + var3, var10, var9 + var4, this.field_1037_n);
                }
            }
        }

    }

    public boolean func_700_a(boolean var1) {
        int var2 = this.field_1058_B.size();
        if (var2 != this.field_1056_C.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        } else {
            if (var2 > 1000) {
                var2 = 1000;
            }

            for(int var3 = 0; var3 < var2; ++var3) {
                NextTickListEntry var4 = (NextTickListEntry)this.field_1058_B.first();
                if (!var1 && var4.field_1364_e > this.field_22145_q.func_22304_f()) {
                    break;
                }

                this.field_1058_B.remove(var4);
                this.field_1056_C.remove(var4);
                byte var5 = 8;
                if (this.func_640_a(var4.field_1361_a - var5, var4.field_1360_b - var5, var4.field_1366_c - var5, var4.field_1361_a + var5, var4.field_1360_b + var5, var4.field_1366_c + var5)) {
                    int var6 = this.func_600_a(var4.field_1361_a, var4.field_1360_b, var4.field_1366_c);
                    if (var6 == var4.field_1365_d && var6 > 0) {
                        Block.field_345_n[var6].func_208_a(this, var4.field_1361_a, var4.field_1360_b, var4.field_1366_c, this.field_1037_n);
                    }
                }
            }

            return this.field_1058_B.size() != 0;
        }
    }

    public void func_677_m(int var1, int var2, int var3) {
        byte var4 = 16;
        Random var5 = new Random();

        for(int var6 = 0; var6 < 1000; ++var6) {
            int var7 = var1 + this.field_1037_n.nextInt(var4) - this.field_1037_n.nextInt(var4);
            int var8 = var2 + this.field_1037_n.nextInt(var4) - this.field_1037_n.nextInt(var4);
            int var9 = var3 + this.field_1037_n.nextInt(var4) - this.field_1037_n.nextInt(var4);
            int var10 = this.func_600_a(var7, var8, var9);
            if (var10 > 0) {
                Block.field_345_n[var10].func_247_b(this, var7, var8, var9, var5);
            }
        }

    }

    public List func_659_b(Entity var1, AxisAlignedBB var2) {
        this.field_1012_M.clear();
        int var3 = MathHelper.func_1108_b((var2.field_1698_a - 2.0D) / 16.0D);
        int var4 = MathHelper.func_1108_b((var2.field_1703_d + 2.0D) / 16.0D);
        int var5 = MathHelper.func_1108_b((var2.field_1704_c - 2.0D) / 16.0D);
        int var6 = MathHelper.func_1108_b((var2.field_1701_f + 2.0D) / 16.0D);

        for(int var7 = var3; var7 <= var4; ++var7) {
            for(int var8 = var5; var8 <= var6; ++var8) {
                if (this.func_620_h(var7, var8)) {
                    this.func_704_b(var7, var8).func_994_a(var1, var2, this.field_1012_M);
                }
            }
        }

        return this.field_1012_M;
    }

    public List func_657_a(Class var1, AxisAlignedBB var2) {
        int var3 = MathHelper.func_1108_b((var2.field_1698_a - 2.0D) / 16.0D);
        int var4 = MathHelper.func_1108_b((var2.field_1703_d + 2.0D) / 16.0D);
        int var5 = MathHelper.func_1108_b((var2.field_1704_c - 2.0D) / 16.0D);
        int var6 = MathHelper.func_1108_b((var2.field_1701_f + 2.0D) / 16.0D);
        ArrayList var7 = new ArrayList();

        for(int var8 = var3; var8 <= var4; ++var8) {
            for(int var9 = var5; var9 <= var6; ++var9) {
                if (this.func_620_h(var8, var9)) {
                    this.func_704_b(var8, var9).func_1013_a(var1, var2, var7);
                }
            }
        }

        return var7;
    }

    public List func_658_i() {
        return this.field_1050_a;
    }

    public void func_698_b(int var1, int var2, int var3, TileEntity var4) {
        if (this.func_630_d(var1, var2, var3)) {
            this.func_673_a(var1, var3).func_1006_f();
        }

        for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
            ((IWorldAccess)this.field_9434_r.get(var5)).func_935_a(var1, var2, var3, var4);
        }

    }

    public int func_621_b(Class var1) {
        int var2 = 0;

        for(int var3 = 0; var3 < this.field_1050_a.size(); ++var3) {
            Entity var4 = (Entity)this.field_1050_a.get(var3);
            if (var1.isAssignableFrom(var4.getClass())) {
                ++var2;
            }
        }

        return var2;
    }

    public void func_636_a(List var1) {
        this.field_1050_a.addAll(var1);

        for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.func_606_b((Entity)var1.get(var2));
        }

    }

    public void func_632_b(List var1) {
        this.field_1024_A.addAll(var1);
    }

    public void func_656_j() {
        while(this.field_1017_H.func_532_a()) {
        }

    }

    public boolean func_695_a(int var1, int var2, int var3, int var4, boolean var5, int var6) {
        int var7 = this.func_600_a(var2, var3, var4);
        Block var8 = Block.field_345_n[var7];
        Block var9 = Block.field_345_n[var1];
        AxisAlignedBB var10 = var9.func_221_d(this, var2, var3, var4);
        if (var5) {
            var10 = null;
        }

        if (var10 != null && !this.func_604_a(var10)) {
            return false;
        } else {
            if (var8 == Block.field_401_B || var8 == Block.field_399_C || var8 == Block.field_397_D || var8 == Block.field_395_E || var8 == Block.field_402_as || var8 == Block.field_428_aT) {
                var8 = null;
            }

            return var1 > 0 && var8 == null && var9.func_28030_e(this, var2, var3, var4, var6);
        }
    }

    public PathEntity func_702_a(Entity var1, Entity var2, float var3) {
        int var4 = MathHelper.func_1108_b(var1.field_611_ak);
        int var5 = MathHelper.func_1108_b(var1.field_610_al);
        int var6 = MathHelper.func_1108_b(var1.field_609_am);
        int var7 = (int)(var3 + 16.0F);
        int var8 = var4 - var7;
        int var9 = var5 - var7;
        int var10 = var6 - var7;
        int var11 = var4 + var7;
        int var12 = var5 + var7;
        int var13 = var6 + var7;
        ChunkCache var14 = new ChunkCache(this, var8, var9, var10, var11, var12, var13);
        return (new Pathfinder(var14)).func_1137_a(var1, var2, var3);
    }

    public PathEntity func_637_a(Entity var1, int var2, int var3, int var4, float var5) {
        int var6 = MathHelper.func_1108_b(var1.field_611_ak);
        int var7 = MathHelper.func_1108_b(var1.field_610_al);
        int var8 = MathHelper.func_1108_b(var1.field_609_am);
        int var9 = (int)(var5 + 8.0F);
        int var10 = var6 - var9;
        int var11 = var7 - var9;
        int var12 = var8 - var9;
        int var13 = var6 + var9;
        int var14 = var7 + var9;
        int var15 = var8 + var9;
        ChunkCache var16 = new ChunkCache(this, var10, var11, var12, var13, var14, var15);
        return (new Pathfinder(var16)).func_1131_a(var1, var2, var3, var4, var5);
    }

    public boolean func_668_j(int var1, int var2, int var3, int var4) {
        int var5 = this.func_600_a(var1, var2, var3);
        return var5 == 0 ? false : Block.field_345_n[var5].func_228_c(this, var1, var2, var3, var4);
    }

    public boolean func_646_n(int var1, int var2, int var3) {
        if (this.func_668_j(var1, var2 - 1, var3, 0)) {
            return true;
        } else if (this.func_668_j(var1, var2 + 1, var3, 1)) {
            return true;
        } else if (this.func_668_j(var1, var2, var3 - 1, 2)) {
            return true;
        } else if (this.func_668_j(var1, var2, var3 + 1, 3)) {
            return true;
        } else if (this.func_668_j(var1 - 1, var2, var3, 4)) {
            return true;
        } else {
            return this.func_668_j(var1 + 1, var2, var3, 5);
        }
    }

    public boolean func_706_k(int var1, int var2, int var3, int var4) {
        if (this.func_28100_h(var1, var2, var3)) {
            return this.func_646_n(var1, var2, var3);
        } else {
            int var5 = this.func_600_a(var1, var2, var3);
            return var5 == 0 ? false : Block.field_345_n[var5].func_231_b(this, var1, var2, var3, var4);
        }
    }

    public boolean func_625_o(int var1, int var2, int var3) {
        if (this.func_706_k(var1, var2 - 1, var3, 0)) {
            return true;
        } else if (this.func_706_k(var1, var2 + 1, var3, 1)) {
            return true;
        } else if (this.func_706_k(var1, var2, var3 - 1, 2)) {
            return true;
        } else if (this.func_706_k(var1, var2, var3 + 1, 3)) {
            return true;
        } else if (this.func_706_k(var1 - 1, var2, var3, 4)) {
            return true;
        } else {
            return this.func_706_k(var1 + 1, var2, var3, 5);
        }
    }

    public EntityPlayer func_609_a(Entity var1, double var2) {
        return this.func_683_a(var1.field_611_ak, var1.field_610_al, var1.field_609_am, var2);
    }

    public EntityPlayer func_683_a(double var1, double var3, double var5, double var7) {
        double var9 = -1.0D;
        EntityPlayer var11 = null;

        for(int var12 = 0; var12 < this.field_1040_k.size(); ++var12) {
            EntityPlayer var13 = (EntityPlayer)this.field_1040_k.get(var12);
            double var14 = var13.func_360_d(var1, var3, var5);
            if ((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
                var9 = var14;
                var11 = var13;
            }
        }

        return var11;
    }

    public EntityPlayer func_25099_a(String var1) {
        for(int var2 = 0; var2 < this.field_1040_k.size(); ++var2) {
            if (var1.equals(((EntityPlayer)this.field_1040_k.get(var2)).field_771_i)) {
                return (EntityPlayer)this.field_1040_k.get(var2);
            }
        }

        return null;
    }

    public void func_693_a(int var1, int var2, int var3, int var4, int var5, int var6, byte[] var7) {
        int var8 = var1 >> 4;
        int var9 = var3 >> 4;
        int var10 = var1 + var4 - 1 >> 4;
        int var11 = var3 + var6 - 1 >> 4;
        int var12 = 0;
        int var13 = var2;
        int var14 = var2 + var5;
        if (var2 < 0) {
            var13 = 0;
        }

        if (var14 > 128) {
            var14 = 128;
        }

        for(int var15 = var8; var15 <= var10; ++var15) {
            int var16 = var1 - var15 * 16;
            int var17 = var1 + var4 - var15 * 16;
            if (var16 < 0) {
                var16 = 0;
            }

            if (var17 > 16) {
                var17 = 16;
            }

            for(int var18 = var9; var18 <= var11; ++var18) {
                int var19 = var3 - var18 * 16;
                int var20 = var3 + var6 - var18 * 16;
                if (var19 < 0) {
                    var19 = 0;
                }

                if (var20 > 16) {
                    var20 = 16;
                }

                var12 = this.func_704_b(var15, var18).func_1004_a(var7, var16, var13, var19, var17, var14, var20, var12);
                this.func_701_b(var15 * 16 + var16, var13, var18 * 16 + var19, var15 * 16 + var17, var14, var18 * 16 + var20);
            }
        }

    }

    public void func_660_k() {
    }

    public void func_663_l() {
        this.field_22147_p.func_22150_b();
    }

    public void func_648_a(long var1) {
        this.field_22145_q.func_22307_a(var1);
    }

    public long func_22138_q() {
        return this.field_22145_q.func_22288_b();
    }

    public long func_22139_r() {
        return this.field_22145_q.func_22304_f();
    }

    public ChunkCoordinates func_22137_s() {
        return new ChunkCoordinates(this.field_22145_q.func_22293_c(), this.field_22145_q.func_22295_d(), this.field_22145_q.func_22300_e());
    }

    public void func_22143_a(ChunkCoordinates var1) {
        this.field_22145_q.func_22292_a(var1.field_22395_a, var1.field_22394_b, var1.field_22396_c);
    }

    public void func_705_f(Entity var1) {
        int var2 = MathHelper.func_1108_b(var1.field_611_ak / 16.0D);
        int var3 = MathHelper.func_1108_b(var1.field_609_am / 16.0D);
        byte var4 = 2;

        for(int var5 = var2 - var4; var5 <= var2 + var4; ++var5) {
            for(int var6 = var3 - var4; var6 <= var3 + var4; ++var6) {
                this.func_704_b(var5, var6);
            }
        }

        if (!this.field_1050_a.contains(var1)) {
            this.field_1050_a.add(var1);
        }

    }

    public boolean func_6466_a(EntityPlayer var1, int var2, int var3, int var4) {
        return true;
    }

    public void func_9425_a(Entity var1, byte var2) {
    }

    public void func_9424_o() {
        this.field_1050_a.removeAll(this.field_1024_A);

        int var1;
        Entity var2;
        int var3;
        int var4;
        for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
            var2 = (Entity)this.field_1024_A.get(var1);
            var3 = var2.field_657_ba;
            var4 = var2.field_654_bc;
            if (var2.field_621_aZ && this.func_620_h(var3, var4)) {
                this.func_704_b(var3, var4).func_1015_b(var2);
            }
        }

        for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
            this.func_678_c((Entity)this.field_1024_A.get(var1));
        }

        this.field_1024_A.clear();

        for(var1 = 0; var1 < this.field_1050_a.size(); ++var1) {
            var2 = (Entity)this.field_1050_a.get(var1);
            if (var2.field_616_af != null) {
                if (!var2.field_616_af.field_646_aA && var2.field_616_af.field_617_ae == var2) {
                    continue;
                }

                var2.field_616_af.field_617_ae = null;
                var2.field_616_af = null;
            }

            if (var2.field_646_aA) {
                var3 = var2.field_657_ba;
                var4 = var2.field_654_bc;
                if (var2.field_621_aZ && this.func_620_h(var3, var4)) {
                    this.func_704_b(var3, var4).func_1015_b(var2);
                }

                this.field_1050_a.remove(var1--);
                this.func_678_c(var2);
            }
        }

    }

    public IChunkProvider func_21118_q() {
        return this.field_1017_H;
    }

    public void func_21116_c(int var1, int var2, int var3, int var4, int var5) {
        int var6 = this.func_600_a(var1, var2, var3);
        if (var6 > 0) {
            Block.field_345_n[var6].func_21024_a(this, var1, var2, var3, var4, var5);
        }

    }

    public WorldInfo func_22144_v() {
        return this.field_22145_q;
    }

    public void func_22140_w() {
        this.field_22146_A = !this.field_1040_k.isEmpty();
        Iterator var1 = this.field_1040_k.iterator();

        while(var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (!var2.func_22051_K()) {
                this.field_22146_A = false;
                break;
            }
        }

    }

    protected void func_22141_x() {
        this.field_22146_A = false;
        Iterator var1 = this.field_1040_k.iterator();

        while(var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (var2.func_22051_K()) {
                var2.func_22056_a(false, false, true);
            }
        }

        this.func_27164_F();
    }

    public boolean func_22142_y() {
        if (this.field_22146_A && !this.field_1026_y) {
            Iterator var1 = this.field_1040_k.iterator();

            EntityPlayer var2;
            do {
                if (!var1.hasNext()) {
                    return true;
                }

                var2 = (EntityPlayer)var1.next();
            } while(var2.func_22054_L());

            return false;
        } else {
            return false;
        }
    }

    public float func_27166_f(float var1) {
        return (this.field_27170_D + (this.field_27169_E - this.field_27170_D) * var1) * this.func_27162_g(var1);
    }

    public float func_27162_g(float var1) {
        return this.field_26901_B + (this.field_27171_C - this.field_26901_B) * var1;
    }

    public void func_27158_h(float var1) {
        this.field_26901_B = var1;
        this.field_27171_C = var1;
    }

    public boolean func_27160_B() {
        return (double)this.func_27166_f(1.0F) > 0.9D;
    }

    public boolean func_27161_C() {
        return (double)this.func_27162_g(1.0F) > 0.2D;
    }

    public boolean func_27167_r(int var1, int var2, int var3) {
        if (!this.func_27161_C()) {
            return false;
        } else if (!this.func_647_i(var1, var2, var3)) {
            return false;
        } else if (this.func_4083_e(var1, var3) > var2) {
            return false;
        } else {
            BiomeGenBase var4 = this.func_4075_a().func_4073_a(var1, var3);
            return var4.func_27078_c() ? false : var4.func_27077_d();
        }
    }

    public void func_28102_a(String var1, MapDataBase var2) {
        this.field_28108_z.func_28184_a(var1, var2);
    }

    public MapDataBase func_28103_a(Class var1, String var2) {
        return this.field_28108_z.func_28185_a(var1, var2);
    }

    public int func_28101_b(String var1) {
        return this.field_28108_z.func_28186_a(var1);
    }

    public void func_28106_e(int var1, int var2, int var3, int var4, int var5) {
        this.func_28107_a((EntityPlayer)null, var1, var2, var3, var4, var5);
    }

    public void func_28107_a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.field_9434_r.size(); ++var7) {
            ((IWorldAccess)this.field_9434_r.get(var7)).func_28136_a(var1, var2, var3, var4, var5, var6);
        }

    }
}
