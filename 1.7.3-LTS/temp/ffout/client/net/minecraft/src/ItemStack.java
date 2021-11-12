package net.minecraft.src;

public final class ItemStack {
    public int field_1615_a;
    public int field_1614_b;
    public int field_1617_c;
    private int field_1616_d;

    public ItemStack(Block var1) {
        this((Block)var1, 1);
    }

    public ItemStack(Block var1, int var2) {
        this(var1.field_376_bc, var2, 0);
    }

    public ItemStack(Block var1, int var2, int var3) {
        this(var1.field_376_bc, var2, var3);
    }

    public ItemStack(Item var1) {
        this(var1.field_291_aS, 1, 0);
    }

    public ItemStack(Item var1, int var2) {
        this(var1.field_291_aS, var2, 0);
    }

    public ItemStack(Item var1, int var2, int var3) {
        this(var1.field_291_aS, var2, var3);
    }

    public ItemStack(int var1, int var2, int var3) {
        this.field_1615_a = 0;
        this.field_1617_c = var1;
        this.field_1615_a = var2;
        this.field_1616_d = var3;
    }

    public ItemStack(NBTTagCompound var1) {
        this.field_1615_a = 0;
        this.func_1096_b(var1);
    }

    public ItemStack func_1085_a(int var1) {
        this.field_1615_a -= var1;
        return new ItemStack(this.field_1617_c, var1, this.field_1616_d);
    }

    public Item func_1091_a() {
        return Item.field_233_c[this.field_1617_c];
    }

    public int func_1088_b() {
        return this.func_1091_a().func_196_a(this);
    }

    public boolean func_1090_a(EntityPlayer var1, World var2, int var3, int var4, int var5, int var6) {
        boolean var7 = this.func_1091_a().func_192_a(this, var1, var2, var3, var4, var5, var6);
        if (var7) {
            var1.func_25058_a(StatList.field_25172_A[this.field_1617_c], 1);
        }

        return var7;
    }

    public float func_1098_a(Block var1) {
        return this.func_1091_a().func_204_a(this, var1);
    }

    public ItemStack func_1093_a(World var1, EntityPlayer var2) {
        return this.func_1091_a().func_193_a(this, var1, var2);
    }

    public NBTTagCompound func_1086_a(NBTTagCompound var1) {
        var1.func_749_a("id", (short)this.field_1617_c);
        var1.func_761_a("Count", (byte)this.field_1615_a);
        var1.func_749_a("Damage", (short)this.field_1616_d);
        return var1;
    }

    public void func_1096_b(NBTTagCompound var1) {
        this.field_1617_c = var1.func_745_d("id");
        this.field_1615_a = var1.func_746_c("Count");
        this.field_1616_d = var1.func_745_d("Damage");
    }

    public int func_1089_c() {
        return this.func_1091_a().func_200_b();
    }

    public boolean func_21180_d() {
        return this.func_1089_c() > 1 && (!this.func_21182_e() || !this.func_21185_g());
    }

    public boolean func_21182_e() {
        return Item.field_233_c[this.field_1617_c].func_197_c() > 0;
    }

    public boolean func_21183_f() {
        return Item.field_233_c[this.field_1617_c].func_21010_e();
    }

    public boolean func_21185_g() {
        return this.func_21182_e() && this.field_1616_d > 0;
    }

    public int func_21179_h() {
        return this.field_1616_d;
    }

    public int func_21181_i() {
        return this.field_1616_d;
    }

    public void func_28156_b(int var1) {
        this.field_1616_d = var1;
    }

    public int func_1094_d() {
        return Item.field_233_c[this.field_1617_c].func_197_c();
    }

    public void func_25190_a(int var1, Entity var2) {
        if (this.func_21182_e()) {
            this.field_1616_d += var1;
            if (this.field_1616_d > this.func_1094_d()) {
                if (var2 instanceof EntityPlayer) {
                    ((EntityPlayer)var2).func_25058_a(StatList.field_25170_B[this.field_1617_c], 1);
                }

                --this.field_1615_a;
                if (this.field_1615_a < 0) {
                    this.field_1615_a = 0;
                }

                this.field_1616_d = 0;
            }

        }
    }

    public void func_1092_a(EntityLiving var1, EntityPlayer var2) {
        boolean var3 = Item.field_233_c[this.field_1617_c].func_4021_a(this, var1, var2);
        if (var3) {
            var2.func_25058_a(StatList.field_25172_A[this.field_1617_c], 1);
        }

    }

    public void func_25191_a(int var1, int var2, int var3, int var4, EntityPlayer var5) {
        boolean var6 = Item.field_233_c[this.field_1617_c].func_25008_a(this, var1, var2, var3, var4, var5);
        if (var6) {
            var5.func_25058_a(StatList.field_25172_A[this.field_1617_c], 1);
        }

    }

    public int func_1095_a(Entity var1) {
        return Item.field_233_c[this.field_1617_c].func_4020_a(var1);
    }

    public boolean func_1099_b(Block var1) {
        return Item.field_233_c[this.field_1617_c].func_4018_a(var1);
    }

    public void func_1097_a(EntityPlayer var1) {
    }

    public void func_1100_b(EntityLiving var1) {
        Item.field_233_c[this.field_1617_c].func_4019_b(this, var1);
    }

    public ItemStack func_1102_e() {
        return new ItemStack(this.field_1617_c, this.field_1615_a, this.field_1616_d);
    }

    public static boolean func_20107_a(ItemStack var0, ItemStack var1) {
        if (var0 == null && var1 == null) {
            return true;
        } else {
            return var0 != null && var1 != null ? var0.func_20108_a(var1) : false;
        }
    }

    private boolean func_20108_a(ItemStack var1) {
        if (this.field_1615_a != var1.field_1615_a) {
            return false;
        } else if (this.field_1617_c != var1.field_1617_c) {
            return false;
        } else {
            return this.field_1616_d == var1.field_1616_d;
        }
    }

    public boolean func_21184_a(ItemStack var1) {
        return this.field_1617_c == var1.field_1617_c && this.field_1616_d == var1.field_1616_d;
    }

    public String func_20109_f() {
        return Item.field_233_c[this.field_1617_c].func_21011_b(this);
    }

    public static ItemStack func_30010_b(ItemStack var0) {
        return var0 == null ? null : var0.func_1102_e();
    }

    public String toString() {
        return this.field_1615_a + "x" + Item.field_233_c[this.field_1617_c].func_20009_a() + "@" + this.field_1616_d;
    }

    public void func_28153_a(World var1, Entity var2, int var3, boolean var4) {
        if (this.field_1614_b > 0) {
            --this.field_1614_b;
        }

        Item.field_233_c[this.field_1617_c].func_28008_a(this, var1, var2, var3, var4);
    }

    public void func_28155_b(World var1, EntityPlayer var2) {
        var2.func_25058_a(StatList.field_25158_z[this.field_1617_c], this.field_1615_a);
        Item.field_233_c[this.field_1617_c].func_28009_b(this, var1, var2);
    }

    public boolean func_28154_b(ItemStack var1) {
        return this.field_1617_c == var1.field_1617_c && this.field_1615_a == var1.field_1615_a && this.field_1616_d == var1.field_1616_d;
    }
}
