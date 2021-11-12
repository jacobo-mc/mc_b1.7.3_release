package net.minecraft.src;

public class ItemRecord extends Item {
    public final String field_316_a;

    protected ItemRecord(int var1, String var2) {
        super(var1);
        this.field_316_a = var2;
        this.field_290_aT = 1;
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.func_600_a(var4, var5, var6) == Block.field_422_aZ.field_376_bc && var3.func_602_e(var4, var5, var6) == 0) {
            if (var3.field_1026_y) {
                return true;
            } else {
                ((BlockJukeBox)Block.field_422_aZ).func_317_e(var3, var4, var5, var6, this.field_291_aS);
                var3.func_28107_a((EntityPlayer)null, 1005, var4, var5, var6, this.field_291_aS);
                --var1.field_1615_a;
                return true;
            }
        } else {
            return false;
        }
    }
}
