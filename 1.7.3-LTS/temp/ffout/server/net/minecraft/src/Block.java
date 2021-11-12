package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class Block {
    public static final StepSound field_551_e = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound field_9028_e = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound field_9027_f = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound field_9026_g = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound field_9025_h = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound field_9024_i = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound field_9023_j = new StepSoundStone("stone", 1.0F, 1.0F);
    public static final StepSound field_9022_k = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound field_9021_l = new StepSoundSand("sand", 1.0F, 1.0F);
    public static final Block[] field_542_n = new Block[256];
    public static final boolean[] field_541_o = new boolean[256];
    public static final boolean[] field_540_p = new boolean[256];
    public static final boolean[] field_539_q = new boolean[256];
    public static final int[] field_538_r = new int[256];
    public static final boolean[] field_537_s = new boolean[256];
    public static final int[] field_536_t = new int[256];
    public static final boolean[] field_28029_t = new boolean[256];
    public static final Block field_535_u;
    public static final BlockGrass field_534_v;
    public static final Block field_533_w;
    public static final Block field_532_x;
    public static final Block field_531_y;
    public static final Block field_6047_y;
    public static final Block field_4064_A;
    public static final Block field_598_B;
    public static final Block field_596_C;
    public static final Block field_594_D;
    public static final Block field_592_E;
    public static final Block field_590_F;
    public static final Block field_4062_G;
    public static final Block field_4061_H;
    public static final Block field_4059_I;
    public static final Block field_583_J;
    public static final Block field_582_K;
    public static final BlockLeaves field_581_L;
    public static final Block field_9043_L;
    public static final Block field_4056_N;
    public static final Block field_9042_N;
    public static final Block field_9041_O;
    public static final Block field_9040_P;
    public static final Block field_9039_Q;
    public static final Block field_9038_R;
    public static final Block field_9037_S;
    public static final Block field_9036_T;
    public static final Block field_9034_U;
    public static final Block field_9033_V;
    public static final Block field_9032_W;
    public static final BlockTallGrass field_9031_X;
    public static final BlockDeadBush field_9030_Y;
    public static final Block field_9029_Z;
    public static final BlockPistonExtension field_9049_aa;
    public static final Block field_616_ac;
    public static final BlockPistonMoving field_9048_ac;
    public static final BlockFlower field_4072_ae;
    public static final BlockFlower field_4071_af;
    public static final BlockFlower field_4070_ag;
    public static final BlockFlower field_4069_ah;
    public static final Block field_4068_ai;
    public static final Block field_4067_aj;
    public static final Block field_608_ak;
    public static final Block field_607_al;
    public static final Block field_9047_al;
    public static final Block field_605_an;
    public static final Block field_604_ao;
    public static final Block field_603_ap;
    public static final Block field_602_aq;
    public static final Block field_9046_aq;
    public static final BlockFire field_599_as;
    public static final Block field_597_at;
    public static final Block field_9045_at;
    public static final Block field_593_av;
    public static final Block field_591_aw;
    public static final Block field_588_ax;
    public static final Block field_4060_ay;
    public static final Block field_9044_ay;
    public static final Block field_644_aA;
    public static final Block field_643_aB;
    public static final Block field_642_aC;
    public static final Block field_641_aD;
    public static final Block field_4084_aE;
    public static final Block field_639_aF;
    public static final Block field_638_aG;
    public static final Block field_637_aH;
    public static final Block field_9055_aH;
    public static final Block field_4082_aJ;
    public static final Block field_9054_aJ;
    public static final Block field_9053_aK;
    public static final Block field_632_aM;
    public static final Block field_9052_aM;
    public static final Block field_630_aO;
    public static final Block field_629_aP;
    public static final Block field_628_aQ;
    public static final Block field_627_aR;
    public static final Block field_9051_aR;
    public static final Block field_625_aT;
    public static final Block field_4077_aU;
    public static final Block field_4076_aV;
    public static final Block field_622_aW;
    public static final Block field_621_aX;
    public static final Block field_620_aY;
    public static final Block field_619_aZ;
    public static final Block field_9050_aZ;
    public static final Block field_4052_bb;
    public static final Block field_4050_bc;
    public static final Block field_4048_bd;
    public static final Block field_6065_bd;
    public static final BlockPortal field_4044_bf;
    public static final Block field_9035_bf;
    public static final Block field_21026_bg;
    public static final Block field_22011_bh;
    public static final Block field_22010_bi;
    public static final Block field_25013_bj;
    public static final Block field_28030_bl;
    public int field_575_bb;
    public final int field_573_bc;
    protected float field_571_bd;
    protected float field_569_be;
    protected boolean field_27024_bo;
    protected boolean field_27023_bp;
    public double field_567_bf;
    public double field_565_bg;
    public double field_563_bh;
    public double field_561_bi;
    public double field_559_bj;
    public double field_557_bk;
    public StepSound field_555_bl;
    public float field_554_bm;
    public final Material field_553_bn;
    public float field_552_bo;
    private String field_666_a;

    protected Block(int var1, Material var2) {
        this.field_27024_bo = true;
        this.field_27023_bp = true;
        this.field_555_bl = field_551_e;
        this.field_554_bm = 1.0F;
        this.field_552_bo = 0.6F;
        if (field_542_n[var1] != null) {
            throw new IllegalArgumentException("Slot " + var1 + " is already occupied by " + field_542_n[var1] + " when adding " + this);
        } else {
            this.field_553_bn = var2;
            field_542_n[var1] = this;
            this.field_573_bc = var1;
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            field_540_p[var1] = this.func_240_b();
            field_538_r[var1] = this.func_240_b() ? 255 : 0;
            field_537_s[var1] = !var2.func_219_b();
            field_539_q[var1] = false;
        }
    }

    protected Block func_28027_k() {
        field_28029_t[this.field_573_bc] = true;
        return this;
    }

    protected void func_28028_f() {
    }

    protected Block(int var1, int var2, Material var3) {
        this(var1, var3);
        this.field_575_bb = var2;
    }

    protected Block func_4026_a(StepSound var1) {
        this.field_555_bl = var1;
        return this;
    }

    protected Block func_258_c(int var1) {
        field_538_r[this.field_573_bc] = var1;
        return this;
    }

    protected Block func_224_a(float var1) {
        field_536_t[this.field_573_bc] = (int)(15.0F * var1);
        return this;
    }

    protected Block func_232_b(float var1) {
        this.field_569_be = var1 * 3.0F;
        return this;
    }

    public boolean func_28025_b() {
        return true;
    }

    protected Block func_237_c(float var1) {
        this.field_571_bd = var1;
        if (this.field_569_be < var1 * 5.0F) {
            this.field_569_be = var1 * 5.0F;
        }

        return this;
    }

    protected Block func_31027_i() {
        this.func_237_c(-1.0F);
        return this;
    }

    public float func_31026_j() {
        return this.field_571_bd;
    }

    protected Block func_231_a(boolean var1) {
        field_541_o[this.field_573_bc] = var1;
        return this;
    }

    public void func_229_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_567_bf = (double)var1;
        this.field_565_bg = (double)var2;
        this.field_563_bh = (double)var3;
        this.field_561_bi = (double)var4;
        this.field_559_bj = (double)var5;
        this.field_557_bk = (double)var6;
    }

    public boolean func_253_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var1.func_443_c(var2, var3, var4).func_216_a();
    }

    public int func_22009_a(int var1, int var2) {
        return this.func_241_a(var1);
    }

    public int func_241_a(int var1) {
        return this.field_575_bb;
    }

    public void func_264_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        AxisAlignedBB var7 = this.func_248_d(var1, var2, var3, var4);
        if (var7 != null && var5.func_704_a(var7)) {
            var6.add(var7);
        }

    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_693_b((double)var2 + this.field_567_bf, (double)var3 + this.field_565_bg, (double)var4 + this.field_563_bh, (double)var2 + this.field_561_bi, (double)var3 + this.field_559_bj, (double)var4 + this.field_557_bk);
    }

    public boolean func_240_b() {
        return true;
    }

    public boolean func_243_a(int var1, boolean var2) {
        return this.func_245_e();
    }

    public boolean func_245_e() {
        return true;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
    }

    public void func_251_a(World var1, int var2, int var3, int var4, int var5) {
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
    }

    public int func_4028_b() {
        return 10;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
    }

    public int func_244_a(Random var1) {
        return 1;
    }

    public int func_252_a(int var1, Random var2) {
        return this.field_573_bc;
    }

    public float func_254_a(EntityPlayer var1) {
        if (this.field_571_bd < 0.0F) {
            return 0.0F;
        } else {
            return !var1.func_167_b(this) ? 1.0F / this.field_571_bd / 100.0F : var1.func_165_a(this) / this.field_571_bd / 30.0F;
        }
    }

    public final void func_247_a_(World var1, int var2, int var3, int var4, int var5) {
        this.func_227_a(var1, var2, var3, var4, var5, 1.0F);
    }

    public void func_227_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.field_792_x) {
            int var7 = this.func_244_a(var1.field_803_m);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var1.field_803_m.nextFloat() <= var6) {
                    int var9 = this.func_252_a(var5, var1.field_803_m);
                    if (var9 > 0) {
                        this.func_31024_a(var1, var2, var3, var4, new ItemStack(var9, 1, this.func_21025_b(var5)));
                    }
                }
            }

        }
    }

    protected void func_31024_a(World var1, int var2, int var3, int var4, ItemStack var5) {
        if (!var1.field_792_x) {
            float var6 = 0.7F;
            double var7 = (double)(var1.field_803_m.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var9 = (double)(var1.field_803_m.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var11 = (double)(var1.field_803_m.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            EntityItem var13 = new EntityItem(var1, (double)var2 + var7, (double)var3 + var9, (double)var4 + var11, var5);
            var13.field_433_ad = 10;
            var1.func_526_a(var13);
        }
    }

    protected int func_21025_b(int var1) {
        return 0;
    }

    public float func_226_a(Entity var1) {
        return this.field_569_be / 5.0F;
    }

    public MovingObjectPosition func_262_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_233_a(var1, var2, var3, var4);
        var5 = var5.func_757_c((double)(-var2), (double)(-var3), (double)(-var4));
        var6 = var6.func_757_c((double)(-var2), (double)(-var3), (double)(-var4));
        Vec3D var7 = var5.func_766_a(var6, this.field_567_bf);
        Vec3D var8 = var5.func_766_a(var6, this.field_561_bi);
        Vec3D var9 = var5.func_763_b(var6, this.field_565_bg);
        Vec3D var10 = var5.func_763_b(var6, this.field_559_bj);
        Vec3D var11 = var5.func_762_c(var6, this.field_563_bh);
        Vec3D var12 = var5.func_762_c(var6, this.field_557_bk);
        if (!this.func_223_a(var7)) {
            var7 = null;
        }

        if (!this.func_223_a(var8)) {
            var8 = null;
        }

        if (!this.func_228_b(var9)) {
            var9 = null;
        }

        if (!this.func_228_b(var10)) {
            var10 = null;
        }

        if (!this.func_236_c(var11)) {
            var11 = null;
        }

        if (!this.func_236_c(var12)) {
            var12 = null;
        }

        Vec3D var13 = null;
        if (var7 != null && (var13 == null || var5.func_767_a(var7) < var5.func_767_a(var13))) {
            var13 = var7;
        }

        if (var8 != null && (var13 == null || var5.func_767_a(var8) < var5.func_767_a(var13))) {
            var13 = var8;
        }

        if (var9 != null && (var13 == null || var5.func_767_a(var9) < var5.func_767_a(var13))) {
            var13 = var9;
        }

        if (var10 != null && (var13 == null || var5.func_767_a(var10) < var5.func_767_a(var13))) {
            var13 = var10;
        }

        if (var11 != null && (var13 == null || var5.func_767_a(var11) < var5.func_767_a(var13))) {
            var13 = var11;
        }

        if (var12 != null && (var13 == null || var5.func_767_a(var12) < var5.func_767_a(var13))) {
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

            return new MovingObjectPosition(var2, var3, var4, var14, var13.func_757_c((double)var2, (double)var3, (double)var4));
        }
    }

    private boolean func_223_a(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1054_b >= this.field_565_bg && var1.field_1054_b <= this.field_559_bj && var1.field_1058_c >= this.field_563_bh && var1.field_1058_c <= this.field_557_bk;
        }
    }

    private boolean func_228_b(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1055_a >= this.field_567_bf && var1.field_1055_a <= this.field_561_bi && var1.field_1058_c >= this.field_563_bh && var1.field_1058_c <= this.field_557_bk;
        }
    }

    private boolean func_236_c(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1055_a >= this.field_567_bf && var1.field_1055_a <= this.field_561_bi && var1.field_1054_b >= this.field_565_bg && var1.field_1054_b <= this.field_559_bj;
        }
    }

    public void func_4029_c(World var1, int var2, int var3, int var4) {
    }

    public boolean func_28026_e(World var1, int var2, int var3, int var4, int var5) {
        return this.func_259_a(var1, var2, var3, var4);
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_444_a(var2, var3, var4);
        return var5 == 0 || field_542_n[var5].field_553_bn.func_27090_g();
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return false;
    }

    public void func_249_b(World var1, int var2, int var3, int var4, Entity var5) {
    }

    public void func_255_c(World var1, int var2, int var3, int var4, int var5) {
    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
    }

    public void func_230_a(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public boolean func_225_d() {
        return false;
    }

    public void func_263_a(World var1, int var2, int var3, int var4, Entity var5) {
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public void func_12007_g(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        var2.func_25046_a(StatList.field_25094_y[this.field_573_bc], 1);
        this.func_247_a_(var1, var3, var4, var5, var6);
    }

    public boolean func_220_f(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void func_4027_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
    }

    public Block func_20037_a(String var1) {
        this.field_666_a = "tile." + var1;
        return this;
    }

    public String func_25012_e() {
        return StatCollector.func_25136_a(this.func_20036_e() + ".name");
    }

    public String func_20036_e() {
        return this.field_666_a;
    }

    public void func_21024_a(World var1, int var2, int var3, int var4, int var5, int var6) {
    }

    public boolean func_27022_g() {
        return this.field_27023_bp;
    }

    protected Block func_27021_h() {
        this.field_27023_bp = false;
        return this;
    }

    public int func_31025_e() {
        return this.field_553_bn.func_31056_j();
    }

    static {
        field_535_u = (new BlockStone(1, 1)).func_237_c(1.5F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("stone");
        field_534_v = (BlockGrass)(new BlockGrass(2)).func_237_c(0.6F).func_4026_a(field_9026_g).func_20037_a("grass");
        field_533_w = (new BlockDirt(3, 2)).func_237_c(0.5F).func_4026_a(field_9027_f).func_20037_a("dirt");
        field_532_x = (new Block(4, 16, Material.field_523_d)).func_237_c(2.0F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("stonebrick");
        field_531_y = (new Block(5, 4, Material.field_524_c)).func_237_c(2.0F).func_232_b(5.0F).func_4026_a(field_9028_e).func_20037_a("wood").func_28027_k();
        field_6047_y = (new BlockSapling(6, 15)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("sapling").func_28027_k();
        field_4064_A = (new Block(7, 17, Material.field_523_d)).func_31027_i().func_232_b(6000000.0F).func_4026_a(field_9025_h).func_20037_a("bedrock").func_27021_h();
        field_598_B = (new BlockFlowing(8, Material.field_521_f)).func_237_c(100.0F).func_258_c(3).func_20037_a("water").func_27021_h().func_28027_k();
        field_596_C = (new BlockStationary(9, Material.field_521_f)).func_237_c(100.0F).func_258_c(3).func_20037_a("water").func_27021_h().func_28027_k();
        field_594_D = (new BlockFlowing(10, Material.field_520_g)).func_237_c(0.0F).func_224_a(1.0F).func_258_c(255).func_20037_a("lava").func_27021_h().func_28027_k();
        field_592_E = (new BlockStationary(11, Material.field_520_g)).func_237_c(100.0F).func_224_a(1.0F).func_258_c(255).func_20037_a("lava").func_27021_h().func_28027_k();
        field_590_F = (new BlockSand(12, 18)).func_237_c(0.5F).func_4026_a(field_9021_l).func_20037_a("sand");
        field_4062_G = (new BlockGravel(13, 19)).func_237_c(0.6F).func_4026_a(field_9027_f).func_20037_a("gravel");
        field_4061_H = (new BlockOre(14, 32)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreGold");
        field_4059_I = (new BlockOre(15, 33)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreIron");
        field_583_J = (new BlockOre(16, 34)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreCoal");
        field_582_K = (new BlockLog(17)).func_237_c(2.0F).func_4026_a(field_9028_e).func_20037_a("log").func_28027_k();
        field_581_L = (BlockLeaves)(new BlockLeaves(18, 52)).func_237_c(0.2F).func_258_c(1).func_4026_a(field_9026_g).func_20037_a("leaves").func_27021_h().func_28027_k();
        field_9043_L = (new BlockSponge(19)).func_237_c(0.6F).func_4026_a(field_9026_g).func_20037_a("sponge");
        field_4056_N = (new BlockGlass(20, 49, Material.field_4216_o, false)).func_237_c(0.3F).func_4026_a(field_9023_j).func_20037_a("glass");
        field_9042_N = (new BlockOre(21, 160)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreLapis");
        field_9041_O = (new Block(22, 144, Material.field_523_d)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("blockLapis");
        field_9040_P = (new BlockDispenser(23)).func_237_c(3.5F).func_4026_a(field_9025_h).func_20037_a("dispenser").func_28027_k();
        field_9039_Q = (new BlockSandStone(24)).func_4026_a(field_9025_h).func_237_c(0.8F).func_20037_a("sandStone");
        field_9038_R = (new BlockNote(25)).func_237_c(0.8F).func_20037_a("musicBlock").func_28027_k();
        field_9037_S = (new BlockBed(26)).func_237_c(0.2F).func_20037_a("bed").func_27021_h().func_28027_k();
        field_9036_T = (new BlockRail(27, 179, true)).func_237_c(0.7F).func_4026_a(field_9024_i).func_20037_a("goldenRail").func_28027_k();
        field_9034_U = (new BlockDetectorRail(28, 195)).func_237_c(0.7F).func_4026_a(field_9024_i).func_20037_a("detectorRail").func_28027_k();
        field_9033_V = (new BlockPistonBase(29, 106, true)).func_20037_a("pistonStickyBase").func_28027_k();
        field_9032_W = (new BlockWeb(30, 11)).func_258_c(1).func_237_c(4.0F).func_20037_a("web");
        field_9031_X = (BlockTallGrass)(new BlockTallGrass(31, 39)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("tallgrass");
        field_9030_Y = (BlockDeadBush)(new BlockDeadBush(32, 55)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("deadbush");
        field_9029_Z = (new BlockPistonBase(33, 107, false)).func_20037_a("pistonBase").func_28027_k();
        field_9049_aa = (BlockPistonExtension)(new BlockPistonExtension(34, 107)).func_28027_k();
        field_616_ac = (new BlockCloth()).func_237_c(0.8F).func_4026_a(field_9022_k).func_20037_a("cloth").func_28027_k();
        field_9048_ac = new BlockPistonMoving(36);
        field_4072_ae = (BlockFlower)(new BlockFlower(37, 13)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("flower");
        field_4071_af = (BlockFlower)(new BlockFlower(38, 12)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("rose");
        field_4070_ag = (BlockFlower)(new BlockMushroom(39, 29)).func_237_c(0.0F).func_4026_a(field_9026_g).func_224_a(0.125F).func_20037_a("mushroom");
        field_4069_ah = (BlockFlower)(new BlockMushroom(40, 28)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("mushroom");
        field_4068_ai = (new BlockOreStorage(41, 23)).func_237_c(3.0F).func_232_b(10.0F).func_4026_a(field_9024_i).func_20037_a("blockGold");
        field_4067_aj = (new BlockOreStorage(42, 22)).func_237_c(5.0F).func_232_b(10.0F).func_4026_a(field_9024_i).func_20037_a("blockIron");
        field_608_ak = (new BlockStep(43, true)).func_237_c(2.0F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("stoneSlab");
        field_607_al = (new BlockStep(44, false)).func_237_c(2.0F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("stoneSlab");
        field_9047_al = (new Block(45, 7, Material.field_523_d)).func_237_c(2.0F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("brick");
        field_605_an = (new BlockTNT(46, 8)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("tnt");
        field_604_ao = (new BlockBookshelf(47, 35)).func_237_c(1.5F).func_4026_a(field_9028_e).func_20037_a("bookshelf");
        field_603_ap = (new Block(48, 36, Material.field_523_d)).func_237_c(2.0F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("stoneMoss");
        field_602_aq = (new BlockObsidian(49, 37)).func_237_c(10.0F).func_232_b(2000.0F).func_4026_a(field_9025_h).func_20037_a("obsidian");
        field_9046_aq = (new BlockTorch(50, 80)).func_237_c(0.0F).func_224_a(0.9375F).func_4026_a(field_9028_e).func_20037_a("torch").func_28027_k();
        field_599_as = (BlockFire)(new BlockFire(51, 31)).func_237_c(0.0F).func_224_a(1.0F).func_4026_a(field_9028_e).func_20037_a("fire").func_27021_h().func_28027_k();
        field_597_at = (new BlockMobSpawner(52, 65)).func_237_c(5.0F).func_4026_a(field_9024_i).func_20037_a("mobSpawner").func_27021_h();
        field_9045_at = (new BlockStairs(53, field_531_y)).func_20037_a("stairsWood").func_28027_k();
        field_593_av = (new BlockChest(54)).func_237_c(2.5F).func_4026_a(field_9028_e).func_20037_a("chest").func_28027_k();
        field_591_aw = (new BlockRedstoneWire(55, 164)).func_237_c(0.0F).func_4026_a(field_551_e).func_20037_a("redstoneDust").func_27021_h().func_28027_k();
        field_588_ax = (new BlockOre(56, 50)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreDiamond");
        field_4060_ay = (new BlockOreStorage(57, 24)).func_237_c(5.0F).func_232_b(10.0F).func_4026_a(field_9024_i).func_20037_a("blockDiamond");
        field_9044_ay = (new BlockWorkbench(58)).func_237_c(2.5F).func_4026_a(field_9028_e).func_20037_a("workbench");
        field_644_aA = (new BlockCrops(59, 88)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("crops").func_27021_h().func_28027_k();
        field_643_aB = (new BlockFarmland(60)).func_237_c(0.6F).func_4026_a(field_9027_f).func_20037_a("farmland");
        field_642_aC = (new BlockFurnace(61, false)).func_237_c(3.5F).func_4026_a(field_9025_h).func_20037_a("furnace").func_28027_k();
        field_641_aD = (new BlockFurnace(62, true)).func_237_c(3.5F).func_4026_a(field_9025_h).func_224_a(0.875F).func_20037_a("furnace").func_28027_k();
        field_4084_aE = (new BlockSign(63, TileEntitySign.class, true)).func_237_c(1.0F).func_4026_a(field_9028_e).func_20037_a("sign").func_27021_h().func_28027_k();
        field_639_aF = (new BlockDoor(64, Material.field_524_c)).func_237_c(3.0F).func_4026_a(field_9028_e).func_20037_a("doorWood").func_27021_h().func_28027_k();
        field_638_aG = (new BlockLadder(65, 83)).func_237_c(0.4F).func_4026_a(field_9028_e).func_20037_a("ladder").func_28027_k();
        field_637_aH = (new BlockRail(66, 128, false)).func_237_c(0.7F).func_4026_a(field_9024_i).func_20037_a("rail").func_28027_k();
        field_9055_aH = (new BlockStairs(67, field_532_x)).func_20037_a("stairsStone").func_28027_k();
        field_4082_aJ = (new BlockSign(68, TileEntitySign.class, false)).func_237_c(1.0F).func_4026_a(field_9028_e).func_20037_a("sign").func_27021_h().func_28027_k();
        field_9054_aJ = (new BlockLever(69, 96)).func_237_c(0.5F).func_4026_a(field_9028_e).func_20037_a("lever").func_28027_k();
        field_9053_aK = (new BlockPressurePlate(70, field_535_u.field_575_bb, EnumMobType.mobs, Material.field_523_d)).func_237_c(0.5F).func_4026_a(field_9025_h).func_20037_a("pressurePlate").func_28027_k();
        field_632_aM = (new BlockDoor(71, Material.field_522_e)).func_237_c(5.0F).func_4026_a(field_9024_i).func_20037_a("doorIron").func_27021_h().func_28027_k();
        field_9052_aM = (new BlockPressurePlate(72, field_531_y.field_575_bb, EnumMobType.everything, Material.field_524_c)).func_237_c(0.5F).func_4026_a(field_9028_e).func_20037_a("pressurePlate").func_28027_k();
        field_630_aO = (new BlockRedstoneOre(73, 51, false)).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreRedstone").func_28027_k();
        field_629_aP = (new BlockRedstoneOre(74, 51, true)).func_224_a(0.625F).func_237_c(3.0F).func_232_b(5.0F).func_4026_a(field_9025_h).func_20037_a("oreRedstone").func_28027_k();
        field_628_aQ = (new BlockRedstoneTorch(75, 115, false)).func_237_c(0.0F).func_4026_a(field_9028_e).func_20037_a("notGate").func_28027_k();
        field_627_aR = (new BlockRedstoneTorch(76, 99, true)).func_237_c(0.0F).func_224_a(0.5F).func_4026_a(field_9028_e).func_20037_a("notGate").func_28027_k();
        field_9051_aR = (new BlockButton(77, field_535_u.field_575_bb)).func_237_c(0.5F).func_4026_a(field_9025_h).func_20037_a("button").func_28027_k();
        field_625_aT = (new BlockSnow(78, 66)).func_237_c(0.1F).func_4026_a(field_9022_k).func_20037_a("snow");
        field_4077_aU = (new BlockIce(79, 67)).func_237_c(0.5F).func_258_c(3).func_4026_a(field_9023_j).func_20037_a("ice");
        field_4076_aV = (new BlockSnowBlock(80, 66)).func_237_c(0.2F).func_4026_a(field_9022_k).func_20037_a("snow");
        field_622_aW = (new BlockCactus(81, 70)).func_237_c(0.4F).func_4026_a(field_9022_k).func_20037_a("cactus");
        field_621_aX = (new BlockClay(82, 72)).func_237_c(0.6F).func_4026_a(field_9027_f).func_20037_a("clay");
        field_620_aY = (new BlockReed(83, 73)).func_237_c(0.0F).func_4026_a(field_9026_g).func_20037_a("reeds").func_27021_h();
        field_619_aZ = (new BlockJukeBox(84, 74)).func_237_c(2.0F).func_232_b(10.0F).func_4026_a(field_9025_h).func_20037_a("jukebox").func_28027_k();
        field_9050_aZ = (new BlockFence(85, 4)).func_237_c(2.0F).func_232_b(5.0F).func_4026_a(field_9028_e).func_20037_a("fence").func_28027_k();
        field_4052_bb = (new BlockPumpkin(86, 102, false)).func_237_c(1.0F).func_4026_a(field_9028_e).func_20037_a("pumpkin").func_28027_k();
        field_4050_bc = (new BlockNetherrack(87, 103)).func_237_c(0.4F).func_4026_a(field_9025_h).func_20037_a("hellrock");
        field_4048_bd = (new BlockSoulSand(88, 104)).func_237_c(0.5F).func_4026_a(field_9021_l).func_20037_a("hellsand");
        field_6065_bd = (new BlockGlowStone(89, 105, Material.field_523_d)).func_237_c(0.3F).func_4026_a(field_9023_j).func_224_a(1.0F).func_20037_a("lightgem");
        field_4044_bf = (BlockPortal)(new BlockPortal(90, 14)).func_237_c(-1.0F).func_4026_a(field_9023_j).func_224_a(0.75F).func_20037_a("portal");
        field_9035_bf = (new BlockPumpkin(91, 102, true)).func_237_c(1.0F).func_4026_a(field_9028_e).func_224_a(1.0F).func_20037_a("litpumpkin").func_28027_k();
        field_21026_bg = (new BlockCake(92, 121)).func_237_c(0.5F).func_4026_a(field_9022_k).func_20037_a("cake").func_27021_h().func_28027_k();
        field_22011_bh = (new BlockRedstoneRepeater(93, false)).func_237_c(0.0F).func_4026_a(field_9028_e).func_20037_a("diode").func_27021_h().func_28027_k();
        field_22010_bi = (new BlockRedstoneRepeater(94, true)).func_237_c(0.0F).func_224_a(0.625F).func_4026_a(field_9028_e).func_20037_a("diode").func_27021_h().func_28027_k();
        field_25013_bj = (new BlockLockedChest(95)).func_237_c(0.0F).func_224_a(1.0F).func_4026_a(field_9028_e).func_20037_a("lockedchest").func_231_a(true).func_28027_k();
        field_28030_bl = (new BlockTrapDoor(96, Material.field_524_c)).func_237_c(3.0F).func_4026_a(field_9028_e).func_20037_a("trapdoor").func_27021_h().func_28027_k();
        Item.field_176_c[field_616_ac.field_573_bc] = (new ItemCloth(field_616_ac.field_573_bc - 256)).func_20105_a("cloth");
        Item.field_176_c[field_582_K.field_573_bc] = (new ItemLog(field_582_K.field_573_bc - 256)).func_20105_a("log");
        Item.field_176_c[field_607_al.field_573_bc] = (new ItemSlab(field_607_al.field_573_bc - 256)).func_20105_a("stoneSlab");
        Item.field_176_c[field_6047_y.field_573_bc] = (new ItemSapling(field_6047_y.field_573_bc - 256)).func_20105_a("sapling");
        Item.field_176_c[field_581_L.field_573_bc] = (new ItemLeaves(field_581_L.field_573_bc - 256)).func_20105_a("leaves");
        Item.field_176_c[field_9029_Z.field_573_bc] = new ItemPiston(field_9029_Z.field_573_bc - 256);
        Item.field_176_c[field_9033_V.field_573_bc] = new ItemPiston(field_9033_V.field_573_bc - 256);

        for(int var0 = 0; var0 < 256; ++var0) {
            if (field_542_n[var0] != null && Item.field_176_c[var0] == null) {
                Item.field_176_c[var0] = new ItemBlock(var0 - 256);
                field_542_n[var0].func_28028_f();
            }
        }

        field_537_s[0] = true;
        StatList.func_25088_a();
    }
}
