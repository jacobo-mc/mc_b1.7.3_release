package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class Block {
    public static final StepSound field_354_e = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound field_9254_e = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound field_9253_f = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound field_9252_g = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound field_9251_h = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound field_9250_i = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound field_9249_j = new StepSoundStone("stone", 1.0F, 1.0F);
    public static final StepSound field_9248_k = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound field_9247_l = new StepSoundSand("sand", 1.0F, 1.0F);
    public static final Block[] field_345_n = new Block[256];
    public static final boolean[] field_344_o = new boolean[256];
    public static final boolean[] field_343_p = new boolean[256];
    public static final boolean[] field_342_q = new boolean[256];
    public static final int[] field_341_r = new int[256];
    public static final boolean[] field_340_s = new boolean[256];
    public static final int[] field_339_t = new int[256];
    public static final boolean[] field_28032_t = new boolean[256];
    public static final Block field_338_u;
    public static final BlockGrass field_337_v;
    public static final Block field_336_w;
    public static final Block field_335_x;
    public static final Block field_334_y;
    public static final Block field_333_z;
    public static final Block field_403_A;
    public static final Block field_401_B;
    public static final Block field_399_C;
    public static final Block field_397_D;
    public static final Block field_395_E;
    public static final Block field_393_F;
    public static final Block field_392_G;
    public static final Block field_390_H;
    public static final Block field_388_I;
    public static final Block field_386_J;
    public static final Block field_385_K;
    public static final BlockLeaves field_384_L;
    public static final Block field_383_M;
    public static final Block field_382_N;
    public static final Block field_9267_N;
    public static final Block field_9266_O;
    public static final Block field_9265_P;
    public static final Block field_9264_Q;
    public static final Block field_9263_R;
    public static final Block field_9262_S;
    public static final Block field_9261_T;
    public static final Block field_9260_U;
    public static final Block field_9259_V;
    public static final Block field_9258_W;
    public static final BlockTallGrass field_9257_X;
    public static final BlockDeadBush field_9256_Y;
    public static final Block field_9255_Z;
    public static final BlockPistonExtension field_9269_aa;
    public static final Block field_419_ac;
    public static final BlockPistonMoving field_9268_ac;
    public static final BlockFlower field_417_ae;
    public static final BlockFlower field_416_af;
    public static final BlockFlower field_415_ag;
    public static final BlockFlower field_414_ah;
    public static final Block field_413_ai;
    public static final Block field_412_aj;
    public static final Block field_411_ak;
    public static final Block field_410_al;
    public static final Block field_409_am;
    public static final Block field_408_an;
    public static final Block field_407_ao;
    public static final Block field_406_ap;
    public static final Block field_405_aq;
    public static final Block field_404_ar;
    public static final BlockFire field_402_as;
    public static final Block field_400_at;
    public static final Block field_4059_au;
    public static final Block field_396_av;
    public static final Block field_394_aw;
    public static final Block field_391_ax;
    public static final Block field_389_ay;
    public static final Block field_387_az;
    public static final Block field_447_aA;
    public static final Block field_446_aB;
    public static final Block field_445_aC;
    public static final Block field_444_aD;
    public static final Block field_443_aE;
    public static final Block field_442_aF;
    public static final Block field_441_aG;
    public static final Block field_440_aH;
    public static final Block field_4069_aI;
    public static final Block field_4068_aJ;
    public static final Block field_4067_aK;
    public static final Block field_4066_aL;
    public static final Block field_435_aM;
    public static final Block field_4065_aN;
    public static final Block field_433_aO;
    public static final Block field_432_aP;
    public static final Block field_431_aQ;
    public static final Block field_430_aR;
    public static final Block field_4064_aS;
    public static final Block field_428_aT;
    public static final Block field_4063_aU;
    public static final Block field_426_aV;
    public static final Block field_425_aW;
    public static final Block field_424_aX;
    public static final Block field_423_aY;
    public static final Block field_422_aZ;
    public static final Block field_4057_ba;
    public static final Block field_4055_bb;
    public static final Block field_4053_bc;
    public static final Block field_4051_bd;
    public static final Block field_4049_be;
    public static final BlockPortal field_4047_bf;
    public static final Block field_4045_bg;
    public static final Block field_21026_bg;
    public static final Block field_22021_bh;
    public static final Block field_22020_bi;
    public static final Block field_25017_bj;
    public static final Block field_28033_bl;
    public int field_378_bb;
    public final int field_376_bc;
    protected float field_374_bd;
    protected float field_372_be;
    protected boolean field_27035_bo;
    protected boolean field_27034_bp;
    public double field_370_bf;
    public double field_368_bg;
    public double field_366_bh;
    public double field_364_bi;
    public double field_362_bj;
    public double field_360_bk;
    public StepSound field_358_bl;
    public float field_357_bm;
    public final Material field_356_bn;
    public float field_355_bo;
    private String field_469_a;

    protected Block(int var1, Material var2) {
        this.field_27035_bo = true;
        this.field_27034_bp = true;
        this.field_358_bl = field_354_e;
        this.field_357_bm = 1.0F;
        this.field_355_bo = 0.6F;
        if (field_345_n[var1] != null) {
            throw new IllegalArgumentException("Slot " + var1 + " is already occupied by " + field_345_n[var1] + " when adding " + this);
        } else {
            this.field_356_bn = var2;
            field_345_n[var1] = this;
            this.field_376_bc = var1;
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            field_343_p[var1] = this.func_217_b();
            field_341_r[var1] = this.func_217_b() ? 255 : 0;
            field_340_s[var1] = !var2.func_881_b();
            field_342_q[var1] = false;
        }
    }

    protected Block func_28031_n() {
        field_28032_t[this.field_376_bc] = true;
        return this;
    }

    protected void func_28028_i() {
    }

    protected Block(int var1, int var2, Material var3) {
        this(var1, var3);
        this.field_378_bb = var2;
    }

    protected Block func_4024_a(StepSound var1) {
        this.field_358_bl = var1;
        return this;
    }

    protected Block func_256_d(int var1) {
        field_341_r[this.field_376_bc] = var1;
        return this;
    }

    protected Block func_215_a(float var1) {
        field_339_t[this.field_376_bc] = (int)(15.0F * var1);
        return this;
    }

    protected Block func_219_b(float var1) {
        this.field_372_be = var1 * 3.0F;
        return this;
    }

    public boolean func_242_c() {
        return true;
    }

    public int func_210_f() {
        return 0;
    }

    protected Block func_222_c(float var1) {
        this.field_374_bd = var1;
        if (this.field_372_be < var1 * 5.0F) {
            this.field_372_be = var1 * 5.0F;
        }

        return this;
    }

    protected Block func_31028_l() {
        this.func_222_c(-1.0F);
        return this;
    }

    public float func_31031_m() {
        return this.field_374_bd;
    }

    protected Block func_253_b(boolean var1) {
        field_344_o[this.field_376_bc] = var1;
        return this;
    }

    public void func_213_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_370_bf = (double)var1;
        this.field_368_bg = (double)var2;
        this.field_366_bh = (double)var3;
        this.field_364_bi = (double)var4;
        this.field_362_bj = (double)var5;
        this.field_360_bk = (double)var6;
    }

    public float func_241_c(IBlockAccess var1, int var2, int var3, int var4) {
        return var1.func_28099_a(var2, var3, var4, field_339_t[this.field_376_bc]);
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 0 && this.field_368_bg > 0.0D) {
            return true;
        } else if (var5 == 1 && this.field_362_bj < 1.0D) {
            return true;
        } else if (var5 == 2 && this.field_366_bh > 0.0D) {
            return true;
        } else if (var5 == 3 && this.field_360_bk < 1.0D) {
            return true;
        } else if (var5 == 4 && this.field_370_bf > 0.0D) {
            return true;
        } else if (var5 == 5 && this.field_364_bi < 1.0D) {
            return true;
        } else {
            return !var1.func_601_g(var2, var3, var4);
        }
    }

    public boolean func_28029_d(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var1.func_599_f(var2, var3, var4).func_878_a();
    }

    public int func_211_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return this.func_232_a(var5, var1.func_602_e(var2, var3, var4));
    }

    public int func_232_a(int var1, int var2) {
        return this.func_218_a(var1);
    }

    public int func_218_a(int var1) {
        return this.field_378_bb;
    }

    public AxisAlignedBB func_246_f(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_1161_b((double)var2 + this.field_370_bf, (double)var3 + this.field_368_bg, (double)var4 + this.field_366_bh, (double)var2 + this.field_364_bi, (double)var3 + this.field_362_bj, (double)var4 + this.field_360_bk);
    }

    public void func_230_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        AxisAlignedBB var7 = this.func_221_d(var1, var2, var3, var4);
        if (var7 != null && var5.func_1178_a(var7)) {
            var6.add(var7);
        }

    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_1161_b((double)var2 + this.field_370_bf, (double)var3 + this.field_368_bg, (double)var4 + this.field_366_bh, (double)var2 + this.field_364_bi, (double)var3 + this.field_362_bj, (double)var4 + this.field_360_bk);
    }

    public boolean func_217_b() {
        return true;
    }

    public boolean func_224_a(int var1, boolean var2) {
        return this.func_245_h();
    }

    public boolean func_245_h() {
        return true;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
    }

    public void func_252_b(World var1, int var2, int var3, int var4, int var5) {
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
    }

    public int func_4025_d() {
        return 10;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
    }

    public int func_229_a(Random var1) {
        return 1;
    }

    public int func_240_a(int var1, Random var2) {
        return this.field_376_bc;
    }

    public float func_225_a(EntityPlayer var1) {
        if (this.field_374_bd < 0.0F) {
            return 0.0F;
        } else {
            return !var1.func_454_b(this) ? 1.0F / this.field_374_bd / 100.0F : var1.func_450_a(this) / this.field_374_bd / 30.0F;
        }
    }

    public final void func_259_b_(World var1, int var2, int var3, int var4, int var5) {
        this.func_216_a(var1, var2, var3, var4, var5, 1.0F);
    }

    public void func_216_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.field_1026_y) {
            int var7 = this.func_229_a(var1.field_1037_n);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var1.field_1037_n.nextFloat() <= var6) {
                    int var9 = this.func_240_a(var5, var1.field_1037_n);
                    if (var9 > 0) {
                        this.func_31027_a(var1, var2, var3, var4, new ItemStack(var9, 1, this.func_21025_b(var5)));
                    }
                }
            }

        }
    }

    protected void func_31027_a(World var1, int var2, int var3, int var4, ItemStack var5) {
        if (!var1.field_1026_y) {
            float var6 = 0.7F;
            double var7 = (double)(var1.field_1037_n.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var9 = (double)(var1.field_1037_n.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var11 = (double)(var1.field_1037_n.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            EntityItem var13 = new EntityItem(var1, (double)var2 + var7, (double)var3 + var9, (double)var4 + var11, var5);
            var13.field_805_c = 10;
            var1.func_674_a(var13);
        }
    }

    protected int func_21025_b(int var1) {
        return 0;
    }

    public float func_227_a(Entity var1) {
        return this.field_372_be / 5.0F;
    }

    public MovingObjectPosition func_255_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_238_a(var1, var2, var3, var4);
        var5 = var5.func_1257_c((double)(-var2), (double)(-var3), (double)(-var4));
        var6 = var6.func_1257_c((double)(-var2), (double)(-var3), (double)(-var4));
        Vec3D var7 = var5.func_1247_a(var6, this.field_370_bf);
        Vec3D var8 = var5.func_1247_a(var6, this.field_364_bi);
        Vec3D var9 = var5.func_1250_b(var6, this.field_368_bg);
        Vec3D var10 = var5.func_1250_b(var6, this.field_362_bj);
        Vec3D var11 = var5.func_1256_c(var6, this.field_366_bh);
        Vec3D var12 = var5.func_1256_c(var6, this.field_360_bk);
        if (!this.func_244_a(var7)) {
            var7 = null;
        }

        if (!this.func_244_a(var8)) {
            var8 = null;
        }

        if (!this.func_249_b(var9)) {
            var9 = null;
        }

        if (!this.func_249_b(var10)) {
            var10 = null;
        }

        if (!this.func_251_c(var11)) {
            var11 = null;
        }

        if (!this.func_251_c(var12)) {
            var12 = null;
        }

        Vec3D var13 = null;
        if (var7 != null && (var13 == null || var5.func_1251_c(var7) < var5.func_1251_c(var13))) {
            var13 = var7;
        }

        if (var8 != null && (var13 == null || var5.func_1251_c(var8) < var5.func_1251_c(var13))) {
            var13 = var8;
        }

        if (var9 != null && (var13 == null || var5.func_1251_c(var9) < var5.func_1251_c(var13))) {
            var13 = var9;
        }

        if (var10 != null && (var13 == null || var5.func_1251_c(var10) < var5.func_1251_c(var13))) {
            var13 = var10;
        }

        if (var11 != null && (var13 == null || var5.func_1251_c(var11) < var5.func_1251_c(var13))) {
            var13 = var11;
        }

        if (var12 != null && (var13 == null || var5.func_1251_c(var12) < var5.func_1251_c(var13))) {
            var13 = var12;
        }

        if (var13 == null) {
            return null;
        } else {
            byte var14 = -1;
            if (var13 == var7) {
                var14 = 4;
            }

            if (var13 == var8) {
                var14 = 5;
            }

            if (var13 == var9) {
                var14 = 0;
            }

            if (var13 == var10) {
                var14 = 1;
            }

            if (var13 == var11) {
                var14 = 2;
            }

            if (var13 == var12) {
                var14 = 3;
            }

            return new MovingObjectPosition(var2, var3, var4, var14, var13.func_1257_c((double)var2, (double)var3, (double)var4));
        }
    }

    private boolean func_244_a(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1775_b >= this.field_368_bg && var1.field_1775_b <= this.field_362_bj && var1.field_1779_c >= this.field_366_bh && var1.field_1779_c <= this.field_360_bk;
        }
    }

    private boolean func_249_b(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1776_a >= this.field_370_bf && var1.field_1776_a <= this.field_364_bi && var1.field_1779_c >= this.field_366_bh && var1.field_1779_c <= this.field_360_bk;
        }
    }

    private boolean func_251_c(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1776_a >= this.field_370_bf && var1.field_1776_a <= this.field_364_bi && var1.field_1775_b >= this.field_368_bg && var1.field_1775_b <= this.field_362_bj;
        }
    }

    public void func_4027_c(World var1, int var2, int var3, int var4) {
    }

    public int func_234_g() {
        return 0;
    }

    public boolean func_28030_e(World var1, int var2, int var3, int var4, int var5) {
        return this.func_243_a(var1, var2, var3, var4);
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_600_a(var2, var3, var4);
        return var5 == 0 || field_345_n[var5].field_356_bn.func_27283_g();
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return false;
    }

    public void func_254_a(World var1, int var2, int var3, int var4, Entity var5) {
    }

    public void func_258_d(World var1, int var2, int var3, int var4, int var5) {
    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
    }

    public void func_257_a(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
    }

    public int func_31030_b(int var1) {
        return 16777215;
    }

    public int func_207_d(IBlockAccess var1, int var2, int var3, int var4) {
        return 16777215;
    }

    public boolean func_231_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public boolean func_209_d() {
        return false;
    }

    public void func_236_b(World var1, int var2, int var3, int var4, Entity var5) {
    }

    public boolean func_228_c(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public void func_237_e() {
    }

    public void func_220_a_(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        var2.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
        this.func_259_b_(var1, var3, var4, var5, var6);
    }

    public boolean func_223_g(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void func_4026_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
    }

    public Block func_20012_a(String var1) {
        this.field_469_a = "tile." + var1;
        return this;
    }

    public String func_25016_i() {
        return StatCollector.func_25200_a(this.func_20013_i() + ".name");
    }

    public String func_20013_i() {
        return this.field_469_a;
    }

    public void func_21024_a(World var1, int var2, int var3, int var4, int var5, int var6) {
    }

    public boolean func_27033_k() {
        return this.field_27034_bp;
    }

    protected Block func_27032_l() {
        this.field_27034_bp = false;
        return this;
    }

    public int func_31029_h() {
        return this.field_356_bn.func_31064_j();
    }

    static {
        field_338_u = (new BlockStone(1, 1)).func_222_c(1.5F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("stone");
        field_337_v = (BlockGrass)(new BlockGrass(2)).func_222_c(0.6F).func_4024_a(field_9252_g).func_20012_a("grass");
        field_336_w = (new BlockDirt(3, 2)).func_222_c(0.5F).func_4024_a(field_9253_f).func_20012_a("dirt");
        field_335_x = (new Block(4, 16, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("stonebrick");
        field_334_y = (new Block(5, 4, Material.field_1335_c)).func_222_c(2.0F).func_219_b(5.0F).func_4024_a(field_9254_e).func_20012_a("wood").func_28031_n();
        field_333_z = (new BlockSapling(6, 15)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("sapling").func_28031_n();
        field_403_A = (new Block(7, 17, Material.field_1334_d)).func_31028_l().func_219_b(6000000.0F).func_4024_a(field_9251_h).func_20012_a("bedrock").func_27032_l();
        field_401_B = (new BlockFlowing(8, Material.field_1332_f)).func_222_c(100.0F).func_256_d(3).func_20012_a("water").func_27032_l().func_28031_n();
        field_399_C = (new BlockStationary(9, Material.field_1332_f)).func_222_c(100.0F).func_256_d(3).func_20012_a("water").func_27032_l().func_28031_n();
        field_397_D = (new BlockFlowing(10, Material.field_1331_g)).func_222_c(0.0F).func_215_a(1.0F).func_256_d(255).func_20012_a("lava").func_27032_l().func_28031_n();
        field_395_E = (new BlockStationary(11, Material.field_1331_g)).func_222_c(100.0F).func_215_a(1.0F).func_256_d(255).func_20012_a("lava").func_27032_l().func_28031_n();
        field_393_F = (new BlockSand(12, 18)).func_222_c(0.5F).func_4024_a(field_9247_l).func_20012_a("sand");
        field_392_G = (new BlockGravel(13, 19)).func_222_c(0.6F).func_4024_a(field_9253_f).func_20012_a("gravel");
        field_390_H = (new BlockOre(14, 32)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreGold");
        field_388_I = (new BlockOre(15, 33)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreIron");
        field_386_J = (new BlockOre(16, 34)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreCoal");
        field_385_K = (new BlockLog(17)).func_222_c(2.0F).func_4024_a(field_9254_e).func_20012_a("log").func_28031_n();
        field_384_L = (BlockLeaves)(new BlockLeaves(18, 52)).func_222_c(0.2F).func_256_d(1).func_4024_a(field_9252_g).func_20012_a("leaves").func_27032_l().func_28031_n();
        field_383_M = (new BlockSponge(19)).func_222_c(0.6F).func_4024_a(field_9252_g).func_20012_a("sponge");
        field_382_N = (new BlockGlass(20, 49, Material.field_4263_o, false)).func_222_c(0.3F).func_4024_a(field_9249_j).func_20012_a("glass");
        field_9267_N = (new BlockOre(21, 160)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreLapis");
        field_9266_O = (new Block(22, 144, Material.field_1334_d)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("blockLapis");
        field_9265_P = (new BlockDispenser(23)).func_222_c(3.5F).func_4024_a(field_9251_h).func_20012_a("dispenser").func_28031_n();
        field_9264_Q = (new BlockSandStone(24)).func_4024_a(field_9251_h).func_222_c(0.8F).func_20012_a("sandStone");
        field_9263_R = (new BlockNote(25)).func_222_c(0.8F).func_20012_a("musicBlock").func_28031_n();
        field_9262_S = (new BlockBed(26)).func_222_c(0.2F).func_20012_a("bed").func_27032_l().func_28031_n();
        field_9261_T = (new BlockRail(27, 179, true)).func_222_c(0.7F).func_4024_a(field_9250_i).func_20012_a("goldenRail").func_28031_n();
        field_9260_U = (new BlockDetectorRail(28, 195)).func_222_c(0.7F).func_4024_a(field_9250_i).func_20012_a("detectorRail").func_28031_n();
        field_9259_V = (new BlockPistonBase(29, 106, true)).func_20012_a("pistonStickyBase").func_28031_n();
        field_9258_W = (new BlockWeb(30, 11)).func_256_d(1).func_222_c(4.0F).func_20012_a("web");
        field_9257_X = (BlockTallGrass)(new BlockTallGrass(31, 39)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("tallgrass");
        field_9256_Y = (BlockDeadBush)(new BlockDeadBush(32, 55)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("deadbush");
        field_9255_Z = (new BlockPistonBase(33, 107, false)).func_20012_a("pistonBase").func_28031_n();
        field_9269_aa = (BlockPistonExtension)(new BlockPistonExtension(34, 107)).func_28031_n();
        field_419_ac = (new BlockCloth()).func_222_c(0.8F).func_4024_a(field_9248_k).func_20012_a("cloth").func_28031_n();
        field_9268_ac = new BlockPistonMoving(36);
        field_417_ae = (BlockFlower)(new BlockFlower(37, 13)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("flower");
        field_416_af = (BlockFlower)(new BlockFlower(38, 12)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("rose");
        field_415_ag = (BlockFlower)(new BlockMushroom(39, 29)).func_222_c(0.0F).func_4024_a(field_9252_g).func_215_a(0.125F).func_20012_a("mushroom");
        field_414_ah = (BlockFlower)(new BlockMushroom(40, 28)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("mushroom");
        field_413_ai = (new BlockOreStorage(41, 23)).func_222_c(3.0F).func_219_b(10.0F).func_4024_a(field_9250_i).func_20012_a("blockGold");
        field_412_aj = (new BlockOreStorage(42, 22)).func_222_c(5.0F).func_219_b(10.0F).func_4024_a(field_9250_i).func_20012_a("blockIron");
        field_411_ak = (new BlockStep(43, true)).func_222_c(2.0F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("stoneSlab");
        field_410_al = (new BlockStep(44, false)).func_222_c(2.0F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("stoneSlab");
        field_409_am = (new Block(45, 7, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("brick");
        field_408_an = (new BlockTNT(46, 8)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("tnt");
        field_407_ao = (new BlockBookshelf(47, 35)).func_222_c(1.5F).func_4024_a(field_9254_e).func_20012_a("bookshelf");
        field_406_ap = (new Block(48, 36, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("stoneMoss");
        field_405_aq = (new BlockObsidian(49, 37)).func_222_c(10.0F).func_219_b(2000.0F).func_4024_a(field_9251_h).func_20012_a("obsidian");
        field_404_ar = (new BlockTorch(50, 80)).func_222_c(0.0F).func_215_a(0.9375F).func_4024_a(field_9254_e).func_20012_a("torch").func_28031_n();
        field_402_as = (BlockFire)(new BlockFire(51, 31)).func_222_c(0.0F).func_215_a(1.0F).func_4024_a(field_9254_e).func_20012_a("fire").func_27032_l().func_28031_n();
        field_400_at = (new BlockMobSpawner(52, 65)).func_222_c(5.0F).func_4024_a(field_9250_i).func_20012_a("mobSpawner").func_27032_l();
        field_4059_au = (new BlockStairs(53, field_334_y)).func_20012_a("stairsWood").func_28031_n();
        field_396_av = (new BlockChest(54)).func_222_c(2.5F).func_4024_a(field_9254_e).func_20012_a("chest").func_28031_n();
        field_394_aw = (new BlockRedstoneWire(55, 164)).func_222_c(0.0F).func_4024_a(field_354_e).func_20012_a("redstoneDust").func_27032_l().func_28031_n();
        field_391_ax = (new BlockOre(56, 50)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreDiamond");
        field_389_ay = (new BlockOreStorage(57, 24)).func_222_c(5.0F).func_219_b(10.0F).func_4024_a(field_9250_i).func_20012_a("blockDiamond");
        field_387_az = (new BlockWorkbench(58)).func_222_c(2.5F).func_4024_a(field_9254_e).func_20012_a("workbench");
        field_447_aA = (new BlockCrops(59, 88)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("crops").func_27032_l().func_28031_n();
        field_446_aB = (new BlockFarmland(60)).func_222_c(0.6F).func_4024_a(field_9253_f).func_20012_a("farmland");
        field_445_aC = (new BlockFurnace(61, false)).func_222_c(3.5F).func_4024_a(field_9251_h).func_20012_a("furnace").func_28031_n();
        field_444_aD = (new BlockFurnace(62, true)).func_222_c(3.5F).func_4024_a(field_9251_h).func_215_a(0.875F).func_20012_a("furnace").func_28031_n();
        field_443_aE = (new BlockSign(63, TileEntitySign.class, true)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("sign").func_27032_l().func_28031_n();
        field_442_aF = (new BlockDoor(64, Material.field_1335_c)).func_222_c(3.0F).func_4024_a(field_9254_e).func_20012_a("doorWood").func_27032_l().func_28031_n();
        field_441_aG = (new BlockLadder(65, 83)).func_222_c(0.4F).func_4024_a(field_9254_e).func_20012_a("ladder").func_28031_n();
        field_440_aH = (new BlockRail(66, 128, false)).func_222_c(0.7F).func_4024_a(field_9250_i).func_20012_a("rail").func_28031_n();
        field_4069_aI = (new BlockStairs(67, field_335_x)).func_20012_a("stairsStone").func_28031_n();
        field_4068_aJ = (new BlockSign(68, TileEntitySign.class, false)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("sign").func_27032_l().func_28031_n();
        field_4067_aK = (new BlockLever(69, 96)).func_222_c(0.5F).func_4024_a(field_9254_e).func_20012_a("lever").func_28031_n();
        field_4066_aL = (new BlockPressurePlate(70, field_338_u.field_378_bb, EnumMobType.mobs, Material.field_1334_d)).func_222_c(0.5F).func_4024_a(field_9251_h).func_20012_a("pressurePlate").func_28031_n();
        field_435_aM = (new BlockDoor(71, Material.field_1333_e)).func_222_c(5.0F).func_4024_a(field_9250_i).func_20012_a("doorIron").func_27032_l().func_28031_n();
        field_4065_aN = (new BlockPressurePlate(72, field_334_y.field_378_bb, EnumMobType.everything, Material.field_1335_c)).func_222_c(0.5F).func_4024_a(field_9254_e).func_20012_a("pressurePlate").func_28031_n();
        field_433_aO = (new BlockRedstoneOre(73, 51, false)).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreRedstone").func_28031_n();
        field_432_aP = (new BlockRedstoneOre(74, 51, true)).func_215_a(0.625F).func_222_c(3.0F).func_219_b(5.0F).func_4024_a(field_9251_h).func_20012_a("oreRedstone").func_28031_n();
        field_431_aQ = (new BlockRedstoneTorch(75, 115, false)).func_222_c(0.0F).func_4024_a(field_9254_e).func_20012_a("notGate").func_28031_n();
        field_430_aR = (new BlockRedstoneTorch(76, 99, true)).func_222_c(0.0F).func_215_a(0.5F).func_4024_a(field_9254_e).func_20012_a("notGate").func_28031_n();
        field_4064_aS = (new BlockButton(77, field_338_u.field_378_bb)).func_222_c(0.5F).func_4024_a(field_9251_h).func_20012_a("button").func_28031_n();
        field_428_aT = (new BlockSnow(78, 66)).func_222_c(0.1F).func_4024_a(field_9248_k).func_20012_a("snow");
        field_4063_aU = (new BlockIce(79, 67)).func_222_c(0.5F).func_256_d(3).func_4024_a(field_9249_j).func_20012_a("ice");
        field_426_aV = (new BlockSnowBlock(80, 66)).func_222_c(0.2F).func_4024_a(field_9248_k).func_20012_a("snow");
        field_425_aW = (new BlockCactus(81, 70)).func_222_c(0.4F).func_4024_a(field_9248_k).func_20012_a("cactus");
        field_424_aX = (new BlockClay(82, 72)).func_222_c(0.6F).func_4024_a(field_9253_f).func_20012_a("clay");
        field_423_aY = (new BlockReed(83, 73)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("reeds").func_27032_l();
        field_422_aZ = (new BlockJukeBox(84, 74)).func_222_c(2.0F).func_219_b(10.0F).func_4024_a(field_9251_h).func_20012_a("jukebox").func_28031_n();
        field_4057_ba = (new BlockFence(85, 4)).func_222_c(2.0F).func_219_b(5.0F).func_4024_a(field_9254_e).func_20012_a("fence").func_28031_n();
        field_4055_bb = (new BlockPumpkin(86, 102, false)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("pumpkin").func_28031_n();
        field_4053_bc = (new BlockNetherrack(87, 103)).func_222_c(0.4F).func_4024_a(field_9251_h).func_20012_a("hellrock");
        field_4051_bd = (new BlockSoulSand(88, 104)).func_222_c(0.5F).func_4024_a(field_9247_l).func_20012_a("hellsand");
        field_4049_be = (new BlockGlowStone(89, 105, Material.field_1334_d)).func_222_c(0.3F).func_4024_a(field_9249_j).func_215_a(1.0F).func_20012_a("lightgem");
        field_4047_bf = (BlockPortal)(new BlockPortal(90, 14)).func_222_c(-1.0F).func_4024_a(field_9249_j).func_215_a(0.75F).func_20012_a("portal");
        field_4045_bg = (new BlockPumpkin(91, 102, true)).func_222_c(1.0F).func_4024_a(field_9254_e).func_215_a(1.0F).func_20012_a("litpumpkin").func_28031_n();
        field_21026_bg = (new BlockCake(92, 121)).func_222_c(0.5F).func_4024_a(field_9248_k).func_20012_a("cake").func_27032_l().func_28031_n();
        field_22021_bh = (new BlockRedstoneRepeater(93, false)).func_222_c(0.0F).func_4024_a(field_9254_e).func_20012_a("diode").func_27032_l().func_28031_n();
        field_22020_bi = (new BlockRedstoneRepeater(94, true)).func_222_c(0.0F).func_215_a(0.625F).func_4024_a(field_9254_e).func_20012_a("diode").func_27032_l().func_28031_n();
        field_25017_bj = (new BlockLockedChest(95)).func_222_c(0.0F).func_215_a(1.0F).func_4024_a(field_9254_e).func_20012_a("lockedchest").func_253_b(true).func_28031_n();
        field_28033_bl = (new BlockTrapDoor(96, Material.field_1335_c)).func_222_c(3.0F).func_4024_a(field_9254_e).func_20012_a("trapdoor").func_27032_l().func_28031_n();
        Item.field_233_c[field_419_ac.field_376_bc] = (new ItemCloth(field_419_ac.field_376_bc - 256)).func_20011_a("cloth");
        Item.field_233_c[field_385_K.field_376_bc] = (new ItemLog(field_385_K.field_376_bc - 256)).func_20011_a("log");
        Item.field_233_c[field_410_al.field_376_bc] = (new ItemSlab(field_410_al.field_376_bc - 256)).func_20011_a("stoneSlab");
        Item.field_233_c[field_333_z.field_376_bc] = (new ItemSapling(field_333_z.field_376_bc - 256)).func_20011_a("sapling");
        Item.field_233_c[field_384_L.field_376_bc] = (new ItemLeaves(field_384_L.field_376_bc - 256)).func_20011_a("leaves");
        Item.field_233_c[field_9255_Z.field_376_bc] = new ItemPiston(field_9255_Z.field_376_bc - 256);
        Item.field_233_c[field_9259_V.field_376_bc] = new ItemPiston(field_9259_V.field_376_bc - 256);

        for(int var0 = 0; var0 < 256; ++var0) {
            if (field_345_n[var0] != null && Item.field_233_c[var0] == null) {
                Item.field_233_c[var0] = new ItemBlock(var0 - 256);
                field_345_n[var0].func_28028_i();
            }
        }

        field_340_s[0] = true;
        StatList.func_25154_a();
    }
}
