package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiCrafting extends GuiContainer {
    public GuiCrafting(InventoryPlayer var1, World var2, int var3, int var4, int var5) {
        super(new ContainerWorkbench(var1, var2, var3, var4, var5));
    }

    public void func_6449_h() {
        super.func_6449_h();
        this.field_973_i.func_1104_a(this.field_945_b.field_6322_g);
    }

    protected void func_587_j() {
        this.field_6451_g.func_873_b("Crafting", 28, 6, 4210752);
        this.field_6451_g.func_873_b("Inventory", 8, this.field_974_h - 96 + 2, 4210752);
    }

    protected void func_589_a(float var1) {
        int var2 = this.field_945_b.field_6315_n.func_1070_a("/gui/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_945_b.field_6315_n.func_1076_b(var2);
        int var3 = (this.field_951_c - this.field_971_a) / 2;
        int var4 = (this.field_950_d - this.field_974_h) / 2;
        this.func_550_b(var3, var4, 0, 0, this.field_971_a, this.field_974_h);
    }
}
