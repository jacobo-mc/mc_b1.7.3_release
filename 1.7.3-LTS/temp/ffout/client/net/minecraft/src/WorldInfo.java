package net.minecraft.src;

import java.util.List;

public class WorldInfo {
    private long field_22320_a;
    private int field_22319_b;
    private int field_22318_c;
    private int field_22317_d;
    private long field_22316_e;
    private long field_22315_f;
    private long field_22314_g;
    private NBTTagCompound field_22313_h;
    private int field_22312_i;
    private String field_22311_j;
    private int field_22310_k;
    private boolean field_27404_l;
    private int field_27403_m;
    private boolean field_27402_n;
    private int field_27401_o;

    public WorldInfo(NBTTagCompound var1) {
        this.field_22320_a = var1.func_764_f("RandomSeed");
        this.field_22319_b = var1.func_756_e("SpawnX");
        this.field_22318_c = var1.func_756_e("SpawnY");
        this.field_22317_d = var1.func_756_e("SpawnZ");
        this.field_22316_e = var1.func_764_f("Time");
        this.field_22315_f = var1.func_764_f("LastPlayed");
        this.field_22314_g = var1.func_764_f("SizeOnDisk");
        this.field_22311_j = var1.func_755_i("LevelName");
        this.field_22310_k = var1.func_756_e("version");
        this.field_27403_m = var1.func_756_e("rainTime");
        this.field_27404_l = var1.func_760_m("raining");
        this.field_27401_o = var1.func_756_e("thunderTime");
        this.field_27402_n = var1.func_760_m("thundering");
        if (var1.func_751_b("Player")) {
            this.field_22313_h = var1.func_743_k("Player");
            this.field_22312_i = this.field_22313_h.func_756_e("Dimension");
        }

    }

    public WorldInfo(long var1, String var3) {
        this.field_22320_a = var1;
        this.field_22311_j = var3;
    }

    public WorldInfo(WorldInfo var1) {
        this.field_22320_a = var1.field_22320_a;
        this.field_22319_b = var1.field_22319_b;
        this.field_22318_c = var1.field_22318_c;
        this.field_22317_d = var1.field_22317_d;
        this.field_22316_e = var1.field_22316_e;
        this.field_22315_f = var1.field_22315_f;
        this.field_22314_g = var1.field_22314_g;
        this.field_22313_h = var1.field_22313_h;
        this.field_22312_i = var1.field_22312_i;
        this.field_22311_j = var1.field_22311_j;
        this.field_22310_k = var1.field_22310_k;
        this.field_27403_m = var1.field_27403_m;
        this.field_27404_l = var1.field_27404_l;
        this.field_27401_o = var1.field_27401_o;
        this.field_27402_n = var1.field_27402_n;
    }

    public NBTTagCompound func_22299_a() {
        NBTTagCompound var1 = new NBTTagCompound();
        this.func_22291_a(var1, this.field_22313_h);
        return var1;
    }

    public NBTTagCompound func_22305_a(List var1) {
        NBTTagCompound var2 = new NBTTagCompound();
        EntityPlayer var3 = null;
        NBTTagCompound var4 = null;
        if (var1.size() > 0) {
            var3 = (EntityPlayer)var1.get(0);
        }

        if (var3 != null) {
            var4 = new NBTTagCompound();
            var3.func_363_d(var4);
        }

        this.func_22291_a(var2, var4);
        return var2;
    }

    private void func_22291_a(NBTTagCompound var1, NBTTagCompound var2) {
        var1.func_750_a("RandomSeed", this.field_22320_a);
        var1.func_758_a("SpawnX", this.field_22319_b);
        var1.func_758_a("SpawnY", this.field_22318_c);
        var1.func_758_a("SpawnZ", this.field_22317_d);
        var1.func_750_a("Time", this.field_22316_e);
        var1.func_750_a("SizeOnDisk", this.field_22314_g);
        var1.func_750_a("LastPlayed", System.currentTimeMillis());
        var1.func_754_a("LevelName", this.field_22311_j);
        var1.func_758_a("version", this.field_22310_k);
        var1.func_758_a("rainTime", this.field_27403_m);
        var1.func_748_a("raining", this.field_27404_l);
        var1.func_758_a("thunderTime", this.field_27401_o);
        var1.func_748_a("thundering", this.field_27402_n);
        if (var2 != null) {
            var1.func_763_a("Player", var2);
        }

    }

    public long func_22288_b() {
        return this.field_22320_a;
    }

    public int func_22293_c() {
        return this.field_22319_b;
    }

    public int func_22295_d() {
        return this.field_22318_c;
    }

    public int func_22300_e() {
        return this.field_22317_d;
    }

    public long func_22304_f() {
        return this.field_22316_e;
    }

    public long func_22306_g() {
        return this.field_22314_g;
    }

    public NBTTagCompound func_22303_h() {
        return this.field_22313_h;
    }

    public int func_22290_i() {
        return this.field_22312_i;
    }

    public void func_22294_a(int var1) {
        this.field_22319_b = var1;
    }

    public void func_22308_b(int var1) {
        this.field_22318_c = var1;
    }

    public void func_22298_c(int var1) {
        this.field_22317_d = var1;
    }

    public void func_22307_a(long var1) {
        this.field_22316_e = var1;
    }

    public void func_22297_b(long var1) {
        this.field_22314_g = var1;
    }

    public void func_22309_a(NBTTagCompound var1) {
        this.field_22313_h = var1;
    }

    public void func_22292_a(int var1, int var2, int var3) {
        this.field_22319_b = var1;
        this.field_22318_c = var2;
        this.field_22317_d = var3;
    }

    public String func_22302_j() {
        return this.field_22311_j;
    }

    public void func_22287_a(String var1) {
        this.field_22311_j = var1;
    }

    public int func_22296_k() {
        return this.field_22310_k;
    }

    public void func_22289_d(int var1) {
        this.field_22310_k = var1;
    }

    public long func_22301_l() {
        return this.field_22315_f;
    }

    public boolean func_27396_m() {
        return this.field_27402_n;
    }

    public void func_27398_a(boolean var1) {
        this.field_27402_n = var1;
    }

    public int func_27400_n() {
        return this.field_27401_o;
    }

    public void func_27399_e(int var1) {
        this.field_27401_o = var1;
    }

    public boolean func_27397_o() {
        return this.field_27404_l;
    }

    public void func_27394_b(boolean var1) {
        this.field_27404_l = var1;
    }

    public int func_27393_p() {
        return this.field_27403_m;
    }

    public void func_27395_f(int var1) {
        this.field_27403_m = var1;
    }
}
