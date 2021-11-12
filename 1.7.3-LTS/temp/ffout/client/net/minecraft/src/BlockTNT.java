package net.minecraft.src;

import java.util.Random;

public class BlockTNT extends Block {
    public BlockTNT(int var1, int var2) {
        super(var1, var2, Material.field_1322_p);
    }

    public int func_218_a(int var1) {
        if (var1 == 0) {
            return this.field_378_bb + 2;
        } else {
            return var1 == 1 ? this.field_378_bb + 1 : this.field_378_bb;
        }
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        super.func_235_e(var1, var2, var3, var4);
        if (var1.func_625_o(var2, var3, var4)) {
            this.func_252_b(var1, var2, var3, var4, 1);
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (var5 > 0 && Block.field_345_n[var5].func_209_d() && var1.func_625_o(var2, var3, var4)) {
            this.func_252_b(var1, var2, var3, var4, 1);
            var1.func_690_d(var2, var3, var4, 0);
        }

    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public void func_4027_c(World var1, int var2, int var3, int var4) {
        EntityTNTPrimed var5 = new EntityTNTPrimed(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F));
        var5.field_689_a = var1.field_1037_n.nextInt(var5.field_689_a / 4) + var5.field_689_a / 8;
        var1.func_674_a(var5);
    }

    public void func_252_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y) {
            if ((var5 & 1) == 0) {
                this.func_31027_a(var1, var2, var3, var4, new ItemStack(Block.field_408_an.field_376_bc, 1, 0));
            } else {
                EntityTNTPrimed var6 = new EntityTNTPrimed(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F));
                var1.func_674_a(var6);
                var1.func_623_a(var6, "random.fuse", 1.0F, 1.0F);
            }

        }
    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var5.func_6416_v() != null && var5.func_6416_v().field_1617_c == Item.field_4014_g.field_291_aS) {
            var1.func_635_c(var2, var3, var4, 1);
        }

        super.func_233_b(var1, var2, var3, var4, var5);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return super.func_250_a(var1, var2, var3, var4, var5);
    }
}
