package net.minecraft.src;

public class MovementInputFromOptions extends MovementInput {
    private boolean[] field_1179_f = new boolean[10];
    private GameSettings field_1178_g;

    public MovementInputFromOptions(GameSettings var1) {
        this.field_1178_g = var1;
    }

    public void func_796_a(int var1, boolean var2) {
        byte var3 = -1;
        if (var1 == this.field_1178_g.field_1575_j.field_1370_b) {
            var3 = 0;
        }

        if (var1 == this.field_1178_g.field_1573_l.field_1370_b) {
            var3 = 1;
        }

        if (var1 == this.field_1178_g.field_1574_k.field_1370_b) {
            var3 = 2;
        }

        if (var1 == this.field_1178_g.field_1572_m.field_1370_b) {
            var3 = 3;
        }

        if (var1 == this.field_1178_g.field_1571_n.field_1370_b) {
            var3 = 4;
        }

        if (var1 == this.field_1178_g.field_1565_s.field_1370_b) {
            var3 = 5;
        }

        if (var3 >= 0) {
            this.field_1179_f[var3] = var2;
        }

    }

    public void func_798_a() {
        for(int var1 = 0; var1 < 10; ++var1) {
            this.field_1179_f[var1] = false;
        }

    }

    public void func_797_a(EntityPlayer var1) {
        this.field_1174_a = 0.0F;
        this.field_1173_b = 0.0F;
        if (this.field_1179_f[0]) {
            ++this.field_1173_b;
        }

        if (this.field_1179_f[1]) {
            --this.field_1173_b;
        }

        if (this.field_1179_f[2]) {
            ++this.field_1174_a;
        }

        if (this.field_1179_f[3]) {
            --this.field_1174_a;
        }

        this.field_1176_d = this.field_1179_f[4];
        this.field_1175_e = this.field_1179_f[5];
        if (this.field_1175_e) {
            this.field_1174_a = (float)((double)this.field_1174_a * 0.3D);
            this.field_1173_b = (float)((double)this.field_1173_b * 0.3D);
        }

    }
}
