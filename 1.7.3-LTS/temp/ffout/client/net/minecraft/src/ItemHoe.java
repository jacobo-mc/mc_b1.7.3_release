package net.minecraft.src;

public class ItemHoe extends Item {
    public ItemHoe(int var1, EnumToolMaterial var2) {
        super(var1);
        this.field_290_aT = 1;
        this.func_21013_d(var2.func_21207_a());
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        int var8 = var3.func_600_a(var4, var5, var6);
        int var9 = var3.func_600_a(var4, var5 + 1, var6);
        if ((var7 == 0 || var9 != 0 || var8 != Block.field_337_v.field_376_bc) && var8 != Block.field_336_w.field_376_bc) {
            return false;
        } else {
            Block var10 = Block.field_446_aB;
            var3.func_684_a((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var10.field_358_bl.func_1145_d(), (var10.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var10.field_358_bl.func_1144_c() * 0.8F);
            if (var3.field_1026_y) {
                return true;
            } else {
                var3.func_690_d(var4, var5, var6, var10.field_376_bc);
                var1.func_25190_a(1, var2);
                return true;
            }
        }
    }

    public boolean func_4017_a() {
        return true;
    }
}
