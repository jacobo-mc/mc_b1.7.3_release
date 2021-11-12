package net.minecraft.src;

public class BlockWorkbench extends Block {
    protected BlockWorkbench(int var1) {
        super(var1, Material.field_1335_c);
        this.field_378_bb = 59;
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb - 16;
        } else if (var1 == 0) {
            return Block.field_334_y.func_218_a(0);
        } else {
            return var1 != 2 && var1 != 4 ? this.field_378_bb : this.field_378_bb + 1;
        }
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_1026_y) {
            return true;
        } else {
            var5.func_445_l(var2, var3, var4);
            return true;
        }
    }
}
