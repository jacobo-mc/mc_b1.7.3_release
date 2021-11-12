package net.minecraft.src;

public class ItemDye extends Item {
    public static final String[] field_21023_a = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
    public static final int[] field_31002_bk = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

    public ItemDye(int var1) {
        super(var1);
        this.func_21015_a(true);
        this.func_21013_d(0);
    }

    public int func_27009_a(int var1) {
        return this.field_4018_aZ + var1 % 8 * 16 + var1 / 8;
    }

    public String func_21011_b(ItemStack var1) {
        return super.func_20009_a() + "." + field_21023_a[var1.func_21181_i()];
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var1.func_21181_i() == 15) {
            int var8 = var3.func_600_a(var4, var5, var6);
            if (var8 == Block.field_333_z.field_376_bc) {
                if (!var3.field_1026_y) {
                    ((BlockSapling)Block.field_333_z).func_21028_c(var3, var4, var5, var6, var3.field_1037_n);
                    --var1.field_1615_a;
                }

                return true;
            }

            if (var8 == Block.field_447_aA.field_376_bc) {
                if (!var3.field_1026_y) {
                    ((BlockCrops)Block.field_447_aA).func_21027_c_(var3, var4, var5, var6);
                    --var1.field_1615_a;
                }

                return true;
            }

            if (var8 == Block.field_337_v.field_376_bc) {
                if (!var3.field_1026_y) {
                    --var1.field_1615_a;

                    label53:
                    for(int var9 = 0; var9 < 128; ++var9) {
                        int var10 = var4;
                        int var11 = var5 + 1;
                        int var12 = var6;

                        for(int var13 = 0; var13 < var9 / 16; ++var13) {
                            var10 += field_4015_b.nextInt(3) - 1;
                            var11 += (field_4015_b.nextInt(3) - 1) * field_4015_b.nextInt(3) / 2;
                            var12 += field_4015_b.nextInt(3) - 1;
                            if (var3.func_600_a(var10, var11 - 1, var12) != Block.field_337_v.field_376_bc || var3.func_28100_h(var10, var11, var12)) {
                                continue label53;
                            }
                        }

                        if (var3.func_600_a(var10, var11, var12) == 0) {
                            if (field_4015_b.nextInt(10) != 0) {
                                var3.func_688_b(var10, var11, var12, Block.field_9257_X.field_376_bc, 1);
                            } else if (field_4015_b.nextInt(3) != 0) {
                                var3.func_690_d(var10, var11, var12, Block.field_417_ae.field_376_bc);
                            } else {
                                var3.func_690_d(var10, var11, var12, Block.field_416_af.field_376_bc);
                            }
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public void func_4019_b(ItemStack var1, EntityLiving var2) {
        if (var2 instanceof EntitySheep) {
            EntitySheep var3 = (EntitySheep)var2;
            int var4 = BlockCloth.func_21034_c(var1.func_21181_i());
            if (!var3.func_21072_p() && var3.func_21074_p_() != var4) {
                var3.func_21071_b_(var4);
                --var1.field_1615_a;
            }
        }

    }
}
