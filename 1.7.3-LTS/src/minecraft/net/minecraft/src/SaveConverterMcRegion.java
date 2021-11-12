package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class SaveConverterMcRegion extends SaveFormatOld {
    public SaveConverterMcRegion(File var1) {
        super(var1);
    }

    public String getWorldFormat() {
        return "Scaevolus' McRegion";
    }

    public List getSaveList() {
        ArrayList var1 = new ArrayList();
        File[] var2 = this.field_22180_a.listFiles();
        File[] var3 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File var6 = var3[var5];
            if (var6.isDirectory()) {
                String var7 = var6.getName();
                WorldInfo var8 = this.getWorldInfo(var7);
                if (var8 != null) {
                    boolean var9 = var8.getSaveVersion() != 19132;
                    String var10 = var8.getWorldName();
                    if (var10 == null || MathHelper.stringNullOrLengthZero(var10)) {
                        var10 = var7;
                    }

                    var1.add(new SaveFormatComparator(var7, var10, var8.getLastTimePlayed(), var8.getSizeOnDisk(), var9));
                }
            }
        }

        return var1;
    }

    public void flushCache() {
        RegionFileCache.func_22192_a();
    }

    public ISaveHandler getSaveLoader(String var1, boolean var2) {
        return new SaveOldDir(this.field_22180_a, var1, var2);
    }

    public boolean isOldMapFormat(String var1) {
        WorldInfo var2 = this.getWorldInfo(var1);
        return var2 != null && var2.getSaveVersion() == 0;
    }

    public boolean convertMapFormat(String var1, IProgressUpdate var2) {
        var2.setLoadingProgress(0);
        ArrayList var3 = new ArrayList();
        ArrayList var4 = new ArrayList();
        ArrayList var5 = new ArrayList();
        ArrayList var6 = new ArrayList();
        File var7 = new File(this.field_22180_a, var1);
        File var8 = new File(var7, "DIM-1");
        System.out.println("Scanning folders...");
        this.func_22183_a(var7, var3, var4);
        if (var8.exists()) {
            this.func_22183_a(var8, var5, var6);
        }

        int var9 = var3.size() + var5.size() + var4.size() + var6.size();
        System.out.println("Total conversion count is " + var9);
        this.func_22181_a(var7, var3, 0, var9, var2);
        this.func_22181_a(var8, var5, var3.size(), var9, var2);
        WorldInfo var10 = this.getWorldInfo(var1);
        var10.setSaveVersion(19132);
        ISaveHandler var11 = this.getSaveLoader(var1, false);
        var11.saveWorldInfo(var10);
        this.func_22182_a(var4, var3.size() + var5.size(), var9, var2);
        if (var8.exists()) {
            this.func_22182_a(var6, var3.size() + var5.size() + var4.size(), var9, var2);
        }

        return true;
    }

    private void func_22183_a(File var1, ArrayList var2, ArrayList var3) {
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

    private void func_22181_a(File var1, ArrayList var2, int var3, int var4, IProgressUpdate var5) {
        Collections.sort(var2);
        byte[] var6 = new byte[4096];
        Iterator var7 = var2.iterator();

        while(var7.hasNext()) {
            ChunkFile var8 = (ChunkFile)var7.next();
            int var9 = var8.getXChunk();
            int var10 = var8.getYChunk();
            RegionFile var11 = RegionFileCache.func_22193_a(var1, var9, var10);
            if (!var11.func_22202_c(var9 & 31, var10 & 31)) {
                try {
                    DataInputStream var12 = new DataInputStream(new GZIPInputStream(new FileInputStream(var8.getChunkFile())));
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

        RegionFileCache.func_22192_a();
    }

    private void func_22182_a(ArrayList var1, int var2, int var3, IProgressUpdate var4) {
        Iterator var5 = var1.iterator();

        while(var5.hasNext()) {
            File var6 = (File)var5.next();
            File[] var7 = var6.listFiles();
            func_22179_a(var7);
            var6.delete();
            ++var2;
            int var8 = (int)Math.round(100.0D * (double)var2 / (double)var3);
            var4.setLoadingProgress(var8);
        }

    }
}
