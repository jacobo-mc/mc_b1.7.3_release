package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Container {
    public List field_20136_d = new ArrayList();
    public List field_20135_e = new ArrayList();
    public int field_20134_f = 0;
    private short field_20132_a = 0;
    protected List field_20133_g = new ArrayList();
    private Set field_20131_b = new HashSet();

    protected void func_20122_a(Slot var1) {
        var1.field_20100_c = this.field_20135_e.size();
        this.field_20135_e.add(var1);
        this.field_20136_d.add((Object)null);
    }

    public void func_20128_a(ICrafting var1) {
        if (this.field_20133_g.contains(var1)) {
            throw new IllegalArgumentException("Listener already listening");
        } else {
            this.field_20133_g.add(var1);
            var1.func_20054_a(this, this.func_28127_b());
            this.func_20125_a();
        }
    }

    public List func_28127_b() {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < this.field_20135_e.size(); ++var2) {
            var1.add(((Slot)this.field_20135_e.get(var2)).func_20092_c());
        }

        return var1;
    }

    public void func_20125_a() {
        for(int var1 = 0; var1 < this.field_20135_e.size(); ++var1) {
            ItemStack var2 = ((Slot)this.field_20135_e.get(var1)).func_20092_c();
            ItemStack var3 = (ItemStack)this.field_20136_d.get(var1);
            if (!ItemStack.func_20119_a(var3, var2)) {
                var3 = var2 == null ? null : var2.func_578_d();
                this.field_20136_d.set(var1, var3);

                for(int var4 = 0; var4 < this.field_20133_g.size(); ++var4) {
                    ((ICrafting)this.field_20133_g.get(var4)).func_20055_a(this, var1, var3);
                }
            }
        }

    }

    public Slot func_20127_a(IInventory var1, int var2) {
        for(int var3 = 0; var3 < this.field_20135_e.size(); ++var3) {
            Slot var4 = (Slot)this.field_20135_e.get(var3);
            if (var4.func_20090_a(var1, var2)) {
                return var4;
            }
        }

        return null;
    }

    public Slot func_20120_a(int var1) {
        return (Slot)this.field_20135_e.get(var1);
    }

    public ItemStack func_27086_a(int var1) {
        Slot var2 = (Slot)this.field_20135_e.get(var1);
        return var2 != null ? var2.func_20092_c() : null;
    }

    public ItemStack func_27085_a(int var1, int var2, boolean var3, EntityPlayer var4) {
        ItemStack var5 = null;
        if (var2 == 0 || var2 == 1) {
            InventoryPlayer var6 = var4.field_416_aj;
            if (var1 == -999) {
                if (var6.func_20072_i() != null && var1 == -999) {
                    if (var2 == 0) {
                        var4.func_20044_b(var6.func_20072_i());
                        var6.func_20073_b((ItemStack)null);
                    }

                    if (var2 == 1) {
                        var4.func_20044_b(var6.func_20072_i().func_20118_a(1));
                        if (var6.func_20072_i().field_853_a == 0) {
                            var6.func_20073_b((ItemStack)null);
                        }
                    }
                }
            } else {
                int var10;
                if (var3) {
                    ItemStack var7 = this.func_27086_a(var1);
                    if (var7 != null) {
                        int var8 = var7.field_853_a;
                        var5 = var7.func_578_d();
                        Slot var9 = (Slot)this.field_20135_e.get(var1);
                        if (var9 != null && var9.func_20092_c() != null) {
                            var10 = var9.func_20092_c().field_853_a;
                            if (var10 < var8) {
                                this.func_27085_a(var1, var2, var3, var4);
                            }
                        }
                    }
                } else {
                    Slot var12 = (Slot)this.field_20135_e.get(var1);
                    if (var12 != null) {
                        var12.func_20094_d();
                        ItemStack var13 = var12.func_20092_c();
                        ItemStack var14 = var6.func_20072_i();
                        if (var13 != null) {
                            var5 = var13.func_578_d();
                        }

                        if (var13 == null) {
                            if (var14 != null && var12.func_20095_a(var14)) {
                                var10 = var2 == 0 ? var14.field_853_a : 1;
                                if (var10 > var12.func_20093_a()) {
                                    var10 = var12.func_20093_a();
                                }

                                var12.func_20089_b(var14.func_20118_a(var10));
                                if (var14.field_853_a == 0) {
                                    var6.func_20073_b((ItemStack)null);
                                }
                            }
                        } else if (var14 == null) {
                            var10 = var2 == 0 ? var13.field_853_a : (var13.field_853_a + 1) / 2;
                            ItemStack var11 = var12.func_20088_a(var10);
                            var6.func_20073_b(var11);
                            if (var13.field_853_a == 0) {
                                var12.func_20089_b((ItemStack)null);
                            }

                            var12.func_20091_b(var6.func_20072_i());
                        } else if (var12.func_20095_a(var14)) {
                            if (var13.field_855_c == var14.field_855_c && (!var13.func_21128_e() || var13.func_21125_h() == var14.func_21125_h())) {
                                var10 = var2 == 0 ? var14.field_853_a : 1;
                                if (var10 > var12.func_20093_a() - var13.field_853_a) {
                                    var10 = var12.func_20093_a() - var13.field_853_a;
                                }

                                if (var10 > var14.func_576_b() - var13.field_853_a) {
                                    var10 = var14.func_576_b() - var13.field_853_a;
                                }

                                var14.func_20118_a(var10);
                                if (var14.field_853_a == 0) {
                                    var6.func_20073_b((ItemStack)null);
                                }

                                var13.field_853_a += var10;
                            } else if (var14.field_853_a <= var12.func_20093_a()) {
                                var12.func_20089_b(var14);
                                var6.func_20073_b(var13);
                            }
                        } else if (var13.field_855_c == var14.field_855_c && var14.func_576_b() > 1 && (!var13.func_21128_e() || var13.func_21125_h() == var14.func_21125_h())) {
                            var10 = var13.field_853_a;
                            if (var10 > 0 && var10 + var14.field_853_a <= var14.func_576_b()) {
                                var14.field_853_a += var10;
                                var13.func_20118_a(var10);
                                if (var13.field_853_a == 0) {
                                    var12.func_20089_b((ItemStack)null);
                                }

                                var12.func_20091_b(var6.func_20072_i());
                            }
                        }
                    }
                }
            }
        }

        return var5;
    }

    public void func_20130_a(EntityPlayer var1) {
        InventoryPlayer var2 = var1.field_416_aj;
        if (var2.func_20072_i() != null) {
            var1.func_20044_b(var2.func_20072_i());
            var2.func_20073_b((ItemStack)null);
        }

    }

    public void func_20121_a(IInventory var1) {
        this.func_20125_a();
    }

    public boolean func_20124_c(EntityPlayer var1) {
        return !this.field_20131_b.contains(var1);
    }

    public void func_20129_a(EntityPlayer var1, boolean var2) {
        if (var2) {
            this.field_20131_b.remove(var1);
        } else {
            this.field_20131_b.add(var1);
        }

    }

    public abstract boolean func_20126_b(EntityPlayer var1);

    protected void func_28126_a(ItemStack var1, int var2, int var3, boolean var4) {
        int var5 = var2;
        if (var4) {
            var5 = var3 - 1;
        }

        Slot var6;
        ItemStack var7;
        if (var1.func_21132_c()) {
            while(var1.field_853_a > 0 && (!var4 && var5 < var3 || var4 && var5 >= var2)) {
                var6 = (Slot)this.field_20135_e.get(var5);
                var7 = var6.func_20092_c();
                if (var7 != null && var7.field_855_c == var1.field_855_c && (!var1.func_21128_e() || var1.func_21125_h() == var7.func_21125_h())) {
                    int var8 = var7.field_853_a + var1.field_853_a;
                    if (var8 <= var1.func_576_b()) {
                        var1.field_853_a = 0;
                        var7.field_853_a = var8;
                        var6.func_20094_d();
                    } else if (var7.field_853_a < var1.func_576_b()) {
                        var1.field_853_a -= var1.func_576_b() - var7.field_853_a;
                        var7.field_853_a = var1.func_576_b();
                        var6.func_20094_d();
                    }
                }

                if (var4) {
                    --var5;
                } else {
                    ++var5;
                }
            }
        }

        if (var1.field_853_a > 0) {
            if (var4) {
                var5 = var3 - 1;
            } else {
                var5 = var2;
            }

            while(!var4 && var5 < var3 || var4 && var5 >= var2) {
                var6 = (Slot)this.field_20135_e.get(var5);
                var7 = var6.func_20092_c();
                if (var7 == null) {
                    var6.func_20089_b(var1.func_578_d());
                    var6.func_20094_d();
                    var1.field_853_a = 0;
                    break;
                }

                if (var4) {
                    --var5;
                } else {
                    ++var5;
                }
            }
        }

    }
}
