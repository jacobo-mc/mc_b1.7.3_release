package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelRenderer {
    private PositionTextureVertex[] field_1401_j;
    private TexturedQuad[] field_1400_k;
    private int field_1399_l;
    private int field_1398_m;
    public float field_1410_a;
    public float field_1409_b;
    public float field_1408_c;
    public float field_1407_d;
    public float field_1406_e;
    public float field_1405_f;
    private boolean field_1397_n = false;
    private int field_1396_o = 0;
    public boolean field_1404_g = false;
    public boolean field_1403_h = true;
    public boolean field_1402_i = false;

    public ModelRenderer(int var1, int var2) {
        this.field_1399_l = var1;
        this.field_1398_m = var2;
    }

    public void func_921_a(float var1, float var2, float var3, int var4, int var5, int var6) {
        this.func_923_a(var1, var2, var3, var4, var5, var6, 0.0F);
    }

    public void func_923_a(float var1, float var2, float var3, int var4, int var5, int var6, float var7) {
        this.field_1401_j = new PositionTextureVertex[8];
        this.field_1400_k = new TexturedQuad[6];
        float var8 = var1 + (float)var4;
        float var9 = var2 + (float)var5;
        float var10 = var3 + (float)var6;
        var1 -= var7;
        var2 -= var7;
        var3 -= var7;
        var8 += var7;
        var9 += var7;
        var10 += var7;
        if (this.field_1404_g) {
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
        this.field_1401_j[0] = var20;
        this.field_1401_j[1] = var12;
        this.field_1401_j[2] = var13;
        this.field_1401_j[3] = var14;
        this.field_1401_j[4] = var15;
        this.field_1401_j[5] = var16;
        this.field_1401_j[6] = var17;
        this.field_1401_j[7] = var18;
        this.field_1400_k[0] = new TexturedQuad(new PositionTextureVertex[]{var16, var12, var13, var17}, this.field_1399_l + var6 + var4, this.field_1398_m + var6, this.field_1399_l + var6 + var4 + var6, this.field_1398_m + var6 + var5);
        this.field_1400_k[1] = new TexturedQuad(new PositionTextureVertex[]{var20, var15, var18, var14}, this.field_1399_l + 0, this.field_1398_m + var6, this.field_1399_l + var6, this.field_1398_m + var6 + var5);
        this.field_1400_k[2] = new TexturedQuad(new PositionTextureVertex[]{var16, var15, var20, var12}, this.field_1399_l + var6, this.field_1398_m + 0, this.field_1399_l + var6 + var4, this.field_1398_m + var6);
        this.field_1400_k[3] = new TexturedQuad(new PositionTextureVertex[]{var13, var14, var18, var17}, this.field_1399_l + var6 + var4, this.field_1398_m + 0, this.field_1399_l + var6 + var4 + var4, this.field_1398_m + var6);
        this.field_1400_k[4] = new TexturedQuad(new PositionTextureVertex[]{var12, var20, var14, var13}, this.field_1399_l + var6, this.field_1398_m + var6, this.field_1399_l + var6 + var4, this.field_1398_m + var6 + var5);
        this.field_1400_k[5] = new TexturedQuad(new PositionTextureVertex[]{var15, var16, var17, var18}, this.field_1399_l + var6 + var4 + var6, this.field_1398_m + var6, this.field_1399_l + var6 + var4 + var6 + var4, this.field_1398_m + var6 + var5);
        if (this.field_1404_g) {
            for(int var19 = 0; var19 < this.field_1400_k.length; ++var19) {
                this.field_1400_k[var19].func_809_a();
            }
        }

    }

    public void func_925_a(float var1, float var2, float var3) {
        this.field_1410_a = var1;
        this.field_1409_b = var2;
        this.field_1408_c = var3;
    }

    public void func_922_a(float var1) {
        if (!this.field_1402_i) {
            if (this.field_1403_h) {
                if (!this.field_1397_n) {
                    this.func_924_c(var1);
                }

                if (this.field_1407_d == 0.0F && this.field_1406_e == 0.0F && this.field_1405_f == 0.0F) {
                    if (this.field_1410_a == 0.0F && this.field_1409_b == 0.0F && this.field_1408_c == 0.0F) {
                        GL11.glCallList(this.field_1396_o);
                    } else {
                        GL11.glTranslatef(this.field_1410_a * var1, this.field_1409_b * var1, this.field_1408_c * var1);
                        GL11.glCallList(this.field_1396_o);
                        GL11.glTranslatef(-this.field_1410_a * var1, -this.field_1409_b * var1, -this.field_1408_c * var1);
                    }
                } else {
                    GL11.glPushMatrix();
                    GL11.glTranslatef(this.field_1410_a * var1, this.field_1409_b * var1, this.field_1408_c * var1);
                    if (this.field_1405_f != 0.0F) {
                        GL11.glRotatef(this.field_1405_f * 57.295776F, 0.0F, 0.0F, 1.0F);
                    }

                    if (this.field_1406_e != 0.0F) {
                        GL11.glRotatef(this.field_1406_e * 57.295776F, 0.0F, 1.0F, 0.0F);
                    }

                    if (this.field_1407_d != 0.0F) {
                        GL11.glRotatef(this.field_1407_d * 57.295776F, 1.0F, 0.0F, 0.0F);
                    }

                    GL11.glCallList(this.field_1396_o);
                    GL11.glPopMatrix();
                }

            }
        }
    }

    public void func_25122_b(float var1) {
        if (!this.field_1402_i) {
            if (this.field_1403_h) {
                if (!this.field_1397_n) {
                    this.func_924_c(var1);
                }

                GL11.glPushMatrix();
                GL11.glTranslatef(this.field_1410_a * var1, this.field_1409_b * var1, this.field_1408_c * var1);
                if (this.field_1406_e != 0.0F) {
                    GL11.glRotatef(this.field_1406_e * 57.295776F, 0.0F, 1.0F, 0.0F);
                }

                if (this.field_1407_d != 0.0F) {
                    GL11.glRotatef(this.field_1407_d * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                if (this.field_1405_f != 0.0F) {
                    GL11.glRotatef(this.field_1405_f * 57.295776F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glCallList(this.field_1396_o);
                GL11.glPopMatrix();
            }
        }
    }

    public void func_926_b(float var1) {
        if (!this.field_1402_i) {
            if (this.field_1403_h) {
                if (!this.field_1397_n) {
                    this.func_924_c(var1);
                }

                if (this.field_1407_d == 0.0F && this.field_1406_e == 0.0F && this.field_1405_f == 0.0F) {
                    if (this.field_1410_a != 0.0F || this.field_1409_b != 0.0F || this.field_1408_c != 0.0F) {
                        GL11.glTranslatef(this.field_1410_a * var1, this.field_1409_b * var1, this.field_1408_c * var1);
                    }
                } else {
                    GL11.glTranslatef(this.field_1410_a * var1, this.field_1409_b * var1, this.field_1408_c * var1);
                    if (this.field_1405_f != 0.0F) {
                        GL11.glRotatef(this.field_1405_f * 57.295776F, 0.0F, 0.0F, 1.0F);
                    }

                    if (this.field_1406_e != 0.0F) {
                        GL11.glRotatef(this.field_1406_e * 57.295776F, 0.0F, 1.0F, 0.0F);
                    }

                    if (this.field_1407_d != 0.0F) {
                        GL11.glRotatef(this.field_1407_d * 57.295776F, 1.0F, 0.0F, 0.0F);
                    }
                }

            }
        }
    }

    private void func_924_c(float var1) {
        this.field_1396_o = GLAllocation.func_1124_a(1);
        GL11.glNewList(this.field_1396_o, 4864);
        Tessellator var2 = Tessellator.field_1512_a;

        for(int var3 = 0; var3 < this.field_1400_k.length; ++var3) {
            this.field_1400_k[var3].func_808_a(var2, var1);
        }

        GL11.glEndList();
        this.field_1397_n = true;
    }
}
