package net.minecraft.src;

import java.io.File;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager {
    private static SoundSystem field_591_a;
    private SoundPool field_590_b = new SoundPool();
    private SoundPool field_589_c = new SoundPool();
    private SoundPool field_588_d = new SoundPool();
    private int field_587_e = 0;
    private GameSettings field_586_f;
    private static boolean field_585_g = false;
    private Random field_584_h = new Random();
    private int field_583_i;

    public SoundManager() {
        this.field_583_i = this.field_584_h.nextInt(12000);
    }

    public void func_340_a(GameSettings var1) {
        this.field_589_c.field_1657_b = false;
        this.field_586_f = var1;
        if (!field_585_g && (var1 == null || var1.field_1583_b != 0.0F || var1.field_1584_a != 0.0F)) {
            this.func_339_d();
        }

    }

    private void func_339_d() {
        try {
            float var1 = this.field_586_f.field_1583_b;
            float var2 = this.field_586_f.field_1584_a;
            this.field_586_f.field_1583_b = 0.0F;
            this.field_586_f.field_1584_a = 0.0F;
            this.field_586_f.func_1041_b();
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", CodecMus.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            field_591_a = new SoundSystem();
            this.field_586_f.field_1583_b = var1;
            this.field_586_f.field_1584_a = var2;
            this.field_586_f.func_1041_b();
        } catch (Throwable var3) {
            var3.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }

        field_585_g = true;
    }

    public void func_335_a() {
        if (!field_585_g && (this.field_586_f.field_1583_b != 0.0F || this.field_586_f.field_1584_a != 0.0F)) {
            this.func_339_d();
        }

        if (field_585_g) {
            if (this.field_586_f.field_1584_a == 0.0F) {
                field_591_a.stop("BgMusic");
            } else {
                field_591_a.setVolume("BgMusic", this.field_586_f.field_1584_a);
            }
        }

    }

    public void func_330_b() {
        if (field_585_g) {
            field_591_a.cleanup();
        }

    }

    public void func_6372_a(String var1, File var2) {
        this.field_590_b.func_1117_a(var1, var2);
    }

    public void func_6373_b(String var1, File var2) {
        this.field_589_c.func_1117_a(var1, var2);
    }

    public void func_6374_c(String var1, File var2) {
        this.field_588_d.func_1117_a(var1, var2);
    }

    public void func_4033_c() {
        if (field_585_g && this.field_586_f.field_1584_a != 0.0F) {
            if (!field_591_a.playing("BgMusic") && !field_591_a.playing("streaming")) {
                if (this.field_583_i > 0) {
                    --this.field_583_i;
                    return;
                }

                SoundPoolEntry var1 = this.field_588_d.func_1116_a();
                if (var1 != null) {
                    this.field_583_i = this.field_584_h.nextInt(12000) + 12000;
                    field_591_a.backgroundMusic("BgMusic", var1.field_1780_b, var1.field_1781_a, false);
                    field_591_a.setVolume("BgMusic", this.field_586_f.field_1584_a);
                    field_591_a.play("BgMusic");
                }
            }

        }
    }

    public void func_338_a(EntityLiving var1, float var2) {
        if (field_585_g && this.field_586_f.field_1583_b != 0.0F) {
            if (var1 != null) {
                float var3 = var1.field_603_as + (var1.field_605_aq - var1.field_603_as) * var2;
                double var4 = var1.field_9285_at + (var1.field_611_ak - var1.field_9285_at) * (double)var2;
                double var6 = var1.field_9284_au + (var1.field_610_al - var1.field_9284_au) * (double)var2;
                double var8 = var1.field_9283_av + (var1.field_609_am - var1.field_9283_av) * (double)var2;
                float var10 = MathHelper.func_1114_b(-var3 * 0.017453292F - 3.1415927F);
                float var11 = MathHelper.func_1106_a(-var3 * 0.017453292F - 3.1415927F);
                float var12 = -var11;
                float var13 = 0.0F;
                float var14 = -var10;
                float var15 = 0.0F;
                float var16 = 1.0F;
                float var17 = 0.0F;
                field_591_a.setListenerPosition((float)var4, (float)var6, (float)var8);
                field_591_a.setListenerOrientation(var12, var13, var14, var15, var16, var17);
            }
        }
    }

    public void func_331_a(String var1, float var2, float var3, float var4, float var5, float var6) {
        if (field_585_g && this.field_586_f.field_1583_b != 0.0F) {
            String var7 = "streaming";
            if (field_591_a.playing("streaming")) {
                field_591_a.stop("streaming");
            }

            if (var1 != null) {
                SoundPoolEntry var8 = this.field_589_c.func_1118_a(var1);
                if (var8 != null && var5 > 0.0F) {
                    if (field_591_a.playing("BgMusic")) {
                        field_591_a.stop("BgMusic");
                    }

                    float var9 = 16.0F;
                    field_591_a.newStreamingSource(true, var7, var8.field_1780_b, var8.field_1781_a, false, var2, var3, var4, 2, var9 * 4.0F);
                    field_591_a.setVolume(var7, 0.5F * this.field_586_f.field_1583_b);
                    field_591_a.play(var7);
                }

            }
        }
    }

    public void func_336_b(String var1, float var2, float var3, float var4, float var5, float var6) {
        if (field_585_g && this.field_586_f.field_1583_b != 0.0F) {
            SoundPoolEntry var7 = this.field_590_b.func_1118_a(var1);
            if (var7 != null && var5 > 0.0F) {
                this.field_587_e = (this.field_587_e + 1) % 256;
                String var8 = "sound_" + this.field_587_e;
                float var9 = 16.0F;
                if (var5 > 1.0F) {
                    var9 *= var5;
                }

                field_591_a.newSource(var5 > 1.0F, var8, var7.field_1780_b, var7.field_1781_a, false, var2, var3, var4, 2, var9);
                field_591_a.setPitch(var8, var6);
                if (var5 > 1.0F) {
                    var5 = 1.0F;
                }

                field_591_a.setVolume(var8, var5 * this.field_586_f.field_1583_b);
                field_591_a.play(var8);
            }

        }
    }

    public void func_337_a(String var1, float var2, float var3) {
        if (field_585_g && this.field_586_f.field_1583_b != 0.0F) {
            SoundPoolEntry var4 = this.field_590_b.func_1118_a(var1);
            if (var4 != null) {
                this.field_587_e = (this.field_587_e + 1) % 256;
                String var5 = "sound_" + this.field_587_e;
                field_591_a.newSource(false, var5, var4.field_1780_b, var4.field_1781_a, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
                if (var2 > 1.0F) {
                    var2 = 1.0F;
                }

                var2 *= 0.25F;
                field_591_a.setPitch(var5, var3);
                field_591_a.setVolume(var5, var2 * this.field_586_f.field_1583_b);
                field_591_a.play(var5);
            }

        }
    }
}
