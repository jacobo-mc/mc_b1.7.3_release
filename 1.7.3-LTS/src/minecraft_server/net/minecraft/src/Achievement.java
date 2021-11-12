package net.minecraft.src;

public class Achievement extends StatBase {
    public final int field_25067_a;
    public final int field_27991_b;
    public final Achievement field_27992_c;
    private final String field_27063_l;
    public final ItemStack theItemStack;
    private boolean field_27062_m;

    public Achievement(int var1, String var2, int var3, int var4, Item var5, Achievement var6) {
        this(var1, var2, var3, var4, new ItemStack(var5), var6);
    }

    public Achievement(int var1, String var2, int var3, int var4, Block var5, Achievement var6) {
        this(var1, var2, var3, var4, new ItemStack(var5), var6);
    }

    public Achievement(int var1, String var2, int var3, int var4, ItemStack var5, Achievement var6) {
        super(5242880 + var1, StatCollector.translateToLocal("achievement." + var2));
        this.theItemStack = var5;
        this.field_27063_l = StatCollector.translateToLocal("achievement." + var2 + ".desc");
        this.field_25067_a = var3;
        this.field_27991_b = var4;
        if (var3 < AchievementList.field_27114_a) {
            AchievementList.field_27114_a = var3;
        }

        if (var4 < AchievementList.field_27113_b) {
            AchievementList.field_27113_b = var4;
        }

        if (var3 > AchievementList.field_27112_c) {
            AchievementList.field_27112_c = var3;
        }

        if (var4 > AchievementList.field_27111_d) {
            AchievementList.field_27111_d = var4;
        }

        this.field_27992_c = var6;
    }

    public Achievement func_27059_a() {
        this.field_27058_g = true;
        return this;
    }

    public Achievement func_27060_b() {
        this.field_27062_m = true;
        return this;
    }

    public Achievement func_27061_c() {
        super.func_27053_d();
        AchievementList.field_25129_a.add(this);
        return this;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public StatBase func_27053_d() {
        return this.func_27061_c();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public StatBase func_27052_e() {
        return this.func_27059_a();
    }
}
