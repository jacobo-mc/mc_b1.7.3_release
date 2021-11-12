package net.minecraft.src;

import java.util.Random;

public class TileEntityDispenser extends TileEntity implements IInventory {
    private ItemStack[] field_21081_e = new ItemStack[9];
    private Random field_21080_f = new Random();

    public int func_83_a() {
        return 9;
    }

    public ItemStack func_82_a(int var1) {
        return this.field_21081_e[var1];
    }

    public ItemStack func_20069_a(int var1, int var2) {
        if (this.field_21081_e[var1] != null) {
            ItemStack var3;
            if (this.field_21081_e[var1].field_853_a <= var2) {
                var3 = this.field_21081_e[var1];
                this.field_21081_e[var1] = null;
                this.func_183_c();
                return var3;
            } else {
                var3 = this.field_21081_e[var1].func_20118_a(var2);
                if (this.field_21081_e[var1].field_853_a == 0) {
                    this.field_21081_e[var1] = null;
                }

                this.func_183_c();
                return var3;
            }
        } else {
            return null;
        }
    }

    public ItemStack func_21079_e() {
        int var1 = -1;
        int var2 = 1;

        for(int var3 = 0; var3 < this.field_21081_e.length; ++var3) {
            if (this.field_21081_e[var3] != null && this.field_21080_f.nextInt(var2++) == 0) {
                var1 = var3;
            }
        }

        if (var1 >= 0) {
            return this.func_20069_a(var1, 1);
        } else {
            return null;
        }
    }

    public void func_206_a(int var1, ItemStack var2) {
        this.field_21081_e[var1] = var2;
        if (var2 != null && var2.field_853_a > this.func_202_d()) {
            var2.field_853_a = this.func_202_d();
        }

        this.func_183_c();
    }

    public String func_20068_b() {
        return "Trap";
    }

    public void func_186_a(NBTTagCompound var1) {
        super.func_186_a(var1);
        NBTTagList var2 = var1.func_407_k("Items");
        this.field_21081_e = new ItemStack[this.func_83_a()];

        for(int var3 = 0; var3 < var2.func_387_b(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.func_388_a(var3);
            int var5 = var4.func_408_b("Slot") & 255;
            if (var5 >= 0 && var5 < this.field_21081_e.length) {
                this.field_21081_e[var5] = new ItemStack(var4);
            }
        }

    }

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        NBTTagList var2 = new NBTTagList();

        for(int var3 = 0; var3 < this.field_21081_e.length; ++var3) {
            if (this.field_21081_e[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.func_409_a("Slot", (byte)var3);
                this.field_21081_e[var3].func_570_a(var4);
                var2.func_386_a(var4);
            }
        }

        var1.func_399_a("Items", var2);
    }

    public int func_202_d() {
        return 64;
    }

    public boolean func_20067_a_(EntityPlayer var1) {
        if (this.field_479_a.func_451_k(this.field_478_b, this.field_483_c, this.field_482_d) != this) {
            return false;
        } else {
            return var1.func_101_d((double)this.field_478_b + 0.5D, (double)this.field_483_c + 0.5D, (double)this.field_482_d + 0.5D) <= 64.0D;
        }
    }
}
