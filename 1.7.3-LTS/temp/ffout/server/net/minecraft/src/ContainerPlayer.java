package net.minecraft.src;

public class ContainerPlayer extends Container {
    public InventoryCrafting field_20143_a;
    public IInventory field_20142_b;
    public boolean field_20144_c;

    public ContainerPlayer(InventoryPlayer var1) {
        this(var1, true);
    }

    public ContainerPlayer(InventoryPlayer var1, boolean var2) {
        this.field_20143_a = new InventoryCrafting(this, 2, 2);
        this.field_20142_b = new InventoryCraftResult();
        this.field_20144_c = false;
        this.field_20144_c = var2;
        this.func_20122_a(new SlotCrafting(var1.field_497_f, this.field_20143_a, this.field_20142_b, 0, 144, 36));

        int var3;
        int var4;
        for(var3 = 0; var3 < 2; ++var3) {
            for(var4 = 0; var4 < 2; ++var4) {
                this.func_20122_a(new Slot(this.field_20143_a, var4 + var3 * 2, 88 + var4 * 18, 26 + var3 * 18));
            }
        }

        for(var3 = 0; var3 < 4; ++var3) {
            this.func_20122_a(new SlotArmor(this, var1, var1.func_83_a() - 1 - var3, 8, 8 + var3 * 18, var3));
        }

        for(var3 = 0; var3 < 3; ++var3) {
            for(var4 = 0; var4 < 9; ++var4) {
                this.func_20122_a(new Slot(var1, var4 + (var3 + 1) * 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.func_20122_a(new Slot(var1, var3, 8 + var3 * 18, 142));
        }

        this.func_20121_a(this.field_20143_a);
    }

    public void func_20121_a(IInventory var1) {
        this.field_20142_b.func_206_a(0, CraftingManager.func_20151_a().func_21147_a(this.field_20143_a));
    }

    public void func_20130_a(EntityPlayer var1) {
        super.func_20130_a(var1);

        for(int var2 = 0; var2 < 4; ++var2) {
            ItemStack var3 = this.field_20143_a.func_82_a(var2);
            if (var3 != null) {
                var1.func_20044_b(var3);
                this.field_20143_a.func_206_a(var2, (ItemStack)null);
            }
        }

    }

    public boolean func_20126_b(EntityPlayer var1) {
        return true;
    }

    public ItemStack func_27086_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.field_20135_e.get(var1);
        if (var3 != null && var3.func_27006_b()) {
            ItemStack var4 = var3.func_20092_c();
            var2 = var4.func_578_d();
            if (var1 == 0) {
                this.func_28126_a(var4, 9, 45, true);
            } else if (var1 >= 9 && var1 < 36) {
                this.func_28126_a(var4, 36, 45, false);
            } else if (var1 >= 36 && var1 < 45) {
                this.func_28126_a(var4, 9, 36, false);
            } else {
                this.func_28126_a(var4, 9, 45, false);
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
