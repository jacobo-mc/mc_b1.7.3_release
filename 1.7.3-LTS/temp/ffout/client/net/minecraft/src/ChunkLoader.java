package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ChunkLoader implements IChunkLoader {
    private File field_1200_a;
    private boolean field_1199_b;

    public ChunkLoader(File var1, boolean var2) {
        this.field_1200_a = var1;
        this.field_1199_b = var2;
    }

    private File func_817_a(int var1, int var2) {
        String var3 = "c." + Integer.toString(var1, 36) + "." + Integer.toString(var2, 36) + ".dat";
        String var4 = Integer.toString(var1 & 63, 36);
        String var5 = Integer.toString(var2 & 63, 36);
        File var6 = new File(this.field_1200_a, var4);
        if (!var6.exists()) {
            if (!this.field_1199_b) {
                return null;
            }

            var6.mkdir();
        }

        var6 = new File(var6, var5);
        if (!var6.exists()) {
            if (!this.field_1199_b) {
                return null;
            }

            var6.mkdir();
        }

        var6 = new File(var6, var3);
        return !var6.exists() && !this.field_1199_b ? null : var6;
    }

    public Chunk func_813_a(World var1, int var2, int var3) throws IOException {
        File var4 = this.func_817_a(var2, var3);
        if (var4 != null && var4.exists()) {
            try {
                FileInputStream var5 = new FileInputStream(var4);
                NBTTagCompound var6 = CompressedStreamTools.func_1138_a(var5);
                if (!var6.func_751_b("Level")) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
                    return null;
                }

                if (!var6.func_743_k("Level").func_751_b("Blocks")) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
                    return null;
                }

                Chunk var7 = func_816_a(var1, var6.func_743_k("Level"));
                if (!var7.func_1017_a(var2, var3)) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var7.field_1531_j + ", " + var7.field_1530_k + ")");
                    var6.func_758_a("xPos", var2);
                    var6.func_758_a("zPos", var3);
                    var7 = func_816_a(var1, var6.func_743_k("Level"));
                }

                var7.func_25124_i();
                return var7;
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }

        return null;
    }

    public void func_812_a(World var1, Chunk var2) throws IOException {
        var1.func_663_l();
        File var3 = this.func_817_a(var2.field_1531_j, var2.field_1530_k);
        if (var3.exists()) {
            WorldInfo var4 = var1.func_22144_v();
            var4.func_22297_b(var4.func_22306_g() - var3.length());
        }

        try {
            File var10 = new File(this.field_1200_a, "tmp_chunk.dat");
            FileOutputStream var5 = new FileOutputStream(var10);
            NBTTagCompound var6 = new NBTTagCompound();
            NBTTagCompound var7 = new NBTTagCompound();
            var6.func_762_a("Level", var7);
            func_818_a(var2, var1, var7);
            CompressedStreamTools.func_1143_a(var6, var5);
            var5.close();
            if (var3.exists()) {
                var3.delete();
            }

            var10.renameTo(var3);
            WorldInfo var8 = var1.func_22144_v();
            var8.func_22297_b(var8.func_22306_g() + var3.length());
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public static void func_818_a(Chunk var0, World var1, NBTTagCompound var2) {
        var1.func_663_l();
        var2.func_758_a("xPos", var0.field_1531_j);
        var2.func_758_a("zPos", var0.field_1530_k);
        var2.func_750_a("LastUpdate", var1.func_22139_r());
        var2.func_747_a("Blocks", var0.field_1539_b);
        var2.func_747_a("Data", var0.field_1536_e.field_1109_a);
        var2.func_747_a("SkyLight", var0.field_1535_f.field_1109_a);
        var2.func_747_a("BlockLight", var0.field_1534_g.field_1109_a);
        var2.func_747_a("HeightMap", var0.field_1533_h);
        var2.func_748_a("TerrainPopulated", var0.field_1527_n);
        var0.field_1523_r = false;
        NBTTagList var3 = new NBTTagList();

        Iterator var5;
        NBTTagCompound var7;
        for(int var4 = 0; var4 < var0.field_1528_m.length; ++var4) {
            var5 = var0.field_1528_m[var4].iterator();

            while(var5.hasNext()) {
                Entity var6 = (Entity)var5.next();
                var0.field_1523_r = true;
                var7 = new NBTTagCompound();
                if (var6.func_358_c(var7)) {
                    var3.func_742_a(var7);
                }
            }
        }

        var2.func_762_a("Entities", var3);
        NBTTagList var8 = new NBTTagList();
        var5 = var0.field_1529_l.values().iterator();

        while(var5.hasNext()) {
            TileEntity var9 = (TileEntity)var5.next();
            var7 = new NBTTagCompound();
            var9.func_481_b(var7);
            var8.func_742_a(var7);
        }

        var2.func_762_a("TileEntities", var8);
    }

    public static Chunk func_816_a(World var0, NBTTagCompound var1) {
        int var2 = var1.func_756_e("xPos");
        int var3 = var1.func_756_e("zPos");
        Chunk var4 = new Chunk(var0, var2, var3);
        var4.field_1539_b = var1.func_759_j("Blocks");
        var4.field_1536_e = new NibbleArray(var1.func_759_j("Data"));
        var4.field_1535_f = new NibbleArray(var1.func_759_j("SkyLight"));
        var4.field_1534_g = new NibbleArray(var1.func_759_j("BlockLight"));
        var4.field_1533_h = var1.func_759_j("HeightMap");
        var4.field_1527_n = var1.func_760_m("TerrainPopulated");
        if (!var4.field_1536_e.func_769_a()) {
            var4.field_1536_e = new NibbleArray(var4.field_1539_b.length);
        }

        if (var4.field_1533_h == null || !var4.field_1535_f.func_769_a()) {
            var4.field_1533_h = new byte[256];
            var4.field_1535_f = new NibbleArray(var4.field_1539_b.length);
            var4.func_1024_c();
        }

        if (!var4.field_1534_g.func_769_a()) {
            var4.field_1534_g = new NibbleArray(var4.field_1539_b.length);
            var4.func_1014_a();
        }

        NBTTagList var5 = var1.func_753_l("Entities");
        if (var5 != null) {
            for(int var6 = 0; var6 < var5.func_740_c(); ++var6) {
                NBTTagCompound var7 = (NBTTagCompound)var5.func_741_a(var6);
                Entity var8 = EntityList.func_1081_a(var7, var0);
                var4.field_1523_r = true;
                if (var8 != null) {
                    var4.func_1000_a(var8);
                }
            }
        }

        NBTTagList var10 = var1.func_753_l("TileEntities");
        if (var10 != null) {
            for(int var11 = 0; var11 < var10.func_740_c(); ++var11) {
                NBTTagCompound var12 = (NBTTagCompound)var10.func_741_a(var11);
                TileEntity var9 = TileEntity.func_477_c(var12);
                if (var9 != null) {
                    var4.func_1001_a(var9);
                }
            }
        }

        return var4;
    }

    public void func_814_a() {
    }

    public void func_811_b() {
    }

    public void func_815_b(World var1, Chunk var2) throws IOException {
    }
}
