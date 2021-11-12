package net.minecraft.src;

import java.util.Random;

public class BlockChest extends BlockContainer {
    private Random field_656_a = new Random();

    protected BlockChest(int var1) {
        super(var1, Material.field_524_c);
        this.field_575_bb = 26;
    }

    public int func_241_a(int var1) {
        if (var1 == 1) {
            return this.field_575_bb - 1;
        } else if (var1 == 0) {
            return this.field_575_bb - 1;
        } else {
            return var1 == 3 ? this.field_575_bb + 1 : this.field_575_bb;
        }
    }

    public boolean func_259_a(World var1, int var2, int var3, int var4) {
        int var5 = 0;
        if (var1.func_444_a(var2 - 1, var3, var4) == this.field_573_bc) {
            ++var5;
        }

        if (var1.func_444_a(var2 + 1, var3, var4) == this.field_573_bc) {
            ++var5;
        }

        if (var1.func_444_a(var2, var3, var4 - 1) == this.field_573_bc) {
            ++var5;
        }

        if (var1.func_444_a(var2, var3, var4 + 1) == this.field_573_bc) {
            ++var5;
        }

        if (var5 > 1) {
            return false;
        } else if (this.func_297_g(var1, var2 - 1, var3, var4)) {
            return false;
        } else if (this.func_297_g(var1, var2 + 1, var3, var4)) {
            return false;
        } else if (this.func_297_g(var1, var2, var3, var4 - 1)) {
            return false;
        } else {
            return !this.func_297_g(var1, var2, var3, var4 + 1);
        }
    }

    private boolean func_297_g(World var1, int var2, int var3, int var4) {
        if (var1.func_444_a(var2, var3, var4) != this.field_573_bc) {
            return false;
        } else if (var1.func_444_a(var2 - 1, var3, var4) == this.field_573_bc) {
            return true;
        } else if (var1.func_444_a(var2 + 1, var3, var4) == this.field_573_bc) {
            return true;
        } else if (var1.func_444_a(var2, var3, var4 - 1) == this.field_573_bc) {
            return true;
        } else {
            return var1.func_444_a(var2, var3, var4 + 1) == this.field_573_bc;
        }
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        TileEntityChest var5 = (TileEntityChest)var1.func_451_k(var2, var3, var4);

        for(int var6 = 0; var6 < var5.func_83_a(); ++var6) {
            ItemStack var7 = var5.func_82_a(var6);
            if (var7 != null) {
                float var8 = this.field_656_a.nextFloat() * 0.8F + 0.1F;
                float var9 = this.field_656_a.nextFloat() * 0.8F + 0.1F;
                float var10 = this.field_656_a.nextFloat() * 0.8F + 0.1F;

                while(var7.field_853_a > 0) {
                    int var11 = this.field_656_a.nextInt(21) + 10;
                    if (var11 > var7.field_853_a) {
                        var11 = var7.field_853_a;
                    }

                    var7.field_853_a -= var11;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.field_855_c, var11, var7.func_21125_h()));
                    float var13 = 0.05F;
                    var12.field_319_o = (double)((float)this.field_656_a.nextGaussian() * var13);
                    var12.field_318_p = (double)((float)this.field_656_a.nextGaussian() * var13 + 0.2F);
                    var12.field_317_q = (double)((float)this.field_656_a.nextGaussian() * var13);
                    var1.func_526_a(var12);
                }
            }
        }

        super.func_242_b(var1, var2, var3, var4);
    }

    public boolean func_246_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        Object var6 = (TileEntityChest)var1.func_451_k(var2, var3, var4);
        if (var1.func_445_d(var2, var3 + 1, var4)) {
            return true;
        } else if (var1.func_444_a(var2 - 1, var3, var4) == this.field_573_bc && var1.func_445_d(var2 - 1, var3 + 1, var4)) {
            return true;
        } else if (var1.func_444_a(var2 + 1, var3, var4) == this.field_573_bc && var1.func_445_d(var2 + 1, var3 + 1, var4)) {
            return true;
        } else if (var1.func_444_a(var2, var3, var4 - 1) == this.field_573_bc && var1.func_445_d(var2, var3 + 1, var4 - 1)) {
            return true;
        } else if (var1.func_444_a(var2, var3, var4 + 1) == this.field_573_bc && var1.func_445_d(var2, var3 + 1, var4 + 1)) {
            return true;
        } else {
            if (var1.func_444_a(var2 - 1, var3, var4) == this.field_573_bc) {
                var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.func_451_k(var2 - 1, var3, var4), (IInventory)var6);
            }

            if (var1.func_444_a(var2 + 1, var3, var4) == this.field_573_bc) {
                var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.func_451_k(var2 + 1, var3, var4));
            }

            if (var1.func_444_a(var2, var3, var4 - 1) == this.field_573_bc) {
                var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.func_451_k(var2, var3, var4 - 1), (IInventory)var6);
            }

            if (var1.func_444_a(var2, var3, var4 + 1) == this.field_573_bc) {
                var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.func_451_k(var2, var3, var4 + 1));
            }

            if (var1.field_792_x) {
                return true;
            } else {
                var5.func_166_a((IInventory)var6);
                return true;
            }
        }
    }

    protected TileEntity func_294_a_() {
        return new TileEntityChest();
    }
}
