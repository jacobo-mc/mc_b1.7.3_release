package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NBTTagCompound extends NBTBase {
    private Map field_1094_a = new HashMap();

    void func_735_a(DataOutput var1) throws IOException {
        Iterator var2 = this.field_1094_a.values().iterator();

        while(var2.hasNext()) {
            NBTBase var3 = (NBTBase)var2.next();
            NBTBase.func_738_a(var3, var1);
        }

        var1.writeByte(0);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1094_a.clear();

        NBTBase var2;
        while((var2 = NBTBase.func_734_b(var1)).func_733_a() != 0) {
            this.field_1094_a.put(var2.func_737_b(), var2);
        }

    }

    public Collection func_28110_c() {
        return this.field_1094_a.values();
    }

    public byte func_733_a() {
        return 10;
    }

    public void func_762_a(String var1, NBTBase var2) {
        this.field_1094_a.put(var1, var2.func_732_a(var1));
    }

    public void func_761_a(String var1, byte var2) {
        this.field_1094_a.put(var1, (new NBTTagByte(var2)).func_732_a(var1));
    }

    public void func_749_a(String var1, short var2) {
        this.field_1094_a.put(var1, (new NBTTagShort(var2)).func_732_a(var1));
    }

    public void func_758_a(String var1, int var2) {
        this.field_1094_a.put(var1, (new NBTTagInt(var2)).func_732_a(var1));
    }

    public void func_750_a(String var1, long var2) {
        this.field_1094_a.put(var1, (new NBTTagLong(var2)).func_732_a(var1));
    }

    public void func_744_a(String var1, float var2) {
        this.field_1094_a.put(var1, (new NBTTagFloat(var2)).func_732_a(var1));
    }

    public void func_765_a(String var1, double var2) {
        this.field_1094_a.put(var1, (new NBTTagDouble(var2)).func_732_a(var1));
    }

    public void func_754_a(String var1, String var2) {
        this.field_1094_a.put(var1, (new NBTTagString(var2)).func_732_a(var1));
    }

    public void func_747_a(String var1, byte[] var2) {
        this.field_1094_a.put(var1, (new NBTTagByteArray(var2)).func_732_a(var1));
    }

    public void func_763_a(String var1, NBTTagCompound var2) {
        this.field_1094_a.put(var1, var2.func_732_a(var1));
    }

    public void func_748_a(String var1, boolean var2) {
        this.func_761_a(var1, (byte)(var2 ? 1 : 0));
    }

    public boolean func_751_b(String var1) {
        return this.field_1094_a.containsKey(var1);
    }

    public byte func_746_c(String var1) {
        return !this.field_1094_a.containsKey(var1) ? 0 : ((NBTTagByte)this.field_1094_a.get(var1)).field_1092_a;
    }

    public short func_745_d(String var1) {
        return !this.field_1094_a.containsKey(var1) ? 0 : ((NBTTagShort)this.field_1094_a.get(var1)).field_1088_a;
    }

    public int func_756_e(String var1) {
        return !this.field_1094_a.containsKey(var1) ? 0 : ((NBTTagInt)this.field_1094_a.get(var1)).field_1093_a;
    }

    public long func_764_f(String var1) {
        return !this.field_1094_a.containsKey(var1) ? 0L : ((NBTTagLong)this.field_1094_a.get(var1)).field_1095_a;
    }

    public float func_752_g(String var1) {
        return !this.field_1094_a.containsKey(var1) ? 0.0F : ((NBTTagFloat)this.field_1094_a.get(var1)).field_1097_a;
    }

    public double func_757_h(String var1) {
        return !this.field_1094_a.containsKey(var1) ? 0.0D : ((NBTTagDouble)this.field_1094_a.get(var1)).field_1089_a;
    }

    public String func_755_i(String var1) {
        return !this.field_1094_a.containsKey(var1) ? "" : ((NBTTagString)this.field_1094_a.get(var1)).field_1098_a;
    }

    public byte[] func_759_j(String var1) {
        return !this.field_1094_a.containsKey(var1) ? new byte[0] : ((NBTTagByteArray)this.field_1094_a.get(var1)).field_1096_a;
    }

    public NBTTagCompound func_743_k(String var1) {
        return !this.field_1094_a.containsKey(var1) ? new NBTTagCompound() : (NBTTagCompound)this.field_1094_a.get(var1);
    }

    public NBTTagList func_753_l(String var1) {
        return !this.field_1094_a.containsKey(var1) ? new NBTTagList() : (NBTTagList)this.field_1094_a.get(var1);
    }

    public boolean func_760_m(String var1) {
        return this.func_746_c(var1) != 0;
    }

    public String toString() {
        return "" + this.field_1094_a.size() + " entries";
    }
}
