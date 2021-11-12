package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockPressurePlate extends Block {
    private EnumMobType field_467_a;

    protected BlockPressurePlate(int var1, int var2, EnumMobType var3, Material var4) {
        super(var1, var2, var4);
        this.field_467_a = var3;
        this.func_253_b(true);
        float var5 = 0.0625F;
        this.func_213_a(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
    }

    public int func_4025_d() {
        return 20;
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

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return var1.func_28100_h(var2, var3 - 1, var4);
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        boolean var6 = false;
        if (!var1.func_28100_h(var2, var3 - 1, var4)) {
            var6 = true;
        }

        if (var6) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_1026_y) {
            if (var1.func_602_e(var2, var3, var4) != 0) {
                this.func_318_h(var1, var2, var3, var4);
            }
        }
    }

    public void func_236_b(World var1, int var2, int var3, int var4, Entity var5) {
        if (!var1.field_1026_y) {
            if (var1.func_602_e(var2, var3, var4) != 1) {
                this.func_318_h(var1, var2, var3, var4);
            }
        }
    }

    private void func_318_h(World var1, int var2, int var3, int var4) {
        boolean var5 = var1.func_602_e(var2, var3, var4) == 1;
        boolean var6 = false;
        float var7 = 0.125F;
        List var8 = null;
        if (this.field_467_a == EnumMobType.everything) {
            var8 = var1.func_659_b((Entity)null, AxisAlignedBB.func_1161_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (this.field_467_a == EnumMobType.mobs) {
            var8 = var1.func_657_a(EntityLiving.class, AxisAlignedBB.func_1161_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (this.field_467_a == EnumMobType.players) {
            var8 = var1.func_657_a(EntityPlayer.class, AxisAlignedBB.func_1161_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (var8.size() > 0) {
            var6 = true;
        }

        if (var6 && !var5) {
            var1.func_691_b(var2, var3, var4, 1);
            var1.func_611_g(var2, var3, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            var1.func_701_b(var2, var3, var4, var2, var3, var4);
            var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!var6 && var5) {
            var1.func_691_b(var2, var3, var4, 0);
            var1.func_611_g(var2, var3, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            var1.func_701_b(var2, var3, var4, var2, var3, var4);
            var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (var6) {
            var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
        }

    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        if (var5 > 0) {
            var1.func_611_g(var2, var3, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
        }

        super.func_214_b(var1, var2, var3, var4);
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        boolean var5 = var1.func_602_e(var2, var3, var4) == 1;
        float var6 = 0.0625F;
        if (var5) {
            this.func_213_a(var6, 0.0F, var6, 1.0F - var6, 0.03125F, 1.0F - var6);
        } else {
            this.func_213_a(var6, 0.0F, var6, 1.0F - var6, 0.0625F, 1.0F - var6);
        }

    }

    public boolean func_231_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var1.func_602_e(var2, var3, var4) > 0;
    }

    public boolean func_228_c(World var1, int var2, int var3, int var4, int var5) {
        if (var1.func_602_e(var2, var3, var4) == 0) {
            return false;
        } else {
            return var5 == 1;
        }
    }

    public boolean func_209_d() {
        return true;
    }

    public void func_237_e() {
        float var1 = 0.5F;
        float var2 = 0.125F;
        float var3 = 0.5F;
        this.func_213_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
    }

    public int func_31029_h() {
        return 1;
    }
}
