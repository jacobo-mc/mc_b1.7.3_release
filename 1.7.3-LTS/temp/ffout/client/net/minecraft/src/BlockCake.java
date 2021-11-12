package net.minecraft.src;

import java.util.Random;

public class BlockCake extends Block {
    protected BlockCake(int var1, int var2) {
        super(var1, var2, Material.field_21150_y);
        this.func_253_b(true);
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        this.func_213_a(var7, 0.0F, var6, 1.0F - var6, var8, 1.0F - var6);
    }

    public void func_237_e() {
        float var1 = 0.0625F;
        float var2 = 0.5F;
        this.func_213_a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        return AxisAlignedBB.func_1161_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var6), (double)((float)(var2 + 1) - var6), (double)((float)var3 + var8 - var6), (double)((float)(var4 + 1) - var6));
    }

    public AxisAlignedBB func_246_f(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        return AxisAlignedBB.func_1161_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var6), (double)((float)(var2 + 1) - var6), (double)((float)var3 + var8), (double)((float)(var4 + 1) - var6));
    }

    public int func_232_a(int var1, int var2) {
        if (var1 == 1) {
            return this.field_378_bb;
        } else if (var1 == 0) {
            return this.field_378_bb + 3;
        } else {
            return var2 > 0 && var1 == 4 ? this.field_378_bb + 2 : this.field_378_bb + 1;
        }
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb;
        } else {
            return var1 == 0 ? this.field_378_bb + 3 : this.field_378_bb + 1;
        }
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_21029_c(var1, var2, var3, var4, var5);
        return true;
    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_21029_c(var1, var2, var3, var4, var5);
    }

    private void func_21029_c(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var5.field_9337_J < 20) {
            var5.func_432_b(3);
            int var6 = var1.func_602_e(var2, var3, var4) + 1;
            if (var6 >= 6) {
                var1.func_690_d(var2, var3, var4, 0);
            } else {
                var1.func_691_b(var2, var3, var4, var6);
                var1.func_21115_j(var2, var3, var4);
            }
        }

    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return !super.func_243_a(var1, var2, var3, var4) ? false : this.func_223_g(var1, var2, var3, var4);
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!this.func_223_g(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public boolean func_223_g(World var1, int var2, int var3, int var4) {
        return var1.func_599_f(var2, var3 - 1, var4).func_878_a();
    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public int func_240_a(int var1, Random var2) {
        return 0;
    }
}
