package net.minecraft.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;

public class NetClientHandler extends NetHandler {
    private boolean field_1214_c = false;
    private NetworkManager field_1213_d;
    public String field_1209_a;
    private Minecraft field_1212_e;
    private WorldClient field_1211_f;
    private boolean field_1210_g = false;
    public MapStorage field_28118_b = new MapStorage((ISaveHandler)null);
    Random field_1208_b = new Random();

    public NetClientHandler(Minecraft var1, String var2, int var3) throws UnknownHostException, IOException {
        this.field_1212_e = var1;
        Socket var4 = new Socket(InetAddress.getByName(var2), var3);
        this.field_1213_d = new NetworkManager(var4, "Client", this);
    }

    public void func_848_a() {
        if (!this.field_1214_c) {
            this.field_1213_d.func_967_a();
        }

        this.field_1213_d.func_28139_a();
    }

    public void func_4115_a(Packet1Login var1) {
        this.field_1212_e.field_6327_b = new PlayerControllerMP(this.field_1212_e, this);
        this.field_1212_e.field_25001_G.func_25100_a(StatList.field_25181_h, 1);
        this.field_1211_f = new WorldClient(this, var1.field_4074_d, var1.field_4073_e);
        this.field_1211_f.field_1026_y = true;
        this.field_1212_e.func_6261_a(this.field_1211_f);
        this.field_1212_e.field_6322_g.field_4129_m = var1.field_4073_e;
        this.field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
        this.field_1212_e.field_6322_g.field_620_ab = var1.field_519_a;
    }

    public void func_832_a(Packet21PickupSpawn var1) {
        double var2 = (double)var1.field_530_b / 32.0D;
        double var4 = (double)var1.field_529_c / 32.0D;
        double var6 = (double)var1.field_528_d / 32.0D;
        EntityItem var8 = new EntityItem(this.field_1211_f, var2, var4, var6, new ItemStack(var1.field_524_h, var1.field_523_i, var1.field_21052_l));
        var8.field_608_an = (double)var1.field_527_e / 128.0D;
        var8.field_607_ao = (double)var1.field_526_f / 128.0D;
        var8.field_606_ap = (double)var1.field_525_g / 128.0D;
        var8.field_9303_br = var1.field_530_b;
        var8.field_9302_bs = var1.field_529_c;
        var8.field_9301_bt = var1.field_528_d;
        this.field_1211_f.func_712_a(var1.field_531_a, var8);
    }

    public void func_835_a(Packet23VehicleSpawn var1) {
        double var2 = (double)var1.field_499_b / 32.0D;
        double var4 = (double)var1.field_503_c / 32.0D;
        double var6 = (double)var1.field_502_d / 32.0D;
        Object var8 = null;
        if (var1.field_501_e == 10) {
            var8 = new EntityMinecart(this.field_1211_f, var2, var4, var6, 0);
        }

        if (var1.field_501_e == 11) {
            var8 = new EntityMinecart(this.field_1211_f, var2, var4, var6, 1);
        }

        if (var1.field_501_e == 12) {
            var8 = new EntityMinecart(this.field_1211_f, var2, var4, var6, 2);
        }

        if (var1.field_501_e == 90) {
            var8 = new EntityFish(this.field_1211_f, var2, var4, var6);
        }

        if (var1.field_501_e == 60) {
            var8 = new EntityArrow(this.field_1211_f, var2, var4, var6);
        }

        if (var1.field_501_e == 61) {
            var8 = new EntitySnowball(this.field_1211_f, var2, var4, var6);
        }

        if (var1.field_501_e == 63) {
            var8 = new EntityFireball(this.field_1211_f, var2, var4, var6, (double)var1.field_28047_e / 8000.0D, (double)var1.field_28046_f / 8000.0D, (double)var1.field_28045_g / 8000.0D);
            var1.field_28044_i = 0;
        }

        if (var1.field_501_e == 62) {
            var8 = new EntityEgg(this.field_1211_f, var2, var4, var6);
        }

        if (var1.field_501_e == 1) {
            var8 = new EntityBoat(this.field_1211_f, var2, var4, var6);
        }

        if (var1.field_501_e == 50) {
            var8 = new EntityTNTPrimed(this.field_1211_f, var2, var4, var6);
        }

        if (var1.field_501_e == 70) {
            var8 = new EntityFallingSand(this.field_1211_f, var2, var4, var6, Block.field_393_F.field_376_bc);
        }

        if (var1.field_501_e == 71) {
            var8 = new EntityFallingSand(this.field_1211_f, var2, var4, var6, Block.field_392_G.field_376_bc);
        }

        if (var8 != null) {
            ((Entity)var8).field_9303_br = var1.field_499_b;
            ((Entity)var8).field_9302_bs = var1.field_503_c;
            ((Entity)var8).field_9301_bt = var1.field_502_d;
            ((Entity)var8).field_605_aq = 0.0F;
            ((Entity)var8).field_604_ar = 0.0F;
            ((Entity)var8).field_620_ab = var1.field_500_a;
            this.field_1211_f.func_712_a(var1.field_500_a, (Entity)var8);
            if (var1.field_28044_i > 0) {
                if (var1.field_501_e == 60) {
                    Entity var9 = this.func_12246_a(var1.field_28044_i);
                    if (var9 instanceof EntityLiving) {
                        ((EntityArrow)var8).field_682_g = (EntityLiving)var9;
                    }
                }

                ((Entity)var8).func_6375_a((double)var1.field_28047_e / 8000.0D, (double)var1.field_28046_f / 8000.0D, (double)var1.field_28045_g / 8000.0D);
            }
        }

    }

    public void func_27246_a(Packet71Weather var1) {
        double var2 = (double)var1.field_27053_b / 32.0D;
        double var4 = (double)var1.field_27057_c / 32.0D;
        double var6 = (double)var1.field_27056_d / 32.0D;
        EntityLightningBolt var8 = null;
        if (var1.field_27055_e == 1) {
            var8 = new EntityLightningBolt(this.field_1211_f, var2, var4, var6);
        }

        if (var8 != null) {
            var8.field_9303_br = var1.field_27053_b;
            var8.field_9302_bs = var1.field_27057_c;
            var8.field_9301_bt = var1.field_27056_d;
            var8.field_605_aq = 0.0F;
            var8.field_604_ar = 0.0F;
            var8.field_620_ab = var1.field_27054_a;
            this.field_1211_f.func_27159_a(var8);
        }

    }

    public void func_21146_a(Packet25EntityPainting var1) {
        EntityPainting var2 = new EntityPainting(this.field_1211_f, var1.field_21041_b, var1.field_21046_c, var1.field_21045_d, var1.field_21044_e, var1.field_21043_f);
        this.field_1211_f.func_712_a(var1.field_21042_a, var2);
    }

    public void func_6498_a(Packet28EntityVelocity var1) {
        Entity var2 = this.func_12246_a(var1.field_6367_a);
        if (var2 != null) {
            var2.func_6375_a((double)var1.field_6366_b / 8000.0D, (double)var1.field_6369_c / 8000.0D, (double)var1.field_6368_d / 8000.0D);
        }
    }

    public void func_21148_a(Packet40EntityMetadata var1) {
        Entity var2 = this.func_12246_a(var1.field_21049_a);
        if (var2 != null && var1.func_21047_b() != null) {
            var2.func_21061_O().func_21126_a(var1.func_21047_b());
        }

    }

    public void func_820_a(Packet20NamedEntitySpawn var1) {
        double var2 = (double)var1.field_540_c / 32.0D;
        double var4 = (double)var1.field_539_d / 32.0D;
        double var6 = (double)var1.field_538_e / 32.0D;
        float var8 = (float)(var1.field_537_f * 360) / 256.0F;
        float var9 = (float)(var1.field_536_g * 360) / 256.0F;
        EntityOtherPlayerMP var10 = new EntityOtherPlayerMP(this.field_1212_e.field_6324_e, var1.field_533_b);
        var10.field_9285_at = var10.field_638_aI = (double)(var10.field_9303_br = var1.field_540_c);
        var10.field_9284_au = var10.field_637_aJ = (double)(var10.field_9302_bs = var1.field_539_d);
        var10.field_9283_av = var10.field_636_aK = (double)(var10.field_9301_bt = var1.field_538_e);
        int var11 = var1.field_535_h;
        if (var11 == 0) {
            var10.field_778_b.field_843_a[var10.field_778_b.field_847_d] = null;
        } else {
            var10.field_778_b.field_843_a[var10.field_778_b.field_847_d] = new ItemStack(var11, 1, 0);
        }

        var10.func_399_b(var2, var4, var6, var8, var9);
        this.field_1211_f.func_712_a(var1.field_534_a, var10);
    }

    public void func_829_a(Packet34EntityTeleport var1) {
        Entity var2 = this.func_12246_a(var1.field_509_a);
        if (var2 != null) {
            var2.field_9303_br = var1.field_508_b;
            var2.field_9302_bs = var1.field_513_c;
            var2.field_9301_bt = var1.field_512_d;
            double var3 = (double)var2.field_9303_br / 32.0D;
            double var5 = (double)var2.field_9302_bs / 32.0D + 0.015625D;
            double var7 = (double)var2.field_9301_bt / 32.0D;
            float var9 = (float)(var1.field_511_e * 360) / 256.0F;
            float var10 = (float)(var1.field_510_f * 360) / 256.0F;
            var2.func_378_a(var3, var5, var7, var9, var10, 3);
        }
    }

    public void func_827_a(Packet30Entity var1) {
        Entity var2 = this.func_12246_a(var1.field_485_a);
        if (var2 != null) {
            var2.field_9303_br += var1.field_484_b;
            var2.field_9302_bs += var1.field_490_c;
            var2.field_9301_bt += var1.field_489_d;
            double var3 = (double)var2.field_9303_br / 32.0D;
            double var5 = (double)var2.field_9302_bs / 32.0D;
            double var7 = (double)var2.field_9301_bt / 32.0D;
            float var9 = var1.field_486_g ? (float)(var1.field_488_e * 360) / 256.0F : var2.field_605_aq;
            float var10 = var1.field_486_g ? (float)(var1.field_487_f * 360) / 256.0F : var2.field_604_ar;
            var2.func_378_a(var3, var5, var7, var9, var10, 3);
        }
    }

    public void func_839_a(Packet29DestroyEntity var1) {
        this.field_1211_f.func_710_c(var1.field_507_a);
    }

    public void func_837_a(Packet10Flying var1) {
        EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
        double var3 = var2.field_611_ak;
        double var5 = var2.field_610_al;
        double var7 = var2.field_609_am;
        float var9 = var2.field_605_aq;
        float var10 = var2.field_604_ar;
        if (var1.field_554_h) {
            var3 = var1.field_561_a;
            var5 = var1.field_560_b;
            var7 = var1.field_559_c;
        }

        if (var1.field_553_i) {
            var9 = var1.field_557_e;
            var10 = var1.field_556_f;
        }

        var2.field_9287_aY = 0.0F;
        var2.field_608_an = var2.field_607_ao = var2.field_606_ap = 0.0D;
        var2.func_399_b(var3, var5, var7, var9, var10);
        var1.field_561_a = var2.field_611_ak;
        var1.field_560_b = var2.field_601_au.field_1697_b;
        var1.field_559_c = var2.field_609_am;
        var1.field_558_d = var2.field_610_al;
        this.field_1213_d.func_972_a(var1);
        if (!this.field_1210_g) {
            this.field_1212_e.field_6322_g.field_9285_at = this.field_1212_e.field_6322_g.field_611_ak;
            this.field_1212_e.field_6322_g.field_9284_au = this.field_1212_e.field_6322_g.field_610_al;
            this.field_1212_e.field_6322_g.field_9283_av = this.field_1212_e.field_6322_g.field_609_am;
            this.field_1210_g = true;
            this.field_1212_e.func_6272_a((GuiScreen)null);
        }

    }

    public void func_826_a(Packet50PreChunk var1) {
        this.field_1211_f.func_713_a(var1.field_505_a, var1.field_504_b, var1.field_506_c);
    }

    public void func_824_a(Packet52MultiBlockChange var1) {
        Chunk var2 = this.field_1211_f.func_704_b(var1.field_479_a, var1.field_478_b);
        int var3 = var1.field_479_a * 16;
        int var4 = var1.field_478_b * 16;

        for(int var5 = 0; var5 < var1.field_480_f; ++var5) {
            short var6 = var1.field_483_c[var5];
            int var7 = var1.field_482_d[var5] & 255;
            byte var8 = var1.field_481_e[var5];
            int var9 = var6 >> 12 & 15;
            int var10 = var6 >> 8 & 15;
            int var11 = var6 & 255;
            var2.func_1010_a(var9, var11, var10, var7, var8);
            this.field_1211_f.func_711_c(var9 + var3, var11, var10 + var4, var9 + var3, var11, var10 + var4);
            this.field_1211_f.func_701_b(var9 + var3, var11, var10 + var4, var9 + var3, var11, var10 + var4);
        }

    }

    public void func_833_a(Packet51MapChunk var1) {
        this.field_1211_f.func_711_c(var1.field_573_a, var1.field_572_b, var1.field_579_c, var1.field_573_a + var1.field_578_d - 1, var1.field_572_b + var1.field_577_e - 1, var1.field_579_c + var1.field_576_f - 1);
        this.field_1211_f.func_693_a(var1.field_573_a, var1.field_572_b, var1.field_579_c, var1.field_578_d, var1.field_577_e, var1.field_576_f, var1.field_575_g);
    }

    public void func_822_a(Packet53BlockChange var1) {
        this.field_1211_f.func_714_c(var1.field_492_a, var1.field_491_b, var1.field_495_c, var1.field_494_d, var1.field_493_e);
    }

    public void func_844_a(Packet255KickDisconnect var1) {
        this.field_1213_d.func_974_a("disconnect.kicked");
        this.field_1214_c = true;
        this.field_1212_e.func_6261_a((World)null);
        this.field_1212_e.func_6272_a(new GuiConnectFailed("disconnect.disconnected", "disconnect.genericReason", new Object[]{var1.field_582_a}));
    }

    public void func_823_a(String var1, Object[] var2) {
        if (!this.field_1214_c) {
            this.field_1214_c = true;
            this.field_1212_e.func_6261_a((World)null);
            this.field_1212_e.func_6272_a(new GuiConnectFailed("disconnect.lost", var1, var2));
        }
    }

    public void func_28117_a(Packet var1) {
        if (!this.field_1214_c) {
            this.field_1213_d.func_972_a(var1);
            this.field_1213_d.func_28142_c();
        }
    }

    public void func_847_a(Packet var1) {
        if (!this.field_1214_c) {
            this.field_1213_d.func_972_a(var1);
        }
    }

    public void func_834_a(Packet22Collect var1) {
        Entity var2 = this.func_12246_a(var1.field_581_a);
        Object var3 = (EntityLiving)this.func_12246_a(var1.field_580_b);
        if (var3 == null) {
            var3 = this.field_1212_e.field_6322_g;
        }

        if (var2 != null) {
            this.field_1211_f.func_623_a(var2, "random.pop", 0.2F, ((this.field_1208_b.nextFloat() - this.field_1208_b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            this.field_1212_e.field_6321_h.func_1192_a(new EntityPickupFX(this.field_1212_e.field_6324_e, var2, (Entity)var3, -0.5F));
            this.field_1211_f.func_710_c(var1.field_581_a);
        }

    }

    public void func_4113_a(Packet3Chat var1) {
        this.field_1212_e.field_6308_u.func_552_a(var1.field_517_a);
    }

    public void func_825_a(Packet18Animation var1) {
        Entity var2 = this.func_12246_a(var1.field_522_a);
        if (var2 != null) {
            EntityPlayer var3;
            if (var1.field_521_b == 1) {
                var3 = (EntityPlayer)var2;
                var3.func_457_w();
            } else if (var1.field_521_b == 2) {
                var2.func_9280_g();
            } else if (var1.field_521_b == 3) {
                var3 = (EntityPlayer)var2;
                var3.func_22056_a(false, false, false);
            } else if (var1.field_521_b == 4) {
                var3 = (EntityPlayer)var2;
                var3.func_6420_o();
            }

        }
    }

    public void func_22186_a(Packet17Sleep var1) {
        Entity var2 = this.func_12246_a(var1.field_22045_a);
        if (var2 != null) {
            if (var1.field_22046_e == 0) {
                EntityPlayer var3 = (EntityPlayer)var2;
                var3.func_22053_b(var1.field_22044_b, var1.field_22048_c, var1.field_22047_d);
            }

        }
    }

    public void func_838_a(Packet2Handshake var1) {
        if (var1.field_532_a.equals("-")) {
            this.func_847_a(new Packet1Login(this.field_1212_e.field_6320_i.field_1666_b, 14));
        } else {
            try {
                URL var2 = new URL("http://www.minecraft.net/game/joinserver.jsp?user=" + this.field_1212_e.field_6320_i.field_1666_b + "&sessionId=" + this.field_1212_e.field_6320_i.field_6543_c + "&serverId=" + var1.field_532_a);
                BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.openStream()));
                String var4 = var3.readLine();
                var3.close();
                if (var4.equalsIgnoreCase("ok")) {
                    this.func_847_a(new Packet1Login(this.field_1212_e.field_6320_i.field_1666_b, 14));
                } else {
                    this.field_1213_d.func_974_a("disconnect.loginFailedInfo", var4);
                }
            } catch (Exception var5) {
                var5.printStackTrace();
                this.field_1213_d.func_974_a("disconnect.genericReason", "Internal client error: " + var5.toString());
            }
        }

    }

    public void func_849_b() {
        this.field_1214_c = true;
        this.field_1213_d.func_28139_a();
        this.field_1213_d.func_974_a("disconnect.closed");
    }

    public void func_828_a(Packet24MobSpawn var1) {
        double var2 = (double)var1.field_552_c / 32.0D;
        double var4 = (double)var1.field_551_d / 32.0D;
        double var6 = (double)var1.field_550_e / 32.0D;
        float var8 = (float)(var1.field_549_f * 360) / 256.0F;
        float var9 = (float)(var1.field_548_g * 360) / 256.0F;
        EntityLiving var10 = (EntityLiving)EntityList.func_1084_a(var1.field_546_b, this.field_1212_e.field_6324_e);
        var10.field_9303_br = var1.field_552_c;
        var10.field_9302_bs = var1.field_551_d;
        var10.field_9301_bt = var1.field_550_e;
        var10.field_620_ab = var1.field_547_a;
        var10.func_399_b(var2, var4, var6, var8, var9);
        var10.field_9343_G = true;
        this.field_1211_f.func_712_a(var1.field_547_a, var10);
        List var11 = var1.func_21053_b();
        if (var11 != null) {
            var10.func_21061_O().func_21126_a(var11);
        }

    }

    public void func_846_a(Packet4UpdateTime var1) {
        this.field_1212_e.field_6324_e.func_648_a(var1.field_564_a);
    }

    public void func_845_a(Packet6SpawnPosition var1) {
        this.field_1212_e.field_6322_g.func_25061_a(new ChunkCoordinates(var1.field_515_a, var1.field_514_b, var1.field_516_c));
        this.field_1212_e.field_6324_e.func_22144_v().func_22292_a(var1.field_515_a, var1.field_514_b, var1.field_516_c);
    }

    public void func_6497_a(Packet39AttachEntity var1) {
        Object var2 = this.func_12246_a(var1.field_6365_a);
        Entity var3 = this.func_12246_a(var1.field_6364_b);
        if (var1.field_6365_a == this.field_1212_e.field_6322_g.field_620_ab) {
            var2 = this.field_1212_e.field_6322_g;
        }

        if (var2 != null) {
            ((Entity)var2).func_6377_h(var3);
        }
    }

    public void func_9447_a(Packet38EntityStatus var1) {
        Entity var2 = this.func_12246_a(var1.field_9274_a);
        if (var2 != null) {
            var2.func_9282_a(var1.field_9273_b);
        }

    }

    private Entity func_12246_a(int var1) {
        return (Entity)(var1 == this.field_1212_e.field_6322_g.field_620_ab ? this.field_1212_e.field_6322_g : this.field_1211_f.func_709_b(var1));
    }

    public void func_9446_a(Packet8UpdateHealth var1) {
        this.field_1212_e.field_6322_g.func_9372_a_(var1.field_9275_a);
    }

    public void func_9448_a(Packet9Respawn var1) {
        if (var1.field_28048_a != this.field_1212_e.field_6322_g.field_4129_m) {
            this.field_1210_g = false;
            this.field_1211_f = new WorldClient(this, this.field_1211_f.func_22144_v().func_22288_b(), var1.field_28048_a);
            this.field_1211_f.field_1026_y = true;
            this.field_1212_e.func_6261_a(this.field_1211_f);
            this.field_1212_e.field_6322_g.field_4129_m = var1.field_28048_a;
            this.field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
        }

        this.field_1212_e.func_6239_p(true, var1.field_28048_a);
    }

    public void func_12245_a(Packet60Explosion var1) {
        Explosion var2 = new Explosion(this.field_1212_e.field_6324_e, (Entity)null, var1.field_12236_a, var1.field_12235_b, var1.field_12239_c, var1.field_12238_d);
        var2.field_12251_g = var1.field_12237_e;
        var2.func_12247_b(true);
    }

    public void func_20087_a(Packet100OpenWindow var1) {
        if (var1.field_20037_b == 0) {
            InventoryBasic var2 = new InventoryBasic(var1.field_20040_c, var1.field_20039_d);
            this.field_1212_e.field_6322_g.func_452_a(var2);
            this.field_1212_e.field_6322_g.field_20068_h.field_1618_c = var1.field_20038_a;
        } else if (var1.field_20037_b == 2) {
            TileEntityFurnace var3 = new TileEntityFurnace();
            this.field_1212_e.field_6322_g.func_453_a(var3);
            this.field_1212_e.field_6322_g.field_20068_h.field_1618_c = var1.field_20038_a;
        } else if (var1.field_20037_b == 3) {
            TileEntityDispenser var4 = new TileEntityDispenser();
            this.field_1212_e.field_6322_g.func_21092_a(var4);
            this.field_1212_e.field_6322_g.field_20068_h.field_1618_c = var1.field_20038_a;
        } else if (var1.field_20037_b == 1) {
            EntityPlayerSP var5 = this.field_1212_e.field_6322_g;
            this.field_1212_e.field_6322_g.func_445_l(MathHelper.func_1108_b(var5.field_611_ak), MathHelper.func_1108_b(var5.field_610_al), MathHelper.func_1108_b(var5.field_609_am));
            this.field_1212_e.field_6322_g.field_20068_h.field_1618_c = var1.field_20038_a;
        }

    }

    public void func_20088_a(Packet103SetSlot var1) {
        if (var1.field_20042_a == -1) {
            this.field_1212_e.field_6322_g.field_778_b.func_20076_b(var1.field_20043_c);
        } else if (var1.field_20042_a == 0 && var1.field_20041_b >= 36 && var1.field_20041_b < 45) {
            ItemStack var2 = this.field_1212_e.field_6322_g.field_20069_g.func_20118_a(var1.field_20041_b).func_777_b();
            if (var1.field_20043_c != null && (var2 == null || var2.field_1615_a < var1.field_20043_c.field_1615_a)) {
                var1.field_20043_c.field_1614_b = 5;
            }

            this.field_1212_e.field_6322_g.field_20069_g.func_20119_a(var1.field_20041_b, var1.field_20043_c);
        } else if (var1.field_20042_a == this.field_1212_e.field_6322_g.field_20068_h.field_1618_c) {
            this.field_1212_e.field_6322_g.field_20068_h.func_20119_a(var1.field_20041_b, var1.field_20043_c);
        }

    }

    public void func_20089_a(Packet106Transaction var1) {
        Container var2 = null;
        if (var1.field_20029_a == 0) {
            var2 = this.field_1212_e.field_6322_g.field_20069_g;
        } else if (var1.field_20029_a == this.field_1212_e.field_6322_g.field_20068_h.field_1618_c) {
            var2 = this.field_1212_e.field_6322_g.field_20068_h;
        }

        if (var2 != null) {
            if (var1.field_20030_c) {
                var2.func_20113_a(var1.field_20028_b);
            } else {
                var2.func_20110_b(var1.field_20028_b);
                this.func_847_a(new Packet106Transaction(var1.field_20029_a, var1.field_20028_b, true));
            }
        }

    }

    public void func_20094_a(Packet104WindowItems var1) {
        if (var1.field_20036_a == 0) {
            this.field_1212_e.field_6322_g.field_20069_g.func_20115_a(var1.field_20035_b);
        } else if (var1.field_20036_a == this.field_1212_e.field_6322_g.field_20068_h.field_1618_c) {
            this.field_1212_e.field_6322_g.field_20068_h.func_20115_a(var1.field_20035_b);
        }

    }

    public void func_20093_a(Packet130UpdateSign var1) {
        if (this.field_1212_e.field_6324_e.func_630_d(var1.field_20020_a, var1.field_20019_b, var1.field_20022_c)) {
            TileEntity var2 = this.field_1212_e.field_6324_e.func_603_b(var1.field_20020_a, var1.field_20019_b, var1.field_20022_c);
            if (var2 instanceof TileEntitySign) {
                TileEntitySign var3 = (TileEntitySign)var2;

                for(int var4 = 0; var4 < 4; ++var4) {
                    var3.field_826_a[var4] = var1.field_20021_d[var4];
                }

                var3.func_474_j_();
            }
        }

    }

    public void func_20090_a(Packet105UpdateProgressbar var1) {
        this.func_4114_b(var1);
        if (this.field_1212_e.field_6322_g.field_20068_h != null && this.field_1212_e.field_6322_g.field_20068_h.field_1618_c == var1.field_20032_a) {
            this.field_1212_e.field_6322_g.field_20068_h.func_20112_a(var1.field_20031_b, var1.field_20033_c);
        }

    }

    public void func_843_a(Packet5PlayerInventory var1) {
        Entity var2 = this.func_12246_a(var1.field_571_a);
        if (var2 != null) {
            var2.func_20045_c(var1.field_21056_b, var1.field_570_b, var1.field_20044_c);
        }

    }

    public void func_20092_a(Packet101CloseWindow var1) {
        this.field_1212_e.field_6322_g.func_20059_m();
    }

    public void func_21145_a(Packet54PlayNoteBlock var1) {
        this.field_1212_e.field_6324_e.func_21116_c(var1.field_21037_a, var1.field_21036_b, var1.field_21040_c, var1.field_21039_d, var1.field_21038_e);
    }

    public void func_25118_a(Packet70Bed var1) {
        int var2 = var1.field_25019_b;
        if (var2 >= 0 && var2 < Packet70Bed.field_25020_a.length && Packet70Bed.field_25020_a[var2] != null) {
            this.field_1212_e.field_6322_g.func_22055_b(Packet70Bed.field_25020_a[var2]);
        }

        if (var2 == 1) {
            this.field_1211_f.func_22144_v().func_27394_b(true);
            this.field_1211_f.func_27158_h(1.0F);
        } else if (var2 == 2) {
            this.field_1211_f.func_22144_v().func_27394_b(false);
            this.field_1211_f.func_27158_h(0.0F);
        }

    }

    public void func_28116_a(Packet131MapData var1) {
        if (var1.field_28055_a == Item.field_28010_bb.field_291_aS) {
            ItemMap.func_28013_a(var1.field_28054_b, this.field_1212_e.field_6324_e).func_28171_a(var1.field_28056_c);
        } else {
            System.out.println("Unknown itemid: " + var1.field_28054_b);
        }

    }

    public void func_28115_a(Packet61DoorChange var1) {
        this.field_1212_e.field_6324_e.func_28106_e(var1.field_28050_a, var1.field_28053_c, var1.field_28052_d, var1.field_28051_e, var1.field_28049_b);
    }

    public void func_27245_a(Packet200Statistic var1) {
        ((EntityClientPlayerMP)this.field_1212_e.field_6322_g).func_27027_b(StatList.func_27361_a(var1.field_27052_a), var1.field_27051_b);
    }

    public boolean func_27247_c() {
        return false;
    }
}
