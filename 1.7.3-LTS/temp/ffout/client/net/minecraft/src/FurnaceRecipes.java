package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes {
    private static final FurnaceRecipes field_21202_a = new FurnaceRecipes();
    private Map field_21201_b = new HashMap();

    public static final FurnaceRecipes func_21200_a() {
        return field_21202_a;
    }

    private FurnaceRecipes() {
        this.func_21199_a(Block.field_388_I.field_376_bc, new ItemStack(Item.field_223_m));
        this.func_21199_a(Block.field_390_H.field_376_bc, new ItemStack(Item.field_222_n));
        this.func_21199_a(Block.field_391_ax.field_376_bc, new ItemStack(Item.field_224_l));
        this.func_21199_a(Block.field_393_F.field_376_bc, new ItemStack(Block.field_382_N));
        this.func_21199_a(Item.field_272_ao.field_291_aS, new ItemStack(Item.field_4017_ap));
        this.func_21199_a(Item.field_4021_aS.field_291_aS, new ItemStack(Item.field_4020_aT));
        this.func_21199_a(Block.field_335_x.field_376_bc, new ItemStack(Block.field_338_u));
        this.func_21199_a(Item.field_303_aG.field_291_aS, new ItemStack(Item.field_4030_aF));
        this.func_21199_a(Block.field_425_aW.field_376_bc, new ItemStack(Item.field_21021_aU, 1, 2));
        this.func_21199_a(Block.field_385_K.field_376_bc, new ItemStack(Item.field_225_k, 1, 1));
    }

    public void func_21199_a(int var1, ItemStack var2) {
        this.field_21201_b.put(var1, var2);
    }

    public ItemStack func_21198_a(int var1) {
        return (ItemStack)this.field_21201_b.get(var1);
    }

    public Map func_25194_b() {
        return this.field_21201_b;
    }
}
