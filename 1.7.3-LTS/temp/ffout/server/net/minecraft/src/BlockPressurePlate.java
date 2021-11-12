package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockPressurePlate extends Block {
    private EnumMobType field_664_a;

    protected BlockPressurePlate(int var1, int var2, EnumMobType var3, Material var4) {
        super(var1, var2, var4);
        this.field_664_a = var3;
        this.func_231_a(true);
        float var5 = 0.0625F;
        this.func_229_a(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
    }

    public int func_4028_b() {
        return 20;
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

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return var1.func_445_d(var2, var3 - 1, var4);
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        boolean var6 = false;
        if (!var1.func_445_d(var2, var3 - 1, var4)) {
            var6 = true;
        }

        if (var6) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_792_x) {
            if (var1.func_446_b(var2, var3, var4) != 0) {
                this.func_318_g(var1, var2, var3, var4);
            }
        }
    }

    public void func_263_a(World var1, int var2, int var3, int var4, Entity var5) {
        if (!var1.field_792_x) {
            if (var1.func_446_b(var2, var3, var4) != 1) {
                this.func_318_g(var1, var2, var3, var4);
            }
        }
    }

    private void func_318_g(World var1, int var2, int var3, int var4) {
        boolean var5 = var1.func_446_b(var2, var3, var4) == 1;
        boolean var6 = false;
        float var7 = 0.125F;
        List var8 = null;
        if (this.field_664_a == EnumMobType.everything) {
            var8 = var1.func_450_b((Entity)null, AxisAlignedBB.func_693_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (this.field_664_a == EnumMobType.mobs) {
            var8 = var1.func_457_a(EntityLiving.class, AxisAlignedBB.func_693_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (this.field_664_a == EnumMobType.players) {
            var8 = var1.func_457_a(EntityPlayer.class, AxisAlignedBB.func_693_b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (var8.size() > 0) {
            var6 = true;
        }

        if (var6 && !var5) {
            var1.func_511_b(var2, var3, var4, 1);
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_519_b(var2, var3, var4, var2, var3, var4);
            var1.func_502_a((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!var6 && var5) {
            var1.func_511_b(var2, var3, var4, 0);
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_519_b(var2, var3, var4, var2, var3, var4);
            var1.func_502_a((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (var6) {
            var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
        }

    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        if (var5 > 0) {
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
        }

        super.func_242_b(var1, var2, var3, var4);
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        boolean var5 = var1.func_446_b(var2, var3, var4) == 1;
        float var6 = 0.0625F;
        if (var5) {
            this.func_229_a(var6, 0.0F, var6, 1.0F - var6, 0.03125F, 1.0F - var6);
        } else {
            this.func_229_a(var6, 0.0F, var6, 1.0F - var6, 0.0625F, 1.0F - var6);
        }

    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var1.func_446_b(var2, var3, var4) > 0;
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        if (var1.func_446_b(var2, var3, var4) == 0) {
            return false;
        } else {
            return var5 == 1;
        }
    }

    public boolean func_225_d() {
        return true;
    }

    public int func_31025_e() {
        return 1;
    }
}
