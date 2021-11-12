package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TileEntityPiston extends TileEntity {
    private int storedBlockID;
    private int storedMetadata;
    private int storedOrientation;
    private boolean isExtending;
    private boolean field_31018_j;
    private float progress;
    private float lastProgress;
    private static List field_31013_m = new ArrayList();

    public TileEntityPiston() {
    }

    public TileEntityPiston(int var1, int var2, int var3, boolean var4, boolean var5) {
        this.storedBlockID = var1;
        this.storedMetadata = var2;
        this.storedOrientation = var3;
        this.isExtending = var4;
        this.field_31018_j = var5;
    }

    public int getStoredBlockID() {
        return this.storedBlockID;
    }

    public int getBlockMetadata() {
        return this.storedMetadata;
    }

    public boolean func_31010_c() {
        return this.isExtending;
    }

    public int func_31008_d() {
        return this.storedOrientation;
    }

    public float func_31007_a(float var1) {
        if (var1 > 1.0F) {
            var1 = 1.0F;
        }

        return this.lastProgress + (this.progress - this.lastProgress) * var1;
    }

    private void func_31009_a(float var1, float var2) {
        if (!this.isExtending) {
            --var1;
        } else {
            var1 = 1.0F - var1;
        }

        AxisAlignedBB var3 = Block.pistonMoving.func_31032_a(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.storedBlockID, var1, this.storedOrientation);
        if (var3 != null) {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)null, var3);
            if (!var4.isEmpty()) {
                field_31013_m.addAll(var4);
                Iterator var5 = field_31013_m.iterator();

                while(var5.hasNext()) {
                    Entity var6 = (Entity)var5.next();
                    var6.moveEntity((double)(var2 * (float)PistonBlockTextures.field_31051_b[this.storedOrientation]), (double)(var2 * (float)PistonBlockTextures.field_31054_c[this.storedOrientation]), (double)(var2 * (float)PistonBlockTextures.field_31053_d[this.storedOrientation]));
                }

                field_31013_m.clear();
            }
        }

    }

    public void clearPistonTileEntity() {
        if (this.lastProgress < 1.0F) {
            this.lastProgress = this.progress = 1.0F;
            this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
            this.invalidate();
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == Block.pistonMoving.blockID) {
                this.worldObj.setBlockAndMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, this.storedBlockID, this.storedMetadata);
            }
        }

    }

    public void updateEntity() {
        this.lastProgress = this.progress;
        if (this.lastProgress >= 1.0F) {
            this.func_31009_a(1.0F, 0.25F);
            this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
            this.invalidate();
            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) == Block.pistonMoving.blockID) {
                this.worldObj.setBlockAndMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, this.storedBlockID, this.storedMetadata);
            }

        } else {
            this.progress += 0.5F;
            if (this.progress >= 1.0F) {
                this.progress = 1.0F;
            }

            if (this.isExtending) {
                this.func_31009_a(this.progress, this.progress - this.lastProgress + 0.0625F);
            }

        }
    }

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        this.storedBlockID = var1.getInteger("blockId");
        this.storedMetadata = var1.getInteger("blockData");
        this.storedOrientation = var1.getInteger("facing");
        this.lastProgress = this.progress = var1.getFloat("progress");
        this.isExtending = var1.getBoolean("extending");
    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setInteger("blockId", this.storedBlockID);
        var1.setInteger("blockData", this.storedMetadata);
        var1.setInteger("facing", this.storedOrientation);
        var1.setFloat("progress", this.lastProgress);
        var1.setBoolean("extending", this.isExtending);
    }
}
