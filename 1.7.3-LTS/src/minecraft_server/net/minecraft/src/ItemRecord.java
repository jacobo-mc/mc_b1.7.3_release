package net.minecraft.src;

public class ItemRecord extends Item {
    public final String recordName;

    protected ItemRecord(int var1, String var2) {
        super(var1);
        this.recordName = var2;
        this.maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.getBlockId(var4, var5, var6) == Block.jukebox.blockID && var3.getBlockMetadata(var4, var5, var6) == 0) {
            if (var3.singleplayerWorld) {
                return true;
            } else {
                ((BlockJukeBox)Block.jukebox).ejectRecord(var3, var4, var5, var6, this.shiftedIndex);
                var3.func_28101_a((EntityPlayer)null, 1005, var4, var5, var6, this.shiftedIndex);
                --var1.stackSize;
                return true;
            }
        } else {
            return false;
        }
    }
}
