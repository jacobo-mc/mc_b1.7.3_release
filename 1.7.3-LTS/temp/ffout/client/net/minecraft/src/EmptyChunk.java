package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EmptyChunk extends Chunk {
    public EmptyChunk(World var1, int var2, int var3) {
        super(var1, var2, var3);
        this.field_1525_p = true;
    }

    public EmptyChunk(World var1, byte[] var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        this.field_1525_p = true;
    }

    public boolean func_1017_a(int var1, int var2) {
        return var1 == this.field_1531_j && var2 == this.field_1530_k;
    }

    public int func_999_b(int var1, int var2) {
        return 0;
    }

    public void func_1014_a() {
    }

    public void func_1018_b() {
    }

    public void func_1024_c() {
    }

    public void func_4143_d() {
    }

    public int func_1008_a(int var1, int var2, int var3) {
        return 0;
    }

    public boolean func_1010_a(int var1, int var2, int var3, int var4, int var5) {
        return true;
    }

    public boolean func_1022_a(int var1, int var2, int var3, int var4) {
        return true;
    }

    public int func_1021_b(int var1, int var2, int var3) {
        return 0;
    }

    public void func_1009_b(int var1, int var2, int var3, int var4) {
    }

    public int func_1025_a(EnumSkyBlock var1, int var2, int var3, int var4) {
        return 0;
    }

    public void func_1011_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
    }

    public int func_1019_c(int var1, int var2, int var3, int var4) {
        return 0;
    }

    public void func_1000_a(Entity var1) {
    }

    public void func_1015_b(Entity var1) {
    }

    public void func_1016_a(Entity var1, int var2) {
    }

    public boolean func_1007_c(int var1, int var2, int var3) {
        return false;
    }

    public TileEntity func_1002_d(int var1, int var2, int var3) {
        return null;
    }

    public void func_1001_a(TileEntity var1) {
    }

    public void func_1005_a(int var1, int var2, int var3, TileEntity var4) {
    }

    public void func_1023_e(int var1, int var2, int var3) {
    }

    public void func_995_d() {
    }

    public void func_998_e() {
    }

    public void func_1006_f() {
    }

    public void func_994_a(Entity var1, AxisAlignedBB var2, List var3) {
    }

    public void func_1013_a(Class var1, AxisAlignedBB var2, List var3) {
    }

    public boolean func_1012_a(boolean var1) {
        return false;
    }

    public int func_1004_a(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var5 - var2;
        int var10 = var6 - var3;
        int var11 = var7 - var4;
        int var12 = var9 * var10 * var11;
        return var12 + var12 / 2 * 3;
    }

    public Random func_997_a(long var1) {
        return new Random(this.field_1537_d.func_22138_q() + (long)(this.field_1531_j * this.field_1531_j * 4987142) + (long)(this.field_1531_j * 5947611) + (long)(this.field_1530_k * this.field_1530_k) * 4392871L + (long)(this.field_1530_k * 389711) ^ var1);
    }

    public boolean func_21167_h() {
        return true;
    }
}
