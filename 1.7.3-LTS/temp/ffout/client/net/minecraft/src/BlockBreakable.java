package net.minecraft.src;

public class BlockBreakable extends Block {
    private boolean field_6363_a;

    protected BlockBreakable(int var1, int var2, Material var3, boolean var4) {
        super(var1, var2, var3);
        this.field_6363_a = var4;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_600_a(var2, var3, var4);
        return !this.field_6363_a && var6 == this.field_376_bc ? false : super.func_260_c(var1, var2, var3, var4, var5);
    }
}
