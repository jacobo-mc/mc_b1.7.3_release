package net.minecraft.src;

public class ItemDoor extends Item {
    private Material doorMaterial;

    public ItemDoor(int var1, Material var2) {
        super(var1);
        this.doorMaterial = var2;
        this.maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var7 != 1) {
            return false;
        } else {
            ++var5;
            Block var8;
            if (this.doorMaterial == Material.wood) {
                var8 = Block.doorWood;
            } else {
                var8 = Block.doorSteel;
            }

            if (!var8.canPlaceBlockAt(var3, var4, var5, var6)) {
                return false;
            } else {
                int var9 = MathHelper.floor_double((double)((var2.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                byte var10 = 0;
                byte var11 = 0;
                if (var9 == 0) {
                    var11 = 1;
                }

                if (var9 == 1) {
                    var10 = -1;
                }

                if (var9 == 2) {
                    var11 = -1;
                }

                if (var9 == 3) {
                    var10 = 1;
                }

                int var12 = (var3.isBlockNormalCube(var4 - var10, var5, var6 - var11) ? 1 : 0) + (var3.isBlockNormalCube(var4 - var10, var5 + 1, var6 - var11) ? 1 : 0);
                int var13 = (var3.isBlockNormalCube(var4 + var10, var5, var6 + var11) ? 1 : 0) + (var3.isBlockNormalCube(var4 + var10, var5 + 1, var6 + var11) ? 1 : 0);
                boolean var14 = var3.getBlockId(var4 - var10, var5, var6 - var11) == var8.blockID || var3.getBlockId(var4 - var10, var5 + 1, var6 - var11) == var8.blockID;
                boolean var15 = var3.getBlockId(var4 + var10, var5, var6 + var11) == var8.blockID || var3.getBlockId(var4 + var10, var5 + 1, var6 + var11) == var8.blockID;
                boolean var16 = false;
                if (var14 && !var15) {
                    var16 = true;
                } else if (var13 > var12) {
                    var16 = true;
                }

                if (var16) {
                    var9 = var9 - 1 & 3;
                    var9 += 4;
                }

                var3.editingBlocks = true;
                var3.setBlockAndMetadataWithNotify(var4, var5, var6, var8.blockID, var9);
                var3.setBlockAndMetadataWithNotify(var4, var5 + 1, var6, var8.blockID, var9 + 8);
                var3.editingBlocks = false;
                var3.notifyBlocksOfNeighborChange(var4, var5, var6, var8.blockID);
                var3.notifyBlocksOfNeighborChange(var4, var5 + 1, var6, var8.blockID);
                --var1.stackSize;
                return true;
            }
        }
    }
}
