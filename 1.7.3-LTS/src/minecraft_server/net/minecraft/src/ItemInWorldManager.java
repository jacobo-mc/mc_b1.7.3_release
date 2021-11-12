package net.minecraft.src;

public class ItemInWorldManager {
    private WorldServer thisWorld;
    public EntityPlayer thisPlayer;
    private float field_672_d = 0.0F;
    private int field_22055_d;
    private int field_22054_g;
    private int field_22053_h;
    private int field_22052_i;
    private int field_22051_j;
    private boolean field_22050_k;
    private int field_22049_l;
    private int field_22048_m;
    private int field_22047_n;
    private int field_22046_o;

    public ItemInWorldManager(WorldServer var1) {
        this.thisWorld = var1;
    }

    public void func_328_a() {
        ++this.field_22051_j;
        if (this.field_22050_k) {
            int var1 = this.field_22051_j - this.field_22046_o;
            int var2 = this.thisWorld.getBlockId(this.field_22049_l, this.field_22048_m, this.field_22047_n);
            if (var2 != 0) {
                Block var3 = Block.blocksList[var2];
                float var4 = var3.blockStrength(this.thisPlayer) * (float)(var1 + 1);
                if (var4 >= 1.0F) {
                    this.field_22050_k = false;
                    this.func_325_c(this.field_22049_l, this.field_22048_m, this.field_22047_n);
                }
            } else {
                this.field_22050_k = false;
            }
        }

    }

    public void func_324_a(int var1, int var2, int var3, int var4) {
        this.thisWorld.func_28096_a((EntityPlayer)null, var1, var2, var3, var4);
        this.field_22055_d = this.field_22051_j;
        int var5 = this.thisWorld.getBlockId(var1, var2, var3);
        if (var5 > 0) {
            Block.blocksList[var5].onBlockClicked(this.thisWorld, var1, var2, var3, this.thisPlayer);
        }

        if (var5 > 0 && Block.blocksList[var5].blockStrength(this.thisPlayer) >= 1.0F) {
            this.func_325_c(var1, var2, var3);
        } else {
            this.field_22054_g = var1;
            this.field_22053_h = var2;
            this.field_22052_i = var3;
        }

    }

    public void func_22045_b(int var1, int var2, int var3) {
        if (var1 == this.field_22054_g && var2 == this.field_22053_h && var3 == this.field_22052_i) {
            int var4 = this.field_22051_j - this.field_22055_d;
            int var5 = this.thisWorld.getBlockId(var1, var2, var3);
            if (var5 != 0) {
                Block var6 = Block.blocksList[var5];
                float var7 = var6.blockStrength(this.thisPlayer) * (float)(var4 + 1);
                if (var7 >= 0.7F) {
                    this.func_325_c(var1, var2, var3);
                } else if (!this.field_22050_k) {
                    this.field_22050_k = true;
                    this.field_22049_l = var1;
                    this.field_22048_m = var2;
                    this.field_22047_n = var3;
                    this.field_22046_o = this.field_22055_d;
                }
            }
        }

        this.field_672_d = 0.0F;
    }

    public boolean removeBlock(int var1, int var2, int var3) {
        Block var4 = Block.blocksList[this.thisWorld.getBlockId(var1, var2, var3)];
        int var5 = this.thisWorld.getBlockMetadata(var1, var2, var3);
        boolean var6 = this.thisWorld.setBlockWithNotify(var1, var2, var3, 0);
        if (var4 != null && var6) {
            var4.onBlockDestroyedByPlayer(this.thisWorld, var1, var2, var3, var5);
        }

        return var6;
    }

    public boolean func_325_c(int var1, int var2, int var3) {
        int var4 = this.thisWorld.getBlockId(var1, var2, var3);
        int var5 = this.thisWorld.getBlockMetadata(var1, var2, var3);
        this.thisWorld.func_28101_a(this.thisPlayer, 2001, var1, var2, var3, var4 + this.thisWorld.getBlockMetadata(var1, var2, var3) * 256);
        boolean var6 = this.removeBlock(var1, var2, var3);
        ItemStack var7 = this.thisPlayer.getCurrentEquippedItem();
        if (var7 != null) {
            var7.func_25124_a(var4, var1, var2, var3, this.thisPlayer);
            if (var7.stackSize == 0) {
                var7.func_577_a(this.thisPlayer);
                this.thisPlayer.destroyCurrentEquippedItem();
            }
        }

        if (var6 && this.thisPlayer.canHarvestBlock(Block.blocksList[var4])) {
            Block.blocksList[var4].harvestBlock(this.thisWorld, this.thisPlayer, var1, var2, var3, var5);
            ((EntityPlayerMP)this.thisPlayer).playerNetServerHandler.sendPacket(new Packet53BlockChange(var1, var2, var3, this.thisWorld));
        }

        return var6;
    }

    public boolean func_6154_a(EntityPlayer var1, World var2, ItemStack var3) {
        int var4 = var3.stackSize;
        ItemStack var5 = var3.useItemRightClick(var2, var1);
        if (var5 != var3 || var5 != null && var5.stackSize != var4) {
            var1.inventory.mainInventory[var1.inventory.currentItem] = var5;
            if (var5.stackSize == 0) {
                var1.inventory.mainInventory[var1.inventory.currentItem] = null;
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean activeBlockOrUseItem(EntityPlayer var1, World var2, ItemStack var3, int var4, int var5, int var6, int var7) {
        int var8 = var2.getBlockId(var4, var5, var6);
        if (var8 > 0 && Block.blocksList[var8].blockActivated(var2, var4, var5, var6, var1)) {
            return true;
        } else {
            return var3 == null ? false : var3.useItem(var1, var2, var4, var5, var6, var7);
        }
    }
}
