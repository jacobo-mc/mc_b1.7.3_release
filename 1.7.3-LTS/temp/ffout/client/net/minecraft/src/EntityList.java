package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class EntityList {
    private static Map field_1611_a = new HashMap();
    private static Map field_1610_b = new HashMap();
    private static Map field_1613_c = new HashMap();
    private static Map field_1612_d = new HashMap();

    private static void func_1080_a(Class var0, String var1, int var2) {
        field_1611_a.put(var1, var0);
        field_1610_b.put(var0, var1);
        field_1613_c.put(var2, var0);
        field_1612_d.put(var0, var2);
    }

    public static Entity func_1079_a(String var0, World var1) {
        Entity var2 = null;

        try {
            Class var3 = (Class)field_1611_a.get(var0);
            if (var3 != null) {
                var2 = (Entity)var3.getConstructor(World.class).newInstance(var1);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return var2;
    }

    public static Entity func_1081_a(NBTTagCompound var0, World var1) {
        Entity var2 = null;

        try {
            Class var3 = (Class)field_1611_a.get(var0.func_755_i("id"));
            if (var3 != null) {
                var2 = (Entity)var3.getConstructor(World.class).newInstance(var1);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        if (var2 != null) {
            var2.func_368_e(var0);
        } else {
            System.out.println("Skipping Entity with id " + var0.func_755_i("id"));
        }

        return var2;
    }

    public static Entity func_1084_a(int var0, World var1) {
        Entity var2 = null;

        try {
            Class var3 = (Class)field_1613_c.get(var0);
            if (var3 != null) {
                var2 = (Entity)var3.getConstructor(World.class).newInstance(var1);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        if (var2 == null) {
            System.out.println("Skipping Entity with id " + var0);
        }

        return var2;
    }

    public static int func_1082_a(Entity var0) {
        return (Integer)field_1612_d.get(var0.getClass());
    }

    public static String func_1083_b(Entity var0) {
        return (String)field_1610_b.get(var0.getClass());
    }

    static {
        func_1080_a(EntityArrow.class, "Arrow", 10);
        func_1080_a(EntitySnowball.class, "Snowball", 11);
        func_1080_a(EntityItem.class, "Item", 1);
        func_1080_a(EntityPainting.class, "Painting", 9);
        func_1080_a(EntityLiving.class, "Mob", 48);
        func_1080_a(EntityMob.class, "Monster", 49);
        func_1080_a(EntityCreeper.class, "Creeper", 50);
        func_1080_a(EntitySkeleton.class, "Skeleton", 51);
        func_1080_a(EntitySpider.class, "Spider", 52);
        func_1080_a(EntityGiantZombie.class, "Giant", 53);
        func_1080_a(EntityZombie.class, "Zombie", 54);
        func_1080_a(EntitySlime.class, "Slime", 55);
        func_1080_a(EntityGhast.class, "Ghast", 56);
        func_1080_a(EntityPigZombie.class, "PigZombie", 57);
        func_1080_a(EntityPig.class, "Pig", 90);
        func_1080_a(EntitySheep.class, "Sheep", 91);
        func_1080_a(EntityCow.class, "Cow", 92);
        func_1080_a(EntityChicken.class, "Chicken", 93);
        func_1080_a(EntitySquid.class, "Squid", 94);
        func_1080_a(EntityWolf.class, "Wolf", 95);
        func_1080_a(EntityTNTPrimed.class, "PrimedTnt", 20);
        func_1080_a(EntityFallingSand.class, "FallingSand", 21);
        func_1080_a(EntityMinecart.class, "Minecart", 40);
        func_1080_a(EntityBoat.class, "Boat", 41);
    }
}
