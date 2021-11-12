package net.minecraft.src;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class RenderGlobal implements IWorldAccess {
    public List field_1458_a = new ArrayList();
    private World field_1448_k;
    private RenderEngine field_1447_l;
    private List field_1446_m = new ArrayList();
    private WorldRenderer[] field_1445_n;
    private WorldRenderer[] field_1444_o;
    private int field_1443_p;
    private int field_1442_q;
    private int field_1441_r;
    private int field_1440_s;
    private Minecraft field_1439_t;
    private RenderBlocks field_1438_u;
    private IntBuffer field_1437_v;
    private boolean field_1436_w = false;
    private int field_1435_x = 0;
    private int field_1434_y;
    private int field_1433_z;
    private int field_1432_A;
    private int field_1431_B;
    private int field_1430_C;
    private int field_1429_D;
    private int field_1428_E;
    private int field_1427_F;
    private int field_1426_G;
    private int field_1425_H = -1;
    private int field_1424_I = 2;
    private int field_1423_J;
    private int field_1422_K;
    private int field_1421_L;
    int[] field_1457_b = new int['\uc350'];
    IntBuffer field_1456_c = GLAllocation.func_1125_c(64);
    private int field_1420_M;
    private int field_1419_N;
    private int field_1418_O;
    private int field_1417_P;
    private int field_1416_Q;
    private int field_21156_R;
    private List field_1415_R = new ArrayList();
    private RenderList[] field_1414_S = new RenderList[]{new RenderList(), new RenderList(), new RenderList(), new RenderList()};
    int field_1455_d = 0;
    int field_1454_e = GLAllocation.func_1124_a(1);
    double field_1453_f = -9999.0D;
    double field_1452_g = -9999.0D;
    double field_1451_h = -9999.0D;
    public float field_1450_i;
    int field_1449_j = 0;

    public RenderGlobal(Minecraft var1, RenderEngine var2) {
        this.field_1439_t = var1;
        this.field_1447_l = var2;
        byte var3 = 64;
        this.field_1440_s = GLAllocation.func_1124_a(var3 * var3 * var3 * 3);
        this.field_1436_w = var1.func_6251_l().func_1213_a();
        if (this.field_1436_w) {
            this.field_1456_c.clear();
            this.field_1437_v = GLAllocation.func_1125_c(var3 * var3 * var3);
            this.field_1437_v.clear();
            this.field_1437_v.position(0);
            this.field_1437_v.limit(var3 * var3 * var3);
            ARBOcclusionQuery.glGenQueriesARB(this.field_1437_v);
        }

        this.field_1434_y = GLAllocation.func_1124_a(3);
        GL11.glPushMatrix();
        GL11.glNewList(this.field_1434_y, 4864);
        this.func_950_f();
        GL11.glEndList();
        GL11.glPopMatrix();
        Tessellator var4 = Tessellator.field_1512_a;
        this.field_1433_z = this.field_1434_y + 1;
        GL11.glNewList(this.field_1433_z, 4864);
        byte var6 = 64;
        int var7 = 256 / var6 + 2;
        float var5 = 16.0F;

        int var8;
        int var9;
        for(var8 = -var6 * var7; var8 <= var6 * var7; var8 += var6) {
            for(var9 = -var6 * var7; var9 <= var6 * var7; var9 += var6) {
                var4.func_977_b();
                var4.func_991_a((double)(var8 + 0), (double)var5, (double)(var9 + 0));
                var4.func_991_a((double)(var8 + var6), (double)var5, (double)(var9 + 0));
                var4.func_991_a((double)(var8 + var6), (double)var5, (double)(var9 + var6));
                var4.func_991_a((double)(var8 + 0), (double)var5, (double)(var9 + var6));
                var4.func_982_a();
            }
        }

        GL11.glEndList();
        this.field_1432_A = this.field_1434_y + 2;
        GL11.glNewList(this.field_1432_A, 4864);
        var5 = -16.0F;
        var4.func_977_b();

        for(var8 = -var6 * var7; var8 <= var6 * var7; var8 += var6) {
            for(var9 = -var6 * var7; var9 <= var6 * var7; var9 += var6) {
                var4.func_991_a((double)(var8 + var6), (double)var5, (double)(var9 + 0));
                var4.func_991_a((double)(var8 + 0), (double)var5, (double)(var9 + 0));
                var4.func_991_a((double)(var8 + 0), (double)var5, (double)(var9 + var6));
                var4.func_991_a((double)(var8 + var6), (double)var5, (double)(var9 + var6));
            }
        }

        var4.func_982_a();
        GL11.glEndList();
    }

    private void func_950_f() {
        Random var1 = new Random(10842L);
        Tessellator var2 = Tessellator.field_1512_a;
        var2.func_977_b();

        for(int var3 = 0; var3 < 1500; ++var3) {
            double var4 = (double)(var1.nextFloat() * 2.0F - 1.0F);
            double var6 = (double)(var1.nextFloat() * 2.0F - 1.0F);
            double var8 = (double)(var1.nextFloat() * 2.0F - 1.0F);
            double var10 = (double)(0.25F + var1.nextFloat() * 0.25F);
            double var12 = var4 * var4 + var6 * var6 + var8 * var8;
            if (var12 < 1.0D && var12 > 0.01D) {
                var12 = 1.0D / Math.sqrt(var12);
                var4 *= var12;
                var6 *= var12;
                var8 *= var12;
                double var14 = var4 * 100.0D;
                double var16 = var6 * 100.0D;
                double var18 = var8 * 100.0D;
                double var20 = Math.atan2(var4, var8);
                double var22 = Math.sin(var20);
                double var24 = Math.cos(var20);
                double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
                double var28 = Math.sin(var26);
                double var30 = Math.cos(var26);
                double var32 = var1.nextDouble() * 3.141592653589793D * 2.0D;
                double var34 = Math.sin(var32);
                double var36 = Math.cos(var32);

                for(int var38 = 0; var38 < 4; ++var38) {
                    double var39 = 0.0D;
                    double var41 = (double)((var38 & 2) - 1) * var10;
                    double var43 = (double)((var38 + 1 & 2) - 1) * var10;
                    double var47 = var41 * var36 - var43 * var34;
                    double var49 = var43 * var36 + var41 * var34;
                    double var53 = var47 * var28 + var39 * var30;
                    double var55 = var39 * var28 - var47 * var30;
                    double var57 = var55 * var22 - var49 * var24;
                    double var61 = var49 * var22 + var55 * var24;
                    var2.func_991_a(var14 + var57, var16 + var53, var18 + var61);
                }
            }
        }

        var2.func_982_a();
    }

    public void func_946_a(World var1) {
        if (this.field_1448_k != null) {
            this.field_1448_k.func_672_b(this);
        }

        this.field_1453_f = -9999.0D;
        this.field_1452_g = -9999.0D;
        this.field_1451_h = -9999.0D;
        RenderManager.field_1233_a.func_852_a(var1);
        this.field_1448_k = var1;
        this.field_1438_u = new RenderBlocks(var1);
        if (var1 != null) {
            var1.func_613_a(this);
            this.func_958_a();
        }

    }

    public void func_958_a() {
        Block.field_384_L.func_310_a(this.field_1439_t.field_6304_y.field_1576_i);
        this.field_1425_H = this.field_1439_t.field_6304_y.field_1580_e;
        int var1;
        if (this.field_1444_o != null) {
            for(var1 = 0; var1 < this.field_1444_o.length; ++var1) {
                this.field_1444_o[var1].func_1204_c();
            }
        }

        var1 = 64 << 3 - this.field_1425_H;
        if (var1 > 400) {
            var1 = 400;
        }

        this.field_1443_p = var1 / 16 + 1;
        this.field_1442_q = 8;
        this.field_1441_r = var1 / 16 + 1;
        this.field_1444_o = new WorldRenderer[this.field_1443_p * this.field_1442_q * this.field_1441_r];
        this.field_1445_n = new WorldRenderer[this.field_1443_p * this.field_1442_q * this.field_1441_r];
        int var2 = 0;
        int var3 = 0;
        this.field_1431_B = 0;
        this.field_1430_C = 0;
        this.field_1429_D = 0;
        this.field_1428_E = this.field_1443_p;
        this.field_1427_F = this.field_1442_q;
        this.field_1426_G = this.field_1441_r;

        int var4;
        for(var4 = 0; var4 < this.field_1446_m.size(); ++var4) {
            ((WorldRenderer)this.field_1446_m.get(var4)).field_1738_u = false;
        }

        this.field_1446_m.clear();
        this.field_1458_a.clear();

        for(var4 = 0; var4 < this.field_1443_p; ++var4) {
            for(int var5 = 0; var5 < this.field_1442_q; ++var5) {
                for(int var6 = 0; var6 < this.field_1441_r; ++var6) {
                    this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4] = new WorldRenderer(this.field_1448_k, this.field_1458_a, var4 * 16, var5 * 16, var6 * 16, 16, this.field_1440_s + var2);
                    if (this.field_1436_w) {
                        this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1732_z = this.field_1437_v.get(var3);
                    }

                    this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1733_y = false;
                    this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1734_x = true;
                    this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1749_o = true;
                    this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1735_w = var3++;
                    this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].func_1194_f();
                    this.field_1445_n[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4] = this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4];
                    this.field_1446_m.add(this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4]);
                    var2 += 3;
                }
            }
        }

        if (this.field_1448_k != null) {
            EntityLiving var7 = this.field_1439_t.field_22009_h;
            if (var7 != null) {
                this.func_956_b(MathHelper.func_1108_b(var7.field_611_ak), MathHelper.func_1108_b(var7.field_610_al), MathHelper.func_1108_b(var7.field_609_am));
                Arrays.sort(this.field_1445_n, new EntitySorter(var7));
            }
        }

        this.field_1424_I = 2;
    }

    public void func_951_a(Vec3D var1, ICamera var2, float var3) {
        if (this.field_1424_I > 0) {
            --this.field_1424_I;
        } else {
            TileEntityRenderer.field_1554_a.func_22267_a(this.field_1448_k, this.field_1447_l, this.field_1439_t.field_6314_o, this.field_1439_t.field_22009_h, var3);
            RenderManager.field_1233_a.func_22187_a(this.field_1448_k, this.field_1447_l, this.field_1439_t.field_6314_o, this.field_1439_t.field_22009_h, this.field_1439_t.field_6304_y, var3);
            this.field_1423_J = 0;
            this.field_1422_K = 0;
            this.field_1421_L = 0;
            EntityLiving var4 = this.field_1439_t.field_22009_h;
            RenderManager.field_1232_b = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)var3;
            RenderManager.field_1231_c = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)var3;
            RenderManager.field_1230_d = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)var3;
            TileEntityRenderer.field_1553_b = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)var3;
            TileEntityRenderer.field_1552_c = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)var3;
            TileEntityRenderer.field_1551_d = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)var3;
            List var5 = this.field_1448_k.func_658_i();
            this.field_1423_J = var5.size();

            int var6;
            Entity var7;
            for(var6 = 0; var6 < this.field_1448_k.field_27173_e.size(); ++var6) {
                var7 = (Entity)this.field_1448_k.field_27173_e.get(var6);
                ++this.field_1422_K;
                if (var7.func_390_a(var1)) {
                    RenderManager.field_1233_a.func_854_a(var7, var3);
                }
            }

            for(var6 = 0; var6 < var5.size(); ++var6) {
                var7 = (Entity)var5.get(var6);
                if (var7.func_390_a(var1) && (var7.field_28016_bK || var2.func_342_a(var7.field_601_au)) && (var7 != this.field_1439_t.field_22009_h || this.field_1439_t.field_6304_y.field_1560_x || this.field_1439_t.field_22009_h.func_22051_K())) {
                    int var8 = MathHelper.func_1108_b(var7.field_610_al);
                    if (var8 < 0) {
                        var8 = 0;
                    }

                    if (var8 >= 128) {
                        var8 = 127;
                    }

                    if (this.field_1448_k.func_630_d(MathHelper.func_1108_b(var7.field_611_ak), var8, MathHelper.func_1108_b(var7.field_609_am))) {
                        ++this.field_1422_K;
                        RenderManager.field_1233_a.func_854_a(var7, var3);
                    }
                }
            }

            for(var6 = 0; var6 < this.field_1458_a.size(); ++var6) {
                TileEntityRenderer.field_1554_a.func_1030_a((TileEntity)this.field_1458_a.get(var6), var3);
            }

        }
    }

    public String func_953_b() {
        return "C: " + this.field_1417_P + "/" + this.field_1420_M + ". F: " + this.field_1419_N + ", O: " + this.field_1418_O + ", E: " + this.field_1416_Q;
    }

    public String func_957_c() {
        return "E: " + this.field_1422_K + "/" + this.field_1423_J + ". B: " + this.field_1421_L + ", I: " + (this.field_1423_J - this.field_1421_L - this.field_1422_K);
    }

    private void func_956_b(int var1, int var2, int var3) {
        var1 -= 8;
        var2 -= 8;
        var3 -= 8;
        this.field_1431_B = Integer.MAX_VALUE;
        this.field_1430_C = Integer.MAX_VALUE;
        this.field_1429_D = Integer.MAX_VALUE;
        this.field_1428_E = Integer.MIN_VALUE;
        this.field_1427_F = Integer.MIN_VALUE;
        this.field_1426_G = Integer.MIN_VALUE;
        int var4 = this.field_1443_p * 16;
        int var5 = var4 / 2;

        for(int var6 = 0; var6 < this.field_1443_p; ++var6) {
            int var7 = var6 * 16;
            int var8 = var7 + var5 - var1;
            if (var8 < 0) {
                var8 -= var4 - 1;
            }

            var8 /= var4;
            var7 -= var8 * var4;
            if (var7 < this.field_1431_B) {
                this.field_1431_B = var7;
            }

            if (var7 > this.field_1428_E) {
                this.field_1428_E = var7;
            }

            for(int var9 = 0; var9 < this.field_1441_r; ++var9) {
                int var10 = var9 * 16;
                int var11 = var10 + var5 - var3;
                if (var11 < 0) {
                    var11 -= var4 - 1;
                }

                var11 /= var4;
                var10 -= var11 * var4;
                if (var10 < this.field_1429_D) {
                    this.field_1429_D = var10;
                }

                if (var10 > this.field_1426_G) {
                    this.field_1426_G = var10;
                }

                for(int var12 = 0; var12 < this.field_1442_q; ++var12) {
                    int var13 = var12 * 16;
                    if (var13 < this.field_1430_C) {
                        this.field_1430_C = var13;
                    }

                    if (var13 > this.field_1427_F) {
                        this.field_1427_F = var13;
                    }

                    WorldRenderer var14 = this.field_1444_o[(var9 * this.field_1442_q + var12) * this.field_1443_p + var6];
                    boolean var15 = var14.field_1738_u;
                    var14.func_1197_a(var7, var13, var10);
                    if (!var15 && var14.field_1738_u) {
                        this.field_1446_m.add(var14);
                    }
                }
            }
        }

    }

    public int func_943_a(EntityLiving var1, int var2, double var3) {
        for(int var5 = 0; var5 < 10; ++var5) {
            this.field_21156_R = (this.field_21156_R + 1) % this.field_1444_o.length;
            WorldRenderer var6 = this.field_1444_o[this.field_21156_R];
            if (var6.field_1738_u && !this.field_1446_m.contains(var6)) {
                this.field_1446_m.add(var6);
            }
        }

        if (this.field_1439_t.field_6304_y.field_1580_e != this.field_1425_H) {
            this.func_958_a();
        }

        if (var2 == 0) {
            this.field_1420_M = 0;
            this.field_1419_N = 0;
            this.field_1418_O = 0;
            this.field_1417_P = 0;
            this.field_1416_Q = 0;
        }

        double var33 = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * var3;
        double var7 = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * var3;
        double var9 = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * var3;
        double var11 = var1.field_611_ak - this.field_1453_f;
        double var13 = var1.field_610_al - this.field_1452_g;
        double var15 = var1.field_609_am - this.field_1451_h;
        if (var11 * var11 + var13 * var13 + var15 * var15 > 16.0D) {
            this.field_1453_f = var1.field_611_ak;
            this.field_1452_g = var1.field_610_al;
            this.field_1451_h = var1.field_609_am;
            this.func_956_b(MathHelper.func_1108_b(var1.field_611_ak), MathHelper.func_1108_b(var1.field_610_al), MathHelper.func_1108_b(var1.field_609_am));
            Arrays.sort(this.field_1445_n, new EntitySorter(var1));
        }

        RenderHelper.func_1159_a();
        byte var17 = 0;
        int var34;
        if (this.field_1436_w && this.field_1439_t.field_6304_y.field_27342_h && !this.field_1439_t.field_6304_y.field_1578_g && var2 == 0) {
            byte var18 = 0;
            int var19 = 16;
            this.func_962_a(var18, var19);

            for(int var20 = var18; var20 < var19; ++var20) {
                this.field_1445_n[var20].field_1734_x = true;
            }

            var34 = var17 + this.func_952_a(var18, var19, var2, var3);

            do {
                int var35 = var19;
                var19 *= 2;
                if (var19 > this.field_1445_n.length) {
                    var19 = this.field_1445_n.length;
                }

                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glDisable(2912);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                this.func_962_a(var35, var19);
                GL11.glPushMatrix();
                float var36 = 0.0F;
                float var21 = 0.0F;
                float var22 = 0.0F;

                for(int var23 = var35; var23 < var19; ++var23) {
                    if (this.field_1445_n[var23].func_1196_e()) {
                        this.field_1445_n[var23].field_1749_o = false;
                    } else {
                        if (!this.field_1445_n[var23].field_1749_o) {
                            this.field_1445_n[var23].field_1734_x = true;
                        }

                        if (this.field_1445_n[var23].field_1749_o && !this.field_1445_n[var23].field_1733_y) {
                            float var24 = MathHelper.func_1113_c(this.field_1445_n[var23].func_1202_a(var1));
                            int var25 = (int)(1.0F + var24 / 128.0F);
                            if (this.field_1435_x % var25 == var23 % var25) {
                                WorldRenderer var26 = this.field_1445_n[var23];
                                float var27 = (float)((double)var26.field_1755_i - var33);
                                float var28 = (float)((double)var26.field_1754_j - var7);
                                float var29 = (float)((double)var26.field_1753_k - var9);
                                float var30 = var27 - var36;
                                float var31 = var28 - var21;
                                float var32 = var29 - var22;
                                if (var30 != 0.0F || var31 != 0.0F || var32 != 0.0F) {
                                    GL11.glTranslatef(var30, var31, var32);
                                    var36 += var30;
                                    var21 += var31;
                                    var22 += var32;
                                }

                                ARBOcclusionQuery.glBeginQueryARB(35092, this.field_1445_n[var23].field_1732_z);
                                this.field_1445_n[var23].func_1201_d();
                                ARBOcclusionQuery.glEndQueryARB(35092);
                                this.field_1445_n[var23].field_1733_y = true;
                            }
                        }
                    }
                }

                GL11.glPopMatrix();
                if (this.field_1439_t.field_6304_y.field_1578_g) {
                    if (EntityRenderer.field_28134_b == 0) {
                        GL11.glColorMask(false, true, true, true);
                    } else {
                        GL11.glColorMask(true, false, false, true);
                    }
                } else {
                    GL11.glColorMask(true, true, true, true);
                }

                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glEnable(2912);
                var34 += this.func_952_a(var35, var19, var2, var3);
            } while(var19 < this.field_1445_n.length);
        } else {
            var34 = var17 + this.func_952_a(0, this.field_1445_n.length, var2, var3);
        }

        return var34;
    }

    private void func_962_a(int var1, int var2) {
        for(int var3 = var1; var3 < var2; ++var3) {
            if (this.field_1445_n[var3].field_1733_y) {
                this.field_1456_c.clear();
                ARBOcclusionQuery.glGetQueryObjectuARB(this.field_1445_n[var3].field_1732_z, 34919, this.field_1456_c);
                if (this.field_1456_c.get(0) != 0) {
                    this.field_1445_n[var3].field_1733_y = false;
                    this.field_1456_c.clear();
                    ARBOcclusionQuery.glGetQueryObjectuARB(this.field_1445_n[var3].field_1732_z, 34918, this.field_1456_c);
                    this.field_1445_n[var3].field_1734_x = this.field_1456_c.get(0) != 0;
                }
            }
        }

    }

    private int func_952_a(int var1, int var2, int var3, double var4) {
        this.field_1415_R.clear();
        int var6 = 0;

        for(int var7 = var1; var7 < var2; ++var7) {
            if (var3 == 0) {
                ++this.field_1420_M;
                if (this.field_1445_n[var7].field_1748_p[var3]) {
                    ++this.field_1416_Q;
                } else if (!this.field_1445_n[var7].field_1749_o) {
                    ++this.field_1419_N;
                } else if (this.field_1436_w && !this.field_1445_n[var7].field_1734_x) {
                    ++this.field_1418_O;
                } else {
                    ++this.field_1417_P;
                }
            }

            if (!this.field_1445_n[var7].field_1748_p[var3] && this.field_1445_n[var7].field_1749_o && (!this.field_1436_w || this.field_1445_n[var7].field_1734_x)) {
                int var8 = this.field_1445_n[var7].func_1200_a(var3);
                if (var8 >= 0) {
                    this.field_1415_R.add(this.field_1445_n[var7]);
                    ++var6;
                }
            }
        }

        EntityLiving var19 = this.field_1439_t.field_22009_h;
        double var20 = var19.field_638_aI + (var19.field_611_ak - var19.field_638_aI) * var4;
        double var10 = var19.field_637_aJ + (var19.field_610_al - var19.field_637_aJ) * var4;
        double var12 = var19.field_636_aK + (var19.field_609_am - var19.field_636_aK) * var4;
        int var14 = 0;

        int var15;
        for(var15 = 0; var15 < this.field_1414_S.length; ++var15) {
            this.field_1414_S[var15].func_859_b();
        }

        for(var15 = 0; var15 < this.field_1415_R.size(); ++var15) {
            WorldRenderer var16 = (WorldRenderer)this.field_1415_R.get(var15);
            int var17 = -1;

            for(int var18 = 0; var18 < var14; ++var18) {
                if (this.field_1414_S[var18].func_862_a(var16.field_1755_i, var16.field_1754_j, var16.field_1753_k)) {
                    var17 = var18;
                }
            }

            if (var17 < 0) {
                var17 = var14++;
                this.field_1414_S[var17].func_861_a(var16.field_1755_i, var16.field_1754_j, var16.field_1753_k, var20, var10, var12);
            }

            this.field_1414_S[var17].func_858_a(var16.func_1200_a(var3));
        }

        this.func_944_a(var3, var4);
        return var6;
    }

    public void func_944_a(int var1, double var2) {
        for(int var4 = 0; var4 < this.field_1414_S.length; ++var4) {
            this.field_1414_S[var4].func_860_a();
        }

    }

    public void func_945_d() {
        ++this.field_1435_x;
    }

    public void func_4142_a(float var1) {
        if (!this.field_1439_t.field_6324_e.field_4209_q.field_4220_c) {
            GL11.glDisable(3553);
            Vec3D var2 = this.field_1448_k.func_4079_a(this.field_1439_t.field_22009_h, var1);
            float var3 = (float)var2.field_1776_a;
            float var4 = (float)var2.field_1775_b;
            float var5 = (float)var2.field_1779_c;
            float var7;
            float var8;
            if (this.field_1439_t.field_6304_y.field_1578_g) {
                float var6 = (var3 * 30.0F + var4 * 59.0F + var5 * 11.0F) / 100.0F;
                var7 = (var3 * 30.0F + var4 * 70.0F) / 100.0F;
                var8 = (var3 * 30.0F + var5 * 70.0F) / 100.0F;
                var3 = var6;
                var4 = var7;
                var5 = var8;
            }

            GL11.glColor3f(var3, var4, var5);
            Tessellator var17 = Tessellator.field_1512_a;
            GL11.glDepthMask(false);
            GL11.glEnable(2912);
            GL11.glColor3f(var3, var4, var5);
            GL11.glCallList(this.field_1433_z);
            GL11.glDisable(2912);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            RenderHelper.func_1159_a();
            float[] var18 = this.field_1448_k.field_4209_q.func_4097_b(this.field_1448_k.func_619_c(var1), var1);
            float var9;
            float var10;
            float var11;
            float var12;
            if (var18 != null) {
                GL11.glDisable(3553);
                GL11.glShadeModel(7425);
                GL11.glPushMatrix();
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                var8 = this.field_1448_k.func_619_c(var1);
                GL11.glRotatef(var8 > 0.5F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
                var9 = var18[0];
                var10 = var18[1];
                var11 = var18[2];
                float var14;
                if (this.field_1439_t.field_6304_y.field_1578_g) {
                    var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
                    float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
                    var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
                    var9 = var12;
                    var10 = var13;
                    var11 = var14;
                }

                var17.func_992_a(6);
                var17.func_986_a(var9, var10, var11, var18[3]);
                var17.func_991_a(0.0D, 100.0D, 0.0D);
                byte var19 = 16;
                var17.func_986_a(var18[0], var18[1], var18[2], 0.0F);

                for(int var20 = 0; var20 <= var19; ++var20) {
                    var14 = (float)var20 * 3.1415927F * 2.0F / (float)var19;
                    float var15 = MathHelper.func_1106_a(var14);
                    float var16 = MathHelper.func_1114_b(var14);
                    var17.func_991_a((double)(var15 * 120.0F), (double)(var16 * 120.0F), (double)(-var16 * 40.0F * var18[3]));
                }

                var17.func_982_a();
                GL11.glPopMatrix();
                GL11.glShadeModel(7424);
            }

            GL11.glEnable(3553);
            GL11.glBlendFunc(770, 1);
            GL11.glPushMatrix();
            var7 = 1.0F - this.field_1448_k.func_27162_g(var1);
            var8 = 0.0F;
            var9 = 0.0F;
            var10 = 0.0F;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, var7);
            GL11.glTranslatef(var8, var9, var10);
            GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(this.field_1448_k.func_619_c(var1) * 360.0F, 1.0F, 0.0F, 0.0F);
            var11 = 30.0F;
            GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/terrain/sun.png"));
            var17.func_977_b();
            var17.func_983_a((double)(-var11), 100.0D, (double)(-var11), 0.0D, 0.0D);
            var17.func_983_a((double)var11, 100.0D, (double)(-var11), 1.0D, 0.0D);
            var17.func_983_a((double)var11, 100.0D, (double)var11, 1.0D, 1.0D);
            var17.func_983_a((double)(-var11), 100.0D, (double)var11, 0.0D, 1.0D);
            var17.func_982_a();
            var11 = 20.0F;
            GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/terrain/moon.png"));
            var17.func_977_b();
            var17.func_983_a((double)(-var11), -100.0D, (double)var11, 1.0D, 1.0D);
            var17.func_983_a((double)var11, -100.0D, (double)var11, 0.0D, 1.0D);
            var17.func_983_a((double)var11, -100.0D, (double)(-var11), 0.0D, 0.0D);
            var17.func_983_a((double)(-var11), -100.0D, (double)(-var11), 1.0D, 0.0D);
            var17.func_982_a();
            GL11.glDisable(3553);
            var12 = this.field_1448_k.func_679_f(var1) * var7;
            if (var12 > 0.0F) {
                GL11.glColor4f(var12, var12, var12, var12);
                GL11.glCallList(this.field_1434_y);
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(3008);
            GL11.glEnable(2912);
            GL11.glPopMatrix();
            if (this.field_1448_k.field_4209_q.func_28112_c()) {
                GL11.glColor3f(var3 * 0.2F + 0.04F, var4 * 0.2F + 0.04F, var5 * 0.6F + 0.1F);
            } else {
                GL11.glColor3f(var3, var4, var5);
            }

            GL11.glDisable(3553);
            GL11.glCallList(this.field_1432_A);
            GL11.glEnable(3553);
            GL11.glDepthMask(true);
        }
    }

    public void func_4141_b(float var1) {
        if (!this.field_1439_t.field_6324_e.field_4209_q.field_4220_c) {
            if (this.field_1439_t.field_6304_y.field_1576_i) {
                this.func_6510_c(var1);
            } else {
                GL11.glDisable(2884);
                float var2 = (float)(this.field_1439_t.field_22009_h.field_637_aJ + (this.field_1439_t.field_22009_h.field_610_al - this.field_1439_t.field_22009_h.field_637_aJ) * (double)var1);
                byte var3 = 32;
                int var4 = 256 / var3;
                Tessellator var5 = Tessellator.field_1512_a;
                GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/environment/clouds.png"));
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                Vec3D var6 = this.field_1448_k.func_628_d(var1);
                float var7 = (float)var6.field_1776_a;
                float var8 = (float)var6.field_1775_b;
                float var9 = (float)var6.field_1779_c;
                float var10;
                if (this.field_1439_t.field_6304_y.field_1578_g) {
                    var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
                    float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
                    float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
                    var7 = var10;
                    var8 = var11;
                    var9 = var12;
                }

                var10 = 4.8828125E-4F;
                double var22 = this.field_1439_t.field_22009_h.field_9285_at + (this.field_1439_t.field_22009_h.field_611_ak - this.field_1439_t.field_22009_h.field_9285_at) * (double)var1 + (double)(((float)this.field_1435_x + var1) * 0.03F);
                double var13 = this.field_1439_t.field_22009_h.field_9283_av + (this.field_1439_t.field_22009_h.field_609_am - this.field_1439_t.field_22009_h.field_9283_av) * (double)var1;
                int var15 = MathHelper.func_1108_b(var22 / 2048.0D);
                int var16 = MathHelper.func_1108_b(var13 / 2048.0D);
                var22 -= (double)(var15 * 2048);
                var13 -= (double)(var16 * 2048);
                float var17 = this.field_1448_k.field_4209_q.func_28111_d() - var2 + 0.33F;
                float var18 = (float)(var22 * (double)var10);
                float var19 = (float)(var13 * (double)var10);
                var5.func_977_b();
                var5.func_986_a(var7, var8, var9, 0.8F);

                for(int var20 = -var3 * var4; var20 < var3 * var4; var20 += var3) {
                    for(int var21 = -var3 * var4; var21 < var3 * var4; var21 += var3) {
                        var5.func_983_a((double)(var20 + 0), (double)var17, (double)(var21 + var3), (double)((float)(var20 + 0) * var10 + var18), (double)((float)(var21 + var3) * var10 + var19));
                        var5.func_983_a((double)(var20 + var3), (double)var17, (double)(var21 + var3), (double)((float)(var20 + var3) * var10 + var18), (double)((float)(var21 + var3) * var10 + var19));
                        var5.func_983_a((double)(var20 + var3), (double)var17, (double)(var21 + 0), (double)((float)(var20 + var3) * var10 + var18), (double)((float)(var21 + 0) * var10 + var19));
                        var5.func_983_a((double)(var20 + 0), (double)var17, (double)(var21 + 0), (double)((float)(var20 + 0) * var10 + var18), (double)((float)(var21 + 0) * var10 + var19));
                    }
                }

                var5.func_982_a();
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(3042);
                GL11.glEnable(2884);
            }
        }
    }

    public boolean func_27307_a(double var1, double var3, double var5, float var7) {
        return false;
    }

    public void func_6510_c(float var1) {
        GL11.glDisable(2884);
        float var2 = (float)(this.field_1439_t.field_22009_h.field_637_aJ + (this.field_1439_t.field_22009_h.field_610_al - this.field_1439_t.field_22009_h.field_637_aJ) * (double)var1);
        Tessellator var3 = Tessellator.field_1512_a;
        float var4 = 12.0F;
        float var5 = 4.0F;
        double var6 = (this.field_1439_t.field_22009_h.field_9285_at + (this.field_1439_t.field_22009_h.field_611_ak - this.field_1439_t.field_22009_h.field_9285_at) * (double)var1 + (double)(((float)this.field_1435_x + var1) * 0.03F)) / (double)var4;
        double var8 = (this.field_1439_t.field_22009_h.field_9283_av + (this.field_1439_t.field_22009_h.field_609_am - this.field_1439_t.field_22009_h.field_9283_av) * (double)var1) / (double)var4 + 0.33000001311302185D;
        float var10 = this.field_1448_k.field_4209_q.func_28111_d() - var2 + 0.33F;
        int var11 = MathHelper.func_1108_b(var6 / 2048.0D);
        int var12 = MathHelper.func_1108_b(var8 / 2048.0D);
        var6 -= (double)(var11 * 2048);
        var8 -= (double)(var12 * 2048);
        GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3D var13 = this.field_1448_k.func_628_d(var1);
        float var14 = (float)var13.field_1776_a;
        float var15 = (float)var13.field_1775_b;
        float var16 = (float)var13.field_1779_c;
        float var17;
        float var18;
        float var19;
        if (this.field_1439_t.field_6304_y.field_1578_g) {
            var17 = (var14 * 30.0F + var15 * 59.0F + var16 * 11.0F) / 100.0F;
            var18 = (var14 * 30.0F + var15 * 70.0F) / 100.0F;
            var19 = (var14 * 30.0F + var16 * 70.0F) / 100.0F;
            var14 = var17;
            var15 = var18;
            var16 = var19;
        }

        var17 = (float)(var6 * 0.0D);
        var18 = (float)(var8 * 0.0D);
        var19 = 0.00390625F;
        var17 = (float)MathHelper.func_1108_b(var6) * var19;
        var18 = (float)MathHelper.func_1108_b(var8) * var19;
        float var20 = (float)(var6 - (double)MathHelper.func_1108_b(var6));
        float var21 = (float)(var8 - (double)MathHelper.func_1108_b(var8));
        byte var22 = 8;
        byte var23 = 3;
        float var24 = 9.765625E-4F;
        GL11.glScalef(var4, 1.0F, var4);

        for(int var25 = 0; var25 < 2; ++var25) {
            if (var25 == 0) {
                GL11.glColorMask(false, false, false, false);
            } else if (this.field_1439_t.field_6304_y.field_1578_g) {
                if (EntityRenderer.field_28134_b == 0) {
                    GL11.glColorMask(false, true, true, true);
                } else {
                    GL11.glColorMask(true, false, false, true);
                }
            } else {
                GL11.glColorMask(true, true, true, true);
            }

            for(int var26 = -var23 + 1; var26 <= var23; ++var26) {
                for(int var27 = -var23 + 1; var27 <= var23; ++var27) {
                    var3.func_977_b();
                    float var28 = (float)(var26 * var22);
                    float var29 = (float)(var27 * var22);
                    float var30 = var28 - var20;
                    float var31 = var29 - var21;
                    if (var10 > -var5 - 1.0F) {
                        var3.func_986_a(var14 * 0.7F, var15 * 0.7F, var16 * 0.7F, 0.8F);
                        var3.func_980_b(0.0F, -1.0F, 0.0F);
                        var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + 0.0F), (double)(var31 + (float)var22), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                        var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + 0.0F), (double)(var31 + (float)var22), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                        var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + 0.0F), (double)(var31 + 0.0F), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                        var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + 0.0F), (double)(var31 + 0.0F), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                    }

                    if (var10 <= var5 + 1.0F) {
                        var3.func_986_a(var14, var15, var16, 0.8F);
                        var3.func_980_b(0.0F, 1.0F, 0.0F);
                        var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + var5 - var24), (double)(var31 + (float)var22), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                        var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + var5 - var24), (double)(var31 + (float)var22), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                        var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + var5 - var24), (double)(var31 + 0.0F), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                        var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + var5 - var24), (double)(var31 + 0.0F), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                    }

                    var3.func_986_a(var14 * 0.9F, var15 * 0.9F, var16 * 0.9F, 0.8F);
                    int var32;
                    if (var26 > -1) {
                        var3.func_980_b(-1.0F, 0.0F, 0.0F);

                        for(var32 = 0; var32 < var22; ++var32) {
                            var3.func_983_a((double)(var30 + (float)var32 + 0.0F), (double)(var10 + 0.0F), (double)(var31 + (float)var22), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var32 + 0.0F), (double)(var10 + var5), (double)(var31 + (float)var22), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var32 + 0.0F), (double)(var10 + var5), (double)(var31 + 0.0F), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var32 + 0.0F), (double)(var10 + 0.0F), (double)(var31 + 0.0F), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                        }
                    }

                    if (var26 <= 1) {
                        var3.func_980_b(1.0F, 0.0F, 0.0F);

                        for(var32 = 0; var32 < var22; ++var32) {
                            var3.func_983_a((double)(var30 + (float)var32 + 1.0F - var24), (double)(var10 + 0.0F), (double)(var31 + (float)var22), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var32 + 1.0F - var24), (double)(var10 + var5), (double)(var31 + (float)var22), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + (float)var22) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var32 + 1.0F - var24), (double)(var10 + var5), (double)(var31 + 0.0F), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var32 + 1.0F - var24), (double)(var10 + 0.0F), (double)(var31 + 0.0F), (double)((var28 + (float)var32 + 0.5F) * var19 + var17), (double)((var29 + 0.0F) * var19 + var18));
                        }
                    }

                    var3.func_986_a(var14 * 0.8F, var15 * 0.8F, var16 * 0.8F, 0.8F);
                    if (var27 > -1) {
                        var3.func_980_b(0.0F, 0.0F, -1.0F);

                        for(var32 = 0; var32 < var22; ++var32) {
                            var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + var5), (double)(var31 + (float)var32 + 0.0F), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + var5), (double)(var31 + (float)var32 + 0.0F), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + 0.0F), (double)(var31 + (float)var32 + 0.0F), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                            var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + 0.0F), (double)(var31 + (float)var32 + 0.0F), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                        }
                    }

                    if (var27 <= 1) {
                        var3.func_980_b(0.0F, 0.0F, 1.0F);

                        for(var32 = 0; var32 < var22; ++var32) {
                            var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + var5), (double)(var31 + (float)var32 + 1.0F - var24), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + var5), (double)(var31 + (float)var32 + 1.0F - var24), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                            var3.func_983_a((double)(var30 + (float)var22), (double)(var10 + 0.0F), (double)(var31 + (float)var32 + 1.0F - var24), (double)((var28 + (float)var22) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                            var3.func_983_a((double)(var30 + 0.0F), (double)(var10 + 0.0F), (double)(var31 + (float)var32 + 1.0F - var24), (double)((var28 + 0.0F) * var19 + var17), (double)((var29 + (float)var32 + 0.5F) * var19 + var18));
                        }
                    }

                    var3.func_982_a();
                }
            }
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean func_948_a(EntityLiving var1, boolean var2) {
        boolean var3 = false;
        if (var3) {
            Collections.sort(this.field_1446_m, new RenderSorter(var1));
            int var17 = this.field_1446_m.size() - 1;
            int var18 = this.field_1446_m.size();

            for(int var19 = 0; var19 < var18; ++var19) {
                WorldRenderer var20 = (WorldRenderer)this.field_1446_m.get(var17 - var19);
                if (!var2) {
                    if (var20.func_1202_a(var1) > 256.0F) {
                        if (var20.field_1749_o) {
                            if (var19 >= 3) {
                                return false;
                            }
                        } else if (var19 >= 1) {
                            return false;
                        }
                    }
                } else if (!var20.field_1749_o) {
                    continue;
                }

                var20.func_1198_a();
                this.field_1446_m.remove(var20);
                var20.field_1738_u = false;
            }

            return this.field_1446_m.size() == 0;
        } else {
            byte var4 = 2;
            RenderSorter var5 = new RenderSorter(var1);
            WorldRenderer[] var6 = new WorldRenderer[var4];
            ArrayList var7 = null;
            int var8 = this.field_1446_m.size();
            int var9 = 0;

            int var10;
            WorldRenderer var11;
            int var12;
            int var13;
            label169:
            for(var10 = 0; var10 < var8; ++var10) {
                var11 = (WorldRenderer)this.field_1446_m.get(var10);
                if (!var2) {
                    if (var11.func_1202_a(var1) > 256.0F) {
                        for(var12 = 0; var12 < var4 && (var6[var12] == null || var5.func_993_a(var6[var12], var11) <= 0); ++var12) {
                        }

                        --var12;
                        if (var12 <= 0) {
                            continue;
                        }

                        var13 = var12;

                        while(true) {
                            --var13;
                            if (var13 == 0) {
                                var6[var12] = var11;
                                continue label169;
                            }

                            var6[var13 - 1] = var6[var13];
                        }
                    }
                } else if (!var11.field_1749_o) {
                    continue;
                }

                if (var7 == null) {
                    var7 = new ArrayList();
                }

                ++var9;
                var7.add(var11);
                this.field_1446_m.set(var10, (Object)null);
            }

            if (var7 != null) {
                if (var7.size() > 1) {
                    Collections.sort(var7, var5);
                }

                for(var10 = var7.size() - 1; var10 >= 0; --var10) {
                    var11 = (WorldRenderer)var7.get(var10);
                    var11.func_1198_a();
                    var11.field_1738_u = false;
                }
            }

            var10 = 0;

            int var21;
            for(var21 = var4 - 1; var21 >= 0; --var21) {
                WorldRenderer var22 = var6[var21];
                if (var22 != null) {
                    if (!var22.field_1749_o && var21 != var4 - 1) {
                        var6[var21] = null;
                        var6[0] = null;
                        break;
                    }

                    var6[var21].func_1198_a();
                    var6[var21].field_1738_u = false;
                    ++var10;
                }
            }

            var21 = 0;
            var12 = 0;

            for(var13 = this.field_1446_m.size(); var21 != var13; ++var21) {
                WorldRenderer var14 = (WorldRenderer)this.field_1446_m.get(var21);
                if (var14 != null) {
                    boolean var15 = false;

                    for(int var16 = 0; var16 < var4 && !var15; ++var16) {
                        if (var14 == var6[var16]) {
                            var15 = true;
                        }
                    }

                    if (!var15) {
                        if (var12 != var21) {
                            this.field_1446_m.set(var12, var14);
                        }

                        ++var12;
                    }
                }
            }

            while(true) {
                --var21;
                if (var21 < var12) {
                    return var8 == var9 + var10;
                }

                this.field_1446_m.remove(var21);
            }
        }
    }

    public void func_959_a(EntityPlayer var1, MovingObjectPosition var2, int var3, ItemStack var4, float var5) {
        Tessellator var6 = Tessellator.field_1512_a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, (MathHelper.func_1106_a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.4F) * 0.5F);
        int var8;
        if (var3 == 0) {
            if (this.field_1450_i > 0.0F) {
                GL11.glBlendFunc(774, 768);
                int var7 = this.field_1447_l.func_1070_a("/terrain.png");
                GL11.glBindTexture(3553, var7);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
                GL11.glPushMatrix();
                var8 = this.field_1448_k.func_600_a(var2.field_1166_b, var2.field_1172_c, var2.field_1171_d);
                Block var9 = var8 > 0 ? Block.field_345_n[var8] : null;
                GL11.glDisable(3008);
                GL11.glPolygonOffset(-3.0F, -3.0F);
                GL11.glEnable(32823);
                double var10 = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * (double)var5;
                double var12 = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * (double)var5;
                double var14 = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * (double)var5;
                if (var9 == null) {
                    var9 = Block.field_338_u;
                }

                GL11.glEnable(3008);
                var6.func_977_b();
                var6.func_984_b(-var10, -var12, -var14);
                var6.func_989_c();
                this.field_1438_u.func_1223_a(var9, var2.field_1166_b, var2.field_1172_c, var2.field_1171_d, 240 + (int)(this.field_1450_i * 10.0F));
                var6.func_982_a();
                var6.func_984_b(0.0D, 0.0D, 0.0D);
                GL11.glDisable(3008);
                GL11.glPolygonOffset(0.0F, 0.0F);
                GL11.glDisable(32823);
                GL11.glEnable(3008);
                GL11.glDepthMask(true);
                GL11.glPopMatrix();
            }
        } else if (var4 != null) {
            GL11.glBlendFunc(770, 771);
            float var16 = MathHelper.func_1106_a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.8F;
            GL11.glColor4f(var16, var16, var16, MathHelper.func_1106_a((float)System.currentTimeMillis() / 200.0F) * 0.2F + 0.5F);
            var8 = this.field_1447_l.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, var8);
            int var17 = var2.field_1166_b;
            int var18 = var2.field_1172_c;
            int var11 = var2.field_1171_d;
            if (var2.field_1170_e == 0) {
                --var18;
            }

            if (var2.field_1170_e == 1) {
                ++var18;
            }

            if (var2.field_1170_e == 2) {
                --var11;
            }

            if (var2.field_1170_e == 3) {
                ++var11;
            }

            if (var2.field_1170_e == 4) {
                --var17;
            }

            if (var2.field_1170_e == 5) {
                ++var17;
            }
        }

        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    public void func_955_b(EntityPlayer var1, MovingObjectPosition var2, int var3, ItemStack var4, float var5) {
        if (var3 == 0 && var2.field_1167_a == EnumMovingObjectType.TILE) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
            GL11.glLineWidth(2.0F);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float var6 = 0.002F;
            int var7 = this.field_1448_k.func_600_a(var2.field_1166_b, var2.field_1172_c, var2.field_1171_d);
            if (var7 > 0) {
                Block.field_345_n[var7].func_238_a(this.field_1448_k, var2.field_1166_b, var2.field_1172_c, var2.field_1171_d);
                double var8 = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * (double)var5;
                double var10 = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * (double)var5;
                double var12 = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * (double)var5;
                this.func_942_a(Block.field_345_n[var7].func_246_f(this.field_1448_k, var2.field_1166_b, var2.field_1172_c, var2.field_1171_d).func_1177_b((double)var6, (double)var6, (double)var6).func_1166_c(-var8, -var10, -var12));
            }

            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }

    }

    private void func_942_a(AxisAlignedBB var1) {
        Tessellator var2 = Tessellator.field_1512_a;
        var2.func_992_a(3);
        var2.func_991_a(var1.field_1698_a, var1.field_1697_b, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1697_b, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1697_b, var1.field_1701_f);
        var2.func_991_a(var1.field_1698_a, var1.field_1697_b, var1.field_1701_f);
        var2.func_991_a(var1.field_1698_a, var1.field_1697_b, var1.field_1704_c);
        var2.func_982_a();
        var2.func_992_a(3);
        var2.func_991_a(var1.field_1698_a, var1.field_1702_e, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1702_e, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1702_e, var1.field_1701_f);
        var2.func_991_a(var1.field_1698_a, var1.field_1702_e, var1.field_1701_f);
        var2.func_991_a(var1.field_1698_a, var1.field_1702_e, var1.field_1704_c);
        var2.func_982_a();
        var2.func_992_a(1);
        var2.func_991_a(var1.field_1698_a, var1.field_1697_b, var1.field_1704_c);
        var2.func_991_a(var1.field_1698_a, var1.field_1702_e, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1697_b, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1702_e, var1.field_1704_c);
        var2.func_991_a(var1.field_1703_d, var1.field_1697_b, var1.field_1701_f);
        var2.func_991_a(var1.field_1703_d, var1.field_1702_e, var1.field_1701_f);
        var2.func_991_a(var1.field_1698_a, var1.field_1697_b, var1.field_1701_f);
        var2.func_991_a(var1.field_1698_a, var1.field_1702_e, var1.field_1701_f);
        var2.func_982_a();
    }

    public void func_949_a(int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = MathHelper.func_1111_a(var1, 16);
        int var8 = MathHelper.func_1111_a(var2, 16);
        int var9 = MathHelper.func_1111_a(var3, 16);
        int var10 = MathHelper.func_1111_a(var4, 16);
        int var11 = MathHelper.func_1111_a(var5, 16);
        int var12 = MathHelper.func_1111_a(var6, 16);

        for(int var13 = var7; var13 <= var10; ++var13) {
            int var14 = var13 % this.field_1443_p;
            if (var14 < 0) {
                var14 += this.field_1443_p;
            }

            for(int var15 = var8; var15 <= var11; ++var15) {
                int var16 = var15 % this.field_1442_q;
                if (var16 < 0) {
                    var16 += this.field_1442_q;
                }

                for(int var17 = var9; var17 <= var12; ++var17) {
                    int var18 = var17 % this.field_1441_r;
                    if (var18 < 0) {
                        var18 += this.field_1441_r;
                    }

                    int var19 = (var18 * this.field_1442_q + var16) * this.field_1443_p + var14;
                    WorldRenderer var20 = this.field_1444_o[var19];
                    if (!var20.field_1738_u) {
                        this.field_1446_m.add(var20);
                        var20.func_1194_f();
                    }
                }
            }
        }

    }

    public void func_934_a(int var1, int var2, int var3) {
        this.func_949_a(var1 - 1, var2 - 1, var3 - 1, var1 + 1, var2 + 1, var3 + 1);
    }

    public void func_937_b(int var1, int var2, int var3, int var4, int var5, int var6) {
        this.func_949_a(var1 - 1, var2 - 1, var3 - 1, var4 + 1, var5 + 1, var6 + 1);
    }

    public void func_960_a(ICamera var1, float var2) {
        for(int var3 = 0; var3 < this.field_1444_o.length; ++var3) {
            if (!this.field_1444_o[var3].func_1196_e() && (!this.field_1444_o[var3].field_1749_o || (var3 + this.field_1449_j & 15) == 0)) {
                this.field_1444_o[var3].func_1199_a(var1);
            }
        }

        ++this.field_1449_j;
    }

    public void func_933_a(String var1, int var2, int var3, int var4) {
        if (var1 != null) {
            this.field_1439_t.field_6308_u.func_553_b("C418 - " + var1);
        }

        this.field_1439_t.field_6301_A.func_331_a(var1, (float)var2, (float)var3, (float)var4, 1.0F, 1.0F);
    }

    public void func_940_a(String var1, double var2, double var4, double var6, float var8, float var9) {
        float var10 = 16.0F;
        if (var8 > 1.0F) {
            var10 *= var8;
        }

        if (this.field_1439_t.field_22009_h.func_360_d(var2, var4, var6) < (double)(var10 * var10)) {
            this.field_1439_t.field_6301_A.func_336_b(var1, (float)var2, (float)var4, (float)var6, var8, var9);
        }

    }

    public void func_939_a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        if (this.field_1439_t != null && this.field_1439_t.field_22009_h != null && this.field_1439_t.field_6321_h != null) {
            double var14 = this.field_1439_t.field_22009_h.field_611_ak - var2;
            double var16 = this.field_1439_t.field_22009_h.field_610_al - var4;
            double var18 = this.field_1439_t.field_22009_h.field_609_am - var6;
            double var20 = 16.0D;
            if (var14 * var14 + var16 * var16 + var18 * var18 <= var20 * var20) {
                if (var1.equals("bubble")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityBubbleFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("smoke")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntitySmokeFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("note")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityNoteFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("portal")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityPortalFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("explode")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityExplodeFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("flame")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityFlameFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("lava")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityLavaFX(this.field_1448_k, var2, var4, var6));
                } else if (var1.equals("footstep")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityFootStepFX(this.field_1447_l, this.field_1448_k, var2, var4, var6));
                } else if (var1.equals("splash")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntitySplashFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("largesmoke")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntitySmokeFX(this.field_1448_k, var2, var4, var6, var8, var10, var12, 2.5F));
                } else if (var1.equals("reddust")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityReddustFX(this.field_1448_k, var2, var4, var6, (float)var8, (float)var10, (float)var12));
                } else if (var1.equals("snowballpoof")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntitySlimeFX(this.field_1448_k, var2, var4, var6, Item.field_308_aB));
                } else if (var1.equals("snowshovel")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntitySnowShovelFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                } else if (var1.equals("slime")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntitySlimeFX(this.field_1448_k, var2, var4, var6, Item.field_299_aK));
                } else if (var1.equals("heart")) {
                    this.field_1439_t.field_6321_h.func_1192_a(new EntityHeartFX(this.field_1448_k, var2, var4, var6, var8, var10, var12));
                }

            }
        }
    }

    public void func_941_a(Entity var1) {
        var1.func_20046_s();
        if (var1.field_20047_bv != null) {
            this.field_1447_l.func_1075_a(var1.field_20047_bv, new ImageBufferDownload());
        }

        if (var1.field_622_aY != null) {
            this.field_1447_l.func_1075_a(var1.field_622_aY, new ImageBufferDownload());
        }

    }

    public void func_938_b(Entity var1) {
        if (var1.field_20047_bv != null) {
            this.field_1447_l.func_1073_b(var1.field_20047_bv);
        }

        if (var1.field_622_aY != null) {
            this.field_1447_l.func_1073_b(var1.field_622_aY);
        }

    }

    public void func_936_e() {
        for(int var1 = 0; var1 < this.field_1444_o.length; ++var1) {
            if (this.field_1444_o[var1].field_1747_A && !this.field_1444_o[var1].field_1738_u) {
                this.field_1446_m.add(this.field_1444_o[var1]);
                this.field_1444_o[var1].func_1194_f();
            }
        }

    }

    public void func_935_a(int var1, int var2, int var3, TileEntity var4) {
    }

    public void func_28137_f() {
        GLAllocation.func_28194_b(this.field_1440_s);
    }

    public void func_28136_a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6) {
        Random var7 = this.field_1448_k.field_1037_n;
        int var16;
        switch(var2) {
        case 1000:
            this.field_1448_k.func_684_a((double)var3, (double)var4, (double)var5, "random.click", 1.0F, 1.0F);
            break;
        case 1001:
            this.field_1448_k.func_684_a((double)var3, (double)var4, (double)var5, "random.click", 1.0F, 1.2F);
            break;
        case 1002:
            this.field_1448_k.func_684_a((double)var3, (double)var4, (double)var5, "random.bow", 1.0F, 1.2F);
            break;
        case 1003:
            if (Math.random() < 0.5D) {
                this.field_1448_k.func_684_a((double)var3 + 0.5D, (double)var4 + 0.5D, (double)var5 + 0.5D, "random.door_open", 1.0F, this.field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
            } else {
                this.field_1448_k.func_684_a((double)var3 + 0.5D, (double)var4 + 0.5D, (double)var5 + 0.5D, "random.door_close", 1.0F, this.field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
            }
            break;
        case 1004:
            this.field_1448_k.func_684_a((double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), "random.fizz", 0.5F, 2.6F + (var7.nextFloat() - var7.nextFloat()) * 0.8F);
            break;
        case 1005:
            if (Item.field_233_c[var6] instanceof ItemRecord) {
                this.field_1448_k.func_670_a(((ItemRecord)Item.field_233_c[var6]).field_316_a, var3, var4, var5);
            } else {
                this.field_1448_k.func_670_a((String)null, var3, var4, var5);
            }
            break;
        case 2000:
            int var8 = var6 % 3 - 1;
            int var9 = var6 / 3 % 3 - 1;
            double var10 = (double)var3 + (double)var8 * 0.6D + 0.5D;
            double var12 = (double)var4 + 0.5D;
            double var14 = (double)var5 + (double)var9 * 0.6D + 0.5D;

            for(var16 = 0; var16 < 10; ++var16) {
                double var31 = var7.nextDouble() * 0.2D + 0.01D;
                double var19 = var10 + (double)var8 * 0.01D + (var7.nextDouble() - 0.5D) * (double)var9 * 0.5D;
                double var21 = var12 + (var7.nextDouble() - 0.5D) * 0.5D;
                double var23 = var14 + (double)var9 * 0.01D + (var7.nextDouble() - 0.5D) * (double)var8 * 0.5D;
                double var25 = (double)var8 * var31 + var7.nextGaussian() * 0.01D;
                double var27 = -0.03D + var7.nextGaussian() * 0.01D;
                double var29 = (double)var9 * var31 + var7.nextGaussian() * 0.01D;
                this.func_939_a("smoke", var19, var21, var23, var25, var27, var29);
            }

            return;
        case 2001:
            var16 = var6 & 255;
            if (var16 > 0) {
                Block var17 = Block.field_345_n[var16];
                this.field_1439_t.field_6301_A.func_336_b(var17.field_358_bl.func_1146_a(), (float)var3 + 0.5F, (float)var4 + 0.5F, (float)var5 + 0.5F, (var17.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var17.field_358_bl.func_1144_c() * 0.8F);
            }

            this.field_1439_t.field_6321_h.func_1186_a(var3, var4, var5, var6 & 255, var6 >> 8 & 255);
        }

    }
}
