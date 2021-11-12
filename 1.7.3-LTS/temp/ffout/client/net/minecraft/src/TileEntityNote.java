package net.minecraft.src;

public class TileEntityNote extends TileEntity {
    public byte field_21097_a = 0;
    public boolean field_21096_b = false;

    public void func_481_b(NBTTagCompound var1) {
        super.func_481_b(var1);
        var1.func_761_a("note", this.field_21097_a);
    }

    public void func_482_a(NBTTagCompound var1) {
        super.func_482_a(var1);
        this.field_21097_a = var1.func_746_c("note");
        if (this.field_21097_a < 0) {
            this.field_21097_a = 0;
        }

        if (this.field_21097_a > 24) {
            this.field_21097_a = 24;
        }

    }

    public void func_21095_a() {
        this.field_21097_a = (byte)((this.field_21097_a + 1) % 25);
        this.func_474_j_();
    }

    public void func_21094_a(World var1, int var2, int var3, int var4) {
        if (var1.func_599_f(var2, var3 + 1, var4) == Material.field_1337_a) {
            Material var5 = var1.func_599_f(var2, var3 - 1, var4);
            byte var6 = 0;
            if (var5 == Material.field_1334_d) {
                var6 = 1;
            }

            if (var5 == Material.field_1325_m) {
                var6 = 2;
            }

            if (var5 == Material.field_4263_o) {
                var6 = 3;
            }

            if (var5 == Material.field_1335_c) {
                var6 = 4;
            }

            var1.func_21116_c(var2, var3, var4, var6, this.field_21097_a);
        }
    }
}
