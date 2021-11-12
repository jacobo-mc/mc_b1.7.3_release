package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class RenderManager {
    private Map field_6501_o = new HashMap();
    public static RenderManager field_1233_a = new RenderManager();
    private FontRenderer field_1218_p;
    public static double field_1232_b;
    public static double field_1231_c;
    public static double field_1230_d;
    public RenderEngine field_1229_e;
    public ItemRenderer field_4236_f;
    public World field_1227_g;
    public EntityLiving field_22188_h;
    public float field_1225_i;
    public float field_1224_j;
    public GameSettings field_1223_k;
    public double field_1222_l;
    public double field_1221_m;
    public double field_1220_n;

    private RenderManager() {
        this.field_6501_o.put(EntitySpider.class, new RenderSpider());
        this.field_6501_o.put(EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
        this.field_6501_o.put(EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        this.field_6501_o.put(EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
        this.field_6501_o.put(EntityWolf.class, new RenderWolf(new ModelWolf(), 0.5F));
        this.field_6501_o.put(EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
        this.field_6501_o.put(EntityCreeper.class, new RenderCreeper());
        this.field_6501_o.put(EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5F));
        this.field_6501_o.put(EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
        this.field_6501_o.put(EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
        this.field_6501_o.put(EntityPlayer.class, new RenderPlayer());
        this.field_6501_o.put(EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6.0F));
        this.field_6501_o.put(EntityGhast.class, new RenderGhast());
        this.field_6501_o.put(EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
        this.field_6501_o.put(EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5F));
        this.field_6501_o.put(Entity.class, new RenderEntity());
        this.field_6501_o.put(EntityPainting.class, new RenderPainting());
        this.field_6501_o.put(EntityArrow.class, new RenderArrow());
        this.field_6501_o.put(EntitySnowball.class, new RenderSnowball(Item.field_308_aB.func_27009_a(0)));
        this.field_6501_o.put(EntityEgg.class, new RenderSnowball(Item.field_296_aN.func_27009_a(0)));
        this.field_6501_o.put(EntityFireball.class, new RenderFireball());
        this.field_6501_o.put(EntityItem.class, new RenderItem());
        this.field_6501_o.put(EntityTNTPrimed.class, new RenderTNTPrimed());
        this.field_6501_o.put(EntityFallingSand.class, new RenderFallingSand());
        this.field_6501_o.put(EntityMinecart.class, new RenderMinecart());
        this.field_6501_o.put(EntityBoat.class, new RenderBoat());
        this.field_6501_o.put(EntityFish.class, new RenderFish());
        this.field_6501_o.put(EntityLightningBolt.class, new RenderLightningBolt());
        Iterator var1 = this.field_6501_o.values().iterator();

        while(var1.hasNext()) {
            Render var2 = (Render)var1.next();
            var2.func_4009_a(this);
        }

    }

    public Render func_4117_a(Class var1) {
        Render var2 = (Render)this.field_6501_o.get(var1);
        if (var2 == null && var1 != Entity.class) {
            var2 = this.func_4117_a(var1.getSuperclass());
            this.field_6501_o.put(var1, var2);
        }

        return var2;
    }

    public Render func_855_a(Entity var1) {
        return this.func_4117_a(var1.getClass());
    }

    public void func_22187_a(World var1, RenderEngine var2, FontRenderer var3, EntityLiving var4, GameSettings var5, float var6) {
        this.field_1227_g = var1;
        this.field_1229_e = var2;
        this.field_1223_k = var5;
        this.field_22188_h = var4;
        this.field_1218_p = var3;
        if (var4.func_22051_K()) {
            int var7 = var1.func_600_a(MathHelper.func_1108_b(var4.field_611_ak), MathHelper.func_1108_b(var4.field_610_al), MathHelper.func_1108_b(var4.field_609_am));
            if (var7 == Block.field_9262_S.field_376_bc) {
                int var8 = var1.func_602_e(MathHelper.func_1108_b(var4.field_611_ak), MathHelper.func_1108_b(var4.field_610_al), MathHelper.func_1108_b(var4.field_609_am));
                int var9 = var8 & 3;
                this.field_1225_i = (float)(var9 * 90 + 180);
                this.field_1224_j = 0.0F;
            }
        } else {
            this.field_1225_i = var4.field_603_as + (var4.field_605_aq - var4.field_603_as) * var6;
            this.field_1224_j = var4.field_602_at + (var4.field_604_ar - var4.field_602_at) * var6;
        }

        this.field_1222_l = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)var6;
        this.field_1221_m = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)var6;
        this.field_1220_n = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)var6;
    }

    public void func_854_a(Entity var1, float var2) {
        double var3 = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * (double)var2;
        double var5 = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * (double)var2;
        double var7 = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * (double)var2;
        float var9 = var1.field_603_as + (var1.field_605_aq - var1.field_603_as) * var2;
        float var10 = var1.func_382_a(var2);
        GL11.glColor3f(var10, var10, var10);
        this.func_853_a(var1, var3 - field_1232_b, var5 - field_1231_c, var7 - field_1230_d, var9, var2);
    }

    public void func_853_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        Render var10 = this.func_855_a(var1);
        if (var10 != null) {
            var10.func_147_a(var1, var2, var4, var6, var8, var9);
            var10.func_141_b(var1, var2, var4, var6, var8, var9);
        }

    }

    public void func_852_a(World var1) {
        this.field_1227_g = var1;
    }

    public double func_851_a(double var1, double var3, double var5) {
        double var7 = var1 - this.field_1222_l;
        double var9 = var3 - this.field_1221_m;
        double var11 = var5 - this.field_1220_n;
        return var7 * var7 + var9 * var9 + var11 * var11;
    }

    public FontRenderer func_6500_a() {
        return this.field_1218_p;
    }
}
