package net.minecraft.src;

public class ItemDye extends Item {
    public static final String[] field_21099_a = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
    public static final int[] field_31023_bk = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

    public ItemDye(int var1) {
        super(var1);
        this.func_21091_a(true);
        this.func_21090_d(0);
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var1.func_21125_h() == 15) {
            int var8 = var3.func_444_a(var4, var5, var6);
            if (var8 == Block.field_6047_y.field_573_bc) {
                if (!var3.field_792_x) {
                    ((BlockSapling)Block.field_6047_y).func_21027_b(var3, var4, var5, var6, var3.field_803_m);
                    --var1.field_853_a;
                }

                return true;
            }

            if (var8 == Block.field_644_aA.field_573_bc) {
                if (!var3.field_792_x) {
                    ((BlockCrops)Block.field_644_aA).func_21028_c(var3, var4, var5, var6);
                    --var1.field_853_a;
                }

                return true;
            }

            if (var8 == Block.field_534_v.field_573_bc) {
                if (!var3.field_792_x) {
                    --var1.field_853_a;

                    label53:
                    for(int var9 = 0; var9 < 128; ++var9) {
                        int var10 = var4;
                        int var11 = var5 + 1;
                        int var12 = var6;

                        for(int var13 = 0; var13 < var9 / 16; ++var13) {
                            var10 += field_4154_b.nextInt(3) - 1;
                            var11 += (field_4154_b.nextInt(3) - 1) * field_4154_b.nextInt(3) / 2;
                            var12 += field_4154_b.nextInt(3) - 1;
                            if (var3.func_444_a(var10, var11 - 1, var12) != Block.field_534_v.field_573_bc || var3.func_445_d(var10, var11, var12)) {
                                continue label53;
                            }
                        }

                        if (var3.func_444_a(var10, var11, var12) == 0) {
                            if (field_4154_b.nextInt(10) != 0) {
                                var3.func_507_b(var10, var11, var12, Block.field_9031_X.field_573_bc, 1);
                            } else if (field_4154_b.nextInt(3) != 0) {
                                var3.func_508_d(var10, var11, var12, Block.field_4072_ae.field_573_bc);
                            } else {
                                var3.func_508_d(var10, var11, var12, Block.field_4071_af.field_573_bc);
                            }
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public void func_9202_b(ItemStack var1, EntityLiving var2) {
        if (var2 instanceof EntitySheep) {
            EntitySheep var3 = (EntitySheep)var2;
            int var4 = BlockCloth.func_21033_c(var1.func_21125_h());
            if (!var3.func_21069_f_() && var3.func_21068_e_() != var4) {
                var3.func_21070_a(var4);
                --var1.field_853_a;
            }
        }

    }
}
