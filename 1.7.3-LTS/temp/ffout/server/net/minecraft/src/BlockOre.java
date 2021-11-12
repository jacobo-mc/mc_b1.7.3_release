package net.minecraft.src;

import java.util.Random;

public class BlockOre extends Block {
    public BlockOre(int var1, int var2) {
        super(var1, var2, Material.field_523_d);
    }

    public int func_252_a(int var1, Random var2) {
        if (this.field_573_bc == Block.field_583_J.field_573_bc) {
            return Item.field_168_k.field_234_aS;
        } else if (this.field_573_bc == Block.field_588_ax.field_573_bc) {
            return Item.field_167_l.field_234_aS;
        } else {
            return this.field_573_bc == Block.field_9042_N.field_573_bc ? Item.field_21097_aU.field_234_aS : this.field_573_bc;
        }
    }

    public int func_244_a(Random var1) {
        return this.field_573_bc == Block.field_9042_N.field_573_bc ? 4 + var1.nextInt(5) : 1;
    }

    protected int func_21025_b(int var1) {
        return this.field_573_bc == Block.field_9042_N.field_573_bc ? 4 : 0;
    }
}
