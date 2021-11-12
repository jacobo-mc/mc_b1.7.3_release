package net.minecraft.src;

public class BlockFence extends Block {
    public BlockFence(int var1, int var2) {
        super(var1, var2, Material.field_1335_c);
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        if (var1.func_600_a(var2, var3 - 1, var4) == this.field_376_bc) {
            return true;
        } else {
            return !var1.func_599_f(var2, var3 - 1, var4).func_878_a() ? false : super.func_243_a(var1, var2, var3, var4);
        }
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_1161_b((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)var3 + 1.5F), (double)(var4 + 1));
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_210_f() {
        return 11;
    }
}
