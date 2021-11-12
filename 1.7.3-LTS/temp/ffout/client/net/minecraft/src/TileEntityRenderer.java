package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderer {
    private Map field_6517_m = new HashMap();
    public static TileEntityRenderer field_1554_a = new TileEntityRenderer();
    private FontRenderer field_1541_n;
    public static double field_1553_b;
    public static double field_1552_c;
    public static double field_1551_d;
    public RenderEngine field_1550_e;
    public World field_1549_f;
    public EntityLiving field_22270_g;
    public float field_22269_h;
    public float field_22268_i;
    public double field_1545_j;
    public double field_1544_k;
    public double field_1543_l;

    private TileEntityRenderer() {
        this.field_6517_m.put(TileEntitySign.class, new TileEntitySignRenderer());
        this.field_6517_m.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        this.field_6517_m.put(TileEntityPiston.class, new TileEntityRendererPiston());
        Iterator var1 = this.field_6517_m.values().iterator();

        while(var1.hasNext()) {
            TileEntitySpecialRenderer var2 = (TileEntitySpecialRenderer)var1.next();
            var2.func_928_a(this);
        }

    }

    public TileEntitySpecialRenderer func_4144_a(Class var1) {
        TileEntitySpecialRenderer var2 = (TileEntitySpecialRenderer)this.field_6517_m.get(var1);
        if (var2 == null && var1 != TileEntity.class) {
            var2 = this.func_4144_a(var1.getSuperclass());
            this.field_6517_m.put(var1, var2);
        }

        return var2;
    }

    public boolean func_1028_a(TileEntity var1) {
        return this.func_1031_b(var1) != null;
    }

    public TileEntitySpecialRenderer func_1031_b(TileEntity var1) {
        return var1 == null ? null : this.func_4144_a(var1.getClass());
    }

    public void func_22267_a(World var1, RenderEngine var2, FontRenderer var3, EntityLiving var4, float var5) {
        if (this.field_1549_f != var1) {
            this.func_31072_a(var1);
        }

        this.field_1550_e = var2;
        this.field_22270_g = var4;
        this.field_1541_n = var3;
        this.field_22269_h = var4.field_603_as + (var4.field_605_aq - var4.field_603_as) * var5;
        this.field_22268_i = var4.field_602_at + (var4.field_604_ar - var4.field_602_at) * var5;
        this.field_1545_j = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)var5;
        this.field_1544_k = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)var5;
        this.field_1543_l = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)var5;
    }

    public void func_1030_a(TileEntity var1, float var2) {
        if (var1.func_480_a(this.field_1545_j, this.field_1544_k, this.field_1543_l) < 4096.0D) {
            float var3 = this.field_1549_f.func_598_c(var1.field_823_f, var1.field_822_g, var1.field_821_h);
            GL11.glColor3f(var3, var3, var3);
            this.func_1032_a(var1, (double)var1.field_823_f - field_1553_b, (double)var1.field_822_g - field_1552_c, (double)var1.field_821_h - field_1551_d, var2);
        }

    }

    public void func_1032_a(TileEntity var1, double var2, double var4, double var6, float var8) {
        TileEntitySpecialRenderer var9 = this.func_1031_b(var1);
        if (var9 != null) {
            var9.func_930_a(var1, var2, var4, var6, var8);
        }

    }

    public void func_31072_a(World var1) {
        this.field_1549_f = var1;
        Iterator var2 = this.field_6517_m.values().iterator();

        while(var2.hasNext()) {
            TileEntitySpecialRenderer var3 = (TileEntitySpecialRenderer)var2.next();
            if (var3 != null) {
                var3.func_31069_a(var1);
            }
        }

    }

    public FontRenderer func_6516_a() {
        return this.field_1541_n;
    }
}
