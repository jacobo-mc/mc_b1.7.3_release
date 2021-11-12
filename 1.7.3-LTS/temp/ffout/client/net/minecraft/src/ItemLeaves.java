package net.minecraft.src;

public class ItemLeaves extends ItemBlock {
    public ItemLeaves(int var1) {
        super(var1);
        this.func_21013_d(0);
        this.func_21015_a(true);
    }

    public int func_21012_a(int var1) {
        return var1 | 8;
    }

    public int func_27009_a(int var1) {
        return Block.field_384_L.func_232_a(0, var1);
    }

    public int func_27010_f(int var1) {
        if ((var1 & 1) == 1) {
            return ColorizerFoliage.func_21175_a();
        } else {
            return (var1 & 2) == 2 ? ColorizerFoliage.func_21174_b() : ColorizerFoliage.func_31073_c();
        }
    }
}
