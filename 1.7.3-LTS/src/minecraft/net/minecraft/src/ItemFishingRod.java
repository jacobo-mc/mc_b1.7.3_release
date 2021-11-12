package net.minecraft.src;

public class ItemFishingRod extends Item {
    public ItemFishingRod(int var1) {
        super(var1);
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
    }

    public boolean isFull3D() {
        return true;
    }

    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        if (var3.fishEntity != null) {
            int var4 = var3.fishEntity.catchFish();
            var1.damageItem(var4, var3);
            var3.swingItem();
        } else {
            var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!var2.multiplayerWorld) {
                var2.entityJoinedWorld(new EntityFish(var2, var3));
            }

            var3.swingItem();
        }

        return var1;
    }
}
