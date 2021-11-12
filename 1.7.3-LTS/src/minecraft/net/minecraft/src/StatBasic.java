package net.minecraft.src;

public class StatBasic extends StatBase {
    public StatBasic(int var1, String var2, IStatType var3) {
        super(var1, var2, var3);
    }

    public StatBasic(int var1, String var2) {
        super(var1, var2);
    }

    public StatBase registerStat() {
        super.registerStat();
        StatList.generalStats.add(this);
        return this;
    }
}
