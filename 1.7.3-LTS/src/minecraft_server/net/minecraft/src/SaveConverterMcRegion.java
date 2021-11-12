package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

public class SaveConverterMcRegion extends SaveFormatOld {
    public SaveConverterMcRegion(File var1) {
        super(var1);
    }

    public ISaveHandler func_22105_a(String var1, boolean var2) {
        return new SaveOldDir(this.field_22106_a, var1, var2);
    }

    public boolean isOldSaveType(String var1) {
        WorldInfo var2 = this.getWorldInfo(var1);
        return var2 != null && var2.getVersion() == 0;
    }

    public boolean converMapToMCRegion(String var1, IProgressUpdate var2) {
        var2.setLoadingProgress(0);
        ArrayList var3 = new ArrayList();
        ArrayList var4 = new ArrayList();
        ArrayList var5 = new ArrayList();
        ArrayList var6 = new ArrayList();
        File var7 = new File(this.field_22106_a, var1);
        File var8 = new File(var7, "DIM-1");
        System.out.println("Scanning folders...");
        this.func_22108_a(var7, var3, var4);
        if (var8.exists()) {
            this.func_22108_a(var8, var5, var6);
        }

        int var9 = var3.size() + var5.size() + var4.size() + var6.size();
        System.out.println("Total conversion count is " + var9);
        this.func_22107_a(var7, var3, 0, var9, var2);
        this.func_22107_a(var8, var5, var3.size(), var9, var2);
        WorldInfo var10 = this.getWorldInfo(var1);
        var10.setVersion(19132);
        ISaveHandler var11 = this.func_22105_a(var1, false);
        var11.func_22094_a(var10);
        this.func_22109_a(var4, var3.size() + var5.size(), var9, var2);
        if (var8.exists()) {
            this.func_22109_a(var6, var3.size() + var5.size() + var4.size(), var9, var2);
        }

        return true;
    }

    private void func_22108_a(File var1, ArrayList var2, ArrayList var3) {
        ChunkFolderPattern var4 = new ChunkFolderPattern((Empty2)null);
        ChunkFilePattern var5 = new ChunkFilePattern((Empty2)null);
        File[] var6 = var1.listFiles(var4);
        File[] var7 = var6;
        int var8 = var6.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            File var10 = var7[var9];
            var3.add(var10);
            File[] var11 = var10.listFiles(var4);
            File[] var12 = var11;
            int var13 = var11.length;

            for(int var14 = 0; var14 < var13; ++var14) {
                File var15 = var12[var14];
                File[] var16 = var15.listFiles(var5);
                File[] var17 = var16;
                int var18 = var16.length;

                for(int var19 = 0; var19 < var18; ++var19) {
                    File var20 = var17[var19];
                    var2.add(new ChunkFile(var20));
                }
            }
        }

    }

    private void func_22107_a(File var1, ArrayList var2, int var3, int var4, IProgressUpdate var5) {
        Collections.sort(var2);
        byte[] var6 = new byte[4096];
        Iterator var7 = var2.iterator();

        while(var7.hasNext()) {
            ChunkFile var8 = (ChunkFile)var7.next();
            int var9 = var8.func_22205_b();
            int var10 = var8.func_22204_c();
            RegionFile var11 = RegionFileCache.func_22123_a(var1, var9, var10);
            if (!var11.isChunkSaved(var9 & 31, var10 & 31)) {
                try {
                    DataInputStream var12 = new DataInputStream(new GZIPInputStream(new FileInputStream(var8.func_22207_a())));
                    DataOutputStream var13 = var11.getChunkDataOutputStream(var9 & 31, var10 & 31);
                    boolean var14 = false;

                    int var17;
                    while((var17 = var12.read(var6)) != -1) {
                        var13.write(var6, 0, var17);
                    }

                    var13.close();
                    var12.close();
                } catch (IOException var15) {
                    var15.printStackTrace();
                }
            }

            ++var3;
            int var16 = (int)Math.round(100.0D * (double)var3 / (double)var4);
            var5.setLoadingProgress(var16);
        }

        RegionFileCache.func_22122_a();
    }

    private void func_22109_a(ArrayList var1, int var2, int var3, IProgressUpdate var4) {
        Iterator var5 = var1.iterator();

        while(var5.hasNext()) {
            File var6 = (File)var5.next();
            File[] var7 = var6.listFiles();
            func_22104_a(var7);
            var6.delete();
            ++var2;
            int var8 = (int)Math.round(100.0D * (double)var2 / (double)var3);
            var4.setLoadingProgress(var8);
        }

    }
}
