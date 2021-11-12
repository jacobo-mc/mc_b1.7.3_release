package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockStairs extends Block {
    private Block field_651_a;

    protected BlockStairs(int var1, Block var2) {
        super(var1, var2.field_575_bb, var2.field_553_bn);
        this.field_651_a = var2;
        this.func_237_c(var2.field_571_bd);
        this.func_232_b(var2.field_569_be / 3.0F);
        this.func_4026_a(var2.field_555_bl);
        this.func_258_c(255);
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return super.func_248_d(var1, var2, var3, var4);
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public void func_264_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        int var7 = var1.func_446_b(var2, var3, var4);
        if (var7 == 0) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 1) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 2) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 3) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
            this.func_229_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.func_264_a(var1, var2, var3, var4, var5, var6);
        }

        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.field_651_a.func_235_b(var1, var2, var3, var4, var5);
    }

    public void func_251_a(World var1, int var2, int var3, int var4, int var5) {
        this.field_651_a.func_251_a(var1, var2, var3, var4, var5);
    }

    public float func_226_a(Entity var1) {
        return this.field_651_a.func_226_a(var1);
    }

    public int func_252_a(int var1, Random var2) {
        return this.field_651_a.func_252_a(var1, var2);
    }

    public int func_244_a(Random var1) {
        return this.field_651_a.func_244_a(var1);
    }

    public int func_22009_a(int var1, int var2) {
        return this.field_651_a.func_22009_a(var1, var2);
    }

    public int func_241_a(int var1) {
        return this.field_651_a.func_241_a(var1);
    }

    public int func_4028_b() {
        return this.field_651_a.func_4028_b();
    }

    public void func_230_a(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
        this.field_651_a.func_230_a(var1, var2, var3, var4, var5, var6);
    }

    public boolean func_245_e() {
        return this.field_651_a.func_245_e();
    }

    public boolean func_243_a(int var1, boolean var2) {
        return this.field_651_a.func_243_a(var1, var2);
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return this.field_651_a.func_259_a(var1, var2, var3, var4);
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        this.func_234_b(var1, var2, var3, var4, 0);
        this.field_651_a.func_250_e(var1, var2, var3, var4);
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        this.field_651_a.func_242_b(var1, var2, var3, var4);
    }

    public void func_227_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        this.field_651_a.func_227_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_249_b(World var1, int var2, int var3, int var4, Entity var5) {
        this.field_651_a.func_249_b(var1, var2, var3, var4, var5);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        this.field_651_a.func_221_a(var1, var2, var3, var4, var5);
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return this.field_651_a.func_246_a(var1, var2, var3, var4, var5);
    }

    public void func_4029_c(World var1, int var2, int var3, int var4) {
        this.field_651_a.func_4029_c(var1, var2, var3, var4);
    }

    public void func_4027_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.func_584_b((double)(var5.field_316_r * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            var1.func_511_b(var2, var3, var4, 2);
        }

        if (var6 == 1) {
            var1.func_511_b(var2, var3, var4, 1);
        }

        if (var6 == 2) {
            var1.func_511_b(var2, var3, var4, 3);
        }

        if (var6 == 3) {
            var1.func_511_b(var2, var3, var4, 0);
        }

    }
}
