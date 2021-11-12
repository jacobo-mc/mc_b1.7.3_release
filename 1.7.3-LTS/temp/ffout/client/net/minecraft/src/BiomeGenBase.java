package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BiomeGenBase {
    public static final BiomeGenBase field_4256_a = (new BiomeGenRainforest()).func_4123_b(588342).func_4125_a("Rainforest").func_4124_a(2094168);
    public static final BiomeGenBase field_4255_b = (new BiomeGenSwamp()).func_4123_b(522674).func_4125_a("Swampland").func_4124_a(9154376);
    public static final BiomeGenBase field_4254_c = (new BiomeGenBase()).func_4123_b(10215459).func_4125_a("Seasonal Forest");
    public static final BiomeGenBase field_4253_d = (new BiomeGenForest()).func_4123_b(353825).func_4125_a("Forest").func_4124_a(5159473);
    public static final BiomeGenBase field_4252_e = (new BiomeGenDesert()).func_4123_b(14278691).func_4125_a("Savanna");
    public static final BiomeGenBase field_4251_f = (new BiomeGenBase()).func_4123_b(10595616).func_4125_a("Shrubland");
    public static final BiomeGenBase field_4250_g = (new BiomeGenTaiga()).func_4123_b(3060051).func_4125_a("Taiga").func_4122_b().func_4124_a(8107825);
    public static final BiomeGenBase field_4249_h = (new BiomeGenDesert()).func_4123_b(16421912).func_4125_a("Desert").func_27076_e();
    public static final BiomeGenBase field_4248_i = (new BiomeGenDesert()).func_4123_b(16767248).func_4125_a("Plains");
    public static final BiomeGenBase field_4247_j = (new BiomeGenDesert()).func_4123_b(16772499).func_4125_a("Ice Desert").func_4122_b().func_27076_e().func_4124_a(12899129);
    public static final BiomeGenBase field_4246_k = (new BiomeGenBase()).func_4123_b(5762041).func_4125_a("Tundra").func_4122_b().func_4124_a(12899129);
    public static final BiomeGenBase field_4245_l = (new BiomeGenHell()).func_4123_b(16711680).func_4125_a("Hell").func_27076_e();
    public static final BiomeGenBase field_28057_m = (new BiomeGenSky()).func_4123_b(8421631).func_4125_a("Sky").func_27076_e();
    public String field_6504_m;
    public int field_6503_n;
    public byte field_4242_o;
    public byte field_4241_p;
    public int field_6502_q;
    protected List field_25066_r;
    protected List field_25065_s;
    protected List field_25064_t;
    private boolean field_27080_u;
    private boolean field_27079_v;
    private static BiomeGenBase[] field_4237_t = new BiomeGenBase[4096];

    protected BiomeGenBase() {
        this.field_4242_o = (byte)Block.field_337_v.field_376_bc;
        this.field_4241_p = (byte)Block.field_336_w.field_376_bc;
        this.field_6502_q = 5169201;
        this.field_25066_r = new ArrayList();
        this.field_25065_s = new ArrayList();
        this.field_25064_t = new ArrayList();
        this.field_27079_v = true;
        this.field_25066_r.add(new SpawnListEntry(EntitySpider.class, 10));
        this.field_25066_r.add(new SpawnListEntry(EntityZombie.class, 10));
        this.field_25066_r.add(new SpawnListEntry(EntitySkeleton.class, 10));
        this.field_25066_r.add(new SpawnListEntry(EntityCreeper.class, 10));
        this.field_25066_r.add(new SpawnListEntry(EntitySlime.class, 10));
        this.field_25065_s.add(new SpawnListEntry(EntitySheep.class, 12));
        this.field_25065_s.add(new SpawnListEntry(EntityPig.class, 10));
        this.field_25065_s.add(new SpawnListEntry(EntityChicken.class, 10));
        this.field_25065_s.add(new SpawnListEntry(EntityCow.class, 8));
        this.field_25064_t.add(new SpawnListEntry(EntitySquid.class, 10));
    }

    private BiomeGenBase func_27076_e() {
        this.field_27079_v = false;
        return this;
    }

    public static void func_4120_a() {
        for(int var0 = 0; var0 < 64; ++var0) {
            for(int var1 = 0; var1 < 64; ++var1) {
                field_4237_t[var0 + var1 * 64] = func_4119_a((float)var0 / 63.0F, (float)var1 / 63.0F);
            }
        }

        field_4249_h.field_4242_o = field_4249_h.field_4241_p = (byte)Block.field_393_F.field_376_bc;
        field_4247_j.field_4242_o = field_4247_j.field_4241_p = (byte)Block.field_393_F.field_376_bc;
    }

    public WorldGenerator func_21107_a(Random var1) {
        return (WorldGenerator)(var1.nextInt(10) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }

    protected BiomeGenBase func_4122_b() {
        this.field_27080_u = true;
        return this;
    }

    protected BiomeGenBase func_4125_a(String var1) {
        this.field_6504_m = var1;
        return this;
    }

    protected BiomeGenBase func_4124_a(int var1) {
        this.field_6502_q = var1;
        return this;
    }

    protected BiomeGenBase func_4123_b(int var1) {
        this.field_6503_n = var1;
        return this;
    }

    public static BiomeGenBase func_4121_a(double var0, double var2) {
        int var4 = (int)(var0 * 63.0D);
        int var5 = (int)(var2 * 63.0D);
        return field_4237_t[var4 + var5 * 64];
    }

    public static BiomeGenBase func_4119_a(float var0, float var1) {
        var1 *= var0;
        if (var0 < 0.1F) {
            return field_4246_k;
        } else if (var1 < 0.2F) {
            if (var0 < 0.5F) {
                return field_4246_k;
            } else {
                return var0 < 0.95F ? field_4252_e : field_4249_h;
            }
        } else if (var1 > 0.5F && var0 < 0.7F) {
            return field_4255_b;
        } else if (var0 < 0.5F) {
            return field_4250_g;
        } else if (var0 < 0.97F) {
            return var1 < 0.35F ? field_4251_f : field_4253_d;
        } else if (var1 < 0.45F) {
            return field_4248_i;
        } else {
            return var1 < 0.9F ? field_4254_c : field_4256_a;
        }
    }

    public int func_4126_a(float var1) {
        var1 /= 3.0F;
        if (var1 < -1.0F) {
            var1 = -1.0F;
        }

        if (var1 > 1.0F) {
            var1 = 1.0F;
        }

        return Color.getHSBColor(0.62222224F - var1 * 0.05F, 0.5F + var1 * 0.1F, 1.0F).getRGB();
    }

    public List func_25063_a(EnumCreatureType var1) {
        if (var1 == EnumCreatureType.monster) {
            return this.field_25066_r;
        } else if (var1 == EnumCreatureType.creature) {
            return this.field_25065_s;
        } else {
            return var1 == EnumCreatureType.waterCreature ? this.field_25064_t : null;
        }
    }

    public boolean func_27078_c() {
        return this.field_27080_u;
    }

    public boolean func_27077_d() {
        return this.field_27080_u ? false : this.field_27079_v;
    }

    static {
        func_4120_a();
    }
}
