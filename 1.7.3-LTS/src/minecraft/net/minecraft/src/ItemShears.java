package net.minecraft.src;

public class ItemShears extends Item {
    public ItemShears(int var1) {
        super(var1);
        this.setMaxStackSize(1);
        this.setMaxDamage(238);
    }

    public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        if (var2 == Block.leaves.blockID || var2 == Block.web.blockID) {
            var1.damageItem(1, var6);
        }

        return super.onBlockDestroyed(var1, var2, var3, var4, var5, var6);
    }

    public boolean canHarvestBlock(Block var1) {
        return var1.blockID == Block.web.blockID;
    }

    public float getStrVsBlock(ItemStack var1, Block var2) {
        if (var2.blockID != Block.web.blockID && var2.blockID != Block.leaves.blockID) {
            return var2.blockID == Block.cloth.blockID ? 5.0F : super.getStrVsBlock(var1, var2);
        } else {
            return 15.0F;
        }
    }
}
