package net.minecraft.src;

public class Material {
    public static final Material field_526_a;
    public static final Material field_28132_b;
    public static final Material field_525_b;
    public static final Material field_524_c;
    public static final Material field_523_d;
    public static final Material field_522_e;
    public static final Material field_521_f;
    public static final Material field_520_g;
    public static final Material field_4218_h;
    public static final Material field_518_i;
    public static final Material field_517_j;
    public static final Material field_4217_k;
    public static final Material field_515_l;
    public static final Material field_514_m;
    public static final Material field_513_n;
    public static final Material field_4216_o;
    public static final Material field_511_p;
    public static final Material field_4215_q;
    public static final Material field_509_r;
    public static final Material field_508_s;
    public static final Material field_507_t;
    public static final Material field_4214_u;
    public static final Material field_505_v;
    public static final Material field_4213_w;
    public static final Material field_4212_x;
    public static final Material field_21100_y;
    public static final Material field_31063_A;
    public static final Material field_31062_B;
    private boolean field_4211_y;
    private boolean field_27091_A;
    private boolean field_28130_D;
    public final MapColor field_28131_A;
    private boolean field_31061_G = true;
    private int field_31060_H;

    public Material(MapColor var1) {
        this.field_28131_A = var1;
    }

    public boolean func_217_d() {
        return false;
    }

    public boolean func_216_a() {
        return true;
    }

    public boolean func_219_b() {
        return true;
    }

    public boolean func_218_c() {
        return true;
    }

    private Material func_28129_i() {
        this.field_28130_D = true;
        return this;
    }

    private Material func_31058_n() {
        this.field_31061_G = false;
        return this;
    }

    private Material func_4052_f() {
        this.field_4211_y = true;
        return this;
    }

    public boolean func_4051_e() {
        return this.field_4211_y;
    }

    public Material func_27089_f() {
        this.field_27091_A = true;
        return this;
    }

    public boolean func_27090_g() {
        return this.field_27091_A;
    }

    public boolean func_28128_h() {
        return this.field_28130_D ? false : this.func_218_c();
    }

    public boolean func_31055_i() {
        return this.field_31061_G;
    }

    public int func_31056_j() {
        return this.field_31060_H;
    }

    protected Material func_31059_k() {
        this.field_31060_H = 1;
        return this;
    }

    protected Material func_31057_l() {
        this.field_31060_H = 2;
        return this;
    }

    static {
        field_526_a = new MaterialTransparent(MapColor.field_28199_b);
        field_28132_b = new Material(MapColor.field_28198_c);
        field_525_b = new Material(MapColor.field_28189_l);
        field_524_c = (new Material(MapColor.field_28186_o)).func_4052_f();
        field_523_d = (new Material(MapColor.field_28188_m)).func_31058_n();
        field_522_e = (new Material(MapColor.field_28193_h)).func_31058_n();
        field_521_f = (new MaterialLiquid(MapColor.field_28187_n)).func_31059_k();
        field_520_g = (new MaterialLiquid(MapColor.field_28195_f)).func_31059_k();
        field_4218_h = (new Material(MapColor.field_28192_i)).func_4052_f().func_28129_i().func_31059_k();
        field_518_i = (new MaterialLogic(MapColor.field_28192_i)).func_31059_k();
        field_517_j = new Material(MapColor.field_28196_e);
        field_4217_k = (new Material(MapColor.field_28196_e)).func_4052_f();
        field_515_l = (new MaterialTransparent(MapColor.field_28199_b)).func_31059_k();
        field_514_m = new Material(MapColor.field_28197_d);
        field_513_n = (new MaterialLogic(MapColor.field_28199_b)).func_31059_k();
        field_4216_o = (new Material(MapColor.field_28199_b)).func_28129_i();
        field_511_p = (new Material(MapColor.field_28195_f)).func_4052_f().func_28129_i();
        field_4215_q = (new Material(MapColor.field_28192_i)).func_31059_k();
        field_509_r = (new Material(MapColor.field_28194_g)).func_28129_i();
        field_508_s = (new MaterialLogic(MapColor.field_28191_j)).func_27089_f().func_28129_i().func_31058_n().func_31059_k();
        field_507_t = (new Material(MapColor.field_28191_j)).func_31058_n();
        field_4214_u = (new Material(MapColor.field_28192_i)).func_28129_i().func_31059_k();
        field_505_v = new Material(MapColor.field_28190_k);
        field_4213_w = (new Material(MapColor.field_28192_i)).func_31059_k();
        field_4212_x = (new MaterialPortal(MapColor.field_28199_b)).func_31057_l();
        field_21100_y = (new Material(MapColor.field_28199_b)).func_31059_k();
        field_31063_A = (new Material(MapColor.field_28196_e)).func_31058_n().func_31059_k();
        field_31062_B = (new Material(MapColor.field_28188_m)).func_31057_l();
    }
}
