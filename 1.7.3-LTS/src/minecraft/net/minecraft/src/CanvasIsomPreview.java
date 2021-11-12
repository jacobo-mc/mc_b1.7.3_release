package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CanvasIsomPreview extends Canvas implements KeyListener, MouseListener, MouseMotionListener, Runnable {
    private int field_1793_a = 0;
    private int zoomLevel = 2;
    private boolean displayHelpText = true;
    private World worldObj;
    private File dataFolder = this.getMinecraftDir();
    private boolean running = true;
    private List imageBufferList = Collections.synchronizedList(new LinkedList());
    private IsoImageBuffer[][] imageBuffers = new IsoImageBuffer[64][64];
    private int field_1785_i;
    private int field_1784_j;
    private int xPosition;
    private int yPosition;

    public File getMinecraftDir() {
        if (this.dataFolder == null) {
            this.dataFolder = this.getAppDir("minecraft");
        }

        return this.dataFolder;
    }

    public File getAppDir(String var1) {
        String var2 = System.getProperty("user.home", ".");
        File var3;
        switch(OsMap.field_1193_a[getOs().ordinal()]) {
        case 1:
        case 2:
            var3 = new File(var2, '.' + var1 + '/');
            break;
        case 3:
            String var4 = System.getenv("APPDATA");
            if (var4 != null) {
                var3 = new File(var4, "." + var1 + '/');
            } else {
                var3 = new File(var2, '.' + var1 + '/');
            }
            break;
        case 4:
            var3 = new File(var2, "Library/Application Support/" + var1);
            break;
        default:
            var3 = new File(var2, var1 + '/');
        }

        if (!var3.exists() && !var3.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + var3);
        } else {
            return var3;
        }
    }

    private static EnumOS1 getOs() {
        String var0 = System.getProperty("os.name").toLowerCase();
        if (var0.contains("win")) {
            return EnumOS1.windows;
        } else if (var0.contains("mac")) {
            return EnumOS1.macos;
        } else if (var0.contains("solaris")) {
            return EnumOS1.solaris;
        } else if (var0.contains("sunos")) {
            return EnumOS1.solaris;
        } else if (var0.contains("linux")) {
            return EnumOS1.linux;
        } else {
            return var0.contains("unix") ? EnumOS1.linux : EnumOS1.unknown;
        }
    }

    public CanvasIsomPreview() {
        for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
                this.imageBuffers[var1][var2] = new IsoImageBuffer((World)null, var1, var2);
            }
        }

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        this.setBackground(Color.red);
    }

    public void loadWorld(String var1) {
        this.field_1785_i = this.field_1784_j = 0;
        this.worldObj = new World(new SaveHandler(new File(this.dataFolder, "saves"), var1, false), var1, (new Random()).nextLong());
        this.worldObj.skylightSubtracted = 0;
        synchronized(this.imageBufferList) {
            this.imageBufferList.clear();

            for(int var3 = 0; var3 < 64; ++var3) {
                for(int var4 = 0; var4 < 64; ++var4) {
                    this.imageBuffers[var3][var4].setWorldAndChunkPosition(this.worldObj, var3, var4);
                }
            }

        }
    }

    private void setTimeOfDay(int var1) {
        synchronized(this.imageBufferList) {
            this.worldObj.skylightSubtracted = var1;
            this.imageBufferList.clear();

            for(int var3 = 0; var3 < 64; ++var3) {
                for(int var4 = 0; var4 < 64; ++var4) {
                    this.imageBuffers[var3][var4].setWorldAndChunkPosition(this.worldObj, var3, var4);
                }
            }

        }
    }

    public void startThreads() {
        (new ThreadRunIsoClient(this)).start();

        for(int var1 = 0; var1 < 8; ++var1) {
            (new Thread(this)).start();
        }

    }

    public void exit() {
        this.running = false;
    }

    private IsoImageBuffer getImageBuffer(int var1, int var2) {
        int var3 = var1 & 63;
        int var4 = var2 & 63;
        IsoImageBuffer var5 = this.imageBuffers[var3][var4];
        if (var5.chunkX == var1 && var5.chunkZ == var2) {
            return var5;
        } else {
            synchronized(this.imageBufferList) {
                this.imageBufferList.remove(var5);
            }

            var5.setChunkPosition(var1, var2);
            return var5;
        }
    }

    public void run() {
        TerrainTextureManager var1 = new TerrainTextureManager();

        while(this.running) {
            IsoImageBuffer var2 = null;
            synchronized(this.imageBufferList) {
                if (this.imageBufferList.size() > 0) {
                    var2 = (IsoImageBuffer)this.imageBufferList.remove(0);
                }
            }

            if (var2 != null) {
                if (this.field_1793_a - var2.field_1350_g < 2) {
                    var1.func_799_a(var2);
                    this.repaint();
                } else {
                    var2.field_1349_h = false;
                }
            }

            try {
                Thread.sleep(2L);
            } catch (InterruptedException var5) {
                var5.printStackTrace();
            }
        }

    }

    public void update(Graphics var1) {
    }

    public void paint(Graphics var1) {
    }

    public void showNextBuffer() {
        BufferStrategy var1 = this.getBufferStrategy();
        if (var1 == null) {
            this.createBufferStrategy(2);
        } else {
            this.drawScreen((Graphics2D)var1.getDrawGraphics());
            var1.show();
        }
    }

    public void drawScreen(Graphics2D var1) {
        ++this.field_1793_a;
        AffineTransform var2 = var1.getTransform();
        var1.setClip(0, 0, this.getWidth(), this.getHeight());
        var1.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        var1.translate(this.getWidth() / 2, this.getHeight() / 2);
        var1.scale((double)this.zoomLevel, (double)this.zoomLevel);
        var1.translate(this.field_1785_i, this.field_1784_j);
        if (this.worldObj != null) {
            ChunkCoordinates var3 = this.worldObj.getSpawnPoint();
            var1.translate(-(var3.x + var3.z), -(-var3.x + var3.z) + 64);
        }

        Rectangle var17 = var1.getClipBounds();
        var1.setColor(new Color(-15724512));
        var1.fillRect(var17.x, var17.y, var17.width, var17.height);
        byte var4 = 16;
        byte var5 = 3;
        int var6 = var17.x / var4 / 2 - 2 - var5;
        int var7 = (var17.x + var17.width) / var4 / 2 + 1 + var5;
        int var8 = var17.y / var4 - 1 - var5 * 2;
        int var9 = (var17.y + var17.height + 16 + 128) / var4 + 1 + var5 * 2;

        int var10;
        for(var10 = var8; var10 <= var9; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
                int var12 = var11 - (var10 >> 1);
                int var13 = var11 + (var10 + 1 >> 1);
                IsoImageBuffer var14 = this.getImageBuffer(var12, var13);
                var14.field_1350_g = this.field_1793_a;
                if (!var14.field_1352_e) {
                    if (!var14.field_1349_h) {
                        var14.field_1349_h = true;
                        this.imageBufferList.add(var14);
                    }
                } else {
                    var14.field_1349_h = false;
                    if (!var14.field_1351_f) {
                        int var15 = var11 * var4 * 2 + (var10 & 1) * var4;
                        int var16 = var10 * var4 - 128 - 16;
                        var1.drawImage(var14.field_1348_a, var15, var16, (ImageObserver)null);
                    }
                }
            }
        }

        if (this.displayHelpText) {
            var1.setTransform(var2);
            var10 = this.getHeight() - 32 - 4;
            var1.setColor(new Color(Integer.MIN_VALUE, true));
            var1.fillRect(4, this.getHeight() - 32 - 4, this.getWidth() - 8, 32);
            var1.setColor(Color.WHITE);
            String var18 = "F1 - F5: load levels   |   0-9: Set time of day   |   Space: return to spawn   |   Double click: zoom   |   Escape: hide this text";
            var1.drawString(var18, this.getWidth() / 2 - var1.getFontMetrics().stringWidth(var18) / 2, var10 + 20);
        }

        var1.dispose();
    }

    public void mouseDragged(MouseEvent var1) {
        int var2 = var1.getX() / this.zoomLevel;
        int var3 = var1.getY() / this.zoomLevel;
        this.field_1785_i += var2 - this.xPosition;
        this.field_1784_j += var3 - this.yPosition;
        this.xPosition = var2;
        this.yPosition = var3;
        this.repaint();
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
        if (var1.getClickCount() == 2) {
            this.zoomLevel = 3 - this.zoomLevel;
            this.repaint();
        }

    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        int var2 = var1.getX() / this.zoomLevel;
        int var3 = var1.getY() / this.zoomLevel;
        this.xPosition = var2;
        this.yPosition = var3;
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void keyPressed(KeyEvent var1) {
        if (var1.getKeyCode() == 48) {
            this.setTimeOfDay(11);
        }

        if (var1.getKeyCode() == 49) {
            this.setTimeOfDay(10);
        }

        if (var1.getKeyCode() == 50) {
            this.setTimeOfDay(9);
        }

        if (var1.getKeyCode() == 51) {
            this.setTimeOfDay(7);
        }

        if (var1.getKeyCode() == 52) {
            this.setTimeOfDay(6);
        }

        if (var1.getKeyCode() == 53) {
            this.setTimeOfDay(5);
        }

        if (var1.getKeyCode() == 54) {
            this.setTimeOfDay(3);
        }

        if (var1.getKeyCode() == 55) {
            this.setTimeOfDay(2);
        }

        if (var1.getKeyCode() == 56) {
            this.setTimeOfDay(1);
        }

        if (var1.getKeyCode() == 57) {
            this.setTimeOfDay(0);
        }

        if (var1.getKeyCode() == 112) {
            this.loadWorld("World1");
        }

        if (var1.getKeyCode() == 113) {
            this.loadWorld("World2");
        }

        if (var1.getKeyCode() == 114) {
            this.loadWorld("World3");
        }

        if (var1.getKeyCode() == 115) {
            this.loadWorld("World4");
        }

        if (var1.getKeyCode() == 116) {
            this.loadWorld("World5");
        }

        if (var1.getKeyCode() == 32) {
            this.field_1785_i = this.field_1784_j = 0;
        }

        if (var1.getKeyCode() == 27) {
            this.displayHelpText = !this.displayHelpText;
        }

        this.repaint();
    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    // $FF: synthetic method
    static boolean isRunning(CanvasIsomPreview var0) {
        return var0.running;
    }
}
