package net.minecraft.src;

public class ChunkCache implements IBlockAccess {
    private int field_823_a;
    private int field_822_b;
    private Chunk[][] field_825_c;
    private World field_824_d;

    public ChunkCache(World var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.field_824_d = var1;
        this.field_823_a = var2 >> 4;
        this.field_822_b = var4 >> 4;
        int var8 = var5 >> 4;
        int var9 = var7 >> 4;
        this.field_825_c = new Chunk[var8 - this.field_823_a + 1][var9 - this.field_822_b + 1];

        for(int var10 = this.field_823_a; var10 <= var8; ++var10) {
            for(int var11 = this.field_822_b; var11 <= var9; ++var11) {
                this.field_825_c[var10 - this.field_823_a][var11 - this.field_822_b] = var1.func_525_b(var10, var11);
            }
        }

    }

    public int func_444_a(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else if (var2 >= 128) {
            return 0;
        } else {
            int var4 = (var1 >> 4) - this.field_823_a;
            int var5 = (var3 >> 4) - this.field_822_b;
            if (var4 >= 0 && var4 < this.field_825_c.length && var5 >= 0 && var5 < this.field_825_c[var4].length) {
                Chunk var6 = this.field_825_c[var4][var5];
                return var6 == null ? 0 : var6.func_344_a(var1 & 15, var2, var3 & 15);
            } else {
                return 0;
            }
        }
    }

    public TileEntity func_451_k(int var1, int var2, int var3) {
        int var4 = (var1 >> 4) - this.field_823_a;
        int var5 = (var3 >> 4) - this.field_822_b;
        return this.field_825_c[var4][var5].func_338_d(var1 & 15, var2, var3 & 15);
    }

    public int func_446_b(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else if (var2 >= 128) {
            return 0;
        } else {
            int var4 = (var1 >> 4) - this.field_823_a;
            int var5 = (var3 >> 4) - this.field_822_b;
            return this.field_825_c[var4][var5].func_356_b(var1 & 15, var2, var3 & 15);
        }
    }

    public Material func_443_c(int var1, int var2, int var3) {
        int var4 = this.func_444_a(var1, var2, var3);
        return var4 == 0 ? Material.field_526_a : Block.field_542_n[var4].field_553_bn;
    }

    public boolean func_445_d(int var1, int var2, int var3) {
        Block var4 = Block.field_542_n[this.func_444_a(var1, var2, var3)];
        if (var4 == null) {
            return false;
        } else {
            return var4.field_553_bn.func_218_c() && var4.func_28025_b();
        }
    }
}
