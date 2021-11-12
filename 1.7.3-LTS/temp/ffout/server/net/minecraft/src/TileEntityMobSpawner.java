package net.minecraft.src;

public class TileEntityMobSpawner extends TileEntity {
    public int field_493_e = -1;
    private String field_492_f = "Pig";
    public double field_491_g;
    public double field_490_h = 0.0D;

    public TileEntityMobSpawner() {
        this.field_493_e = 20;
    }

    public void func_21078_a(String var1) {
        this.field_492_f = var1;
    }

    public boolean func_195_a() {
        return this.field_479_a.func_456_a((double)this.field_478_b + 0.5D, (double)this.field_483_c + 0.5D, (double)this.field_482_d + 0.5D, 16.0D) != null;
    }

    public void func_184_b() {
        this.field_490_h = this.field_491_g;
        if (this.func_195_a()) {
            double var1 = (double)((float)this.field_478_b + this.field_479_a.field_803_m.nextFloat());
            double var3 = (double)((float)this.field_483_c + this.field_479_a.field_803_m.nextFloat());
            double var5 = (double)((float)this.field_482_d + this.field_479_a.field_803_m.nextFloat());
            this.field_479_a.func_514_a("smoke", var1, var3, var5, 0.0D, 0.0D, 0.0D);
            this.field_479_a.func_514_a("flame", var1, var3, var5, 0.0D, 0.0D, 0.0D);

            for(this.field_491_g += (double)(1000.0F / ((float)this.field_493_e + 200.0F)); this.field_491_g > 360.0D; this.field_490_h -= 360.0D) {
                this.field_491_g -= 360.0D;
            }

            if (!this.field_479_a.field_792_x) {
                if (this.field_493_e == -1) {
                    this.func_196_d();
                }

                if (this.field_493_e > 0) {
                    --this.field_493_e;
                    return;
                }

                byte var7 = 4;

                for(int var8 = 0; var8 < var7; ++var8) {
                    EntityLiving var9 = (EntityLiving)((EntityLiving)EntityList.func_567_a(this.field_492_f, this.field_479_a));
                    if (var9 == null) {
                        return;
                    }

                    int var10 = this.field_479_a.func_457_a(var9.getClass(), AxisAlignedBB.func_693_b((double)this.field_478_b, (double)this.field_483_c, (double)this.field_482_d, (double)(this.field_478_b + 1), (double)(this.field_483_c + 1), (double)(this.field_482_d + 1)).func_708_b(8.0D, 4.0D, 8.0D)).size();
                    if (var10 >= 6) {
                        this.func_196_d();
                        return;
                    }

                    if (var9 != null) {
                        double var11 = (double)this.field_478_b + (this.field_479_a.field_803_m.nextDouble() - this.field_479_a.field_803_m.nextDouble()) * 4.0D;
                        double var13 = (double)(this.field_483_c + this.field_479_a.field_803_m.nextInt(3) - 1);
                        double var15 = (double)this.field_482_d + (this.field_479_a.field_803_m.nextDouble() - this.field_479_a.field_803_m.nextDouble()) * 4.0D;
                        var9.func_107_c(var11, var13, var15, this.field_479_a.field_803_m.nextFloat() * 360.0F, 0.0F);
                        if (var9.func_155_a()) {
                            this.field_479_a.func_526_a(var9);

                            for(int var17 = 0; var17 < 20; ++var17) {
                                var1 = (double)this.field_478_b + 0.5D + ((double)this.field_479_a.field_803_m.nextFloat() - 0.5D) * 2.0D;
                                var3 = (double)this.field_483_c + 0.5D + ((double)this.field_479_a.field_803_m.nextFloat() - 0.5D) * 2.0D;
                                var5 = (double)this.field_482_d + 0.5D + ((double)this.field_479_a.field_803_m.nextFloat() - 0.5D) * 2.0D;
                                this.field_479_a.func_514_a("smoke", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                                this.field_479_a.func_514_a("flame", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                            }

                            var9.func_156_D();
                            this.func_196_d();
                        }
                    }
                }
            }

            super.func_184_b();
        }
    }

    private void func_196_d() {
        this.field_493_e = 200 + this.field_479_a.field_803_m.nextInt(600);
    }

    public void func_186_a(NBTTagCompound var1) {
        super.func_186_a(var1);
        this.field_492_f = var1.func_401_h("EntityId");
        this.field_493_e = var1.func_406_c("Delay");
    }

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        var1.func_403_a("EntityId", this.field_492_f);
        var1.func_394_a("Delay", (short)this.field_493_e);
    }
}
