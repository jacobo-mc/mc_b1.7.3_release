package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ChunkLoader implements IChunkLoader {
    private File field_945_a;
    private boolean field_944_b;

    public ChunkLoader(File var1, boolean var2) {
        this.field_945_a = var1;
        this.field_944_b = var2;
    }

    private File func_665_a(int var1, int var2) {
        String var3 = "c." + Integer.toString(var1, 36) + "." + Integer.toString(var2, 36) + ".dat";
        String var4 = Integer.toString(var1 & 63, 36);
        String var5 = Integer.toString(var2 & 63, 36);
        File var6 = new File(this.field_945_a, var4);
        if (!var6.exists()) {
            if (!this.field_944_b) {
                return null;
            }

            var6.mkdir();
        }

        var6 = new File(var6, var5);
        if (!var6.exists()) {
            if (!this.field_944_b) {
                return null;
            }

            var6.mkdir();
        }

        var6 = new File(var6, var3);
        return !var6.exists() && !this.field_944_b ? null : var6;
    }

    public Chunk func_659_a(World var1, int var2, int var3) throws IOException {
        File var4 = this.func_665_a(var2, var3);
        if (var4 != null && var4.exists()) {
            try {
                FileInputStream var5 = new FileInputStream(var4);
                NBTTagCompound var6 = CompressedStreamTools.func_770_a(var5);
                if (!var6.func_410_a("Level")) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
                    return null;
                }

                if (!var6.func_397_j("Level").func_410_a("Blocks")) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
                    return null;
                }

                Chunk var7 = func_664_a(var1, var6.func_397_j("Level"));
                if (!var7.func_351_a(var2, var3)) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var7.field_685_j + ", " + var7.field_684_k + ")");
                    var6.func_405_a("xPos", var2);
                    var6.func_405_a("zPos", var3);
                    var7 = func_664_a(var1, var6.func_397_j("Level"));
                }

                var7.func_25083_h();
                return var7;
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }

        return null;
    }

    public void func_662_a(World var1, Chunk var2) throws IOException {
        var1.func_476_g();
        File var3 = this.func_665_a(var2.field_685_j, var2.field_684_k);
        if (var3.exists()) {
            WorldInfo var4 = var1.func_22081_n();
            var4.func_22177_b(var4.func_22182_g() - var3.length());
        }

        try {
            File var10 = new File(this.field_945_a, "tmp_chunk.dat");
            FileOutputStream var5 = new FileOutputStream(var10);
            NBTTagCompound var6 = new NBTTagCompound();
            NBTTagCompound var7 = new NBTTagCompound();
            var6.func_399_a("Level", var7);
            func_663_a(var2, var1, var7);
            CompressedStreamTools.func_769_a(var6, var5);
            var5.close();
            if (var3.exists()) {
                var3.delete();
            }

            var10.renameTo(var3);
            WorldInfo var8 = var1.func_22081_n();
            var8.func_22177_b(var8.func_22182_g() + var3.length());
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public static void func_663_a(Chunk var0, World var1, NBTTagCompound var2) {
        var1.func_476_g();
        var2.func_405_a("xPos", var0.field_685_j);
        var2.func_405_a("zPos", var0.field_684_k);
        var2.func_396_a("LastUpdate", var1.func_22080_k());
        var2.func_391_a("Blocks", var0.field_693_b);
        var2.func_391_a("Data", var0.field_690_e.field_844_a);
        var2.func_391_a("SkyLight", var0.field_689_f.field_844_a);
        var2.func_391_a("BlockLight", var0.field_688_g.field_844_a);
        var2.func_391_a("HeightMap", var0.field_687_h);
        var2.func_393_a("TerrainPopulated", var0.field_681_n);
        var0.field_677_r = false;
        NBTTagList var3 = new NBTTagList();

        Iterator var5;
        NBTTagCompound var7;
        for(int var4 = 0; var4 < var0.field_682_m.length; ++var4) {
            var5 = var0.field_682_m[var4].iterator();

            while(var5.hasNext()) {
                Entity var6 = (Entity)var5.next();
                var0.field_677_r = true;
                var7 = new NBTTagCompound();
                if (var6.func_95_c(var7)) {
                    var3.func_386_a(var7);
                }
            }
        }

        var2.func_399_a("Entities", var3);
        NBTTagList var8 = new NBTTagList();
        var5 = var0.field_683_l.values().iterator();

        while(var5.hasNext()) {
            TileEntity var9 = (TileEntity)var5.next();
            var7 = new NBTTagCompound();
            var9.func_188_b(var7);
            var8.func_386_a(var7);
        }

        var2.func_399_a("TileEntities", var8);
    }

    public static Chunk func_664_a(World var0, NBTTagCompound var1) {
        int var2 = var1.func_395_d("xPos");
        int var3 = var1.func_395_d("zPos");
        Chunk var4 = new Chunk(var0, var2, var3);
        var4.field_693_b = var1.func_400_i("Blocks");
        var4.field_690_e = new NibbleArray(var1.func_400_i("Data"));
        var4.field_689_f = new NibbleArray(var1.func_400_i("SkyLight"));
        var4.field_688_g = new NibbleArray(var1.func_400_i("BlockLight"));
        var4.field_687_h = var1.func_400_i("HeightMap");
        var4.field_681_n = var1.func_402_l("TerrainPopulated");
        if (!var4.field_690_e.func_560_a()) {
            var4.field_690_e = new NibbleArray(var4.field_693_b.length);
        }

        if (var4.field_687_h == null || !var4.field_689_f.func_560_a()) {
            var4.field_687_h = new byte[256];
            var4.field_689_f = new NibbleArray(var4.field_693_b.length);
            var4.func_353_b();
        }

        if (!var4.field_688_g.func_560_a()) {
            var4.field_688_g = new NibbleArray(var4.field_693_b.length);
            var4.func_348_a();
        }

        NBTTagList var5 = var1.func_407_k("Entities");
        if (var5 != null) {
            for(int var6 = 0; var6 < var5.func_387_b(); ++var6) {
                NBTTagCompound var7 = (NBTTagCompound)var5.func_388_a(var6);
                Entity var8 = EntityList.func_566_a(var7, var0);
                var4.field_677_r = true;
                if (var8 != null) {
                    var4.func_335_a(var8);
                }
            }
        }

        NBTTagList var10 = var1.func_407_k("TileEntities");
        if (var10 != null) {
            for(int var11 = 0; var11 < var10.func_387_b(); ++var11) {
                NBTTagCompound var12 = (NBTTagCompound)var10.func_388_a(var11);
                TileEntity var9 = TileEntity.func_185_c(var12);
                if (var9 != null) {
                    var4.func_349_a(var9);
                }
            }
        }

        return var4;
    }

    public void func_661_a() {
    }

    public void func_660_b() {
    }

    public void func_4104_b(World var1, Chunk var2) throws IOException {
    }
}
