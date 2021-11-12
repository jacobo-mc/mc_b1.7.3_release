package net.minecraft.src;

import java.util.Random;

public class EntitySheep extends EntityAnimal {
    public static final float[][] field_21071_a = new float[][]{{1.0F, 1.0F, 1.0F}, {0.95F, 0.7F, 0.2F}, {0.9F, 0.5F, 0.85F}, {0.6F, 0.7F, 0.95F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.7F, 0.8F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.6F, 0.7F}, {0.7F, 0.4F, 0.9F}, {0.2F, 0.4F, 0.8F}, {0.5F, 0.4F, 0.3F}, {0.4F, 0.5F, 0.2F}, {0.8F, 0.3F, 0.3F}, {0.1F, 0.1F, 0.1F}};

    public EntitySheep(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/sheep.png";
        this.func_113_a(0.9F, 1.3F);
    }

    protected void func_21044_a() {
        super.func_21044_a();
        this.field_21045_af.func_21153_a(16, new Byte((byte)0));
    }

    public boolean func_121_a(Entity var1, int var2) {
        return super.func_121_a(var1, var2);
    }

    protected void func_21047_g_() {
        if (!this.func_21069_f_()) {
            this.func_21040_a(new ItemStack(Block.field_616_ac.field_573_bc, 1, this.func_21068_e_()), 0.0F);
        }

    }

    protected int func_149_g() {
        return Block.field_616_ac.field_573_bc;
    }

    public boolean func_6092_a(EntityPlayer var1) {
        ItemStack var2 = var1.field_416_aj.func_213_b();
        if (var2 != null && var2.field_855_c == Item.field_31022_bc.field_234_aS && !this.func_21069_f_()) {
            if (!this.field_9093_l.field_792_x) {
                this.func_21067_a(true);
                int var3 = 2 + this.field_9064_W.nextInt(3);

                for(int var4 = 0; var4 < var3; ++var4) {
                    EntityItem var5 = this.func_21040_a(new ItemStack(Block.field_616_ac.field_573_bc, 1, this.func_21068_e_()), 1.0F);
                    var5.field_318_p += (double)(this.field_9064_W.nextFloat() * 0.05F);
                    var5.field_319_o += (double)((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.1F);
                    var5.field_317_q += (double)((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.1F);
                }
            }

            var2.func_25125_a(1, var1);
        }

        return false;
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        var1.func_393_a("Sheared", this.func_21069_f_());
        var1.func_409_a("Color", (byte)this.func_21068_e_());
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        this.func_21067_a(var1.func_402_l("Sheared"));
        this.func_21070_a(var1.func_408_b("Color"));
    }

    protected String func_6097_d() {
        return "mob.sheep";
    }

    protected String func_6100_e() {
        return "mob.sheep";
    }

    protected String func_6098_f() {
        return "mob.sheep";
    }

    public int func_21068_e_() {
        return this.field_21045_af.func_21156_a(16) & 15;
    }

    public void func_21070_a(int var1) {
        byte var2 = this.field_21045_af.func_21156_a(16);
        this.field_21045_af.func_21155_b(16, (byte)(var2 & 240 | var1 & 15));
    }

    public boolean func_21069_f_() {
        return (this.field_21045_af.func_21156_a(16) & 16) != 0;
    }

    public void func_21067_a(boolean var1) {
        byte var2 = this.field_21045_af.func_21156_a(16);
        if (var1) {
            this.field_21045_af.func_21155_b(16, (byte)(var2 | 16));
        } else {
            this.field_21045_af.func_21155_b(16, (byte)(var2 & -17));
        }

    }

    public static int func_21066_a(Random var0) {
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
