package net.minecraft.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class StatBase {
    public final int statId;
    public final String statName;
    public boolean isIndependent;
    public String statGuid;
    private final IStatType field_26902_a;
    private static NumberFormat field_26903_b;
    public static IStatType field_27087_i;
    private static DecimalFormat field_26904_c;
    public static IStatType timeStatType;
    public static IStatType distanceStatType;

    public StatBase(int var1, String var2, IStatType var3) {
        this.isIndependent = false;
        this.statId = var1;
        this.statName = var2;
        this.field_26902_a = var3;
    }

    public StatBase(int var1, String var2) {
        this(var1, var2, field_27087_i);
    }

    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }

    public StatBase registerStat() {
        if (StatList.oneShotStats.containsKey(this.statId)) {
            throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.oneShotStats.get(this.statId)).statName + "\" and \"" + this.statName + "\" at id " + this.statId);
        } else {
            StatList.field_25188_a.add(this);
            StatList.oneShotStats.put(this.statId, this);
            this.statGuid = AchievementMap.getGuid(this.statId);
            return this;
        }
    }

    public boolean isAchievement() {
        return false;
    }

    public String func_27084_a(int var1) {
        return this.field_26902_a.format(var1);
    }

    public String toString() {
        return this.statName;
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
        timeStatType = new StatTypeTime();
        distanceStatType = new StatTypeDistance();
    }
}
