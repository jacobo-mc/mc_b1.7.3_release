package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ServerConfigurationManager {
    public static Logger field_925_a = Logger.getLogger("Minecraft");
    public List field_924_b = new ArrayList();
    private MinecraftServer field_923_c;
    private PlayerManager[] field_922_d = new PlayerManager[2];
    private int field_9253_e;
    private Set field_9252_f = new HashSet();
    private Set field_919_g = new HashSet();
    private Set field_918_h = new HashSet();
    private Set field_22174_i = new HashSet();
    private File field_917_i;
    private File field_9251_j;
    private File field_9250_k;
    private File field_22173_m;
    private IPlayerFileData field_914_l;
    private boolean field_22172_o;

    public ServerConfigurationManager(MinecraftServer var1) {
        this.field_923_c = var1;
        this.field_917_i = var1.func_6009_a("banned-players.txt");
        this.field_9251_j = var1.func_6009_a("banned-ips.txt");
        this.field_9250_k = var1.func_6009_a("ops.txt");
        this.field_22173_m = var1.func_6009_a("white-list.txt");
        int var2 = var1.field_6035_d.func_722_a("view-distance", 10);
        this.field_922_d[0] = new PlayerManager(var1, 0, var2);
        this.field_922_d[1] = new PlayerManager(var1, -1, var2);
        this.field_9253_e = var1.field_6035_d.func_722_a("max-players", 20);
        this.field_22172_o = var1.field_6035_d.func_724_a("white-list", false);
        this.func_623_e();
        this.func_9245_g();
        this.func_9249_i();
        this.func_22168_m();
        this.func_626_f();
        this.func_9248_h();
        this.func_9239_j();
        this.func_22160_n();
    }

    public void func_618_a(WorldServer[] var1) {
        this.field_914_l = var1[0].func_22075_m().func_22090_d();
    }

    public void func_28172_a(EntityPlayerMP var1) {
        this.field_922_d[0].func_9213_b(var1);
        this.field_922_d[1].func_9213_b(var1);
        this.func_28167_a(var1.field_4110_as).func_9214_a(var1);
        WorldServer var2 = this.field_923_c.func_28004_a(var1.field_4110_as);
        var2.field_20911_y.func_376_d((int)var1.field_322_l >> 4, (int)var1.field_320_n >> 4);
    }

    public int func_640_a() {
        return this.field_922_d[0].func_542_b();
    }

    private PlayerManager func_28167_a(int var1) {
        return var1 == -1 ? this.field_922_d[1] : this.field_922_d[0];
    }

    public void func_28166_b(EntityPlayerMP var1) {
        this.field_914_l.func_725_b(var1);
    }

    public void func_627_a(EntityPlayerMP var1) {
        this.field_924_b.add(var1);
        WorldServer var2 = this.field_923_c.func_28004_a(var1.field_4110_as);
        var2.field_20911_y.func_376_d((int)var1.field_322_l >> 4, (int)var1.field_320_n >> 4);

        while(var2.func_481_a(var1, var1.field_312_v).size() != 0) {
            var1.func_86_a(var1.field_322_l, var1.field_321_m + 1.0D, var1.field_320_n);
        }

        var2.func_526_a(var1);
        this.func_28167_a(var1.field_4110_as).func_9214_a(var1);
    }

    public void func_613_b(EntityPlayerMP var1) {
        this.func_28167_a(var1.field_4110_as).func_543_c(var1);
    }

    public void func_616_c(EntityPlayerMP var1) {
        this.field_914_l.func_726_a(var1);
        this.field_923_c.func_28004_a(var1.field_4110_as).func_22085_d(var1);
        this.field_924_b.remove(var1);
        this.func_28167_a(var1.field_4110_as).func_9213_b(var1);
    }

    public EntityPlayerMP func_619_a(NetLoginHandler var1, String var2) {
        if (this.field_9252_f.contains(var2.trim().toLowerCase())) {
            var1.func_34_b("You are banned from this server!");
            return null;
        } else if (!this.func_22166_g(var2)) {
            var1.func_34_b("You are not white-listed on this server!");
            return null;
        } else {
            String var3 = var1.field_8_b.func_755_b().toString();
            var3 = var3.substring(var3.indexOf("/") + 1);
            var3 = var3.substring(0, var3.indexOf(":"));
            if (this.field_919_g.contains(var3)) {
                var1.func_34_b("Your IP address is banned from this server!");
                return null;
            } else if (this.field_924_b.size() >= this.field_9253_e) {
                var1.func_34_b("The server is full!");
                return null;
            } else {
                for(int var4 = 0; var4 < this.field_924_b.size(); ++var4) {
                    EntityPlayerMP var5 = (EntityPlayerMP)this.field_924_b.get(var4);
                    if (var5.field_409_aq.equalsIgnoreCase(var2)) {
                        var5.field_20908_a.func_43_c("You logged in from another location");
                    }
                }

                return new EntityPlayerMP(this.field_923_c, this.field_923_c.func_28004_a(0), var2, new ItemInWorldManager(this.field_923_c.func_28004_a(0)));
            }
        }
    }

    public EntityPlayerMP func_9242_d(EntityPlayerMP var1, int var2) {
        this.field_923_c.func_28003_b(var1.field_4110_as).func_9238_a(var1);
        this.field_923_c.func_28003_b(var1.field_4110_as).func_610_b(var1);
        this.func_28167_a(var1.field_4110_as).func_9213_b(var1);
        this.field_924_b.remove(var1);
        this.field_923_c.func_28004_a(var1.field_4110_as).func_22073_e(var1);
        ChunkCoordinates var3 = var1.func_25049_H();
        var1.field_4110_as = var2;
        EntityPlayerMP var4 = new EntityPlayerMP(this.field_923_c, this.field_923_c.func_28004_a(var1.field_4110_as), var1.field_409_aq, new ItemInWorldManager(this.field_923_c.func_28004_a(var1.field_4110_as)));
        var4.field_331_c = var1.field_331_c;
        var4.field_20908_a = var1.field_20908_a;
        WorldServer var5 = this.field_923_c.func_28004_a(var1.field_4110_as);
        if (var3 != null) {
            ChunkCoordinates var6 = EntityPlayer.func_25051_a(this.field_923_c.func_28004_a(var1.field_4110_as), var3);
            if (var6 != null) {
                var4.func_107_c((double)((float)var6.field_22216_a + 0.5F), (double)((float)var6.field_529_a + 0.1F), (double)((float)var6.field_528_b + 0.5F), 0.0F, 0.0F);
                var4.func_25050_a(var3);
            } else {
                var4.field_20908_a.func_39_b(new Packet70Bed(0));
            }
        }

        var5.field_20911_y.func_376_d((int)var4.field_322_l >> 4, (int)var4.field_320_n >> 4);

        while(var5.func_481_a(var4, var4.field_312_v).size() != 0) {
            var4.func_86_a(var4.field_322_l, var4.field_321_m + 1.0D, var4.field_320_n);
        }

        var4.field_20908_a.func_39_b(new Packet9Respawn((byte)var4.field_4110_as));
        var4.field_20908_a.func_41_a(var4.field_322_l, var4.field_321_m, var4.field_320_n, var4.field_316_r, var4.field_315_s);
        this.func_28170_a(var4, var5);
        this.func_28167_a(var4.field_4110_as).func_9214_a(var4);
        var5.func_526_a(var4);
        this.field_924_b.add(var4);
        var4.func_20057_k();
        var4.func_22068_s();
        return var4;
    }

    public void func_28168_f(EntityPlayerMP var1) {
        WorldServer var2 = this.field_923_c.func_28004_a(var1.field_4110_as);
        boolean var3 = false;
        byte var11;
        if (var1.field_4110_as == -1) {
            var11 = 0;
        } else {
            var11 = -1;
        }

        var1.field_4110_as = var11;
        WorldServer var4 = this.field_923_c.func_28004_a(var1.field_4110_as);
        var1.field_20908_a.func_39_b(new Packet9Respawn((byte)var1.field_4110_as));
        var2.func_22073_e(var1);
        var1.field_304_B = false;
        double var5 = var1.field_322_l;
        double var7 = var1.field_320_n;
        double var9 = 8.0D;
        if (var1.field_4110_as == -1) {
            var5 /= var9;
            var7 /= var9;
            var1.func_107_c(var5, var1.field_321_m, var7, var1.field_316_r, var1.field_315_s);
            if (var1.func_120_t()) {
                var2.func_4074_a(var1, false);
            }
        } else {
            var5 *= var9;
            var7 *= var9;
            var1.func_107_c(var5, var1.field_321_m, var7, var1.field_316_r, var1.field_315_s);
            if (var1.func_120_t()) {
                var2.func_4074_a(var1, false);
            }
        }

        if (var1.func_120_t()) {
            var4.func_526_a(var1);
            var1.func_107_c(var5, var1.field_321_m, var7, var1.field_316_r, var1.field_315_s);
            var4.func_4074_a(var1, false);
            var4.field_20911_y.field_28068_a = true;
            (new Teleporter()).func_28115_a(var4, var1);
            var4.field_20911_y.field_28068_a = false;
        }

        this.func_28172_a(var1);
        var1.field_20908_a.func_41_a(var1.field_322_l, var1.field_321_m, var1.field_320_n, var1.field_316_r, var1.field_315_s);
        var1.func_28007_a(var4);
        this.func_28170_a(var1, var4);
        this.func_30008_g(var1);
    }

    public void func_637_b() {
        for(int var1 = 0; var1 < this.field_922_d.length; ++var1) {
            this.field_922_d[var1].func_538_a();
        }

    }

    public void func_622_a(int var1, int var2, int var3, int var4) {
        this.func_28167_a(var4).func_535_a(var1, var2, var3);
    }

    public void func_631_a(Packet var1) {
        for(int var2 = 0; var2 < this.field_924_b.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.field_924_b.get(var2);
            var3.field_20908_a.func_39_b(var1);
        }

    }

    public void func_28169_a(Packet var1, int var2) {
        for(int var3 = 0; var3 < this.field_924_b.size(); ++var3) {
            EntityPlayerMP var4 = (EntityPlayerMP)this.field_924_b.get(var3);
            if (var4.field_4110_as == var2) {
                var4.field_20908_a.func_39_b(var1);
            }
        }

    }

    public String func_633_c() {
        String var1 = "";

        for(int var2 = 0; var2 < this.field_924_b.size(); ++var2) {
            if (var2 > 0) {
                var1 = var1 + ", ";
            }

            var1 = var1 + ((EntityPlayerMP)this.field_924_b.get(var2)).field_409_aq;
        }

        return var1;
    }

    public void func_22159_a(String var1) {
        this.field_9252_f.add(var1.toLowerCase());
        this.func_626_f();
    }

    public void func_22161_b(String var1) {
        this.field_9252_f.remove(var1.toLowerCase());
        this.func_626_f();
    }

    private void func_623_e() {
        try {
            this.field_9252_f.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.field_917_i));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.field_9252_f.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            field_925_a.warning("Failed to load ban list: " + var3);
        }

    }

    private void func_626_f() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.field_917_i, false));
            Iterator var2 = this.field_9252_f.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            field_925_a.warning("Failed to save ban list: " + var4);
        }

    }

    public void func_22162_c(String var1) {
        this.field_919_g.add(var1.toLowerCase());
        this.func_9248_h();
    }

    public void func_22163_d(String var1) {
        this.field_919_g.remove(var1.toLowerCase());
        this.func_9248_h();
    }

    private void func_9245_g() {
        try {
            this.field_919_g.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.field_9251_j));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.field_919_g.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            field_925_a.warning("Failed to load ip ban list: " + var3);
        }

    }

    private void func_9248_h() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.field_9251_j, false));
            Iterator var2 = this.field_919_g.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            field_925_a.warning("Failed to save ip ban list: " + var4);
        }

    }

    public void func_22164_e(String var1) {
        this.field_918_h.add(var1.toLowerCase());
        this.func_9239_j();
    }

    public void func_22165_f(String var1) {
        this.field_918_h.remove(var1.toLowerCase());
        this.func_9239_j();
    }

    private void func_9249_i() {
        try {
            this.field_918_h.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.field_9250_k));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.field_918_h.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            field_925_a.warning("Failed to load ip ban list: " + var3);
        }

    }

    private void func_9239_j() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.field_9250_k, false));
            Iterator var2 = this.field_918_h.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            field_925_a.warning("Failed to save ip ban list: " + var4);
        }

    }

    private void func_22168_m() {
        try {
            this.field_22174_i.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.field_22173_m));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.field_22174_i.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            field_925_a.warning("Failed to load white-list: " + var3);
        }

    }

    private void func_22160_n() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.field_22173_m, false));
            Iterator var2 = this.field_22174_i.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            field_925_a.warning("Failed to save white-list: " + var4);
        }

    }

    public boolean func_22166_g(String var1) {
        var1 = var1.trim().toLowerCase();
        return !this.field_22172_o || this.field_918_h.contains(var1) || this.field_22174_i.contains(var1);
    }

    public boolean func_639_g(String var1) {
        return this.field_918_h.contains(var1.trim().toLowerCase());
    }

    public EntityPlayerMP func_620_h(String var1) {
        for(int var2 = 0; var2 < this.field_924_b.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.field_924_b.get(var2);
            if (var3.field_409_aq.equalsIgnoreCase(var1)) {
                return var3;
            }
        }

        return null;
    }

    public void func_628_a(String var1, String var2) {
        EntityPlayerMP var3 = this.func_620_h(var1);
        if (var3 != null) {
            var3.field_20908_a.func_39_b(new Packet3Chat(var2));
        }

    }

    public void func_12022_a(double var1, double var3, double var5, double var7, int var9, Packet var10) {
        this.func_28171_a((EntityPlayer)null, var1, var3, var5, var7, var9, var10);
    }

    public void func_28171_a(EntityPlayer var1, double var2, double var4, double var6, double var8, int var10, Packet var11) {
        for(int var12 = 0; var12 < this.field_924_b.size(); ++var12) {
            EntityPlayerMP var13 = (EntityPlayerMP)this.field_924_b.get(var12);
            if (var13 != var1 && var13.field_4110_as == var10) {
                double var14 = var2 - var13.field_322_l;
                double var16 = var4 - var13.field_321_m;
                double var18 = var6 - var13.field_320_n;
                if (var14 * var14 + var16 * var16 + var18 * var18 < var8 * var8) {
                    var13.field_20908_a.func_39_b(var11);
                }
            }
        }

    }

    public void func_630_i(String var1) {
        Packet3Chat var2 = new Packet3Chat(var1);

        for(int var3 = 0; var3 < this.field_924_b.size(); ++var3) {
            EntityPlayerMP var4 = (EntityPlayerMP)this.field_924_b.get(var3);
            if (this.func_639_g(var4.field_409_aq)) {
                var4.field_20908_a.func_39_b(var2);
            }
        }

    }

    public boolean func_621_a(String var1, Packet var2) {
        EntityPlayerMP var3 = this.func_620_h(var1);
        if (var3 != null) {
            var3.field_20908_a.func_39_b(var2);
            return true;
        } else {
            return false;
        }
    }

    public void func_617_d() {
        for(int var1 = 0; var1 < this.field_924_b.size(); ++var1) {
            this.field_914_l.func_726_a((EntityPlayer)this.field_924_b.get(var1));
        }

    }

    public void func_636_a(int var1, int var2, int var3, TileEntity var4) {
    }

    public void func_22169_k(String var1) {
        this.field_22174_i.add(var1);
        this.func_22160_n();
    }

    public void func_22170_l(String var1) {
        this.field_22174_i.remove(var1);
        this.func_22160_n();
    }

    public Set func_22167_e() {
        return this.field_22174_i;
    }

    public void func_22171_f() {
        this.func_22168_m();
    }

    public void func_28170_a(EntityPlayerMP var1, WorldServer var2) {
        var1.field_20908_a.func_39_b(new Packet4UpdateTime(var2.func_22080_k()));
        if (var2.func_27068_v()) {
            var1.field_20908_a.func_39_b(new Packet70Bed(1));
        }

    }

    public void func_30008_g(EntityPlayerMP var1) {
        var1.func_28017_a(var1.field_20053_ao);
        var1.func_30001_B();
    }
}
