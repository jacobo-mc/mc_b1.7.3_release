package net.minecraft.src;

public class BlockFence extends Block {
    public BlockFence(int var1, int var2) {
        super(var1, var2, Material.field_524_c);
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        if (var1.func_444_a(var2, var3 - 1, var4) == this.field_573_bc) {
            return true;
        } else {
            return !var1.func_443_c(var2, var3 - 1, var4).func_216_a() ? false : super.func_259_a(var1, var2, var3, var4);
        }
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.func_693_b((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)var3 + 1.5F), (double)(var4 + 1));
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_28025_b() {
        return false;
    }
}
