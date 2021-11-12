package net.minecraft.src;

public class MetadataChunkBlock {
    public final EnumSkyBlock field_957_a;
    public int field_956_b;
    public int field_962_c;
    public int field_961_d;
    public int field_960_e;
    public int field_959_f;
    public int field_958_g;

    public MetadataChunkBlock(EnumSkyBlock var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.field_957_a = var1;
        this.field_956_b = var2;
        this.field_962_c = var3;
        this.field_961_d = var4;
        this.field_960_e = var5;
        this.field_959_f = var6;
        this.field_958_g = var7;
    }

    public void func_4107_a(World var1) {
        int var2 = this.field_960_e - this.field_956_b + 1;
        int var3 = this.field_959_f - this.field_962_c + 1;
        int var4 = this.field_958_g - this.field_961_d + 1;
        int var5 = var2 * var3 * var4;
        if (var5 > 32768) {
            System.out.println("Light too large, skipping!");
        } else {
            int var6 = 0;
            int var7 = 0;
            boolean var8 = false;
            boolean var9 = false;

            for(int var10 = this.field_956_b; var10 <= this.field_960_e; ++var10) {
                for(int var11 = this.field_961_d; var11 <= this.field_958_g; ++var11) {
                    int var12 = var10 >> 4;
                    int var13 = var11 >> 4;
                    boolean var14 = false;
                    if (var8 && var12 == var6 && var13 == var7) {
                        var14 = var9;
                    } else {
                        var14 = var1.doChunksNearChunkExist(var10, 0, var11, 1);
                        if (var14) {
                            Chunk var15 = var1.getChunkFromChunkCoords(var10 >> 4, var11 >> 4);
                            if (var15.func_21101_g()) {
                                var14 = false;
                            }
                        }

                        var9 = var14;
                        var6 = var12;
                        var7 = var13;
                    }

                    if (var14) {
                        if (this.field_962_c < 0) {
                            this.field_962_c = 0;
                        }

                        if (this.field_959_f >= 128) {
                            this.field_959_f = 127;
                        }

                        for(int var27 = this.field_962_c; var27 <= this.field_959_f; ++var27) {
                            int var16 = var1.getSavedLightValue(this.field_957_a, var10, var27, var11);
                            boolean var17 = false;
                            int var18 = var1.getBlockId(var10, var27, var11);
                            int var19 = Block.lightOpacity[var18];
                            if (var19 == 0) {
                                var19 = 1;
                            }

                            int var20 = 0;
                            if (this.field_957_a == EnumSkyBlock.Sky) {
                                if (var1.canExistingBlockSeeTheSky(var10, var27, var11)) {
                                    var20 = 15;
                                }
                            } else if (this.field_957_a == EnumSkyBlock.Block) {
                                var20 = Block.lightValue[var18];
                            }

                            int var21;
                            int var28;
                            if (var19 >= 15 && var20 == 0) {
                                var28 = 0;
                            } else {
                                var21 = var1.getSavedLightValue(this.field_957_a, var10 - 1, var27, var11);
                                int var22 = var1.getSavedLightValue(this.field_957_a, var10 + 1, var27, var11);
                                int var23 = var1.getSavedLightValue(this.field_957_a, var10, var27 - 1, var11);
                                int var24 = var1.getSavedLightValue(this.field_957_a, var10, var27 + 1, var11);
                                int var25 = var1.getSavedLightValue(this.field_957_a, var10, var27, var11 - 1);
                                int var26 = var1.getSavedLightValue(this.field_957_a, var10, var27, var11 + 1);
                                var28 = var21;
                                if (var22 > var21) {
                                    var28 = var22;
                                }

                                if (var23 > var28) {
                                    var28 = var23;
                                }

                                if (var24 > var28) {
                                    var28 = var24;
                                }

                                if (var25 > var28) {
                                    var28 = var25;
                                }

                                if (var26 > var28) {
                                    var28 = var26;
                                }

                                var28 -= var19;
                                if (var28 < 0) {
                                    var28 = 0;
                                }

                                if (var20 > var28) {
                                    var28 = var20;
                                }
                            }

                            if (var16 != var28) {
                                var1.setLightValue(this.field_957_a, var10, var27, var11, var28);
                                var21 = var28 - 1;
                                if (var21 < 0) {
                                    var21 = 0;
                                }

                                var1.neighborLightPropagationChanged(this.field_957_a, var10 - 1, var27, var11, var21);
                                var1.neighborLightPropagationChanged(this.field_957_a, var10, var27 - 1, var11, var21);
                                var1.neighborLightPropagationChanged(this.field_957_a, var10, var27, var11 - 1, var21);
                                if (var10 + 1 >= this.field_960_e) {
                                    var1.neighborLightPropagationChanged(this.field_957_a, var10 + 1, var27, var11, var21);
                                }

                                if (var27 + 1 >= this.field_959_f) {
                                    var1.neighborLightPropagationChanged(this.field_957_a, var10, var27 + 1, var11, var21);
                                }

                                if (var11 + 1 >= this.field_958_g) {
                                    var1.neighborLightPropagationChanged(this.field_957_a, var10, var27, var11 + 1, var21);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public boolean func_692_a(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var1 >= this.field_956_b && var2 >= this.field_962_c && var3 >= this.field_961_d && var4 <= this.field_960_e && var5 <= this.field_959_f && var6 <= this.field_958_g) {
            return true;
        } else {
            byte var7 = 1;
            if (var1 >= this.field_956_b - var7 && var2 >= this.field_962_c - var7 && var3 >= this.field_961_d - var7 && var4 <= this.field_960_e + var7 && var5 <= this.field_959_f + var7 && var6 <= this.field_958_g + var7) {
                int var8 = this.field_960_e - this.field_956_b;
                int var9 = this.field_959_f - this.field_962_c;
                int var10 = this.field_958_g - this.field_961_d;
                if (var1 > this.field_956_b) {
                    var1 = this.field_956_b;
                }

                if (var2 > this.field_962_c) {
                    var2 = this.field_962_c;
                }

                if (var3 > this.field_961_d) {
                    var3 = this.field_961_d;
                }

                if (var4 < this.field_960_e) {
                    var4 = this.field_960_e;
                }

                if (var5 < this.field_959_f) {
                    var5 = this.field_959_f;
                }

                if (var6 < this.field_958_g) {
                    var6 = this.field_958_g;
                }

                int var11 = var4 - var1;
                int var12 = var5 - var2;
                int var13 = var6 - var3;
                int var14 = var8 * var9 * var10;
                int var15 = var11 * var12 * var13;
                if (var15 - var14 <= 2) {
                    this.field_956_b = var1;
                    this.field_962_c = var2;
                    this.field_961_d = var3;
                    this.field_960_e = var4;
                    this.field_959_f = var5;
                    this.field_958_g = var6;
                    return true;
                }
            }

            return false;
        }
    }
}
