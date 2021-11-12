package net.minecraft.src;

public class TileEntityNote extends TileEntity {
    public byte field_21077_e = 0;
    public boolean field_21076_f = false;

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        var1.func_409_a("note", this.field_21077_e);
    }

    public void func_186_a(NBTTagCompound var1) {
        super.func_186_a(var1);
        this.field_21077_e = var1.func_408_b("note");
        if (this.field_21077_e < 0) {
            this.field_21077_e = 0;
        }

        if (this.field_21077_e > 24) {
            this.field_21077_e = 24;
        }

    }

    public void func_21075_a() {
        this.field_21077_e = (byte)((this.field_21077_e + 1) % 25);
        this.func_31001_i();
    }

    public void func_21074_a(World var1, int var2, int var3, int var4) {
        if (var1.func_443_c(var2, var3 + 1, var4) == Material.field_526_a) {
            Material var5 = var1.func_443_c(var2, var3 - 1, var4);
            byte var6 = 0;
            if (var5 == Material.field_523_d) {
                var6 = 1;
            }

            if (var5 == Material.field_514_m) {
                var6 = 2;
            }

            if (var5 == Material.field_4216_o) {
                var6 = 3;
            }

            if (var5 == Material.field_524_c) {
                var6 = 4;
            }

            var1.func_21117_c(var2, var3, var4, var6, this.field_21077_e);
        }
    }
}
