package net.minecraft.src;

public class ItemHoe extends Item {
    public ItemHoe(int var1, EnumToolMaterial var2) {
        super(var1);
        this.field_233_aT = 1;
        this.func_21090_d(var2.func_21180_a());
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        int var8 = var3.func_444_a(var4, var5, var6);
        int var9 = var3.func_444_a(var4, var5 + 1, var6);
        if ((var7 == 0 || var9 != 0 || var8 != Block.field_534_v.field_573_bc) && var8 != Block.field_533_w.field_573_bc) {
            return false;
        } else {
            Block var10 = Block.field_643_aB;
            var3.func_502_a((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var10.field_555_bl.func_737_c(), (var10.field_555_bl.func_738_a() + 1.0F) / 2.0F, var10.field_555_bl.func_739_b() * 0.8F);
            if (var3.field_792_x) {
                return true;
            } else {
                var3.func_508_d(var4, var5, var6, var10.field_573_bc);
                var1.func_25125_a(1, var2);
                return true;
            }
        }
    }
}
