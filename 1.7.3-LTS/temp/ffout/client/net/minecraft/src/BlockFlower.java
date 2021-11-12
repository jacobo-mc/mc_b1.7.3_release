package net.minecraft.src;

import java.util.Random;

public class BlockFlower extends Block {
    protected BlockFlower(int var1, int var2) {
        super(var1, Material.field_1329_i);
        this.field_378_bb = var2;
        this.func_253_b(true);
        float var3 = 0.2F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return super.func_243_a(var1, var2, var3, var4) && this.func_269_b(var1.func_600_a(var2, var3 - 1, var4));
    }

    protected boolean func_269_b(int var1) {
        return var1 == Block.field_337_v.field_376_bc || var1 == Block.field_336_w.field_376_bc || var1 == Block.field_446_aB.field_376_bc;
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        super.func_226_a(var1, var2, var3, var4, var5);
        this.func_268_h(var1, var2, var3, var4);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        this.func_268_h(var1, var2, var3, var4);
    }

    protected final void func_268_h(World var1, int var2, int var3, int var4) {
        if (!this.func_223_g(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public boolean func_223_g(World var1, int var2, int var3, int var4) {
        return (var1.func_28104_m(var2, var3, var4) >= 8 || var1.func_647_i(var2, var3, var4)) && this.func_269_b(var1.func_600_a(var2, var3 - 1, var4));
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 1;
    }
}
