package net.minecraft.src;

import java.util.Random;

public class BlockFlowing extends BlockFluid {
    int field_659_a = 0;
    boolean[] field_658_b = new boolean[4];
    int[] field_660_c = new int[4];

    protected BlockFlowing(int var1, Material var2) {
        super(var1, var2);
    }

    private void func_30004_i(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        var1.setBlockAndMetadata(var2, var3, var4, this.blockID + 1, var5);
        var1.markBlocksDirty(var2, var3, var4, var2, var3, var4);
        var1.markBlockNeedsUpdate(var2, var3, var4);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = this.func_301_g(var1, var2, var3, var4);
        byte var7 = 1;
        if (this.blockMaterial == Material.lava && !var1.worldProvider.isHellWorld) {
            var7 = 2;
        }

        boolean var8 = true;
        int var10;
        if (var6 > 0) {
            byte var9 = -100;
            this.field_659_a = 0;
            int var12 = this.func_307_e(var1, var2 - 1, var3, var4, var9);
            var12 = this.func_307_e(var1, var2 + 1, var3, var4, var12);
            var12 = this.func_307_e(var1, var2, var3, var4 - 1, var12);
            var12 = this.func_307_e(var1, var2, var3, var4 + 1, var12);
            var10 = var12 + var7;
            if (var10 >= 8 || var12 < 0) {
                var10 = -1;
            }

            if (this.func_301_g(var1, var2, var3 + 1, var4) >= 0) {
                int var11 = this.func_301_g(var1, var2, var3 + 1, var4);
                if (var11 >= 8) {
                    var10 = var11;
                } else {
                    var10 = var11 + 8;
                }
            }

            if (this.field_659_a >= 2 && this.blockMaterial == Material.water) {
                if (var1.getBlockMaterial(var2, var3 - 1, var4).isSolid()) {
                    var10 = 0;
                } else if (var1.getBlockMaterial(var2, var3 - 1, var4) == this.blockMaterial && var1.getBlockMetadata(var2, var3, var4) == 0) {
                    var10 = 0;
                }
            }

            if (this.blockMaterial == Material.lava && var6 < 8 && var10 < 8 && var10 > var6 && var5.nextInt(4) != 0) {
                var10 = var6;
                var8 = false;
            }

            if (var10 != var6) {
                var6 = var10;
                if (var10 < 0) {
                    var1.setBlockWithNotify(var2, var3, var4, 0);
                } else {
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var10);
                    var1.scheduleUpdateTick(var2, var3, var4, this.blockID, this.tickRate());
                    var1.notifyBlocksOfNeighborChange(var2, var3, var4, this.blockID);
                }
            } else if (var8) {
                this.func_30004_i(var1, var2, var3, var4);
            }
        } else {
            this.func_30004_i(var1, var2, var3, var4);
        }

        if (this.func_312_l(var1, var2, var3 - 1, var4)) {
            if (var6 >= 8) {
                var1.setBlockAndMetadataWithNotify(var2, var3 - 1, var4, this.blockID, var6);
            } else {
                var1.setBlockAndMetadataWithNotify(var2, var3 - 1, var4, this.blockID, var6 + 8);
            }
        } else if (var6 >= 0 && (var6 == 0 || this.func_309_k(var1, var2, var3 - 1, var4))) {
            boolean[] var13 = this.func_4035_j(var1, var2, var3, var4);
            var10 = var6 + var7;
            if (var6 >= 8) {
                var10 = 1;
            }

            if (var10 >= 8) {
                return;
            }

            if (var13[0]) {
                this.func_311_f(var1, var2 - 1, var3, var4, var10);
            }

            if (var13[1]) {
                this.func_311_f(var1, var2 + 1, var3, var4, var10);
            }

            if (var13[2]) {
                this.func_311_f(var1, var2, var3, var4 - 1, var10);
            }

            if (var13[3]) {
                this.func_311_f(var1, var2, var3, var4 + 1, var10);
            }
        }

    }

    private void func_311_f(World var1, int var2, int var3, int var4, int var5) {
        if (this.func_312_l(var1, var2, var3, var4)) {
            int var6 = var1.getBlockId(var2, var3, var4);
            if (var6 > 0) {
                if (this.blockMaterial == Material.lava) {
                    this.func_300_h(var1, var2, var3, var4);
                } else {
                    Block.blocksList[var6].dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
                }
            }

            var1.setBlockAndMetadataWithNotify(var2, var3, var4, this.blockID, var5);
        }

    }

    private int func_4034_a(World var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = 1000;

        for(int var8 = 0; var8 < 4; ++var8) {
            if ((var8 != 0 || var6 != 1) && (var8 != 1 || var6 != 0) && (var8 != 2 || var6 != 3) && (var8 != 3 || var6 != 2)) {
                int var9 = var2;
                int var11 = var4;
                if (var8 == 0) {
                    var9 = var2 - 1;
                }

                if (var8 == 1) {
                    ++var9;
                }

                if (var8 == 2) {
                    var11 = var4 - 1;
                }

                if (var8 == 3) {
                    ++var11;
                }

                if (!this.func_309_k(var1, var9, var3, var11) && (var1.getBlockMaterial(var9, var3, var11) != this.blockMaterial || var1.getBlockMetadata(var9, var3, var11) != 0)) {
                    if (!this.func_309_k(var1, var9, var3 - 1, var11)) {
                        return var5;
                    }

                    if (var5 < 4) {
                        int var12 = this.func_4034_a(var1, var9, var3, var11, var5 + 1, var8);
                        if (var12 < var7) {
                            var7 = var12;
                        }
                    }
                }
            }
        }

        return var7;
    }

    private boolean[] func_4035_j(World var1, int var2, int var3, int var4) {
        int var5;
        int var6;
        for(var5 = 0; var5 < 4; ++var5) {
            this.field_660_c[var5] = 1000;
            var6 = var2;
            int var8 = var4;
            if (var5 == 0) {
                var6 = var2 - 1;
            }

            if (var5 == 1) {
                ++var6;
            }

            if (var5 == 2) {
                var8 = var4 - 1;
            }

            if (var5 == 3) {
                ++var8;
            }

            if (!this.func_309_k(var1, var6, var3, var8) && (var1.getBlockMaterial(var6, var3, var8) != this.blockMaterial || var1.getBlockMetadata(var6, var3, var8) != 0)) {
                if (!this.func_309_k(var1, var6, var3 - 1, var8)) {
                    this.field_660_c[var5] = 0;
                } else {
                    this.field_660_c[var5] = this.func_4034_a(var1, var6, var3, var8, 1, var5);
                }
            }
        }

        var5 = this.field_660_c[0];

        for(var6 = 1; var6 < 4; ++var6) {
            if (this.field_660_c[var6] < var5) {
                var5 = this.field_660_c[var6];
            }
        }

        for(var6 = 0; var6 < 4; ++var6) {
            this.field_658_b[var6] = this.field_660_c[var6] == var5;
        }

        return this.field_658_b;
    }

    private boolean func_309_k(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockId(var2, var3, var4);
        if (var5 != Block.doorWood.blockID && var5 != Block.doorSteel.blockID && var5 != Block.signPost.blockID && var5 != Block.ladder.blockID && var5 != Block.reed.blockID) {
            if (var5 == 0) {
                return false;
            } else {
                Material var6 = Block.blocksList[var5].blockMaterial;
                return var6.getIsSolid();
            }
        } else {
            return true;
        }
    }

    protected int func_307_e(World var1, int var2, int var3, int var4, int var5) {
        int var6 = this.func_301_g(var1, var2, var3, var4);
        if (var6 < 0) {
            return var5;
        } else {
            if (var6 == 0) {
                ++this.field_659_a;
            }

            if (var6 >= 8) {
                var6 = 0;
            }

            return var5 >= 0 && var6 >= var5 ? var5 : var6;
        }
    }

    private boolean func_312_l(World var1, int var2, int var3, int var4) {
        Material var5 = var1.getBlockMaterial(var2, var3, var4);
        if (var5 == this.blockMaterial) {
            return false;
        } else if (var5 == Material.lava) {
            return false;
        } else {
            return !this.func_309_k(var1, var2, var3, var4);
        }
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        super.onBlockAdded(var1, var2, var3, var4);
        if (var1.getBlockId(var2, var3, var4) == this.blockID) {
            var1.scheduleUpdateTick(var2, var3, var4, this.blockID, this.tickRate());
        }

    }
}
