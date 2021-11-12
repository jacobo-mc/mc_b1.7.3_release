package net.minecraft.src;

public class BlockJukeBox extends BlockContainer {
    protected BlockJukeBox(int var1, int var2) {
        super(var1, var2, Material.field_1335_c);
    }

    public int func_218_a(int var1) {
        return this.field_378_bb + (var1 == 1 ? 1 : 0);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.func_602_e(var2, var3, var4) == 0) {
            return false;
        } else {
            this.func_28038_b_(var1, var2, var3, var4);
            return true;
        }
    }

    public void func_317_e(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.field_1026_y) {
            TileEntityRecordPlayer var6 = (TileEntityRecordPlayer)var1.func_603_b(var2, var3, var4);
            var6.field_28017_a = var5;
            var6.func_474_j_();
            var1.func_691_b(var2, var3, var4, 1);
        }
    }

    public void func_28038_b_(World var1, int var2, int var3, int var4) {
        if (!var1.field_1026_y) {
            TileEntityRecordPlayer var5 = (TileEntityRecordPlayer)var1.func_603_b(var2, var3, var4);
            int var6 = var5.field_28017_a;
            if (var6 != 0) {
                var1.func_28106_e(1005, var2, var3, var4, 0);
                var1.func_670_a((String)null, var2, var3, var4);
                var5.field_28017_a = 0;
                var5.func_474_j_();
                var1.func_691_b(var2, var3, var4, 0);
                float var8 = 0.7F;
                double var9 = (double)(var1.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
                double var11 = (double)(var1.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.2D + 0.6D;
                double var13 = (double)(var1.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
                EntityItem var15 = new EntityItem(var1, (double)var2 + var9, (double)var3 + var11, (double)var4 + var13, new ItemStack(var6, 1, 0));
                var15.field_805_c = 10;
                var1.func_674_a(var15);
            }
        }
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        this.func_28038_b_(var1, var2, var3, var4);
        super.func_214_b(var1, var2, var3, var4);
    }

    public void func_216_a(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.field_1026_y) {
            super.func_216_a(var1, var2, var3, var4, var5, var6);
        }
    }

    protected TileEntity func_283_a_() {
        return new TileEntityRecordPlayer();
    }
}
