package net.minecraft.src;

public final class ItemStack {
    public int field_853_a;
    public int field_852_b;
    public int field_855_c;
    private int field_854_d;

    public ItemStack(Block var1) {
        this((Block)var1, 1);
    }

    public ItemStack(Block var1, int var2) {
        this(var1.field_573_bc, var2, 0);
    }

    public ItemStack(Block var1, int var2, int var3) {
        this(var1.field_573_bc, var2, var3);
    }

    public ItemStack(Item var1) {
        this(var1.field_234_aS, 1, 0);
    }

    public ItemStack(Item var1, int var2) {
        this(var1.field_234_aS, var2, 0);
    }

    public ItemStack(Item var1, int var2, int var3) {
        this(var1.field_234_aS, var2, var3);
    }

    public ItemStack(int var1, int var2, int var3) {
        this.field_853_a = 0;
        this.field_855_c = var1;
        this.field_853_a = var2;
        this.field_854_d = var3;
    }

    public ItemStack(NBTTagCompound var1) {
        this.field_853_a = 0;
        this.func_575_b(var1);
    }

    public ItemStack func_20118_a(int var1) {
        this.field_853_a -= var1;
        return new ItemStack(this.field_855_c, var1, this.field_854_d);
    }

    public Item func_569_a() {
        return Item.field_176_c[this.field_855_c];
    }

    public boolean func_572_a(EntityPlayer var1, World var2, int var3, int var4, int var5, int var6) {
        boolean var7 = this.func_569_a().func_78_a(this, var1, var2, var3, var4, var5, var6);
        if (var7) {
            var1.func_25046_a(StatList.field_25107_A[this.field_855_c], 1);
        }

        return var7;
    }

    public float func_574_a(Block var1) {
        return this.func_569_a().func_79_a(this, var1);
    }

    public ItemStack func_6168_a(World var1, EntityPlayer var2) {
        return this.func_569_a().func_6152_a(this, var1, var2);
    }

    public NBTTagCompound func_570_a(NBTTagCompound var1) {
        var1.func_394_a("id", (short)this.field_855_c);
        var1.func_409_a("Count", (byte)this.field_853_a);
        var1.func_394_a("Damage", (short)this.field_854_d);
        return var1;
    }

    public void func_575_b(NBTTagCompound var1) {
        this.field_855_c = var1.func_406_c("id");
        this.field_853_a = var1.func_408_b("Count");
        this.field_854_d = var1.func_406_c("Damage");
    }

    public int func_576_b() {
        return this.func_569_a().func_81_a();
    }

    public boolean func_21132_c() {
        return this.func_576_b() > 1 && (!this.func_21126_d() || !this.func_21130_f());
    }

    public boolean func_21126_d() {
        return Item.field_176_c[this.field_855_c].func_77_b() > 0;
    }

    public boolean func_21128_e() {
        return Item.field_176_c[this.field_855_c].func_21092_c();
    }

    public boolean func_21130_f() {
        return this.func_21126_d() && this.field_854_d > 0;
    }

    public int func_21131_g() {
        return this.field_854_d;
    }

    public int func_21125_h() {
        return this.field_854_d;
    }

    public void func_28145_b(int var1) {
        this.field_854_d = var1;
    }

    public int func_571_c() {
        return Item.field_176_c[this.field_855_c].func_77_b();
    }

    public void func_25125_a(int var1, Entity var2) {
        if (this.func_21126_d()) {
            this.field_854_d += var1;
            if (this.field_854_d > this.func_571_c()) {
                if (var2 instanceof EntityPlayer) {
                    ((EntityPlayer)var2).func_25046_a(StatList.field_25105_B[this.field_855_c], 1);
                }

                --this.field_853_a;
                if (this.field_853_a < 0) {
                    this.field_853_a = 0;
                }

                this.field_854_d = 0;
            }

        }
    }

    public void func_9217_a(EntityLiving var1, EntityPlayer var2) {
        boolean var3 = Item.field_176_c[this.field_855_c].func_9201_a(this, var1, var2);
        if (var3) {
            var2.func_25046_a(StatList.field_25107_A[this.field_855_c], 1);
        }

    }

    public void func_25124_a(int var1, int var2, int var3, int var4, EntityPlayer var5) {
        boolean var6 = Item.field_176_c[this.field_855_c].func_25007_a(this, var1, var2, var3, var4, var5);
        if (var6) {
            var5.func_25046_a(StatList.field_25107_A[this.field_855_c], 1);
        }

    }

    public int func_9218_a(Entity var1) {
        return Item.field_176_c[this.field_855_c].func_9203_a(var1);
    }

    public boolean func_573_b(Block var1) {
        return Item.field_176_c[this.field_855_c].func_80_a(var1);
    }

    public void func_577_a(EntityPlayer var1) {
    }

    public void func_21129_b(EntityLiving var1) {
        Item.field_176_c[this.field_855_c].func_9202_b(this, var1);
    }

    public ItemStack func_578_d() {
        return new ItemStack(this.field_855_c, this.field_853_a, this.field_854_d);
    }

    public static boolean func_20119_a(ItemStack var0, ItemStack var1) {
        if (var0 == null && var1 == null) {
            return true;
        } else {
            return var0 != null && var1 != null ? var0.func_20116_b(var1) : false;
        }
    }

    private boolean func_20116_b(ItemStack var1) {
        if (this.field_853_a != var1.field_853_a) {
            return false;
        } else if (this.field_855_c != var1.field_855_c) {
            return false;
        } else {
            return this.field_854_d == var1.field_854_d;
        }
    }

    public boolean func_21127_a(ItemStack var1) {
        return this.field_855_c == var1.field_855_c && this.field_854_d == var1.field_854_d;
    }

    public static ItemStack func_20117_a(ItemStack var0) {
        return var0 == null ? null : var0.func_578_d();
    }

    public String toString() {
        return this.field_853_a + "x" + Item.field_176_c[this.field_855_c].func_20106_a() + "@" + this.field_854_d;
    }

    public void func_28143_a(World var1, Entity var2, int var3, boolean var4) {
        if (this.field_852_b > 0) {
            --this.field_852_b;
        }

        Item.field_176_c[this.field_855_c].func_28018_a(this, var1, var2, var3, var4);
    }

    public void func_28142_b(World var1, EntityPlayer var2) {
        var2.func_25046_a(StatList.field_25093_z[this.field_855_c], this.field_853_a);
        Item.field_176_c[this.field_855_c].func_28020_c(this, var1, var2);
    }

    public boolean func_28144_c(ItemStack var1) {
        return this.field_855_c == var1.field_855_c && this.field_853_a == var1.field_853_a && this.field_854_d == var1.field_854_d;
    }
}
