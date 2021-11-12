package net.minecraft.src;

public class ItemRecord extends Item {
    public final String field_261_a;

    protected ItemRecord(int var1, String var2) {
        super(var1);
        this.field_261_a = var2;
        this.field_233_aT = 1;
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.func_444_a(var4, var5, var6) == Block.field_619_aZ.field_573_bc && var3.func_446_b(var4, var5, var6) == 0) {
            if (var3.field_792_x) {
                return true;
            } else {
                ((BlockJukeBox)Block.field_619_aZ).func_286_f(var3, var4, var5, var6, this.field_234_aS);
                var3.func_28101_a((EntityPlayer)null, 1005, var4, var5, var6, this.field_234_aS);
                --var1.field_853_a;
                return true;
            }
        } else {
            return false;
        }
    }
}
