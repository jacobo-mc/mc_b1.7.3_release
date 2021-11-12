package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class TileEntity {
    private static Map field_820_a = new HashMap();
    private static Map field_819_b = new HashMap();
    public World field_824_e;
    public int field_823_f;
    public int field_822_g;
    public int field_821_h;
    protected boolean field_31007_h;

    private static void func_476_a(Class var0, String var1) {
        if (field_819_b.containsKey(var1)) {
            throw new IllegalArgumentException("Duplicate id: " + var1);
        } else {
            field_820_a.put(var1, var0);
            field_819_b.put(var0, var1);
        }
    }

    public void func_482_a(NBTTagCompound var1) {
        this.field_823_f = var1.func_756_e("x");
        this.field_822_g = var1.func_756_e("y");
        this.field_821_h = var1.func_756_e("z");
    }

    public void func_481_b(NBTTagCompound var1) {
        String var2 = (String)field_819_b.get(this.getClass());
        if (var2 == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        } else {
            var1.func_754_a("id", var2);
            var1.func_758_a("x", this.field_823_f);
            var1.func_758_a("y", this.field_822_g);
            var1.func_758_a("z", this.field_821_h);
        }
    }

    public void func_475_b() {
    }

    public static TileEntity func_477_c(NBTTagCompound var0) {
        TileEntity var1 = null;

        try {
            Class var2 = (Class)field_820_a.get(var0.func_755_i("id"));
            if (var2 != null) {
                var1 = (TileEntity)var2.newInstance();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        if (var1 != null) {
            var1.func_482_a(var0);
        } else {
            System.out.println("Skipping TileEntity with id " + var0.func_755_i("id"));
        }

        return var1;
    }

    public int func_479_f() {
        return this.field_824_e.func_602_e(this.field_823_f, this.field_822_g, this.field_821_h);
    }

    public void func_474_j_() {
        if (this.field_824_e != null) {
            this.field_824_e.func_698_b(this.field_823_f, this.field_822_g, this.field_821_h, this);
        }

    }

    public double func_480_a(double var1, double var3, double var5) {
        double var7 = (double)this.field_823_f + 0.5D - var1;
        double var9 = (double)this.field_822_g + 0.5D - var3;
        double var11 = (double)this.field_821_h + 0.5D - var5;
        return var7 * var7 + var9 * var9 + var11 * var11;
    }

    public Block func_478_g() {
        return Block.field_345_n[this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h)];
    }

    public boolean func_31006_g() {
        return this.field_31007_h;
    }

    public void func_31005_i() {
        this.field_31007_h = true;
    }

    public void func_31004_j() {
        this.field_31007_h = false;
    }

    static {
        func_476_a(TileEntityFurnace.class, "Furnace");
        func_476_a(TileEntityChest.class, "Chest");
        func_476_a(TileEntityRecordPlayer.class, "RecordPlayer");
        func_476_a(TileEntityDispenser.class, "Trap");
        func_476_a(TileEntitySign.class, "Sign");
        func_476_a(TileEntityMobSpawner.class, "MobSpawner");
        func_476_a(TileEntityNote.class, "Music");
        func_476_a(TileEntityPiston.class, "Piston");
    }
}
