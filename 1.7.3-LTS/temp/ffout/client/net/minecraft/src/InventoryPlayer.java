package net.minecraft.src;

public class InventoryPlayer implements IInventory {
    public ItemStack[] field_843_a = new ItemStack[36];
    public ItemStack[] field_842_b = new ItemStack[4];
    public int field_847_d = 0;
    public EntityPlayer field_844_g;
    private ItemStack field_20077_f;
    public boolean field_845_f = false;

    public InventoryPlayer(EntityPlayer var1) {
        this.field_844_g = var1;
    }

    public ItemStack func_494_a() {
        return this.field_847_d < 9 && this.field_847_d >= 0 ? this.field_843_a[this.field_847_d] : null;
    }

    private int func_505_f(int var1) {
        for(int var2 = 0; var2 < this.field_843_a.length; ++var2) {
            if (this.field_843_a[var2] != null && this.field_843_a[var2].field_1617_c == var1) {
                return var2;
            }
        }

        return -1;
    }

    private int func_21105_c(ItemStack var1) {
        for(int var2 = 0; var2 < this.field_843_a.length; ++var2) {
            if (this.field_843_a[var2] != null && this.field_843_a[var2].field_1617_c == var1.field_1617_c && this.field_843_a[var2].func_21180_d() && this.field_843_a[var2].field_1615_a < this.field_843_a[var2].func_1089_c() && this.field_843_a[var2].field_1615_a < this.func_470_e() && (!this.field_843_a[var2].func_21183_f() || this.field_843_a[var2].func_21181_i() == var1.func_21181_i())) {
                return var2;
            }
        }

        return -1;
    }

    private int func_499_j() {
        for(int var1 = 0; var1 < this.field_843_a.length; ++var1) {
            if (this.field_843_a[var1] == null) {
                return var1;
            }
        }

        return -1;
    }

    public void func_496_a(int var1, boolean var2) {
        int var3 = this.func_505_f(var1);
        if (var3 >= 0 && var3 < 9) {
            this.field_847_d = var3;
        }
    }

    public void func_498_a(int var1) {
        if (var1 > 0) {
            var1 = 1;
        }

        if (var1 < 0) {
            var1 = -1;
        }

        for(this.field_847_d -= var1; this.field_847_d < 0; this.field_847_d += 9) {
        }

        while(this.field_847_d >= 9) {
            this.field_847_d -= 9;
        }

    }

    private int func_21106_d(ItemStack var1) {
        int var2 = var1.field_1617_c;
        int var3 = var1.field_1615_a;
        int var4 = this.func_21105_c(var1);
        if (var4 < 0) {
            var4 = this.func_499_j();
        }

        if (var4 < 0) {
            return var3;
        } else {
            if (this.field_843_a[var4] == null) {
                this.field_843_a[var4] = new ItemStack(var2, 0, var1.func_21181_i());
            }

            int var5 = var3;
            if (var3 > this.field_843_a[var4].func_1089_c() - this.field_843_a[var4].field_1615_a) {
                var5 = this.field_843_a[var4].func_1089_c() - this.field_843_a[var4].field_1615_a;
            }

            if (var5 > this.func_470_e() - this.field_843_a[var4].field_1615_a) {
                var5 = this.func_470_e() - this.field_843_a[var4].field_1615_a;
            }

            if (var5 == 0) {
                return var3;
            } else {
                var3 -= var5;
                ItemStack var10000 = this.field_843_a[var4];
                var10000.field_1615_a += var5;
                this.field_843_a[var4].field_1614_b = 5;
                return var3;
            }
        }
    }

    public void func_511_b() {
        for(int var1 = 0; var1 < this.field_843_a.length; ++var1) {
            if (this.field_843_a[var1] != null) {
                this.field_843_a[var1].func_28153_a(this.field_844_g.field_615_ag, this.field_844_g, var1, this.field_847_d == var1);
            }
        }

    }

    public boolean func_510_b(int var1) {
        int var2 = this.func_505_f(var1);
        if (var2 < 0) {
            return false;
        } else {
            if (--this.field_843_a[var2].field_1615_a <= 0) {
                this.field_843_a[var2] = null;
            }

            return true;
        }
    }

    public boolean func_504_a(ItemStack var1) {
        int var2;
        if (var1.func_21185_g()) {
            var2 = this.func_499_j();
            if (var2 >= 0) {
                this.field_843_a[var2] = ItemStack.func_30010_b(var1);
                this.field_843_a[var2].field_1614_b = 5;
                var1.field_1615_a = 0;
                return true;
            } else {
                return false;
            }
        } else {
            do {
                var2 = var1.field_1615_a;
                var1.field_1615_a = this.func_21106_d(var1);
            } while(var1.field_1615_a > 0 && var1.field_1615_a < var2);

            return var1.field_1615_a < var2;
        }
    }

    public ItemStack func_473_a(int var1, int var2) {
        ItemStack[] var3 = this.field_843_a;
        if (var1 >= this.field_843_a.length) {
            var3 = this.field_842_b;
            var1 -= this.field_843_a.length;
        }

        if (var3[var1] != null) {
            ItemStack var4;
            if (var3[var1].field_1615_a <= var2) {
                var4 = var3[var1];
                var3[var1] = null;
                return var4;
            } else {
                var4 = var3[var1].func_1085_a(var2);
                if (var3[var1].field_1615_a == 0) {
                    var3[var1] = null;
                }

                return var4;
            }
        } else {
            return null;
        }
    }

    public void func_472_a(int var1, ItemStack var2) {
        ItemStack[] var3 = this.field_843_a;
        if (var1 >= var3.length) {
            var1 -= var3.length;
            var3 = this.field_842_b;
        }

        var3[var1] = var2;
    }

    public float func_508_a(Block var1) {
        float var2 = 1.0F;
        if (this.field_843_a[this.field_847_d] != null) {
            var2 *= this.field_843_a[this.field_847_d].func_1098_a(var1);
        }

        return var2;
    }

    public NBTTagList func_493_a(NBTTagList var1) {
        int var2;
        NBTTagCompound var3;
        for(var2 = 0; var2 < this.field_843_a.length; ++var2) {
            if (this.field_843_a[var2] != null) {
                var3 = new NBTTagCompound();
                var3.func_761_a("Slot", (byte)var2);
                this.field_843_a[var2].func_1086_a(var3);
                var1.func_742_a(var3);
            }
        }

        for(var2 = 0; var2 < this.field_842_b.length; ++var2) {
            if (this.field_842_b[var2] != null) {
                var3 = new NBTTagCompound();
                var3.func_761_a("Slot", (byte)(var2 + 100));
                this.field_842_b[var2].func_1086_a(var3);
                var1.func_742_a(var3);
            }
        }

        return var1;
    }

    public void func_513_b(NBTTagList var1) {
        this.field_843_a = new ItemStack[36];
        this.field_842_b = new ItemStack[4];

        for(int var2 = 0; var2 < var1.func_740_c(); ++var2) {
            NBTTagCompound var3 = (NBTTagCompound)var1.func_741_a(var2);
            int var4 = var3.func_746_c("Slot") & 255;
            ItemStack var5 = new ItemStack(var3);
            if (var5.func_1091_a() != null) {
                if (var4 >= 0 && var4 < this.field_843_a.length) {
                    this.field_843_a[var4] = var5;
                }

                if (var4 >= 100 && var4 < this.field_842_b.length + 100) {
                    this.field_842_b[var4 - 100] = var5;
                }
            }
        }

    }

    public int func_469_c() {
        return this.field_843_a.length + 4;
    }

    public ItemStack func_468_c(int var1) {
        ItemStack[] var2 = this.field_843_a;
        if (var1 >= var2.length) {
            var1 -= var2.length;
            var2 = this.field_842_b;
        }

        return var2[var1];
    }

    public String func_471_d() {
        return "Inventory";
    }

    public int func_470_e() {
        return 64;
    }

    public int func_502_a(Entity var1) {
        ItemStack var2 = this.func_468_c(this.field_847_d);
        return var2 != null ? var2.func_1095_a(var1) : 1;
    }

    public boolean func_509_b(Block var1) {
        if (var1.field_356_bn.func_31061_i()) {
            return true;
        } else {
            ItemStack var2 = this.func_468_c(this.field_847_d);
            return var2 != null ? var2.func_1099_b(var1) : false;
        }
    }

    public ItemStack func_492_d(int var1) {
        return this.field_842_b[var1];
    }

    public int func_506_f() {
        int var1 = 0;
        int var2 = 0;
        int var3 = 0;

        for(int var4 = 0; var4 < this.field_842_b.length; ++var4) {
            if (this.field_842_b[var4] != null && this.field_842_b[var4].func_1091_a() instanceof ItemArmor) {
                int var5 = this.field_842_b[var4].func_1094_d();
                int var6 = this.field_842_b[var4].func_21179_h();
                int var7 = var5 - var6;
                var2 += var7;
                var3 += var5;
                int var8 = ((ItemArmor)this.field_842_b[var4].func_1091_a()).field_312_aY;
                var1 += var8;
            }
        }

        if (var3 == 0) {
            return 0;
        } else {
            return (var1 - 1) * var2 / var3 + 1;
        }
    }

    public void func_507_e(int var1) {
        for(int var2 = 0; var2 < this.field_842_b.length; ++var2) {
            if (this.field_842_b[var2] != null && this.field_842_b[var2].func_1091_a() instanceof ItemArmor) {
                this.field_842_b[var2].func_25190_a(var1, this.field_844_g);
                if (this.field_842_b[var2].field_1615_a == 0) {
                    this.field_842_b[var2].func_1097_a(this.field_844_g);
                    this.field_842_b[var2] = null;
                }
            }
        }

    }

    public void func_503_g() {
        int var1;
        for(var1 = 0; var1 < this.field_843_a.length; ++var1) {
            if (this.field_843_a[var1] != null) {
                this.field_844_g.func_444_a(this.field_843_a[var1], true);
                this.field_843_a[var1] = null;
            }
        }

        for(var1 = 0; var1 < this.field_842_b.length; ++var1) {
            if (this.field_842_b[var1] != null) {
                this.field_844_g.func_444_a(this.field_842_b[var1], true);
                this.field_842_b[var1] = null;
            }
        }

    }

    public void func_474_j_() {
        this.field_845_f = true;
    }

    public void func_20076_b(ItemStack var1) {
        this.field_20077_f = var1;
        this.field_844_g.func_20058_b(var1);
    }

    public ItemStack func_20075_i() {
        return this.field_20077_f;
    }

    public boolean func_20070_a_(EntityPlayer var1) {
        if (this.field_844_g.field_646_aA) {
            return false;
        } else {
            return var1.func_387_e(this.field_844_g) <= 64.0D;
        }
    }

    public boolean func_28018_c(ItemStack var1) {
        int var2;
        for(var2 = 0; var2 < this.field_842_b.length; ++var2) {
            if (this.field_842_b[var2] != null && this.field_842_b[var2].func_28154_b(var1)) {
                return true;
            }
        }

        for(var2 = 0; var2 < this.field_843_a.length; ++var2) {
            if (this.field_843_a[var2] != null && this.field_843_a[var2].func_28154_b(var1)) {
                return true;
            }
        }

        return false;
    }
}
