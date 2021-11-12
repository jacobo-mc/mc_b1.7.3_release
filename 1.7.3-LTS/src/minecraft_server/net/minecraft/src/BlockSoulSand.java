package net.minecraft.src;

public class BlockSoulSand extends Block {
    public BlockSoulSand(int var1, int var2) {
        super(var1, var2, Material.sand);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        float var5 = 0.125F;
        return AxisAlignedBB.getBoundingBoxFromPool((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)(var3 + 1) - var5), (double)(var4 + 1));
    }

    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
        var5.motionX *= 0.4D;
        var5.motionZ *= 0.4D;
    }
}
