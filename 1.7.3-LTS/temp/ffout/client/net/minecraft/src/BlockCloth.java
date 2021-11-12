package net.minecraft.src;

public class BlockCloth extends Block {
    public BlockCloth() {
        super(35, 64, Material.field_4264_k);
    }

    public int func_232_a(int var1, int var2) {
        if (var2 == 0) {
            return this.field_378_bb;
        } else {
            var2 = ~(var2 & 15);
            return 113 + ((var2 & 8) >> 3) + (var2 & 7) * 16;
        }
    }

    protected int func_21025_b(int var1) {
        return var1;
    }

    public static int func_21034_c(int var0) {
        return ~var0 & 15;
    }

    public static int func_21035_d(int var0) {
        return ~var0 & 15;
    }
}
