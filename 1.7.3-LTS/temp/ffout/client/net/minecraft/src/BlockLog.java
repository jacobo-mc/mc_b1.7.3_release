package net.minecraft.src;

import java.util.Random;

public class BlockLog extends Block {
    protected BlockLog(int var1) {
        super(var1, Material.field_1335_c);
        this.field_378_bb = 20;
    }

    public int func_229_a(Random var1) {
        return 1;
    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_385_K.field_376_bc;
    }

    public void func_220_a_(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        super.func_220_a_(var1, var2, var3, var4, var5, var6);
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        byte var5 = 4;
        int var6 = var5 + 1;
        if (var1.func_640_a(var2 - var6, var3 - var6, var4 - var6, var2 + var6, var3 + var6, var4 + var6)) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
                for(int var8 = -var5; var8 <= var5; ++var8) {
                    for(int var9 = -var5; var9 <= var5; ++var9) {
                        int var10 = var1.func_600_a(var2 + var7, var3 + var8, var4 + var9);
                        if (var10 == Block.field_384_L.field_376_bc) {
                            int var11 = var1.func_602_e(var2 + var7, var3 + var8, var4 + var9);
                            if ((var11 & 8) == 0) {
                                var1.func_635_c(var2 + var7, var3 + var8, var4 + var9, var11 | 8);
                            }
                        }
                    }
                }
            }
        }

    }

    public int func_232_a(int var1, int var2) {
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
