package net.minecraft.src;

public class TileEntityFurnace extends TileEntity implements IInventory {
    private ItemStack[] field_489_e = new ItemStack[3];
    public int field_488_f = 0;
    public int field_487_g = 0;
    public int field_486_h = 0;

    public int func_83_a() {
        return this.field_489_e.length;
    }

    public ItemStack func_82_a(int var1) {
        return this.field_489_e[var1];
    }

    public ItemStack func_20069_a(int var1, int var2) {
        if (this.field_489_e[var1] != null) {
            ItemStack var3;
            if (this.field_489_e[var1].field_853_a <= var2) {
                var3 = this.field_489_e[var1];
                this.field_489_e[var1] = null;
                return var3;
            } else {
                var3 = this.field_489_e[var1].func_20118_a(var2);
                if (this.field_489_e[var1].field_853_a == 0) {
                    this.field_489_e[var1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_206_a(int var1, ItemStack var2) {
        this.field_489_e[var1] = var2;
        if (var2 != null && var2.field_853_a > this.func_202_d()) {
            var2.field_853_a = this.func_202_d();
        }

    }

    public String func_20068_b() {
        return "Furnace";
    }

    public void func_186_a(NBTTagCompound var1) {
        super.func_186_a(var1);
        NBTTagList var2 = var1.func_407_k("Items");
        this.field_489_e = new ItemStack[this.func_83_a()];

        for(int var3 = 0; var3 < var2.func_387_b(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.func_388_a(var3);
            byte var5 = var4.func_408_b("Slot");
            if (var5 >= 0 && var5 < this.field_489_e.length) {
                this.field_489_e[var5] = new ItemStack(var4);
            }
        }

        this.field_488_f = var1.func_406_c("BurnTime");
        this.field_486_h = var1.func_406_c("CookTime");
        this.field_487_g = this.func_194_a(this.field_489_e[1]);
    }

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        var1.func_394_a("BurnTime", (short)this.field_488_f);
        var1.func_394_a("CookTime", (short)this.field_486_h);
        NBTTagList var2 = new NBTTagList();

        for(int var3 = 0; var3 < this.field_489_e.length; ++var3) {
            if (this.field_489_e[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.func_409_a("Slot", (byte)var3);
                this.field_489_e[var3].func_570_a(var4);
                var2.func_386_a(var4);
            }
        }

        var1.func_399_a("Items", var2);
    }

    public int func_202_d() {
        return 64;
    }

    public boolean func_191_e() {
        return this.field_488_f > 0;
    }

    public void func_184_b() {
        boolean var1 = this.field_488_f > 0;
        boolean var2 = false;
        if (this.field_488_f > 0) {
            --this.field_488_f;
        }

        if (!this.field_479_a.field_792_x) {
            if (this.field_488_f == 0 && this.func_193_g()) {
                this.field_487_g = this.field_488_f = this.func_194_a(this.field_489_e[1]);
                if (this.field_488_f > 0) {
                    var2 = true;
                    if (this.field_489_e[1] != null) {
                        --this.field_489_e[1].field_853_a;
                        if (this.field_489_e[1].field_853_a == 0) {
                            this.field_489_e[1] = null;
                        }
                    }
                }
            }

            if (this.func_191_e() && this.func_193_g()) {
                ++this.field_486_h;
                if (this.field_486_h == 200) {
                    this.field_486_h = 0;
                    this.func_189_f();
                    var2 = true;
                }
            } else {
                this.field_486_h = 0;
            }

            if (var1 != this.field_488_f > 0) {
                var2 = true;
                BlockFurnace.func_295_a(this.field_488_f > 0, this.field_479_a, this.field_478_b, this.field_483_c, this.field_482_d);
            }
        }

        if (var2) {
            this.func_183_c();
        }

    }

    private boolean func_193_g() {
        if (this.field_489_e[0] == null) {
            return false;
        } else {
            ItemStack var1 = FurnaceRecipes.func_21162_a().func_21161_a(this.field_489_e[0].func_569_a().field_234_aS);
            if (var1 == null) {
                return false;
            } else if (this.field_489_e[2] == null) {
                return true;
            } else if (!this.field_489_e[2].func_21127_a(var1)) {
                return false;
            } else if (this.field_489_e[2].field_853_a < this.func_202_d() && this.field_489_e[2].field_853_a < this.field_489_e[2].func_576_b()) {
                return true;
            } else {
                return this.field_489_e[2].field_853_a < var1.func_576_b();
            }
        }
    }

    public void func_189_f() {
        if (this.func_193_g()) {
            ItemStack var1 = FurnaceRecipes.func_21162_a().func_21161_a(this.field_489_e[0].func_569_a().field_234_aS);
            if (this.field_489_e[2] == null) {
                this.field_489_e[2] = var1.func_578_d();
            } else if (this.field_489_e[2].field_855_c == var1.field_855_c) {
                ++this.field_489_e[2].field_853_a;
            }

            --this.field_489_e[0].field_853_a;
            if (this.field_489_e[0].field_853_a <= 0) {
                this.field_489_e[0] = null;
            }

        }
    }

    private int func_194_a(ItemStack var1) {
        if (var1 == null) {
            return 0;
        } else {
            int var2 = var1.func_569_a().field_234_aS;
            if (var2 < 256 && Block.field_542_n[var2].field_553_bn == Material.field_524_c) {
                return 300;
            } else if (var2 == Item.field_209_B.field_234_aS) {
                return 100;
            } else if (var2 == Item.field_168_k.field_234_aS) {
                return 1600;
            } else if (var2 == Item.field_201_aw.field_234_aS) {
                return 20000;
            } else {
                return var2 == Block.field_6047_y.field_573_bc ? 100 : 0;
            }
        }
    }

    public boolean func_20067_a_(EntityPlayer var1) {
        if (this.field_479_a.func_451_k(this.field_478_b, this.field_483_c, this.field_482_d) != this) {
            return false;
        } else {
            return var1.func_101_d((double)this.field_478_b + 0.5D, (double)this.field_483_c + 0.5D, (double)this.field_482_d + 0.5D) <= 64.0D;
        }
    }
}
