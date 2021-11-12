package net.minecraft.src;

import java.util.Random;

public class BlockChest extends BlockContainer {
    private Random field_457_a = new Random();

    protected BlockChest(int var1) {
        super(var1, Material.field_1335_c);
        this.field_378_bb = 26;
    }

    public int func_211_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1) {
            return this.field_378_bb - 1;
        } else if (var5 == 0) {
            return this.field_378_bb - 1;
        } else {
            int var6 = var1.func_600_a(var2, var3, var4 - 1);
            int var7 = var1.func_600_a(var2, var3, var4 + 1);
            int var8 = var1.func_600_a(var2 - 1, var3, var4);
            int var9 = var1.func_600_a(var2 + 1, var3, var4);
            int var10;
            int var11;
            int var12;
            byte var13;
            if (var6 != this.field_376_bc && var7 != this.field_376_bc) {
                if (var8 != this.field_376_bc && var9 != this.field_376_bc) {
                    byte var14 = 3;
                    if (Block.field_343_p[var6] && !Block.field_343_p[var7]) {
                        var14 = 3;
                    }

                    if (Block.field_343_p[var7] && !Block.field_343_p[var6]) {
                        var14 = 2;
                    }

                    if (Block.field_343_p[var8] && !Block.field_343_p[var9]) {
                        var14 = 5;
                    }

                    if (Block.field_343_p[var9] && !Block.field_343_p[var8]) {
                        var14 = 4;
                    }

                    return var5 == var14 ? this.field_378_bb + 1 : this.field_378_bb;
                } else if (var5 != 4 && var5 != 5) {
                    var10 = 0;
                    if (var8 == this.field_376_bc) {
                        var10 = -1;
                    }

                    var11 = var1.func_600_a(var8 == this.field_376_bc ? var2 - 1 : var2 + 1, var3, var4 - 1);
                    var12 = var1.func_600_a(var8 == this.field_376_bc ? var2 - 1 : var2 + 1, var3, var4 + 1);
                    if (var5 == 3) {
                        var10 = -1 - var10;
                    }

                    var13 = 3;
                    if ((Block.field_343_p[var6] || Block.field_343_p[var11]) && !Block.field_343_p[var7] && !Block.field_343_p[var12]) {
                        var13 = 3;
                    }

                    if ((Block.field_343_p[var7] || Block.field_343_p[var12]) && !Block.field_343_p[var6] && !Block.field_343_p[var11]) {
                        var13 = 2;
                    }

                    return (var5 == var13 ? this.field_378_bb + 16 : this.field_378_bb + 32) + var10;
                } else {
                    return this.field_378_bb;
                }
            } else if (var5 != 2 && var5 != 3) {
                var10 = 0;
                if (var6 == this.field_376_bc) {
                    var10 = -1;
                }

                var11 = var1.func_600_a(var2 - 1, var3, var6 == this.field_376_bc ? var4 - 1 : var4 + 1);
                var12 = var1.func_600_a(var2 + 1, var3, var6 == this.field_376_bc ? var4 - 1 : var4 + 1);
                if (var5 == 4) {
                    var10 = -1 - var10;
                }

                var13 = 5;
                if ((Block.field_343_p[var8] || Block.field_343_p[var11]) && !Block.field_343_p[var9] && !Block.field_343_p[var12]) {
                    var13 = 5;
                }

                if ((Block.field_343_p[var9] || Block.field_343_p[var12]) && !Block.field_343_p[var8] && !Block.field_343_p[var11]) {
                    var13 = 4;
                }

                return (var5 == var13 ? this.field_378_bb + 16 : this.field_378_bb + 32) + var10;
            } else {
                return this.field_378_bb;
            }
        }
    }

    public int func_218_a(int var1) {
        if (var1 == 1) {
            return this.field_378_bb - 1;
        } else if (var1 == 0) {
            return this.field_378_bb - 1;
        } else {
            return var1 == 3 ? this.field_378_bb + 1 : this.field_378_bb;
        }
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        int var5 = 0;
        if (var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc) {
            ++var5;
        }

        if (var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc) {
            ++var5;
        }

        if (var1.func_600_a(var2, var3, var4 - 1) == this.field_376_bc) {
            ++var5;
        }

        if (var1.func_600_a(var2, var3, var4 + 1) == this.field_376_bc) {
            ++var5;
        }

        if (var5 > 1) {
            return false;
        } else if (this.func_286_h(var1, var2 - 1, var3, var4)) {
            return false;
        } else if (this.func_286_h(var1, var2 + 1, var3, var4)) {
            return false;
        } else if (this.func_286_h(var1, var2, var3, var4 - 1)) {
            return false;
        } else {
            return !this.func_286_h(var1, var2, var3, var4 + 1);
        }
    }

    private boolean func_286_h(World var1, int var2, int var3, int var4) {
        if (var1.func_600_a(var2, var3, var4) != this.field_376_bc) {
            return false;
        } else if (var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc) {
            return true;
        } else if (var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc) {
            return true;
        } else if (var1.func_600_a(var2, var3, var4 - 1) == this.field_376_bc) {
            return true;
        } else {
            return var1.func_600_a(var2, var3, var4 + 1) == this.field_376_bc;
        }
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        TileEntityChest var5 = (TileEntityChest)var1.func_603_b(var2, var3, var4);

        for(int var6 = 0; var6 < var5.func_469_c(); ++var6) {
            ItemStack var7 = var5.func_468_c(var6);
            if (var7 != null) {
                float var8 = this.field_457_a.nextFloat() * 0.8F + 0.1F;
                float var9 = this.field_457_a.nextFloat() * 0.8F + 0.1F;
                float var10 = this.field_457_a.nextFloat() * 0.8F + 0.1F;

                while(var7.field_1615_a > 0) {
                    int var11 = this.field_457_a.nextInt(21) + 10;
                    if (var11 > var7.field_1615_a) {
                        var11 = var7.field_1615_a;
                    }

                    var7.field_1615_a -= var11;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.field_1617_c, var11, var7.func_21181_i()));
                    float var13 = 0.05F;
                    var12.field_608_an = (double)((float)this.field_457_a.nextGaussian() * var13);
                    var12.field_607_ao = (double)((float)this.field_457_a.nextGaussian() * var13 + 0.2F);
                    var12.field_606_ap = (double)((float)this.field_457_a.nextGaussian() * var13);
                    var1.func_674_a(var12);
                }
            }
        }

        super.func_214_b(var1, var2, var3, var4);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        Object var6 = (TileEntityChest)var1.func_603_b(var2, var3, var4);
        if (var1.func_28100_h(var2, var3 + 1, var4)) {
            return true;
        } else if (var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc && var1.func_28100_h(var2 - 1, var3 + 1, var4)) {
            return true;
        } else if (var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc && var1.func_28100_h(var2 + 1, var3 + 1, var4)) {
            return true;
        } else if (var1.func_600_a(var2, var3, var4 - 1) == this.field_376_bc && var1.func_28100_h(var2, var3 + 1, var4 - 1)) {
            return true;
        } else if (var1.func_600_a(var2, var3, var4 + 1) == this.field_376_bc && var1.func_28100_h(var2, var3 + 1, var4 + 1)) {
            return true;
        } else {
            if (var1.func_600_a(var2 - 1, var3, var4) == this.field_376_bc) {
                var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.func_603_b(var2 - 1, var3, var4), (IInventory)var6);
            }

            if (var1.func_600_a(var2 + 1, var3, var4) == this.field_376_bc) {
                var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.func_603_b(var2 + 1, var3, var4));
            }

            if (var1.func_600_a(var2, var3, var4 - 1) == this.field_376_bc) {
                var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.func_603_b(var2, var3, var4 - 1), (IInventory)var6);
            }

            if (var1.func_600_a(var2, var3, var4 + 1) == this.field_376_bc) {
                var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.func_603_b(var2, var3, var4 + 1));
            }

            if (var1.field_1026_y) {
                return true;
            } else {
                var5.func_452_a((IInventory)var6);
                return true;
            }
        }
    }

    protected TileEntity func_283_a_() {
        return new TileEntityChest();
    }
}
