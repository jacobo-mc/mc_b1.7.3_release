package net.minecraft.src;

public class BlockPumpkin extends Block {
    private boolean field_4086_a;

    protected BlockPumpkin(int var1, int var2, boolean var3) {
        super(var1, Material.field_4213_w);
        this.field_575_bb = var2;
        this.func_231_a(true);
        this.field_4086_a = var3;
    }

    public int func_22009_a(int var1, int var2) {
        if (var1 == 1) {
            return this.field_575_bb;
        } else if (var1 == 0) {
            return this.field_575_bb;
        } else {
            int var3 = this.field_575_bb + 1 + 16;
            if (this.field_4086_a) {
                ++var3;
            }

            if (var2 == 2 && var1 == 2) {
                return var3;
            } else if (var2 == 3 && var1 == 5) {
                return var3;
            } else if (var2 == 0 && var1 == 3) {
                return var3;
            } else {
                return var2 == 1 && var1 == 4 ? var3 : this.field_575_bb + 16;
            }
        }
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb;
        } else if (var1 == 0) {
            return this.field_575_bb;
        } else {
            return var1 == 3 ? this.field_575_bb + 1 + 16 : this.field_575_bb + 16;
        }
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        super.func_250_e(var1, var2, var3, var4);
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_444_a(var2, var3, var4);
        return (var5 == 0 || Block.field_542_n[var5].field_553_bn.func_27090_g()) && var1.func_445_d(var2, var3 - 1, var4);
    }

    public void func_4027_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.func_584_b((double)(var5.field_316_r * 4.0F / 360.0F) + 2.5D) & 3;
        var1.func_511_b(var2, var3, var4, var6);
    }
}
