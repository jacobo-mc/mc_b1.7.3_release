package net.minecraft.src;

public class WatchableObject {
    private final int objectType;
    private final int dataValueId;
    private Object watchedObject;
    private boolean isWatching;

    public WatchableObject(int var1, int var2, Object var3) {
        this.dataValueId = var2;
        this.watchedObject = var3;
        this.objectType = var1;
        this.isWatching = true;
    }

    public int getDataValueId() {
        return this.dataValueId;
    }

    public void setObject(Object var1) {
        this.watchedObject = var1;
    }

    public Object getObject() {
        return this.watchedObject;
    }

    public int getObjectType() {
        return this.objectType;
    }

    public void setWatching(boolean var1) {
        this.isWatching = var1;
    }
}
