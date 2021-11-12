package net.minecraft.src;

public class ItemTool extends Item {
    private Block[] field_265_aX;
    private float field_264_aY = 4.0F;
    private int field_263_aZ;
    protected EnumToolMaterial field_20913_a;

    protected ItemTool(int var1, int var2, EnumToolMaterial var3, Block[] var4) {
        super(var1);
        this.field_20913_a = var3;
        this.field_265_aX = var4;
        this.field_233_aT = 1;
        this.func_21090_d(var3.func_21180_a());
        this.field_264_aY = var3.func_21179_b();
        this.field_263_aZ = var2 + var3.func_21178_c();
    }

    public float func_79_a(ItemStack var1, Block var2) {
        for(int var3 = 0; var3 < this.field_265_aX.length; ++var3) {
            if (this.field_265_aX[var3] == var2) {
                return this.field_264_aY;
            }
        }

        return 1.0F;
    }

    public boolean func_9201_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        var1.func_25125_a(2, var3);
        return true;
    }

    public boolean func_25007_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
        var1.func_25125_a(1, var6);
        return true;
    }

    public int func_9203_a(Entity var1) {
        return this.field_263_aZ;
    }
}
