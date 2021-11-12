package net.minecraft.src;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ChunkFilePattern implements FilenameFilter {
    public static final Pattern dataFilenamePattern = Pattern.compile("c\\.(-?[0-9a-z]+)\\.(-?[0-9a-z]+)\\.dat");

    private ChunkFilePattern() {
    }

    public boolean accept(File var1, String var2) {
        Matcher var3 = dataFilenamePattern.matcher(var2);
        return var3.matches();
    }

    // $FF: synthetic method
    ChunkFilePattern(Empty2 var1) {
        this();
    }
}
