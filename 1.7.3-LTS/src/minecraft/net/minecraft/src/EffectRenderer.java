package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {
    protected World worldObj;
    private List[] fxLayers = new List[4];
    private RenderEngine renderer;
    private Random rand = new Random();

    public EffectRenderer(World var1, RenderEngine var2) {
        if (var1 != null) {
            this.worldObj = var1;
        }

        this.renderer = var2;

        for(int var3 = 0; var3 < 4; ++var3) {
            this.fxLayers[var3] = new ArrayList();
        }

    }

    public void addEffect(EntityFX var1) {
        int var2 = var1.getFXLayer();
        if (this.fxLayers[var2].size() >= 4000) {
            this.fxLayers[var2].remove(0);
        }

        this.fxLayers[var2].add(var1);
    }

    public void updateEffects() {
        for(int var1 = 0; var1 < 4; ++var1) {
            for(int var2 = 0; var2 < this.fxLayers[var1].size(); ++var2) {
                EntityFX var3 = (EntityFX)this.fxLayers[var1].get(var2);
                var3.onUpdate();
                if (var3.isDead) {
                    this.fxLayers[var1].remove(var2--);
                }
            }
        }

    }

    public void renderParticles(Entity var1, float var2) {
        float var3 = MathHelper.cos(var1.rotationYaw * 3.1415927F / 180.0F);
        float var4 = MathHelper.sin(var1.rotationYaw * 3.1415927F / 180.0F);
        float var5 = -var4 * MathHelper.sin(var1.rotationPitch * 3.1415927F / 180.0F);
        float var6 = var3 * MathHelper.sin(var1.rotationPitch * 3.1415927F / 180.0F);
        float var7 = MathHelper.cos(var1.rotationPitch * 3.1415927F / 180.0F);
        EntityFX.interpPosX = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var2;
        EntityFX.interpPosY = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var2;
        EntityFX.interpPosZ = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var2;

        for(int var8 = 0; var8 < 3; ++var8) {
            if (this.fxLayers[var8].size() != 0) {
                int var9 = 0;
                if (var8 == 0) {
                    var9 = this.renderer.getTexture("/particles.png");
                }

                if (var8 == 1) {
                    var9 = this.renderer.getTexture("/terrain.png");
                }

                if (var8 == 2) {
                    var9 = this.renderer.getTexture("/gui/items.png");
                }

                GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, var9);
                Tessellator var10 = Tessellator.instance;
                var10.startDrawingQuads();

                for(int var11 = 0; var11 < this.fxLayers[var8].size(); ++var11) {
                    EntityFX var12 = (EntityFX)this.fxLayers[var8].get(var11);
                    var12.renderParticle(var10, var2, var3, var7, var4, var5, var6);
                }

                var10.draw();
            }
        }

    }

    public void renderLitParticles(Entity var1, float var2) {
        byte var3 = 3;
        if (this.fxLayers[var3].size() != 0) {
            Tessellator var4 = Tessellator.instance;

            for(int var5 = 0; var5 < this.fxLayers[var3].size(); ++var5) {
                EntityFX var6 = (EntityFX)this.fxLayers[var3].get(var5);
                var6.renderParticle(var4, var2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
            }

        }
    }

    public void clearEffects(World var1) {
        this.worldObj = var1;

        for(int var2 = 0; var2 < 4; ++var2) {
            this.fxLayers[var2].clear();
        }

    }

    public void addBlockDestroyEffects(int var1, int var2, int var3, int var4, int var5) {
        if (var4 != 0) {
            Block var6 = Block.blocksList[var4];
            byte var7 = 4;

            for(int var8 = 0; var8 < var7; ++var8) {
                for(int var9 = 0; var9 < var7; ++var9) {
                    for(int var10 = 0; var10 < var7; ++var10) {
                        double var11 = (double)var1 + ((double)var8 + 0.5D) / (double)var7;
                        double var13 = (double)var2 + ((double)var9 + 0.5D) / (double)var7;
                        double var15 = (double)var3 + ((double)var10 + 0.5D) / (double)var7;
                        int var17 = this.rand.nextInt(6);
                        this.addEffect((new EntityDiggingFX(this.worldObj, var11, var13, var15, var11 - (double)var1 - 0.5D, var13 - (double)var2 - 0.5D, var15 - (double)var3 - 0.5D, var6, var17, var5)).applyColourMultiplier(var1, var2, var3));
                    }
                }
            }

        }
    }

    public void addBlockHitEffects(int var1, int var2, int var3, int var4) {
        int var5 = this.worldObj.getBlockId(var1, var2, var3);
        if (var5 != 0) {
            Block var6 = Block.blocksList[var5];
            float var7 = 0.1F;
            double var8 = (double)var1 + this.rand.nextDouble() * (var6.maxX - var6.minX - (double)(var7 * 2.0F)) + (double)var7 + var6.minX;
            double var10 = (double)var2 + this.rand.nextDouble() * (var6.maxY - var6.minY - (double)(var7 * 2.0F)) + (double)var7 + var6.minY;
            double var12 = (double)var3 + this.rand.nextDouble() * (var6.maxZ - var6.minZ - (double)(var7 * 2.0F)) + (double)var7 + var6.minZ;
            if (var4 == 0) {
                var10 = (double)var2 + var6.minY - (double)var7;
            }

            if (var4 == 1) {
                var10 = (double)var2 + var6.maxY + (double)var7;
            }

            if (var4 == 2) {
                var12 = (double)var3 + var6.minZ - (double)var7;
            }

            if (var4 == 3) {
                var12 = (double)var3 + var6.maxZ + (double)var7;
            }

            if (var4 == 4) {
                var8 = (double)var1 + var6.minX - (double)var7;
            }

            if (var4 == 5) {
                var8 = (double)var1 + var6.maxX + (double)var7;
            }

            this.addEffect((new EntityDiggingFX(this.worldObj, var8, var10, var12, 0.0D, 0.0D, 0.0D, var6, var4, this.worldObj.getBlockMetadata(var1, var2, var3))).applyColourMultiplier(var1, var2, var3).multiplyVelocity(0.2F).multipleParticleScaleBy(0.6F));
        }
    }

    public String getStatistics() {
        return "" + (this.fxLayers[0].size() + this.fxLayers[1].size() + this.fxLayers[2].size());
    }
}
