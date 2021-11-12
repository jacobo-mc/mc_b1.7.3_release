package net.minecraft.src;

import java.io.File;
import java.util.regex.Matcher;

class ChunkFile implements Comparable {
    private final File field_22326_a;
    private final int field_22325_b;
    private final int field_22327_c;

    public ChunkFile(File var1) {
        this.field_22326_a = var1;
        Matcher var2 = ChunkFilePattern.field_22189_a.matcher(var1.getName());
        if (var2.matches()) {
            this.field_22325_b = Integer.parseInt(var2.group(1), 36);
            this.field_22327_c = Integer.parseInt(var2.group(2), 36);
        } else {
            this.field_22325_b = 0;
            this.field_22327_c = 0;
        }

    }

    public int func_22322_a(ChunkFile var1) {
        int var2 = this.field_22325_b >> 5;
        int var3 = var1.field_22325_b >> 5;
        if (var2 == var3) {
            int var4 = this.field_22327_c >> 5;
            int var5 = var1.field_22327_c >> 5;
            return var4 - var5;
        } else {
            return var2 - var3;
        }
    }

    public File func_22324_a() {
        return this.field_22326_a;
    }

    public int func_22323_b() {
        return this.field_22325_b;
    }

    public int func_22321_c() {
        return this.field_22327_c;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_22322_a((ChunkFile)var1);
    }
}
