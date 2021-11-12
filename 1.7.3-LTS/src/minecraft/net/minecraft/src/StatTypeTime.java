package net.minecraft.src;

final class StatTypeTime implements IStatType {
    public String format(int var1) {
        double var2 = (double)var1 / 20.0D;
        double var4 = var2 / 60.0D;
        double var6 = var4 / 60.0D;
        double var8 = var6 / 24.0D;
        double var10 = var8 / 365.0D;
        if (var10 > 0.5D) {
            return StatBase.func_27081_j().format(var10) + " y";
        } else if (var8 > 0.5D) {
            return StatBase.func_27081_j().format(var8) + " d";
        } else if (var6 > 0.5D) {
            return StatBase.func_27081_j().format(var6) + " h";
        } else {
            return var4 > 0.5D ? StatBase.func_27081_j().format(var4) + " m" : var2 + " s";
        }
    }
}
