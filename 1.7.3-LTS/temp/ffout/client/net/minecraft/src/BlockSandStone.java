package net.minecraft.src;

public class BlockSandStone extends Block {
    public BlockSandStone(int var1) {
        super(var1, 192, Material.field_1334_d);
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb - 16;
        } else {
            return var1 == 0 ? this.field_378_bb + 16 : this.field_378_bb;
        }
    }
}
