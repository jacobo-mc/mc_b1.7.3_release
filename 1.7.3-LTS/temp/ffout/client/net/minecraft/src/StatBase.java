package net.minecraft.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class StatBase {
    public final int field_25071_d;
    public final String field_25070_e;
    public boolean field_27088_g;
    public String field_25069_f;
    private final IStatType field_26902_a;
    private static NumberFormat field_26903_b;
    public static IStatType field_27087_i;
    private static DecimalFormat field_26904_c;
    public static IStatType field_27086_j;
    public static IStatType field_27085_k;

    public StatBase(int var1, String var2, IStatType var3) {
        this.field_27088_g = false;
        this.field_25071_d = var1;
        this.field_25070_e = var2;
        this.field_26902_a = var3;
    }

    public StatBase(int var1, String var2) {
        this(var1, var2, field_27087_i);
    }

    public StatBase func_27082_h() {
        this.field_27088_g = true;
        return this;
    }

    public StatBase func_25068_c() {
        if (StatList.field_25169_C.containsKey(this.field_25071_d)) {
            throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.field_25169_C.get(this.field_25071_d)).field_25070_e + "\" and \"" + this.field_25070_e + "\" at id " + this.field_25071_d);
        } else {
            StatList.field_25188_a.add(this);
            StatList.field_25169_C.put(this.field_25071_d, this);
            this.field_25069_f = AchievementMap.func_25208_a(this.field_25071_d);
            return this;
        }
    }

    public boolean func_25067_a() {
        return false;
    }

    public String func_27084_a(int var1) {
        return this.field_26902_a.func_27192_a(var1);
    }

    public String toString() {
        return this.field_25070_e;
    }

    // $FF: synthetic method
    static NumberFormat func_27083_i() {
        return field_26903_b;
    }

    // $FF: synthetic method
    static DecimalFormat func_27081_j() {
        return field_26904_c;
    }

    static {
        field_26903_b = NumberFormat.getIntegerInstance(Locale.US);
        field_27087_i = new StatTypeSimple();
        field_26904_c = new DecimalFormat("########0.00");
        field_27086_j = new StatTypeTime();
        field_27085_k = new StatTypeDistance();
    }
}
