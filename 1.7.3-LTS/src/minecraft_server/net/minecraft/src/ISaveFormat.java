package net.minecraft.src;

public interface ISaveFormat {
    boolean isOldSaveType(String var1);

    boolean converMapToMCRegion(String var1, IProgressUpdate var2);
}
