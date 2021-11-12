package net.minecraft.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityTrackerEntry {
    public Entity field_909_a;
    public int field_9235_d;
    public int field_9234_e;
    public int field_9233_f;
    public int field_9232_g;
    public int field_9231_h;
    public int field_9230_i;
    public int field_9229_j;
    public double field_9228_k;
    public double field_9227_l;
    public double field_9226_m;
    public int field_9221_t = 0;
    private double field_9224_q;
    private double field_9223_r;
    private double field_9222_s;
    private boolean field_12020_u = false;
    private boolean field_9220_u;
    private int field_28165_t = 0;
    public boolean field_900_j = false;
    public Set field_899_k = new HashSet();

    public EntityTrackerEntry(Entity var1, int var2, int var3, boolean var4) {
        this.field_909_a = var1;
        this.field_9235_d = var2;
        this.field_9234_e = var3;
        this.field_9220_u = var4;
        this.field_9233_f = MathHelper.func_584_b(var1.field_322_l * 32.0D);
        this.field_9232_g = MathHelper.func_584_b(var1.field_321_m * 32.0D);
        this.field_9231_h = MathHelper.func_584_b(var1.field_320_n * 32.0D);
        this.field_9230_i = MathHelper.func_588_d(var1.field_316_r * 256.0F / 360.0F);
        this.field_9229_j = MathHelper.func_588_d(var1.field_315_s * 256.0F / 360.0F);
    }

    public boolean equals(Object var1) {
        if (var1 instanceof EntityTrackerEntry) {
            return ((EntityTrackerEntry)var1).field_909_a.field_331_c == this.field_909_a.field_331_c;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.field_909_a.field_331_c;
    }

    public void func_605_a(List var1) {
        this.field_900_j = false;
        if (!this.field_12020_u || this.field_909_a.func_101_d(this.field_9224_q, this.field_9223_r, this.field_9222_s) > 16.0D) {
            this.field_9224_q = this.field_909_a.field_322_l;
            this.field_9223_r = this.field_909_a.field_321_m;
            this.field_9222_s = this.field_909_a.field_320_n;
            this.field_12020_u = true;
            this.field_900_j = true;
            this.func_601_b(var1);
        }

        ++this.field_28165_t;
        if (++this.field_9221_t % this.field_9234_e == 0) {
            int var2 = MathHelper.func_584_b(this.field_909_a.field_322_l * 32.0D);
            int var3 = MathHelper.func_584_b(this.field_909_a.field_321_m * 32.0D);
            int var4 = MathHelper.func_584_b(this.field_909_a.field_320_n * 32.0D);
            int var5 = MathHelper.func_588_d(this.field_909_a.field_316_r * 256.0F / 360.0F);
            int var6 = MathHelper.func_588_d(this.field_909_a.field_315_s * 256.0F / 360.0F);
            int var7 = var2 - this.field_9233_f;
            int var8 = var3 - this.field_9232_g;
            int var9 = var4 - this.field_9231_h;
            Object var10 = null;
            boolean var11 = Math.abs(var2) >= 8 || Math.abs(var3) >= 8 || Math.abs(var4) >= 8;
            boolean var12 = Math.abs(var5 - this.field_9230_i) >= 8 || Math.abs(var6 - this.field_9229_j) >= 8;
            if (var7 >= -128 && var7 < 128 && var8 >= -128 && var8 < 128 && var9 >= -128 && var9 < 128 && this.field_28165_t <= 400) {
                if (var11 && var12) {
                    var10 = new Packet33RelEntityMoveLook(this.field_909_a.field_331_c, (byte)var7, (byte)var8, (byte)var9, (byte)var5, (byte)var6);
                } else if (var11) {
                    var10 = new Packet31RelEntityMove(this.field_909_a.field_331_c, (byte)var7, (byte)var8, (byte)var9);
                } else if (var12) {
                    var10 = new Packet32EntityLook(this.field_909_a.field_331_c, (byte)var5, (byte)var6);
                }
            } else {
                this.field_28165_t = 0;
                this.field_909_a.field_322_l = (double)var2 / 32.0D;
                this.field_909_a.field_321_m = (double)var3 / 32.0D;
                this.field_909_a.field_320_n = (double)var4 / 32.0D;
                var10 = new Packet34EntityTeleport(this.field_909_a.field_331_c, var2, var3, var4, (byte)var5, (byte)var6);
            }

            if (this.field_9220_u) {
                double var13 = this.field_909_a.field_319_o - this.field_9228_k;
                double var15 = this.field_909_a.field_318_p - this.field_9227_l;
                double var17 = this.field_909_a.field_317_q - this.field_9226_m;
                double var19 = 0.02D;
                double var21 = var13 * var13 + var15 * var15 + var17 * var17;
                if (var21 > var19 * var19 || var21 > 0.0D && this.field_909_a.field_319_o == 0.0D && this.field_909_a.field_318_p == 0.0D && this.field_909_a.field_317_q == 0.0D) {
                    this.field_9228_k = this.field_909_a.field_319_o;
                    this.field_9227_l = this.field_909_a.field_318_p;
                    this.field_9226_m = this.field_909_a.field_317_q;
                    this.func_603_a(new Packet28EntityVelocity(this.field_909_a.field_331_c, this.field_9228_k, this.field_9227_l, this.field_9226_m));
                }
            }

            if (var10 != null) {
                this.func_603_a((Packet)var10);
            }

            DataWatcher var23 = this.field_909_a.func_21039_p();
            if (var23.func_21150_a()) {
                this.func_12018_b(new Packet40EntityMetadata(this.field_909_a.field_331_c, var23));
            }

            if (var11) {
                this.field_9233_f = var2;
                this.field_9232_g = var3;
                this.field_9231_h = var4;
            }

            if (var12) {
                this.field_9230_i = var5;
                this.field_9229_j = var6;
            }
        }

        if (this.field_909_a.field_9078_E) {
            this.func_12018_b(new Packet28EntityVelocity(this.field_909_a));
            this.field_909_a.field_9078_E = false;
        }

    }

    public void func_603_a(Packet var1) {
        Iterator var2 = this.field_899_k.iterator();

        while(var2.hasNext()) {
            EntityPlayerMP var3 = (EntityPlayerMP)var2.next();
            var3.field_20908_a.func_39_b(var1);
        }

    }

    public void func_12018_b(Packet var1) {
        this.func_603_a(var1);
        if (this.field_909_a instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this.field_909_a).field_20908_a.func_39_b(var1);
        }

    }

    public void func_604_a() {
        this.func_603_a(new Packet29DestroyEntity(this.field_909_a.field_331_c));
    }

    public void func_12019_a(EntityPlayerMP var1) {
        if (this.field_899_k.contains(var1)) {
            this.field_899_k.remove(var1);
        }

    }

    public void func_606_a(EntityPlayerMP var1) {
        if (var1 != this.field_909_a) {
            double var2 = var1.field_322_l - (double)(this.field_9233_f / 32);
            double var4 = var1.field_320_n - (double)(this.field_9231_h / 32);
            if (var2 >= (double)(-this.field_9235_d) && var2 <= (double)this.field_9235_d && var4 >= (double)(-this.field_9235_d) && var4 <= (double)this.field_9235_d) {
                if (!this.field_899_k.contains(var1)) {
                    this.field_899_k.add(var1);
                    var1.field_20908_a.func_39_b(this.func_602_b());
                    if (this.field_9220_u) {
                        var1.field_20908_a.func_39_b(new Packet28EntityVelocity(this.field_909_a.field_331_c, this.field_909_a.field_319_o, this.field_909_a.field_318_p, this.field_909_a.field_317_q));
                    }

                    ItemStack[] var6 = this.field_909_a.func_20042_E();
                    if (var6 != null) {
                        for(int var7 = 0; var7 < var6.length; ++var7) {
                            var1.field_20908_a.func_39_b(new Packet5PlayerInventory(this.field_909_a.field_331_c, var7, var6[var7]));
                        }
                    }

                    if (this.field_909_a instanceof EntityPlayer) {
                        EntityPlayer var8 = (EntityPlayer)this.field_909_a;
                        if (var8.func_22057_E()) {
                            var1.field_20908_a.func_39_b(new Packet17Sleep(this.field_909_a, 0, MathHelper.func_584_b(this.field_909_a.field_322_l), MathHelper.func_584_b(this.field_909_a.field_321_m), MathHelper.func_584_b(this.field_909_a.field_320_n)));
                        }
                    }
                }
            } else if (this.field_899_k.contains(var1)) {
                this.field_899_k.remove(var1);
                var1.field_20908_a.func_39_b(new Packet29DestroyEntity(this.field_909_a.field_331_c));
            }

        }
    }

    public void func_601_b(List var1) {
        for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.func_606_a((EntityPlayerMP)var1.get(var2));
        }

    }

    private Packet func_602_b() {
        if (this.field_909_a instanceof EntityItem) {
            EntityItem var6 = (EntityItem)this.field_909_a;
            Packet21PickupSpawn var7 = new Packet21PickupSpawn(var6);
            var6.field_322_l = (double)var7.field_128_b / 32.0D;
            var6.field_321_m = (double)var7.field_127_c / 32.0D;
            var6.field_320_n = (double)var7.field_126_d / 32.0D;
            return var7;
        } else if (this.field_909_a instanceof EntityPlayerMP) {
            return new Packet20NamedEntitySpawn((EntityPlayer)this.field_909_a);
        } else {
            if (this.field_909_a instanceof EntityMinecart) {
                EntityMinecart var1 = (EntityMinecart)this.field_909_a;
                if (var1.field_476_ae == 0) {
                    return new Packet23VehicleSpawn(this.field_909_a, 10);
                }

                if (var1.field_476_ae == 1) {
                    return new Packet23VehicleSpawn(this.field_909_a, 11);
                }

                if (var1.field_476_ae == 2) {
                    return new Packet23VehicleSpawn(this.field_909_a, 12);
                }
            }

            if (this.field_909_a instanceof EntityBoat) {
                return new Packet23VehicleSpawn(this.field_909_a, 1);
            } else if (this.field_909_a instanceof IAnimals) {
                return new Packet24MobSpawn((EntityLiving)this.field_909_a);
            } else if (this.field_909_a instanceof EntityFish) {
                return new Packet23VehicleSpawn(this.field_909_a, 90);
            } else if (this.field_909_a instanceof EntityArrow) {
                EntityLiving var5 = ((EntityArrow)this.field_909_a).field_439_ah;
                return new Packet23VehicleSpawn(this.field_909_a, 60, var5 != null ? var5.field_331_c : this.field_909_a.field_331_c);
            } else if (this.field_909_a instanceof EntitySnowball) {
                return new Packet23VehicleSpawn(this.field_909_a, 61);
            } else if (this.field_909_a instanceof EntityFireball) {
                EntityFireball var4 = (EntityFireball)this.field_909_a;
                Packet23VehicleSpawn var2 = new Packet23VehicleSpawn(this.field_909_a, 63, ((EntityFireball)this.field_909_a).field_9191_am.field_331_c);
                var2.field_28044_e = (int)(var4.field_9199_b * 8000.0D);
                var2.field_28043_f = (int)(var4.field_9198_c * 8000.0D);
                var2.field_28042_g = (int)(var4.field_9196_d * 8000.0D);
                return var2;
            } else if (this.field_909_a instanceof EntityEgg) {
                return new Packet23VehicleSpawn(this.field_909_a, 62);
            } else if (this.field_909_a instanceof EntityTNTPrimed) {
                return new Packet23VehicleSpawn(this.field_909_a, 50);
            } else {
                if (this.field_909_a instanceof EntityFallingSand) {
                    EntityFallingSand var3 = (EntityFallingSand)this.field_909_a;
                    if (var3.field_427_a == Block.field_590_F.field_573_bc) {
                        return new Packet23VehicleSpawn(this.field_909_a, 70);
                    }

                    if (var3.field_427_a == Block.field_4062_G.field_573_bc) {
                        return new Packet23VehicleSpawn(this.field_909_a, 71);
                    }
                }

                if (this.field_909_a instanceof EntityPainting) {
                    return new Packet25EntityPainting((EntityPainting)this.field_909_a);
                } else {
                    throw new IllegalArgumentException("Don't know how to add " + this.field_909_a.getClass() + "!");
                }
            }
        }
    }

    public void func_9219_b(EntityPlayerMP var1) {
        if (this.field_899_k.contains(var1)) {
            this.field_899_k.remove(var1);
            var1.field_20908_a.func_39_b(new Packet29DestroyEntity(this.field_909_a.field_331_c));
        }

    }
}
