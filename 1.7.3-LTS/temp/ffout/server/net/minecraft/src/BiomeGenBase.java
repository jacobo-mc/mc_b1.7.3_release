package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BiomeGenBase {
    public static final BiomeGenBase field_4300_a = (new BiomeGenRainforest()).func_4079_b(588342).func_4082_a("Rainforest").func_4080_a(2094168);
    public static final BiomeGenBase field_4299_b = (new BiomeGenSwamp()).func_4079_b(522674).func_4082_a("Swampland").func_4080_a(9154376);
    public static final BiomeGenBase field_4298_c = (new BiomeGenBase()).func_4079_b(10215459).func_4082_a("Seasonal Forest");
    public static final BiomeGenBase field_4297_d = (new BiomeGenForest()).func_4079_b(353825).func_4082_a("Forest").func_4080_a(5159473);
    public static final BiomeGenBase field_4296_e = (new BiomeGenDesert()).func_4079_b(14278691).func_4082_a("Savanna");
    public static final BiomeGenBase field_4295_f = (new BiomeGenBase()).func_4079_b(10595616).func_4082_a("Shrubland");
    public static final BiomeGenBase field_4294_g = (new BiomeGenTaiga()).func_4079_b(3060051).func_4082_a("Taiga").func_4083_b().func_4080_a(8107825);
    public static final BiomeGenBase field_4293_h = (new BiomeGenDesert()).func_4079_b(16421912).func_4082_a("Desert").func_27047_e();
    public static final BiomeGenBase field_4292_i = (new BiomeGenDesert()).func_4079_b(16767248).func_4082_a("Plains");
    public static final BiomeGenBase field_4291_j = (new BiomeGenDesert()).func_4079_b(16772499).func_4082_a("Ice Desert").func_4083_b().func_27047_e().func_4080_a(12899129);
    public static final BiomeGenBase field_4290_k = (new BiomeGenBase()).func_4079_b(5762041).func_4082_a("Tundra").func_4083_b().func_4080_a(12899129);
    public static final BiomeGenBase field_4289_l = (new BiomeGenHell()).func_4079_b(16711680).func_4082_a("Hell").func_27047_e();
    public static final BiomeGenBase field_28054_m = (new BiomeGenSky()).func_4079_b(8421631).func_4082_a("Sky").func_27047_e();
    public String field_6163_m;
    public int field_6162_n;
    public byte field_4286_o;
    public byte field_4285_p;
    public int field_6161_q;
    protected List field_25058_r;
    protected List field_25057_s;
    protected List field_25056_t;
    private boolean field_27051_u;
    private boolean field_27050_v;
    private static BiomeGenBase[] field_4281_t = new BiomeGenBase[4096];

    protected BiomeGenBase() {
        this.field_4286_o = (byte)Block.field_534_v.field_573_bc;
        this.field_4285_p = (byte)Block.field_533_w.field_573_bc;
        this.field_6161_q = 5169201;
        this.field_25058_r = new ArrayList();
        this.field_25057_s = new ArrayList();
        this.field_25056_t = new ArrayList();
        this.field_27050_v = true;
        this.field_25058_r.add(new SpawnListEntry(EntitySpider.class, 10));
        this.field_25058_r.add(new SpawnListEntry(EntityZombie.class, 10));
        this.field_25058_r.add(new SpawnListEntry(EntitySkeleton.class, 10));
        this.field_25058_r.add(new SpawnListEntry(EntityCreeper.class, 10));
        this.field_25058_r.add(new SpawnListEntry(EntitySlime.class, 10));
        this.field_25057_s.add(new SpawnListEntry(EntitySheep.class, 12));
        this.field_25057_s.add(new SpawnListEntry(EntityPig.class, 10));
        this.field_25057_s.add(new SpawnListEntry(EntityChicken.class, 10));
        this.field_25057_s.add(new SpawnListEntry(EntityCow.class, 8));
        this.field_25056_t.add(new SpawnListEntry(EntitySquid.class, 10));
    }

    private BiomeGenBase func_27047_e() {
        this.field_27050_v = false;
        return this;
    }

    public static void func_4084_a() {
        for(int var0 = 0; var0 < 64; ++var0) {
            for(int var1 = 0; var1 < 64; ++var1) {
                field_4281_t[var0 + var1 * 64] = func_4078_a((float)var0 / 63.0F, (float)var1 / 63.0F);
            }
        }

        field_4293_h.field_4286_o = field_4293_h.field_4285_p = (byte)Block.field_590_F.field_573_bc;
        field_4291_j.field_4286_o = field_4291_j.field_4285_p = (byte)Block.field_590_F.field_573_bc;
    }

    public WorldGenerator func_21114_a(Random var1) {
        return (WorldGenerator)(var1.nextInt(10) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }

    protected BiomeGenBase func_4083_b() {
        this.field_27051_u = true;
        return this;
    }

    protected BiomeGenBase func_4082_a(String var1) {
        this.field_6163_m = var1;
        return this;
    }

    protected BiomeGenBase func_4080_a(int var1) {
        this.field_6161_q = var1;
        return this;
    }

    protected BiomeGenBase func_4079_b(int var1) {
        this.field_6162_n = var1;
        return this;
    }

    public static BiomeGenBase func_4085_a(double var0, double var2) {
        int var4 = (int)(var0 * 63.0D);
        int var5 = (int)(var2 * 63.0D);
        return field_4281_t[var4 + var5 * 64];
    }

    public static BiomeGenBase func_4078_a(float var0, float var1) {
        var1 *= var0;
        if (var0 < 0.1F) {
            return field_4290_k;
        } else if (var1 < 0.2F) {
            if (var0 < 0.5F) {
                return field_4290_k;
            } else {
                return var0 < 0.95F ? field_4296_e : field_4293_h;
            }
        } else if (var1 > 0.5F && var0 < 0.7F) {
            return field_4299_b;
        } else if (var0 < 0.5F) {
            return field_4294_g;
        } else if (var0 < 0.97F) {
            return var1 < 0.35F ? field_4295_f : field_4297_d;
        } else if (var1 < 0.45F) {
            return field_4292_i;
        } else {
            return var1 < 0.9F ? field_4298_c : field_4300_a;
        }
    }

    public List func_25055_a(EnumCreatureType var1) {
        if (var1 == EnumCreatureType.monster) {
            return this.field_25058_r;
        } else if (var1 == EnumCreatureType.creature) {
            return this.field_25057_s;
        } else {
            return var1 == EnumCreatureType.waterCreature ? this.field_25056_t : null;
        }
    }

    public boolean func_27049_c() {
        return this.field_27051_u;
    }

    public boolean func_27048_d() {
        return this.field_27051_u ? false : this.field_27050_v;
    }

    static {
        func_4084_a();
    }
}
