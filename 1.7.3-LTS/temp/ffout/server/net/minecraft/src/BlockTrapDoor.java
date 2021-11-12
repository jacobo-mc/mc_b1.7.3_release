package net.minecraft.src;

public class BlockTrapDoor extends Block {
    protected BlockTrapDoor(int var1, Material var2) {
        super(var1, var2);
        this.field_575_bb = 84;
        if (var2 == Material.field_522_e) {
            ++this.field_575_bb;
        }

        float var3 = 0.5F;
        float var4 = 1.0F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        this.func_233_a(var1, var2, var3, var4);
        return super.func_248_d(var1, var2, var3, var4);
    }

    public void func_233_a(IBlockAccess var1, int var2, int var3, int var4) {
        this.func_28039_c(var1.func_446_b(var2, var3, var4));
    }

    public void func_28039_c(int var1) {
        float var2 = 0.1875F;
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, var2, 1.0F);
        if (func_28038_d(var1)) {
            if ((var1 & 3) == 0) {
                this.func_229_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }

            if ((var1 & 3) == 1) {
                this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }

            if ((var1 & 3) == 2) {
                this.func_229_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if ((var1 & 3) == 3) {
                this.func_229_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
        }

    }

    public void func_235_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_246_a(var1, var2, var3, var4, var5);
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (this.field_553_bn == Material.field_522_e) {
            return true;
        } else {
            int var6 = var1.func_446_b(var2, var3, var4);
            var1.func_511_b(var2, var3, var4, var6 ^ 4);
            var1.func_28101_a(var5, 1003, var2, var3, var4, 0);
            return true;
        }
    }

    public void func_28040_a(World var1, int var2, int var3, int var4, boolean var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        boolean var7 = (var6 & 4) > 0;
        if (var7 != var5) {
            var1.func_511_b(var2, var3, var4, var6 ^ 4);
            var1.func_28101_a((EntityPlayer)null, 1003, var2, var3, var4, 0);
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_792_x) {
            int var6 = var1.func_446_b(var2, var3, var4);
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

            if (!var1.func_445_d(var7, var3, var8)) {
                var1.func_508_d(var2, var3, var4, 0);
                this.func_247_a_(var1, var2, var3, var4, var6);
            }

            if (var5 > 0 && Block.field_542_n[var5].func_225_d()) {
                boolean var9 = var1.func_474_n(var2, var3, var4);
                this.func_28040_a(var1, var2, var3, var4, var9);
            }

        }
    }

    public MovingObjectPosition func_262_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_233_a(var1, var2, var3, var4);
        return super.func_262_a(var1, var2, var3, var4, var5, var6);
    }

    public void func_255_c(World var1, int var2, int var3, int var4, int var5) {
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

        var1.func_511_b(var2, var3, var4, var6);
    }

    public boolean func_28026_e(World var1, int var2, int var3, int var4, int var5) {
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

            return var1.func_445_d(var2, var3, var4);
        }
    }

    public static boolean func_28038_d(int var0) {
        return (var0 & 4) != 0;
    }
}
