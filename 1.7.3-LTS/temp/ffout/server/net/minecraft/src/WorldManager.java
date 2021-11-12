package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class WorldManager implements IWorldAccess {
    private MinecraftServer field_953_a;
    private WorldServer field_28134_b;

    public WorldManager(MinecraftServer var1, WorldServer var2) {
        this.field_953_a = var1;
        this.field_28134_b = var2;
    }

    public void func_687_a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
    }

    public void func_681_a(Entity var1) {
        this.field_953_a.func_28003_b(this.field_28134_b.field_4272_q.field_6165_g).func_611_a(var1);
    }

    public void func_688_b(Entity var1) {
        this.field_953_a.func_28003_b(this.field_28134_b.field_4272_q.field_6165_g).func_610_b(var1);
    }

    public void func_689_a(String var1, double var2, double var4, double var6, float var8, float var9) {
    }

    public void func_685_a(int var1, int var2, int var3, int var4, int var5, int var6) {
    }

    public void func_684_a() {
    }

    public void func_683_a(int var1, int var2, int var3) {
        this.field_953_a.field_6033_f.func_622_a(var1, var2, var3, this.field_28134_b.field_4272_q.field_6165_g);
    }

    public void func_682_a(String var1, int var2, int var3, int var4) {
    }

    public void func_686_a(int var1, int var2, int var3, TileEntity var4) {
        this.field_953_a.field_6033_f.func_636_a(var1, var2, var3, var4);
    }

    public void func_28133_a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6) {
        this.field_953_a.field_6033_f.func_28171_a(var1, (double)var3, (double)var4, (double)var5, 64.0D, this.field_28134_b.field_4272_q.field_6165_g, new Packet61DoorChange(var2, var3, var4, var5, var6));
    }
}
