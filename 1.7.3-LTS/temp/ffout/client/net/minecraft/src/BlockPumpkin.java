package net.minecraft.src;

public class BlockPumpkin extends Block {
    private boolean field_4072_a;

    protected BlockPumpkin(int var1, int var2, boolean var3) {
        super(var1, Material.field_4261_w);
        this.field_378_bb = var2;
        this.func_253_b(true);
        this.field_4072_a = var3;
    }

    public int func_232_a(int var1, int var2) {
        if (var1 == 1) {
            return this.field_378_bb;
        } else if (var1 == 0) {
            return this.field_378_bb;
        } else {
            int var3 = this.field_378_bb + 1 + 16;
            if (this.field_4072_a) {
                ++var3;
            }

            if (var2 == 2 && var1 == 2) {
                return var3;
            } else if (var2 == 3 && var1 == 5) {
                return var3;
            } else if (var2 == 0 && var1 == 3) {
                return var3;
            } else {
                return var2 == 1 && var1 == 4 ? var3 : this.field_378_bb + 16;
            }
        }
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb;
        } else if (var1 == 0) {
            return this.field_378_bb;
        } else {
            return var1 == 3 ? this.field_378_bb + 1 + 16 : this.field_378_bb + 16;
        }
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        super.func_235_e(var1, var2, var3, var4);
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_600_a(var2, var3, var4);
        return (var5 == 0 || Block.field_345_n[var5].field_356_bn.func_27283_g()) && var1.func_28100_h(var2, var3 - 1, var4);
    }

    public void func_4026_a(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.func_1108_b((double)(var5.field_605_aq * 4.0F / 360.0F) + 2.5D) & 3;
        var1.func_691_b(var2, var3, var4, var6);
    }
}
