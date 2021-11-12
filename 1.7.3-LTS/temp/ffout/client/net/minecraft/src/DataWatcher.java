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
    private static final HashMap field_21133_a = new HashMap();
    private final Map field_21132_b = new HashMap();
    private boolean field_21134_c;

    public void func_21124_a(int var1, Object var2) {
        Integer var3 = (Integer)field_21133_a.get(var2.getClass());
        if (var3 == null) {
            throw new IllegalArgumentException("Unknown data type: " + var2.getClass());
        } else if (var1 > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + var1 + "! (Max is " + 31 + ")");
        } else if (this.field_21132_b.containsKey(var1)) {
            throw new IllegalArgumentException("Duplicate id value for " + var1 + "!");
        } else {
            WatchableObject var4 = new WatchableObject(var3, var1, var2);
            this.field_21132_b.put(var1, var4);
        }
    }

    public byte func_21130_a(int var1) {
        return (Byte)((WatchableObject)this.field_21132_b.get(var1)).func_21158_b();
    }

    public int func_25115_b(int var1) {
        return (Integer)((WatchableObject)this.field_21132_b.get(var1)).func_21158_b();
    }

    public String func_25116_c(int var1) {
        return (String)((WatchableObject)this.field_21132_b.get(var1)).func_21158_b();
    }

    public void func_21129_b(int var1, Object var2) {
        WatchableObject var3 = (WatchableObject)this.field_21132_b.get(var1);
        if (!var2.equals(var3.func_21158_b())) {
            var3.func_21160_a(var2);
            var3.func_21162_a(true);
            this.field_21134_c = true;
        }

    }

    public static void func_21125_a(List var0, DataOutputStream var1) throws IOException {
        if (var0 != null) {
            Iterator var2 = var0.iterator();

            while(var2.hasNext()) {
                WatchableObject var3 = (WatchableObject)var2.next();
                func_21128_a(var1, var3);
            }
        }

        var1.writeByte(127);
    }

    public void func_21127_a(DataOutputStream var1) throws IOException {
        Iterator var2 = this.field_21132_b.values().iterator();

        while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            func_21128_a(var1, var3);
        }

        var1.writeByte(127);
    }

    private static void func_21128_a(DataOutputStream var0, WatchableObject var1) throws IOException {
        int var2 = (var1.func_21159_c() << 5 | var1.func_21161_a() & 31) & 255;
        var0.writeByte(var2);
        switch(var1.func_21159_c()) {
        case 0:
            var0.writeByte((Byte)var1.func_21158_b());
            break;
        case 1:
            var0.writeShort((Short)var1.func_21158_b());
            break;
        case 2:
            var0.writeInt((Integer)var1.func_21158_b());
            break;
        case 3:
            var0.writeFloat((Float)var1.func_21158_b());
            break;
        case 4:
            Packet.func_27049_a((String)var1.func_21158_b(), var0);
            break;
        case 5:
            ItemStack var4 = (ItemStack)var1.func_21158_b();
            var0.writeShort(var4.func_1091_a().field_291_aS);
            var0.writeByte(var4.field_1615_a);
            var0.writeShort(var4.func_21181_i());
            break;
        case 6:
            ChunkCoordinates var3 = (ChunkCoordinates)var1.func_21158_b();
            var0.writeInt(var3.field_22395_a);
            var0.writeInt(var3.field_22394_b);
            var0.writeInt(var3.field_22396_c);
        }

    }

    public static List func_21131_a(DataInputStream var0) throws IOException {
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
                var5 = new WatchableObject(var3, var4, Packet.func_27048_a(var0, 64));
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

    public void func_21126_a(List var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            WatchableObject var4 = (WatchableObject)this.field_21132_b.get(var3.func_21161_a());
            if (var4 != null) {
                var4.func_21160_a(var3.func_21158_b());
            }
        }

    }

    static {
        field_21133_a.put(Byte.class, 0);
        field_21133_a.put(Short.class, 1);
        field_21133_a.put(Integer.class, 2);
        field_21133_a.put(Float.class, 3);
        field_21133_a.put(String.class, 4);
        field_21133_a.put(ItemStack.class, 5);
        field_21133_a.put(ChunkCoordinates.class, 6);
    }
}
