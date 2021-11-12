package net.minecraft.src;

import java.io.IOException;

public class ChunkProviderLoadOrGenerate implements IChunkProvider {
    private Chunk field_897_c;
    private IChunkProvider field_896_d;
    private IChunkLoader field_895_e;
    private Chunk[] field_894_f;
    private World field_893_g;
    int field_891_a;
    int field_890_b;
    private Chunk field_892_h;
    private int field_21113_i;
    private int field_21112_j;

    public void func_21110_c(int var1, int var2) {
        this.field_21113_i = var1;
        this.field_21112_j = var2;
    }

    public boolean func_21111_d(int var1, int var2) {
        byte var3 = 15;
        return var1 >= this.field_21113_i - var3 && var2 >= this.field_21112_j - var3 && var1 <= this.field_21113_i + var3 && var2 <= this.field_21112_j + var3;
    }

    public boolean func_537_a(int var1, int var2) {
        if (!this.func_21111_d(var1, var2)) {
            return false;
        } else if (var1 == this.field_891_a && var2 == this.field_890_b && this.field_892_h != null) {
            return true;
        } else {
            int var3 = var1 & 31;
            int var4 = var2 & 31;
            int var5 = var3 + var4 * 32;
            return this.field_894_f[var5] != null && (this.field_894_f[var5] == this.field_897_c || this.field_894_f[var5].func_1017_a(var1, var2));
        }
    }

    public Chunk func_538_d(int var1, int var2) {
        return this.func_533_b(var1, var2);
    }

    public Chunk func_533_b(int var1, int var2) {
        if (var1 == this.field_891_a && var2 == this.field_890_b && this.field_892_h != null) {
            return this.field_892_h;
        } else if (!this.field_893_g.field_9430_x && !this.func_21111_d(var1, var2)) {
            return this.field_897_c;
        } else {
            int var3 = var1 & 31;
            int var4 = var2 & 31;
            int var5 = var3 + var4 * 32;
            if (!this.func_537_a(var1, var2)) {
                if (this.field_894_f[var5] != null) {
                    this.field_894_f[var5].func_998_e();
                    this.func_540_b(this.field_894_f[var5]);
                    this.func_541_a(this.field_894_f[var5]);
                }

                Chunk var6 = this.func_542_c(var1, var2);
                if (var6 == null) {
                    if (this.field_896_d == null) {
                        var6 = this.field_897_c;
                    } else {
                        var6 = this.field_896_d.func_533_b(var1, var2);
                        var6.func_25124_i();
                    }
                }

                this.field_894_f[var5] = var6;
                var6.func_4143_d();
                if (this.field_894_f[var5] != null) {
                    this.field_894_f[var5].func_995_d();
                }

                if (!this.field_894_f[var5].field_1527_n && this.func_537_a(var1 + 1, var2 + 1) && this.func_537_a(var1, var2 + 1) && this.func_537_a(var1 + 1, var2)) {
                    this.func_534_a(this, var1, var2);
                }

                if (this.func_537_a(var1 - 1, var2) && !this.func_533_b(var1 - 1, var2).field_1527_n && this.func_537_a(var1 - 1, var2 + 1) && this.func_537_a(var1, var2 + 1) && this.func_537_a(var1 - 1, var2)) {
                    this.func_534_a(this, var1 - 1, var2);
                }

                if (this.func_537_a(var1, var2 - 1) && !this.func_533_b(var1, var2 - 1).field_1527_n && this.func_537_a(var1 + 1, var2 - 1) && this.func_537_a(var1, var2 - 1) && this.func_537_a(var1 + 1, var2)) {
                    this.func_534_a(this, var1, var2 - 1);
                }

                if (this.func_537_a(var1 - 1, var2 - 1) && !this.func_533_b(var1 - 1, var2 - 1).field_1527_n && this.func_537_a(var1 - 1, var2 - 1) && this.func_537_a(var1, var2 - 1) && this.func_537_a(var1 - 1, var2)) {
                    this.func_534_a(this, var1 - 1, var2 - 1);
                }
            }

            this.field_891_a = var1;
            this.field_890_b = var2;
            this.field_892_h = this.field_894_f[var5];
            return this.field_894_f[var5];
        }
    }

    private Chunk func_542_c(int var1, int var2) {
        if (this.field_895_e == null) {
            return this.field_897_c;
        } else {
            try {
                Chunk var3 = this.field_895_e.func_813_a(this.field_893_g, var1, var2);
                if (var3 != null) {
                    var3.field_1522_s = this.field_893_g.func_22139_r();
                }

                return var3;
            } catch (Exception var4) {
                var4.printStackTrace();
                return this.field_897_c;
            }
        }
    }

    private void func_541_a(Chunk var1) {
        if (this.field_895_e != null) {
            try {
                this.field_895_e.func_815_b(this.field_893_g, var1);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    private void func_540_b(Chunk var1) {
        if (this.field_895_e != null) {
            try {
                var1.field_1522_s = this.field_893_g.func_22139_r();
                this.field_895_e.func_812_a(this.field_893_g, var1);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }

    public void func_534_a(IChunkProvider var1, int var2, int var3) {
        Chunk var4 = this.func_533_b(var2, var3);
        if (!var4.field_1527_n) {
            var4.field_1527_n = true;
            if (this.field_896_d != null) {
                this.field_896_d.func_534_a(var1, var2, var3);
                var4.func_1006_f();
            }
        }

    }

    public boolean func_535_a(boolean var1, IProgressUpdate var2) {
        int var3 = 0;
        int var4 = 0;
        int var5;
        if (var2 != null) {
            for(var5 = 0; var5 < this.field_894_f.length; ++var5) {
                if (this.field_894_f[var5] != null && this.field_894_f[var5].func_1012_a(var1)) {
                    ++var4;
                }
            }
        }

        var5 = 0;

        for(int var6 = 0; var6 < this.field_894_f.length; ++var6) {
            if (this.field_894_f[var6] != null) {
                if (var1 && !this.field_894_f[var6].field_1525_p) {
                    this.func_541_a(this.field_894_f[var6]);
                }

                if (this.field_894_f[var6].func_1012_a(var1)) {
                    this.func_540_b(this.field_894_f[var6]);
                    this.field_894_f[var6].field_1526_o = false;
                    ++var3;
                    if (var3 == 2 && !var1) {
                        return false;
                    }

                    if (var2 != null) {
                        ++var5;
                        if (var5 % 10 == 0) {
                            var2.func_593_a(var5 * 100 / var4);
                        }
                    }
                }
            }
        }

        if (var1) {
            if (this.field_895_e == null) {
                return true;
            }

            this.field_895_e.func_811_b();
        }

        return true;
    }

    public boolean func_532_a() {
        if (this.field_895_e != null) {
            this.field_895_e.func_814_a();
        }

        return this.field_896_d.func_532_a();
    }

    public boolean func_536_b() {
        return true;
    }

    public String func_21109_c() {
        return "ChunkCache: " + this.field_894_f.length;
    }
}
