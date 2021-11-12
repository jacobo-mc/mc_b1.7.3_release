package net.minecraft.src;

import java.util.Random;

public class BlockFlower extends Block {
    protected BlockFlower(int var1, int var2) {
        super(var1, Material.field_518_i);
        this.field_575_bb = var2;
        this.func_231_a(true);
        float var3 = 0.2F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return super.func_259_a(var1, var2, var3, var4) && this.func_277_b(var1.func_444_a(var2, var3 - 1, var4));
    }

    protected boolean func_277_b(int var1) {
        return var1 == Block.field_534_v.field_573_bc || var1 == Block.field_533_w.field_573_bc || var1 == Block.field_643_aB.field_573_bc;
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        super.func_234_b(var1, var2, var3, var4, var5);
        this.func_276_g(var1, var2, var3, var4);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        this.func_276_g(var1, var2, var3, var4);
    }

    protected final void func_276_g(World var1, int var2, int var3, int var4) {
        if (!this.func_220_f(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

    }

    public boolean func_220_f(World var1, int var2, int var3, int var4) {
        return (var1.func_28098_j(var2, var3, var4) >= 8 || var1.func_497_g(var2, var3, var4)) && this.func_277_b(var1.func_444_a(var2, var3 - 1, var4));
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }
}
