package net.minecraft.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class StatBase {
    public final int field_25063_d;
    public final String field_25062_e;
    public boolean field_27058_g;
    public String field_27057_h;
    private final IStatType field_25065_a;
    private static NumberFormat field_25066_b;
    public static IStatType field_27056_i;
    private static DecimalFormat field_25068_c;
    public static IStatType field_27055_j;
    public static IStatType field_27054_k;

    public StatBase(int var1, String var2, IStatType var3) {
        this.field_27058_g = false;
        this.field_25063_d = var1;
        this.field_25062_e = var2;
        this.field_25065_a = var3;
    }

    public StatBase(int var1, String var2) {
        this(var1, var2, field_27056_i);
    }

    public StatBase func_27052_e() {
        this.field_27058_g = true;
        return this;
    }

    public StatBase func_27053_d() {
        if (StatList.field_25104_C.containsKey(this.field_25063_d)) {
            throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.field_25104_C.get(this.field_25063_d)).field_25062_e + "\" and \"" + this.field_25062_e + "\" at id " + this.field_25063_d);
        } else {
            StatList.field_25123_a.add(this);
            StatList.field_25104_C.put(this.field_25063_d, this);
            this.field_27057_h = AchievementMap.func_25132_a(this.field_25063_d);
            return this;
        }
    }

    public String toString() {
        return this.field_25062_e;
    }

    static {
        field_25066_b = NumberFormat.getIntegerInstance(Locale.US);
        field_27056_i = new StatTypeSimple();
        field_25068_c = new DecimalFormat("########0.00");
        field_27055_j = new StatTypeTime();
        field_27054_k = new StatTypeDistance();
    }
}
