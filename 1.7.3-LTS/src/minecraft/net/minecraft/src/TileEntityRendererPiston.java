package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPiston extends TileEntitySpecialRenderer {
    private RenderBlocks field_31071_b;

    public void func_31070_a(TileEntityPiston var1, double var2, double var4, double var6, float var8) {
        Block var9 = Block.blocksList[var1.getStoredBlockID()];
        if (var9 != null && var1.getProgress(var8) < 1.0F) {
            Tessellator var10 = Tessellator.instance;
            this.bindTextureByName("/terrain.png");
            RenderHelper.disableStandardItemLighting();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glDisable(2884 /*GL_CULL_FACE*/);
            if (Minecraft.isAmbientOcclusionEnabled()) {
                GL11.glShadeModel(7425 /*GL_SMOOTH*/);
            } else {
                GL11.glShadeModel(7424 /*GL_FLAT*/);
            }

            var10.startDrawingQuads();
            var10.setTranslationD((double)((float)var2 - (float)var1.xCoord + var1.func_31017_b(var8)), (double)((float)var4 - (float)var1.yCoord + var1.func_31014_c(var8)), (double)((float)var6 - (float)var1.zCoord + var1.func_31013_d(var8)));
            var10.setColorOpaque(1, 1, 1);
            if (var9 == Block.pistonExtension && var1.getProgress(var8) < 0.5F) {
                this.field_31071_b.func_31079_a(var9, var1.xCoord, var1.yCoord, var1.zCoord, false);
            } else if (var1.func_31012_k() && !var1.isExtending()) {
                Block.pistonExtension.setHeadTexture(((BlockPistonBase)var9).getPistonExtensionTexture());
                this.field_31071_b.func_31079_a(Block.pistonExtension, var1.xCoord, var1.yCoord, var1.zCoord, var1.getProgress(var8) < 0.5F);
                Block.pistonExtension.clearHeadTexture();
                var10.setTranslationD((double)((float)var2 - (float)var1.xCoord), (double)((float)var4 - (float)var1.yCoord), (double)((float)var6 - (float)var1.zCoord));
                this.field_31071_b.func_31078_d(var9, var1.xCoord, var1.yCoord, var1.zCoord);
            } else {
                this.field_31071_b.func_31075_a(var9, var1.xCoord, var1.yCoord, var1.zCoord);
            }

            var10.setTranslationD(0.0D, 0.0D, 0.0D);
            var10.draw();
            RenderHelper.enableStandardItemLighting();
        }

    }

    public void func_31069_a(World var1) {
        this.field_31071_b = new RenderBlocks(var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
        this.func_31070_a((TileEntityPiston)var1, var2, var4, var6, var8);
    }
}
