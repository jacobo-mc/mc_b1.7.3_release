package net.minecraft.src;

import java.util.Random;

public class BlockRail extends Block {
    private final boolean field_27045_a;

    public static final boolean func_27040_h(World var0, int var1, int var2, int var3) {
        int var4 = var0.func_600_a(var1, var2, var3);
        return var4 == Block.field_440_aH.field_376_bc || var4 == Block.field_9261_T.field_376_bc || var4 == Block.field_9260_U.field_376_bc;
    }

    public static final boolean func_27041_c(int var0) {
        return var0 == Block.field_440_aH.field_376_bc || var0 == Block.field_9261_T.field_376_bc || var0 == Block.field_9260_U.field_376_bc;
    }

    protected BlockRail(int var1, int var2, boolean var3) {
        super(var1, var2, Material.field_1324_n);
        this.field_27045_a = var3;
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_27042_h() {
        return this.field_27045_a;
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_217_b() {
        return false;
    }

    public MovingObjectPosition func_255_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_238_a(var1, var2, var3, var4);
        return super.func_255_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        if (var5 >= 2 && var5 <= 5) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        } else {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }

    }

    public int func_232_a(int var1, int var2) {
        if (this.field_27045_a) {
            if (this.field_376_bc == Block.field_9261_T.field_376_bc && (var2 & 8) == 0) {
                return this.field_378_bb - 16;
            }
        } else if (var2 >= 6) {
            return this.field_378_bb - 16;
        }

        return this.field_378_bb;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 9;
    }

    public int func_229_a(Random var1) {
        return 1;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return var1.func_28100_h(var2, var3 - 1, var4);
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        if (!var1.field_1026_y) {
            this.func_4031_h(var1, var2, var3, var4, true);
        }

    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y) {
            int var6 = var1.func_602_e(var2, var3, var4);
            int var7 = var6;
            if (this.field_27045_a) {
                var7 = var6 & 7;
            }

            boolean var8 = false;
            if (!var1.func_28100_h(var2, var3 - 1, var4)) {
                var8 = true;
            }

            if (var7 == 2 && !var1.func_28100_h(var2 + 1, var3, var4)) {
                var8 = true;
            }

            if (var7 == 3 && !var1.func_28100_h(var2 - 1, var3, var4)) {
                var8 = true;
            }

            if (var7 == 4 && !var1.func_28100_h(var2, var3, var4 - 1)) {
                var8 = true;
            }

            if (var7 == 5 && !var1.func_28100_h(var2, var3, var4 + 1)) {
                var8 = true;
            }

            if (var8) {
                this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
                var1.func_690_d(var2, var3, var4, 0);
            } else if (this.field_376_bc == Block.field_9261_T.field_376_bc) {
                boolean var9 = var1.func_625_o(var2, var3, var4) || var1.func_625_o(var2, var3 + 1, var4);
                var9 = var9 || this.func_27044_a(var1, var2, var3, var4, var6, true, 0) || this.func_27044_a(var1, var2, var3, var4, var6, false, 0);
                boolean var10 = false;
                if (var9 && (var6 & 8) == 0) {
                    var1.func_691_b(var2, var3, var4, var7 | 8);
                    var10 = true;
                } else if (!var9 && (var6 & 8) != 0) {
                    var1.func_691_b(var2, var3, var4, var7);
                    var10 = true;
                }

                if (var10) {
                    var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
                    if (var7 == 2 || var7 == 3 || var7 == 4 || var7 == 5) {
                        var1.func_611_g(var2, var3 + 1, var4, this.field_376_bc);
                    }
                }
            } else if (var5 > 0 && Block.field_345_n[var5].func_209_d() && !this.field_27045_a && RailLogic.func_791_a(new RailLogic(this, var1, var2, var3, var4)) == 3) {
                this.func_4031_h(var1, var2, var3, var4, false);
            }

        }
    }

    private void func_4031_h(World var1, int var2, int var3, int var4, boolean var5) {
        if (!var1.field_1026_y) {
            (new RailLogic(this, var1, var2, var3, var4)).func_792_a(var1.func_625_o(var2, var3, var4), var5);
        }
    }

    private boolean func_27044_a(World var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
        if (var7 >= 8) {
            return false;
        } else {
            int var8 = var5 & 7;
            boolean var9 = true;
            switch(var8) {
            case 0:
                if (var6) {
                    ++var4;
                } else {
                    --var4;
                }
                break;
            case 1:
                if (var6) {
                    --var2;
                } else {
                    ++var2;
                }
                break;
            case 2:
                if (var6) {
                    --var2;
                } else {
                    ++var2;
                    ++var3;
                    var9 = false;
                }

                var8 = 1;
                break;
            case 3:
                if (var6) {
                    --var2;
                    ++var3;
                    var9 = false;
                } else {
                    ++var2;
                }

                var8 = 1;
                break;
            case 4:
                if (var6) {
                    ++var4;
                } else {
                    --var4;
                    ++var3;
                    var9 = false;
                }

                var8 = 0;
                break;
            case 5:
                if (var6) {
                    ++var4;
                    ++var3;
                    var9 = false;
                } else {
                    --var4;
                }

                var8 = 0;
            }

            if (this.func_27043_a(var1, var2, var3, var4, var6, var7, var8)) {
                return true;
            } else {
                return var9 && this.func_27043_a(var1, var2, var3 - 1, var4, var6, var7, var8);
            }
        }
    }

    private boolean func_27043_a(World var1, int var2, int var3, int var4, boolean var5, int var6, int var7) {
        int var8 = var1.func_600_a(var2, var3, var4);
        if (var8 == Block.field_9261_T.field_376_bc) {
            int var9 = var1.func_602_e(var2, var3, var4);
            int var10 = var9 & 7;
            if (var7 == 1 && (var10 == 0 || var10 == 4 || var10 == 5)) {
                return false;
            }

            if (var7 == 0 && (var10 == 1 || var10 == 2 || var10 == 3)) {
                return false;
            }

            if ((var9 & 8) != 0) {
                if (!var1.func_625_o(var2, var3, var4) && !var1.func_625_o(var2, var3 + 1, var4)) {
                    return this.func_27044_a(var1, var2, var3, var4, var9, var5, var6 + 1);
                }

                return true;
            }
        }

        return false;
    }

    public int func_31029_h() {
        return 0;
    }

    // $FF: synthetic method
    static boolean func_27039_a(BlockRail var0) {
        return var0.field_27045_a;
    }
}
