package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class AxisAlignedBB {
    private static List boundingBoxes = new ArrayList();
    private static int numBoundingBoxesInUse = 0;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;

    public static AxisAlignedBB getBoundingBox(double var0, double var2, double var4, double var6, double var8, double var10) {
        return new AxisAlignedBB(var0, var2, var4, var6, var8, var10);
    }

    public static void clearBoundingBoxPool() {
        numBoundingBoxesInUse = 0;
    }

    public static AxisAlignedBB getBoundingBoxFromPool(double var0, double var2, double var4, double var6, double var8, double var10) {
        if (numBoundingBoxesInUse >= boundingBoxes.size()) {
            boundingBoxes.add(getBoundingBox(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D));
        }

        return ((AxisAlignedBB)boundingBoxes.get(numBoundingBoxesInUse++)).setBounds(var0, var2, var4, var6, var8, var10);
    }

    private AxisAlignedBB(double var1, double var3, double var5, double var7, double var9, double var11) {
        this.minX = var1;
        this.minY = var3;
        this.minZ = var5;
        this.maxX = var7;
        this.maxY = var9;
        this.maxZ = var11;
    }

    public AxisAlignedBB setBounds(double var1, double var3, double var5, double var7, double var9, double var11) {
        this.minX = var1;
        this.minY = var3;
        this.minZ = var5;
        this.maxX = var7;
        this.maxY = var9;
        this.maxZ = var11;
        return this;
    }

    public AxisAlignedBB addCoord(double var1, double var3, double var5) {
        double var7 = this.minX;
        double var9 = this.minY;
        double var11 = this.minZ;
        double var13 = this.maxX;
        double var15 = this.maxY;
        double var17 = this.maxZ;
        if (var1 < 0.0D) {
            var7 += var1;
        }

        if (var1 > 0.0D) {
            var13 += var1;
        }

        if (var3 < 0.0D) {
            var9 += var3;
        }

        if (var3 > 0.0D) {
            var15 += var3;
        }

        if (var5 < 0.0D) {
            var11 += var5;
        }

        if (var5 > 0.0D) {
            var17 += var5;
        }

        return getBoundingBoxFromPool(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB expand(double var1, double var3, double var5) {
        double var7 = this.minX - var1;
        double var9 = this.minY - var3;
        double var11 = this.minZ - var5;
        double var13 = this.maxX + var1;
        double var15 = this.maxY + var3;
        double var17 = this.maxZ + var5;
        return getBoundingBoxFromPool(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB getOffsetBoundingBox(double var1, double var3, double var5) {
        return getBoundingBoxFromPool(this.minX + var1, this.minY + var3, this.minZ + var5, this.maxX + var1, this.maxY + var3, this.maxZ + var5);
    }

    public double calculateXOffset(AxisAlignedBB var1, double var2) {
        if (var1.maxY > this.minY && var1.minY < this.maxY) {
            if (var1.maxZ > this.minZ && var1.minZ < this.maxZ) {
                double var4;
                if (var2 > 0.0D && var1.maxX <= this.minX) {
                    var4 = this.minX - var1.maxX;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.minX >= this.maxX) {
                    var4 = this.maxX - var1.minX;
                    if (var4 > var2) {
                        var2 = var4;
                    }
                }

                return var2;
            } else {
                return var2;
            }
        } else {
            return var2;
        }
    }

    public double calculateYOffset(AxisAlignedBB var1, double var2) {
        if (var1.maxX > this.minX && var1.minX < this.maxX) {
            if (var1.maxZ > this.minZ && var1.minZ < this.maxZ) {
                double var4;
                if (var2 > 0.0D && var1.maxY <= this.minY) {
                    var4 = this.minY - var1.maxY;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.minY >= this.maxY) {
                    var4 = this.maxY - var1.minY;
                    if (var4 > var2) {
                        var2 = var4;
                    }
                }

                return var2;
            } else {
                return var2;
            }
        } else {
            return var2;
        }
    }

    public double calculateZOffset(AxisAlignedBB var1, double var2) {
        if (var1.maxX > this.minX && var1.minX < this.maxX) {
            if (var1.maxY > this.minY && var1.minY < this.maxY) {
                double var4;
                if (var2 > 0.0D && var1.maxZ <= this.minZ) {
                    var4 = this.minZ - var1.maxZ;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.minZ >= this.maxZ) {
                    var4 = this.maxZ - var1.minZ;
                    if (var4 > var2) {
                        var2 = var4;
                    }
                }

                return var2;
            } else {
                return var2;
            }
        } else {
            return var2;
        }
    }

    public boolean intersectsWith(AxisAlignedBB var1) {
        if (var1.maxX > this.minX && var1.minX < this.maxX) {
            if (var1.maxY > this.minY && var1.minY < this.maxY) {
                return var1.maxZ > this.minZ && var1.minZ < this.maxZ;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AxisAlignedBB offset(double var1, double var3, double var5) {
        this.minX += var1;
        this.minY += var3;
        this.minZ += var5;
        this.maxX += var1;
        this.maxY += var3;
        this.maxZ += var5;
        return this;
    }

    public boolean isVecInXYZ(Vec3D var1) {
        if (var1.xCoord > this.minX && var1.xCoord < this.maxX) {
            if (var1.yCoord > this.minY && var1.yCoord < this.maxY) {
                return var1.zCoord > this.minZ && var1.zCoord < this.maxZ;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AxisAlignedBB getInsetBoundingBox(double var1, double var3, double var5) {
        double var7 = this.minX + var1;
        double var9 = this.minY + var3;
        double var11 = this.minZ + var5;
        double var13 = this.maxX - var1;
        double var15 = this.maxY - var3;
        double var17 = this.maxZ - var5;
        return getBoundingBoxFromPool(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB copy() {
        return getBoundingBoxFromPool(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    public MovingObjectPosition func_706_a(Vec3D var1, Vec3D var2) {
        Vec3D var3 = var1.getIntermediateWithXValue(var2, this.minX);
        Vec3D var4 = var1.getIntermediateWithXValue(var2, this.maxX);
        Vec3D var5 = var1.getIntermediateWithYValue(var2, this.minY);
        Vec3D var6 = var1.getIntermediateWithYValue(var2, this.maxY);
        Vec3D var7 = var1.getIntermediateWithZValue(var2, this.minZ);
        Vec3D var8 = var1.getIntermediateWithZValue(var2, this.maxZ);
        if (!this.isVecInYZ(var3)) {
            var3 = null;
        }

        if (!this.isVecInYZ(var4)) {
            var4 = null;
        }

        if (!this.isVecInXZ(var5)) {
            var5 = null;
        }

        if (!this.isVecInXZ(var6)) {
            var6 = null;
        }

        if (!this.isVecInXY(var7)) {
            var7 = null;
        }

        if (!this.isVecInXY(var8)) {
            var8 = null;
        }

        Vec3D var9 = null;
        if (var3 != null && (var9 == null || var1.squareDistanceTo(var3) < var1.squareDistanceTo(var9))) {
            var9 = var3;
        }

        if (var4 != null && (var9 == null || var1.squareDistanceTo(var4) < var1.squareDistanceTo(var9))) {
            var9 = var4;
        }

        if (var5 != null && (var9 == null || var1.squareDistanceTo(var5) < var1.squareDistanceTo(var9))) {
            var9 = var5;
        }

        if (var6 != null && (var9 == null || var1.squareDistanceTo(var6) < var1.squareDistanceTo(var9))) {
            var9 = var6;
        }

        if (var7 != null && (var9 == null || var1.squareDistanceTo(var7) < var1.squareDistanceTo(var9))) {
            var9 = var7;
        }

        if (var8 != null && (var9 == null || var1.squareDistanceTo(var8) < var1.squareDistanceTo(var9))) {
            var9 = var8;
        }

        if (var9 == null) {
            return null;
        } else {
            byte var10 = -1;
            if (var9 == var3) {
                var10 = 4;
            }

            if (var9 == var4) {
                var10 = 5;
            }

            if (var9 == var5) {
                var10 = 0;
            }

            if (var9 == var6) {
                var10 = 1;
            }

            if (var9 == var7) {
                var10 = 2;
            }

            if (var9 == var8) {
                var10 = 3;
            }

            return new MovingObjectPosition(0, 0, 0, var10, var9);
        }
    }

    private boolean isVecInYZ(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.yCoord >= this.minY && var1.yCoord <= this.maxY && var1.zCoord >= this.minZ && var1.zCoord <= this.maxZ;
        }
    }

    private boolean isVecInXZ(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.xCoord >= this.minX && var1.xCoord <= this.maxX && var1.zCoord >= this.minZ && var1.zCoord <= this.maxZ;
        }
    }

    private boolean isVecInXY(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.xCoord >= this.minX && var1.xCoord <= this.maxX && var1.yCoord >= this.minY && var1.yCoord <= this.maxY;
        }
    }

    public void setBB(AxisAlignedBB var1) {
        this.minX = var1.minX;
        this.minY = var1.minY;
        this.minZ = var1.minZ;
        this.maxX = var1.maxX;
        this.maxY = var1.maxY;
        this.maxZ = var1.maxZ;
    }

    public String toString() {
        return "box[" + this.minX + ", " + this.minY + ", " + this.minZ + " -> " + this.maxX + ", " + this.maxY + ", " + this.maxZ + "]";
    }
}
