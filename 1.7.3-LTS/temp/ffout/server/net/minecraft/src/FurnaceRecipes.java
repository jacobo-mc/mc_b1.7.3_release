package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes {
    private static final FurnaceRecipes field_21164_a = new FurnaceRecipes();
    private Map field_21163_b = new HashMap();

    public static final FurnaceRecipes func_21162_a() {
        return field_21164_a;
    }

    private FurnaceRecipes() {
        this.func_21160_a(Block.field_4059_I.field_573_bc, new ItemStack(Item.field_166_m));
        this.func_21160_a(Block.field_4061_H.field_573_bc, new ItemStack(Item.field_4147_n));
        this.func_21160_a(Block.field_588_ax.field_573_bc, new ItemStack(Item.field_167_l));
        this.func_21160_a(Block.field_590_F.field_573_bc, new ItemStack(Block.field_4056_N));
        this.func_21160_a(Item.field_215_ao.field_234_aS, new ItemStack(Item.field_4176_ap));
        this.func_21160_a(Item.field_4193_aS.field_234_aS, new ItemStack(Item.field_4192_aT));
        this.func_21160_a(Block.field_532_x.field_573_bc, new ItemStack(Block.field_535_u));
        this.func_21160_a(Item.field_246_aG.field_234_aS, new ItemStack(Item.field_4203_aF));
        this.func_21160_a(Block.field_622_aW.field_573_bc, new ItemStack(Item.field_21097_aU, 1, 2));
        this.func_21160_a(Block.field_582_K.field_573_bc, new ItemStack(Item.field_168_k, 1, 1));
    }

    public void func_21160_a(int var1, ItemStack var2) {
        this.field_21163_b.put(var1, var2);
    }

    public ItemStack func_21161_a(int var1) {
        return (ItemStack)this.field_21163_b.get(var1);
    }

    public Map func_25127_b() {
        return this.field_21163_b;
    }
}
