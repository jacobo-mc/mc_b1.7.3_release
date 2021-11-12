package net.minecraft.src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WorldClient extends World {
    private LinkedList field_1057_z = new LinkedList();
    private NetClientHandler field_1052_A;
    private ChunkProviderClient field_20915_C;
    private MCHash field_1055_D = new MCHash();
    private Set field_20914_E = new HashSet();
    private Set field_1053_F = new HashSet();

    public WorldClient(NetClientHandler var1, long var2, int var4) {
        super(new SaveHandlerMP(), "MpServer", WorldProvider.func_4101_a(var4), var2);
        this.field_1052_A = var1;
        this.func_22143_a(new ChunkCoordinates(8, 64, 8));
        this.field_28108_z = var1.field_28118_b;
    }

    public void func_649_g() {
        this.func_648_a(this.func_22139_r() + 1L);
        int var1 = this.func_671_a(1.0F);
        int var2;
        if (var1 != this.field_1046_e) {
            this.field_1046_e = var1;

            for(var2 = 0; var2 < this.field_9434_r.size(); ++var2) {
                ((IWorldAccess)this.field_9434_r.get(var2)).func_936_e();
            }
        }

        for(var2 = 0; var2 < 10 && !this.field_1053_F.isEmpty(); ++var2) {
            Entity var3 = (Entity)this.field_1053_F.iterator().next();
            if (!this.field_1050_a.contains(var3)) {
                this.func_674_a(var3);
            }
        }

        this.field_1052_A.func_848_a();

        for(var2 = 0; var2 < this.field_1057_z.size(); ++var2) {
            WorldBlockPositionType var4 = (WorldBlockPositionType)this.field_1057_z.get(var2);
            if (--var4.field_1206_d == 0) {
                super.func_643_a(var4.field_1202_a, var4.field_1201_b, var4.field_1207_c, var4.field_1205_e, var4.field_1204_f);
                super.func_665_h(var4.field_1202_a, var4.field_1201_b, var4.field_1207_c);
                this.field_1057_z.remove(var2--);
            }
        }

    }

    public void func_711_c(int var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.field_1057_z.size(); ++var7) {
            WorldBlockPositionType var8 = (WorldBlockPositionType)this.field_1057_z.get(var7);
            if (var8.field_1202_a >= var1 && var8.field_1201_b >= var2 && var8.field_1207_c >= var3 && var8.field_1202_a <= var4 && var8.field_1201_b <= var5 && var8.field_1207_c <= var6) {
                this.field_1057_z.remove(var7--);
            }
        }

    }

    protected IChunkProvider func_4081_a() {
        this.field_20915_C = new ChunkProviderClient(this);
        return this.field_20915_C;
    }

    public void func_4076_b() {
        this.func_22143_a(new ChunkCoordinates(8, 64, 8));
    }

    protected void func_4080_j() {
    }

    public void func_22136_c(int var1, int var2, int var3, int var4, int var5) {
    }

    public boolean func_700_a(boolean var1) {
        return false;
    }

    public void func_713_a(int var1, int var2, boolean var3) {
        if (var3) {
            this.field_20915_C.func_538_d(var1, var2);
        } else {
            this.field_20915_C.func_539_c(var1, var2);
        }

        if (!var3) {
            this.func_701_b(var1 * 16, 0, var2 * 16, var1 * 16 + 15, 128, var2 * 16 + 15);
        }

    }

    public boolean func_674_a(Entity var1) {
        boolean var2 = super.func_674_a(var1);
        this.field_20914_E.add(var1);
        if (!var2) {
            this.field_1053_F.add(var1);
        }

        return var2;
    }

    public void func_607_d(Entity var1) {
        super.func_607_d(var1);
        this.field_20914_E.remove(var1);
    }

    protected void func_606_b(Entity var1) {
        super.func_606_b(var1);
        if (this.field_1053_F.contains(var1)) {
            this.field_1053_F.remove(var1);
        }

    }

    protected void func_678_c(Entity var1) {
        super.func_678_c(var1);
        if (this.field_20914_E.contains(var1)) {
            this.field_1053_F.add(var1);
        }

    }

    public void func_712_a(int var1, Entity var2) {
        Entity var3 = this.func_709_b(var1);
        if (var3 != null) {
            this.func_607_d(var3);
        }

        this.field_20914_E.add(var2);
        var2.field_620_ab = var1;
        if (!this.func_674_a(var2)) {
            this.field_1053_F.add(var2);
        }

        this.field_1055_D.func_1061_a(var1, var2);
    }

    public Entity func_709_b(int var1) {
        return (Entity)this.field_1055_D.func_1057_a(var1);
    }

    public Entity func_710_c(int var1) {
        Entity var2 = (Entity)this.field_1055_D.func_1052_b(var1);
        if (var2 != null) {
            this.field_20914_E.remove(var2);
            this.func_607_d(var2);
        }

        return var2;
    }

    public boolean func_635_c(int var1, int var2, int var3, int var4) {
        int var5 = this.func_600_a(var1, var2, var3);
        int var6 = this.func_602_e(var1, var2, var3);
        if (super.func_635_c(var1, var2, var3, var4)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, var1, var2, var3, var5, var6));
            return true;
        } else {
            return false;
        }
    }

    public boolean func_643_a(int var1, int var2, int var3, int var4, int var5) {
        int var6 = this.func_600_a(var1, var2, var3);
        int var7 = this.func_602_e(var1, var2, var3);
        if (super.func_643_a(var1, var2, var3, var4, var5)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, var1, var2, var3, var6, var7));
            return true;
        } else {
            return false;
        }
    }

    public boolean func_634_a(int var1, int var2, int var3, int var4) {
        int var5 = this.func_600_a(var1, var2, var3);
        int var6 = this.func_602_e(var1, var2, var3);
        if (super.func_634_a(var1, var2, var3, var4)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, var1, var2, var3, var5, var6));
            return true;
        } else {
            return false;
        }
    }

    public boolean func_714_c(int var1, int var2, int var3, int var4, int var5) {
        this.func_711_c(var1, var2, var3, var1, var2, var3);
        if (super.func_643_a(var1, var2, var3, var4, var5)) {
            this.func_617_e(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public void func_660_k() {
        this.field_1052_A.func_28117_a(new Packet255KickDisconnect("Quitting"));
    }

    protected void func_27165_m() {
        if (!this.field_4209_q.field_6478_e) {
            if (this.field_27168_F > 0) {
                --this.field_27168_F;
            }

            this.field_26901_B = this.field_27171_C;
            if (this.field_22145_q.func_27397_o()) {
                this.field_27171_C = (float)((double)this.field_27171_C + 0.01D);
            } else {
                this.field_27171_C = (float)((double)this.field_27171_C - 0.01D);
            }

            if (this.field_27171_C < 0.0F) {
                this.field_27171_C = 0.0F;
            }

            if (this.field_27171_C > 1.0F) {
                this.field_27171_C = 1.0F;
            }

            this.field_27170_D = this.field_27169_E;
            if (this.field_22145_q.func_27396_m()) {
                this.field_27169_E = (float)((double)this.field_27169_E + 0.01D);
            } else {
                this.field_27169_E = (float)((double)this.field_27169_E - 0.01D);
            }

            if (this.field_27169_E < 0.0F) {
                this.field_27169_E = 0.0F;
            }

            if (this.field_27169_E > 1.0F) {
                this.field_27169_E = 1.0F;
            }

        }
    }
}
