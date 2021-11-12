package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapelessRecipes implements IRecipe {
    private final ItemStack field_21138_a;
    private final List field_21137_b;

    public ShapelessRecipes(ItemStack var1, List var2) {
        this.field_21138_a = var1;
        this.field_21137_b = var2;
    }

    public ItemStack func_25077_b() {
        return this.field_21138_a;
    }

    public boolean func_21134_a(InventoryCrafting var1) {
        ArrayList var2 = new ArrayList(this.field_21137_b);

        for(int var3 = 0; var3 < 3; ++var3) {
            for(int var4 = 0; var4 < 3; ++var4) {
                ItemStack var5 = var1.func_21084_a(var4, var3);
                if (var5 != null) {
                    boolean var6 = false;
                    Iterator var7 = var2.iterator();

                    while(var7.hasNext()) {
                        ItemStack var8 = (ItemStack)var7.next();
                        if (var5.itemID == var8.itemID && (var8.getItemDamage() == -1 || var5.getItemDamage() == var8.getItemDamage())) {
                            var6 = true;
                            var2.remove(var8);
                            break;
                        }
                    }

                    if (!var6) {
                        return false;
                    }
                }
            }
        }

        return var2.isEmpty();
    }

    public ItemStack func_21136_b(InventoryCrafting var1) {
        return this.field_21138_a.copy();
    }

    public int getRecipeSize() {
        return this.field_21137_b.size();
    }
}
