package net.minecraft.src;

public class MapColor {
    public static final MapColor[] field_28213_a = new MapColor[16];
    public static final MapColor field_28212_b = new MapColor(0, 0);
    public static final MapColor field_28211_c = new MapColor(1, 8368696);
    public static final MapColor field_28210_d = new MapColor(2, 16247203);
    public static final MapColor field_28209_e = new MapColor(3, 10987431);
    public static final MapColor field_28208_f = new MapColor(4, 16711680);
    public static final MapColor field_28207_g = new MapColor(5, 10526975);
    public static final MapColor field_28206_h = new MapColor(6, 10987431);
    public static final MapColor field_28205_i = new MapColor(7, 31744);
    public static final MapColor field_28204_j = new MapColor(8, 16777215);
    public static final MapColor field_28203_k = new MapColor(9, 10791096);
    public static final MapColor field_28202_l = new MapColor(10, 12020271);
    public static final MapColor field_28201_m = new MapColor(11, 7368816);
    public static final MapColor field_28200_n = new MapColor(12, 4210943);
    public static final MapColor field_28199_o = new MapColor(13, 6837042);
    public final int field_28198_p;
    public final int field_28197_q;

    private MapColor(int var1, int var2) {
        this.field_28197_q = var1;
        this.field_28198_p = var2;
        field_28213_a[var1] = this;
    }
}
