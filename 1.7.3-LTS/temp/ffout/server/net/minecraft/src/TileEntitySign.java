package net.minecraft.src;

public class TileEntitySign extends TileEntity {
    public String[] field_485_e = new String[]{"", "", "", ""};
    public int field_484_f = -1;
    private boolean field_25053_c = true;

    public void func_188_b(NBTTagCompound var1) {
        super.func_188_b(var1);
        var1.func_403_a("Text1", this.field_485_e[0]);
        var1.func_403_a("Text2", this.field_485_e[1]);
        var1.func_403_a("Text3", this.field_485_e[2]);
        var1.func_403_a("Text4", this.field_485_e[3]);
    }

    public void func_186_a(NBTTagCompound var1) {
        this.field_25053_c = false;
        super.func_186_a(var1);

        for(int var2 = 0; var2 < 4; ++var2) {
            this.field_485_e[var2] = var1.func_401_h("Text" + (var2 + 1));
            if (this.field_485_e[var2].length() > 15) {
                this.field_485_e[var2] = this.field_485_e[var2].substring(0, 15);
            }
        }

    }

    public Packet func_20070_f() {
        String[] var1 = new String[4];

        for(int var2 = 0; var2 < 4; ++var2) {
            var1[var2] = this.field_485_e[var2];
        }

        return new Packet130UpdateSign(this.field_478_b, this.field_483_c, this.field_482_d, var1);
    }

    public boolean func_25052_a() {
        return this.field_25053_c;
    }

    public void func_32001_a(boolean var1) {
        this.field_25053_c = var1;
    }
}
