package net.minecraft.src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmptyChunk extends Chunk {
    public EmptyChunk(World var1, int var2, int var3) {
        super(var1, var2, var3);
        this.field_679_p = true;
    }

    public EmptyChunk(World var1, byte[] var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        this.field_679_p = true;
    }

    public boolean func_351_a(int var1, int var2) {
        return var1 == this.field_685_j && var2 == this.field_684_k;
    }

    public int func_337_b(int var1, int var2) {
        return 0;
    }

    public void func_348_a() {
    }

    public void func_353_b() {
    }

    public void func_4053_c() {
    }

    public int func_344_a(int var1, int var2, int var3) {
        return 0;
    }

    public boolean func_346_a(int var1, int var2, int var3, int var4, int var5) {
        return true;
    }

    public boolean func_357_a(int var1, int var2, int var3, int var4) {
        return true;
    }

    public int func_356_b(int var1, int var2, int var3) {
        return 0;
    }

    public void func_345_b(int var1, int var2, int var3, int var4) {
    }

    public int func_341_a(EnumSkyBlock var1, int var2, int var3, int var4) {
        return 0;
    }

    public void func_330_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
    }

    public int func_354_c(int var1, int var2, int var3, int var4) {
        return 0;
    }

    public void func_335_a(Entity var1) {
    }

    public void func_350_b(Entity var1) {
    }

    public void func_332_a(Entity var1, int var2) {
    }

    public boolean func_343_c(int var1, int var2, int var3) {
        return false;
    }

    public TileEntity func_338_d(int var1, int var2, int var3) {
        return null;
    }

    public void func_349_a(TileEntity var1) {
    }

    public void func_352_a(int var1, int var2, int var3, TileEntity var4) {
    }

    public void func_359_e(int var1, int var2, int var3) {
    }

    public void func_358_c() {
    }

    public void func_331_d() {
    }

    public void func_336_e() {
    }

    public void func_329_a(Entity var1, AxisAlignedBB var2, List var3) {
    }

    public void func_342_a(Class var1, AxisAlignedBB var2, List var3) {
    }

    public boolean func_347_a(boolean var1) {
        return false;
    }

    public int func_340_a(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var5 - var2;
        int var10 = var6 - var3;
        int var11 = var7 - var4;
        int var12 = var9 * var10 * var11;
        int var13 = var12 + var12 / 2 * 3;
        Arrays.fill(var1, var8, var8 + var13, (byte)0);
        return var13;
    }

    public Random func_334_a(long var1) {
        return new Random(this.field_691_d.func_22079_j() + (long)(this.field_685_j * this.field_685_j * 4987142) + (long)(this.field_685_j * 5947611) + (long)(this.field_684_k * this.field_684_k) * 4392871L + (long)(this.field_684_k * 389711) ^ var1);
    }

    public boolean func_21101_g() {
        return true;
    }
}
