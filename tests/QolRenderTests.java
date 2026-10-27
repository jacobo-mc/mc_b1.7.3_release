package net.minecraft.src;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/** Optional integration checks: requires DISPLAY and matching LWJGL 2 natives. */
public final class QolRenderTests {
    private static void check(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }

    private static final class EmptyWorld extends World {
        EmptyWorld() { super(null, "camera-test", new WorldProviderSurface(), 123L); }
        protected IChunkProvider getChunkProvider() { return null; }
        public MovingObjectPosition rayTraceBlocks(Vec3D start, Vec3D end) { return null; }
    }

    public static void main(String[] args) throws Exception {
        Display.setDisplayMode(new DisplayMode(854, 480));
        Display.create();
        File directory = Files.createTempDirectory("beta-qol-render").toFile();
        try {
            GL11.glViewport(0, 0, 854, 480);
            GL11.glMatrixMode(GL11.GL_PROJECTION); GL11.glLoadIdentity();
            GL11.glOrtho(0, 427, 240, 0, -1000, 1000);
            GL11.glMatrixMode(GL11.GL_MODELVIEW); GL11.glLoadIdentity();
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            int[] colors = {0xff0000, 0x00ff00, 0x0000ff, 0xffffff};
            for (int i = 0; i < colors.length; i++) {
                tessellator.setColorOpaque_I(colors[i]);
                int x = i * 100;
                tessellator.addVertex(x, 0, 0); tessellator.addVertex(x, 100, 0);
                tessellator.addVertex(x + 100, 100, 0); tessellator.addVertex(x + 100, 0, 0);
            }
            tessellator.draw();
            ByteBuffer pixel = GLAllocation.createDirectByteBuffer(4);
            for (int i = 0; i < colors.length; i++) {
                GL11.glReadPixels(i * 200 + 100, 400, 1, 1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixel);
                int actual = (pixel.get(0) & 255) << 16 | (pixel.get(1) & 255) << 8 | pixel.get(2) & 255;
                check(actual == colors[i], "Rendered RGB mismatch: " + Integer.toHexString(actual));
            }
            Minecraft mc = new Minecraft(null, null, null, 854, 480, false) {
                public OpenGlCapsChecker getOpenGlCapsChecker() {
                    return new OpenGlCapsChecker() { public boolean checkARBOcclusion() { return false; } };
                }
                public void displayUnexpectedThrowable(UnexpectedThrowable failure) { throw new AssertionError("Client crash"); }
            };
            mc.gameSettings = new GameSettings(mc, directory);
            mc.texturePackList = new TexturePackList(mc, directory);
            mc.renderEngine = new RenderEngine(mc.texturePackList, mc.gameSettings);
            mc.fontRenderer = new FontRenderer(mc.gameSettings, "/font/default.png", mc.renderEngine);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GuiControls controls = new GuiControls(null, mc.gameSettings);
            controls.setWorldAndResolution(mc, 427, 240);
            controls.drawScreen(0, 0, 0);
            new File("build/render-check").mkdirs();
            ScreenShotHelper.saveScreenshot(new File("build/render-check"), 854, 480);
            GuiOptions options = new GuiOptions(null, mc.gameSettings);
            options.setWorldAndResolution(mc, 427, 240);
            options.drawScreen(0, 0, 0);
            boolean fov = false;
            for (Object object : options.controlList) {
                GuiButton button = (GuiButton)object;
                if (button.id == EnumOptions.FOV.ordinal()) fov = button instanceof GuiSlider;
            }
            check(fov, "FOV slider exists in Options");
            EntityLiving player = new EntityLiving(null) {
                public boolean isInsideOfMaterial(Material material) { return false; }
            };
            mc.renderViewEntity = player;
            EntityRenderer renderer = new EntityRenderer(mc);
            Method fovMethod = EntityRenderer.class.getDeclaredMethod("getFOVModifier", float.class);
            fovMethod.setAccessible(true);
            mc.gameSettings.fov = 90;
            mc.inGameHasFocus = true;
            mc.gameSettings.keyBindZoom = new KeyBinding("Test held zoom", 46) { public boolean isDown() { return true; } };
            check((Float)fovMethod.invoke(renderer, 0F) == 22.5F, "Held zoom divides current FOV");
            mc.currentScreen = controls;
            check((Float)fovMethod.invoke(renderer, 0F) == 90F, "Opening menu restores FOV");
            mc.currentScreen = null; mc.inGameHasFocus = false;
            check((Float)fovMethod.invoke(renderer, 0F) == 90F, "Losing focus restores FOV");
            mc.theWorld = new EmptyWorld();
            mc.renderGlobal = new RenderGlobal(mc, mc.renderEngine);
            player.yOffset = 1.62F; player.posX = player.prevPosX = player.posY = player.prevPosY = player.posZ = player.prevPosZ = 0;
            Method orient = EntityRenderer.class.getDeclaredMethod("orientCamera", float.class);
            orient.setAccessible(true);
            for (int perspective = 1; perspective <= 2; perspective++) {
                mc.gameSettings.thirdPersonView = perspective;
                for (float yaw : new float[]{0, 45, 180}) for (float pitch : new float[]{-30, 0, 30}) {
                    player.rotationYaw = player.prevRotationYaw = yaw;
                    player.rotationPitch = player.prevRotationPitch = pitch;
                    GL11.glMatrixMode(GL11.GL_MODELVIEW); GL11.glLoadIdentity();
                    orient.invoke(renderer, 0F);
                    FloatBuffer matrix = GLAllocation.createDirectFloatBuffer(16);
                    GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
                    double y = Math.toRadians(yaw), p = Math.toRadians(pitch);
                    double x = -Math.sin(y) * Math.cos(p), v = -Math.sin(p), z = Math.cos(y) * Math.cos(p);
                    double cameraX = matrix.get(0) * x + matrix.get(4) * v + matrix.get(8) * z;
                    double cameraY = matrix.get(1) * x + matrix.get(5) * v + matrix.get(9) * z;
                    double cameraZ = matrix.get(2) * x + matrix.get(6) * v + matrix.get(10) * z;
                    check(Math.abs(cameraX) < .002 && Math.abs(cameraY) < .002, "Camera faces along player axis");
                    check(Math.abs(cameraZ - (perspective == 2 ? 1 : -1)) < .002, "Front/rear look direction");
                    check(Math.abs(matrix.get(14) + 4) < .002, "Camera remains four blocks from player");
                }
            }
            checkHandProjection(mc, renderer, fovMethod);
            checkCrosshair(mc);
            checkFullbright(mc, renderer);
            check(GL11.glGetError() == GL11.GL_NO_ERROR, "OpenGL error during render integration tests");
            mc.running = false;
            System.out.println("PASS: rendered RGBA, Controls, FOV slider, zoom focus, 18 front/rear orientations, fixed hand pixels, perspective crosshair visibility, fullbright render/restore");
        } finally {
            Display.destroy();
        }
    }
    private static void checkHandProjection(Minecraft mc, EntityRenderer renderer, Method worldFov) throws Exception {
        java.lang.reflect.Field farPlane = EntityRenderer.class.getDeclaredField("farPlaneDistance");
        farPlane.setAccessible(true); farPlane.setFloat(renderer, 256F);
        Method hand = EntityRenderer.class.getDeclaredMethod("renderHand", float.class, int.class);
        hand.setAccessible(true);
        renderer.itemRenderer = new ItemRenderer(mc) {
            public void renderItemInFirstPerson(float partialTick) {
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                GL11.glDisable(GL11.GL_CULL_FACE);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor3f(1, 0, 0);
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex3f(.15F, -.2F, -1); GL11.glVertex3f(.45F, -.2F, -1);
                GL11.glVertex3f(.45F, -.5F, -1); GL11.glVertex3f(.15F, -.5F, -1);
                GL11.glEnd();
            }
            public void renderOverlays(float partialTick) {}
        };
        mc.gameSettings.thirdPersonView = 0;
        mc.gameSettings.viewBobbing = false;
        mc.gameSettings.hideGUI = false;
        int[] originalBounds = null;
        for (boolean zoom : new boolean[]{false, true}) for (float fov : new float[]{30, 70, 110}) {
            mc.inGameHasFocus = zoom;
            mc.gameSettings.fov = fov;
            GL11.glMatrixMode(GL11.GL_PROJECTION); GL11.glLoadIdentity();
            org.lwjgl.util.glu.GLU.gluPerspective((Float)worldFov.invoke(renderer, 0F), 854F / 480, .05F, 512);
            GL11.glMatrixMode(GL11.GL_MODELVIEW); GL11.glLoadIdentity();
            GL11.glClearColor(0, 0, 0, 0); GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            hand.invoke(renderer, 0F, 0);
            FloatBuffer projection = GLAllocation.createDirectFloatBuffer(16);
            GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projection);
            check(Math.abs(projection.get(5) - 1 / Math.tan(Math.toRadians(35))) < .0001, "Hand uses fixed 70 degree FOV");
            ByteBuffer pixels = GLAllocation.createDirectByteBuffer(854 * 480 * 4);
            GL11.glReadPixels(0, 0, 854, 480, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixels);
            int[] bounds = {854, 480, -1, -1};
            for (int y = 0; y < 480; y++) for (int x = 0; x < 854; x++) {
                int pixel = (y * 854 + x) * 4;
                if ((pixels.get(pixel) & 255) > 240 && (pixels.get(pixel + 1) & 255) < 5 && (pixels.get(pixel + 2) & 255) < 5) {
                    bounds[0] = Math.min(bounds[0], x); bounds[1] = Math.min(bounds[1], y);
                    bounds[2] = Math.max(bounds[2], x); bounds[3] = Math.max(bounds[3], y);
                }
            }
            check(bounds[2] > bounds[0] && bounds[3] > bounds[1], "Hand geometry rendered");
            if (originalBounds == null) originalBounds = bounds;
            else check(java.util.Arrays.equals(originalBounds, bounds), "Hand pixel bounds unchanged at FOV " + fov + ", zoom=" + zoom);
        }
    }

    private static void checkCrosshair(Minecraft mc) {
        GL11.glViewport(0, 0, 854, 480);
        GL11.glMatrixMode(GL11.GL_PROJECTION); GL11.glLoadIdentity();
        GL11.glOrtho(0, 427, 240, 0, -1000, 1000);
        GL11.glMatrixMode(GL11.GL_MODELVIEW); GL11.glLoadIdentity();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/gui/icons.png"));
        GL11.glColor4f(1, 1, 1, 1);
        GuiIngame hud = new GuiIngame(mc);
        ByteBuffer pixels = GLAllocation.createDirectByteBuffer(40 * 40 * 4);
        for (int perspective = 0; perspective < 3; perspective++) {
            mc.gameSettings.thirdPersonView = perspective;
            GL11.glClearColor(.25F, .25F, .25F, 1); GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            hud.renderCrosshair(427, 240);
            GL11.glReadPixels(407, 220, 40, 40, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixels);
            boolean changed = false;
            for (int i = 0; i < 40 * 40 * 4; i += 4) {
                if ((pixels.get(i) & 255) != 64 || (pixels.get(i + 1) & 255) != 64 || (pixels.get(i + 2) & 255) != 64) changed = true;
            }
            check(changed == (perspective == 0), "Crosshair pixels visible only in first person, perspective=" + perspective);
        }
    }

    private static void checkFullbright(Minecraft mc, EntityRenderer renderer) {
        mc.entityRenderer = renderer;
        float[] original = mc.theWorld.worldProvider.lightBrightnessTable.clone();
        int rawLight = mc.theWorld.getBlockLightValue(0, -1, 0);
        float normal = mc.theWorld.getLightBrightness(0, -1, 0);
        check(normal < 1, "Dark block starts below full brightness");
        mc.gameSettings.setOptionValue(EnumOptions.FULLBRIGHT, 1);
        check(mc.theWorld.getLightBrightness(0, -1, 0) == 1, "Fullbright reaches the world brightness accessor");
        check(mc.theWorld.getBlockLightValue(0, -1, 0) == rawLight, "Fullbright does not alter gameplay light levels");
        renderBrightness(mc.theWorld.getLightBrightness(0, -1, 0), 255);
        mc.gameSettings.setOptionValue(EnumOptions.FULLBRIGHT, 1);
        check(java.util.Arrays.equals(original, mc.theWorld.worldProvider.lightBrightnessTable), "Toggle restores original world lighting");
        renderBrightness(mc.theWorld.getLightBrightness(0, -1, 0), (int)(normal * 255));
        GuiVideoSettings video = new GuiVideoSettings(null, mc.gameSettings);
        video.setWorldAndResolution(mc, 427, 240);
        boolean found = false;
        for (Object entry : video.controlList) if (((GuiButton)entry).id == EnumOptions.FULLBRIGHT.ordinal()) found = true;
        check(found, "Fullbright toggle appears in Video Settings");
    }

    private static void renderBrightness(float brightness, int expected) {
        GL11.glDisable(GL11.GL_TEXTURE_2D); GL11.glDisable(GL11.GL_BLEND);
        GL11.glMatrixMode(GL11.GL_PROJECTION); GL11.glLoadIdentity();
        GL11.glOrtho(0, 1, 0, 1, -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW); GL11.glLoadIdentity();
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads(); tessellator.setColorOpaque_F(brightness, brightness, brightness);
        tessellator.addVertex(0, 0, 0); tessellator.addVertex(1, 0, 0);
        tessellator.addVertex(1, 1, 0); tessellator.addVertex(0, 1, 0); tessellator.draw();
        ByteBuffer pixel = GLAllocation.createDirectByteBuffer(4);
        GL11.glReadPixels(400, 200, 1, 1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixel);
        for (int i = 0; i < 3; i++) check((pixel.get(i) & 255) == expected, "Rendered world brightness " + expected);
    }

}
