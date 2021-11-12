package net.minecraft.src;

import java.util.Random;

public class EntitySheep extends EntityAnimal {
    public static final float[][] field_21075_a = new float[][]{{1.0F, 1.0F, 1.0F}, {0.95F, 0.7F, 0.2F}, {0.9F, 0.5F, 0.85F}, {0.6F, 0.7F, 0.95F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.7F, 0.8F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.6F, 0.7F}, {0.7F, 0.4F, 0.9F}, {0.2F, 0.4F, 0.8F}, {0.5F, 0.4F, 0.3F}, {0.4F, 0.5F, 0.2F}, {0.8F, 0.3F, 0.3F}, {0.1F, 0.1F, 0.1F}};

    public EntitySheep(World var1) {
        super(var1);
        this.field_9357_z = "/mob/sheep.png";
        this.func_371_a(0.9F, 1.3F);
    }

    protected void func_21057_b() {
        super.func_21057_b();
        this.field_21064_bx.func_21124_a(16, new Byte((byte)0));
    }

    public boolean func_396_a(Entity var1, int var2) {
        return super.func_396_a(var1, var2);
    }

    protected void func_21066_o() {
        if (!this.func_21072_p()) {
            this.func_21058_a(new ItemStack(Block.field_419_ac.field_376_bc, 1, this.func_21074_p_()), 0.0F);
        }

    }

    protected int func_422_g() {
        return Block.field_419_ac.field_376_bc;
    }

    public boolean func_353_a(EntityPlayer var1) {
        ItemStack var2 = var1.field_778_b.func_494_a();
        if (var2 != null && var2.field_1617_c == Item.field_31001_bc.field_291_aS && !this.func_21072_p()) {
            if (!this.field_615_ag.field_1026_y) {
                this.func_21073_a(true);
                int var3 = 2 + this.field_9312_bd.nextInt(3);

                for(int var4 = 0; var4 < var3; ++var4) {
                    EntityItem var5 = this.func_21058_a(new ItemStack(Block.field_419_ac.field_376_bc, 1, this.func_21074_p_()), 1.0F);
                    var5.field_607_ao += (double)(this.field_9312_bd.nextFloat() * 0.05F);
                    var5.field_608_an += (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.1F);
                    var5.field_606_ap += (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.1F);
                }
            }

            var2.func_25190_a(1, var1);
        }

        return false;
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_748_a("Sheared", this.func_21072_p());
        var1.func_761_a("Color", (byte)this.func_21074_p_());
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.func_21073_a(var1.func_760_m("Sheared"));
        this.func_21071_b_(var1.func_746_c("Color"));
    }

    protected String func_6389_d() {
        return "mob.sheep";
    }

    protected String func_6394_f_() {
        return "mob.sheep";
    }

    protected String func_6390_f() {
        return "mob.sheep";
    }

    public int func_21074_p_() {
        return this.field_21064_bx.func_21130_a(16) & 15;
    }

    public void func_21071_b_(int var1) {
        byte var2 = this.field_21064_bx.func_21130_a(16);
        this.field_21064_bx.func_21129_b(16, (byte)(var2 & 240 | var1 & 15));
    }

    public boolean func_21072_p() {
        return (this.field_21064_bx.func_21130_a(16) & 16) != 0;
    }

    public void func_21073_a(boolean var1) {
        byte var2 = this.field_21064_bx.func_21130_a(16);
        if (var1) {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 | 16));
        } else {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 & -17));
        }

    }

    public static int func_21070_a(Random var0) {
        int var1 = var0.nextInt(100);
        if (var1 < 5) {
            return 15;
        } else if (var1 < 10) {
            return 7;
        } else if (var1 < 15) {
            return 8;
        } else if (var1 < 18) {
            return 12;
        } else {
            return var0.nextInt(500) == 0 ? 6 : 0;
        }
    }
}
