package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelRenderer {
    private PositionTextureVertex[] corners;
    private TexturedQuad[] faces;
    private int textureOffsetX;
    private int textureOffsetY;
    public float rotationPointX;
    public float rotationPointY;
    public float rotationPointZ;
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    private boolean compiled = false;
    private int displayList = 0;
    public boolean mirror = false;
    public boolean showModel = true;
    public boolean isHidden = false;

    public ModelRenderer(int var1, int var2) {
        this.textureOffsetX = var1;
        this.textureOffsetY = var2;
    }

    public void addBox(float var1, float var2, float var3, int var4, int var5, int var6) {
        this.addBox(var1, var2, var3, var4, var5, var6, 0.0F);
    }

    public void addBox(float var1, float var2, float var3, int var4, int var5, int var6, float var7) {
        this.corners = new PositionTextureVertex[8];
        this.faces = new TexturedQuad[6];
        float var8 = var1 + (float)var4;
        float var9 = var2 + (float)var5;
        float var10 = var3 + (float)var6;
        var1 -= var7;
        var2 -= var7;
        var3 -= var7;
        var8 += var7;
        var9 += var7;
        var10 += var7;
        if (this.mirror) {
            float var11 = var8;
            var8 = var1;
            var1 = var11;
        }

        PositionTextureVertex var20 = new PositionTextureVertex(var1, var2, var3, 0.0F, 0.0F);
        PositionTextureVertex var12 = new PositionTextureVertex(var8, var2, var3, 0.0F, 8.0F);
        PositionTextureVertex var13 = new PositionTextureVertex(var8, var9, var3, 8.0F, 8.0F);
        PositionTextureVertex var14 = new PositionTextureVertex(var1, var9, var3, 8.0F, 0.0F);
        PositionTextureVertex var15 = new PositionTextureVertex(var1, var2, var10, 0.0F, 0.0F);
        PositionTextureVertex var16 = new PositionTextureVertex(var8, var2, var10, 0.0F, 8.0F);
        PositionTextureVertex var17 = new PositionTextureVertex(var8, var9, var10, 8.0F, 8.0F);
        PositionTextureVertex var18 = new PositionTextureVertex(var1, var9, var10, 8.0F, 0.0F);
        this.corners[0] = var20;
        this.corners[1] = var12;
        this.corners[2] = var13;
        this.corners[3] = var14;
        this.corners[4] = var15;
        this.corners[5] = var16;
        this.corners[6] = var17;
        this.corners[7] = var18;
        this.faces[0] = new TexturedQuad(new PositionTextureVertex[]{var16, var12, var13, var17}, this.textureOffsetX + var6 + var4, this.textureOffsetY + var6, this.textureOffsetX + var6 + var4 + var6, this.textureOffsetY + var6 + var5);
        this.faces[1] = new TexturedQuad(new PositionTextureVertex[]{var20, var15, var18, var14}, this.textureOffsetX + 0, this.textureOffsetY + var6, this.textureOffsetX + var6, this.textureOffsetY + var6 + var5);
        this.faces[2] = new TexturedQuad(new PositionTextureVertex[]{var16, var15, var20, var12}, this.textureOffsetX + var6, this.textureOffsetY + 0, this.textureOffsetX + var6 + var4, this.textureOffsetY + var6);
        this.faces[3] = new TexturedQuad(new PositionTextureVertex[]{var13, var14, var18, var17}, this.textureOffsetX + var6 + var4, this.textureOffsetY + 0, this.textureOffsetX + var6 + var4 + var4, this.textureOffsetY + var6);
        this.faces[4] = new TexturedQuad(new PositionTextureVertex[]{var12, var20, var14, var13}, this.textureOffsetX + var6, this.textureOffsetY + var6, this.textureOffsetX + var6 + var4, this.textureOffsetY + var6 + var5);
        this.faces[5] = new TexturedQuad(new PositionTextureVertex[]{var15, var16, var17, var18}, this.textureOffsetX + var6 + var4 + var6, this.textureOffsetY + var6, this.textureOffsetX + var6 + var4 + var6 + var4, this.textureOffsetY + var6 + var5);
        if (this.mirror) {
            for(int var19 = 0; var19 < this.faces.length; ++var19) {
                this.faces[var19].flipFace();
            }
        }

    }

    public void setRotationPoint(float var1, float var2, float var3) {
        this.rotationPointX = var1;
        this.rotationPointY = var2;
        this.rotationPointZ = var3;
    }

    public void render(float var1) {
        if (!this.isHidden) {
            if (this.showModel) {
                if (!this.compiled) {
                    this.compileDisplayList(var1);
                }

                if (this.rotateAngleX == 0.0F && this.rotateAngleY == 0.0F && this.rotateAngleZ == 0.0F) {
                    if (this.rotationPointX == 0.0F && this.rotationPointY == 0.0F && this.rotationPointZ == 0.0F) {
                        GL11.glCallList(this.displayList);
                    } else {
                        GL11.glTranslatef(this.rotationPointX * var1, this.rotationPointY * var1, this.rotationPointZ * var1);
                        GL11.glCallList(this.displayList);
                        GL11.glTranslatef(-this.rotationPointX * var1, -this.rotationPointY * var1, -this.rotationPointZ * var1);
                    }
                } else {
                    GL11.glPushMatrix();
                    GL11.glTranslatef(this.rotationPointX * var1, this.rotationPointY * var1, this.rotationPointZ * var1);
                    if (this.rotateAngleZ != 0.0F) {
                        GL11.glRotatef(this.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
                    }

                    if (this.rotateAngleY != 0.0F) {
                        GL11.glRotatef(this.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
                    }

                    if (this.rotateAngleX != 0.0F) {
                        GL11.glRotatef(this.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
                    }

                    GL11.glCallList(this.displayList);
                    GL11.glPopMatrix();
                }

            }
        }
    }

    public void renderWithRotation(float var1) {
        if (!this.isHidden) {
            if (this.showModel) {
                if (!this.compiled) {
                    this.compileDisplayList(var1);
                }

                GL11.glPushMatrix();
                GL11.glTranslatef(this.rotationPointX * var1, this.rotationPointY * var1, this.rotationPointZ * var1);
                if (this.rotateAngleY != 0.0F) {
                    GL11.glRotatef(this.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
                }

                if (this.rotateAngleX != 0.0F) {
                    GL11.glRotatef(this.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                if (this.rotateAngleZ != 0.0F) {
                    GL11.glRotatef(this.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glCallList(this.displayList);
                GL11.glPopMatrix();
            }
        }
    }

    public void postRender(float var1) {
        if (!this.isHidden) {
            if (this.showModel) {
                if (!this.compiled) {
                    this.compileDisplayList(var1);
                }

                if (this.rotateAngleX == 0.0F && this.rotateAngleY == 0.0F && this.rotateAngleZ == 0.0F) {
                    if (this.rotationPointX != 0.0F || this.rotationPointY != 0.0F || this.rotationPointZ != 0.0F) {
                        GL11.glTranslatef(this.rotationPointX * var1, this.rotationPointY * var1, this.rotationPointZ * var1);
                    }
                } else {
                    GL11.glTranslatef(this.rotationPointX * var1, this.rotationPointY * var1, this.rotationPointZ * var1);
                    if (this.rotateAngleZ != 0.0F) {
                        GL11.glRotatef(this.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
                    }

                    if (this.rotateAngleY != 0.0F) {
                        GL11.glRotatef(this.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
                    }

                    if (this.rotateAngleX != 0.0F) {
                        GL11.glRotatef(this.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
                    }
                }

            }
        }
    }

    private void compileDisplayList(float var1) {
        this.displayList = GLAllocation.generateDisplayLists(1);
        GL11.glNewList(this.displayList, 4864 /*GL_COMPILE*/);
        Tessellator var2 = Tessellator.instance;

        for(int var3 = 0; var3 < this.faces.length; ++var3) {
            this.faces[var3].draw(var2, var1);
        }

        GL11.glEndList();
        this.compiled = true;
    }
}
