package net.minecraft.src;

public class BlockPumpkin extends Block {
    private boolean blockType;

    protected BlockPumpkin(int var1, int var2, boolean var3) {
        super(var1, Material.pumpkin);
        this.blockIndexInTexture = var2;
        this.setTickOnLoad(true);
        this.blockType = var3;
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var1 == 1) {
            return this.blockIndexInTexture;
        } else if (var1 == 0) {
            return this.blockIndexInTexture;
        } else {
            int var3 = this.blockIndexInTexture + 1 + 16;
            if (this.blockType) {
                ++var3;
            }

            if (var2 == 2 && var1 == 2) {
                return var3;
            } else if (var2 == 3 && var1 == 5) {
                return var3;
            } else if (var2 == 0 && var1 == 3) {
                return var3;
            } else {
                return var2 == 1 && var1 == 4 ? var3 : this.blockIndexInTexture + 16;
            }
        }
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture;
        } else if (var1 == 0) {
            return this.blockIndexInTexture;
        } else {
            return var1 == 3 ? this.blockIndexInTexture + 1 + 16 : this.blockIndexInTexture + 16;
        }
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        super.onBlockAdded(var1, var2, var3, var4);
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockId(var2, var3, var4);
        return (var5 == 0 || Block.blocksList[var5].blockMaterial.func_27090_g()) && var1.isBlockNormalCube(var2, var3 - 1, var4);
    }

    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
    }
}
