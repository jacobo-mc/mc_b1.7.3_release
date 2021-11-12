package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class WorldServerMulti extends WorldServer {
    public WorldServerMulti(MinecraftServer var1, ISaveHandler var2, String var3, int var4, long var5, WorldServer var7) {
        super(var1, var2, var3, var4, var5);
        this.field_28105_z = var7.field_28105_z;
    }
}
