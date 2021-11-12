package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapStorage {
    private ISaveHandler saveHandler;
    private Map loadedDataMap = new HashMap();
    private List loadedDataList = new ArrayList();
    private Map idCounts = new HashMap();

    public MapStorage(ISaveHandler var1) {
        this.saveHandler = var1;
        this.loadIdCounts();
    }

    public MapDataBase loadData(Class var1, String var2) {
        MapDataBase var3 = (MapDataBase)this.loadedDataMap.get(var2);
        if (var3 != null) {
            return var3;
        } else {
            if (this.saveHandler != null) {
                try {
                    File var4 = this.saveHandler.getMapFile(var2);
                    if (var4 != null && var4.exists()) {
                        try {
                            var3 = (MapDataBase)var1.getConstructor(String.class).newInstance(var2);
                        } catch (Exception var7) {
                            throw new RuntimeException("Failed to instantiate " + var1.toString(), var7);
                        }

                        FileInputStream var5 = new FileInputStream(var4);
                        NBTTagCompound var6 = CompressedStreamTools.loadGzippedCompoundFromOutputStream(var5);
                        var5.close();
                        var3.readFromNBT(var6.getCompoundTag("data"));
                    }
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }

            if (var3 != null) {
                this.loadedDataMap.put(var2, var3);
                this.loadedDataList.add(var3);
            }

            return var3;
        }
    }

    public void setData(String var1, MapDataBase var2) {
        if (var2 == null) {
            throw new RuntimeException("Can't set null data");
        } else {
            if (this.loadedDataMap.containsKey(var1)) {
                this.loadedDataList.remove(this.loadedDataMap.remove(var1));
            }

            this.loadedDataMap.put(var1, var2);
            this.loadedDataList.add(var2);
        }
    }

    public void saveAllData() {
        for(int var1 = 0; var1 < this.loadedDataList.size(); ++var1) {
            MapDataBase var2 = (MapDataBase)this.loadedDataList.get(var1);
            if (var2.isDirty()) {
                this.saveData(var2);
                var2.setDirty(false);
            }
        }

    }

    private void saveData(MapDataBase var1) {
        if (this.saveHandler != null) {
            try {
                File var2 = this.saveHandler.getMapFile(var1.mapName);
                if (var2 != null) {
                    NBTTagCompound var3 = new NBTTagCompound();
                    var1.writeToNBT(var3);
                    NBTTagCompound var4 = new NBTTagCompound();
                    var4.setCompoundTag("data", var3);
                    FileOutputStream var5 = new FileOutputStream(var2);
                    CompressedStreamTools.writeGzippedCompoundToOutputStream(var4, var5);
                    var5.close();
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

        }
    }

    private void loadIdCounts() {
        try {
            this.idCounts.clear();
            if (this.saveHandler == null) {
                return;
            }

            File var1 = this.saveHandler.getMapFile("idcounts");
            if (var1 != null && var1.exists()) {
                DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
                NBTTagCompound var3 = CompressedStreamTools.read(var2);
                var2.close();
                Iterator var4 = var3.getTags().iterator();

                while(var4.hasNext()) {
                    NBTBase var5 = (NBTBase)var4.next();
                    if (var5 instanceof NBTTagShort) {
                        NBTTagShort var6 = (NBTTagShort)var5;
                        String var7 = var6.getKey();
                        short var8 = var6.shortValue;
                        this.idCounts.put(var7, var8);
                    }
                }
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public int getUniqueDataId(String var1) {
        Short var2 = (Short)this.idCounts.get(var1);
        if (var2 == null) {
            var2 = Short.valueOf((short)0);
        } else {
            var2 = (short)(var2 + 1);
        }

        this.idCounts.put(var1, var2);
        if (this.saveHandler == null) {
            return var2;
        } else {
            try {
                File var3 = this.saveHandler.getMapFile("idcounts");
                if (var3 != null) {
                    NBTTagCompound var4 = new NBTTagCompound();
                    Iterator var5 = this.idCounts.keySet().iterator();

                    while(var5.hasNext()) {
                        String var6 = (String)var5.next();
                        short var7 = (Short)this.idCounts.get(var6);
                        var4.setShort(var6, var7);
                    }

                    DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
                    CompressedStreamTools.write(var4, var9);
                    var9.close();
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return var2;
        }
    }
}
