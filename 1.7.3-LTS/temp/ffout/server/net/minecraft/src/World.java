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
    public boolean field_4280_a = false;
    private List field_821_y = new ArrayList();
    public List field_815_a = new ArrayList();
    private List field_790_z = new ArrayList();
    private TreeSet field_789_A = new TreeSet();
    private Set field_788_B = new HashSet();
    public List field_814_b = new ArrayList();
    private List field_20912_E = new ArrayList();
    public List field_805_k = new ArrayList();
    public List field_27081_e = new ArrayList();
    private long field_6159_E = 16777215L;
    public int field_811_e = 0;
    protected int field_4279_g = (new Random()).nextInt();
    protected final int field_4278_h = 1013904223;
    protected float field_27079_B;
    protected float field_27078_C;
    protected float field_27077_D;
    protected float field_27076_E;
    protected int field_27075_F = 0;
    public int field_27080_i = 0;
    public boolean field_808_h = false;
    private long field_784_F = System.currentTimeMillis();
    protected int field_4277_j = 40;
    public int field_804_l;
    public Random field_803_m = new Random();
    public boolean field_9212_p = false;
    public final WorldProvider field_4272_q;
    protected List field_798_r = new ArrayList();
    protected IChunkProvider field_783_G;
    protected final ISaveHandler field_9211_s;
    protected WorldInfo field_797_s;
    public boolean field_9209_x;
    private boolean field_22087_A;
    public MapStorage field_28105_z;
    private ArrayList field_9207_I = new ArrayList();
    private boolean field_31048_L;
    private int field_4265_J = 0;
    private boolean field_21121_K = true;
    private boolean field_21120_L = true;
    static int field_4268_y = 0;
    private Set field_4264_K = new HashSet();
    private int field_4263_L;
    private List field_778_L;
    public boolean field_792_x;

    public WorldChunkManager func_4077_a() {
        return this.field_4272_q.field_4301_b;
    }

    public World(ISaveHandler var1, String var2, long var3, WorldProvider var5) {
        this.field_4263_L = this.field_803_m.nextInt(12000);
        this.field_778_L = new ArrayList();
        this.field_792_x = false;
        this.field_9211_s = var1;
        this.field_28105_z = new MapStorage(var1);
        this.field_797_s = var1.func_22096_c();
        this.field_9212_p = this.field_797_s == null;
        if (var5 != null) {
            this.field_4272_q = var5;
        } else if (this.field_797_s != null && this.field_797_s.func_22178_h() == -1) {
            this.field_4272_q = WorldProvider.func_4091_a(-1);
        } else {
            this.field_4272_q = WorldProvider.func_4091_a(0);
        }

        boolean var6 = false;
        if (this.field_797_s == null) {
            this.field_797_s = new WorldInfo(var3, var2);
            var6 = true;
        } else {
            this.field_797_s.func_22190_a(var2);
        }

        this.field_4272_q.func_4093_a(this);
        this.field_783_G = this.func_22086_b();
        if (var6) {
            this.func_25072_c();
        }

        this.func_465_d();
        this.func_27070_x();
    }

    protected IChunkProvider func_22086_b() {
        IChunkLoader var1 = this.field_9211_s.func_22092_a(this.field_4272_q);
        return new ChunkProvider(this, var1, this.field_4272_q.func_4087_c());
    }

    protected void func_25072_c() {
        this.field_9209_x = true;
        int var1 = 0;
        byte var2 = 64;

        int var3;
        for(var3 = 0; !this.field_4272_q.func_4092_a(var1, var3); var3 += this.field_803_m.nextInt(64) - this.field_803_m.nextInt(64)) {
            var1 += this.field_803_m.nextInt(64) - this.field_803_m.nextInt(64);
        }

        this.field_797_s.func_22181_a(var1, var2, var3);
        this.field_9209_x = false;
    }

    public int func_528_f(int var1, int var2) {
        int var3;
        for(var3 = 63; !this.func_20111_e(var1, var3 + 1, var2); ++var3) {
        }

        return this.func_444_a(var1, var3, var2);
    }

    public void func_485_a(boolean var1, IProgressUpdate var2) {
        if (this.field_783_G.func_364_b()) {
            if (var2 != null) {
                var2.func_438_a("Saving level");
            }

            this.func_478_h();
            if (var2 != null) {
                var2.func_439_b("Saving chunks");
            }

            this.field_783_G.func_360_a(var1, var2);
        }
    }

    private void func_478_h() {
        this.func_476_g();
        this.field_9211_s.func_22095_a(this.field_797_s, this.field_805_k);
        this.field_28105_z.func_28176_a();
    }

    public int func_444_a(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return 0;
            } else {
                return var2 >= 128 ? 0 : this.func_525_b(var1 >> 4, var3 >> 4).func_344_a(var1 & 15, var2, var3 & 15);
            }
        } else {
            return 0;
        }
    }

    public boolean func_20111_e(int var1, int var2, int var3) {
        return this.func_444_a(var1, var2, var3) == 0;
    }

    public boolean func_530_e(int var1, int var2, int var3) {
        return var2 >= 0 && var2 < 128 ? this.func_447_g(var1 >> 4, var3 >> 4) : false;
    }

    public boolean func_21118_a(int var1, int var2, int var3, int var4) {
        return this.func_466_a(var1 - var4, var2 - var4, var3 - var4, var1 + var4, var2 + var4, var3 + var4);
    }

    public boolean func_466_a(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var5 >= 0 && var2 < 128) {
            var1 >>= 4;
            var2 >>= 4;
            var3 >>= 4;
            var4 >>= 4;
            var5 >>= 4;
            var6 >>= 4;

            for(int var7 = var1; var7 <= var4; ++var7) {
                for(int var8 = var3; var8 <= var6; ++var8) {
                    if (!this.func_447_g(var7, var8)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean func_447_g(int var1, int var2) {
        return this.field_783_G.func_365_a(var1, var2);
    }

    public Chunk func_492_a(int var1, int var2) {
        return this.func_525_b(var1 >> 4, var2 >> 4);
    }

    public Chunk func_525_b(int var1, int var2) {
        return this.field_783_G.func_363_b(var1, var2);
    }

    public boolean func_470_a(int var1, int var2, int var3, int var4, int var5) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var6 = this.func_525_b(var1 >> 4, var3 >> 4);
                return var6.func_346_a(var1 & 15, var2, var3 & 15, var4, var5);
            }
        } else {
            return false;
        }
    }

    public boolean func_462_a(int var1, int var2, int var3, int var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var5 = this.func_525_b(var1 >> 4, var3 >> 4);
                return var5.func_357_a(var1 & 15, var2, var3 & 15, var4);
            }
        } else {
            return false;
        }
    }

    public Material func_443_c(int var1, int var2, int var3) {
        int var4 = this.func_444_a(var1, var2, var3);
        return var4 == 0 ? Material.field_526_a : Block.field_542_n[var4].field_553_bn;
    }

    public int func_446_b(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return 0;
            } else if (var2 >= 128) {
                return 0;
            } else {
                Chunk var4 = this.func_525_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var4.func_356_b(var1, var2, var3);
            }
        } else {
            return 0;
        }
    }

    public void func_511_b(int var1, int var2, int var3, int var4) {
        if (this.func_463_c(var1, var2, var3, var4)) {
            int var5 = this.func_444_a(var1, var2, var3);
            if (Block.field_28029_t[var5 & 255]) {
                this.func_454_e(var1, var2, var3, var5);
            } else {
                this.func_449_g(var1, var2, var3, var5);
            }
        }

    }

    public boolean func_463_c(int var1, int var2, int var3, int var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return false;
            } else {
                Chunk var5 = this.func_525_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                var5.func_345_b(var1, var2, var3, var4);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean func_508_d(int var1, int var2, int var3, int var4) {
        if (this.func_462_a(var1, var2, var3, var4)) {
            this.func_454_e(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public boolean func_507_b(int var1, int var2, int var3, int var4, int var5) {
        if (this.func_470_a(var1, var2, var3, var4, var5)) {
            this.func_454_e(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public void func_521_f(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.field_798_r.size(); ++var4) {
            ((IWorldAccess)this.field_798_r.get(var4)).func_683_a(var1, var2, var3);
        }

    }

    protected void func_454_e(int var1, int var2, int var3, int var4) {
        this.func_521_f(var1, var2, var3);
        this.func_449_g(var1, var2, var3, var4);
    }

    public void func_498_f(int var1, int var2, int var3, int var4) {
        if (var3 > var4) {
            int var5 = var4;
            var4 = var3;
            var3 = var5;
        }

        this.func_519_b(var1, var3, var2, var1, var4, var2);
    }

    public void func_21119_h(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.field_798_r.size(); ++var4) {
            ((IWorldAccess)this.field_798_r.get(var4)).func_685_a(var1, var2, var3, var1, var2, var3);
        }

    }

    public void func_519_b(int var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.field_798_r.size(); ++var7) {
            ((IWorldAccess)this.field_798_r.get(var7)).func_685_a(var1, var2, var3, var4, var5, var6);
        }

    }

    public void func_449_g(int var1, int var2, int var3, int var4) {
        this.func_527_k(var1 - 1, var2, var3, var4);
        this.func_527_k(var1 + 1, var2, var3, var4);
        this.func_527_k(var1, var2 - 1, var3, var4);
        this.func_527_k(var1, var2 + 1, var3, var4);
        this.func_527_k(var1, var2, var3 - 1, var4);
        this.func_527_k(var1, var2, var3 + 1, var4);
    }

    private void func_527_k(int var1, int var2, int var3, int var4) {
        if (!this.field_808_h && !this.field_792_x) {
            Block var5 = Block.field_542_n[this.func_444_a(var1, var2, var3)];
            if (var5 != null) {
                var5.func_234_b(this, var1, var2, var3, var4);
            }

        }
    }

    public boolean func_497_g(int var1, int var2, int var3) {
        return this.func_525_b(var1 >> 4, var3 >> 4).func_343_c(var1 & 15, var2, var3 & 15);
    }

    public int func_28098_j(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else {
            if (var2 >= 128) {
                var2 = 127;
            }

            return this.func_525_b(var1 >> 4, var3 >> 4).func_354_c(var1 & 15, var2, var3 & 15, 0);
        }
    }

    public int func_495_h(int var1, int var2, int var3) {
        return this.func_517_a(var1, var2, var3, true);
    }

    public int func_517_a(int var1, int var2, int var3, boolean var4) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var4) {
                int var5 = this.func_444_a(var1, var2, var3);
                if (var5 == Block.field_607_al.field_573_bc || var5 == Block.field_643_aB.field_573_bc || var5 == Block.field_9055_aH.field_573_bc || var5 == Block.field_9045_at.field_573_bc) {
                    int var6 = this.func_517_a(var1, var2 + 1, var3, false);
                    int var7 = this.func_517_a(var1 + 1, var2, var3, false);
                    int var8 = this.func_517_a(var1 - 1, var2, var3, false);
                    int var9 = this.func_517_a(var1, var2, var3 + 1, false);
                    int var10 = this.func_517_a(var1, var2, var3 - 1, false);
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

                Chunk var11 = this.func_525_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var11.func_354_c(var1, var2, var3, this.field_811_e);
            }
        } else {
            return 15;
        }
    }

    public boolean func_475_i(int var1, int var2, int var3) {
        if (var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
            if (var2 < 0) {
                return false;
            } else if (var2 >= 128) {
                return true;
            } else if (!this.func_447_g(var1 >> 4, var3 >> 4)) {
                return false;
            } else {
                Chunk var4 = this.func_525_b(var1 >> 4, var3 >> 4);
                var1 &= 15;
                var3 &= 15;
                return var4.func_343_c(var1, var2, var3);
            }
        } else {
            return false;
        }
    }

    public int func_488_c(int var1, int var2) {
        if (var1 >= -32000000 && var2 >= -32000000 && var1 < 32000000 && var2 <= 32000000) {
            if (!this.func_447_g(var1 >> 4, var2 >> 4)) {
                return 0;
            } else {
                Chunk var3 = this.func_525_b(var1 >> 4, var2 >> 4);
                return var3.func_337_b(var1 & 15, var2 & 15);
            }
        } else {
            return 0;
        }
    }

    public void func_4069_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        if (!this.field_4272_q.field_4306_c || var1 != EnumSkyBlock.Sky) {
            if (this.func_530_e(var2, var3, var4)) {
                if (var1 == EnumSkyBlock.Sky) {
                    if (this.func_475_i(var2, var3, var4)) {
                        var5 = 15;
                    }
                } else if (var1 == EnumSkyBlock.Block) {
                    int var6 = this.func_444_a(var2, var3, var4);
                    if (Block.field_536_t[var6] > var5) {
                        var5 = Block.field_536_t[var6];
                    }
                }

                if (this.func_512_a(var1, var2, var3, var4) != var5) {
                    this.func_483_a(var1, var2, var3, var4, var2, var3, var4);
                }

            }
        }
    }

    public int func_512_a(EnumSkyBlock var1, int var2, int var3, int var4) {
        if (var3 < 0) {
            var3 = 0;
        }

        if (var3 >= 128) {
            var3 = 127;
        }

        if (var3 >= 0 && var3 < 128 && var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
            int var5 = var2 >> 4;
            int var6 = var4 >> 4;
            if (!this.func_447_g(var5, var6)) {
                return 0;
            } else {
                Chunk var7 = this.func_525_b(var5, var6);
                return var7.func_341_a(var1, var2 & 15, var3, var4 & 15);
            }
        } else {
            return var1.field_984_c;
        }
    }

    public void func_529_b(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        if (var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
            if (var3 >= 0) {
                if (var3 < 128) {
                    if (this.func_447_g(var2 >> 4, var4 >> 4)) {
                        Chunk var6 = this.func_525_b(var2 >> 4, var4 >> 4);
                        var6.func_330_a(var1, var2 & 15, var3, var4 & 15, var5);

                        for(int var7 = 0; var7 < this.field_798_r.size(); ++var7) {
                            ((IWorldAccess)this.field_798_r.get(var7)).func_683_a(var2, var3, var4);
                        }

                    }
                }
            }
        }
    }

    public float func_455_j(int var1, int var2, int var3) {
        return this.field_4272_q.field_4305_d[this.func_495_h(var1, var2, var3)];
    }

    public boolean func_453_a() {
        return this.field_811_e < 4;
    }

    public MovingObjectPosition func_486_a(Vec3D var1, Vec3D var2) {
        return this.func_28099_a(var1, var2, false, false);
    }

    public MovingObjectPosition func_505_a(Vec3D var1, Vec3D var2, boolean var3) {
        return this.func_28099_a(var1, var2, var3, false);
    }

    public MovingObjectPosition func_28099_a(Vec3D var1, Vec3D var2, boolean var3, boolean var4) {
        if (!Double.isNaN(var1.field_1055_a) && !Double.isNaN(var1.field_1054_b) && !Double.isNaN(var1.field_1058_c)) {
            if (!Double.isNaN(var2.field_1055_a) && !Double.isNaN(var2.field_1054_b) && !Double.isNaN(var2.field_1058_c)) {
                int var5 = MathHelper.func_584_b(var2.field_1055_a);
                int var6 = MathHelper.func_584_b(var2.field_1054_b);
                int var7 = MathHelper.func_584_b(var2.field_1058_c);
                int var8 = MathHelper.func_584_b(var1.field_1055_a);
                int var9 = MathHelper.func_584_b(var1.field_1054_b);
                int var10 = MathHelper.func_584_b(var1.field_1058_c);
                int var11 = this.func_444_a(var8, var9, var10);
                int var12 = this.func_446_b(var8, var9, var10);
                Block var13 = Block.field_542_n[var11];
                if ((!var4 || var13 == null || var13.func_248_d(this, var8, var9, var10) != null) && var11 > 0 && var13.func_243_a(var12, var3)) {
                    MovingObjectPosition var14 = var13.func_262_a(this, var8, var9, var10, var1, var2);
                    if (var14 != null) {
                        return var14;
                    }
                }

                var11 = 200;

                while(var11-- >= 0) {
                    if (Double.isNaN(var1.field_1055_a) || Double.isNaN(var1.field_1054_b) || Double.isNaN(var1.field_1058_c)) {
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
                    double var27 = var2.field_1055_a - var1.field_1055_a;
                    double var29 = var2.field_1054_b - var1.field_1054_b;
                    double var31 = var2.field_1058_c - var1.field_1058_c;
                    if (var39) {
                        var21 = (var15 - var1.field_1055_a) / var27;
                    }

                    if (var40) {
                        var23 = (var17 - var1.field_1054_b) / var29;
                    }

                    if (var41) {
                        var25 = (var19 - var1.field_1058_c) / var31;
                    }

                    boolean var33 = false;
                    byte var42;
                    if (var21 < var23 && var21 < var25) {
                        if (var5 > var8) {
                            var42 = 4;
                        } else {
                            var42 = 5;
                        }

                        var1.field_1055_a = var15;
                        var1.field_1054_b += var29 * var21;
                        var1.field_1058_c += var31 * var21;
                    } else if (var23 < var25) {
                        if (var6 > var9) {
                            var42 = 0;
                        } else {
                            var42 = 1;
                        }

                        var1.field_1055_a += var27 * var23;
                        var1.field_1054_b = var17;
                        var1.field_1058_c += var31 * var23;
                    } else {
                        if (var7 > var10) {
                            var42 = 2;
                        } else {
                            var42 = 3;
                        }

                        var1.field_1055_a += var27 * var25;
                        var1.field_1054_b += var29 * var25;
                        var1.field_1058_c = var19;
                    }

                    Vec3D var34 = Vec3D.func_768_b(var1.field_1055_a, var1.field_1054_b, var1.field_1058_c);
                    var8 = (int)(var34.field_1055_a = (double)MathHelper.func_584_b(var1.field_1055_a));
                    if (var42 == 5) {
                        --var8;
                        ++var34.field_1055_a;
                    }

                    var9 = (int)(var34.field_1054_b = (double)MathHelper.func_584_b(var1.field_1054_b));
                    if (var42 == 1) {
                        --var9;
                        ++var34.field_1054_b;
                    }

                    var10 = (int)(var34.field_1058_c = (double)MathHelper.func_584_b(var1.field_1058_c));
                    if (var42 == 3) {
                        --var10;
                        ++var34.field_1058_c;
                    }

                    int var35 = this.func_444_a(var8, var9, var10);
                    int var36 = this.func_446_b(var8, var9, var10);
                    Block var37 = Block.field_542_n[var35];
                    if ((!var4 || var37 == null || var37.func_248_d(this, var8, var9, var10) != null) && var35 > 0 && var37.func_243_a(var36, var3)) {
                        MovingObjectPosition var38 = var37.func_262_a(this, var8, var9, var10, var1, var2);
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

    public void func_506_a(Entity var1, String var2, float var3, float var4) {
        for(int var5 = 0; var5 < this.field_798_r.size(); ++var5) {
            ((IWorldAccess)this.field_798_r.get(var5)).func_689_a(var2, var1.field_322_l, var1.field_321_m - (double)var1.field_9076_H, var1.field_320_n, var3, var4);
        }

    }

    public void func_502_a(double var1, double var3, double var5, String var7, float var8, float var9) {
        for(int var10 = 0; var10 < this.field_798_r.size(); ++var10) {
            ((IWorldAccess)this.field_798_r.get(var10)).func_689_a(var7, var1, var3, var5, var8, var9);
        }

    }

    public void func_491_a(String var1, int var2, int var3, int var4) {
        for(int var5 = 0; var5 < this.field_798_r.size(); ++var5) {
            ((IWorldAccess)this.field_798_r.get(var5)).func_682_a(var1, var2, var3, var4);
        }

    }

    public void func_514_a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        for(int var14 = 0; var14 < this.field_798_r.size(); ++var14) {
            ((IWorldAccess)this.field_798_r.get(var14)).func_687_a(var1, var2, var4, var6, var8, var10, var12);
        }

    }

    public boolean func_27073_a(Entity var1) {
        this.field_27081_e.add(var1);
        return true;
    }

    public boolean func_526_a(Entity var1) {
        int var2 = MathHelper.func_584_b(var1.field_322_l / 16.0D);
        int var3 = MathHelper.func_584_b(var1.field_320_n / 16.0D);
        boolean var4 = false;
        if (var1 instanceof EntityPlayer) {
            var4 = true;
        }

        if (!var4 && !this.func_447_g(var2, var3)) {
            return false;
        } else {
            if (var1 instanceof EntityPlayer) {
                EntityPlayer var5 = (EntityPlayer)var1;
                this.field_805_k.add(var5);
                this.func_22082_o();
            }

            this.func_525_b(var2, var3).func_335_a(var1);
            this.field_815_a.add(var1);
            this.func_479_b(var1);
            return true;
        }
    }

    protected void func_479_b(Entity var1) {
        for(int var2 = 0; var2 < this.field_798_r.size(); ++var2) {
            ((IWorldAccess)this.field_798_r.get(var2)).func_681_a(var1);
        }

    }

    protected void func_531_c(Entity var1) {
        for(int var2 = 0; var2 < this.field_798_r.size(); ++var2) {
            ((IWorldAccess)this.field_798_r.get(var2)).func_688_b(var1);
        }

    }

    public void func_22085_d(Entity var1) {
        if (var1.field_328_f != null) {
            var1.field_328_f.func_6094_e((Entity)null);
        }

        if (var1.field_327_g != null) {
            var1.func_6094_e((Entity)null);
        }

        var1.func_118_j();
        if (var1 instanceof EntityPlayer) {
            this.field_805_k.remove((EntityPlayer)var1);
            this.func_22082_o();
        }

    }

    public void func_22073_e(Entity var1) {
        var1.func_118_j();
        if (var1 instanceof EntityPlayer) {
            this.field_805_k.remove((EntityPlayer)var1);
            this.func_22082_o();
        }

        int var2 = var1.field_307_aa;
        int var3 = var1.field_303_ac;
        if (var1.field_276_Z && this.func_447_g(var2, var3)) {
            this.func_525_b(var2, var3).func_350_b(var1);
        }

        this.field_815_a.remove(var1);
        this.func_531_c(var1);
    }

    public void func_4072_a(IWorldAccess var1) {
        this.field_798_r.add(var1);
    }

    public List func_481_a(Entity var1, AxisAlignedBB var2) {
        this.field_9207_I.clear();
        int var3 = MathHelper.func_584_b(var2.field_964_a);
        int var4 = MathHelper.func_584_b(var2.field_969_d + 1.0D);
        int var5 = MathHelper.func_584_b(var2.field_963_b);
        int var6 = MathHelper.func_584_b(var2.field_968_e + 1.0D);
        int var7 = MathHelper.func_584_b(var2.field_970_c);
        int var8 = MathHelper.func_584_b(var2.field_967_f + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var7; var10 < var8; ++var10) {
                if (this.func_530_e(var9, 64, var10)) {
                    for(int var11 = var5 - 1; var11 < var6; ++var11) {
                        Block var12 = Block.field_542_n[this.func_444_a(var9, var11, var10)];
                        if (var12 != null) {
                            var12.func_264_a(this, var9, var11, var10, var2, this.field_9207_I);
                        }
                    }
                }
            }
        }

        double var14 = 0.25D;
        List var15 = this.func_450_b(var1, var2.func_708_b(var14, var14, var14));

        for(int var16 = 0; var16 < var15.size(); ++var16) {
            AxisAlignedBB var13 = ((Entity)var15.get(var16)).func_93_n();
            if (var13 != null && var13.func_704_a(var2)) {
                this.field_9207_I.add(var13);
            }

            var13 = var1.func_89_d((Entity)var15.get(var16));
            if (var13 != null && var13.func_704_a(var2)) {
                this.field_9207_I.add(var13);
            }
        }

        return this.field_9207_I;
    }

    public int func_493_a(float var1) {
        float var2 = this.func_477_b(var1);
        float var3 = 1.0F - (MathHelper.func_582_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        var3 = 1.0F - var3;
        var3 = (float)((double)var3 * (1.0D - (double)(this.func_27074_d(var1) * 5.0F) / 16.0D));
        var3 = (float)((double)var3 * (1.0D - (double)(this.func_27065_c(var1) * 5.0F) / 16.0D));
        var3 = 1.0F - var3;
        return (int)(var3 * 11.0F);
    }

    public float func_477_b(float var1) {
        return this.field_4272_q.func_4089_a(this.field_797_s.func_22186_f(), var1);
    }

    public int func_28100_e(int var1, int var2) {
        Chunk var3 = this.func_492_a(var1, var2);
        int var4 = 127;
        var1 &= 15;

        for(var2 &= 15; var4 > 0; --var4) {
            int var5 = var3.func_344_a(var1, var4, var2);
            Material var6 = var5 == 0 ? Material.field_526_a : Block.field_542_n[var5].field_553_bn;
            if (var6.func_218_c() || var6.func_217_d()) {
                return var4 + 1;
            }
        }

        return -1;
    }

    public int func_4075_e(int var1, int var2) {
        Chunk var3 = this.func_492_a(var1, var2);
        int var4 = 127;
        var1 &= 15;

        for(var2 &= 15; var4 > 0; --var4) {
            int var5 = var3.func_344_a(var1, var4, var2);
            if (var5 != 0 && Block.field_542_n[var5].field_553_bn.func_218_c()) {
                return var4 + 1;
            }
        }

        return -1;
    }

    public void func_22074_c(int var1, int var2, int var3, int var4, int var5) {
        NextTickListEntry var6 = new NextTickListEntry(var1, var2, var3, var4);
        byte var7 = 8;
        if (this.field_4280_a) {
            if (this.func_466_a(var6.field_1018_a - var7, var6.field_1017_b - var7, var6.field_1023_c - var7, var6.field_1018_a + var7, var6.field_1017_b + var7, var6.field_1023_c + var7)) {
                int var8 = this.func_444_a(var6.field_1018_a, var6.field_1017_b, var6.field_1023_c);
                if (var8 == var6.field_1022_d && var8 > 0) {
                    Block.field_542_n[var8].func_221_a(this, var6.field_1018_a, var6.field_1017_b, var6.field_1023_c, this.field_803_m);
                }
            }

        } else {
            if (this.func_466_a(var1 - var7, var2 - var7, var3 - var7, var1 + var7, var2 + var7, var3 + var7)) {
                if (var4 > 0) {
                    var6.func_733_a((long)var5 + this.field_797_s.func_22186_f());
                }

                if (!this.field_788_B.contains(var6)) {
                    this.field_788_B.add(var6);
                    this.field_789_A.add(var6);
                }
            }

        }
    }

    public void func_459_b() {
        int var1;
        Entity var2;
        for(var1 = 0; var1 < this.field_27081_e.size(); ++var1) {
            var2 = (Entity)this.field_27081_e.get(var1);
            var2.func_106_b_();
            if (var2.field_304_B) {
                this.field_27081_e.remove(var1--);
            }
        }

        this.field_815_a.removeAll(this.field_790_z);

        int var3;
        int var4;
        for(var1 = 0; var1 < this.field_790_z.size(); ++var1) {
            var2 = (Entity)this.field_790_z.get(var1);
            var3 = var2.field_307_aa;
            var4 = var2.field_303_ac;
            if (var2.field_276_Z && this.func_447_g(var3, var4)) {
                this.func_525_b(var3, var4).func_350_b(var2);
            }
        }

        for(var1 = 0; var1 < this.field_790_z.size(); ++var1) {
            this.func_531_c((Entity)this.field_790_z.get(var1));
        }

        this.field_790_z.clear();

        for(var1 = 0; var1 < this.field_815_a.size(); ++var1) {
            var2 = (Entity)this.field_815_a.get(var1);
            if (var2.field_327_g != null) {
                if (!var2.field_327_g.field_304_B && var2.field_327_g.field_328_f == var2) {
                    continue;
                }

                var2.field_327_g.field_328_f = null;
                var2.field_327_g = null;
            }

            if (!var2.field_304_B) {
                this.func_520_e(var2);
            }

            if (var2.field_304_B) {
                var3 = var2.field_307_aa;
                var4 = var2.field_303_ac;
                if (var2.field_276_Z && this.func_447_g(var3, var4)) {
                    this.func_525_b(var3, var4).func_350_b(var2);
                }

                this.field_815_a.remove(var1--);
                this.func_531_c(var2);
            }
        }

        this.field_31048_L = true;
        Iterator var10 = this.field_814_b.iterator();

        while(var10.hasNext()) {
            TileEntity var5 = (TileEntity)var10.next();
            if (!var5.func_31004_g()) {
                var5.func_184_b();
            }

            if (var5.func_31004_g()) {
                var10.remove();
                Chunk var7 = this.func_525_b(var5.field_478_b >> 4, var5.field_482_d >> 4);
                if (var7 != null) {
                    var7.func_359_e(var5.field_478_b & 15, var5.field_483_c, var5.field_482_d & 15);
                }
            }
        }

        this.field_31048_L = false;
        if (!this.field_20912_E.isEmpty()) {
            Iterator var6 = this.field_20912_E.iterator();

            while(var6.hasNext()) {
                TileEntity var8 = (TileEntity)var6.next();
                if (!var8.func_31004_g()) {
                    if (!this.field_814_b.contains(var8)) {
                        this.field_814_b.add(var8);
                    }

                    Chunk var9 = this.func_525_b(var8.field_478_b >> 4, var8.field_482_d >> 4);
                    if (var9 != null) {
                        var9.func_352_a(var8.field_478_b & 15, var8.field_483_c, var8.field_482_d & 15, var8);
                    }

                    this.func_521_f(var8.field_478_b, var8.field_483_c, var8.field_482_d);
                }
            }

            this.field_20912_E.clear();
        }

    }

    public void func_31047_a(Collection var1) {
        if (this.field_31048_L) {
            this.field_20912_E.addAll(var1);
        } else {
            this.field_814_b.addAll(var1);
        }

    }

    public void func_520_e(Entity var1) {
        this.func_4074_a(var1, true);
    }

    public void func_4074_a(Entity var1, boolean var2) {
        int var3 = MathHelper.func_584_b(var1.field_322_l);
        int var4 = MathHelper.func_584_b(var1.field_320_n);
        byte var5 = 32;
        if (!var2 || this.func_466_a(var3 - var5, 0, var4 - var5, var3 + var5, 128, var4 + var5)) {
            var1.field_9071_O = var1.field_322_l;
            var1.field_9070_P = var1.field_321_m;
            var1.field_9069_Q = var1.field_320_n;
            var1.field_9089_x = var1.field_316_r;
            var1.field_9088_y = var1.field_315_s;
            if (var2 && var1.field_276_Z) {
                if (var1.field_327_g != null) {
                    var1.func_115_v();
                } else {
                    var1.func_106_b_();
                }
            }

            if (Double.isNaN(var1.field_322_l) || Double.isInfinite(var1.field_322_l)) {
                var1.field_322_l = var1.field_9071_O;
            }

            if (Double.isNaN(var1.field_321_m) || Double.isInfinite(var1.field_321_m)) {
                var1.field_321_m = var1.field_9070_P;
            }

            if (Double.isNaN(var1.field_320_n) || Double.isInfinite(var1.field_320_n)) {
                var1.field_320_n = var1.field_9069_Q;
            }

            if (Double.isNaN((double)var1.field_315_s) || Double.isInfinite((double)var1.field_315_s)) {
                var1.field_315_s = var1.field_9088_y;
            }

            if (Double.isNaN((double)var1.field_316_r) || Double.isInfinite((double)var1.field_316_r)) {
                var1.field_316_r = var1.field_9089_x;
            }

            int var6 = MathHelper.func_584_b(var1.field_322_l / 16.0D);
            int var7 = MathHelper.func_584_b(var1.field_321_m / 16.0D);
            int var8 = MathHelper.func_584_b(var1.field_320_n / 16.0D);
            if (!var1.field_276_Z || var1.field_307_aa != var6 || var1.field_305_ab != var7 || var1.field_303_ac != var8) {
                if (var1.field_276_Z && this.func_447_g(var1.field_307_aa, var1.field_303_ac)) {
                    this.func_525_b(var1.field_307_aa, var1.field_303_ac).func_332_a(var1, var1.field_305_ab);
                }

                if (this.func_447_g(var6, var8)) {
                    var1.field_276_Z = true;
                    this.func_525_b(var6, var8).func_335_a(var1);
                } else {
                    var1.field_276_Z = false;
                }
            }

            if (var2 && var1.field_276_Z && var1.field_328_f != null) {
                if (!var1.field_328_f.field_304_B && var1.field_328_f.field_327_g == var1) {
                    this.func_520_e(var1.field_328_f);
                } else {
                    var1.field_328_f.field_327_g = null;
                    var1.field_328_f = null;
                }
            }

        }
    }

    public boolean func_522_a(AxisAlignedBB var1) {
        List var2 = this.func_450_b((Entity)null, var1);

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            Entity var4 = (Entity)var2.get(var3);
            if (!var4.field_304_B && var4.field_329_e) {
                return false;
            }
        }

        return true;
    }

    public boolean func_27069_b(AxisAlignedBB var1) {
        int var2 = MathHelper.func_584_b(var1.field_964_a);
        int var3 = MathHelper.func_584_b(var1.field_969_d + 1.0D);
        int var4 = MathHelper.func_584_b(var1.field_963_b);
        int var5 = MathHelper.func_584_b(var1.field_968_e + 1.0D);
        int var6 = MathHelper.func_584_b(var1.field_970_c);
        int var7 = MathHelper.func_584_b(var1.field_967_f + 1.0D);
        if (var1.field_964_a < 0.0D) {
            --var2;
        }

        if (var1.field_963_b < 0.0D) {
            --var4;
        }

        if (var1.field_970_c < 0.0D) {
            --var6;
        }

        for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
                for(int var10 = var6; var10 < var7; ++var10) {
                    Block var11 = Block.field_542_n[this.func_444_a(var8, var9, var10)];
                    if (var11 != null) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean func_469_b(AxisAlignedBB var1) {
        int var2 = MathHelper.func_584_b(var1.field_964_a);
        int var3 = MathHelper.func_584_b(var1.field_969_d + 1.0D);
        int var4 = MathHelper.func_584_b(var1.field_963_b);
        int var5 = MathHelper.func_584_b(var1.field_968_e + 1.0D);
        int var6 = MathHelper.func_584_b(var1.field_970_c);
        int var7 = MathHelper.func_584_b(var1.field_967_f + 1.0D);
        if (var1.field_964_a < 0.0D) {
            --var2;
        }

        if (var1.field_963_b < 0.0D) {
            --var4;
        }

        if (var1.field_970_c < 0.0D) {
            --var6;
        }

        for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
                for(int var10 = var6; var10 < var7; ++var10) {
                    Block var11 = Block.field_542_n[this.func_444_a(var8, var9, var10)];
                    if (var11 != null && var11.field_553_bn.func_217_d()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean func_523_c(AxisAlignedBB var1) {
        int var2 = MathHelper.func_584_b(var1.field_964_a);
        int var3 = MathHelper.func_584_b(var1.field_969_d + 1.0D);
        int var4 = MathHelper.func_584_b(var1.field_963_b);
        int var5 = MathHelper.func_584_b(var1.field_968_e + 1.0D);
        int var6 = MathHelper.func_584_b(var1.field_970_c);
        int var7 = MathHelper.func_584_b(var1.field_967_f + 1.0D);
        if (this.func_466_a(var2, var4, var6, var3, var5, var7)) {
            for(int var8 = var2; var8 < var3; ++var8) {
                for(int var9 = var4; var9 < var5; ++var9) {
                    for(int var10 = var6; var10 < var7; ++var10) {
                        int var11 = this.func_444_a(var8, var9, var10);
                        if (var11 == Block.field_599_as.field_573_bc || var11 == Block.field_594_D.field_573_bc || var11 == Block.field_592_E.field_573_bc) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean func_490_a(AxisAlignedBB var1, Material var2, Entity var3) {
        int var4 = MathHelper.func_584_b(var1.field_964_a);
        int var5 = MathHelper.func_584_b(var1.field_969_d + 1.0D);
        int var6 = MathHelper.func_584_b(var1.field_963_b);
        int var7 = MathHelper.func_584_b(var1.field_968_e + 1.0D);
        int var8 = MathHelper.func_584_b(var1.field_970_c);
        int var9 = MathHelper.func_584_b(var1.field_967_f + 1.0D);
        if (!this.func_466_a(var4, var6, var8, var5, var7, var9)) {
            return false;
        } else {
            boolean var10 = false;
            Vec3D var11 = Vec3D.func_768_b(0.0D, 0.0D, 0.0D);

            for(int var12 = var4; var12 < var5; ++var12) {
                for(int var13 = var6; var13 < var7; ++var13) {
                    for(int var14 = var8; var14 < var9; ++var14) {
                        Block var15 = Block.field_542_n[this.func_444_a(var12, var13, var14)];
                        if (var15 != null && var15.field_553_bn == var2) {
                            double var16 = (double)((float)(var13 + 1) - BlockFluid.func_299_b(this.func_446_b(var12, var13, var14)));
                            if ((double)var7 >= var16) {
                                var10 = true;
                                var15.func_230_a(this, var12, var13, var14, var3, var11);
                            }
                        }
                    }
                }
            }

            if (var11.func_765_c() > 0.0D) {
                var11 = var11.func_758_b();
                double var18 = 0.014D;
                var3.field_319_o += var11.field_1055_a * var18;
                var3.field_318_p += var11.field_1054_b * var18;
                var3.field_317_q += var11.field_1058_c * var18;
            }

            return var10;
        }
    }

    public boolean func_500_a(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.func_584_b(var1.field_964_a);
        int var4 = MathHelper.func_584_b(var1.field_969_d + 1.0D);
        int var5 = MathHelper.func_584_b(var1.field_963_b);
        int var6 = MathHelper.func_584_b(var1.field_968_e + 1.0D);
        int var7 = MathHelper.func_584_b(var1.field_970_c);
        int var8 = MathHelper.func_584_b(var1.field_967_f + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var5; var10 < var6; ++var10) {
                for(int var11 = var7; var11 < var8; ++var11) {
                    Block var12 = Block.field_542_n[this.func_444_a(var9, var10, var11)];
                    if (var12 != null && var12.field_553_bn == var2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean func_524_b(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.func_584_b(var1.field_964_a);
        int var4 = MathHelper.func_584_b(var1.field_969_d + 1.0D);
        int var5 = MathHelper.func_584_b(var1.field_963_b);
        int var6 = MathHelper.func_584_b(var1.field_968_e + 1.0D);
        int var7 = MathHelper.func_584_b(var1.field_970_c);
        int var8 = MathHelper.func_584_b(var1.field_967_f + 1.0D);

        for(int var9 = var3; var9 < var4; ++var9) {
            for(int var10 = var5; var10 < var6; ++var10) {
                for(int var11 = var7; var11 < var8; ++var11) {
                    Block var12 = Block.field_542_n[this.func_444_a(var9, var10, var11)];
                    if (var12 != null && var12.field_553_bn == var2) {
                        int var13 = this.func_446_b(var9, var10, var11);
                        double var14 = (double)(var10 + 1);
                        if (var13 < 8) {
                            var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
                        }

                        if (var14 >= var1.field_963_b) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public Explosion func_12013_a(Entity var1, double var2, double var4, double var6, float var8) {
        return this.func_12015_a(var1, var2, var4, var6, var8, false);
    }

    public Explosion func_12015_a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
        Explosion var10 = new Explosion(this, var1, var2, var4, var6, var8);
        var10.field_12031_a = var9;
        var10.func_12023_a();
        var10.func_732_a(true);
        return var10;
    }

    public float func_494_a(Vec3D var1, AxisAlignedBB var2) {
        double var3 = 1.0D / ((var2.field_969_d - var2.field_964_a) * 2.0D + 1.0D);
        double var5 = 1.0D / ((var2.field_968_e - var2.field_963_b) * 2.0D + 1.0D);
        double var7 = 1.0D / ((var2.field_967_f - var2.field_970_c) * 2.0D + 1.0D);
        int var9 = 0;
        int var10 = 0;

        for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
            for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
                for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
                    double var14 = var2.field_964_a + (var2.field_969_d - var2.field_964_a) * (double)var11;
                    double var16 = var2.field_963_b + (var2.field_968_e - var2.field_963_b) * (double)var12;
                    double var18 = var2.field_970_c + (var2.field_967_f - var2.field_970_c) * (double)var13;
                    if (this.func_486_a(Vec3D.func_768_b(var14, var16, var18), var1) == null) {
                        ++var9;
                    }

                    ++var10;
                }
            }
        }

        return (float)var9 / (float)var10;
    }

    public void func_28096_a(EntityPlayer var1, int var2, int var3, int var4, int var5) {
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

        if (this.func_444_a(var2, var3, var4) == Block.field_599_as.field_573_bc) {
            this.func_28101_a(var1, 1004, var2, var3, var4, 0);
            this.func_508_d(var2, var3, var4, 0);
        }

    }

    public TileEntity func_451_k(int var1, int var2, int var3) {
        Chunk var4 = this.func_525_b(var1 >> 4, var3 >> 4);
        return var4 != null ? var4.func_338_d(var1 & 15, var2, var3 & 15) : null;
    }

    public void func_473_a(int var1, int var2, int var3, TileEntity var4) {
        if (!var4.func_31004_g()) {
            if (this.field_31048_L) {
                var4.field_478_b = var1;
                var4.field_483_c = var2;
                var4.field_482_d = var3;
                this.field_20912_E.add(var4);
            } else {
                this.field_814_b.add(var4);
                Chunk var5 = this.func_525_b(var1 >> 4, var3 >> 4);
                if (var5 != null) {
                    var5.func_352_a(var1 & 15, var2, var3 & 15, var4);
                }
            }
        }

    }

    public void func_513_l(int var1, int var2, int var3) {
        TileEntity var4 = this.func_451_k(var1, var2, var3);
        if (var4 != null && this.field_31048_L) {
            var4.func_31003_h();
        } else {
            if (var4 != null) {
                this.field_814_b.remove(var4);
            }

            Chunk var5 = this.func_525_b(var1 >> 4, var3 >> 4);
            if (var5 != null) {
                var5.func_359_e(var1 & 15, var2, var3 & 15);
            }
        }

    }

    public boolean func_28095_p(int var1, int var2, int var3) {
        Block var4 = Block.field_542_n[this.func_444_a(var1, var2, var3)];
        return var4 == null ? false : var4.func_240_b();
    }

    public boolean func_445_d(int var1, int var2, int var3) {
        Block var4 = Block.field_542_n[this.func_444_a(var1, var2, var3)];
        if (var4 == null) {
            return false;
        } else {
            return var4.field_553_bn.func_28128_h() && var4.func_28025_b();
        }
    }

    public boolean func_6156_d() {
        if (this.field_4265_J >= 50) {
            return false;
        } else {
            ++this.field_4265_J;

            boolean var2;
            try {
                int var1 = 500;

                while(this.field_821_y.size() > 0) {
                    --var1;
                    if (var1 <= 0) {
                        var2 = true;
                        return var2;
                    }

                    ((MetadataChunkBlock)this.field_821_y.remove(this.field_821_y.size() - 1)).func_4107_a(this);
                }

                var2 = false;
            } finally {
                --this.field_4265_J;
            }

            return var2;
        }
    }

    public void func_483_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.func_484_a(var1, var2, var3, var4, var5, var6, var7, true);
    }

    public void func_484_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
        if (!this.field_4272_q.field_4306_c || var1 != EnumSkyBlock.Sky) {
            ++field_4268_y;

            try {
                if (field_4268_y != 50) {
                    int var9 = (var5 + var2) / 2;
                    int var10 = (var7 + var4) / 2;
                    if (this.func_530_e(var9, 64, var10)) {
                        if (!this.func_492_a(var9, var10).func_21101_g()) {
                            int var11 = this.field_821_y.size();
                            int var12;
                            if (var8) {
                                var12 = 5;
                                if (var12 > var11) {
                                    var12 = var11;
                                }

                                for(int var13 = 0; var13 < var12; ++var13) {
                                    MetadataChunkBlock var14 = (MetadataChunkBlock)this.field_821_y.get(this.field_821_y.size() - var13 - 1);
                                    if (var14.field_957_a == var1 && var14.func_692_a(var2, var3, var4, var5, var6, var7)) {
                                        return;
                                    }
                                }
                            }

                            this.field_821_y.add(new MetadataChunkBlock(var1, var2, var3, var4, var5, var6, var7));
                            var12 = 1000000;
                            if (this.field_821_y.size() > 1000000) {
                                System.out.println("More than " + var12 + " updates, aborting lighting updates");
                                this.field_821_y.clear();
                            }

                        }
                    }
                }
            } finally {
                --field_4268_y;
            }
        }
    }

    public void func_465_d() {
        int var1 = this.func_493_a(1.0F);
        if (var1 != this.field_811_e) {
            this.field_811_e = var1;
        }

    }

    public void func_21116_a(boolean var1, boolean var2) {
        this.field_21121_K = var1;
        this.field_21120_L = var2;
    }

    public void func_22077_g() {
        this.func_27066_i();
        long var2;
        if (this.func_22084_q()) {
            boolean var1 = false;
            if (this.field_21121_K && this.field_804_l >= 1) {
                var1 = SpawnerAnimals.func_22212_a(this, this.field_805_k);
            }

            if (!var1) {
                var2 = this.field_797_s.func_22186_f() + 24000L;
                this.field_797_s.func_22180_a(var2 - var2 % 24000L);
                this.func_22083_p();
            }
        }

        SpawnerAnimals.func_4111_a(this, this.field_21121_K, this.field_21120_L);
        this.field_783_G.func_361_a();
        int var4 = this.func_493_a(1.0F);
        if (var4 != this.field_811_e) {
            this.field_811_e = var4;

            for(int var5 = 0; var5 < this.field_798_r.size(); ++var5) {
                ((IWorldAccess)this.field_798_r.get(var5)).func_684_a();
            }
        }

        var2 = this.field_797_s.func_22186_f() + 1L;
        if (var2 % (long)this.field_4277_j == 0L) {
            this.func_485_a(false, (IProgressUpdate)null);
        }

        this.field_797_s.func_22180_a(var2);
        this.func_518_a(false);
        this.func_4073_g();
    }

    private void func_27070_x() {
        if (this.field_797_s.func_27115_l()) {
            this.field_27078_C = 1.0F;
            if (this.field_797_s.func_27122_j()) {
                this.field_27076_E = 1.0F;
            }
        }

    }

    protected void func_27066_i() {
        if (!this.field_4272_q.field_4306_c) {
            if (this.field_27075_F > 0) {
                --this.field_27075_F;
            }

            int var1 = this.field_797_s.func_27117_k();
            if (var1 <= 0) {
                if (this.field_797_s.func_27122_j()) {
                    this.field_797_s.func_27121_b(this.field_803_m.nextInt(12000) + 3600);
                } else {
                    this.field_797_s.func_27121_b(this.field_803_m.nextInt(168000) + 12000);
                }
            } else {
                --var1;
                this.field_797_s.func_27121_b(var1);
                if (var1 <= 0) {
                    this.field_797_s.func_27119_a(!this.field_797_s.func_27122_j());
                }
            }

            int var2 = this.field_797_s.func_27120_m();
            if (var2 <= 0) {
                if (this.field_797_s.func_27115_l()) {
                    this.field_797_s.func_27118_c(this.field_803_m.nextInt(12000) + 12000);
                } else {
                    this.field_797_s.func_27118_c(this.field_803_m.nextInt(168000) + 12000);
                }
            } else {
                --var2;
                this.field_797_s.func_27118_c(var2);
                if (var2 <= 0) {
                    this.field_797_s.func_27116_b(!this.field_797_s.func_27115_l());
                }
            }

            this.field_27079_B = this.field_27078_C;
            if (this.field_797_s.func_27115_l()) {
                this.field_27078_C = (float)((double)this.field_27078_C + 0.01D);
            } else {
                this.field_27078_C = (float)((double)this.field_27078_C - 0.01D);
            }

            if (this.field_27078_C < 0.0F) {
                this.field_27078_C = 0.0F;
            }

            if (this.field_27078_C > 1.0F) {
                this.field_27078_C = 1.0F;
            }

            this.field_27077_D = this.field_27076_E;
            if (this.field_797_s.func_27122_j()) {
                this.field_27076_E = (float)((double)this.field_27076_E + 0.01D);
            } else {
                this.field_27076_E = (float)((double)this.field_27076_E - 0.01D);
            }

            if (this.field_27076_E < 0.0F) {
                this.field_27076_E = 0.0F;
            }

            if (this.field_27076_E > 1.0F) {
                this.field_27076_E = 1.0F;
            }

        }
    }

    private void func_27071_y() {
        this.field_797_s.func_27118_c(0);
        this.field_797_s.func_27116_b(false);
        this.field_797_s.func_27121_b(0);
        this.field_797_s.func_27119_a(false);
    }

    protected void func_4073_g() {
        this.field_4264_K.clear();

        int var3;
        int var4;
        int var6;
        int var7;
        for(int var1 = 0; var1 < this.field_805_k.size(); ++var1) {
            EntityPlayer var2 = (EntityPlayer)this.field_805_k.get(var1);
            var3 = MathHelper.func_584_b(var2.field_322_l / 16.0D);
            var4 = MathHelper.func_584_b(var2.field_320_n / 16.0D);
            byte var5 = 9;

            for(var6 = -var5; var6 <= var5; ++var6) {
                for(var7 = -var5; var7 <= var5; ++var7) {
                    this.field_4264_K.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
                }
            }
        }

        if (this.field_4263_L > 0) {
            --this.field_4263_L;
        }

        Iterator var12 = this.field_4264_K.iterator();

        while(var12.hasNext()) {
            ChunkCoordIntPair var13 = (ChunkCoordIntPair)var12.next();
            var3 = var13.field_152_a * 16;
            var4 = var13.field_151_b * 16;
            Chunk var14 = this.func_525_b(var13.field_152_a, var13.field_151_b);
            int var8;
            int var9;
            int var10;
            if (this.field_4263_L == 0) {
                this.field_4279_g = this.field_4279_g * 3 + 1013904223;
                var6 = this.field_4279_g >> 2;
                var7 = var6 & 15;
                var8 = var6 >> 8 & 15;
                var9 = var6 >> 16 & 127;
                var10 = var14.func_344_a(var7, var9, var8);
                var7 += var3;
                var8 += var4;
                if (var10 == 0 && this.func_28098_j(var7, var9, var8) <= this.field_803_m.nextInt(8) && this.func_512_a(EnumSkyBlock.Sky, var7, var9, var8) <= 0) {
                    EntityPlayer var11 = this.func_456_a((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D, 8.0D);
                    if (var11 != null && var11.func_101_d((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D) > 4.0D) {
                        this.func_502_a((double)var7 + 0.5D, (double)var9 + 0.5D, (double)var8 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_803_m.nextFloat() * 0.2F);
                        this.field_4263_L = this.field_803_m.nextInt(12000) + 6000;
                    }
                }
            }

            if (this.field_803_m.nextInt(100000) == 0 && this.func_27068_v() && this.func_27067_u()) {
                this.field_4279_g = this.field_4279_g * 3 + 1013904223;
                var6 = this.field_4279_g >> 2;
                var7 = var3 + (var6 & 15);
                var8 = var4 + (var6 >> 8 & 15);
                var9 = this.func_28100_e(var7, var8);
                if (this.func_27072_q(var7, var9, var8)) {
                    this.func_27073_a(new EntityLightningBolt(this, (double)var7, (double)var9, (double)var8));
                    this.field_27075_F = 2;
                }
            }

            int var15;
            if (this.field_803_m.nextInt(16) == 0) {
                this.field_4279_g = this.field_4279_g * 3 + 1013904223;
                var6 = this.field_4279_g >> 2;
                var7 = var6 & 15;
                var8 = var6 >> 8 & 15;
                var9 = this.func_28100_e(var7 + var3, var8 + var4);
                if (this.func_4077_a().func_4067_a(var7 + var3, var8 + var4).func_27049_c() && var9 >= 0 && var9 < 128 && var14.func_341_a(EnumSkyBlock.Block, var7, var9, var8) < 10) {
                    var10 = var14.func_344_a(var7, var9 - 1, var8);
                    var15 = var14.func_344_a(var7, var9, var8);
                    if (this.func_27068_v() && var15 == 0 && Block.field_625_aT.func_259_a(this, var7 + var3, var9, var8 + var4) && var10 != 0 && var10 != Block.field_4077_aU.field_573_bc && Block.field_542_n[var10].field_553_bn.func_218_c()) {
                        this.func_508_d(var7 + var3, var9, var8 + var4, Block.field_625_aT.field_573_bc);
                    }

                    if (var10 == Block.field_596_C.field_573_bc && var14.func_356_b(var7, var9 - 1, var8) == 0) {
                        this.func_508_d(var7 + var3, var9 - 1, var8 + var4, Block.field_4077_aU.field_573_bc);
                    }
                }
            }

            for(var6 = 0; var6 < 80; ++var6) {
                this.field_4279_g = this.field_4279_g * 3 + 1013904223;
                var7 = this.field_4279_g >> 2;
                var8 = var7 & 15;
                var9 = var7 >> 8 & 15;
                var10 = var7 >> 16 & 127;
                var15 = var14.field_693_b[var8 << 11 | var9 << 7 | var10] & 255;
                if (Block.field_541_o[var15]) {
                    Block.field_542_n[var15].func_221_a(this, var8 + var3, var10, var9 + var4, this.field_803_m);
                }
            }
        }

    }

    public boolean func_518_a(boolean var1) {
        int var2 = this.field_789_A.size();
        if (var2 != this.field_788_B.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        } else {
            if (var2 > 1000) {
                var2 = 1000;
            }

            for(int var3 = 0; var3 < var2; ++var3) {
                NextTickListEntry var4 = (NextTickListEntry)this.field_789_A.first();
                if (!var1 && var4.field_1021_e > this.field_797_s.func_22186_f()) {
                    break;
                }

                this.field_789_A.remove(var4);
                this.field_788_B.remove(var4);
                byte var5 = 8;
                if (this.func_466_a(var4.field_1018_a - var5, var4.field_1017_b - var5, var4.field_1023_c - var5, var4.field_1018_a + var5, var4.field_1017_b + var5, var4.field_1023_c + var5)) {
                    int var6 = this.func_444_a(var4.field_1018_a, var4.field_1017_b, var4.field_1023_c);
                    if (var6 == var4.field_1022_d && var6 > 0) {
                        Block.field_542_n[var6].func_221_a(this, var4.field_1018_a, var4.field_1017_b, var4.field_1023_c, this.field_803_m);
                    }
                }
            }

            return this.field_789_A.size() != 0;
        }
    }

    public List func_450_b(Entity var1, AxisAlignedBB var2) {
        this.field_778_L.clear();
        int var3 = MathHelper.func_584_b((var2.field_964_a - 2.0D) / 16.0D);
        int var4 = MathHelper.func_584_b((var2.field_969_d + 2.0D) / 16.0D);
        int var5 = MathHelper.func_584_b((var2.field_970_c - 2.0D) / 16.0D);
        int var6 = MathHelper.func_584_b((var2.field_967_f + 2.0D) / 16.0D);

        for(int var7 = var3; var7 <= var4; ++var7) {
            for(int var8 = var5; var8 <= var6; ++var8) {
                if (this.func_447_g(var7, var8)) {
                    this.func_525_b(var7, var8).func_329_a(var1, var2, this.field_778_L);
                }
            }
        }

        return this.field_778_L;
    }

    public List func_457_a(Class var1, AxisAlignedBB var2) {
        int var3 = MathHelper.func_584_b((var2.field_964_a - 2.0D) / 16.0D);
        int var4 = MathHelper.func_584_b((var2.field_969_d + 2.0D) / 16.0D);
        int var5 = MathHelper.func_584_b((var2.field_970_c - 2.0D) / 16.0D);
        int var6 = MathHelper.func_584_b((var2.field_967_f + 2.0D) / 16.0D);
        ArrayList var7 = new ArrayList();

        for(int var8 = var3; var8 <= var4; ++var8) {
            for(int var9 = var5; var9 <= var6; ++var9) {
                if (this.func_447_g(var8, var9)) {
                    this.func_525_b(var8, var9).func_342_a(var1, var2, var7);
                }
            }
        }

        return var7;
    }

    public void func_515_b(int var1, int var2, int var3, TileEntity var4) {
        if (this.func_530_e(var1, var2, var3)) {
            this.func_492_a(var1, var3).func_336_e();
        }

        for(int var5 = 0; var5 < this.field_798_r.size(); ++var5) {
            ((IWorldAccess)this.field_798_r.get(var5)).func_686_a(var1, var2, var3, var4);
        }

    }

    public int func_487_a(Class var1) {
        int var2 = 0;

        for(int var3 = 0; var3 < this.field_815_a.size(); ++var3) {
            Entity var4 = (Entity)this.field_815_a.get(var3);
            if (var1.isAssignableFrom(var4.getClass())) {
                ++var2;
            }
        }

        return var2;
    }

    public void func_464_a(List var1) {
        this.field_815_a.addAll(var1);

        for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.func_479_b((Entity)var1.get(var2));
        }

    }

    public void func_461_b(List var1) {
        this.field_790_z.addAll(var1);
    }

    public boolean func_516_a(int var1, int var2, int var3, int var4, boolean var5, int var6) {
        int var7 = this.func_444_a(var2, var3, var4);
        Block var8 = Block.field_542_n[var7];
        Block var9 = Block.field_542_n[var1];
        AxisAlignedBB var10 = var9.func_248_d(this, var2, var3, var4);
        if (var5) {
            var10 = null;
        }

        if (var10 != null && !this.func_522_a(var10)) {
            return false;
        } else {
            if (var8 == Block.field_598_B || var8 == Block.field_596_C || var8 == Block.field_594_D || var8 == Block.field_592_E || var8 == Block.field_599_as || var8 == Block.field_625_aT) {
                var8 = null;
            }

            return var1 > 0 && var8 == null && var9.func_28026_e(this, var2, var3, var4, var6);
        }
    }

    public PathEntity func_482_a(Entity var1, Entity var2, float var3) {
        int var4 = MathHelper.func_584_b(var1.field_322_l);
        int var5 = MathHelper.func_584_b(var1.field_321_m);
        int var6 = MathHelper.func_584_b(var1.field_320_n);
        int var7 = (int)(var3 + 16.0F);
        int var8 = var4 - var7;
        int var9 = var5 - var7;
        int var10 = var6 - var7;
        int var11 = var4 + var7;
        int var12 = var5 + var7;
        int var13 = var6 + var7;
        ChunkCache var14 = new ChunkCache(this, var8, var9, var10, var11, var12, var13);
        return (new Pathfinder(var14)).func_657_a(var1, var2, var3);
    }

    public PathEntity func_501_a(Entity var1, int var2, int var3, int var4, float var5) {
        int var6 = MathHelper.func_584_b(var1.field_322_l);
        int var7 = MathHelper.func_584_b(var1.field_321_m);
        int var8 = MathHelper.func_584_b(var1.field_320_n);
        int var9 = (int)(var5 + 8.0F);
        int var10 = var6 - var9;
        int var11 = var7 - var9;
        int var12 = var8 - var9;
        int var13 = var6 + var9;
        int var14 = var7 + var9;
        int var15 = var8 + var9;
        ChunkCache var16 = new ChunkCache(this, var10, var11, var12, var13, var14, var15);
        return (new Pathfinder(var16)).func_651_a(var1, var2, var3, var4, var5);
    }

    public boolean func_448_i(int var1, int var2, int var3, int var4) {
        int var5 = this.func_444_a(var1, var2, var3);
        return var5 == 0 ? false : Block.field_542_n[var5].func_238_d(this, var1, var2, var3, var4);
    }

    public boolean func_496_m(int var1, int var2, int var3) {
        if (this.func_448_i(var1, var2 - 1, var3, 0)) {
            return true;
        } else if (this.func_448_i(var1, var2 + 1, var3, 1)) {
            return true;
        } else if (this.func_448_i(var1, var2, var3 - 1, 2)) {
            return true;
        } else if (this.func_448_i(var1, var2, var3 + 1, 3)) {
            return true;
        } else if (this.func_448_i(var1 - 1, var2, var3, 4)) {
            return true;
        } else {
            return this.func_448_i(var1 + 1, var2, var3, 5);
        }
    }

    public boolean func_489_j(int var1, int var2, int var3, int var4) {
        if (this.func_445_d(var1, var2, var3)) {
            return this.func_496_m(var1, var2, var3);
        } else {
            int var5 = this.func_444_a(var1, var2, var3);
            return var5 == 0 ? false : Block.field_542_n[var5].func_239_b(this, var1, var2, var3, var4);
        }
    }

    public boolean func_474_n(int var1, int var2, int var3) {
        if (this.func_489_j(var1, var2 - 1, var3, 0)) {
            return true;
        } else if (this.func_489_j(var1, var2 + 1, var3, 1)) {
            return true;
        } else if (this.func_489_j(var1, var2, var3 - 1, 2)) {
            return true;
        } else if (this.func_489_j(var1, var2, var3 + 1, 3)) {
            return true;
        } else if (this.func_489_j(var1 - 1, var2, var3, 4)) {
            return true;
        } else {
            return this.func_489_j(var1 + 1, var2, var3, 5);
        }
    }

    public EntityPlayer func_472_a(Entity var1, double var2) {
        return this.func_456_a(var1.field_322_l, var1.field_321_m, var1.field_320_n, var2);
    }

    public EntityPlayer func_456_a(double var1, double var3, double var5, double var7) {
        double var9 = -1.0D;
        EntityPlayer var11 = null;

        for(int var12 = 0; var12 < this.field_805_k.size(); ++var12) {
            EntityPlayer var13 = (EntityPlayer)this.field_805_k.get(var12);
            double var14 = var13.func_101_d(var1, var3, var5);
            if ((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
                var9 = var14;
                var11 = var13;
            }
        }

        return var11;
    }

    public EntityPlayer func_25071_a(String var1) {
        for(int var2 = 0; var2 < this.field_805_k.size(); ++var2) {
            if (var1.equals(((EntityPlayer)this.field_805_k.get(var2)).field_409_aq)) {
                return (EntityPlayer)this.field_805_k.get(var2);
            }
        }

        return null;
    }

    public byte[] func_504_c(int var1, int var2, int var3, int var4, int var5, int var6) {
        byte[] var7 = new byte[var4 * var5 * var6 * 5 / 2];
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

                var12 = this.func_525_b(var15, var18).func_340_a(var7, var16, var13, var19, var17, var14, var20, var12);
            }
        }

        return var7;
    }

    public void func_476_g() {
        this.field_9211_s.func_22091_b();
    }

    public void func_22076_a(long var1) {
        this.field_797_s.func_22180_a(var1);
    }

    public void func_32005_b(long var1) {
        long var3 = var1 - this.field_797_s.func_22186_f();

        NextTickListEntry var6;
        for(Iterator var5 = this.field_788_B.iterator(); var5.hasNext(); var6.field_1021_e += var3) {
            var6 = (NextTickListEntry)var5.next();
        }

        this.func_22076_a(var1);
    }

    public long func_22079_j() {
        return this.field_797_s.func_22187_b();
    }

    public long func_22080_k() {
        return this.field_797_s.func_22186_f();
    }

    public ChunkCoordinates func_22078_l() {
        return new ChunkCoordinates(this.field_797_s.func_22184_c(), this.field_797_s.func_22179_d(), this.field_797_s.func_22189_e());
    }

    public boolean func_6157_a(EntityPlayer var1, int var2, int var3, int var4) {
        return true;
    }

    public void func_9206_a(Entity var1, byte var2) {
    }

    public IChunkProvider func_25073_n() {
        return this.field_783_G;
    }

    public void func_21117_c(int var1, int var2, int var3, int var4, int var5) {
        int var6 = this.func_444_a(var1, var2, var3);
        if (var6 > 0) {
            Block.field_542_n[var6].func_21024_a(this, var1, var2, var3, var4, var5);
        }

    }

    public ISaveHandler func_22075_m() {
        return this.field_9211_s;
    }

    public WorldInfo func_22081_n() {
        return this.field_797_s;
    }

    public void func_22082_o() {
        this.field_22087_A = !this.field_805_k.isEmpty();
        Iterator var1 = this.field_805_k.iterator();

        while(var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (!var2.func_22057_E()) {
                this.field_22087_A = false;
                break;
            }
        }

    }

    protected void func_22083_p() {
        this.field_22087_A = false;
        Iterator var1 = this.field_805_k.iterator();

        while(var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (var2.func_22057_E()) {
                var2.func_22062_a(false, false, true);
            }
        }

        this.func_27071_y();
    }

    public boolean func_22084_q() {
        if (this.field_22087_A && !this.field_792_x) {
            Iterator var1 = this.field_805_k.iterator();

            EntityPlayer var2;
            do {
                if (!var1.hasNext()) {
                    return true;
                }

                var2 = (EntityPlayer)var1.next();
            } while(var2.func_22065_F());

            return false;
        } else {
            return false;
        }
    }

    public float func_27065_c(float var1) {
        return (this.field_27077_D + (this.field_27076_E - this.field_27077_D) * var1) * this.func_27074_d(var1);
    }

    public float func_27074_d(float var1) {
        return this.field_27079_B + (this.field_27078_C - this.field_27079_B) * var1;
    }

    public boolean func_27067_u() {
        return (double)this.func_27065_c(1.0F) > 0.9D;
    }

    public boolean func_27068_v() {
        return (double)this.func_27074_d(1.0F) > 0.2D;
    }

    public boolean func_27072_q(int var1, int var2, int var3) {
        if (!this.func_27068_v()) {
            return false;
        } else if (!this.func_497_g(var1, var2, var3)) {
            return false;
        } else if (this.func_28100_e(var1, var3) > var2) {
            return false;
        } else {
            BiomeGenBase var4 = this.func_4077_a().func_4067_a(var1, var3);
            return var4.func_27049_c() ? false : var4.func_27048_d();
        }
    }

    public void func_28102_a(String var1, MapDataBase var2) {
        this.field_28105_z.func_28177_a(var1, var2);
    }

    public MapDataBase func_28103_a(Class var1, String var2) {
        return this.field_28105_z.func_28178_a(var1, var2);
    }

    public int func_28104_b(String var1) {
        return this.field_28105_z.func_28173_a(var1);
    }

    public void func_28097_e(int var1, int var2, int var3, int var4, int var5) {
        this.func_28101_a((EntityPlayer)null, var1, var2, var3, var4, var5);
    }

    public void func_28101_a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.field_798_r.size(); ++var7) {
            ((IWorldAccess)this.field_798_r.get(var7)).func_28133_a(var1, var2, var3, var4, var5, var6);
        }

    }
}
