package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Packet {
    private static Map field_39_a = new HashMap();
    private static Map field_38_b = new HashMap();
    private static Set field_27994_c = new HashSet();
    private static Set field_27993_d = new HashSet();
    public final long field_20009_j = System.currentTimeMillis();
    public boolean field_40_j = false;
    private static HashMap field_21904_c;
    private static int field_21903_d;

    static void func_64_a(int var0, boolean var1, boolean var2, Class var3) {
        if (field_39_a.containsKey(var0)) {
            throw new IllegalArgumentException("Duplicate packet id:" + var0);
        } else if (field_38_b.containsKey(var3)) {
            throw new IllegalArgumentException("Duplicate packet class:" + var3);
        } else {
            field_39_a.put(var0, var3);
            field_38_b.put(var3, var0);
            if (var1) {
                field_27994_c.add(var0);
            }

            if (var2) {
                field_27993_d.add(var0);
            }

        }
    }

    public static Packet func_67_a(int var0) {
        try {
            Class var1 = (Class)field_39_a.get(var0);
            return var1 == null ? null : (Packet)var1.newInstance();
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("Skipping packet with id " + var0);
            return null;
        }
    }

    public final int func_69_b() {
        return (Integer)field_38_b.get(this.getClass());
    }

    public static Packet func_65_b(DataInputStream var0, boolean var1) throws IOException {
        boolean var2 = false;
        Packet var3 = null;

        int var6;
        try {
            var6 = var0.read();
            if (var6 == -1) {
                return null;
            }

            if (var1 && !field_27993_d.contains(var6) || !var1 && !field_27994_c.contains(var6)) {
                throw new IOException("Bad packet id " + var6);
            }

            var3 = func_67_a(var6);
            if (var3 == null) {
                throw new IOException("Bad packet id " + var6);
            }

            var3.func_70_a(var0);
        } catch (EOFException var5) {
            System.out.println("Reached end of stream");
            return null;
        }

        PacketCounter var4 = (PacketCounter)field_21904_c.get(var6);
        if (var4 == null) {
            var4 = new PacketCounter((Empty1)null);
            field_21904_c.put(var6, var4);
        }

        var4.func_22150_a(var3.func_71_a());
        ++field_21903_d;
        if (field_21903_d % 1000 == 0) {
        }

        return var3;
    }

    public static void func_66_a(Packet var0, DataOutputStream var1) throws IOException {
        var1.write(var0.func_69_b());
        var0.func_68_a(var1);
    }

    public static void func_27038_a(String var0, DataOutputStream var1) throws IOException {
        if (var0.length() > 32767) {
            throw new IOException("String too big");
        } else {
            var1.writeShort(var0.length());
            var1.writeChars(var0);
        }
    }

    public static String func_27037_a(DataInputStream var0, int var1) throws IOException {
        short var2 = var0.readShort();
        if (var2 > var1) {
            throw new IOException("Received string length longer than maximum allowed (" + var2 + " > " + var1 + ")");
        } else if (var2 < 0) {
            throw new IOException("Received string length is less than zero! Weird string!");
        } else {
            StringBuilder var3 = new StringBuilder();

            for(int var4 = 0; var4 < var2; ++var4) {
                var3.append(var0.readChar());
            }

            return var3.toString();
        }
    }

    public abstract void func_70_a(DataInputStream var1) throws IOException;

    public abstract void func_68_a(DataOutputStream var1) throws IOException;

    public abstract void func_72_a(NetHandler var1);

    public abstract int func_71_a();

    static {
        func_64_a(0, true, true, Packet0KeepAlive.class);
        func_64_a(1, true, true, Packet1Login.class);
        func_64_a(2, true, true, Packet2Handshake.class);
        func_64_a(3, true, true, Packet3Chat.class);
        func_64_a(4, true, false, Packet4UpdateTime.class);
        func_64_a(5, true, false, Packet5PlayerInventory.class);
        func_64_a(6, true, false, Packet6SpawnPosition.class);
        func_64_a(7, false, true, Packet7UseEntity.class);
        func_64_a(8, true, false, Packet8UpdateHealth.class);
        func_64_a(9, true, true, Packet9Respawn.class);
        func_64_a(10, true, true, Packet10Flying.class);
        func_64_a(11, true, true, Packet11PlayerPosition.class);
        func_64_a(12, true, true, Packet12PlayerLook.class);
        func_64_a(13, true, true, Packet13PlayerLookMove.class);
        func_64_a(14, false, true, Packet14BlockDig.class);
        func_64_a(15, false, true, Packet15Place.class);
        func_64_a(16, false, true, Packet16BlockItemSwitch.class);
        func_64_a(17, true, false, Packet17Sleep.class);
        func_64_a(18, true, true, Packet18Animation.class);
        func_64_a(19, false, true, Packet19EntityAction.class);
        func_64_a(20, true, false, Packet20NamedEntitySpawn.class);
        func_64_a(21, true, false, Packet21PickupSpawn.class);
        func_64_a(22, true, false, Packet22Collect.class);
        func_64_a(23, true, false, Packet23VehicleSpawn.class);
        func_64_a(24, true, false, Packet24MobSpawn.class);
        func_64_a(25, true, false, Packet25EntityPainting.class);
        func_64_a(27, false, true, Packet27Position.class);
        func_64_a(28, true, false, Packet28EntityVelocity.class);
        func_64_a(29, true, false, Packet29DestroyEntity.class);
        func_64_a(30, true, false, Packet30Entity.class);
        func_64_a(31, true, false, Packet31RelEntityMove.class);
        func_64_a(32, true, false, Packet32EntityLook.class);
        func_64_a(33, true, false, Packet33RelEntityMoveLook.class);
        func_64_a(34, true, false, Packet34EntityTeleport.class);
        func_64_a(38, true, false, Packet38EntityStatus.class);
        func_64_a(39, true, false, Packet39AttachEntity.class);
        func_64_a(40, true, false, Packet40EntityMetadata.class);
        func_64_a(50, true, false, Packet50PreChunk.class);
        func_64_a(51, true, false, Packet51MapChunk.class);
        func_64_a(52, true, false, Packet52MultiBlockChange.class);
        func_64_a(53, true, false, Packet53BlockChange.class);
        func_64_a(54, true, false, Packet54PlayNoteBlock.class);
        func_64_a(60, true, false, Packet60Explosion.class);
        func_64_a(61, true, false, Packet61DoorChange.class);
        func_64_a(70, true, false, Packet70Bed.class);
        func_64_a(71, true, false, Packet71Weather.class);
        func_64_a(100, true, false, Packet100OpenWindow.class);
        func_64_a(101, true, true, Packet101CloseWindow.class);
        func_64_a(102, false, true, Packet102WindowClick.class);
        func_64_a(103, true, false, Packet103SetSlot.class);
        func_64_a(104, true, false, Packet104WindowItems.class);
        func_64_a(105, true, false, Packet105UpdateProgressbar.class);
        func_64_a(106, true, true, Packet106Transaction.class);
        func_64_a(130, true, true, Packet130UpdateSign.class);
        func_64_a(131, true, false, Packet131MapData.class);
        func_64_a(200, true, false, Packet200Statistic.class);
        func_64_a(255, true, true, Packet255KickDisconnect.class);
        field_21904_c = new HashMap();
        field_21903_d = 0;
    }
}
