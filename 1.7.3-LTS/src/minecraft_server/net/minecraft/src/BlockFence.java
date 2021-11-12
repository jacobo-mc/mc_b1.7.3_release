package net.minecraft.src;

public class BlockFence extends Block {
    public BlockFence(int var1, int var2) {
        super(var1, var2, Material.wood);
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        if (var1.getBlockId(var2, var3 - 1, var4) == this.blockID) {
            return true;
        } else {
            return !var1.getBlockMaterial(var2, var3 - 1, var4).isSolid() ? false : super.canPlaceBlockAt(var1, var2, var3, var4);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.getBoundingBoxFromPool((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)var3 + 1.5F), (double)(var4 + 1));
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isACube() {
        return false;
    }
}
