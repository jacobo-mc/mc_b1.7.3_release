package net.minecraft.src;

public class ContainerFurnace extends Container {
    private TileEntityFurnace field_20127_a;
    private int field_20126_b = 0;
    private int field_20129_c = 0;
    private int field_20128_h = 0;

    public ContainerFurnace(InventoryPlayer var1, TileEntityFurnace var2) {
        this.field_20127_a = var2;
        this.func_20117_a(new Slot(var2, 0, 56, 17));
        this.func_20117_a(new Slot(var2, 1, 56, 53));
        this.func_20117_a(new SlotFurnace(var1.field_844_g, var2, 2, 116, 35));

        int var3;
        for(var3 = 0; var3 < 3; ++var3) {
            for(int var4 = 0; var4 < 9; ++var4) {
                this.func_20117_a(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.func_20117_a(new Slot(var1, var3, 8 + var3 * 18, 142));
        }

    }

    public void func_20114_a() {
        super.func_20114_a();

        for(int var1 = 0; var1 < this.field_20121_g.size(); ++var1) {
            ICrafting var2 = (ICrafting)this.field_20121_g.get(var1);
            if (this.field_20126_b != this.field_20127_a.field_834_d) {
                var2.func_20158_a(this, 0, this.field_20127_a.field_834_d);
            }

            if (this.field_20129_c != this.field_20127_a.field_832_b) {
                var2.func_20158_a(this, 1, this.field_20127_a.field_832_b);
            }

            if (this.field_20128_h != this.field_20127_a.field_835_c) {
                var2.func_20158_a(this, 2, this.field_20127_a.field_835_c);
            }
        }

        this.field_20126_b = this.field_20127_a.field_834_d;
        this.field_20129_c = this.field_20127_a.field_832_b;
        this.field_20128_h = this.field_20127_a.field_835_c;
    }

    public void func_20112_a(int var1, int var2) {
        if (var1 == 0) {
            this.field_20127_a.field_834_d = var2;
        }

        if (var1 == 1) {
            this.field_20127_a.field_832_b = var2;
        }

        if (var1 == 2) {
            this.field_20127_a.field_835_c = var2;
        }

    }

    public boolean func_20120_b(EntityPlayer var1) {
        return this.field_20127_a.func_20070_a_(var1);
    }

    public ItemStack func_27279_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.field_20122_e.get(var1);
        if (var3 != null && var3.func_20005_c()) {
            ItemStack var4 = var3.func_777_b();
            var2 = var4.func_1102_e();
            if (var1 == 2) {
                this.func_28125_a(var4, 3, 39, true);
            } else if (var1 >= 3 && var1 < 30) {
                this.func_28125_a(var4, 30, 39, false);
            } else if (var1 >= 30 && var1 < 39) {
                this.func_28125_a(var4, 3, 30, false);
            } else {
                this.func_28125_a(var4, 3, 39, false);
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
