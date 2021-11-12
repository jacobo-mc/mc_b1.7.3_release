package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NBTTagCompound extends NBTBase {
    private Map field_738_a = new HashMap();

    void func_381_a(DataOutput var1) throws IOException {
        Iterator var2 = this.field_738_a.values().iterator();

        while(var2.hasNext()) {
            NBTBase var3 = (NBTBase)var2.next();
            NBTBase.func_380_a(var3, var1);
        }

        var1.writeByte(0);
    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_738_a.clear();

        NBTBase var2;
        while((var2 = NBTBase.func_383_b(var1)).func_379_a() != 0) {
            this.field_738_a.put(var2.func_384_c(), var2);
        }

    }

    public Collection func_28107_c() {
        return this.field_738_a.values();
    }

    public byte func_379_a() {
        return 10;
    }

    public void func_399_a(String var1, NBTBase var2) {
        this.field_738_a.put(var1, var2.func_385_m(var1));
    }

    public void func_409_a(String var1, byte var2) {
        this.field_738_a.put(var1, (new NBTTagByte(var2)).func_385_m(var1));
    }

    public void func_394_a(String var1, short var2) {
        this.field_738_a.put(var1, (new NBTTagShort(var2)).func_385_m(var1));
    }

    public void func_405_a(String var1, int var2) {
        this.field_738_a.put(var1, (new NBTTagInt(var2)).func_385_m(var1));
    }

    public void func_396_a(String var1, long var2) {
        this.field_738_a.put(var1, (new NBTTagLong(var2)).func_385_m(var1));
    }

    public void func_390_a(String var1, float var2) {
        this.field_738_a.put(var1, (new NBTTagFloat(var2)).func_385_m(var1));
    }

    public void func_411_a(String var1, double var2) {
        this.field_738_a.put(var1, (new NBTTagDouble(var2)).func_385_m(var1));
    }

    public void func_403_a(String var1, String var2) {
        this.field_738_a.put(var1, (new NBTTagString(var2)).func_385_m(var1));
    }

    public void func_391_a(String var1, byte[] var2) {
        this.field_738_a.put(var1, (new NBTTagByteArray(var2)).func_385_m(var1));
    }

    public void func_392_a(String var1, NBTTagCompound var2) {
        this.field_738_a.put(var1, var2.func_385_m(var1));
    }

    public void func_393_a(String var1, boolean var2) {
        this.func_409_a(var1, (byte)(var2 ? 1 : 0));
    }

    public boolean func_410_a(String var1) {
        return this.field_738_a.containsKey(var1);
    }

    public byte func_408_b(String var1) {
        return !this.field_738_a.containsKey(var1) ? 0 : ((NBTTagByte)this.field_738_a.get(var1)).field_741_a;
    }

    public short func_406_c(String var1) {
        return !this.field_738_a.containsKey(var1) ? 0 : ((NBTTagShort)this.field_738_a.get(var1)).field_734_a;
    }

    public int func_395_d(String var1) {
        return !this.field_738_a.containsKey(var1) ? 0 : ((NBTTagInt)this.field_738_a.get(var1)).field_742_a;
    }

    public long func_404_e(String var1) {
        return !this.field_738_a.containsKey(var1) ? 0L : ((NBTTagLong)this.field_738_a.get(var1)).field_740_a;
    }

    public float func_389_f(String var1) {
        return !this.field_738_a.containsKey(var1) ? 0.0F : ((NBTTagFloat)this.field_738_a.get(var1)).field_739_a;
    }

    public double func_398_g(String var1) {
        return !this.field_738_a.containsKey(var1) ? 0.0D : ((NBTTagDouble)this.field_738_a.get(var1)).field_735_a;
    }

    public String func_401_h(String var1) {
        return !this.field_738_a.containsKey(var1) ? "" : ((NBTTagString)this.field_738_a.get(var1)).field_732_a;
    }

    public byte[] func_400_i(String var1) {
        return !this.field_738_a.containsKey(var1) ? new byte[0] : ((NBTTagByteArray)this.field_738_a.get(var1)).field_733_a;
    }

    public NBTTagCompound func_397_j(String var1) {
        return !this.field_738_a.containsKey(var1) ? new NBTTagCompound() : (NBTTagCompound)this.field_738_a.get(var1);
    }

    public NBTTagList func_407_k(String var1) {
        return !this.field_738_a.containsKey(var1) ? new NBTTagList() : (NBTTagList)this.field_738_a.get(var1);
    }

    public boolean func_402_l(String var1) {
        return this.func_408_b(var1) != 0;
    }

    public String toString() {
        return "" + this.field_738_a.size() + " entries";
    }
}
