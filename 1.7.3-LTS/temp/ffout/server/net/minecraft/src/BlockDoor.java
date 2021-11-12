package net.minecraft.src;

import java.util.Random;

public class BlockDoor extends Block {
    protected BlockDoor(int var1, Material var2) {
        super(var1, var2);
        this.field_575_bb = 97;
        if (var2 == Material.field_522_e) {
            ++this.field_575_bb;
        }

        float var3 = 0.5F;
        float var4 = 1.0F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
    }

    public int func_22009_a(int var1, int var2) {
        if (var1 != 0 && var1 != 1) {
            int var3 = this.func_271_d(var2);
            if ((var3 == 0 || var3 == 2) ^ var1 <= 3) {
                return this.field_575_bb;
            } else {
                int var4 = var3 / 2 + (var1 & 1 ^ var3);
                var4 += (var2 & 4) / 4;
                int var5 = this.field_575_bb - (var2 & 8) * 2;
                if ((var4 & 1) != 0) {
                    var5 = -var5;
                }

                return var5;
            }
        } else {
            return this.field_575_bb;
        }
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
        this.func_273_b(this.func_271_d(var1.func_446_b(var2, var3, var4)));
    }

    public void func_273_b(int var1) {
        float var2 = 0.1875F;
        this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        if (var1 == 0) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
        }

        if (var1 == 1) {
            this.func_229_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var1 == 2) {
            this.func_229_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
        }

        if (var1 == 3) {
            this.func_229_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
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
            if ((var6 & 8) != 0) {
                if (var1.func_444_a(var2, var3 - 1, var4) == this.field_573_bc) {
                    this.func_246_a(var1, var2, var3 - 1, var4, var5);
                }

                return true;
            } else {
                if (var1.func_444_a(var2, var3 + 1, var4) == this.field_573_bc) {
                    var1.func_511_b(var2, var3 + 1, var4, (var6 ^ 4) + 8);
                }

                var1.func_511_b(var2, var3, var4, var6 ^ 4);
                var1.func_519_b(var2, var3 - 1, var4, var2, var3, var4);
                var1.func_28101_a(var5, 1003, var2, var3, var4, 0);
                return true;
            }
        }
    }

    public void func_272_a(World var1, int var2, int var3, int var4, boolean var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        if ((var6 & 8) != 0) {
            if (var1.func_444_a(var2, var3 - 1, var4) == this.field_573_bc) {
                this.func_272_a(var1, var2, var3 - 1, var4, var5);
            }

        } else {
            boolean var7 = (var1.func_446_b(var2, var3, var4) & 4) > 0;
            if (var7 != var5) {
                if (var1.func_444_a(var2, var3 + 1, var4) == this.field_573_bc) {
                    var1.func_511_b(var2, var3 + 1, var4, (var6 ^ 4) + 8);
                }

                var1.func_511_b(var2, var3, var4, var6 ^ 4);
                var1.func_519_b(var2, var3 - 1, var4, var2, var3, var4);
                var1.func_28101_a((EntityPlayer)null, 1003, var2, var3, var4, 0);
            }
        }
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_446_b(var2, var3, var4);
        if ((var6 & 8) != 0) {
            if (var1.func_444_a(var2, var3 - 1, var4) != this.field_573_bc) {
                var1.func_508_d(var2, var3, var4, 0);
            }

            if (var5 > 0 && Block.field_542_n[var5].func_225_d()) {
                this.func_234_b(var1, var2, var3 - 1, var4, var5);
            }
        } else {
            boolean var7 = false;
            if (var1.func_444_a(var2, var3 + 1, var4) != this.field_573_bc) {
                var1.func_508_d(var2, var3, var4, 0);
                var7 = true;
            }

            if (!var1.func_445_d(var2, var3 - 1, var4)) {
                var1.func_508_d(var2, var3, var4, 0);
                var7 = true;
                if (var1.func_444_a(var2, var3 + 1, var4) == this.field_573_bc) {
                    var1.func_508_d(var2, var3 + 1, var4, 0);
                }
            }

            if (var7) {
                if (!var1.field_792_x) {
                    this.func_247_a_(var1, var2, var3, var4, var6);
                }
            } else if (var5 > 0 && Block.field_542_n[var5].func_225_d()) {
                boolean var8 = var1.func_474_n(var2, var3, var4) || var1.func_474_n(var2, var3 + 1, var4);
                this.func_272_a(var1, var2, var3, var4, var8);
            }
        }

    }

    public int func_252_a(int var1, Random var2) {
        if ((var1 & 8) != 0) {
            return 0;
        } else {
            return this.field_553_bn == Material.field_522_e ? Item.field_195_az.field_234_aS : Item.field_208_at.field_234_aS;
        }
    }

    public MovingObjectPosition func_262_a(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.func_233_a(var1, var2, var3, var4);
        return super.func_262_a(var1, var2, var3, var4, var5, var6);
    }

    public int func_271_d(int var1) {
        return (var1 & 4) == 0 ? var1 - 1 & 3 : var1 & 3;
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        if (var3 >= 127) {
            return false;
        } else {
            return var1.func_445_d(var2, var3 - 1, var4) && super.func_259_a(var1, var2, var3, var4) && super.func_259_a(var1, var2, var3 + 1, var4);
        }
    }

    public static boolean func_27036_e(int var0) {
        return (var0 & 4) != 0;
    }

    public int func_31025_e() {
        return 1;
    }
}
