package net.minecraft.src;

public class ContainerWorkbench extends Container {
    public InventoryCrafting field_1622_a = new InventoryCrafting(this, 3, 3);
    public IInventory field_1621_b = new InventoryCraftResult();
    private World field_20133_c;
    private int field_20132_h;
    private int field_20131_i;
    private int field_20130_j;

    public ContainerWorkbench(InventoryPlayer var1, World var2, int var3, int var4, int var5) {
        this.field_20133_c = var2;
        this.field_20132_h = var3;
        this.field_20131_i = var4;
        this.field_20130_j = var5;
        this.func_20117_a(new SlotCrafting(var1.field_844_g, this.field_1622_a, this.field_1621_b, 0, 124, 35));

        int var6;
        int var7;
        for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < 3; ++var7) {
                this.func_20117_a(new Slot(this.field_1622_a, var7 + var6 * 3, 30 + var7 * 18, 17 + var6 * 18));
            }
        }

        for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < 9; ++var7) {
                this.func_20117_a(new Slot(var1, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
            }
        }

        for(var6 = 0; var6 < 9; ++var6) {
            this.func_20117_a(new Slot(var1, var6, 8 + var6 * 18, 142));
        }

        this.func_1103_a(this.field_1622_a);
    }

    public void func_1103_a(IInventory var1) {
        this.field_1621_b.func_472_a(0, CraftingManager.func_1120_a().func_21188_a(this.field_1622_a));
    }

    public void func_1104_a(EntityPlayer var1) {
        super.func_1104_a(var1);
        if (!this.field_20133_c.field_1026_y) {
            for(int var2 = 0; var2 < 9; ++var2) {
                ItemStack var3 = this.field_1622_a.func_468_c(var2);
                if (var3 != null) {
                    var1.func_449_a(var3);
                }
            }

        }
    }

    public boolean func_20120_b(EntityPlayer var1) {
        if (this.field_20133_c.func_600_a(this.field_20132_h, this.field_20131_i, this.field_20130_j) != Block.field_387_az.field_376_bc) {
            return false;
        } else {
            return var1.func_360_d((double)this.field_20132_h + 0.5D, (double)this.field_20131_i + 0.5D, (double)this.field_20130_j + 0.5D) <= 64.0D;
        }
    }

    public ItemStack func_27279_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.field_20122_e.get(var1);
        if (var3 != null && var3.func_20005_c()) {
            ItemStack var4 = var3.func_777_b();
            var2 = var4.func_1102_e();
            if (var1 == 0) {
                this.func_28125_a(var4, 10, 46, true);
            } else if (var1 >= 10 && var1 < 37) {
                this.func_28125_a(var4, 37, 46, false);
            } else if (var1 >= 37 && var1 < 46) {
                this.func_28125_a(var4, 10, 37, false);
            } else {
                this.func_28125_a(var4, 10, 46, false);
            }

            if (var4.field_1615_a == 0) {
                var3.func_776_b((ItemStack)null);
            } else {
                var3.func_779_d();
            }

            if (var4.field_1615_a == var2.field_1615_a) {
                return null;
            }

            var3.func_4103_a(var4);
        }

        return var2;
    }
}
