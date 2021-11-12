package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class TileEntity {
    private static Map nameToClassMap = new HashMap();
    private static Map classToNameMap = new HashMap();
    public World worldObj;
    public int xCoord;
    public int yCoord;
    public int zCoord;
    protected boolean tileEntityInvalid;

    private static void addMapping(Class var0, String var1) {
        if (classToNameMap.containsKey(var1)) {
            throw new IllegalArgumentException("Duplicate id: " + var1);
        } else {
            nameToClassMap.put(var1, var0);
            classToNameMap.put(var0, var1);
        }
    }

    public void readFromNBT(NBTTagCompound var1) {
        this.xCoord = var1.getInteger("x");
        this.yCoord = var1.getInteger("y");
        this.zCoord = var1.getInteger("z");
    }

    public void writeToNBT(NBTTagCompound var1) {
        String var2 = (String)classToNameMap.get(this.getClass());
        if (var2 == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        } else {
            var1.setString("id", var2);
            var1.setInteger("x", this.xCoord);
            var1.setInteger("y", this.yCoord);
            var1.setInteger("z", this.zCoord);
        }
    }

    public void updateEntity() {
    }

    public static TileEntity createAndLoadEntity(NBTTagCompound var0) {
        TileEntity var1 = null;

        try {
            Class var2 = (Class)nameToClassMap.get(var0.getString("id"));
            if (var2 != null) {
                var1 = (TileEntity)var2.newInstance();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        if (var1 != null) {
            var1.readFromNBT(var0);
        } else {
            System.out.println("Skipping TileEntity with id " + var0.getString("id"));
        }

        return var1;
    }

    public int getBlockMetadata() {
        return this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
    }

    public void onInventoryChanged() {
        if (this.worldObj != null) {
            this.worldObj.updateTileEntityChunkAndDoNothing(this.xCoord, this.yCoord, this.zCoord, this);
        }

    }

    public Packet getDescriptionPacket() {
        return null;
    }

    public boolean isInvalid() {
        return this.tileEntityInvalid;
    }

    public void invalidate() {
        this.tileEntityInvalid = true;
    }

    public void validate() {
        this.tileEntityInvalid = false;
    }

    static {
        addMapping(TileEntityFurnace.class, "Furnace");
        addMapping(TileEntityChest.class, "Chest");
        addMapping(TileEntityRecordPlayer.class, "RecordPlayer");
        addMapping(TileEntityDispenser.class, "Trap");
        addMapping(TileEntitySign.class, "Sign");
        addMapping(TileEntityMobSpawner.class, "MobSpawner");
        addMapping(TileEntityNote.class, "Music");
        addMapping(TileEntityPiston.class, "Piston");
    }
}
