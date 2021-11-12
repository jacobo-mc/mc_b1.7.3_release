package net.minecraft.src;

import java.util.Random;

public class Particle {
    private static Random field_25128_s = new Random();
    public double field_25146_a;
    public double field_25145_b;
    public double field_25144_c;
    public double field_25143_d;
    public double field_25142_e;
    public double field_25141_f;
    public double field_25140_g;
    public boolean isDead;
    public int field_25138_i;
    public int field_25137_j;
    public double field_25136_k;
    public double field_25135_l;
    public double field_25134_m;
    public double field_25133_n;
    public double field_25132_o;
    public double field_25131_p;
    public double field_25130_q;
    public double field_25129_r;

    public void update(GuiParticle var1) {
        this.field_25146_a += this.field_25142_e;
        this.field_25145_b += this.field_25141_f;
        this.field_25142_e *= this.field_25140_g;
        this.field_25141_f *= this.field_25140_g;
        this.field_25141_f += 0.1D;
        if (++this.field_25138_i > this.field_25137_j) {
            this.func_25126_b();
        }

        this.field_25133_n = 2.0D - (double)this.field_25138_i / (double)this.field_25137_j * 2.0D;
        if (this.field_25133_n > 1.0D) {
            this.field_25133_n = 1.0D;
        }

        this.field_25133_n *= this.field_25133_n;
        this.field_25133_n *= 0.5D;
    }

    public void preUpdate() {
        this.field_25132_o = this.field_25136_k;
        this.field_25131_p = this.field_25135_l;
        this.field_25130_q = this.field_25134_m;
        this.field_25129_r = this.field_25133_n;
        this.field_25144_c = this.field_25146_a;
        this.field_25143_d = this.field_25145_b;
    }

    public void func_25126_b() {
        this.isDead = true;
    }
}
