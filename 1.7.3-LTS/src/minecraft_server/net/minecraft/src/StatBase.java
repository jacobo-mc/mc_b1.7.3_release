package net.minecraft.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class StatBase {
    public final int statId;
    public final String statName;
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
        this.statId = var1;
        this.statName = var2;
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
        if (StatList.field_25104_C.containsKey(this.statId)) {
            throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.field_25104_C.get(this.statId)).statName + "\" and \"" + this.statName + "\" at id " + this.statId);
        } else {
            StatList.field_25123_a.add(this);
            StatList.field_25104_C.put(this.statId, this);
            this.field_27057_h = AchievementMap.func_25132_a(this.statId);
            return this;
        }
    }

    public String toString() {
        return this.statName;
    }

    static {
        field_25066_b = NumberFormat.getIntegerInstance(Locale.US);
        field_27056_i = new StatTypeSimple();
        field_25068_c = new DecimalFormat("########0.00");
        field_27055_j = new StatTypeTime();
        field_27054_k = new StatTypeDistance();
    }
}
