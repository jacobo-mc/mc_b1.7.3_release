package net.minecraft.src;

public class BlockNote extends BlockContainer {
    public BlockNote(int var1) {
        super(var1, 74, Material.field_1335_c);
    }

    public int func_218_a(int var1) {
        return this.field_378_bb;
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (var5 > 0 && Block.field_345_n[var5].func_209_d()) {
            boolean var6 = var1.func_646_n(var2, var3, var4);
            TileEntityNote var7 = (TileEntityNote)var1.func_603_b(var2, var3, var4);
            if (var7.field_21096_b != var6) {
                if (var6) {
                    var7.func_21094_a(var1, var2, var3, var4);
                }

                var7.field_21096_b = var6;
            }
        }

    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_1026_y) {
            return true;
        } else {
            TileEntityNote var6 = (TileEntityNote)var1.func_603_b(var2, var3, var4);
            var6.func_21095_a();
            var6.func_21094_a(var1, var2, var3, var4);
            return true;
        }
    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (!var1.field_1026_y) {
            TileEntityNote var6 = (TileEntityNote)var1.func_603_b(var2, var3, var4);
            var6.func_21094_a(var1, var2, var3, var4);
        }
    }

    protected TileEntity func_283_a_() {
        return new TileEntityNote();
    }

    public void func_21024_a(World var1, int var2, int var3, int var4, int var5, int var6) {
        float var7 = (float)Math.pow(2.0D, (double)(var6 - 12) / 12.0D);
        String var8 = "harp";
        if (var5 == 1) {
            var8 = "bd";
        }

        if (var5 == 2) {
            var8 = "snare";
        }

        if (var5 == 3) {
            var8 = "hat";
        }

        if (var5 == 4) {
            var8 = "bassattack";
        }

        var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "note." + var8, 3.0F, var7);
        var1.func_694_a("note", (double)var2 + 0.5D, (double)var3 + 1.2D, (double)var4 + 0.5D, (double)var6 / 24.0D, 0.0D, 0.0D);
    }
}
