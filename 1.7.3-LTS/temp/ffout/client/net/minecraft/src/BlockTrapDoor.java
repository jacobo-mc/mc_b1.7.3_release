package net.minecraft.src;

public class BlockTrapDoor extends Block {
    protected BlockTrapDoor(int var1, Material var2) {
        super(var1, var2);
        this.field_378_bb = 84;
        if (var2 == Material.field_1333_e) {
            ++this.field_378_bb;
        }

        float var3 = 0.5F;
        float var4 = 1.0F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 0;
    }

    public AxisAlignedBB func_246_f(World var1, int var2, int var3, int var4) {
        this.func_238_a(var1, var2, var3, var4);
        return super.func_246_f(var1, var2, var3, var4);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        this.func_238_a(var1, var2, var3, var4);
        return super.func_221_d(var1, var2, var3, var4);
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        this.func_28043_c(var1.func_602_e(var2, var3, var4));
    }

    public void func_237_e() {
        float var1 = 0.1875F;
        this.func_213_a(0.0F, 0.5F - var1 / 2.0F, 0.0F, 1.0F, 0.5F + var1 / 2.0F, 1.0F);
    }

    public void func_28043_c(int var1) {
        float var2 = 0.1875F;
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, var2, 1.0F);
        if (func_28041_d(var1)) {
            if ((var1 & 3) == 0) {
                this.func_213_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }

            if ((var1 & 3) == 1) {
                this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }

            if ((var1 & 3) == 2) {
                this.func_213_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if ((var1 & 3) == 3) {
                this.func_213_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
        }

    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_250_a(var1, var2, var3, var4, var5);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (this.field_356_bn == Material.field_1333_e) {
            return true;
        } else {
            int var6 = var1.func_602_e(var2, var3, var4);
            var1.func_691_b(var2, var3, var4, var6 ^ 4);
            var1.func_28107_a(var5, 1003, var2, var3, var4, 0);
            return true;
        }
    }

    public void func_28042_a(World var1, int var2, int var3, int var4, boolean var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        boolean var7 = (var6 & 4) > 0;
        if (var7 != var5) {
            var1.func_691_b(var2, var3, var4, var6 ^ 4);
            var1.func_28107_a((EntityPlayer)null, 1003, var2, var3, var4, 0);
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y) {
            int var6 = var1.func_602_e(var2, var3, var4);
            int var7 = var2;
            int var8 = var4;
            if ((var6 & 3) == 0) {
                var8 = var4 + 1;
            }

            if ((var6 & 3) == 1) {
                --var8;
            }

            if ((var6 & 3) == 2) {
                var7 = var2 + 1;
            }

            if ((var6 & 3) == 3) {
                --var7;
            }

            if (!var1.func_28100_h(var7, var3, var8)) {
                var1.func_690_d(var2, var3, var4, 0);
                this.func_259_b_(var1, var2, var3, var4, var6);
            }

            if (var5 > 0 && Block.field_345_n[var5].func_209_d()) {
                boolean var9 = var1.func_625_o(var2, var3, var4);
                this.func_28042_a(var1, var2, var3, var4, var9);
            }

        }
    }

    public MovingObjectPosition func_255_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_238_a(var1, var2, var3, var4);
        return super.func_255_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_258_d(World var1, int var2, int var3, int var4, int var5) {
        byte var6 = 0;
        if (var5 == 2) {
            var6 = 0;
        }

        if (var5 == 3) {
            var6 = 1;
        }

        if (var5 == 4) {
            var6 = 2;
        }

        if (var5 == 5) {
            var6 = 3;
        }

        var1.func_691_b(var2, var3, var4, var6);
    }

    public boolean func_28030_e(World var1, int var2, int var3, int var4, int var5) {
        if (var5 == 0) {
            return false;
        } else if (var5 == 1) {
            return false;
        } else {
            if (var5 == 2) {
                ++var4;
            }

            if (var5 == 3) {
                --var4;
            }

            if (var5 == 4) {
                ++var2;
            }

            if (var5 == 5) {
                --var2;
            }

            return var1.func_28100_h(var2, var3, var4);
        }
    }

    public static boolean func_28041_d(int var0) {
        return (var0 & 4) != 0;
    }
}
