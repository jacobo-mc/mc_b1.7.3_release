package net.minecraft.src;

public class ContainerFurnace extends Container {
    private TileEntityFurnace field_20139_a;
    private int field_20138_b = 0;
    private int field_20141_c = 0;
    private int field_20140_h = 0;

    public ContainerFurnace(InventoryPlayer var1, TileEntityFurnace var2) {
        this.field_20139_a = var2;
        this.func_20122_a(new Slot(var2, 0, 56, 17));
        this.func_20122_a(new Slot(var2, 1, 56, 53));
        this.func_20122_a(new SlotFurnace(var1.field_497_f, var2, 2, 116, 35));

        int var3;
        for(var3 = 0; var3 < 3; ++var3) {
            for(int var4 = 0; var4 < 9; ++var4) {
                this.func_20122_a(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.func_20122_a(new Slot(var1, var3, 8 + var3 * 18, 142));
        }

    }

    public void func_20128_a(ICrafting var1) {
        super.func_20128_a(var1);
        var1.func_20056_a(this, 0, this.field_20139_a.field_486_h);
        var1.func_20056_a(this, 1, this.field_20139_a.field_488_f);
        var1.func_20056_a(this, 2, this.field_20139_a.field_487_g);
    }

    public void func_20125_a() {
        super.func_20125_a();

        for(int var1 = 0; var1 < this.field_20133_g.size(); ++var1) {
            ICrafting var2 = (ICrafting)this.field_20133_g.get(var1);
            if (this.field_20138_b != this.field_20139_a.field_486_h) {
                var2.func_20056_a(this, 0, this.field_20139_a.field_486_h);
            }

            if (this.field_20141_c != this.field_20139_a.field_488_f) {
                var2.func_20056_a(this, 1, this.field_20139_a.field_488_f);
            }

            if (this.field_20140_h != this.field_20139_a.field_487_g) {
                var2.func_20056_a(this, 2, this.field_20139_a.field_487_g);
            }
        }

        this.field_20138_b = this.field_20139_a.field_486_h;
        this.field_20141_c = this.field_20139_a.field_488_f;
        this.field_20140_h = this.field_20139_a.field_487_g;
    }

    public boolean func_20126_b(EntityPlayer var1) {
        return this.field_20139_a.func_20067_a_(var1);
    }

    public ItemStack func_27086_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.field_20135_e.get(var1);
        if (var3 != null && var3.func_27006_b()) {
            ItemStack var4 = var3.func_20092_c();
            var2 = var4.func_578_d();
            if (var1 == 2) {
                this.func_28126_a(var4, 3, 39, true);
            } else if (var1 >= 3 && var1 < 30) {
                this.func_28126_a(var4, 30, 39, false);
            } else if (var1 >= 30 && var1 < 39) {
                this.func_28126_a(var4, 3, 30, false);
            } else {
                this.func_28126_a(var4, 3, 39, false);
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
