package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Container {
    public List field_20123_d = new ArrayList();
    public List field_20122_e = new ArrayList();
    public int field_1618_c = 0;
    private short field_20917_a = 0;
    protected List field_20121_g = new ArrayList();
    private Set field_20918_b = new HashSet();

    protected void func_20117_a(Slot var1) {
        var1.field_20007_a = this.field_20122_e.size();
        this.field_20122_e.add(var1);
        this.field_20123_d.add((Object)null);
    }

    public void func_20114_a() {
        for(int var1 = 0; var1 < this.field_20122_e.size(); ++var1) {
            ItemStack var2 = ((Slot)this.field_20122_e.get(var1)).func_777_b();
            ItemStack var3 = (ItemStack)this.field_20123_d.get(var1);
            if (!ItemStack.func_20107_a(var3, var2)) {
                var3 = var2 == null ? null : var2.func_1102_e();
                this.field_20123_d.set(var1, var3);

                for(int var4 = 0; var4 < this.field_20121_g.size(); ++var4) {
                    ((ICrafting)this.field_20121_g.get(var4)).func_20159_a(this, var1, var3);
                }
            }
        }

    }

    public Slot func_20118_a(int var1) {
        return (Slot)this.field_20122_e.get(var1);
    }

    public ItemStack func_27279_a(int var1) {
        Slot var2 = (Slot)this.field_20122_e.get(var1);
        return var2 != null ? var2.func_777_b() : null;
    }

    public ItemStack func_27280_a(int var1, int var2, boolean var3, EntityPlayer var4) {
        ItemStack var5 = null;
        if (var2 == 0 || var2 == 1) {
            InventoryPlayer var6 = var4.field_778_b;
            if (var1 == -999) {
                if (var6.func_20075_i() != null && var1 == -999) {
                    if (var2 == 0) {
                        var4.func_449_a(var6.func_20075_i());
                        var6.func_20076_b((ItemStack)null);
                    }

                    if (var2 == 1) {
                        var4.func_449_a(var6.func_20075_i().func_1085_a(1));
                        if (var6.func_20075_i().field_1615_a == 0) {
                            var6.func_20076_b((ItemStack)null);
                        }
                    }
                }
            } else {
                int var10;
                if (var3) {
                    ItemStack var7 = this.func_27279_a(var1);
                    if (var7 != null) {
                        int var8 = var7.field_1615_a;
                        var5 = var7.func_1102_e();
                        Slot var9 = (Slot)this.field_20122_e.get(var1);
                        if (var9 != null && var9.func_777_b() != null) {
                            var10 = var9.func_777_b().field_1615_a;
                            if (var10 < var8) {
                                this.func_27280_a(var1, var2, var3, var4);
                            }
                        }
                    }
                } else {
                    Slot var12 = (Slot)this.field_20122_e.get(var1);
                    if (var12 != null) {
                        var12.func_779_d();
                        ItemStack var13 = var12.func_777_b();
                        ItemStack var14 = var6.func_20075_i();
                        if (var13 != null) {
                            var5 = var13.func_1102_e();
                        }

                        if (var13 == null) {
                            if (var14 != null && var12.func_4105_a(var14)) {
                                var10 = var2 == 0 ? var14.field_1615_a : 1;
                                if (var10 > var12.func_4104_e()) {
                                    var10 = var12.func_4104_e();
                                }

                                var12.func_776_b(var14.func_1085_a(var10));
                                if (var14.field_1615_a == 0) {
                                    var6.func_20076_b((ItemStack)null);
                                }
                            }
                        } else if (var14 == null) {
                            var10 = var2 == 0 ? var13.field_1615_a : (var13.field_1615_a + 1) / 2;
                            ItemStack var11 = var12.func_20004_a(var10);
                            var6.func_20076_b(var11);
                            if (var13.field_1615_a == 0) {
                                var12.func_776_b((ItemStack)null);
                            }

                            var12.func_4103_a(var6.func_20075_i());
                        } else if (var12.func_4105_a(var14)) {
                            if (var13.field_1617_c == var14.field_1617_c && (!var13.func_21183_f() || var13.func_21181_i() == var14.func_21181_i())) {
                                var10 = var2 == 0 ? var14.field_1615_a : 1;
                                if (var10 > var12.func_4104_e() - var13.field_1615_a) {
                                    var10 = var12.func_4104_e() - var13.field_1615_a;
                                }

                                if (var10 > var14.func_1089_c() - var13.field_1615_a) {
                                    var10 = var14.func_1089_c() - var13.field_1615_a;
                                }

                                var14.func_1085_a(var10);
                                if (var14.field_1615_a == 0) {
                                    var6.func_20076_b((ItemStack)null);
                                }

                                var13.field_1615_a += var10;
                            } else if (var14.field_1615_a <= var12.func_4104_e()) {
                                var12.func_776_b(var14);
                                var6.func_20076_b(var13);
                            }
                        } else if (var13.field_1617_c == var14.field_1617_c && var14.func_1089_c() > 1 && (!var13.func_21183_f() || var13.func_21181_i() == var14.func_21181_i())) {
                            var10 = var13.field_1615_a;
                            if (var10 > 0 && var10 + var14.field_1615_a <= var14.func_1089_c()) {
                                var14.field_1615_a += var10;
                                var13.func_1085_a(var10);
                                if (var13.field_1615_a == 0) {
                                    var12.func_776_b((ItemStack)null);
                                }

                                var12.func_4103_a(var6.func_20075_i());
                            }
                        }
                    }
                }
            }
        }

        return var5;
    }

    public void func_1104_a(EntityPlayer var1) {
        InventoryPlayer var2 = var1.field_778_b;
        if (var2.func_20075_i() != null) {
            var1.func_449_a(var2.func_20075_i());
            var2.func_20076_b((ItemStack)null);
        }

    }

    public void func_1103_a(IInventory var1) {
        this.func_20114_a();
    }

    public void func_20119_a(int var1, ItemStack var2) {
        this.func_20118_a(var1).func_776_b(var2);
    }

    public void func_20115_a(ItemStack[] var1) {
        for(int var2 = 0; var2 < var1.length; ++var2) {
            this.func_20118_a(var2).func_776_b(var1[var2]);
        }

    }

    public void func_20112_a(int var1, int var2) {
    }

    public short func_20111_a(InventoryPlayer var1) {
        ++this.field_20917_a;
        return this.field_20917_a;
    }

    public void func_20113_a(short var1) {
    }

    public void func_20110_b(short var1) {
    }

    public abstract boolean func_20120_b(EntityPlayer var1);

    protected void func_28125_a(ItemStack var1, int var2, int var3, boolean var4) {
        int var5 = var2;
        if (var4) {
            var5 = var3 - 1;
        }

        Slot var6;
        ItemStack var7;
        if (var1.func_21180_d()) {
            while(var1.field_1615_a > 0 && (!var4 && var5 < var3 || var4 && var5 >= var2)) {
                var6 = (Slot)this.field_20122_e.get(var5);
                var7 = var6.func_777_b();
                if (var7 != null && var7.field_1617_c == var1.field_1617_c && (!var1.func_21183_f() || var1.func_21181_i() == var7.func_21181_i())) {
                    int var8 = var7.field_1615_a + var1.field_1615_a;
                    if (var8 <= var1.func_1089_c()) {
                        var1.field_1615_a = 0;
                        var7.field_1615_a = var8;
                        var6.func_779_d();
                    } else if (var7.field_1615_a < var1.func_1089_c()) {
                        var1.field_1615_a -= var1.func_1089_c() - var7.field_1615_a;
                        var7.field_1615_a = var1.func_1089_c();
                        var6.func_779_d();
                    }
                }

                if (var4) {
                    --var5;
                } else {
                    ++var5;
                }
            }
        }

        if (var1.field_1615_a > 0) {
            if (var4) {
                var5 = var3 - 1;
            } else {
                var5 = var2;
            }

            while(!var4 && var5 < var3 || var4 && var5 >= var2) {
                var6 = (Slot)this.field_20122_e.get(var5);
                var7 = var6.func_777_b();
                if (var7 == null) {
                    var6.func_776_b(var1.func_1102_e());
                    var6.func_779_d();
                    var1.field_1615_a = 0;
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
