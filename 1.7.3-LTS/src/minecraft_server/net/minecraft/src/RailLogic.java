package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

class RailLogic {
    private World worldObj;
    private int trackX;
    private int trackY;
    private int trackZ;
    private final boolean field_27084_f;
    private List connectedTracks;
    // $FF: synthetic field
    final BlockRail minecartTrack;

    public RailLogic(BlockRail var1, World var2, int var3, int var4, int var5) {
        this.minecartTrack = var1;
        this.connectedTracks = new ArrayList();
        this.worldObj = var2;
        this.trackX = var3;
        this.trackY = var4;
        this.trackZ = var5;
        int var6 = var2.getBlockId(var3, var4, var5);
        int var7 = var2.getBlockMetadata(var3, var4, var5);
        if (BlockRail.func_27033_a((BlockRail)Block.blocksList[var6])) {
            this.field_27084_f = true;
            var7 &= -9;
        } else {
            this.field_27084_f = false;
        }

        this.func_27083_a(var7);
    }

    private void func_27083_a(int var1) {
        this.connectedTracks.clear();
        if (var1 == 0) {
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ - 1));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ + 1));
        } else if (var1 == 1) {
            this.connectedTracks.add(new ChunkPosition(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX + 1, this.trackY, this.trackZ));
        } else if (var1 == 2) {
            this.connectedTracks.add(new ChunkPosition(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX + 1, this.trackY + 1, this.trackZ));
        } else if (var1 == 3) {
            this.connectedTracks.add(new ChunkPosition(this.trackX - 1, this.trackY + 1, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX + 1, this.trackY, this.trackZ));
        } else if (var1 == 4) {
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY + 1, this.trackZ - 1));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ + 1));
        } else if (var1 == 5) {
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ - 1));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY + 1, this.trackZ + 1));
        } else if (var1 == 6) {
            this.connectedTracks.add(new ChunkPosition(this.trackX + 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ + 1));
        } else if (var1 == 7) {
            this.connectedTracks.add(new ChunkPosition(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ + 1));
        } else if (var1 == 8) {
            this.connectedTracks.add(new ChunkPosition(this.trackX - 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ - 1));
        } else if (var1 == 9) {
            this.connectedTracks.add(new ChunkPosition(this.trackX + 1, this.trackY, this.trackZ));
            this.connectedTracks.add(new ChunkPosition(this.trackX, this.trackY, this.trackZ - 1));
        }

    }

    private void func_591_b() {
        for(int var1 = 0; var1 < this.connectedTracks.size(); ++var1) {
            RailLogic var2 = this.getMinecartTrackLogic((ChunkPosition)this.connectedTracks.get(var1));
            if (var2 != null && var2.isConnectedTo(this)) {
                this.connectedTracks.set(var1, new ChunkPosition(var2.trackX, var2.trackY, var2.trackZ));
            } else {
                this.connectedTracks.remove(var1--);
            }
        }

    }

    private boolean isMinecartTrack(int var1, int var2, int var3) {
        if (BlockRail.func_27029_g(this.worldObj, var1, var2, var3)) {
            return true;
        } else if (BlockRail.func_27029_g(this.worldObj, var1, var2 + 1, var3)) {
            return true;
        } else {
            return BlockRail.func_27029_g(this.worldObj, var1, var2 - 1, var3);
        }
    }

    private RailLogic getMinecartTrackLogic(ChunkPosition var1) {
        if (BlockRail.func_27029_g(this.worldObj, var1.x, var1.y, var1.z)) {
            return new RailLogic(this.minecartTrack, this.worldObj, var1.x, var1.y, var1.z);
        } else if (BlockRail.func_27029_g(this.worldObj, var1.x, var1.y + 1, var1.z)) {
            return new RailLogic(this.minecartTrack, this.worldObj, var1.x, var1.y + 1, var1.z);
        } else {
            return BlockRail.func_27029_g(this.worldObj, var1.x, var1.y - 1, var1.z) ? new RailLogic(this.minecartTrack, this.worldObj, var1.x, var1.y - 1, var1.z) : null;
        }
    }

    private boolean isConnectedTo(RailLogic var1) {
        for(int var2 = 0; var2 < this.connectedTracks.size(); ++var2) {
            ChunkPosition var3 = (ChunkPosition)this.connectedTracks.get(var2);
            if (var3.x == var1.trackX && var3.z == var1.trackZ) {
                return true;
            }
        }

        return false;
    }

    private boolean func_599_b(int var1, int var2, int var3) {
        for(int var4 = 0; var4 < this.connectedTracks.size(); ++var4) {
            ChunkPosition var5 = (ChunkPosition)this.connectedTracks.get(var4);
            if (var5.x == var1 && var5.z == var3) {
                return true;
            }
        }

        return false;
    }

    private int getAdjacentTracks() {
        int var1 = 0;
        if (this.isMinecartTrack(this.trackX, this.trackY, this.trackZ - 1)) {
            ++var1;
        }

        if (this.isMinecartTrack(this.trackX, this.trackY, this.trackZ + 1)) {
            ++var1;
        }

        if (this.isMinecartTrack(this.trackX - 1, this.trackY, this.trackZ)) {
            ++var1;
        }

        if (this.isMinecartTrack(this.trackX + 1, this.trackY, this.trackZ)) {
            ++var1;
        }

        return var1;
    }

    private boolean handleKeyPress(RailLogic var1) {
        if (this.isConnectedTo(var1)) {
            return true;
        } else if (this.connectedTracks.size() == 2) {
            return false;
        } else if (this.connectedTracks.size() == 0) {
            return true;
        } else {
            ChunkPosition var2 = (ChunkPosition)this.connectedTracks.get(0);
            return var1.trackY == this.trackY && var2.y == this.trackY ? true : true;
        }
    }

    private void func_598_d(RailLogic var1) {
        this.connectedTracks.add(new ChunkPosition(var1.trackX, var1.trackY, var1.trackZ));
        boolean var2 = this.func_599_b(this.trackX, this.trackY, this.trackZ - 1);
        boolean var3 = this.func_599_b(this.trackX, this.trackY, this.trackZ + 1);
        boolean var4 = this.func_599_b(this.trackX - 1, this.trackY, this.trackZ);
        boolean var5 = this.func_599_b(this.trackX + 1, this.trackY, this.trackZ);
        byte var6 = -1;
        if (var2 || var3) {
            var6 = 0;
        }

        if (var4 || var5) {
            var6 = 1;
        }

        if (!this.field_27084_f) {
            if (var3 && var5 && !var2 && !var4) {
                var6 = 6;
            }

            if (var3 && var4 && !var2 && !var5) {
                var6 = 7;
            }

            if (var2 && var4 && !var3 && !var5) {
                var6 = 8;
            }

            if (var2 && var5 && !var3 && !var4) {
                var6 = 9;
            }
        }

        if (var6 == 0) {
            if (BlockRail.func_27029_g(this.worldObj, this.trackX, this.trackY + 1, this.trackZ - 1)) {
                var6 = 4;
            }

            if (BlockRail.func_27029_g(this.worldObj, this.trackX, this.trackY + 1, this.trackZ + 1)) {
                var6 = 5;
            }
        }

        if (var6 == 1) {
            if (BlockRail.func_27029_g(this.worldObj, this.trackX + 1, this.trackY + 1, this.trackZ)) {
                var6 = 2;
            }

            if (BlockRail.func_27029_g(this.worldObj, this.trackX - 1, this.trackY + 1, this.trackZ)) {
                var6 = 3;
            }
        }

        if (var6 < 0) {
            var6 = 0;
        }

        int var7 = var6;
        if (this.field_27084_f) {
            var7 = this.worldObj.getBlockMetadata(this.trackX, this.trackY, this.trackZ) & 8 | var6;
        }

        this.worldObj.setBlockMetadataWithNotify(this.trackX, this.trackY, this.trackZ, var7);
    }

    private boolean func_592_c(int var1, int var2, int var3) {
        RailLogic var4 = this.getMinecartTrackLogic(new ChunkPosition(var1, var2, var3));
        if (var4 == null) {
            return false;
        } else {
            var4.func_591_b();
            return var4.handleKeyPress(this);
        }
    }

    public void func_596_a(boolean var1, boolean var2) {
        boolean var3 = this.func_592_c(this.trackX, this.trackY, this.trackZ - 1);
        boolean var4 = this.func_592_c(this.trackX, this.trackY, this.trackZ + 1);
        boolean var5 = this.func_592_c(this.trackX - 1, this.trackY, this.trackZ);
        boolean var6 = this.func_592_c(this.trackX + 1, this.trackY, this.trackZ);
        byte var7 = -1;
        if ((var3 || var4) && !var5 && !var6) {
            var7 = 0;
        }

        if ((var5 || var6) && !var3 && !var4) {
            var7 = 1;
        }

        if (!this.field_27084_f) {
            if (var4 && var6 && !var3 && !var5) {
                var7 = 6;
            }

            if (var4 && var5 && !var3 && !var6) {
                var7 = 7;
            }

            if (var3 && var5 && !var4 && !var6) {
                var7 = 8;
            }

            if (var3 && var6 && !var4 && !var5) {
                var7 = 9;
            }
        }

        if (var7 == -1) {
            if (var3 || var4) {
                var7 = 0;
            }

            if (var5 || var6) {
                var7 = 1;
            }

            if (!this.field_27084_f) {
                if (var1) {
                    if (var4 && var6) {
                        var7 = 6;
                    }

                    if (var5 && var4) {
                        var7 = 7;
                    }

                    if (var6 && var3) {
                        var7 = 9;
                    }

                    if (var3 && var5) {
                        var7 = 8;
                    }
                } else {
                    if (var3 && var5) {
                        var7 = 8;
                    }

                    if (var6 && var3) {
                        var7 = 9;
                    }

                    if (var5 && var4) {
                        var7 = 7;
                    }

                    if (var4 && var6) {
                        var7 = 6;
                    }
                }
            }
        }

        if (var7 == 0) {
            if (BlockRail.func_27029_g(this.worldObj, this.trackX, this.trackY + 1, this.trackZ - 1)) {
                var7 = 4;
            }

            if (BlockRail.func_27029_g(this.worldObj, this.trackX, this.trackY + 1, this.trackZ + 1)) {
                var7 = 5;
            }
        }

        if (var7 == 1) {
            if (BlockRail.func_27029_g(this.worldObj, this.trackX + 1, this.trackY + 1, this.trackZ)) {
                var7 = 2;
            }

            if (BlockRail.func_27029_g(this.worldObj, this.trackX - 1, this.trackY + 1, this.trackZ)) {
                var7 = 3;
            }
        }

        if (var7 < 0) {
            var7 = 0;
        }

        this.func_27083_a(var7);
        int var8 = var7;
        if (this.field_27084_f) {
            var8 = this.worldObj.getBlockMetadata(this.trackX, this.trackY, this.trackZ) & 8 | var7;
        }

        if (var2 || this.worldObj.getBlockMetadata(this.trackX, this.trackY, this.trackZ) != var8) {
            this.worldObj.setBlockMetadataWithNotify(this.trackX, this.trackY, this.trackZ, var8);

            for(int var9 = 0; var9 < this.connectedTracks.size(); ++var9) {
                RailLogic var10 = this.getMinecartTrackLogic((ChunkPosition)this.connectedTracks.get(var9));
                if (var10 != null) {
                    var10.func_591_b();
                    if (var10.handleKeyPress(this)) {
                        var10.func_598_d(this);
                    }
                }
            }
        }

    }

    // $FF: synthetic method
    static int getNAdjacentTracks(RailLogic var0) {
        return var0.getAdjacentTracks();
    }
}
