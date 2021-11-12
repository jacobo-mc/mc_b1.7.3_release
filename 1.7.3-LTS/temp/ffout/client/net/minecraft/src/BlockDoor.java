package net.minecraft.src;

import java.util.Random;

public class BlockDoor extends Block {
    protected BlockDoor(int var1, Material var2) {
        super(var1, var2);
        this.field_378_bb = 97;
        if (var2 == Material.field_1333_e) {
            ++this.field_378_bb;
        }

        float var3 = 0.5F;
        float var4 = 1.0F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
    }

    public int func_232_a(int var1, int var2) {
        if (var1 != 0 && var1 != 1) {
            int var3 = this.func_312_c(var2);
            if ((var3 == 0 || var3 == 2) ^ var1 <= 3) {
                return this.field_378_bb;
            } else {
                int var4 = var3 / 2 + (var1 & 1 ^ var3);
                var4 += (var2 & 4) / 4;
                int var5 = this.field_378_bb - (var2 & 8) * 2;
                if ((var4 & 1) != 0) {
                    var5 = -var5;
                }

                return var5;
            }
        } else {
            return this.field_378_bb;
        }
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 7;
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
        this.func_313_b(this.func_312_c(var1.func_602_e(var2, var3, var4)));
    }

    public void func_313_b(int var1) {
        float var2 = 0.1875F;
        this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        if (var1 == 0) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
        }

        if (var1 == 1) {
            this.func_213_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var1 == 2) {
            this.func_213_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
        }

        if (var1 == 3) {
            this.func_213_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
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
            if ((var6 & 8) != 0) {
                if (var1.func_600_a(var2, var3 - 1, var4) == this.field_376_bc) {
                    this.func_250_a(var1, var2, var3 - 1, var4, var5);
                }

                return true;
            } else {
                if (var1.func_600_a(var2, var3 + 1, var4) == this.field_376_bc) {
                    var1.func_691_b(var2, var3 + 1, var4, (var6 ^ 4) + 8);
                }

                var1.func_691_b(var2, var3, var4, var6 ^ 4);
                var1.func_701_b(var2, var3 - 1, var4, var2, var3, var4);
                var1.func_28107_a(var5, 1003, var2, var3, var4, 0);
                return true;
            }
        }
    }

    public void func_311_a(World var1, int var2, int var3, int var4, boolean var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        if ((var6 & 8) != 0) {
            if (var1.func_600_a(var2, var3 - 1, var4) == this.field_376_bc) {
                this.func_311_a(var1, var2, var3 - 1, var4, var5);
            }

        } else {
            boolean var7 = (var1.func_602_e(var2, var3, var4) & 4) > 0;
            if (var7 != var5) {
                if (var1.func_600_a(var2, var3 + 1, var4) == this.field_376_bc) {
                    var1.func_691_b(var2, var3 + 1, var4, (var6 ^ 4) + 8);
                }

                var1.func_691_b(var2, var3, var4, var6 ^ 4);
                var1.func_701_b(var2, var3 - 1, var4, var2, var3, var4);
                var1.func_28107_a((EntityPlayer)null, 1003, var2, var3, var4, 0);
            }
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        if ((var6 & 8) != 0) {
            if (var1.func_600_a(var2, var3 - 1, var4) != this.field_376_bc) {
                var1.func_690_d(var2, var3, var4, 0);
            }

            if (var5 > 0 && Block.field_345_n[var5].func_209_d()) {
                this.func_226_a(var1, var2, var3 - 1, var4, var5);
            }
        } else {
            boolean var7 = false;
            if (var1.func_600_a(var2, var3 + 1, var4) != this.field_376_bc) {
                var1.func_690_d(var2, var3, var4, 0);
                var7 = true;
            }

            if (!var1.func_28100_h(var2, var3 - 1, var4)) {
                var1.func_690_d(var2, var3, var4, 0);
                var7 = true;
                if (var1.func_600_a(var2, var3 + 1, var4) == this.field_376_bc) {
                    var1.func_690_d(var2, var3 + 1, var4, 0);
                }
            }

            if (var7) {
                if (!var1.field_1026_y) {
                    this.func_259_b_(var1, var2, var3, var4, var6);
                }
            } else if (var5 > 0 && Block.field_345_n[var5].func_209_d()) {
                boolean var8 = var1.func_625_o(var2, var3, var4) || var1.func_625_o(var2, var3 + 1, var4);
                this.func_311_a(var1, var2, var3, var4, var8);
            }
        }

    }

    public int func_240_a(int var1, Random var2) {
        if ((var1 & 8) != 0) {
            return 0;
        } else {
            return this.field_356_bn == Material.field_1333_e ? Item.field_252_az.field_291_aS : Item.field_265_at.field_291_aS;
        }
    }

    public MovingObjectPosition func_255_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_238_a(var1, var2, var3, var4);
        return super.func_255_a(var1, var2, var3, var4, var5, var6);
    }

    public int func_312_c(int var1) {
        return (var1 & 4) == 0 ? var1 - 1 & 3 : var1 & 3;
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        if (var3 >= 127) {
            return false;
        } else {
            return var1.func_28100_h(var2, var3 - 1, var4) && super.func_243_a(var1, var2, var3, var4) && super.func_243_a(var1, var2, var3 + 1, var4);
        }
    }

    public static boolean func_27047_e(int var0) {
        return (var0 & 4) != 0;
    }

    public int func_31029_h() {
        return 1;
    }
}
