package net.minecraft.src;

import java.util.Random;

public class BlockCrops extends BlockFlower {
    protected BlockCrops(int var1, int var2) {
        super(var1, var2);
        this.field_378_bb = var2;
        this.func_253_b(true);
        float var3 = 0.5F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
    }

    protected boolean func_269_b(int var1) {
        return var1 == Block.field_446_aB.field_376_bc;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        super.func_208_a(var1, var2, var3, var4, var5);
        if (var1.func_618_j(var2, var3 + 1, var4) >= 9) {
            int var6 = var1.func_602_e(var2, var3, var4);
            if (var6 < 7) {
                float var7 = this.func_270_i(var1, var2, var3, var4);
                if (var5.nextInt((int)(100.0F / var7)) == 0) {
                    ++var6;
                    var1.func_691_b(var2, var3, var4, var6);
                }
            }
        }

    }

    public void func_21027_c_(World var1, int var2, int var3, int var4) {
        var1.func_691_b(var2, var3, var4, 7);
    }

    private float func_270_i(World var1, int var2, int var3, int var4) {
        float var5 = 1.0F;
        int var6 = var1.func_600_a(var2, var3, var4 - 1);
        int var7 = var1.func_600_a(var2, var3, var4 + 1);
        int var8 = var1.func_600_a(var2 - 1, var3, var4);
        int var9 = var1.func_600_a(var2 + 1, var3, var4);
        int var10 = var1.func_600_a(var2 - 1, var3, var4 - 1);
        int var11 = var1.func_600_a(var2 + 1, var3, var4 - 1);
        int var12 = var1.func_600_a(var2 + 1, var3, var4 + 1);
        int var13 = var1.func_600_a(var2 - 1, var3, var4 + 1);
        boolean var14 = var8 == this.field_376_bc || var9 == this.field_376_bc;
        boolean var15 = var6 == this.field_376_bc || var7 == this.field_376_bc;
        boolean var16 = var10 == this.field_376_bc || var11 == this.field_376_bc || var12 == this.field_376_bc || var13 == this.field_376_bc;

        for(int var17 = var2 - 1; var17 <= var2 + 1; ++var17) {
            for(int var18 = var4 - 1; var18 <= var4 + 1; ++var18) {
                int var19 = var1.func_600_a(var17, var3 - 1, var18);
                float var20 = 0.0F;
                if (var19 == Block.field_446_aB.field_376_bc) {
                    var20 = 1.0F;
                    if (var1.func_602_e(var17, var3 - 1, var18) > 0) {
                        var20 = 3.0F;
                    }
                }

                if (var17 != var2 || var18 != var4) {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15) {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int func_232_a(int var1, int var2) {
        if (var2 < 0) {
            var2 = 7;
        }

        return this.field_378_bb + var2;
    }

    public int func_210_f() {
        return 6;
    }

    public void func_216_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        super.func_216_a(var1, var2, var3, var4, var5, var6);
        if (!var1.field_1026_y) {
            for(int var7 = 0; var7 < 3; ++var7) {
                if (var1.field_1037_n.nextInt(15) <= var5) {
                    float var8 = 0.7F;
                    float var9 = var1.field_1037_n.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var10 = var1.field_1037_n.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var11 = var1.field_1037_n.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var9), (double)((float)var3 + var10), (double)((float)var4 + var11), new ItemStack(Item.field_244_Q));
                    var12.field_805_c = 10;
                    var1.func_674_a(var12);
                }
            }

        }
    }

    public int func_240_a(int var1, Random var2) {
        return var1 == 7 ? Item.field_243_R.field_291_aS : -1;
    }

    public int func_229_a(Random var1) {
        return 1;
    }
}
