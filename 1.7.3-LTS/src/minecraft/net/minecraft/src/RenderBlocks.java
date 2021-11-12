package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class RenderBlocks {
    private IBlockAccess blockAccess;
    private int overrideBlockTexture = -1;
    private boolean flipTexture = false;
    private boolean renderAllFaces = false;
    public static boolean fancyGrass = true;
    public boolean field_31088_b = true;
    private int field_31087_g = 0;
    private int field_31086_h = 0;
    private int field_31085_i = 0;
    private int field_31084_j = 0;
    private int field_31083_k = 0;
    private int field_31082_l = 0;
    private boolean enableAO;
    private float lightValueOwn;
    private float aoLightValueXNeg;
    private float aoLightValueYNeg;
    private float aoLightValueZNeg;
    private float aoLightValueXPos;
    private float aoLightValueYPos;
    private float aoLightValueZPos;
    private float field_22377_m;
    private float field_22376_n;
    private float field_22375_o;
    private float field_22374_p;
    private float field_22373_q;
    private float field_22372_r;
    private float field_22371_s;
    private float field_22370_t;
    private float field_22369_u;
    private float field_22368_v;
    private float field_22367_w;
    private float field_22366_x;
    private float field_22365_y;
    private float field_22364_z;
    private float field_22362_A;
    private float field_22360_B;
    private float field_22358_C;
    private float field_22356_D;
    private float field_22354_E;
    private float field_22353_F;
    private int field_22352_G = 1;
    private float colorRedTopLeft;
    private float colorRedBottomLeft;
    private float colorRedBottomRight;
    private float colorRedTopRight;
    private float colorGreenTopLeft;
    private float colorGreenBottomLeft;
    private float colorGreenBottomRight;
    private float colorGreenTopRight;
    private float colorBlueTopLeft;
    private float colorBlueBottomLeft;
    private float colorBlueBottomRight;
    private float colorBlueTopRight;
    private boolean field_22339_T;
    private boolean field_22338_U;
    private boolean field_22337_V;
    private boolean field_22336_W;
    private boolean field_22335_X;
    private boolean field_22334_Y;
    private boolean field_22333_Z;
    private boolean field_22363_aa;
    private boolean field_22361_ab;
    private boolean field_22359_ac;
    private boolean field_22357_ad;
    private boolean field_22355_ae;

    public RenderBlocks(IBlockAccess var1) {
        this.blockAccess = var1;
    }

    public RenderBlocks() {
    }

    public void renderBlockUsingTexture(Block var1, int var2, int var3, int var4, int var5) {
        this.overrideBlockTexture = var5;
        this.renderBlockByRenderType(var1, var2, var3, var4);
        this.overrideBlockTexture = -1;
    }

    public void func_31075_a(Block var1, int var2, int var3, int var4) {
        this.renderAllFaces = true;
        this.renderBlockByRenderType(var1, var2, var3, var4);
        this.renderAllFaces = false;
    }

    public boolean renderBlockByRenderType(Block var1, int var2, int var3, int var4) {
        int var5 = var1.getRenderType();
        var1.setBlockBoundsBasedOnState(this.blockAccess, var2, var3, var4);
        if (var5 == 0) {
            return this.renderStandardBlock(var1, var2, var3, var4);
        } else if (var5 == 4) {
            return this.renderBlockFluids(var1, var2, var3, var4);
        } else if (var5 == 13) {
            return this.renderBlockCactus(var1, var2, var3, var4);
        } else if (var5 == 1) {
            return this.renderBlockReed(var1, var2, var3, var4);
        } else if (var5 == 6) {
            return this.renderBlockCrops(var1, var2, var3, var4);
        } else if (var5 == 2) {
            return this.renderBlockTorch(var1, var2, var3, var4);
        } else if (var5 == 3) {
            return this.renderBlockFire(var1, var2, var3, var4);
        } else if (var5 == 5) {
            return this.renderBlockRedstoneWire(var1, var2, var3, var4);
        } else if (var5 == 8) {
            return this.renderBlockLadder(var1, var2, var3, var4);
        } else if (var5 == 7) {
            return this.renderBlockDoor(var1, var2, var3, var4);
        } else if (var5 == 9) {
            return this.renderBlockMinecartTrack((BlockRail)var1, var2, var3, var4);
        } else if (var5 == 10) {
            return this.renderBlockStairs(var1, var2, var3, var4);
        } else if (var5 == 11) {
            return this.renderBlockFence(var1, var2, var3, var4);
        } else if (var5 == 12) {
            return this.renderBlockLever(var1, var2, var3, var4);
        } else if (var5 == 14) {
            return this.renderBlockBed(var1, var2, var3, var4);
        } else if (var5 == 15) {
            return this.renderBlockRepeater(var1, var2, var3, var4);
        } else if (var5 == 16) {
            return this.func_31074_b(var1, var2, var3, var4, false);
        } else {
            return var5 == 17 ? this.func_31080_c(var1, var2, var3, var4, true) : false;
        }
    }

    private boolean renderBlockBed(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        int var6 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        int var7 = BlockBed.getDirectionFromMetadata(var6);
        boolean var8 = BlockBed.isBlockFootOfBed(var6);
        float var9 = 0.5F;
        float var10 = 1.0F;
        float var11 = 0.8F;
        float var12 = 0.6F;
        float var25 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        var5.setColorOpaque_F(var9 * var25, var9 * var25, var9 * var25);
        int var26 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 0);
        int var27 = (var26 & 15) << 4;
        int var28 = var26 & 240;
        double var29 = (double)((float)var27 / 256.0F);
        double var31 = ((double)(var27 + 16) - 0.01D) / 256.0D;
        double var33 = (double)((float)var28 / 256.0F);
        double var35 = ((double)(var28 + 16) - 0.01D) / 256.0D;
        double var37 = (double)var2 + var1.minX;
        double var39 = (double)var2 + var1.maxX;
        double var41 = (double)var3 + var1.minY + 0.1875D;
        double var43 = (double)var4 + var1.minZ;
        double var45 = (double)var4 + var1.maxZ;
        var5.addVertexWithUV(var37, var41, var45, var29, var35);
        var5.addVertexWithUV(var37, var41, var43, var29, var33);
        var5.addVertexWithUV(var39, var41, var43, var31, var33);
        var5.addVertexWithUV(var39, var41, var45, var31, var35);
        float var64 = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
        var5.setColorOpaque_F(var10 * var64, var10 * var64, var10 * var64);
        var27 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 1);
        var28 = (var27 & 15) << 4;
        int var67 = var27 & 240;
        double var30 = (double)((float)var28 / 256.0F);
        double var32 = ((double)(var28 + 16) - 0.01D) / 256.0D;
        double var34 = (double)((float)var67 / 256.0F);
        double var36 = ((double)(var67 + 16) - 0.01D) / 256.0D;
        double var38 = var30;
        double var40 = var32;
        double var42 = var34;
        double var44 = var34;
        double var46 = var30;
        double var48 = var32;
        double var50 = var36;
        double var52 = var36;
        if (var7 == 0) {
            var40 = var30;
            var42 = var36;
            var46 = var32;
            var52 = var34;
        } else if (var7 == 2) {
            var38 = var32;
            var44 = var36;
            var48 = var30;
            var50 = var34;
        } else if (var7 == 3) {
            var38 = var32;
            var44 = var36;
            var48 = var30;
            var50 = var34;
            var40 = var30;
            var42 = var36;
            var46 = var32;
            var52 = var34;
        }

        double var54 = (double)var2 + var1.minX;
        double var56 = (double)var2 + var1.maxX;
        double var58 = (double)var3 + var1.maxY;
        double var60 = (double)var4 + var1.minZ;
        double var62 = (double)var4 + var1.maxZ;
        var5.addVertexWithUV(var56, var58, var62, var46, var50);
        var5.addVertexWithUV(var56, var58, var60, var38, var42);
        var5.addVertexWithUV(var54, var58, var60, var40, var44);
        var5.addVertexWithUV(var54, var58, var62, var48, var52);
        var26 = ModelBed.headInvisibleFace[var7];
        if (var8) {
            var26 = ModelBed.headInvisibleFace[ModelBed.footInvisibleFaceRemap[var7]];
        }

        byte var65 = 4;
        switch(var7) {
        case 0:
            var65 = 5;
            break;
        case 1:
            var65 = 3;
        case 2:
        default:
            break;
        case 3:
            var65 = 2;
        }

        float var66;
        if (var26 != 2 && (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 - 1, 2))) {
            var66 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
            if (var1.minZ > 0.0D) {
                var66 = var25;
            }

            var5.setColorOpaque_F(var11 * var66, var11 * var66, var11 * var66);
            this.flipTexture = var65 == 2;
            this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 2));
        }

        if (var26 != 3 && (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 + 1, 3))) {
            var66 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
            if (var1.maxZ < 1.0D) {
                var66 = var25;
            }

            var5.setColorOpaque_F(var11 * var66, var11 * var66, var11 * var66);
            this.flipTexture = var65 == 3;
            this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 3));
        }

        if (var26 != 4 && (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 - 1, var3, var4, 4))) {
            var66 = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
            if (var1.minX > 0.0D) {
                var66 = var25;
            }

            var5.setColorOpaque_F(var12 * var66, var12 * var66, var12 * var66);
            this.flipTexture = var65 == 4;
            this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 4));
        }

        if (var26 != 5 && (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 + 1, var3, var4, 5))) {
            var66 = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
            if (var1.maxX < 1.0D) {
                var66 = var25;
            }

            var5.setColorOpaque_F(var12 * var66, var12 * var66, var12 * var66);
            this.flipTexture = var65 == 5;
            this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 5));
        }

        this.flipTexture = false;
        return true;
    }

    public boolean renderBlockTorch(Block var1, int var2, int var3, int var4) {
        int var5 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        Tessellator var6 = Tessellator.instance;
        float var7 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        if (Block.lightValue[var1.blockID] > 0) {
            var7 = 1.0F;
        }

        var6.setColorOpaque_F(var7, var7, var7);
        double var8 = 0.4000000059604645D;
        double var10 = 0.5D - var8;
        double var12 = 0.20000000298023224D;
        if (var5 == 1) {
            this.renderTorchAtAngle(var1, (double)var2 - var10, (double)var3 + var12, (double)var4, -var8, 0.0D);
        } else if (var5 == 2) {
            this.renderTorchAtAngle(var1, (double)var2 + var10, (double)var3 + var12, (double)var4, var8, 0.0D);
        } else if (var5 == 3) {
            this.renderTorchAtAngle(var1, (double)var2, (double)var3 + var12, (double)var4 - var10, 0.0D, -var8);
        } else if (var5 == 4) {
            this.renderTorchAtAngle(var1, (double)var2, (double)var3 + var12, (double)var4 + var10, 0.0D, var8);
        } else {
            this.renderTorchAtAngle(var1, (double)var2, (double)var3, (double)var4, 0.0D, 0.0D);
        }

        return true;
    }

    private boolean renderBlockRepeater(Block var1, int var2, int var3, int var4) {
        int var5 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        int var6 = var5 & 3;
        int var7 = (var5 & 12) >> 2;
        this.renderStandardBlock(var1, var2, var3, var4);
        Tessellator var8 = Tessellator.instance;
        float var9 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        if (Block.lightValue[var1.blockID] > 0) {
            var9 = (var9 + 1.0F) * 0.5F;
        }

        var8.setColorOpaque_F(var9, var9, var9);
        double var10 = -0.1875D;
        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = 0.0D;
        double var18 = 0.0D;
        switch(var6) {
        case 0:
            var18 = -0.3125D;
            var14 = BlockRedstoneRepeater.repeaterTorchOffset[var7];
            break;
        case 1:
            var16 = 0.3125D;
            var12 = -BlockRedstoneRepeater.repeaterTorchOffset[var7];
            break;
        case 2:
            var18 = 0.3125D;
            var14 = -BlockRedstoneRepeater.repeaterTorchOffset[var7];
            break;
        case 3:
            var16 = -0.3125D;
            var12 = BlockRedstoneRepeater.repeaterTorchOffset[var7];
        }

        this.renderTorchAtAngle(var1, (double)var2 + var12, (double)var3 + var10, (double)var4 + var14, 0.0D, 0.0D);
        this.renderTorchAtAngle(var1, (double)var2 + var16, (double)var3 + var10, (double)var4 + var18, 0.0D, 0.0D);
        int var20 = var1.getBlockTextureFromSide(1);
        int var21 = (var20 & 15) << 4;
        int var22 = var20 & 240;
        double var23 = (double)((float)var21 / 256.0F);
        double var25 = (double)(((float)var21 + 15.99F) / 256.0F);
        double var27 = (double)((float)var22 / 256.0F);
        double var29 = (double)(((float)var22 + 15.99F) / 256.0F);
        float var31 = 0.125F;
        float var32 = (float)(var2 + 1);
        float var33 = (float)(var2 + 1);
        float var34 = (float)(var2 + 0);
        float var35 = (float)(var2 + 0);
        float var36 = (float)(var4 + 0);
        float var37 = (float)(var4 + 1);
        float var38 = (float)(var4 + 1);
        float var39 = (float)(var4 + 0);
        float var40 = (float)var3 + var31;
        if (var6 == 2) {
            var32 = var33 = (float)(var2 + 0);
            var34 = var35 = (float)(var2 + 1);
            var36 = var39 = (float)(var4 + 1);
            var37 = var38 = (float)(var4 + 0);
        } else if (var6 == 3) {
            var32 = var35 = (float)(var2 + 0);
            var33 = var34 = (float)(var2 + 1);
            var36 = var37 = (float)(var4 + 0);
            var38 = var39 = (float)(var4 + 1);
        } else if (var6 == 1) {
            var32 = var35 = (float)(var2 + 1);
            var33 = var34 = (float)(var2 + 0);
            var36 = var37 = (float)(var4 + 1);
            var38 = var39 = (float)(var4 + 0);
        }

        var8.addVertexWithUV((double)var35, (double)var40, (double)var39, var23, var27);
        var8.addVertexWithUV((double)var34, (double)var40, (double)var38, var23, var29);
        var8.addVertexWithUV((double)var33, (double)var40, (double)var37, var25, var29);
        var8.addVertexWithUV((double)var32, (double)var40, (double)var36, var25, var27);
        return true;
    }

    public void func_31078_d(Block var1, int var2, int var3, int var4) {
        this.renderAllFaces = true;
        this.func_31074_b(var1, var2, var3, var4, true);
        this.renderAllFaces = false;
    }

    private boolean func_31074_b(Block var1, int var2, int var3, int var4, boolean var5) {
        int var6 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        boolean var7 = var5 || (var6 & 8) != 0;
        int var8 = BlockPistonBase.getOrientation(var6);
        if (var7) {
            switch(var8) {
            case 0:
                this.field_31087_g = 3;
                this.field_31086_h = 3;
                this.field_31085_i = 3;
                this.field_31084_j = 3;
                var1.setBlockBounds(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 1:
                var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;
            case 2:
                this.field_31085_i = 1;
                this.field_31084_j = 2;
                var1.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;
            case 3:
                this.field_31085_i = 2;
                this.field_31084_j = 1;
                this.field_31083_k = 3;
                this.field_31082_l = 3;
                var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;
            case 4:
                this.field_31087_g = 1;
                this.field_31086_h = 2;
                this.field_31083_k = 2;
                this.field_31082_l = 1;
                var1.setBlockBounds(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 5:
                this.field_31087_g = 2;
                this.field_31086_h = 1;
                this.field_31083_k = 1;
                this.field_31082_l = 2;
                var1.setBlockBounds(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }

            this.renderStandardBlock(var1, var2, var3, var4);
            this.field_31087_g = 0;
            this.field_31086_h = 0;
            this.field_31085_i = 0;
            this.field_31084_j = 0;
            this.field_31083_k = 0;
            this.field_31082_l = 0;
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else {
            switch(var8) {
            case 0:
                this.field_31087_g = 3;
                this.field_31086_h = 3;
                this.field_31085_i = 3;
                this.field_31084_j = 3;
            case 1:
            default:
                break;
            case 2:
                this.field_31085_i = 1;
                this.field_31084_j = 2;
                break;
            case 3:
                this.field_31085_i = 2;
                this.field_31084_j = 1;
                this.field_31083_k = 3;
                this.field_31082_l = 3;
                break;
            case 4:
                this.field_31087_g = 1;
                this.field_31086_h = 2;
                this.field_31083_k = 2;
                this.field_31082_l = 1;
                break;
            case 5:
                this.field_31087_g = 2;
                this.field_31086_h = 1;
                this.field_31083_k = 1;
                this.field_31082_l = 2;
            }

            this.renderStandardBlock(var1, var2, var3, var4);
            this.field_31087_g = 0;
            this.field_31086_h = 0;
            this.field_31085_i = 0;
            this.field_31084_j = 0;
            this.field_31083_k = 0;
            this.field_31082_l = 0;
        }

        return true;
    }

    private void func_31076_a(double var1, double var3, double var5, double var7, double var9, double var11, float var13, double var14) {
        int var16 = 108;
        if (this.overrideBlockTexture >= 0) {
            var16 = this.overrideBlockTexture;
        }

        int var17 = (var16 & 15) << 4;
        int var18 = var16 & 240;
        Tessellator var19 = Tessellator.instance;
        double var20 = (double)((float)(var17 + 0) / 256.0F);
        double var22 = (double)((float)(var18 + 0) / 256.0F);
        double var24 = ((double)var17 + var14 - 0.01D) / 256.0D;
        double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
        var19.setColorOpaque_F(var13, var13, var13);
        var19.addVertexWithUV(var1, var7, var9, var24, var22);
        var19.addVertexWithUV(var1, var5, var9, var20, var22);
        var19.addVertexWithUV(var3, var5, var11, var20, var26);
        var19.addVertexWithUV(var3, var7, var11, var24, var26);
    }

    private void func_31081_b(double var1, double var3, double var5, double var7, double var9, double var11, float var13, double var14) {
        int var16 = 108;
        if (this.overrideBlockTexture >= 0) {
            var16 = this.overrideBlockTexture;
        }

        int var17 = (var16 & 15) << 4;
        int var18 = var16 & 240;
        Tessellator var19 = Tessellator.instance;
        double var20 = (double)((float)(var17 + 0) / 256.0F);
        double var22 = (double)((float)(var18 + 0) / 256.0F);
        double var24 = ((double)var17 + var14 - 0.01D) / 256.0D;
        double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
        var19.setColorOpaque_F(var13, var13, var13);
        var19.addVertexWithUV(var1, var5, var11, var24, var22);
        var19.addVertexWithUV(var1, var5, var9, var20, var22);
        var19.addVertexWithUV(var3, var7, var9, var20, var26);
        var19.addVertexWithUV(var3, var7, var11, var24, var26);
    }

    private void func_31077_c(double var1, double var3, double var5, double var7, double var9, double var11, float var13, double var14) {
        int var16 = 108;
        if (this.overrideBlockTexture >= 0) {
            var16 = this.overrideBlockTexture;
        }

        int var17 = (var16 & 15) << 4;
        int var18 = var16 & 240;
        Tessellator var19 = Tessellator.instance;
        double var20 = (double)((float)(var17 + 0) / 256.0F);
        double var22 = (double)((float)(var18 + 0) / 256.0F);
        double var24 = ((double)var17 + var14 - 0.01D) / 256.0D;
        double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
        var19.setColorOpaque_F(var13, var13, var13);
        var19.addVertexWithUV(var3, var5, var9, var24, var22);
        var19.addVertexWithUV(var1, var5, var9, var20, var22);
        var19.addVertexWithUV(var1, var7, var11, var20, var26);
        var19.addVertexWithUV(var3, var7, var11, var24, var26);
    }

    public void func_31079_a(Block var1, int var2, int var3, int var4, boolean var5) {
        this.renderAllFaces = true;
        this.func_31080_c(var1, var2, var3, var4, var5);
        this.renderAllFaces = false;
    }

    private boolean func_31080_c(Block var1, int var2, int var3, int var4, boolean var5) {
        int var6 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        int var7 = BlockPistonExtension.getDirectionMeta(var6);
        float var11 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        float var12 = var5 ? 1.0F : 0.5F;
        double var13 = var5 ? 16.0D : 8.0D;
        switch(var7) {
        case 0:
            this.field_31087_g = 3;
            this.field_31086_h = 3;
            this.field_31085_i = 3;
            this.field_31084_j = 3;
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            this.func_31076_a((double)((float)var2 + 0.375F), (double)((float)var2 + 0.625F), (double)((float)var3 + 0.25F), (double)((float)var3 + 0.25F + var12), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.625F), var11 * 0.8F, var13);
            this.func_31076_a((double)((float)var2 + 0.625F), (double)((float)var2 + 0.375F), (double)((float)var3 + 0.25F), (double)((float)var3 + 0.25F + var12), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.375F), var11 * 0.8F, var13);
            this.func_31076_a((double)((float)var2 + 0.375F), (double)((float)var2 + 0.375F), (double)((float)var3 + 0.25F), (double)((float)var3 + 0.25F + var12), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.625F), var11 * 0.6F, var13);
            this.func_31076_a((double)((float)var2 + 0.625F), (double)((float)var2 + 0.625F), (double)((float)var3 + 0.25F), (double)((float)var3 + 0.25F + var12), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.375F), var11 * 0.6F, var13);
            break;
        case 1:
            var1.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            this.func_31076_a((double)((float)var2 + 0.375F), (double)((float)var2 + 0.625F), (double)((float)var3 - 0.25F + 1.0F - var12), (double)((float)var3 - 0.25F + 1.0F), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.625F), var11 * 0.8F, var13);
            this.func_31076_a((double)((float)var2 + 0.625F), (double)((float)var2 + 0.375F), (double)((float)var3 - 0.25F + 1.0F - var12), (double)((float)var3 - 0.25F + 1.0F), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.375F), var11 * 0.8F, var13);
            this.func_31076_a((double)((float)var2 + 0.375F), (double)((float)var2 + 0.375F), (double)((float)var3 - 0.25F + 1.0F - var12), (double)((float)var3 - 0.25F + 1.0F), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.625F), var11 * 0.6F, var13);
            this.func_31076_a((double)((float)var2 + 0.625F), (double)((float)var2 + 0.625F), (double)((float)var3 - 0.25F + 1.0F - var12), (double)((float)var3 - 0.25F + 1.0F), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.375F), var11 * 0.6F, var13);
            break;
        case 2:
            this.field_31085_i = 1;
            this.field_31084_j = 2;
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            this.renderStandardBlock(var1, var2, var3, var4);
            this.func_31081_b((double)((float)var2 + 0.375F), (double)((float)var2 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var4 + 0.25F), (double)((float)var4 + 0.25F + var12), var11 * 0.6F, var13);
            this.func_31081_b((double)((float)var2 + 0.625F), (double)((float)var2 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var4 + 0.25F), (double)((float)var4 + 0.25F + var12), var11 * 0.6F, var13);
            this.func_31081_b((double)((float)var2 + 0.375F), (double)((float)var2 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.375F), (double)((float)var4 + 0.25F), (double)((float)var4 + 0.25F + var12), var11 * 0.5F, var13);
            this.func_31081_b((double)((float)var2 + 0.625F), (double)((float)var2 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.625F), (double)((float)var4 + 0.25F), (double)((float)var4 + 0.25F + var12), var11, var13);
            break;
        case 3:
            this.field_31085_i = 2;
            this.field_31084_j = 1;
            this.field_31083_k = 3;
            this.field_31082_l = 3;
            var1.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            this.func_31081_b((double)((float)var2 + 0.375F), (double)((float)var2 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var4 - 0.25F + 1.0F - var12), (double)((float)var4 - 0.25F + 1.0F), var11 * 0.6F, var13);
            this.func_31081_b((double)((float)var2 + 0.625F), (double)((float)var2 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var4 - 0.25F + 1.0F - var12), (double)((float)var4 - 0.25F + 1.0F), var11 * 0.6F, var13);
            this.func_31081_b((double)((float)var2 + 0.375F), (double)((float)var2 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.375F), (double)((float)var4 - 0.25F + 1.0F - var12), (double)((float)var4 - 0.25F + 1.0F), var11 * 0.5F, var13);
            this.func_31081_b((double)((float)var2 + 0.625F), (double)((float)var2 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.625F), (double)((float)var4 - 0.25F + 1.0F - var12), (double)((float)var4 - 0.25F + 1.0F), var11, var13);
            break;
        case 4:
            this.field_31087_g = 1;
            this.field_31086_h = 2;
            this.field_31083_k = 2;
            this.field_31082_l = 1;
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            this.func_31077_c((double)((float)var2 + 0.25F), (double)((float)var2 + 0.25F + var12), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.375F), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.375F), var11 * 0.5F, var13);
            this.func_31077_c((double)((float)var2 + 0.25F), (double)((float)var2 + 0.25F + var12), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.625F), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.625F), var11, var13);
            this.func_31077_c((double)((float)var2 + 0.25F), (double)((float)var2 + 0.25F + var12), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.375F), var11 * 0.6F, var13);
            this.func_31077_c((double)((float)var2 + 0.25F), (double)((float)var2 + 0.25F + var12), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.625F), var11 * 0.6F, var13);
            break;
        case 5:
            this.field_31087_g = 2;
            this.field_31086_h = 1;
            this.field_31083_k = 1;
            this.field_31082_l = 2;
            var1.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            this.func_31077_c((double)((float)var2 - 0.25F + 1.0F - var12), (double)((float)var2 - 0.25F + 1.0F), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.375F), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.375F), var11 * 0.5F, var13);
            this.func_31077_c((double)((float)var2 - 0.25F + 1.0F - var12), (double)((float)var2 - 0.25F + 1.0F), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.625F), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.625F), var11, var13);
            this.func_31077_c((double)((float)var2 - 0.25F + 1.0F - var12), (double)((float)var2 - 0.25F + 1.0F), (double)((float)var3 + 0.375F), (double)((float)var3 + 0.625F), (double)((float)var4 + 0.375F), (double)((float)var4 + 0.375F), var11 * 0.6F, var13);
            this.func_31077_c((double)((float)var2 - 0.25F + 1.0F - var12), (double)((float)var2 - 0.25F + 1.0F), (double)((float)var3 + 0.625F), (double)((float)var3 + 0.375F), (double)((float)var4 + 0.625F), (double)((float)var4 + 0.625F), var11 * 0.6F, var13);
        }

        this.field_31087_g = 0;
        this.field_31086_h = 0;
        this.field_31085_i = 0;
        this.field_31084_j = 0;
        this.field_31083_k = 0;
        this.field_31082_l = 0;
        var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean renderBlockLever(Block var1, int var2, int var3, int var4) {
        int var5 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        int var6 = var5 & 7;
        boolean var7 = (var5 & 8) > 0;
        Tessellator var8 = Tessellator.instance;
        boolean var9 = this.overrideBlockTexture >= 0;
        if (!var9) {
            this.overrideBlockTexture = Block.cobblestone.blockIndexInTexture;
        }

        float var10 = 0.25F;
        float var11 = 0.1875F;
        float var12 = 0.1875F;
        if (var6 == 5) {
            var1.setBlockBounds(0.5F - var11, 0.0F, 0.5F - var10, 0.5F + var11, var12, 0.5F + var10);
        } else if (var6 == 6) {
            var1.setBlockBounds(0.5F - var10, 0.0F, 0.5F - var11, 0.5F + var10, var12, 0.5F + var11);
        } else if (var6 == 4) {
            var1.setBlockBounds(0.5F - var11, 0.5F - var10, 1.0F - var12, 0.5F + var11, 0.5F + var10, 1.0F);
        } else if (var6 == 3) {
            var1.setBlockBounds(0.5F - var11, 0.5F - var10, 0.0F, 0.5F + var11, 0.5F + var10, var12);
        } else if (var6 == 2) {
            var1.setBlockBounds(1.0F - var12, 0.5F - var10, 0.5F - var11, 1.0F, 0.5F + var10, 0.5F + var11);
        } else if (var6 == 1) {
            var1.setBlockBounds(0.0F, 0.5F - var10, 0.5F - var11, var12, 0.5F + var10, 0.5F + var11);
        }

        this.renderStandardBlock(var1, var2, var3, var4);
        if (!var9) {
            this.overrideBlockTexture = -1;
        }

        float var13 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var8.setColorOpaque_F(var13, var13, var13);
        int var14 = var1.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            var14 = this.overrideBlockTexture;
        }

        int var15 = (var14 & 15) << 4;
        int var16 = var14 & 240;
        float var17 = (float)var15 / 256.0F;
        float var18 = ((float)var15 + 15.99F) / 256.0F;
        float var19 = (float)var16 / 256.0F;
        float var20 = ((float)var16 + 15.99F) / 256.0F;
        Vec3D[] var21 = new Vec3D[8];
        float var22 = 0.0625F;
        float var23 = 0.0625F;
        float var24 = 0.625F;
        var21[0] = Vec3D.createVector((double)(-var22), 0.0D, (double)(-var23));
        var21[1] = Vec3D.createVector((double)var22, 0.0D, (double)(-var23));
        var21[2] = Vec3D.createVector((double)var22, 0.0D, (double)var23);
        var21[3] = Vec3D.createVector((double)(-var22), 0.0D, (double)var23);
        var21[4] = Vec3D.createVector((double)(-var22), (double)var24, (double)(-var23));
        var21[5] = Vec3D.createVector((double)var22, (double)var24, (double)(-var23));
        var21[6] = Vec3D.createVector((double)var22, (double)var24, (double)var23);
        var21[7] = Vec3D.createVector((double)(-var22), (double)var24, (double)var23);

        for(int var25 = 0; var25 < 8; ++var25) {
            if (var7) {
                var21[var25].zCoord -= 0.0625D;
                var21[var25].rotateAroundX(0.69813174F);
            } else {
                var21[var25].zCoord += 0.0625D;
                var21[var25].rotateAroundX(-0.69813174F);
            }

            if (var6 == 6) {
                var21[var25].rotateAroundY(1.5707964F);
            }

            if (var6 < 5) {
                var21[var25].yCoord -= 0.375D;
                var21[var25].rotateAroundX(1.5707964F);
                if (var6 == 4) {
                    var21[var25].rotateAroundY(0.0F);
                }

                if (var6 == 3) {
                    var21[var25].rotateAroundY(3.1415927F);
                }

                if (var6 == 2) {
                    var21[var25].rotateAroundY(1.5707964F);
                }

                if (var6 == 1) {
                    var21[var25].rotateAroundY(-1.5707964F);
                }

                var21[var25].xCoord += (double)var2 + 0.5D;
                var21[var25].yCoord += (double)((float)var3 + 0.5F);
                var21[var25].zCoord += (double)var4 + 0.5D;
            } else {
                var21[var25].xCoord += (double)var2 + 0.5D;
                var21[var25].yCoord += (double)((float)var3 + 0.125F);
                var21[var25].zCoord += (double)var4 + 0.5D;
            }
        }

        Vec3D var30 = null;
        Vec3D var26 = null;
        Vec3D var27 = null;
        Vec3D var28 = null;

        for(int var29 = 0; var29 < 6; ++var29) {
            if (var29 == 0) {
                var17 = (float)(var15 + 7) / 256.0F;
                var18 = ((float)(var15 + 9) - 0.01F) / 256.0F;
                var19 = (float)(var16 + 6) / 256.0F;
                var20 = ((float)(var16 + 8) - 0.01F) / 256.0F;
            } else if (var29 == 2) {
                var17 = (float)(var15 + 7) / 256.0F;
                var18 = ((float)(var15 + 9) - 0.01F) / 256.0F;
                var19 = (float)(var16 + 6) / 256.0F;
                var20 = ((float)(var16 + 16) - 0.01F) / 256.0F;
            }

            if (var29 == 0) {
                var30 = var21[0];
                var26 = var21[1];
                var27 = var21[2];
                var28 = var21[3];
            } else if (var29 == 1) {
                var30 = var21[7];
                var26 = var21[6];
                var27 = var21[5];
                var28 = var21[4];
            } else if (var29 == 2) {
                var30 = var21[1];
                var26 = var21[0];
                var27 = var21[4];
                var28 = var21[5];
            } else if (var29 == 3) {
                var30 = var21[2];
                var26 = var21[1];
                var27 = var21[5];
                var28 = var21[6];
            } else if (var29 == 4) {
                var30 = var21[3];
                var26 = var21[2];
                var27 = var21[6];
                var28 = var21[7];
            } else if (var29 == 5) {
                var30 = var21[0];
                var26 = var21[3];
                var27 = var21[7];
                var28 = var21[4];
            }

            var8.addVertexWithUV(var30.xCoord, var30.yCoord, var30.zCoord, (double)var17, (double)var20);
            var8.addVertexWithUV(var26.xCoord, var26.yCoord, var26.zCoord, (double)var18, (double)var20);
            var8.addVertexWithUV(var27.xCoord, var27.yCoord, var27.zCoord, (double)var18, (double)var19);
            var8.addVertexWithUV(var28.xCoord, var28.yCoord, var28.zCoord, (double)var17, (double)var19);
        }

        return true;
    }

    public boolean renderBlockFire(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        int var6 = var1.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            var6 = this.overrideBlockTexture;
        }

        float var7 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        var5.setColorOpaque_F(var7, var7, var7);
        int var8 = (var6 & 15) << 4;
        int var9 = var6 & 240;
        double var10 = (double)((float)var8 / 256.0F);
        double var12 = (double)(((float)var8 + 15.99F) / 256.0F);
        double var14 = (double)((float)var9 / 256.0F);
        double var16 = (double)(((float)var9 + 15.99F) / 256.0F);
        float var18 = 1.4F;
        double var21;
        double var23;
        double var25;
        double var27;
        double var29;
        double var31;
        double var33;
        if (!this.blockAccess.isBlockNormalCube(var2, var3 - 1, var4) && !Block.fire.canBlockCatchFire(this.blockAccess, var2, var3 - 1, var4)) {
            float var37 = 0.2F;
            float var20 = 0.0625F;
            if ((var2 + var3 + var4 & 1) == 1) {
                var10 = (double)((float)var8 / 256.0F);
                var12 = (double)(((float)var8 + 15.99F) / 256.0F);
                var14 = (double)((float)(var9 + 16) / 256.0F);
                var16 = (double)(((float)var9 + 15.99F + 16.0F) / 256.0F);
            }

            if ((var2 / 2 + var3 / 2 + var4 / 2 & 1) == 1) {
                var21 = var12;
                var12 = var10;
                var10 = var21;
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, var2 - 1, var3, var4)) {
                var5.addVertexWithUV((double)((float)var2 + var37), (double)((float)var3 + var18 + var20), (double)(var4 + 1), var12, var14);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 1), var12, var16);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var10, var16);
                var5.addVertexWithUV((double)((float)var2 + var37), (double)((float)var3 + var18 + var20), (double)(var4 + 0), var10, var14);
                var5.addVertexWithUV((double)((float)var2 + var37), (double)((float)var3 + var18 + var20), (double)(var4 + 0), var10, var14);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var10, var16);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 1), var12, var16);
                var5.addVertexWithUV((double)((float)var2 + var37), (double)((float)var3 + var18 + var20), (double)(var4 + 1), var12, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, var2 + 1, var3, var4)) {
                var5.addVertexWithUV((double)((float)(var2 + 1) - var37), (double)((float)var3 + var18 + var20), (double)(var4 + 0), var10, var14);
                var5.addVertexWithUV((double)(var2 + 1 - 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var10, var16);
                var5.addVertexWithUV((double)(var2 + 1 - 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 1), var12, var16);
                var5.addVertexWithUV((double)((float)(var2 + 1) - var37), (double)((float)var3 + var18 + var20), (double)(var4 + 1), var12, var14);
                var5.addVertexWithUV((double)((float)(var2 + 1) - var37), (double)((float)var3 + var18 + var20), (double)(var4 + 1), var12, var14);
                var5.addVertexWithUV((double)(var2 + 1 - 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 1), var12, var16);
                var5.addVertexWithUV((double)(var2 + 1 - 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var10, var16);
                var5.addVertexWithUV((double)((float)(var2 + 1) - var37), (double)((float)var3 + var18 + var20), (double)(var4 + 0), var10, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, var2, var3, var4 - 1)) {
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18 + var20), (double)((float)var4 + var37), var12, var14);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var12, var16);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var10, var16);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18 + var20), (double)((float)var4 + var37), var10, var14);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18 + var20), (double)((float)var4 + var37), var10, var14);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var10, var16);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 0), var12, var16);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18 + var20), (double)((float)var4 + var37), var12, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, var2, var3, var4 + 1)) {
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18 + var20), (double)((float)(var4 + 1) - var37), var10, var14);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 0) + var20), (double)(var4 + 1 - 0), var10, var16);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 1 - 0), var12, var16);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18 + var20), (double)((float)(var4 + 1) - var37), var12, var14);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18 + var20), (double)((float)(var4 + 1) - var37), var12, var14);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 0) + var20), (double)(var4 + 1 - 0), var12, var16);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 0) + var20), (double)(var4 + 1 - 0), var10, var16);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18 + var20), (double)((float)(var4 + 1) - var37), var10, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, var2, var3 + 1, var4)) {
                var21 = (double)var2 + 0.5D + 0.5D;
                var23 = (double)var2 + 0.5D - 0.5D;
                var25 = (double)var4 + 0.5D + 0.5D;
                var27 = (double)var4 + 0.5D - 0.5D;
                var29 = (double)var2 + 0.5D - 0.5D;
                var31 = (double)var2 + 0.5D + 0.5D;
                var33 = (double)var4 + 0.5D - 0.5D;
                double var35 = (double)var4 + 0.5D + 0.5D;
                var10 = (double)((float)var8 / 256.0F);
                var12 = (double)(((float)var8 + 15.99F) / 256.0F);
                var14 = (double)((float)var9 / 256.0F);
                var16 = (double)(((float)var9 + 15.99F) / 256.0F);
                ++var3;
                var18 = -0.2F;
                if ((var2 + var3 + var4 & 1) == 0) {
                    var5.addVertexWithUV(var29, (double)((float)var3 + var18), (double)(var4 + 0), var12, var14);
                    var5.addVertexWithUV(var21, (double)(var3 + 0), (double)(var4 + 0), var12, var16);
                    var5.addVertexWithUV(var21, (double)(var3 + 0), (double)(var4 + 1), var10, var16);
                    var5.addVertexWithUV(var29, (double)((float)var3 + var18), (double)(var4 + 1), var10, var14);
                    var10 = (double)((float)var8 / 256.0F);
                    var12 = (double)(((float)var8 + 15.99F) / 256.0F);
                    var14 = (double)((float)(var9 + 16) / 256.0F);
                    var16 = (double)(((float)var9 + 15.99F + 16.0F) / 256.0F);
                    var5.addVertexWithUV(var31, (double)((float)var3 + var18), (double)(var4 + 1), var12, var14);
                    var5.addVertexWithUV(var23, (double)(var3 + 0), (double)(var4 + 1), var12, var16);
                    var5.addVertexWithUV(var23, (double)(var3 + 0), (double)(var4 + 0), var10, var16);
                    var5.addVertexWithUV(var31, (double)((float)var3 + var18), (double)(var4 + 0), var10, var14);
                } else {
                    var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18), var35, var12, var14);
                    var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), var27, var12, var16);
                    var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), var27, var10, var16);
                    var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18), var35, var10, var14);
                    var10 = (double)((float)var8 / 256.0F);
                    var12 = (double)(((float)var8 + 15.99F) / 256.0F);
                    var14 = (double)((float)(var9 + 16) / 256.0F);
                    var16 = (double)(((float)var9 + 15.99F + 16.0F) / 256.0F);
                    var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18), var33, var12, var14);
                    var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), var25, var12, var16);
                    var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), var25, var10, var16);
                    var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18), var33, var10, var14);
                }
            }
        } else {
            double var19 = (double)var2 + 0.5D + 0.2D;
            var21 = (double)var2 + 0.5D - 0.2D;
            var23 = (double)var4 + 0.5D + 0.2D;
            var25 = (double)var4 + 0.5D - 0.2D;
            var27 = (double)var2 + 0.5D - 0.3D;
            var29 = (double)var2 + 0.5D + 0.3D;
            var31 = (double)var4 + 0.5D - 0.3D;
            var33 = (double)var4 + 0.5D + 0.3D;
            var5.addVertexWithUV(var27, (double)((float)var3 + var18), (double)(var4 + 1), var12, var14);
            var5.addVertexWithUV(var19, (double)(var3 + 0), (double)(var4 + 1), var12, var16);
            var5.addVertexWithUV(var19, (double)(var3 + 0), (double)(var4 + 0), var10, var16);
            var5.addVertexWithUV(var27, (double)((float)var3 + var18), (double)(var4 + 0), var10, var14);
            var5.addVertexWithUV(var29, (double)((float)var3 + var18), (double)(var4 + 0), var12, var14);
            var5.addVertexWithUV(var21, (double)(var3 + 0), (double)(var4 + 0), var12, var16);
            var5.addVertexWithUV(var21, (double)(var3 + 0), (double)(var4 + 1), var10, var16);
            var5.addVertexWithUV(var29, (double)((float)var3 + var18), (double)(var4 + 1), var10, var14);
            var10 = (double)((float)var8 / 256.0F);
            var12 = (double)(((float)var8 + 15.99F) / 256.0F);
            var14 = (double)((float)(var9 + 16) / 256.0F);
            var16 = (double)(((float)var9 + 15.99F + 16.0F) / 256.0F);
            var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18), var33, var12, var14);
            var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), var25, var12, var16);
            var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), var25, var10, var16);
            var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18), var33, var10, var14);
            var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18), var31, var12, var14);
            var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), var23, var12, var16);
            var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), var23, var10, var16);
            var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18), var31, var10, var14);
            var19 = (double)var2 + 0.5D - 0.5D;
            var21 = (double)var2 + 0.5D + 0.5D;
            var23 = (double)var4 + 0.5D - 0.5D;
            var25 = (double)var4 + 0.5D + 0.5D;
            var27 = (double)var2 + 0.5D - 0.4D;
            var29 = (double)var2 + 0.5D + 0.4D;
            var31 = (double)var4 + 0.5D - 0.4D;
            var33 = (double)var4 + 0.5D + 0.4D;
            var5.addVertexWithUV(var27, (double)((float)var3 + var18), (double)(var4 + 0), var10, var14);
            var5.addVertexWithUV(var19, (double)(var3 + 0), (double)(var4 + 0), var10, var16);
            var5.addVertexWithUV(var19, (double)(var3 + 0), (double)(var4 + 1), var12, var16);
            var5.addVertexWithUV(var27, (double)((float)var3 + var18), (double)(var4 + 1), var12, var14);
            var5.addVertexWithUV(var29, (double)((float)var3 + var18), (double)(var4 + 1), var10, var14);
            var5.addVertexWithUV(var21, (double)(var3 + 0), (double)(var4 + 1), var10, var16);
            var5.addVertexWithUV(var21, (double)(var3 + 0), (double)(var4 + 0), var12, var16);
            var5.addVertexWithUV(var29, (double)((float)var3 + var18), (double)(var4 + 0), var12, var14);
            var10 = (double)((float)var8 / 256.0F);
            var12 = (double)(((float)var8 + 15.99F) / 256.0F);
            var14 = (double)((float)var9 / 256.0F);
            var16 = (double)(((float)var9 + 15.99F) / 256.0F);
            var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18), var33, var10, var14);
            var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), var25, var10, var16);
            var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), var25, var12, var16);
            var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18), var33, var12, var14);
            var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var18), var31, var10, var14);
            var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), var23, var10, var16);
            var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), var23, var12, var16);
            var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var18), var31, var12, var14);
        }

        return true;
    }

    public boolean renderBlockRedstoneWire(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        int var6 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        int var7 = var1.getBlockTextureFromSideAndMetadata(1, var6);
        if (this.overrideBlockTexture >= 0) {
            var7 = this.overrideBlockTexture;
        }

        float var8 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        float var9 = (float)var6 / 15.0F;
        float var10 = var9 * 0.6F + 0.4F;
        if (var6 == 0) {
            var10 = 0.3F;
        }

        float var11 = var9 * var9 * 0.7F - 0.5F;
        float var12 = var9 * var9 * 0.6F - 0.7F;
        if (var11 < 0.0F) {
            var11 = 0.0F;
        }

        if (var12 < 0.0F) {
            var12 = 0.0F;
        }

        var5.setColorOpaque_F(var8 * var10, var8 * var11, var8 * var12);
        int var13 = (var7 & 15) << 4;
        int var14 = var7 & 240;
        double var15 = (double)((float)var13 / 256.0F);
        double var17 = (double)(((float)var13 + 15.99F) / 256.0F);
        double var19 = (double)((float)var14 / 256.0F);
        double var21 = (double)(((float)var14 + 15.99F) / 256.0F);
        boolean var26 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2 - 1, var3, var4, 1) || !this.blockAccess.isBlockNormalCube(var2 - 1, var3, var4) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2 - 1, var3 - 1, var4, -1);
        boolean var27 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2 + 1, var3, var4, 3) || !this.blockAccess.isBlockNormalCube(var2 + 1, var3, var4) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2 + 1, var3 - 1, var4, -1);
        boolean var28 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2, var3, var4 - 1, 2) || !this.blockAccess.isBlockNormalCube(var2, var3, var4 - 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2, var3 - 1, var4 - 1, -1);
        boolean var29 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2, var3, var4 + 1, 0) || !this.blockAccess.isBlockNormalCube(var2, var3, var4 + 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2, var3 - 1, var4 + 1, -1);
        if (!this.blockAccess.isBlockNormalCube(var2, var3 + 1, var4)) {
            if (this.blockAccess.isBlockNormalCube(var2 - 1, var3, var4) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2 - 1, var3 + 1, var4, -1)) {
                var26 = true;
            }

            if (this.blockAccess.isBlockNormalCube(var2 + 1, var3, var4) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2 + 1, var3 + 1, var4, -1)) {
                var27 = true;
            }

            if (this.blockAccess.isBlockNormalCube(var2, var3, var4 - 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2, var3 + 1, var4 - 1, -1)) {
                var28 = true;
            }

            if (this.blockAccess.isBlockNormalCube(var2, var3, var4 + 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, var2, var3 + 1, var4 + 1, -1)) {
                var29 = true;
            }
        }

        float var31 = (float)(var2 + 0);
        float var32 = (float)(var2 + 1);
        float var33 = (float)(var4 + 0);
        float var34 = (float)(var4 + 1);
        byte var35 = 0;
        if ((var26 || var27) && !var28 && !var29) {
            var35 = 1;
        }

        if ((var28 || var29) && !var27 && !var26) {
            var35 = 2;
        }

        if (var35 != 0) {
            var15 = (double)((float)(var13 + 16) / 256.0F);
            var17 = (double)(((float)(var13 + 16) + 15.99F) / 256.0F);
            var19 = (double)((float)var14 / 256.0F);
            var21 = (double)(((float)var14 + 15.99F) / 256.0F);
        }

        if (var35 == 0) {
            if (var27 || var28 || var29 || var26) {
                if (!var26) {
                    var31 += 0.3125F;
                }

                if (!var26) {
                    var15 += 0.01953125D;
                }

                if (!var27) {
                    var32 -= 0.3125F;
                }

                if (!var27) {
                    var17 -= 0.01953125D;
                }

                if (!var28) {
                    var33 += 0.3125F;
                }

                if (!var28) {
                    var19 += 0.01953125D;
                }

                if (!var29) {
                    var34 -= 0.3125F;
                }

                if (!var29) {
                    var21 -= 0.01953125D;
                }
            }

            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var34, var17, var21);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var33, var17, var19);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var33, var15, var19);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var34, var15, var21);
            var5.setColorOpaque_F(var8, var8, var8);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var34, var17, var21 + 0.0625D);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var33, var17, var19 + 0.0625D);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var33, var15, var19 + 0.0625D);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var34, var15, var21 + 0.0625D);
        } else if (var35 == 1) {
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var34, var17, var21);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var33, var17, var19);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var33, var15, var19);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var34, var15, var21);
            var5.setColorOpaque_F(var8, var8, var8);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var34, var17, var21 + 0.0625D);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var33, var17, var19 + 0.0625D);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var33, var15, var19 + 0.0625D);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var34, var15, var21 + 0.0625D);
        } else if (var35 == 2) {
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var34, var17, var21);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var33, var15, var21);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var33, var15, var19);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var34, var17, var19);
            var5.setColorOpaque_F(var8, var8, var8);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var34, var17, var21 + 0.0625D);
            var5.addVertexWithUV((double)var32, (double)((float)var3 + 0.015625F), (double)var33, var15, var21 + 0.0625D);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var33, var15, var19 + 0.0625D);
            var5.addVertexWithUV((double)var31, (double)((float)var3 + 0.015625F), (double)var34, var17, var19 + 0.0625D);
        }

        if (!this.blockAccess.isBlockNormalCube(var2, var3 + 1, var4)) {
            var15 = (double)((float)(var13 + 16) / 256.0F);
            var17 = (double)(((float)(var13 + 16) + 15.99F) / 256.0F);
            var19 = (double)((float)var14 / 256.0F);
            var21 = (double)(((float)var14 + 15.99F) / 256.0F);
            if (this.blockAccess.isBlockNormalCube(var2 - 1, var3, var4) && this.blockAccess.getBlockId(var2 - 1, var3 + 1, var4) == Block.redstoneWire.blockID) {
                var5.setColorOpaque_F(var8 * var10, var8 * var11, var8 * var12);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 1), var17, var19);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)(var3 + 0), (double)(var4 + 1), var15, var19);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)(var3 + 0), (double)(var4 + 0), var15, var21);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 0), var17, var21);
                var5.setColorOpaque_F(var8, var8, var8);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 1), var17, var19 + 0.0625D);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)(var3 + 0), (double)(var4 + 1), var15, var19 + 0.0625D);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)(var3 + 0), (double)(var4 + 0), var15, var21 + 0.0625D);
                var5.addVertexWithUV((double)((float)var2 + 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 0), var17, var21 + 0.0625D);
            }

            if (this.blockAccess.isBlockNormalCube(var2 + 1, var3, var4) && this.blockAccess.getBlockId(var2 + 1, var3 + 1, var4) == Block.redstoneWire.blockID) {
                var5.setColorOpaque_F(var8 * var10, var8 * var11, var8 * var12);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)(var3 + 0), (double)(var4 + 1), var15, var21);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 1), var17, var21);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 0), var17, var19);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)(var3 + 0), (double)(var4 + 0), var15, var19);
                var5.setColorOpaque_F(var8, var8, var8);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)(var3 + 0), (double)(var4 + 1), var15, var21 + 0.0625D);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 1), var17, var21 + 0.0625D);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)((float)(var3 + 1) + 0.021875F), (double)(var4 + 0), var17, var19 + 0.0625D);
                var5.addVertexWithUV((double)((float)(var2 + 1) - 0.015625F), (double)(var3 + 0), (double)(var4 + 0), var15, var19 + 0.0625D);
            }

            if (this.blockAccess.isBlockNormalCube(var2, var3, var4 - 1) && this.blockAccess.getBlockId(var2, var3 + 1, var4 - 1) == Block.redstoneWire.blockID) {
                var5.setColorOpaque_F(var8 * var10, var8 * var11, var8 * var12);
                var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), (double)((float)var4 + 0.015625F), var15, var21);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 1) + 0.021875F), (double)((float)var4 + 0.015625F), var17, var21);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 1) + 0.021875F), (double)((float)var4 + 0.015625F), var17, var19);
                var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), (double)((float)var4 + 0.015625F), var15, var19);
                var5.setColorOpaque_F(var8, var8, var8);
                var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), (double)((float)var4 + 0.015625F), var15, var21 + 0.0625D);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 1) + 0.021875F), (double)((float)var4 + 0.015625F), var17, var21 + 0.0625D);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 1) + 0.021875F), (double)((float)var4 + 0.015625F), var17, var19 + 0.0625D);
                var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), (double)((float)var4 + 0.015625F), var15, var19 + 0.0625D);
            }

            if (this.blockAccess.isBlockNormalCube(var2, var3, var4 + 1) && this.blockAccess.getBlockId(var2, var3 + 1, var4 + 1) == Block.redstoneWire.blockID) {
                var5.setColorOpaque_F(var8 * var10, var8 * var11, var8 * var12);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 1) + 0.021875F), (double)((float)(var4 + 1) - 0.015625F), var17, var19);
                var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), (double)((float)(var4 + 1) - 0.015625F), var15, var19);
                var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), (double)((float)(var4 + 1) - 0.015625F), var15, var21);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 1) + 0.021875F), (double)((float)(var4 + 1) - 0.015625F), var17, var21);
                var5.setColorOpaque_F(var8, var8, var8);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)(var3 + 1) + 0.021875F), (double)((float)(var4 + 1) - 0.015625F), var17, var19 + 0.0625D);
                var5.addVertexWithUV((double)(var2 + 1), (double)(var3 + 0), (double)((float)(var4 + 1) - 0.015625F), var15, var19 + 0.0625D);
                var5.addVertexWithUV((double)(var2 + 0), (double)(var3 + 0), (double)((float)(var4 + 1) - 0.015625F), var15, var21 + 0.0625D);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)(var3 + 1) + 0.021875F), (double)((float)(var4 + 1) - 0.015625F), var17, var21 + 0.0625D);
            }
        }

        return true;
    }

    public boolean renderBlockMinecartTrack(BlockRail var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        int var6 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        int var7 = var1.getBlockTextureFromSideAndMetadata(0, var6);
        if (this.overrideBlockTexture >= 0) {
            var7 = this.overrideBlockTexture;
        }

        if (var1.getIsPowered()) {
            var6 &= 7;
        }

        float var8 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        var5.setColorOpaque_F(var8, var8, var8);
        int var9 = (var7 & 15) << 4;
        int var10 = var7 & 240;
        double var11 = (double)((float)var9 / 256.0F);
        double var13 = (double)(((float)var9 + 15.99F) / 256.0F);
        double var15 = (double)((float)var10 / 256.0F);
        double var17 = (double)(((float)var10 + 15.99F) / 256.0F);
        float var19 = 0.0625F;
        float var20 = (float)(var2 + 1);
        float var21 = (float)(var2 + 1);
        float var22 = (float)(var2 + 0);
        float var23 = (float)(var2 + 0);
        float var24 = (float)(var4 + 0);
        float var25 = (float)(var4 + 1);
        float var26 = (float)(var4 + 1);
        float var27 = (float)(var4 + 0);
        float var28 = (float)var3 + var19;
        float var29 = (float)var3 + var19;
        float var30 = (float)var3 + var19;
        float var31 = (float)var3 + var19;
        if (var6 != 1 && var6 != 2 && var6 != 3 && var6 != 7) {
            if (var6 == 8) {
                var20 = var21 = (float)(var2 + 0);
                var22 = var23 = (float)(var2 + 1);
                var24 = var27 = (float)(var4 + 1);
                var25 = var26 = (float)(var4 + 0);
            } else if (var6 == 9) {
                var20 = var23 = (float)(var2 + 0);
                var21 = var22 = (float)(var2 + 1);
                var24 = var25 = (float)(var4 + 0);
                var26 = var27 = (float)(var4 + 1);
            }
        } else {
            var20 = var23 = (float)(var2 + 1);
            var21 = var22 = (float)(var2 + 0);
            var24 = var25 = (float)(var4 + 1);
            var26 = var27 = (float)(var4 + 0);
        }

        if (var6 != 2 && var6 != 4) {
            if (var6 == 3 || var6 == 5) {
                ++var29;
                ++var30;
            }
        } else {
            ++var28;
            ++var31;
        }

        var5.addVertexWithUV((double)var20, (double)var28, (double)var24, var13, var15);
        var5.addVertexWithUV((double)var21, (double)var29, (double)var25, var13, var17);
        var5.addVertexWithUV((double)var22, (double)var30, (double)var26, var11, var17);
        var5.addVertexWithUV((double)var23, (double)var31, (double)var27, var11, var15);
        var5.addVertexWithUV((double)var23, (double)var31, (double)var27, var11, var15);
        var5.addVertexWithUV((double)var22, (double)var30, (double)var26, var11, var17);
        var5.addVertexWithUV((double)var21, (double)var29, (double)var25, var13, var17);
        var5.addVertexWithUV((double)var20, (double)var28, (double)var24, var13, var15);
        return true;
    }

    public boolean renderBlockLadder(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        int var6 = var1.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            var6 = this.overrideBlockTexture;
        }

        float var7 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        var5.setColorOpaque_F(var7, var7, var7);
        int var8 = (var6 & 15) << 4;
        int var9 = var6 & 240;
        double var10 = (double)((float)var8 / 256.0F);
        double var12 = (double)(((float)var8 + 15.99F) / 256.0F);
        double var14 = (double)((float)var9 / 256.0F);
        double var16 = (double)(((float)var9 + 15.99F) / 256.0F);
        int var18 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        float var19 = 0.0F;
        float var20 = 0.05F;
        if (var18 == 5) {
            var5.addVertexWithUV((double)((float)var2 + var20), (double)((float)(var3 + 1) + var19), (double)((float)(var4 + 1) + var19), var10, var14);
            var5.addVertexWithUV((double)((float)var2 + var20), (double)((float)(var3 + 0) - var19), (double)((float)(var4 + 1) + var19), var10, var16);
            var5.addVertexWithUV((double)((float)var2 + var20), (double)((float)(var3 + 0) - var19), (double)((float)(var4 + 0) - var19), var12, var16);
            var5.addVertexWithUV((double)((float)var2 + var20), (double)((float)(var3 + 1) + var19), (double)((float)(var4 + 0) - var19), var12, var14);
        }

        if (var18 == 4) {
            var5.addVertexWithUV((double)((float)(var2 + 1) - var20), (double)((float)(var3 + 0) - var19), (double)((float)(var4 + 1) + var19), var12, var16);
            var5.addVertexWithUV((double)((float)(var2 + 1) - var20), (double)((float)(var3 + 1) + var19), (double)((float)(var4 + 1) + var19), var12, var14);
            var5.addVertexWithUV((double)((float)(var2 + 1) - var20), (double)((float)(var3 + 1) + var19), (double)((float)(var4 + 0) - var19), var10, var14);
            var5.addVertexWithUV((double)((float)(var2 + 1) - var20), (double)((float)(var3 + 0) - var19), (double)((float)(var4 + 0) - var19), var10, var16);
        }

        if (var18 == 3) {
            var5.addVertexWithUV((double)((float)(var2 + 1) + var19), (double)((float)(var3 + 0) - var19), (double)((float)var4 + var20), var12, var16);
            var5.addVertexWithUV((double)((float)(var2 + 1) + var19), (double)((float)(var3 + 1) + var19), (double)((float)var4 + var20), var12, var14);
            var5.addVertexWithUV((double)((float)(var2 + 0) - var19), (double)((float)(var3 + 1) + var19), (double)((float)var4 + var20), var10, var14);
            var5.addVertexWithUV((double)((float)(var2 + 0) - var19), (double)((float)(var3 + 0) - var19), (double)((float)var4 + var20), var10, var16);
        }

        if (var18 == 2) {
            var5.addVertexWithUV((double)((float)(var2 + 1) + var19), (double)((float)(var3 + 1) + var19), (double)((float)(var4 + 1) - var20), var10, var14);
            var5.addVertexWithUV((double)((float)(var2 + 1) + var19), (double)((float)(var3 + 0) - var19), (double)((float)(var4 + 1) - var20), var10, var16);
            var5.addVertexWithUV((double)((float)(var2 + 0) - var19), (double)((float)(var3 + 0) - var19), (double)((float)(var4 + 1) - var20), var12, var16);
            var5.addVertexWithUV((double)((float)(var2 + 0) - var19), (double)((float)(var3 + 1) + var19), (double)((float)(var4 + 1) - var20), var12, var14);
        }

        return true;
    }

    public boolean renderBlockReed(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        float var6 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        int var7 = var1.colorMultiplier(this.blockAccess, var2, var3, var4);
        float var8 = (float)(var7 >> 16 & 255) / 255.0F;
        float var9 = (float)(var7 >> 8 & 255) / 255.0F;
        float var10 = (float)(var7 & 255) / 255.0F;
        if (EntityRenderer.anaglyphEnable) {
            float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
            float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
            float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
            var8 = var11;
            var9 = var12;
            var10 = var13;
        }

        var5.setColorOpaque_F(var6 * var8, var6 * var9, var6 * var10);
        double var19 = (double)var2;
        double var20 = (double)var3;
        double var15 = (double)var4;
        if (var1 == Block.tallGrass) {
            long var17 = (long)(var2 * 3129871) ^ (long)var4 * 116129781L ^ (long)var3;
            var17 = var17 * var17 * 42317861L + var17 * 11L;
            var19 += ((double)((float)(var17 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
            var20 += ((double)((float)(var17 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
            var15 += ((double)((float)(var17 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
        }

        this.renderCrossedSquares(var1, this.blockAccess.getBlockMetadata(var2, var3, var4), var19, var20, var15);
        return true;
    }

    public boolean renderBlockCrops(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        float var6 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        var5.setColorOpaque_F(var6, var6, var6);
        this.func_1245_b(var1, this.blockAccess.getBlockMetadata(var2, var3, var4), (double)var2, (double)((float)var3 - 0.0625F), (double)var4);
        return true;
    }

    public void renderTorchAtAngle(Block var1, double var2, double var4, double var6, double var8, double var10) {
        Tessellator var12 = Tessellator.instance;
        int var13 = var1.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            var13 = this.overrideBlockTexture;
        }

        int var14 = (var13 & 15) << 4;
        int var15 = var13 & 240;
        float var16 = (float)var14 / 256.0F;
        float var17 = ((float)var14 + 15.99F) / 256.0F;
        float var18 = (float)var15 / 256.0F;
        float var19 = ((float)var15 + 15.99F) / 256.0F;
        double var20 = (double)var16 + 0.02734375D;
        double var22 = (double)var18 + 0.0234375D;
        double var24 = (double)var16 + 0.03515625D;
        double var26 = (double)var18 + 0.03125D;
        var2 += 0.5D;
        var6 += 0.5D;
        double var28 = var2 - 0.5D;
        double var30 = var2 + 0.5D;
        double var32 = var6 - 0.5D;
        double var34 = var6 + 0.5D;
        double var36 = 0.0625D;
        double var38 = 0.625D;
        var12.addVertexWithUV(var2 + var8 * (1.0D - var38) - var36, var4 + var38, var6 + var10 * (1.0D - var38) - var36, var20, var22);
        var12.addVertexWithUV(var2 + var8 * (1.0D - var38) - var36, var4 + var38, var6 + var10 * (1.0D - var38) + var36, var20, var26);
        var12.addVertexWithUV(var2 + var8 * (1.0D - var38) + var36, var4 + var38, var6 + var10 * (1.0D - var38) + var36, var24, var26);
        var12.addVertexWithUV(var2 + var8 * (1.0D - var38) + var36, var4 + var38, var6 + var10 * (1.0D - var38) - var36, var24, var22);
        var12.addVertexWithUV(var2 - var36, var4 + 1.0D, var32, (double)var16, (double)var18);
        var12.addVertexWithUV(var2 - var36 + var8, var4 + 0.0D, var32 + var10, (double)var16, (double)var19);
        var12.addVertexWithUV(var2 - var36 + var8, var4 + 0.0D, var34 + var10, (double)var17, (double)var19);
        var12.addVertexWithUV(var2 - var36, var4 + 1.0D, var34, (double)var17, (double)var18);
        var12.addVertexWithUV(var2 + var36, var4 + 1.0D, var34, (double)var16, (double)var18);
        var12.addVertexWithUV(var2 + var8 + var36, var4 + 0.0D, var34 + var10, (double)var16, (double)var19);
        var12.addVertexWithUV(var2 + var8 + var36, var4 + 0.0D, var32 + var10, (double)var17, (double)var19);
        var12.addVertexWithUV(var2 + var36, var4 + 1.0D, var32, (double)var17, (double)var18);
        var12.addVertexWithUV(var28, var4 + 1.0D, var6 + var36, (double)var16, (double)var18);
        var12.addVertexWithUV(var28 + var8, var4 + 0.0D, var6 + var36 + var10, (double)var16, (double)var19);
        var12.addVertexWithUV(var30 + var8, var4 + 0.0D, var6 + var36 + var10, (double)var17, (double)var19);
        var12.addVertexWithUV(var30, var4 + 1.0D, var6 + var36, (double)var17, (double)var18);
        var12.addVertexWithUV(var30, var4 + 1.0D, var6 - var36, (double)var16, (double)var18);
        var12.addVertexWithUV(var30 + var8, var4 + 0.0D, var6 - var36 + var10, (double)var16, (double)var19);
        var12.addVertexWithUV(var28 + var8, var4 + 0.0D, var6 - var36 + var10, (double)var17, (double)var19);
        var12.addVertexWithUV(var28, var4 + 1.0D, var6 - var36, (double)var17, (double)var18);
    }

    public void renderCrossedSquares(Block var1, int var2, double var3, double var5, double var7) {
        Tessellator var9 = Tessellator.instance;
        int var10 = var1.getBlockTextureFromSideAndMetadata(0, var2);
        if (this.overrideBlockTexture >= 0) {
            var10 = this.overrideBlockTexture;
        }

        int var11 = (var10 & 15) << 4;
        int var12 = var10 & 240;
        double var13 = (double)((float)var11 / 256.0F);
        double var15 = (double)(((float)var11 + 15.99F) / 256.0F);
        double var17 = (double)((float)var12 / 256.0F);
        double var19 = (double)(((float)var12 + 15.99F) / 256.0F);
        double var21 = var3 + 0.5D - 0.44999998807907104D;
        double var23 = var3 + 0.5D + 0.44999998807907104D;
        double var25 = var7 + 0.5D - 0.44999998807907104D;
        double var27 = var7 + 0.5D + 0.44999998807907104D;
        var9.addVertexWithUV(var21, var5 + 1.0D, var25, var13, var17);
        var9.addVertexWithUV(var21, var5 + 0.0D, var25, var13, var19);
        var9.addVertexWithUV(var23, var5 + 0.0D, var27, var15, var19);
        var9.addVertexWithUV(var23, var5 + 1.0D, var27, var15, var17);
        var9.addVertexWithUV(var23, var5 + 1.0D, var27, var13, var17);
        var9.addVertexWithUV(var23, var5 + 0.0D, var27, var13, var19);
        var9.addVertexWithUV(var21, var5 + 0.0D, var25, var15, var19);
        var9.addVertexWithUV(var21, var5 + 1.0D, var25, var15, var17);
        var9.addVertexWithUV(var21, var5 + 1.0D, var27, var13, var17);
        var9.addVertexWithUV(var21, var5 + 0.0D, var27, var13, var19);
        var9.addVertexWithUV(var23, var5 + 0.0D, var25, var15, var19);
        var9.addVertexWithUV(var23, var5 + 1.0D, var25, var15, var17);
        var9.addVertexWithUV(var23, var5 + 1.0D, var25, var13, var17);
        var9.addVertexWithUV(var23, var5 + 0.0D, var25, var13, var19);
        var9.addVertexWithUV(var21, var5 + 0.0D, var27, var15, var19);
        var9.addVertexWithUV(var21, var5 + 1.0D, var27, var15, var17);
    }

    public void func_1245_b(Block var1, int var2, double var3, double var5, double var7) {
        Tessellator var9 = Tessellator.instance;
        int var10 = var1.getBlockTextureFromSideAndMetadata(0, var2);
        if (this.overrideBlockTexture >= 0) {
            var10 = this.overrideBlockTexture;
        }

        int var11 = (var10 & 15) << 4;
        int var12 = var10 & 240;
        double var13 = (double)((float)var11 / 256.0F);
        double var15 = (double)(((float)var11 + 15.99F) / 256.0F);
        double var17 = (double)((float)var12 / 256.0F);
        double var19 = (double)(((float)var12 + 15.99F) / 256.0F);
        double var21 = var3 + 0.5D - 0.25D;
        double var23 = var3 + 0.5D + 0.25D;
        double var25 = var7 + 0.5D - 0.5D;
        double var27 = var7 + 0.5D + 0.5D;
        var9.addVertexWithUV(var21, var5 + 1.0D, var25, var13, var17);
        var9.addVertexWithUV(var21, var5 + 0.0D, var25, var13, var19);
        var9.addVertexWithUV(var21, var5 + 0.0D, var27, var15, var19);
        var9.addVertexWithUV(var21, var5 + 1.0D, var27, var15, var17);
        var9.addVertexWithUV(var21, var5 + 1.0D, var27, var13, var17);
        var9.addVertexWithUV(var21, var5 + 0.0D, var27, var13, var19);
        var9.addVertexWithUV(var21, var5 + 0.0D, var25, var15, var19);
        var9.addVertexWithUV(var21, var5 + 1.0D, var25, var15, var17);
        var9.addVertexWithUV(var23, var5 + 1.0D, var27, var13, var17);
        var9.addVertexWithUV(var23, var5 + 0.0D, var27, var13, var19);
        var9.addVertexWithUV(var23, var5 + 0.0D, var25, var15, var19);
        var9.addVertexWithUV(var23, var5 + 1.0D, var25, var15, var17);
        var9.addVertexWithUV(var23, var5 + 1.0D, var25, var13, var17);
        var9.addVertexWithUV(var23, var5 + 0.0D, var25, var13, var19);
        var9.addVertexWithUV(var23, var5 + 0.0D, var27, var15, var19);
        var9.addVertexWithUV(var23, var5 + 1.0D, var27, var15, var17);
        var21 = var3 + 0.5D - 0.5D;
        var23 = var3 + 0.5D + 0.5D;
        var25 = var7 + 0.5D - 0.25D;
        var27 = var7 + 0.5D + 0.25D;
        var9.addVertexWithUV(var21, var5 + 1.0D, var25, var13, var17);
        var9.addVertexWithUV(var21, var5 + 0.0D, var25, var13, var19);
        var9.addVertexWithUV(var23, var5 + 0.0D, var25, var15, var19);
        var9.addVertexWithUV(var23, var5 + 1.0D, var25, var15, var17);
        var9.addVertexWithUV(var23, var5 + 1.0D, var25, var13, var17);
        var9.addVertexWithUV(var23, var5 + 0.0D, var25, var13, var19);
        var9.addVertexWithUV(var21, var5 + 0.0D, var25, var15, var19);
        var9.addVertexWithUV(var21, var5 + 1.0D, var25, var15, var17);
        var9.addVertexWithUV(var23, var5 + 1.0D, var27, var13, var17);
        var9.addVertexWithUV(var23, var5 + 0.0D, var27, var13, var19);
        var9.addVertexWithUV(var21, var5 + 0.0D, var27, var15, var19);
        var9.addVertexWithUV(var21, var5 + 1.0D, var27, var15, var17);
        var9.addVertexWithUV(var21, var5 + 1.0D, var27, var13, var17);
        var9.addVertexWithUV(var21, var5 + 0.0D, var27, var13, var19);
        var9.addVertexWithUV(var23, var5 + 0.0D, var27, var15, var19);
        var9.addVertexWithUV(var23, var5 + 1.0D, var27, var15, var17);
    }

    public boolean renderBlockFluids(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        int var6 = var1.colorMultiplier(this.blockAccess, var2, var3, var4);
        float var7 = (float)(var6 >> 16 & 255) / 255.0F;
        float var8 = (float)(var6 >> 8 & 255) / 255.0F;
        float var9 = (float)(var6 & 255) / 255.0F;
        boolean var10 = var1.shouldSideBeRendered(this.blockAccess, var2, var3 + 1, var4, 1);
        boolean var11 = var1.shouldSideBeRendered(this.blockAccess, var2, var3 - 1, var4, 0);
        boolean[] var12 = new boolean[]{var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 - 1, 2), var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 + 1, 3), var1.shouldSideBeRendered(this.blockAccess, var2 - 1, var3, var4, 4), var1.shouldSideBeRendered(this.blockAccess, var2 + 1, var3, var4, 5)};
        if (!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3]) {
            return false;
        } else {
            boolean var13 = false;
            float var14 = 0.5F;
            float var15 = 1.0F;
            float var16 = 0.8F;
            float var17 = 0.6F;
            double var18 = 0.0D;
            double var20 = 1.0D;
            Material var22 = var1.blockMaterial;
            int var23 = this.blockAccess.getBlockMetadata(var2, var3, var4);
            float var24 = this.func_1224_a(var2, var3, var4, var22);
            float var25 = this.func_1224_a(var2, var3, var4 + 1, var22);
            float var26 = this.func_1224_a(var2 + 1, var3, var4 + 1, var22);
            float var27 = this.func_1224_a(var2 + 1, var3, var4, var22);
            int var28;
            int var31;
            float var36;
            float var37;
            float var38;
            if (this.renderAllFaces || var10) {
                var13 = true;
                var28 = var1.getBlockTextureFromSideAndMetadata(1, var23);
                float var29 = (float)BlockFluid.getFlowDirection(this.blockAccess, var2, var3, var4, var22);
                if (var29 > -999.0F) {
                    var28 = var1.getBlockTextureFromSideAndMetadata(2, var23);
                }

                int var30 = (var28 & 15) << 4;
                var31 = var28 & 240;
                double var32 = ((double)var30 + 8.0D) / 256.0D;
                double var34 = ((double)var31 + 8.0D) / 256.0D;
                if (var29 < -999.0F) {
                    var29 = 0.0F;
                } else {
                    var32 = (double)((float)(var30 + 16) / 256.0F);
                    var34 = (double)((float)(var31 + 16) / 256.0F);
                }

                var36 = MathHelper.sin(var29) * 8.0F / 256.0F;
                var37 = MathHelper.cos(var29) * 8.0F / 256.0F;
                var38 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
                var5.setColorOpaque_F(var15 * var38 * var7, var15 * var38 * var8, var15 * var38 * var9);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var24), (double)(var4 + 0), var32 - (double)var37 - (double)var36, var34 - (double)var37 + (double)var36);
                var5.addVertexWithUV((double)(var2 + 0), (double)((float)var3 + var25), (double)(var4 + 1), var32 - (double)var37 + (double)var36, var34 + (double)var37 + (double)var36);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var26), (double)(var4 + 1), var32 + (double)var37 + (double)var36, var34 + (double)var37 - (double)var36);
                var5.addVertexWithUV((double)(var2 + 1), (double)((float)var3 + var27), (double)(var4 + 0), var32 + (double)var37 - (double)var36, var34 - (double)var37 - (double)var36);
            }

            if (this.renderAllFaces || var11) {
                float var52 = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
                var5.setColorOpaque_F(var14 * var52, var14 * var52, var14 * var52);
                this.renderBottomFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTextureFromSide(0));
                var13 = true;
            }

            for(var28 = 0; var28 < 4; ++var28) {
                int var53 = var2;
                var31 = var4;
                if (var28 == 0) {
                    var31 = var4 - 1;
                }

                if (var28 == 1) {
                    ++var31;
                }

                if (var28 == 2) {
                    var53 = var2 - 1;
                }

                if (var28 == 3) {
                    ++var53;
                }

                int var54 = var1.getBlockTextureFromSideAndMetadata(var28 + 2, var23);
                int var33 = (var54 & 15) << 4;
                int var55 = var54 & 240;
                if (this.renderAllFaces || var12[var28]) {
                    float var35;
                    float var39;
                    float var40;
                    if (var28 == 0) {
                        var35 = var24;
                        var36 = var27;
                        var37 = (float)var2;
                        var39 = (float)(var2 + 1);
                        var38 = (float)var4;
                        var40 = (float)var4;
                    } else if (var28 == 1) {
                        var35 = var26;
                        var36 = var25;
                        var37 = (float)(var2 + 1);
                        var39 = (float)var2;
                        var38 = (float)(var4 + 1);
                        var40 = (float)(var4 + 1);
                    } else if (var28 == 2) {
                        var35 = var25;
                        var36 = var24;
                        var37 = (float)var2;
                        var39 = (float)var2;
                        var38 = (float)(var4 + 1);
                        var40 = (float)var4;
                    } else {
                        var35 = var27;
                        var36 = var26;
                        var37 = (float)(var2 + 1);
                        var39 = (float)(var2 + 1);
                        var38 = (float)var4;
                        var40 = (float)(var4 + 1);
                    }

                    var13 = true;
                    double var41 = (double)((float)(var33 + 0) / 256.0F);
                    double var43 = ((double)(var33 + 16) - 0.01D) / 256.0D;
                    double var45 = (double)(((float)var55 + (1.0F - var35) * 16.0F) / 256.0F);
                    double var47 = (double)(((float)var55 + (1.0F - var36) * 16.0F) / 256.0F);
                    double var49 = ((double)(var55 + 16) - 0.01D) / 256.0D;
                    float var51 = var1.getBlockBrightness(this.blockAccess, var53, var3, var31);
                    if (var28 < 2) {
                        var51 *= var16;
                    } else {
                        var51 *= var17;
                    }

                    var5.setColorOpaque_F(var15 * var51 * var7, var15 * var51 * var8, var15 * var51 * var9);
                    var5.addVertexWithUV((double)var37, (double)((float)var3 + var35), (double)var38, var41, var45);
                    var5.addVertexWithUV((double)var39, (double)((float)var3 + var36), (double)var40, var43, var47);
                    var5.addVertexWithUV((double)var39, (double)(var3 + 0), (double)var40, var43, var49);
                    var5.addVertexWithUV((double)var37, (double)(var3 + 0), (double)var38, var41, var49);
                }
            }

            var1.minY = var18;
            var1.maxY = var20;
            return var13;
        }
    }

    private float func_1224_a(int var1, int var2, int var3, Material var4) {
        int var5 = 0;
        float var6 = 0.0F;

        for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = var1 - (var7 & 1);
            int var10 = var3 - (var7 >> 1 & 1);
            if (this.blockAccess.getBlockMaterial(var8, var2 + 1, var10) == var4) {
                return 1.0F;
            }

            Material var11 = this.blockAccess.getBlockMaterial(var8, var2, var10);
            if (var11 != var4) {
                if (!var11.isSolid()) {
                    ++var6;
                    ++var5;
                }
            } else {
                int var12 = this.blockAccess.getBlockMetadata(var8, var2, var10);
                if (var12 >= 8 || var12 == 0) {
                    var6 += BlockFluid.getPercentAir(var12) * 10.0F;
                    var5 += 10;
                }

                var6 += BlockFluid.getPercentAir(var12);
                ++var5;
            }
        }

        return 1.0F - var6 / (float)var5;
    }

    public void renderBlockFallingSand(Block var1, World var2, int var3, int var4, int var5) {
        float var6 = 0.5F;
        float var7 = 1.0F;
        float var8 = 0.8F;
        float var9 = 0.6F;
        Tessellator var10 = Tessellator.instance;
        var10.startDrawingQuads();
        float var11 = var1.getBlockBrightness(var2, var3, var4, var5);
        float var12 = var1.getBlockBrightness(var2, var3, var4 - 1, var5);
        if (var12 < var11) {
            var12 = var11;
        }

        var10.setColorOpaque_F(var6 * var12, var6 * var12, var6 * var12);
        this.renderBottomFace(var1, -0.5D, -0.5D, -0.5D, var1.getBlockTextureFromSide(0));
        var12 = var1.getBlockBrightness(var2, var3, var4 + 1, var5);
        if (var12 < var11) {
            var12 = var11;
        }

        var10.setColorOpaque_F(var7 * var12, var7 * var12, var7 * var12);
        this.renderTopFace(var1, -0.5D, -0.5D, -0.5D, var1.getBlockTextureFromSide(1));
        var12 = var1.getBlockBrightness(var2, var3, var4, var5 - 1);
        if (var12 < var11) {
            var12 = var11;
        }

        var10.setColorOpaque_F(var8 * var12, var8 * var12, var8 * var12);
        this.renderEastFace(var1, -0.5D, -0.5D, -0.5D, var1.getBlockTextureFromSide(2));
        var12 = var1.getBlockBrightness(var2, var3, var4, var5 + 1);
        if (var12 < var11) {
            var12 = var11;
        }

        var10.setColorOpaque_F(var8 * var12, var8 * var12, var8 * var12);
        this.renderWestFace(var1, -0.5D, -0.5D, -0.5D, var1.getBlockTextureFromSide(3));
        var12 = var1.getBlockBrightness(var2, var3 - 1, var4, var5);
        if (var12 < var11) {
            var12 = var11;
        }

        var10.setColorOpaque_F(var9 * var12, var9 * var12, var9 * var12);
        this.renderNorthFace(var1, -0.5D, -0.5D, -0.5D, var1.getBlockTextureFromSide(4));
        var12 = var1.getBlockBrightness(var2, var3 + 1, var4, var5);
        if (var12 < var11) {
            var12 = var11;
        }

        var10.setColorOpaque_F(var9 * var12, var9 * var12, var9 * var12);
        this.renderSouthFace(var1, -0.5D, -0.5D, -0.5D, var1.getBlockTextureFromSide(5));
        var10.draw();
    }

    public boolean renderStandardBlock(Block var1, int var2, int var3, int var4) {
        int var5 = var1.colorMultiplier(this.blockAccess, var2, var3, var4);
        float var6 = (float)(var5 >> 16 & 255) / 255.0F;
        float var7 = (float)(var5 >> 8 & 255) / 255.0F;
        float var8 = (float)(var5 & 255) / 255.0F;
        if (EntityRenderer.anaglyphEnable) {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return Minecraft.isAmbientOcclusionEnabled() ? this.renderStandardBlockWithAmbientOcclusion(var1, var2, var3, var4, var6, var7, var8) : this.renderStandardBlockWithColorMultiplier(var1, var2, var3, var4, var6, var7, var8);
    }

    public boolean renderStandardBlockWithAmbientOcclusion(Block var1, int var2, int var3, int var4, float var5, float var6, float var7) {
        this.enableAO = true;
        boolean var8 = false;
        float var9 = this.lightValueOwn;
        float var10 = this.lightValueOwn;
        float var11 = this.lightValueOwn;
        float var12 = this.lightValueOwn;
        boolean var13 = true;
        boolean var14 = true;
        boolean var15 = true;
        boolean var16 = true;
        boolean var17 = true;
        boolean var18 = true;
        this.lightValueOwn = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        this.aoLightValueXNeg = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
        this.aoLightValueYNeg = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
        this.aoLightValueZNeg = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
        this.aoLightValueXPos = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
        this.aoLightValueYPos = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
        this.aoLightValueZPos = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
        this.field_22338_U = Block.canBlockGrass[this.blockAccess.getBlockId(var2 + 1, var3 + 1, var4)];
        this.field_22359_ac = Block.canBlockGrass[this.blockAccess.getBlockId(var2 + 1, var3 - 1, var4)];
        this.field_22334_Y = Block.canBlockGrass[this.blockAccess.getBlockId(var2 + 1, var3, var4 + 1)];
        this.field_22363_aa = Block.canBlockGrass[this.blockAccess.getBlockId(var2 + 1, var3, var4 - 1)];
        this.field_22337_V = Block.canBlockGrass[this.blockAccess.getBlockId(var2 - 1, var3 + 1, var4)];
        this.field_22357_ad = Block.canBlockGrass[this.blockAccess.getBlockId(var2 - 1, var3 - 1, var4)];
        this.field_22335_X = Block.canBlockGrass[this.blockAccess.getBlockId(var2 - 1, var3, var4 - 1)];
        this.field_22333_Z = Block.canBlockGrass[this.blockAccess.getBlockId(var2 - 1, var3, var4 + 1)];
        this.field_22336_W = Block.canBlockGrass[this.blockAccess.getBlockId(var2, var3 + 1, var4 + 1)];
        this.field_22339_T = Block.canBlockGrass[this.blockAccess.getBlockId(var2, var3 + 1, var4 - 1)];
        this.field_22355_ae = Block.canBlockGrass[this.blockAccess.getBlockId(var2, var3 - 1, var4 + 1)];
        this.field_22361_ab = Block.canBlockGrass[this.blockAccess.getBlockId(var2, var3 - 1, var4 - 1)];
        if (var1.blockIndexInTexture == 3) {
            var18 = false;
            var17 = false;
            var16 = false;
            var15 = false;
            var13 = false;
        }

        if (this.overrideBlockTexture >= 0) {
            var18 = false;
            var17 = false;
            var16 = false;
            var15 = false;
            var13 = false;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3 - 1, var4, 0)) {
            if (this.field_22352_G <= 0) {
                var9 = var10 = var11 = var12 = this.aoLightValueYNeg;
            } else {
                --var3;
                this.field_22376_n = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
                this.field_22374_p = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
                this.field_22373_q = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
                this.field_22371_s = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
                if (!this.field_22361_ab && !this.field_22357_ad) {
                    this.field_22377_m = this.field_22376_n;
                } else {
                    this.field_22377_m = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4 - 1);
                }

                if (!this.field_22355_ae && !this.field_22357_ad) {
                    this.field_22375_o = this.field_22376_n;
                } else {
                    this.field_22375_o = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4 + 1);
                }

                if (!this.field_22361_ab && !this.field_22359_ac) {
                    this.field_22372_r = this.field_22371_s;
                } else {
                    this.field_22372_r = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4 - 1);
                }

                if (!this.field_22355_ae && !this.field_22359_ac) {
                    this.field_22370_t = this.field_22371_s;
                } else {
                    this.field_22370_t = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4 + 1);
                }

                ++var3;
                var9 = (this.field_22375_o + this.field_22376_n + this.field_22373_q + this.aoLightValueYNeg) / 4.0F;
                var12 = (this.field_22373_q + this.aoLightValueYNeg + this.field_22370_t + this.field_22371_s) / 4.0F;
                var11 = (this.aoLightValueYNeg + this.field_22374_p + this.field_22371_s + this.field_22372_r) / 4.0F;
                var10 = (this.field_22376_n + this.field_22377_m + this.aoLightValueYNeg + this.field_22374_p) / 4.0F;
            }

            this.colorRedTopLeft = this.colorRedBottomLeft = this.colorRedBottomRight = this.colorRedTopRight = (var13 ? var5 : 1.0F) * 0.5F;
            this.colorGreenTopLeft = this.colorGreenBottomLeft = this.colorGreenBottomRight = this.colorGreenTopRight = (var13 ? var6 : 1.0F) * 0.5F;
            this.colorBlueTopLeft = this.colorBlueBottomLeft = this.colorBlueBottomRight = this.colorBlueTopRight = (var13 ? var7 : 1.0F) * 0.5F;
            this.colorRedTopLeft *= var9;
            this.colorGreenTopLeft *= var9;
            this.colorBlueTopLeft *= var9;
            this.colorRedBottomLeft *= var10;
            this.colorGreenBottomLeft *= var10;
            this.colorBlueBottomLeft *= var10;
            this.colorRedBottomRight *= var11;
            this.colorGreenBottomRight *= var11;
            this.colorBlueBottomRight *= var11;
            this.colorRedTopRight *= var12;
            this.colorGreenTopRight *= var12;
            this.colorBlueTopRight *= var12;
            this.renderBottomFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 0));
            var8 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3 + 1, var4, 1)) {
            if (this.field_22352_G <= 0) {
                var9 = var10 = var11 = var12 = this.aoLightValueYPos;
            } else {
                ++var3;
                this.field_22368_v = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
                this.field_22364_z = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
                this.field_22366_x = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
                this.field_22362_A = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
                if (!this.field_22339_T && !this.field_22337_V) {
                    this.field_22369_u = this.field_22368_v;
                } else {
                    this.field_22369_u = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4 - 1);
                }

                if (!this.field_22339_T && !this.field_22338_U) {
                    this.field_22365_y = this.field_22364_z;
                } else {
                    this.field_22365_y = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4 - 1);
                }

                if (!this.field_22336_W && !this.field_22337_V) {
                    this.field_22367_w = this.field_22368_v;
                } else {
                    this.field_22367_w = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4 + 1);
                }

                if (!this.field_22336_W && !this.field_22338_U) {
                    this.field_22360_B = this.field_22364_z;
                } else {
                    this.field_22360_B = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4 + 1);
                }

                --var3;
                var12 = (this.field_22367_w + this.field_22368_v + this.field_22362_A + this.aoLightValueYPos) / 4.0F;
                var9 = (this.field_22362_A + this.aoLightValueYPos + this.field_22360_B + this.field_22364_z) / 4.0F;
                var10 = (this.aoLightValueYPos + this.field_22366_x + this.field_22364_z + this.field_22365_y) / 4.0F;
                var11 = (this.field_22368_v + this.field_22369_u + this.aoLightValueYPos + this.field_22366_x) / 4.0F;
            }

            this.colorRedTopLeft = this.colorRedBottomLeft = this.colorRedBottomRight = this.colorRedTopRight = var14 ? var5 : 1.0F;
            this.colorGreenTopLeft = this.colorGreenBottomLeft = this.colorGreenBottomRight = this.colorGreenTopRight = var14 ? var6 : 1.0F;
            this.colorBlueTopLeft = this.colorBlueBottomLeft = this.colorBlueBottomRight = this.colorBlueTopRight = var14 ? var7 : 1.0F;
            this.colorRedTopLeft *= var9;
            this.colorGreenTopLeft *= var9;
            this.colorBlueTopLeft *= var9;
            this.colorRedBottomLeft *= var10;
            this.colorGreenBottomLeft *= var10;
            this.colorBlueBottomLeft *= var10;
            this.colorRedBottomRight *= var11;
            this.colorGreenBottomRight *= var11;
            this.colorBlueBottomRight *= var11;
            this.colorRedTopRight *= var12;
            this.colorGreenTopRight *= var12;
            this.colorBlueTopRight *= var12;
            this.renderTopFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 1));
            var8 = true;
        }

        int var19;
        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 - 1, 2)) {
            if (this.field_22352_G <= 0) {
                var9 = var10 = var11 = var12 = this.aoLightValueZNeg;
            } else {
                --var4;
                this.field_22358_C = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
                this.field_22374_p = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
                this.field_22366_x = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
                this.field_22356_D = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
                if (!this.field_22335_X && !this.field_22361_ab) {
                    this.field_22377_m = this.field_22358_C;
                } else {
                    this.field_22377_m = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3 - 1, var4);
                }

                if (!this.field_22335_X && !this.field_22339_T) {
                    this.field_22369_u = this.field_22358_C;
                } else {
                    this.field_22369_u = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3 + 1, var4);
                }

                if (!this.field_22363_aa && !this.field_22361_ab) {
                    this.field_22372_r = this.field_22356_D;
                } else {
                    this.field_22372_r = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3 - 1, var4);
                }

                if (!this.field_22363_aa && !this.field_22339_T) {
                    this.field_22365_y = this.field_22356_D;
                } else {
                    this.field_22365_y = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3 + 1, var4);
                }

                ++var4;
                var9 = (this.field_22358_C + this.field_22369_u + this.aoLightValueZNeg + this.field_22366_x) / 4.0F;
                var10 = (this.aoLightValueZNeg + this.field_22366_x + this.field_22356_D + this.field_22365_y) / 4.0F;
                var11 = (this.field_22374_p + this.aoLightValueZNeg + this.field_22372_r + this.field_22356_D) / 4.0F;
                var12 = (this.field_22377_m + this.field_22358_C + this.field_22374_p + this.aoLightValueZNeg) / 4.0F;
            }

            this.colorRedTopLeft = this.colorRedBottomLeft = this.colorRedBottomRight = this.colorRedTopRight = (var15 ? var5 : 1.0F) * 0.8F;
            this.colorGreenTopLeft = this.colorGreenBottomLeft = this.colorGreenBottomRight = this.colorGreenTopRight = (var15 ? var6 : 1.0F) * 0.8F;
            this.colorBlueTopLeft = this.colorBlueBottomLeft = this.colorBlueBottomRight = this.colorBlueTopRight = (var15 ? var7 : 1.0F) * 0.8F;
            this.colorRedTopLeft *= var9;
            this.colorGreenTopLeft *= var9;
            this.colorBlueTopLeft *= var9;
            this.colorRedBottomLeft *= var10;
            this.colorGreenBottomLeft *= var10;
            this.colorBlueBottomLeft *= var10;
            this.colorRedBottomRight *= var11;
            this.colorGreenBottomRight *= var11;
            this.colorBlueBottomRight *= var11;
            this.colorRedTopRight *= var12;
            this.colorGreenTopRight *= var12;
            this.colorBlueTopRight *= var12;
            var19 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 2);
            this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, var19);
            if (fancyGrass && var19 == 3 && this.overrideBlockTexture < 0) {
                this.colorRedTopLeft *= var5;
                this.colorRedBottomLeft *= var5;
                this.colorRedBottomRight *= var5;
                this.colorRedTopRight *= var5;
                this.colorGreenTopLeft *= var6;
                this.colorGreenBottomLeft *= var6;
                this.colorGreenBottomRight *= var6;
                this.colorGreenTopRight *= var6;
                this.colorBlueTopLeft *= var7;
                this.colorBlueBottomLeft *= var7;
                this.colorBlueBottomRight *= var7;
                this.colorBlueTopRight *= var7;
                this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var8 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 + 1, 3)) {
            if (this.field_22352_G <= 0) {
                var9 = var10 = var11 = var12 = this.aoLightValueZPos;
            } else {
                ++var4;
                this.field_22354_E = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
                this.field_22353_F = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
                this.field_22373_q = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
                this.field_22362_A = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
                if (!this.field_22333_Z && !this.field_22355_ae) {
                    this.field_22375_o = this.field_22354_E;
                } else {
                    this.field_22375_o = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3 - 1, var4);
                }

                if (!this.field_22333_Z && !this.field_22336_W) {
                    this.field_22367_w = this.field_22354_E;
                } else {
                    this.field_22367_w = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3 + 1, var4);
                }

                if (!this.field_22334_Y && !this.field_22355_ae) {
                    this.field_22370_t = this.field_22353_F;
                } else {
                    this.field_22370_t = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3 - 1, var4);
                }

                if (!this.field_22334_Y && !this.field_22336_W) {
                    this.field_22360_B = this.field_22353_F;
                } else {
                    this.field_22360_B = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3 + 1, var4);
                }

                --var4;
                var9 = (this.field_22354_E + this.field_22367_w + this.aoLightValueZPos + this.field_22362_A) / 4.0F;
                var12 = (this.aoLightValueZPos + this.field_22362_A + this.field_22353_F + this.field_22360_B) / 4.0F;
                var11 = (this.field_22373_q + this.aoLightValueZPos + this.field_22370_t + this.field_22353_F) / 4.0F;
                var10 = (this.field_22375_o + this.field_22354_E + this.field_22373_q + this.aoLightValueZPos) / 4.0F;
            }

            this.colorRedTopLeft = this.colorRedBottomLeft = this.colorRedBottomRight = this.colorRedTopRight = (var16 ? var5 : 1.0F) * 0.8F;
            this.colorGreenTopLeft = this.colorGreenBottomLeft = this.colorGreenBottomRight = this.colorGreenTopRight = (var16 ? var6 : 1.0F) * 0.8F;
            this.colorBlueTopLeft = this.colorBlueBottomLeft = this.colorBlueBottomRight = this.colorBlueTopRight = (var16 ? var7 : 1.0F) * 0.8F;
            this.colorRedTopLeft *= var9;
            this.colorGreenTopLeft *= var9;
            this.colorBlueTopLeft *= var9;
            this.colorRedBottomLeft *= var10;
            this.colorGreenBottomLeft *= var10;
            this.colorBlueBottomLeft *= var10;
            this.colorRedBottomRight *= var11;
            this.colorGreenBottomRight *= var11;
            this.colorBlueBottomRight *= var11;
            this.colorRedTopRight *= var12;
            this.colorGreenTopRight *= var12;
            this.colorBlueTopRight *= var12;
            var19 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 3);
            this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 3));
            if (fancyGrass && var19 == 3 && this.overrideBlockTexture < 0) {
                this.colorRedTopLeft *= var5;
                this.colorRedBottomLeft *= var5;
                this.colorRedBottomRight *= var5;
                this.colorRedTopRight *= var5;
                this.colorGreenTopLeft *= var6;
                this.colorGreenBottomLeft *= var6;
                this.colorGreenBottomRight *= var6;
                this.colorGreenTopRight *= var6;
                this.colorBlueTopLeft *= var7;
                this.colorBlueBottomLeft *= var7;
                this.colorBlueBottomRight *= var7;
                this.colorBlueTopRight *= var7;
                this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var8 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 - 1, var3, var4, 4)) {
            if (this.field_22352_G <= 0) {
                var9 = var10 = var11 = var12 = this.aoLightValueXNeg;
            } else {
                --var2;
                this.field_22376_n = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
                this.field_22358_C = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
                this.field_22354_E = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
                this.field_22368_v = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
                if (!this.field_22335_X && !this.field_22357_ad) {
                    this.field_22377_m = this.field_22358_C;
                } else {
                    this.field_22377_m = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4 - 1);
                }

                if (!this.field_22333_Z && !this.field_22357_ad) {
                    this.field_22375_o = this.field_22354_E;
                } else {
                    this.field_22375_o = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4 + 1);
                }

                if (!this.field_22335_X && !this.field_22337_V) {
                    this.field_22369_u = this.field_22358_C;
                } else {
                    this.field_22369_u = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4 - 1);
                }

                if (!this.field_22333_Z && !this.field_22337_V) {
                    this.field_22367_w = this.field_22354_E;
                } else {
                    this.field_22367_w = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4 + 1);
                }

                ++var2;
                var12 = (this.field_22376_n + this.field_22375_o + this.aoLightValueXNeg + this.field_22354_E) / 4.0F;
                var9 = (this.aoLightValueXNeg + this.field_22354_E + this.field_22368_v + this.field_22367_w) / 4.0F;
                var10 = (this.field_22358_C + this.aoLightValueXNeg + this.field_22369_u + this.field_22368_v) / 4.0F;
                var11 = (this.field_22377_m + this.field_22376_n + this.field_22358_C + this.aoLightValueXNeg) / 4.0F;
            }

            this.colorRedTopLeft = this.colorRedBottomLeft = this.colorRedBottomRight = this.colorRedTopRight = (var17 ? var5 : 1.0F) * 0.6F;
            this.colorGreenTopLeft = this.colorGreenBottomLeft = this.colorGreenBottomRight = this.colorGreenTopRight = (var17 ? var6 : 1.0F) * 0.6F;
            this.colorBlueTopLeft = this.colorBlueBottomLeft = this.colorBlueBottomRight = this.colorBlueTopRight = (var17 ? var7 : 1.0F) * 0.6F;
            this.colorRedTopLeft *= var9;
            this.colorGreenTopLeft *= var9;
            this.colorBlueTopLeft *= var9;
            this.colorRedBottomLeft *= var10;
            this.colorGreenBottomLeft *= var10;
            this.colorBlueBottomLeft *= var10;
            this.colorRedBottomRight *= var11;
            this.colorGreenBottomRight *= var11;
            this.colorBlueBottomRight *= var11;
            this.colorRedTopRight *= var12;
            this.colorGreenTopRight *= var12;
            this.colorBlueTopRight *= var12;
            var19 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 4);
            this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, var19);
            if (fancyGrass && var19 == 3 && this.overrideBlockTexture < 0) {
                this.colorRedTopLeft *= var5;
                this.colorRedBottomLeft *= var5;
                this.colorRedBottomRight *= var5;
                this.colorRedTopRight *= var5;
                this.colorGreenTopLeft *= var6;
                this.colorGreenBottomLeft *= var6;
                this.colorGreenBottomRight *= var6;
                this.colorGreenTopRight *= var6;
                this.colorBlueTopLeft *= var7;
                this.colorBlueBottomLeft *= var7;
                this.colorBlueBottomRight *= var7;
                this.colorBlueTopRight *= var7;
                this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var8 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 + 1, var3, var4, 5)) {
            if (this.field_22352_G <= 0) {
                var9 = var10 = var11 = var12 = this.aoLightValueXPos;
            } else {
                ++var2;
                this.field_22371_s = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
                this.field_22356_D = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
                this.field_22353_F = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
                this.field_22364_z = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
                if (!this.field_22359_ac && !this.field_22363_aa) {
                    this.field_22372_r = this.field_22356_D;
                } else {
                    this.field_22372_r = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4 - 1);
                }

                if (!this.field_22359_ac && !this.field_22334_Y) {
                    this.field_22370_t = this.field_22353_F;
                } else {
                    this.field_22370_t = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4 + 1);
                }

                if (!this.field_22338_U && !this.field_22363_aa) {
                    this.field_22365_y = this.field_22356_D;
                } else {
                    this.field_22365_y = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4 - 1);
                }

                if (!this.field_22338_U && !this.field_22334_Y) {
                    this.field_22360_B = this.field_22353_F;
                } else {
                    this.field_22360_B = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4 + 1);
                }

                --var2;
                var9 = (this.field_22371_s + this.field_22370_t + this.aoLightValueXPos + this.field_22353_F) / 4.0F;
                var12 = (this.aoLightValueXPos + this.field_22353_F + this.field_22364_z + this.field_22360_B) / 4.0F;
                var11 = (this.field_22356_D + this.aoLightValueXPos + this.field_22365_y + this.field_22364_z) / 4.0F;
                var10 = (this.field_22372_r + this.field_22371_s + this.field_22356_D + this.aoLightValueXPos) / 4.0F;
            }

            this.colorRedTopLeft = this.colorRedBottomLeft = this.colorRedBottomRight = this.colorRedTopRight = (var18 ? var5 : 1.0F) * 0.6F;
            this.colorGreenTopLeft = this.colorGreenBottomLeft = this.colorGreenBottomRight = this.colorGreenTopRight = (var18 ? var6 : 1.0F) * 0.6F;
            this.colorBlueTopLeft = this.colorBlueBottomLeft = this.colorBlueBottomRight = this.colorBlueTopRight = (var18 ? var7 : 1.0F) * 0.6F;
            this.colorRedTopLeft *= var9;
            this.colorGreenTopLeft *= var9;
            this.colorBlueTopLeft *= var9;
            this.colorRedBottomLeft *= var10;
            this.colorGreenBottomLeft *= var10;
            this.colorBlueBottomLeft *= var10;
            this.colorRedBottomRight *= var11;
            this.colorGreenBottomRight *= var11;
            this.colorBlueBottomRight *= var11;
            this.colorRedTopRight *= var12;
            this.colorGreenTopRight *= var12;
            this.colorBlueTopRight *= var12;
            var19 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 5);
            this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, var19);
            if (fancyGrass && var19 == 3 && this.overrideBlockTexture < 0) {
                this.colorRedTopLeft *= var5;
                this.colorRedBottomLeft *= var5;
                this.colorRedBottomRight *= var5;
                this.colorRedTopRight *= var5;
                this.colorGreenTopLeft *= var6;
                this.colorGreenBottomLeft *= var6;
                this.colorGreenBottomRight *= var6;
                this.colorGreenTopRight *= var6;
                this.colorBlueTopLeft *= var7;
                this.colorBlueBottomLeft *= var7;
                this.colorBlueBottomRight *= var7;
                this.colorBlueTopRight *= var7;
                this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var8 = true;
        }

        this.enableAO = false;
        return var8;
    }

    public boolean renderStandardBlockWithColorMultiplier(Block var1, int var2, int var3, int var4, float var5, float var6, float var7) {
        this.enableAO = false;
        Tessellator var8 = Tessellator.instance;
        boolean var9 = false;
        float var10 = 0.5F;
        float var11 = 1.0F;
        float var12 = 0.8F;
        float var13 = 0.6F;
        float var14 = var11 * var5;
        float var15 = var11 * var6;
        float var16 = var11 * var7;
        float var17 = var10;
        float var18 = var12;
        float var19 = var13;
        float var20 = var10;
        float var21 = var12;
        float var22 = var13;
        float var23 = var10;
        float var24 = var12;
        float var25 = var13;
        if (var1 != Block.grass) {
            var17 = var10 * var5;
            var18 = var12 * var5;
            var19 = var13 * var5;
            var20 = var10 * var6;
            var21 = var12 * var6;
            var22 = var13 * var6;
            var23 = var10 * var7;
            var24 = var12 * var7;
            var25 = var13 * var7;
        }

        float var26 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        float var27;
        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3 - 1, var4, 0)) {
            var27 = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
            var8.setColorOpaque_F(var17 * var27, var20 * var27, var23 * var27);
            this.renderBottomFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 0));
            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3 + 1, var4, 1)) {
            var27 = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
            if (var1.maxY != 1.0D && !var1.blockMaterial.getIsLiquid()) {
                var27 = var26;
            }

            var8.setColorOpaque_F(var14 * var27, var15 * var27, var16 * var27);
            this.renderTopFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 1));
            var9 = true;
        }

        int var28;
        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 - 1, 2)) {
            var27 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
            if (var1.minZ > 0.0D) {
                var27 = var26;
            }

            var8.setColorOpaque_F(var18 * var27, var21 * var27, var24 * var27);
            var28 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 2);
            this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, var28);
            if (fancyGrass && var28 == 3 && this.overrideBlockTexture < 0) {
                var8.setColorOpaque_F(var18 * var27 * var5, var21 * var27 * var6, var24 * var27 * var7);
                this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 + 1, 3)) {
            var27 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
            if (var1.maxZ < 1.0D) {
                var27 = var26;
            }

            var8.setColorOpaque_F(var18 * var27, var21 * var27, var24 * var27);
            var28 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 3);
            this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, var28);
            if (fancyGrass && var28 == 3 && this.overrideBlockTexture < 0) {
                var8.setColorOpaque_F(var18 * var27 * var5, var21 * var27 * var6, var24 * var27 * var7);
                this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 - 1, var3, var4, 4)) {
            var27 = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
            if (var1.minX > 0.0D) {
                var27 = var26;
            }

            var8.setColorOpaque_F(var19 * var27, var22 * var27, var25 * var27);
            var28 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 4);
            this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, var28);
            if (fancyGrass && var28 == 3 && this.overrideBlockTexture < 0) {
                var8.setColorOpaque_F(var19 * var27 * var5, var22 * var27 * var6, var25 * var27 * var7);
                this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 + 1, var3, var4, 5)) {
            var27 = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
            if (var1.maxX < 1.0D) {
                var27 = var26;
            }

            var8.setColorOpaque_F(var19 * var27, var22 * var27, var25 * var27);
            var28 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 5);
            this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, var28);
            if (fancyGrass && var28 == 3 && this.overrideBlockTexture < 0) {
                var8.setColorOpaque_F(var19 * var27 * var5, var22 * var27 * var6, var25 * var27 * var7);
                this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, 38);
            }

            var9 = true;
        }

        return var9;
    }

    public boolean renderBlockCactus(Block var1, int var2, int var3, int var4) {
        int var5 = var1.colorMultiplier(this.blockAccess, var2, var3, var4);
        float var6 = (float)(var5 >> 16 & 255) / 255.0F;
        float var7 = (float)(var5 >> 8 & 255) / 255.0F;
        float var8 = (float)(var5 & 255) / 255.0F;
        if (EntityRenderer.anaglyphEnable) {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return this.func_1230_b(var1, var2, var3, var4, var6, var7, var8);
    }

    public boolean func_1230_b(Block var1, int var2, int var3, int var4, float var5, float var6, float var7) {
        Tessellator var8 = Tessellator.instance;
        boolean var9 = false;
        float var10 = 0.5F;
        float var11 = 1.0F;
        float var12 = 0.8F;
        float var13 = 0.6F;
        float var14 = var10 * var5;
        float var15 = var11 * var5;
        float var16 = var12 * var5;
        float var17 = var13 * var5;
        float var18 = var10 * var6;
        float var19 = var11 * var6;
        float var20 = var12 * var6;
        float var21 = var13 * var6;
        float var22 = var10 * var7;
        float var23 = var11 * var7;
        float var24 = var12 * var7;
        float var25 = var13 * var7;
        float var26 = 0.0625F;
        float var27 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        float var28;
        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3 - 1, var4, 0)) {
            var28 = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
            var8.setColorOpaque_F(var14 * var28, var18 * var28, var22 * var28);
            this.renderBottomFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 0));
            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3 + 1, var4, 1)) {
            var28 = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
            if (var1.maxY != 1.0D && !var1.blockMaterial.getIsLiquid()) {
                var28 = var27;
            }

            var8.setColorOpaque_F(var15 * var28, var19 * var28, var23 * var28);
            this.renderTopFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 1));
            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 - 1, 2)) {
            var28 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
            if (var1.minZ > 0.0D) {
                var28 = var27;
            }

            var8.setColorOpaque_F(var16 * var28, var20 * var28, var24 * var28);
            var8.setTranslationF(0.0F, 0.0F, var26);
            this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 2));
            var8.setTranslationF(0.0F, 0.0F, -var26);
            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2, var3, var4 + 1, 3)) {
            var28 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
            if (var1.maxZ < 1.0D) {
                var28 = var27;
            }

            var8.setColorOpaque_F(var16 * var28, var20 * var28, var24 * var28);
            var8.setTranslationF(0.0F, 0.0F, -var26);
            this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 3));
            var8.setTranslationF(0.0F, 0.0F, var26);
            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 - 1, var3, var4, 4)) {
            var28 = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
            if (var1.minX > 0.0D) {
                var28 = var27;
            }

            var8.setColorOpaque_F(var17 * var28, var21 * var28, var25 * var28);
            var8.setTranslationF(var26, 0.0F, 0.0F);
            this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 4));
            var8.setTranslationF(-var26, 0.0F, 0.0F);
            var9 = true;
        }

        if (this.renderAllFaces || var1.shouldSideBeRendered(this.blockAccess, var2 + 1, var3, var4, 5)) {
            var28 = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
            if (var1.maxX < 1.0D) {
                var28 = var27;
            }

            var8.setColorOpaque_F(var17 * var28, var21 * var28, var25 * var28);
            var8.setTranslationF(-var26, 0.0F, 0.0F);
            this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 5));
            var8.setTranslationF(var26, 0.0F, 0.0F);
            var9 = true;
        }

        return var9;
    }

    public boolean renderBlockFence(Block var1, int var2, int var3, int var4) {
        boolean var5 = false;
        float var6 = 0.375F;
        float var7 = 0.625F;
        var1.setBlockBounds(var6, 0.0F, var6, var7, 1.0F, var7);
        this.renderStandardBlock(var1, var2, var3, var4);
        var5 = true;
        boolean var8 = false;
        boolean var9 = false;
        if (this.blockAccess.getBlockId(var2 - 1, var3, var4) == var1.blockID || this.blockAccess.getBlockId(var2 + 1, var3, var4) == var1.blockID) {
            var8 = true;
        }

        if (this.blockAccess.getBlockId(var2, var3, var4 - 1) == var1.blockID || this.blockAccess.getBlockId(var2, var3, var4 + 1) == var1.blockID) {
            var9 = true;
        }

        boolean var10 = this.blockAccess.getBlockId(var2 - 1, var3, var4) == var1.blockID;
        boolean var11 = this.blockAccess.getBlockId(var2 + 1, var3, var4) == var1.blockID;
        boolean var12 = this.blockAccess.getBlockId(var2, var3, var4 - 1) == var1.blockID;
        boolean var13 = this.blockAccess.getBlockId(var2, var3, var4 + 1) == var1.blockID;
        if (!var8 && !var9) {
            var8 = true;
        }

        var6 = 0.4375F;
        var7 = 0.5625F;
        float var14 = 0.75F;
        float var15 = 0.9375F;
        float var16 = var10 ? 0.0F : var6;
        float var17 = var11 ? 1.0F : var7;
        float var18 = var12 ? 0.0F : var6;
        float var19 = var13 ? 1.0F : var7;
        if (var8) {
            var1.setBlockBounds(var16, var14, var6, var17, var15, var7);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        }

        if (var9) {
            var1.setBlockBounds(var6, var14, var18, var7, var15, var19);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        }

        var14 = 0.375F;
        var15 = 0.5625F;
        if (var8) {
            var1.setBlockBounds(var16, var14, var6, var17, var15, var7);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        }

        if (var9) {
            var1.setBlockBounds(var6, var14, var18, var7, var15, var19);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        }

        var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return var5;
    }

    public boolean renderBlockStairs(Block var1, int var2, int var3, int var4) {
        boolean var5 = false;
        int var6 = this.blockAccess.getBlockMetadata(var2, var3, var4);
        if (var6 == 0) {
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var1.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        } else if (var6 == 1) {
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var1.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        } else if (var6 == 2) {
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var1.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        } else if (var6 == 3) {
            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var1.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            this.renderStandardBlock(var1, var2, var3, var4);
            var5 = true;
        }

        var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return var5;
    }

    public boolean renderBlockDoor(Block var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.instance;
        BlockDoor var6 = (BlockDoor)var1;
        boolean var7 = false;
        float var8 = 0.5F;
        float var9 = 1.0F;
        float var10 = 0.8F;
        float var11 = 0.6F;
        float var12 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4);
        float var13 = var1.getBlockBrightness(this.blockAccess, var2, var3 - 1, var4);
        if (var6.minY > 0.0D) {
            var13 = var12;
        }

        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var5.setColorOpaque_F(var8 * var13, var8 * var13, var8 * var13);
        this.renderBottomFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 0));
        var7 = true;
        var13 = var1.getBlockBrightness(this.blockAccess, var2, var3 + 1, var4);
        if (var6.maxY < 1.0D) {
            var13 = var12;
        }

        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var5.setColorOpaque_F(var9 * var13, var9 * var13, var9 * var13);
        this.renderTopFace(var1, (double)var2, (double)var3, (double)var4, var1.getBlockTexture(this.blockAccess, var2, var3, var4, 1));
        var7 = true;
        var13 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 - 1);
        if (var6.minZ > 0.0D) {
            var13 = var12;
        }

        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var5.setColorOpaque_F(var10 * var13, var10 * var13, var10 * var13);
        int var14 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 2);
        if (var14 < 0) {
            this.flipTexture = true;
            var14 = -var14;
        }

        this.renderEastFace(var1, (double)var2, (double)var3, (double)var4, var14);
        var7 = true;
        this.flipTexture = false;
        var13 = var1.getBlockBrightness(this.blockAccess, var2, var3, var4 + 1);
        if (var6.maxZ < 1.0D) {
            var13 = var12;
        }

        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var5.setColorOpaque_F(var10 * var13, var10 * var13, var10 * var13);
        var14 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 3);
        if (var14 < 0) {
            this.flipTexture = true;
            var14 = -var14;
        }

        this.renderWestFace(var1, (double)var2, (double)var3, (double)var4, var14);
        var7 = true;
        this.flipTexture = false;
        var13 = var1.getBlockBrightness(this.blockAccess, var2 - 1, var3, var4);
        if (var6.minX > 0.0D) {
            var13 = var12;
        }

        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var5.setColorOpaque_F(var11 * var13, var11 * var13, var11 * var13);
        var14 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 4);
        if (var14 < 0) {
            this.flipTexture = true;
            var14 = -var14;
        }

        this.renderNorthFace(var1, (double)var2, (double)var3, (double)var4, var14);
        var7 = true;
        this.flipTexture = false;
        var13 = var1.getBlockBrightness(this.blockAccess, var2 + 1, var3, var4);
        if (var6.maxX < 1.0D) {
            var13 = var12;
        }

        if (Block.lightValue[var1.blockID] > 0) {
            var13 = 1.0F;
        }

        var5.setColorOpaque_F(var11 * var13, var11 * var13, var11 * var13);
        var14 = var1.getBlockTexture(this.blockAccess, var2, var3, var4, 5);
        if (var14 < 0) {
            this.flipTexture = true;
            var14 = -var14;
        }

        this.renderSouthFace(var1, (double)var2, (double)var3, (double)var4, var14);
        var7 = true;
        this.flipTexture = false;
        return var7;
    }

    public void renderBottomFace(Block var1, double var2, double var4, double var6, int var8) {
        Tessellator var9 = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            var8 = this.overrideBlockTexture;
        }

        int var10 = (var8 & 15) << 4;
        int var11 = var8 & 240;
        double var12 = ((double)var10 + var1.minX * 16.0D) / 256.0D;
        double var14 = ((double)var10 + var1.maxX * 16.0D - 0.01D) / 256.0D;
        double var16 = ((double)var11 + var1.minZ * 16.0D) / 256.0D;
        double var18 = ((double)var11 + var1.maxZ * 16.0D - 0.01D) / 256.0D;
        if (var1.minX < 0.0D || var1.maxX > 1.0D) {
            var12 = (double)(((float)var10 + 0.0F) / 256.0F);
            var14 = (double)(((float)var10 + 15.99F) / 256.0F);
        }

        if (var1.minZ < 0.0D || var1.maxZ > 1.0D) {
            var16 = (double)(((float)var11 + 0.0F) / 256.0F);
            var18 = (double)(((float)var11 + 15.99F) / 256.0F);
        }

        double var20 = var14;
        double var22 = var12;
        double var24 = var16;
        double var26 = var18;
        if (this.field_31082_l == 2) {
            var12 = ((double)var10 + var1.minZ * 16.0D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.maxX * 16.0D) / 256.0D;
            var14 = ((double)var10 + var1.maxZ * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.minX * 16.0D) / 256.0D;
            var24 = var16;
            var26 = var18;
            var20 = var12;
            var22 = var14;
            var16 = var18;
            var18 = var24;
        } else if (this.field_31082_l == 1) {
            var12 = ((double)(var10 + 16) - var1.maxZ * 16.0D) / 256.0D;
            var16 = ((double)var11 + var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.minZ * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.maxX * 16.0D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var12 = var14;
            var14 = var22;
            var24 = var18;
            var26 = var16;
        } else if (this.field_31082_l == 3) {
            var12 = ((double)(var10 + 16) - var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.maxX * 16.0D - 0.01D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.minZ * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.maxZ * 16.0D - 0.01D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var24 = var16;
            var26 = var18;
        }

        double var28 = var2 + var1.minX;
        double var30 = var2 + var1.maxX;
        double var32 = var4 + var1.minY;
        double var34 = var6 + var1.minZ;
        double var36 = var6 + var1.maxZ;
        if (this.enableAO) {
            var9.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            var9.addVertexWithUV(var28, var32, var36, var22, var26);
            var9.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            var9.addVertexWithUV(var28, var32, var34, var12, var16);
            var9.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            var9.addVertexWithUV(var30, var32, var34, var20, var24);
            var9.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            var9.addVertexWithUV(var30, var32, var36, var14, var18);
        } else {
            var9.addVertexWithUV(var28, var32, var36, var22, var26);
            var9.addVertexWithUV(var28, var32, var34, var12, var16);
            var9.addVertexWithUV(var30, var32, var34, var20, var24);
            var9.addVertexWithUV(var30, var32, var36, var14, var18);
        }

    }

    public void renderTopFace(Block var1, double var2, double var4, double var6, int var8) {
        Tessellator var9 = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            var8 = this.overrideBlockTexture;
        }

        int var10 = (var8 & 15) << 4;
        int var11 = var8 & 240;
        double var12 = ((double)var10 + var1.minX * 16.0D) / 256.0D;
        double var14 = ((double)var10 + var1.maxX * 16.0D - 0.01D) / 256.0D;
        double var16 = ((double)var11 + var1.minZ * 16.0D) / 256.0D;
        double var18 = ((double)var11 + var1.maxZ * 16.0D - 0.01D) / 256.0D;
        if (var1.minX < 0.0D || var1.maxX > 1.0D) {
            var12 = (double)(((float)var10 + 0.0F) / 256.0F);
            var14 = (double)(((float)var10 + 15.99F) / 256.0F);
        }

        if (var1.minZ < 0.0D || var1.maxZ > 1.0D) {
            var16 = (double)(((float)var11 + 0.0F) / 256.0F);
            var18 = (double)(((float)var11 + 15.99F) / 256.0F);
        }

        double var20 = var14;
        double var22 = var12;
        double var24 = var16;
        double var26 = var18;
        if (this.field_31083_k == 1) {
            var12 = ((double)var10 + var1.minZ * 16.0D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.maxX * 16.0D) / 256.0D;
            var14 = ((double)var10 + var1.maxZ * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.minX * 16.0D) / 256.0D;
            var24 = var16;
            var26 = var18;
            var20 = var12;
            var22 = var14;
            var16 = var18;
            var18 = var24;
        } else if (this.field_31083_k == 2) {
            var12 = ((double)(var10 + 16) - var1.maxZ * 16.0D) / 256.0D;
            var16 = ((double)var11 + var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.minZ * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.maxX * 16.0D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var12 = var14;
            var14 = var22;
            var24 = var18;
            var26 = var16;
        } else if (this.field_31083_k == 3) {
            var12 = ((double)(var10 + 16) - var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.maxX * 16.0D - 0.01D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.minZ * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.maxZ * 16.0D - 0.01D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var24 = var16;
            var26 = var18;
        }

        double var28 = var2 + var1.minX;
        double var30 = var2 + var1.maxX;
        double var32 = var4 + var1.maxY;
        double var34 = var6 + var1.minZ;
        double var36 = var6 + var1.maxZ;
        if (this.enableAO) {
            var9.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            var9.addVertexWithUV(var30, var32, var36, var14, var18);
            var9.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            var9.addVertexWithUV(var30, var32, var34, var20, var24);
            var9.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            var9.addVertexWithUV(var28, var32, var34, var12, var16);
            var9.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            var9.addVertexWithUV(var28, var32, var36, var22, var26);
        } else {
            var9.addVertexWithUV(var30, var32, var36, var14, var18);
            var9.addVertexWithUV(var30, var32, var34, var20, var24);
            var9.addVertexWithUV(var28, var32, var34, var12, var16);
            var9.addVertexWithUV(var28, var32, var36, var22, var26);
        }

    }

    public void renderEastFace(Block var1, double var2, double var4, double var6, int var8) {
        Tessellator var9 = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            var8 = this.overrideBlockTexture;
        }

        int var10 = (var8 & 15) << 4;
        int var11 = var8 & 240;
        double var12 = ((double)var10 + var1.minX * 16.0D) / 256.0D;
        double var14 = ((double)var10 + var1.maxX * 16.0D - 0.01D) / 256.0D;
        double var16 = ((double)(var11 + 16) - var1.maxY * 16.0D) / 256.0D;
        double var18 = ((double)(var11 + 16) - var1.minY * 16.0D - 0.01D) / 256.0D;
        double var20;
        if (this.flipTexture) {
            var20 = var12;
            var12 = var14;
            var14 = var20;
        }

        if (var1.minX < 0.0D || var1.maxX > 1.0D) {
            var12 = (double)(((float)var10 + 0.0F) / 256.0F);
            var14 = (double)(((float)var10 + 15.99F) / 256.0F);
        }

        if (var1.minY < 0.0D || var1.maxY > 1.0D) {
            var16 = (double)(((float)var11 + 0.0F) / 256.0F);
            var18 = (double)(((float)var11 + 15.99F) / 256.0F);
        }

        var20 = var14;
        double var22 = var12;
        double var24 = var16;
        double var26 = var18;
        if (this.field_31087_g == 2) {
            var12 = ((double)var10 + var1.minY * 16.0D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.minX * 16.0D) / 256.0D;
            var14 = ((double)var10 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.maxX * 16.0D) / 256.0D;
            var24 = var16;
            var26 = var18;
            var20 = var12;
            var22 = var14;
            var16 = var18;
            var18 = var24;
        } else if (this.field_31087_g == 1) {
            var12 = ((double)(var10 + 16) - var1.maxY * 16.0D) / 256.0D;
            var16 = ((double)var11 + var1.maxX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.minY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.minX * 16.0D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var12 = var14;
            var14 = var22;
            var24 = var18;
            var26 = var16;
        } else if (this.field_31087_g == 3) {
            var12 = ((double)(var10 + 16) - var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.maxX * 16.0D - 0.01D) / 256.0D;
            var16 = ((double)var11 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.minY * 16.0D - 0.01D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var24 = var16;
            var26 = var18;
        }

        double var28 = var2 + var1.minX;
        double var30 = var2 + var1.maxX;
        double var32 = var4 + var1.minY;
        double var34 = var4 + var1.maxY;
        double var36 = var6 + var1.minZ;
        if (this.enableAO) {
            var9.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            var9.addVertexWithUV(var28, var34, var36, var20, var24);
            var9.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            var9.addVertexWithUV(var30, var34, var36, var12, var16);
            var9.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            var9.addVertexWithUV(var30, var32, var36, var22, var26);
            var9.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            var9.addVertexWithUV(var28, var32, var36, var14, var18);
        } else {
            var9.addVertexWithUV(var28, var34, var36, var20, var24);
            var9.addVertexWithUV(var30, var34, var36, var12, var16);
            var9.addVertexWithUV(var30, var32, var36, var22, var26);
            var9.addVertexWithUV(var28, var32, var36, var14, var18);
        }

    }

    public void renderWestFace(Block var1, double var2, double var4, double var6, int var8) {
        Tessellator var9 = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            var8 = this.overrideBlockTexture;
        }

        int var10 = (var8 & 15) << 4;
        int var11 = var8 & 240;
        double var12 = ((double)var10 + var1.minX * 16.0D) / 256.0D;
        double var14 = ((double)var10 + var1.maxX * 16.0D - 0.01D) / 256.0D;
        double var16 = ((double)(var11 + 16) - var1.maxY * 16.0D) / 256.0D;
        double var18 = ((double)(var11 + 16) - var1.minY * 16.0D - 0.01D) / 256.0D;
        double var20;
        if (this.flipTexture) {
            var20 = var12;
            var12 = var14;
            var14 = var20;
        }

        if (var1.minX < 0.0D || var1.maxX > 1.0D) {
            var12 = (double)(((float)var10 + 0.0F) / 256.0F);
            var14 = (double)(((float)var10 + 15.99F) / 256.0F);
        }

        if (var1.minY < 0.0D || var1.maxY > 1.0D) {
            var16 = (double)(((float)var11 + 0.0F) / 256.0F);
            var18 = (double)(((float)var11 + 15.99F) / 256.0F);
        }

        var20 = var14;
        double var22 = var12;
        double var24 = var16;
        double var26 = var18;
        if (this.field_31086_h == 1) {
            var12 = ((double)var10 + var1.minY * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.minX * 16.0D) / 256.0D;
            var14 = ((double)var10 + var1.maxY * 16.0D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.maxX * 16.0D) / 256.0D;
            var24 = var16;
            var26 = var18;
            var20 = var12;
            var22 = var14;
            var16 = var18;
            var18 = var24;
        } else if (this.field_31086_h == 2) {
            var12 = ((double)(var10 + 16) - var1.maxY * 16.0D) / 256.0D;
            var16 = ((double)var11 + var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.minY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.maxX * 16.0D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var12 = var14;
            var14 = var22;
            var24 = var18;
            var26 = var16;
        } else if (this.field_31086_h == 3) {
            var12 = ((double)(var10 + 16) - var1.minX * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.maxX * 16.0D - 0.01D) / 256.0D;
            var16 = ((double)var11 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.minY * 16.0D - 0.01D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var24 = var16;
            var26 = var18;
        }

        double var28 = var2 + var1.minX;
        double var30 = var2 + var1.maxX;
        double var32 = var4 + var1.minY;
        double var34 = var4 + var1.maxY;
        double var36 = var6 + var1.maxZ;
        if (this.enableAO) {
            var9.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            var9.addVertexWithUV(var28, var34, var36, var12, var16);
            var9.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            var9.addVertexWithUV(var28, var32, var36, var22, var26);
            var9.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            var9.addVertexWithUV(var30, var32, var36, var14, var18);
            var9.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            var9.addVertexWithUV(var30, var34, var36, var20, var24);
        } else {
            var9.addVertexWithUV(var28, var34, var36, var12, var16);
            var9.addVertexWithUV(var28, var32, var36, var22, var26);
            var9.addVertexWithUV(var30, var32, var36, var14, var18);
            var9.addVertexWithUV(var30, var34, var36, var20, var24);
        }

    }

    public void renderNorthFace(Block var1, double var2, double var4, double var6, int var8) {
        Tessellator var9 = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            var8 = this.overrideBlockTexture;
        }

        int var10 = (var8 & 15) << 4;
        int var11 = var8 & 240;
        double var12 = ((double)var10 + var1.minZ * 16.0D) / 256.0D;
        double var14 = ((double)var10 + var1.maxZ * 16.0D - 0.01D) / 256.0D;
        double var16 = ((double)(var11 + 16) - var1.maxY * 16.0D) / 256.0D;
        double var18 = ((double)(var11 + 16) - var1.minY * 16.0D - 0.01D) / 256.0D;
        double var20;
        if (this.flipTexture) {
            var20 = var12;
            var12 = var14;
            var14 = var20;
        }

        if (var1.minZ < 0.0D || var1.maxZ > 1.0D) {
            var12 = (double)(((float)var10 + 0.0F) / 256.0F);
            var14 = (double)(((float)var10 + 15.99F) / 256.0F);
        }

        if (var1.minY < 0.0D || var1.maxY > 1.0D) {
            var16 = (double)(((float)var11 + 0.0F) / 256.0F);
            var18 = (double)(((float)var11 + 15.99F) / 256.0F);
        }

        var20 = var14;
        double var22 = var12;
        double var24 = var16;
        double var26 = var18;
        if (this.field_31084_j == 1) {
            var12 = ((double)var10 + var1.minY * 16.0D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.maxZ * 16.0D) / 256.0D;
            var14 = ((double)var10 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.minZ * 16.0D) / 256.0D;
            var24 = var16;
            var26 = var18;
            var20 = var12;
            var22 = var14;
            var16 = var18;
            var18 = var24;
        } else if (this.field_31084_j == 2) {
            var12 = ((double)(var10 + 16) - var1.maxY * 16.0D) / 256.0D;
            var16 = ((double)var11 + var1.minZ * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.minY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.maxZ * 16.0D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var12 = var14;
            var14 = var22;
            var24 = var18;
            var26 = var16;
        } else if (this.field_31084_j == 3) {
            var12 = ((double)(var10 + 16) - var1.minZ * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.maxZ * 16.0D - 0.01D) / 256.0D;
            var16 = ((double)var11 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.minY * 16.0D - 0.01D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var24 = var16;
            var26 = var18;
        }

        double var28 = var2 + var1.minX;
        double var30 = var4 + var1.minY;
        double var32 = var4 + var1.maxY;
        double var34 = var6 + var1.minZ;
        double var36 = var6 + var1.maxZ;
        if (this.enableAO) {
            var9.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            var9.addVertexWithUV(var28, var32, var36, var20, var24);
            var9.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            var9.addVertexWithUV(var28, var32, var34, var12, var16);
            var9.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            var9.addVertexWithUV(var28, var30, var34, var22, var26);
            var9.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            var9.addVertexWithUV(var28, var30, var36, var14, var18);
        } else {
            var9.addVertexWithUV(var28, var32, var36, var20, var24);
            var9.addVertexWithUV(var28, var32, var34, var12, var16);
            var9.addVertexWithUV(var28, var30, var34, var22, var26);
            var9.addVertexWithUV(var28, var30, var36, var14, var18);
        }

    }

    public void renderSouthFace(Block var1, double var2, double var4, double var6, int var8) {
        Tessellator var9 = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            var8 = this.overrideBlockTexture;
        }

        int var10 = (var8 & 15) << 4;
        int var11 = var8 & 240;
        double var12 = ((double)var10 + var1.minZ * 16.0D) / 256.0D;
        double var14 = ((double)var10 + var1.maxZ * 16.0D - 0.01D) / 256.0D;
        double var16 = ((double)(var11 + 16) - var1.maxY * 16.0D) / 256.0D;
        double var18 = ((double)(var11 + 16) - var1.minY * 16.0D - 0.01D) / 256.0D;
        double var20;
        if (this.flipTexture) {
            var20 = var12;
            var12 = var14;
            var14 = var20;
        }

        if (var1.minZ < 0.0D || var1.maxZ > 1.0D) {
            var12 = (double)(((float)var10 + 0.0F) / 256.0F);
            var14 = (double)(((float)var10 + 15.99F) / 256.0F);
        }

        if (var1.minY < 0.0D || var1.maxY > 1.0D) {
            var16 = (double)(((float)var11 + 0.0F) / 256.0F);
            var18 = (double)(((float)var11 + 15.99F) / 256.0F);
        }

        var20 = var14;
        double var22 = var12;
        double var24 = var16;
        double var26 = var18;
        if (this.field_31085_i == 2) {
            var12 = ((double)var10 + var1.minY * 16.0D) / 256.0D;
            var16 = ((double)(var11 + 16) - var1.minZ * 16.0D) / 256.0D;
            var14 = ((double)var10 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)(var11 + 16) - var1.maxZ * 16.0D) / 256.0D;
            var24 = var16;
            var26 = var18;
            var20 = var12;
            var22 = var14;
            var16 = var18;
            var18 = var24;
        } else if (this.field_31085_i == 1) {
            var12 = ((double)(var10 + 16) - var1.maxY * 16.0D) / 256.0D;
            var16 = ((double)var11 + var1.maxZ * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.minY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.minZ * 16.0D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var12 = var14;
            var14 = var22;
            var24 = var18;
            var26 = var16;
        } else if (this.field_31085_i == 3) {
            var12 = ((double)(var10 + 16) - var1.minZ * 16.0D) / 256.0D;
            var14 = ((double)(var10 + 16) - var1.maxZ * 16.0D - 0.01D) / 256.0D;
            var16 = ((double)var11 + var1.maxY * 16.0D) / 256.0D;
            var18 = ((double)var11 + var1.minY * 16.0D - 0.01D) / 256.0D;
            var20 = var14;
            var22 = var12;
            var24 = var16;
            var26 = var18;
        }

        double var28 = var2 + var1.maxX;
        double var30 = var4 + var1.minY;
        double var32 = var4 + var1.maxY;
        double var34 = var6 + var1.minZ;
        double var36 = var6 + var1.maxZ;
        if (this.enableAO) {
            var9.setColorOpaque_F(this.colorRedTopLeft, this.colorGreenTopLeft, this.colorBlueTopLeft);
            var9.addVertexWithUV(var28, var30, var36, var22, var26);
            var9.setColorOpaque_F(this.colorRedBottomLeft, this.colorGreenBottomLeft, this.colorBlueBottomLeft);
            var9.addVertexWithUV(var28, var30, var34, var14, var18);
            var9.setColorOpaque_F(this.colorRedBottomRight, this.colorGreenBottomRight, this.colorBlueBottomRight);
            var9.addVertexWithUV(var28, var32, var34, var20, var24);
            var9.setColorOpaque_F(this.colorRedTopRight, this.colorGreenTopRight, this.colorBlueTopRight);
            var9.addVertexWithUV(var28, var32, var36, var12, var16);
        } else {
            var9.addVertexWithUV(var28, var30, var36, var22, var26);
            var9.addVertexWithUV(var28, var30, var34, var14, var18);
            var9.addVertexWithUV(var28, var32, var34, var20, var24);
            var9.addVertexWithUV(var28, var32, var36, var12, var16);
        }

    }

    public void renderBlockOnInventory(Block var1, int var2, float var3) {
        Tessellator var4 = Tessellator.instance;
        int var5;
        float var6;
        float var7;
        if (this.field_31088_b) {
            var5 = var1.getRenderColor(var2);
            var6 = (float)(var5 >> 16 & 255) / 255.0F;
            var7 = (float)(var5 >> 8 & 255) / 255.0F;
            float var8 = (float)(var5 & 255) / 255.0F;
            GL11.glColor4f(var6 * var3, var7 * var3, var8 * var3, 1.0F);
        }

        var5 = var1.getRenderType();
        if (var5 != 0 && var5 != 16) {
            if (var5 == 1) {
                var4.startDrawingQuads();
                var4.setNormal(0.0F, -1.0F, 0.0F);
                this.renderCrossedSquares(var1, var2, -0.5D, -0.5D, -0.5D);
                var4.draw();
            } else if (var5 == 13) {
                var1.setBlockBoundsForItemRender();
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                var6 = 0.0625F;
                var4.startDrawingQuads();
                var4.setNormal(0.0F, -1.0F, 0.0F);
                this.renderBottomFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(0));
                var4.draw();
                var4.startDrawingQuads();
                var4.setNormal(0.0F, 1.0F, 0.0F);
                this.renderTopFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(1));
                var4.draw();
                var4.startDrawingQuads();
                var4.setNormal(0.0F, 0.0F, -1.0F);
                var4.setTranslationF(0.0F, 0.0F, var6);
                this.renderEastFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(2));
                var4.setTranslationF(0.0F, 0.0F, -var6);
                var4.draw();
                var4.startDrawingQuads();
                var4.setNormal(0.0F, 0.0F, 1.0F);
                var4.setTranslationF(0.0F, 0.0F, -var6);
                this.renderWestFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(3));
                var4.setTranslationF(0.0F, 0.0F, var6);
                var4.draw();
                var4.startDrawingQuads();
                var4.setNormal(-1.0F, 0.0F, 0.0F);
                var4.setTranslationF(var6, 0.0F, 0.0F);
                this.renderNorthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(4));
                var4.setTranslationF(-var6, 0.0F, 0.0F);
                var4.draw();
                var4.startDrawingQuads();
                var4.setNormal(1.0F, 0.0F, 0.0F);
                var4.setTranslationF(-var6, 0.0F, 0.0F);
                this.renderSouthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(5));
                var4.setTranslationF(var6, 0.0F, 0.0F);
                var4.draw();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            } else if (var5 == 6) {
                var4.startDrawingQuads();
                var4.setNormal(0.0F, -1.0F, 0.0F);
                this.func_1245_b(var1, var2, -0.5D, -0.5D, -0.5D);
                var4.draw();
            } else if (var5 == 2) {
                var4.startDrawingQuads();
                var4.setNormal(0.0F, -1.0F, 0.0F);
                this.renderTorchAtAngle(var1, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
                var4.draw();
            } else {
                int var9;
                if (var5 == 10) {
                    for(var9 = 0; var9 < 2; ++var9) {
                        if (var9 == 0) {
                            var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                        }

                        if (var9 == 1) {
                            var1.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
                        }

                        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, -1.0F, 0.0F);
                        this.renderBottomFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(0));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, 1.0F, 0.0F);
                        this.renderTopFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(1));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, 0.0F, -1.0F);
                        this.renderEastFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(2));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, 0.0F, 1.0F);
                        this.renderWestFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(3));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(-1.0F, 0.0F, 0.0F);
                        this.renderNorthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(4));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(1.0F, 0.0F, 0.0F);
                        this.renderSouthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(5));
                        var4.draw();
                        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                    }
                } else if (var5 == 11) {
                    for(var9 = 0; var9 < 4; ++var9) {
                        var7 = 0.125F;
                        if (var9 == 0) {
                            var1.setBlockBounds(0.5F - var7, 0.0F, 0.0F, 0.5F + var7, 1.0F, var7 * 2.0F);
                        }

                        if (var9 == 1) {
                            var1.setBlockBounds(0.5F - var7, 0.0F, 1.0F - var7 * 2.0F, 0.5F + var7, 1.0F, 1.0F);
                        }

                        var7 = 0.0625F;
                        if (var9 == 2) {
                            var1.setBlockBounds(0.5F - var7, 1.0F - var7 * 3.0F, -var7 * 2.0F, 0.5F + var7, 1.0F - var7, 1.0F + var7 * 2.0F);
                        }

                        if (var9 == 3) {
                            var1.setBlockBounds(0.5F - var7, 0.5F - var7 * 3.0F, -var7 * 2.0F, 0.5F + var7, 0.5F - var7, 1.0F + var7 * 2.0F);
                        }

                        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, -1.0F, 0.0F);
                        this.renderBottomFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(0));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, 1.0F, 0.0F);
                        this.renderTopFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(1));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, 0.0F, -1.0F);
                        this.renderEastFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(2));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(0.0F, 0.0F, 1.0F);
                        this.renderWestFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(3));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(-1.0F, 0.0F, 0.0F);
                        this.renderNorthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(4));
                        var4.draw();
                        var4.startDrawingQuads();
                        var4.setNormal(1.0F, 0.0F, 0.0F);
                        this.renderSouthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSide(5));
                        var4.draw();
                        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
                    }

                    var1.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
        } else {
            if (var5 == 16) {
                var2 = 1;
            }

            var1.setBlockBoundsForItemRender();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var4.startDrawingQuads();
            var4.setNormal(0.0F, -1.0F, 0.0F);
            this.renderBottomFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(0, var2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(0.0F, 1.0F, 0.0F);
            this.renderTopFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(1, var2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(0.0F, 0.0F, -1.0F);
            this.renderEastFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(2, var2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(0.0F, 0.0F, 1.0F);
            this.renderWestFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(3, var2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(-1.0F, 0.0F, 0.0F);
            this.renderNorthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(4, var2));
            var4.draw();
            var4.startDrawingQuads();
            var4.setNormal(1.0F, 0.0F, 0.0F);
            this.renderSouthFace(var1, 0.0D, 0.0D, 0.0D, var1.getBlockTextureFromSideAndMetadata(5, var2));
            var4.draw();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }

    }

    public static boolean renderItemIn3d(int var0) {
        if (var0 == 0) {
            return true;
        } else if (var0 == 13) {
            return true;
        } else if (var0 == 10) {
            return true;
        } else if (var0 == 11) {
            return true;
        } else {
            return var0 == 16;
        }
    }
}
