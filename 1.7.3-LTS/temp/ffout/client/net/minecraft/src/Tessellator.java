package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Tessellator {
    private static boolean field_1511_b = true;
    private static boolean field_1510_c = false;
    private ByteBuffer field_1509_d;
    private IntBuffer field_1508_e;
    private FloatBuffer field_1507_f;
    private int[] field_1506_g;
    private int field_1505_h = 0;
    private double field_1504_i;
    private double field_1503_j;
    private int field_1502_k;
    private boolean field_1501_l = false;
    private boolean field_1500_m = false;
    private boolean field_1499_n = false;
    private int field_1498_o = 0;
    private int field_1497_p = 0;
    private boolean field_1495_q = false;
    private int field_1493_r;
    private double field_1492_s;
    private double field_1491_t;
    private double field_1490_u;
    private int field_1489_v;
    public static final Tessellator field_1512_a = new Tessellator(2097152);
    private boolean field_1488_w = false;
    private boolean field_1487_x = false;
    private IntBuffer field_1486_y;
    private int field_1485_z = 0;
    private int field_1496_A = 10;
    private int field_1494_B;

    private Tessellator(int var1) {
        this.field_1494_B = var1;
        this.field_1509_d = GLAllocation.func_1127_b(var1 * 4);
        this.field_1508_e = this.field_1509_d.asIntBuffer();
        this.field_1507_f = this.field_1509_d.asFloatBuffer();
        this.field_1506_g = new int[var1];
        this.field_1487_x = field_1510_c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if (this.field_1487_x) {
            this.field_1486_y = GLAllocation.func_1125_c(this.field_1496_A);
            ARBVertexBufferObject.glGenBuffersARB(this.field_1486_y);
        }

    }

    public void func_982_a() {
        if (!this.field_1488_w) {
            throw new IllegalStateException("Not tesselating!");
        } else {
            this.field_1488_w = false;
            if (this.field_1505_h > 0) {
                this.field_1508_e.clear();
                this.field_1508_e.put(this.field_1506_g, 0, this.field_1498_o);
                this.field_1509_d.position(0);
                this.field_1509_d.limit(this.field_1498_o * 4);
                if (this.field_1487_x) {
                    this.field_1485_z = (this.field_1485_z + 1) % this.field_1496_A;
                    ARBVertexBufferObject.glBindBufferARB(34962, this.field_1486_y.get(this.field_1485_z));
                    ARBVertexBufferObject.glBufferDataARB(34962, this.field_1509_d, 35040);
                }

                if (this.field_1500_m) {
                    if (this.field_1487_x) {
                        GL11.glTexCoordPointer(2, 5126, 32, 12L);
                    } else {
                        this.field_1507_f.position(3);
                        GL11.glTexCoordPointer(2, 32, this.field_1507_f);
                    }

                    GL11.glEnableClientState(32888);
                }

                if (this.field_1501_l) {
                    if (this.field_1487_x) {
                        GL11.glColorPointer(4, 5121, 32, 20L);
                    } else {
                        this.field_1509_d.position(20);
                        GL11.glColorPointer(4, true, 32, this.field_1509_d);
                    }

                    GL11.glEnableClientState(32886);
                }

                if (this.field_1499_n) {
                    if (this.field_1487_x) {
                        GL11.glNormalPointer(5120, 32, 24L);
                    } else {
                        this.field_1509_d.position(24);
                        GL11.glNormalPointer(32, this.field_1509_d);
                    }

                    GL11.glEnableClientState(32885);
                }

                if (this.field_1487_x) {
                    GL11.glVertexPointer(3, 5126, 32, 0L);
                } else {
                    this.field_1507_f.position(0);
                    GL11.glVertexPointer(3, 32, this.field_1507_f);
                }

                GL11.glEnableClientState(32884);
                if (this.field_1493_r == 7 && field_1511_b) {
                    GL11.glDrawArrays(4, 0, this.field_1505_h);
                } else {
                    GL11.glDrawArrays(this.field_1493_r, 0, this.field_1505_h);
                }

                GL11.glDisableClientState(32884);
                if (this.field_1500_m) {
                    GL11.glDisableClientState(32888);
                }

                if (this.field_1501_l) {
                    GL11.glDisableClientState(32886);
                }

                if (this.field_1499_n) {
                    GL11.glDisableClientState(32885);
                }
            }

            this.func_985_d();
        }
    }

    private void func_985_d() {
        this.field_1505_h = 0;
        this.field_1509_d.clear();
        this.field_1498_o = 0;
        this.field_1497_p = 0;
    }

    public void func_977_b() {
        this.func_992_a(7);
    }

    public void func_992_a(int var1) {
        if (this.field_1488_w) {
            throw new IllegalStateException("Already tesselating!");
        } else {
            this.field_1488_w = true;
            this.func_985_d();
            this.field_1493_r = var1;
            this.field_1499_n = false;
            this.field_1501_l = false;
            this.field_1500_m = false;
            this.field_1495_q = false;
        }
    }

    public void func_981_a(double var1, double var3) {
        this.field_1500_m = true;
        this.field_1504_i = var1;
        this.field_1503_j = var3;
    }

    public void func_987_a(float var1, float var2, float var3) {
        this.func_979_a((int)(var1 * 255.0F), (int)(var2 * 255.0F), (int)(var3 * 255.0F));
    }

    public void func_986_a(float var1, float var2, float var3, float var4) {
        this.func_978_a((int)(var1 * 255.0F), (int)(var2 * 255.0F), (int)(var3 * 255.0F), (int)(var4 * 255.0F));
    }

    public void func_979_a(int var1, int var2, int var3) {
        this.func_978_a(var1, var2, var3, 255);
    }

    public void func_978_a(int var1, int var2, int var3, int var4) {
        if (!this.field_1495_q) {
            if (var1 > 255) {
                var1 = 255;
            }

            if (var2 > 255) {
                var2 = 255;
            }

            if (var3 > 255) {
                var3 = 255;
            }

            if (var4 > 255) {
                var4 = 255;
            }

            if (var1 < 0) {
                var1 = 0;
            }

            if (var2 < 0) {
                var2 = 0;
            }

            if (var3 < 0) {
                var3 = 0;
            }

            if (var4 < 0) {
                var4 = 0;
            }

            this.field_1501_l = true;
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                this.field_1502_k = var4 << 24 | var3 << 16 | var2 << 8 | var1;
            } else {
                this.field_1502_k = var1 << 24 | var2 << 16 | var3 << 8 | var4;
            }

        }
    }

    public void func_983_a(double var1, double var3, double var5, double var7, double var9) {
        this.func_981_a(var7, var9);
        this.func_991_a(var1, var3, var5);
    }

    public void func_991_a(double var1, double var3, double var5) {
        ++this.field_1497_p;
        if (this.field_1493_r == 7 && field_1511_b && this.field_1497_p % 4 == 0) {
            for(int var7 = 0; var7 < 2; ++var7) {
                int var8 = 8 * (3 - var7);
                if (this.field_1500_m) {
                    this.field_1506_g[this.field_1498_o + 3] = this.field_1506_g[this.field_1498_o - var8 + 3];
                    this.field_1506_g[this.field_1498_o + 4] = this.field_1506_g[this.field_1498_o - var8 + 4];
                }

                if (this.field_1501_l) {
                    this.field_1506_g[this.field_1498_o + 5] = this.field_1506_g[this.field_1498_o - var8 + 5];
                }

                this.field_1506_g[this.field_1498_o + 0] = this.field_1506_g[this.field_1498_o - var8 + 0];
                this.field_1506_g[this.field_1498_o + 1] = this.field_1506_g[this.field_1498_o - var8 + 1];
                this.field_1506_g[this.field_1498_o + 2] = this.field_1506_g[this.field_1498_o - var8 + 2];
                ++this.field_1505_h;
                this.field_1498_o += 8;
            }
        }

        if (this.field_1500_m) {
            this.field_1506_g[this.field_1498_o + 3] = Float.floatToRawIntBits((float)this.field_1504_i);
            this.field_1506_g[this.field_1498_o + 4] = Float.floatToRawIntBits((float)this.field_1503_j);
        }

        if (this.field_1501_l) {
            this.field_1506_g[this.field_1498_o + 5] = this.field_1502_k;
        }

        if (this.field_1499_n) {
            this.field_1506_g[this.field_1498_o + 6] = this.field_1489_v;
        }

        this.field_1506_g[this.field_1498_o + 0] = Float.floatToRawIntBits((float)(var1 + this.field_1492_s));
        this.field_1506_g[this.field_1498_o + 1] = Float.floatToRawIntBits((float)(var3 + this.field_1491_t));
        this.field_1506_g[this.field_1498_o + 2] = Float.floatToRawIntBits((float)(var5 + this.field_1490_u));
        this.field_1498_o += 8;
        ++this.field_1505_h;
        if (this.field_1505_h % 4 == 0 && this.field_1498_o >= this.field_1494_B - 32) {
            this.func_982_a();
            this.field_1488_w = true;
        }

    }

    public void func_990_b(int var1) {
        int var2 = var1 >> 16 & 255;
        int var3 = var1 >> 8 & 255;
        int var4 = var1 & 255;
        this.func_979_a(var2, var3, var4);
    }

    public void func_6513_a(int var1, int var2) {
        int var3 = var1 >> 16 & 255;
        int var4 = var1 >> 8 & 255;
        int var5 = var1 & 255;
        this.func_978_a(var3, var4, var5, var2);
    }

    public void func_989_c() {
        this.field_1495_q = true;
    }

    public void func_980_b(float var1, float var2, float var3) {
        if (!this.field_1488_w) {
            System.out.println("But..");
        }

        this.field_1499_n = true;
        byte var4 = (byte)((int)(var1 * 128.0F));
        byte var5 = (byte)((int)(var2 * 127.0F));
        byte var6 = (byte)((int)(var3 * 127.0F));
        this.field_1489_v = var4 | var5 << 8 | var6 << 16;
    }

    public void func_984_b(double var1, double var3, double var5) {
        this.field_1492_s = var1;
        this.field_1491_t = var3;
        this.field_1490_u = var5;
    }

    public void func_988_c(float var1, float var2, float var3) {
        this.field_1492_s += (double)var1;
        this.field_1491_t += (double)var2;
        this.field_1490_u += (double)var3;
    }
}
