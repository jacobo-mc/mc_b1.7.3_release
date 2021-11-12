package net.minecraft.src;

public class MapColor {
    public static final MapColor[] field_28200_a = new MapColor[16];
    public static final MapColor field_28199_b = new MapColor(0, 0);
    public static final MapColor field_28198_c = new MapColor(1, 8368696);
    public static final MapColor field_28197_d = new MapColor(2, 16247203);
    public static final MapColor field_28196_e = new MapColor(3, 10987431);
    public static final MapColor field_28195_f = new MapColor(4, 16711680);
    public static final MapColor field_28194_g = new MapColor(5, 10526975);
    public static final MapColor field_28193_h = new MapColor(6, 10987431);
    public static final MapColor field_28192_i = new MapColor(7, 31744);
    public static final MapColor field_28191_j = new MapColor(8, 16777215);
    public static final MapColor field_28190_k = new MapColor(9, 10791096);
    public static final MapColor field_28189_l = new MapColor(10, 12020271);
    public static final MapColor field_28188_m = new MapColor(11, 7368816);
    public static final MapColor field_28187_n = new MapColor(12, 4210943);
    public static final MapColor field_28186_o = new MapColor(13, 6837042);
    public final int field_28185_p;
    public final int field_28184_q;

    private MapColor(int var1, int var2) {
        this.field_28184_q = var1;
        this.field_28185_p = var2;
        field_28200_a[var1] = this;
    }
}
