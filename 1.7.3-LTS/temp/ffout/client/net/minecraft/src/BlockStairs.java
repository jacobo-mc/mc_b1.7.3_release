package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockStairs extends Block {
    private Block field_452_a;

    protected BlockStairs(int var1, Block var2) {
        super(var1, var2.field_378_bb, var2.field_356_bn);
        this.field_452_a = var2;
        this.func_222_c(var2.field_374_bd);
        this.func_219_b(var2.field_372_be / 3.0F);
        this.func_4024_a(var2.field_358_bl);
        this.func_256_d(255);
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return super.func_221_d(var1, var2, var3, var4);
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 10;
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return super.func_260_c(var1, var2, var3, var4, var5);
    }

    public void func_230_a(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        int var7 = var1.func_602_e(var2, var3, var4);
        if (var7 == 0) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 1) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 2) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 3) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
            this.func_213_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.func_230_a(var1, var2, var3, var4, var5, var6);
        }

        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        this.field_452_a.func_247_b(var1, var2, var3, var4, var5);
    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.field_452_a.func_233_b(var1, var2, var3, var4, var5);
    }

    public void func_252_b(World var1, int var2, int var3, int var4, int var5) {
        this.field_452_a.func_252_b(var1, var2, var3, var4, var5);
    }

    public float func_241_c(IBlockAccess var1, int var2, int var3, int var4) {
        return this.field_452_a.func_241_c(var1, var2, var3, var4);
    }

    public float func_227_a(Entity var1) {
        return this.field_452_a.func_227_a(var1);
    }

    public int func_234_g() {
        return this.field_452_a.func_234_g();
    }

    public int func_240_a(int var1, Random var2) {
        return this.field_452_a.func_240_a(var1, var2);
    }

    public int func_229_a(Random var1) {
        return this.field_452_a.func_229_a(var1);
    }

    public int func_232_a(int var1, int var2) {
        return this.field_452_a.func_232_a(var1, var2);
    }

    public int func_218_a(int var1) {
        return this.field_452_a.func_218_a(var1);
    }

    public int func_211_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return this.field_452_a.func_211_a(var1, var2, var3, var4, var5);
    }

    public int func_4025_d() {
        return this.field_452_a.func_4025_d();
    }

    public AxisAlignedBB func_246_f(World var1, int var2, int var3, int var4) {
        return this.field_452_a.func_246_f(var1, var2, var3, var4);
    }

    public void func_257_a(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
        this.field_452_a.func_257_a(var1, var2, var3, var4, var5, var6);
    }

    public boolean func_245_h() {
        return this.field_452_a.func_245_h();
    }

    public boolean func_224_a(int var1, boolean var2) {
        return this.field_452_a.func_224_a(var1, var2);
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return this.field_452_a.func_243_a(var1, var2, var3, var4);
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        this.func_226_a(var1, var2, var3, var4, 0);
        this.field_452_a.func_235_e(var1, var2, var3, var4);
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        this.field_452_a.func_214_b(var1, var2, var3, var4);
    }

    public void func_216_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        this.field_452_a.func_216_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_254_a(World var1, int var2, int var3, int var4, Entity var5) {
        this.field_452_a.func_254_a(var1, var2, var3, var4, var5);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        this.field_452_a.func_208_a(var1, var2, var3, var4, var5);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return this.field_452_a.func_250_a(var1, var2, var3, var4, var5);
    }

    public void func_4027_c(World var1, int var2, int var3, int var4) {
        this.field_452_a.func_4027_c(var1, var2, var3, var4);
    }

    public void func_4026_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.func_1108_b((double)(var5.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            var1.func_691_b(var2, var3, var4, 2);
        }

        if (var6 == 1) {
            var1.func_691_b(var2, var3, var4, 1);
        }

        if (var6 == 2) {
            var1.func_691_b(var2, var3, var4, 3);
        }

        if (var6 == 3) {
            var1.func_691_b(var2, var3, var4, 0);
        }

    }
}
