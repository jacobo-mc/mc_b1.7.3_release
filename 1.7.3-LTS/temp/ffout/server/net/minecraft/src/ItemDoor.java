package net.minecraft.src;

public class ItemDoor extends Item {
    private Material field_260_a;

    public ItemDoor(int var1, Material var2) {
        super(var1);
        this.field_260_a = var2;
        this.field_233_aT = 1;
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var7 != 1) {
            return false;
        } else {
            ++var5;
            Block var8;
            if (this.field_260_a == Material.field_524_c) {
                var8 = Block.field_639_aF;
            } else {
                var8 = Block.field_632_aM;
            }

            if (!var8.func_259_a(var3, var4, var5, var6)) {
                return false;
            } else {
                int var9 = MathHelper.func_584_b((double)((var2.field_316_r + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                byte var10 = 0;
                byte var11 = 0;
                if (var9 == 0) {
                    var11 = 1;
                }

                if (var9 == 1) {
                    var10 = -1;
                }

                if (var9 == 2) {
                    var11 = -1;
                }

                if (var9 == 3) {
                    var10 = 1;
                }

                int var12 = (var3.func_445_d(var4 - var10, var5, var6 - var11) ? 1 : 0) + (var3.func_445_d(var4 - var10, var5 + 1, var6 - var11) ? 1 : 0);
                int var13 = (var3.func_445_d(var4 + var10, var5, var6 + var11) ? 1 : 0) + (var3.func_445_d(var4 + var10, var5 + 1, var6 + var11) ? 1 : 0);
                boolean var14 = var3.func_444_a(var4 - var10, var5, var6 - var11) == var8.field_573_bc || var3.func_444_a(var4 - var10, var5 + 1, var6 - var11) == var8.field_573_bc;
                boolean var15 = var3.func_444_a(var4 + var10, var5, var6 + var11) == var8.field_573_bc || var3.func_444_a(var4 + var10, var5 + 1, var6 + var11) == var8.field_573_bc;
                boolean var16 = false;
                if (var14 && !var15) {
                    var16 = true;
                } else if (var13 > var12) {
                    var16 = true;
                }

                if (var16) {
                    var9 = var9 - 1 & 3;
                    var9 += 4;
                }

                var3.field_808_h = true;
                var3.func_507_b(var4, var5, var6, var8.field_573_bc, var9);
                var3.func_507_b(var4, var5 + 1, var6, var8.field_573_bc, var9 + 8);
                var3.field_808_h = false;
                var3.func_449_g(var4, var5, var6, var8.field_573_bc);
                var3.func_449_g(var4, var5 + 1, var6, var8.field_573_bc);
                --var1.field_853_a;
                return true;
            }
        }
    }
}
