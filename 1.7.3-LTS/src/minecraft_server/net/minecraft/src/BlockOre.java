package net.minecraft.src;

import java.util.Random;

public class BlockOre extends Block {
    public BlockOre(int var1, int var2) {
        super(var1, var2, Material.rock);
    }

    public int idDropped(int var1, Random var2) {
        if (this.blockID == Block.oreCoal.blockID) {
            return Item.coal.shiftedIndex;
        } else if (this.blockID == Block.oreDiamond.blockID) {
            return Item.diamond.shiftedIndex;
        } else {
            return this.blockID == Block.oreLapis.blockID ? Item.dyePowder.shiftedIndex : this.blockID;
        }
    }

    public int quantityDropped(Random var1) {
        return this.blockID == Block.oreLapis.blockID ? 4 + var1.nextInt(5) : 1;
    }

    protected int damageDropped(int var1) {
        return this.blockID == Block.oreLapis.blockID ? 4 : 0;
    }
}
