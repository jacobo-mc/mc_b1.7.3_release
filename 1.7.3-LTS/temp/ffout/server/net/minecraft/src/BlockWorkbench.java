package net.minecraft.src;

public class BlockWorkbench extends Block {
    protected BlockWorkbench(int var1) {
        super(var1, Material.field_524_c);
        this.field_575_bb = 59;
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb - 16;
        } else if (var1 == 0) {
            return Block.field_531_y.func_241_a(0);
        } else {
            return var1 != 2 && var1 != 4 ? this.field_575_bb : this.field_575_bb + 1;
        }
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.field_792_x) {
            return true;
        } else {
            var5.func_174_A(var2, var3, var4);
            return true;
        }
    }
}
