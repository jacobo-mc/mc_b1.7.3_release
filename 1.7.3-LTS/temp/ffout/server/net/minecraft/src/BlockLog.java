package net.minecraft.src;

import java.util.Random;

public class BlockLog extends Block {
    protected BlockLog(int var1) {
        super(var1, Material.field_524_c);
        this.field_575_bb = 20;
    }

    public int func_244_a(Random var1) {
        return 1;
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_582_K.field_573_bc;
    }

    public void func_12007_g(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        super.func_12007_g(var1, var2, var3, var4, var5, var6);
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        byte var5 = 4;
        int var6 = var5 + 1;
        if (var1.func_466_a(var2 - var6, var3 - var6, var4 - var6, var2 + var6, var3 + var6, var4 + var6)) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
                for(int var8 = -var5; var8 <= var5; ++var8) {
                    for(int var9 = -var5; var9 <= var5; ++var9) {
                        int var10 = var1.func_444_a(var2 + var7, var3 + var8, var4 + var9);
                        if (var10 == Block.field_581_L.field_573_bc) {
                            int var11 = var1.func_446_b(var2 + var7, var3 + var8, var4 + var9);
                            if ((var11 & 8) == 0) {
                                var1.func_463_c(var2 + var7, var3 + var8, var4 + var9, var11 | 8);
                            }
                        }
                    }
                }
            }
        }

    }

    public int func_22009_a(int var1, int var2) {
        if (var1 == 1) {
            return 21;
        } else if (var1 == 0) {
            return 21;
        } else if (var2 == 1) {
            return 116;
        } else {
            return var2 == 2 ? 117 : 20;
        }
    }

    protected int func_21025_b(int var1) {
        return var1;
    }
}
