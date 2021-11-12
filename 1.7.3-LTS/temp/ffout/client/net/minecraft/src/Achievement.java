package net.minecraft.src;

public class Achievement extends StatBase {
    public final int field_25075_a;
    public final int field_25074_b;
    public final Achievement field_25076_c;
    private final String field_27096_l;
    private IStatStringFormat field_27095_m;
    public final ItemStack field_27097_d;
    private boolean field_27098_n;

    public Achievement(int var1, String var2, int var3, int var4, Item var5, Achievement var6) {
        this(var1, var2, var3, var4, new ItemStack(var5), var6);
    }

    public Achievement(int var1, String var2, int var3, int var4, Block var5, Achievement var6) {
        this(var1, var2, var3, var4, new ItemStack(var5), var6);
    }

    public Achievement(int var1, String var2, int var3, int var4, ItemStack var5, Achievement var6) {
        super(5242880 + var1, StatCollector.func_25200_a("achievement." + var2));
        this.field_27097_d = var5;
        this.field_27096_l = StatCollector.func_25200_a("achievement." + var2 + ".desc");
        this.field_25075_a = var3;
        this.field_25074_b = var4;
        if (var3 < AchievementList.field_27392_a) {
            AchievementList.field_27392_a = var3;
        }

        if (var4 < AchievementList.field_27391_b) {
            AchievementList.field_27391_b = var4;
        }

        if (var3 > AchievementList.field_27390_c) {
            AchievementList.field_27390_c = var3;
        }

        if (var4 > AchievementList.field_27389_d) {
            AchievementList.field_27389_d = var4;
        }

        this.field_25076_c = var6;
    }

    public Achievement func_27089_a() {
        this.field_27088_g = true;
        return this;
    }

    public Achievement func_27094_b() {
        this.field_27098_n = true;
        return this;
    }

    public Achievement func_27091_c() {
        super.func_25068_c();
        AchievementList.field_27388_e.add(this);
        return this;
    }

    public boolean func_25067_a() {
        return true;
    }

    public String func_27090_e() {
        return this.field_27095_m != null ? this.field_27095_m.func_27343_a(this.field_27096_l) : this.field_27096_l;
    }

    public Achievement func_27092_a(IStatStringFormat var1) {
        this.field_27095_m = var1;
        return this;
    }

    public boolean func_27093_f() {
        return this.field_27098_n;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public StatBase func_25068_c() {
        return this.func_27091_c();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public StatBase func_27082_h() {
        return this.func_27089_a();
    }
}
