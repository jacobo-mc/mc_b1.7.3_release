package net.minecraft.src;

public class BlockSponge extends Block {
    protected BlockSponge(int var1) {
        super(var1, Material.field_1328_j);
        this.field_378_bb = 48;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        byte var5 = 2;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var3 - var5; var7 <= var3 + var5; ++var7) {
                for(int var8 = var4 - var5; var8 <= var4 + var5; ++var8) {
                    if (var1.func_599_f(var6, var7, var8) == Material.field_1332_f) {
                    }
                }
            }
        }

    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        byte var5 = 2;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var3 - var5; var7 <= var3 + var5; ++var7) {
                for(int var8 = var4 - var5; var8 <= var4 + var5; ++var8) {
                    var1.func_611_g(var6, var7, var8, var1.func_600_a(var6, var7, var8));
                }
            }
        }

    }
}
