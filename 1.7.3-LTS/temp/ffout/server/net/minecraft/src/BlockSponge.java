package net.minecraft.src;

public class BlockSponge extends Block {
    protected BlockSponge(int var1) {
        super(var1, Material.field_517_j);
        this.field_575_bb = 48;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        byte var5 = 2;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var3 - var5; var7 <= var3 + var5; ++var7) {
                for(int var8 = var4 - var5; var8 <= var4 + var5; ++var8) {
                    if (var1.func_443_c(var6, var7, var8) == Material.field_521_f) {
                    }
                }
            }
        }

    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        byte var5 = 2;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var3 - var5; var7 <= var3 + var5; ++var7) {
                for(int var8 = var4 - var5; var8 <= var4 + var5; ++var8) {
                    var1.func_449_g(var6, var7, var8, var1.func_444_a(var6, var7, var8));
                }
            }
        }

    }
}
