package net.minecraft.src;

import java.util.Random;

public class BlockSnow extends Block {
    protected BlockSnow(int var1, int var2) {
        super(var1, var2, Material.field_1319_s);
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.func_253_b(true);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4) & 7;
        return var5 >= 3 ? AxisAlignedBB.func_1161_b((double)var2 + this.field_370_bf, (double)var3 + this.field_368_bg, (double)var4 + this.field_366_bh, (double)var2 + this.field_364_bi, (double)((float)var3 + 0.5F), (double)var4 + this.field_360_bk) : null;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4) & 7;
        float var6 = (float)(2 * (1 + var5)) / 16.0F;
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, var6, 1.0F);
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_600_a(var2, var3 - 1, var4);
        return var5 != 0 && Block.field_345_n[var5].func_217_b() ? var1.func_599_f(var2, var3 - 1, var4).func_880_c() : false;
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        this.func_314_h(var1, var2, var3, var4);
    }

    private boolean func_314_h(World var1, int var2, int var3, int var4) {
        if (!this.func_243_a(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public void func_220_a_(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        int var7 = Item.field_308_aB.field_291_aS;
        float var8 = 0.7F;
        double var9 = (double)(var1.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
        double var11 = (double)(var1.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
        double var13 = (double)(var1.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
        EntityItem var15 = new EntityItem(var1, (double)var3 + var9, (double)var4 + var11, (double)var5 + var13, new ItemStack(var7, 1, 0));
        var15.field_805_c = 10;
        var1.func_674_a(var15);
        var1.func_690_d(var3, var4, var5, 0);
        var2.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_308_aB.field_291_aS;
    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_641_a(EnumSkyBlock.Block, var2, var3, var4) > 11) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var5 == 1 ? true : super.func_260_c(var1, var2, var3, var4, var5);
    }
}
