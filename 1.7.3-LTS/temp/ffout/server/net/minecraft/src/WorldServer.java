package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class WorldServer extends World {
    public ChunkProviderServer field_20911_y;
    public boolean field_819_z = false;
    public boolean field_816_A;
    private MinecraftServer field_6160_D;
    private MCHash field_20912_E = new MCHash();

    public WorldServer(MinecraftServer var1, ISaveHandler var2, String var3, int var4, long var5) {
        super(var2, var3, var5, WorldProvider.func_4091_a(var4));
        this.field_6160_D = var1;
    }

    public void func_4074_a(Entity var1, boolean var2) {
        if (!this.field_6160_D.field_6026_m && (var1 instanceof EntityAnimal || var1 instanceof EntityWaterMob)) {
            var1.func_118_j();
        }

        if (var1.field_328_f == null || !(var1.field_328_f instanceof EntityPlayer)) {
            super.func_4074_a(var1, var2);
        }

    }

    public void func_12017_b(Entity var1, boolean var2) {
        super.func_4074_a(var1, var2);
    }

    protected IChunkProvider func_22086_b() {
        IChunkLoader var1 = this.field_9211_s.func_22092_a(this.field_4272_q);
        this.field_20911_y = new ChunkProviderServer(this, var1, this.field_4272_q.func_4087_c());
        return this.field_20911_y;
    }

    public List func_532_d(int var1, int var2, int var3, int var4, int var5, int var6) {
        ArrayList var7 = new ArrayList();

        for(int var8 = 0; var8 < this.field_814_b.size(); ++var8) {
            TileEntity var9 = (TileEntity)this.field_814_b.get(var8);
            if (var9.field_478_b >= var1 && var9.field_483_c >= var2 && var9.field_482_d >= var3 && var9.field_478_b < var4 && var9.field_483_c < var5 && var9.field_482_d < var6) {
                var7.add(var9);
            }
        }

        return var7;
    }

    public boolean func_6157_a(EntityPlayer var1, int var2, int var3, int var4) {
        int var5 = (int)MathHelper.func_587_e((float)(var2 - this.field_797_s.func_22184_c()));
        int var6 = (int)MathHelper.func_587_e((float)(var4 - this.field_797_s.func_22189_e()));
        if (var5 > var6) {
            var6 = var5;
        }

        return var6 > 16 || this.field_6160_D.field_6033_f.func_639_g(var1.field_409_aq);
    }

    protected void func_479_b(Entity var1) {
        super.func_479_b(var1);
        this.field_20912_E.func_554_a(var1.field_331_c, var1);
    }

    protected void func_531_c(Entity var1) {
        super.func_531_c(var1);
        this.field_20912_E.func_553_d(var1.field_331_c);
    }

    public Entity func_6158_a(int var1) {
        return (Entity)this.field_20912_E.func_550_a(var1);
    }

    public boolean func_27073_a(Entity var1) {
        if (super.func_27073_a(var1)) {
            this.field_6160_D.field_6033_f.func_12022_a(var1.field_322_l, var1.field_321_m, var1.field_320_n, 512.0D, this.field_4272_q.field_6165_g, new Packet71Weather(var1));
            return true;
        } else {
            return false;
        }
    }

    public void func_9206_a(Entity var1, byte var2) {
        Packet38EntityStatus var3 = new Packet38EntityStatus(var1.field_331_c, var2);
        this.field_6160_D.func_28003_b(this.field_4272_q.field_6165_g).func_609_a(var1, var3);
    }

    public Explosion func_12015_a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
        Explosion var10 = new Explosion(this, var1, var2, var4, var6, var8);
        var10.field_12031_a = var9;
        var10.func_12023_a();
        var10.func_732_a(false);
        this.field_6160_D.field_6033_f.func_12022_a(var2, var4, var6, 64.0D, this.field_4272_q.field_6165_g, new Packet60Explosion(var2, var4, var6, var8, var10.field_12025_g));
        return var10;
    }

    public void func_21117_c(int var1, int var2, int var3, int var4, int var5) {
        super.func_21117_c(var1, var2, var3, var4, var5);
        this.field_6160_D.field_6033_f.func_12022_a((double)var1, (double)var2, (double)var3, 64.0D, this.field_4272_q.field_6165_g, new Packet54PlayNoteBlock(var1, var2, var3, var4, var5));
    }

    public void func_30006_w() {
        this.field_9211_s.func_22093_e();
    }

    protected void func_27066_i() {
        boolean var1 = this.func_27068_v();
        super.func_27066_i();
        if (var1 != this.func_27068_v()) {
            if (var1) {
                this.field_6160_D.field_6033_f.func_631_a(new Packet70Bed(2));
            } else {
                this.field_6160_D.field_6033_f.func_631_a(new Packet70Bed(1));
            }
        }

    }
}
