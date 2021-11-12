package net.minecraft.src;

public class TileEntityFurnace extends TileEntity implements IInventory {
    private ItemStack[] field_833_a = new ItemStack[3];
    public int field_832_b = 0;
    public int field_835_c = 0;
    public int field_834_d = 0;

    public int func_469_c() {
        return this.field_833_a.length;
    }

    public ItemStack func_468_c(int var1) {
        return this.field_833_a[var1];
    }

    public ItemStack func_473_a(int var1, int var2) {
        if (this.field_833_a[var1] != null) {
            ItemStack var3;
            if (this.field_833_a[var1].field_1615_a <= var2) {
                var3 = this.field_833_a[var1];
                this.field_833_a[var1] = null;
                return var3;
            } else {
                var3 = this.field_833_a[var1].func_1085_a(var2);
                if (this.field_833_a[var1].field_1615_a == 0) {
                    this.field_833_a[var1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_472_a(int var1, ItemStack var2) {
        this.field_833_a[var1] = var2;
        if (var2 != null && var2.field_1615_a > this.func_470_e()) {
            var2.field_1615_a = this.func_470_e();
        }

    }

    public String func_471_d() {
        return "Furnace";
    }

    public void func_482_a(NBTTagCompound var1) {
        super.func_482_a(var1);
        NBTTagList var2 = var1.func_753_l("Items");
        this.field_833_a = new ItemStack[this.func_469_c()];

        for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
            byte var5 = var4.func_746_c("Slot");
            if (var5 >= 0 && var5 < this.field_833_a.length) {
                this.field_833_a[var5] = new ItemStack(var4);
            }
        }

        this.field_832_b = var1.func_745_d("BurnTime");
        this.field_834_d = var1.func_745_d("CookTime");
        this.field_835_c = this.func_488_a(this.field_833_a[1]);
    }

    public void func_481_b(NBTTagCompound var1) {
        super.func_481_b(var1);
        var1.func_749_a("BurnTime", (short)this.field_832_b);
        var1.func_749_a("CookTime", (short)this.field_834_d);
        NBTTagList var2 = new NBTTagList();

        for(int var3 = 0; var3 < this.field_833_a.length; ++var3) {
            if (this.field_833_a[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.func_761_a("Slot", (byte)var3);
                this.field_833_a[var3].func_1086_a(var4);
                var2.func_742_a(var4);
            }
        }

        var1.func_762_a("Items", var2);
    }

    public int func_470_e() {
        return 64;
    }

    public int func_490_a(int var1) {
        return this.field_834_d * var1 / 200;
    }

    public int func_489_b(int var1) {
        if (this.field_835_c == 0) {
            this.field_835_c = 200;
        }

        return this.field_832_b * var1 / this.field_835_c;
    }

    public boolean func_485_a() {
        return this.field_832_b > 0;
    }

    public void func_475_b() {
        boolean var1 = this.field_832_b > 0;
        boolean var2 = false;
        if (this.field_832_b > 0) {
            --this.field_832_b;
        }

        if (!this.field_824_e.field_1026_y) {
            if (this.field_832_b == 0 && this.func_491_j()) {
                this.field_835_c = this.field_832_b = this.func_488_a(this.field_833_a[1]);
                if (this.field_832_b > 0) {
                    var2 = true;
                    if (this.field_833_a[1] != null) {
                        --this.field_833_a[1].field_1615_a;
                        if (this.field_833_a[1].field_1615_a == 0) {
                            this.field_833_a[1] = null;
                        }
                    }
                }
            }

            if (this.func_485_a() && this.func_491_j()) {
                ++this.field_834_d;
                if (this.field_834_d == 200) {
                    this.field_834_d = 0;
                    this.func_487_i();
                    var2 = true;
                }
            } else {
                this.field_834_d = 0;
            }

            if (var1 != this.field_832_b > 0) {
                var2 = true;
                BlockFurnace.func_285_a(this.field_832_b > 0, this.field_824_e, this.field_823_f, this.field_822_g, this.field_821_h);
            }
        }

        if (var2) {
            this.func_474_j_();
        }

    }

    private boolean func_491_j() {
        if (this.field_833_a[0] == null) {
            return false;
        } else {
            ItemStack var1 = FurnaceRecipes.func_21200_a().func_21198_a(this.field_833_a[0].func_1091_a().field_291_aS);
            if (var1 == null) {
                return false;
            } else if (this.field_833_a[2] == null) {
                return true;
            } else if (!this.field_833_a[2].func_21184_a(var1)) {
                return false;
            } else if (this.field_833_a[2].field_1615_a < this.func_470_e() && this.field_833_a[2].field_1615_a < this.field_833_a[2].func_1089_c()) {
                return true;
            } else {
                return this.field_833_a[2].field_1615_a < var1.func_1089_c();
            }
        }
    }

    public void func_487_i() {
        if (this.func_491_j()) {
            ItemStack var1 = FurnaceRecipes.func_21200_a().func_21198_a(this.field_833_a[0].func_1091_a().field_291_aS);
            if (this.field_833_a[2] == null) {
                this.field_833_a[2] = var1.func_1102_e();
            } else if (this.field_833_a[2].field_1617_c == var1.field_1617_c) {
                ++this.field_833_a[2].field_1615_a;
            }

            --this.field_833_a[0].field_1615_a;
            if (this.field_833_a[0].field_1615_a <= 0) {
                this.field_833_a[0] = null;
            }

        }
    }

    private int func_488_a(ItemStack var1) {
        if (var1 == null) {
            return 0;
        } else {
            int var2 = var1.func_1091_a().field_291_aS;
            if (var2 < 256 && Block.field_345_n[var2].field_356_bn == Material.field_1335_c) {
                return 300;
            } else if (var2 == Item.field_266_B.field_291_aS) {
                return 100;
            } else if (var2 == Item.field_225_k.field_291_aS) {
                return 1600;
            } else if (var2 == Item.field_258_aw.field_291_aS) {
                return 20000;
            } else {
                return var2 == Block.field_333_z.field_376_bc ? 100 : 0;
            }
        }
    }

    public boolean func_20070_a_(EntityPlayer var1) {
        if (this.field_824_e.func_603_b(this.field_823_f, this.field_822_g, this.field_821_h) != this) {
            return false;
        } else {
            return var1.func_360_d((double)this.field_823_f + 0.5D, (double)this.field_822_g + 0.5D, (double)this.field_821_h + 0.5D) <= 64.0D;
        }
    }
}
