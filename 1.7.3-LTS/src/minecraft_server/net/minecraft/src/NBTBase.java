package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTBase {
    private String key = null;

    abstract void writeTagContents(DataOutput var1) throws IOException;

    abstract void readTagContents(DataInput var1) throws IOException;

    public abstract byte getType();

    public String getKey() {
        return this.key == null ? "" : this.key;
    }

    public NBTBase setKey(String var1) {
        this.key = var1;
        return this;
    }

    public static NBTBase readTag(DataInput var0) throws IOException {
        byte var1 = var0.readByte();
        if (var1 == 0) {
            return new NBTTagEnd();
        } else {
            NBTBase var2 = createTagOfType(var1);
            var2.key = var0.readUTF();
            var2.readTagContents(var0);
            return var2;
        }
    }

    public static void writeTag(NBTBase var0, DataOutput var1) throws IOException {
        var1.writeByte(var0.getType());
        if (var0.getType() != 0) {
            var1.writeUTF(var0.getKey());
            var0.writeTagContents(var1);
        }
    }

    public static NBTBase createTagOfType(byte var0) {
        switch(var0) {
        case 0:
            return new NBTTagEnd();
        case 1:
            return new NBTTagByte();
        case 2:
            return new NBTTagShort();
        case 3:
            return new NBTTagInt();
        case 4:
            return new NBTTagLong();
        case 5:
            return new NBTTagFloat();
        case 6:
            return new NBTTagDouble();
        case 7:
            return new NBTTagByteArray();
        case 8:
            return new NBTTagString();
        case 9:
            return new NBTTagList();
        case 10:
            return new NBTTagCompound();
        default:
            return null;
        }
    }

    public static String getTagName(byte var0) {
        switch(var0) {
        case 0:
            return "TAG_End";
        case 1:
            return "TAG_Byte";
        case 2:
            return "TAG_Short";
        case 3:
            return "TAG_Int";
        case 4:
            return "TAG_Long";
        case 5:
            return "TAG_Float";
        case 6:
            return "TAG_Double";
        case 7:
            return "TAG_Byte_Array";
        case 8:
            return "TAG_String";
        case 9:
            return "TAG_List";
        case 10:
            return "TAG_Compound";
        default:
            return "UNKNOWN";
        }
    }
}
