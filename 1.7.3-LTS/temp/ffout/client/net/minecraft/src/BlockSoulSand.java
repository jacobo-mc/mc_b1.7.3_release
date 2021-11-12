package net.minecraft.src;

public class BlockSoulSand extends Block {
    public BlockSoulSand(int var1, int var2) {
        super(var1, var2, Material.field_1325_m);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        float var5 = 0.125F;
        return AxisAlignedBB.func_1161_b((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)(var3 + 1) - var5), (double)(var4 + 1));
    }

    public void func_236_b(World var1, int var2, int var3, int var4, Entity var5) {
        var5.field_608_an *= 0.4D;
        var5.field_606_ap *= 0.4D;
    }
}
