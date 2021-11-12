package net.minecraft.src;

public class Frustrum implements ICamera {
    private ClippingHelper field_593_a = ClippingHelperImpl.func_1155_a();
    private double field_592_b;
    private double field_595_c;
    private double field_594_d;

    public void func_343_a(double var1, double var3, double var5) {
        this.field_592_b = var1;
        this.field_595_c = var3;
        this.field_594_d = var5;
    }

    public boolean func_344_a(double var1, double var3, double var5, double var7, double var9, double var11) {
        return this.field_593_a.func_1152_a(var1 - this.field_592_b, var3 - this.field_595_c, var5 - this.field_594_d, var7 - this.field_592_b, var9 - this.field_595_c, var11 - this.field_594_d);
    }

    public boolean func_342_a(AxisAlignedBB var1) {
        return this.func_344_a(var1.field_1698_a, var1.field_1697_b, var1.field_1704_c, var1.field_1703_d, var1.field_1702_e, var1.field_1701_f);
    }
}
