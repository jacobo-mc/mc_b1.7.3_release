package net.minecraft.src;

import java.util.Random;

public class BlockStationary extends BlockFluid {
    protected BlockStationary(int var1, Material var2) {
        super(var1, var2);
        this.setTickOnLoad(false);
        if (var2 == Material.lava) {
            this.setTickOnLoad(true);
        }

    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
        if (var1.getBlockId(var2, var3, var4) == this.blockID) {
            this.func_30005_i(var1, var2, var3, var4);
        }

    }

    private void func_30005_i(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        var1.editingBlocks = true;
        var1.setBlockAndMetadata(var2, var3, var4, this.blockID - 1, var5);
        var1.markBlocksDirty(var2, var3, var4, var2, var3, var4);
        var1.scheduleUpdateTick(var2, var3, var4, this.blockID - 1, this.tickRate());
        var1.editingBlocks = false;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (this.blockMaterial == Material.lava) {
            int var6 = var5.nextInt(3);

            for(int var7 = 0; var7 < var6; ++var7) {
                var2 += var5.nextInt(3) - 1;
                ++var3;
                var4 += var5.nextInt(3) - 1;
                int var8 = var1.getBlockId(var2, var3, var4);
                if (var8 == 0) {
                    if (this.func_4033_j(var1, var2 - 1, var3, var4) || this.func_4033_j(var1, var2 + 1, var3, var4) || this.func_4033_j(var1, var2, var3, var4 - 1) || this.func_4033_j(var1, var2, var3, var4 + 1) || this.func_4033_j(var1, var2, var3 - 1, var4) || this.func_4033_j(var1, var2, var3 + 1, var4)) {
                        var1.setBlockWithNotify(var2, var3, var4, Block.fire.blockID);
                        return;
                    }
                } else if (Block.blocksList[var8].blockMaterial.getIsSolid()) {
                    return;
                }
            }
        }

    }

    private boolean func_4033_j(World var1, int var2, int var3, int var4) {
        return var1.getBlockMaterial(var2, var3, var4).getBurning();
    }
}
