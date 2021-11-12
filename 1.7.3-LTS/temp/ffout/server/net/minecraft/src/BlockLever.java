package net.minecraft.src;

public class BlockLever extends Block {
    protected BlockLever(int var1, int var2) {
        super(var1, var2, Material.field_513_n);
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

    public boolean func_28026_e(World var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1 && var1.func_445_d(var2, var3 - 1, var4)) {
            return true;
        } else if (var5 == 2 && var1.func_445_d(var2, var3, var4 + 1)) {
            return true;
        } else if (var5 == 3 && var1.func_445_d(var2, var3, var4 - 1)) {
            return true;
        } else if (var5 == 4 && var1.func_445_d(var2 + 1, var3, var4)) {
            return true;
        } else {
            return var5 == 5 && var1.func_445_d(var2 - 1, var3, var4);
        }
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        if (var1.func_445_d(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.func_445_d(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.func_445_d(var2, var3, var4 - 1)) {
            return true;
        } else if (var1.func_445_d(var2, var3, var4 + 1)) {
            return true;
        } else {
            return var1.func_445_d(var2, var3 - 1, var4);
        }
    }

    public void func_255_c(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        int var7 = var6 & 8;
        var6 &= 7;
        var6 = -1;
        if (var5 == 1 && var1.func_445_d(var2, var3 - 1, var4)) {
            var6 = 5 + var1.field_803_m.nextInt(2);
        }

        if (var5 == 2 && var1.func_445_d(var2, var3, var4 + 1)) {
            var6 = 4;
        }

        if (var5 == 3 && var1.func_445_d(var2, var3, var4 - 1)) {
            var6 = 3;
        }

        if (var5 == 4 && var1.func_445_d(var2 + 1, var3, var4)) {
            var6 = 2;
        }

        if (var5 == 5 && var1.func_445_d(var2 - 1, var3, var4)) {
            var6 = 1;
        }

        if (var6 == -1) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        } else {
            var1.func_511_b(var2, var3, var4, var6 + var7);
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (this.func_274_g(var1, var2, var3, var4)) {
            int var6 = var1.func_446_b(var2, var3, var4) & 7;
            boolean var7 = false;
            if (!var1.func_445_d(var2 - 1, var3, var4) && var6 == 1) {
                var7 = true;
            }

            if (!var1.func_445_d(var2 + 1, var3, var4) && var6 == 2) {
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3, var4 - 1) && var6 == 3) {
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3, var4 + 1) && var6 == 4) {
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3 - 1, var4) && var6 == 5) {
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3 - 1, var4) && var6 == 6) {
                var7 = true;
            }

            if (var7) {
                this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
                var1.func_508_d(var2, var3, var4, 0);
            }
        }

    }

    private boolean func_274_g(World var1, int var2, int var3, int var4) {
        if (!this.func_259_a(var1, var2, var3, var4)) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4) & 7;
        float var6 = 0.1875F;
        if (var5 == 1) {
            this.func_229_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
        } else if (var5 == 2) {
            this.func_229_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
        } else if (var5 == 3) {
            this.func_229_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
        } else if (var5 == 4) {
            this.func_229_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
        } else {
            var6 = 0.25F;
            this.func_229_a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
        }

    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_246_a(var1, var2, var3, var4, var5);
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_792_x) {
            return true;
        } else {
            int var6 = var1.func_446_b(var2, var3, var4);
            int var7 = var6 & 7;
            int var8 = 8 - (var6 & 8);
            var1.func_511_b(var2, var3, var4, var7 + var8);
            var1.func_519_b(var2, var3, var4, var2, var3, var4);
            var1.func_502_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.click", 0.3F, var8 > 0 ? 0.6F : 0.5F);
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            if (var7 == 1) {
                var1.func_449_g(var2 - 1, var3, var4, this.field_573_bc);
            } else if (var7 == 2) {
                var1.func_449_g(var2 + 1, var3, var4, this.field_573_bc);
            } else if (var7 == 3) {
                var1.func_449_g(var2, var3, var4 - 1, this.field_573_bc);
            } else if (var7 == 4) {
                var1.func_449_g(var2, var3, var4 + 1, this.field_573_bc);
            } else {
                var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            }

            return true;
        }
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        if ((var5 & 8) > 0) {
            var1.func_449_g(var2, var3, var4, this.field_573_bc);
            int var6 = var5 & 7;
            if (var6 == 1) {
                var1.func_449_g(var2 - 1, var3, var4, this.field_573_bc);
            } else if (var6 == 2) {
                var1.func_449_g(var2 + 1, var3, var4, this.field_573_bc);
            } else if (var6 == 3) {
                var1.func_449_g(var2, var3, var4 - 1, this.field_573_bc);
            } else if (var6 == 4) {
                var1.func_449_g(var2, var3, var4 + 1, this.field_573_bc);
            } else {
                var1.func_449_g(var2, var3 - 1, var4, this.field_573_bc);
            }
        }

        super.func_242_b(var1, var2, var3, var4);
    }

    public boolean func_239_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return (var1.func_446_b(var2, var3, var4) & 8) > 0;
    }

    public boolean func_238_d(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        if ((var6 & 8) == 0) {
            return false;
        } else {
            int var7 = var6 & 7;
            if (var7 == 6 && var5 == 1) {
                return true;
            } else if (var7 == 5 && var5 == 1) {
                return true;
            } else if (var7 == 4 && var5 == 2) {
                return true;
            } else if (var7 == 3 && var5 == 3) {
                return true;
            } else if (var7 == 2 && var5 == 4) {
                return true;
            } else {
                return var7 == 1 && var5 == 5;
            }
        }
    }

    public boolean func_225_d() {
        return true;
    }
}
