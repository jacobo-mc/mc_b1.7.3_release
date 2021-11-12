package net.minecraft.src;

public class ItemMap extends ItemMapBase {
    protected ItemMap(int var1) {
        super(var1);
        this.setMaxStackSize(1);
    }

    public MapData func_28023_a(ItemStack var1, World var2) {
        (new StringBuilder()).append("map_").append(var1.getItemDamage()).toString();
        MapData var4 = (MapData)var2.func_28103_a(MapData.class, "map_" + var1.getItemDamage());
        if (var4 == null) {
            var1.setItemDamage(var2.func_28104_b("map"));
            String var3 = "map_" + var1.getItemDamage();
            var4 = new MapData(var3);
            var4.field_28164_b = var2.getWorldInfo().getSpawnX();
            var4.field_28163_c = var2.getWorldInfo().getSpawnZ();
            var4.field_28161_e = 3;
            var4.field_28162_d = (byte)var2.worldProvider.worldType;
            var4.func_28146_a();
            var2.func_28102_a(var3, var4);
        }

        return var4;
    }

    public void func_28024_a(World var1, Entity var2, MapData var3) {
        if (var1.worldProvider.worldType == var3.field_28162_d) {
            short var4 = 128;
            short var5 = 128;
            int var6 = 1 << var3.field_28161_e;
            int var7 = var3.field_28164_b;
            int var8 = var3.field_28163_c;
            int var9 = MathHelper.floor_double(var2.posX - (double)var7) / var6 + var4 / 2;
            int var10 = MathHelper.floor_double(var2.posZ - (double)var8) / var6 + var5 / 2;
            int var11 = 128 / var6;
            if (var1.worldProvider.field_4306_c) {
                var11 /= 2;
            }

            ++var3.field_28159_g;

            for(int var12 = var9 - var11 + 1; var12 < var9 + var11; ++var12) {
                if ((var12 & 15) == (var3.field_28159_g & 15)) {
                    int var13 = 255;
                    int var14 = 0;
                    double var15 = 0.0D;

                    for(int var17 = var10 - var11 - 1; var17 < var10 + var11; ++var17) {
                        if (var12 >= 0 && var17 >= -1 && var12 < var4 && var17 < var5) {
                            int var18 = var12 - var9;
                            int var19 = var17 - var10;
                            boolean var20 = var18 * var18 + var19 * var19 > (var11 - 2) * (var11 - 2);
                            int var21 = (var7 / var6 + var12 - var4 / 2) * var6;
                            int var22 = (var8 / var6 + var17 - var5 / 2) * var6;
                            byte var23 = 0;
                            byte var24 = 0;
                            byte var25 = 0;
                            int[] var26 = new int[256];
                            Chunk var27 = var1.getChunkFromBlockCoords(var21, var22);
                            int var28 = var21 & 15;
                            int var29 = var22 & 15;
                            int var30 = 0;
                            double var31 = 0.0D;
                            int var33;
                            int var34;
                            int var35;
                            int var38;
                            if (var1.worldProvider.field_4306_c) {
                                var33 = var21 + var22 * 231871;
                                var33 = var33 * var33 * 31287121 + var33 * 11;
                                int var10001;
                                if ((var33 >> 20 & 1) == 0) {
                                    var10001 = Block.dirt.blockID;
                                    var26[var10001] += 10;
                                } else {
                                    var10001 = Block.stone.blockID;
                                    var26[var10001] += 10;
                                }

                                var31 = 100.0D;
                            } else {
                                for(var33 = 0; var33 < var6; ++var33) {
                                    for(var34 = 0; var34 < var6; ++var34) {
                                        var35 = var27.getHeightValue(var33 + var28, var34 + var29) + 1;
                                        int var36 = 0;
                                        if (var35 > 1) {
                                            boolean var37 = false;

                                            label164:
                                            while(true) {
                                                var37 = true;
                                                var36 = var27.getBlockID(var33 + var28, var35 - 1, var34 + var29);
                                                if (var36 == 0) {
                                                    var37 = false;
                                                } else if (var35 > 0 && var36 > 0 && Block.blocksList[var36].blockMaterial.field_28131_A == MapColor.field_28199_b) {
                                                    var37 = false;
                                                }

                                                if (!var37) {
                                                    --var35;
                                                    var36 = var27.getBlockID(var33 + var28, var35 - 1, var34 + var29);
                                                }

                                                if (var37) {
                                                    if (var36 == 0 || !Block.blocksList[var36].blockMaterial.getIsLiquid()) {
                                                        break;
                                                    }

                                                    var38 = var35 - 1;
                                                    boolean var39 = false;

                                                    while(true) {
                                                        int var43 = var27.getBlockID(var33 + var28, var38--, var34 + var29);
                                                        ++var30;
                                                        if (var38 <= 0 || var43 == 0 || !Block.blocksList[var43].blockMaterial.getIsLiquid()) {
                                                            break label164;
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        var31 += (double)var35 / (double)(var6 * var6);
                                        int var10002 = var26[var36]++;
                                    }
                                }
                            }

                            var30 /= var6 * var6;
                            int var10000 = var23 / (var6 * var6);
                            var10000 = var24 / (var6 * var6);
                            var10000 = var25 / (var6 * var6);
                            var33 = 0;
                            var34 = 0;

                            for(var35 = 0; var35 < 256; ++var35) {
                                if (var26[var35] > var33) {
                                    var34 = var35;
                                    var33 = var26[var35];
                                }
                            }

                            double var41 = (var31 - var15) * 4.0D / (double)(var6 + 4) + ((double)(var12 + var17 & 1) - 0.5D) * 0.4D;
                            byte var42 = 1;
                            if (var41 > 0.6D) {
                                var42 = 2;
                            }

                            if (var41 < -0.6D) {
                                var42 = 0;
                            }

                            var38 = 0;
                            if (var34 > 0) {
                                MapColor var44 = Block.blocksList[var34].blockMaterial.field_28131_A;
                                if (var44 == MapColor.field_28187_n) {
                                    var41 = (double)var30 * 0.1D + (double)(var12 + var17 & 1) * 0.2D;
                                    var42 = 1;
                                    if (var41 < 0.5D) {
                                        var42 = 2;
                                    }

                                    if (var41 > 0.9D) {
                                        var42 = 0;
                                    }
                                }

                                var38 = var44.field_28184_q;
                            }

                            var15 = var31;
                            if (var17 >= 0 && var18 * var18 + var19 * var19 < var11 * var11 && (!var20 || (var12 + var17 & 1) != 0)) {
                                byte var45 = var3.field_28160_f[var12 + var17 * var4];
                                byte var40 = (byte)(var38 * 4 + var42);
                                if (var45 != var40) {
                                    if (var13 > var17) {
                                        var13 = var17;
                                    }

                                    if (var14 < var17) {
                                        var14 = var17;
                                    }

                                    var3.field_28160_f[var12 + var17 * var4] = var40;
                                }
                            }
                        }
                    }

                    if (var13 <= var14) {
                        var3.func_28153_a(var12, var13, var14);
                    }
                }
            }

        }
    }

    public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
        if (!var2.singleplayerWorld) {
            MapData var6 = this.func_28023_a(var1, var2);
            if (var3 instanceof EntityPlayer) {
                EntityPlayer var7 = (EntityPlayer)var3;
                var6.func_28155_a(var7, var1);
            }

            if (var5) {
                this.func_28024_a(var2, var3, var6);
            }

        }
    }

    public void onCreated(ItemStack var1, World var2, EntityPlayer var3) {
        var1.setItemDamage(var2.func_28104_b("map"));
        String var4 = "map_" + var1.getItemDamage();
        MapData var5 = new MapData(var4);
        var2.func_28102_a(var4, var5);
        var5.field_28164_b = MathHelper.floor_double(var3.posX);
        var5.field_28163_c = MathHelper.floor_double(var3.posZ);
        var5.field_28161_e = 3;
        var5.field_28162_d = (byte)var2.worldProvider.worldType;
        var5.func_28146_a();
    }

    public Packet func_28022_b(ItemStack var1, World var2, EntityPlayer var3) {
        byte[] var4 = this.func_28023_a(var1, var2).func_28154_a(var1, var2, var3);
        return var4 == null ? null : new Packet131MapData((short)Item.field_28021_bb.shiftedIndex, (short)var1.getItemDamage(), var4);
    }
}
