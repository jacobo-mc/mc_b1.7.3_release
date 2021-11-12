package net.minecraft.src;

import java.util.Random;

public class BlockRail extends Block {
    private final boolean field_27034_a;

    public static final boolean func_27029_g(World var0, int var1, int var2, int var3) {
        int var4 = var0.func_444_a(var1, var2, var3);
        return var4 == Block.field_637_aH.field_573_bc || var4 == Block.field_9036_T.field_573_bc || var4 == Block.field_9034_U.field_573_bc;
    }

    public static final boolean func_27030_c(int var0) {
        return var0 == Block.field_637_aH.field_573_bc || var0 == Block.field_9036_T.field_573_bc || var0 == Block.field_9034_U.field_573_bc;
    }

    protected BlockRail(int var1, int var2, boolean var3) {
        super(var1, var2, Material.field_513_n);
        this.field_27034_a = var3;
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_27028_d() {
        return this.field_27034_a;
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_240_b() {
        return false;
    }

    public MovingObjectPosition func_262_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_233_a(var1, var2, var3, var4);
        return super.func_262_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        if (var5 >= 2 && var5 <= 5) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        } else {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }

    }

    public int func_22009_a(int var1, int var2) {
        if (this.field_27034_a) {
            if (this.field_573_bc == Block.field_9036_T.field_573_bc && (var2 & 8) == 0) {
                return this.field_575_bb - 16;
            }
        } else if (var2 >= 6) {
            return this.field_575_bb - 16;
        }

        return this.field_575_bb;
    }

    public boolean func_28025_b() {
        return false;
    }

    public int func_244_a(Random var1) {
        return 1;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return var1.func_445_d(var2, var3 - 1, var4);
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        if (!var1.field_792_x) {
            this.func_4038_g(var1, var2, var3, var4, true);
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_792_x) {
            int var6 = var1.func_446_b(var2, var3, var4);
            int var7 = var6;
            if (this.field_27034_a) {
                var7 = var6 & 7;
            }

            boolean var8 = false;
            if (!var1.func_445_d(var2, var3 - 1, var4)) {
                var8 = true;
            }

            if (var7 == 2 && !var1.func_445_d(var2 + 1, var3, var4)) {
                var8 = true;
            }

            if (var7 == 3 && !var1.func_445_d(var2 - 1, var3, var4)) {
                var8 = true;
            }

            if (var7 == 4 && !var1.func_445_d(var2, var3, var4 - 1)) {
                var8 = true;
            }

            if (var7 == 5 && !var1.func_445_d(var2, var3, var4 + 1)) {
                var8 = true;
            }

            if (var8) {
                this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
                var1.func_508_d(var2, var3, var4, 0);
            } else if (this.field_573_bc == Block.field_9036_T.field_573_bc) {
                boolean var9 = var1.func_474_n(var2, var3, var4) || var1.func_474_n(var2, var3 + 1, var4);
                var9 = var9 || this.func_27032_a(var1, var2, var3, var4, var6, true, 0) || this.func_27032_a(var1, var2, var3, var4, var6, false, 0);
                boolean var10 = false;
                if (var9 && (var6 & 8) == 0) {
                    var1.func_511_b(var2, var3, var4, var7 | 8);
                    var10 = true;
                } else if (!var9 && (var6 & 8) != 0) {
                    var1.func_511_b(var2, var3, var4, var7);
                    var10 = true;
                }

                if (var10) {
                    var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
                    if (var7 == 2 || var7 == 3 || var7 == 4 || var7 == 5) {
                        var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
                    }
                }
            } else if (var5 > 0 && Block.field_542_n[var5].func_225_d() && !this.field_27034_a && RailLogic.func_600_a(new RailLogic(this, var1, var2, var3, var4)) == 3) {
                this.func_4038_g(var1, var2, var3, var4, false);
            }

        }
    }

    private void func_4038_g(World var1, int var2, int var3, int var4, boolean var5) {
        if (!var1.field_792_x) {
            (new RailLogic(this, var1, var2, var3, var4)).func_596_a(var1.func_474_n(var2, var3, var4), var5);
        }
    }

    private boolean func_27032_a(World var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
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

            if (this.func_27031_a(var1, var2, var3, var4, var6, var7, var8)) {
                return true;
            } else {
                return var9 && this.func_27031_a(var1, var2, var3 - 1, var4, var6, var7, var8);
            }
        }
    }

    private boolean func_27031_a(World var1, int var2, int var3, int var4, boolean var5, int var6, int var7) {
        int var8 = var1.func_444_a(var2, var3, var4);
        if (var8 == Block.field_9036_T.field_573_bc) {
            int var9 = var1.func_446_b(var2, var3, var4);
            int var10 = var9 & 7;
            if (var7 == 1 && (var10 == 0 || var10 == 4 || var10 == 5)) {
                return false;
            }

            if (var7 == 0 && (var10 == 1 || var10 == 2 || var10 == 3)) {
                return false;
            }

            if ((var9 & 8) != 0) {
                if (!var1.func_474_n(var2, var3, var4) && !var1.func_474_n(var2, var3 + 1, var4)) {
                    return this.func_27032_a(var1, var2, var3, var4, var9, var5, var6 + 1);
                }

                return true;
            }
        }

        return false;
    }

    public int func_31025_e() {
        return 0;
    }

    // $FF: synthetic method
    static boolean func_27033_a(BlockRail var0) {
        return var0.field_27034_a;
    }
}
