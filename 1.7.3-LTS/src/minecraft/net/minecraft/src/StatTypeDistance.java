package net.minecraft.src;

final class StatTypeDistance implements IStatType {
    public String format(int var1) {
        double var3 = (double)var1 / 100.0D;
        double var5 = var3 / 1000.0D;
        if (var5 > 0.5D) {
            return StatBase.func_27081_j().format(var5) + " km";
        } else {
            return var3 > 0.5D ? StatBase.func_27081_j().format(var3) + " m" : var1 + " cm";
        }
    }
}
