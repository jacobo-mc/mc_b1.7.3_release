package net.minecraft.src;

public class InventoryPlayer implements IInventory {
    public ItemStack[] field_496_a = new ItemStack[36];
    public ItemStack[] field_495_b = new ItemStack[4];
    public int field_499_d = 0;
    public EntityPlayer field_497_f;
    private ItemStack field_20074_f;
    public boolean field_498_e = false;

    public InventoryPlayer(EntityPlayer var1) {
        this.field_497_f = var1;
    }

    public ItemStack func_213_b() {
        return this.field_499_d < 9 && this.field_499_d >= 0 ? this.field_496_a[this.field_499_d] : null;
    }

    public static int func_25054_e() {
        return 9;
    }

    private int func_6126_d(int var1) {
        for(int var2 = 0; var2 < this.field_496_a.length; ++var2) {
            if (this.field_496_a[var2] != null && this.field_496_a[var2].field_855_c == var1) {
                return var2;
            }
        }

        return -1;
    }

    private int func_21082_c(ItemStack var1) {
        for(int var2 = 0; var2 < this.field_496_a.length; ++var2) {
            if (this.field_496_a[var2] != null && this.field_496_a[var2].field_855_c == var1.field_855_c && this.field_496_a[var2].func_21132_c() && this.field_496_a[var2].field_853_a < this.field_496_a[var2].func_576_b() && this.field_496_a[var2].field_853_a < this.func_202_d() && (!this.field_496_a[var2].func_21128_e() || this.field_496_a[var2].func_21125_h() == var1.func_21125_h())) {
                return var2;
            }
        }

        return -1;
    }

    private int func_205_g() {
        for(int var1 = 0; var1 < this.field_496_a.length; ++var1) {
            if (this.field_496_a[var1] == null) {
                return var1;
            }
        }

        return -1;
    }

    private int func_21083_d(ItemStack var1) {
        int var2 = var1.field_855_c;
        int var3 = var1.field_853_a;
        int var4 = this.func_21082_c(var1);
        if (var4 < 0) {
            var4 = this.func_205_g();
        }

        if (var4 < 0) {
            return var3;
        } else {
            if (this.field_496_a[var4] == null) {
                this.field_496_a[var4] = new ItemStack(var2, 0, var1.func_21125_h());
            }

            int var5 = var3;
            if (var3 > this.field_496_a[var4].func_576_b() - this.field_496_a[var4].field_853_a) {
                var5 = this.field_496_a[var4].func_576_b() - this.field_496_a[var4].field_853_a;
            }

            if (var5 > this.func_202_d() - this.field_496_a[var4].field_853_a) {
                var5 = this.func_202_d() - this.field_496_a[var4].field_853_a;
            }

            if (var5 == 0) {
                return var3;
            } else {
                var3 -= var5;
                ItemStack var10000 = this.field_496_a[var4];
                var10000.field_853_a += var5;
                this.field_496_a[var4].field_852_b = 5;
                return var3;
            }
        }
    }

    public void func_210_c() {
        for(int var1 = 0; var1 < this.field_496_a.length; ++var1) {
            if (this.field_496_a[var1] != null) {
                this.field_496_a[var1].func_28143_a(this.field_497_f.field_9093_l, this.field_497_f, var1, this.field_499_d == var1);
            }
        }

    }

    public boolean func_6127_b(int var1) {
        int var2 = this.func_6126_d(var1);
        if (var2 < 0) {
            return false;
        } else {
            if (--this.field_496_a[var2].field_853_a <= 0) {
                this.field_496_a[var2] = null;
            }

            return true;
        }
    }

    public boolean func_201_a(ItemStack var1) {
        int var2;
        if (var1.func_21130_f()) {
            var2 = this.func_205_g();
            if (var2 >= 0) {
                this.field_496_a[var2] = ItemStack.func_20117_a(var1);
                this.field_496_a[var2].field_852_b = 5;
                var1.field_853_a = 0;
                return true;
            } else {
                return false;
            }
        } else {
            do {
                var2 = var1.field_853_a;
                var1.field_853_a = this.func_21083_d(var1);
            } while(var1.field_853_a > 0 && var1.field_853_a < var2);

            return var1.field_853_a < var2;
        }
    }

    public ItemStack func_20069_a(int var1, int var2) {
        ItemStack[] var3 = this.field_496_a;
        if (var1 >= this.field_496_a.length) {
            var3 = this.field_495_b;
            var1 -= this.field_496_a.length;
        }

        if (var3[var1] != null) {
            ItemStack var4;
            if (var3[var1].field_853_a <= var2) {
                var4 = var3[var1];
                var3[var1] = null;
                return var4;
            } else {
                var4 = var3[var1].func_20118_a(var2);
                if (var3[var1].field_853_a == 0) {
                    var3[var1] = null;
                }

                return var4;
            }
        } else {
            return null;
        }
    }

    public void func_206_a(int var1, ItemStack var2) {
        ItemStack[] var3 = this.field_496_a;
        if (var1 >= var3.length) {
            var1 -= var3.length;
            var3 = this.field_495_b;
        }

        var3[var1] = var2;
    }

    public float func_208_a(Block var1) {
        float var2 = 1.0F;
        if (this.field_496_a[this.field_499_d] != null) {
            var2 *= this.field_496_a[this.field_499_d].func_574_a(var1);
        }

        return var2;
    }

    public NBTTagList func_200_a(NBTTagList var1) {
        int var2;
        NBTTagCompound var3;
        for(var2 = 0; var2 < this.field_496_a.length; ++var2) {
            if (this.field_496_a[var2] != null) {
                var3 = new NBTTagCompound();
                var3.func_409_a("Slot", (byte)var2);
                this.field_496_a[var2].func_570_a(var3);
                var1.func_386_a(var3);
            }
        }

        for(var2 = 0; var2 < this.field_495_b.length; ++var2) {
            if (this.field_495_b[var2] != null) {
                var3 = new NBTTagCompound();
                var3.func_409_a("Slot", (byte)(var2 + 100));
                this.field_495_b[var2].func_570_a(var3);
                var1.func_386_a(var3);
            }
        }

        return var1;
    }

    public void func_203_b(NBTTagList var1) {
        this.field_496_a = new ItemStack[36];
        this.field_495_b = new ItemStack[4];

        for(int var2 = 0; var2 < var1.func_387_b(); ++var2) {
            NBTTagCompound var3 = (NBTTagCompound)var1.func_388_a(var2);
            int var4 = var3.func_408_b("Slot") & 255;
            ItemStack var5 = new ItemStack(var3);
            if (var5.func_569_a() != null) {
                if (var4 >= 0 && var4 < this.field_496_a.length) {
                    this.field_496_a[var4] = var5;
                }

                if (var4 >= 100 && var4 < this.field_495_b.length + 100) {
                    this.field_495_b[var4 - 100] = var5;
                }
            }
        }

    }

    public int func_83_a() {
        return this.field_496_a.length + 4;
    }

    public ItemStack func_82_a(int var1) {
        ItemStack[] var2 = this.field_496_a;
        if (var1 >= var2.length) {
            var1 -= var2.length;
            var2 = this.field_495_b;
        }

        return var2[var1];
    }

    public String func_20068_b() {
        return "Inventory";
    }

    public int func_202_d() {
        return 64;
    }

    public int func_9157_a(Entity var1) {
        ItemStack var2 = this.func_82_a(this.field_499_d);
        return var2 != null ? var2.func_9218_a(var1) : 1;
    }

    public boolean func_207_b(Block var1) {
        if (var1.field_553_bn.func_31055_i()) {
            return true;
        } else {
            ItemStack var2 = this.func_82_a(this.field_499_d);
            return var2 != null ? var2.func_573_b(var1) : false;
        }
    }

    public int func_212_e() {
        int var1 = 0;
        int var2 = 0;
        int var3 = 0;

        for(int var4 = 0; var4 < this.field_495_b.length; ++var4) {
            if (this.field_495_b[var4] != null && this.field_495_b[var4].func_569_a() instanceof ItemArmor) {
                int var5 = this.field_495_b[var4].func_571_c();
                int var6 = this.field_495_b[var4].func_21131_g();
                int var7 = var5 - var6;
                var2 += var7;
                var3 += var5;
                int var8 = ((ItemArmor)this.field_495_b[var4].func_569_a()).field_256_aY;
                var1 += var8;
            }
        }

        if (var3 == 0) {
            return 0;
        } else {
            return (var1 - 1) * var2 / var3 + 1;
        }
    }

    public void func_211_b(int var1) {
        for(int var2 = 0; var2 < this.field_495_b.length; ++var2) {
            if (this.field_495_b[var2] != null && this.field_495_b[var2].func_569_a() instanceof ItemArmor) {
                this.field_495_b[var2].func_25125_a(var1, this.field_497_f);
                if (this.field_495_b[var2].field_853_a == 0) {
                    this.field_495_b[var2].func_577_a(this.field_497_f);
                    this.field_495_b[var2] = null;
                }
            }
        }

    }

    public void func_199_f() {
        int var1;
        for(var1 = 0; var1 < this.field_496_a.length; ++var1) {
            if (this.field_496_a[var1] != null) {
                this.field_497_f.func_169_a(this.field_496_a[var1], true);
                this.field_496_a[var1] = null;
            }
        }

        for(var1 = 0; var1 < this.field_495_b.length; ++var1) {
            if (this.field_495_b[var1] != null) {
                this.field_497_f.func_169_a(this.field_495_b[var1], true);
                this.field_495_b[var1] = null;
            }
        }

    }

    public void func_183_c() {
        this.field_498_e = true;
    }

    public void func_20073_b(ItemStack var1) {
        this.field_20074_f = var1;
        this.field_497_f.func_20045_a(var1);
    }

    public ItemStack func_20072_i() {
        return this.field_20074_f;
    }

    public boolean func_20067_a_(EntityPlayer var1) {
        if (this.field_497_f.field_304_B) {
            return false;
        } else {
            return var1.func_102_b(this.field_497_f) <= 64.0D;
        }
    }

    public boolean func_28010_c(ItemStack var1) {
        int var2;
        for(var2 = 0; var2 < this.field_495_b.length; ++var2) {
            if (this.field_495_b[var2] != null && this.field_495_b[var2].func_28144_c(var1)) {
                return true;
            }
        }

        for(var2 = 0; var2 < this.field_496_a.length; ++var2) {
            if (this.field_496_a[var2] != null && this.field_496_a[var2].func_28144_c(var1)) {
                return true;
            }
        }

        return false;
    }
}
