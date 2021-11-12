package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NBTTagList extends NBTBase {
    private List field_737_a = new ArrayList();
    private byte field_736_b;

    void func_381_a(DataOutput var1) throws IOException {
        if (this.field_737_a.size() > 0) {
            this.field_736_b = ((NBTBase)this.field_737_a.get(0)).func_379_a();
        } else {
            this.field_736_b = 1;
        }

        var1.writeByte(this.field_736_b);
        var1.writeInt(this.field_737_a.size());

        for(int var2 = 0; var2 < this.field_737_a.size(); ++var2) {
            ((NBTBase)this.field_737_a.get(var2)).func_381_a(var1);
        }

    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_736_b = var1.readByte();
        int var2 = var1.readInt();
        this.field_737_a = new ArrayList();

        for(int var3 = 0; var3 < var2; ++var3) {
            NBTBase var4 = NBTBase.func_378_a(this.field_736_b);
            var4.func_382_a(var1);
            this.field_737_a.add(var4);
        }

    }

    public byte func_379_a() {
        return 9;
    }

    public String toString() {
        return "" + this.field_737_a.size() + " entries of type " + NBTBase.func_377_b(this.field_736_b);
    }

    public void func_386_a(NBTBase var1) {
        this.field_736_b = var1.func_379_a();
        this.field_737_a.add(var1);
    }

    public NBTBase func_388_a(int var1) {
        return (NBTBase)this.field_737_a.get(var1);
    }

    public int func_387_b() {
        return this.field_737_a.size();
    }
}
