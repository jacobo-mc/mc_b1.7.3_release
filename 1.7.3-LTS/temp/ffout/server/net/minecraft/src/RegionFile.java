package net.minecraft.src;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class RegionFile {
    private static final byte[] field_22143_a = new byte[4096];
    private final File field_22142_b;
    private RandomAccessFile field_22149_c;
    private final int[] field_22148_d = new int[1024];
    private final int[] field_22147_e = new int[1024];
    private ArrayList field_22146_f;
    private int field_22145_g;
    private long field_22144_h = 0L;

    public RegionFile(File var1) {
        this.field_22142_b = var1;
        this.func_22134_b("REGION LOAD " + this.field_22142_b);
        this.field_22145_g = 0;

        try {
            if (var1.exists()) {
                this.field_22144_h = var1.lastModified();
            }

            this.field_22149_c = new RandomAccessFile(var1, "rw");
            int var2;
            if (this.field_22149_c.length() < 4096L) {
                for(var2 = 0; var2 < 1024; ++var2) {
                    this.field_22149_c.writeInt(0);
                }

                for(var2 = 0; var2 < 1024; ++var2) {
                    this.field_22149_c.writeInt(0);
                }

                this.field_22145_g += 8192;
            }

            if ((this.field_22149_c.length() & 4095L) != 0L) {
                for(var2 = 0; (long)var2 < (this.field_22149_c.length() & 4095L); ++var2) {
                    this.field_22149_c.write(0);
                }
            }

            var2 = (int)this.field_22149_c.length() / 4096;
            this.field_22146_f = new ArrayList(var2);

            int var3;
            for(var3 = 0; var3 < var2; ++var3) {
                this.field_22146_f.add(true);
            }

            this.field_22146_f.set(0, false);
            this.field_22146_f.set(1, false);
            this.field_22149_c.seek(0L);

            int var4;
            for(var3 = 0; var3 < 1024; ++var3) {
                var4 = this.field_22149_c.readInt();
                this.field_22148_d[var3] = var4;
                if (var4 != 0 && (var4 >> 8) + (var4 & 255) <= this.field_22146_f.size()) {
                    for(int var5 = 0; var5 < (var4 & 255); ++var5) {
                        this.field_22146_f.set((var4 >> 8) + var5, false);
                    }
                }
            }

            for(var3 = 0; var3 < 1024; ++var3) {
                var4 = this.field_22149_c.readInt();
                this.field_22147_e[var3] = var4;
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public synchronized int func_22139_a() {
        int var1 = this.field_22145_g;
        this.field_22145_g = 0;
        return var1;
    }

    private void func_22141_a(String var1) {
    }

    private void func_22134_b(String var1) {
        this.func_22141_a(var1 + "\n");
    }

    private void func_22129_a(String var1, int var2, int var3, String var4) {
        this.func_22141_a("REGION " + var1 + " " + this.field_22142_b.getName() + "[" + var2 + "," + var3 + "] = " + var4);
    }

    private void func_22127_a(String var1, int var2, int var3, int var4, String var5) {
        this.func_22141_a("REGION " + var1 + " " + this.field_22142_b.getName() + "[" + var2 + "," + var3 + "] " + var4 + "B = " + var5);
    }

    private void func_22131_b(String var1, int var2, int var3, String var4) {
        this.func_22129_a(var1, var2, var3, var4 + "\n");
    }

    public synchronized DataInputStream func_22140_a(int var1, int var2) {
        if (this.func_22136_d(var1, var2)) {
            this.func_22131_b("READ", var1, var2, "out of bounds");
            return null;
        } else {
            try {
                int var3 = this.func_22137_e(var1, var2);
                if (var3 == 0) {
                    return null;
                } else {
                    int var4 = var3 >> 8;
                    int var5 = var3 & 255;
                    if (var4 + var5 > this.field_22146_f.size()) {
                        this.func_22131_b("READ", var1, var2, "invalid sector");
                        return null;
                    } else {
                        this.field_22149_c.seek((long)(var4 * 4096));
                        int var6 = this.field_22149_c.readInt();
                        if (var6 > 4096 * var5) {
                            this.func_22131_b("READ", var1, var2, "invalid length: " + var6 + " > 4096 * " + var5);
                            return null;
                        } else {
                            byte var7 = this.field_22149_c.readByte();
                            byte[] var8;
                            DataInputStream var9;
                            if (var7 == 1) {
                                var8 = new byte[var6 - 1];
                                this.field_22149_c.read(var8);
                                var9 = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(var8)));
                                return var9;
                            } else if (var7 == 2) {
                                var8 = new byte[var6 - 1];
                                this.field_22149_c.read(var8);
                                var9 = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(var8)));
                                return var9;
                            } else {
                                this.func_22131_b("READ", var1, var2, "unknown version " + var7);
                                return null;
                            }
                        }
                    }
                }
            } catch (IOException var10) {
                this.func_22131_b("READ", var1, var2, "exception");
                return null;
            }
        }
    }

    public DataOutputStream func_22135_b(int var1, int var2) {
        return this.func_22136_d(var1, var2) ? null : new DataOutputStream(new DeflaterOutputStream(new RegionFileChunkBuffer(this, var1, var2)));
    }

    protected synchronized void func_22133_a(int var1, int var2, byte[] var3, int var4) {
        try {
            int var5 = this.func_22137_e(var1, var2);
            int var6 = var5 >> 8;
            int var7 = var5 & 255;
            int var8 = (var4 + 5) / 4096 + 1;
            if (var8 >= 256) {
                return;
            }

            if (var6 != 0 && var7 == var8) {
                this.func_22127_a("SAVE", var1, var2, var4, "rewrite");
                this.func_22130_a(var6, var3, var4);
            } else {
                int var9;
                for(var9 = 0; var9 < var7; ++var9) {
                    this.field_22146_f.set(var6 + var9, true);
                }

                var9 = this.field_22146_f.indexOf(true);
                int var10 = 0;
                int var11;
                if (var9 != -1) {
                    for(var11 = var9; var11 < this.field_22146_f.size(); ++var11) {
                        if (var10 != 0) {
                            if ((Boolean)this.field_22146_f.get(var11)) {
                                ++var10;
                            } else {
                                var10 = 0;
                            }
                        } else if ((Boolean)this.field_22146_f.get(var11)) {
                            var9 = var11;
                            var10 = 1;
                        }

                        if (var10 >= var8) {
                            break;
                        }
                    }
                }

                if (var10 >= var8) {
                    this.func_22127_a("SAVE", var1, var2, var4, "reuse");
                    var6 = var9;
                    this.func_22128_a(var1, var2, var9 << 8 | var8);

                    for(var11 = 0; var11 < var8; ++var11) {
                        this.field_22146_f.set(var6 + var11, false);
                    }

                    this.func_22130_a(var6, var3, var4);
                } else {
                    this.func_22127_a("SAVE", var1, var2, var4, "grow");
                    this.field_22149_c.seek(this.field_22149_c.length());
                    var6 = this.field_22146_f.size();

                    for(var11 = 0; var11 < var8; ++var11) {
                        this.field_22149_c.write(field_22143_a);
                        this.field_22146_f.add(false);
                    }

                    this.field_22145_g += 4096 * var8;
                    this.func_22130_a(var6, var3, var4);
                    this.func_22128_a(var1, var2, var6 << 8 | var8);
                }
            }

            this.func_22138_b(var1, var2, (int)(System.currentTimeMillis() / 1000L));
        } catch (IOException var12) {
            var12.printStackTrace();
        }

    }

    private void func_22130_a(int var1, byte[] var2, int var3) throws IOException {
        this.func_22134_b(" " + var1);
        this.field_22149_c.seek((long)(var1 * 4096));
        this.field_22149_c.writeInt(var3 + 1);
        this.field_22149_c.writeByte(2);
        this.field_22149_c.write(var2, 0, var3);
    }

    private boolean func_22136_d(int var1, int var2) {
        return var1 < 0 || var1 >= 32 || var2 < 0 || var2 >= 32;
    }

    private int func_22137_e(int var1, int var2) {
        return this.field_22148_d[var1 + var2 * 32];
    }

    public boolean func_22132_c(int var1, int var2) {
        return this.func_22137_e(var1, var2) != 0;
    }

    private void func_22128_a(int var1, int var2, int var3) throws IOException {
        this.field_22148_d[var1 + var2 * 32] = var3;
        this.field_22149_c.seek((long)((var1 + var2 * 32) * 4));
        this.field_22149_c.writeInt(var3);
    }

    private void func_22138_b(int var1, int var2, int var3) throws IOException {
        this.field_22147_e[var1 + var2 * 32] = var3;
        this.field_22149_c.seek((long)(4096 + (var1 + var2 * 32) * 4));
        this.field_22149_c.writeInt(var3);
    }

    public void func_22126_b() throws IOException {
        this.field_22149_c.close();
    }
}
