package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class EntityList {
    private static Map field_849_a = new HashMap();
    private static Map field_848_b = new HashMap();
    private static Map field_851_c = new HashMap();
    private static Map field_850_d = new HashMap();

    private static void func_563_a(Class var0, String var1, int var2) {
        field_849_a.put(var1, var0);
        field_848_b.put(var0, var1);
        field_851_c.put(var2, var0);
        field_850_d.put(var0, var2);
    }

    public static Entity func_567_a(String var0, World var1) {
        Entity var2 = null;

        try {
            Class var3 = (Class)field_849_a.get(var0);
            if (var3 != null) {
                var2 = (Entity)var3.getConstructor(World.class).newInstance(var1);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return var2;
    }

    public static Entity func_566_a(NBTTagCompound var0, World var1) {
        Entity var2 = null;

        try {
            Class var3 = (Class)field_849_a.get(var0.func_401_h("id"));
            if (var3 != null) {
                var2 = (Entity)var3.getConstructor(World.class).newInstance(var1);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        if (var2 != null) {
            var2.func_100_e(var0);
        } else {
            System.out.println("Skipping Entity with id " + var0.func_401_h("id"));
        }

        return var2;
    }

    public static int func_565_a(Entity var0) {
        return (Integer)field_850_d.get(var0.getClass());
    }

    public static String func_564_b(Entity var0) {
        return (String)field_848_b.get(var0.getClass());
    }

    static {
        func_563_a(EntityArrow.class, "Arrow", 10);
        func_563_a(EntitySnowball.class, "Snowball", 11);
        func_563_a(EntityItem.class, "Item", 1);
        func_563_a(EntityPainting.class, "Painting", 9);
        func_563_a(EntityLiving.class, "Mob", 48);
        func_563_a(EntityMob.class, "Monster", 49);
        func_563_a(EntityCreeper.class, "Creeper", 50);
        func_563_a(EntitySkeleton.class, "Skeleton", 51);
        func_563_a(EntitySpider.class, "Spider", 52);
        func_563_a(EntityGiantZombie.class, "Giant", 53);
        func_563_a(EntityZombie.class, "Zombie", 54);
        func_563_a(EntitySlime.class, "Slime", 55);
        func_563_a(EntityGhast.class, "Ghast", 56);
        func_563_a(EntityPigZombie.class, "PigZombie", 57);
        func_563_a(EntityPig.class, "Pig", 90);
        func_563_a(EntitySheep.class, "Sheep", 91);
        func_563_a(EntityCow.class, "Cow", 92);
        func_563_a(EntityChicken.class, "Chicken", 93);
        func_563_a(EntitySquid.class, "Squid", 94);
        func_563_a(EntityWolf.class, "Wolf", 95);
        func_563_a(EntityTNTPrimed.class, "PrimedTnt", 20);
        func_563_a(EntityFallingSand.class, "FallingSand", 21);
        func_563_a(EntityMinecart.class, "Minecart", 40);
        func_563_a(EntityBoat.class, "Boat", 41);
    }
}
