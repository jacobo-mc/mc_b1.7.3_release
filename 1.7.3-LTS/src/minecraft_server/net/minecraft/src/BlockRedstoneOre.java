package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneOre extends Block {
    private boolean field_665_a;

    public BlockRedstoneOre(int var1, int var2, boolean var3) {
        super(var1, var2, Material.rock);
        if (var3) {
            this.setTickOnLoad(true);
        }

        this.field_665_a = var3;
    }

    public int tickRate() {
        return 30;
    }

    public void onBlockClicked(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_321_g(var1, var2, var3, var4);
        super.onBlockClicked(var1, var2, var3, var4, var5);
    }

    public void onEntityWalking(World var1, int var2, int var3, int var4, Entity var5) {
        this.func_321_g(var1, var2, var3, var4);
        super.onEntityWalking(var1, var2, var3, var4, var5);
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_321_g(var1, var2, var3, var4);
        return super.blockActivated(var1, var2, var3, var4, var5);
    }

    private void func_321_g(World var1, int var2, int var3, int var4) {
        this.glow(var1, var2, var3, var4);
        if (this.blockID == Block.oreRedstone.blockID) {
            var1.setBlockWithNotify(var2, var3, var4, Block.oreRedstoneGlowing.blockID);
        }

    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (this.blockID == Block.oreRedstoneGlowing.blockID) {
            var1.setBlockWithNotify(var2, var3, var4, Block.oreRedstone.blockID);
        }

    }

    public int idDropped(int var1, Random var2) {
        return Item.redstone.shiftedIndex;
    }

    public int quantityDropped(Random var1) {
        return 4 + var1.nextInt(2);
    }

    private void glow(World var1, int var2, int var3, int var4) {
        Random var5 = var1.rand;
        double var6 = 0.0625D;

        for(int var8 = 0; var8 < 6; ++var8) {
            double var9 = (double)((float)var2 + var5.nextFloat());
            double var11 = (double)((float)var3 + var5.nextFloat());
            double var13 = (double)((float)var4 + var5.nextFloat());
            if (var8 == 0 && !var1.isBlockOpaqueCube(var2, var3 + 1, var4)) {
                var11 = (double)(var3 + 1) + var6;
            }

            if (var8 == 1 && !var1.isBlockOpaqueCube(var2, var3 - 1, var4)) {
                var11 = (double)(var3 + 0) - var6;
            }

            if (var8 == 2 && !var1.isBlockOpaqueCube(var2, var3, var4 + 1)) {
                var13 = (double)(var4 + 1) + var6;
            }

            if (var8 == 3 && !var1.isBlockOpaqueCube(var2, var3, var4 - 1)) {
                var13 = (double)(var4 + 0) - var6;
            }

            if (var8 == 4 && !var1.isBlockOpaqueCube(var2 + 1, var3, var4)) {
                var9 = (double)(var2 + 1) + var6;
            }

            if (var8 == 5 && !var1.isBlockOpaqueCube(var2 - 1, var3, var4)) {
                var9 = (double)(var2 + 0) - var6;
            }

            if (var9 < (double)var2 || var9 > (double)(var2 + 1) || var11 < 0.0D || var11 > (double)(var3 + 1) || var13 < (double)var4 || var13 > (double)(var4 + 1)) {
                var1.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
