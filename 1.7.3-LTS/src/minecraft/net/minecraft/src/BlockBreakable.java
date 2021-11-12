package net.minecraft.src;

public class BlockBreakable extends Block {
    private boolean localFlag;

    protected BlockBreakable(int var1, int var2, Material var3, boolean var4) {
        super(var1, var2, var3);
        this.localFlag = var4;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.getBlockId(var2, var3, var4);
        return !this.localFlag && var6 == this.blockID ? false : super.shouldSideBeRendered(var1, var2, var3, var4, var5);
    }
}
