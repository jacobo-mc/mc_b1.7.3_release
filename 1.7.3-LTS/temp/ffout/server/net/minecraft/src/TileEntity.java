package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class TileEntity {
    private static Map field_481_e = new HashMap();
    private static Map field_480_f = new HashMap();
    public World field_479_a;
    public int field_478_b;
    public int field_483_c;
    public int field_482_d;
    protected boolean field_31006_h;

    private static void func_187_a(Class var0, String var1) {
        if (field_480_f.containsKey(var1)) {
            throw new IllegalArgumentException("Duplicate id: " + var1);
        } else {
            field_481_e.put(var1, var0);
            field_480_f.put(var0, var1);
        }
    }

    public void func_186_a(NBTTagCompound var1) {
        this.field_478_b = var1.func_395_d("x");
        this.field_483_c = var1.func_395_d("y");
        this.field_482_d = var1.func_395_d("z");
    }

    public void func_188_b(NBTTagCompound var1) {
        String var2 = (String)field_480_f.get(this.getClass());
        if (var2 == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        } else {
            var1.func_403_a("id", var2);
            var1.func_405_a("x", this.field_478_b);
            var1.func_405_a("y", this.field_483_c);
            var1.func_405_a("z", this.field_482_d);
        }
    }

    public void func_184_b() {
    }

    public static TileEntity func_185_c(NBTTagCompound var0) {
        TileEntity var1 = null;

        try {
            Class var2 = (Class)field_481_e.get(var0.func_401_h("id"));
            if (var2 != null) {
                var1 = (TileEntity)var2.newInstance();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        if (var1 != null) {
            var1.func_186_a(var0);
        } else {
            System.out.println("Skipping TileEntity with id " + var0.func_401_h("id"));
        }

        return var1;
    }

    public int func_31005_e() {
        return this.field_479_a.func_446_b(this.field_478_b, this.field_483_c, this.field_482_d);
    }

    public void func_31001_i() {
        if (this.field_479_a != null) {
            this.field_479_a.func_515_b(this.field_478_b, this.field_483_c, this.field_482_d, this);
        }

    }

    public Packet func_20070_f() {
        return null;
    }

    public boolean func_31004_g() {
        return this.field_31006_h;
    }

    public void func_31003_h() {
        this.field_31006_h = true;
    }

    public void func_31002_j() {
        this.field_31006_h = false;
    }

    static {
        func_187_a(TileEntityFurnace.class, "Furnace");
        func_187_a(TileEntityChest.class, "Chest");
        func_187_a(TileEntityRecordPlayer.class, "RecordPlayer");
        func_187_a(TileEntityDispenser.class, "Trap");
        func_187_a(TileEntitySign.class, "Sign");
        func_187_a(TileEntityMobSpawner.class, "MobSpawner");
        func_187_a(TileEntityNote.class, "Music");
        func_187_a(TileEntityPiston.class, "Piston");
    }
}
