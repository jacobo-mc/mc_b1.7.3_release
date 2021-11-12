package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {
    private boolean field_453_a = true;
    private Set field_21031_b = new HashSet();

    public BlockRedstoneWire(int var1, int var2) {
        super(var1, var2, Material.field_1324_n);
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public int func_232_a(int var1, int var2) {
        return this.field_378_bb;
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

    public int func_210_f() {
        return 5;
    }

    public int func_207_d(IBlockAccess var1, int var2, int var3, int var4) {
        return 8388608;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return var1.func_28100_h(var2, var3 - 1, var4);
    }

    private void func_280_h(World var1, int var2, int var3, int var4) {
        this.func_21030_a(var1, var2, var3, var4, var2, var3, var4);
        ArrayList var5 = new ArrayList(this.field_21031_b);
        this.field_21031_b.clear();

        for(int var6 = 0; var6 < var5.size(); ++var6) {
            ChunkPosition var7 = (ChunkPosition)var5.get(var6);
            var1.func_611_g(var7.field_1111_a, var7.field_1110_b, var7.field_1112_c, this.field_376_bc);
        }

    }

    private void func_21030_a(World var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = var1.func_602_e(var2, var3, var4);
        int var9 = 0;
        this.field_453_a = false;
        boolean var10 = var1.func_625_o(var2, var3, var4);
        this.field_453_a = true;
        int var11;
        int var12;
        int var13;
        if (var10) {
            var9 = 15;
        } else {
            for(var11 = 0; var11 < 4; ++var11) {
                var12 = var2;
                var13 = var4;
                if (var11 == 0) {
                    var12 = var2 - 1;
                }

                if (var11 == 1) {
                    ++var12;
                }

                if (var11 == 2) {
                    var13 = var4 - 1;
                }

                if (var11 == 3) {
                    ++var13;
                }

                if (var12 != var5 || var3 != var6 || var13 != var7) {
                    var9 = this.func_281_g(var1, var12, var3, var13, var9);
                }

                if (var1.func_28100_h(var12, var3, var13) && !var1.func_28100_h(var2, var3 + 1, var4)) {
                    if (var12 != var5 || var3 + 1 != var6 || var13 != var7) {
                        var9 = this.func_281_g(var1, var12, var3 + 1, var13, var9);
                    }
                } else if (!var1.func_28100_h(var12, var3, var13) && (var12 != var5 || var3 - 1 != var6 || var13 != var7)) {
                    var9 = this.func_281_g(var1, var12, var3 - 1, var13, var9);
                }
            }

            if (var9 > 0) {
                --var9;
            } else {
                var9 = 0;
            }
        }

        if (var8 != var9) {
            var1.field_1043_h = true;
            var1.func_691_b(var2, var3, var4, var9);
            var1.func_701_b(var2, var3, var4, var2, var3, var4);
            var1.field_1043_h = false;

            for(var11 = 0; var11 < 4; ++var11) {
                var12 = var2;
                var13 = var4;
                int var14 = var3 - 1;
                if (var11 == 0) {
                    var12 = var2 - 1;
                }

                if (var11 == 1) {
                    ++var12;
                }

                if (var11 == 2) {
                    var13 = var4 - 1;
                }

                if (var11 == 3) {
                    ++var13;
                }

                if (var1.func_28100_h(var12, var3, var13)) {
                    var14 += 2;
                }

                boolean var15 = false;
                int var16 = this.func_281_g(var1, var12, var3, var13, -1);
                var9 = var1.func_602_e(var2, var3, var4);
                if (var9 > 0) {
                    --var9;
                }

                if (var16 >= 0 && var16 != var9) {
                    this.func_21030_a(var1, var12, var3, var13, var2, var3, var4);
                }

                var16 = this.func_281_g(var1, var12, var14, var13, -1);
                var9 = var1.func_602_e(var2, var3, var4);
                if (var9 > 0) {
                    --var9;
                }

                if (var16 >= 0 && var16 != var9) {
                    this.func_21030_a(var1, var12, var14, var13, var2, var3, var4);
                }
            }

            if (var8 == 0 || var9 == 0) {
                this.field_21031_b.add(new ChunkPosition(var2, var3, var4));
                this.field_21031_b.add(new ChunkPosition(var2 - 1, var3, var4));
                this.field_21031_b.add(new ChunkPosition(var2 + 1, var3, var4));
                this.field_21031_b.add(new ChunkPosition(var2, var3 - 1, var4));
                this.field_21031_b.add(new ChunkPosition(var2, var3 + 1, var4));
                this.field_21031_b.add(new ChunkPosition(var2, var3, var4 - 1));
                this.field_21031_b.add(new ChunkPosition(var2, var3, var4 + 1));
            }
        }

    }

    private void func_282_i(World var1, int var2, int var3, int var4) {
        if (var1.func_600_a(var2, var3, var4) == this.field_376_bc) {
            var1.func_611_g(var2, var3, var4, this.field_376_bc);
            var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
            var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
            var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
            var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
        }
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        super.func_235_e(var1, var2, var3, var4);
        if (!var1.field_1026_y) {
            this.func_280_h(var1, var2, var3, var4);
            var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            this.func_282_i(var1, var2 - 1, var3, var4);
            this.func_282_i(var1, var2 + 1, var3, var4);
            this.func_282_i(var1, var2, var3, var4 - 1);
            this.func_282_i(var1, var2, var3, var4 + 1);
            if (var1.func_28100_h(var2 - 1, var3, var4)) {
                this.func_282_i(var1, var2 - 1, var3 + 1, var4);
            } else {
                this.func_282_i(var1, var2 - 1, var3 - 1, var4);
            }

            if (var1.func_28100_h(var2 + 1, var3, var4)) {
                this.func_282_i(var1, var2 + 1, var3 + 1, var4);
            } else {
                this.func_282_i(var1, var2 + 1, var3 - 1, var4);
            }

            if (var1.func_28100_h(var2, var3, var4 - 1)) {
                this.func_282_i(var1, var2, var3 + 1, var4 - 1);
            } else {
                this.func_282_i(var1, var2, var3 - 1, var4 - 1);
            }

            if (var1.func_28100_h(var2, var3, var4 + 1)) {
                this.func_282_i(var1, var2, var3 + 1, var4 + 1);
            } else {
                this.func_282_i(var1, var2, var3 - 1, var4 + 1);
            }

        }
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        super.func_214_b(var1, var2, var3, var4);
        if (!var1.field_1026_y) {
            var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
            var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            this.func_280_h(var1, var2, var3, var4);
            this.func_282_i(var1, var2 - 1, var3, var4);
            this.func_282_i(var1, var2 + 1, var3, var4);
            this.func_282_i(var1, var2, var3, var4 - 1);
            this.func_282_i(var1, var2, var3, var4 + 1);
            if (var1.func_28100_h(var2 - 1, var3, var4)) {
                this.func_282_i(var1, var2 - 1, var3 + 1, var4);
            } else {
                this.func_282_i(var1, var2 - 1, var3 - 1, var4);
            }

            if (var1.func_28100_h(var2 + 1, var3, var4)) {
                this.func_282_i(var1, var2 + 1, var3 + 1, var4);
            } else {
                this.func_282_i(var1, var2 + 1, var3 - 1, var4);
            }

            if (var1.func_28100_h(var2, var3, var4 - 1)) {
                this.func_282_i(var1, var2, var3 + 1, var4 - 1);
            } else {
                this.func_282_i(var1, var2, var3 - 1, var4 - 1);
            }

            if (var1.func_28100_h(var2, var3, var4 + 1)) {
                this.func_282_i(var1, var2, var3 + 1, var4 + 1);
            } else {
                this.func_282_i(var1, var2, var3 - 1, var4 + 1);
            }

        }
    }

    private int func_281_g(World var1, int var2, int var3, int var4, int var5) {
        if (var1.func_600_a(var2, var3, var4) != this.field_376_bc) {
            return var5;
        } else {
            int var6 = var1.func_602_e(var2, var3, var4);
            return var6 > var5 ? var6 : var5;
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y) {
            int var6 = var1.func_602_e(var2, var3, var4);
            boolean var7 = this.func_243_a(var1, var2, var3, var4);
            if (!var7) {
                this.func_259_b_(var1, var2, var3, var4, var6);
                var1.func_690_d(var2, var3, var4, 0);
            } else {
                this.func_280_h(var1, var2, var3, var4);
            }

            super.func_226_a(var1, var2, var3, var4, var5);
        }
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_309_aA.field_291_aS;
    }

    public boolean func_228_c(World var1, int var2, int var3, int var4, int var5) {
        return !this.field_453_a ? false : this.func_231_b(var1, var2, var3, var4, var5);
    }

    public boolean func_231_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.field_453_a) {
            return false;
        } else if (var1.func_602_e(var2, var3, var4) == 0) {
            return false;
        } else if (var5 == 1) {
            return true;
        } else {
            boolean var6 = func_279_b(var1, var2 - 1, var3, var4, 1) || !var1.func_28100_h(var2 - 1, var3, var4) && func_279_b(var1, var2 - 1, var3 - 1, var4, -1);
            boolean var7 = func_279_b(var1, var2 + 1, var3, var4, 3) || !var1.func_28100_h(var2 + 1, var3, var4) && func_279_b(var1, var2 + 1, var3 - 1, var4, -1);
            boolean var8 = func_279_b(var1, var2, var3, var4 - 1, 2) || !var1.func_28100_h(var2, var3, var4 - 1) && func_279_b(var1, var2, var3 - 1, var4 - 1, -1);
            boolean var9 = func_279_b(var1, var2, var3, var4 + 1, 0) || !var1.func_28100_h(var2, var3, var4 + 1) && func_279_b(var1, var2, var3 - 1, var4 + 1, -1);
            if (!var1.func_28100_h(var2, var3 + 1, var4)) {
                if (var1.func_28100_h(var2 - 1, var3, var4) && func_279_b(var1, var2 - 1, var3 + 1, var4, -1)) {
                    var6 = true;
                }

                if (var1.func_28100_h(var2 + 1, var3, var4) && func_279_b(var1, var2 + 1, var3 + 1, var4, -1)) {
                    var7 = true;
                }

                if (var1.func_28100_h(var2, var3, var4 - 1) && func_279_b(var1, var2, var3 + 1, var4 - 1, -1)) {
                    var8 = true;
                }

                if (var1.func_28100_h(var2, var3, var4 + 1) && func_279_b(var1, var2, var3 + 1, var4 + 1, -1)) {
                    var9 = true;
                }
            }

            if (!var8 && !var7 && !var6 && !var9 && var5 >= 2 && var5 <= 5) {
                return true;
            } else if (var5 == 2 && var8 && !var6 && !var7) {
                return true;
            } else if (var5 == 3 && var9 && !var6 && !var7) {
                return true;
            } else if (var5 == 4 && var6 && !var8 && !var9) {
                return true;
            } else {
                return var5 == 5 && var7 && !var8 && !var9;
            }
        }
    }

    public boolean func_209_d() {
        return this.field_453_a;
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        if (var6 > 0) {
            double var7 = (double)var2 + 0.5D + ((double)var5.nextFloat() - 0.5D) * 0.2D;
            double var9 = (double)((float)var3 + 0.0625F);
            double var11 = (double)var4 + 0.5D + ((double)var5.nextFloat() - 0.5D) * 0.2D;
            float var13 = (float)var6 / 15.0F;
            float var14 = var13 * 0.6F + 0.4F;
            if (var6 == 0) {
                var14 = 0.0F;
            }

            float var15 = var13 * var13 * 0.7F - 0.5F;
            float var16 = var13 * var13 * 0.6F - 0.7F;
            if (var15 < 0.0F) {
                var15 = 0.0F;
            }

            if (var16 < 0.0F) {
                var16 = 0.0F;
            }

            var1.func_694_a("reddust", var7, var9, var11, (double)var14, (double)var15, (double)var16);
        }

    }

    public static boolean func_279_b(IBlockAccess var0, int var1, int var2, int var3, int var4) {
        int var5 = var0.func_600_a(var1, var2, var3);
        if (var5 == Block.field_394_aw.field_376_bc) {
            return true;
        } else if (var5 == 0) {
            return false;
        } else if (Block.field_345_n[var5].func_209_d()) {
            return true;
        } else if (var5 != Block.field_22021_bh.field_376_bc && var5 != Block.field_22020_bi.field_376_bc) {
            return false;
        } else {
            int var6 = var0.func_602_e(var1, var2, var3);
            return var4 == ModelBed.field_22279_b[var6 & 3];
        }
    }
}
