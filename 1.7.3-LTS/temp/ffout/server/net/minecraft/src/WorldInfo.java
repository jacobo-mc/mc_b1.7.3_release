package net.minecraft.src;

import java.util.List;

public class WorldInfo {
    private long field_22202_a;
    private int field_22201_b;
    private int field_22200_c;
    private int field_22199_d;
    private long field_22198_e;
    private long field_22197_f;
    private long field_22196_g;
    private NBTTagCompound field_22195_h;
    private int field_22194_i;
    private String field_22193_j;
    private int field_22192_k;
    private boolean field_27126_l;
    private int field_27125_m;
    private boolean field_27124_n;
    private int field_27123_o;

    public WorldInfo(NBTTagCompound var1) {
        this.field_22202_a = var1.func_404_e("RandomSeed");
        this.field_22201_b = var1.func_395_d("SpawnX");
        this.field_22200_c = var1.func_395_d("SpawnY");
        this.field_22199_d = var1.func_395_d("SpawnZ");
        this.field_22198_e = var1.func_404_e("Time");
        this.field_22197_f = var1.func_404_e("LastPlayed");
        this.field_22196_g = var1.func_404_e("SizeOnDisk");
        this.field_22193_j = var1.func_401_h("LevelName");
        this.field_22192_k = var1.func_395_d("version");
        this.field_27125_m = var1.func_395_d("rainTime");
        this.field_27126_l = var1.func_402_l("raining");
        this.field_27123_o = var1.func_395_d("thunderTime");
        this.field_27124_n = var1.func_402_l("thundering");
        if (var1.func_410_a("Player")) {
            this.field_22195_h = var1.func_397_j("Player");
            this.field_22194_i = this.field_22195_h.func_395_d("Dimension");
        }

    }

    public WorldInfo(long var1, String var3) {
        this.field_22202_a = var1;
        this.field_22193_j = var3;
    }

    public WorldInfo(WorldInfo var1) {
        this.field_22202_a = var1.field_22202_a;
        this.field_22201_b = var1.field_22201_b;
        this.field_22200_c = var1.field_22200_c;
        this.field_22199_d = var1.field_22199_d;
        this.field_22198_e = var1.field_22198_e;
        this.field_22197_f = var1.field_22197_f;
        this.field_22196_g = var1.field_22196_g;
        this.field_22195_h = var1.field_22195_h;
        this.field_22194_i = var1.field_22194_i;
        this.field_22193_j = var1.field_22193_j;
        this.field_22192_k = var1.field_22192_k;
        this.field_27125_m = var1.field_27125_m;
        this.field_27126_l = var1.field_27126_l;
        this.field_27123_o = var1.field_27123_o;
        this.field_27124_n = var1.field_27124_n;
    }

    public NBTTagCompound func_22185_a() {
        NBTTagCompound var1 = new NBTTagCompound();
        this.func_22176_a(var1, this.field_22195_h);
        return var1;
    }

    public NBTTagCompound func_22183_a(List var1) {
        NBTTagCompound var2 = new NBTTagCompound();
        EntityPlayer var3 = null;
        NBTTagCompound var4 = null;
        if (var1.size() > 0) {
            var3 = (EntityPlayer)var1.get(0);
        }

        if (var3 != null) {
            var4 = new NBTTagCompound();
            var3.func_98_d(var4);
        }

        this.func_22176_a(var2, var4);
        return var2;
    }

    private void func_22176_a(NBTTagCompound var1, NBTTagCompound var2) {
        var1.func_396_a("RandomSeed", this.field_22202_a);
        var1.func_405_a("SpawnX", this.field_22201_b);
        var1.func_405_a("SpawnY", this.field_22200_c);
        var1.func_405_a("SpawnZ", this.field_22199_d);
        var1.func_396_a("Time", this.field_22198_e);
        var1.func_396_a("SizeOnDisk", this.field_22196_g);
        var1.func_396_a("LastPlayed", System.currentTimeMillis());
        var1.func_403_a("LevelName", this.field_22193_j);
        var1.func_405_a("version", this.field_22192_k);
        var1.func_405_a("rainTime", this.field_27125_m);
        var1.func_393_a("raining", this.field_27126_l);
        var1.func_405_a("thunderTime", this.field_27123_o);
        var1.func_393_a("thundering", this.field_27124_n);
        if (var2 != null) {
            var1.func_392_a("Player", var2);
        }

    }

    public long func_22187_b() {
        return this.field_22202_a;
    }

    public int func_22184_c() {
        return this.field_22201_b;
    }

    public int func_22179_d() {
        return this.field_22200_c;
    }

    public int func_22189_e() {
        return this.field_22199_d;
    }

    public long func_22186_f() {
        return this.field_22198_e;
    }

    public long func_22182_g() {
        return this.field_22196_g;
    }

    public int func_22178_h() {
        return this.field_22194_i;
    }

    public void func_22180_a(long var1) {
        this.field_22198_e = var1;
    }

    public void func_22177_b(long var1) {
        this.field_22196_g = var1;
    }

    public void func_22181_a(int var1, int var2, int var3) {
        this.field_22201_b = var1;
        this.field_22200_c = var2;
        this.field_22199_d = var3;
    }

    public void func_22190_a(String var1) {
        this.field_22193_j = var1;
    }

    public int func_22188_i() {
        return this.field_22192_k;
    }

    public void func_22191_a(int var1) {
        this.field_22192_k = var1;
    }

    public boolean func_27122_j() {
        return this.field_27124_n;
    }

    public void func_27119_a(boolean var1) {
        this.field_27124_n = var1;
    }

    public int func_27117_k() {
        return this.field_27123_o;
    }

    public void func_27121_b(int var1) {
        this.field_27123_o = var1;
    }

    public boolean func_27115_l() {
        return this.field_27126_l;
    }

    public void func_27116_b(boolean var1) {
        this.field_27126_l = var1;
    }

    public int func_27120_m() {
        return this.field_27125_m;
    }

    public void func_27118_c(int var1) {
        this.field_27125_m = var1;
    }
}
