package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockDetectorRail extends BlockRail {
    public BlockDetectorRail(int var1, int var2) {
        super(var1, var2, true);
        this.func_231_a(true);
    }

    public int func_4028_b() {
        return 20;
    }

    public boolean func_225_d() {
        return true;
    }

    public void func_263_a(World var1, int var2, int var3, int var4, Entity var5) {
        if (!var1.field_792_x) {
            int var6 = var1.func_446_b(var2, var3, var4);
            if ((var6 & 8) == 0) {
                this.func_27035_f(var1, var2, var3, var4, var6);
            }
        }
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_792_x) {
            int var6 = var1.func_446_b(var2, var3, var4);
            if ((var6 & 8) != 0) {
                this.func_27035_f(var1, var2, var3, var4, var6);
            }
        }
    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return (var1.func_446_b(var2, var3, var4) & 8) != 0;
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        if ((var1.func_446_b(var2, var3, var4) & 8) == 0) {
            return false;
        } else {
            return var5 == 1;
        }
    }

    private void func_27035_f(World var1, int var2, int var3, int var4, int var5) {
        boolean var6 = (var5 & 8) != 0;
        boolean var7 = false;
        float var8 = 0.125F;
        List var9 = var1.func_457_a(EntityMinecart.class, AxisAlignedBB.func_693_b((double)((float)var2 + var8), (double)var3, (double)((float)var4 + var8), (double)((float)(var2 + 1) - var8), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var8)));
        if (var9.size() > 0) {
            var7 = true;
        }

        if (var7 && !var6) {
            var1.func_511_b(var2, var3, var4, var5 | 8);
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_519_b(var2, var3, var4, var2, var3, var4);
        }

        if (!var7 && var6) {
            var1.func_511_b(var2, var3, var4, var5 & 7);
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_519_b(var2, var3, var4, var2, var3, var4);
        }

        if (var7) {
            var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
        }

    }
}
