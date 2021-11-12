package net.minecraft.src;

import java.util.Random;

public class BlockTNT extends Block {
    public BlockTNT(int var1, int var2) {
        super(var1, var2, Material.field_511_p);
    }

    public int func_241_a(int var1) {
        if (var1 == 0) {
            return this.field_575_bb + 2;
        } else {
            return var1 == 1 ? this.field_575_bb + 1 : this.field_575_bb;
        }
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        super.func_250_e(var1, var2, var3, var4);
        if (var1.func_474_n(var2, var3, var4)) {
            this.func_251_a(var1, var2, var3, var4, 1);
            var1.func_508_d(var2, var3, var4, 0);
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (var5 > 0 && Block.field_542_n[var5].func_225_d() && var1.func_474_n(var2, var3, var4)) {
            this.func_251_a(var1, var2, var3, var4, 1);
            var1.func_508_d(var2, var3, var4, 0);
        }

    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public void func_4029_c(World var1, int var2, int var3, int var4) {
        EntityTNTPrimed var5 = new EntityTNTPrimed(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F));
        var5.field_446_a = var1.field_803_m.nextInt(var5.field_446_a / 4) + var5.field_446_a / 8;
        var1.func_526_a(var5);
    }

    public void func_251_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_792_x) {
            if ((var5 & 1) == 0) {
                this.func_31024_a(var1, var2, var3, var4, new ItemStack(Block.field_605_an.field_573_bc, 1, 0));
            } else {
                EntityTNTPrimed var6 = new EntityTNTPrimed(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F));
                var1.func_526_a(var6);
                var1.func_506_a(var6, "random.fuse", 1.0F, 1.0F);
            }

        }
    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var5.func_172_B() != null && var5.func_172_B().field_855_c == Item.field_4150_g.field_234_aS) {
            var1.func_463_c(var2, var3, var4, 1);
        }

        super.func_235_b(var1, var2, var3, var4, var5);
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return super.func_246_a(var1, var2, var3, var4, var5);
    }
}
