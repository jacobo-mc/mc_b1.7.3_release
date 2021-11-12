package net.minecraft.src;

import java.util.Random;

public class BlockCactus extends Block {
    protected BlockCactus(int var1, int var2) {
        super(var1, var2, Material.field_4214_u);
        this.func_231_a(true);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_20111_e(var2, var3 + 1, var4)) {
            int var6;
            for(var6 = 1; var1.func_444_a(var2, var3 - var6, var4) == this.field_573_bc; ++var6) {
            }

            if (var6 < 3) {
                int var7 = var1.func_446_b(var2, var3, var4);
                if (var7 == 15) {
                    var1.func_508_d(var2, var3 + 1, var4, this.field_573_bc);
                    var1.func_511_b(var2, var3, var4, 0);
                } else {
                    var1.func_511_b(var2, var3, var4, var7 + 1);
                }
            }
        }

    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        float var5 = 0.0625F;
        return AxisAlignedBB.func_693_b((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - var5), (double)((float)(var4 + 1) - var5));
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb - 1;
        } else {
            return var1 == 0 ? this.field_575_bb + 1 : this.field_575_bb;
        }
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_240_b() {
        return false;
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
        if (var1.func_443_c(var2 - 1, var3, var4).func_216_a()) {
            return false;
        } else if (var1.func_443_c(var2 + 1, var3, var4).func_216_a()) {
            return false;
        } else if (var1.func_443_c(var2, var3, var4 - 1).func_216_a()) {
            return false;
        } else if (var1.func_443_c(var2, var3, var4 + 1).func_216_a()) {
            return false;
        } else {
            int var5 = var1.func_444_a(var2, var3 - 1, var4);
            return var5 == Block.field_622_aW.field_573_bc || var5 == Block.field_590_F.field_573_bc;
        }
    }

    public void func_263_a(World var1, int var2, int var3, int var4, Entity var5) {
        var5.func_121_a((Entity)null, 1);
    }
}
