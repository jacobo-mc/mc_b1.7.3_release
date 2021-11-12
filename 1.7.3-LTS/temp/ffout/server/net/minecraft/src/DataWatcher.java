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
    private static final HashMap field_21158_a = new HashMap();
    private final Map field_21157_b = new HashMap();
    private boolean field_21159_c;

    public void func_21153_a(int var1, Object var2) {
        Integer var3 = (Integer)field_21158_a.get(var2.getClass());
        if (var3 == null) {
            throw new IllegalArgumentException("Unknown data type: " + var2.getClass());
        } else if (var1 > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + var1 + "! (Max is " + 31 + ")");
        } else if (this.field_21157_b.containsKey(var1)) {
            throw new IllegalArgumentException("Duplicate id value for " + var1 + "!");
        } else {
            WatchableObject var4 = new WatchableObject(var3, var1, var2);
            this.field_21157_b.put(var1, var4);
        }
    }

    public byte func_21156_a(int var1) {
        return (Byte)((WatchableObject)this.field_21157_b.get(var1)).func_21168_b();
    }

    public int func_25075_b(int var1) {
        return (Integer)((WatchableObject)this.field_21157_b.get(var1)).func_21168_b();
    }

    public String func_25076_c(int var1) {
        return (String)((WatchableObject)this.field_21157_b.get(var1)).func_21168_b();
    }

    public void func_21155_b(int var1, Object var2) {
        WatchableObject var3 = (WatchableObject)this.field_21157_b.get(var1);
        if (!var2.equals(var3.func_21168_b())) {
            var3.func_21171_a(var2);
            var3.func_21173_a(true);
            this.field_21159_c = true;
        }

    }

    public boolean func_21150_a() {
        return this.field_21159_c;
    }

    public static void func_21151_a(List var0, DataOutputStream var1) throws IOException {
        if (var0 != null) {
            Iterator var2 = var0.iterator();

            while(var2.hasNext()) {
                WatchableObject var3 = (WatchableObject)var2.next();
                func_21154_a(var1, var3);
            }
        }

        var1.writeByte(127);
    }

    public ArrayList func_21148_b() {
        ArrayList var1 = null;
        if (this.field_21159_c) {
            Iterator var2 = this.field_21157_b.values().iterator();

            while(var2.hasNext()) {
                WatchableObject var3 = (WatchableObject)var2.next();
                if (var3.func_21170_d()) {
                    var3.func_21173_a(false);
                    if (var1 == null) {
                        var1 = new ArrayList();
                    }

                    var1.add(var3);
                }
            }
        }

        this.field_21159_c = false;
        return var1;
    }

    public void func_21152_a(DataOutputStream var1) throws IOException {
        Iterator var2 = this.field_21157_b.values().iterator();

        while(var2.hasNext()) {
            WatchableObject var3 = (WatchableObject)var2.next();
            func_21154_a(var1, var3);
        }

        var1.writeByte(127);
    }

    private static void func_21154_a(DataOutputStream var0, WatchableObject var1) throws IOException {
        int var2 = (var1.func_21169_c() << 5 | var1.func_21172_a() & 31) & 255;
        var0.writeByte(var2);
        switch(var1.func_21169_c()) {
        case 0:
            var0.writeByte((Byte)var1.func_21168_b());
            break;
        case 1:
            var0.writeShort((Short)var1.func_21168_b());
            break;
        case 2:
            var0.writeInt((Integer)var1.func_21168_b());
            break;
        case 3:
            var0.writeFloat((Float)var1.func_21168_b());
            break;
        case 4:
            Packet.func_27038_a((String)var1.func_21168_b(), var0);
            break;
        case 5:
            ItemStack var4 = (ItemStack)var1.func_21168_b();
            var0.writeShort(var4.func_569_a().field_234_aS);
            var0.writeByte(var4.field_853_a);
            var0.writeShort(var4.func_21125_h());
            break;
        case 6:
            ChunkCoordinates var3 = (ChunkCoordinates)var1.func_21168_b();
            var0.writeInt(var3.field_22216_a);
            var0.writeInt(var3.field_529_a);
            var0.writeInt(var3.field_528_b);
        }

    }

    public static List func_21149_a(DataInputStream var0) throws IOException {
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
                var5 = new WatchableObject(var3, var4, Packet.func_27037_a(var0, 64));
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

    static {
        field_21158_a.put(Byte.class, 0);
        field_21158_a.put(Short.class, 1);
        field_21158_a.put(Integer.class, 2);
        field_21158_a.put(Float.class, 3);
        field_21158_a.put(String.class, 4);
        field_21158_a.put(ItemStack.class, 5);
        field_21158_a.put(ChunkCoordinates.class, 6);
    }
}
