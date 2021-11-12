package net.minecraft.src;

import java.io.ByteArrayOutputStream;

class RegionFileChunkBuffer extends ByteArrayOutputStream {
    private int field_22156_b;
    private int field_22158_c;
    // $FF: synthetic field
    final RegionFile field_22157_a;

    public RegionFileChunkBuffer(RegionFile var1, int var2, int var3) {
        super(8096);
        this.field_22157_a = var1;
        this.field_22156_b = var2;
        this.field_22158_c = var3;
    }

    public void close() {
        this.field_22157_a.write(this.field_22156_b, this.field_22158_c, this.buf, this.count);
    }
}
