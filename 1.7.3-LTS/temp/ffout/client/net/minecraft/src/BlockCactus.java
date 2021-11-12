package net.minecraft.src;

import java.util.Random;

public class BlockCactus extends Block {
    protected BlockCactus(int var1, int var2) {
        super(var1, var2, Material.field_1317_u);
        this.func_253_b(true);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_20084_d(var2, var3 + 1, var4)) {
            int var6;
            for(var6 = 1; var1.func_600_a(var2, var3 - var6, var4) == this.field_376_bc; ++var6) {
            }

            if (var6 < 3) {
                int var7 = var1.func_602_e(var2, var3, var4);
                if (var7 == 15) {
                    var1.func_690_d(var2, var3 + 1, var4, this.field_376_bc);
                    var1.func_691_b(var2, var3, var4, 0);
                } else {
                    var1.func_691_b(var2, var3, var4, var7 + 1);
                }
            }
        }

    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        float var5 = 0.0625F;
        return AxisAlignedBB.func_1161_b((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - var5), (double)((float)(var4 + 1) - var5));
    }

    public AxisAlignedBB func_246_f(World var1, int var2, int var3, int var4) {
        float var5 = 0.0625F;
        return AxisAlignedBB.func_1161_b((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)(var3 + 1), (double)((float)(var4 + 1) - var5));
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb - 1;
        } else {
            return var1 == 0 ? this.field_378_bb + 1 : this.field_378_bb;
        }
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_217_b() {
        return false;
    }

    public int func_210_f() {
        return 13;
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
        if (var1.func_599_f(var2 - 1, var3, var4).func_878_a()) {
            return false;
        } else if (var1.func_599_f(var2 + 1, var3, var4).func_878_a()) {
            return false;
        } else if (var1.func_599_f(var2, var3, var4 - 1).func_878_a()) {
            return false;
        } else if (var1.func_599_f(var2, var3, var4 + 1).func_878_a()) {
            return false;
        } else {
            int var5 = var1.func_600_a(var2, var3 - 1, var4);
            return var5 == Block.field_425_aW.field_376_bc || var5 == Block.field_393_F.field_376_bc;
        }
    }

    public void func_236_b(World var1, int var2, int var3, int var4, Entity var5) {
        var5.func_396_a((Entity)null, 1);
    }
}
