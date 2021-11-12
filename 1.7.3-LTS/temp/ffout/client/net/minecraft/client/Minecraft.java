package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import net.minecraft.src.AchievementList;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkProviderLoadOrGenerate;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.ColorizerWater;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.EnumOS2;
import net.minecraft.src.EnumOSMappingHelper;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GameWindowListener;
import net.minecraft.src.GuiAchievement;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiConflictWarning;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiErrorScreen;
import net.minecraft.src.GuiGameOver;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSleepMP;
import net.minecraft.src.GuiUnused;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.LoadingScreenRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.MinecraftImpl;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.MouseHelper;
import net.minecraft.src.MovementInputFromOptions;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.OpenGlCapsChecker;
import net.minecraft.src.PlayerController;
import net.minecraft.src.PlayerControllerTest;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderManager;
import net.minecraft.src.SaveConverterMcRegion;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.ScreenShotHelper;
import net.minecraft.src.Session;
import net.minecraft.src.SoundManager;
import net.minecraft.src.StatFileWriter;
import net.minecraft.src.StatList;
import net.minecraft.src.StatStringFormatKeyInv;
import net.minecraft.src.Teleporter;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureCompassFX;
import net.minecraft.src.TextureFlamesFX;
import net.minecraft.src.TextureLavaFX;
import net.minecraft.src.TextureLavaFlowFX;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.TexturePortalFX;
import net.minecraft.src.TextureWatchFX;
import net.minecraft.src.TextureWaterFX;
import net.minecraft.src.TextureWaterFlowFX;
import net.minecraft.src.ThreadCheckHasPaid;
import net.minecraft.src.ThreadDownloadResources;
import net.minecraft.src.ThreadSleepForever;
import net.minecraft.src.Timer;
import net.minecraft.src.UnexpectedThrowable;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldRenderer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft implements Runnable {
    public static byte[] field_28006_b = new byte[10485760];
    private static Minecraft field_21900_a;
    public PlayerController field_6327_b;
    private boolean field_185_a = false;
    private boolean field_28004_R = false;
    public int field_6326_c;
    public int field_6325_d;
    private OpenGlCapsChecker field_6286_O;
    private Timer field_9237_P = new Timer(20.0F);
    public World field_6324_e;
    public RenderGlobal field_6323_f;
    public EntityPlayerSP field_6322_g;
    public EntityLiving field_22009_h;
    public EffectRenderer field_6321_h;
    public Session field_6320_i = null;
    public String field_6319_j;
    public Canvas field_9244_k;
    public boolean field_6317_l = true;
    public volatile boolean field_6316_m = false;
    public RenderEngine field_6315_n;
    public FontRenderer field_6314_o;
    public GuiScreen field_6313_p = null;
    public LoadingScreenRenderer field_6312_q = new LoadingScreenRenderer(this);
    public EntityRenderer field_9243_r;
    private ThreadDownloadResources field_6284_Q;
    private int field_6283_R = 0;
    private int field_6282_S = 0;
    private int field_9236_T;
    private int field_9235_U;
    public GuiAchievement field_25002_t = new GuiAchievement(this);
    public GuiIngame field_6308_u;
    public boolean field_6307_v = false;
    public ModelBiped field_9242_w = new ModelBiped(0.0F);
    public MovingObjectPosition field_6305_x = null;
    public GameSettings field_6304_y;
    protected MinecraftApplet field_9241_z;
    public SoundManager field_6301_A = new SoundManager();
    public MouseHelper field_6299_B;
    public TexturePackList field_6298_C;
    private File field_6297_D;
    private ISaveFormat field_22008_V;
    public static long[] field_9240_E = new long[512];
    public static long[] field_9239_F = new long[512];
    public static int field_9238_G = 0;
    public static long field_28005_H = 0L;
    public StatFileWriter field_25001_G;
    private String field_9234_V;
    private int field_9233_W;
    private TextureWaterFX field_9232_X = new TextureWaterFX();
    private TextureLavaFX field_9231_Y = new TextureLavaFX();
    private static File field_6275_Z = null;
    public volatile boolean field_6293_H = true;
    public String field_6292_I = "";
    boolean field_6291_J = false;
    long field_6290_K = -1L;
    public boolean field_6289_L = false;
    private int field_6302_aa = 0;
    public boolean field_6288_M = false;
    long field_6287_N = System.currentTimeMillis();
    private int field_6300_ab = 0;

    public Minecraft(Component var1, Canvas var2, MinecraftApplet var3, int var4, int var5, boolean var6) {
        StatList.func_27360_a();
        this.field_9235_U = var5;
        this.field_185_a = var6;
        this.field_9241_z = var3;
        new ThreadSleepForever(this, "Timer hack thread");
        this.field_9244_k = var2;
        this.field_6326_c = var4;
        this.field_6325_d = var5;
        this.field_185_a = var6;
        if (var3 == null || "true".equals(var3.getParameter("stand-alone"))) {
            this.field_6317_l = false;
        }

        field_21900_a = this;
    }

    public void func_28003_b(UnexpectedThrowable var1) {
        this.field_28004_R = true;
        this.func_4007_a(var1);
    }

    public abstract void func_4007_a(UnexpectedThrowable var1);

    public void func_6258_a(String var1, int var2) {
        this.field_9234_V = var1;
        this.field_9233_W = var2;
    }

    public void func_6271_a() throws LWJGLException {
        if (this.field_9244_k != null) {
            Graphics var1 = this.field_9244_k.getGraphics();
            if (var1 != null) {
                var1.setColor(Color.BLACK);
                var1.fillRect(0, 0, this.field_6326_c, this.field_6325_d);
                var1.dispose();
            }

            Display.setParent(this.field_9244_k);
        } else if (this.field_185_a) {
            Display.setFullscreen(true);
            this.field_6326_c = Display.getDisplayMode().getWidth();
            this.field_6325_d = Display.getDisplayMode().getHeight();
            if (this.field_6326_c <= 0) {
                this.field_6326_c = 1;
            }

            if (this.field_6325_d <= 0) {
                this.field_6325_d = 1;
            }
        } else {
            Display.setDisplayMode(new DisplayMode(this.field_6326_c, this.field_6325_d));
        }

        Display.setTitle("Minecraft Minecraft Beta 1.7.3");

        try {
            Display.create();
        } catch (LWJGLException var6) {
            var6.printStackTrace();

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var5) {
            }

            Display.create();
        }

        this.field_6297_D = func_6240_b();
        this.field_22008_V = new SaveConverterMcRegion(new File(this.field_6297_D, "saves"));
        this.field_6304_y = new GameSettings(this, this.field_6297_D);
        this.field_6298_C = new TexturePackList(this, this.field_6297_D);
        this.field_6315_n = new RenderEngine(this.field_6298_C, this.field_6304_y);
        this.field_6314_o = new FontRenderer(this.field_6304_y, "/font/default.png", this.field_6315_n);
        ColorizerWater.func_28182_a(this.field_6315_n.func_28149_a("/misc/watercolor.png"));
        ColorizerGrass.func_28181_a(this.field_6315_n.func_28149_a("/misc/grasscolor.png"));
        ColorizerFoliage.func_28152_a(this.field_6315_n.func_28149_a("/misc/foliagecolor.png"));
        this.field_9243_r = new EntityRenderer(this);
        RenderManager.field_1233_a.field_4236_f = new ItemRenderer(this);
        this.field_25001_G = new StatFileWriter(this.field_6320_i, this.field_6297_D);
        AchievementList.field_25195_b.func_27092_a(new StatStringFormatKeyInv(this));
        this.func_6257_q();
        Keyboard.create();
        Mouse.create();
        this.field_6299_B = new MouseHelper(this.field_9244_k);

        try {
            Controllers.create();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        this.func_6250_c("Pre startup");
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glClearDepth(1.0D);
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1F);
        GL11.glCullFace(1029);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        this.func_6250_c("Startup");
        this.field_6286_O = new OpenGlCapsChecker();
        this.field_6301_A.func_340_a(this.field_6304_y);
        this.field_6315_n.func_1066_a(this.field_9231_Y);
        this.field_6315_n.func_1066_a(this.field_9232_X);
        this.field_6315_n.func_1066_a(new TexturePortalFX());
        this.field_6315_n.func_1066_a(new TextureCompassFX(this));
        this.field_6315_n.func_1066_a(new TextureWatchFX(this));
        this.field_6315_n.func_1066_a(new TextureWaterFlowFX());
        this.field_6315_n.func_1066_a(new TextureLavaFlowFX());
        this.field_6315_n.func_1066_a(new TextureFlamesFX(0));
        this.field_6315_n.func_1066_a(new TextureFlamesFX(1));
        this.field_6323_f = new RenderGlobal(this, this.field_6315_n);
        GL11.glViewport(0, 0, this.field_6326_c, this.field_6325_d);
        this.field_6321_h = new EffectRenderer(this.field_6324_e, this.field_6315_n);

        try {
            this.field_6284_Q = new ThreadDownloadResources(this.field_6297_D, this);
            this.field_6284_Q.start();
        } catch (Exception var3) {
        }

        this.func_6250_c("Post startup");
        this.field_6308_u = new GuiIngame(this);
        if (this.field_9234_V != null) {
            this.func_6272_a(new GuiConnecting(this, this.field_9234_V, this.field_9233_W));
        } else {
            this.func_6272_a(new GuiMainMenu());
        }

    }

    private void func_6257_q() throws LWJGLException {
        ScaledResolution var1 = new ScaledResolution(this.field_6304_y, this.field_6326_c, this.field_6325_d);
        GL11.glClear(16640);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, var1.field_25121_a, var1.field_25120_b, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
        GL11.glViewport(0, 0, this.field_6326_c, this.field_6325_d);
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        Tessellator var2 = Tessellator.field_1512_a;
        GL11.glDisable(2896);
        GL11.glEnable(3553);
        GL11.glDisable(2912);
        GL11.glBindTexture(3553, this.field_6315_n.func_1070_a("/title/mojang.png"));
        var2.func_977_b();
        var2.func_990_b(16777215);
        var2.func_983_a(0.0D, (double)this.field_6325_d, 0.0D, 0.0D, 0.0D);
        var2.func_983_a((double)this.field_6326_c, (double)this.field_6325_d, 0.0D, 0.0D, 0.0D);
        var2.func_983_a((double)this.field_6326_c, 0.0D, 0.0D, 0.0D, 0.0D);
        var2.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        var2.func_982_a();
        short var3 = 256;
        short var4 = 256;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        var2.func_990_b(16777215);
        this.func_6274_a((var1.func_903_a() - var3) / 2, (var1.func_902_b() - var4) / 2, 0, 0, var3, var4);
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1F);
        Display.swapBuffers();
    }

    public void func_6274_a(int var1, int var2, int var3, int var4, int var5, int var6) {
        float var7 = 0.00390625F;
        float var8 = 0.00390625F;
        Tessellator var9 = Tessellator.field_1512_a;
        var9.func_977_b();
        var9.func_983_a((double)(var1 + 0), (double)(var2 + var6), 0.0D, (double)((float)(var3 + 0) * var7), (double)((float)(var4 + var6) * var8));
        var9.func_983_a((double)(var1 + var5), (double)(var2 + var6), 0.0D, (double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8));
        var9.func_983_a((double)(var1 + var5), (double)(var2 + 0), 0.0D, (double)((float)(var3 + var5) * var7), (double)((float)(var4 + 0) * var8));
        var9.func_983_a((double)(var1 + 0), (double)(var2 + 0), 0.0D, (double)((float)(var3 + 0) * var7), (double)((float)(var4 + 0) * var8));
        var9.func_982_a();
    }

    public static File func_6240_b() {
        if (field_6275_Z == null) {
            field_6275_Z = func_6264_a("minecraft");
        }

        return field_6275_Z;
    }

    public static File func_6264_a(String var0) {
        String var1 = System.getProperty("user.home", ".");
        File var2;
        switch(EnumOSMappingHelper.field_1585_a[func_6267_r().ordinal()]) {
        case 1:
        case 2:
            var2 = new File(var1, '.' + var0 + '/');
            break;
        case 3:
            String var3 = System.getenv("APPDATA");
            if (var3 != null) {
                var2 = new File(var3, "." + var0 + '/');
            } else {
                var2 = new File(var1, '.' + var0 + '/');
            }
            break;
        case 4:
            var2 = new File(var1, "Library/Application Support/" + var0);
            break;
        default:
            var2 = new File(var1, var0 + '/');
        }

        if (!var2.exists() && !var2.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + var2);
        } else {
            return var2;
        }
    }

    private static EnumOS2 func_6267_r() {
        String var0 = System.getProperty("os.name").toLowerCase();
        if (var0.contains("win")) {
            return EnumOS2.windows;
        } else if (var0.contains("mac")) {
            return EnumOS2.macos;
        } else if (var0.contains("solaris")) {
            return EnumOS2.solaris;
        } else if (var0.contains("sunos")) {
            return EnumOS2.solaris;
        } else if (var0.contains("linux")) {
            return EnumOS2.linux;
        } else {
            return var0.contains("unix") ? EnumOS2.linux : EnumOS2.unknown;
        }
    }

    public ISaveFormat func_22004_c() {
        return this.field_22008_V;
    }

    public void func_6272_a(GuiScreen var1) {
        if (!(this.field_6313_p instanceof GuiUnused)) {
            if (this.field_6313_p != null) {
                this.field_6313_p.func_6449_h();
            }

            if (var1 instanceof GuiMainMenu) {
                this.field_25001_G.func_27175_b();
            }

            this.field_25001_G.func_27182_c();
            if (var1 == null && this.field_6324_e == null) {
                var1 = new GuiMainMenu();
            } else if (var1 == null && this.field_6322_g.field_9337_J <= 0) {
                var1 = new GuiGameOver();
            }

            if (var1 instanceof GuiMainMenu) {
                this.field_6308_u.func_28097_b();
            }

            this.field_6313_p = (GuiScreen)var1;
            if (var1 != null) {
                this.func_6273_f();
                ScaledResolution var2 = new ScaledResolution(this.field_6304_y, this.field_6326_c, this.field_6325_d);
                int var3 = var2.func_903_a();
                int var4 = var2.func_902_b();
                ((GuiScreen)var1).func_6447_a(this, var3, var4);
                this.field_6307_v = false;
            } else {
                this.func_6259_e();
            }

        }
    }

    private void func_6250_c(String var1) {
        int var2 = GL11.glGetError();
        if (var2 != 0) {
            String var3 = GLU.gluErrorString(var2);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + var1);
            System.out.println(var2 + ": " + var3);
        }

    }

    public void func_6266_c() {
        try {
            this.field_25001_G.func_27175_b();
            this.field_25001_G.func_27182_c();
            if (this.field_9241_z != null) {
                this.field_9241_z.func_6231_c();
            }

            try {
                if (this.field_6284_Q != null) {
                    this.field_6284_Q.func_1208_b();
                }
            } catch (Exception var9) {
            }

            System.out.println("Stopping!");

            try {
                this.func_6261_a((World)null);
            } catch (Throwable var8) {
            }

            try {
                GLAllocation.func_1126_a();
            } catch (Throwable var7) {
            }

            this.field_6301_A.func_330_b();
            Mouse.destroy();
            Keyboard.destroy();
        } finally {
            Display.destroy();
            if (!this.field_28004_R) {
                System.exit(0);
            }

        }

        System.gc();
    }

    public void run() {
        this.field_6293_H = true;

        try {
            this.func_6271_a();
        } catch (Exception var17) {
            var17.printStackTrace();
            this.func_28003_b(new UnexpectedThrowable("Failed to start game", var17));
            return;
        }

        try {
            long var1 = System.currentTimeMillis();
            int var3 = 0;

            while(this.field_6293_H) {
                try {
                    if (this.field_9241_z != null && !this.field_9241_z.isActive()) {
                        break;
                    }

                    AxisAlignedBB.func_4149_a();
                    Vec3D.func_1259_a();
                    if (this.field_9244_k == null && Display.isCloseRequested()) {
                        this.func_6244_d();
                    }

                    if (this.field_6316_m && this.field_6324_e != null) {
                        float var4 = this.field_9237_P.field_1378_c;
                        this.field_9237_P.func_904_a();
                        this.field_9237_P.field_1378_c = var4;
                    } else {
                        this.field_9237_P.func_904_a();
                    }

                    long var23 = System.nanoTime();

                    for(int var6 = 0; var6 < this.field_9237_P.field_1379_b; ++var6) {
                        ++this.field_6283_R;

                        try {
                            this.func_6246_i();
                        } catch (MinecraftException var16) {
                            this.field_6324_e = null;
                            this.func_6261_a((World)null);
                            this.func_6272_a(new GuiConflictWarning());
                        }
                    }

                    long var24 = System.nanoTime() - var23;
                    this.func_6250_c("Pre render");
                    RenderBlocks.field_27406_a = this.field_6304_y.field_1576_i;
                    this.field_6301_A.func_338_a(this.field_6322_g, this.field_9237_P.field_1378_c);
                    GL11.glEnable(3553);
                    if (this.field_6324_e != null) {
                        this.field_6324_e.func_6465_g();
                    }

                    if (!Keyboard.isKeyDown(65)) {
                        Display.update();
                    }

                    if (this.field_6322_g != null && this.field_6322_g.func_345_I()) {
                        this.field_6304_y.field_1560_x = false;
                    }

                    if (!this.field_6307_v) {
                        if (this.field_6327_b != null) {
                            this.field_6327_b.func_6467_a(this.field_9237_P.field_1378_c);
                        }

                        this.field_9243_r.func_4136_b(this.field_9237_P.field_1378_c);
                    }

                    if (!Display.isActive()) {
                        if (this.field_185_a) {
                            this.func_6270_h();
                        }

                        Thread.sleep(10L);
                    }

                    if (this.field_6304_y.field_22276_A) {
                        this.func_6238_a(var24);
                    } else {
                        this.field_6290_K = System.nanoTime();
                    }

                    this.field_25002_t.func_25080_a();
                    Thread.yield();
                    if (Keyboard.isKeyDown(65)) {
                        Display.update();
                    }

                    this.func_6248_s();
                    if (this.field_9244_k != null && !this.field_185_a && (this.field_9244_k.getWidth() != this.field_6326_c || this.field_9244_k.getHeight() != this.field_6325_d)) {
                        this.field_6326_c = this.field_9244_k.getWidth();
                        this.field_6325_d = this.field_9244_k.getHeight();
                        if (this.field_6326_c <= 0) {
                            this.field_6326_c = 1;
                        }

                        if (this.field_6325_d <= 0) {
                            this.field_6325_d = 1;
                        }

                        this.func_6249_a(this.field_6326_c, this.field_6325_d);
                    }

                    this.func_6250_c("Post render");
                    ++var3;

                    for(this.field_6316_m = !this.func_6260_j() && this.field_6313_p != null && this.field_6313_p.func_6450_b(); System.currentTimeMillis() >= var1 + 1000L; var3 = 0) {
                        this.field_6292_I = var3 + " fps, " + WorldRenderer.field_1762_b + " chunk updates";
                        WorldRenderer.field_1762_b = 0;
                        var1 += 1000L;
                    }
                } catch (MinecraftException var18) {
                    this.field_6324_e = null;
                    this.func_6261_a((World)null);
                    this.func_6272_a(new GuiConflictWarning());
                } catch (OutOfMemoryError var19) {
                    this.func_28002_e();
                    this.func_6272_a(new GuiErrorScreen());
                    System.gc();
                }
            }
        } catch (MinecraftError var20) {
        } catch (Throwable var21) {
            this.func_28002_e();
            var21.printStackTrace();
            this.func_28003_b(new UnexpectedThrowable("Unexpected error", var21));
        } finally {
            this.func_6266_c();
        }

    }

    public void func_28002_e() {
        try {
            field_28006_b = new byte[0];
            this.field_6323_f.func_28137_f();
        } catch (Throwable var4) {
        }

        try {
            System.gc();
            AxisAlignedBB.func_28196_a();
            Vec3D.func_28215_a();
        } catch (Throwable var3) {
        }

        try {
            System.gc();
            this.func_6261_a((World)null);
        } catch (Throwable var2) {
        }

        System.gc();
    }

    private void func_6248_s() {
        if (Keyboard.isKeyDown(60)) {
            if (!this.field_6291_J) {
                this.field_6291_J = true;
                this.field_6308_u.func_552_a(ScreenShotHelper.func_4148_a(field_6275_Z, this.field_6326_c, this.field_6325_d));
            }
        } else {
            this.field_6291_J = false;
        }

    }

    private void func_6238_a(long var1) {
        long var3 = 16666666L;
        if (this.field_6290_K == -1L) {
            this.field_6290_K = System.nanoTime();
        }

        long var5 = System.nanoTime();
        field_9239_F[field_9238_G & field_9240_E.length - 1] = var1;
        field_9240_E[field_9238_G++ & field_9240_E.length - 1] = var5 - this.field_6290_K;
        this.field_6290_K = var5;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, (double)this.field_6326_c, (double)this.field_6325_d, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
        GL11.glLineWidth(1.0F);
        GL11.glDisable(3553);
        Tessellator var7 = Tessellator.field_1512_a;
        var7.func_992_a(7);
        int var8 = (int)(var3 / 200000L);
        var7.func_990_b(536870912);
        var7.func_991_a(0.0D, (double)(this.field_6325_d - var8), 0.0D);
        var7.func_991_a(0.0D, (double)this.field_6325_d, 0.0D);
        var7.func_991_a((double)field_9240_E.length, (double)this.field_6325_d, 0.0D);
        var7.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var8), 0.0D);
        var7.func_990_b(538968064);
        var7.func_991_a(0.0D, (double)(this.field_6325_d - var8 * 2), 0.0D);
        var7.func_991_a(0.0D, (double)(this.field_6325_d - var8), 0.0D);
        var7.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var8), 0.0D);
        var7.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var8 * 2), 0.0D);
        var7.func_982_a();
        long var9 = 0L;

        int var11;
        for(var11 = 0; var11 < field_9240_E.length; ++var11) {
            var9 += field_9240_E[var11];
        }

        var11 = (int)(var9 / 200000L / (long)field_9240_E.length);
        var7.func_992_a(7);
        var7.func_990_b(541065216);
        var7.func_991_a(0.0D, (double)(this.field_6325_d - var11), 0.0D);
        var7.func_991_a(0.0D, (double)this.field_6325_d, 0.0D);
        var7.func_991_a((double)field_9240_E.length, (double)this.field_6325_d, 0.0D);
        var7.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var11), 0.0D);
        var7.func_982_a();
        var7.func_992_a(1);

        for(int var12 = 0; var12 < field_9240_E.length; ++var12) {
            int var13 = (var12 - field_9238_G & field_9240_E.length - 1) * 255 / field_9240_E.length;
            int var14 = var13 * var13 / 255;
            var14 = var14 * var14 / 255;
            int var15 = var14 * var14 / 255;
            var15 = var15 * var15 / 255;
            if (field_9240_E[var12] > var3) {
                var7.func_990_b(-16777216 + var14 * 65536);
            } else {
                var7.func_990_b(-16777216 + var14 * 256);
            }

            long var16 = field_9240_E[var12] / 200000L;
            long var18 = field_9239_F[var12] / 200000L;
            var7.func_991_a((double)((float)var12 + 0.5F), (double)((float)((long)this.field_6325_d - var16) + 0.5F), 0.0D);
            var7.func_991_a((double)((float)var12 + 0.5F), (double)((float)this.field_6325_d + 0.5F), 0.0D);
            var7.func_990_b(-16777216 + var14 * 65536 + var14 * 256 + var14 * 1);
            var7.func_991_a((double)((float)var12 + 0.5F), (double)((float)((long)this.field_6325_d - var16) + 0.5F), 0.0D);
            var7.func_991_a((double)((float)var12 + 0.5F), (double)((float)((long)this.field_6325_d - (var16 - var18)) + 0.5F), 0.0D);
        }

        var7.func_982_a();
        GL11.glEnable(3553);
    }

    public void func_6244_d() {
        this.field_6293_H = false;
    }

    public void func_6259_e() {
        if (Display.isActive()) {
            if (!this.field_6289_L) {
                this.field_6289_L = true;
                this.field_6299_B.func_774_a();
                this.func_6272_a((GuiScreen)null);
                this.field_6282_S = 10000;
                this.field_6302_aa = this.field_6283_R + 10000;
            }
        }
    }

    public void func_6273_f() {
        if (this.field_6289_L) {
            if (this.field_6322_g != null) {
                this.field_6322_g.func_458_k();
            }

            this.field_6289_L = false;
            this.field_6299_B.func_773_b();
        }
    }

    public void func_6252_g() {
        if (this.field_6313_p == null) {
            this.func_6272_a(new GuiIngameMenu());
        }
    }

    private void func_6254_a(int var1, boolean var2) {
        if (!this.field_6327_b.field_1064_b) {
            if (!var2) {
                this.field_6282_S = 0;
            }

            if (var1 != 0 || this.field_6282_S <= 0) {
                if (var2 && this.field_6305_x != null && this.field_6305_x.field_1167_a == EnumMovingObjectType.TILE && var1 == 0) {
                    int var3 = this.field_6305_x.field_1166_b;
                    int var4 = this.field_6305_x.field_1172_c;
                    int var5 = this.field_6305_x.field_1171_d;
                    this.field_6327_b.func_6470_c(var3, var4, var5, this.field_6305_x.field_1170_e);
                    this.field_6321_h.func_1191_a(var3, var4, var5, this.field_6305_x.field_1170_e);
                } else {
                    this.field_6327_b.func_6468_a();
                }

            }
        }
    }

    private void func_6243_a(int var1) {
        if (var1 != 0 || this.field_6282_S <= 0) {
            if (var1 == 0) {
                this.field_6322_g.func_457_w();
            }

            boolean var2 = true;
            if (this.field_6305_x == null) {
                if (var1 == 0 && !(this.field_6327_b instanceof PlayerControllerTest)) {
                    this.field_6282_S = 10;
                }
            } else if (this.field_6305_x.field_1167_a == EnumMovingObjectType.ENTITY) {
                if (var1 == 0) {
                    this.field_6327_b.func_6472_b(this.field_6322_g, this.field_6305_x.field_1168_g);
                }

                if (var1 == 1) {
                    this.field_6327_b.func_6475_a(this.field_6322_g, this.field_6305_x.field_1168_g);
                }
            } else if (this.field_6305_x.field_1167_a == EnumMovingObjectType.TILE) {
                int var3 = this.field_6305_x.field_1166_b;
                int var4 = this.field_6305_x.field_1172_c;
                int var5 = this.field_6305_x.field_1171_d;
                int var6 = this.field_6305_x.field_1170_e;
                if (var1 == 0) {
                    this.field_6327_b.func_719_a(var3, var4, var5, this.field_6305_x.field_1170_e);
                } else {
                    ItemStack var7 = this.field_6322_g.field_778_b.func_494_a();
                    int var8 = var7 != null ? var7.field_1615_a : 0;
                    if (this.field_6327_b.func_722_a(this.field_6322_g, this.field_6324_e, var7, var3, var4, var5, var6)) {
                        var2 = false;
                        this.field_6322_g.func_457_w();
                    }

                    if (var7 == null) {
                        return;
                    }

                    if (var7.field_1615_a == 0) {
                        this.field_6322_g.field_778_b.field_843_a[this.field_6322_g.field_778_b.field_847_d] = null;
                    } else if (var7.field_1615_a != var8) {
                        this.field_9243_r.field_1395_a.func_9449_b();
                    }
                }
            }

            if (var2 && var1 == 1) {
                ItemStack var9 = this.field_6322_g.field_778_b.func_494_a();
                if (var9 != null && this.field_6327_b.func_6471_a(this.field_6322_g, this.field_6324_e, var9)) {
                    this.field_9243_r.field_1395_a.func_9450_c();
                }
            }

        }
    }

    public void func_6270_h() {
        try {
            this.field_185_a = !this.field_185_a;
            if (this.field_185_a) {
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                this.field_6326_c = Display.getDisplayMode().getWidth();
                this.field_6325_d = Display.getDisplayMode().getHeight();
                if (this.field_6326_c <= 0) {
                    this.field_6326_c = 1;
                }

                if (this.field_6325_d <= 0) {
                    this.field_6325_d = 1;
                }
            } else {
                if (this.field_9244_k != null) {
                    this.field_6326_c = this.field_9244_k.getWidth();
                    this.field_6325_d = this.field_9244_k.getHeight();
                } else {
                    this.field_6326_c = this.field_9236_T;
                    this.field_6325_d = this.field_9235_U;
                }

                if (this.field_6326_c <= 0) {
                    this.field_6326_c = 1;
                }

                if (this.field_6325_d <= 0) {
                    this.field_6325_d = 1;
                }
            }

            if (this.field_6313_p != null) {
                this.func_6249_a(this.field_6326_c, this.field_6325_d);
            }

            Display.setFullscreen(this.field_185_a);
            Display.update();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void func_6249_a(int var1, int var2) {
        if (var1 <= 0) {
            var1 = 1;
        }

        if (var2 <= 0) {
            var2 = 1;
        }

        this.field_6326_c = var1;
        this.field_6325_d = var2;
        if (this.field_6313_p != null) {
            ScaledResolution var3 = new ScaledResolution(this.field_6304_y, var1, var2);
            int var4 = var3.func_903_a();
            int var5 = var3.func_902_b();
            this.field_6313_p.func_6447_a(this, var4, var5);
        }

    }

    private void func_6265_t() {
        if (this.field_6305_x != null) {
            int var1 = this.field_6324_e.func_600_a(this.field_6305_x.field_1166_b, this.field_6305_x.field_1172_c, this.field_6305_x.field_1171_d);
            if (var1 == Block.field_337_v.field_376_bc) {
                var1 = Block.field_336_w.field_376_bc;
            }

            if (var1 == Block.field_411_ak.field_376_bc) {
                var1 = Block.field_410_al.field_376_bc;
            }

            if (var1 == Block.field_403_A.field_376_bc) {
                var1 = Block.field_338_u.field_376_bc;
            }

            this.field_6322_g.field_778_b.func_496_a(var1, this.field_6327_b instanceof PlayerControllerTest);
        }

    }

    private void func_28001_B() {
        (new ThreadCheckHasPaid(this)).start();
    }

    public void func_6246_i() {
        if (this.field_6283_R == 6000) {
            this.func_28001_B();
        }

        this.field_25001_G.func_27178_d();
        this.field_6308_u.func_555_a();
        this.field_9243_r.func_910_a(1.0F);
        int var3;
        if (this.field_6322_g != null) {
            IChunkProvider var1 = this.field_6324_e.func_21118_q();
            if (var1 instanceof ChunkProviderLoadOrGenerate) {
                ChunkProviderLoadOrGenerate var2 = (ChunkProviderLoadOrGenerate)var1;
                var3 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_611_ak)) >> 4;
                int var4 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_609_am)) >> 4;
                var2.func_21110_c(var3, var4);
            }
        }

        if (!this.field_6316_m && this.field_6324_e != null) {
            this.field_6327_b.func_6474_c();
        }

        GL11.glBindTexture(3553, this.field_6315_n.func_1070_a("/terrain.png"));
        if (!this.field_6316_m) {
            this.field_6315_n.func_1067_a();
        }

        if (this.field_6313_p == null && this.field_6322_g != null) {
            if (this.field_6322_g.field_9337_J <= 0) {
                this.func_6272_a((GuiScreen)null);
            } else if (this.field_6322_g.func_22051_K() && this.field_6324_e != null && this.field_6324_e.field_1026_y) {
                this.func_6272_a(new GuiSleepMP());
            }
        } else if (this.field_6313_p != null && this.field_6313_p instanceof GuiSleepMP && !this.field_6322_g.func_22051_K()) {
            this.func_6272_a((GuiScreen)null);
        }

        if (this.field_6313_p != null) {
            this.field_6282_S = 10000;
            this.field_6302_aa = this.field_6283_R + 10000;
        }

        if (this.field_6313_p != null) {
            this.field_6313_p.func_564_d();
            if (this.field_6313_p != null) {
                this.field_6313_p.field_25091_h.func_25088_a();
                this.field_6313_p.func_570_g();
            }
        }

        if (this.field_6313_p == null || this.field_6313_p.field_948_f) {
            label301:
            while(true) {
                while(true) {
                    while(true) {
                        long var5;
                        do {
                            if (!Mouse.next()) {
                                if (this.field_6282_S > 0) {
                                    --this.field_6282_S;
                                }

                                while(true) {
                                    while(true) {
                                        do {
                                            if (!Keyboard.next()) {
                                                if (this.field_6313_p == null) {
                                                    if (Mouse.isButtonDown(0) && (float)(this.field_6283_R - this.field_6302_aa) >= this.field_9237_P.field_1380_a / 4.0F && this.field_6289_L) {
                                                        this.func_6243_a(0);
                                                        this.field_6302_aa = this.field_6283_R;
                                                    }

                                                    if (Mouse.isButtonDown(1) && (float)(this.field_6283_R - this.field_6302_aa) >= this.field_9237_P.field_1380_a / 4.0F && this.field_6289_L) {
                                                        this.func_6243_a(1);
                                                        this.field_6302_aa = this.field_6283_R;
                                                    }
                                                }

                                                this.func_6254_a(0, this.field_6313_p == null && Mouse.isButtonDown(0) && this.field_6289_L);
                                                break label301;
                                            }

                                            this.field_6322_g.func_460_a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                                        } while(!Keyboard.getEventKeyState());

                                        if (Keyboard.getEventKey() == 87) {
                                            this.func_6270_h();
                                        } else {
                                            if (this.field_6313_p != null) {
                                                this.field_6313_p.func_569_f();
                                            } else {
                                                if (Keyboard.getEventKey() == 1) {
                                                    this.func_6252_g();
                                                }

                                                if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                                                    this.func_6242_u();
                                                }

                                                if (Keyboard.getEventKey() == 59) {
                                                    this.field_6304_y.field_22277_y = !this.field_6304_y.field_22277_y;
                                                }

                                                if (Keyboard.getEventKey() == 61) {
                                                    this.field_6304_y.field_22276_A = !this.field_6304_y.field_22276_A;
                                                }

                                                if (Keyboard.getEventKey() == 63) {
                                                    this.field_6304_y.field_1560_x = !this.field_6304_y.field_1560_x;
                                                }

                                                if (Keyboard.getEventKey() == 66) {
                                                    this.field_6304_y.field_22274_D = !this.field_6304_y.field_22274_D;
                                                }

                                                if (Keyboard.getEventKey() == this.field_6304_y.field_1570_o.field_1370_b) {
                                                    this.func_6272_a(new GuiInventory(this.field_6322_g));
                                                }

                                                if (Keyboard.getEventKey() == this.field_6304_y.field_6523_q.field_1370_b) {
                                                    this.field_6322_g.func_20060_w();
                                                }

                                                if (this.func_6260_j() && Keyboard.getEventKey() == this.field_6304_y.field_6521_r.field_1370_b) {
                                                    this.func_6272_a(new GuiChat());
                                                }
                                            }

                                            for(int var6 = 0; var6 < 9; ++var6) {
                                                if (Keyboard.getEventKey() == 2 + var6) {
                                                    this.field_6322_g.field_778_b.field_847_d = var6;
                                                }
                                            }

                                            if (Keyboard.getEventKey() == this.field_6304_y.field_6520_s.field_1370_b) {
                                                this.field_6304_y.func_1045_b(EnumOptions.RENDER_DISTANCE, !Keyboard.isKeyDown(42) && !Keyboard.isKeyDown(54) ? 1 : -1);
                                            }
                                        }
                                    }
                                }
                            }

                            var5 = System.currentTimeMillis() - this.field_6287_N;
                        } while(var5 > 200L);

                        var3 = Mouse.getEventDWheel();
                        if (var3 != 0) {
                            this.field_6322_g.field_778_b.func_498_a(var3);
                            if (this.field_6304_y.field_22275_C) {
                                if (var3 > 0) {
                                    var3 = 1;
                                }

                                if (var3 < 0) {
                                    var3 = -1;
                                }

                                GameSettings var10000 = this.field_6304_y;
                                var10000.field_22272_F += (float)var3 * 0.25F;
                            }
                        }

                        if (this.field_6313_p == null) {
                            if (!this.field_6289_L && Mouse.getEventButtonState()) {
                                this.func_6259_e();
                            } else {
                                if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
                                    this.func_6243_a(0);
                                    this.field_6302_aa = this.field_6283_R;
                                }

                                if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                                    this.func_6243_a(1);
                                    this.field_6302_aa = this.field_6283_R;
                                }

                                if (Mouse.getEventButton() == 2 && Mouse.getEventButtonState()) {
                                    this.func_6265_t();
                                }
                            }
                        } else if (this.field_6313_p != null) {
                            this.field_6313_p.func_566_e();
                        }
                    }
                }
            }
        }

        if (this.field_6324_e != null) {
            if (this.field_6322_g != null) {
                ++this.field_6300_ab;
                if (this.field_6300_ab == 30) {
                    this.field_6300_ab = 0;
                    this.field_6324_e.func_705_f(this.field_6322_g);
                }
            }

            this.field_6324_e.field_1039_l = this.field_6304_y.field_1561_w;
            if (this.field_6324_e.field_1026_y) {
                this.field_6324_e.field_1039_l = 3;
            }

            if (!this.field_6316_m) {
                this.field_9243_r.func_911_a();
            }

            if (!this.field_6316_m) {
                this.field_6323_f.func_945_d();
            }

            if (!this.field_6316_m) {
                if (this.field_6324_e.field_27172_i > 0) {
                    --this.field_6324_e.field_27172_i;
                }

                this.field_6324_e.func_633_c();
            }

            if (!this.field_6316_m || this.func_6260_j()) {
                this.field_6324_e.func_21114_a(this.field_6304_y.field_1561_w > 0, true);
                this.field_6324_e.func_649_g();
            }

            if (!this.field_6316_m && this.field_6324_e != null) {
                this.field_6324_e.func_677_m(MathHelper.func_1108_b(this.field_6322_g.field_611_ak), MathHelper.func_1108_b(this.field_6322_g.field_610_al), MathHelper.func_1108_b(this.field_6322_g.field_609_am));
            }

            if (!this.field_6316_m) {
                this.field_6321_h.func_1193_a();
            }
        }

        this.field_6287_N = System.currentTimeMillis();
    }

    private void func_6242_u() {
        System.out.println("FORCING RELOAD!");
        this.field_6301_A = new SoundManager();
        this.field_6301_A.func_340_a(this.field_6304_y);
        this.field_6284_Q.func_1210_a();
    }

    public boolean func_6260_j() {
        return this.field_6324_e != null && this.field_6324_e.field_1026_y;
    }

    public void func_6247_b(String var1, String var2, long var3) {
        this.func_6261_a((World)null);
        System.gc();
        if (this.field_22008_V.func_22175_a(var1)) {
            this.func_22002_b(var1, var2);
        } else {
            ISaveHandler var5 = this.field_22008_V.func_22174_a(var1, false);
            World var6 = null;
            var6 = new World(var5, var2, var3);
            if (var6.field_1033_r) {
                this.field_25001_G.func_25100_a(StatList.field_25183_f, 1);
                this.field_25001_G.func_25100_a(StatList.field_25184_e, 1);
                this.func_6263_a(var6, "Generating level");
            } else {
                this.field_25001_G.func_25100_a(StatList.field_25182_g, 1);
                this.field_25001_G.func_25100_a(StatList.field_25184_e, 1);
                this.func_6263_a(var6, "Loading level");
            }
        }

    }

    public void func_6237_k() {
        System.out.println("Toggling dimension!!");
        if (this.field_6322_g.field_4129_m == -1) {
            this.field_6322_g.field_4129_m = 0;
        } else {
            this.field_6322_g.field_4129_m = -1;
        }

        this.field_6324_e.func_607_d(this.field_6322_g);
        this.field_6322_g.field_646_aA = false;
        double var1 = this.field_6322_g.field_611_ak;
        double var3 = this.field_6322_g.field_609_am;
        double var5 = 8.0D;
        World var7;
        if (this.field_6322_g.field_4129_m == -1) {
            var1 /= var5;
            var3 /= var5;
            this.field_6322_g.func_365_c(var1, this.field_6322_g.field_610_al, var3, this.field_6322_g.field_605_aq, this.field_6322_g.field_604_ar);
            if (this.field_6322_g.func_354_B()) {
                this.field_6324_e.func_4084_a(this.field_6322_g, false);
            }

            var7 = null;
            var7 = new World(this.field_6324_e, WorldProvider.func_4101_a(-1));
            this.func_6256_a(var7, "Entering the Nether", this.field_6322_g);
        } else {
            var1 *= var5;
            var3 *= var5;
            this.field_6322_g.func_365_c(var1, this.field_6322_g.field_610_al, var3, this.field_6322_g.field_605_aq, this.field_6322_g.field_604_ar);
            if (this.field_6322_g.func_354_B()) {
                this.field_6324_e.func_4084_a(this.field_6322_g, false);
            }

            var7 = null;
            var7 = new World(this.field_6324_e, WorldProvider.func_4101_a(0));
            this.func_6256_a(var7, "Leaving the Nether", this.field_6322_g);
        }

        this.field_6322_g.field_615_ag = this.field_6324_e;
        if (this.field_6322_g.func_354_B()) {
            this.field_6322_g.func_365_c(var1, this.field_6322_g.field_610_al, var3, this.field_6322_g.field_605_aq, this.field_6322_g.field_604_ar);
            this.field_6324_e.func_4084_a(this.field_6322_g, false);
            (new Teleporter()).func_4107_a(this.field_6324_e, this.field_6322_g);
        }

    }

    public void func_6261_a(World var1) {
        this.func_6263_a(var1, "");
    }

    public void func_6263_a(World var1, String var2) {
        this.func_6256_a(var1, var2, (EntityPlayer)null);
    }

    public void func_6256_a(World var1, String var2, EntityPlayer var3) {
        this.field_25001_G.func_27175_b();
        this.field_25001_G.func_27182_c();
        this.field_22009_h = null;
        this.field_6312_q.func_596_a(var2);
        this.field_6312_q.func_595_d("");
        this.field_6301_A.func_331_a((String)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        if (this.field_6324_e != null) {
            this.field_6324_e.func_651_a(this.field_6312_q);
        }

        this.field_6324_e = var1;
        if (var1 != null) {
            this.field_6327_b.func_717_a(var1);
            if (!this.func_6260_j()) {
                if (var3 == null) {
                    this.field_6322_g = (EntityPlayerSP)var1.func_4085_a(EntityPlayerSP.class);
                }
            } else if (this.field_6322_g != null) {
                this.field_6322_g.func_374_q();
                if (var1 != null) {
                    var1.func_674_a(this.field_6322_g);
                }
            }

            if (!var1.field_1026_y) {
                this.func_6255_d(var2);
            }

            if (this.field_6322_g == null) {
                this.field_6322_g = (EntityPlayerSP)this.field_6327_b.func_4087_b(var1);
                this.field_6322_g.func_374_q();
                this.field_6327_b.func_6476_a(this.field_6322_g);
            }

            this.field_6322_g.field_787_a = new MovementInputFromOptions(this.field_6304_y);
            if (this.field_6323_f != null) {
                this.field_6323_f.func_946_a(var1);
            }

            if (this.field_6321_h != null) {
                this.field_6321_h.func_1188_a(var1);
            }

            this.field_6327_b.func_6473_b(this.field_6322_g);
            if (var3 != null) {
                var1.func_6464_c();
            }

            IChunkProvider var4 = var1.func_21118_q();
            if (var4 instanceof ChunkProviderLoadOrGenerate) {
                ChunkProviderLoadOrGenerate var5 = (ChunkProviderLoadOrGenerate)var4;
                int var6 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_611_ak)) >> 4;
                int var7 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_609_am)) >> 4;
                var5.func_21110_c(var6, var7);
            }

            var1.func_608_a(this.field_6322_g);
            if (var1.field_1033_r) {
                var1.func_651_a(this.field_6312_q);
            }

            this.field_22009_h = this.field_6322_g;
        } else {
            this.field_6322_g = null;
        }

        System.gc();
        this.field_6287_N = 0L;
    }

    private void func_22002_b(String var1, String var2) {
        this.field_6312_q.func_596_a("Converting World to " + this.field_22008_V.func_22178_a());
        this.field_6312_q.func_595_d("This may take a while :)");
        this.field_22008_V.func_22171_a(var1, this.field_6312_q);
        this.func_6247_b(var1, var2, 0L);
    }

    private void func_6255_d(String var1) {
        this.field_6312_q.func_596_a(var1);
        this.field_6312_q.func_595_d("Building terrain");
        short var2 = 128;
        int var3 = 0;
        int var4 = var2 * 2 / 16 + 1;
        var4 *= var4;
        IChunkProvider var5 = this.field_6324_e.func_21118_q();
        ChunkCoordinates var6 = this.field_6324_e.func_22137_s();
        if (this.field_6322_g != null) {
            var6.field_22395_a = (int)this.field_6322_g.field_611_ak;
            var6.field_22396_c = (int)this.field_6322_g.field_609_am;
        }

        if (var5 instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate var7 = (ChunkProviderLoadOrGenerate)var5;
            var7.func_21110_c(var6.field_22395_a >> 4, var6.field_22396_c >> 4);
        }

        for(int var10 = -var2; var10 <= var2; var10 += 16) {
            for(int var8 = -var2; var8 <= var2; var8 += 16) {
                this.field_6312_q.func_593_a(var3++ * 100 / var4);
                this.field_6324_e.func_600_a(var6.field_22395_a + var10, 64, var6.field_22396_c + var8);

                while(this.field_6324_e.func_6465_g()) {
                }
            }
        }

        this.field_6312_q.func_595_d("Simulating world for a bit");
        boolean var9 = true;
        this.field_6324_e.func_656_j();
    }

    public void func_6268_a(String var1, File var2) {
        int var3 = var1.indexOf("/");
        String var4 = var1.substring(0, var3);
        var1 = var1.substring(var3 + 1);
        if (var4.equalsIgnoreCase("sound")) {
            this.field_6301_A.func_6372_a(var1, var2);
        } else if (var4.equalsIgnoreCase("newsound")) {
            this.field_6301_A.func_6372_a(var1, var2);
        } else if (var4.equalsIgnoreCase("streaming")) {
            this.field_6301_A.func_6373_b(var1, var2);
        } else if (var4.equalsIgnoreCase("music")) {
            this.field_6301_A.func_6374_c(var1, var2);
        } else if (var4.equalsIgnoreCase("newmusic")) {
            this.field_6301_A.func_6374_c(var1, var2);
        }

    }

    public OpenGlCapsChecker func_6251_l() {
        return this.field_6286_O;
    }

    public String func_6241_m() {
        return this.field_6323_f.func_953_b();
    }

    public String func_6262_n() {
        return this.field_6323_f.func_957_c();
    }

    public String func_21002_o() {
        return this.field_6324_e.func_21119_g();
    }

    public String func_6245_o() {
        return "P: " + this.field_6321_h.func_1190_b() + ". T: " + this.field_6324_e.func_687_d();
    }

    public void func_6239_p(boolean var1, int var2) {
        if (!this.field_6324_e.field_1026_y && !this.field_6324_e.field_4209_q.func_6477_d()) {
            this.func_6237_k();
        }

        ChunkCoordinates var3 = null;
        ChunkCoordinates var4 = null;
        boolean var5 = true;
        if (this.field_6322_g != null && !var1) {
            var3 = this.field_6322_g.func_25059_P();
            if (var3 != null) {
                var4 = EntityPlayer.func_25060_a(this.field_6324_e, var3);
                if (var4 == null) {
                    this.field_6322_g.func_22055_b("tile.bed.notValid");
                }
            }
        }

        if (var4 == null) {
            var4 = this.field_6324_e.func_22137_s();
            var5 = false;
        }

        IChunkProvider var6 = this.field_6324_e.func_21118_q();
        if (var6 instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate var7 = (ChunkProviderLoadOrGenerate)var6;
            var7.func_21110_c(var4.field_22395_a >> 4, var4.field_22396_c >> 4);
        }

        this.field_6324_e.func_4076_b();
        this.field_6324_e.func_9424_o();
        int var8 = 0;
        if (this.field_6322_g != null) {
            var8 = this.field_6322_g.field_620_ab;
            this.field_6324_e.func_607_d(this.field_6322_g);
        }

        this.field_22009_h = null;
        this.field_6322_g = (EntityPlayerSP)this.field_6327_b.func_4087_b(this.field_6324_e);
        this.field_6322_g.field_4129_m = var2;
        this.field_22009_h = this.field_6322_g;
        this.field_6322_g.func_374_q();
        if (var5) {
            this.field_6322_g.func_25061_a(var3);
            this.field_6322_g.func_365_c((double)((float)var4.field_22395_a + 0.5F), (double)((float)var4.field_22394_b + 0.1F), (double)((float)var4.field_22396_c + 0.5F), 0.0F, 0.0F);
        }

        this.field_6327_b.func_6476_a(this.field_6322_g);
        this.field_6324_e.func_608_a(this.field_6322_g);
        this.field_6322_g.field_787_a = new MovementInputFromOptions(this.field_6304_y);
        this.field_6322_g.field_620_ab = var8;
        this.field_6322_g.func_6420_o();
        this.field_6327_b.func_6473_b(this.field_6322_g);
        this.func_6255_d("Respawning");
        if (this.field_6313_p instanceof GuiGameOver) {
            this.func_6272_a((GuiScreen)null);
        }

    }

    public static void func_6269_a(String var0, String var1) {
        func_6253_a(var0, var1, (String)null);
    }

    public static void func_6253_a(String var0, String var1, String var2) {
        boolean var3 = false;
        Frame var5 = new Frame("Minecraft");
        Canvas var6 = new Canvas();
        var5.setLayout(new BorderLayout());
        var5.add(var6, "Center");
        var6.setPreferredSize(new Dimension(854, 480));
        var5.pack();
        var5.setLocationRelativeTo((Component)null);
        MinecraftImpl var7 = new MinecraftImpl(var5, var6, (MinecraftApplet)null, 854, 480, var3, var5);
        Thread var8 = new Thread(var7, "Minecraft main thread");
        var8.setPriority(10);
        var7.field_6319_j = "www.minecraft.net";
        if (var0 != null && var1 != null) {
            var7.field_6320_i = new Session(var0, var1);
        } else {
            var7.field_6320_i = new Session("Player" + System.currentTimeMillis() % 1000L, "");
        }

        if (var2 != null) {
            String[] var9 = var2.split(":");
            var7.func_6258_a(var9[0], Integer.parseInt(var9[1]));
        }

        var5.setVisible(true);
        var5.addWindowListener(new GameWindowListener(var7, var8));
        var8.start();
    }

    public NetClientHandler func_20001_q() {
        return this.field_6322_g instanceof EntityClientPlayerMP ? ((EntityClientPlayerMP)this.field_6322_g).field_797_bg : null;
    }

    public static void main(String[] var0) {
        String var1 = null;
        String var2 = null;
        var1 = "Player" + System.currentTimeMillis() % 1000L;
        if (var0.length > 0) {
            var1 = var0[0];
        }

        var2 = "-";
        if (var0.length > 1) {
            var2 = var0[1];
        }

        func_6269_a(var1, var2);
    }

    public static boolean func_22006_t() {
        return field_21900_a == null || !field_21900_a.field_6304_y.field_22277_y;
    }

    public static boolean func_22001_u() {
        return field_21900_a != null && field_21900_a.field_6304_y.field_1576_i;
    }

    public static boolean func_22005_v() {
        return field_21900_a != null && field_21900_a.field_6304_y.field_22278_j;
    }

    public static boolean func_22007_w() {
        return field_21900_a != null && field_21900_a.field_6304_y.field_22276_A;
    }

    public boolean func_22003_b(String var1) {
        if (var1.startsWith("/")) {
        }

        return false;
    }
}
