package net.minecraft.src;

import java.util.Random;

public class BlockSign extends BlockContainer {
    private Class field_654_a;
    private boolean field_653_b;

    protected BlockSign(int var1, Class var2, boolean var3) {
        super(var1, Material.field_524_c);
        this.field_653_b = var3;
        this.field_575_bb = 4;
        this.field_654_a = var2;
        float var4 = 0.25F;
        float var5 = 1.0F;
        this.func_229_a(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var5, 0.5F + var4);
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        if (!this.field_653_b) {
            int var5 = var1.func_446_b(var2, var3, var4);
            float var6 = 0.28125F;
            float var7 = 0.78125F;
            float var8 = 0.0F;
            float var9 = 1.0F;
            float var10 = 0.125F;
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            if (var5 == 2) {
                this.func_229_a(var8, var6, 1.0F - var10, var9, var7, 1.0F);
            }

            if (var5 == 3) {
                this.func_229_a(var8, var6, 0.0F, var9, var7, var10);
            }

            if (var5 == 4) {
                this.func_229_a(1.0F - var10, var6, var8, 1.0F, var7, var9);
            }

            if (var5 == 5) {
                this.func_229_a(0.0F, var6, var8, var10, var7, var9);
            }

        }
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_240_b() {
        return false;
    }

    protected TileEntity func_294_a_() {
        try {
            return (TileEntity)this.field_654_a.newInstance();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_4174_as.field_234_aS;
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        boolean var6 = false;
        if (this.field_653_b) {
            if (!var1.func_443_c(var2, var3 - 1, var4).func_216_a()) {
                var6 = true;
            }
        } else {
            int var7 = var1.func_446_b(var2, var3, var4);
            var6 = true;
            if (var7 == 2 && var1.func_443_c(var2, var3, var4 + 1).func_216_a()) {
                var6 = false;
            }

            if (var7 == 3 && var1.func_443_c(var2, var3, var4 - 1).func_216_a()) {
                var6 = false;
            }

            if (var7 == 4 && var1.func_443_c(var2 + 1, var3, var4).func_216_a()) {
                var6 = false;
            }

            if (var7 == 5 && var1.func_443_c(var2 - 1, var3, var4).func_216_a()) {
                var6 = false;
            }
        }

        if (var6) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

        super.func_234_b(var1, var2, var3, var4, var5);
    }
}
