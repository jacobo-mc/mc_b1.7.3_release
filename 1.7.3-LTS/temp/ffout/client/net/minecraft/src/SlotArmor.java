package net.minecraft.src;

class SlotArmor extends Slot {
    // $FF: synthetic field
    final int field_1124_c;
    // $FF: synthetic field
    final ContainerPlayer field_1123_d;

    SlotArmor(ContainerPlayer var1, IInventory var2, int var3, int var4, int var5, int var6) {
        super(var2, var3, var4, var5);
        this.field_1123_d = var1;
        this.field_1124_c = var6;
    }

    public int func_4104_e() {
        return 1;
    }

    public boolean func_4105_a(ItemStack var1) {
        if (var1.func_1091_a() instanceof ItemArmor) {
            return ((ItemArmor)var1.func_1091_a()).field_313_aX == this.field_1124_c;
        } else if (var1.func_1091_a().field_291_aS == Block.field_4055_bb.field_376_bc) {
            return this.field_1124_c == 0;
        } else {
            return false;
        }
    }
}
