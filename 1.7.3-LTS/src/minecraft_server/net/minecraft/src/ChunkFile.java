package net.minecraft.src;

import java.io.File;
import java.util.regex.Matcher;

class ChunkFile implements Comparable {
    private final File field_22209_a;
    private final int field_22208_b;
    private final int field_22210_c;

    public ChunkFile(File var1) {
        this.field_22209_a = var1;
        Matcher var2 = ChunkFilePattern.field_22119_a.matcher(var1.getName());
        if (var2.matches()) {
            this.field_22208_b = Integer.parseInt(var2.group(1), 36);
            this.field_22210_c = Integer.parseInt(var2.group(2), 36);
        } else {
            this.field_22208_b = 0;
            this.field_22210_c = 0;
        }

    }

    public int func_22206_a(ChunkFile var1) {
        int var2 = this.field_22208_b >> 5;
        int var3 = var1.field_22208_b >> 5;
        if (var2 == var3) {
            int var4 = this.field_22210_c >> 5;
            int var5 = var1.field_22210_c >> 5;
            return var4 - var5;
        } else {
            return var2 - var3;
        }
    }

    public File func_22207_a() {
        return this.field_22209_a;
    }

    public int func_22205_b() {
        return this.field_22208_b;
    }

    public int func_22204_c() {
        return this.field_22210_c;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_22206_a((ChunkFile)var1);
    }
}
