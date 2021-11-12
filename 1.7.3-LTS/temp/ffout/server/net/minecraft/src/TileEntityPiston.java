package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TileEntityPiston extends TileEntity {
    private int field_31016_a;
    private int field_31014_b;
    private int field_31020_c;
    private boolean field_31019_i;
    private boolean field_31018_j;
    private float field_31017_k;
    private float field_31015_l;
    private static List field_31013_m = new ArrayList();

    public TileEntityPiston() {
    }

    public TileEntityPiston(int var1, int var2, int var3, boolean var4, boolean var5) {
        this.field_31016_a = var1;
        this.field_31014_b = var2;
        this.field_31020_c = var3;
        this.field_31019_i = var4;
        this.field_31018_j = var5;
    }

    public int func_31012_a() {
        return this.field_31016_a;
    }

    public int func_31005_e() {
        return this.field_31014_b;
    }

    public boolean func_31010_c() {
        return this.field_31019_i;
    }

    public int func_31008_d() {
        return this.field_31020_c;
    }

    public float func_31007_a(float var1) {
        if (var1 > 1.0F) {
            var1 = 1.0F;
        }

        return this.field_31015_l + (this.field_31017_k - this.field_31015_l) * var1;
    }

    private void func_31009_a(float var1, float var2) {
        if (!this.field_31019_i) {
            --var1;
        } else {
            var1 = 1.0F - var1;
        }

        AxisAlignedBB var3 = Block.field_9048_ac.func_31032_a(this.field_479_a, this.field_478_b, this.field_483_c, this.field_482_d, this.field_31016_a, var1, this.field_31020_c);
        if (var3 != null) {
            List var4 = this.field_479_a.func_450_b((Entity)null, var3);
            if (!var4.isEmpty()) {
                field_31013_m.addAll(var4);
                Iterator var5 = field_31013_m.iterator();

                while(var5.hasNext()) {
                    Entity var6 = (Entity)var5.next();
                    var6.func_88_c((double)(var2 * (float)PistonBlockTextures.field_31051_b[this.field_31020_c]), (double)(var2 * (float)PistonBlockTextures.field_31054_c[this.field_31020_c]), (double)(var2 * (float)PistonBlockTextures.field_31053_d[this.field_31020_c]));
                }

                field_31013_m.clear();
            }
        }

    }

    public void func_31011_k() {
        if (this.field_31015_l < 1.0F) {
            this.field_31015_l = this.field_31017_k = 1.0F;
            this.field_479_a.func_513_l(this.field_478_b, this.field_483_c, this.field_482_d);
            this.func_31003_h();
            if (this.field_479_a.func_444_a(this.field_478_b, this.field_483_c, this.field_482_d) == Block.field_9048_ac.field_573_bc) {
                this.field_479_a.func_507_b(this.field_478_b, this.field_483_c, this.field_482_d, this.field_31016_a, this.field_31014_b);
            }
        }

    }

    public void func_184_b() {
        this.field_31015_l = this.field_31017_k;
        if (this.field_31015_l >= 1.0F) {
            this.func_31009_a(1.0F, 0.25F);
            this.field_479_a.func_513_l(this.field_478_b, this.field_483_c, this.field_482_d);
            this.func_31003_h();
            if (this.field_479_a.func_444_a(this.field_478_b, this.field_483_c, this.field_482_d) == Block.field_9048_ac.field_573_bc) {
                this.field_479_a.func_507_b(this.field_478_b, this.field_483_c, this.field_482_d, this.field_31016_a, this.field_31014_b);
            }

        } else {
            this.field_31017_k += 0.5F;
            if (this.field_31017_k >= 1.0F) {
                this.field_31017_k = 1.0F;
            }

            if (this.field_31019_i) {
                this.func_31009_a(this.field_31017_k, this.field_31017_k - this.field_31015_l + 0.0625F);
            }

        }
    }

    public void func_186_a(NBTTagCompound var1) {
        super.func_186_a(var1);
        this.field_31016_a = var1.func_395_d("blockId");
        this.field_31014_b = var1.func_395_d("blockData");
        this.field_31020_c = var1.func_395_d("facing");
        this.field_31015_l = this.field_31017_k = var1.func_389_f("progress");
        this.field_31019_i = var1.func_402_l("extending");
    }

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        var1.func_405_a("blockId", this.field_31016_a);
        var1.func_405_a("blockData", this.field_31014_b);
        var1.func_405_a("facing", this.field_31020_c);
        var1.func_390_a("progress", this.field_31015_l);
        var1.func_393_a("extending", this.field_31019_i);
    }
}
