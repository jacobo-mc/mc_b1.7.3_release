package net.minecraft.src;

public class TileEntityMobSpawner extends TileEntity {
    public int field_829_a = -1;
    private String field_828_b = "Pig";
    public double field_831_c;
    public double field_830_d = 0.0D;

    public TileEntityMobSpawner() {
        this.field_829_a = 20;
    }

    public String func_21099_a() {
        return this.field_828_b;
    }

    public void func_21098_a(String var1) {
        this.field_828_b = var1;
    }

    public boolean func_484_a() {
        return this.field_824_e.func_683_a((double)this.field_823_f + 0.5D, (double)this.field_822_g + 0.5D, (double)this.field_821_h + 0.5D, 16.0D) != null;
    }

    public void func_475_b() {
        this.field_830_d = this.field_831_c;
        if (this.func_484_a()) {
            double var1 = (double)((float)this.field_823_f + this.field_824_e.field_1037_n.nextFloat());
            double var3 = (double)((float)this.field_822_g + this.field_824_e.field_1037_n.nextFloat());
            double var5 = (double)((float)this.field_821_h + this.field_824_e.field_1037_n.nextFloat());
            this.field_824_e.func_694_a("smoke", var1, var3, var5, 0.0D, 0.0D, 0.0D);
            this.field_824_e.func_694_a("flame", var1, var3, var5, 0.0D, 0.0D, 0.0D);

            for(this.field_831_c += (double)(1000.0F / ((float)this.field_829_a + 200.0F)); this.field_831_c > 360.0D; this.field_830_d -= 360.0D) {
                this.field_831_c -= 360.0D;
            }

            if (!this.field_824_e.field_1026_y) {
                if (this.field_829_a == -1) {
                    this.func_483_c();
                }

                if (this.field_829_a > 0) {
                    --this.field_829_a;
                    return;
                }

                byte var7 = 4;

                for(int var8 = 0; var8 < var7; ++var8) {
                    EntityLiving var9 = (EntityLiving)((EntityLiving)EntityList.func_1079_a(this.field_828_b, this.field_824_e));
                    if (var9 == null) {
                        return;
                    }

                    int var10 = this.field_824_e.func_657_a(var9.getClass(), AxisAlignedBB.func_1161_b((double)this.field_823_f, (double)this.field_822_g, (double)this.field_821_h, (double)(this.field_823_f + 1), (double)(this.field_822_g + 1), (double)(this.field_821_h + 1)).func_1177_b(8.0D, 4.0D, 8.0D)).size();
                    if (var10 >= 6) {
                        this.func_483_c();
                        return;
                    }

                    if (var9 != null) {
                        double var11 = (double)this.field_823_f + (this.field_824_e.field_1037_n.nextDouble() - this.field_824_e.field_1037_n.nextDouble()) * 4.0D;
                        double var13 = (double)(this.field_822_g + this.field_824_e.field_1037_n.nextInt(3) - 1);
                        double var15 = (double)this.field_821_h + (this.field_824_e.field_1037_n.nextDouble() - this.field_824_e.field_1037_n.nextDouble()) * 4.0D;
                        var9.func_365_c(var11, var13, var15, this.field_824_e.field_1037_n.nextFloat() * 360.0F, 0.0F);
                        if (var9.func_433_a()) {
                            this.field_824_e.func_674_a(var9);

                            for(int var17 = 0; var17 < 20; ++var17) {
                                var1 = (double)this.field_823_f + 0.5D + ((double)this.field_824_e.field_1037_n.nextFloat() - 0.5D) * 2.0D;
                                var3 = (double)this.field_822_g + 0.5D + ((double)this.field_824_e.field_1037_n.nextFloat() - 0.5D) * 2.0D;
                                var5 = (double)this.field_821_h + 0.5D + ((double)this.field_824_e.field_1037_n.nextFloat() - 0.5D) * 2.0D;
                                this.field_824_e.func_694_a("smoke", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                                this.field_824_e.func_694_a("flame", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                            }

                            var9.func_415_z();
                            this.func_483_c();
                        }
                    }
                }
            }

            super.func_475_b();
        }
    }

    private void func_483_c() {
        this.field_829_a = 200 + this.field_824_e.field_1037_n.nextInt(600);
    }

    public void func_482_a(NBTTagCompound var1) {
        super.func_482_a(var1);
        this.field_828_b = var1.func_755_i("EntityId");
        this.field_829_a = var1.func_745_d("Delay");
    }

    public void func_481_b(NBTTagCompound var1) {
        super.func_481_b(var1);
        var1.func_754_a("EntityId", this.field_828_b);
        var1.func_749_a("Delay", (short)this.field_829_a);
    }
}
