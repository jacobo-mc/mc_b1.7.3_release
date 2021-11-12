package net.minecraft.src;

import java.io.File;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager {
    private static SoundSystem sndSystem;
    private SoundPool soundPoolSounds = new SoundPool();
    private SoundPool soundPoolStreaming = new SoundPool();
    private SoundPool soundPoolMusic = new SoundPool();
    private int field_587_e = 0;
    private GameSettings options;
    private static boolean loaded = false;
    private Random rand = new Random();
    private int ticksBeforeMusic;

    public SoundManager() {
        this.ticksBeforeMusic = this.rand.nextInt(12000);
    }

    public void loadSoundSettings(GameSettings var1) {
        this.soundPoolStreaming.field_1657_b = false;
        this.options = var1;
        if (!loaded && (var1 == null || var1.soundVolume != 0.0F || var1.musicVolume != 0.0F)) {
            this.tryToSetLibraryAndCodecs();
        }

    }

    private void tryToSetLibraryAndCodecs() {
        try {
            float var1 = this.options.soundVolume;
            float var2 = this.options.musicVolume;
            this.options.soundVolume = 0.0F;
            this.options.musicVolume = 0.0F;
            this.options.saveOptions();
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", CodecMus.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            sndSystem = new SoundSystem();
            this.options.soundVolume = var1;
            this.options.musicVolume = var2;
            this.options.saveOptions();
        } catch (Throwable var3) {
            var3.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }

        loaded = true;
    }

    public void onSoundOptionsChanged() {
        if (!loaded && (this.options.soundVolume != 0.0F || this.options.musicVolume != 0.0F)) {
            this.tryToSetLibraryAndCodecs();
        }

        if (loaded) {
            if (this.options.musicVolume == 0.0F) {
                sndSystem.stop("BgMusic");
            } else {
                sndSystem.setVolume("BgMusic", this.options.musicVolume);
            }
        }

    }

    public void closeMinecraft() {
        if (loaded) {
            sndSystem.cleanup();
        }

    }

    public void addSound(String var1, File var2) {
        this.soundPoolSounds.addSound(var1, var2);
    }

    public void addStreaming(String var1, File var2) {
        this.soundPoolStreaming.addSound(var1, var2);
    }

    public void addMusic(String var1, File var2) {
        this.soundPoolMusic.addSound(var1, var2);
    }

    public void playRandomMusicIfReady() {
        if (loaded && this.options.musicVolume != 0.0F) {
            if (!sndSystem.playing("BgMusic") && !sndSystem.playing("streaming")) {
                if (this.ticksBeforeMusic > 0) {
                    --this.ticksBeforeMusic;
                    return;
                }

                SoundPoolEntry var1 = this.soundPoolMusic.getRandomSound();
                if (var1 != null) {
                    this.ticksBeforeMusic = this.rand.nextInt(12000) + 12000;
                    sndSystem.backgroundMusic("BgMusic", var1.soundUrl, var1.soundName, false);
                    sndSystem.setVolume("BgMusic", this.options.musicVolume);
                    sndSystem.play("BgMusic");
                }
            }

        }
    }

    public void func_338_a(EntityLiving var1, float var2) {
        if (loaded && this.options.soundVolume != 0.0F) {
            if (var1 != null) {
                float var3 = var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var2;
                double var4 = var1.prevPosX + (var1.posX - var1.prevPosX) * (double)var2;
                double var6 = var1.prevPosY + (var1.posY - var1.prevPosY) * (double)var2;
                double var8 = var1.prevPosZ + (var1.posZ - var1.prevPosZ) * (double)var2;
                float var10 = MathHelper.cos(-var3 * 0.017453292F - 3.1415927F);
                float var11 = MathHelper.sin(-var3 * 0.017453292F - 3.1415927F);
                float var12 = -var11;
                float var13 = 0.0F;
                float var14 = -var10;
                float var15 = 0.0F;
                float var16 = 1.0F;
                float var17 = 0.0F;
                sndSystem.setListenerPosition((float)var4, (float)var6, (float)var8);
                sndSystem.setListenerOrientation(var12, var13, var14, var15, var16, var17);
            }
        }
    }

    public void playStreaming(String var1, float var2, float var3, float var4, float var5, float var6) {
        if (loaded && this.options.soundVolume != 0.0F) {
            String var7 = "streaming";
            if (sndSystem.playing("streaming")) {
                sndSystem.stop("streaming");
            }

            if (var1 != null) {
                SoundPoolEntry var8 = this.soundPoolStreaming.getRandomSoundFromSoundPool(var1);
                if (var8 != null && var5 > 0.0F) {
                    if (sndSystem.playing("BgMusic")) {
                        sndSystem.stop("BgMusic");
                    }

                    float var9 = 16.0F;
                    sndSystem.newStreamingSource(true, var7, var8.soundUrl, var8.soundName, false, var2, var3, var4, 2, var9 * 4.0F);
                    sndSystem.setVolume(var7, 0.5F * this.options.soundVolume);
                    sndSystem.play(var7);
                }

            }
        }
    }

    public void playSound(String var1, float var2, float var3, float var4, float var5, float var6) {
        if (loaded && this.options.soundVolume != 0.0F) {
            SoundPoolEntry var7 = this.soundPoolSounds.getRandomSoundFromSoundPool(var1);
            if (var7 != null && var5 > 0.0F) {
                this.field_587_e = (this.field_587_e + 1) % 256;
                String var8 = "sound_" + this.field_587_e;
                float var9 = 16.0F;
                if (var5 > 1.0F) {
                    var9 *= var5;
                }

                sndSystem.newSource(var5 > 1.0F, var8, var7.soundUrl, var7.soundName, false, var2, var3, var4, 2, var9);
                sndSystem.setPitch(var8, var6);
                if (var5 > 1.0F) {
                    var5 = 1.0F;
                }

                sndSystem.setVolume(var8, var5 * this.options.soundVolume);
                sndSystem.play(var8);
            }

        }
    }

    public void playSoundFX(String var1, float var2, float var3) {
        if (loaded && this.options.soundVolume != 0.0F) {
            SoundPoolEntry var4 = this.soundPoolSounds.getRandomSoundFromSoundPool(var1);
            if (var4 != null) {
                this.field_587_e = (this.field_587_e + 1) % 256;
                String var5 = "sound_" + this.field_587_e;
                sndSystem.newSource(false, var5, var4.soundUrl, var4.soundName, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
                if (var2 > 1.0F) {
                    var2 = 1.0F;
                }

                var2 *= 0.25F;
                sndSystem.setPitch(var5, var3);
                sndSystem.setVolume(var5, var2 * this.options.soundVolume);
                sndSystem.play(var5);
            }

        }
    }
}
