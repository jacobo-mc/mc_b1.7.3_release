package net.minecraft.src;

import java.util.Random;

public class BlockCake extends Block {
    protected BlockCake(int var1, int var2) {
        super(var1, var2, Material.field_21100_y);
        this.func_231_a(true);
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        this.func_229_a(var7, 0.0F, var6, 1.0F - var6, var8, 1.0F - var6);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        return AxisAlignedBB.func_693_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var6), (double)((float)(var2 + 1) - var6), (double)((float)var3 + var8 - var6), (double)((float)(var4 + 1) - var6));
    }

    public int func_22009_a(int var1, int var2) {
        if (var1 == 1) {
            return this.field_575_bb;
        } else if (var1 == 0) {
            return this.field_575_bb + 3;
        } else {
            return var2 > 0 && var1 == 4 ? this.field_575_bb + 2 : this.field_575_bb + 1;
        }
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb;
        } else {
            return var1 == 0 ? this.field_575_bb + 3 : this.field_575_bb + 1;
        }
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_21030_c(var1, var2, var3, var4, var5);
        return true;
    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_21030_c(var1, var2, var3, var4, var5);
    }

    private void func_21030_c(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var5.field_9109_aQ < 20) {
            var5.func_137_a(3);
            int var6 = var1.func_446_b(var2, var3, var4) + 1;
            if (var6 >= 6) {
                var1.func_508_d(var2, var3, var4, 0);
            } else {
                var1.func_511_b(var2, var3, var4, var6);
                var1.func_21119_h(var2, var3, var4);
            }
        }

    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return !super.func_259_a(var1, var2, var3, var4) ? false : this.func_220_f(var1, var2, var3, var4);
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!this.func_220_f(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

    }

    public boolean func_220_f(World var1, int var2, int var3, int var4) {
        return var1.func_443_c(var2, var3 - 1, var4).func_216_a();
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public int func_252_a(int var1, Random var2) {
        return 0;
    }
}
