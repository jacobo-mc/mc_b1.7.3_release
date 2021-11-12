package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NBTTagCompound extends NBTBase {
    private Map tagMap = new HashMap();

    void writeTagContents(DataOutput var1) throws IOException {
        Iterator var2 = this.tagMap.values().iterator();

        while(var2.hasNext()) {
            NBTBase var3 = (NBTBase)var2.next();
            NBTBase.writeTag(var3, var1);
        }

        var1.writeByte(0);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.tagMap.clear();

        NBTBase var2;
        while((var2 = NBTBase.readTag(var1)).getType() != 0) {
            this.tagMap.put(var2.getKey(), var2);
        }

    }

    public Collection func_28107_c() {
        return this.tagMap.values();
    }

    public byte getType() {
        return 10;
    }

    public void setTag(String var1, NBTBase var2) {
        this.tagMap.put(var1, var2.setKey(var1));
    }

    public void setByte(String var1, byte var2) {
        this.tagMap.put(var1, (new NBTTagByte(var2)).setKey(var1));
    }

    public void setShort(String var1, short var2) {
        this.tagMap.put(var1, (new NBTTagShort(var2)).setKey(var1));
    }

    public void setInteger(String var1, int var2) {
        this.tagMap.put(var1, (new NBTTagInt(var2)).setKey(var1));
    }

    public void setLong(String var1, long var2) {
        this.tagMap.put(var1, (new NBTTagLong(var2)).setKey(var1));
    }

    public void setFloat(String var1, float var2) {
        this.tagMap.put(var1, (new NBTTagFloat(var2)).setKey(var1));
    }

    public void setDouble(String var1, double var2) {
        this.tagMap.put(var1, (new NBTTagDouble(var2)).setKey(var1));
    }

    public void setString(String var1, String var2) {
        this.tagMap.put(var1, (new NBTTagString(var2)).setKey(var1));
    }

    public void setByteArray(String var1, byte[] var2) {
        this.tagMap.put(var1, (new NBTTagByteArray(var2)).setKey(var1));
    }

    public void setCompoundTag(String var1, NBTTagCompound var2) {
        this.tagMap.put(var1, var2.setKey(var1));
    }

    public void setBoolean(String var1, boolean var2) {
        this.setByte(var1, (byte)(var2 ? 1 : 0));
    }

    public boolean hasKey(String var1) {
        return this.tagMap.containsKey(var1);
    }

    public byte getByte(String var1) {
        return !this.tagMap.containsKey(var1) ? 0 : ((NBTTagByte)this.tagMap.get(var1)).byteValue;
    }

    public short getShort(String var1) {
        return !this.tagMap.containsKey(var1) ? 0 : ((NBTTagShort)this.tagMap.get(var1)).shortValue;
    }

    public int getInteger(String var1) {
        return !this.tagMap.containsKey(var1) ? 0 : ((NBTTagInt)this.tagMap.get(var1)).intValue;
    }

    public long getLong(String var1) {
        return !this.tagMap.containsKey(var1) ? 0L : ((NBTTagLong)this.tagMap.get(var1)).longValue;
    }

    public float getFloat(String var1) {
        return !this.tagMap.containsKey(var1) ? 0.0F : ((NBTTagFloat)this.tagMap.get(var1)).floatValue;
    }

    public double getDouble(String var1) {
        return !this.tagMap.containsKey(var1) ? 0.0D : ((NBTTagDouble)this.tagMap.get(var1)).doubleValue;
    }

    public String getString(String var1) {
        return !this.tagMap.containsKey(var1) ? "" : ((NBTTagString)this.tagMap.get(var1)).stringValue;
    }

    public byte[] getByteArray(String var1) {
        return !this.tagMap.containsKey(var1) ? new byte[0] : ((NBTTagByteArray)this.tagMap.get(var1)).byteArray;
    }

    public NBTTagCompound getCompoundTag(String var1) {
        return !this.tagMap.containsKey(var1) ? new NBTTagCompound() : (NBTTagCompound)this.tagMap.get(var1);
    }

    public NBTTagList getTagList(String var1) {
        return !this.tagMap.containsKey(var1) ? new NBTTagList() : (NBTTagList)this.tagMap.get(var1);
    }

    public boolean getBoolean(String var1) {
        return this.getByte(var1) != 0;
    }

    public String toString() {
        return "" + this.tagMap.size() + " entries";
    }
}
