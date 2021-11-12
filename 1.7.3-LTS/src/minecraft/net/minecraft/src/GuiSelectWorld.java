package net.minecraft.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

public class GuiSelectWorld extends GuiScreen {
    private final DateFormat dateFormatter = new SimpleDateFormat();
    protected GuiScreen parentScreen;
    protected String screenTitle = "Select world";
    private boolean selected = false;
    private int selectedWorld;
    private List saveList;
    private GuiWorldSlot worldSlotContainer;
    private String localizedWorldText;
    private String localizedMustConvertText;
    private boolean deleting;
    private GuiButton buttonRename;
    private GuiButton buttonSelect;
    private GuiButton buttonDelete;

    public GuiSelectWorld(GuiScreen var1) {
        this.parentScreen = var1;
    }

    public void initGui() {
        StringTranslate var1 = StringTranslate.getInstance();
        this.screenTitle = var1.translateKey("selectWorld.title");
        this.localizedWorldText = var1.translateKey("selectWorld.world");
        this.localizedMustConvertText = var1.translateKey("selectWorld.conversion");
        this.loadSaves();
        this.worldSlotContainer = new GuiWorldSlot(this);
        this.worldSlotContainer.registerScrollButtons(this.controlList, 4, 5);
        this.initButtons();
    }

    private void loadSaves() {
        ISaveFormat var1 = this.mc.getSaveLoader();
        this.saveList = var1.getSaveList();
        Collections.sort(this.saveList);
        this.selectedWorld = -1;
    }

    protected String getSaveFileName(int var1) {
        return ((SaveFormatComparator)this.saveList.get(var1)).getFileName();
    }

    protected String getSaveName(int var1) {
        String var2 = ((SaveFormatComparator)this.saveList.get(var1)).getDisplayName();
        if (var2 == null || MathHelper.stringNullOrLengthZero(var2)) {
            StringTranslate var3 = StringTranslate.getInstance();
            var2 = var3.translateKey("selectWorld.world") + " " + (var1 + 1);
        }

        return var2;
    }

    public void initButtons() {
        StringTranslate var1 = StringTranslate.getInstance();
        this.controlList.add(this.buttonSelect = new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, var1.translateKey("selectWorld.select")));
        this.controlList.add(this.buttonRename = new GuiButton(6, this.width / 2 - 154, this.height - 28, 70, 20, var1.translateKey("selectWorld.rename")));
        this.controlList.add(this.buttonDelete = new GuiButton(2, this.width / 2 - 74, this.height - 28, 70, 20, var1.translateKey("selectWorld.delete")));
        this.controlList.add(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, var1.translateKey("selectWorld.create")));
        this.controlList.add(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, var1.translateKey("gui.cancel")));
        this.buttonSelect.enabled = false;
        this.buttonRename.enabled = false;
        this.buttonDelete.enabled = false;
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.enabled) {
            if (var1.id == 2) {
                String var2 = this.getSaveName(this.selectedWorld);
                if (var2 != null) {
                    this.deleting = true;
                    StringTranslate var3 = StringTranslate.getInstance();
                    String var4 = var3.translateKey("selectWorld.deleteQuestion");
                    String var5 = "'" + var2 + "' " + var3.translateKey("selectWorld.deleteWarning");
                    String var6 = var3.translateKey("selectWorld.deleteButton");
                    String var7 = var3.translateKey("gui.cancel");
                    GuiYesNo var8 = new GuiYesNo(this, var4, var5, var6, var7, this.selectedWorld);
                    this.mc.displayGuiScreen(var8);
                }
            } else if (var1.id == 1) {
                this.selectWorld(this.selectedWorld);
            } else if (var1.id == 3) {
                this.mc.displayGuiScreen(new GuiCreateWorld(this));
            } else if (var1.id == 6) {
                this.mc.displayGuiScreen(new GuiRenameWorld(this, this.getSaveFileName(this.selectedWorld)));
            } else if (var1.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            } else {
                this.worldSlotContainer.actionPerformed(var1);
            }

        }
    }

    public void selectWorld(int var1) {
        this.mc.displayGuiScreen((GuiScreen)null);
        if (!this.selected) {
            this.selected = true;
            this.mc.playerController = new PlayerControllerSP(this.mc);
            String var2 = this.getSaveFileName(var1);
            if (var2 == null) {
                var2 = "World" + var1;
            }

            this.mc.startWorld(var2, this.getSaveName(var1), 0L);
            this.mc.displayGuiScreen((GuiScreen)null);
        }
    }

    public void deleteWorld(boolean var1, int var2) {
        if (this.deleting) {
            this.deleting = false;
            if (var1) {
                ISaveFormat var3 = this.mc.getSaveLoader();
                var3.flushCache();
                var3.deleteWorldDirectory(this.getSaveFileName(var2));
                this.loadSaves();
            }

            this.mc.displayGuiScreen(this);
        }

    }

    public void drawScreen(int var1, int var2, float var3) {
        this.worldSlotContainer.drawScreen(var1, var2, var3);
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    // $FF: synthetic method
    static List getSize(GuiSelectWorld var0) {
        return var0.saveList;
    }

    // $FF: synthetic method
    static int onElementSelected(GuiSelectWorld var0, int var1) {
        return var0.selectedWorld = var1;
    }

    // $FF: synthetic method
    static int getSelectedWorld(GuiSelectWorld var0) {
        return var0.selectedWorld;
    }

    // $FF: synthetic method
    static GuiButton getSelectButton(GuiSelectWorld var0) {
        return var0.buttonSelect;
    }

    // $FF: synthetic method
    static GuiButton getRenameButton(GuiSelectWorld var0) {
        return var0.buttonRename;
    }

    // $FF: synthetic method
    static GuiButton getDeleteButton(GuiSelectWorld var0) {
        return var0.buttonDelete;
    }

    // $FF: synthetic method
    static String getlocalizedWorldText(GuiSelectWorld var0) {
        return var0.localizedWorldText;
    }

    // $FF: synthetic method
    static DateFormat getDateFormatter(GuiSelectWorld var0) {
        return var0.dateFormatter;
    }

    // $FF: synthetic method
    static String getLocalizedMustConvertText(GuiSelectWorld var0) {
        return var0.localizedMustConvertText;
    }
}
