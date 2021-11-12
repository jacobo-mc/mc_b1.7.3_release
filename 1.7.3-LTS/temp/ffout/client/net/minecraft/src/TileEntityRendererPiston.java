package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPiston extends TileEntitySpecialRenderer {
    private RenderBlocks field_31071_b;

    public void func_31070_a(TileEntityPiston var1, double var2, double var4, double var6, float var8) {
        Block var9 = Block.field_345_n[var1.func_31016_a()];
        if (var9 != null && var1.func_31008_a(var8) < 1.0F) {
            Tessellator var10 = Tessellator.field_1512_a;
            this.func_6507_a("/terrain.png");
            RenderHelper.func_1159_a();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            if (Minecraft.func_22005_v()) {
                GL11.glShadeModel(7425);
            } else {
                GL11.glShadeModel(7424);
            }

            var10.func_977_b();
            var10.func_984_b((double)((float)var2 - (float)var1.field_823_f + var1.func_31017_b(var8)), (double)((float)var4 - (float)var1.field_822_g + var1.func_31014_c(var8)), (double)((float)var6 - (float)var1.field_821_h + var1.func_31013_d(var8)));
            var10.func_979_a(1, 1, 1);
            if (var9 == Block.field_9269_aa && var1.func_31008_a(var8) < 0.5F) {
                this.field_31071_b.func_31079_a(var9, var1.field_823_f, var1.field_822_g, var1.field_821_h, false);
            } else if (var1.func_31012_k() && !var1.func_31015_b()) {
                Block.field_9269_aa.func_31052_a_(((BlockPistonBase)var9).func_31040_i());
                this.field_31071_b.func_31079_a(Block.field_9269_aa, var1.field_823_f, var1.field_822_g, var1.field_821_h, var1.func_31008_a(var8) < 0.5F);
                Block.field_9269_aa.func_31051_a();
                var10.func_984_b((double)((float)var2 - (float)var1.field_823_f), (double)((float)var4 - (float)var1.field_822_g), (double)((float)var6 - (float)var1.field_821_h));
                this.field_31071_b.func_31078_d(var9, var1.field_823_f, var1.field_822_g, var1.field_821_h);
            } else {
                this.field_31071_b.func_31075_a(var9, var1.field_823_f, var1.field_822_g, var1.field_821_h);
            }

            var10.func_984_b(0.0D, 0.0D, 0.0D);
            var10.func_982_a();
            RenderHelper.func_1158_b();
        }

    }

    public void func_31069_a(World var1) {
        this.field_31071_b = new RenderBlocks(var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_930_a(TileEntity var1, double var2, double var4, double var6, float var8) {
        this.func_31070_a((TileEntityPiston)var1, var2, var4, var6, var8);
    }
}
