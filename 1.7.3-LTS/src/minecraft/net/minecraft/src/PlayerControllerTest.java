package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class PlayerControllerTest extends PlayerController {
    public PlayerControllerTest(Minecraft var1) {
        super(var1);
        this.field_1064_b = true;
    }

    public void func_6473_b(EntityPlayer var1) {
        for(int var2 = 0; var2 < 9; ++var2) {
            if (var1.inventory.mainInventory[var2] == null) {
                this.mc.thePlayer.inventory.mainInventory[var2] = new ItemStack((Block)Session.registeredBlocksList.get(var2));
            } else {
                this.mc.thePlayer.inventory.mainInventory[var2].stackSize = 1;
            }
        }

    }

    public boolean shouldDrawHUD() {
        return false;
    }

    public void func_717_a(World var1) {
        super.func_717_a(var1);
    }

    public void updateController() {
    }
}
