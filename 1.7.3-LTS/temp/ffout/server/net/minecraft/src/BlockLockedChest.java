package net.minecraft.src;

import java.util.Random;

public class BlockLockedChest extends Block {
    protected BlockLockedChest(int var1) {
        super(var1, Material.field_524_c);
        this.field_575_bb = 26;
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb - 1;
        } else if (var1 == 0) {
            return this.field_575_bb - 1;
        } else {
            return var1 == 3 ? this.field_575_bb + 1 : this.field_575_bb;
        }
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        var1.func_508_d(var2, var3, var4, 0);
    }
}
