package net.minecraft.src;

public class TileEntitySign extends TileEntity {
    public String[] field_826_a = new String[]{"", "", "", ""};
    public int field_825_b = -1;
    private boolean field_25062_c = true;

    public void func_481_b(NBTTagCompound var1) {
        super.func_481_b(var1);
        var1.func_754_a("Text1", this.field_826_a[0]);
        var1.func_754_a("Text2", this.field_826_a[1]);
        var1.func_754_a("Text3", this.field_826_a[2]);
        var1.func_754_a("Text4", this.field_826_a[3]);
    }

    public void func_482_a(NBTTagCompound var1) {
        this.field_25062_c = false;
        super.func_482_a(var1);

        for(int var2 = 0; var2 < 4; ++var2) {
            this.field_826_a[var2] = var1.func_755_i("Text" + (var2 + 1));
            if (this.field_826_a[var2].length() > 15) {
                this.field_826_a[var2] = this.field_826_a[var2].substring(0, 15);
            }
        }

    }
}
