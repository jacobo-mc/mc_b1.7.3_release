package net.minecraft.src;

public class TexturedQuad {
    public PositionTextureVertex[] vertexPositions;
    public int nVertices;
    private boolean invertNormal;

    public TexturedQuad(PositionTextureVertex[] var1) {
        this.nVertices = 0;
        this.invertNormal = false;
        this.vertexPositions = var1;
        this.nVertices = var1.length;
    }

    public TexturedQuad(PositionTextureVertex[] var1, int var2, int var3, int var4, int var5) {
        this(var1);
        float var6 = 0.0015625F;
        float var7 = 0.003125F;
        var1[0] = var1[0].setTexturePosition((float)var4 / 64.0F - var6, (float)var3 / 32.0F + var7);
        var1[1] = var1[1].setTexturePosition((float)var2 / 64.0F + var6, (float)var3 / 32.0F + var7);
        var1[2] = var1[2].setTexturePosition((float)var2 / 64.0F + var6, (float)var5 / 32.0F - var7);
        var1[3] = var1[3].setTexturePosition((float)var4 / 64.0F - var6, (float)var5 / 32.0F - var7);
    }

    public void flipFace() {
        PositionTextureVertex[] var1 = new PositionTextureVertex[this.vertexPositions.length];

        for(int var2 = 0; var2 < this.vertexPositions.length; ++var2) {
            var1[var2] = this.vertexPositions[this.vertexPositions.length - var2 - 1];
        }

        this.vertexPositions = var1;
    }

    public void draw(Tessellator var1, float var2) {
        Vec3D var3 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[0].vector3D);
        Vec3D var4 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[2].vector3D);
        Vec3D var5 = var4.crossProduct(var3).normalize();
        var1.startDrawingQuads();
        if (this.invertNormal) {
            var1.setNormal(-((float)var5.xCoord), -((float)var5.yCoord), -((float)var5.zCoord));
        } else {
            var1.setNormal((float)var5.xCoord, (float)var5.yCoord, (float)var5.zCoord);
        }

        for(int var6 = 0; var6 < 4; ++var6) {
            PositionTextureVertex var7 = this.vertexPositions[var6];
            var1.addVertexWithUV((double)((float)var7.vector3D.xCoord * var2), (double)((float)var7.vector3D.yCoord * var2), (double)((float)var7.vector3D.zCoord * var2), (double)var7.texturePositionX, (double)var7.texturePositionY);
        }

        var1.draw();
    }
}
