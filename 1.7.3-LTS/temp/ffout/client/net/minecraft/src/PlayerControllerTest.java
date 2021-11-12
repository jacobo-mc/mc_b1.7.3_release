package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class PlayerControllerTest extends PlayerController {
    public PlayerControllerTest(Minecraft var1) {
        super(var1);
        this.field_1064_b = true;
    }

    public void func_6473_b(EntityPlayer var1) {
        for(int var2 = 0; var2 < 9; ++var2) {
            if (var1.field_778_b.field_843_a[var2] == null) {
                this.field_1065_a.field_6322_g.field_778_b.field_843_a[var2] = new ItemStack((Block)Session.field_1667_a.get(var2));
            } else {
                this.field_1065_a.field_6322_g.field_778_b.field_843_a[var2].field_1615_a = 1;
            }
        }

    }

    public boolean func_6469_d() {
        return false;
    }

    public void func_717_a(World var1) {
        super.func_717_a(var1);
    }

    public void func_6474_c() {
    }
}
