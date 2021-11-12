package net.minecraft.src;

import java.util.Random;

public class BlockSnow extends Block {
    protected BlockSnow(int var1, int var2) {
        super(var1, var2, Material.field_508_s);
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.func_231_a(true);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4) & 7;
        return var5 >= 3 ? AxisAlignedBB.func_693_b((double)var2 + this.field_567_bf, (double)var3 + this.field_565_bg, (double)var4 + this.field_563_bh, (double)var2 + this.field_561_bi, (double)((float)var3 + 0.5F), (double)var4 + this.field_557_bk) : null;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4) & 7;
        float var6 = (float)(2 * (1 + var5)) / 16.0F;
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, var6, 1.0F);
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_444_a(var2, var3 - 1, var4);
        return var5 != 0 && Block.field_542_n[var5].func_240_b() ? var1.func_443_c(var2, var3 - 1, var4).func_218_c() : false;
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        this.func_275_g(var1, var2, var3, var4);
    }

    private boolean func_275_g(World var1, int var2, int var3, int var4) {
        if (!this.func_259_a(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public void func_12007_g(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        int var7 = Item.field_251_aB.field_234_aS;
        float var8 = 0.7F;
        double var9 = (double)(var1.field_803_m.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
        double var11 = (double)(var1.field_803_m.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
        double var13 = (double)(var1.field_803_m.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
        EntityItem var15 = new EntityItem(var1, (double)var3 + var9, (double)var4 + var11, (double)var5 + var13, new ItemStack(var7, 1, 0));
        var15.field_433_ad = 10;
        var1.func_526_a(var15);
        var1.func_508_d(var3, var4, var5, 0);
        var2.func_25046_a(StatList.field_25094_y[this.field_573_bc], 1);
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_251_aB.field_234_aS;
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_512_a(EnumSkyBlock.Block, var2, var3, var4) > 11) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

    }
}
