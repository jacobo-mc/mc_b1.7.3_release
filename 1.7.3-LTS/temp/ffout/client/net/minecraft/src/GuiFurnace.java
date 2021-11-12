package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiFurnace extends GuiContainer {
    private TileEntityFurnace field_978_j;

    public GuiFurnace(InventoryPlayer var1, TileEntityFurnace var2) {
        super(new ContainerFurnace(var1, var2));
        this.field_978_j = var2;
    }

    protected void func_587_j() {
        this.field_6451_g.func_873_b("Furnace", 60, 6, 4210752);
        this.field_6451_g.func_873_b("Inventory", 8, this.field_974_h - 96 + 2, 4210752);
    }

    protected void func_589_a(float var1) {
        int var2 = this.field_945_b.field_6315_n.func_1070_a("/gui/furnace.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_945_b.field_6315_n.func_1076_b(var2);
        int var3 = (this.field_951_c - this.field_971_a) / 2;
        int var4 = (this.field_950_d - this.field_974_h) / 2;
        this.func_550_b(var3, var4, 0, 0, this.field_971_a, this.field_974_h);
        int var5;
        if (this.field_978_j.func_485_a()) {
            var5 = this.field_978_j.func_489_b(12);
            this.func_550_b(var3 + 56, var4 + 36 + 12 - var5, 176, 12 - var5, 14, var5 + 2);
        }

        var5 = this.field_978_j.func_490_a(24);
        this.func_550_b(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
    }
}
