package net.minecraft.src;

public class GuiIngameMenu extends GuiScreen {
    private int field_966_a = 0;
    private int field_967_h = 0;

    public void func_6448_a() {
        this.field_966_a = 0;
        this.field_949_e.clear();
        byte var1 = -16;
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + var1, "Save and quit to title"));
        if (this.field_945_b.func_6260_j()) {
            ((GuiButton)this.field_949_e.get(0)).field_939_e = "Disconnect";
        }

        this.field_949_e.add(new GuiButton(4, this.field_951_c / 2 - 100, this.field_950_d / 4 + 24 + var1, "Back to game"));
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + var1, "Options..."));
        this.field_949_e.add(new GuiButton(5, this.field_951_c / 2 - 100, this.field_950_d / 4 + 48 + var1, 98, 20, StatCollector.func_25200_a("gui.achievements")));
        this.field_949_e.add(new GuiButton(6, this.field_951_c / 2 + 2, this.field_950_d / 4 + 48 + var1, 98, 20, StatCollector.func_25200_a("gui.stats")));
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 0) {
            this.field_945_b.func_6272_a(new GuiOptions(this, this.field_945_b.field_6304_y));
        }

        if (var1.field_938_f == 1) {
            this.field_945_b.field_25001_G.func_25100_a(StatList.field_25180_i, 1);
            if (this.field_945_b.func_6260_j()) {
                this.field_945_b.field_6324_e.func_660_k();
            }

            this.field_945_b.func_6261_a((World)null);
            this.field_945_b.func_6272_a(new GuiMainMenu());
        }

        if (var1.field_938_f == 4) {
            this.field_945_b.func_6272_a((GuiScreen)null);
            this.field_945_b.func_6259_e();
        }

        if (var1.field_938_f == 5) {
            this.field_945_b.func_6272_a(new GuiAchievements(this.field_945_b.field_25001_G));
        }

        if (var1.field_938_f == 6) {
            this.field_945_b.func_6272_a(new GuiStats(this, this.field_945_b.field_25001_G));
        }

    }

    public void func_570_g() {
        super.func_570_g();
        ++this.field_967_h;
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        boolean var4 = !this.field_945_b.field_6324_e.func_650_a(this.field_966_a++);
        if (var4 || this.field_967_h < 20) {
            float var5 = ((float)(this.field_967_h % 10) + var3) / 10.0F;
            var5 = MathHelper.func_1106_a(var5 * 3.1415927F * 2.0F) * 0.2F + 0.8F;
            int var6 = (int)(255.0F * var5);
            this.func_547_b(this.field_6451_g, "Saving level..", 8, this.field_950_d - 16, var6 << 16 | var6 << 8 | var6);
        }

        this.func_548_a(this.field_6451_g, "Game menu", this.field_951_c / 2, 40, 16777215);
        super.func_571_a(var1, var2, var3);
    }
}
