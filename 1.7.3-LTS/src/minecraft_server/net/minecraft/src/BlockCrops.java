package net.minecraft.src;

import java.util.Random;

public class BlockCrops extends BlockFlower {
    protected BlockCrops(int var1, int var2) {
        super(var1, var2);
        this.blockIndexInTexture = var2;
        this.setTickOnLoad(true);
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1) {
        return var1 == Block.tilledField.blockID;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        super.updateTick(var1, var2, var3, var4, var5);
        if (var1.getBlockLightValue(var2, var3 + 1, var4) >= 9) {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            if (var6 < 7) {
                float var7 = this.getGrowthRate(var1, var2, var3, var4);
                if (var5.nextInt((int)(100.0F / var7)) == 0) {
                    ++var6;
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
                }
            }
        }

    }

    public void fertilize(World var1, int var2, int var3, int var4) {
        var1.setBlockMetadataWithNotify(var2, var3, var4, 7);
    }

    private float getGrowthRate(World var1, int var2, int var3, int var4) {
        float var5 = 1.0F;
        int var6 = var1.getBlockId(var2, var3, var4 - 1);
        int var7 = var1.getBlockId(var2, var3, var4 + 1);
        int var8 = var1.getBlockId(var2 - 1, var3, var4);
        int var9 = var1.getBlockId(var2 + 1, var3, var4);
        int var10 = var1.getBlockId(var2 - 1, var3, var4 - 1);
        int var11 = var1.getBlockId(var2 + 1, var3, var4 - 1);
        int var12 = var1.getBlockId(var2 + 1, var3, var4 + 1);
        int var13 = var1.getBlockId(var2 - 1, var3, var4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

        for(int var17 = var2 - 1; var17 <= var2 + 1; ++var17) {
            for(int var18 = var4 - 1; var18 <= var4 + 1; ++var18) {
                int var19 = var1.getBlockId(var17, var3 - 1, var18);
                float var20 = 0.0F;
                if (var19 == Block.tilledField.blockID) {
                    var20 = 1.0F;
                    if (var1.getBlockMetadata(var17, var3 - 1, var18) > 0) {
                        var20 = 3.0F;
                    }
                }

                if (var17 != var2 || var18 != var4) {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15) {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var2 < 0) {
            var2 = 7;
        }

        return this.blockIndexInTexture + var2;
    }

    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
        super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
        if (!var1.singleplayerWorld) {
            for(int var7 = 0; var7 < 3; ++var7) {
                if (var1.rand.nextInt(15) <= var5) {
                    float var8 = 0.7F;
                    float var9 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var10 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var11 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var9), (double)((float)var3 + var10), (double)((float)var4 + var11), new ItemStack(Item.seeds));
                    var12.delayBeforeCanPickup = 10;
                    var1.entityJoinedWorld(var12);
                }
            }

        }
    }

    public int idDropped(int var1, Random var2) {
        return var1 == 7 ? Item.wheat.shiftedIndex : -1;
    }

    public int quantityDropped(Random var1) {
        return 1;
    }
}
