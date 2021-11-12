package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataWatcher {
    private static final HashMap dataTypes = new HashMap();
    private final Map watchedObjects = new HashMap();
    private boolean objectChanged;

    public void addObject(int var1, Object var2) {
        Integer var3 = (Integer)dataTypes.get(var2.getClass());
        if (var3 == null) {
            throw new IllegalArgumentException("Unknown data type: " + var2.getClass());
        } else if (var1 > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + var1 + "! (Max is " + 31 + ")");
        } else if (this.watchedObjects.containsKey(var1)) {
            throw new IllegalArgumentException("Duplicate id value for " + var1 + "!");
        } else {
            WatchableObject var4 = new WatchableObject(var3, var1, var2);
            this.watchedObjects.put(var1, var4);
        }
    }

    public byte getWatchableObjectByte(int var1) {
        return (Byte)((WatchableObject)this.watchedObjects.get(var1)).getObject();
    }

    public int getWatchableObjectInt(int var1) {
        return (Integer)((WatchableObject)this.watchedObjects.get(var1)).getObject();
    }

    public String getWatchableObjectString(int var1) {
        return (String)((WatchableObject)this.watchedObjects.get(var1)).getObject();
    }

    public void updateObject(int var1, Object var2) {
        WatchableObject var3 = (WatchableObject)this.watchedObjects.get(var1);
        if (!var2.equals(var3.getObject())) {
            var3.setObject(var2);
            var3.setWatching(true);
            this.objectChanged = true;
        }

    }

    public static void writeObjectsInListToStream(List var0, DataOutputStream var1) throws IOException {
        if (var0 != null) {
            Iterator var2 = var0.iterator();

            while(var2.hasNext()) {
                WatchableObject var3 = (WatchableObject)var2.next();
                writeWatchableObject(var1, var3);
            }
        }

        var1.writeByte(127);
    }

    public void writeWatchableObjects(DataOutputStream var1) throws IOException {
        Iterator var2 = this.watchedObjects.values().iterator();

        while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            writeWatchableObject(var1, var3);
        }

        var1.writeByte(127);
    }

    private static void writeWatchableObject(DataOutputStream var0, WatchableObject var1) throws IOException {
        int var2 = (var1.getObjectType() << 5 | var1.getDataValueId() & 31) & 255;
        var0.writeByte(var2);
        switch(var1.getObjectType()) {
        case 0:
            var0.writeByte((Byte)var1.getObject());
            break;
        case 1:
            var0.writeShort((Short)var1.getObject());
            break;
        case 2:
            var0.writeInt((Integer)var1.getObject());
            break;
        case 3:
            var0.writeFloat((Float)var1.getObject());
            break;
        case 4:
            Packet.writeString((String)var1.getObject(), var0);
            break;
        case 5:
            ItemStack var4 = (ItemStack)var1.getObject();
            var0.writeShort(var4.getItem().shiftedIndex);
            var0.writeByte(var4.stackSize);
            var0.writeShort(var4.getItemDamage());
            break;
        case 6:
            ChunkCoordinates var3 = (ChunkCoordinates)var1.getObject();
            var0.writeInt(var3.x);
            var0.writeInt(var3.y);
            var0.writeInt(var3.z);
        }

    }

    public static List readWatchableObjects(DataInputStream var0) throws IOException {
        ArrayList var1 = null;

        for(byte var2 = var0.readByte(); var2 != 127; var2 = var0.readByte()) {
            if (var1 == null) {
                var1 = new ArrayList();
            }

            int var3 = (var2 & 224) >> 5;
            int var4 = var2 & 31;
            WatchableObject var5 = null;
            switch(var3) {
            case 0:
                var5 = new WatchableObject(var3, var4, var0.readByte());
                break;
            case 1:
                var5 = new WatchableObject(var3, var4, var0.readShort());
                break;
            case 2:
                var5 = new WatchableObject(var3, var4, var0.readInt());
                break;
            case 3:
                var5 = new WatchableObject(var3, var4, var0.readFloat());
                break;
            case 4:
                var5 = new WatchableObject(var3, var4, Packet.readString(var0, 64));
                break;
            case 5:
                short var9 = var0.readShort();
                byte var10 = var0.readByte();
                short var11 = var0.readShort();
                var5 = new WatchableObject(var3, var4, new ItemStack(var9, var10, var11));
                break;
            case 6:
                int var6 = var0.readInt();
                int var7 = var0.readInt();
                int var8 = var0.readInt();
                var5 = new WatchableObject(var3, var4, new ChunkCoordinates(var6, var7, var8));
            }

            var1.add(var5);
        }

        return var1;
    }

    public void updateWatchedObjectsFromList(List var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            WatchableObject var4 = (WatchableObject)this.watchedObjects.get(var3.getDataValueId());
            if (var4 != null) {
                var4.setObject(var3.getObject());
            }
        }

    }

    static {
        dataTypes.put(Byte.class, 0);
        dataTypes.put(Short.class, 1);
        dataTypes.put(Integer.class, 2);
        dataTypes.put(Float.class, 3);
        dataTypes.put(String.class, 4);
        dataTypes.put(ItemStack.class, 5);
        dataTypes.put(ChunkCoordinates.class, 6);
    }
}
