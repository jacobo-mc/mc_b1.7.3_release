package net.minecraft.src;

public class ItemCloth extends ItemBlock {
    public ItemCloth(int var1) {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int var1) {
        return var1;
    }
}
