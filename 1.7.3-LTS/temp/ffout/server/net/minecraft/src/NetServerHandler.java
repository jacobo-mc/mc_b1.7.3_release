package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetServerHandler extends NetHandler implements ICommandListener {
    public static Logger field_20_a = Logger.getLogger("Minecraft");
    public NetworkManager field_19_b;
    public boolean field_18_c = false;
    private MinecraftServer field_17_d;
    private EntityPlayerMP field_16_e;
    private int field_15_f;
    private int field_22004_g;
    private int field_27004_h;
    private boolean field_22003_h;
    private double field_9009_g;
    private double field_9008_h;
    private double field_9007_i;
    private boolean field_9006_j = true;
    private Map field_10_k = new HashMap();

    public NetServerHandler(MinecraftServer var1, NetworkManager var2, EntityPlayerMP var3) {
        this.field_17_d = var1;
        this.field_19_b = var2;
        var2.func_754_a(this);
        this.field_16_e = var3;
        var3.field_20908_a = this;
    }

    public void func_42_a() {
        this.field_22003_h = false;
        this.field_19_b.func_747_a();
        if (this.field_15_f - this.field_22004_g > 20) {
            this.func_39_b(new Packet0KeepAlive());
        }

    }

    public void func_43_c(String var1) {
        this.field_16_e.func_30002_A();
        this.func_39_b(new Packet255KickDisconnect(var1));
        this.field_19_b.func_752_c();
        this.field_17_d.field_6033_f.func_631_a(new Packet3Chat("\u00a7e" + this.field_16_e.field_409_aq + " left the game."));
        this.field_17_d.field_6033_f.func_616_c(this.field_16_e);
        this.field_18_c = true;
    }

    public void func_22001_a(Packet27Position var1) {
        this.field_16_e.func_22069_a(var1.func_22031_c(), var1.func_22028_e(), var1.func_22032_g(), var1.func_22030_h(), var1.func_22029_d(), var1.func_22033_f());
    }

    public void func_18_a(Packet10Flying var1) {
        WorldServer var2 = this.field_17_d.func_28004_a(this.field_16_e.field_4110_as);
        this.field_22003_h = true;
        double var3;
        if (!this.field_9006_j) {
            var3 = var1.field_72_b - this.field_9008_h;
            if (var1.field_73_a == this.field_9009_g && var3 * var3 < 0.01D && var1.field_71_c == this.field_9007_i) {
                this.field_9006_j = true;
            }
        }

        if (this.field_9006_j) {
            double var5;
            double var7;
            double var9;
            double var13;
            if (this.field_16_e.field_327_g != null) {
                float var26 = this.field_16_e.field_316_r;
                float var4 = this.field_16_e.field_315_s;
                this.field_16_e.field_327_g.func_127_w();
                var5 = this.field_16_e.field_322_l;
                var7 = this.field_16_e.field_321_m;
                var9 = this.field_16_e.field_320_n;
                double var27 = 0.0D;
                var13 = 0.0D;
                if (var1.field_65_i) {
                    var26 = var1.field_69_e;
                    var4 = var1.field_68_f;
                }

                if (var1.field_66_h && var1.field_72_b == -999.0D && var1.field_70_d == -999.0D) {
                    var27 = var1.field_73_a;
                    var13 = var1.field_71_c;
                }

                this.field_16_e.field_9086_A = var1.field_67_g;
                this.field_16_e.func_22070_a(true);
                this.field_16_e.func_88_c(var27, 0.0D, var13);
                this.field_16_e.func_6095_b(var5, var7, var9, var26, var4);
                this.field_16_e.field_319_o = var27;
                this.field_16_e.field_317_q = var13;
                if (this.field_16_e.field_327_g != null) {
                    var2.func_12017_b(this.field_16_e.field_327_g, true);
                }

                if (this.field_16_e.field_327_g != null) {
                    this.field_16_e.field_327_g.func_127_w();
                }

                this.field_17_d.field_6033_f.func_613_b(this.field_16_e);
                this.field_9009_g = this.field_16_e.field_322_l;
                this.field_9008_h = this.field_16_e.field_321_m;
                this.field_9007_i = this.field_16_e.field_320_n;
                var2.func_520_e(this.field_16_e);
                return;
            }

            if (this.field_16_e.func_22057_E()) {
                this.field_16_e.func_22070_a(true);
                this.field_16_e.func_6095_b(this.field_9009_g, this.field_9008_h, this.field_9007_i, this.field_16_e.field_316_r, this.field_16_e.field_315_s);
                var2.func_520_e(this.field_16_e);
                return;
            }

            var3 = this.field_16_e.field_321_m;
            this.field_9009_g = this.field_16_e.field_322_l;
            this.field_9008_h = this.field_16_e.field_321_m;
            this.field_9007_i = this.field_16_e.field_320_n;
            var5 = this.field_16_e.field_322_l;
            var7 = this.field_16_e.field_321_m;
            var9 = this.field_16_e.field_320_n;
            float var11 = this.field_16_e.field_316_r;
            float var12 = this.field_16_e.field_315_s;
            if (var1.field_66_h && var1.field_72_b == -999.0D && var1.field_70_d == -999.0D) {
                var1.field_66_h = false;
            }

            if (var1.field_66_h) {
                var5 = var1.field_73_a;
                var7 = var1.field_72_b;
                var9 = var1.field_71_c;
                var13 = var1.field_70_d - var1.field_72_b;
                if (!this.field_16_e.func_22057_E() && (var13 > 1.65D || var13 < 0.1D)) {
                    this.func_43_c("Illegal stance");
                    field_20_a.warning(this.field_16_e.field_409_aq + " had an illegal stance: " + var13);
                    return;
                }

                if (Math.abs(var1.field_73_a) > 3.2E7D || Math.abs(var1.field_71_c) > 3.2E7D) {
                    this.func_43_c("Illegal position");
                    return;
                }
            }

            if (var1.field_65_i) {
                var11 = var1.field_69_e;
                var12 = var1.field_68_f;
            }

            this.field_16_e.func_22070_a(true);
            this.field_16_e.field_9068_R = 0.0F;
            this.field_16_e.func_6095_b(this.field_9009_g, this.field_9008_h, this.field_9007_i, var11, var12);
            if (!this.field_9006_j) {
                return;
            }

            var13 = var5 - this.field_16_e.field_322_l;
            double var15 = var7 - this.field_16_e.field_321_m;
            double var17 = var9 - this.field_16_e.field_320_n;
            double var19 = var13 * var13 + var15 * var15 + var17 * var17;
            if (var19 > 100.0D) {
                field_20_a.warning(this.field_16_e.field_409_aq + " moved too quickly!");
                this.func_43_c("You moved too quickly :( (Hacking?)");
                return;
            }

            float var21 = 0.0625F;
            boolean var22 = var2.func_481_a(this.field_16_e, this.field_16_e.field_312_v.func_711_b().func_694_e((double)var21, (double)var21, (double)var21)).size() == 0;
            this.field_16_e.func_88_c(var13, var15, var17);
            var13 = var5 - this.field_16_e.field_322_l;
            var15 = var7 - this.field_16_e.field_321_m;
            if (var15 > -0.5D || var15 < 0.5D) {
                var15 = 0.0D;
            }

            var17 = var9 - this.field_16_e.field_320_n;
            var19 = var13 * var13 + var15 * var15 + var17 * var17;
            boolean var23 = false;
            if (var19 > 0.0625D && !this.field_16_e.func_22057_E()) {
                var23 = true;
                field_20_a.warning(this.field_16_e.field_409_aq + " moved wrongly!");
                System.out.println("Got position " + var5 + ", " + var7 + ", " + var9);
                System.out.println("Expected " + this.field_16_e.field_322_l + ", " + this.field_16_e.field_321_m + ", " + this.field_16_e.field_320_n);
            }

            this.field_16_e.func_6095_b(var5, var7, var9, var11, var12);
            boolean var24 = var2.func_481_a(this.field_16_e, this.field_16_e.field_312_v.func_711_b().func_694_e((double)var21, (double)var21, (double)var21)).size() == 0;
            if (var22 && (var23 || !var24) && !this.field_16_e.func_22057_E()) {
                this.func_41_a(this.field_9009_g, this.field_9008_h, this.field_9007_i, var11, var12);
                return;
            }

            AxisAlignedBB var25 = this.field_16_e.field_312_v.func_711_b().func_708_b((double)var21, (double)var21, (double)var21).func_700_a(0.0D, -0.55D, 0.0D);
            if (!this.field_17_d.field_27005_o && !var2.func_27069_b(var25)) {
                if (var15 >= -0.03125D) {
                    ++this.field_27004_h;
                    if (this.field_27004_h > 80) {
                        field_20_a.warning(this.field_16_e.field_409_aq + " was kicked for floating too long!");
                        this.func_43_c("Flying is not enabled on this server");
                        return;
                    }
                }
            } else {
                this.field_27004_h = 0;
            }

            this.field_16_e.field_9086_A = var1.field_67_g;
            this.field_17_d.field_6033_f.func_613_b(this.field_16_e);
            this.field_16_e.func_9153_b(this.field_16_e.field_321_m - var3, var1.field_67_g);
        }

    }

    public void func_41_a(double var1, double var3, double var5, float var7, float var8) {
        this.field_9006_j = false;
        this.field_9009_g = var1;
        this.field_9008_h = var3;
        this.field_9007_i = var5;
        this.field_16_e.func_6095_b(var1, var3, var5, var7, var8);
        this.field_16_e.field_20908_a.func_39_b(new Packet13PlayerLookMove(var1, var3 + 1.6200000047683716D, var3, var5, var7, var8, false));
    }

    public void func_26_a(Packet14BlockDig var1) {
        WorldServer var2 = this.field_17_d.func_28004_a(this.field_16_e.field_4110_as);
        if (var1.field_55_e == 4) {
            this.field_16_e.func_161_a();
        } else {
            boolean var3 = var2.field_819_z = var2.field_4272_q.field_6165_g != 0 || this.field_17_d.field_6033_f.func_639_g(this.field_16_e.field_409_aq);
            boolean var4 = false;
            if (var1.field_55_e == 0) {
                var4 = true;
            }

            if (var1.field_55_e == 2) {
                var4 = true;
            }

            int var5 = var1.field_54_a;
            int var6 = var1.field_53_b;
            int var7 = var1.field_57_c;
            if (var4) {
                double var8 = this.field_16_e.field_322_l - ((double)var5 + 0.5D);
                double var10 = this.field_16_e.field_321_m - ((double)var6 + 0.5D);
                double var12 = this.field_16_e.field_320_n - ((double)var7 + 0.5D);
                double var14 = var8 * var8 + var10 * var10 + var12 * var12;
                if (var14 > 36.0D) {
                    return;
                }
            }

            ChunkCoordinates var19 = var2.func_22078_l();
            int var9 = (int)MathHelper.func_587_e((float)(var5 - var19.field_22216_a));
            int var20 = (int)MathHelper.func_587_e((float)(var7 - var19.field_528_b));
            if (var9 > var20) {
                var20 = var9;
            }

            if (var1.field_55_e == 0) {
                if (var20 <= 16 && !var3) {
                    this.field_16_e.field_20908_a.func_39_b(new Packet53BlockChange(var5, var6, var7, var2));
                } else {
                    this.field_16_e.field_425_ad.func_324_a(var5, var6, var7, var1.field_56_d);
                }
            } else if (var1.field_55_e == 2) {
                this.field_16_e.field_425_ad.func_22045_b(var5, var6, var7);
                if (var2.func_444_a(var5, var6, var7) != 0) {
                    this.field_16_e.field_20908_a.func_39_b(new Packet53BlockChange(var5, var6, var7, var2));
                }
            } else if (var1.field_55_e == 3) {
                double var11 = this.field_16_e.field_322_l - ((double)var5 + 0.5D);
                double var13 = this.field_16_e.field_321_m - ((double)var6 + 0.5D);
                double var15 = this.field_16_e.field_320_n - ((double)var7 + 0.5D);
                double var17 = var11 * var11 + var13 * var13 + var15 * var15;
                if (var17 < 256.0D) {
                    this.field_16_e.field_20908_a.func_39_b(new Packet53BlockChange(var5, var6, var7, var2));
                }
            }

            var2.field_819_z = false;
        }
    }

    public void func_24_a(Packet15Place var1) {
        WorldServer var2 = this.field_17_d.func_28004_a(this.field_16_e.field_4110_as);
        ItemStack var3 = this.field_16_e.field_416_aj.func_213_b();
        boolean var4 = var2.field_819_z = var2.field_4272_q.field_6165_g != 0 || this.field_17_d.field_6033_f.func_639_g(this.field_16_e.field_409_aq);
        if (var1.field_80_d == 255) {
            if (var3 == null) {
                return;
            }

            this.field_16_e.field_425_ad.func_6154_a(this.field_16_e, var2, var3);
        } else {
            int var5 = var1.field_78_a;
            int var6 = var1.field_77_b;
            int var7 = var1.field_81_c;
            int var8 = var1.field_80_d;
            ChunkCoordinates var9 = var2.func_22078_l();
            int var10 = (int)MathHelper.func_587_e((float)(var5 - var9.field_22216_a));
            int var11 = (int)MathHelper.func_587_e((float)(var7 - var9.field_528_b));
            if (var10 > var11) {
                var11 = var10;
            }

            if (this.field_9006_j && this.field_16_e.func_101_d((double)var5 + 0.5D, (double)var6 + 0.5D, (double)var7 + 0.5D) < 64.0D && (var11 > 16 || var4)) {
                this.field_16_e.field_425_ad.func_327_a(this.field_16_e, var2, var3, var5, var6, var7, var8);
            }

            this.field_16_e.field_20908_a.func_39_b(new Packet53BlockChange(var5, var6, var7, var2));
            if (var8 == 0) {
                --var6;
            }

            if (var8 == 1) {
                ++var6;
            }

            if (var8 == 2) {
                --var7;
            }

            if (var8 == 3) {
                ++var7;
            }

            if (var8 == 4) {
                --var5;
            }

            if (var8 == 5) {
                ++var5;
            }

            this.field_16_e.field_20908_a.func_39_b(new Packet53BlockChange(var5, var6, var7, var2));
        }

        var3 = this.field_16_e.field_416_aj.func_213_b();
        if (var3 != null && var3.field_853_a == 0) {
            this.field_16_e.field_416_aj.field_496_a[this.field_16_e.field_416_aj.field_499_d] = null;
        }

        this.field_16_e.field_20064_am = true;
        this.field_16_e.field_416_aj.field_496_a[this.field_16_e.field_416_aj.field_499_d] = ItemStack.func_20117_a(this.field_16_e.field_416_aj.field_496_a[this.field_16_e.field_416_aj.field_499_d]);
        Slot var12 = this.field_16_e.field_20052_ap.func_20127_a(this.field_16_e.field_416_aj, this.field_16_e.field_416_aj.field_499_d);
        this.field_16_e.field_20052_ap.func_20125_a();
        this.field_16_e.field_20064_am = false;
        if (!ItemStack.func_20119_a(this.field_16_e.field_416_aj.func_213_b(), var1.field_79_e)) {
            this.func_39_b(new Packet103SetSlot(this.field_16_e.field_20052_ap.field_20134_f, var12.field_20100_c, this.field_16_e.field_416_aj.func_213_b()));
        }

        var2.field_819_z = false;
    }

    public void func_6_a(String var1, Object[] var2) {
        field_20_a.info(this.field_16_e.field_409_aq + " lost connection: " + var1);
        this.field_17_d.field_6033_f.func_631_a(new Packet3Chat("\u00a7e" + this.field_16_e.field_409_aq + " left the game."));
        this.field_17_d.field_6033_f.func_616_c(this.field_16_e);
        this.field_18_c = true;
    }

    public void func_6001_a(Packet var1) {
        field_20_a.warning(this.getClass() + " wasn't prepared to deal with a " + var1.getClass());
        this.func_43_c("Protocol error, unexpected packet");
    }

    public void func_39_b(Packet var1) {
        this.field_19_b.func_745_a(var1);
        this.field_22004_g = this.field_15_f;
    }

    public void func_11_a(Packet16BlockItemSwitch var1) {
        if (var1.field_74_b >= 0 && var1.field_74_b <= InventoryPlayer.func_25054_e()) {
            this.field_16_e.field_416_aj.field_499_d = var1.field_74_b;
        } else {
            field_20_a.warning(this.field_16_e.field_409_aq + " tried to set an invalid carried item");
        }
    }

    public void func_23_a(Packet3Chat var1) {
        String var2 = var1.field_150_a;
        if (var2.length() > 100) {
            this.func_43_c("Chat message too long");
        } else {
            var2 = var2.trim();

            for(int var3 = 0; var3 < var2.length(); ++var3) {
                if (ChatAllowedCharacters.field_20162_a.indexOf(var2.charAt(var3)) < 0) {
                    this.func_43_c("Illegal characters in chat");
                    return;
                }
            }

            if (var2.startsWith("/")) {
                this.func_4010_d(var2);
            } else {
                var2 = "<" + this.field_16_e.field_409_aq + "> " + var2;
                field_20_a.info(var2);
                this.field_17_d.field_6033_f.func_631_a(new Packet3Chat(var2));
            }

        }
    }

    private void func_4010_d(String var1) {
        if (var1.toLowerCase().startsWith("/me ")) {
            var1 = "* " + this.field_16_e.field_409_aq + " " + var1.substring(var1.indexOf(" ")).trim();
            field_20_a.info(var1);
            this.field_17_d.field_6033_f.func_631_a(new Packet3Chat(var1));
        } else if (var1.toLowerCase().startsWith("/kill")) {
            this.field_16_e.func_121_a((Entity)null, 1000);
        } else if (var1.toLowerCase().startsWith("/tell ")) {
            String[] var2 = var1.split(" ");
            if (var2.length >= 3) {
                var1 = var1.substring(var1.indexOf(" ")).trim();
                var1 = var1.substring(var1.indexOf(" ")).trim();
                var1 = "\u00a77" + this.field_16_e.field_409_aq + " whispers " + var1;
                field_20_a.info(var1 + " to " + var2[1]);
                if (!this.field_17_d.field_6033_f.func_621_a(var2[1], new Packet3Chat(var1))) {
                    this.func_39_b(new Packet3Chat("\u00a7cThere's no player by that name online."));
                }
            }
        } else {
            String var3;
            if (this.field_17_d.field_6033_f.func_639_g(this.field_16_e.field_409_aq)) {
                var3 = var1.substring(1);
                field_20_a.info(this.field_16_e.field_409_aq + " issued server command: " + var3);
                this.field_17_d.func_6010_a(var3, this);
            } else {
                var3 = var1.substring(1);
                field_20_a.info(this.field_16_e.field_409_aq + " tried command: " + var3);
            }
        }

    }

    public void func_3_a(Packet18Animation var1) {
        if (var1.field_119_b == 1) {
            this.field_16_e.func_168_z();
        }

    }

    public void func_21001_a(Packet19EntityAction var1) {
        if (var1.field_21020_b == 1) {
            this.field_16_e.func_21043_b(true);
        } else if (var1.field_21020_b == 2) {
            this.field_16_e.func_21043_b(false);
        } else if (var1.field_21020_b == 3) {
            this.field_16_e.func_22062_a(false, true, true);
            this.field_9006_j = false;
        }

    }

    public void func_4009_a(Packet255KickDisconnect var1) {
        this.field_19_b.func_753_a("disconnect.quitting");
    }

    public int func_38_b() {
        return this.field_19_b.func_744_d();
    }

    public void func_2_b(String var1) {
        this.func_39_b(new Packet3Chat("\u00a77" + var1));
    }

    public String func_1_c() {
        return this.field_16_e.field_409_aq;
    }

    public void func_6006_a(Packet7UseEntity var1) {
        WorldServer var2 = this.field_17_d.func_28004_a(this.field_16_e.field_4110_as);
        Entity var3 = var2.func_6158_a(var1.field_9018_b);
        if (var3 != null && this.field_16_e.func_145_g(var3) && this.field_16_e.func_102_b(var3) < 36.0D) {
            if (var1.field_9020_c == 0) {
                this.field_16_e.func_9145_g(var3);
            } else if (var1.field_9020_c == 1) {
                this.field_16_e.func_9146_h(var3);
            }
        }

    }

    public void func_9002_a(Packet9Respawn var1) {
        if (this.field_16_e.field_9109_aQ <= 0) {
            this.field_16_e = this.field_17_d.field_6033_f.func_9242_d(this.field_16_e, 0);
        }
    }

    public void func_20006_a(Packet101CloseWindow var1) {
        this.field_16_e.func_20059_K();
    }

    public void func_20007_a(Packet102WindowClick var1) {
        if (this.field_16_e.field_20052_ap.field_20134_f == var1.field_20024_a && this.field_16_e.field_20052_ap.func_20124_c(this.field_16_e)) {
            ItemStack var2 = this.field_16_e.field_20052_ap.func_27085_a(var1.field_20023_b, var1.field_20027_c, var1.field_27039_f, this.field_16_e);
            if (ItemStack.func_20119_a(var1.field_20025_e, var2)) {
                this.field_16_e.field_20908_a.func_39_b(new Packet106Transaction(var1.field_20024_a, var1.field_20026_d, true));
                this.field_16_e.field_20064_am = true;
                this.field_16_e.field_20052_ap.func_20125_a();
                this.field_16_e.func_20058_J();
                this.field_16_e.field_20064_am = false;
            } else {
                this.field_10_k.put(this.field_16_e.field_20052_ap.field_20134_f, var1.field_20026_d);
                this.field_16_e.field_20908_a.func_39_b(new Packet106Transaction(var1.field_20024_a, var1.field_20026_d, false));
                this.field_16_e.field_20052_ap.func_20129_a(this.field_16_e, false);
                ArrayList var3 = new ArrayList();

                for(int var4 = 0; var4 < this.field_16_e.field_20052_ap.field_20135_e.size(); ++var4) {
                    var3.add(((Slot)this.field_16_e.field_20052_ap.field_20135_e.get(var4)).func_20092_c());
                }

                this.field_16_e.func_20054_a(this.field_16_e.field_20052_ap, var3);
            }
        }

    }

    public void func_20008_a(Packet106Transaction var1) {
        Short var2 = (Short)this.field_10_k.get(this.field_16_e.field_20052_ap.field_20134_f);
        if (var2 != null && var1.field_20033_b == var2 && this.field_16_e.field_20052_ap.field_20134_f == var1.field_20034_a && !this.field_16_e.field_20052_ap.func_20124_c(this.field_16_e)) {
            this.field_16_e.field_20052_ap.func_20129_a(this.field_16_e, true);
        }

    }

    public void func_20005_a(Packet130UpdateSign var1) {
        WorldServer var2 = this.field_17_d.func_28004_a(this.field_16_e.field_4110_as);
        if (var2.func_530_e(var1.field_20020_a, var1.field_20019_b, var1.field_20022_c)) {
            TileEntity var3 = var2.func_451_k(var1.field_20020_a, var1.field_20019_b, var1.field_20022_c);
            if (var3 instanceof TileEntitySign) {
                TileEntitySign var4 = (TileEntitySign)var3;
                if (!var4.func_25052_a()) {
                    this.field_17_d.func_25002_c("Player " + this.field_16_e.field_409_aq + " just tried to change non-editable sign");
                    return;
                }
            }

            int var6;
            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
                boolean var5 = true;
                if (var1.field_20021_d[var9].length() > 15) {
                    var5 = false;
                } else {
                    for(var6 = 0; var6 < var1.field_20021_d[var9].length(); ++var6) {
                        if (ChatAllowedCharacters.field_20162_a.indexOf(var1.field_20021_d[var9].charAt(var6)) < 0) {
                            var5 = false;
                        }
                    }
                }

                if (!var5) {
                    var1.field_20021_d[var9] = "!?";
                }
            }

            if (var3 instanceof TileEntitySign) {
                var9 = var1.field_20020_a;
                int var10 = var1.field_20019_b;
                var6 = var1.field_20022_c;
                TileEntitySign var7 = (TileEntitySign)var3;

                for(int var8 = 0; var8 < 4; ++var8) {
                    var7.field_485_e[var8] = var1.field_20021_d[var8];
                }

                var7.func_32001_a(false);
                var7.func_31001_i();
                var2.func_521_f(var9, var10, var6);
            }
        }

    }

    public boolean func_27003_c() {
        return true;
    }
}
