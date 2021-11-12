package net.minecraft.src;

import java.util.Random;

public class BlockStep extends Block {
    public static final String[] field_22027_a = new String[]{"stone", "sand", "wood", "cobble"};
    private boolean field_20910_a;

    public BlockStep(int var1, boolean var2) {
        super(var1, 6, Material.field_523_d);
        this.field_20910_a = var2;
        if (!var2) {
            this.func_229_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        this.func_258_c(255);
    }

    public int func_22009_a(int var1, int var2) {
        if (var2 == 0) {
            return var1 <= 1 ? 6 : 5;
        } else if (var2 == 1) {
            if (var1 == 0) {
                return 208;
            } else {
                return var1 == 1 ? 176 : 192;
            }
        } else if (var2 == 2) {
            return 4;
        } else {
            return var2 == 3 ? 16 : 6;
        }
    }

    public int func_241_a(int var1) {
        return this.func_22009_a(var1, 0);
    }

    public boolean func_240_b() {
        return this.field_20910_a;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        if (this != Block.field_607_al) {
            super.func_250_e(var1, var2, var3, var4);
        }

        int var5 = var1.func_444_a(var2, var3 - 1, var4);
        int var6 = var1.func_446_b(var2, var3, var4);
        int var7 = var1.func_446_b(var2, var3 - 1, var4);
        if (var6 == var7) {
            if (var5 == field_607_al.field_573_bc) {
                var1.func_508_d(var2, var3, var4, 0);
                var1.func_507_b(var2, var3 - 1, var4, Block.field_608_ak.field_573_bc, var6);
            }

        }
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_607_al.field_573_bc;
    }

    public int func_244_a(Random var1) {
        return this.field_20910_a ? 2 : 1;
    }

    protected int func_21025_b(int var1) {
        return var1;
    }

    public boolean func_28025_b() {
        return this.field_20910_a;
    }
}
