package net.minecraft.src;

public class Achievement extends StatBase {
    public final int displayColumn;
    public final int displayRow;
    public final Achievement parentAchievement;
    private final String achievementDescription;
    private IStatStringFormat statStringFormatter;
    public final ItemStack theItemStack;
    private boolean isSpecial;

    public Achievement(int var1, String var2, int var3, int var4, Item var5, Achievement var6) {
        this(var1, var2, var3, var4, new ItemStack(var5), var6);
    }

    public Achievement(int var1, String var2, int var3, int var4, Block var5, Achievement var6) {
        this(var1, var2, var3, var4, new ItemStack(var5), var6);
    }

    public Achievement(int var1, String var2, int var3, int var4, ItemStack var5, Achievement var6) {
        super(5242880 + var1, StatCollector.translateToLocal("achievement." + var2));
        this.theItemStack = var5;
        this.achievementDescription = StatCollector.translateToLocal("achievement." + var2 + ".desc");
        this.displayColumn = var3;
        this.displayRow = var4;
        if (var3 < AchievementList.minDisplayColumn) {
            AchievementList.minDisplayColumn = var3;
        }

        if (var4 < AchievementList.minDisplayRow) {
            AchievementList.minDisplayRow = var4;
        }

        if (var3 > AchievementList.maxDisplayColumn) {
            AchievementList.maxDisplayColumn = var3;
        }

        if (var4 > AchievementList.maxDisplayRow) {
            AchievementList.maxDisplayRow = var4;
        }

        this.parentAchievement = var6;
    }

    public Achievement setIndependent() {
        this.isIndependent = true;
        return this;
    }

    public Achievement setSpecial() {
        this.isSpecial = true;
        return this;
    }

    public Achievement registerAchievement() {
        super.registerStat();
        AchievementList.achievementList.add(this);
        return this;
    }

    public boolean isAchievement() {
        return true;
    }

    public String getDescription() {
        return this.statStringFormatter != null ? this.statStringFormatter.formatString(this.achievementDescription) : this.achievementDescription;
    }

    public Achievement setStatStringFormatter(IStatStringFormat var1) {
        this.statStringFormatter = var1;
        return this;
    }

    public boolean getSpecial() {
        return this.isSpecial;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public StatBase registerStat() {
        return this.registerAchievement();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public StatBase initIndependentStat() {
        return this.setIndependent();
    }
}
