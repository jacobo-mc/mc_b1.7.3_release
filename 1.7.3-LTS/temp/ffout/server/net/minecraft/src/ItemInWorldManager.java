package net.minecraft.src;

public class ItemInWorldManager {
    private WorldServer field_674_b;
    public EntityPlayer field_675_a;
    private float field_672_d = 0.0F;
    private int field_22055_d;
    private int field_22054_g;
    private int field_22053_h;
    private int field_22052_i;
    private int field_22051_j;
    private boolean field_22050_k;
    private int field_22049_l;
    private int field_22048_m;
    private int field_22047_n;
    private int field_22046_o;

    public ItemInWorldManager(WorldServer var1) {
        this.field_674_b = var1;
    }

    public void func_328_a() {
        ++this.field_22051_j;
        if (this.field_22050_k) {
            int var1 = this.field_22051_j - this.field_22046_o;
            int var2 = this.field_674_b.func_444_a(this.field_22049_l, this.field_22048_m, this.field_22047_n);
            if (var2 != 0) {
                Block var3 = Block.field_542_n[var2];
                float var4 = var3.func_254_a(this.field_675_a) * (float)(var1 + 1);
                if (var4 >= 1.0F) {
                    this.field_22050_k = false;
                    this.func_325_c(this.field_22049_l, this.field_22048_m, this.field_22047_n);
                }
            } else {
                this.field_22050_k = false;
            }
        }

    }

    public void func_324_a(int var1, int var2, int var3, int var4) {
        this.field_674_b.func_28096_a((EntityPlayer)null, var1, var2, var3, var4);
        this.field_22055_d = this.field_22051_j;
        int var5 = this.field_674_b.func_444_a(var1, var2, var3);
        if (var5 > 0) {
            Block.field_542_n[var5].func_235_b(this.field_674_b, var1, var2, var3, this.field_675_a);
        }

        if (var5 > 0 && Block.field_542_n[var5].func_254_a(this.field_675_a) >= 1.0F) {
            this.func_325_c(var1, var2, var3);
        } else {
            this.field_22054_g = var1;
            this.field_22053_h = var2;
            this.field_22052_i = var3;
        }

    }

    public void func_22045_b(int var1, int var2, int var3) {
        if (var1 == this.field_22054_g && var2 == this.field_22053_h && var3 == this.field_22052_i) {
            int var4 = this.field_22051_j - this.field_22055_d;
            int var5 = this.field_674_b.func_444_a(var1, var2, var3);
            if (var5 != 0) {
                Block var6 = Block.field_542_n[var5];
                float var7 = var6.func_254_a(this.field_675_a) * (float)(var4 + 1);
                if (var7 >= 0.7F) {
                    this.func_325_c(var1, var2, var3);
                } else if (!this.field_22050_k) {
                    this.field_22050_k = true;
                    this.field_22049_l = var1;
                    this.field_22048_m = var2;
                    this.field_22047_n = var3;
                    this.field_22046_o = this.field_22055_d;
                }
            }
        }

        this.field_672_d = 0.0F;
    }

    public boolean func_323_b(int var1, int var2, int var3) {
        Block var4 = Block.field_542_n[this.field_674_b.func_444_a(var1, var2, var3)];
        int var5 = this.field_674_b.func_446_b(var1, var2, var3);
        boolean var6 = this.field_674_b.func_508_d(var1, var2, var3, 0);
        if (var4 != null && var6) {
            var4.func_251_a(this.field_674_b, var1, var2, var3, var5);
        }

        return var6;
    }

    public boolean func_325_c(int var1, int var2, int var3) {
        int var4 = this.field_674_b.func_444_a(var1, var2, var3);
        int var5 = this.field_674_b.func_446_b(var1, var2, var3);
        this.field_674_b.func_28101_a(this.field_675_a, 2001, var1, var2, var3, var4 + this.field_674_b.func_446_b(var1, var2, var3) * 256);
        boolean var6 = this.func_323_b(var1, var2, var3);
        ItemStack var7 = this.field_675_a.func_172_B();
        if (var7 != null) {
            var7.func_25124_a(var4, var1, var2, var3, this.field_675_a);
            if (var7.field_853_a == 0) {
                var7.func_577_a(this.field_675_a);
                this.field_675_a.func_164_C();
            }
        }

        if (var6 && this.field_675_a.func_167_b(Block.field_542_n[var4])) {
            Block.field_542_n[var4].func_12007_g(this.field_674_b, this.field_675_a, var1, var2, var3, var5);
            ((EntityPlayerMP)this.field_675_a).field_20908_a.func_39_b(new Packet53BlockChange(var1, var2, var3, this.field_674_b));
        }

        return var6;
    }

    public boolean func_6154_a(EntityPlayer var1, World var2, ItemStack var3) {
        int var4 = var3.field_853_a;
        ItemStack var5 = var3.func_6168_a(var2, var1);
        if (var5 != var3 || var5 != null && var5.field_853_a != var4) {
            var1.field_416_aj.field_496_a[var1.field_416_aj.field_499_d] = var5;
            if (var5.field_853_a == 0) {
                var1.field_416_aj.field_496_a[var1.field_416_aj.field_499_d] = null;
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean func_327_a(EntityPlayer var1, World var2, ItemStack var3, int var4, int var5, int var6, int var7) {
        int var8 = var2.func_444_a(var4, var5, var6);
        if (var8 > 0 && Block.field_542_n[var8].func_246_a(var2, var4, var5, var6, var1)) {
            return true;
        } else {
            return var3 == null ? false : var3.func_572_a(var1, var2, var4, var5, var6, var7);
        }
    }
}
