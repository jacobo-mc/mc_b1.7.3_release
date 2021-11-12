package net.minecraft.src;

public class SaveFormatComparator implements Comparable {
    private final String fileName;
    private final String displayName;
    private final long field_22169_c;
    private final long field_22168_d;
    private final boolean field_22167_e;

    public SaveFormatComparator(String var1, String var2, long var3, long var5, boolean var7) {
        this.fileName = var1;
        this.displayName = var2;
        this.field_22169_c = var3;
        this.field_22168_d = var5;
        this.field_22167_e = var7;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public long func_22159_c() {
        return this.field_22168_d;
    }

    public boolean func_22161_d() {
        return this.field_22167_e;
    }

    public long getLastTimePlayed() {
        return this.field_22169_c;
    }

    public int func_22160_a(SaveFormatComparator var1) {
        if (this.field_22169_c < var1.field_22169_c) {
            return 1;
        } else {
            return this.field_22169_c > var1.field_22169_c ? -1 : this.fileName.compareTo(var1.fileName);
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_22160_a((SaveFormatComparator)var1);
    }
}
