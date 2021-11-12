package net.minecraft.src;

public class ItemSlab extends ItemBlock {
    public ItemSlab(int var1) {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int var1) {
        return var1;
    }
}
