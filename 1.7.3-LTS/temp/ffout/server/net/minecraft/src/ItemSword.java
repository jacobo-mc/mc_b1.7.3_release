package net.minecraft.src;

public class ItemSword extends Item {
    private int field_4210_a;

    public ItemSword(int var1, EnumToolMaterial var2) {
        super(var1);
        this.field_233_aT = 1;
        this.func_21090_d(var2.func_21180_a());
        this.field_4210_a = 4 + var2.func_21178_c() * 2;
    }

    public float func_79_a(ItemStack var1, Block var2) {
        return var2.field_573_bc == Block.field_9032_W.field_573_bc ? 15.0F : 1.5F;
    }

    public boolean func_9201_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        var1.func_25125_a(1, var3);
        return true;
    }

    public boolean func_25007_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        var1.func_25125_a(2, var6);
        return true;
    }

    public int func_9203_a(Entity var1) {
        return this.field_4210_a;
    }

    public boolean func_80_a(Block var1) {
        return var1.field_573_bc == Block.field_9032_W.field_573_bc;
    }
}
