package net.minecraft.src;

public class ContainerWorkbench extends Container {
    public InventoryCrafting field_20146_a = new InventoryCrafting(this, 3, 3);
    public IInventory field_20145_b = new InventoryCraftResult();
    private World field_20150_c;
    private int field_20149_h;
    private int field_20148_i;
    private int field_20147_j;

    public ContainerWorkbench(InventoryPlayer var1, World var2, int var3, int var4, int var5) {
        this.field_20150_c = var2;
        this.field_20149_h = var3;
        this.field_20148_i = var4;
        this.field_20147_j = var5;
        this.func_20122_a(new SlotCrafting(var1.field_497_f, this.field_20146_a, this.field_20145_b, 0, 124, 35));

        int var6;
        int var7;
        for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < 3; ++var7) {
                this.func_20122_a(new Slot(this.field_20146_a, var7 + var6 * 3, 30 + var7 * 18, 17 + var6 * 18));
            }
        }

        for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < 9; ++var7) {
                this.func_20122_a(new Slot(var1, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
            }
        }

        for(var6 = 0; var6 < 9; ++var6) {
            this.func_20122_a(new Slot(var1, var6, 8 + var6 * 18, 142));
        }

        this.func_20121_a(this.field_20146_a);
    }

    public void func_20121_a(IInventory var1) {
        this.field_20145_b.func_206_a(0, CraftingManager.func_20151_a().func_21147_a(this.field_20146_a));
    }

    public void func_20130_a(EntityPlayer var1) {
        super.func_20130_a(var1);
        if (!this.field_20150_c.field_792_x) {
            for(int var2 = 0; var2 < 9; ++var2) {
                ItemStack var3 = this.field_20146_a.func_82_a(var2);
                if (var3 != null) {
                    var1.func_20044_b(var3);
                }
            }

        }
    }

    public boolean func_20126_b(EntityPlayer var1) {
        if (this.field_20150_c.func_444_a(this.field_20149_h, this.field_20148_i, this.field_20147_j) != Block.field_9044_ay.field_573_bc) {
            return false;
        } else {
            return var1.func_101_d((double)this.field_20149_h + 0.5D, (double)this.field_20148_i + 0.5D, (double)this.field_20147_j + 0.5D) <= 64.0D;
        }
    }

    public ItemStack func_27086_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.field_20135_e.get(var1);
        if (var3 != null && var3.func_27006_b()) {
            ItemStack var4 = var3.func_20092_c();
            var2 = var4.func_578_d();
            if (var1 == 0) {
                this.func_28126_a(var4, 10, 46, true);
            } else if (var1 >= 10 && var1 < 37) {
                this.func_28126_a(var4, 37, 46, false);
            } else if (var1 >= 37 && var1 < 46) {
                this.func_28126_a(var4, 10, 37, false);
            } else {
                this.func_28126_a(var4, 10, 46, false);
            }

            if (var4.field_853_a == 0) {
                var3.func_20089_b((ItemStack)null);
            } else {
                var3.func_20094_d();
            }

            if (var4.field_853_a == var2.field_853_a) {
                return null;
            }

            var3.func_20091_b(var4);
        }

        return var2;
    }
}
