package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NBTTagList extends NBTBase {
    private List field_1091_a = new ArrayList();
    private byte field_1090_b;

    void func_735_a(DataOutput var1) throws IOException {
        if (this.field_1091_a.size() > 0) {
            this.field_1090_b = ((NBTBase)this.field_1091_a.get(0)).func_733_a();
        } else {
            this.field_1090_b = 1;
        }

        var1.writeByte(this.field_1090_b);
        var1.writeInt(this.field_1091_a.size());

        for(int var2 = 0; var2 < this.field_1091_a.size(); ++var2) {
            ((NBTBase)this.field_1091_a.get(var2)).func_735_a(var1);
        }

    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1090_b = var1.readByte();
        int var2 = var1.readInt();
        this.field_1091_a = new ArrayList();

        for(int var3 = 0; var3 < var2; ++var3) {
            NBTBase var4 = NBTBase.func_739_a(this.field_1090_b);
            var4.func_736_a(var1);
            this.field_1091_a.add(var4);
        }

    }

    public byte func_733_a() {
        return 9;
    }

    public String toString() {
        return "" + this.field_1091_a.size() + " entries of type " + NBTBase.func_731_b(this.field_1090_b);
    }

    public void func_742_a(NBTBase var1) {
        this.field_1090_b = var1.func_733_a();
        this.field_1091_a.add(var1);
    }

    public NBTBase func_741_a(int var1) {
        return (NBTBase)this.field_1091_a.get(var1);
    }

    public int func_740_c() {
        return this.field_1091_a.size();
    }
}
