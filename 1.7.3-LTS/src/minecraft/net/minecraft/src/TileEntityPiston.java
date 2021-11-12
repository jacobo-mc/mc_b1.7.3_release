package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TileEntityPiston extends TileEntity {
    private int storedBlockID;
    private int storedMetadata;
    private int field_31025_c;
    private boolean field_31024_i;
    private boolean field_31023_j;
    private float field_31022_k;
    private float field_31020_l;
    private static List field_31018_m = new ArrayList();

    public TileEntityPiston() {
    }

    public TileEntityPiston(int var1, int var2, int var3, boolean var4, boolean var5) {
        this.storedBlockID = var1;
        this.storedMetadata = var2;
        this.field_31025_c = var3;
        this.field_31024_i = var4;
        this.field_31023_j = var5;
    }

    public int getStoredBlockID() {
        return this.storedBlockID;
    }

    public int getBlockMetadata() {
        return this.storedMetadata;
    }

    public boolean isExtending() {
        return this.field_31024_i;
    }

    public int getPistonOrientation() {
        return this.field_31025_c;
    }

    public boolean func_31012_k() {
        return this.field_31023_j;
    }

    public float getProgress(float var1) {
        if (var1 > 1.0F) {
            var1 = 1.0F;
        }

        return this.field_31020_l + (this.field_31022_k - this.field_31020_l) * var1;
    }

    public float func_31017_b(float var1) {
        return this.field_31024_i ? (this.getProgress(var1) - 1.0F) * (float)PistonBlockTextures.offsetsXForSide[this.field_31025_c] : (1.0F - this.getProgress(var1)) * (float)PistonBlockTextures.offsetsXForSide[this.field_31025_c];
    }

    public float func_31014_c(float var1) {
        return this.field_31024_i ? (this.getProgress(var1) - 1.0F) * (float)PistonBlockTextures.offsetsYForSide[this.field_31025_c] : (1.0F - this.getProgress(var1)) * (float)PistonBlockTextures.offsetsYForSide[this.field_31025_c];
    }

    public float func_31013_d(float var1) {
        return this.field_31024_i ? (this.getProgress(var1) - 1.0F) * (float)PistonBlockTextures.offsetsZForSide[this.field_31025_c] : (1.0F - this.getProgress(var1)) * (float)PistonBlockTextures.offsetsZForSide[this.field_31025_c];
    }

    private void func_31010_a(float var1, float var2) {
        if (!this.field_31024_i) {
            --var1;
        } else {
            var1 = 1.0F - var1;
        }

        AxisAlignedBB var3 = Block.pistonMoving.getAxisAlignedBB(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.storedBlockID, var1, this.field_31025_c);
        if (var3 != null) {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)null, var3);
            if (!var4.isEmpty()) {
                field_31018_m.addAll(var4);
                Iterator var5 = field_31018_m.iterator();

                while(var5.hasNext()) {
                    Entity var6 = (Entity)var5.next();
                    var6.moveEntity((double)(var2 * (float)PistonBlockTextures.offsetsXForSide[this.field_31025_c]), (double)(var2 * (float)PistonBlockTextures.offsetsYForSide[this.field_31025_c]), (double)(var2 * (float)PistonBlockTextures.offsetsZForSide[this.field_31025_c]));
                }

                field_31018_m.clear();
            }
        }

    }

    public void clearPistonTileEntity() {
        if (this.field_31020_l < 1.0F) {
            this.field_31020_l = this.field_31022_k = 1.0F;
            this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
            this.invalidate();
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == Block.pistonMoving.blockID) {
                this.worldObj.setBlockAndMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, this.storedBlockID, this.storedMetadata);
            }
        }

    }

    public void updateEntity() {
        this.field_31020_l = this.field_31022_k;
        if (this.field_31020_l >= 1.0F) {
            this.func_31010_a(1.0F, 0.25F);
            this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
            this.invalidate();
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == Block.pistonMoving.blockID) {
                this.worldObj.setBlockAndMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, this.storedBlockID, this.storedMetadata);
            }

        } else {
            this.field_31022_k += 0.5F;
            if (this.field_31022_k >= 1.0F) {
                this.field_31022_k = 1.0F;
            }

            if (this.field_31024_i) {
                this.func_31010_a(this.field_31022_k, this.field_31022_k - this.field_31020_l + 0.0625F);
            }

        }
    }

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        this.storedBlockID = var1.getInteger("blockId");
        this.storedMetadata = var1.getInteger("blockData");
        this.field_31025_c = var1.getInteger("facing");
        this.field_31020_l = this.field_31022_k = var1.getFloat("progress");
        this.field_31024_i = var1.getBoolean("extending");
    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setInteger("blockId", this.storedBlockID);
        var1.setInteger("blockData", this.storedMetadata);
        var1.setInteger("facing", this.field_31025_c);
        var1.setFloat("progress", this.field_31020_l);
        var1.setBoolean("extending", this.field_31024_i);
    }
}
