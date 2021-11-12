package net.minecraft.src;

public class BlockWorkbench extends Block {
    protected BlockWorkbench(int var1) {
        super(var1, Material.wood);
        this.blockIndexInTexture = 59;
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture - 16;
        } else if (var1 == 0) {
            return Block.planks.getBlockTextureFromSide(0);
        } else {
            return var1 != 2 && var1 != 4 ? this.blockIndexInTexture : this.blockIndexInTexture + 1;
        }
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.singleplayerWorld) {
            return true;
        } else {
            var5.displayWorkbenchGUI(var2, var3, var4);
            return true;
        }
    }
}
