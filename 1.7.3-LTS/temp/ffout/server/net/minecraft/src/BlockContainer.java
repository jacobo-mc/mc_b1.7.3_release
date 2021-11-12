package net.minecraft.src;

public abstract class BlockContainer extends Block {
    protected BlockContainer(int var1, Material var2) {
        super(var1, var2);
        field_539_q[var1] = true;
    }

    protected BlockContainer(int var1, int var2, Material var3) {
        super(var1, var2, var3);
        field_539_q[var1] = true;
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        super.func_250_e(var1, var2, var3, var4);
        var1.func_473_a(var2, var3, var4, this.func_294_a_());
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        super.func_242_b(var1, var2, var3, var4);
        var1.func_513_l(var2, var3, var4);
    }

    protected abstract TileEntity func_294_a_();
}
