package net.minecraft.src;

public class MapInfo {
    public final EntityPlayer entityplayerObj;
    public int[] field_28119_b;
    public int[] field_28124_c;
    private int field_28122_e;
    private int field_28121_f;
    // $FF: synthetic field
    final MapData mapDataObj;

    public MapInfo(MapData var1, EntityPlayer var2) {
        this.mapDataObj = var1;
        this.field_28119_b = new int[128];
        this.field_28124_c = new int[128];
        this.field_28122_e = 0;
        this.field_28121_f = 0;
        this.entityplayerObj = var2;

        for(int var3 = 0; var3 < this.field_28119_b.length; ++var3) {
            this.field_28119_b[var3] = 0;
            this.field_28124_c[var3] = 127;
        }

    }
}
