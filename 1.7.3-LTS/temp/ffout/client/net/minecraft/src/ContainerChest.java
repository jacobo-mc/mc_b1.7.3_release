package net.minecraft.src;

public class ContainerChest extends Container {
    private IInventory field_20125_a;
    private int field_27282_b;

    public ContainerChest(IInventory var1, IInventory var2) {
        this.field_20125_a = var2;
        this.field_27282_b = var2.func_469_c() / 9;
        int var3 = (this.field_27282_b - 4) * 18;

        int var4;
        int var5;
        for(var4 = 0; var4 < this.field_27282_b; ++var4) {
            for(var5 = 0; var5 < 9; ++var5) {
                this.func_20117_a(new Slot(var2, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18));
            }
        }

        for(var4 = 0; var4 < 3; ++var4) {
            for(var5 = 0; var5 < 9; ++var5) {
                this.func_20117_a(new Slot(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
            }
        }

        for(var4 = 0; var4 < 9; ++var4) {
            this.func_20117_a(new Slot(var1, var4, 8 + var4 * 18, 161 + var3));
        }

    }

    public boolean func_20120_b(EntityPlayer var1) {
        return this.field_20125_a.func_20070_a_(var1);
    }

    public ItemStack func_27279_a(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.field_20122_e.get(var1);
        if (var3 != null && var3.func_20005_c()) {
            ItemStack var4 = var3.func_777_b();
            var2 = var4.func_1102_e();
            if (var1 < this.field_27282_b * 9) {
                this.func_28125_a(var4, this.field_27282_b * 9, this.field_20122_e.size(), true);
            } else {
                this.func_28125_a(var4, 0, this.field_27282_b * 9, false);
            }

            if (var4.field_1615_a == 0) {
                var3.func_776_b((ItemStack)null);
            } else {
                var3.func_779_d();
            }
        }

        return var2;
    }
}
