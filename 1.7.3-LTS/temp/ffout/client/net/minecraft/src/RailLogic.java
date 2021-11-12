package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

class RailLogic {
    private World field_1159_b;
    private int field_1165_c;
    private int field_1164_d;
    private int field_1163_e;
    private final boolean field_27212_f;
    private List field_1161_g;
    // $FF: synthetic field
    final BlockRail field_1160_a;

    public RailLogic(BlockRail var1, World var2, int var3, int var4, int var5) {
        this.field_1160_a = var1;
        this.field_1161_g = new ArrayList();
        this.field_1159_b = var2;
        this.field_1165_c = var3;
        this.field_1164_d = var4;
        this.field_1163_e = var5;
        int var6 = var2.func_600_a(var3, var4, var5);
        int var7 = var2.func_602_e(var3, var4, var5);
        if (BlockRail.func_27039_a((BlockRail)Block.field_345_n[var6])) {
            this.field_27212_f = true;
            var7 &= -9;
        } else {
            this.field_27212_f = false;
        }

        this.func_27211_a(var7);
    }

    private void func_27211_a(int var1) {
        this.field_1161_g.clear();
        if (var1 == 0) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (var1 == 1) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
        } else if (var1 == 2) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e));
        } else if (var1 == 3) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
        } else if (var1 == 4) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (var1 == 5) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1));
        } else if (var1 == 6) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (var1 == 7) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (var1 == 8) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
        } else if (var1 == 9) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
        }

    }

    private void func_785_b() {
        for(int var1 = 0; var1 < this.field_1161_g.size(); ++var1) {
            RailLogic var2 = this.func_795_a((ChunkPosition)this.field_1161_g.get(var1));
            if (var2 != null && var2.func_793_b(this)) {
                this.field_1161_g.set(var1, new ChunkPosition(var2.field_1165_c, var2.field_1164_d, var2.field_1163_e));
            } else {
                this.field_1161_g.remove(var1--);
            }
        }

    }

    private boolean func_784_a(int var1, int var2, int var3) {
        if (BlockRail.func_27040_h(this.field_1159_b, var1, var2, var3)) {
            return true;
        } else if (BlockRail.func_27040_h(this.field_1159_b, var1, var2 + 1, var3)) {
            return true;
        } else {
            return BlockRail.func_27040_h(this.field_1159_b, var1, var2 - 1, var3);
        }
    }

    private RailLogic func_795_a(ChunkPosition var1) {
        if (BlockRail.func_27040_h(this.field_1159_b, var1.field_1111_a, var1.field_1110_b, var1.field_1112_c)) {
            return new RailLogic(this.field_1160_a, this.field_1159_b, var1.field_1111_a, var1.field_1110_b, var1.field_1112_c);
        } else if (BlockRail.func_27040_h(this.field_1159_b, var1.field_1111_a, var1.field_1110_b + 1, var1.field_1112_c)) {
            return new RailLogic(this.field_1160_a, this.field_1159_b, var1.field_1111_a, var1.field_1110_b + 1, var1.field_1112_c);
        } else {
            return BlockRail.func_27040_h(this.field_1159_b, var1.field_1111_a, var1.field_1110_b - 1, var1.field_1112_c) ? new RailLogic(this.field_1160_a, this.field_1159_b, var1.field_1111_a, var1.field_1110_b - 1, var1.field_1112_c) : null;
        }
    }

    private boolean func_793_b(RailLogic var1) {
        for(int var2 = 0; var2 < this.field_1161_g.size(); ++var2) {
            ChunkPosition var3 = (ChunkPosition)this.field_1161_g.get(var2);
            if (var3.field_1111_a == var1.field_1165_c && var3.field_1112_c == var1.field_1163_e) {
                return true;
            }
        }

        return false;
    }

    private boolean func_794_b(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.field_1161_g.size(); ++var4) {
            ChunkPosition var5 = (ChunkPosition)this.field_1161_g.get(var4);
            if (var5.field_1111_a == var1 && var5.field_1112_c == var3) {
                return true;
            }
        }

        return false;
    }

    private int func_790_c() {
        int var1 = 0;
        if (this.func_784_a(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1)) {
            ++var1;
        }

        if (this.func_784_a(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1)) {
            ++var1;
        }

        if (this.func_784_a(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e)) {
            ++var1;
        }

        if (this.func_784_a(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e)) {
            ++var1;
        }

        return var1;
    }

    private boolean func_787_c(RailLogic var1) {
        if (this.func_793_b(var1)) {
            return true;
        } else if (this.field_1161_g.size() == 2) {
            return false;
        } else if (this.field_1161_g.size() == 0) {
            return true;
        } else {
            ChunkPosition var2 = (ChunkPosition)this.field_1161_g.get(0);
            return var1.field_1164_d == this.field_1164_d && var2.field_1110_b == this.field_1164_d ? true : true;
        }
    }

    private void func_788_d(RailLogic var1) {
        this.field_1161_g.add(new ChunkPosition(var1.field_1165_c, var1.field_1164_d, var1.field_1163_e));
        boolean var2 = this.func_794_b(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1);
        boolean var3 = this.func_794_b(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1);
        boolean var4 = this.func_794_b(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e);
        boolean var5 = this.func_794_b(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e);
        byte var6 = -1;
        if (var2 || var3) {
            var6 = 0;
        }

        if (var4 || var5) {
            var6 = 1;
        }

        if (!this.field_27212_f) {
            if (var3 && var5 && !var2 && !var4) {
                var6 = 6;
            }

            if (var3 && var4 && !var2 && !var5) {
                var6 = 7;
            }

            if (var2 && var4 && !var3 && !var5) {
                var6 = 8;
            }

            if (var2 && var5 && !var3 && !var4) {
                var6 = 9;
            }
        }

        if (var6 == 0) {
            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1)) {
                var6 = 4;
            }

            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1)) {
                var6 = 5;
            }
        }

        if (var6 == 1) {
            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e)) {
                var6 = 2;
            }

            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e)) {
                var6 = 3;
            }
        }

        if (var6 < 0) {
            var6 = 0;
        }

        int var7 = var6;
        if (this.field_27212_f) {
            var7 = this.field_1159_b.func_602_e(this.field_1165_c, this.field_1164_d, this.field_1163_e) & 8 | var6;
        }

        this.field_1159_b.func_691_b(this.field_1165_c, this.field_1164_d, this.field_1163_e, var7);
    }

    private boolean func_786_c(int var1, int var2, int var3) {
        RailLogic var4 = this.func_795_a(new ChunkPosition(var1, var2, var3));
        if (var4 == null) {
            return false;
        } else {
            var4.func_785_b();
            return var4.func_787_c(this);
        }
    }

    public void func_792_a(boolean var1, boolean var2) {
        boolean var3 = this.func_786_c(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1);
        boolean var4 = this.func_786_c(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1);
        boolean var5 = this.func_786_c(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e);
        boolean var6 = this.func_786_c(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e);
        byte var7 = -1;
        if ((var3 || var4) && !var5 && !var6) {
            var7 = 0;
        }

        if ((var5 || var6) && !var3 && !var4) {
            var7 = 1;
        }

        if (!this.field_27212_f) {
            if (var4 && var6 && !var3 && !var5) {
                var7 = 6;
            }

            if (var4 && var5 && !var3 && !var6) {
                var7 = 7;
            }

            if (var3 && var5 && !var4 && !var6) {
                var7 = 8;
            }

            if (var3 && var6 && !var4 && !var5) {
                var7 = 9;
            }
        }

        if (var7 == -1) {
            if (var3 || var4) {
                var7 = 0;
            }

            if (var5 || var6) {
                var7 = 1;
            }

            if (!this.field_27212_f) {
                if (var1) {
                    if (var4 && var6) {
                        var7 = 6;
                    }

                    if (var5 && var4) {
                        var7 = 7;
                    }

                    if (var6 && var3) {
                        var7 = 9;
                    }

                    if (var3 && var5) {
                        var7 = 8;
                    }
                } else {
                    if (var3 && var5) {
                        var7 = 8;
                    }

                    if (var6 && var3) {
                        var7 = 9;
                    }

                    if (var5 && var4) {
                        var7 = 7;
                    }

                    if (var4 && var6) {
                        var7 = 6;
                    }
                }
            }
        }

        if (var7 == 0) {
            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1)) {
                var7 = 4;
            }

            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1)) {
                var7 = 5;
            }
        }

        if (var7 == 1) {
            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e)) {
                var7 = 2;
            }

            if (BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e)) {
                var7 = 3;
            }
        }

        if (var7 < 0) {
            var7 = 0;
        }

        this.func_27211_a(var7);
        int var8 = var7;
        if (this.field_27212_f) {
            var8 = this.field_1159_b.func_602_e(this.field_1165_c, this.field_1164_d, this.field_1163_e) & 8 | var7;
        }

        if (var2 || this.field_1159_b.func_602_e(this.field_1165_c, this.field_1164_d, this.field_1163_e) != var8) {
            this.field_1159_b.func_691_b(this.field_1165_c, this.field_1164_d, this.field_1163_e, var8);

            for(int var9 = 0; var9 < this.field_1161_g.size(); ++var9) {
                RailLogic var10 = this.func_795_a((ChunkPosition)this.field_1161_g.get(var9));
                if (var10 != null) {
                    var10.func_785_b();
                    if (var10.func_787_c(this)) {
                        var10.func_788_d(this);
                    }
                }
            }
        }

    }

    // $FF: synthetic method
    static int func_791_a(RailLogic var0) {
        return var0.func_790_c();
    }
}
