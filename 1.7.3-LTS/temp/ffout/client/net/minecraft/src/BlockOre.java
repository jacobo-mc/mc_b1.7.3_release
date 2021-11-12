package net.minecraft.src;

import java.util.Random;

public class BlockOre extends Block {
    public BlockOre(int var1, int var2) {
        super(var1, var2, Material.field_1334_d);
    }

    public int func_240_a(int var1, Random var2) {
        if (this.field_376_bc == Block.field_386_J.field_376_bc) {
            return Item.field_225_k.field_291_aS;
        } else if (this.field_376_bc == Block.field_391_ax.field_376_bc) {
            return Item.field_224_l.field_291_aS;
        } else {
            return this.field_376_bc == Block.field_9267_N.field_376_bc ? Item.field_21021_aU.field_291_aS : this.field_376_bc;
        }
    }

    public int func_229_a(Random var1) {
        return this.field_376_bc == Block.field_9267_N.field_376_bc ? 4 + var1.nextInt(5) : 1;
    }

    protected int func_21025_b(int var1) {
        return this.field_376_bc == Block.field_9267_N.field_376_bc ? 4 : 0;
    }
}
