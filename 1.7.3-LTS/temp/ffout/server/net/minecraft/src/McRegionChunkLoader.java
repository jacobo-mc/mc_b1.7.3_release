package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class McRegionChunkLoader implements IChunkLoader {
    private final File field_22110_a;

    public McRegionChunkLoader(File var1) {
        this.field_22110_a = var1;
    }

    public Chunk func_659_a(World var1, int var2, int var3) throws IOException {
        DataInputStream var4 = RegionFileCache.func_22124_c(this.field_22110_a, var2, var3);
        if (var4 != null) {
            NBTTagCompound var5 = CompressedStreamTools.func_774_a(var4);
            if (!var5.func_410_a("Level")) {
                System.out.println("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
                return null;
            } else if (!var5.func_397_j("Level").func_410_a("Blocks")) {
                System.out.println("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
                return null;
            } else {
                Chunk var6 = ChunkLoader.func_664_a(var1, var5.func_397_j("Level"));
                if (!var6.func_351_a(var2, var3)) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.field_685_j + ", " + var6.field_684_k + ")");
                    var5.func_405_a("xPos", var2);
                    var5.func_405_a("zPos", var3);
                    var6 = ChunkLoader.func_664_a(var1, var5.func_397_j("Level"));
                }

                var6.func_25083_h();
                return var6;
            }
        } else {
            return null;
        }
    }

    public void func_662_a(World var1, Chunk var2) throws IOException {
        var1.func_476_g();

        try {
            DataOutputStream var3 = RegionFileCache.func_22120_d(this.field_22110_a, var2.field_685_j, var2.field_684_k);
            NBTTagCompound var4 = new NBTTagCompound();
            NBTTagCompound var5 = new NBTTagCompound();
            var4.func_399_a("Level", var5);
            ChunkLoader.func_663_a(var2, var1, var5);
            CompressedStreamTools.func_771_a(var4, var3);
            var3.close();
            WorldInfo var6 = var1.func_22081_n();
            var6.func_22177_b(var6.func_22182_g() + (long)RegionFileCache.func_22121_b(this.field_22110_a, var2.field_685_j, var2.field_684_k));
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public void func_4104_b(World var1, Chunk var2) throws IOException {
    }

    public void func_661_a() {
    }

    public void func_660_b() {
    }
}
