package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {
    private boolean field_652_a = true;
    private Set field_21032_b = new HashSet();

    public BlockRedstoneWire(int var1, int var2) {
        super(var1, var2, Material.field_513_n);
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public int func_22009_a(int var1, int var2) {
        return this.field_575_bb;
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return var1.func_445_d(var2, var3 - 1, var4);
    }

    private void func_292_g(World var1, int var2, int var3, int var4) {
        this.func_21031_a(var1, var2, var3, var4, var2, var3, var4);
        ArrayList var5 = new ArrayList(this.field_21032_b);
        this.field_21032_b.clear();

        for(int var6 = 0; var6 < var5.size(); ++var6) {
            ChunkPosition var7 = (ChunkPosition)var5.get(var6);
            var1.func_449_g(var7.field_846_a, var7.field_845_b, var7.field_847_c, this.field_573_bc);
        }

    }

    private void func_21031_a(World var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = var1.func_446_b(var2, var3, var4);
        int var9 = 0;
        this.field_652_a = false;
        boolean var10 = var1.func_474_n(var2, var3, var4);
        this.field_652_a = true;
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
                    var9 = this.func_290_f(var1, var12, var3, var13, var9);
                }

                if (var1.func_445_d(var12, var3, var13) && !var1.func_445_d(var2, var3 + 1, var4)) {
                    if (var12 != var5 || var3 + 1 != var6 || var13 != var7) {
                        var9 = this.func_290_f(var1, var12, var3 + 1, var13, var9);
                    }
                } else if (!var1.func_445_d(var12, var3, var13) && (var12 != var5 || var3 - 1 != var6 || var13 != var7)) {
                    var9 = this.func_290_f(var1, var12, var3 - 1, var13, var9);
                }
            }

            if (var9 > 0) {
                --var9;
            } else {
                var9 = 0;
            }
        }

        if (var8 != var9) {
            var1.field_808_h = true;
            var1.func_511_b(var2, var3, var4, var9);
            var1.func_519_b(var2, var3, var4, var2, var3, var4);
            var1.field_808_h = false;

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

                if (var1.func_445_d(var12, var3, var13)) {
                    var14 += 2;
                }

                boolean var15 = false;
                int var16 = this.func_290_f(var1, var12, var3, var13, -1);
                var9 = var1.func_446_b(var2, var3, var4);
                if (var9 > 0) {
                    --var9;
                }

                if (var16 >= 0 && var16 != var9) {
                    this.func_21031_a(var1, var12, var3, var13, var2, var3, var4);
                }

                var16 = this.func_290_f(var1, var12, var14, var13, -1);
                var9 = var1.func_446_b(var2, var3, var4);
                if (var9 > 0) {
                    --var9;
                }

                if (var16 >= 0 && var16 != var9) {
                    this.func_21031_a(var1, var12, var14, var13, var2, var3, var4);
                }
            }

            if (var8 == 0 || var9 == 0) {
                this.field_21032_b.add(new ChunkPosition(var2, var3, var4));
                this.field_21032_b.add(new ChunkPosition(var2 - 1, var3, var4));
                this.field_21032_b.add(new ChunkPosition(var2 + 1, var3, var4));
                this.field_21032_b.add(new ChunkPosition(var2, var3 - 1, var4));
                this.field_21032_b.add(new ChunkPosition(var2, var3 + 1, var4));
                this.field_21032_b.add(new ChunkPosition(var2, var3, var4 - 1));
                this.field_21032_b.add(new ChunkPosition(var2, var3, var4 + 1));
            }
        }

    }

    private void func_291_h(World var1, int var2, int var3, int var4) {
        if (var1.func_444_a(var2, var3, var4) == this.field_573_bc) {
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            var1.func_449_g(var2 - 1, var3, var4, this.field_573_bc);
            var1.func_449_g(var2 + 1, var3, var4, this.field_573_bc);
            var1.func_449_g(var2, var3, var4 - 1, this.field_573_bc);
            var1.func_449_g(var2, var3, var4 + 1, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
        }
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        super.func_250_e(var1, var2, var3, var4);
        if (!var1.field_792_x) {
            this.func_292_g(var1, var2, var3, var4);
            var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            this.func_291_h(var1, var2 - 1, var3, var4);
            this.func_291_h(var1, var2 + 1, var3, var4);
            this.func_291_h(var1, var2, var3, var4 - 1);
            this.func_291_h(var1, var2, var3, var4 + 1);
            if (var1.func_445_d(var2 - 1, var3, var4)) {
                this.func_291_h(var1, var2 - 1, var3 + 1, var4);
            } else {
                this.func_291_h(var1, var2 - 1, var3 - 1, var4);
            }

            if (var1.func_445_d(var2 + 1, var3, var4)) {
                this.func_291_h(var1, var2 + 1, var3 + 1, var4);
            } else {
                this.func_291_h(var1, var2 + 1, var3 - 1, var4);
            }

            if (var1.func_445_d(var2, var3, var4 - 1)) {
                this.func_291_h(var1, var2, var3 + 1, var4 - 1);
            } else {
                this.func_291_h(var1, var2, var3 - 1, var4 - 1);
            }

            if (var1.func_445_d(var2, var3, var4 + 1)) {
                this.func_291_h(var1, var2, var3 + 1, var4 + 1);
            } else {
                this.func_291_h(var1, var2, var3 - 1, var4 + 1);
            }

        }
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        super.func_242_b(var1, var2, var3, var4);
        if (!var1.field_792_x) {
            var1.func_449_g(var2, var3 + 1, var4, this.field_573_bc);
            var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            this.func_292_g(var1, var2, var3, var4);
            this.func_291_h(var1, var2 - 1, var3, var4);
            this.func_291_h(var1, var2 + 1, var3, var4);
            this.func_291_h(var1, var2, var3, var4 - 1);
            this.func_291_h(var1, var2, var3, var4 + 1);
            if (var1.func_445_d(var2 - 1, var3, var4)) {
                this.func_291_h(var1, var2 - 1, var3 + 1, var4);
            } else {
                this.func_291_h(var1, var2 - 1, var3 - 1, var4);
            }

            if (var1.func_445_d(var2 + 1, var3, var4)) {
                this.func_291_h(var1, var2 + 1, var3 + 1, var4);
            } else {
                this.func_291_h(var1, var2 + 1, var3 - 1, var4);
            }

            if (var1.func_445_d(var2, var3, var4 - 1)) {
                this.func_291_h(var1, var2, var3 + 1, var4 - 1);
            } else {
                this.func_291_h(var1, var2, var3 - 1, var4 - 1);
            }

            if (var1.func_445_d(var2, var3, var4 + 1)) {
                this.func_291_h(var1, var2, var3 + 1, var4 + 1);
            } else {
                this.func_291_h(var1, var2, var3 - 1, var4 + 1);
            }

        }
    }

    private int func_290_f(World var1, int var2, int var3, int var4, int var5) {
        if (var1.func_444_a(var2, var3, var4) != this.field_573_bc) {
            return var5;
        } else {
            int var6 = var1.func_446_b(var2, var3, var4);
            return var6 > var5 ? var6 : var5;
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_792_x) {
            int var6 = var1.func_446_b(var2, var3, var4);
            boolean var7 = this.func_259_a(var1, var2, var3, var4);
            if (!var7) {
                this.func_247_a_(var1, var2, var3, var4, var6);
                var1.func_508_d(var2, var3, var4, 0);
            } else {
                this.func_292_g(var1, var2, var3, var4);
            }

            super.func_234_b(var1, var2, var3, var4, var5);
        }
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_252_aA.field_234_aS;
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        return !this.field_652_a ? false : this.func_239_b(var1, var2, var3, var4, var5);
    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.field_652_a) {
            return false;
        } else if (var1.func_446_b(var2, var3, var4) == 0) {
            return false;
        } else if (var5 == 1) {
            return true;
        } else {
            boolean var6 = func_293_b(var1, var2 - 1, var3, var4, 1) || !var1.func_445_d(var2 - 1, var3, var4) && func_293_b(var1, var2 - 1, var3 - 1, var4, -1);
            boolean var7 = func_293_b(var1, var2 + 1, var3, var4, 3) || !var1.func_445_d(var2 + 1, var3, var4) && func_293_b(var1, var2 + 1, var3 - 1, var4, -1);
            boolean var8 = func_293_b(var1, var2, var3, var4 - 1, 2) || !var1.func_445_d(var2, var3, var4 - 1) && func_293_b(var1, var2, var3 - 1, var4 - 1, -1);
            boolean var9 = func_293_b(var1, var2, var3, var4 + 1, 0) || !var1.func_445_d(var2, var3, var4 + 1) && func_293_b(var1, var2, var3 - 1, var4 + 1, -1);
            if (!var1.func_445_d(var2, var3 + 1, var4)) {
                if (var1.func_445_d(var2 - 1, var3, var4) && func_293_b(var1, var2 - 1, var3 + 1, var4, -1)) {
                    var6 = true;
                }

                if (var1.func_445_d(var2 + 1, var3, var4) && func_293_b(var1, var2 + 1, var3 + 1, var4, -1)) {
                    var7 = true;
                }

                if (var1.func_445_d(var2, var3, var4 - 1) && func_293_b(var1, var2, var3 + 1, var4 - 1, -1)) {
                    var8 = true;
                }

                if (var1.func_445_d(var2, var3, var4 + 1) && func_293_b(var1, var2, var3 + 1, var4 + 1, -1)) {
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

    public boolean func_225_d() {
        return this.field_652_a;
    }

    public static boolean func_293_b(IBlockAccess var0, int var1, int var2, int var3, int var4) {
        int var5 = var0.func_444_a(var1, var2, var3);
        if (var5 == Block.field_591_aw.field_573_bc) {
            return true;
        } else if (var5 == 0) {
            return false;
        } else if (Block.field_542_n[var5].func_225_d()) {
            return true;
        } else if (var5 != Block.field_22011_bh.field_573_bc && var5 != Block.field_22010_bi.field_573_bc) {
            return false;
        } else {
            int var6 = var0.func_446_b(var1, var2, var3);
            return var4 == ModelBed.field_22153_b[var6 & 3];
        }
    }
}
