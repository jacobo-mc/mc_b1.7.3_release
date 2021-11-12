package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TileEntityPiston extends TileEntity {
    private int field_31021_a;
    private int field_31019_b;
    private int field_31025_c;
    private boolean field_31024_i;
    private boolean field_31023_j;
    private float field_31022_k;
    private float field_31020_l;
    private static List field_31018_m = new ArrayList();

    public TileEntityPiston() {
    }

    public TileEntityPiston(int var1, int var2, int var3, boolean var4, boolean var5) {
        this.field_31021_a = var1;
        this.field_31019_b = var2;
        this.field_31025_c = var3;
        this.field_31024_i = var4;
        this.field_31023_j = var5;
    }

    public int func_31016_a() {
        return this.field_31021_a;
    }

    public int func_479_f() {
        return this.field_31019_b;
    }

    public boolean func_31015_b() {
        return this.field_31024_i;
    }

    public int func_31009_d() {
        return this.field_31025_c;
    }

    public boolean func_31012_k() {
        return this.field_31023_j;
    }

    public float func_31008_a(float var1) {
        if (var1 > 1.0F) {
            var1 = 1.0F;
        }

        return this.field_31020_l + (this.field_31022_k - this.field_31020_l) * var1;
    }

    public float func_31017_b(float var1) {
        return this.field_31024_i ? (this.func_31008_a(var1) - 1.0F) * (float)PistonBlockTextures.field_31056_b[this.field_31025_c] : (1.0F - this.func_31008_a(var1)) * (float)PistonBlockTextures.field_31056_b[this.field_31025_c];
    }

    public float func_31014_c(float var1) {
        return this.field_31024_i ? (this.func_31008_a(var1) - 1.0F) * (float)PistonBlockTextures.field_31059_c[this.field_31025_c] : (1.0F - this.func_31008_a(var1)) * (float)PistonBlockTextures.field_31059_c[this.field_31025_c];
    }

    public float func_31013_d(float var1) {
        return this.field_31024_i ? (this.func_31008_a(var1) - 1.0F) * (float)PistonBlockTextures.field_31058_d[this.field_31025_c] : (1.0F - this.func_31008_a(var1)) * (float)PistonBlockTextures.field_31058_d[this.field_31025_c];
    }

    private void func_31010_a(float var1, float var2) {
        if (!this.field_31024_i) {
            --var1;
        } else {
            var1 = 1.0F - var1;
        }

        AxisAlignedBB var3 = Block.field_9268_ac.func_31035_a(this.field_824_e, this.field_823_f, this.field_822_g, this.field_821_h, this.field_31021_a, var1, this.field_31025_c);
        if (var3 != null) {
            List var4 = this.field_824_e.func_659_b((Entity)null, var3);
            if (!var4.isEmpty()) {
                field_31018_m.addAll(var4);
                Iterator var5 = field_31018_m.iterator();

                while(var5.hasNext()) {
                    Entity var6 = (Entity)var5.next();
                    var6.func_349_c((double)(var2 * (float)PistonBlockTextures.field_31056_b[this.field_31025_c]), (double)(var2 * (float)PistonBlockTextures.field_31059_c[this.field_31025_c]), (double)(var2 * (float)PistonBlockTextures.field_31058_d[this.field_31025_c]));
                }

                field_31018_m.clear();
            }
        }

    }

    public void func_31011_l() {
        if (this.field_31020_l < 1.0F) {
            this.field_31020_l = this.field_31022_k = 1.0F;
            this.field_824_e.func_692_l(this.field_823_f, this.field_822_g, this.field_821_h);
            this.func_31005_i();
            if (this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h) == Block.field_9268_ac.field_376_bc) {
                this.field_824_e.func_688_b(this.field_823_f, this.field_822_g, this.field_821_h, this.field_31021_a, this.field_31019_b);
            }
        }

    }

    public void func_475_b() {
        this.field_31020_l = this.field_31022_k;
        if (this.field_31020_l >= 1.0F) {
            this.func_31010_a(1.0F, 0.25F);
            this.field_824_e.func_692_l(this.field_823_f, this.field_822_g, this.field_821_h);
            this.func_31005_i();
            if (this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h) == Block.field_9268_ac.field_376_bc) {
                this.field_824_e.func_688_b(this.field_823_f, this.field_822_g, this.field_821_h, this.field_31021_a, this.field_31019_b);
            }

        } else {
            this.field_31022_k += 0.5F;
            if (this.field_31022_k >= 1.0F) {
                this.field_31022_k = 1.0F;
            }

            if (this.field_31024_i) {
                this.func_31010_a(this.field_31022_k, this.field_31022_k - this.field_31020_l + 0.0625F);
            }

        }
    }

    public void func_482_a(NBTTagCompound var1) {
        super.func_482_a(var1);
        this.field_31021_a = var1.func_756_e("blockId");
        this.field_31019_b = var1.func_756_e("blockData");
        this.field_31025_c = var1.func_756_e("facing");
        this.field_31020_l = this.field_31022_k = var1.func_752_g("progress");
        this.field_31024_i = var1.func_760_m("extending");
    }

    public void func_481_b(NBTTagCompound var1) {
        super.func_481_b(var1);
        var1.func_758_a("blockId", this.field_31021_a);
        var1.func_758_a("blockData", this.field_31019_b);
        var1.func_758_a("facing", this.field_31025_c);
        var1.func_744_a("progress", this.field_31020_l);
        var1.func_748_a("extending", this.field_31024_i);
    }
}
