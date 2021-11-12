package net.minecraft.src;

public class ItemSword extends Item {
    private int weaponDamage;

    public ItemSword(int var1, EnumToolMaterial var2) {
        super(var1);
        this.maxStackSize = 1;
        this.setMaxDamage(var2.getMaxUses());
        this.weaponDamage = 4 + var2.getDamageVsEntity() * 2;
    }

    public float getStrVsBlock(ItemStack var1, Block var2) {
        return var2.blockID == Block.web.blockID ? 15.0F : 1.5F;
    }

    public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        var1.damageItem(1, var3);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        var1.damageItem(2, var6);
        return true;
    }

    public int getDamageVsEntity(Entity var1) {
        return this.weaponDamage;
    }

    public boolean isFull3D() {
        return true;
    }

    public boolean canHarvestBlock(Block var1) {
        return var1.blockID == Block.web.blockID;
    }
}
