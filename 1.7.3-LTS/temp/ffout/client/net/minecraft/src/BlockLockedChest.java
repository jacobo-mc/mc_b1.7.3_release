package net.minecraft.src;

import java.util.Random;

public class BlockLockedChest extends Block {
    protected BlockLockedChest(int var1) {
        super(var1, Material.field_1335_c);
        this.field_378_bb = 26;
    }

    public int func_211_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1) {
            return this.field_378_bb - 1;
        } else if (var5 == 0) {
            return this.field_378_bb - 1;
        } else {
            int var6 = var1.func_600_a(var2, var3, var4 - 1);
            int var7 = var1.func_600_a(var2, var3, var4 + 1);
            int var8 = var1.func_600_a(var2 - 1, var3, var4);
            int var9 = var1.func_600_a(var2 + 1, var3, var4);
            byte var10 = 3;
            if (Block.field_343_p[var6] && !Block.field_343_p[var7]) {
                var10 = 3;
            }

            if (Block.field_343_p[var7] && !Block.field_343_p[var6]) {
                var10 = 2;
            }

            if (Block.field_343_p[var8] && !Block.field_343_p[var9]) {
                var10 = 5;
            }

            if (Block.field_343_p[var9] && !Block.field_343_p[var8]) {
                var10 = 4;
            }

            return var5 == var10 ? this.field_378_bb + 1 : this.field_378_bb;
        }
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb - 1;
        } else if (var1 == 0) {
            return this.field_378_bb - 1;
        } else {
            return var1 == 3 ? this.field_378_bb + 1 : this.field_378_bb;
        }
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        var1.func_690_d(var2, var3, var4, 0);
    }
}
