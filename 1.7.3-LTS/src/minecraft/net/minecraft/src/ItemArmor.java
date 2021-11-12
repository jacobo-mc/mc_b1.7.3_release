package net.minecraft.src;

public class ItemArmor extends Item {
    private static final int[] damageReduceAmountArray = new int[]{3, 8, 6, 3};
    private static final int[] maxDamageArray = new int[]{11, 16, 15, 13};
    public final int armorLevel;
    public final int armorType;
    public final int damageReduceAmount;
    public final int renderIndex;

    public ItemArmor(int var1, int var2, int var3, int var4) {
        super(var1);
        this.armorLevel = var2;
        this.armorType = var4;
        this.renderIndex = var3;
        this.damageReduceAmount = damageReduceAmountArray[var4];
        this.setMaxDamage(maxDamageArray[var4] * 3 << var2);
        this.maxStackSize = 1;
    }
}
